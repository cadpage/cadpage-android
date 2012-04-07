package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Howard County, MD
Contact: "Committee, Equipment" <equipment@fdvfd.com>
Contact: "McNeece, John" <jmcneece@mfri.org>
Sender: Rc.261@c-msg.net

[CAD] RT 32/LINDEN CHURCH RD WS CLK TYPE: RESCUE--UNKNOW @ 23:29:39 BEAT/BOX: 032119
[CAD] 14470 TRIADELPHIA MILL RD DYTN TYPE: WIRES-WIRES @ 13:52:21 BEAT/BOX: 0540
[CAD] 6005 DAYBREAK CIR CLK: @RIVER HILL VC TYPE: LOCKV-ANIMAL @ 12:13:57 BEAT/BOX: 0501
[CAD] 6348 MORNING TIME LN WCOL TYPE: MEDICAL-BLS-COLD @ 13:59:49 BEAT/BOX: 0561
[CAD] RT 32/ROSEMARY LN ECW TYPE: RESCUE--UNKNOW @ 06:03:24 BEAT/BOX: 032145
[CAD] 12700 HALL SHOP RD HIGH: @SAINT MARKS EPISCOPAL CHURCH TYPE: GASLEAK-OUTSIDE/FIRE @ 01:28:32 BEAT/BOX: 0564
[CAD] 5764 STEVENS FOREST RD ECOL,111: @GRANDE POINT APARTMENTS TYPE: SMOKE-INSIDE/HIGHOCC @ 23:28:39 BEAT/BOX: 0908
[CAD] 14101 HOWARD RD DYTN: @SMITH RESIDENCE TYPE: MEDICAL-*********** @ 08:30:53 BEAT/BOX: 0545
(CAD) [CAD] EVENT: F11023456 7110 MINSTREL WAY ECOL: @BRIGHTON GARDENS TYPE: SMOKE-INSIDE/HIGHOCC @ 10:38:22 BEAT/BOX: 1034
(CAD) [CAD] EVENT: F11023457 RT 29 SB/RIVERS EDGE RD SCOL TYPE: RESCUE--UNKNOW @ 10:56:54 BEAT/BOX: 029086

