package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Northumberland County, PA
Contact: Kyle Rudy <rescuengine41@yahoo.com>
Contact: Chris Yetter <co50ffyetter@gmail.com>
Sender: @northumberland.alertpa.org

desc STHY 147 & BRUSH VALLEY RD * UPA * ACCIDENT - MVA WITH UNKNOWN INJURY(S) * Dispatch: CH 503,TK 542,MICU 545,ENG 721,CH 723,SQ 723,CH 721,ENG 541,SQ 553,SQ 581,RES 552,AMB 547,CH 722,CH 505,BR 724 affected loc AMB 547,MICU 545,ENG 541,RES 552,SQ 581,CH 721,CH 722,CH 723,ENG 721,SQ 723,CH 503,CH 505,BR 724,TK 542,SQ 553
desc 202 E PINE ST * YSE * FIRE - DWELLING - 2ND ALARM * Dispatch: ENG 561,TK 542,RES 735,MICU 545,ENG 572,SQ 563,UN 548,CH 505,RH 544 affected loc UN 548
LINCOLN ST & MEMORIAL DR * SUN * CARBON MONOXIDE INCIDENT * Dispatch: CH 503,CH 504,TK 542,ENG 531,SQ 581,MICU 91,ENG 572,CH 501,CH 502
330 S SHAMOKIN ST * SHA * FIRE - VEHICLE (CAR/SUV/VAN/ETC...) * Dispatch: FP 80,ENG 41,S/CH 4,ENG 11,S/CH 1 ,SH 21,S/CH 3,RES 62 ENG 11,SH 21,S/CH 3,RES 62,FP 80
S ANTHRACITE ST & W HIGH ST * SHA * FIRE - BRUSH * Dispatch: FP 80,ENG 41,BR 153,S/CH 4,SQ 21,ENG 11,S/CH 1 ,SH 21,S/CH 3,S/CH 2,RES 62 SH 21
204 MAIN ST * COA * STAND-BY ASSIGNMENT * Dispatch: ENG 141,ENG 41,ENG1,TK 32,AT 21,MICU 90,UT 195,SQ 66,ENG 294,A/L 36,ENG 161,SH 21,RES 62,AMB 923 AMB 923,MICU 90,AT 21,ENG 141,ENG 161,UT 195,ENG1,ENG 294,SH 21,TK 32,ENG 41,RES 62
19 N GRANT ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,ENG 11,S/CH 1 ,ENG 51,SQ 66,AMB 919,SH 21,S/CH 3,S/CH 2,RES 62 ENG 11,SH 21,TK 32,ENG 41,ENG 51,RES 62,FP 80
123 N FRANKLIN ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,MICU 90\r

*DO NOT INSERT BLANK BETWEEN MESSAGES!!


 */


public class PANorthumberlandCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" \\*(?= )");
  
  public PANorthumberlandCountyParser() {
    super(CITY_CODES, "NORTHUMBERLAND COUNTY", "PA",
           "ADDR CITY CALL! Dispatch:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "@northumberland.alertpa.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("desc ")) body = body.substring(5).trim();
    return parseFields(DELIM.split(body), data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "COA", "COAL",
      "SHA", "SHAMOKIN",
      "SUN", "SUNBURY",
      "UPA", "UPPER AUGUSTA TWP",
      "YSE", "SNYDER",
  });
}
