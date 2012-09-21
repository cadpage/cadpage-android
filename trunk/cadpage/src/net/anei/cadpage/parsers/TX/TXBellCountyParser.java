package net.anei.cadpage.parsers.TX;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Bell County, TX
Contact: Jonathan Phelps <texasking254@yahoo.com>
Sender:930010xx

LOC: 640 SCARLET OAK DR BELL TYPE CODE: STRUCT SubType: CALLER NAME: CLRNUM: TIME: 14:35:00 Comments: AC UNIT ON FIRE
LOC: CHAPPARAL RD/E TRIMMIER RD BELL TYPE CODE: TTA SubType: CALLER NAME: CLAY/CBF&R 513 CLRNUM: 830-426-0696 TIME: 15:38:34 Comments: TX 8304260696 -097.690451 +031.030079 CALLED IN BY A CENTAL BELL FIRE &RECUE NOT BLOCKING, BOTH VEH IN DIRT 5 INDIVIDUAL INVOLVED - 4 FEM, 1 MALE 2 VEH ACC Number of patients: 5 Age: Unknown Range Gender: Unknown Conscious: Unknown Breathing: Unknown ProQA chief complaint code: 29 Responder script: Age unknown, 2 VEH ACC. RED HYUNDAI SEDAN VS TAN SUBURBAN SUBURBAN RADIATOR IS LEAKING AIRBAG DEPLOYED ON SEDAN
LOC: CHAPPARAL RD/SCARLET OAK DR BELL TYPE CODE: GRASS SubType: CITY CALLER NAME: SW 706 CLRNUM:  TIME: 17:50:51
LOC: 512 CEDAR RIDGE CR BELL TYPE CODE: GRASS SubType: COUNTY CALLER NAME:  CLRNUM:  TIME: 19:22:52
LOC: 3465 UPTON DR BELL TYPE CODE: AL SubType: FIRE CALLER NAME: SARAH/STROUD CLRNUM: 8566-885-4634 TIME: 03:13:58 Comments:  ** Event not created for uncovered group CCFD/CCFD GENERAL FIRE RESIDENCE PREMISE PETER & JULIE PETERSON 254-518-5845 PENDING CONTACT '

Contact: David Buchanan <buchanan.james.david@gmail.com>
Sender: 93001010
P3 LOC: 5990 STANLEY RD BELL TYPE CODE: FALLS SubType: ND CALLER NAME: VERIZON WIRELESS CLRNUM: 3176501089 TIME: 18:14:19 Comments: 3176501089 -097.528317 +031.053661 MOBILE HOME NO LOT OFF OF DOGRIDGE ROAD FELL DOWN STAIRS/HURT KNEE Number of patients: 1 Age: 80 Years Gender: Male Conscious: Yes Breathing: Yes ProQA chief complaint code: 17 Responder script: 80 year old, Male, Conscious, Breathing. Falls. Caller Statement: FELL DOWN STAIRS/HURT KNEE. ProQA dispatch code: 17A01 Dispatch level suffix: G Response text: Alpha Responder script: NOT DANGEROUS body area (On the ground or floor). 1.This happened now (less than 6hrs ago). 2.The fall was less than 10ft/3m (less than 1 story). 3.The fall was accidental. 4.There is no bleeding now. 5.He is completely alert (responding appropriately). 6.The injury is to a NOT DANGEROUS area. 7.He is still on the floor (ground). FELL DOWN 1 STAIR

*/

public class TXBellCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BELL", ""   // Bell County
  });
  
  public TXBellCountyParser() {
    super(CITY_CODES, "BELL COUNTY", "TX",
        "LOC:ADDR/S! TYPE_CODE:CALL! SubType:CALL CALLER_NAME:NAME! CLRNUM:PHONE! TIME:SKIP! Comments:INFO");
  }
  
  public String getFilter() {
    return "930010";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("CHAPPARAL", "CHAPARRAL");
      super.parse(field, data);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
