package net.anei.cadpage.parsers.IL;

import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import net.anei.cadpage.parsers.MsgInfo.Data;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class ILClintonCountyParser extends DispatchA41Parser {
 
  public   ILClintonCountyParser() {
    super(null, "CLINTON COUNTY", "AL", null);
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@clintonco.illinois.gov>";
  }
  
  private static final String[] CITY_LIST = new String[]{
      //Cities

      "BREESE",
      "CARLYLE",
      "CENTRALIA",
      "TRENTON",

      //Villages

      "ALBERS",
      "AVISTON",
      "BARTELSO",
      "BECKEMEYER",
      "DAMIANSVILLE",
      "GERMANTOWN",
      "HOFFMAN",
      "HUEY",
      "KEYESPORT",
      "NEW BADEN",
      "ST. ROSE",

      //Townships

      "BREESE",
      "BROOKSIDE",
      "CARLYLE",
      "CLEMENT",
      "EAST FORK",
      "GERMANTOWN",
      "IRISHTOWN",
      "LAKE",
      "LOOKING GLASS",
      "MERIDIAN",
      "SAINT ROSE",
      "SANTA FE",
      "SUGAR CREEK",
      "WADE",
      "WHEATFIELD"


  
  };
}
