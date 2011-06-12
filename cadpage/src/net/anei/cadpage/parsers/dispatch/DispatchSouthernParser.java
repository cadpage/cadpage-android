package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Southern Software CAD

Jefferson County, TN 
DISPATCH:1718 BROOKLINE CT JEFFERSON CITY 2011-611597 22:43:08  BREATHING DIFFICULTY

Jackson County, NC 
Bill:9783 CHARLEYS CREEK RD TUCKASEGEE MDL 26A03 2011009480 22:20:01 SICK PERSON (SPECIFIC DIAGNOSIS) CALLER ADV SHE HAD HEART SURGERY A LITTLE WHILE AGO AND HER

Brunswick County, NC
349:560 CUMBERLAND ST SE BOLIVIA MDL 09B01 11-020650 17:02:34 Cardiac or Respiratiory Arrest / Death RECV CALL FROM FUNERAL HOME ADVING THAT THEY RECV CALL STATING A FEMALE WAS DEAD AT THIS LOCATION AD
415:111 SE 32ND ST OAK ISLAND VERIZON WIRELESS 7045790781 MDL 09E01 11-025910 20:39:44 Cardiac or Respiratiory Arrest - De
411:22 BOUNDARYLINE DR NW C CALABASH LYNN 9102094924 11-025720 06:59:32 Structure Fire SMELL SOMETHING BURNING IN RESD
399:1295 DECATOR ST SW SUPPLY PAM 9106339368 MDL 09E01 11-025419 22:11:30 Cardiac or RespArrest  CALLER ADV THE PT IS STIFF
428:BAY POINT CT / JENNIS AV FELICIA  9103685110 MDL 27D04 11-026412 21:09:48 Stab-Gunshot-Pen Trauma AT THE END OF  RD .
426:BAY POINT CT-JENNIS AV FELICIA 9103685110 11-026412 21:07:25 Stab-Gun-Trauma AT THE END OF BAYPOINT RD MALE SUBJ IS CUT
415:111 SE 32ND ST OAK ISLAND  7045790781 MDL 09E01 11-025910 20:39:44 Cardiac or Resp Arrest - Death TRANS BY OKI... ADVD TH
411:22 BOUNDARYLINE DR NW C CALABASH LYNN 9102094924 11-025720 06:59:32 Structure Fire SMELL SOMETHING BURNING IN RESD,

Person County, NC
JBROWN:115 CROSS CREEK CT TIMBERLAKE 2011019922 18:27:47 FIRE STOVE
Jason_White:HURDLE MILLS RD / PAYNES TAVERN RD 2011019901 15:46:01 MVA PI CARD 29 car vs motorcycle
Shutchings:GUESS RD / HURDLE MILLS RD 2011019810 00:35:44 MVA PI CARD 29
Shutchings:115 JACOBS-MOORE LN HURDLE MILLS 2011019797 23:05:28 FIRE STRUCTURE FLAMES VISIBLE the house is on fire
Bmelton:HURDLE MILLS RD / POINDEXTER RD 2011019760 17:21:08 TREE DOWN
BGILLISPIE:796 WHEELERS CHURCH RD HURDLE MILLS MDL 10C01 2011019661 05:54:13 CHEST PAIN CARD 10
BROWN:225 CROWN BLVD TIMBERLAKE 2011020040 11:49:49 ALARMS-FIRE design works building 2 general fire alarm adt 8772857397

Chilton County, AL
120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
COUNTY RD 57 \ COUNTY RD 445 2011039172 06:20:45 WRECK-UNKNOWN INJURIES CALLER STATES ONE VEHICLE OVERTURNED.. ADV THAT THE SUBJECT IS OUT OF THE VEHICLE
120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
100 COUNTY RD 99 LOT 5 VERBENA 2011043298 18:37:55 SHORTNESS OF BREATH GRANDMOTHER ON CHEMO NOT DOING GOOD 
518 COUNTY RD 221 THORSBY 2011046746 06:20:05 DIABETIC RESIDENCE IS A BEIGE DOUBLE WIDE WITH MAROON SHUTTERS. RED TOYOTA AND BLACK DODGE IN THE BACK YARD

Moore County, NC
[[911 NOTIFICATION] ]  505 PINEHURST ST ABERDEEN 2011024766 19:52:16 F69 STRUCTURE FIRE LOOKS LIKE BACK DECK ON FIRE
[[911 NOTIFICATION] ]  1 S. VINELAND SOUTH CELL TOWER 2011025029 09:31:20 M25 PSYCHIATRIC/SUICIDE ATTEMPT
[[911 NOTIFICATION] ]  126 ROBIN HOOD LN ABERDEEN 2011025065 13:37:27 F52 ALARM-FIRE ACTIVATION AC 800 932-3822 OPER SP8
[[911 NOTIFICATION] ]  632 SAND PIT RD ABERDEEN MDL 07A01 2011025721 11:06:58 M7 BURNS/EXPLOSIONS
[[911 NOTIFICATION] ]  218 BERRY ST PINE BLUFF 2011026135 14:36:24 F67 OUTSIDE FIRE/WOODS/BRUSH TREE ON FIRE
[[911 NOTIFICATION] ]  1 E NEW ENGLAND /S PEAR 2011025862 07:31:07 F67 OUTSIDE FIRE/WOODS/BRUSH

*/

public class DispatchSouthernParser extends SmartAddressParser {
  
  public static final int DSFLAG_DISPATCH_ID = 0x01;
  public static final int DSFLAG_UNIT = 0x02;
  
  private static final Pattern LEAD_PTN = Pattern.compile("^[\\w\\.]+:");
  private static final Pattern ID_TIME_PTN = Pattern.compile("\\b(\\d{2,4}-?\\d{4,8}) \\d\\d:\\d\\d:\\d\\d\\b");
  private static final Pattern CALL_PTN = Pattern.compile("^[A-Z0-9\\- /]+\\b");
  
  private boolean leadDispatch;
  private boolean unitId;
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState) {
    this(cityList, defCity, defState, DSFLAG_DISPATCH_ID);
  }
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState, int flags) {
    super(cityList, defCity, defState);
    this.leadDispatch = (flags & DSFLAG_DISPATCH_ID) != 0;
    this.unitId = (flags & DSFLAG_UNIT) != 0;
  }

  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Message must always start with dispatcher ID, which we promptly discard
    if (leadDispatch) {
      Matcher match = LEAD_PTN.matcher(body);
      if (!match.find()) return false;
      body = body.substring(match.end()).trim();
    }
    
    // find an ID/Time pattern which splits the message into two fields
    Matcher match = ID_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    
    data.strCallId = match.group(1);
    String sAddr = body.substring(0,match.start()).trim();
    String sExtra = body.substring(match.end()).trim();
    
    // First half contains address, optional place,and possibly an MDL call code
    Parser p = new Parser(sAddr);
    data.strCode = p.getLastOptional(" MDL ");
    sAddr = p.get();
    parseAddress(StartType.START_ADDR, sAddr, data);
    data.strPlace = getLeft();

    // Second half May contain unit ID,
    // then call description and long call description
    // Call description comes first and contains only upper case letters and numbers
    if (unitId) {
      p = new Parser(sExtra);
      data.strUnit = p.get(' ');
      sExtra = p.get();
    }
    match = CALL_PTN.matcher(sExtra);
    if (match.find()) {
      String sCall = match.group().trim();
      if (sCall.length() <= 20) {
        data.strCall = sCall;
        sExtra = sExtra.substring(match.end()).trim();
      }
    }
    data.strSupp = sExtra;
    
    return true;
  }
}
