package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Hancock County, IL
 */
public class ILHancockCountyParser extends DispatchA29Parser {
    
  public ILHancockCountyParser() {
    super(CITY_LIST, "HANCOCK COUNTY", "IL");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@Hancock911.com";
  }
    
  private static final CodeSet CALL_LIST = new CodeSet(
      
      "5",
      "10 CHEST PAIN",
      "12 CONVULSONS / SEIZURES",
      "13 DIABETIC PROBLEMS",
      "23 OVERDOSE",
      "25 PSYCHIATRIC / AB BEHAVIOR / SUICIDE ATTEMPT",
      "29",
      "32 UNKNOWN PROBLEM (MAN DOWN)",
      "8111 TS TRAFFIC STOP"

  );

  private static final String[] CITY_LIST = new String[]{
    
  //Cities
      
      "CARTHAGE",
      "DALLAS CITY",
      "HAMILTON",
      "LA HARPE",
      "NAUVOO",
      "WARSAW",

  //TOWN

      "BENTLEY",

  //VILLAGES

      "AUGUSTA",
      "BASCO",
      "BOWEN",
      "ELVASTON",
      "FERRIS",
      "PLYMOUTH",
      "PONTOOSUC",
      "WEST POINT",

  //UNINCORPORATED COMMUNITIES

      "ADRIAN",
      "BURNSIDE",
      "COLMAR",
      "COLUSA",
      "DENVER",
      "ELDERVILLE",
      "FOUNTAIN GREEN",
      "LA CROSSE",
      "MCCALL",
      "NIOTA",
      "STILLWELL",
      "SUTTER",
      "WEBSTER",

  //TOWNSHIPS

      "APPANOOSE",
      "BEAR CREEK",
      "CARTHAGE",
      "CHILI",
      "DALLAS CITY",
      "DURHAM",
      "HANCOCK",
      "HARMONY",
      "PILOT GROVE",
      "PONTOOSUC",
      "PRAIRIE",
      "ROCK CREEK",
      "ROCKY RUN",
      "ST. ALBANS",
      "ST. MARY'S",
      "SONORA",
      "WALKER",
      "WARSAW",
      "WILCOX",
      "WYTHE",

  };
}
