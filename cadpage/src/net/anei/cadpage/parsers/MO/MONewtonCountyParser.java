package net.anei.cadpage.parsers.MO;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Newton County, MO
Contact: jeffrey lechliter <jlechliter4512@gmail.com>
Sender: 911@NC-CDC.ORG

Subject:911 CALL\n11178 ELAND RD  CrossStreets: JUNIPER DR 0.01 mi SE IVY DR 0.73 mi N SICK PERSON ESN: pg6 Call Number: 763388
Subject:911 CALL\nIRIS RD & STATE LINE RD  CrossStreets: TA-D (TONE PD) HIGH MECH-ALL TERRAIN ESN: pg6 Call Number: 760919
Subject:911 CALL\n2953 ROWAN DR  CrossStreets: ANTELOPE RD 0.19 mi E HIGHWAY 43 0.81 mi W STRUCTURE FIRE-D / RES (SINGLE) ESN: pg8 Call Number: 7
Subject:911 CALL\n13724 HIGHWAY 43, Apt. 30 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE ESN: pg7 Call Number
Subject:911 CALL\n20513 HIGHWAY Y  CrossStreets: RHINEHART LN 0.19 mi S REDBUD RD 0.62 mi N CHEST PAIN ESN: pg8 Call Number: 762218
Subject:911 CALL\n5369 QUINCE RD  CrossStreets: DENNISON LN 0.03 mi E CROW RD 0.71 mi W TA INJURY ESN: pg8 Call Number: 762973
Subject:911 CALL\n13724 HIGHWAY 43, Apt. 29 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE-D / MH-PORTABLE OFC 
Subject:911 CALL\n5156 JESSICA LN  CrossStreets: CROW RD 0.31 mi W FALL ESN: pg6 Call Number: 762520
Newton County, MO
Contact: Active911.com

Contact: Active911
Agency name: Redings Mill Fire District Location: Joplin, MO 
Sender: 911@NC-CDC.ORG  

