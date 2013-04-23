package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class VALoudounCountyParser extends MsgParser {
  
  public VALoudounCountyParser() {
    super("LOUDOUN COUNTY", "VA");
    setFieldList("CALL ADDR CITY APT X UNIT BOX MAP");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt =0;
    // Clean off extra junk at both ends
    if (body.contains("Call:")){ //Old Format call
        pt = body.indexOf("Call:");
        if (pt < 0) return false;
      body = body.substring(pt);
      pt = body.lastIndexOf('[');
    if (pt >= 0) body = body.substring(0, pt).trim();
    
    } else if (body.contains("CALL:")) { //New Format
      if (body.contains("Subject:")){ // Get rid of email and subject for split messages
        int disa = body.lastIndexOf("msg§");
        int disb = body.lastIndexOf("Subject:");
        
        body= body.substring(0,disa) + body.substring(disb+12);
        
      }
      pt = body.indexOf("CALL:");
      if (pt < 0) return false;
      body = body.substring(pt);
      
        pt = body.lastIndexOf("FDID:");
      if (pt >= 0) body = body.substring(0, pt).trim();
      
    }

    // Needs some massaging before it can be run through the standard parser
    body = body.replace(" Apt:", ",Apt:");
    Properties props = parseMessage(body, ",", new String[]{"Addr", "Unit"});
    data.strCall = props.getProperty("Call", "");
    parseAddressCity(props.getProperty("Addr", ""), data);
    if (data.strAddress.length() == 0) return false;
    data.strApt = props.getProperty("Apt");
    if (data.strApt == null) return false;
    data.strCross = props.getProperty("X-St");
    if (data.strCross == null) return false;
    data.strUnit = props.getProperty("Unit", "");
    data.strBox = props.getProperty("Box", "");
    String sMap = props.getProperty("ADC", "");
    pt = sMap.indexOf('[');
    if (pt >= 0) sMap = sMap.substring(0,pt).trim();
    data.strMap = sMap;
    data.strCity = convertCodes(data.strCity, LCFRCityCodes);
    
    return true;
  }

  private static final Properties LCFRCityCodes = buildCodeTable(new String[]{
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
        "PV", "Purcellville",
        "PS", "Paeonian",
        "RH", "Round Hill",
        "UP", "Upperville",
        "FX19", "Fairfax",
        "FX11", "Fairfax",
        "FX", "Fairfax",
        "FQ", "Faquier"});
}