Contact: support@ctive911.com
Sender: rc.446@c-msg.net
(hCAD) [!] EVENT: F12009425 10162 BRACKEN DR ECW: @LEE RESIDENCE: @GLANCEY RESIDENCE TYPE: MEDICAL-ALSA/PD-HOT @ 01:16:08 BEAT/BOX: 0810
(hCAD) [!] EVENT: F12009429 8789 FREDERICK RD EC TYPE: MEDICAL-ALSA-HOT @ 03:26:18 BEAT/BOX: 0212
(hCAD) [!] EVENT: F12009429 8789 FREDERICK RD EC TYPE: MEDICAL-*********** @ 03:26:18 BEAT/BOX: 0212
(hCAD) [!] EVENT: F12009443 3004 NORTH RIDGE RD EC,H217: @HEARTLANDS COMM CTR & ASST LVG TYPE: MEDICAL-*********** @ 09:36:10 BEAT/BOX: 0241
(hCAD) [!] EVENT: F12009444 8450 BALTIMORE NATIONAL PK WB EC: @NORMANDY SHOPPING CENTER TYPE: CHECK-ALS/PD-COLD @ 09:38:57 BEAT/BOX: 0243
(hCAD) [!] EVENT: F12009444 8450 BALTIMORE NATIONAL PK WB EC: @NORMANDY SHOPPING CENTER TYPE: CHECK-ALS/PD-COLD @ 09:38:57 BEAT/BOX: 0243
(hCAD) [!] EVENT: F12009454 MARYLAND AVE/SAINT PAUL ST EC TYPE: LOCKV-ANIMAL @ 11:19:38 BEAT/BOX: 0214
(hCAD) [!] EVENT: F12009456 8766 CLOUDLEAP CT ECOL,T3 TYPE: MEDICAL-*********** @ 11:42:28 BEAT/BOX: 0919
(hCAD) [!] EVENT: F12009456 8766 CLOUDLEAP CT ECOL,T3 TYPE: MEDICAL-BARIATRIC @ 11:42:28 BEAT/BOX: 0919
(hCAD) [!] EVENT: F12009458 10300 LITTLE PATUXENT PKWY WB WCOL,D300: @SEARS TYPE: BRUSH-BRUSH @ 11:59:01 BEAT/BOX: 0701
(hCAD) [!] EVENT: F12009459 4150 MONTGOMERY RD EC: @STATION 2 TYPE: VEHICLE-AUTO @ 12:04:50 BEAT/BOX: 0201
(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC: @TIBER HUDSON SENIOR HOUSING TYPE: ALFIRE-BUSC @ 12:09:06 BEAT/BOX: 0213
(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC: @TIBER HUDSON SENIOR HOUSING TYPE: ALFIRE-BUSC @ 12:09:06 BEAT/BOX: 0213
(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC,100: @TIBER HUDSON SENIOR HOUSING TYPE: SMOKE-INSIDE/HIGHOCC @ 12:09:06 BEAT/BOX: 0213
(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC,100: @TIBER HUDSON SENIOR HOUSING TYPE: SMOKE-INSIDE/HIGHOCC @ 12:09:06 BEAT/BOX: 0213
(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC,100: @TIBER HUDSON SENIOR HOUSING TYPE: SMOKE-INSIDE/HIGHOCC @ 12:09:06 BEAT/BOX: 0213
(hCAD) [!] EVENT: F12009464 3290 CENTENNIAL LN ECW: @ARBYS TYPE: MISC-noPD @ 12:48:31 BEAT/BOX: 0804
(hCAD) [!] EVENT: F12009466 BALTIMORE COUNTY CTNV: @BC4 TYPE: MUTAID-MAALS @ 13:17:25 BEAT/BOX: BC04
(hCAD) [!] EVENT: F12009470 11185 CHAMBERS CT WDSK,A TYPE: FIRE-APPLIANCE @ 13:24:48 BEAT/BOX: 0815
(hCAD) [!] EVENT: F12009470 11185 CHAMBERS CT WDSK,A TYPE: FIRE-APPLIANCE @ 13:24:48 BEAT/BOX: 0815
(hCAD) [!] EVENT: F12009479 3120 WHEATON WAY EC,J TYPE: MEDICAL-*********** @ 15:16:49 BEAT/BOX: 0243
(hCAD) [!] EVENT: F12009479 3120 WHEATON WAY EC,J TYPE: MEDICAL-ALSA-HOT @ 15:16:49 BEAT/BOX: 0243
(hCAD) [!] EVENT: F12009491 3410 PLUMTREE DR ECW: @SHANTY GRILL TYPE: MEDICAL-*********** @ 18:10:56 BEAT/BOX: 0208
 
*/

public class MDHowardCountyParser extends FieldProgramParser {
  
  public MDHowardCountyParser() {
    super(CITY_CODES, "HOWARD COUNTY", "MD",
           "ADDR/S! TYPE:CALL! BEAT/BOX:BOX!");
  }
  
  @Override
  public String getFilter() {
    return "Rc.261@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("CAD") && ! subject.startsWith("hCAD")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      boolean id = field.startsWith("EVENT: ");
      if (id) field = field.substring(7).trim();
      Parser p = new Parser(field);
      if (id) data.strCallId = p.get(' ');
      String sAddr = p.get(": @");
      data.strPlace = p.get().replace(": @", " - ");
      p = new Parser(sAddr);
      data.strApt = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ID " + super.getFieldNames() + " APT PLACE";
    }
  }
  
  private static final Pattern TRAIL_JUNK_PTN = Pattern.compile("-\\**$");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('@');
      if (pt < 0) abort();
      data.strTime = field.substring(pt+1).trim();
      field = field.substring(0,pt).trim();
      Matcher match = TRAIL_JUNK_PTN.matcher(field);
      if (match.find()) field = field.substring(0,match.start()).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ANNJ", "ANNAPOLIS JUNCTION",
      "BWI",  "BWI AIRPORT",
      "CLK",  "CLARKSVILLE",
      "COOK", "COOKSVILLE",
      "DYTN", "DAYTON",
      "EC",   "ELLICOTT CITY",
      "ECOL", "COLUMBIA",
      "ECW",  "ELLICOTT CITY",
      "ELK",  "ELKRIDGE",
      "FULT", "FULTON",
      "GLNG", "GLENELG",
      "GLWD", "GLENWOOD",
      "HANR", "HANOVER",
      "HIGH", "HIGHLAND",
      "JSSP", "JESSUP",
      "LAUR", "LAUREL",
      "MARR", "MARRIOTTSVILLE",
      "MTAR", "MOUNT AIRY",
      "SAVG", "SAVAGE",
      "SCOL", "COLUMBIA",
      "SYKE", "SYKESVILLE",
      "WCOL", "COLUMBIA",
      "WDBN", "WOODBINE",
      "WDSK", "WOODSTOCK",
      "WF",   "WEST FRIENDSHIP",
     
  });
}
