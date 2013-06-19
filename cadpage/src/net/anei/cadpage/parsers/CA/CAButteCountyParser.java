package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Butte County, CA
 */
public class CAButteCountyParser extends FieldProgramParser {
  
  public CAButteCountyParser() {
    super(CITY_CODES, "BUTTE COUNTY", "CA",
           "CALL ADDRCITY! X/Z+ Map:MAP Inc:ID! Date-Time:DATETIME! CALL");
  }
  
  @Override
  public String getFilter() {
    return "btucad@fire.ca.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    body = body.replace(" Inc#", " Inc:");
    if (! parseFields(body.split(";"), 6, data)) return false;
    String realCity = CITY_ADJ_TABLE.getProperty(data.strCity);
    if (realCity != null) {
      data.strPlace = data.strCity;
      data.strCity = realCity;
    }
    return true;
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strPlace = field.substring(0,pt).trim();
        field = field.substring(pt+1).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames();
    }
  }
  
  private class MyDateTimeField extends Field {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('/');
      if (pt < 0) abort();
      data.strDate = field.substring(0,pt).trim();
      data.strTime = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BERRY_CRK",      "BERRY CREEK",
      "BGS",            "BIGGS",
      "BIG",            "BIGGS",
      "BNGR",           "BANGOR",
      "BT_COLL",        "BUTTE COLLEGE",
      "BT_CRK_CYN",     "BUTTE CREEK CANYON",
      "BUTTE_MDWS",     "BUTTE MEADOWS",
      "CHEROKEE",       "CHEROKEE",
      "CHI",            "CHICO",
      "COHASSET",       "COHASSET",
      "COL_CO",         "COLUSA COUNTY",
      "CONCOW",         "CONCOW",
      "DRHM",           "DURHAM",
      "EAST_CHICO",     "EAST CHICO",
      "EL_MEDIO",       "EL MEDIO",
      "FTHR_FALLS",     "FEATHER FALLS",
      "FRBSTWN",        "FORBESTOWN",
      "FRST_RNCH",      "FOREST RANCH",
      "GLE_CO",         "GLENN COUNTY",
      "GRD",            "GRIDLEY",
      "GRDLY",          "GRIDLEY",
      "HAM_CITY",       "HAMILTON CITY",
      "HONCUT",         "HONCUT",
      "JARBO_GAP",      "JARBO GAP",
      "KELLY_RDGE",     "KELLY RIDGE",
      "LAS_CO",         "LASSEN COUNTY",
      "LNF_COHASSET",   "COHASSET",
      "LNF",            "LASSEN NATIONAL FOREST",
      "LNF_PLUMAS_CO",  "LASSEN NATIONAL FOREST",
      "MGLA",           "MAGALIA",
      "MOR_RANCH",      "MOORETOWN RANCHERIA",
      "NEU_DOBBINS",    "DOBBINS",
      "NEU_FOOTHILL",   "FOOTHILL FIRE DISTRICT",
      "NEU_LAPORTE",    "LA PORTE",
      "NEU_LRB",        "LOMA RICA",
      "NEU_PNF",        "PUMA NATIONAL FOREST",
      "NEU_SMARTSVILLE","SMARTSVILLE",
      "NEV_CO",         "NEVADA COUNTY",
      "NORD",           "NORD",
      "NOR_CHICO",      "NORTH CHICO",
      "N_OROVILLE",     "NORTH OVOVILLE",
      "ORO",            "OROVILLE",
      "ORVL",           "OROVILLE",
      "PALERMO",        "PALERMO",
      "PDSE",           "PARADISE",
      "PLU_CO",         "PLUMAS COUNTY",
      "PNF_CLPR_MLS",   "CLIPPER MILLS",
      "PNF_FTHR_FALLS", "FEATHER FALLS",
      "PNF_PLUMAS_CO",  "PLUMAS NATIONAL FOREST",
      "PRA",            "PARADISE",
      "RCHVL",          "RICHVALE",
      "ROB_MILL",       "ROBINSON MILLS",
      "SHA_CO",         "SHASTA COUNTY",
      "SIE_CO",         "SIERRA COUNTY",
      "STH_CHICO",      "SOUTH CHICO",
      "STRLNG_CTY",     "STIRLING CITY",
      "SUTTER",         "SUTTER",
      "SUT_CO",         "SUTTER COUNTY",
      "S_OROVILLE",     "SOUTH OROVILLE",
      "TEH_CO",         "TEHAMA COUNTY",
      "TYME_RANCH" ,    "TYME RANCHERIA",
      "TGU_LOS_MOL",    "LOS MOLINOS",
      "TGU_VINA",       "VINA",
      "THERMALITO",     "THERMALITO",
      "WEST_CHICO",     "WEST CHICO",
      "W_OROVILLE",     "WEST OROVILLE",
      "YUB_CO",         "YUBA COUNTY",
      "PNF_BRUSH_CRK",  "BRUSH CREEK",
      "PNF_JARBO_GAP",  "BARBO GAP",
      "LNF_BUTTE_MDWS", "BUTTE MEADOWS",
      "LNF_TEHAMA_CO",  "TEHAMA COUNTY"
  });
  
  private static final Properties CITY_ADJ_TABLE = buildCodeTable(new String[]{
      "BUTTE CREEK CANYON", "CHICO",
      "EAST CHICO",         "CHICO",
      "EL MEDIO",           "OROVILLE",
      "FOOTHILL FIRE DISTRICT", "YUBA COUNTY",
      "KELLY RIDGE",        "OROVILLE",
      "MOORETOWN RANCHERIA","OROVILLE",
      "NORTH CHICO",        "CHICO",
      "NORTH OVOVILLE",     "OROVILLE",
      "SOUTH CHICO",        "CHICO",
      "TYME RANCHERIA",     "OROVILLE",
      "WEST CHICO",         "CHICO",
      "WEST OROVILLE",      "OROVILLE"
  });
}
