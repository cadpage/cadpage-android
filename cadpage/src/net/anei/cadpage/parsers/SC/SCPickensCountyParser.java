package net.anei.cadpage.parsers.SC;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.HtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class SCPickensCountyParser extends HtmlParser {
//  private final String stem = "/home/brennus/html/SCPickensCountyParser-";
//  private int ndx = 1;
  
  public SCPickensCountyParser() {
    super("PICKENS COUNTY", "SC",
           "ID DATE TIME CODE CALL ADDR APT CITY UNIT INFO",
           LAYOUT);
  }

  @Override
  public String getProgram() {
    return "ID DATE TIME CODE CALL ADDR APT CITY UNIT INFO";
  }
  
  @Override
  public String getFilter() {
    return "pickenscountye911@gmail.com";
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
      data.strCode = cc;
    parseAddress(StartType.START_ADDR, getValue("LOCATION"), data);
    data.strCity = getValue("COMMUNITY");
    data.strSupp = getValue("NARRATIVE");
    data.strUnit = getValue("UNIT");

//    makeFile(stem+ndx+".html");
//    ndx++;
    return true;
  }
  
  private static final String[] LAYOUT = {
    "ID(table=0;element=td;label=/CAD Incident : /;remove_label)",
    "DATETIME(element=p;remove=/As of /)",
    "CODE(table=0;element=td;label=/Event Code: /;remove_label)",
    "LOCATION(table=0;element=td;label=/Location: /;remove_label)",
    "COMMUNITY(table=0;element=td;label=/Community: /;remove_label)",
    "NARRATIVE(table=2;row=*;col=1)",
    "UNIT(table=3;label=/Unit/;row=*;separator=/, /"
  };
}
