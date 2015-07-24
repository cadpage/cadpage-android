package net.anei.cadpage.parsers.MI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class MICalhounCountyCParser extends HtmlProgramParser {
  
  public MICalhounCountyCParser() {
    super(MICalhounCountyParser.CITY_CODES, "CALHOUN COUNTY", "MI", 
          "COMM! DISPATCH! Incident#:ID! Report#:EMPTY! Date:DATE! Time_Out:TIME! Nature:CALL! MP:CODE! Business:PLACE! Address:ADDR! City:CITY Addt_Address:ADD_ADDR! Cross:X! X+ Subdivision:EMPTY! RA:EMPTY! Neighborhood:EMPTY! Notes:INFO+ Hot_Spot:EMPTY! Premise:EMPTY! Units:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "CCCDA-DONOTREPLY@CALHOUNCOUNTYMI.GOV";
  }

  private static final Pattern SUBJECT_PTN = Pattern.compile("(Dispatch|Clear) Report Incident #(\\d+)");
  private static final Pattern MISSING_LINE_BRK_PTN = Pattern.compile("[ \t](?=Report#:|Time Out:|MP:|City:|RA:)");
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    if (match.group(1).equals("Clear")) {
      setFieldList("ID");
      data.msgType = MsgType.RUN_REPORT;
      data.strCallId = match.group(2);
      return true;
    }
    
    body = MISSING_LINE_BRK_PTN.matcher(body).replaceAll("\n");
    if (body.startsWith("<html>")) return super.parseHtmlMsg(subject, body, data);
    return parseFields(body.split("\n+"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("COMM")) return new SkipField("Communications", true);
    if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
    if (name.equals("ADD_ADDR")) return new MyAddAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyAddAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      data.strAddress = append(data.strAddress, " ", '('+field+')');
    }
  }
  
  private static final Pattern INFO_DATE_TIME_PTN = Pattern.compile(" *\\[\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)? \\d\\d:\\d\\d:\\d\\d [A-Z0-9]+\\]$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = INFO_DATE_TIME_PTN.matcher(field).replaceFirst("");
      data.strSupp = append(data.strSupp, "\n", field);
    }
  }
}
