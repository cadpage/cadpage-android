package net.anei.cadpage.parsers.TN;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class TNWilliamsonCountyBParser extends SmartAddressParser {

  public TNWilliamsonCountyBParser() {
    super("WILLIAMSON COUNTY", "TN");
    setFieldList("CODE CALL ADDR APT CITY PHONE X NAME");
    setupCallList(CALL_LIST);
  }

  private static Pattern CODE_CALL = Pattern.compile("([A-Z]{2,3}) {4,}(.*?)"); // that is how you do 'or more' right?
  private static Pattern PHONE = Pattern.compile("(.*?) *(\\d{10}|615) *(.*)");
  private static Pattern TO = Pattern.compile("(.*? *TO) *(.*)");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    // verify + remove leading '911-CENTER:'
    if (!body.startsWith("911-CENTER:")) return false;
    body = body.substring(11);

    // future parseAddress parameters
    StartType type = StartType.START_CALL;
    int flag = FLAG_START_FLD_REQ;

    // if subject exists parse CODE + Call from it, fail if unsuccessful
    if (subject.length() > 0) {
      Matcher ccMat = CODE_CALL.matcher(subject);
      if (!ccMat.matches()) return false;
      data.strCode = ccMat.group(1);
      data.strCall = ccMat.group(2);
      type = StartType.START_ADDR;
      flag = 0;
    }
    
    else {
      Parser p = new Parser(body);
      data.strCode = p.get(' ');
      body = p.get();
    }

    // parse 10 digit phone from middle of string
    String left = null;
    Matcher pMat = PHONE.matcher(body);
    if (pMat.matches()) {
      body = pMat.group(1);
      String g2 = pMat.group(2);
      if (g2.length() == 10) data.strPhone = g2;
      left = pMat.group(3);
      flag |= FLAG_ANCHOR_END;
    } else {
      flag |= FLAG_CROSS_FOLLOWS;
    }

    // parse address with determined parameters
    parseAddress(type, flag, body, data);

    // temporarily remove leading ".* TO " from string containing X + NAME
    String prefix = "";
    if (left == null) left = getLeft();
    Matcher tMat = TO.matcher(left);
    if (tMat.matches()) {
      prefix = tMat.group(1);
      left = tMat.group(2);
    }

    // X NAME
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, left);
    if (res.isValid()) {
      res.getData(data);
      data.strName = cleanWirelessCarrier(res.getLeft());
      data.strCross = append(prefix, " ", data.strCross);
    } 
    else data.strName = append(prefix, " ", cleanWirelessCarrier(left));

    return true;
  }

  private static String[] CALL_LIST = new String[] { 
    "DEATH INVESTIGATION", 
    "OTHER FIRE", 
    "PERSONAL INJURY ACCIDENT", 
    "SEARCH FOR MISSING PERSON",
    "STRUCTURE FIRE", 
    "TEST STRUCTURE FIRE", 
    "WEEKLY PAGER TEST" };

}
