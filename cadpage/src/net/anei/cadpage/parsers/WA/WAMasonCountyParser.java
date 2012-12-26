package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class WAMasonCountyParser extends FieldProgramParser {
  
  private static final Pattern KEYWORD_BREAK_PTN = Pattern.compile(" (?=ACTIVE CALL#|REPORTED:|Type:|Zone:|Phone:)");
  private static final Pattern HASH_DELIM_PTN = Pattern.compile("(?<=LONG TERM CAD|ACTIVE CALL)#");
  
  public WAMasonCountyParser() {
    super("MASON COUNTY", "WA",
           "LONG_TERM_CAD:ID! ACTIVE_CALL:SKIP! PRIORITY:PRI! REPORTED:TIMEDATE! Nature:CALL Type:SKIP! Address:ADDR! Zone:MAP! City:CITY! Responding_Units:UNIT! Directions:INFO! Comments:INFO! INFO+ Contact:APT! Phone:PHONE!");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = KEYWORD_BREAK_PTN.matcher(body).replaceAll("\n");
    body = HASH_DELIM_PTN.matcher(body).replaceAll(":");
    return parseFields(body.split("\n+"), 14, data);
  }
  
  private static final Pattern ADDR_APT_PTN = Pattern.compile("(?:APT|RM|SUITE) *(.*)", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String apt = null;
      int pt = field.lastIndexOf(';');
      if (pt >= 0) {
        apt = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
      if (apt != null) {
        Matcher match = ADDR_APT_PTN.matcher(apt);
        if (match.matches()) apt = match.group(1);
        data.strApt = append(data.strApt, "-", apt);
      }
    }
  }
  
  
  private static final Pattern INFO_SKIP_PTN = Pattern.compile("\\d\\d:\\d\\d:\\d\\d \\d\\d/\\d\\d/\\d{4} -.*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (INFO_SKIP_PTN.matcher(field).matches()) return;
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
  
  private static final Pattern APT_PTN = Pattern.compile("CONTACT APARTMENT *(.*)", Pattern.CASE_INSENSITIVE);
  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (field.equalsIgnoreCase("YES")) return;
      if (field.equalsIgnoreCase("CONTACT")) return;
      Matcher match = APT_PTN.matcher(field);
      if (match.matches()) field = match.group(1);
      super.parse(field, data);
    }
  }
  
  private class MyPhoneField extends PhoneField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("(   )   -")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{2}-\\d{6}");
    if (name.equals("TIMEDATE")) return new TimeDateField("\\d\\d:\\d\\d:\\d\\d \\d\\d?/\\d\\d?/\\d\\d");
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("PHONE")) return new MyPhoneField();
    return super.getField(name);
  }
}
