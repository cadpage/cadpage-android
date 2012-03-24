package net.anei.cadpage.parsers.IN;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA6Parser;

/*
St Joseph County, IN
Contact: Eric Yoder <pennfire38@sbcglobal.net>
Sender: rc.425@c-msg.net

Subject:CAD\n[!] ^ 11425 MCKINLEY HW PE :(55231) BELAIR STGAS LEAK FROM PUTING IN A POST 1626,006NIPSCO 1627,014PEN4A\n
Subject:CAD\n[!] ^ 17 RIVERCREST DR OS :( 600) N BEECH RDFROM MEDICAL ALARM COMP UNK MED 1617,006CALL BACK # TO ALARM COMP 800-325-17\n

Contact: Tyler Heckaman <ty.heckaman@gmail.com>
Subject:CAD\n[!] CRASH021 ^ 2 BYPASS HW PE :(60000) ELM RD2 VEH UNK INJ 0613,010ME10 ,PENN1 
Subject:CAD\n[!] COMAL021 ^ 55693 ASH RD PE :(10000) ELSIE HWDUNGARVIN - COMMERCIAL FIRE ALARM - MANUAL 1233,014NOVI 800-877-3624 PRE 
Subject:CAD\n[!] RESAL021 ^ 54895 MONTPELLIER DR PE :(11500) BOISE RUN STRESIDENTIAL FIRE ALARM - HALLWAY SMOKE DETECTOR 0813,014PENN 
Subject:CAD\n[!] ^ 56375 CURRANT RD PE :(13402) ESTHER AVM. HEAD INJ FROM ASSULT 2147,014ME12 ,PENN2 

Contact: support@active911.com
Sender: rc.588@c-msg.net
(NC)[!] INVES 03/23/12 POPPY LN :( ) OBTAIN MORE LOCATION INFOBETWEEN HICKORY AND HOLLY - UNKNOWN TYPE FIRE
(NC)[!] CRASH009 G-453 03/23/12 30750 SR 2 HW NC :(56000) LARRISON DRPI
(NC)[!] COMAL009 G-428 03/23/12 31869 CHICAGO TR NC :(51452) HAMILTON TRGENERAL FIRE-SIMPLEX SECURITY

*/


public class INStJosephCountyParser extends DispatchA6Parser {
  
  public INStJosephCountyParser() {
    super(CITY_CODES, "ST JOSEPH COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[] {
      "NC", "NEW CARLISLE",
      "OS", "OSCEOLA",
      "PE", "PENN"
  });
}
