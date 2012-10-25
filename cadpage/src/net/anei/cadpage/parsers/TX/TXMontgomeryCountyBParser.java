package net.anei.cadpage.parsers.TX;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Montgomery County, TX (MCHD EMS)
 */
public class TXMontgomeryCountyBParser extends DispatchProQAParser {
  
  public TXMontgomeryCountyBParser() {
    super(CITY_CODES, "MONTGOMERY COUNTY", "TX",
           "CODE MAP ADDR CITY PRI! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@mchd-tx.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf("\n******");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new CodeField("\\d{2}[A-Z]\\d{2}", true);
    if (name.equals("MAP")) return new MapField("\\d{1,4}[A-Z]", true);
    if (name.equals("PRI")) return new PriorityField("Priority +(\\d)", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "77301", "CONROE",
      "77304", "CONROE",
      "77306", "CONROE",
      "77356", "SAM HOUSTON NAT FOREST",
      "77380", "SPRING",
  });
}
