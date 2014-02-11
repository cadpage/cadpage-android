package net.anei.cadpage.vendors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import android.net.Uri;
import net.anei.cadpage.R;
import net.anei.cadpage.parsers.MsgParser;

class Active911Vendor extends Vendor {
  
  Active911Vendor() {
    super(R.string.active911_title,
           R.string.active911_summary,
           R.string.active911_text,
           R.drawable.active_911_vendor,
           R.drawable.active_911_logo,
           "https://www.active911.com",
           ">A91",
           null);
  }

  @Override
  boolean isSponsored() {
    return true;
  }

  @Override
  boolean isAvailable() {
    return true;
  }
  
  @Override
  String getResponseMenu(int index) {
    switch (index) {
    case 1:
      return "R=Respond;A=Arrive;Y=Available;N=Unavailable;C=Cancel";
    
    default:
      return null;
    }
  }
  
  @Override
  int getVersion() {
    return 1;
  }

  @Override
  Uri getBaseURI(String req) {
    Uri uri = super.getBaseURI();
    if (req.equals("register") || req.equals("info") || req.equals("profile")) {
      return uri.buildUpon().appendPath("cadpage_registration").build();
    } else {
      return uri.buildUpon().appendPath("interface").appendPath("cadpage_api.php").build();
    }
  }

  @Override
  boolean isVendorAddress(String address) {
    if (address.startsWith("+")) address = address.substring(1);
    return PHONE_SET.contains(address);
  }
  
  @Override
  String convertLocationCode(String location) {
    StringBuilder sb = new StringBuilder();
    for (String loc : location.split(",")) {
      loc = loc.trim();
      String tmp = POLY_CODE_TABLE.getProperty(loc);
      if (tmp != null) loc = tmp;
      if (sb.length() > 0) sb.append(',');
      sb.append(loc);
    }
    return sb.toString();
  }

  private static final Set<String> PHONE_SET = new HashSet<String>(Arrays.asList(new String[]{
      "15123376259",
      "19145173586",
      "17272191279",
      "15417047704",
      "18434800223",
      "17172203767",
      "13364058803",
      "17783836218",
      "12027690862",
      "12032083335",
      "12052010901",
      "12072093315",
      "12706810905",
      "12765240572",
      "13046587002",
      "13072222635",
      "13134010041",
      "13172967331",
      "13603424100",
      "14012973063",
      "14029881004",
      "14046926092",
      "14052534266",
      "14062244055",
      "14242208369",
      "14433202484",
      "14805356958",
      "15013131847",
      "15046621719",
      "15052065036",
      "15132024579",
      "15744008669",
      "16013452163",
      "16052207124",
      "16086207759",
      "16093087467",
      "16122000004",
      "16156252978",
      "16363233043",
      "16418470032",
      "16783903000",
      "17012044024",
      "17196025911",
      "17572062724",
      "17736146018",
      "17752307392",
      "18019006459",
      "18022304149",
      "19134989068",
      "19783931289"
  }));
  
