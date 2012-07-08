package net.anei.cadpage.parsers.CT;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Middlesex County, CT
Contact: Active911
Agency name: Durham Vol Fire Department Location: Durham, CT 
Contact: LogiSYS@smtp109.sbc.mail.gq1.yahoo.com,CAD@smtp109.sbc.mail.gq1.yahoo.com

(DURHAM FIRE CALL CAD Page for CFS 061312-31) \nhttp://maps.google.com/maps?q=+41.48618%20-72.65719\nFire Alarm\n18 WEATHERVANE HILL\nApt: \nDH       \nCross Streets : MAIDEN LANE \nCaller: ADT OP YSG\nDisp Time: 06/13/12 11:36:52
(DURHAM FIRE CALL CAD Page for CFS 061312-47) \nhttp://maps.google.com/maps?q=+41.44852%20-72.70119\nFire Alarm\n471 NEW HAVEN RD\nApt: \nDH       \nCross Streets : SAW MILL RD * CANTERBURY DR \nCaller: \nDisp Time: 06/13/12 18:03:43
(DURHAM FIRE CALL CAD Page for CFS 061412-5) \nhttp://maps.google.com/maps?q=+41.48025%20-72.66325\nUnconcious/Unresponsive ALS\nMAIDEN LANE and BEAR ROCK RD\nApt: \nDH       \nCross Streets : SYCAMORE DR * MAIDEN LANE \nCaller: ATTMO\nDisp Time: 06/14/12 04:22:21
(CAD Page for CFS 061512-51) \nhttp://maps.google.com/maps?q=+41.43734%20-72.71928\nFire Alarm\n809 NEW HAVEN RD\nApt: -R\nDH       \nCross Streets : COE RD * FORLINE RD \nCaller: \nWater\Info: SEND EMS NON-EMERGENCY ON FIRE ALARMS AT THIS LOCATION\n\nDisp Time: 06/15/12 15:35:55
(CAD Page for CFS 062012-32) \nhttp://maps.google.com/maps?q=+41.48282%20-72.68172\nMinor MVA -No Medic\n310 MAIN ST\nApt: \nDH       \nCross Streets : MAIDEN LANE * TALCOTT LANE \nCaller: VERIZON WIRELESS\nDisp Time: 06/20/12 12:24:24
(CAD Page for CFS 062112-63) \nhttp://maps.google.com/maps?q=+41.47446%20-72.68228\nMVA Medic ALS\n68 MAPLE AVE\nApt: \nDH       \nCross Streets : JOHNS WAY * OLD CEMETERY RD \nCaller: SPRINTPCS\nDisp Time: 06/21/12 17:22:22
(CAD Page for CFS 062212-43) \nhttp://maps.google.com/maps?q=+41.47400%20-72.68024\nMinor MVA -No Medic\n154 MAIN ST\nApt: \nDH       \nCross Streets : FOWLER AVE * OLD CEMETERY RD \nCaller: \nDisp Time: 06/22/12 15:48:27
(CAD Page for CFS 062312-10) \nhttp://maps.google.com/maps?q=+41.47818%20-72.68108\nMinor MVA -No Medic\nMAIN ST and WALLINGFORD RD\nApt: \nDH       \nCross Streets : WALLINGFORD RD * MAIDEN LANE \nCaller: \nDisp Time: 06/23/12 07:42:19
(CAD Page for CFS 062312-66) \nhttp://maps.google.com/maps?q=+41.47828%20-72.67083\nWires Down -Call NU\n135 PICKETT LANE\nApt: \nDH\nCross Streets : MAIN ST * MAIDEN LANE \nCaller: ATTMO\nDisp Time: 06/23/12 21:06:27
(CAD Page for CFS 062412-49) \nhttp://maps.google.com/maps?q=+41.47896%20-72.68120\nMinor MVA -No Medic\n238 MAIN ST\nApt: \nDH       \nCross Streets : WALLINGFORD RD * MAIDEN LANE \nCaller: ATTMO\nDisp Time: 06/24/12 14:21:09
(CAD Page for CFS 062512-13) \nhttp://maps.google.com/maps?q=+41.33698%20-72.58493\nStructure Fire\n24 COW PEN HILL RD\nApt: \nKW\nCross Streets : GREEN HILL RD * COOKS LANE \nCaller: BROWN,ROBERT F\nDisp Time: 06/25/12 08:30:13
(CAD Page for CFS 062512-65) \nhttp://maps.google.com/maps?q=+41.48772%20-72.64230\nFire Alarm\n255 JOHNSON LANE\nApt: \nDH       \nCross Streets : MAIDEN LANE * HADDAM QUARTER RD \nCaller: adt\nDisp Time: 06/25/12 16:21:16
(CAD Page for CFS 062512-87) \nhttp://maps.google.com/maps?q=+41.49094%20-72.65092\nElectrical Fire Pole/Wire\nHADDAM QUARTER RD and ARBUTUS ST\nApt: \nDH       \nCross Streets : WINTERBERRY LANE * HADDAM QUARTER RD \nCaller: VERIZON WIRELESS\nDisp Time: 06/25/12 20:31:21
(CAD Page for CFS 062612-1) \nhttp://maps.google.com/maps?q=+41.46590%20-72.67495\nBrush Fire\nHIGGANUM RD and CHERRY LANE\nApt: \nDH       \nCross Streets : MADISON RD * CHERRY LANE \nCaller: \nDisp Time: 06/26/12 00:16:19
(CAD Page for CFS 063012-41) \nhttp://maps.google.com/maps?q=+41.46674%20-72.65959\nElectrical Fire Pole/Wire\n291 HIGGANUM RD\nApt: \nDH       \nCross Streets : TRINITY HILL DR * BEAR ROCK RD \nCaller: VERIZON WIRELESS\nDisp Time: 06/30/12 11:30:15
(CAD Page for CFS 070512-9) \nhttp://maps.google.com/maps?q=+41.49594%20-72.64658\nFire Alarm\n23 CHEYENNE TR\nApt: \nDH       \nCross Streets : ARBUTUS ST \nCaller: early detection\nDisp Time: 07/05/12 07:03:07
(CAD Page for CFS 070712-30) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nPublic Service\nU:OLD JOHNSON LANE AND MILBROOK\nApt: \nMD\nCaller: MD\nDisp Time: 07/07/12 13:36:50
(CAD Page for CFS 070712-87) \nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000\nStructure Fire\nU:U:ROUTE 149 AND ROUTE 16\nApt: \n\nCaller: \nDisp Time: 07/08/12 01:23:01

*/

public class CTMiddlesexCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile(".*CAD Page for CFS (\\d{6,}-\\d+)");
  
  public CTMiddlesexCountyParser() {
    super(CITY_CODES, "MIDDLESEX COUNTY", "CT",
          "HTTP! CALL! ADDR! Apt:APT! CITY! Cross_Streets:X? Caller:NAME! Disp_Time:DATETIME!");
  }

  @Override
  public String getFilter() {
    return "LogiSYS@smtp109.sbc.mail.gq1.yahoo.com,CAD@smtp109.sbc.mail.gq1.yahoo.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    return parseFields(body.split("\n"), 7, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      while (field.startsWith("U:")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" * ", " & ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("HTTP")) return new SkipField("http://maps.google.com.*", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "DH", "DURHAM",
      "KW", "KILLINGWORTH",
      "MD", "MIDDLETOWN"
  });
}
