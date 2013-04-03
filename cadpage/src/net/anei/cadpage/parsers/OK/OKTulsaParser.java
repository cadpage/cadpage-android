package net.anei.cadpage.parsers.OK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.general.GeneralParser;


public class OKTulsaParser extends GeneralParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:PAGE-OUT / )?\\d\\d:\\d\\d[AP]M [A-Z][A-Za-z]{2} ");
  private static final Pattern DATE_PTN = Pattern.compile("^\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)? ");
  private static final Pattern DELIM_PTN = Pattern.compile("\\.\\.+|//+");
  
  public OKTulsaParser() {
    super("TULSA", "OK");
    setFieldList("CALL ADDR X PHONE NAME ID INFO PLACE");
  }
  
  @Override
  public String getFilter() {
    return "pagealert@cityoftulsa.org";
  }

  @Override
  protected boolean isPageMsg(String subject, String body) {
    return true;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // See if message has the right start signature
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    
    // if what is left starts with a date, strip that off
    match = DATE_PTN.matcher(body);
    if (match.find()) body = body.substring(match.end()).trim();
    
    // There are some constructs we know are delimiters that the general parser doesn't
    body = DELIM_PTN.matcher(body).replaceAll(";");
    
    // That's all we can do, time for the general parser to do what it can
    if (super.parseMsg(subject, body, data)) return true;
    
    // If it fails, it can only be because it couldn't find an address
    // We know this is a CAD page so we don't want to fail, so we'll just
    // do our own general alert
    return data.parseGeneralAlert(body);
  }

}
