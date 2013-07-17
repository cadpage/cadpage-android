package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class DispatchB3Parser extends DispatchB2Parser {
  
  private String prefix = null;
  private Pattern prefixPattern = null;

  public DispatchB3Parser(String prefix, String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    setupCallList((CodeSet)null);
    this.prefix = prefix;
  }

  public DispatchB3Parser(Pattern prefixPattern, String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    setupCallList((CodeSet)null);
    this.prefixPattern = prefixPattern;
  }

  public DispatchB3Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    setupCallList((CodeSet)null);
  }

  public DispatchB3Parser(String prefix, Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
    setupCallList((CodeSet)null);
    this.prefix = prefix;
  }

  public DispatchB3Parser(Pattern prefixPattern, Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
    setupCallList((CodeSet)null);
    this.prefixPattern = prefixPattern;
  }

  public DispatchB3Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
    setupCallList((CodeSet)null);
  }
  
  @Override
 protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    String tmp;
    if ((tmp = checkPrefix(body)) != null) {
      body = tmp;
    } else if ((tmp = checkPrefix(subject)) != null) {
      subject = tmp;
    } else {
      return false;
    }
    
    body = subject + " @ " + body;
    return super.parseMsg(body, data);
  }

  /**
   * Internal method to check body or subject against and
   * paser required prefix strings
   * @param body string to be checked for prefix
   * @return null if prefix check fails.  Otherwise return
   * original body with the matching prefix removed
   */
  private String checkPrefix(String body) {
    if (prefix != null) {
      if (!body.startsWith(prefix)) return null;
      return body.substring(prefix.length()).trim();
    } else if (prefixPattern != null) {
      Matcher match = prefixPattern.matcher(body);
      if (!match.find()) return null;
      return body.substring(match.end()).trim();
    }
    return body;
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    if (prefix != null || prefixPattern != null) return true;
    return super.isPageMsg(body);
  }
}
