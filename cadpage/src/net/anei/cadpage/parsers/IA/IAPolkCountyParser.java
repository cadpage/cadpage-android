package net.anei.cadpage.parsers.IA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Polk County, IA (Grimes Fire & Rescue)
Contact: angela brouwer <abrouwerdcg@gmail.com>
Sender: 777129998926

.... (Grimes) Location: 500 S JAMES ST GRIM: @SCHOOL - GRIM Type: STILL VEHICLE Caller:  Time: 19:47:24
.... (Grimes) Location: 101 SE DESTINATION DR GRIMES Type: MEDICAL  Caller: GRIMES FAMILY PHYSICIANS Time: 10:54:07
.... (Grimes) Location: 200 SW BROOKSIDE DR GRIM,111 Type: MEDICAL  Caller: KENNYBROOK VILLAGE Time: 13:42:46
.... (Grimes) Location: 5555 NW 55TH AVE JOHN: @CHILDSERVE - JOHN Type: COMMFIRE ALARM Caller: ADT/DBI Time: 17:01:43
.... (Grimes) Location: 2555 W 1ST ST GRIM: @DALLAS CENTER GRIMES HIGH SCHOOL - GRIM Type: COMMFIRE ALARM Caller: ADT Time: 20:37:32

Contact: Rich Davis <med1c@msn.com>
Sender: messaging@iamresponding.com
(PCFD) Location: 6015 NW 62ND AVE JOHN: @JOFD Type: MA MEDICAL Time: 13:46:40

