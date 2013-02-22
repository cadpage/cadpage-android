package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;


public class NCSampsonCountyParser extends DispatchA3Parser {
  
  private static final Pattern MISSED_BLANK_PTN = Pattern.compile("\\*(?=[A-Z])");
  private static final Pattern CALL_CITY_PTN = Pattern.compile("^\\([^\\)]*?\\) +");
  
  public NCSampsonCountyParser() {
    super(0, "EMS:", "SAMPSON COUNTY", "NC");
    setupMultiWordStreets(
        "DR MARTIN L KING JR",
        "DR MARTIN LUTH KING JR",
        "DR MARTIN LUTHER KING JR",
        "DR MARTIN L KING",
        "DR MARTIN LUTH KING",
        "MARTIN LUTHER KING",
        "MARTIN L KING JR",
        "MARTIN LUTH KING JR",
        "MARTIN LUTHER KING JR",
        "MARTIN L KING",
        "MARTIN LUTH KING",
        "MARTIN LUTHER KING"
    );
  }
  
  @Override
  public String getFilter() {
    return "EMS@sampsonnc.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    body = MISSED_BLANK_PTN.matcher(body).replaceAll("* ");
    if (!super.parseMsg(body, data)) return false;
    Matcher match = CALL_CITY_PTN.matcher(data.strCall);
    if (match.find()) {
      if (data.strCity.length() == 0) data.strCity = match.group(1).trim();
      data.strCall = data.strCall.substring(match.end());
    }
    return true;
  }
}
