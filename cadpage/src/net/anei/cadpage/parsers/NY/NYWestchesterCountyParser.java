package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYWestchesterCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARMNK", "ARMONK",
      "BANKS", "BANKSVILLE",
      "CHAPQ", "CHAPPAQUA",
      "GNWCH", "GREENWICH,CT",
      "LARCH", "LARCHMONT",
      "MAMTW", "MAMARONECK",
      "MILLW", "MILLWOOD",
      "PNDRRG", "POUND RIDGE",
      "PORTC", "PORT CHESTER",
      "PVILL", "PLEASANTVILLE",
      "RYE",   "RYE"
  });
  
  public NYWestchesterCountyParser() {
    super(CITY_CODES, "WESTCHESTER COUNTY", "NY",
           "ADDR Cross:X! Type:CALL! CALL Time_out:TIME Area:CITY lev:PRI Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "IPAGE@westchestergov.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Check for IPage signature
    do {
      if (subject.equals("IPage")) break;
      if (subject.equals("Email Copy Message From Hiplink")) break;
      if (body.startsWith("IPage / ")) {
        body = body.substring(8).trim();
        break;
      }
      if (body.startsWith("- ")) {
        body = body.substring(2).trim();
        break;
      }
      return false;
    } while (false);
    
    body = body.replace(" Area:", ",Area:");
    if (!parseFields(body.split(","), data)) return false;
    int pt = data.strCity.indexOf(',');
    if (pt >= 0) {
      data.strState = data.strCity.substring(pt+1).trim();
      data.strCity = data.strCity.substring(0,pt).trim();
    }
    if (data.strCity.equals("BANKSVILLE")) {
      data.strPlace = append(data.strPlace, " - ", data.strCity);
      data.strCity = "BEDFORD";
    }
    return true;
  }

  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strApt = p.getLastOptional(":APT ");
      data.strPlace = p.getLastOptional(": @");
      if (data.strPlace.length() == 0) data.strPlace = p.getLastOptional(':');
      data.strCity = p.getLast(' ');
      parseAddress(p.get(), data);
      if (data.strAddress.length() == 0) {
        data.strAddress = data.strPlace;
        data.strPlace = "";
      }
      if (data.strCity.endsWith("_T")) {
        data.strCity = data.strCity.substring(0,data.strCity.length()-2);
      }
      data.strCity = data.strCity.replace('_', ' ');
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY ST PLACE APT";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
	