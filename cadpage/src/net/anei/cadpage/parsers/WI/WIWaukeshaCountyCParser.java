package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.dispatch.DispatchA36Parser;


public class WIWaukeshaCountyCParser extends DispatchA36Parser {
 
  public WIWaukeshaCountyCParser() {
    super(CITY_LIST, "BRANTLEY COUNTY", "GA", 1);
  }
  
  @Override
  public String getFilter() {
    return "PhoenixNotification@elmgrovewi.org";
  }
  
  private static String[] CITY_LIST = new String[]{
      
      //Cities

      "BROOKFIELD",
      "DELAFIELD",
      "MILWAUKEE",
      "MUSKEGO",
      "NEW BERLIN",
      "OCONOMOWOC",
      "PEWAUKEE",
      "WAUKESHA",

      // Villages

      "BIG BEND",
      "BUTLER",
      "CHENEQUA",
      "DOUSMAN",
      "EAGLE",
      "ELM GROVE",
      "HARTLAND",
      "LAC LA BELLE",
      "LANNON",
      "MENOMONEE FALLS",
      "MERTON",
      "MUKWONAGO",
      "NASHOTAH",
      "NORTH PRAIRIE",
      "OCONOMOWOC LAKE",
      "PEWAUKEE",
      "SUMMIT",
      "SUSSEX",
      "WALES",

      //Towns
      
      "BROOKFIELD",
      "DELAFIELD",
      "EAGLE",
      "GENESEE",
      "LISBON",
      "MERTON",
      "MUKWONAGO",
      "OCONOMOWOC",
      "OTTAWA",
      "VERNON",
      "WAUKESHA",

      //Census-designated place

      "OKAUCHEE LAKE",

      //Unincorporated communities

      "BETHESDA",
      "BUENA VISTA",
      "CAMP WHITCOMB",
      "COLGATE",
      "EAGLEVILLE",
      "GENESEE DEPOT",
      "GOERKE'S CORNERS",
      "GUTHRIE",
      "JERICHO",
      "LAKE FIVE",
      "MAPLETON",
      "MONCHES",
      "MONTEREY",
      "NORTH LAKE",
      "OTTAWA",
      "SAYLESVILLE",
      "STONE BANK",
      "SUMMIT CENTER",
      "SUMMIT CORNERS",
      "VERNON",

      //Ghost towns/Neighborhoods

      "CALHOUN",
      "DODGES CORNERS",
      "DENOON",
      "MENOMONEE",
      "MUSKEGO SETTLEMENT",
      "NEW UPSALA"

  };
 }
