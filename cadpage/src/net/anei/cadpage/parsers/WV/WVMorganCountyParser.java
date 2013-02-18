package net.anei.cadpage.parsers.WV;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/**
 * Hampshire County, WV
 */
public class WVMorganCountyParser extends DispatchBParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d{1,2}:MORGANCO911@FRONTIER.COM:");

  public WVMorganCountyParser() {
    super(CITY_CODES, "MORGAN COUNTY", "WV");
    setupCallList((CodeSet)null);
  }
  
  @Override
  public String getFilter() {
    return "MORGANCO911@FRONTIER.COM";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    body = subject + " @ " + body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{

    // Cities and Towns
    "BATH ",                    "BATH ",
    "BERKELEY",                 "BERKELEY SPRINGS",
    "PAW PAW",                  "PAW PAW",
   
    // Unincorporated communities
    "BERRYVILL",                "BERRYVILLE",
    "BURNT FAC",                "BURNT FACTORY",
    "CAMPBELLS",                "CAMPBELLS",
    "CHERRY RU" ,               "CHERRY RUN",
    "DOE GULLY",                "DOE GULLY",
    "DUCKWALL",                 "DUCKWALL",
    "GREAT CAC",                "GREAT CACAPON", 
    "GREEN RID",                "GREEN RIDGE",
    "GREENWOOD",                "GREENWOOD",
    "HANCOCK",                  "HANCOCK",
    "HANSROTE",                 "HANSROTE",
    "HOLTON",                   "HOLTON",
    "JEROME",                   "JEROME",
    "JIMTOWN",                  "JIMTOWN",
    "JOHNSONS",                 "JOHNSONS MILL",
    "LARGENT",                  "LARGENT",
    "LINEBURG",                 "LINEBURG",
    "MAGNOLIA",                 "MAGNOLIA",
    "MOUNT TRI",                "MOUNT TRIMBLE",
    "NEW HOPE",                 "NEW HOPE",
    "NORTH BER",                "NORTH BERKELEY",
    "OAKLAND",                  "OAKLAND",
    "OMPS",                     "OMPS",
    "ORLEANS C",                "ORLEANS CROSS ROADS",
    "REDROCK C",                "REDROCK CROSSING",
    "RIDERSVIL",                "RIDERSVILLE",
    "RIDGE",                    "RIDGE",
    "ROCK GAP",                 "ROCK GAP",
    "SIR JOHNS",                "SIR JOHNS RUN",
    "SLEEPY CR",                "SLEEPY CREEK",
    "SMITH CRO",                "SMITH CROSSROADS",
    "SPOHRS CR",                "SPOHRS CROSSROADS",
    "STOTLERS",                 "STOTLERS CROSSROADS",
    "UNGER",                    "UNGER",
    "WOODMONT",                 "WOODMONT",
    "WOODROW",                  "WOODROW",
    
    // Berkeley County
    "HEDGESVIL",                "HEDGESVILLE"
  });
}
