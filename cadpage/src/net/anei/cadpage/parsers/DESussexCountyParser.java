package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
[86 EMS] -- 31C2 -- 33384 Hartford Ct Lewes
[86 EMS] -- 33A1 -- 36101 Seaside Blvd Rehoboth
[86 EMS] -- 17A1 -- 18958 Coastal Hwy Lewes
[86 Fire] -- F - Auto Fire Alarm -- Hallmark, Parcel Post, Safeway -- 19266 Coastal Hwy Rehoboth -- INC #602
[86 Fire] -- F - Standby -- Bethany Beach Station 70 Rehoboth Beach -- INC #599
[83 FIRE] -- Traffic/TransportationAcdntALS -- 228 W Dupont Hwy Millsboro 19966 -- Food Lion (83)
[83 FIRE] -- Vehicle Fire -- 26026 Patriots Way Georgetown 19947 -- Sussex Central High School
[83 FIRE] -- Carbon Monoxide Detector -- 28 Patterson Dr Georgetown 19947 
[83 FIRE] -- Washdown (Fuel Spill) -- 26972 - 28044 Zoar Rd Georgetown 19947
[83 FIRE] -- Traffic/TransportationAcdntBLS -- 0 Dupont Blvd & Av Of Honor Georgetown 19947
[83 FIRE] -- Structure Fire -- 0 JOHNSON RD & JESTICE FARM RD Laurel 19956
[83 FIRE] -- Cardiac/Resp./Death-ALS -- 28723 Woodcrest Dr Harbeson 19951
 */


public class DESussexCountyParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "DE";
  private static final String DEF_CITY = "SUSSEX COUNTY";
  
  public DESussexCountyParser() {
    super(DEF_STATE);
  }


  @Override
  protected boolean parseMsg(String body, Data data) {

    if (!body.contains("] -- ")) return false;

    data.defState = DEF_STATE;
    data.defCity = DEF_CITY;

    // First divide up the call
    String strBody[] = body.split("--");
    if (strBody.length < 3) return false;

    // Always ignore the 0 field.
    // field 1 -s the call description
    data.strCall = strBody[1].trim();

    // See how many fields we have
    int fldCnt = strBody.length;

    // If more than 3 and the last fields starts with "INC ", ignore it
    if (fldCnt > 3 && strBody[fldCnt-1].trim().startsWith("INC ")) fldCnt--;

    // If we are down to 3 fields, the last one is the address line and
    // nothing needs to be worried about
    String sAddress;
    if (fldCnt == 3) {
      sAddress = strBody[2].trim();
    }

    // Otherwise we have big problems, one of lines 3 and 4 is the address
    // line and one is a place name.  But we don't know which is which.
    else {
      String[] flds = new String[]{strBody[2].trim(), strBody[3].trim()};
      int ndx = findBestAddress(flds);
      sAddress = flds[ndx];
      data.strPlace = flds[1-ndx];
    }

    // Sometimes the address has a leading zero for unknown reasons
    // which needs to be removed
    if (sAddress.length() < 2) return false;
    if (sAddress.startsWith("0 ")) sAddress = sAddress.substring(2).trim();
    
    // Run the smart parser on this, and see what is left
    parseAddress(StartType.START_ADDR, sAddress, data);
    sAddress = getLeft();
    
    // If the last token in what is left is a 5 digit zip code, strip it off
    Parser p = new Parser(sAddress);
    String zip = p.getLastOptional(' ');
    if (zip.length() == 5 && NUMERIC.matcher(zip).matches()) sAddress = p.get();
    
    // Whatever is left is our city
    data.strCity = sAddress;

    return true;
  }

  /**
   * Examine list of possible address fields and return the index of the
   * most likely candidate
   * @param flds array of possible address fields
   * @return index of best candidate
   */
  private int findBestAddress(String[] flds) {
    
    // Phase 1, if it starts with a leading zero, it is probably an address
    for (int ndx = 0; ndx<flds.length; ndx++) {
      if (flds[ndx].startsWith("0 ")) return ndx;
    }
    
    // Phase 2, if it ends with a 5 digit zip code, it is probably an address
    for (int ndx = 0; ndx<flds.length; ndx++) {
      Parser p = new Parser(flds[ndx]);
      String last = p.getLastOptional(' ');
      if (last.length() == 5 && NUMERIC.matcher(last).matches()) return ndx;
    }
    
    // Phase 3, we have to ask the address parser for its opinion
    int bestNdx = 0;
    int bestScore = -1;
    for (int ndx = 0; ndx<flds.length; ndx++) {
      int score = checkAddress(flds[ndx], 1);
      if (score > bestScore) {
        bestNdx = ndx;
        bestScore = score;
      }
    }
    
    return bestNdx;
  }
}


