package net.anei.cadpage.parsers.TN;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;

public class TNSevierCountyParser extends DispatchSouthernPlusParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\d+ \\*\\*\\* .*");
  private static final Pattern APT_PLACE_PTN = Pattern.compile("[^ ]+ +[^ ]+ +.*");
  
  public TNSevierCountyParser() {
    super(CITY_LIST, "SEVIER COUNTY", "TN", DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS );
  }
  
  @Override
  public String getFilter() {
    return "Central_Dispatch@mydomain.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    if (UNIT_PTN.matcher(data.strSupp).matches()) {
      data.strUnit = data.strSupp.replace("***", "/");
      data.strSupp = "";
    } else if (UNIT_PTN.matcher(data.strCall).matches()) {
      data.strUnit = data.strCall.replace("***", "/");
      data.strCall = "ALERT";
    }
    data.strApt = stripFieldEnd(data.strApt, "AREA OF");
    data.strAddress = stripFieldEnd(data.strAddress, "AREA OF");
    if (data.strPlace.length() == 0 && APT_PLACE_PTN.matcher(data.strApt).matches()) {
      data.strPlace = data.strApt;
      data.strApt = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " UNIT";
  }

  private static final String[] CITY_LIST = new String[]{

    "ALDER BRANCH",
    "BEECH SPRINGS",
    "BOYDS CREEK",
    "CATLETTSBURG",
    "CATON",
    "CHEROKEE HILLS",
    "COUNTRY CASCADES",
    "COSBY",
    "DUPONT",
    "GATLINBURG",
    "KODAK",
    "LAUREL",
    "OLDHAM",
    "PIGEON FORGE",
    "PITTMAN CENTER",
    "REAGANTOWN",
    "SEVIERVILLE",
    "SEYMOUR",
    "SHADY GROVE",
    "STRAWBERRY PLAINS",
    "TRUNDLES CROSSROADS",
    "WEARS VALLEY"
    
  };

}
