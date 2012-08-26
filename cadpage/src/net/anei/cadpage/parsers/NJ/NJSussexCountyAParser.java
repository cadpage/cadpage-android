package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Sussex County, NJ (Bryam TWP FD)  (Sparta Dispatch - not entire county but 8 departments)
Contact:Todd Rudloff <btfd43capt2@gmail.com>

(I-B2011-004928) ALARMF @ 172 LACKAWANNA DRIVE  , BYRAM - PROTECTIVE SERVICES (800-633-2677) OPERATOR 1663. GENERAL FIRE.
[I-B2010-009210]  ALARMF @ 7 WATERLOO ROAD  , BYRAM - ALL AMERICAN CRAFT. ALARMS PLUS (800-932-3822) OPERATOR 1224. UTILITY ROOM
[I-B2011-004688]  FIRE @ 33 SLEEPY HOLLOW ROAD  , BYRAM - CALLER REPORTS HIS LIVING ROOM IS SMOKING.
(I-B2011-003217) FIREPD @ 4 MOUNTAIN AVENUE  , BYRAM - CALLER REPORTS THICK BLACK SMOKE COMING FROM THE RESIDENCE.
[I-B2011-000701]  FIRE @ 228 TOMAHAWK TRAIL  , BYRAM - STRUCTURE FIRE

Contact: Michael Rafferty <mpraff15@yahoo.com>
KBROWN@andpd (I-2011-000118) MVA-F @ DECKER POND ROAD/SUNSET DRIVE  , GREEN TWP - CAR VS GUARDRAIL - MINOR INJURIES.
KBROWN@andpd (I-2011-000121) MVA-F @ HIBLER ROAD/WINTERMUTE ROAD  , GREEN TWP - CALLER REPORTING MOTORCYCLE MVA -- CALLER STATES APPEARS NO L
dcrater@andpd (I-2011-000117) ASSIST-F @  OUT OF TOWN  ,  - 44 KISHPAUGH RD FULLY INVOLVED STRUCTURE
kwilson@andpd (I-2011-000099) BURN-F @ 1 SCENIC DRIVE  , GREEN TWP - permit: A-3251 burning all day ** DO NOT RESPOND**
jcasella@andpd (I-2011-000122) MVA-F @ 21 SUTTON ROAD  , GREEN TWP - CAR VS TREE
jragsdale@andpd (I-2011-000108) TRANSF @ 71 WOLFS CORNER ROAD  , GREEN TWP - MUNICIPAL BLDG CALLED- HAS PASSERBY ADV OF TRANSFORMER FIRE hasEML = false;

Contact: mpraff15 <mpraff15@gmail.com>
Sender: 6245
kbrown@andpd (I-2011-000155) PUMP @ 6 RAMSEY COURT  , FRELINGHUYSEN - WARREN COUNTY COMMUNICATIONS REQUESTING A PUMP OUT FOR THE FOOT OF WATER IN BASEMENT.
jcasella@andpd (I-2011-000194) MVA-F @  ROUTE 94  , GREEN TWP - \nin front of wilbur's country storE
JHOLMES@andpd (I-2011-000217) FUEL @ 231 PEQUEST ROAD  , GREEN TWP -

New Milford, NJ
Contact: Active911.com
Sender: miccom@nnjmicu.org <miccom@nnjmicu.org>
(I-2012-000063)FDPLANE @ 636 SCHAEFER AVENUE , ORADELL BORO - PLANE CRASH INTO HOT TUB TEST TEST TEST
(I-2012-000063)FFIRA @ 105 OLD NEW BRIDGE ROAD  , NEW MILFORD BORO - WATER FLOW ALARM AT ZANZARI'S 
(I-2012-000067)FBRSH @ 413 BOULEVARD  , NEW MILFORD BORO - 

