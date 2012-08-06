package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Montgomery County, PA
Contact: CodeMessaging
Sender: @c-msg.net

[K] TRUCKS: E47-1,E47-2,SD47,TW47 127 S GULPH RD: @BEST WESTERN XST: W DEKALB PIKE/BILL SMITH BLVD NAT: FIRE ALARM,BOX:56-67/56-229
[K] TRUCKS: E47-1,E47-2,SD47,TW47 201 ALLENDALE RD: @COSTCO WHOLESALE,APT: 100 XST: WILLS BLVD/ELLIOTT DR NAT: FIRE ALARM,BOX:56-10/
[K] TRUCKS: E47-2,SD47 175 W VALLEY FORGE RD: @UPPER MERION TOWNSHIP BUILDING XST: N HENDERSON RD/NORTH GATE RD NAT: TRASH/DUMPSTER FIRE,BOX:56-09/56-200
[K] 6010 COUNTY LINE RD: @OFFICE & WOOD SHOP - VFNP XST: VALLEY FORGE PARK RD/GULPH RD NAT: FIRE ALARM,BOX:58-1/
[K] TRUCKS: E47-1,E47-2,SD47,TW47 680 W DEKALB PIKE: @MACY'S XST: ALLENDALE RD/MALL BLVD NAT: FIRE ALARM,BOX:56-67/56-202
[K] TRUCKS: E47-1,SD47,TW47,R47 160 N GULPH RD: @KING OF PRUSSIA PLAZA XST: KIRK AVE/MALL BLVD NAT: FIRE ALARM,BOX:56-77/56-201
[K] 260 N GULPH RD: @HOLIDAY INN EXPRESS XST: MALL BLVD/SCHUYLKILL EXPY OVERPASS NAT: BUILDING FIRE COMMERCIAL,BOX:56-77/56-218
[K] TRUCKS: E47-1,E47-2,SD47,TW47 260 N GULPH RD: @HOLIDAY INN EXPRESS XST: MALL BLVD/SCHUYLKILL EXPY OVERPASS NAT: FIRE ALARM,BOX:56-77/
[K] TRUCKS: E47-1,E47-2,SD47,TW47,3E68-1 1071 PENN CIR: @LAFAYETTE AT VALLEY FORGE - BUILDING G,APT: G306 XST: OLD FORGE LN/PARKVIEW DR NAT: BUILDING FIRE COMMERCIAL,BOX:56-80/56-211
[K] TRUCKS: E47-1,E47-2,SD47 256 RT202 NB XST: RAMP RT422 EB TO RT202 NB/RAMP I76 EB TO RT202 NB NAT: VEHICLE FIRE,BOX:56-77/
[K] TRUCKS: E47-1,E47-2,SD47,TW47 400 AMERICAN AVE: @HOMESTEAD VILLAGE HOTEL XST: 1ST AVE/ NAT: FIRE ALARM,BOX:56-75/
[K] TRUCKS: E47-1,E47-2,SD47,TW47,QT31 122 CROSSFIELD RD XST: FOX RUN RD/HEARTHSTONE RD NAT: BUILDING FIRE COMMERCIAL,BOX:56-09/


*/

public class PAMontgomeryCountyCParser extends FieldProgramParser {
  
  public PAMontgomeryCountyCParser() {
    super("Montgomery County", "PA",
        "ADDR UNIT:UNIT?  Place:PLACE? XST:X NAT:CALL BOX:BOX");
   }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  private class MyUnitField extends Field {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strAddress = field.substring(pt+1).trim();
      data.strUnit = field.substring(0,pt).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT ADDR";
    }
  }
    @Override 
    public boolean parseMsg(String subject, String body, Data data) {
      if (!subject.startsWith("K")) return false;
      body = body.replace(": @", " Place:").replace(",BOX", " BOX").replace("TRUCKS:", "UNIT:");
      return super.parseMsg(body, data);
    }

@Override
protected Field getField(String name) {
  if (name.equals("UNIT")) return new MyUnitField();
  return super.getField(name);
}
}