  private static Properties POLY_CODE_TABLE = MsgParser.buildCodeTable(new String[]{
      "BTXJohnsonCounty",                   "TXJohnsonCountyB",
      "CA/AB/highriver",                    "ZCAABCanmore",
      "CA/QC/Pincourt",                     "General",
      "US/AL/AthensLimestoneCounty",        "ALLimestoneCounty",
      "US/AL/Colbert",                      "ALColbertCountyParser",
      "US/AL/Hoover",                       "ALHoover",
      "US/AL/Shelby",                       "ALShelbyCounty",
      "US/CA/CDFandGrassValleyECC",         "CAPlacerCountyParser",
      "US/CA/CityofSLakeTahoe",             "CASouthLakeTahoe",
      "US/CA/Hayward",                      "CAHayward",
      "US/CA/Kern",                         "General",
      "US/CA/LakeCounty",                   "CALakeCounty",
      "US/CA/Monterey",                     "CAMontereyCountyParser",
      "US/CA/OrovillePD",                   "CAPlacerCounty",
      "US/CA/SanBernardinoCounty",          "CASanBernardinoCounty",
      "US/CA/SantaClaraCountyFD",           "General",
      "US/CO/Bretsaps",                     "General",
      "US/CO/ColoradoSprings",              "COElPasoCountyB",
      "US/CO/DeltaCountyAmbulance",         "Cadpage2",
      "US/CO/ElPasoCounty",                 "COElPasoCountyA",
      "US/CO/OlatheFire",                   "Cadpage2",
      "US/CO/WeldCounty",                   "COWeldCounty",
      "US/CT/Cheshire",                     "General",
      "US/CT/Groton",                       "CTGroton",
      "US/CT/OldSaybrook",                  "Cadpage2",
      "US/CT/WaterfordFD",                  "CTWaterfordTownParser",
      "US/FL/BayCounty",                    "FLBayCounty",
      "US/FL/CalhounCounty",                "Cadpage2",
      "US/FL/CharlotteCountySheriff",       "FLCharlotteCounty",
      "US/FL/Hendry",                       "FLHendryCounty",
      "US/FL/SeminoleCounty",               "General",
      "US/GA/BarrowCounty",                 "General",
      "US/GA/SouthsideFire",                "GAChathamCounty",
      "US/ID/KootenaiCounty",               "IDKootenaiCountyParser",
      "US/IL/DownersGrove",                 "General",
      "US/IL/FairviewHeights",              "Cadpage2",
      "US/IN/Bristol",                      "Cadpage2",
      "US/IN/JasperCounty",                 "US/IN/JasperCounty",
      "US/IN/LakeCounty",                   "INLakeCounty",
      "US/IN/MadisonCounty",                "Cadpage2",
      "US/IN/ShelbyCounty",                 "General",
      "US/IN/SwitzerlandCounty",            "General",
      "US/IN/WayneCounty",                  "General",
      "US/KS/LeavenworthCounty",            "General",
      "US/KS/NeoshoCounty",                 "General",
      "US/KS/RiceCounty",                   "General",
      "US/KY/CampbellCounty",               "KYCampbellCounty",
      "US/KY/Nexigen",                      "Cadpage2",
      "US/LA/TerrebonneParish",             "LATerrebonneParish",
      "US/MD/CecilCounty",                  "Cadpage2",
      "US/MD/HarfordCounty",                "Cadpage2",
      "US/MD/PrinceGeorgesCounty",          "MDPrinceGeorgesCounty",
      "US/MD/WashingtonCounty",             "MDWashingtonCounty",
      "US/MI/AlleganCounty",                "MIAlleganCounty",
      "US/MI/BayCounty",                    "Cadpage2",
      "US/MI/BerrienCounty",                "General",
      "US/MI/CalhounCounty",                "MICalhounCounty",
      "US/MI/GrandTraverse",                "MIGrandTraverseCounty",
      "US/MI/GrandTraverseAttachment",      "MIGrandTraverseCounty",
      "US/MI/Livonia",                      "General",
      "US/MN/BloomingtonFD",                "MNMinneapolisStPaul",
      "US/MN/CarverCounty",                 "MNCarverCounty",
      "US/MN/CrowWingCounty",               "General",
      "US/MN/Edina",                        "General",
      "US/MN/GoodhueCounty",                "US/MN/GoodhueCounty",
      "US/MN/OtterTailCounty",              "General",
      "US/MN/SherburneCounty",              "MNSherburneCounty",
      "US/MN/WadenaCounty",                 "US/MN/WadenaCounty",
      "US/MN/WrightCounty",                 "General",
      "US/MO/ADSiCad",                      "General",
      "US/MO/CityofFestus",                 "General",
      "US/MO/LincolnCounty",                "MOLincolnCounty",
      "US/MO/LincolnCounty",                "MOLincolnCounty",
      "US/MO/MarshfieldFire",               "MOWebsterCounty",
      "US/MO/PikeCounty",                   "MOLincolnCounty",
      "US/MO/SouthernBoone",                "General",
      "US/MS/Biloxi",                       "MSBiloxi",
      "US/MT/RavalliCounty",                "General",
      "US/NC/AlamanceCounty",               "NCAlamanceCountyParser",
      "US/NC/AlexanderCounty",              "NCAlexanderCounty",
      "US/NC/BrunswickCounty",              "NCBrunswickCounty",
      "US/NC/CabarrusCounty",               "NCCabarrusCountyB",
      "US/NC/CabarrusCounty",               "NCCabarrusCountyB",
      "US/NC/Concord",                      "NCCabarrusCountyAParser",
      "US/NC/DavidsonCounty",               "NCDavidsonCounty",
      "US/NC/FranklinCounty",               "NCFranklinCounty",
      "US/NC/GatesCounty",                  "NCGatesCountyParser",
      "US/NC/Havelock",                     "General",
      "US/NC/PenderCounty",                 "NCPenderCounty",
      "US/NC/RobesonCounty",                "General",
      "US/NC/SampsonCounty",                "NCSampsonCounty",
      "US/NH/Hanover",                      "NHHanover",
      "US/NJ/EggHarborTownship",            "Cadpage2",
      "US/NJ/GloucesterCounty",             "NJGloucesterCountyA",
      "US/NJ/HamiltonTownship",             "General",
      "US/NJ/Mahwah",                       "General",
      "US/NJ/MahwahPD",                     "General",
      "US/NJ/OceanCounty",                  "NJOceanCounty",
      "US/NJ/WayneTownship",                "NJWayneTownship",
      "US/NM/LasCruces",                    "General",
      "US/NV/Elko",                         "General",
      "US/NV/WinnemuccaCityFD",             "General",
      "US/NY/BCFA",                         "NYSuffolkCounty",
      "US/NY/CentralIslip",                 "NYSuffolkCounty",
      "US/NY/CommackFD",                    "General",
      "US/NY/DutchessCounty",               "General",
      "US/NY/MonroeCounty",                 "NYMonroeCountyWebster",
      "US/NY/Ronkonkoma",                   "NYSuffolkCounty",
      "US/NY/SCFRESpaging",                 "NYSuffolkCounty",
      "US/NY/StLawrenceCounty",             "NYStLawrenceCounty",
      "US/NY/WashingtonCounty",             "General",
      "US/NY/WayneCounty",                  "NYWayneCountyB",
      "US/NY/WestchesterCounty",            "NYWestchesterCounty",
      "US/OH/Harveysburg",                  "General",
      "US/OH/HolmesCountySheriff",          "OHHolmesCounty",
      "US/OK/LoveCounty",                   "OKLoveCounty",
      "US/OR/Benton",                       "ORBentonCounty",
      "US/OR/ClackamasCounty",              "ORClackamasCounty",
      "US/OR/ColumbiaCounty",               "ORColumbiaCounty",
      "US/OR/CookCounty",                   "ORCookCounty",
      "US/OR/DeschutesCounty",              "ORDeschutesCounty",
      "US/OR/GilliamCounty",                "General",
      "US/OR/GreshamSAR",                   "General",
      "US/OR/HoodRiverCounty",              "ORHoodRiverCounty",
      "US/OR/Jackson",                      "ORJacksonCounty",
      "US/OR/JeffersonCounty",              "ORJeffersonCounty",
      "US/OR/Klamath",                      "ORKlamathCounty",
      "US/OR/LaneCounty",                   "ORLaneCounty",
      "US/OR/Linn",                         "ORLinnCounty",
      "US/OK/LoveCounty",                   "OKLoveCounty",
      "US/OR/NewbergFire",                  "ORYamhillCounty",
      "US/OR/PrinevillePD",                 "ORCrookCounty",
      "US/OR/ShermanCounty",                "General",
      "US/OR/WashingtonCounty",             "ORWashingtonCounty",
      "US/OR/Woodburn",                     "ORMarionCounty",
      "US/OR/Yamhill",                      "ORYamhill",
      "US/PA/AlleghenyCounty",              "PAAlleghenyCounty",
      "US/PA/CentreCounty",                 "General",
      "US/PA/FDCMS",                        "PAChesterCounty",
      "US/PA/GladwyneFire",                 "General",
      "US/PA/LackawannaCounty",             "General",
      "US/PA/LancasterCounty",              "PALancasterCounty",
      "US/PA/Lionville",                    "General",
      "US/PA/MessiahEMS",                   "General",
      "US/PA/SomersetCounty",               "PASomersetCounty",
      "US/PA/Springfield",                  "Cadpage2",
      "US/SC/NewberryCounty",               "General",
      "US/SC/PickensCounty",                "General",
      "US/SD/MinnehahaCounty",              "SDMinnehahaCounty",
      "US/TN/BedfordCounty",                "TNBedfordCounty",
      "US/TN/Overton",                      "TNOvertonCounty",
      "US/TX/AngletonPD",                   "General",
      "US/TX/Austin",                       "TXTravisCounty",
      "US/TX/HaysCounty",                   "TXHaysCounty",
      "US/TX/JohnsonCounty",                "TXJohnsonCountyB",
      "US/TX/Katy",                         "General",
      "US/TX/KendallCounty",                "TXKendallCounty",
      "US/TX/NuecesCounty",                 "TXNuecesCounty",
      "US/TX/RoyseCity",                    "General",
      "US/TX/SanMarcosCounty",              "General",
      "US/TX/VillageFire",                  "Cadpage2",
      "US/TX/West",                         "General",
      "US/TX/WylieFireDispatch",            "TXWylie",
      "US/VA/Esva911",                      "VANorthamptonCounty",
      "US/VA/GloucesterCounty",             "General",
      "US/VA/Hanover",                      "VAHanoverCounty",
      "US/VA/NewportNews",                  "General",
      "US/VA/PetersburgPD",                 "General",
      "US/Vendor/CISPlaceholder",           "General",
      "US/WA/SpokaneCounty",                "Cadpage2",
      "US/WA/USAMobility",                  "General",
      "US/WA/WestPierceCounty",             "WAPierceCounty",
      "US/WI/MukwonagoFire",                "WIWaukeshaCountyB",
      "US/WI/RacineCounty",                 "General",
      "US/WV/BerkeleyCounty",               "WVBerkeleyCounty",
      "US/WV/LincolnCounty",                "General",
      "US/WV/RoaneCounty",                  "General",
      "US/WV/Wyoming",                      "General",
      "Utility/General/Default",            "General",
      "Vendor/Enterpol/Default",            "General",
      "Vendor/NewWorldSystems/Default",     "General",
      "Vendor/Phoenix/Default",             "General"
      
  });
}
