package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class TXDallasCountyCParser extends DispatchOSSIParser {
  
  public TXDallasCountyCParser() {
    super(CITY_CODES, "DALLAS COUNTY", "TX",
          "( CANCEL ADDR CITY " +
          "| FYI ADDR CITY? CODE CITY? SRC? INFO+? MARK X2+? P ONE SRC2 CALL BOX ID INFO+ )");
  }
  
  @Override
  public String getFilter() {
    return "CAD@ntecc.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  private static final Pattern TRAIL_MARK_PTN = Pattern.compile("(.*\\])(.*;P;1.*)");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.startsWith("FYI:") || subject.startsWith("Update:")) {
      body = subject + ';' + body;
    }
    if (!body.startsWith("CAD:")) body = "CAD:" + body;
    
    body = body.replace("\n", "");
    Matcher match = TRAIL_MARK_PTN.matcher(body);
    if (match.matches()) body = match.group(1)+"<<%MARK%>>;" + match.group(2);
    
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) {
      data.strCall = data.strCode;
      data.strCode = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CODE", "CODE CALL?");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new CodeField("[A-Z]{2,6}", true);
    if (name.equals("SRC")) return new SourceField("[A-Z]{3,4}", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("MARK")) return new SkipField("<<%MARK%>>");
    if (name.equals("X2")) return new MyCross2Field();
    if (name.equals("P")) return new SkipField("P", true);
    if (name.equals("ONE")) return new SkipField("1", true);
    if (name.equals("SRC2")) return new MySource2Field();
    if (name.equals("BOX")) return new BoxField("\\d+", true);
    if (name.equals("ID")) return new IdField("\\d{10}", true);
    return super.getField(name);
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Radio Channel:")) {
        data.strChannel = field.substring(14).trim();
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CH? INFO";
    }
  }

  private static final Pattern CROSS_TAC_PTN = Pattern.compile("TAC *\\S*");
  private static final Pattern CROSS_UNIT_PTN = Pattern.compile("[A-Z]+\\d+|.*,.*");
  private class MyCross2Field extends Field {
    @Override
    public void parse(String field, Data data) {
      if (CROSS_TAC_PTN.matcher(field).matches()) {
        data.strChannel = field;
        return;
      }
      
      if (CROSS_UNIT_PTN.matcher(field).matches()) {
        data.strUnit = append(data.strUnit, ",", field);
        return;
      }
      data.strCross = append(data.strCross, "/", field);
    }

    @Override
    public String getFieldNames() {
      return "X CH UNIT";
    }
  }
  
  private class MySource2Field extends SourceField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals(data.strSource)) return;
      data.strSource = append(data.strSource, " ", field);
    }
  }
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equals("DFW AIRPORT")) city = "DALLAS/FORT WORTH AIRPORT";
    return super.adjustMapCity(city);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ADDI", "ADDISON",
      "CARR", "CARROLLTON",
      "COPP", "COPPELL",
      "DALL", "DALLAS",
      "DECO", "DENTON COUNTY",
      "DFW",  "DFW AIRPORT",
      "FARM", "FARMERS BRANCH",
      "FLOW", "FLOWER MOUND",
      "FRIS", "FRISCO",
      "GRAP", "GRAPEVINE",
      "HEBR", "HEBRON",
      "IRVI", "IRVING",
      "LEWI", "LEWISVILLE",
      "PLAN", "PLANO",
      "PRI",  "PRINCETON",
      "THEC", "THE COLONY"
  });

}
