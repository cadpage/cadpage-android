package net.anei.cadpage.parsers.MD;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchAParser;

/* 
**********************************************************
Wicomico County, MD
Contact: Jeff Paige <jeff.paige219@gmail.com>
Sender: cad@wicomicocounty.org

1638:CAD:2010110703;STRUCTURE FIRE;27887 POINTERS LN;SALI;SPANIEL CT;OXBRIDGE DR
1639:CAD:2010110960;STRUCTURE FIRE;914 E CHURCH ST;SALI;HOLLAND AVE;WALSTON AVE
1640:CAD:2010110997;PETROLEUM SPILL;2530 N SALISBURY BLVD;SALI;N ZION RD;N ZION RD
1642:CAD:2010111051;NON BREATHING;105 CIVIC AVE;SALI;OLD OCEAN CITY RD;WHITE ST;[Medical Priority Update] Medical Priority reconfigured event from 09-E-01 to
1643:CAD:2010111259;AUTOMATIC ALARM;121 E NAYLOR MILL RD;SALI;N SALISBURY BLVD;JASMINE DR;[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. HI
Mutual aid to Delmar DE
1644:CAD:2010111333;STRUCTURE FIRE;1103 STATE ST;DELM;HIGHLAND AVE;VIRGINIA AVE
1650:CAD:2010111860;STRUCTURE FIRE;1110 N DIVISION ST;SALI;NAYLOR ST;UNION AVE
1654:CAD:2010112048;STRUCTURE FIRE;413 CAMDEN CT;SALI;CAMDEN AVE;CAMDEN AVE;[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire.Caller Stat

Mutual aid from Delmar
CAD:2010110683;PI ACCIDENT;8859 JERSEY RD;DELM;CONNELLY MILL RD;ADKINS RD;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 25 year old, Male,
*/

public class MDWicomicoCountyParser extends DispatchAParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALLE", "ALLEN",
      "EDEN", "EDEN",
      "BIVA", "BIVALVE",
      "DELM", "DELMAR",
      "FRUI", "FRUITLAND",
      "HEBR", "HEBRON",
      "MARD", "MARDELA",
      "NANT", "NANTICOKE",
      "PARS", "PARSONBURG",
      "PITT", "PITTSVILLE",
      "POWE", "POWELLVILLE",
      "QUAN", "QUANTICO",
      "SALI", "SALISBURY",
      "SHAR", "SHARPTOWN",
      "TYAS", "TYASKIN",
      "WILL", "WILLARDS"
  });
  
  public MDWicomicoCountyParser() {
    super(CITY_CODES, "WICOMICO COUNTY", "MD",
           "ID CALL ADDR CITY! X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@wicomicocounty.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Strip off leading sequence number
    int pt = body.indexOf(':');
    if (pt < 0) return false;
    if (! body.substring(0,pt).equals("CAD")) body = body.substring(pt+1).trim();
    
    if (!super.parseMsg(body, data)) return false;
    
    // Delmar calls can be on either side of the state line
    if (data.strCity.equals("DELMAR")) data.defState = "";
    return true;
  }
}
