package net.anei.cadpage.parsers.MT;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
 **********************************************************
Lewis and Clark County, MT
Contact: "Scott OConnell" <soconnell@ci.helena.mt.us> (911 System admin)
Contact: 4064598617@vzwpix.com, Bryan Backeberg <bbackeberg.bb@gmail.com>
Sender: Varies
Address will start with "U:" if unverified by CAD system

UNITS:#759\nCFS:112210-49\nTYP:Parking complaint\nLOC:1259 N ROBERTS ST\nBUSN:\nAPT:\nCMP:jane blatch\nPHONE:     555-6489\nCMNTS: WHITE TOYOTA PC PARKED BLOCKING ALLEY\nMAP: MAP P10\nMAP: COP6\nMAP: MAP K10
UNITS:#535\nCFS:112210-47\nTYP:Suspicious Circum/Persons/Veh\nLOC:3370 CB LOOP\nBUSN:\nAPT:\nCMP:JOHN MELCHER\nPHONE:     439-1234\nCMNTS: COMP SAID HIS DOGS WERE NOT OUT AND FEELS HE IS BEING HARASSED BY 595\nCOMP REPORTS 595 TOLD HIM HIS DOGS WERE OUT AND 595 CAME ONTO HIS PROPERTY\nMAP: MAP P10
UNITS:557 #539\nCFS:112210-48\nTYP:Juvenile Codes\nLOC:GREEN MEADOW DR and W CUSTER AVE\nBUSN:\nAPT:\nCMP:JOHN DOE\nPHONE:     465-1234\nCMNTS: [557]CRT 10-97 MTG W/ALYSSA\n730 EM  32427.5\n754 WILL BE FOLLOWING 730 TO HOSPITAL\n730 TRANSPORTING AND I AM FOLLOWING\n730 SM 32425.3\nPER 730 THEY WILL TPORT ALYSSIA\n[557]OUT W/MHP127\nMHP STOPPED AT LYNDALE / RODNEY\n[557]WILL BE 10-85 TO ST PETES\nMHP127 ADV MELISSA IS HITTING HER FATHER\nCOMP REQ 722 COME TO E
HELENA 911 (CAD Page for CFS 011211-37) UNITS:EVAFR/EHEFR STPH1\nCFS:011211-37\nTYP:MEDICAL CALLS\nLOC:3816 WYLIE DR\nBUSN:\nAPT:\nCMP:harvey marshall\nPHONE:     (406)459-0683\nCMNTS: COMP REPORTS THAT HIS SON IS INSULIN DEP, IS CONSCIOUS AND BREATHING, BUT DOWN ON THE FLOOR\nMEDS: Med case 20110112112218-GMALSTRO Start\n       3180     CANYON FERRY RD - N S\nMAP: MAP P10\nMAP: MAP B18 TXT STOP to opt-out
HELENA 911 (CAD Page for CFS 020611-6) UNITS:EVAFR/EHEFR 519 510 5A3\nCFS:020611-6\nTYP:MEDICAL ALARM\nLOC:213 E PACIFIC ST\nBUSN:\nAPT:\nCMP:MARCUS-LIFE LINE\nPHONE:     888-289-2018\nCMNTS: REQ WELFARE CHECK\n45 YOF PUSHED LIFE LINE ** NOT RESPONDING\nMAP: MAP P10 TXT STOP to opt-out

*/
public class MTLewisAndClarkCountyParser extends FieldProgramParser {
  
  private static final String DEF_CITY = "LEWIS AND CLARK COUNTY";
  private static final String DEF_STATE = "MT";

  public MTLewisAndClarkCountyParser() {
    super(DEF_CITY, DEF_STATE,
           "UNITS:UNIT! CFS:ID! TYP:CALL! LOC:ADDR! BUSN:PLACE APT:APT CMP:NAME PHONE:PHONE CMNTS:INFO+ MEDS:SKIP MAP:MAP+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.startsWith("HELENA 911 ")) body = body.substring(11).trim();
    if (body.length() == 0) return false;
    if (body.charAt(0) == '(') {
      int pt = body.indexOf(')');
      if (pt < 0) return false;
      body = body.substring(pt+1).trim();
    }
    
    int pt = body.indexOf(" TXT STOP");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return super.parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("U:")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("MAP ")) field = field.substring(4).trim();
      data.strMap = append(data.strMap, " - ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
}
