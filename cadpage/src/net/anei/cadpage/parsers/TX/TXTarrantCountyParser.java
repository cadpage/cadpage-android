package net.anei.cadpage.parsers.TX;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;


public class TXTarrantCountyParser extends DispatchRedAlertParser {
  
  private static final Pattern FMRD_PTN = Pattern.compile("\\bF *M(?: +RD)(?= +\\d+)");
  
  public TXTarrantCountyParser() {
    super("TARRANT COUNTY","TX");
    setupMultiWordStreets(MWORD_STREET_LIST);
    setupSpecialStreets("OHIO GARDEN");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = FMRD_PTN.matcher(body).replaceAll("FM");
    return super.parseMsg(subject, body, data);
  }

  private static final String[] MWORD_STREET_LIST = new String[]{
    "ALLEN MILL",
    "AMANDA SPRINGS",
    "ASH MEADOW",
    "AUTUMN HILLS",
    "AVONDALE HASLET",
    "BAILEY BOSWELL",
    "BAY BREEZE",
    "BELLA COLINA",
    "BELLA VINO",
    "BEN DAY MURRIN",
    "BENNETT LAWSON",
    "BEVERLY HILLS",
    "BLACK OAK",
    "BLUE MOUND",
    "BLUE PINE",
    "BLUE PRAIRIE",
    "BOAT CLUB",
    "BONDS RANCH",
    "BRIAR ROSE",
    "BRIDLE BIT",
    "BURLESON RETTA",
    "CASTLEBERRY CUT-OFF",
    "CHAMBERS CREEK",
    "CIRCLE R",
    "CIRCLE RIDGE",
    "CLUB OAK",
    "COMANCHE MOON",
    "CONFEDERATE PARK",
    "COTTONWOOD CREEK",
    "COUNTRY CLUB",
    "COUNTRY DELL",
    "CREEK HOLLOW",
    "CREST RIDGE",
    "CROMWELL MARINE CREEK",
    "DEL RIO",
    "DICK PRICE",
    "DR GARRISON",
    "DROP TINE",
    "EAGLE MOUNTAIN",
    "ED COADY",
    "ELLA YOUNG",
    "ENGLISH CREEK",
    "FAIRWAY BEND",
    "FEATHER WIND",
    "FIRE HALL",
    "FOREST GREEN",
    "FOSTER STUART",
    "GANTT ACCESS",
    "GIBSON CEMETERY",
    "GLEN CROSSING",
    "GRANT SPRINGS",
    "GRAY DOVE",
    "GRIMSLEY GIBSON",
    "HANGER CUTOFF",
    "HICKS AVONDALE SCHOOL",
    "HIDDEN HILL",
    "HIGH MEADOW",
    "HOUSTON HILL",
    "HUDSON CEMETERY",
    "HUDSON VILLAGE CREEK",
    "J BOAZ",
    "J RENDON",
    "JIM WRIGHT",
    "JOHN B SIAS MEMORIAL",
    "KEITH PUMPHERY",
    "KENNEDALE NEW HOPE",
    "KNIGHTING GAIL",
    "LA JUNTA",
    "LA SIERRA",
    "LAKE CREST",
    "LAKE FOREST",
    "LAKE OAKS",
    "LAKE RIDGE",
    "LAKE SHORE",
    "LAKE WORTH",
    "LAMP LIGHTER",
    "LAS BRESAS",
    "LAWRENCE LAKE",
    "LEVY ACRES",
    "LEVY COUNTY LINE",
    "LIBERTY SCHOOL",
    "LIBERTY SCHOOL TAP",
    "LITTLE PRAIRIE",
    "LITTLE RD",
    "LIVE OAK",
    "LONELY OAK",
    "LUCY TRIMBLE",
    "MARY LOU",
    "MILE BRIDGE",
    "MOUNTAIN VIEW",
    "NINE MILE AZLE",
    "NINE MILE BRIDGE",
    "NORTH CREEK",
    "NORTH PARK",
    "NOTRE DAME",
    "OAK BARK",
    "OAK GROVE",
    "OAK HARBOR",
    "OAK MILL",
    "OAK TREE",
    "OHIO GARDEN",
    "PARK CENTER",
    "PARK RIDGE",
    "PINE RIDGE",
    "PLUM CREEK",
    "POWER SQUADRON",
    "PRAIRIE RIDGE",
    "PURPLE SAGE",
    "RED BUD",
    "RED OAK",
    "RENDON BLOODWORTH",
    "RENDON ESTATES",
    "RENDON NEW HOPE",
    "RETTA MANSFIELD",
    "RIDGE COUNTRY",
    "RIDGE VIEW",
    "RIVER OAKS",
    "ROBERTS CUT OFF",
    "ROLLIE MICHAEL",
    "ROLLING MEADOW",
    "ROLLING WOOD",
    "ROUND HILL",
    "RUBY LEA",
    "SAM CALLOWAY",
    "SAN SABA",
    "SANDY BEACH",
    "SANTA FE",
    "SCENIC RIDGE",
    "SEA BREEZE",
    "SHADY OAK",
    "SILVER CR EEK AZLE",
    "SILVER CREEK",
    "SILVER CREEK AZLE",
    "SILVER MESA",
    "SILVER VIEW",
    "SOMMERVILLE PLACE",
    "SPRING GARDEN",
    "ST EDWARDS",
    "STEPHENSON LEVY",
    "SYBLE JEAN",
    "SYCAMORE CREEK",
    "TALL GRASS",
    "TAPATIO SPRINGS",
    "TEN MILE BRIDGE",
    "TENDER FOOT",
    "TIMBER LAKE",
    "TRAILS END",
    "TRIPLE H",
    "TURTLE PASS",
    "TWIN OAKS",
    "TYE CROSSING",
    "VILLAGE GARDEN",
    "VILLAGE OAK",
    "VISTA DEL SOL",
    "VISTA RANCH",
    "WEEPING WILLOW",
    "WELLS BURNETT",
    "WEST FORK",
    "WEST VIEW",
    "WHISPERING OAKS",
    "WHITE OAK",
    "WILLOW CREEK",
    "WILLOW SPRINGS",
    "WINSCOTT PLOVER",
    "WOODED ACRES",
    "YUCCA FLATS"
  };
}
