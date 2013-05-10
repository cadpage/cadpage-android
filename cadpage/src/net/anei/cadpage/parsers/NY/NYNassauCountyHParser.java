package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYNassauCountyHParser extends NYSuffolkCountyXBaseParser {
  
  public NYNassauCountyHParser() {
    super("NASSAU COUNTY", "NY",
           "CALL PLACENAME ADDR! CS:X? TOA:TOA!");
  }
  
  @Override
  public String getFilter() {
    return "scmbackup@verizon.net";
  }
}
