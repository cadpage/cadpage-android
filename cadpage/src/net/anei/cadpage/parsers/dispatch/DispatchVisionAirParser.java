package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Hoke County, NC
Hoke Co 911:795 TC JONES RD* * * * * **EMD* * * * * * * * 09/15/2011 14:36:26 : pos4 : mblack3325 ** EMD Case Entry Finished ** Chief Complaint Number: 19 Key Q
Hoke Co 911:385 SUNSET LAKE RD* * * * * **EMD* * * * * * * * 09/19/2011 06:20:35 : pos2 : SCOOPER9403 Cross streets: 7100 ARABIA RD//DEAD END Cross streets: 205
Hoke Co 911:6020 PHILLIPI CHURCH RD* * * * * **26 SICK PERS* * * * * * * * 09/18/2011 00:57:12 : pos1 : LGRADY7274 ** EMD Case Complete ** Key Questions: 46 yea
Hoke Co 911:6020 PHILLIPI CHURCH RD* * * * * **EMD* * * * * * * * 09/18/2011 00:56:49 : pos1 : LGRADY7274 ** EMD Recommended Dispatch ** Response Text: Alpha Di
Hoke Co 911:216 ROLLING PINES CT* * * * * **01 ABD PAIN* * * * * * * * 09/17/2011 19:54:51 : pos2 : SCOOPER9403 205 10-8 09/17/2011 19:54:38 : pos2 : SCOOPER940
Hoke Co 911:216 ROLLING PINES CT* * * * * **EMD* * * * * * * * 09/17/2011 19:37:54 : pos1 : LGRADY7274 ** EMD Recommended Dispatch ** Response Text: Alpha Dispa
Hoke Co 911:265 BETTY`S TRL* * * * * **EMD* * * * * * * * 09/16/2011 19:14:15 : pos2 : SCOOPER9403 Cross streets: 580 EVERITT RD//DEAD END WILL BE IN THE VERY E
Hoke Co 911:730 GALATIA CHURCH RD* * * * * **EMD* * * * * * * * 09/15/2011 13:51:27 : pos4 : mblack3325 Cross streets: 5365 ROCKFISH RD//CUMBERLAND CO LINE*
Hoke Co 911:100 WAYSIDE RD* * * * * **AC/PI* * * * * * * * 04/25/2012 18:18:57 : pos2 : RCRUMPLER3351 Cross streets: FAYETTEVILLE RD//OLD OAK RD*

Stamford, CT
 * 107 EAGLE DR* * * * * 654 STRUCT* * * 203-274-3396* * * * * 6/11/2012 5:32:43 PM : pos2 : SESTABROOK CALLER AND HIS WIFE WILL BE OUT
 * 1035 NEWFIELD AV* * * * * F ALARM* * JEWISH COMM CENTER* 203-322-7900* * * * * 05/29/2012 14:53:36 : pos4 : hkokinchak Landmark: JEWISH COMMUNITY CENTER Cross streets: VINE RD//CLUB RD USA CENT OP 33 800-422-2300 GENERAL FIRE*
 * 2700 BEDFORD ST* C* * * * 654 STRUCT* * * 203- -* * * * * 5/12/2012 10:11:52 PM : pos2 : SESTABROOK FIRE IN APT C. 5/12/2012 10:11:40 PM : pos2 : SESTABROOK FIRE IN APT C. 5/12/2012 10:10:50 PM : pos2 : SESTABROOK Cross streets: LOCUST LN//HIGH RIDGE RD 5/12/2012 10:10:16 PM : pos2 : SESTABROOK: Cross streets: LOCUST:
 * 243 TRESSER BLVD* * * * * 644 MED LIFE* * MARRIOTT STAMFORD* 203-357-9555* * * * * 06/18/2012 09:23:23 : pos1 : AMSMITH ** EMD Case Complete ** 06/18/2012 09:23:20 : pos1 : AMSMITH ** EMD Recommended Dispatch ** Response Text: Charlie Dispatch Level: 06C01 CAD Incident Code: 06C01 Key Questions: 56 year old, Male, Co
 * 58 E CROSS RD* * * * * 654 STRUCT* * JAMES* 203-595-6454* * * * * 06/18/2012 13:36:31 : pos1 : AMSMITH Cross streets: HOPE ST//HAWKS HILL RD SMELL OF SMOKE OR ELECTRICAL BURNING FROM THE WASHING MACHINE...*
911Fire:* 42 HALLOWEEN BLVD* * * * * 654 STRUCT* * * 203-667-1756* * * * 7/5/2012 11:54:59 PM : pos11 : AMITCHELL SAFETY OFC WARD RESPONDING, NOT ETA... 7/5/2012 11:53:26 PM : pos11 : AMITCHELL UNIT 4, REQUESTING FIRE MARSHALL, AND SAFETY OFFICER... 7/5/2012 11:50:17 PM : pos8 : CZARMSKY EVACUATED 07/05/2012 23:48:46 : pos12 : JMASTRO E3 RIT TEAM 07/05/2012 23:47:30 : pos4 : LJORDHAMO NUMEROUS CALL..PARTIES ALL OUT 07/05/2012 23:47:10 : pos2 : HFALLON ADVISED TO EVACUATE 07/05/2012 23:47:01 : pos2 : HFALLON ANOTHER CALLER SEE FLAMES IN THE BASEMENT 07/05/2012 23:46:21 : pos3 : MSEMMEL Cross streets: GLEASON AV//SAINT MARYS ST FIRE IN THE BASEMENT*

*/

public class DispatchVisionAirParser extends FieldProgramParser {
  
  private String[] prefixs;
  
  public DispatchVisionAirParser(String prefix, String defCity, String defState) {
    this(new String[]{prefix}, defCity, defState);
  }
  
  public DispatchVisionAirParser(String[] prefixs, String defCity, String defState) {
    super(defCity, defState,
           "ADDR APT UNK UNK UNK CALL UNK PLACENAME PHONE UNK+? EXTRA! INFO+");
    this.prefixs = prefixs;
  }
  
  private static final Pattern DELIM = Pattern.compile("(?<!\\*)\\* ");

  @Override
  protected boolean parseMsg(String body, Data data) {
    boolean found = false;
    for (String prefix : prefixs) {
      if (body.startsWith(prefix)) {
        body = body.substring(prefix.length()).trim();
        found = true;
        break;
      }
    }
    if (!found) return false;
    if (body.endsWith("*")) body = body.substring(0,body.length()-1).trim();
    return parseFields(DELIM.split(body), 12, data);
  }
  
  private static final Pattern START_STAR_PTN = Pattern.compile("^\\*+");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = START_STAR_PTN.matcher(field).replaceFirst("");
      super.parse(field, data);
    }
  }

  private static final Pattern EXTRA_MARKER = Pattern.compile("^(\\d?\\d/\\d?\\d/\\d{4}) (\\d?\\d:\\d?\\d:\\d?\\d(?: [AP]M)?) : (pos\\d+) : ");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private static final Pattern CLEANUP_PTN = Pattern.compile("\\*\\* EMD (?:Case Entry Finished|Case Complete|Recommended Dispatch) \\*\\*|\\bResponse Text:|\\bKey Questions:");
  private class BaseExtraField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = EXTRA_MARKER.matcher(field);
      if (!match.find()) return false;
      data.strDate = match.group(1);
      String time = match.group(2);
      if (time.endsWith("M")) {
        setTime(TIME_FMT, time, data);
      } else {
        data.strTime = time;
      }
      data.strChannel = match.group(3);
      field = field.substring(match.end()).trim();
      
      field = field.replace("//", "/");
      int pt = field.indexOf("Cross streets:");
      if (pt >= 0) {
        String extra = field.substring(pt+14).trim();
        field = field.substring(0,pt).trim();
        Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, extra);
        if (res.getStatus() > 0) {
          res.getData(data);
          field = append (field, " / ", res.getLeft());
        } else {
          data.strCross = extra;
        }
      }
      field = CLEANUP_PTN.matcher(field).replaceAll("").trim().replaceAll("  +", " ");
      data.strSupp = append(data.strSupp, "\n", field);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME CH X INFO";
    }
  }
  
  private class UnknownField extends Field {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = field;
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("EXTRA")) return new BaseExtraField();
    if (name.equals("UNK")) return new UnknownField();
    return super.getField(name);
  }
  
  
}
