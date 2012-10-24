package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

/**
 * Gloucester County, NJ (version A)
 */
public class NJGloucesterCountyAParser extends DispatchProphoenixParser {
  
  public NJGloucesterCountyAParser() {
    super(CITY_CODES, "GLOUCESTER COUNTY", "NJ");
  }
 
  @Override
  public String getFilter() {
    return "gccad@co.gloucester.nj.us";
  }

//  @Override
//  protected boolean parseMsg(String body, Data data) {
//    return parseFields(body.split("\n"), data);
//  }
//  
//  private class MyAddressField extends AddressField {
//    @Override
//    public void parse(String field, Data data) {
//      int pt = field.indexOf('\\');
//      if (pt >= 0) {
//        data.strPlace = field.substring(pt+1).trim();
//        field = field.substring(0,pt).trim();
//      }
//      super.parse(field, data);
//    }
//    
//    @Override
//    public String getFieldNames() {
//      return super.getFieldNames() + " PLACE";
//    }
//  }
//  
//  private static final Pattern TIME_PTN = Pattern.compile("Dsp-(\\d\\d:\\d\\d:\\d\\d)");
//  private class MyTimeField extends TimeField {
//    @Override
//    public void parse(String field, Data data) {
//      Matcher match = TIME_PTN.matcher(field);
//      if (!match.matches()) return;
//      super.parse(match.group(1), data);
//    }
//  }
//  
//  @Override
//  protected Field getField(String name) {
//    if (name.equals("ADDR")) return new MyAddressField();
//    if (name.equals("TIME")) return new MyTimeField();
//    return super.getField(name);
//  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "A", "CLAYTON",
      "C", "EAST GREENWICH TWP",
      "R", "WASHINGTON TWP"
  });
}
