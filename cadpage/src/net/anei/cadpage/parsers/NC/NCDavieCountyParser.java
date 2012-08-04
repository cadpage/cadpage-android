package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Davie County, NC
Contact: Michael Wilson <fireman1700@gmail.com>

911:Call #110619-2932* Address:866 ANGELL RD* * * City:MOCKSVILLE* * Type:HC* HAZARDOUS CONDITION* HILL JOEL* PH#:336-940-2303* Units:17* IRA:* Medical: No* Haza.
911:Call #110622-3347* Address:2388 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:19D4* HEART PROBLEMS* HALL GENE* PH#:336-492-5114* Units:17,34,ST4,YC24* IRA:*
911:Call #110622-3355* Address:389 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* CULLER C O* PH#:336-492-7249* Units:17* IRA:* Medical: No* H
911:Call #110623-3420* Address:261 COOPER CREEK DR* * * City:MOCKSVILLE* Geo Comment: BUSINESSES IN CITY LIMITS NBH: OFF 1734 US HWY 601 N Landmark Comment: KNOX
911:Call #110624-3510* Address:3868 US HWY 601 N* * * City:MOCKSVILLE* * Type:YEL* CARDIAC PROBLEM* HOHFF, EARL V* PH#:336-492-3017* Units:17* IRA:* Medical: No*

911:Call #110627-3974* Address:NC HWY 801 N // BONKIN LAKE RD* * * City:MOCKSVILLE* * Type:GWB* GRASS/WOODS/BRUSH FIRE* PAUL TONY* PH#:336-575-4524* Units:17,23*
911:Call #110630-4406* Address:284 BRANGUS WAY* * * City:MOCKSVILLE* NBH: OFF 2386 CANA RD* Type:VF* VEHICLE FIRE* MEADER CORTLAND J* PH#:336-940-2666* Units:17
911:Call #110628-4171* Address:700 RICHIE RD* * * City:MOCKSVILLE* NBH: FROM 444 EATONS CHURCH RD TO 3558 US HWY 601 N NBH: I40 TO FARMSTEAD LN* Type:HC* HAZARDO

Contact: Brent Crotts <jvfd2110@gmail.com>
911@[70.60.255.70] 911:Call #110713-6266* Address:154 CRESTVIEW DR* * * City:MOCKSVILLE* NBH: OFF 499 EAST LAKE DR* Type:26A2-11* SICK PERSON (SPECIFIC DIAGNOSIS)* linda packett* P

Contact: Kenneth Wheeler <wheelerk1411@yahoo.com>
Sender: From:911@co.davie.nc.us
911:Call #111107-2492* Address:100 SUN BURST LN* * * City:MOCKSVILLE* NBH: OFF 1627 JUNCTION RD NEAR NOLLEY RD* Type:HC* HAZARDOUS CONDITION* *
911:Call #111108-2718* Address:255 NEELY RD* * * City:COOLEEMEE* * Type:SF* STRUCTURE FIRE* FOWLER ANSLO* PH#:336-284-4275* Units:14* IRA:* Me
911:Call #120201-4100* Address:1407 JUNCTION RD* * * City:MOCKSVILLE* * Type:50PD* ACCIDENT/DAMAGE* INNES* PH#:704-640-5463* Units:14* IRA:*

