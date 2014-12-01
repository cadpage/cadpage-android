package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Collin County, TX
 */
public class TXCollinCountyBParser extends FieldProgramParser {
  
  private static final Pattern SPECIAL_COMMENT_PTN = Pattern.compile("^Comment:(.*?),  +");
  private static final Pattern DELIM = Pattern.compile(" */ *(?=ADDR:|Comment:|XST:|City:|Map Page:|All Response Comments:)");

  public TXCollinCountyBParser() {
    super("COLLIN COUNTY", "TX", 
          "CALL! ( ADDR:ADDR! ADDR+ Comment:INFO! | Comment:INFO! ADDR:ADDR! ) XST:X? City:CITY? Map_Page:MAP? All_Response_Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "PSCx7900@plano.gov ";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("VisiCAD SMTP Paging")) return false;
    
    // Check for special comment that indicates some kind of update status
    // Lacking any better place, save it in the place field
    Matcher match = SPECIAL_COMMENT_PTN.matcher(body);
    if (match.find()) {
      data.strPlace = match.group(1).trim();
      body = body.substring(match.end());
    }
    
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "PLACE " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (city.equals("TX")) city = p.getLastOptional(',');
      data.strCity = city;
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      // A lot of times dispatch puts the station address as the response address
      // and the real incident address in in the first comment :(
      if (data.strAddress.equals("165 Country Club Rd") && isValidAddress(field)) {
        data.strAddress = "";
        parseAddress(field, data);
      } else {
        data.strSupp = append(data.strSupp, "\n", field);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return COUNTY_PTN.matcher(addr).replaceAll("COUNTY");
  }
  private static Pattern COUNTY_PTN = Pattern.compile("\\bCOUNTY[NSEW]\\b", Pattern.CASE_INSENSITIVE);
}
