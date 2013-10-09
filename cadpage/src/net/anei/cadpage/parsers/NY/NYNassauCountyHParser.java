package net.anei.cadpage.parsers.NY;

public class NYNassauCountyHParser extends NYSuffolkCountyXBaseParser {
  
  public NYNassauCountyHParser() {
    super("NASSAU COUNTY", "NY",
           "CALL PLACENAME ADDR! CS:X? TOA:TOA!");
  }
  
  @Override
  public String getFilter() {
    return "scmbackup@verizon.net,cpg.page@gmail.com,wbpaging@optonline.net";
  }
}
