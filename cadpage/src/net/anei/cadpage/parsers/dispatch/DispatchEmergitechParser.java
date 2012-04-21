package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Base class for locations handling Emergitech CAD software

Knox County, OH
Dispatch:[SD35]- NATURE: FIRE TRASH/DUMPSTER FIRE LOCATION: 21 JOHNSV ILLE RD CENTERBURG BETWEEN COLUMBUS RD / UPDIKE RD COMMENTS : MATRESS ON FIRE IN PARK ACROSS FROM SUNOCO STATION 
Dispatch:[SD24]- NATURE: FIRESINGLE FAMILY RES STRUCTURE LOCATION: 42 20 ST RT 3 COMMENTS: MUTUAL AID BST&G STRUCTURE FIRE//HOUSE FILLED W/SMOKE////X ROADS OLD 3C//MEREDITH STATE RD
Dispatch:[SD35]- NATURE: CARDIAC OR RESPIRATORY ARREST/DEATH LOCATION : 212 FAIRVIEW AVE SUITE: BLDG CENTERBURG BETWEEN JONES AVE / LEONARD AVE COMMENTS: X Y 39 YOF TRACH AND VE NTILATOR PATIENT FULL CODE PROQA MEDICAL: NEW CASE NUMBER A SSIGNED CALL 11-1010849 BY SD35 (POS 02) AT 07:13:06 PROQA MEDICAL: ABORT CALL 11-1010849 BY SD35 (POS 02) AT 07:13:13 - DID NOT USE PROQA MEDICAL: STOPPED CALL 11-1010849 BY SD3 5 (POS 02) AT 07:13:13
Dispatch:[SD8]- NATURE: FALLS/BACK INJURY (TRAUMATIC) LOCATION: 164 W HOUCK ST SUITE: 109 CENTERBURG BETWEEN N PRESTON ST / WILL IS ST COMMENTS: FEMALE HAS FALLEN
Dispatch:[SD24]- NATURE: UNCONCIOUS/PASSING OUT (NONTRAUMATI LOCATION : 164 W HOUCK ST SUITE: 112 CENTERBURG BETWEEN N PRESTON ST / WILLIS ST COMMENTS: PROQA MEDICAL: NEW CASE NUMBER ASSIGN ED CALL 11-1010741 BY SD24 (POS 01) AT 08:13:03 88 YOM UNRE SPONSIVE//BREATHING AT THIS TIME

Fairfield County, OH
[DIS44]- NATURE: ACAL LOCATION: 114 ACADEMY ST PLEASANTV ILLE BETWEEN S MAIN ST / LINCOLN AV COMMENTS: NO APT GIVENGENDERAL FIRE -DIS44 Fairfield 911
[DIS15]- NATURE: S29 LOCATION: 2295 ELDER RD NE PLEASAN T TWP BETWEEN US RT 22 / BERRY RD COMMENTS: 67 YOF SEVERE A BD & SIDE PAINS. -DIS15 Fairfield
[DIS20]- NATURE: C4 LOCATION: 4815 OLD MILLERSPORT RD NE PLEASANT TWP BETWEEN OLD MILL RD / CARROLL-EASTERN RD CO MMENTS: REF TO 2 VEHICLES, 1 INTO CO
[DIS45]- NATURE: S29 LOCATION: 2890 LANCASTER-THORNVILL E RD NE PLEASANT TWP BETWEEN PLEASANT WAY / COONPATH RD AC CESS BY ST RT 188 COMMENTS: 44 YOM
[DIS48]- NATURE: C28 LOCATION: 206 MARKET ST PLEASANTVI LLE BETWEEN W WALNUT ST / S MAIN ST COMMENTS: PILE OF LEAVE S 4-5 FT FROM A STRUCTURE ---SEEMS
[DIS45]- NATURE: C28 LOCATION: COONPATH RD NW / LANCAST ER-KIRKERSVILLE RD NW GREENFIELD TWP BETWEEN CLAYPOOL DR / DEAD END COMMENTS: CALLER IS ADV TH
[DIS19]- NATURE: C4 LOCATION: COONPATH RD NW / ELECTIO N HOUSE RD NW GREENFIELD TWP BETWEEN CLAYPOOL DR / DEAD END COMMENTS: REF TO 2 VEHICLES..UNKNOW
[DIS50]- NATURE: C4 LOCATION: 4496 CINCINNATI-ZANESVIL LE RD NE PLEASANT TWP BETWEEN IRELAND ROAD / SNOKE HILL RD ACCESS BY US RT 22 COMMENTS: +039.73
[DIS40]- NATURE: S29 LOCATION: 6570 MC CLEERY RD NW LIB ERTY TWP BETWEEN LEONARD RD / PLEASANTVILLE RD COMMENTS: 38 YOM WITH SEVERE ABDOMINAL PAIN -DI

 */


public class DispatchEmergitechParser extends FieldProgramParser {
  
  private Pattern markerPattern;
  int extraSpacePos;
  
  public DispatchEmergitechParser(String prefix, int extraSpacePos,
                           String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
           "NATURE:CALL! LOCATION:ADDR/S! BETWEEN:X? COMMENTS:INFO");
    markerPattern = Pattern.compile("^" + prefix + "\\[([A-Z0-9]+)\\]- ");
    this.extraSpacePos = extraSpacePos;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = markerPattern.matcher(body);
    if (!match.find()) return false;
    data.strUnit = match.group(1);
    
    // If extraSpacePos is positive, the extraneous blank is found in a fixed
    // position relative to the message text
    if (extraSpacePos > 0) body = removeBlank(extraSpacePos, body);
    
    // Carry on with more normal adjustments
    body = body.substring(match.end()).trim().replace(" BETWEEN ", " BETWEEN: ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  private class AddressField extends FieldProgramParser.AddressField {
    @Override
    public void parse(String field, Data data) {
      if (extraSpacePos < 0) field = removeBlank(-extraSpacePos, field);
      super.parse(field, data);
    }
  }


  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new AddressField();
    return super.getField(name);
  }

  /**
   * This method has the unenviable job of remove a extraneous blank that the
   * message service insists on putting in a a fixed position in the string
   * @param pos fixed field position where blank may be inserted
   * @param field field which has the inserted blank
   * @return field with extraneous blank removed
   */
  private String removeBlank(int pos, String field) {
    
    // If field doesn't extend position, or character in that position is
    // not a blank, we don't have to do anything.
    if (field.length() <= pos || field.charAt(pos) != ' ') return field;
   
    // Get the word in front of this blank, if it is a recognized dictionary
    // word, don't mess with it
    int pt = field.lastIndexOf(' ', pos-1);
    if (pt < 0) pt = -1;
    String word = field.substring(pt+1,pos);
    if (isDictionaryWord(word)) return field;
   
    // Ditto for word in back of this blank
    pt = field.indexOf(' ', pos+1);
    if (pt < 0) pt = field.length();
    word = field.substring(pos+1,pt);
    if (isDictionaryWord(word)) return field;
   
    // Otherwise, assume this is an extraneous blank and remove it
    field = field.substring(0,pos) + field.substring(pos+1);
    return field;
  }
}
