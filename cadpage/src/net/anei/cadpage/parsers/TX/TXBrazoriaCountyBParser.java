
package net.anei.cadpage.parsers.TX;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.HtmlParser;


public class TXBrazoriaCountyBParser extends HtmlParser {

  public TXBrazoriaCountyBParser() {
    super(CITY_LIST,
            "BRAZORIA COUNTY",
            "TX",
            "CALL ID ADDR APT CITY DATE TIME NAME PHONE INFO",
            LAYOUT);
    setupMultiWordStreets("STEPHEN F AUSTIN");
  }
  
  @Override
  public String getProgram() {
    return "CALL ID ADDR APT CITY DATE TIME NAME PHONE INFO";
  }
  
  @Override
  public String getFilter() {
    return "FREEPORTDISPATCH@FREEPORT.TX.US";
  }
  
  private static final Pattern ALPHA_APT_PTN = Pattern.compile("([A-Z])\\b *(.*)");
  private static final DateFormat MY_DATE_FMT
    = new SimpleDateFormat("mm/dd/yyyy hh:MM:ss");
  private static final Pattern PHONE_PATTERN
    = Pattern.compile("(.*?)((?:\\(\\d{3}\\) ?)?\\d{3}\\-\\d{4}.*)");
  // Once again, this works better than parseHtmlMsg()
  @Override
  protected boolean parseMsg(String msg, Data data) {
    if (!getHtmlCleaner(msg))
      return false;
    
    /*
    data.strCallId = clean(getOptGroup(getTableCellValueAfter("Event No", 2)));
    data.strCall = clean(getOptGroup(getTableCellValueAfter("Category:", 2)));
    parseAddress(StartType.START_ADDR,
                 getOptGroup(getTableCellValueAfter("Address:", 2)).trim(),
                 data);
    String dtField = clean(getOptGroup(getTableCellValueAfter("Open:", 2)));
    setDateTime(MY_DATE_FMT, dtField, data);
    String nameField = clean(getOptGroup(getTableCellValueAfter("Name Address Phone", 25)));
    Matcher m = PHONE_PATTERN.matcher(nameField);
    if (m.matches()) {
      data.strName = m.group(1).trim();
      data.strPhone = m.group(2).trim();
    }
    else
      data.strName = nameField;
    
    data.strSupp = clean(getOptGroup(getTableCellValueAfter("Incident Notes", 34)));
    
    */
    data.strCallId = clean(getValue("CALLID"));
    data.strCall = clean(getValue("CALL"));
    parseAddress(StartType.START_ADDR, getValue("ADDRESS"), data);
    setDateTime(MY_DATE_FMT, getValue("DATETIME"), data);
    Matcher m = PHONE_PATTERN.matcher(clean(getValue("NAME")));
    if (m.matches()) {
      data.strName = m.group(1).trim();
      data.strPhone = m.group(2).trim();
    }
    else
      data.strName = clean(getValue("NAME"));
      
    // Freeport names some streets AVE [A-Z] where the street
    // name is being misinterpreted as an apt :(
    if (data.strAddress.endsWith(" AVE")) {
      Matcher match = ALPHA_APT_PTN.matcher(data.strApt);
      if (match.matches()) {
        data.strAddress = data.strAddress +  ' ' + match.group(1);
        data.strApt = match.group(2);
      }
    }
    
    return true;
  }
  
  private static final String[] LAYOUT = {
    "CALLID(ELEMENT=TD;LABEL=/Event No/;OFFSET=2)",
    "CALL(ELEMENT=TD;LABEL=/Category:/;OFFSET=2)",
    "ADDRESS(ELEMENT=TD;LABEL=/Address:/;OFFSET=2)",
    "DATETIME(ELEMENT=TD;LABEL=/Open:/;OFFSET=2)",
    "NAME(ELEMENT=TD;LABEL=/Name Address Phone/;OFFSET=25)",
    "INFO(ELEMENT=TD;LABEL=/Incident Notes/;OFFSET=34)"
  };
  
  private static final String[] CITY_LIST = {
        // Cities    
        "ALVIN",
        "ANGLETON",
        "BRAZORIA",
        "BROOKSIDE VILLAGE",
        "CLUTE",
        "DANBURY",
        "FREEPORT",
        "LAKE JACKSON",
        "LIVERPOOL",
        "MANVEL",
        "OYSTER CREEK",
        "PEARLAND",
        "RICHWOOD",
        "SANDY POINT",
        "SURFSIDE BEACH",
        "SWEENY",
        "WEST COLUMBIA",
    
        // Towns
        "HOLIDAY LAKES",
        "QUINTANA",
    
        // Villages
        "BAILEYS PRAIRIE",
        "BONNEY",
        "HILLCREST",
        "IOWA COLONY",
        "JONES CREEK",
    
        // CDPs
        "DAMON",
        "WILD PEACH VILLAGE",
        
        // Other areas
        "AMSTERDAM",
        "ANCHOR",
        "CHENANGO",
        "CHINA GROVE",
        "CHOCOLATE BAYOU",
        "DANCIGER",
        "EAST COLUMBIA",
        "ENGLISH",
        "OLD OCEAN",
        "OTEY",
        "ROSHARON",
        "SNIPE",
        "SILVERLAKE",
        "TURTLE COVE",
        "MCBETH"

  };
}
