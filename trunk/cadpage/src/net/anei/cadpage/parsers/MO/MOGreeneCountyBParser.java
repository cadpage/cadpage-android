package net.anei.cadpage.parsers.MO;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MOGreeneCountyBParser extends FieldProgramParser {

  public MOGreeneCountyBParser() {
    super("GREENE COUNTY", "MO", "LOC:ADDR! AD:PLACE! DESC:PLACE! APT:APT? CRSTR:X! TYP:CODE CMT:INFO! INC:ID TIME:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "grn_alret@springfieldmo.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_KEEP_STATE_HIGHWAY;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("LOC")) {
      int pt = body.indexOf(":");
      body = subject + body.substring(pt);
    }
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) {
      String call = CALL_CODES.getProperty(data.strCode);
      if (call != null) {
        data.strCall = call;
      } else {
        data.strCall = data.strCode;
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CODE", "CODE CALL");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private class MyCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "*M*");
      field = stripFieldEnd(field, "-");
      super.parse(field, data);
    }
  }

  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      if (field.startsWith("/")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }

  @Override
  public String adjustMapAddress(String sAddress) {
    sAddress = FARM_ROAD.matcher(sAddress).replaceAll("$1 FARM ROAD $2");
    sAddress = STATE_HWY.matcher(sAddress).replaceAll("$1 STATE HIGHWAY $2");
    sAddress = STATE_HWY_HWY.matcher(sAddress).replaceAll("$1");
    return sAddress;
  }

  private static Pattern FARM_ROAD = Pattern.compile("\\b([NESW]) FR(\\d+)\\b");
  private static Pattern STATE_HWY = Pattern.compile("\\b([NESW]) SH(([A-Z])(?:\\3)?)\\b");
  private static Pattern STATE_HWY_HWY = Pattern.compile("\\b([NESW] STATE HIGHWAY [^ ]+) HWY\\b");
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "FALARM",   "FIRE ALARM",
      "FAMBA",    "AMBULANCE ASSIST",
      "FAUTO",    "AUTOMOBILE  FIRE",
      "FBLDG",    "BUILDING FIRE",
      "FBOMB",    "EXPLOSIVE DEVICE",
      "FBOMBT",   "BOMB THREAT",
      "FELEV",    "ELEVATOR EMERGENCY",
      "FEMS",     "MEDICAL EMERGENCY",
      "FGBLDG",   "GAS ODOR IN A STRUCTURE",
      "FGOTS",    "GAS ODOR OUTSIDE",
      "FHOUSE",   "HOUSE FIRE",
      "FHZMAT",   "HAZARDOUS MATERIALS",
      "FMCI",     "MASS CASUALTY INCIDENT",
      "FMVA",     "MOTOR VEHICLE ACCIDENT",
      "FOTS",     "FIRE OUTSIDE",
      "FOUT",     "FIRE EXTINGUISHED",
      "FPLANE",   "AIRCRAFT EMERGENCY",
      "FPTRAP",   "PERSONS TRAPPED",
      "FSMOKA",   "SMOKE INVESTIGATION",
      "FSPILL",   "FUEL SPILL",
      "FSVC",     "SERVICE CALL",
      "FTRAIN",   "TRAIN FIRE",
      "FTRUCK",   "TRUCK FIRE",
      "FWATER",   "WATER RESCUE",
      "FWIRE",    "WIRE DOWN",


  });

}
