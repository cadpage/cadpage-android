package net.anei.cadpage.parsers.IN;



import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Parke County, IN
 */
public class INParkeCountyParser extends DispatchA29Parser {
  
  public INParkeCountyParser() {
    super(CITY_LIST, "PARKE COUNTY", "IN");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@bloomingdaletel.com";
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "9007 ACCIDENT: UNKNOWN",
      "9027 BLEEDING HEMORRAGE",
      "9035 CHEST PAINS",
      "9047 DIABETIC PROBLEM",
      "9048 DIFFICULTY BREATHING",
      "9049 DISABLED VEHICLE",
      "9052 DROWNING",
      "9061 FALLS",
      "9063 FIRE-BRUSH",
      "9065 FIRE-CONTROLLED BURN",      
      "9068 FIRE-VEHICLE",
      "9080 HEAD INJURY",
      "9108 OVERDOSE",
      "9126 SEIZURES",
      "9151 TREEDOWN",
      "9153 UNKNOWN",
      "9161 WEAKNESS",
      "9163 WELFARE CHECK"

  );
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and towns
    "BLOOMINGDALE",
    "MARSHALL",
    "MECCA",
    "MONTEZUMA",
    "ROCKVILLE",
    "ROSEDALE",
 
    // Townships
    "ADAMS",
    "FLORIDA",
    "GREENE",
    "HOWARD",
    "JACKSON",
    "LIBERTY",
    "PENN",
    "RACCOON",
    "RESERVE",
    "SUGAR CREEK",
    "UNION",
    "WABASH",
    "WASHINGTON"
      
  };
}
