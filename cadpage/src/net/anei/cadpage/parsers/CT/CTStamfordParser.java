package net.anei.cadpage.parsers.CT;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Stamford, CT
 */
public class CTStamfordParser extends DispatchA3Parser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("^(?:911Fire:)?\\* +");
  public CTStamfordParser() {
    super(0, PREFIX_PTN, "STAMFORD", "CT");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data, boolean splitField) {
    if (!super.parseMsg(body, data, splitField)) return false;
    if (data.strPhone.equals("203- -")) data.strPhone = "";
    return true;
  }

  @Override
  public String getFilter() {
    return "911fire@ci.Stamford.ct.us";
  }
}
