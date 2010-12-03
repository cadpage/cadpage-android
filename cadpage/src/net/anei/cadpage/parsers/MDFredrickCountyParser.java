package net.anei.cadpage.parsers;

import java.util.Properties;
import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser.StartType;

/***
(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 6801 HARBAUGH RD CSAB:NEXT TO HER HOME ESZ: 626 MAP: 3996A6 Disp: [23]
(CAD) [FredCo] CT: WOODS FIRE 7819-B FRIENDS CREEK RD CEMB ESZ: 627 MAP: 3996F6 Disp: E63,B66,DNR [36]
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 4 PAWS PL THUR: @CATOCTIN VETERINARY CLINIC ESZ: 1001 MAP: 4108E9 Disp: E102,TWR6 [37]
(CAD) [FredCo] CT: OUTSIDE INVESTIGATION @MA ADAM CO: @RT15SB/BOYLE RD ESZ: -1 Disp: E63 [38]
       This was a mutual aid call to Adams Co. Pa at Rt.15 South Bound at the Boyle Rd. overpass
(CAD) [FredCo] CT: HOUSE / ODOR 9152 OLD KILN RD CEMB ESZ: 617 MAP: 4109E4 Disp: E63,E102,A268,TWR6,ET64 [39]
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 102 OLD OAK PL THUR ESZ: 1001 MAP: 4222D2 Disp: E102,TWR6 [41]
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / WATERFLOW 100 CREAMERY CT: @EMMITSBURG GLASS CO ESZ: 620 MAP: 3997K9 Disp: E63,TWR6 [42]
(CAD) [FredCo] CT: PERSON FIRE (INSIDE) 16825 S SETON AVE CEMB: @NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB ESZ: 620 MAP: 3997H9 Disp: [34]                    Rmk:"
***/

public class MDFredrickCountyParser extends SmartAddressParser {

  private static final String[]Fredrickkeywords = new String[]{"CT", "ESZ", "MAP", "Disp",};
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
        "THUR","Thurmont",
        "CEMB","Emmitsburg",
        "CSAB","Sabillasville",
        "CWAL","Walkersville",
        "CFR2","Frederick City",
        "WOOD","Woodsboro",
        "CNMA","New Market",
        "ADAM","Adams County", //PA
        "ADCO","Franklinn County" //PA
    });

  public MDFredrickCountyParser(){
    super(CITY_CODE_TABLE);
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    
    if (!body.contains(" [FredCo] ")) return false;
    
    data.defState = "MD";
    data.defCity = "FREDRICK COUNTY";
    
    body = body.replace("(CAD)", "");
    body = body.replace(" [FredCo] ","");
    
    // If there is a : right after city then there is Supp data between City Code and ESZ:
    
    Properties props = parseMessage(body, Fredrickkeywords);
    String strAddr = props.getProperty("CT");

    
    
    if (strAddr.contains(":")) {
      int idxb = strAddr.length();
      int idxa = strAddr.lastIndexOf(":", idxb);
      data.strSupp = strAddr.substring(idxa + 1,idxb).trim();
      data.strCity = strAddr.substring(idxa-4,idxa);
      strAddr = strAddr.substring(0,idxa);
    } else {
      data.strCity = strAddr.substring(strAddr.length()-4);
    }
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, strAddr, data);
    data.strMap = props.getProperty("MAP", "");
    data.strBox = props.getProperty("ESZ", "");
    data.strUnit = props.getProperty("Disp", "");
    data.strCity = convertCodes(data.strCity, CITY_CODE_TABLE);
    if (data.strUnit.contains("[") && data.strUnit.contains("]")) {
        data.strUnit = data.strUnit.substring(0,data.strUnit.indexOf("["));
        data.strUnit = data.strUnit.trim();
      }
    return true;
  }
}