package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

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

Contact: Jesse Zerbe <medicjz@gmail.com>
CAD MSG: *D ALSMED   107 ALLISON PL 0072 80YOM /RESP DIFF / SPITTING UP BLOOD //BEEN INCREASING OVER THE PAST

Contact: Duane Good <duaneg123@gmail.com>
Sender: alrt_1ODM@berks.alertpa.org
CAD MSG: *D ALSMED   106 MAIN ST 0063 56 YOF THROAT FEELS LIKE IS SWELLING CLOSED /BREAKING OUT IN RASH/RESP

Contact: jarrod emes <jkemes@gmail.com>
Sender: _1ZLG@berks.alertpa.org
CAD MSG: *D MVAWITH  I78 / MP 39.6 EB 0078 MC DRIVER DOWN IN THE ROADWAY / NOT MOVING / 2 TT PULLED OFF TO THE SI

*/

public class PABerksCountyParser extends SmsMsgParser {
  
  private static final String DEF_STATE = "PA";
  private static final String DEF_CITY = "BERKS COUNTY";
  
  private static final Pattern MUNI_CODE_PAT = Pattern.compile(" 00\\d\\d ");
  
  public PABerksCountyParser() {
    super(DEF_CITY, DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    // Strip off any prefix
    int pt = body.indexOf("CAD MSG: ");
    if (pt < 0) return false;
    body = body.substring(pt);
    
    // Extract primary call description
    if (body.length() < 20) return false;
    data.strCall = body.substring(9, 20).trim();
    body = body.substring(20);
    
    // Look for a 4 digit station ID, this marks the end of the address
    Matcher match = MUNI_CODE_PAT.matcher(body);
    if (! match.find()) return false;
    
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
    
    return true;
  }
  
  private static final int FIRST_MUNI_CODE = 19;
  private static final String[] MUNI_CODES = new String[]{
    /*19*/  "READING",
    /*20*/  null,
    /*21*/  "MOUNT PENN",
    /*22*/  "ST. LAWRENCE",
    /*23*/  "LOWER ALSACE TOWNSHIP",
    /*24*/  "ALSACE TOWNSHIP",
    /*25*/  "EXETER TOWNSHIP",
    /*26*/  "AMITY TOWNSHIP",
    /*27*/  "DOUGLASS TOWNSHIP",
    /*28*/  "UNION TOWNSHIP",
    /*29*/  "BIRDSBORO",
    /*30*/  "NEW MORGAN",
    /*31*/  "ROBESON TOWNSHIP",
    /*32*/  "CAERNARVON TOWNSHIP",
    /*33*/  "BRECKNOCK TOWNSHIP",
    /*34*/  "CUMRU TOWNSHIP",
    /*35*/  "MOHTON",
    /*36*/  "SHILLINGTON",
    /*37*/  "KENHORST",
    /*38*/  "WEST READING",
    /*39*/  "WYOMISSING",
    /*40*/  null,
    /*41*/  "OLD WYOMISSING HILLS",
    /*42*/  "OLD WEST LAWN",
    /*43*/  "SPRING TOWNSHIP",
    /*44*/  "SINKING SPRINGS",
    /*45*/  "SOUTH HEIDELBERG TOWNSHIP",
    /*46*/  "WERNERSVILLE",
    /*47*/  "ROBESONIA",
    /*48*/  "HEIDELBERG",
    /*49*/  "WOMELSDORF",
    /*50*/  null,
    /*51*/  "MARION TOWNSHIP",
    /*52*/  "NORTH HEIDELBERG",
    /*53*/  "LOWER HEIDELBERG",
    /*54*/  "BERN TOWNSHIP",
    /*55*/  "CENTRE TOWNSHIP",
    /*56*/  "PENN TOWNSHIP",
    /*57*/  "BERNVILLE",
    /*58*/  "JEFFERSON TOWNSHIP",
    /*59*/  "UPPER BERN TOWNSHIP",
    /*60*/  "CENTERPORT",
    /*61*/  "TILDEN TOWNSHIP",
    /*62*/  "UPPER TULPEHOCKEN TOWNSHIP",
    /*63*/  "STRAUSSTOWN",
    /*64*/  "BETHEL TOWNSHIP",
    /*65*/  "TULPEHOCKEN TOWNSHIP",
    /*66*/  "MUHLENBERG TOWNSHIP",
    /*67*/  "LAURELDALE",
    /*68*/  null,
    /*69*/  "ONTELAUNEE TOWNSHIP",
    /*70*/  null,
    /*71*/  "LEESPORT",
    /*72*/  "MAIDENCREEK TOWNSHIP",
    /*73*/  "PERRY TOWNSHIP",
    /*74*/  "SHOEMAKERSVILE",
    /*75*/  "WINDSOR TOWNSHIP",
    /*76*/  "HAMBURG",
    /*77*/  "ALBANY TOWNSHIP",
    /*78*/  "GREENWICH TOWNSHIP",
    /*79*/  "MAXATAWNY TOWNSHIP",
    /*80*/  "LENHARTSVILLE",
    /*81*/  "KUTZTOWN",
    /*82*/  "LYONS",
    /*83*/  "FLEETWOOD",
    /*84*/  "RICHMOND TOWNSHIP",
    /*85*/  "TOPTON",
    /*86*/  "LONGSWAMP TOWNSHIP",
    /*87*/  "ROCKLAND TOWNSHIP",
    /*88*/  "DISTRICT TOWNSHIP",
    /*89*/  "PIKE TOWNSHIP",
    /*90*/  null,
    /*91*/  "RUSCOMBMANOR TOWNSHIP",
    /*92*/  "OLEY TOWNSHIP",
    /*93*/  "EARL TOWNSHIP",
    /*94*/  "BOYERTOWN",
    /*95*/  "COLEBROOKDALE TOWNSHIP",
    /*96*/  "BECHTELSVILLE",
    /*97*/  "WASHINGTON TOWNSHIP",
    /*98*/  "BALLY",
    /*99*/  "HEREFORD TOWNSHIP"
  };
}
