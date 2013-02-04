package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Ulster County, NY
 */
public class NYUlsterCountyParser extends FieldProgramParser {

  public NYUlsterCountyParser() {
    super("ULSTER COUNTY", "NY",
           "Unit:UNIT! UnitSts:SKIP Loc:ADDR/SXa! XSts:X! Common:PLACE Venue:CITY Inc:CALL! Date:DATE Time:TIME Addtl:INFO Nature:INFO CNTX:INFO", FLDPROG_ANY_ORDER);
  }
  
  @Override
  public String getFilter() {
    return "cad@co.ulster.ny.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    body = body.replace('\n', ' ');
    if (!super.parseMsg(body, data)) return false;

    data.strCity = data.strCity.replaceAll(" +", " ");
    if (data.strCity.toUpperCase().startsWith("KING CITY")) { data.strCity="KINGSTON";}
    return true;
  }
  
  private static final Pattern TIME_PTN = Pattern.compile("^\\d\\d:\\d\\d\\b");
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = TIME_PTN.matcher(field);
      if (!match.find()) return;
      data.strTime = match.group();
      data.strSupp = field.substring(match.end()).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "TIME INFO";
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.matches()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
      } else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE")) return new DateField("\\d\\d/\\d\\d/\\d{4}", true);
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}




