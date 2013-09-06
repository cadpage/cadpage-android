package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Camden County, GA
 */
public class GACamdenCountyAParser extends DispatchA3Parser {
  
  public GACamdenCountyAParser() {
    super(1, "", "CAMDEN COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com,911paging@co.camden.ga.us ";
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("^[^ ]*,[^ ]* ");
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = UNIT_PTN.matcher(field);
      if (match.find()) field = field.substring(match.end()).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
}
