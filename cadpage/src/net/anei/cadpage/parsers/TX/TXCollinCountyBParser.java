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
  private static final Pattern DELIM = Pattern.compile(" +/(?! )");

  protected TXCollinCountyBParser() {
    super("COLLIN COUNTY", "TX", 
          "CALL! Comment:INFO! ADDR:ADDR! ADDR+ XST:X! X+ Map_Page:MAP!");
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
    
    if (!parseFields(DELIM.split(body), data)) return false;
    
    // Do the real address field parsing here.  We couldn't do it
    // in the address field processor because it didn't know when
    // the address was complete
    Parser p = new Parser(data.strAddress);
    data.strAddress = "";
    String city = p.getLastOptional(',');
    if (city.equals("TX")) city = p.getLastOptional(',');
    data.strCity = city;
    parseAddress(p.get(), data);
    return true;
  }
  
  @Override
  public String getProgram() {
    return "PLACE " + super.getProgram();
  }
  
  // Since we use a naked slash as a field delimiter, we have to
  // consider what happens if there is slash in the address field 
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      data.strAddress = append(data.strAddress, " / ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY";
    }
  }
  
  // Ditto for the cross field
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      data.strCross = append(data.strCross, " / ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
