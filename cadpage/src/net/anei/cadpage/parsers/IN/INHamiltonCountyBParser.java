package net.anei.cadpage.parsers.IN;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
 * Hamilton County, IN (variant B)
 */
public class INHamiltonCountyBParser extends DispatchOSSIParser {
 
  public INHamiltonCountyBParser() {
    super(CITY_CODES, "HAMILTON COUNTY", "IN",
           "MASH INFO+");
    setupCallList();
  }
  
  @Override
  public String getFilter() {
    return "CAD@noblesville.in.us";
  }
  
  private static final Pattern MASH_PRI_PTN = Pattern.compile("^(\\d) +");
  private static final Pattern MASH_UNIT_PTN = Pattern.compile("^([A-Z]+\\d+\\b[,A-Z0-9]*) +");
  private static final Pattern MASH_CROSS_PTN = Pattern.compile(" *\\(S\\) *(.*?) *\\(N\\) *");
  private static final Pattern MASH_APT_PTN = Pattern.compile("^(APT|ROOM|RM|SUITE|BLDG) +([^ ]+)\\b");
  private static final Pattern MASH_SRC_PTN = Pattern.compile("^\\d{2}\\b");
  private class MashField extends Field {
    @Override
    public void parse(String field, Data data) {
      
      int pt = field.indexOf("Event spawned from");
      if (pt >= 0) field = field.substring(0,pt).trim();
      
      if (field.startsWith("FYI:")) field = field.substring(4).trim();
      else if (field.startsWith("Update:")) field = field.substring(7).trim();
      
      Matcher match = MASH_PRI_PTN.matcher(field);
      if (match.find()) {
        data.strPriority = match.group(1);
        field = field.substring(match.end());
      }
      
      match = MASH_UNIT_PTN.matcher(field);
      if (match.find()) {
        data.strUnit = match.group(1);
        field = field.substring(match.end());
      }
      
      int flags = 0;
      String addr = field;
      String extra = null;
      match = MASH_CROSS_PTN.matcher(addr);
      if (match.find()) {
        flags = FLAG_ANCHOR_END;
        data.strCross = match.group(1);
        extra = addr.substring(match.end()).trim();
        addr = addr.substring(0,match.start()).trim();
      }
      
      parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ | flags, addr, data);
      if (extra == null) extra = getLeft();
      
      match = MASH_APT_PTN.matcher(extra);
      if (match.find()) {
        String key = match.group(1);
        String apt = match.group(2);
        char chr = key.charAt(0);
        if (chr != 'R' && chr != 'A') apt = key + ' ' + apt;
        data.strApt = apt;
        extra = extra.substring(match.end()).trim();
      }
      
      match = MASH_SRC_PTN.matcher(extra);
      if (match.find()) {
        data.strSource = match.group();
        extra = extra.substring(match.end()).trim();
      }
      data.strSupp = extra;
    }
    
    @Override
    public String getFieldNames() {
      return "PRI UNIT CALL PLACE ADDR APT CITY X SRC";
    }
    
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Radio Channel:")) {
        data.strChannel = field.substring(14).trim();
        return;
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CH INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MASH")) return new MashField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CAR", "CARMEL",
      "FIS", "FISHERS",
      "NOB", "NOBLESVILLE",
      "SHE", "SHERIDAN",
      "WES", "WESTFIELD"
  });
  
  private void setupCallList() {
    setupCallList(
        "10-50 PI",
        "10-50 PI 1",
        "10-50 PI 2",
        "ABD PAIN",
        "ASST OTH",
        "BCK PAIN",
        "BUSN ALM",
        "CARD ARR",
        "CHST PNS",
        "CIT ASST",
        "DIABETIC",
        "DIFF BRE",
        "GAS ODOR",
        "HRT PROB",
        "INJ PRSN",
        "INST ALM",
        "INST ALM 1",
        "INST ALM 2",
        "INVEST",
        "MED ????",
        "MED ASST",
        "METH LAB",
        "METNL PT",
        "MINOR PI",
        "MUTL AID",
        "ODOR INV",
        "OVERDOSE",
        "RESD ALM",
        "RES FIRE",
        "RES FIRE 1",
        "RES FIRE 2",
        "SEIZURE",
        "SICK PSN",
        "STROKE",
        "UNKN MED",
        "UNCN PSN",
        "VEH BLDG"
    );
    
  }
}
