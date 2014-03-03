package net.anei.cadpage.parsers.NJ;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchArchonixParser;



public class NJCamdenCountyAParser extends DispatchArchonixParser {
  
  public NJCamdenCountyAParser() {
    super(CITY_CODES, "CAMDEN COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "cccademail@camdencounty.com";
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
    "01",    "Audubon",
    "01 01", "Audubon",
    "02",    "Audubon Park",
    "02 02", "Audubon Park",
    "03",    "Barrington",
    "03 03", "Barrington",
    "04",    "Bellmawr",
    "04 04", "Bellmawr",
    "05",    "Berlin",
    "05 05", "Berlin",
    "06",    "Berlin Twp",
    "06 06", "Berlin Twp",
    "07",    "Brooklawn",
    "07 07", "Brooklawn",
    "08",    "Camden City",
    "08 08", "Camden City",
    "09",    "Chesilhurst",
    "09 09", "Chesilhurst",
    "10",    "Clementon",
    "10 10", "Clementon",
    "11",    "Collingswood",
    "11 11", "Collingswood",
    "12",    "Cherry Hill",
    "12 12", "Cherry Hill",
    "13",    "Gibbsboro",
    "13 13", "Gibbsboro",
    "14",    "Gloucester City",
    "14 14", "Gloucester City",
    "15",    "Gloucester Twp",
    "15 15", "Gloucester Twp",
    "16",    "Haddon Twp",
    "16 16", "Haddon Twp",
    "17",    "Haddonfield",
    "17 17", "Haddonfield",
    "18",    "Haddon Heights",
    "18 18", "Haddon Heights",
    "19",    "Hi-Nella",
    "19 19", "Hi-Nella",
    "20",    "Laurel Springs",
    "20 20", "Laurel Springs",
    "21",    "Lawnside",
    "21 21", "Lawnside",
    "22",    "Lindenwold",
    "22 22", "Lindenwold",
    "23",    "Magnolia",
    "23 23", "Magnolia",
    "24",    "Merchantville",
    "24 24", "Merchantville",
    "25",    "Mount Ephraim",
    "25 25", "Mount Ephraim",
    "26",    "Oaklyn",
    "26 26", "Oaklyn",
    "27",    "Pennsauken Twp",
    "27 27", "Pennsauken Twp",
    "28",    "Pine Hill",
    "28 28", "Pine Hill",
    "29",    "Pine Valley",
    "29 29", "Pine Valley",
    "30",    "Runnemede",
    "30 30", "Runnemede",
    "31",    "Somerdale",
    "31 31", "Somerdale",
    "32",    "Stratford",
    "32 32", "Stratford",
    "33",    "Tavistock",
    "33 33", "Tavistock",
    "34",    "Voorhees Twp",
    "34 34", "Voorhees Twp",
    "35",    "Waterford Twp",
    "35 35", "Waterford Twp",
    "36",    "Winslow Twp",
    "36 36", "Winslow Twp",
    "37",    "Woodlyne",
    "37 37", "Woodlyne"
  });

}
