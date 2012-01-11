package net.anei.cadpage.parsers.DE;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Sussex County, DE
Contact: Samuel Millman <fire7281@gmail.com>
Contact: "fdbuff@aol.com" <fdbuff@aol.com>
Sender: rc.212@c-msg.net
System: Code Messaging

(*CAD*) [CAD] Sta: 78AS3   Loc: 12319 Sussex Hwy   City: 19950   --- Sick Person(Specific Diag)-BLSPremise 12319 Sussex Hwy
(*CAD*) [CAD] Sta: 78AST   Loc: 7229 Seashore Hwy   --- Falls-BLS
(*CAD*) [CAD] Sta: 78AST   Loc: 14490 Broad Ave   City: 19950   --- Breathing Problems-ALS    Premise 14490 Broad Ave
(*CAD*) [CAD] Sta: 78AST   Loc: 12404 Double Fork Rd   City: 19950   --- Medical Alert         Premise 12404 Double Fork Rd
(*CAD*) [CAD] Sta: 78AST   Loc: 16976 Sussex Hwy       Canterbury Apt   --- Chest Pain-ALS
(*CAD*) [CAD] Sta: 78AS3   Loc: 203 E Market St   City: 19950   --- Hemorrhage/Lacerations-BLS  Premise 203 E Market St
(*CAD*) [CAD] Sta: 78AS1   Loc: 13757 Mile Stretch Rd   City: 19950   --- Stroke-ALS          Premise 13757 Mile Stretch Rd
(*CAD*) [CAD] Sta: 78AST   Loc: 14490 Broad Ave   City: 19950   --- Breathing Problems-ALS    Premise 14490 Broad Ave
(*CAD*) [CAD] Sta: 78AS2   Loc: 13757 Mile Stretch Rd   City: 19950   --- Stroke-ALS          Premise 13757 Mile Stretch Rd
(*CAD*) [CAD] Sta: 78AST   Loc: 18029 Spellman Ln   City: 19941   --- Unknown Problem(Man Down)-BLS

Contact: "greenwoodfire@aol.com" <greenwoodfire@aol.com>
Sender: rc.212@c-msg.net
Sta: 78AS2 Loc: 10725 Beach Hwy City: 19950 --- Traffic/TransportationAcdntALSPremise 10725 Beach Hwy

 */

public class DESussexCountyBParser extends FieldProgramParser {
  
  public DESussexCountyBParser() {
    super(CITY_CODES, "SUSEX COUNTY", "DE",
           "Sta:SRC! Loc:ADDR! City:CITY Call:CALL! Premise:SKIP");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = body.replaceAll(" --- ", " Call: ").replaceAll("Premise ", " Premise: ");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional("  ");
      field = p.get().trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "19330", "BETHANY BEACH",
      "19331", "BETHEL",
      "19333", "BRIDGEVILLE",
      "19339", "DAGSBORO",
      "19940", "DELMAR",
      "19941", "ELLENDALE",
      "19944", "FENWICK ISLAND",
      "19945", "FRANKFORD",
      "19947", "GEORGETOWN",
      "19950", "GREENWOOD",
      "19951", "HARBESON",
      "19956", "LAUREL",
      "19958", "LEWES",
      "19960", "LINCOLN",
      "19963", "MILFORD",
      "19966", "MILLSBORO",
      "19967", "MILLVILLE",
      "19968", "MILTON",
      "19969", "NASSAU",
      "19970", "OCEAN VIEW",
      "19971", "REHOBOTH BEACH",
      "19973", "SEAFORD",
      "19975", "SELBYVILLE"
  });
}


