package net.anei.cadpage.parsers.WA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class WAKingCountyCParser extends DispatchA41Parser {

  public WAKingCountyCParser() {
    super(CITY_CODES, "KING COUNTY", "WA", A41_FLG_NO_CALL);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALG",  "Algona",
      "AUB",  "Auburn",
      "BEA",  "Beaux Arts",
      "BEL",  "Bellevue",
      "BLA",  "Black Diamond",
      "BON",  "Bonney Lake",
      "BUR",  "Burien",
      "CLY",  "Clyde Hill",
      "COV",  "Covington",
      "DES",  "Des Moines",
      "EDG",  "Edgewood",
      "ENU",  "Enumclaw",
      "FED",  "Federal Way",
      "ISS",  "Issaquah",
      "KEN",  "Kent",
      "MED",  "Medina",
      "MER",  "Mercer Island",
      "MIL",  "Milton",
      "MPV",  "Maple Valley",
      "NBD",  "North Bend",
      "NDP",  "Normandy Park",
      "NEW",  "New Castle",
      "PAC",  "Pacific",
      "PRE",  "Preston",
      "RAV",  "Ravensdale",
      "REN",  "Renton",
      "SAM",  "Sammamish",
      "SEA",  "Seatac",
      "STL",  "Seattle",
      "SUM",  "Sumner",
      "TAC",  "Tacoma",
      "TUK",  "Tukwila",
      "VAS",  "Vashon"
  });
}
