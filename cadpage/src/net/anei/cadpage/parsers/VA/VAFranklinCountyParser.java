package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/*
Franklin County, VA
=========================================================================================================================================
Basic Message Construct:
"MAILBOX:XXX" Indicates which Agency mailbox messages are Routed to. "S" is an EMS agency or "Rescue Squad" or "Squad" and "C" is a Fire Company or "Company". The next 2 digit number indicates the local agency number
Call Type - Variable length string
Address - Variable Length String. Typically prefixed with House number, however can be expressed as numberless intersection. If House address is given then in lieu of zipcode there is a 3 character prefix that cooresponds to the Zip Code area
"CFS#" is the internal CAD system Insident Number is always the 4 digit year hyphenated with a 6 digit incident number
"CROSS:" Optional and indicates Cross Streets - Streets seperated by a "/"
=========================================================================================================================================

Sender: mailbox@franklincountyva.org

=========================================================================================================================================
Contact spcrook4@gmail.com (FCPS Career Division - get's all pages)

- Boones Mill
MAILBOX:S07 EMS-DIABETIC 400 HAZELRIDGE LN BML CFS# 2011-031035 CROSS: JUBAL EARLY HWY/DEAD END
MAILBOX:S03 EMS-ALLERGIC REACTION 2855 FIVE MILE MOUNTAIN RD CAL CFS# 2011-031477 CROSS: TURNERS CREEK RD/FLOYD COUNTY LINE

- Ferrum
MAILBOX:S03 EMS-OTHER/DEFINE 660 FERRUM SCHOOL RD FER CFS# 2011-031307 CROSS: FRANKLIN ST W/FRANKLIN ST E
MAILBOX:S03 EMS-UNCONSCIOUS 845 HENRY RD FER CFS# 2011-031311 CROSS: FRANCE LN/DILLY VALLEY LN
MAILBOX:S03 FIRE-ALARM COMMERCIAL 165 MUSEUM DR FER CFS# 2011-031312 CROSS: FRANKLIN ST/DEAD END
MAILBOX:S05 ACCIDENT-INJURY FRANKLIN ST & OLD FERRUM RD FER CFS# 2011-031319
MAILBOX:S03 ASSAULT 80 MULLINS COURT LN 16 FER CFS# 2011-031404 CROSS: WAIDSBORO RD/DEAD END
MAILBOX:S03 FIRE-ALARM COMMERCIAL 10300 FRANKLIN ST FER CFS# 2011-031440 CROSS: FERRUM MOUNTAIN RD/FERRUM SCHOOL RD
MAILBOX:S03 FIRE-ALARM COMMERCIAL 325 FERRUM MOUNTAIN RD FER CFS# 2011-031489 CROSS: ARTHUR CIR/WHETSTONE RD

- Glade Hill
MAILBOX:S04 WELLBEING CHECK 560 FARM VIEW RD LOT 2 GLA CFS# 2011-031424 CROSS: GREENWAY RD/PINE GROVE RD

- Henry
MAILBOX:S03 EMS-HEAD INJURY 94 OVERBROOK DR HEN CFS# 2011-031420 CROSS: COTTONWOOD DR/DEAD END
MAILBOX:S08 EMS-LACERATION 105 DAWNRIDGE LN HEN CFS# 2011-031452 CROSS: KNOB CHURCH RD/DEAD END

- Penhook
MAILBOX:S15 EMS-OTHER/DEFINE 460 SAGO RD PEN CFS# 2011-031255 CROSS: CIRCLE CREEK RD/WALKER RD
MAILBOX:S06 EMS-CHEST PAIN 6586 CIRCLE CREEK RD PEN CFS# 2011-031500 CROSS: SAGO RD/PITTSYL CO LINE

- Rocky Mount
MAILBOX:S02 EMS-SEIZURE 000735 EAST COURT ST RMT CFS# 2011-031028 CROSS: DONALD AVE/POWER DAM RD
MAILBOX:S02 EMS-MENTAL 103 JAMESTOWN RD RMT CFS# 2011-031037 CROSS: GRASSY HILL RD/BLUE BEND RD
MAILBOX:S02 EMS-DOA 329 DOE RUN RD RMT CFS# 2011-031047 CROSS: SHAMROCK RD/TRIPPLE CREEK RD
MAILBOX:S02 EMS-UNCONSCIOUS VIRGIL H GOODE HWY & GLEN MEAD RMT CFS# 2011-031058
MAILBOX:S07 ACCIDENT-INJURY VIRGIL H GOODE HWY & BONBROOK M RMT CFS# 2011-031074
MAILBOX:S02 EMS-PATIENT FALLEN 300 HATCHER ST RMT CFS# 2011-031083 CROSS: BUCKNER ST/FRANKLIN ST
MAILBOX:S04 EMS-PATIENT IN PAIN 720 ORCHARD AVE RMT CFS# 2011-031066 CROSS: MARTIN ST/SOUTH MAIN ST
MAILBOX:S08 ACCIDENT-INJURY VIRGIL H GOODE HWY & CROOKED OA RMT CFS# 2011-031356
MAILBOX:S02 FIRE-STRUCTURE 2405 FRANKLIN ST RMT CFS# 2011-031354 CROSS: TOWN LIMITS/SIX MILE POST RD

- Union Hall
MAILBOX:S02 DRUNK DRIVER 11729 OLD FRANKLIN TPK UHL CFS# 2011-031446 CROSS: BERGER LOOP/KEMP FORD RD

- Wirtz
MAILBOX:S15 FIRE-STRUCTURE 150 WINDSOR POINT LP WIR CFS# 2011-031065 CROSS: PONDEROSA DR W/PONDEROSA DR E
MAILBOX:S02 EMS-OTHER/DEFINE 3835 WIRTZ RD WIR CFS# 2011-031294 CROSS: ALEAN RD/WILKERSON RD
MAILBOX:S07 EMS-UNCONSCIOUS 302 DUKE DR WIR CFS# 2011-031425 CROSS: RIDGEVIEW ST/DEAD END

- Bassett
MAILBOX:S08 EMS-PATIENT FALLEN 2809 FORK MOUNTAIN RD BAS CFS# 2011-031043 CROSS: FAWNDALE RD/VIRGIL H GOODE HWY	  
MAILBOX:S08 WELLBEING CHECK 313 FAWNDALE RD BAS CFS# 2011-031281 CROSS: COUNTRY RIDGE RD/FORK MOUNTAIN RD

- Hardy
MAILBOX:S15 EMS-PATIENT IN PAIN 001635 MOREWOOD RD HAR CFS# 2011-031025 CROSS: INDIAN POINTE DR/CHESTNUT POINTE DR
MAILBOX:S09 EMS-PATIENT FALLEN 6633 EDWARDSVILLE RD HAR CFS# 2011-031084 CROSS: WINTERHILL DR/ROBIN LN
MAILBOX:S10 EMS-STROKE 80 WESTLAKE RD HAR CFS# 2011-031067 CROSS: B T WASHINGTON HWY/PROFESSIONAL DR
MAILBOX:S15 EMS-PATIENT IN PAIN 545 FARMINGTON RD HAR CFS# 2011-031401 CROSS: POTEET RD/EDWARDSVILLE RD

- Martinsville
MAILBOX:S06 EMS-DIFFICULTY BREATHING 6342 COOPERS MOUNTAIN RD MAR CFS# 2011-031030 CROSS: SUTTON HOLLOW RD/SONTAG RD
MAILBOX:S06 ACCIDENT-INJURY 755 SNOW CREEK RD MAR CFS# 2011-031081 CROSS: HENRY COUNTY LINE/SHADY GROVE RD

- Moneta
MAILBOX:S10 EMS-PATIENT FALLEN 1195 MERRIMAN WAY RD MON CFS# 2011-031456 CROSS: PERIWINKLE RD/LANDFALL DR

=========================================================================================================================================
Contact: Larry Davids <davidsla07@gmail.com (Squad / Company 7)
MAILBOX:S07 EMS-OTHER/DEFINE 18360 VIRGIL H GOODE HWY 124 RMT CFS# 2010-030542 CROSS: SHADY LN/BLACKWATER RIVER
MAILBOX:S07 EMS-CHEST PAIN 413 WOODDALE DR RMT CFS# 2010-030355 CROSS: VIRGIL H GOODE HWY/DEAD END
MAILBOX:S07 EMS-PATIENT FALLEN 3005 GREEN LEVEL RD RMT CFS# 2010-030541 CROSS: GRASSY HILL RD/LITTLE MOUNTAIN DR
MAILBOX:S07 EMS-CARDIAC VIRGIL H GOODE HWY & LINK ST RMT CFS# 2010-030580
MAILBOX:S07 EMS-HIGH BLOOD PRESSURE 1808 BETHLEHEM RD BML CFS# 2010-030643 CROSS: BETHANY RD/DILLONS MILL RD
MAILBOX:C07 FIRE-ALARM COMMERCIAL 3325 GRASSY HILL RD RMT CFS# 2010-033866 CROSS: JAMESTOWN RD/CALLAWAY RD

=========================================================================================================================================
Contact: dot.jspencer@gmail.com (Squad 2)
S: M:MAILBOX:S02 ACCIDENT-INJURY 1450 WIRTZ CFS# 2011-028395\n

=========================================================================================================================================
Contact: "W. A. Mullins" <wesamullins@gmail.com> (Squad /Company 3)
MAILBOX:C03 FIRE-STRUCTURE 2405 FRANKLIN ST RMT CFS# 2011-031354 CROSS: TOWN LIMITS/SIX MILE POST RD
MAILBOX:C03 ACCIDENT-INJURY FRANKLIN ST & OLD FERRUM RD FER CFS# 2011-031319

Contact: Steve & Emily Crook" <crookshared@gmail.co
MAILBOX:S09 911 HANG UP 000283 KIN VALE RD RMT CFS# 2011-033694 CROSS: ANGLE PLANTATION RD/ALEAN RD

*/

public class VAFranklinCountyParser extends DispatchDAPROParser {
  
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
      "BML", "Boones Mill",	
      "CAL", "Callaway",
      "FER", "Ferrum",
      "GLA", "Glade Hill",
      "HEN", "Henry",
      "PEN", "Penhook",	  
      "RMT", "Rocky Mount",
      "UHL", "Union Hall",
      "WIR", "Wirtz",	  
      "BAS", "Bassett",	  
      "HAR", "Hardy",
      "MAR", "Martinsville",
      "MON", "Moneta"	  
    });

  
  public VAFranklinCountyParser() {
    super(CITY_CODE_TABLE, "FRANKLIN COUNTY", "VA");
  }
      
  
  @Override
  public String getFilter() {
    return "mailbox@franklincountyva.org";
  }

}