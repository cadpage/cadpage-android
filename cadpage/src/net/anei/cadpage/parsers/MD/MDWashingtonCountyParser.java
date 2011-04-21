package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Washington County, MD
Contact: "Snyder, Jon" <JSnyder@sems79.org>
Sender: "Dispatch@washco-md.net" <Dispatch@washco-md.net>
System: Keystone Public Safety
Related parsers MOSStLouisCountyParser, NJMorrisCountyParser,
Drop everything after first \n

MAPLEVILLE RD / CHEWSVILLE RD - PIC, PERS INJURY COLLISION - CO16,RSQE7,R79,SO20 - 1106957 15:38
73 S MAIN ST - FALLS,BACK INJURIES - R79 - 1106940 12:07 2nd ALERT!
14518 MARYLAND AVE - STROKE - FAA4,R79,CO9 - 1106937 11:31
13730 MAUGANSVILLE RD, MAUGANSVILLE FIRE COMPANY - TRANSFER OF UNIT, - CO26,CO9 - 1106889 16:55
LEHMANS MILL RD - WATER RESCUE - - CO9,RS13,R75,BT20,SO20,RS2001,D20,M753,RSQE91,DC9,R79 - 1106823 23:27 2nd ALERT!
FRE CO, N FRANKLINVILLE RD/RT15 - THURMONT - WATER RESCUE - - RSQE7 - TAC 30 1106797 21:01
FRE CO, 15204 QUIRAUK SCHOOL RD - NAT GAS LEAK - CO7,R79,P791,RSQE7 - FIRE 60 1106779 19:49
21348 OLD FORGE RD, ST PETERS BEARD LUTHERAN CHURCH - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - CO9 - 1106753 16:45
INTERSTATE 70, EXIT35 I70 EB - PIC, PERS INJURY COLLISION - CO16,CO10,R75,R79,E101,P791,P751,SUP160,DC10,RS10,E161,CA75 - 1106746 16:21
22507 JEFFERSON BLVD, AC&T SMITHSBURG - EYE PROBLEMS,INJURIES - R79 - 1106670 16:20
20354 LEITERSBURG PIKE, PEN MAR TRAILER SALES INC - NAT GAS ODOR - CO9 - 1106635 00:13
LEITERSBURG PIKE / MILLERS CHURCH RD - PIC, PERS INJURY COLLISION - CO9,R75,P753,R79 - 1106553 22:22
MAPLEVILLE RD / JEFFERSON BLVD - PIC, PERS INJURY COLLISION - CO7,R79,M791,SUP70,P792,C79,RSQE7 - 1106339 12:40

*/

public class MDWashingtonCountyParser extends SmsMsgParser {
  
  private static final Pattern DELIM = Pattern.compile(" *(?<= )- +");
  private static final Pattern TRAILER = Pattern.compile("(?:(.+) )?(\\d{7}) \\d\\d:\\d\\d(?: (.*))?");
  
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "ALL", "ALLEGANY COUNTY",
      "BER", "BERKELEY COUNTY,WV",
      "FRA", "FRANKLIN COUNTY,PA",
      "FRE", "FREDERICK COUNTY",
      "FUL", "FULTON COUNTY,PA",
      "JEF", "JEFFERSON COUNTY,WV",
      "LOU", "LOUDOUN COUNTY,VA",
      "MOR", "MORGAN COUNTY,WV"
  });
 
  public MDWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@washco-md.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Drop everything after the first newline
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // Split body into fields separated by  - 
    String[] flds = DELIM.split(body);
    if (flds.length < 4) return false;
    if (flds.length > 6) return false;
    
    // Last field should contain call ID, time, and optional extra info
    String field = flds[flds.length-1];
    Matcher match = TRAILER.matcher(field);
    if (!match.matches()) return false;
    data.strCallId = match.group(2);
    data.strSupp = append(n2e(match.group(1)), " / ", n2e(match.group(3)));
    if (data.strSupp == null) data.strSupp = "";
    
    // First field contains option M/A county, address and optional place name
    Parser p = new Parser(flds[0]);
    String maCounty = p.getOptional(" CO, ");
    if (maCounty.length() > 0) {
      maCounty = COUNTY_CODES.getProperty(maCounty, maCounty);
      pt = maCounty.indexOf(',');
      if (pt >= 0) {
        data.strState = maCounty.substring(pt+1);
        maCounty = maCounty.substring(0,pt);
      }
      data.strCity = maCounty;
    }
    parseAddress(p.get(','), data);
    data.strPlace = p.get();
    
    // Next to last field is always unit
    data.strUnit = flds[flds.length-2];
    
    // Now things get complicated.  The call description is the 2nd field, unless
    // we have a total of 6 fields in which case it is a city associated with an MA county
    int callNdx = 1;
    if (flds.length == 6) {
      callNdx = 2;
      data.strCity = flds[1];
    }
    data.strCall = flds[callNdx];
    
    // If we had 5 or 6 fields, the field behind the call description is more
    // supplemental info
    if (callNdx+1 < flds.length-2) {
      data.strSupp = append(data.strSupp, " / ", flds[callNdx+1]);
    }
    return true;
  }
  
  private static String n2e(String str) {
    return str == null ? "" : str;
  }
}
