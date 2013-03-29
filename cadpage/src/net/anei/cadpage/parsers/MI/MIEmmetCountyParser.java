package net.anei.cadpage.parsers.MI;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class MIEmmetCountyParser extends DispatchOSSIParser {
  
  private static final Pattern MARKER = Pattern.compile("^CAD:MSG:", Pattern.CASE_INSENSITIVE);
  
  public MIEmmetCountyParser() {
    this("EMMET COUNTY", "MI");
  }
  
  MIEmmetCountyParser(String defCity, String defState) {
    super(CITY_CODES, defCity, defState,
           "ID?:( CANCEL | FYI CALL SRC ) ADDR! CITY? INFO+");
  }
  
  @Override
  public String getAliasCode() {
    return "MIEmmetCounty";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = MARKER.matcher(body).replaceFirst("CAD:");
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CallField("CANCEL", true);
    if (name.equals("SRC")) return new SourceField("[A-Z]{3,4}", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      
      // Charlevoix County
      "HDS",  "HUDSON",
      
      // Emmet County
      "BV",   "BAY VIEW",
      "HS",   "HARBOR SPRINGS",
      
      "BRC",  "BEAR CREEK TWP",
      "LTR",  "LITTLE TRAVERSE TWP",
      "MLR",  "MELROSE TWP",
      "PLS",  "PLEASANTVIEW TWP",
      "RST",  "RESORT TWP",
      "WST",  "WEST TRAVERSE TWP",
  });
}
