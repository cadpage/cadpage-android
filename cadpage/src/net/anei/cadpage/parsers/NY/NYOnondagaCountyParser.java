package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Onondaga County, NY
Contact: Andrew Clark <ajc0079@gmail.com>
Sender: e9web1@ongov.net
[CAD MSG POF 18:04:47 7461 BROADFIELD RD TPO XTS:SWEET RD] HENNEBERRY RD,  , UNCP - P:1 Lev:0 X:  TWCBL BUSHNECK, JOHN VOIP 02/14 18:03:57 911 CC RE 1 YO UNCP/NOT BREATH IS CON. IS BREATHING A LITTLE BIT FACE IS A LITTLE BLU  Disp: 51C1,51C2,51C3,51C4,51RP51,5

Onondaga County, NY
Contact: Al Pola <alpola828@gmail.com>

....(Skaneateles Fire) I/CAD MSG SKF 22:14:04 3104 W Lake Rd TSK XTS: FIRE LANE 9/THE LANE, , WIRE -E P:1 Lev:0 X: M911 - CC - Electric Wire Against A Tree - Is arcing and sparking - compl has no power now Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1
....(Skaneateles Fire) I/CAD MSG CAYFC 22:28:30 3801 SWARTOUT RD  OTOW CAY XTS:MARTIN RD/CEDAR SWAMP RD,  , FIRE -R P:1 Lev:0 X: 54C5 AND E 11 ER - ACTIV
....(Skaneateles Fire) I/CAD MSG SKF 01:07:57  3150 W LAKE RD TSK XTS:BENSON RD/ANDREWS RD, , ALRM -C P:1 Lev:0 X: COUNTY FIRE- OPERATOR#1144-#800-932-93
(Skaneateles Fire) I/CAD MSG SKF 09:42:52  52 W GENESEE ST  VSK XTS:W LAKE ST/GRIFFIN ST,  , FIRE -E P:1 Lev:0 X: LINDSEY, CRAIG &amp; JUDITH  RESD 01/03 9:41:18  911 CC: CALLER SAYS SMELLS LIKE SOMETHING ELECTRICAL IS BURNING  Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54TK1
(Skaneateles Fire) I/CAD MSG SKF 17:58:51 1563 NEW SENECA TPKE  TSK XTS: LUCINDA DR/KNIGHTSBRIDGE RD,  , FIRE -F P:2 Lev:0 X:TWCBL MCGEE, KAREN VOIP 01/02 17:57:49  Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54SD1, CFCTAC3
(Skaneateles Fire) I/CAD MSG SKF 16:03:15  4061 STATE STREET RD TSK: EST XTS: JEWETT RD/OLD SENECA TPKE,  , MVC -IB P:1 Lev:0 X: NW SECTOR -076.426885 042.968098 01/06  16:02:26 VEH IN A DITCH IS SMOKING Disp:38RP1, 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1, 54TK1
(Skaneateles Fire)  I/CAD MSG SKF 16:52:38 2745 E LAKE RD TSK: @SKANEATELES SAILING CLUB XTS:BUFFS BLUFF RD/COON HILL RD, , LOCK -R P:2 Lev:0 X:  M911 CC RE LOCKED IN THE BLDG -- COMPL USES A WALKER AND IS UNABLE TO MOVE  Disp: 54E21, 54MI1, 54R1, 54TK1
(Skaneateles Fire) I/CAD MSG SKF 04:37:24  110 FENNELL ST VSK XTS:PACKSWOOD PL/OLD SENECA TPK, APT B IN BACK, UNCP - P:1 Lev:0 X: M911//88 YO MALE UNCP/NOT BREATHING// IS AN EXPECTED DEATH// HAS BEEN ILL FOR SOME TIME// REQ NO LIGHTS AND SIRENS// Disp: 54C1, 54C2, 54C3, 54E12

*/


public class NYOnondagaCountyParser extends FieldProgramParser {

  private static final Pattern MARKER = Pattern.compile("^(?:I/)?CAD MSG ([A-Z]+) +(\\d\\d:\\d\\d:\\d\\d) +");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "OTOW","OWASCO",
      "TPO", "POMPEY",
      "TSK", "SKANEATELES",
      "VSK", "SKANEATELES"
  });

  public NYOnondagaCountyParser() {
    super(CITY_CODES, "ONONDAGA COUNTY", "NY",
           "ADDR/SXP! XTS:X! P:PRI! Lev:SKIP X:INFO Disp:UNIT%");
  }
  
  @Override
  public String getFilter() {
    return "e9web1@ongov.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Some services split message into subject and message
    if (subject.startsWith("CAD MSG")) {
      body = subject + " " + body;
    }
    
    // Make sure pages starts with initial marker
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1);
    data.strTime = match.group(2);
    body = body.substring(match.end());
    
    // Drop line breaks and duplicate blanks
    body = body.replace('\n', ' ').replaceAll("  +", " ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC TIME " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String sPlace = "";
      int pt = field.indexOf(':');
      if (pt >= 0) {
        sPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (sPlace.startsWith("@")) sPlace = sPlace.substring(1).trim();
      }
      super.parse(field, data);
      data.strPlace = append(data.strPlace, " / ", sPlace);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(", ,");
      if (pt >= 0) {
        data.strCall = field.substring(pt+2).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "X CALL";
    }
  }

  // Remove redundant date/time from info field
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b\\d\\d/\\d\\d \\d\\d:\\d\\d:\\d\\d:\\b");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.find()) {
        field = append(field.substring(0,match.start()).trim(), " ", field.substring(match.end()));
      }
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
}
	