Contact: support@active911.com
[CAD] Location: 819 WREN DR ALTO Type: MEDICAL  Caller: MCGINNIS,WILLIAM & DORIS Time: 15:48:02\n
[CAD] Location: 2ND AVE SW/5TH ST SW ALTO Type: RESCUE PIA Caller: REBER,JEFF Time: 16:05:56\n
[CAD] Location: 147 I80 WB HWY BEAV: @REST AREA WESTBOUND - BEAV Type: MEDICAL  Caller: ISP Time: 16:10:28\n
[CAD] Location: 147 I80 WB HWY BEAV: @REST AREA WESTBOUND - BEAV Type: MEDICAL  Caller: ISP Time: 16:10:28\n
[CAD] Location: 55 N HAWTHORN DR ALTO Type: MEDICAL  Caller: ELLIS,JEREMY Time: 19:49:36\n
[CAD] Location: 2100-B 2ND AVE SE ALTO Type: INVESTIGATION ALARM Caller:  Time: 20:57:05\n
[CAD] Location: 2100-B 2ND AVE SE ALTO Type: INVESTIGATION ALARM Caller:  Time: 20:57:05\n
[CAD] Location: 726 8TH ST SE ALTO,305: @CENTENNIAL PLACE APARTMENTS - ALTO Type: MEDICAL  Caller:  Time: 23:27:05\n
[CAD] Location: 407 3RD AVE SE ALTO Type: MEDICAL  Caller: VERHEUL,CHARLES B Time: 07:20:49\n
[CAD] Location: 912 8TH ST SW ALTO,22: @VENBURY TRAIL APARTMENTS - ALTO Type: MEDICAL  Caller: RITCHIE,LINDA Time: 07:16:40\n
[CAD] Location: 953 8TH AVE NW ALTO Type: MEDICAL  Caller: LIFELINE Time: 09:57:25\n
[CAD] Location: 500 5TH AVE SW ALTO,8D: @PRAIRIE VILLAGE OF ALTOONA - ALTO Type: MEDICAL  Caller: WILLIAMS, BILLY Time: 10:30:04\n
[CAD] Location: 500 5TH AVE SW ALTO,8D: @PRAIRIE VILLAGE OF ALTOONA - ALTO Type: MEDICAL  Caller: WILLIAMS, BILLY Time: 10:30:48\n
[CAD] Location: 5000-B NE HUBBELL RD DELA Type: RESCUE PIA Caller:  Time: 15:31:34\n
[CAD] Location: NE HUBBELL RD/NE 94TH AVE FRAN Type: RESCUE PIA Caller: ISP Time: 17:24:20\n
[CAD] Location: 507 13TH AVE SW ALTO: @LIONS PARK - ALTO Type: MEDICAL  Caller:  Time: 19:03:44\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 19:58:05\n
[CAD] Location: 612 5TH AVE SE ALTO Type: MEDICAL  Caller:  Time: 10:09:41\n
[CAD] Location: 612 5TH AVE SE ALTO Type: MEDICAL  Caller:  Time: 10:09:41\n
[CAD] Location: 114 CARTER ST SW MITC: @MITCHELL VILLAGE CARE CENTER - MITC Type: MEDICAL  Caller: MITCHELL VILLAGE CARE CENTER Time: 12:05:24\n
[CAD] Location: 200 6TH ST SW ALTO Type: STILL WIRES Caller:  Time: 13:41:01\n
[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller:  Time: 16:33:24\n
[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller: MARY Time: 16:34:34\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @CASINO - ALTO Type: MEDICAL  Caller: SECURITY Time: 16:38:27\n
[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller: MARY Time: 16:34:34\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @CASINO - ALTO Type: MEDICAL  Caller: SECURITY Time: 16:38:27\n
[CAD] Location: 950 VENBURY DR ALTO: @ALFD Type: MEDICAL  Caller:  Time: 17:15:58\n
[CAD] Location: 2719 14TH ST SW ALTO Type: MEDICAL  Caller:  Time: 17:23:40\n
[CAD] Location: 2719 14TH ST SW ALTO Type: MEDICAL  Caller:  Time: 17:24:35\n
[CAD] Location: 5285 NE MITCHELL DR BEAV Type: MEDICAL  Caller: BILLINGS,JO Time: 21:31:04\n
[CAD] Location: 1022 8TH ST SE ALTO Type: MEDICAL  Caller:  Time: 23:21:42\n
[CAD] Location: 1022 8TH ST SE ALTO Type: MEDICAL  Caller:  Time: 23:21:42\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 23:25:27\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 23:25:27\n
[CAD] Location: 1123 GREENWAY CT ALTO,B: @TRIPLE CROWN APARTMENTS - ALTO Type: MEDICAL  Caller:  Time: 05:11:37\n
[CAD] Location: 916 13TH STREET CIR SW ALTO Type: MEDICAL  Caller: LOZANO, NICHOLE Time: 09:12:25\n
[CAD] Location: 101 N HAWTHORN DR ALTO Type: RESDFIRE ASSIGN Caller:  Time: 11:23:59\n
[CAD] Location: 3501 8TH ST SW ALTO: @WALMART - ALTO Type: MEDICAL  Caller:  Time: 11:35:05\n
[CAD] Location: 3501 8TH ST SW ALTO: @WALMART - ALTO Type: MEDICAL  Caller:  Time: 11:35:05\n
[CAD] Location: 3231 ADVENTURELAND DR ALTO: @FLYING J - ALTO Type: MEDICAL  Caller: DEDENBERG,GREG Time: 05:25:19\n
[CAD] Location: 542 14TH AVE NW ALTO Type: MEDICAL  Caller:  Time: 07:04:27\n
[CAD] Location: 1006 6TH ST NW ALTO Type: MEDICAL  Caller: MINICK, SMITH Time: 07:56:13\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller: PRAIRIE MEADOWS RACETRACK AN Time: 10:02:39\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller: PRAIRIE MEADOWS RACETRACK AN Time: 21:15:43\n
[CAD] Type: RESCUE PIA Caller: VERIZON Time: 07:12:39\n
[CAD] Location: 3178 W 148TH ST S MITC Type: MEDICAL  Caller: JOHNSON,PAM Time: 08:43:40\n

 */

public class IAPolkCountyParser extends FieldProgramParser {
  
  public IAPolkCountyParser() {
    super(CITY_CODES, "POLK COUNTY", "IA",
           "Location:ADDR/S! Type:CALL! Caller:PLACE? Time:TIME!");
  }
  
  @Override
  public String getFilter() {
    return "7771,messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() == 0) return false;
    data.strSource = subject;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(": @");
      String place = "";
      if (pt >= 0) {
        place = field.substring(pt+3).trim();
        field = field.substring(0,pt);
        int pt1 = field.lastIndexOf(' ');
        int pt2 = place.lastIndexOf(' ');
        if (pt1 >= 0 && pt2 >= 0 && field.substring(pt1).equals(place.substring(pt2))) {
          place = place.substring(0,pt2).trim();
          if (place.endsWith("-")) place = place.substring(0,place.length()-1).trim();
        }
      }
      
      pt = field.lastIndexOf(',');
      String apt = "";
      if (pt >= 0) {
        apt = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      
      super.parse(field, data);
      
      if (place.endsWith(data.strCity)) {
        place = place.substring(0,place.length()-data.strCity.length()).trim();
      }
      if (place.endsWith("-")) place = place.substring(0,place.length()-1).trim();
      
      data.strApt = append(data.strApt, " - ", apt);
      data.strPlace = place;
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      data.strPlace = append(data.strPlace, " / ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALLE", "ALLEMAN",
      "ALLT", "ALLEN TWP",
      "ALTO", "ALTOONA",
      "ANKE", "ANKENY",
      "BEAV", "BEAVER TWP",
      "BLOO", "BLOOMFIELD TWP",
      "BOND", "BONDURANT ",
      "CAMP", "CAMP TWP",
      "CARL", "CARLISLE",
      "CLAY", "CLAY TWP",
      "CLIV", "CLIVE",
      "CROC", "CROCKER TWP",
      "DELA", "DELAWARE TWP",
      "DESM", "DES MOINES",
      "DOUG", "DOUGLAS TWP",
      "ELKH", "ELKHART",
      "ELKT", "ELKHART TWP",
      "FOUR", "FOURMILE TWP",
      "FRAN", "FRANKLIN TWP",
      "GRAN", "GRANGER",
      "GRIM", "GRIMES",
      "GRIMES", "GRIMES",
      "JEFF", "JEFFERSON TWP",
      "JOHN", "JOHNSTON",
      "LINC", "LINCOLN TWP",
      "MADI", "MADISON TWP",
      "MITC", "MITCHELLVILLE",
      "PLEA", "PLEASANT HILL",
      "POLK", "POLK CITY",
      "RUNN", "RUNNELLS",
      "SAYL", "SAYLOR TWP",
      "UNIO", "UNION TWP",
      "URBA", "URBANDALE",
      "WALN", "WALNUT TWP",
      "WASH", "WASHINGTON TWP",
      "WEBS", "WEBSTER TWP",
      "WDSM", "WEST DES MOINES",
      "WIND", "WINDSOR HEIGHTS"
  });
}