(911 CALL) 344 REDINGS MILL RD RMFD1 CrossStreets: CHRISTMAN DR 0.09 mi SW PARK HILL DR 0.08 mi NE OUTSIDE FIRE ESN: pg47 Call Number: 770023
(911 CALL) 5517 SPURGEON RD, Apt. 157 BIG VALLEY MHP CrossStreets: DANIELLE LN 0.24 mi N ELM DR 0.76 mi S BREATHING PROB ESN: pg26 Call Number: 770098
(911 CALL) 3427 HOLLY RD  CrossStreets: ANTELOPE RD 0.31 mi W BISON RD 0.64 mi E OUTSIDE FIRE ESN: pg5 Call Number: 770114
(911 CALL) 11319 HIGHWAY FF, Apt. LOT 8A  CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E SICK PERSON ESN: pg25 Call Number: 770124
(911 CALL) 9477 DANIELLE LN  CrossStreets: DEAD END 0.65 mi W SPURGEON RD 0.65 mi E UNCONS/FAINTING ESN: pg26 Call Number: 770284
(911 CALL) 712 E 39TH ST, Apt. 1 DENNIS ACRES MHP CrossStreets: S INDIANA AVE 0.64 mi W DEAD END 0.64 mi E CHEST PAIN ESN: pg39 Call Number: 770315
(911 CALL) 20TH & BLACKCAT RD  CrossStreets: MUTUAL AID-A / ASST OUTSIDE-MULTI/COLD ESN:  Call Number: 770414
(911 CALL) NEWTON RD & CRANE DR  CrossStreets: OUTSIDE FIRE ESN: pg4/38 Call Number: 770492
(911 CALL) 11319 HIGHWAY FF, Apt. C6 BYKOTA ESTATES MHP CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E SICK PERSON ESN: pg25 Call Number: 770567
(911 CALL) 5725 HIGHWAY 43 GO ZONE CrossStreets: DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S TA INJURY ESN: pg5 Call Number: 770745
(911 CALL) 5725 HIGHWAY 43 GO ZONE CrossStreets: DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S ALLERGIES/STINGS/BITES ESN: pg5 Call Number: 770872
(911 CALL) 808 W 46TH ST  CrossStreets: DEAD END 0.09 mi W SARGEANT AVE 0.09 mi E CARDIAC/RESPIR ARREST ESN: pg51 Call Number: 770886
(911 CALL) 3586 CHERRY RD  CrossStreets: APPLE VALLEY LN 0.14 mi W BERRY HILL LN 0.59 mi E BREATHING PROB ESN: pg4/38 Call Number: 770912
(911 CALL) HIGHWAY 43 & I 44 EB  CrossStreets: TA INJURY-UNK (JOP/OUT) ESN: pg4/38 Call Number: 770924
(911 CALL) 11319 HIGHWAY FF, Apt. A10 BYKOTA ESTATES MHP CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E BREATHING PROB ESN: pg25 Call Number: 770969
(911 CALL) 712 E 39TH ST, Apt. 1 DENNIS ACRES MHP CrossStreets: S INDIANA AVE 0.64 mi W DEAD END 0.64 mi E OD/POISON ESN: pg39 Call Number: 771014
(911 CALL) HILLTOP LN & REINMILLER RD  CrossStreets: STRUCTURE FIRE ESN: pg9 Call Number: 771084
(911 CALL) HILLTOP LN & REINMILLER RD  CrossStreets: STRUCTURE FIRE-D / MH-PORTABLE OFC ESN: pg9 Call Number: 771084
(911 CALL) 4995 EDWARD LN  CrossStreets: DEAD END 0.63 mi W HIGHWAY 43 0.63 mi E FALL ESN: pg5 Call Number: 771137
(911 CALL) 5203 S RANGELINE RD EXTREME SPORTS SCUBA/EDS ELECTRIC CrossStreets: SAGINAW RD 0.09 mi N SUNSET PL 0.03 mi S SICK PERSON ESN: pg49 Call Number: 771254
(911 CALL) 4531 HICKORY LN 4531 HICKORY LN CrossStreets: SILVER CREEK DR 0.15 mi N MARTIN DR 0.18 mi S BREATHING PROB ESN: pg53 Call Number: 771261
(911 CALL) ARCADIA LN & NEWTON RD  CrossStreets: OUTSIDE FIRE ESN: pg4/38 Call Number: 771357
(911 CALL) 5646 CARVER RD CARVER NATIONAL MONUMENT CrossStreets: MACON LN 0.56 mi S HIGHWAY V 0.08 mi N OUTSIDE FIRE-D / BRUSH/GRASS ESN: pg10 Call Number: 771633
(911 CALL) 11319 HIGHWAY FF, Apt. A22 BYKOTA ESTATES MHP CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E CHEST PAIN ESN: pg25 Call Number: 771728
(911 CALL) HIGHWAY 71 & HIGHWAY V  CrossStreets: TA INJURY ESN: pg26 Call Number: 771800
(911 CALL) 4257 HIGHWAY NN  CrossStreets: BROADLAWN BLVD 0.35 mi NW CLIFF LN 0.18 mi SE SICK PERSON ESN: pg4/38 Call Number: 771825
(911 CALL) 4368 OLD HIGHWAY 71 SAGAMOUNT BIBLE CAMP CrossStreets: HAROLD LN 0.18 mi SE CHRISTY LN 0.22 mi NW OUTSIDE FIRE ESN: pg9 Call Number: 771831
(911 CALL) 4704 ELM DR  CrossStreets: CARTER LN 0.23 mi W HIGHWAY 43 0.23 mi E TA INJURY ESN: pg5 Call Number: 771874
(911 CALL) HIGHWAY NN & E HIGHWAY 86  CrossStreets: INFO-EMS ESN: pg11 Call Number: 772128
(911 CALL) 115 BURGESS ST 115 BURGESS ST CrossStreets: WOODLAND DR 0.73 mi N SAGINAW RD 0.73 mi S STROKE ESN: pg49 Call Number: 772174
(911 CALL) 3405 SCHIFFERDECKER AVE, Apt. COMMON AREA OZARK OAKS & RCF CrossStreets: W 32ND ST 0.08 mi N CROW RD 0.16 mi S BREATHING PROB-D / DIFF SPK BTWN BREATHS ESN: PG4/24/36 Call Number: 772188
(911 CALL) 3112 BAY DR  CrossStreets: IMPALA DR 0.03 mi W BIRCH DR 0.31 mi SE CHEST PAIN ESN: pg9 Call Number: 772264
(911 CALL) 4617 S JACKSON AVE  CrossStreets: W 46TH ST 0.02 mi NW EDGEWOOD RD 0.23 mi SW TA INJURY ESN: pg51 Call Number: 772270
(911 CALL) HIGHWAY 71 & HIGHWAY FF  CrossStreets: TA INJURY ESN: pg25 Call Number: 772284
(911 CALL) 10032 BIRCH DR  CrossStreets: STACY LN 0.13 mi W HERON DR 0.13 mi W TRAUMATIC INJS ESN: pg9 Call Number: 772512
(911 CALL) GREENWOOD DR & APRICOT DR  CrossStreets: TA INJURY ESN: pg4/38 Call Number: 772560
(911 CALL) 1625 APRICOT DR  CrossStreets: ALPACA RD 0.20 mi SE AUSTIN DR 0.39 mi W CHEST PAIN ESN: pg4/38 Call Number: 772607
(911 CALL) ANGUS DR & STATE LINE RD  CrossStreets: TA-D (TONE PD) HIGH MECH-ROLLOVER ESN: pg5 Call Number: 772689
(911 CALL) HIGHWAY 71 & GATEWAY DR  CrossStreets: TA INJURY ESN: pg26 Call Number: 772725
(911 CALL) , Apt. B5 BYKOTA ESTATES MHP CrossStreets: ELECTRICAL HAZARD ESN:  Call Number: 772780
(911 CALL) IRIS RD & W HIGHWAY 86  CrossStreets: TA INJURY ESN: pg6 Call Number: 772832
(911 CALL) RIVER RD & S RANGELINE RD  CrossStreets: ELECTRICAL HAZARD ESN: pg4/38 Call Number: 772994
(911 CALL) 8695 BETHEL RD  CrossStreets: HOLLY RD 0.20 mi N HUNNEY LN 0.39 mi S BREATHING PROB ESN: pg5 Call Number: 773047
(911 CALL) 7157 GREENBRIER DR  CrossStreets: ELAND RD 0.19 mi W FINCH DR 0.31 mi E OUTSIDE FIRE ESN: pg5 Call Number: 773057
(911 CALL) 2530 HOLLY RD  CrossStreets: AKRON LN 0.10 mi E BETHEL RD 0.93 mi W TA INJURY ESN: pg5 Call Number: 773154
(911 CALL) 4995 EDWARD LN  CrossStreets: DEAD END 0.63 mi W HIGHWAY 43 0.63 mi E UNK PRO/MAN DWN ESN: pg5 Call Number: 773162
(911 CALL) HIGHWAY 43 & DOUGLAS FIR RD  CrossStreets: HEAT/COLD EXPOSURE ESN: pg5 Call Number: 773226
(911 CALL) 203 CREEK RD 203 CREEK RD CrossStreets: SAGINAW RD 0.10 mi E TA INJURY ESN: pg49 Call Number: 773391
(911 CALL) 1625 APRICOT DR  CrossStreets: ALPACA RD 0.20 mi SE AUSTIN DR 0.39 mi W STROKE ESN: pg4/38 Call Number: 773615
(911 CALL) HIGHWAY 43 & DAKOTA LN  CrossStreets: TA INJURY ESN: pg4/38 Call Number: 773680
(911 CALL) HIGHWAY P & W HIGHWAY 86  CrossStreets: OD/POISON ESN: pg5 Call Number: 773883
(911 CALL) 1185 OUTER RD 1185 OUTER RD CrossStreets: RAINBOW DR 0.34 mi W REINMILLER RD 0.34 mi E SICK PERSON ESN: pg25 Call Number: 774053
(911 CALL) 5725 HIGHWAY 43 GO ZONE CrossStreets: DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S TA INJURY ESN: pg5 Call Number: 774079
(911 CALL) REINMILLER RD & APRICOT DR  CrossStreets: ROAD CLOSING (PG FD) ESN: pg25 Call Number: 774188
(911 CALL) 3944 W 7TH ST WASTE CORPERATON CrossStreets: MUTUAL AID-B / ASST OUTSIDE/HOT ESN:  Call Number: 774207
(911 CALL) 7648 GREENBRIER DR  CrossStreets: ELGIN LN 0.10 mi E FINCH DR 0.11 mi W BREATHING PROB-E / INEFFECTIVE BREATHING ESN: pg5 Call Number: 774310
(911 CALL) 11319 HIGHWAY FF, Apt. B18  CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E HEART PROB ESN: pg25 Call Number: 774327
(911 CALL) 1450 IRIS RD  CrossStreets: STATE LINE RD 0.13 mi W BETHEL RD 0.52 mi E FALL ESN: pg6 Call Number: 774366
(911 CALL) 7859 FAIR PORT LN  CrossStreets: DEAD END 0.20 mi N HIGHWAY P 0.20 mi S OUTSIDE FIRE ESN: pg5 Call Number: 774465
(911 CALL) FULTON LN & HIGHWAY NN  CrossStreets: TA INJURY ESN: pg5 Call Number: 774512
(911 CALL) 6995 FLETCHER LN  CrossStreets: DEAD END 0.05 mi W IMPALA DR 0.05 mi E CHEST PAIN ESN: pg26 Call Number: 774533
(911 CALL) 3323 S TEXAS AVE JOPLIN FIRE STATION 5 CrossStreets: MUTUAL AID-A / ASST OUTSIDE/COLD ESN:  Call Number: 774592
(911 CALL) 905 CASTLE DR  CrossStreets: DANIEL BOONE DR 0.02 mi N MARK TWAIN DR 002 mi S TRAUMATIC INJS ESN: pg47 Call Number: 774593

