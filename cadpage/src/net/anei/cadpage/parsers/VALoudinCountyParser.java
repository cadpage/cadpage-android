package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;

/***
Reporting email: MadisonFD <madisonfd@windstream.net>
Call:12D02E-SEIZURES CONT,42914 OVERLY SQ-CH Apt:,X-St:NORRINGTON SQ KIR,A6092,Box:1908 ,ADC:5520 G06 [90]
Call:17D03-FALL PATIENT N,42848 RECTORS CHASE WAY-AB Apt:,X-St:HOYSVILLE MANOR D,A6092 904 ACO9,Box:2618 ,ADC:5400 G03 [89]
Call:17D03-FALL PATIENT N,42848 RECTORS CHASE WAY-AB Apt:,X-St:HOYSVILLE MANOR D,A6092 904 ACO9,Box:2618 ,ADC:5400 G03 [89]
Call:20D01H-HEAT EXPOSURE,STONE SPRINGS BLVD-AL/MINERAL SPRINGS CIR-AL Apt:,X-St:GREENSTONE DR & M,A6092 9942 ACO9,Box:0910 ,ADC:5520 B02 [77]
***/

public class VALoudinCountyParser extends SmsMsgParser {

  private static Properties LCFRCityCodes = buildCodeTable(new String[]{
        "CH", "Chantilly",
        "LB", "Leesburg",
        "AL", "Aldie",
        "ST", "Sterling",
        "MB", "Middleburg",
        "AB", "Ashburn",
        "SP", "Sterling",
        "BL", "Bluemont",
        "CE", "Centreville",
        "HA", "Hamilton",
        "LV", "Lovettsville",
        "PA", "Paris",
        "PV", "Purceville",
        "PS", "Paeonian",
        "RH", "Round Hill",
        "UP", "Upperville",
        "FX19", "Fairfax",
        "FX", "Fairfax",
        "FQ", "Faquier"});

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("Call:");
  }

  @Override
  protected void parse(String body, Data data) {

    Log.v("decodeLCFRPage: Message Body of:" + body);
    data.defState = "VA";

    // Needs some massaging before it can be run through the standard parser
    body = body.replace(" Apt:", ",Apt:");
    Properties props = parseMessage(body, ",", new String[]{"Addr", "Unit"});
    data.strCall = props.getProperty("Call", "");
    parseAddress(props.getProperty("Addr", ""), data);
    data.strApt = props.getProperty("Apt", "");
    data.strCross = props.getProperty("X-st", "");
    data.strUnit = props.getProperty("Unit", "");
    data.strBox = props.getProperty("Box", "");
    data.strMap = props.getProperty("ADC", "");
    
    data.strCity = convertCodes(data.strCity, LCFRCityCodes);
  }
}
