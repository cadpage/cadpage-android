package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Adams County, PA
 */
public class PASchuylkillCountyParser extends FieldProgramParser {
  
  public PASchuylkillCountyParser() {
    super("SCHUYLKILL COUNTY", "PA",
          "RESPOND_TO:ADDRCITY! FOR_A:CODE_CALL! TRUCKS:UNIT! CN:PLACE INFO+");
  }

  @Override
  public String getFilter() {
    return "llewellynscanner@hotmail.com,ldaubert@hotmail.com,ldaubert@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = stripFieldStart(body, "REPAGE ");
    body = body.replace(" FOR A:", "\nFOR A:");
    body = body.replace(" TRUCKS:", "\nTRUCKS:");
    return super.parseFields(body.split("\n"), 3, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("CODE_CALL")) return new MyCodeCallField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_INTERSECT_PTN = Pattern.compile("(.*?)-(\\d\\d)/(.*)");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_INTERSECT_PTN.matcher(field); 
      if (match.matches()) {
        parseAddress(match.group(1).trim() + " & " + match.group(3).trim(), data);
        data.strCity = convertCodes(match.group(2), CITY_CODES);
      }
      
      else {
        int pt = field.lastIndexOf('-');
        if (pt < 0) abort();
        parseAddress(field.substring(0,pt).trim(), data);
        data.strCity = field.substring(pt+1).trim();
      }
    }
  }
  
  private class MyCodeCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf('-');
      if (pt < 0) abort();
      data.strCode = field.substring(0,pt).trim();
      data.strCall = field.substring(pt+1).trim();
    }

    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "03", "BRANCH TWP",
      "11", "FOSTER TWP",
      "20", "MINERSVILLE",
      "22", "PORTER TWP",
      "33", "WASHINGTON TWP"
  });
}
