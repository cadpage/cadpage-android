package net.anei.cadpage.parsers.general;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

public class GeneralAlertParser extends SmsMsgParser {
  
  private static final Pattern[] EXTRA_BLANKS = new Pattern[]{
    Pattern.compile(" +(\n)"),
    Pattern.compile("(   ) +")
  };
  
  public GeneralAlertParser() {
    super("", "");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    // Everything goes in the place name.  Odd choice, but it comes out 
    // looking right without a prefix keyword.  if we put the entire text
    // in the call field it won't wrap more than two lines.
    data.strCall = "GENERAL ALERT";
    for (Pattern ptn : EXTRA_BLANKS) {
      body = ptn.matcher(body).replaceAll("$1");
    }
    if (subject.length() > 0) {
      body = "(" + subject + ") " + body;
    }
    data.strPlace = body;
    return true;
  }
}
