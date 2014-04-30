package net.anei.cadpage.parsers.NJ;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.HtmlParser;


/**
 * Mercer County, NJ
 */
public class NJMercerCountyBParser extends HtmlParser {
  
  public NJMercerCountyBParser() {
    super(CITY_LIST,
        "MERCER COUNTY", 
        "NJ",
        "ADDR CITY APT PLACE MAP UNIT CALL",
        LAYOUT);
  }
  
  @Override
  public String getProgram() {
    return append(getOptGroup(super.getProgram()), " ", "ADDR CITY APT PLACE MAP UNIT CALL");
  }
  
  @Override
  public String getFilter() {
    return "DoNotReplyCAD@mercercounty.org";
  }
  
  @Override protected boolean parseHtmlMsg(String subject, String msg, Data data) {
    if (!getHtmlCleaner(msg.replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">")))
      return false;
    /*
    parseLocation(getTableCellValueWith("Location:"), data);
    data.strCall = getOptGroup(getTableCellValueWith("Response Type:"));
    data.strMap = getOptGroup(getTableCellValueWith("Zone Name:"));
    data.strUnit = getUnitList(getTableCellValuesWith("Name:"), " ");
    return true;
    */
    parseAddress(StartType.START_ADDR, getValue("LOCATION"), data);
    data.strCall = getValue("CALL");
    data.strMap = getValue("MAP");
    data.strUnit = getValue("UNIT");
    return true;
  }
  
  private static final String[] LAYOUT = {
    "LOCATION(ELEMENT=TD;LABEL=/Location:/;REMOVE_LABEL)",
    "CALL(ELEMENT=TD;LABEL=/Response Type:/;REMOVE_LABEL)",
    "MAP(ELEMENT=TD;LABEL=/Zone Name:/;REMOVE_LABEL)",
    "UNIT(ELEMENT=TD;LABEL=/Name:/;REMOVE_LABEL;/;EXCLUDE=/Zone Name:/;SEPARATOR=/, /;MULTIPLE)"
  };
  
  private static final String[] CITY_LIST = {
    "WEST WINDSOR TWP",
    "EWING TWP"
  };
 }
