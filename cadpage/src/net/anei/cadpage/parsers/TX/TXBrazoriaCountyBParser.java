package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA30Parser;


public class TXBrazoriaCountyBParser extends DispatchA30Parser {
  
  private static final Pattern ALPHA_APT_PTN = Pattern.compile("([A-Z])\\b *(.*)");
  
  public TXBrazoriaCountyBParser() {
    super(CITY_LIST, "F", "BRAZORIA COUNTY", "TX");
    setupMultiWordStreets("STEPHEN F AUSTIN");
  }
  
  @Override
  public String getFilter() {
    return "freeportdispatch@freeport.tx.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    
    // Freeport names some streets AVE [A-Z] where the street
    // name is being misinterpreted as an apt :(
    if (data.strAddress.endsWith(" AVE")) {
      Matcher match = ALPHA_APT_PTN.matcher(data.strApt);
      if (match.matches()) {
        data.strAddress = data.strAddress +  ' ' + match.group(1);
        data.strApt = match.group(2);
      }
    }
    return true;
  }

  private static final String[] CITY_LIST = new String[]{

    // Cities    
    "ALVIN",
    "ANGLETON",
    "BRAZORIA",
    "BROOKSIDE VILLAGE",
    "CLUTE",
    "DANBURY",
    "FREEPORT",
    "LAKE JACKSON",
    "LIVERPOOL",
    "MANVEL",
    "OYSTER CREEK",
    "PEARLAND",
    "RICHWOOD",
    "SANDY POINT",
    "SURFSIDE BEACH",
    "SWEENY",
    "WEST COLUMBIA",

    // Towns
    "HOLIDAY LAKES",
    "QUINTANA",

    // Villages
    "BAILEYS PRAIRIE",
    "BONNEY",
    "HILLCREST",
    "IOWA COLONY",
    "JONES CREEK",

    // CDPs
    "DAMON",
    "WILD PEACH VILLAGE",

    // Other areas
    "AMSTERDAM",
    "ANCHOR",
    "CHENANGO",
    "CHINA GROVE",
    "CHOCOLATE BAYOU",
    "DANCIGER",
    "EAST COLUMBIA",
    "ENGLISH",
    "OLD OCEAN",
    "OTEY",
    "ROSHARON",
    "SNIPE",
    "SILVERLAKE",
    "TURTLE COVE",
    "MCBETH"
  };
}
