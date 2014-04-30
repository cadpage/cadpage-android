package net.anei.cadpage.parsers.KS;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.format.DateFormat;
import net.anei.cadpage.parsers.HtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Neosho County, KS
 */
public class KSNeoshoCountyParser extends HtmlParser {
//  private static String stem = "/home/brennus/html/KSNeoshoCountyParser-";
//  private static int ndx = 1;
  private static final String DEF_CITY = "NEOSHO COUNTY";
  private static final String DEF_STATE = "KS";
  
  public KSNeoshoCountyParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE,
           "ID ADDR CITY APT DATE TIME NAME PHONE PLACE INFO", LAYOUT);
  }
  
  @Override
  public String getProgram() {
    return "ID ADDR CITY APT DATE TIME NAME PHONE PLACE INFO";
  }
  
  @Override
  public String getFilter() {
    return "NEOSHOCO911@NEOSHOCOUNTY.KSCOXMAIL.COM";
  }
  
  private static final Pattern PERSON_PATTERN
    = Pattern.compile("(.*?)\\s*((?:\\(\\d{3}\\))?\\s*\\d{3}\\-\\d{4})(.*)");
  private static final SimpleDateFormat MY_DATE_FMT
    = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    if (!getHtmlCleaner(body.replace("\\t", "").replace("\n", " ").replace("&nbsp;", " ")))
      return false;
    
//    makeFile(stem+ndx+".html");
//    ndx++;
    
    data.strCallId = getValue("ID");
    String personString = getValue("PERSON");
    Matcher m = PERSON_PATTERN.matcher(personString);
    if (m.matches()) {
      data.strName = m.group(1);
      data.strPhone = m.group(2);
    }
    else
      data.strName = personString;
    parseAddress (StartType.START_ADDR, getValue("ADDRESS"), data);
    setDateTime(MY_DATE_FMT, getValue("DATETIME"), data);
    data.strPlace = getValue("BUSINESS");
    data.strSupp = getValue("NOTES");
    return true;
  }
  
  private static final String[] LAYOUT = {
    "ID(element=td;label=/Event No:/;offset=2)",
    "ADDRESS(element=td;label=/Address:/;offset=2)",
    "DATETIME(element=td;label=/Open:/;offset=2)",
    "PERSON(table=28;row=1;col=1)",
    "BUSINESS(table=32;row=1;col=1;remove=/Plate/)",
    "NOTES(xpath=///table/tbody/tr[2]/td[2]/;exclude=/**/;xbegin=19;remove=/Plate/)"
  };
  
  
  private static final String[] CITY_LIST = {
  };
}