Contact: support@active911.com
911:Call #120223-6774* Address:277 OLD TOWNE DR* * * City:ADVANCE* Geo Comment: KINDERTON DEV NBH: OFF 160 BLOCK YADKIN VALLEY RD* Type:MED* MEDICAL CALL* GAIL GODWIN* PH#:336-909-2667* Units:24* IRA:* Medical: No* Hazards: No* NARR:02/23/2012 01:51:24 : pos2 : MCROWE Cross streets: BROOKSTONE DR//DEADEND Geo Comment: KINDERTON DEV NBH: OFF 160 BLOCK YADKIN VALLEY RD*
[] 911:Call #120422-4536* Address:162 TINSLEY DR* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* IREDELL* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/22/2012 23:10:06 : pos2 : RPIERCE OFF CARTNER RD NO RADIO TRAFFIC FROM IREDELL*\n
[] 911:Call #120423-4601* Address:127 FLORA LN* * * City:MOCKSVILLE* * Type:SF* STRUCTURE FIRE* IREDELL* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/23/2012 13:40:34 : pos2 : jbyerly COME IN OFF OF RIMROCK, MT BETHEL CLOSED AT BRIDGE*\n
[] 911:Call #120426-4952* Address:1342 RIDGE RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* LACKEY, BEATRICE* PH#:336-492-6052* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/26/2012 05:04:19 : pos2 : GGUSA Cross streets: SMITH RD//VILLAGE RD female on oxygen ... high temp ... resp distress*\n
[] 911:Call #120427-5175* Address:1707 DAVIE ACADEMY RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* CARTNER JOHN CLIFFORD* PH#:336-492-6447* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/27/2012 17:17:57 : pos2 : CDWIGGINS Cross streets: SHADY KNOLL LN//ST MATTHEWS RD*\n
[] 911:Call #120427-5202* Address:171 LOGAN WAY RD* * * City:STATESVILLE* * Type:HEM* HEMORHAGE* * PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/27/2012 20:51:58 : pos2 : SPHILLIPS *\n
[] 911:Call #120428-5297* Address:336 WHISPERING OAKS LN* * * City:MOCKSVILLE* NBH: off 200 blk oak meadow ln off 550 blk ratledge rd* Type:FA* FIRE ALARM* TAMMY* PH#:336-766-7698* Units:14,18,RC73* IRA:* Medical: No* Hazards: No* NARR:04/28/2012 13:09:01 : pos2 : JALLGOOD Cross streets: OAK MEADOW LN//DEADEND NBH: off 200 blk oak meadow ln off 550 blk ratledge rd STORAGE ROOM AGE LEE STALLARD*\n
[] 911:Call #120429-5402* Address:161 I40 WB* * * City:MOCKSVILLE* * Type:DB* DIABETIC CRISIS* IREDELL* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/29/2012 15:41:23 : pos2 : JALLGOOD *\n
[] 911:Call #120501-5661* Address:1819 RIDGE RD* * * City:MOCKSVILLE* NBH: OFF 4408 US HWY 64 W* Type:STBY* STAND BY* * PH#:336-492-7236* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/01/2012 12:33:35 : pos1 : STHOMPKINS Cross streets: MATTIE LN//US HWY 64 W Landmark: COUNTY LINE FIRE DEPT NBH: OFF 4408 US HWY 64 W*\n
[] 911:Call #120503-5901* Address:149 MOZIER HILL LN* * * City:HARMONY* * Type:SIC* SICK CALL* IRC* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/03/2012 07:40:48 : pos2 : AHANES IREDELL CANCELLED--SUBJECT POV`ING 05/03/2012 07:40:32 : pos2 : AHANES *\n
[] 911:Call #120503-5933* Address:162 I40* * * City:MOCKSVILLE* * Type:50PI* ACCIDENT/INJURY* * PH#:* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/03/2012 11:50:57 : pos4 : JMARTIN TRACTOR TRAILER VS TRUCK PT UNCI*\n
[] 911:Call #120506-6432* Address:168 I40 EB* * * City:MOCKSVILLE* * Type:50PI* ACCIDENT/INJURY* VERIZON* PH#:336-451-5508* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/06/2012 19:14:03 : pos2 : ABURTON Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR 2 VEHICLE CAR OVERTURNED*\n
[] 911:Call #120506-6457* Address:164 I40 WB* * * City:MOCKSVILLE* * Type:50PI* ACCIDENT/INJURY* VERIZON* PH#:828-545-9082* Units:13,18,31,ST4* IRA:* Medical: No* Hazards: No* NARR:05/06/2012 22:15:51 : pos1 : RPIERCE Cross streets: IREDELL COUNTY LINE//64 W AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR SMALL HONDA CAR DROVE UP EMBANKMENT,*\n
[] 911:Call #120510-6909* Address:1969 MOCKSVILLE HWY* * * City:MOCKSVILLE* * Type:FA* FIRE ALARM* iredell* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/10/2012 10:51:13 : pos1 : STHOMPKINS co line.. cool springs school..*\n
[] 911:Call #120516-7704* Address:290 FRED LANIER RD* * * City:MOCKSVILLE* NBH: OFF 2876 US HWY 64 W* Type:UTIL* UTILITY PROBLEM* RENEE SMITH* PH#:704-235-8044* Units:13,18* IRA:* Medical: No* Hazards: No* NARR:05/16/2012 09:38:52 : pos1 : SFRYE Cross streets: US HWY 64 W//CASTLE LN NBH: OFF 2876 US HWY 64 W TREE ON THE UTILITY LINES FG-1 ENERGRY UNITED*\n

Contact: support@active911.com
[] 911:Call #120731-9241* Address:2229 NC HWY 801 S* * * City:ADVANCE* * Type:FA* FIRE ALARM* KANDICE BOGER* PH#:336-940-6957* Units:12* IRA:* Medical: No* Hazards: No* NARR:07/31/2012 19:49:01 : pos1 : MCROWE Cross streets: SAM COPE RD//DEER HOLLOW LN*\r\n\n
[] 911:Call #120802-9449* Address:645 NC HWY 801 S* * * City:ADVANCE* * Type:50PI* ACCIDENT/INJURY* REYNOLDS WAYNE* PH#:336-998-2845* Units:12* IRA:* Medical: No* Hazards: No* NARR:08/02/2012 09:07:33 : pos2 : STHOMPKINS Cross streets: BOWDEN RD//UNDERPASS RD 08/02/2012 09:07:04 : pos2 : STHOMPKINS 3 cars*\r\n\n
[] 911:Call #120802-9475* Address:142 NC HWY 801 N* * * City:ADVANCE* * Type:SF* STRUCTURE FIRE* BARRY* PH#:336-817-2358* Units:12,24* IRA:* Medical: No* Hazards: No* NARR:08/02/2012 11:40:07 : pos4 : ABURTON Cross streets: US HWY 158//I40 EB 08/02/2012 11:39:55 : pos4 : ABURTON Cross streets: PEACHTREE LN//CARTER RD Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158 GEN AND BUILDING*\r\n\n
 */


public class NCDavieCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*(?: \\*)*"); 
  
  public NCDavieCountyParser() {
    super("DAVIE COUNTY", "NC",
           "ID Address:ADDR! City:CITY! Geo_Comment:INFO2? NBH:INFO3 Type:CALL CALL NAME PH:PHONE Units:UNIT IRA:SKIP INFO+ Geo_Comment:INFO2");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    int ipt = body.indexOf("911:Call #");
    if (ipt < 0) return false;
    body = body.substring(ipt+10).trim();
    body = body.replace("PH#:", "PH:");
    return parseFields(DELIM.split(body), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("//+", "/");
      super.parse(field, data);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private class MyInfo2Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " ", "Geo Comment: " + field);
    }
  }
  
  private class MyInfo3Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " ", "NBH: " + field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("INFO2")) return new MyInfo2Field();
    if (name.equals("INFO3")) return new MyInfo3Field();
    return super.getField(name);
  }
}