Contact: Active911.com
Agency name: Oradell Fire Department Location: Oradell, NJ
Sender: @nwbcd.org 
(I-2012-000192) FFIRA @ 386 KINDERKAMACK ROAD  , ORADELL BORO - zone 2 apartment back
(I-2012-000193) FFIRA @ 549 CORBETT PLACE  , ORADELL BORO - 
(I-2012-000194) FFIRA @ 549 CORBETT PLACE  , ORADELL BORO - GENERAL

Contact: Active911
Agency name: Fort Lee Fire Department Location: Fort Lee, NJ 
Sender: @fortleepolice.org

(I-2012-000814) 1045F @ 1350 15TH STREET  , FORT LEE - garage, north and south, waterflow
(I-2012-000815) 1045F @ 250 HOYM STREET  , FORT LEE - 1ST FL HOYM SIDE
(I-2012-000816) 1045F @ 1616 PALISADE AVENUE  , FORT LEE - ZONE 0 AND 2ND FL MENS RM SMOKE
(I-2012-000817) 1045F @ 250 HOYM STREET  , FORT LEE - 2ND FL HOYM ST WING
(I-2012-000818) 1045F @ 1 HORIZON ROAD  , FORT LEE - fan room
(I-2012-000819) 1045F @ 1 EXECUTIVE DRIVE  , FORT LEE - LL Level
(I-2012-000820) 1045F @ 1081 INWOOD TERRACE  , FORT LEE - Cheung - smoke detector
(I-2012-000821) 1045F @ 1115 BUCKINGHAM ROAD  , FORT LEE - OFFICE SMOKE DETECTOR
(I-2012-000822) 1045F @ 3021 EDWIN AVENUE  , FORT LEE - 5th floor elevator activation
(I-2012-000823) 1035 @ 3081 EDWIN AVENUE  , FORT LEE - Reported Stuck Occupied Elevator between 3rd. & 4th. flrs.
(I-2012-000824) 1037 @  ROUTE 95 NORTH  , FORT LEE - Leonia Boro, rt 95 north express 120.7 -...\n\nActive Units: FL-R
(I-2012-000825) 1045F @ 1 EXECUTIVE DRIVE  , FORT LEE - penthouse activation
(I-2012-000826) 1045F @ 1600 PARKER AVENUE  , FORT LEE - General alarm
(I-2012-000827) 1032 @ 2170 FLETCHER AVENUE  , FORT LEE - report of vehicle fire in taco bell parking lot, 551-574-0053
(I-2012-000828) 1033 @ 1 PIP  , FORT LEE - brush fire  caller is by cannons
(I-2012-000829) 1045F @ 2053 ELLERY AVENUE  , FORT LEE - First fl smoke Canerparo residence   apt. building   alarm co to noty   owner cell  854-304-3491
(I-2012-000830) 1035 @ 1000 OVERLOOK DRIVE  , FORT LEE - check for blocked fire exit, on south side of 2nd floor, previously reported to management, 908-249-2449, mr. lacher.
(I-2012-000831) 1045F @ 2 HORIZON ROAD  , FORT LEE - laundry room 8 and basement north

 */


public class NJSussexCountyAParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("I-[A-Z]?\\d{4}-\\d{6}");
  private static final Pattern MASTER_PTN = 
    Pattern.compile("([-A-Z0-9 ]+) @ ([^,]+) +, ([^-]*) -(?: (.*))?"); 
  
  public NJSussexCountyAParser() {
    super("SUSSEX COUNTY", "NJ");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! SUBJECT_PTN.matcher(subject).matches()) return false;
    data.strCallId = subject;
    body = body.replace('\n', ' ');
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim();
    parseAddress(match.group(2).trim(), data);
    data.strCity = match.group(3).trim();
    String sInfo = getOptGroup(match.group(4));
    if (data.strAddress.equals("OUT OF TOWN")) {
      data.strAddress = "";
      parseAddress(StartType.START_ADDR, sInfo, data);
      data.strSupp = getLeft();
      data.defCity = "";
      data.defState = "";
    } else {
      data.strSupp = sInfo;
    }
    return true;
  }
}
