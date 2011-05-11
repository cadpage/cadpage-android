package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;


/*
WestChester County, NY
Contact: Paul Tortorella <ptort271@gmail.com>
Contact: Mike Ross <tmfdmike@gmail.com>
Sender: _IPAGE@westchestergov.com

Subject:IPage\n50 ELKAN RD MAMARONECK_T: @ELKAN APARTMENTS, Cross: PALMER AVE, Type:ALS, , Time out: 12:12:51 Area: LARCH,Alarm lev: 0 ,Comments:   DIFF BREATHING
Subject:IPage\nMAMARONECK_T: @I95 NB 07.1 EXIT 17 (CHATSWORTH AVE), Cross: , Type:MVA, INJURIES, Time out: 11:03:47 Area: LARCH,Alarm
Subject:IPage\n30 HALSTEAD PL RYE, Cross: ORMOND PL, Type:STRU, , Time out: 21:00:33 Area: RYE,Alarm lev: 1 ,Comments:   WPH1
Subject:IPage\nMADISON AVE/JEFFERSON ST MAMARONECK_T, Cross: MADISON AVE, Type:HAZARD, FLUID, Time out: 14:30:33 Area: MAMTW,Alarm
Subject:IPage\n35 N CHATSWORTH AVE MAMARONECK_T: @CARLTON HOUSE APARTMENTS, Cross: JEFFERSON ST, Type:ALARM, COMM, Time out: 19:27:55
Subject:IPage\n280 WEAVER ST MAMARONECK_T: @ST JOHN & PAUL SCHOOL, Cross: EDGEWOOD AVE, Type:ALARM, COMM, Time out: 23:48:57 Area: MAMTW,Alarm lev: 0 ,Comments:   GENERAL FIRE ALARM
Subject:IPage\n833 FENIMORE RD MAMARONECK_T, Cross: MOHEGAN RD, Type:ALARM, CO, Time out: 13:39:20 Area: MAMTW,Alarm lev: 0

// This one should go to general alert
Subject:IPage\n-073.684659 +040.978189   Duplicate Event:Location = HALSTEAD PL/ORMOND PL, Cross Street 1 = HALSTEAD PL   GARAGE FIRE   ORMOND PL, Cross Street 2 = ORMOND PL,
Subject:IPage\n,Comments:   UNKOWN IF SYMPROMS   PREMISE 914-834-7319\3sWILL NTFY KEYHOLDER   Duplicate Event:Location = 833 FENIMORE RD, Cross Street 1 = MOHEGAN RD AVON RD,

IPage / 4 DUDLEY LN MAMARONECK_T, Cross: FENIMORE RD, Type:ALARM, RESD, Time out: 09:42:46 Area: MAMTW,Alarm lev: 0 ,Comments:
IPage / 50 ELKAN RD MAMARONECK_T: @ELKAN APARTMENTS, Cross: PALMER AVE, Type:ALS, , Time out: 12:12:51 Area: LARCH,Alarm lev:
IPage / MAMARONECK_T: @I95 NB 07.3, Cross: , Type:MVF, CAR, Time out: 22:12:12 Area: MAMTW,Alarm lev: 0 ,Comments:
IPage / MAMARONECK_T: @I95 NB 07.1 EXIT 17 (CHATSWORTH AVE), Cross: , Type:MVA, INJURIES, Time out: 11:03:47 Area: LARCH,Alarm
IPage / 42 MAPLEWOOD ST MAMARONECK_T, Cross: MURRAY AVE, Type:SERVICE, LOCKOUT, Time out: 17:27:08 Area: MAMTW,Alarm lev: 0
IPage / 30 HALSTEAD PL RYE, Cross: ORMOND PL, Type:STRU, , Time out: 21:00:33 Area: RYE,Alarm lev: 1 ,Comments:   WPH1

*/


public class NYWestchesterCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "LARCH", "LARCHMONT",
      "MAMTW", "MAMARONECK",
      "RYE",   "RYE"
  });
  
  public NYWestchesterCountyParser() {
    super(CITY_CODES, "WESTCHESTER COUNTY", "NY",
           "ADDR Cross:X! Type:CALL! CALL Time_out:SKIP Area:CITY lev:PRI Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "_IPAGE@westchestergov.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Subject can passed as one of the standard encoding schemes.
    // If it wasn't, check for a non-standard subject encoding scheme
    if (subject.length() == 0) {
      int pt = body.indexOf(" / ");
      if (pt < 0) return false;
      subject = body.substring(0,pt).trim();
      body = body.substring(pt + 3).trim();
    }
    
    // Check for IPage signature
    if (!subject.equals("IPage")) return false;
    
    body = body.replace(" Area:", ",Area:");
    return parseFields(body.split(","), data);
  }

  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional(": @");
      data.strCity = p.getLast(' ');
      parseAddress(p.get(), data);
      if (data.strAddress.length() == 0) {
        data.strAddress = data.strPlace;
        data.strPlace = "";
      }
      if (data.strCity.endsWith("_T")) {
        data.strCity = data.strCity.substring(0,data.strCity.length()-2);
      }
      data.strCity = data.strCity.replace('_', ' ');
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
	