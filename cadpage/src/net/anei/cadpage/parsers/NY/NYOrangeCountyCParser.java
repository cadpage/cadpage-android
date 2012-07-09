package net.anei.cadpage.parsers.NY;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Orange County, NY 
Contact: CodeMessaging

[mCAD] DEPT24   TYP: MOTOR VEHICLE ACCIDT |308 HOMESTEAD AVE |MAYBROOK /CAR VS PED XST: 105 BROADWAY /105 WILLIAM ST
[mCAD] DEPT24   TYP: ANNOUNCEMENT |203 WALLACE AVE |MAYBROOK /CAR FIRE DRILL TONIGHT 1900 ANYONE ATTENDING THE FAMILY EVENT ON MONDAY PLEASE SIGN UP ON THE SHEET XST: CHARLES ST /111 MAIN ST
[mCAD] DEPT24   TYP: FIRE DRILL |2040 ST RTE 208 |MONTGOMERY CMT1: CAR FIRE DRILL |QUALITY TOWING XST: 2 MORRISON PL /2 HOUSTON PL
[mCAD] DEPT24   TYP: MEDICAL CALL |2040 ST RTE 208 |MONTGOMERY /SUBJ WITH HEAT EXHAUSTION |QUALITY TOWING XST: 2 MORRISON PL /2 HOUSTON PL
[mCAD] DEPT24   TYP: STANDBY |2817 ALBANY POST RD |MONTGOMERY /1 ENG STBY MONTGOMERY INCIDENT CLONED FROM PARENT: F29120531000398 XST: 1 WHITE BIRCH LN /1 E SEARSVILLE RD
[mCAD] DEPT24   TYP: ANNOUNCEMENT |203 WALLACE AVE |MAYBROOK /CLARK PL IS NOW REOPENED FOR ALL TRAFFIC |MAYBROOK FIRE XST: CHARLES ST /111 MAIN ST
[mCAD] DEPT24   TYP: ROLLOVER MVA |2040 ST RTE 208 |MONTGOMERY /TRACTOR TRAILER ROLLOVER - WITH PIN SiblingInc MMO120601003179 UPDATE PriUnt to ML/277 XST: 2 MORRISON PL /2 HOUSTON PL
[mCAD] DEPT24   TYP: STANDBY |1175 ST RTE 17K |MONTGOMERY /1 ENGINE OWN QTRS INCIDENT CLONED FROM PARENT: F29120601000402 XST: 2 MCGOWAN DR /1 MIDDLE SCHOOL LN
[mCAD] DEPT24   TYP: ALS MEDICAL CALL |901 TOWER AVE |MAYBROOK /MDIFFICULTY BREATHING 69 YEAR OLD MALE CONSCIOUS BREATHING 1)HE IS C OMPLETELY ALERT (RESPONDING APPROPRIATELY) 2)HE HAS DIFFICULTY SPEAKING TIME:10:59 XST: CHRISTIAN LN /SENIOR DR
[mCAD] DEPT24   TYP: STANDBY |SARAH WELLS TRL&DORIAN WAY |HAMPTONBURGH /STDBY IN QTRS FOR DEPT 2 INCIDENT CLONED FROM PARENT: F02120602000223 
[mCAD] DEPT24   TYP: ALS MEDICAL CALL |648 TWIN ARCH RD |NEW WINDSOR /MCARDIAC EMERGENCY 75 YEAR OLD FEMALE CONSCIOUSNESS UNKNOWN BREATHING STATUS UNKNOWN 1)IT'S NOT KNOWN IF SHE IS COMPLETELY ALERT (RESPONDING A XST: 1 PHYLLIS LN /2129 LITTLE BRITAIN RD
[mCAD] DEPT24   TYP: INFORMATION ONLY |203 WALLACE AVE |MAYBROOK CMT1: CLARK PLACE FROM PROSPECT AVE TO HIGHLAND AVE WILL BE CLOSED FOR PAVING |MAYBROOK FIRE XST: CHARLES ST /111 MAIN ST
[mCAD] DEPT24   TYP: MOTOR VEHICLE ACCIDT |INTERSTATE 84 E&EXIT 5 E OFF |MONTGOMERY /EASTBOUND///TRACTOR TRAILER VS CAR UNK PI Parent Inc MMG120606000931 UPDATE PriUnt to MG/MGDIS 
[mCAD] DEPT24   TYP: ALS MEDICAL CALL |218 COUNTRY CLUB DR |MAYBROOK /MCHEST PAIN 45 YEAR OLD FEMALE CONSCIOUS BREATHING 1)SHE IS COMPLETEL Y ALERT (RESPONDING APPROPRIATELY) 2)SHE HAS DIFFICULTY SPEAKING BETWEEN XST: 1 PALMER CT /201 SARACINO DR
[mCAD] DEPT24   TYP: ALS MEDICAL CALL |813 ABBEY AVE |MAYBROOK /MCOUGHING UP MUCOUS WHEEZING 89 YEAR OLD FEMALE CONSCIOUS BREATHING 1)SHE IS COMPLETELY ALERT (RESPONDING APPROPRIATELY) 2)SHE DOES NOT HAVE XST: WILEY ST /CHRISTIAN LN


*/

public class NYOrangeCountyCParser extends FieldProgramParser {
  
  public NYOrangeCountyCParser() {
    super("ORANGE COUNTY", "NY",
        "SRC TYP:CALL! ADDR! CITY! Time:TIME? XST:X");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("mCAD")) return false;
    body = body.replace("TIME:", "|Time:");
    body = body.replace("TYP:", "|TYP:");
    body = body.replace("CMT1:", "/");
    body = body.replace("XST:", "|XST:");
    if (!parseFields(body.split("\\|"), data)) return false; 
    return true;
  }
    private class MyCityField extends CityField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('/');
      if (pt > 0) {
        data.strSupp = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CITY INFO";
    }
  }
    
  private static final Pattern INFO_PTN = Pattern.compile(" *\\b(?:INCIDENT CLONED FROM PARENT: F\\d+\\b|Parent Inc [A-Z0-9]+|UPDATE PriUnt to ([A-Z/0-9]+))\\b *");
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      StringBuffer sb = new StringBuffer(); 
      Matcher match = INFO_PTN.matcher(field); 
      while (match.find()) {
        String sUnit = match.group(1);
        if (sUnit != null) data.strUnit = sUnit;
        match.appendReplacement(sb, " ");
      }
      match.appendTail(sb);
      field = sb.toString().trim();

      super.parse(field, data);
    }
  }
   
    @Override
    protected Field getField(String name) {
      if (name.equals("INFO")) return new MyInfoField();
      if (name.equals("CITY")) return new MyCityField();
      return super.getField(name);
    }
}








