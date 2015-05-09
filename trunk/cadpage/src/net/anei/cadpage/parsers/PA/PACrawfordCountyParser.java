package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;


public class PACrawfordCountyParser extends DispatchB3Parser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("(?:CRAWFORD COUNTY +911 )?(?:CRAWFORD_COUNTY_911:|OESCAD:|OESCAD@WINDSTREAM.NET:)");

  public PACrawfordCountyParser() {
    super(PREFIX_PTN, CITY_LIST, "CRAWFORD COUNTY", "PA");
    removeWords("CIRCLE", "TRL");
    
    // Normally DispatchB3Parser subclasses do not need the call and multiple
    // word street lists because the subject splits them out nicely.  But
    // Crawford County sends text alerts in the default DispatchB2Parser fallback
    // format, so we have to cover that case as well.
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "ATLANTIC LAKE",
        "BLOOMING VALLEY",
        "BOCKMAN HOLLOW",
        "BROWN HILL",
        "CAMBRIDGE SPRINGS",
        "CAPTAIN WILLIAMS",
        "CONNEAUT LAKE",
        "COUNTY LINE",
        "DRAKE HILL",
        "FOREST GREEN",
        "FRENCH CREEK",
        "GOSPEL HILL",
        "GRANGE CENTER",
        "GRAVEL RUN",
        "HATCH HILL",
        "JOHN BROWN",
        "LEBOEUF TRAIL",
        "LEBOEUF TRL",
        "LITTLE COOLEY",
        "MAPLE HILL",
        "MORNING VIEW",
        "MYSTIC PARK",
        "NICKEL PLATE",
        "OWEN HILL",
        "PARK LANE",
        "POST OFFICE",
        "POST RIDGE",
        "ROGERS FERRY",
        "SHADY ACRES",
        "STAR ROUTE",
        "STEEN HILL",
        "SWIFT HILL",
        "TOURS END",
        "TROY CENTER",
        "WHITE HILL",
        "WHITE OAK"
    );
  }
  
  @Override
  public String getFilter() {
    return "OESCAD@WINDSTREAM.NET,CRAWFORD_COUNTY_911@oescad.com,4702193542";
  }
  
  @Override
  public String adjustMapAddress(String address) {
    return WASHINGTON_STREET_EXT.matcher(address).replaceAll("$1");
  }
  private static final Pattern WASHINGTON_STREET_EXT = Pattern.compile("\\b(WASHINGTON ST(?:REET)?) EXT?\\b");
  
  @Override
  protected int getExtraParseAddressFlags() {
    return FLAG_CROSS_FOLLOWS;
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    int pt = body.indexOf(" Reply STOP ");
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strCity.toUpperCase().endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    } else if (data.strCity.endsWith(" CO")) {
      data.strCity += "UNTY";
      if (data.strCity.equals("VNG COUNTY")) data.strCity = "VENANGO COUNTY";
    } else if (data.strCity.equals("LEBOUF TWP")) data.strCity = "LEBOEUF TWP";
    
    if (data.strCallId.length() == 0) data.expectMore = true;
    return true;
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ALLERGIC REACTION",
      "ALTERED LOC",
      "ASSAULT",
      "ATV ACCIDENT",
      "BEHAVIORAL DISORDER",
      "BLEEDING",
      "BRUSH FIRE",
      "CARBON MONOXIDE INVESTIGATION",
      "CARDIAC ARREST",
      "CARDIAC SYMPTOMS",
      "CHECK WELFARE",
      "CHEST PAINS",
      "DEBRIS ON ROADWAY",
      "DIABETIC",
      "DIFFICULTY BREATHING",
      "DISABLED VEHICLE",
      "DIZZINESS",
      "DOMESTIC",
      "DRILL",
      "EMS/QRS DEPT OUT OF SERVICE",
      "EMS TRANSPORT",
      "FALL VICTIM",
      "FIRE ALARM",
      "FIRE STANDBY",
      "FLU LIKE SYMPTOMS",
      "GENERAL ILLNESS",
      "GI PROBLEM",
      "HEAD INJURY",
      "HIT & RUN",
      "LIFT ASSIST",
      "MATERNITY",
      "MEDICAL ALARM",
      "MISC FIRE",
      "MISSING PERSON",
      "MVA NO INJURY",
      "MVA UNKNOWN INJURY OR ENTRAP",
      "MVA WITH INJURY",
      "MVA WITH INJURY & ENTRAPMENT",
      "NATURAL GAS LEAK",
      "ODOR INVESTIGATION",
      "OVERDOSE",
      "PAIN GENERAL",
      "PEDESTRIAN STRUCK",
      "POSSIBLE DOA",
      "POST SURGICAL COMPLICATION",
      "PUBLIC SERVICE DETAIL",
      "SEIZURES",
      "STROKE/CVA",
      "STRUCTURE FIRE",
      "STRUCTURE FIRE W ENTRAPMENT",
      "SUSPICIOUS PERSON",
      "SYNCOPE",
      "TRAFFIC CONTROL",
      "TRAMATIC INJURY",
      "TREES/WIRES DOWN URGENT",
      "UNCONSCIOUS SUBJECT",
      "UNKNOWN",
      "UNKNOWN TYPE FIRE",
      "VEHICLE FIRE",
      "WARRANT SERVICE"
  );
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "MEADVILLE",
    "TITUSVILLE",
    
    "MEADVILLE CITY",
    "TITUSVILLE CITY",
    
    // Boroughs
    "BLOOMING VALLEY",
    "CAMBRIDGE SPRINGS",
    "CENTERVILLE",
    "CONNEAUT LAKE",
    "CONNEAUTVILLE",
    "COCHRANTON",
    "HYDETOWN",
    "LINESVILLE",
    "SAEGERTOWN",
    "SPARTANSBURG",
    "SPRINGBORO",
    "TOWNVILLE",
    "VENANGO",
    "WOODCOCK",

    "BLOOMING VALLEY BORO",
    "CAMBRIDGE SPRINGS BORO",
    "CENTERVILLE BORO",
    "CONNEAUT LAKE BORO",
    "CONNEAUTVILLE BORO",
    "COCHRANTON BORO",
    "HYDETOWN BORO",
    "LINESVILLE BORO",
    "SAEGERTOWN BORO",
    "SPARTANSBURG BORO",
    "SPRINGBORO BORO",
    "TOWNVILLE BORO",
    "VENANGO BORO",
    "WOODCOCK BORO",

    // Townships
    "ATHENS TWP",
    "BEAVER TWP",
    "BLOOMFIELD TWP",
    "CAMBRIDGE TWP",
    "CONNEAUT TWP",
    "CUSSEWAGO TWP",
    "EAST FAIRFIELD TWP",
    "EAST FALLOWFIELD TWP",
    "EAST MEAD TWP",
    "EAST MEAD TOWNSHIP",
    "FAIRFIELD TWP",
    "GREENWOOD TWP",
    "HAYFIELD TWP",
    "NORTH SHENANGO TWP",
    "OIL CREEK TWP",
    "PINE TWP",
    "RANDOLPH TWP",
    "RICHMOND TWP",
    "ROCKDALE TWP",
    "ROME TWP",
    "SADSBURY TWP",
    "SOUTH SHENANGO TWP",
    "SPARTA TWP",
    "SPRING TWP",
    "STEUBEN TWP",
    "SUMMERHILL TWP",
    "SUMMIT TWP",
    "TROY TWP",
    "UNION TWP",
    "VENANGO TWP",
    "VERNON TWP",
    "WAYNE TWP",
    "WEST FALLOWFIELD TWP",
    "WEST MEAD TWP",
    "WEST SHENANGO TWP",
    "WOODCOCK TWP",
    
    // Ashtabula County
    "ASHTABULA CO",
    
    // Erie County
    "ERIE CO",
    "ERIE COUNTY",
    "LEBOUF TWP",  // Misspelled
    "LEBOEUF TWP",
    "SUMMMIT TWP",
    "SUMMIT TOWNSHIP",
    
    // Mercer County
    "MERCER COUNTY",
    "MERCER CO",
    
    "FRENCH CREEK",
    "SANDY LAKE",
    
    "DEER CREEK TWP",
    "FRENCH CREEK TWP",
    
    // Venango County
    "VNG CO",
    "PLUM TWP"
  };
}
