package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYChautauquaCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER1 = Pattern.compile("^CHAUTAUQUA_COUNTY_SHERIFF \\(([A-Z ]+)\\) (\\d\\d:\\d\\d) \\*");
  private static final Pattern MARKER2 = Pattern.compile("^(\\d\\d:\\d\\d) \\*");
  private static final Pattern DELIM = Pattern.compile(" *(?<= ); ");
  private static final Pattern UNITS = Pattern.compile("(?: *\\b(?:[A-Z]{4}|[A-Z]\\d{2,3})\\b)+");
  
  public NYChautauquaCountyParser() {
    super("CHAUTAUQUA COUNTY", "NY",
           "CALL! ADDR/iS! CTV:CITY! NAME INFO UNIT");
  }
  
  @Override
  public String getFilter() {
    return "911@cattco.org,777, messaging@iamresponding.com,dispatch@sheriff.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      Matcher match = MARKER1.matcher(body);
      if (match.find()) {
        data.strSource = match.group(1);
        data.strTime = match.group(2);
        body = body.substring(match.end()).trim();
        break;
      }
      
      match = MARKER2.matcher(body);
      if (match.find() && subject.length() > 0) {
        data.strSource = subject;
        data.strTime = match.group(1);
        body = body.substring(match.end()).trim();
        break;
      }
      
      return false;
    } while (false);
    
    body = body.replace(" C/T/V ", " CTV: ");
    if (body.endsWith(";")) body = body.substring(0,body.length()-1);
    return parseFields(DELIM.split(body),data);
  }
  
  @Override
  public String getProgram() {
    return "SRC TIME " + super.getProgram();
  }
  
  // City field must remove trailing _T
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("_T")) field = field.substring(0,field.length()-2).trim();
      super.parse(field, data);
    }
  }
  
  // Name field needs to remove trailing commas
  private class MyUnitField extends UnitField {

    @Override
    public void parse(String field, Data data) {
      Matcher match = UNITS.matcher(field);
      String info;
      if (match.find()) {
        data.strUnit = match.group();
        info = append(field.substring(0,match.start()).trim(), " / ", field.substring(match.end()).trim());;
      } else {
        info = field;
      }
      data.strSupp = append(data.strSupp, " / ", info);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
}
	