*/

public class MONewtonCountyParser extends FieldProgramParser {
 
  public MONewtonCountyParser() {
    super("NEWTON COUNTY", "MO",
          "ADDR/SXP! CrossStreets:X! ESN:MAP Call_Number:ID");
  }
  
  @Override
  public String getFilter() {
    return "911@NC-CDC.ORG";
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equalsIgnoreCase("911 CALL")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String addr = p.get(", Apt.");
      String apt = p.get(' ');
      if (apt.equalsIgnoreCase("LOT")) apt = apt + " " + p.get(' ');
      String place = p.get();
      if (apt.length() > 0) {
        parseAddress(addr, data);
        data.strApt = apt;
        data.strPlace = place;
      } else {
        super.parse(field, data);
        if (data.strAddress.equals(append(data.strApt, " ", data.strPlace))) {
          data.strApt = "";
          data.strPlace = "";
        }
      }
    }
  }
  
  private static final Pattern MILE_PTN = Pattern.compile(" mi [NSEW][NSEW]? ");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = 0;
      Matcher match = MILE_PTN.matcher(field);
      while (match.find()) pt = match.end();
      if (pt >= 0) {
        data.strCall = field.substring(pt).trim();
        data.strCross = field.substring(0,pt).trim();
      } else {
        Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field);
        if (res.getStatus() > 0) {
          res.getData(data);
          data.strCall = res.getLeft();
        } else {
          data.strCall = field;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X CALL";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}