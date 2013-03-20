package net.anei.cadpage.parsers.IN;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Madison County (Alexandria), IN
 */
public class INMadisonCountyBParser extends FieldProgramParser {
  
  public INMadisonCountyBParser() {
    super("MADISON COUNTY", "IN",
          "Call_Type:CALL! Address:ADDRCITY! Units:UNIT! Nature:INFO Info:INFO Narr:INFO Call_#:ID Call_Date/Time:DATETIME Priority:PRI Common_Name:PLACE Intersection:X City:CITY Beat:MAP2 Quadrant:MAP1 District:SKIP Source:SKIP",
          FLDPROG_ANY_ORDER | FLDPROG_IGNORE_CASE);
  }
  
  @Override
  public String getFilter() {
    return "cfs@madisoncountypaging.com";
  }
  
  @Override
  public String adjustMapAddress(String address) {
    return CORD_PTN.matcher(address).replaceAll("");
  }
  private static final Pattern CORD_PTN = Pattern.compile("\\bCORD\\b");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CFS")) return false;
    body = body.replace("Call Type:", " Call Type:");
    body = body.replace('\n', ' ').trim();
    return super.parseMsg(body, data);
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" RD# ");
      if (pt >= 0) {
        data.strMap = field.substring(pt+5).trim();
        field = field.substring(0,pt).trim();
      }
      field = field.replace('@', '&');
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " MAP";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals(data.strSupp)) return;
      super.parse(field, data);
    }
  }
  
  private class MyMap1Field extends MyMapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(field, "-", data.strMap);
    }
  }
  
  private class MyMap2Field extends MyMapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public String getFieldNames() {
      return "MAP";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("MM:dd:yyyy hh:mm:ss aa"));
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("MAP1")) return new MyMap1Field();
    if (name.equals("MAP2")) return new MyMap2Field();
    return super.getField(name);
  }
}
