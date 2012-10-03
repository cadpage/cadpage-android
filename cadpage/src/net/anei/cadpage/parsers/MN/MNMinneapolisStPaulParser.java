package net.anei.cadpage.parsers.MN;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;


/**
 * Bloomington, MN
 */
public class MNMinneapolisStPaulParser extends DispatchPrintrakParser {
  
  private static final Pattern ID_PTN = Pattern.compile("^[A-Z]{3}\\d{12} ");
  
  public MNMinneapolisStPaulParser() {
    super("MINNEAPOLIS", "MN");
  }
  
  @Override
  public String getLocName() {
    return "Minneapolis/St Paul, MN";
  }

  @Override
  public String getFilter() {
    return "logis-emergin-paging@logis.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (ID_PTN.matcher(body).find()) {
      body = "INC: " + body;
    } else if (!body.startsWith("TYPE: ")) {
      body = "TYP: " + body;
    }
    return super.parseMsg(body, data);
  }
}
