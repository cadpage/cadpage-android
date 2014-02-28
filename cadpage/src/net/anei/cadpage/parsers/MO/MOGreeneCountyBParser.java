package net.anei.cadpage.parsers.MO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MOGreeneCountyBParser extends FieldProgramParser {

  public MOGreeneCountyBParser() {
    super("GREENE COUNTY", "MO", "LOC:ADDR! AD:PLACE! DESC:CALL! APT:APT? CRSTR:X! TYP:CODE CMT:INFO! INC:ID TIME:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "grn_alret@springfieldmo.gov";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("LOC")) {
      int pt = body.indexOf(":");
      body = subject + body.substring(pt);
    }
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) {
      data.strCall = data.strCode;
      data.strCode = "";
    }
    return true;
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
    sAddress = STATE_HWY.matcher(sAddress).replaceAll("$1 STATE_HIGHWAY $2");
    return sAddress;
  }

  private static Pattern FARM_ROAD = Pattern.compile("\\b([NESW]) FR(\\d+)\\b");
  private static Pattern STATE_HWY = Pattern.compile("\\b([NESW]) SH(([A-Z])(?:\\3)?)\\b");
  
  @Override
  public String postAdjustMapAddress(String sAddress) {
    return sAddress.replaceAll("STATE_HIGHWAY", "STATE HIGHWAY");
  }

}
