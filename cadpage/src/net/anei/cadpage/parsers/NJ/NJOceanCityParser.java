package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA44Parser;

public class NJOceanCityParser extends DispatchA44Parser {

  public NJOceanCityParser() {
    super("OCEAN CITY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "ocpd@ocnj.us";
   }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    data.strAddress = data.strAddress.replaceAll("  +", " ");
    data.strUnit = UNIT_TEST_PTN.matcher(data.strUnit).replaceAll(" ").trim();
    data.strUnit = PatternReplace.replaceArray(data.strUnit, UNIT_FIX_PTNS);
    return true;
  }
  
  private static final Pattern UNIT_TEST_PTN = Pattern.compile(" *\\b(?:TEST|TESTING)\\b *");
  
  private static final PatternReplace[] UNIT_FIX_PTNS = PatternReplace.buildArray(
      "STA \\d+",
      "[A-Z] PTL",
      "EMS DUTY CREW",
      "EMS RECALL",
      "FD RECALL"
  );
}
