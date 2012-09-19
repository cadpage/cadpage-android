package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser.Field;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;
/**
 * Wicomico County, MD
 */
public class MDWicomicoCountyParser extends DispatchOSSIParser {
  
  private static final Pattern ID_MARK = Pattern.compile("^\\d+:");
  
  public MDWicomicoCountyParser() {
    super(CITY_CODES, "WICOMICO COUNTY", "MD",
           "ID CALL ADDR CITY! X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@wicomicocounty.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Strip off leading sequence number
    Matcher match = ID_MARK.matcher(body);
    if (match.find()) body = body.substring(match.end()).trim();
    
    if (!body.startsWith("CAD:")) body = "CAD:" + body;
    
    if (!super.parseMsg(body, data)) return false;
    
    // Delmar calls can be on either side of the state line
    if (data.strCity.equals("DELMAR")) data.defState = "";
    return true;
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{10}", true);
    return super.getField(name);
  }



  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALLE", "ALLEN",
      "EDEN", "EDEN",
      "BIVA", "BIVALVE",
      "DELM", "DELMAR",
      "FRUI", "FRUITLAND",
      "HEBR", "HEBRON",
      "MARD", "MARDELA",
      "NANT", "NANTICOKE",
      "PARS", "PARSONBURG",
      "PITT", "PITTSVILLE",
      "POWE", "POWELLVILLE",
      "QUAN", "QUANTICO",
      "SALI", "SALISBURY",
      "SHAR", "SHARPTOWN",
      "TYAS", "TYASKIN",
      "WILL", "WILLARDS"
  });
}
