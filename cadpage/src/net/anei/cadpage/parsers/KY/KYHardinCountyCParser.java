package net.anei.cadpage.parsers.KY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramHtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class KYHardinCountyCParser extends FieldProgramHtmlParser {
// private static final String STEM = "/home/brennus/html/KYHardinCountyC-S";
// private static int ndx = 1;
  public KYHardinCountyCParser() {
    super(CITY_CODE,
            "HARDIN COUNTY",
            "KY",
            "ID ADDR APT PLACE X CITY DATE TIME CALL PRI UNIT MAP NAME PHONE INFO",
            LAYOUT);
    translate(TRANS);
  }
  
  @Override
  public String getFilter() {
    return "no-reply@hcky.org";
  }

  @Override
  public String getProgram() {
      return "ID ADDR APT PLACE X CITY DATE TIME CALL PRI UNIT MAP NAME PHONE INFO";
  }
  
  private static final Pattern SUBJECT_PATTERN
    = Pattern.compile("(Dispatch|Clear) Report Incident #(\\d{10})");
  private static final Pattern DIRTY_ADDR_PATTERN
    = Pattern.compile("\\d+&#\\d+;(.*)");
  private static final DateFormat MY_DATE_FMT
    = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    boolean isDispatch;
    
    if (!getHtmlCleaner(body))
      return false;

//    makeFile(STEM+ndx+".html");
//    ndx++;
    
    Matcher m = SUBJECT_PATTERN.matcher(subject);
    if (m.matches()) {
      isDispatch = m.group(1).equals("Dispatch");
      data.strCallId = m.group(2);
    }
    else
      return false;
    
     if (isDispatch) {
      String address = getValue("ADDRESS");
      m = DIRTY_ADDR_PATTERN.matcher(address);
      if (m.matches())
        address = m.group(1);
      parseAddress(StartType.START_ADDR, address, data);
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, getValue("CITY"), data);
      data.strCross = getValue("CROSS");
      data.strCall = getValue("CALL");
      data.strDate = getValue("DATE");
      data.strTime = getValue("TIME");
      data.strUnit = getValue("UNIT");
      data.strPlace = append(data.strPlace, " - ", getValue("PLACE"));
      data.strMap = getValue("MAP");
      data.strSupp = getValue("INFO");
    }
    else {
      setDateTime(MY_DATE_FMT, getValue("CDATETIME"), data);
      data.strUnit = getValue("CUNIT");
      parseAddress(StartType.START_ADDR, getValue("CLOCATION"), data);
      data.strPlace = getValue("CPLACE");
      data.strPhone = getValue("CPHONE").replace("(   )    -", "").trim();
      data.strCall = getValue("CCALL");
//      data.strPriority = getValue("CPRI");
      data.strName = getValue("CNAME");
      data.strSupp = getValue("CINFO");
    }
    
    return true;
  }
  
  private static final String[] LAYOUT = {
    // Dispatch layout
    "ADDRESS(DIV=0;ELEMENT=DIV;LABEL=/Address:/;CLOSEST)",
    "CROSS(DIV=0;ELEMENT=DIV;LABEL=/Cross:/;OFFSET=2,3;SEPARATOR=/ / /;EXCLUDE=/:/)",
    "CALL(DIV=0;ELEMENT=DIV;LABEL=/Nature:/;CLOSEST)",
    "DATE(DIV=0;ELEMENT=DIV;LABEL=/Date:/;CLOSEST)",
    "TIME(DIV=0;ELEMENT=DIV;LABEL=/Time Out:/;CLOSEST)",
    "CITY(DIV=0;ELEMENT=DIV;LABEL=/City:/;CLOSEST)",
    "UNIT(DIV=0;ELEMENT=DIV;LABEL=/Units:/;CLOSEST)",
    "PLACE(DIV=0;ELEMENT=DIV;LABEL=/Business:/;CLOSEST)",
    "MAP(DIV=0;ELEMENT=DIV;LABEL=/Neighborhood:/;CLOSEST)",
    "INFO(DIV=0;ELEMENT=DIV;LABEL=/Notes:/;CLOSEST)",
    // Clear layout
    "CDATETIME(DIV=0;ELEMENT=DIV;LABEL=/Time Received:/;CLOSEST;XMAX=200)",
    "CUNIT(DIV=0;ELEMENT=DIV;LABEL=/Unit:/;OFFSET=1)",
    "CLOCATION(DIV=0;ELEMENT=DIV;LABEL=/Location:/;CLOSEST;YMIN=0)",
    "CPLACE(DIV=0;ELEMENT=DIV;LABEL=/Business:/;CLOSEST;XMIN=-15)",
    "CPHONE(DIV=0;ELEMENT=DIV;LABEL=/Phone:/;CLOSEST;XMIN=0;EXCLUDE=/Event Log/;MULTIPLE)",
    "CCALL(DIV=0;ELEMENT=DIV;LABEL=/Nature:/;CLOSEST;YMIN=0)",
//    "CPRI(DIV=0;ELEMENT=DIV;LABEL=/Priority:/;CLOSEST;XMIN=45;YMIN=0;XMAX=50;SEPARATOR=/ - /;MULTIPLE)",
    "CNAME(DIV=0;ELEMENT=DIV;LABEL=/Caller:/;CLOSEST)",
    "CINFO(DIV=0;ELEMENT=DIV;LABEL=/Notes:/;CLOSEST;YMAX=250;MULTIPLE)"
  };
  
  private static final Properties CITY_CODE = buildCodeTable(new String[] {
    
    // Incorporated Places
    "ELIZ",           "ELIZABETHTOWN",
    "MULDRAUGH",      "MULDRAUGH",
    "RADCLIFF",       "RADCLIFF",
    "SON",            "SONORA",
    "UPTON",          "UPTON",
    "VINE GROVE",     "VINE GROVE",
    "WEST POINT",     "WEST POINT",
    
    // Counties
    "CTY",            "HARDIN COUNTY",
    "LRCO",           "LARUE COUNTY",

    // Census-designated places
    "FORT KNOX",      "FORT KNOX",

    // Unincorporated places
    "BIG SPRING",     "BIG SPRING",
    "BLUE BALL",      "BLUE BALL",
    "CECILIA",        "CECILIA",
    "COLESBURG",      "COLESBURG",
    "DEVER HOLLOW",   "DEVER HOLLOW",
    "EASTVIEW",       "EASTVIEW",
    "GLENDALE",       "GLENDALE",
    "HARCOURT",       "HARCOURT",
    "HOWELL SPRING",  "HOWELL SPRING",
    "HARDIN SPRINGS", "HARDIN SPRINGS",
    "HOWEVALLEY",     "HOWE VALLEY",
    "MILL CREEK",     "MILL CREEK",
    "NEW FRUIT",      "NEW FRUIT",
    "NOLIN",          "NOLIN",
    "QUAKER VALLEY",  "QUAKER VALLEY",
    "RED MILLS",      "RED MILLS",
    "RINEYVILLE",     "RINEYVILLE",
    "ST. JOHN",       "ST. JOHN",
    "STAR MILLS",     "STAR MILLS",
    "STEPHENSBURG",   "STEPHENSBURG",
    "SUMMITT",        "SUMMITT",
    "TIP TOP",        "TIP TOP",
    "TUNNEL HILL",    "TUNNER HILL",
    "VERTREES",       "VERTREES",
    "WHITE MILLS",    "WHITE MILLS",
    "YOUNGERS CREEK", "YOUNGERS CREEK",
    
    // Mead County
    "EKRON",          "EKRON",
    "GUSTON",         "GUSTON",
  });
  
  private static final String[] TRANS = {
    "&nbsp;",         " ",
    "&#8209;",        "-"
  };
}
