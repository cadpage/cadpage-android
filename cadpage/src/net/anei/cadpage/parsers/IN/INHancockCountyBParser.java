package net.anei.cadpage.parsers.IN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

public class INHancockCountyBParser extends INShelbyCountyParser {
  
  public INHancockCountyBParser() {
    super("HANCOCK COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "interact@hancockcoingov.org";
  }
}
