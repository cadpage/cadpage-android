package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Somers, NY (in Westchester County)
Contact: Patrick Jackson <patjackson52@gmail.com>
Conact: "David Luongo" <unleashedff248@gmail.com>

2011-000375 *** ALARM, CARBON MONOXIDE (Neg. Symptoms) *** RECINE, LUCIA 2 Corral Court SOMERS SOMERS TOA: 21:41 03/02/11 Somers FD Somers FD
2011-000382 *** Structure Fire (F.D.R. + Sirens) *** 13 GREENLAWN RD SOMERS SOMERS TOA: 00:16 03/04/11 Somers FD Somers FD HQ AMAWALK HOUSE
2011-000398 *** INSIDE ELECTRICAL HAZZARD (Pump Out/ Appliance Mal *** COHN, HENRIETTA 82 LAKE RD SOMERS SOMERS CS: RT 202 TOA: 21:51 03/06/11 Somers FD Som
2011-000397 *** Inside Smoke/Odor Investigation *** MELITO, ELIZABETH 112 WARREN ST SOMERS SOMERS TOA: 20:35 03/06/11 Somers FD Somers FD
2011-000496 *** Other Fire *** ANGLEBROOK GOLF CLUB L.P. 100 RT 202 SOMERS SOMERS CS: RT 139 C-3,4 TOA: 19:12 03/18/11 Somers FD Somers FD HQ GRANITE SPRING
2011-000493 *** Vehicle Fire *** 246 HERITAGE HILLS SOMERS SOMERS CS: RT 202 TOA: 12:18 03/18/11 Somers FD Somers FD AMAWALK HOUSE
2011-000514 *** P.I.A.A. / M.V.A (ALS) ***  MAHOPAC AVE SOMERS SOMERS CS: WATERGATE DR TOA: 21:15 03/23/11 Somers FD Somers FD HQ CAR INTO POLE
2011-000512 *** AUTOMATIC ALARM - RESIDENTIAL *** SALHA, FADY 62 HALLOCKS RUN SOMERS SOMERS CS: VORIS DR  / RT 202 TOA: 18:36 03/23/11 Somers FD Somers FD H
2011-000543 *** Stroke (C.V.A.) (ALS) *** 136 PRIMROSE LINCOLNDALE LINCOLNDALE TOA: 15:44 03/28/11 Somers FD Somers FD HQ 51 Y/O/F
2011-000550 *** Cardiac Arrest (ALS) *** SOMERS MANOR NURSING HOME 189 RT 100 KATONAH KATONAH CS: PLUMBROOK RD D-5 TOA: 06:10 03/29/11 Somers FD Somers FD H
2011-000467 *** Injuries from Fall (More than 10 ft) ALS *** COMMUNITY LIVING CORP 34 MOSEMAN AVE SOMERS SOMERS CS: ORCHARD RD  / SUN HILL RD TOA: 19:25 03/
2011-000507 *** Unknown Medical Emergency *** Lux, George ***MOS*** 61 JUNIPER DR LINCOLNDALE LINCOLNDALE TOA: 18:09 03/21/11 Somers FD Somers FD HQ SOMERS
2011-000504 *** Stand-by FIRE (In Quarters) *** 145 RT 118 SOMERS SOMERS TOA: 19:28 03/20/11 Somers FD Somers FD
2011-000503 *** Structure Fire (F.D.R. + Sirens) *** 112 HITCHING POST LN SOMERS SOMERS TOA: 19:23 03/20/11 Somers FD Somers FD HQ
2011-000502 *** Stand-by Fire (Other Agency's Quarters) *** 1916 COMMERCE ST SOMERS SOMERS TOA: 19:12 03/20/11 Somers FD Somers FD HQ
2011-000550 *** Cardiac Arrest (ALS) *** SOMERS MANOR NURSING HOME 189 RT 100 KATONAH KATONAH CS: PLUMBROOK RD D-5 TOA: 06:10 03/29/11 Somers FD Somers FD H
2011-000559 *** Injury, Leg *** 25 VALLEY POND RD SOMERS SOMERS TOA: 15:12 03/29/11 71 Y/O FEMALE 71 Y/O FEMALE Somers FD Somers FD HIP DISLOCATION
2011-000555 *** Stroke (C.V.A.) (ALS) *** HANSHAFT, RHONA 817 HERITAGE HILLS SOMERS SOMERS TOA: 11:10 03/29/11 Somers FD Somers FD 6696031

*/

public class NYSomersParser extends FieldProgramParser {
  
  private static final String[] CITY_LIST = new String[]{
    "LINCOLNDALE", "KATONAH", "SOMERS"
  };
  
  private static final Pattern MARKER = Pattern.compile("^(\\d{4}-\\d{6}) \\*\\*\\* (.+) \\*\\*\\* ");
  private static final Pattern TIME_DATE = Pattern.compile("^\\d\\d:\\d\\d \\d\\d/\\d\\d/\\d\\d ");
  
  public NYSomersParser() {
    super(CITY_LIST, "SOMERS", "NY",
        "ADDR CS:X? TOA:INFO");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    data.strCall = match.group(2);
    body = body.substring(match.end()).trim();
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strName = p.getOptional("***MOS***");
      if (data.strName.length() > 0) {
        parseAddress(StartType.START_ADDR, p.get(), data);
        return;
      }
      
      parseAddress(StartType.START_PLACE, field, data);
      if (data.strAddress.length() == 0) {
        data.strAddress = data.strPlace;
        data.strPlace = "";
      } else if (data.strPlace.contains(",")) {
        data.strName = data.strPlace;
        data.strPlace = "";
      }
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PLACE ADDR CITY";
    }
  }
  
  private class MyInfoField extends InfoField {

    @Override
    public void parse(String field, Data data) {
      Matcher match = TIME_DATE.matcher(field);
      if (match.find()) field = field.substring(match.end()).trim();
      field = field.replace("Somers FD", "").replaceAll("  +", " ").trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
    
  }
  
  @Override
  public String getProgram() {
    return "ID CALL " + super.getProgram();
  }
}
