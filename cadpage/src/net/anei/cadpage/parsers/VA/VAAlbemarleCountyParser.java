package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Albemarle County, VA
Contact: Joe Orsolini <muzz3256@gmail.com>
Casey Taylor <ctaylor1341@gmail.com>
Neale Nickels <neale.nickels@gmail.com>
Contact: James Wyant <jwyant15@gmail.com>
Contact: Alexander Colley <fish3170@gmail.com>
Contact: Joe Orsolini <orsolini@earlysvillefire.org>
Works for 911 center

Sender: CAD@acuecc.org
System: Premier CAD by Motorola

EARLYSVILL EXTRICATION AD: SEMINOLE TRL&FRAYS MILL RD CTY: AC LOC: SB JUST S OF THE STOPLIGHT CALLER WAS GOING NB AND SAW A VEHICLE ROLL OVER SE
EARLYSVILL EMS CALL AD: 1700 FOXTAIL PNES CTY: AC 93YOM, DIFF BREATHING, JUST DISCHARGED FROM HEALTHSOUTH, AWAKE/TALKING XST2: 2497 ASPENWOOD RD
EARLYSVILL RES STRUCTURE FIRE AD: 4235 WOODTHRUSH LN CTY: AC SMOKE AND FIRE IN THE HOUSE XST: 5001 MEADOWLARK CT
EARLYSVILL MVA AD: SEMINOLE TRL&LEWIS AND CLARK D CTY: AC LOC: NB LANE 5 OR 6 CARS INVOLVED, UNKNWON INJURIES
EARLYSVILL ALARM ACTIVATION AD: 4924 FREE UNION RD CTY: AC LOC: RICHARD BOOTH RES GUEST HOUSE FIRE ALARM-# IS 973-1805 XST: 2001 TASMANIA DR XST
EARLYSVILL CHIMNEY FIRE APT:11B AD:702 WOODBURN CT CTY:AC SPARKS COMING FROM THE CHIMNEY-FIRE STILL IN FIREPLACE-NO SMOKE IN APT XST:2036 WO
EARLYSVILL BRUSH FIRE AD: 1589 THOMPSON FARM RD CTY: AC LOC: OFF OF FREE UNION RD CALLER ADV'D A LOT OF SMOKE IN THE AREA, POSSIBLY FROM A CONTRO

Contact: Lance Blakey <lanceblakey@gmail.com>
CFCHQ      SEIZURE/CONVULSION M AD: 222 SHAMROCK RD CTY: CH LOC: ARC OF THE PIEDMONT 53 YOF, SEIZURE, SOB, HX OF SEIZURES XST: 100 STRATFORD CT
CFCHQ      REDUCED COMM FIRE AD: 1215 LEE ST - UVA CTY: CH LOC: UNIVERSITY HOSPITAL BURNING SMELL IN 7 CENTRAL
CFCHQ      SEIZURE/CONVULSION M AD: 222 SHAMROCK RD CTY: CH LOC: ARC OF THE PIEDMONT 53 YOF, SEIZURE, SOB, HX OF SEIZURES XST: 100 STRATFORD CT

 */


public class VAAlbemarleCountyParser extends FieldProgramParser {
    
  
  public VAAlbemarleCountyParser() {
    super("ALBEMARLE COUNTY", "VA",
           "CALL! APT:APT? AD:ADDR! CTY:CITY! LOC:INFO? XST:X? XST2:X");
  }
  
  @Override
  public String getFilter() {
    return "CAD@acuecc.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() < 10) return false;
    
    data.strSource = body.substring(0,10).trim();
    body = body.substring(10).trim();
    return super.parseMsg(body, data);
  }
  
  // Address field may contain place name
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" - ");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data); 
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  // City code isn't really a city.  It is a 2 character source code
  // possibly followed by an info field.  And we ignore the source code in
  // favor of the 10 character code at the beginning of the message
  private class MyCityField extends SkipField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() > 3) data.strSupp = field.substring(3).trim();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
