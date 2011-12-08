package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.SmsMsgInfo.Data;


/* 
 * Chester County, PA
Contact: "buckhunter1113@aol.com" <buckhunter1113@aol.com>
Sender: gallison39@comcast.net

Initial Type: ACCINJA    Final Type:ACCINJA (ACCIDENT - INJURIES / ALS *)\nLoc: W BALTIMORE PK/SCARLETT RD ,60    (V) AKA:
Initial Type: BFALL      Final Type: BFALL   (FALLS - BLS / LIFT ASSIST *)\nLoc: 118 RACE ST ,03 -- RACE PARK APTS btwn E STATE ST & E C
Initial Type: BSICK      Final Type: BSICK   (SICK PERSON - BLS *)\nLoc: 415 MEGAN CT ,62  btwn VICTORIA GARDENS DR & AZALEA LA (V) AKA
Initial Type: ACVA       Final Type: ACVA    (CVA/STROKE - ALS *)\nLoc: 509 HAZEL AV ,03  btwn N WALNUT ST & WILSON RD (V) AKA:   Munic
Initial Type: ALARMF     Final Type: ALARMF  (ALARM - FIRE *)\nLoc: 100 E SOUTH ST ,03 -- KENNETT HIGH SCHOOL btwn S BROAD ST & CHURCH A
Initial Type: AOD        Final Type: AOD     (OVERDOSE - ALS *)\nLoc: 6 WAYS LA ,62  btwn MUNICIPAL BOUNDARY & E CYPRESS ST (V) AKA:
(Station 24 EMS Call) Initial Type: BSICK      Final Type: BSICK (SICK PERSON - BLS *)\nLoc: 301 VICTORIA GARDENS DR ,62 -- BRANDYWINE ASSISTED LIVNG btwn L

Contact: "Thomas A Dunbar" <tadunbar@verizon.net>
Sender: messaging@iamresponding.com
(Station 36) NOTIFFC    Final Type: NOTIFFC (NOTIFY FIRE CHIEF)\nLoc: 1351 SCOTT RD ,49  btwn MUNICIPAL BOUNDARY &amp; POWELL RD (V) \nAKA:   Municipali


 */


public class PAChesterCountyAParser extends PAChesterCountyBaseParser {
  
  public PAChesterCountyAParser() {
    super("Final_Type:CALL! Loc:ADDRCITY! btwn:X? AKA:INFO");
  }
  
  @Override
  public String getFilter() {
    return "gallison39@comcast.net,messaging@iamresponding.com";
  }


  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    data.strSource = subject;

    // Replace key chars for easier parsing
    body = body.replace("\n"," ");
    body = body.replace(" btwn "," btwn:");
    body = body.replace("(V)", "");
    body = body.replaceAll("  +", " ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" -- ");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+4).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
} 
