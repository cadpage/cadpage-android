package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Lexington & Rockbridge Counties VA
Contact: Robert Jennette <robert.jennette@lexingtonfire.org>
Sender: @c-msg.net

[LCAD] Type: EMS-TRNSPORT Loc: 429 W NELSON ST Units: LXRS1, City: LEXINGTON 1/27/2011 2:10:08 PM SPORT. BRUSHY 1\nMessage Created 1/27/2011 2:10:00 PM
[LCAD] Type: EMS-PAIN Loc: GREEN HILL APT Units: LXRS1, City: LEXINGTON 1/27/2011 1:22:32 AM **Nearest Address: 475 FOREST GROVE RD, LEXINGTON49 YOF HAVING A PANIC ATTACK & CAN`T FEEL LEGS.OPERATE BRUSHY 1\nMessage Created 1/27/2011 1:22:00 AM
[LCAD] Type: EMS-FALL Loc: 431 W NELSON ST Units: CO09A,LR17, City: LEXINGTON 1/26/2011 5:39:37 PM **Nearest Address: 1305 ENFIELD RD, LEXINGTON38 YO MALE HIT A ROCK WALL GASHES SWELLING[01/26/2011 17:39:45 : pos1 : LHUCH]SLIDING WITH THE KIDS\nMessage Created 1/26/2011 5:45:00 PM
[LCAD] Type: EMS-FALL Loc: 431 W NELSON ST Units: LXRS1, City: LEXINGTON 1/26/2011 5:39:37 PM **Nearest Address: 1305 ENFIELD RD, LEXINGTON38 YO MALE HIT A ROCK WALL GASHES SWELLING\nMessage Created 1/26/2011 5:39:00 PM
[LCAD] Type: ACCIDENT MVC Loc: 60 WILLOW SPRINGS RD Units: LXRS2, City: LEXINGTON 1/26/2011 2:39:40 PM BLEEDING FROM HEAD AND ARM OTHER SIDE OF DAYS INN D2\nMessage Created 1/26/2011 2:39:00 PM
[LCAD] Type: ACCIDENT MVC Loc: MAURY RIVER RD Units: CO09A, City: LEXINGTON 1/26/2011 2:37:32 PM **Nearest Address: 1305 ENFIELD RD, LEXINGTONSINGLE VEHICLE OVERTURNED, APPROX 2 MILES LONGS CAMPGROUND\nMessage Created 1/26/2011 2:37:00 PM
[LCAD] Type: ACCIDENT MVC Loc: 81 SB 201 SB Units: B75,EM1,LXRS1,R73, City: FAIRFIELD 1/26/2011 2:23:09 PM **Nearest Address: NoneALTIMA GREY FEMALE BACK PAIN\nMessage Created 1/26/2011 2:34:00 PM
[LCAD] Type: ACCIDENT MVC Loc: 60 W 1/2 W DAYS INN AND SHELL STATION Units: CO09A,LXRS1, City: LEXINGTON 1/26/2011 12:55:37 PM **Nearest Address: NoneSILVER VAN SLID OFF ROAD OVER EMBANKMENT ON IT HIT TREES UNKNOWN INJURIES\nMessage Created 1/26/2011 12:56:00 PM
[LCAD] Type: EMS-HEM Loc: 160 KENDAL DR Units: LXRS1, City: LEXINGTON 1/26/2011 11:00:36 AM D FOR MALE RECTAL BLEED BORDEN CENTER RM106\nMessage Created 1/26/2011 11:00:00 AM

Contact: CodeMessaging
[CAD] Type: WELFARE CHK Loc: CAMERON HALL Units: LX08, City: LEXINGTON 7/10/2012 5:30:35 PM 079.487757ALI Y Coordinate: 037.788602**Nearest Address: 1305 ENFIELD RD, LEXINGTONMID THIRTIES OR FORTIES
[CAD] Type: SUSP VEHICLE Loc: SUNOCO PARKING LOT Units: BV27, City: BUENA VISTA 6/27/2012 1:52:16 AM E BEARING VA TAG XSN6982 IS PARKED ON THE SUNOCO LOT
[CAD] Type: EMS-PAIN Loc: 1139 DECATUR RD Units: FAIR1, City: FAIRFIELD 7/10/2012 5:00:24 PM PAIN 65 YO FEMALE
[CAD] Type: EMS-PAIN Loc: 1139 DECATUR RD Units: CO07A,FAIR1, City: FAIRFIELD 7/10/2012 5:00:24 PM PAIN 65 YO FEMALE
[CAD] Type: FIRE-SERVICE Loc: LEXINGTON Units: A11,E103,U2, City: LEXINGTON 7/10/2012 9:31:49 AM NGTON
[bvCAD] Type: EMS-FALL Loc: 3737 CATALPA AVE Units: BVRS1,CO10A, City: BUENA VISTA 6/25/2012 11:53:15 AM FROM FALLOPERATE BRUSHY 1
[bvCAD] Type: FIRE-WEATHER Loc: 28TH ST // CATALPA AVE Units: BVRS1,CO10A,COMM1, City: BUENA VISTA 6/25/2012 1:53:37 PM THER POWER OR PHONE LINE DOWN
[bvCAD] Type: EMS-TRNSPORT Loc: 3737 CATALPA AVE Units: BVRS1,CO10A, City: BUENA VISTA 7/18/2012 5:58:30 PM AKNESS OPERATE BRUSHY 1
[bvCAD] Type: FIRE-ALARM Loc: 401 N MAIN ST Units: CO04A,CO09A,CO10A, City: LEXINGTON 7/18/2012 6:22:40 PM MILandmark: CAMERON HALLFIRE ALARM SOUNDING OPERATE BRUSHY 1
[bvCAD] Type: WEATHER Loc: 2307 BEECH AVE Units: BVPD,CO10B,COMM1, City: BUENA VISTA 6/25/2012 1:40:52 PM TORAGE OF BLASTINGCAPS ON SITE ! ! ! !Landmark: VIRGINIA POWERPOWER LINE DOWN. IN ROADWAY. CARS TURNING AROUND.[06/25/2012 13:41:36 : pos4 : LHUCH]VA POWER ADVISED
[bvCAD] Type: FIRE-VEHICLE Loc: 253 E 34TH ST Units: CO10A, City: BUENA VISTA 7/5/2012 7:21:56 PM 079.357552ALI Y Coordinate: 037.729046**Nearest Address: 1553 SYCAMORE AVE, BUENA VISTAVEHICLE FIRE
[bvCAD] Type: EMS-TRNSPORT Loc: 3737 CATALPA AVE Units: BVRS1,CO10A, City: BUENA VISTA 7/4/2012 6:21:36 PM TAL STATUS//BRUSHY 1
[LCAD] Type: EMS-PAIN Loc: 1139 DECATUR RD Units: B75,FAIR1,LXRS1, City: FAIRFIELD 7/10/2012 5:00:24 PM PAIN 65 YO FEMALE[07/10/2012 17:01:25 : pos4 : LHUCH]CAVE HILL AND HYDE RD
[LCAD] Type: EMS-DIFF BRE Loc: 5695 W MIDLAND TRL Units: KCRS1,LR18,LXRS1, City: LEXINGTON 7/17/2012 10:07:06 AM NG CANCER PTOPERATE BRUSHY 1[07/17/2012 10:10:06 : pos4 : BARNOLD]CROSS STREETS OF JACK DANIELS LN AND PLOTT LN. ADDRESS IS OFF OF MOUNTAIN LUAREL TRL[07/17/2012 10:14:02 : pos4 : BARNOLD]CARILION NOT AVAILABLE
[LCAD] Type: EMS-HEART Loc: 55 COMFORT WAY Units: LXRS1, City: LEXINGTON 7/10/2012 3:27:25 PM RRAL STEAK HOUSEDR KERSCHALS OFFICE CHEST PAIN FEMALE 74 PREVIOUS HISTORY
[LCAD] Type: EMS-DIFF BRE Loc: 228 CATALPA PL Units: LR19, City: LEXINGTON 7/10/2012 1:43:26 PM NG FROM VAGINA SOME DIFF BREATHING 135531928

Contact: Dave Wheeler <wheelerdh@gmail.com>
S:LCAD M:[LCAD] Type: ACCIDENT MVC Loc: I-81 N BOUND Units: CO09A,LXRS1, City: LEXINGTON 8/14/2011 2:36:17 PM **Nearest Address: \n\n

Contact: Brent <brentaust18@gmail.com>
Sender: 411911
[CAD] Type: ACCIDENT MVC Loc: RD 11 CHURCH Units: FAIR1, City: FAIRFIELD 7/20/2012 3:16:56 AM 079.266657ALI Y Coordinate: 037.896663

 */

public class VALexingtonRockbridgeCountyParser extends FieldProgramParser {
  
  private static final Pattern DATE_TIME_PTN = 
    Pattern.compile(" \\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{2}:\\d{2} [A-P]M ");
  private static final Pattern SQ_BRACKETS_PTN = Pattern.compile(" *\\[.*\\] *");
  
  public VALexingtonRockbridgeCountyParser() {
    super("", "VA",
           "Type:CALL! Loc:ADDR! Units:UNIT! City:CITY!");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,411911";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.contains("CAD")) return false;
    
    // Strip off data field from end of message
    int pt = body.indexOf("\nMessage");
    if (pt > 0) body = body.substring(0, pt).trim();
    
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    String extra = body.substring(match.end()).trim();
    body = body.substring(0,match.start());
    
    // And parse what is left
    if (!parseMsg(body, data)) return false;
    
    // OK, now lets see what to make of the extra data
    String address2 = null;
    if (extra.startsWith("**Nearest Address:")) {
      extra = extra.substring(18).trim();
      if (extra.startsWith("None")) {
        extra = extra.substring(4).trim();
      } else {
        Parser p = new Parser(extra);
        address2 = p.get(',');
        extra = p.get();
        if (extra.startsWith(data.strCity)) extra = extra.substring(data.strCity.length()).trim();
      }
    }
    
    if (address2 != null && !address2.equals("None") && address2.length() > 0) {
      if (checkAddress(data.strAddress) == 0) {
        data.strPlace = data.strAddress;
        data.strAddress = address2;
      }
    }
    
    extra = SQ_BRACKETS_PTN.matcher(extra).replaceAll(" ");
    data.strSupp = extra;
    return true;
  }

  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE INFO";
  }
}
