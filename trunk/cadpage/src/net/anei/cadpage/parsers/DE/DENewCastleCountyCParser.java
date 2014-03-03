package net.anei.cadpage.parsers.DE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import net.anei.cadpage.parsers.dispatch.DispatchA7Parser;

public class DENewCastleCountyCParser extends DispatchA7Parser {
  
  public DENewCastleCountyCParser() {
    super(CITY_SET, CITY_CODES, "NEW CASTLE COUNTY", "DE", A7_FLG_ADDR_MAP_CODE);
  }
  
  @Override
  public String getFilter() {
    return "CAD_DONOTREPLY@NCCDE.ORG";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "ARDEN",
      "ARDENCROFT",
      "ARDENTOWN",
      "BELLEFONTE",
      "CLAYTON",
      "DELAWARE CITY",
      "ELSMERE",
      "MIDDLETOWN",
      "NEW CASTLE",
      "NEWARK",
      "NEWPORT",
      "ODESSA",
      "SMYRNA",
      "TOWNSEND",
      "WILMINGTON",

      "BEAR",
      "BROOKSIDE",
      "CLAYMONT",
      "COLLINS PARK",
      "CHRISTIANA",
      "EDGEMOOR",
      "GLASGOW",
      "GREENVILLE",
      "HOCKESSIN",
      "HOLLY OAK",
      "MARSHALLTON",
      "MINQUADALE",
      "MONTCHANIN",
      "MONTCHANIN VILLAGE",
      "NORTH STAR",
      "OGLETOWN",
      "PORT PENN",
      "PIKE CREEK",
      "ROCKLAND",
      "ST GEORGES",
      "STANTON",
      "WILMINGTON MANOR",
      "WINTERTHUR",
  
      "BETHAL TWP",
      "BETHEL TWP",
      "FAIRFAX",
      "TALLEYVILLE"
  }));
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BETHAL TWP",   "BETHEL TWP,PA",
      "BETHEL TWP",   "BETHEL TWP,PA",
      "MONTCHANIN VILLAGE", "MONTCHANIN"
  });
}
  