package net.anei.cadpage.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Berks County, PA
Contact: "thirty5tripleuno@yahoo.com" <thirty5tripleuno@yahoo.com>
CAD MSG: *D MVAUNK   E STATE ST / S KEMP ST 0082 2 VEH / COMP IS ANDREW BROOKS / INVOLVED // AT THE INTERSECTION B
CAD MSG: *D MVAWITH  102 BEAVER CREEK RD 0087 1 VEH / SPUN OUT / MALE OCC (COMP'S HUSBAND) BELIEVES HE FRACTURED H
CAD MSG: *D FTEST    STATION 35 @110 PARK AV 0082 BERKS TESING THE TEXT PAGING SYSTEM NO ACTION REQUIRED
CAD MSG: *D MVAUNK   NOBLE ST / BASTIAN RD 0079 ONE CAR, OCCUPIED, INTO A FIELD // ONLY LANDMARK SHE COULD MEN﻿﻿
CAD MSG: *D SF       28 NOBLE ST 0081 SEES FLAMES IN BASEMENT //ADVISED TO EVAC /
CAD MSG: *D MVAENT   FORGEDALE RD / DAVIDS DR 0087 2VEHS HEAD ON/2 VICTIMS ENTRAPPED /1 FEMALE SERIOUSLY INJ/BLEED﻿﻿
Subject:1/2\nCAD MSG: *D FTELE    STATION 35 @110 PARK AV 0082 CALL REF ITEMS SHE HAS THAT ARE BELEIVED TO BELONG TO YOUR COMPA
*/

public class PABerksCountyParser extends SmsMsgParser {
  
  private static final String DEF_STATE = "PA";
  private static final String DEF_CITY = "BERKS COUNTY";
  
  private static final Pattern MUNI_CODE_PAT = Pattern.compile(" 00\\d\\d ");

  @Override
  public boolean isPageMsg(String body) {
    return body.contains("CAD MSG: ");
  }

  @Override
  protected void parse(String body, Data data) {
    data.defState = DEF_STATE;
    data.defCity = DEF_CITY;

    // Strip off any prefix
    int pt = body.indexOf("CAD MSG: ");
    if (pt < 0) return;
    body = body.substring(pt);
    
    // Extract primary call description
    if (body.length() < 20) return;
    data.strCall = body.substring(9, 20).trim();
    body = body.substring(20);
    
    // Look for a 4 digit station ID, this marks the end of the address
    Matcher match = MUNI_CODE_PAT.matcher(body);
    if (! match.find()) return;
    
    String muniCode = body.substring(match.start()+1, match.end()-1);
    int iMuniCode = Integer.parseInt(muniCode);
    iMuniCode -= FIRST_MUNI_CODE;
    if (iMuniCode >= 0 && iMuniCode < MUNI_CODES.length && MUNI_CODES[iMuniCode] != null) {
      data.strCity = MUNI_CODES[iMuniCode];
    } else {
      data.strCity = muniCode;
    }
    
    // An '@' splits place name from address
    String address = body.substring(0, match.start()).trim();
    pt = address.indexOf('@');
    if (pt >= 0) {
      data.strPlace = address.substring(0, pt).trim();
      address = address.substring(pt+1).trim();
    }
    data.strAddress = address.replace("/", "&");
    body = body.substring(match.end()).trim();
    
    // Anything beyond that is supplemental info
    data.strSupp = body.replaceAll("//+", "/");
  }
  
  private static final int FIRST_MUNI_CODE = 19;
  private static final String[] MUNI_CODES = new String[]{
    /*19*/  "READING",
    /*20*/  null,
    /*21*/  "MOUNT PENN",
    /*22*/  "ST LAWRENCE",
    /*23*/  "LOWER ALSACE",
    /*24*/  "ALSACE",
    /*25*/  "EXETER",
    /*26*/  "AMITY",
    /*27*/  "DOUGLASS",
    /*28*/  "UNION",
    /*29*/  "BIRDSBORO",
    /*30*/  "NEW MORGAN",
    /*31*/  "ROBESON",
    /*32*/  "CAERNARVON",
    /*33*/  "BRECKNOCK",
    /*34*/  "CUMRU",
    /*35*/  "MOHTON",
    /*36*/  "SHILLINGTON",
    /*37*/  "KENHORST",
    /*38*/  "WEST READING",
    /*39*/  "WYOMISSING",
    /*40*/  null,
    /*41*/  "OLD WYOMISSING HILLS",
    /*42*/  "OLD WEST LAWN",
    /*43*/  "SPRING",
    /*44*/  "SINKING SPRINGS",
    /*45*/  "SOUTH HEIDELBERG",
    /*46*/  "WERNERSVILLE",
    /*47*/  "ROBESONIA",
    /*48*/  "HEIDELBERG",
    /*49*/  "WOMELSDORF",
    /*50*/  null,
    /*51*/  "MARION",
    /*52*/  "NORTH HEIDELBERG",
    /*53*/  "LOWER HEIDELBERG",
    /*54*/  "BERN",
    /*55*/  "CENTRE",
    /*56*/  "PENN",
    /*57*/  "BERNVILLE",
    /*58*/  "JEFFERSON",
    /*59*/  "UPPER BERN",
    /*60*/  "CENTERPORT",
    /*61*/  "TILDEN",
    /*62*/  "UPPER TULPEHOCKEN",
    /*63*/  "STRAUSSTOWN",
    /*64*/  "BETHEL",
    /*65*/  "TULPEHOCKEN",
    /*66*/  "MUHLENBERG",
    /*67*/  "LAURELDALE",
    /*68*/  null,
    /*69*/  "ONTELAUNEE",
    /*70*/  null,
    /*71*/  "LEESPORT",
    /*72*/  "MADIENCREEK",
    /*73*/  "PERRY",
    /*74*/  "SHOEMAKERSVILE",
    /*75*/  "WINDSOR",
    /*76*/  "HAMBURG",
    /*77*/  "ALBANY",
    /*78*/  "GREENWICH",
    /*79*/  "KUTZTOWN", /*"MAXATAWNY"*/
    /*80*/  "LENHARTSVILLE",
    /*81*/  "KUTZTOWN",
    /*82*/  "LYONS",
    /*83*/  "FLEETWOOD",
    /*84*/  "RICHMOND",
    /*85*/  "TOPTON",
    /*86*/  "LONGSWAMP",
    /*87*/  "FLEETWOOD", /*"ROCKLAND"*/
    /*88*/  "DISTRICT",
    /*89*/  "PIKE TOWNSJIP",
    /*90*/  null,
    /*91*/  "RUSCOMBMANOR",
    /*92*/  "OLEY",
    /*93*/  "EARL",
    /*94*/  "BOYERTOWN",
    /*95*/  "COLEBROOKDALE",
    /*96*/  "BECHTELSVILLE",
    /*97*/  "WASHINGTON",
    /*98*/  "BALLY",
    /*99*/  "HEREFORD"
  };

}
