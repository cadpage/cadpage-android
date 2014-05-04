package net.anei.cadpage.parsers.IN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INShelbyCountyParser extends HtmlParser {
//  private static final String stem = "/home/brennus/html/INShelbyCounty-";
//  private static int ndx = 1;
  public INShelbyCountyParser() {
    super(CITY_LIST, "SHELBY COUNTY", "IN",
            "DATE TIME CODE CALL ADDR APT CITY MAP INFO",
            LAYOUT);
    setupMultiWordStreets("SHELBY STATE");
  }

  private static final Pattern SHELBY_STATE_RD_PATTERN
    = Pattern.compile("(?i)(.*?)SHELBY +STATE +RD +44(.*)");
  @Override
  public String adjustMapAddress (String addr) {
    Matcher m = SHELBY_STATE_RD_PATTERN.matcher(addr);
    if (m.matches())
      return m.group(1)+"STATE 44"+m.group(2);
    return addr;
  }
  
  @Override
  public String getProgram() {
    return "DATE TIME CODE CALL ADDR APT CITY UNIT INFO";    
  }
  
  public String getFilter() {
    return "ShelbyCoCAD@in.gov";
  }

  private static final DateFormat MY_DATE_FMT = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!getHtmlCleaner(body))
      return false;
  
    
//    makeFile(stem+ndx+".html");
//    ndx++;
    
    setDateTime(MY_DATE_FMT, getValue("DATETIME"), data);
    String cc = getValue("CODE");
    if (cc.contains(" - ")) {
      int n = cc.indexOf(" - ");
      data.strCode = cc.substring(0, n);
      data.strCall = cc.substring(n+3);
    }
    else
      data.strCode = cc;
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, getValue("LOCATION"), data);
//    System.out.println("LEFTOVER: \""+getLeft()+"\"");
    data.strCity = getValue("COMMUNITY");
    data.strSupp = getValue("NARRATIVE");
    data.strUnit = getValue("UNIT");
    return data.strDate.length()>0 && data.strTime.length()>0 && cc.length()>0 && data.strAddress.length()>0;
  }

  private static final String[] LAYOUT = {
    "DATETIME(element=p;remove=/As of /)",
    "CODE(table=0;element=td;label=/Event Code: /;remove_label)",
    "LOCATION(table=0;element=td;label=/Location: /;remove_label)",
    "COMMUNITY(table=0;element=td;label=/Community: /;remove_label)",
    "NARRATIVE(table=2;row=*;col=1)",
    "UNIT(table=3;label=/Unit/;row=*;separator=/, /"
  };
  
  private static final String[] CITY_LIST = {
//    Cities and towns
    "EDINBURGH",
    "FAIRLAND",
    "MORRISTOWN",
    "ST. PAUL",
    "SHELBYVILLE",

// Unincorporated towns
    "BLUE RIDGE",
    "BROOKFIELD",
    "BOGGSTOWN",
    "FLAT ROCK",
    "FOUNTAINTOWN",
    "GENEVA",
    "GWYNNEVILLE",
    "LONDON",
    "MARIETTA",
    "MEIKS",
    "MOUNT AUBURN",
    "SUGAR CREEK",
    "WALDRON",

// Townships
    "ADDISON",
    "BRANDYWINE",
    "HANOVER",
    "HENDRICKS",
    "JACKSON",
    "LIBERTY",
    "MARION",
    "MORAL",
    "NOBLE",
    "SHELBY",
    "SUGAR CREEK",
    "UNION",
    "VAN BUREN",
    "WASHINGTON",

// Adjacent counties
    "SHELBY COUNTY",
    "HANCOCK COUNTY",
    "RUSH COUNTY",
    "DECATUR COUNTY",
    "BARTHOLOMEW COUNTY",
    "JOHNSON COUNTY",
    "MARION COUNTY"
  };
}
