package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/******************************************************************************
Queen Anne's County, MD

Contact: Contact: David baker <baker.davidm@gmail.com> ?
qac911:*D 4-2 COMMERCIAL BLDG FIRE DUNKIN DONUTS @500 CHURCH HILL RD COMMERCIAL BOX Q04
qac911:*D 4-5 MVC W/ENTRAPMENT RT301NB / RT304 RESCUE BOX Q04
qac911:*D 5-1 LG BRUSH/GRASS FIRE RT405 / WINDSWEPT FARM LN BRUSH BOX Q05
qac911:*D 4-5 UNCONSCIOUS/FAINTING RT301NB / ROLLING BRIDGE RD UNCONSCIOUS Q04
qac911:*D 5-2 MVC W/ROLLOVER RT301NB / HAYDEN RD RESCUE BOX Q05
qac911:*D 4-7 MVC W/ROLLOVER 1627 RUTHSBURG RD RESCUE BOX Q04
(text message) qac911:*D 4-2 CO ALARM 212 NORTHFIELD WAY LOCAL BOX Q04

Contact: david baker <baker.davidm@gmail.com>
sender:QA911com@qac.org <From%3AQA911com@qac.org>
(Text Message) QA911com:*D 4-1 UNKNOWN PROBLEM 206 ORCHESTRA PL LIFE STATUS ? Q04

Contact: Joshua Ruby <josh@computerrescuemd.com>
sender: QA911com@qac.org
(Text Message) QA911com:*D 1-14 FALLS 1401 CALVERT RD POSS DANG BODY AREA Q01

Contact: jahurlock@cvfd7.com <jahurlock@cvfd7.com>
Sender: QA911com@qac.org 
(Text Message) QA911com:*G KM06 MUTUAL AID MEDICAL 300 WASHINGTON AVE MUTUAL AID ONLY KM06

Kent Island VFD
Contact: Joshua Ruby <josh@computerrescuemd.com>
[Text Message]  QA911com:*D 1-15 CHEST PAINS 1630 MAIN ST BREATHING NORMAL>35 Q01
[Text Message]  QA911com:*D 1-9 SICK PERSON 402 CASTLE MARINA RD NOT ALERT Q01 
[Text Message]  QA911com:*D 1-3 HEART PROBLEMS 115 SALLITT DR ABNORMAL BREATHING Q01
[Text Message]  QA911com:*D 1-10 SEIZURES 1918 ANCHORAGE DR CONTINUOUS/MULTIPLE Q01
[Text Message]  QA911com:*D 1-9 ODOR OF SMOKE INSIDE 44 F QUEEN NEVA CT COMMERCIAL BOX Q01
[Text Message]  QA911com:*D 1-15 HEART PROBLEMS 1630 MAIN ST CARDIAC HISTORY Q01
[Text Message]  QA911com:*D 1-4 DROWNING/DIVE ACCDNT 624 ROMANCOKE RD WATER RESCUE BOX Q01

******************************************************************************/

public class MDQueenAnnesCountyParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "MD";
  private static final String DEF_CITY = "QUEEN ANNES COUNTY";
  
  private static final Pattern MARKER = Pattern.compile("^(qac911|QA911com):\\*[DG] ");
  
  public MDQueenAnnesCountyParser() {
    super(DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "qac911@qac.org,QA911com@qac.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    Matcher match = MARKER.matcher(body);
    if (! match.find()) return false;
    body = body.substring(match.end());
    
    // OK, go do your magic!!
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, body, data);
    data.strSupp = getLeft();
    return true;
  }
}
