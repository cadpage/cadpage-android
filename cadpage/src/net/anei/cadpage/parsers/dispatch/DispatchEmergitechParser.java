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

Highland County, OH
Dispatch:[SWM]- NATURE: INJURED LOCATION: 930 MOXLEY RD PAINT TWP ROS S COU COMMENTS: 63 YEAR OLD MALE FALLEN FROM LADDER APPORX 6 FEET, LANDED IN A ROCK BED. POSSIBLE SHOULDER INJURY, IS AL ERT AND TALKING. USE DRIVEWAY THAT GOES TO BASEME
Dispatch:[DAB]- NATURE: CHEST PAINS LOCATION: 10714 HIAWATHA RD PAINT TWP COMMENTS: 55YOM CP/DIB
Dispatch:[CTC]- NATURE: DIFFICULTY IN BREATHING LOCATION: 222 MCCLAIN AV GREENFIELD COMMENTS: 22 YOA FEMALE ASTHMA ATTACK TOT 2 155HRS
Dispatch:[TSC]- NATURE: STROKE LOCATION: 10606 LONG JOHN SILVER TL PA INT TWP COMMENTS: 26 YOA FEMALE POSS STROKE TOT 2017HRS
Dispatch:[TSC]- NATURE: ASSAULT LOCATION: 658 LYNDON AVE GREENFIELD C OMMENTS: SUBJ ASSAULTED TOT 2013HRS
Dispatch:[TSC]- NATURE: CHEST PAINS LOCATION: 7107 STATE RTE 753 PAIN T TWP BETWEEN MC COPPIN MILL RD / U S RTE 50 COMMENTS: 51 Y OA FEMALE CHEST PAIN TOT 1655HRS
Dispatch:[CTC]- NATURE: GENERAL ILLNESS LOCATION: 209 MCCLAIN AV SUIT E: G GREENFIELD COMMENTS: ELDERLY FM GENERAL ILLNESS
Dispatch:[CTC]- NATURE: AGENCY ASSIST LOCATION: 11542 STATE RTE 41 FA YETTE COUNTY COMMENTS: MUTUAL AID W/FAYETTE COUNTY SQUAD ON MVA W/INJURIES. TOT 1638HRS
Dispatch:[RBY]- NATURE: FALLEN LOCATION: 213 S 7 ST GREENFIELD COMMEN TS: +039.365859 -083.392861 28 YOA AMLE FALLEN FROM LADDER, NOW AT HOME
Dispatch:[TSC]- LOCATION: 10917 NORTH SHORE DR PAINT TWP BETWEEN ROB INHOOD LN / EAST LAKE SHORE DR COMMENTS: MALE CHEST & STOMAC H PAINS TOT 1235HRS
Dispatch:[JAV]- NATURE: SUICIDE LOCATION: 11510 LOCH NESS DR PAINT TW P COMMENTS: MALE ATTPT TO HANG HIMSELF
Dispatch:[CTC]- NATURE: FALLEN LOCATION: 7371 BEECHWOOD RD PAINT TWP BETWEEN LOIS LN / U S RTE 50 COMMENTS: ELDERLY FM FALLEN
Dispatch:[RBY]- NATURE: INJURED LOCATION: 200 N 11 ST SUITE: APT 5 GR EENFIELD COMMENTS: 24 YOA FEMALE RE-INJURIED DISLOCATED KNEE
Dispatch:[RDM]- NATURE: FALLEN LOCATION: 6262 STATE RTE 753 HILLSBORO BETWEEN SPARGER LN / MCCOPPIN MILL RD COMMENTS: 74 YO MALE
Dispatch:[RBY]- NATURE: AGENCY ASSIST LOCATION: 204 N EAST ST HILLSBO RO COMMENTS: MUTAL AID STATION COVERAGE '
Dispatch:[DAB]- NATURE: ELECTRICAL SHOCK LOCATION: 209 E MAIN ST LEES BURG COMMENTS: 37 YOF
Dispatch:[SLR]- NATURE: OVERDOSE LOCATION: 451 SOUTH ST GREENFIELD CO MMENTS: FEMALE GOING CRAZY. UNKNOWN IF IT IS OD OR NOT
Dispatch:[JAV]- NATURE: CHEST PAINS LOCATION: 10817 HIAWATHA RD PAINT TWP COMMENTS: +039.192717 -083.494806 CF= 90% 55 YR OLD MA LE CHEST PAINS
Dispatch:[RBY]- NATURE: GENERAL ILLNESS LOCATION: 6641 PIED PIPER PKW Y PAINT TWP COMMENTS: 84 YO MALE LIGHT HEADED
Dispatch:[JAV]- NATURE: INJURED LOCATION: 7163 LAZY TR PAINT TWP COMM ENTS: +039.167719 -083.493068 42 YR OLD FEMALE DOG BITE RIG HT ARM BLEEDING BAD
Dispatch:[JAV]- NATURE: MUTUAL AID LOCATION: 494 GORMLEY RD FAYETTE C OUNTY COMMENTS: +039.200753 -083.506200 70 YR OLD MALE DIFF ICULTY BREATHING
Dispatch:[JAV]- NATURE: SEIZURE LOCATION: 850 NELLIE ST GREENFIELD CO MMENTS: MALE HAVING SEIZURES
Dispatch:[RDM]- NATURE: GENERAL ILLNESS LOCATION: 6599 MC COPPIN MILL RD SUITE: 28 HILLSBORO COMMENTS: 29 YO FEMALE

 */


public class DispatchEmergitechParser extends FieldProgramParser {
  
  private Pattern markerPattern;
  int extraSpacePos;
  
  public DispatchEmergitechParser(String prefix, int extraSpacePos,
                           String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
           "NATURE:CALL? LOCATION:ADDR/SXN! BETWEEN:X? COMMENTS:INFO");
    markerPattern = Pattern.compile("^" + prefix + "\\[([A-Z0-9]+)\\]- ");
    this.extraSpacePos = extraSpacePos;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = markerPattern.matcher(body);
    if (!match.find()) return false;
    data.strUnit = match.group(1);
    
    // If extraSpacePos is positive, the extraneous blank is found in a fixed
    // position relative to the message text.  Also check for keywords that
    // might get split with one side looking like a real word
    if (extraSpacePos > 0) {
      body = removeBlank(extraSpacePos, body);
      body = body.replace(" CO MMENTS:", " COMMENTS:");
    }
    
    // Carry on with more normal adjustments
    body = body.substring(match.end()).trim().replace(" BETWEEN ", " BETWEEN: ");
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
      if (data.strCall.length() == 0) return false;
    }
    return true;
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
