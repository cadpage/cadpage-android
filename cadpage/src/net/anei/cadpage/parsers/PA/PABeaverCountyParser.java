package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Beaver County, PA
Contact: "dchuff31@comcast.net" <dchuff31@comcast.net>
Contact: James F. McCarthy <jmccarthy@beavercountypa.gov> (CAD Administer)
Sender: bc911cad@beavercountypa.gov
System: Intergraph

EVENT #:F20110003039  LOC:251 HODGSON RD SOBE EST:  : @CRAWFORD CAMPGROUND TYPE:FIRE SERVICE CALL   TIME:10:07:00 COMMENTS:CALLER REPORTING TREE LAYING ON WIRES AND CATHING ON FIRE WIRES ARCHING AND SMOKING WILL BE BETWEEN THE HOUSE AND THE ENTRANCE TO THE CAMPGROUND
EVENT #:F20110002860  LOC:199 OLD BLACKHAWK RD SOBE EST:   TYPE:VEHICLE FIRE   TIME:18:04:16 COMMENTS:WPH1 -080.363317 +040.749160 VERIZON WIRELESS 165 LINDY ST SW SECTOR CHIPPEWA VEHICLE FIRE CLOSE TO A RESIDENCE. OPEN LINE. LAST CALLER SAID WAS THAT HE WAS GOING TO ATTEMPT TO PUSH VEHICLE AWAY FROM THE HOUSE. CALLER NOW ADVISING THAT VEHICLE IS AWAY FROM RESIDENCE. DUMP TK ...FULLY INVOLVED﻿
EVENT #:E20110009962  LOC:251 HODGSON RD SOBE EST:  : @CRAWFORD CAMPGROUND TYPE:PROBLEM UNKNOWN   TIME:14:29:41 COMMENTS:WPH2 -080.456572 +040.787076 VERIZON WIRELESS 663 GEORGETOWN RD SW SECTOR SOUTH_BEAVER 70/F UNRESPONSIVE IS BREATHING IS RESPONSIVE AT THIS TIME NOT ACTING﻿
EVENT #:F20110002971  LOC:GEORGETOWN RD/SPORTSMAN RD SOBE EST:   TYPE:FIRE OTHER   TIME:11:50:39 COMMENTS:OPS CH 2 UNK TYPE FIRE IN THE AREA  ﻿
DISPATCH ALERT, EVENT #:E20110009854  LOC:381 HODGSON RD SOBE EST:   TYPE:SEIZURES   TIME:16:37:23 COMMENTS:WPH2 -080.464897 +040.780531 VERIZON WIRELESS 150 BRADEN RD S SECTOR DARLINGTON_TWP 12 YO FEMALE PASSED OUT HAD A SEIZURE LASTED APPROX 2 MINUTES NO PMHX
EVENT #:F20110003486  LOC:911 3RD AVE NEWB,1 EST:  : @PRESSED 4 TIME TYPE:FIRE OTHER   TIME:12:15:18 COMMENTS:WPH2 -080.312933 +040.734053 WIRELESS-CRICKET(TCS) 780 DUQUESNE AVE NE SECTOR ROCHESTER_TWP MALE LEFT A POT ON THE STOVE AND IS LOCKED OUT OF THE APT. 
EVENT #:F20110003399  LOC:2020 3RD AVE NEWB EST:  : @BRIGHTWOOD MANOR APARTMENTS TYPE:FIRE ALARM   TIME:13:19:57 COMMENTS:FIRE OPS CH 6 WPH1 -080.298707 +040.709238 SPPCS CALL 1050 BEANER HOLLOW RD SE SECTOR BRIGHTON FIRE ALARM GOING OFF IN THE BUILDING 
EVENT #:F20110002408  LOC:921 3RD AVE NEWB: @HUNTINGTON BANK Type:BRUSH FIRE   TIME:17:16:07 COMMENTS:WPH1 -080.317933 +040.716823 T-Mobile USA, Inc. 1050 BEANER HOLLOW RD N SECTOR BRIGHTON MULCH IN FRONT OF BANK ON FIRE 
EVENT #:F20110001699  LOC:1517 6TH AVE NEWB: @BEAVER COUNTY REHABILITATION Type:FIRE ALARM   TIME:13:04:59 COMMENTS:FIRE ALARM GENERAL

 */


public class PABeaverCountyParser extends FieldProgramParser {
  
  public PABeaverCountyParser() {
    super(CITY_CODES, "BEAVER COUNTY", "PA",
           "EVENT_#:ID! LOC:ADDR/S! EST:SKIP? PLACE:PLACE? TYPE:CALL! TIME:TIME! COMMENTS:INFO");
  }
  
  @Override
  public String getFilter() {
    return "bc911cad@beavercountypa.gov,Beaver County 911";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("DISPATCH ALERT, ")) body = body.substring(16).trim();
    body = body.replace(": @", " PLACE:").replace(" Type:", " TYPE:");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strApt = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT";
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d:\\d\\d"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new TimeField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALIQ", "ALIQUIPPA",
      "AMBR", "AMBRIDGE",
      "BADE", "BADEN",
      "BEAV", "BEAVER",
      "BEAF", "BEAVER FALLS",
      "BELA", "BELL ACRES",
      "BIGB", "BIG BEAVER",
      "BRID", "BRIDGEWATER",
      "BRIG", "BRIGHTON TWP",
      "CENT", "CENTER TWP",
      "CHIP", "CHIPPEWA TWP",
      "CONW", "CONWAY",
      "DARB", "DARLINGTON BORO",
      "DARL", "DARLINGTON TWP",
      "DAUG", "DAUGHERTY TWP",
      "EROC", "EAST ROCHESTER",
      "EVAL", "EASTVALE",
      "ECON", "ECONOMY",
      "FALS", "FALLSTON",
      "FRDM", "FREEDOM",
      "FRFK", "FRANKFORT SPRINGS",
      "FRAN", "FRANKLIN ",
      "GEOR", "GEORGETOWN",
      "GLAS", "GLASGOW",
      "GREN", "GREENE TWP",
      "HANO", "HANOVER TWP",
      "HARM", "HARMONY TWP",
      "HMWD", "HOMEWOOD",
      "HKTW", "HOOKSTOWN",
      "HPWL", "HOPEWELL TWP",
      "INDE", "INDEPENDENCE TWP",
      "INDU", "INDUSTRY",
      "KOPP", "KOPPEL",
      "LETP", "LEET TWP",
      "MARI", "MARION TWP",
      "MIDL", "MIDLAND",
      "MONA", "MONACA",
      "NEWB", "NEW BRIGHTON",
      "NEWG", "NEW GALILEE",
      "NWSE", "NEW SEWICKLEY TWP",
      "NOSE", "NORTH SEWICKLEY TWP",
      "OHVL", "OHIOVILLE",
      "PRHT", "PATTERSON HEIGHTS",
      "PATT", "PATTERSON TWP",
      "POTT", "POTTER TWP",
      "PULA", "PULASKI TWP",
      "RACC", "RACCOON TWP",
      "ROCH", "ROCHESTER BORO",
      "ROCT", "ROCHESTER TWP",
      "SPPT", "SHIPPINGPORT",
      "SOBE", "SOUTH BEAVER TWP",
      "SOHT", "SOUTH HEIGHTS",
      "VANP", "VANPORT TWP",
      "WMYF", "WEST MAYFIELD",
      "WHIT", "WHITE"
  });
}
