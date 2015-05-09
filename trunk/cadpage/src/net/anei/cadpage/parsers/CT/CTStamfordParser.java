package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Stamford, CT
 */
public class CTStamfordParser extends DispatchA3Parser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("(?:(?:911Fire:|STAMFORD 911:)?\\*|STAMFORD 911:Stamford|911Fire:Stamford)\\n");
  public CTStamfordParser() {
    super(0, "", "STAMFORD", "CT");
  }

  @Override
  public String getFilter() {
    return "911fire@ci.Stamford.ct.us,911Fire@ci.stamford.ct.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.equals("From Stamford 911") || subject.equals("From- Stamford 911")) break;
      
      Matcher match = PREFIX_PTN.matcher(body);
      if (match.lookingAt()) {
        body = body.substring(match.end()).trim();
        break;
      }
      
      return false;
    } while (false);

    return super.parseMsg(body, data);
  }
  
}
