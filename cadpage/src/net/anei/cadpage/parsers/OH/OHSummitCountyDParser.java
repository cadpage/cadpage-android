package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Summit County, OH
 */
public class OHSummitCountyDParser extends DispatchA5Parser {
  
  private static final Pattern UNIT_STRIP_PTN = Pattern.compile("^OH\\d+ +");
  private static final Pattern CALL_CODE_PTN = Pattern.compile("([^ ]+) ([EF] .*)");
  
  public OHSummitCountyDParser() {
    super(CITY_CODES, "SUMMIT COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "MAKRINOSL@STOW.OH.US";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    Matcher match = CALL_CODE_PTN.matcher(data.strCall);
    if (match.find()) {
      data.strCode = match.group(1);
      data.strCall = match.group(2);
    }
    match = UNIT_STRIP_PTN.matcher(data.strUnit);
    if (match.find()) data.strUnit = data.strUnit.substring(match.end());
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CALL", "CODE CALL");
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BrimTwpPC",    "Brimfield Twp",
  });
  
}