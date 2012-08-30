package net.anei.cadpage.parsers.MD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Charles County, MD (Version B)
Contact: "rogersonjg@gmail.com" <rogersonjg@gmail.com>
Sender: fire12alerting-bounces@sms.mdfiretech.com

TRASH, DEBRIS, MULCH, TREE FIRE, REFUSE\r\nHERRING CT, DORCHESTER LAKE @ END\r\nmdft.us/?VSm3jy\r\n1215465\r\nS12\r\n8/26/2012 5:23:48 PM
STAB, STABBING, PENETRATING TRAUMA, EMS, ALS, 27D\r\n4092 BLUEBIRD DR\r\nmdft.us/?Dh6z3p\r\n1215519\r\nS12 R12 RDO16A PA517\r\n8/27/2012 2:25:38 PM\r
BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days)\r\n3600 WOODLEY RD\r\nmdft.us/?Mf5g96\r\n1215451\r\nS3 S12 TA12 S836 33 B12\r\n8/26/2012 2:36:48 PM
FILL IN, MISC TRANSFER, FIRE\r\n15245 PR FREDERICK RD (RT 231), STATION 2\r\nmdft.us/?d6v4tY\r\n1215448\r\nTA5 TA836 TA1 TA12\r\n8/26/2012 2:18:27 P
MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D\r\n91 SMALLWOOD DR, TACO BELL\r\nmdft.us/?Pkhf7P\r\n1215441\r\nS3 S12 HT3 HT12 PA37 PA609
MVC EMS, BLS, PI, 29A\r\nSMALLWOOD DR W / ST PATRICKS DR\r\nmdft.us/?smTKFV\r\n1215411\r\nS12 R12\r\n8/25/2012 11:29:40 PM
MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D\r\n11920 ACTON LN, AMF WALDORF LANES IFO\r\nmdft.us/?JK66VG\r\n1215393\r\nS3 S12 HT3 HT12
MVC EMS, BLS, PI, 29A\r\n2276 CRAIN HWY, WALDORF LIQUORS IFO\r\nmdft.us/?WS95SK\r\n1215389\r\nS3 R3 S12\r\n8/25/2012 3:32:35 PM
STANDBY, EMS, BLS\r\n3300 MIDDLETOWN RD, WESTLAKE HIGH\r\nmdft.us/?JmWN6s\r\n1215376\r\nEMS12\r\n8/25/2012 12:23:47 PM
UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n2860 LYON CT\r\nmdft.us/?Pdb3mF\r\n1215368\r\nS3 R3 39 S12\r\n8/25/2012 10:54:30 AM\r\nPERMIT# R142547
STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE\r\n7835 HAWTHORNE RD\r\nmdft.us/?JXvLRm\r\n1215352\r\nS1 S8 T11 SQ7 S12 T3 S10 TA1 TA8 R51 51
STRUC, ODOR OF SMOKE - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG\r\n3750 CRAIN HWY, HAMPTON INN\r\nmdft.us/?WW3tS4\r\n1215348\r\nS3
SPILL LEAK FROM AUTO, NO FIRE, GASOLINE\r\n5715 SPRINGFISH PL\r\nmdft.us/?RhM7xm\r\n1215340\r\nS12\r\n8/24/2012 6:45:33 PM\r\n2001 HONDA ACCORD, SILVE
LANDING SITE, LZ, MISC\r\n6222 PANTHER CT\r\nmdft.us/?ZydLqp\r\n1215261\r\nS12\r\n8/23/2012 3:02:18 PM
MVC EMS, BLS, PI, 29A\r\nBENSVILLE RD / SHANNON DR\r\nmdft.us/?dMKhFz\r\n1215251\r\nS12 R12 129 123 CH12B\r\n8/23/2012 12:07:04 PM
SIT FND WORKING FIRE WF\r\n11025 MALL CIR, ROCK 'N ROLL MCDONALDS\r\nmdft.us/?yShWXt\r\n1215239\r\nS3 S12 T1 S824 T11 SQ840 S836 S2 R60 609 CH3B C
STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS\r\n11025 MALL CIR, ROCK 'N ROLL MCDONALDS\r\nmdft.us/?Zy8gBP\r\n1215239\r\nS3 S12 T1 S8
STRUC, OUTLET SMOKING - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING\r\n4210 QUIGLEY CT\r\nmdft.us/?
STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS\r\n11040 CRAIN HWY, GLASVA CITGO INC\r\nmdft.us/?LSYpfw\r\n1215225\r\nS14 S10 T28 KG2 T
AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE\r\n11829 MURRE CT\r\nmdft.us/?hb29jZ\r\n1215152\r\nS3 S12\r\n8/21/2012 5:27:26 PM\r\nZONE 13 1ST FL
STANDBY, EMS, BLS\r\n2500 DAVIS RD, NORTH POINT HIGH SCHOOL\r\nmdft.us/?myBdBB\r\n1215094\r\nEMS12\r\n8/20/2012 4:43:29 PM\r\nEMS12=1
FILL IN, (2) ENGINE TRANSFER, FIRE\r\n12245 ROCK POINT RD, STATION 14\r\nmdft.us/?2FFb38\r\n1215053\r\nS1 S2 SM2 S12\r\n8/20/2012 12:37:04 AM
ASSIST THE AMBULANCE, MISC\r\n8520 ABELL WAY\r\nmdft.us/?WVcYXr\r\n1215048\r\nS12\r\n8/19/2012 10:51:11 PM
GAS LEAK INSIDE A COMMERCIAL BUILDING OR MF MULTI FAMILY\r\n3835 GATEVIEW PL\r\nmdft.us/?HNkxzs\r\n1215035\r\nS3 S12 T1 R3 399 CH12B 121 S1 S2 33 
AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE\r\n8660 NORMAN DR\r\nmdft.us/?DTc59Q\r\n1215030\r\nS12\r\n8/19/2012 7:38:17 PM\r\nGENERAL FIRE ALAR
WASH DOWN, MISC\r\n7375 BENSVILLE RD\r\nmdft.us/?NZVQJG\r\n1215022\r\nS12\r\n8/19/2012 6:15:02 PM
LANDING SITE, LZ, MISC\r\n6980 BENSVILLE RD, BENSVILLE PARK\r\nmdft.us/?8mCwsx\r\n1215020\r\nS12\r\n8/19/2012 5:36:33 PM
MVC OVERTURNED, EJECTED, ROLLOVER, EMS, ALS, PI, 29D\r\n7375 BENSVILLE RD\r\nmdft.us/?6Cf9hD\r\n1215019\r\nS12 PA127\r\n8/19/2012 5:09:46 PM
UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n4210 SOUTHWINDS PL, RM 410\r\nmdft.us/?MH4d8g\r\n1215008\r\nS12 R12\r\n8/19/2012 2:24:42 PM
AFA - COMMERCIAL BUILDING, ALARM\r\n2040 ST THOMAS DR, STODDERT MIDDLE SCHOOL\r\nmdft.us/?VvG7sK\r\n1214990\r\nS3 S12\r\n8/19/2012 6:15:34 AM\r\nGEN F
STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE\r\n11691 FOUNTAIN HEAD CT\r\nmdft.us/?RGN5HS\r\n1214966\r\nS3 S12 T1 SQ2 E840 T824 S836 R3\r\n8
UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n4210 SOUTHWINDS PL, APT 114\r\nmdft.us/?Xs8yVy\r\n1214964\r\nS12 R60\r\n8/18/2012 7:15:17 PM\r\nUNKN MEDICAL A
 
