package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.HtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchSPKParser extends HtmlParser {
  private static final String FIELD_NAMES
    = "ID DATE TIME CODE CALL NAME PHONE GPS ADDR X APT CITY UNIT INFO";
  public DispatchSPKParser(String dc, String ds) {
    this(null, dc, ds);
  }

  public DispatchSPKParser(String[] cl, String dc, String ds) {
    super(cl, dc, ds,
           FIELD_NAMES,
           LAYOUT);
    translate(TRANS);
  }

  @Override
  public String getProgram() {
    return FIELD_NAMES;
  }
  
  private static final DateFormat MY_DATE_FMT = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!getHtmlCleaner(body))
      return false;
    
    data.strCallId = getValue("ID");
    setDateTime(MY_DATE_FMT, getValue("DATETIME"), data);
    String cc = getValue("CODE");
    if (cc.contains(" - ")) {
      int n = cc.indexOf(" - ");
      data.strCode = cc.substring(0, n);
      data.strCall = cc.substring(n+3);
    }
    else
      data.strCall = cc;
    data.strPhone = getValue("PHONE");
    data.strName = getValue("NAME");
    parseAddress(StartType.START_ADDR, getValue("LOCATION"), data);
    if (data.strCity.equals(""))
      data.strCity = getValue("COMMUNITY");
    data.strCross = append(data.strCross, " & ", getValue("CROSS_STREET"));
    data.strApt = append(data.strApt, " ", getValue("APARTMENT"));
    data.strSupp = getValue("NARRATIVE");
    data.strUnit = getValue("UNIT");
    data.strGPSLoc = getValue("GPS");

    return true;
    // return data.strCallId.length()>0 && cc.length()>0 && data.strAddress.length()>0;
  }
  
  private static final String[] LAYOUT = {
    "ID(table=0; element=td; label=/CAD Incident : /; remove_label)",
    "DATETIME(element=p; label=/As of /; remove_label)",
    "CODE(table=0; element=td; label=/Event Code: /; remove_label; required)",
    "LOCATION(table=0; element=td; label=/Location: /; remove_label; required)",
    "COMMUNITY(table=0; element=td; label=/Community: /; remove_label)",
    "CROSS_STREET(table=0; element=td; label=/Cross Street: /; offset=1-2; exclude=/Apartment: /; separator=/ & /)",
    "APARTMENT(table=0; element=td; label=/Apartment: /; remove_label)",
    "GPS(table=0; element=td; label=/L/L:/; remove_label)",
    "PHONE(xpath=///h1[normalize-space(.)=\"Caller information\"]/following-sibling::table[1]/tbody/tr/td[contains(., \"Caller Phone:\")]/; xJava; remove=/Caller Phone:/)",
    "NAME(xpath=///h1[normalize-space(.)=\"Caller information\"]/following-sibling::table[1]/tbody/tr/td[contains(., \"Caller Name:\")]/; xJava; remove=/Caller Name:/)",
    "NARRATIVE(xpath=///h1[normalize-space(.)=\"Remarks/Narratives:\"]/following-sibling::table[1]/tbody/tr/td[2]/; xJava)",
    "UNIT(xpath=///*[normalize-space(.)=\"Unit Information:\"]/following-sibling::table[1]/tbody/tr[position()>1]/td[1]/; xJava)"
  };
  
  private static final String[] TRANS = {
    "&amp;", "&"
  };
}
