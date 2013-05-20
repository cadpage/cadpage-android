package net.anei.cadpage.parsers.NY;

/**
 * Suffolk County (variant F)
 */
public class NYSuffolkCountyFParser extends NYSuffolkCountyXBaseParser {
  
    public NYSuffolkCountyFParser() {
      super("SUFFOLK COUNTY", "NY",
             "CALL! TOA:TOA! CODE ADDR! CS:X? IDP! INFO+");
    }
    
    @Override
    public String getFilter() {
      return "Paging1@firerescuesystems.xohost.com,masticambco@optonline.net";
    }
	}
	