*/

public class MDCharlesCountyBParser extends FieldProgramParser {
  
  public MDCharlesCountyBParser() {
    super("CHARLES COUNTY", "MD",
           "CALL ADDR URL! ID UNIT DATETIME INFO+");
  }
  
  @Override
  public String getFilter() {
    return "fire12alerting-bounces@sms.mdfiretech.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    return parseFields(body.split("\n"), 3, data);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    int pt = address.indexOf('(');
    if (pt >= 0) address = address.substring(0,pt).trim();
    address = PR_PTN.matcher(address).replaceAll("PRINCE");
    return address;
  }
  private static final Pattern PR_PTN = Pattern.compile("\\bPR\\b", Pattern.CASE_INSENSITIVE);

  
  
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|RM) *(.*)");
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      String extra = null;
      if (pt >= 0) {
        extra = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
      
      if (extra == null) return;
      
      Matcher match = APT_PTN.matcher(extra);
      if (match.matches()) {
        data.strApt = match.group(1);
        return;
      }
      
      extra = extra.replace('@', '/');
      if (extra.contains("/")) {
        data.strCross = extra;
        return;
      }
      
      data.strPlace = extra;
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT X PLACE";
    }
  }
  
  private class MyInfoUrlField extends InfoUrlField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("mdft.us/?")) return false;
      field = "http://" + field;
      super.parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) +(\\d{1,2}:\\d{1,2}:\\d{1,2} [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override 
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) return;
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("URL")) return new MyInfoUrlField();
    if (name.equals("ID")) return new IdField("\\d+", true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
