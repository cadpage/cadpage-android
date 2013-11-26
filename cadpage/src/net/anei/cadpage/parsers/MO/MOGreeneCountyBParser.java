package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MOGreeneCountyBParser extends FieldProgramParser {

  public MOGreeneCountyBParser() {
    super("GREENE COUNTY", "MO", "LOC:ADDR! AD:PLACE! DESC:CALL! APT:APT? CRSTR:X! TYP:CODE CMT:INFO! TIME:SKIP!");
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
  protected boolean parseMsg(String body, Data data) {
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
    Matcher frMat = FARM_ROAD.matcher(sAddress);
    if (frMat.matches()) {
      sAddress = frMat.group(1) + " FARM ROAD " + frMat.group(2);
    } else { 
      Matcher shMat = STATE_HWY.matcher(sAddress);
      if (shMat.matches()) {
        sAddress = shMat.group(1) + " MISSOURI PP";
      }
    }

    return sAddress;
  }

  private static Pattern FARM_ROAD = Pattern.compile("(\\d+ [NESW]) FR(\\d+)");
  private static Pattern STATE_HWY = Pattern.compile("(\\d+ [NESW]) SHPP");

}
