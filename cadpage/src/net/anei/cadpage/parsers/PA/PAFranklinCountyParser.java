package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Franklin County, PA
 */
public class PAFranklinCountyParser extends FieldProgramParser {
  
  public PAFranklinCountyParser() {
    this("FRANKLIN COUNTY", "PA");
  }
  
  protected PAFranklinCountyParser(String defCity, String defState) {
    super(defCity, defState,
          "ADDR APT APT CITY EMPTY EMPTY EMPTY EMPTY CALL EMPTY EMPTY EMPTY UNIT! INFO+");
  }

  @Override
  public String getAliasCode() {
    return "PAFranklinCounty";
  }

  @Override
  public String getFilter() {
    return "PageGate@franklindes.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("*")) return false;
    if (body.endsWith("*")) body = body + ' ';
    if (!parseFields(body.split("\\* "), data)) return false;
    if (data.strCity.endsWith(" BORO")) data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    if (data.strCity.equals("LEAD")) data.strCity = "CHAMBERSBURG";
    if (data.strCity.endsWith(" MD")) {
      data.strState = "MD";
      data.strCity = data.strCity.substring(0,data.strCity.length()-3).trim();
    }
    if (data.strCity.endsWith(" CO")) {
      data.strCity += "UNTY";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
  
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|ROOT|RM|#) *(.*)", Pattern.CASE_INSENSITIVE);
  private class MyAptField extends AptField {
    @Override
    public void  parse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) field = match.group(1);
      super.parse(field, data);
    }
  }
}
