package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.HtmlParser;

public class NYOswegoCountyBParser extends HtmlParser {
  
  public NYOswegoCountyBParser() {
    super(CITY_CODES,
        "OSWEGO COUNTY",
        "NY",
        "SRC CODE CALL DATE TIME UNIT NAME ADDR CITY APT X ID INFO",
        LAYOUT);
  }
  
  @Override
  public String getFilter() {
    return "911@OSWEGOCOUNTY.COM";
  }
  
  @Override
  public String getProgram() {
    return append(super.getProgram(),
        " ",
        "SRC CODE CALL DATE TIME UNIT NAME ADDR CITY APT X ID INFO");
  }
  
  private static final DateFormat MY_DATE_FMT
    = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
  /*
  private static final Pattern NOTE_PATTERN
    = Pattern.compile(".*?\\[.+?\\](.*)");
    */
  private static final String stem = "/home/brennus/NYOswegoCountyB-";
  private static int ndx = 1;
  @Override
  public boolean parseHtmlMsg(String subject, String body, Data data) {
    if (!getHtmlCleaner(body))
      return false;
    
    makeFile(stem+ndx+".html");
    ndx++;
    /*
    data.strSource = getTableCellValueWith("Location:");
    String codeCall = getTableCellValueWith("Response Type:");
    if (codeCall.contains("-")) {
      String[] codeAndCall = codeCall.split("-");
      data.strCode = codeAndCall[0].trim();
      data.strCall = codeAndCall[1].trim();
    }
    else
      data.strCode = codeCall;
    String dateTime = getTableCellValueWith("Creation Time:");
    setDateTime(MY_DATE_FMT, dateTime, data);
    data.strUnit = getTableCellValueWith("Handling Unit:");
    data.strName = getTableCellValueWith("Phone Owner Name:");
    parseAddress(StartType.START_ADDR, getTableCellValueWith("Address:"), data);
    data.strCallId = getTableCellValueWith("Case Number:");
    Set<String> infoSet = getTableCellValuesWith("Note:");
    for (Iterator<String> i=infoSet.iterator(); i.hasNext(); ) {
      String n = i.next();
      Matcher m = NOTE_PATTERN.matcher(n);
      if (m.matches())
        data.strSupp = append(data.strSupp, " ", m.group(1));
      else
        data.strSupp = append(data.strSupp, " ", n);
    }
    */
    
    data.strSource = getValue("LOCATION");
    String codeCall = getValue("CODECALL");
    if (codeCall.contains("-")) {
      String [] codeAndCall = codeCall.split("-");
      data.strCode = codeAndCall[0].trim();
      data.strCall = codeAndCall[1].trim();
    }
    else
      data.strCode = codeCall;
    setDateTime(MY_DATE_FMT, getValue("DATETIME"), data);
    data.strUnit = getValue("UNIT");
    data.strName = getValue("NAME");
    parseAddress(StartType.START_ADDR, getValue("ADDRESS"), data);
    data.strCallId = getValue("ID");
    data.strSupp = getValue("INFO");

    return codeCall.length() > 0 && data.strDate.length() > 0 && data.strTime.length() > 0 && data.strCallId.length() > 0;
  }
  
  private static final String[] LAYOUT = {
    "LOCATION(ELEMENT=TD;LABEL=/Location:/;REMOVE_LABEL)",
    "CODECALL(ELEMENT=TD;LABEL=/Response Type:/;REMOVE_LABEL)",
    "DATETIME(ELEMENT=TD;LABEL=/Creation Time:/;REMOVE_LABEL)",
    "UNIT(ELEMENT=TD;LABEL=/Handling Unit:/;REMOVE_LABEL)",
    "NAME(ELEMENT=TD;LABEL=/Phone Owner Name:/;REMOVE_LABEL)",
    "ADDRESS(ELEMENT=TD;LABEL=/Address:/;REMOVE_LABEL)",
    "ID(ELEMENT=TD;LABEL=/Case Number:/;REMOVE_LABEL)",
    "INFO(ELEMENT=TD;LABEL=/Note:/;REMOVE_LABEL;MULTIPLE)"
  };
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CLE", "CLEVELAND",
      "CON", "CONSTANTIA",
      "HAS", "HASTINGS",
      "PAR", "PARISH",
      "SCH", "SCHROEPPEL",
      "WMN", "WEST MONROE",
      "WMR", "WEST MONROE"
  });
}
	