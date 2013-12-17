package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Boone County, OH
 */
public class INBooneCountyParser extends DispatchCiscoParser {

  public INBooneCountyParser() {
    super("BOONE COUNTY", "OH");
  }

  @Override
  public String getFilter() {
    return "ciscopaging@co.boone.in.us";
  }
}
  