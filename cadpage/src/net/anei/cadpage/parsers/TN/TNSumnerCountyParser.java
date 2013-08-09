package net.anei.cadpage.parsers.TN;

/**
 * Sumner County, TN
 */
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;


public class TNSumnerCountyParser extends DispatchA3Parser {
  
  public TNSumnerCountyParser() {
    super("", "SUMNER COUNTY", "TN",
           "EMPTY ADDR APT UNK CITY PLACE CALL! INFO+");
  }
  
//  @Override
//  protected boolean parseMsg(String body, Data data) {
//    if (!body.startsWith("* ")) return false;
//    body = body.substring(2).trim();
//    if (body.endsWith("*")) body = body + " ";
//    return parseFields(body.split("\\* "), 6, data);
//  }
}