package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;




public class PAArmstrongCountyBParser extends DispatchA9Parser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "LEECHBURG BORO",    "LEECHBURG",
      "KITTG BORO",        "KITTANNING"
  });
  
  public PAArmstrongCountyBParser() {
    super(CITY_CODES, "ARMSTRONG COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
}
