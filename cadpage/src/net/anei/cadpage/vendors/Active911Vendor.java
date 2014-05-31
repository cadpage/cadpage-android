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
    if (address.startsWith("+")) address =address.substring(1);
    return PHONE_SET.contains(address);
  }
  
  @Override
  String[] convertLocationCode(String location) {
    String missingParsers = null;
    StringBuilder sb = new StringBuilder();
    Set<String> parserSet = new HashSet<String>();
    
    for (String loc : location.split(",")){
      loc = loc.trim();
      if (loc.contains("/")) {
        String newLoc = POLY_CODE_TABLE.getProperty(loc);
        if (newLoc == null) {
          if (missingParsers == null) {
            missingParsers = loc;
          } else {
            missingParsers = missingParsers + ',' + loc;
          }
          newLoc = "General";
        }
        if (newLoc.equals("N/A")) continue;
        loc = newLoc;
      }
      if (parserSet.add(loc)) {
        if (sb.length() > 0) sb.append(',');
        sb.append(loc);
      }
    }
    return new String[]{sb.toString(), missingParsers};
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
      "CA/AB/ClearwaterCounty",           "ZCAABClearwaterCounty",
      "CA/AB/highriver",                  "ZCAABCanmore",
      "US/AL/AthensLimestoneCounty",      "ALLimestoneCounty",
      "US/AL/ChambersCounty",             "ALChambersCounty",
      "US/AL/Cherokee",                   "ALCherokee",
      "US/AL/ChiltonCounty",              "AL/ChiltonCounty",
      "US/AL/Colbert",                    "ALColbertCountyParser",
      "US/AL/Hoover",                     "ALHoover",
      "US/AL/MarshallCounty",             "ALMarshallCounty",
      "US/AL/MorganCounty",               "ALMorganCounty",
      "US/AL/Shelby",                     "ALShelbyCounty",
      "US/AL/TalladegaCounty",            "ALTalladega",
      "US/AL/Tallapoosa911",              "StandardA",
      "US/AR/LifeNetEms",                 "ARGarlandCounty",
      "US/CA/CalaverasCounty",            "CACalaverasCounty",
      "US/CA/CDFandGrassValleyECC",       "CAPlacerCountyParser",
      "US/CA/CityofNapa",                 "CANapa",
      "US/CA/CityofRocklin",              "CARocklin",
      "US/CA/CityofSLakeTahoe",           "CASouthLakeTahoe",
      "US/CA/CSB",                        "CASanBernardinoCountyB",
      "US/CA/Hanford",                    "CAHanford",
      "US/CA/Hayward",                    "CAHayward",
      "US/CA/LakeCounty",                 "CALakeCounty",
      "US/CA/MendocinoCounty",            "CAMendocinoCounty",
      "US/CA/Monterey",                   "CAMontereyCountyParser",
      "US/CA/OrovillePD",                 "CAPlacerCounty",
      "US/CA/CityofPasoRobles",           "CAPasoRobles",
      "US/CA/SanBernardinoCounty",        "CASanBernardinoCounty",
      "US/CA/SantaCruzCounty",            "CASantaCruzCounty",
      "US/CA/SantaCruzlimited",           "CASantaCruzCounty",
      "US/CA/SonomaCounty",               "CASonomaCounty",
      "US/CA/StanislausCounty",           "CAStanislausCounty",
      "US/CO/ColoradoSprings",            "COElPasoCountyB",
      "US/CO/DeltaCountyAmbulance",       "CODeltaCounty",
      "US/CO/ElPasoCounty",               "COElPasoCountyA",
      "US/CO/WeldCounty",                 "COWeldCounty",
      "US/CT/DMS",                        "CTFairfieldCountyB",
      "US/CT/Groton",                     "CTGroton",
      "US/CT/WaterfordFD",                "CTWaterfordTownParser",
      "US/DE/ChiefMsg",                   "DESussexCountyA",
      "US/DE/Dover",                      "DEKentCounty",
      "US/FL/BayCounty",                  "FLBayCounty",
      "US/FL/CharlotteCountySheriff",     "FLCharlotteCounty",
      "US/FL/CollierCounty",              "FLCollierCounty",
      "US/FL/Hendry",                     "FLHendryCounty",
      "US/FL/LongboatKey",                "FLManateeCounty",
      "US/FL/PalmBeachCounty",            "FLPalmBeachCounty",
      "US/FL/SeminoleCounty",             "FLSeminoleCounty",
      "US/GA/SouthsideFire",              "GAChathamCounty",
      "US/GA/WhiteCounty",                "GAWhiteCounty",
      "US/ID/BlaineCounty",               "IDBlaineCounty",
      "US/ID/KootenaiCounty",             "IDKootenaiCountyParser",
      "US/IL/AdamsCounty",                "ILAdamsCounty",
      "US/IL/DownersGrove",               "ILDuPageCountyB",
      "US/IL/GlenCarbon",                 "ILMadisonCounty",
      "US/IL/KaneCounty",                 "ILKaneCounty",
      "US/IN/Bristol",                    "INElkhartCounty",
      "US/IN/HancockCounty",              "INHancockCounty",
      "US/IN/LakeCounty",                 "INLakeCounty",
      "US/IN/ShelbyCounty",               "INShelbyCounty",
      "US/IN/VigoCounty",                 "INVigoCounty",
      "US/KS/CowleyCounty",               "KSCowleyCounty",
      "US/KS/JohnsonCounty",              "KSJohnsonCounty",
      "US/KS/LeavenworthCounty",          "KSLeavenworthCounty",
      "US/KS/MontgomeryCounty",           "KSMontgomeryCounty",
      "US/KS/NeoshoCounty",               "KSNeoshoCounty",
      "US/KY/BooneCounty",                "KYBooneCounty",
      "US/KY/CampbellCounty",             "KYCampbellCounty",
      "US/KY/GallatinCounty",             "KYGallatinCounty",
      "US/KY/HardinCounty",               "KYHardinCountyC",
      "US/KY/LawrenceCounty",             "KYLawrenceCounty",
      "US/KY/Louisville",                 "KYLouisville",
      "US/KY/MadisonCounty",              "KYMadisonCounty",
      "US/LA/AscensionParish",            "LAAscensionParish",
      "US/LA/LafourcheParish",            "LALafourcheParish",
      "US/LA/TerrebonneParish",           "LATerrebonneParish",
      "US/LA/WestBatonRougeCouncil",      "LAWestBatonRougeParish",
      "US/MD/CecilCounty",                "Cadpage",
      "US/MD/HarfordCounty",              "Cadpage",
      "US/MD/PrinceGeorgesCounty",        "MDPrinceGeorgesCounty",
      "US/MD/PrintManager",               "MDAnneArundelCountyAnnapolis",
      "US/MD/QueenAnnesCounty",           "MDQueenAnnesCounty",
      "US/MD/WashingtonCounty",           "MDWashingtonCounty",
      "US/MI/AlleganCounty",              "MIAlleganCounty",
      "US/MI/BayCounty",                  "MIBayCountyB",
      "US/MI/CalhounCounty",              "MICalhounCounty",
      "US/MI/CharlevoixCounty",           "MICharlevoixCounty",
      "US/MI/GrandTraverse",              "MIGrandTraverseCounty",
      "US/MI/GrandTraverseAttachment",    "MIGrandTraverseCounty",
      "US/MI/InghamCounty",               "MIInghamCounty",
      "US/MN/BloomingtonFD",              "MNMinneapolisStPaul",
      "US/MN/CarverCounty",               "MNCarverCounty",
      "US/MN/DakotaCounty",               "MNDakotaCounty",
      "US/MN/HennepinCounty",             "MN/HennepinCounty",
      "US/MN/SherburneCounty",            "MNSherburneCounty",
      "US/MN/StPaul",                     "MNMinneapolisStPaul",
      "US/MN/WabashaCounty",              "MNWabashaCounty",
      "US/MN/WadenaCounty",               "MNWadenaCounty",
      "US/MN/WashingtonCounty",           "MNWashingtonCounty",
      "US/MN/WinomaCounty",               "MNWinomaCounty",
      "US/MN/WrightCounty",               "MNWrightCounty",
      "US/MO/ADSiCad",                    "MOLawrenceCounty",
      "US/MO/AndrewCounty",               "Cadpage2",
      "US/MO/BarryCounty",                "MOBarryCounty",
      "US/MO/CityofFestus",               "MOFestusB",
      "US/MO/ChristianCounty",            "MOChristianCounty",
      "US/MO/ClintonCounty",              "MOClintonCounty",
      "US/MO/ColeCounty",                 "MOJeffersonCounty",
      "US/MO/CrawfordCounty",             "MOCrawfordCountyB",
      "US/MO/FranklinCounty",             "MOFranklinCounty",
      "US/MO/JeffersonCity",              "MOJeffersonCity",
      "US/MO/LincolnCounty",              "MOLincolnCounty",
      "US/MO/MarshfieldFire",             "MOWebsterCounty",
      "US/MO/PikeCounty",                 "MOLincolnCounty",
      "US/MO/Rejis",                      "MOStLouisCountyE",
      "US/MO/StoneCounty",                "MOStoneCounty",
      "US/MS/Biloxi",                     "MSBiloxi",
      "US/MS/DesotoCounty",               "MSDeSotoCounty",
      "US/MT/GallatinCounty",             "BMTGallatinCounty",
      "US/MT/RavalliCounty",              "MTRavalliCounty",
      "US/NC/AlamanceCounty",             "NCAlamanceCountyParser",
      "US/NC/AlexanderCounty",            "NCAlexanderCounty",
      "US/NC/BrunswickCounty",            "NCBrunswickCounty",
      "US/NC/CabarrusCounty",             "NCCabarrusCountyB",
      "US/NC/CatawbaCounty",              "NCCatawbaCounty",
      "US/NC/Cherokee911",                "NCCherokee",
      "US/NC/Concord",                    "NCCabarrusCountyAParser",
      "US/NC/DavidsonCounty",             "NCDavidsonCounty",
      "US/NC/FranklinCounty",             "NCFranklinCounty",
      "US/NC/GastonCounty",               "NCGastonCounty",
      "US/NC/GatesCounty",                "NCGatesCountyParser",
      "US/MO/GreeneCounty",               "MOGreeneCounty",
      "US/NC/GuilfordCounty",             "NCGuilfordCounty",
      "US/NC/Havelock",                   "NCHavelock",
      "US/NC/PenderCounty",               "NCPenderCounty",
      "US/NC/PittCounty",                 "NCPittCounty",
      "US/NC/SampsonCounty",              "NCSampsonCounty",
      "US/NC/WayneCounty",                "NCWayneCounty",
      "US/NC/WilsonCounty",               "NCWilsonCounty",
      "US/NH/Hanover",                    "NHHanover",
      "US/NH/LRMFA",                      "NHGraftonCounty",
      "US/NJ/EggHarborTownship",          "NJAtlanticCounty",
      "US/NJ/GloucesterCounty",           "NJGloucesterCountyA",
      "US/NJ/HunterdonCounty",            "NJHunterdonCounty",
      "US/NJ/LifeCommCad",                "NJMercerCounty",
      "US/NJ/MercerCounty",               "NJMercerCountyB",
      "US/NJ/NPD",                        "NJSussexCountyA",
      "US/NJ/Nwbcd",                      "NJSussexCountyA",
      "US/NJ/OceanCounty",                "NJOceanCounty",
      "US/NJ/TomsRiverPolice",            "NJOceanCountyB",
      "US/NJ/WayneTownship",              "NJWayneTownship",
      "US/NV/Elko",                       "NVElkoCounty",
      "US/NV/CityofElko",                 "NVElkoCountyA",
      "US/NV/WestWendover",               "NVElkoCountyB",
      "US/NY/Albany",                     "NYAlbanyCountyC",
      "US/NY/BCFA",                       "NYSuffolkCountyB",
      "US/NY/ChiliFD",                    "NYMonroeCounty",
      "US/NY/FireRescueSystems",          "NYSuffolkCountyBFI",
      "US/NY/Lewis911",                   "NYLewisCounty",
      "US/NY/MonroeCounty",               "NYMonroeCountyWebster",
      "US/NY/OntarioCounty",              "NYOntarioCounty",
      "US/NY/OrangeCounty",               "NYOrangeCounty",
      "US/NY/OrangeCounty911",            "NYOrangeCountyB",
      "US/NY/OrleansCounty",              "NYOrleansCounty",
      "US/NY/OswegoCounty",               "NYOswegoCountyB",
      "US/NY/OtsegoCounty",               "NYOtsegoCounty",
      "US/NY/RocklandCounty",             "NYRocklandCountyB",
      "US/NY/Ronkonkoma",                 "NYSuffolkCountyB",
      "US/NY/SCFRESpaging",               "NYSuffolkCountyA",
      "US/NY/SCFRESprinting",             "N/A",
      "US/NY/StLawrenceCounty",           "NYStLawrenceCounty",
      "US/NY/WayneCounty",                "NYWayneCountyB",
      "US/NY/WestchesterCounty",          "NYWestchesterCounty",
      "US/OH/ButlerCountySheriff",        "OHButlerCountyA",
      "US/OH/Fairfield",                  "OHFairfieldCounty",
      "US/OH/HamiltonCounty",             "OHHamiltonCounty",
      "US/OH/HolmesCountySheriff",        "OHHolmesCounty",
      "US/OH/Sebring",                    "OHMahoningCounty",
      "US/OK/CityofTulsa",                "OKTulsaB",
      "US/OK/CherokeeCounty",             "OKCherokeeCounty",
      "US/OK/LoveCounty",                 "OKLoveCounty",
      "US/OR/Benton",                     "ORBentonCounty",
      "US/OR/CityofSalem",                "ORMarionCountyB",
      "US/OR/ClackamasCounty",            "ORClackamasCounty",
      "US/OR/ColumbiaCounty",             "ORColumbiaCounty",
      "US/OR/CookCounty",                 "ORCookCounty",
      "US/OR/DeschutesCounty",            "ORDeschutesCounty",
      "US/OR/GilliamCounty",              "ORGilliamCounty",
      "US/OR/HoodRiverCounty",            "ORHoodRiverCounty",
      "US/OR/Jackson",                    "ORJacksonCounty",
      "US/OR/JeffersonCounty",            "ORJeffersonCounty",
      "US/OR/Josephine",                  "ORJosephineCounty",
      "US/OR/Klamath",                    "ORKlamathCounty",
      "US/OR/LaneCounty",                 "ORLaneCounty",
      "US/OR/Lincoln",                    "ORLincolnCounty",
      "US/OR/Linn",                       "ORLinnCounty",
      "US/OR/MultnomahCounty",            "ORMultnomahCounty",
      "US/OR/NewbergFire",                "ORYamhillCounty",
      "US/OR/PrinevillePD",               "ORCrookCounty",
      "US/OR/ShermanCounty",              "ORShermanCounty",
      "US/OR/WashingtonCounty",           "ORWashingtonCounty",
      "US/OR/Woodburn",                   "ORMarionCounty",
      "US/OR/Yamhill",                    "ORYamhill",
      "US/PA/AdamsCounty",                "PAAdamsCounty",
      "US/PA/AlleghenyCounty",            "PAAlleghenyCounty",
      "US/PA/ArmstrongCounty",            "PAArmstrongCounty",
      "US/PA/BlairCounty",                "PABlairCount",
      "US/PA/BradfordCounty",             "PABradfordCounty",
      "US/PA/BucksEMA",                   "PABucksCountyA",
      "US/PA/CentreCounty",               "PACentreCounty",
      "US/PA/ClearfieldCounty",           "PAClearfieldCounty",
      "US/PA/ColumbiaCounty",             "PAColumbiaCounty",
      "US/PA/CumberlandCounty",           "PACumberlandCounty",
      "US/PA/FDCMS",                      "PAChesterCountyVariant",
      "US/PA/FranklinCounty",             "PAFranklinCounty",
      "US/PA/FultonCounty",               "PAFultonCounty",
      "US/PA/LackawannaCounty",           "PALackawannaCounty",
      "US/PA/LancasterCounty",            "PALancasterCounty",
      "US/PA/LuzerneCounty",              "PALuzerneCounty",
      "US/PA/LehighCounty",               "PALehighCounty",
      "US/PA/MontgomeryCounty",           "PAMontgomeryCountyC",
      "US/PA/SomersetCounty",             "PASomersetCounty",
      "US/PA/TrappeIAR",                  "PAChesterCountyL",
      "US/PA/YorkCounty",                 "PAYorkCountyD",
      "US/SC/GeorgetownCounty",           "SCGeorgetownCounty",
      "US/SC/HartsvilleFD",               "SCDarlingtonCounty",
      "US/SC/OrangeburgCounty",           "OrangeburgCounty",
      "US/SC/PickensCounty",              "SCPickensCounty",
      "US/SD/LincolnCounty",              "SDLincolnCounty",
      "US/SD/MinnehahaCounty",            "SDMinnehahaCounty",
      "US/TN/BedfordCounty",              "TNBedfordCounty",
      "US/TN/CampbellCounty",             "TNCampbellCounty",
      "US/TN/CumberlandCounty",           "TNCumberlandCounty",
      "US/TN/Overton",                    "TNOvertonCounty",
      "US/TX/AngletonPD",                 "TXAngleton",
      "US/TX/Austin",                     "TXTravisCounty",
      "US/TX/BellCounty",                 "TXBellCounty",
      "US/TX/CityofDickinson",            "TXGalvestonCounty",
      "US/TX/CityofKeller",               "TXKeller",
      "US/TX/FlightVector",               "TXFlightVector",
      "US/TX/FreeportDispatch",           "TXBrazoriaCountyB",
      "US/TX/GreggCounty",                "TXGreggCounty",
      "US/TX/HaysCounty",                 "TXHaysCounty",
      "US/TX/HaysUSA",                    "KSHays",
      "US/TX/HuntCounty",                 "TXHuntCounty",
      "US/TX/JohnsonCounty",              "TXJohnsonCountyB",
      "US/TX/Katy",                       "TXCyCreekCommCenter",
      "US/TX/KendallCounty",              "TXKendallCounty",
      "US/TX/LeonCounty",                 "TXLeonCounty",
      "US/TX/Lufkin",                     "TXLufkin",
      "US/TX/Midlothian",                 "TXKeller",
      "US/TX/MontgomeryCounty",           "TXMontgomeryCounty",
      "US/TX/MontgomeryCounty",           "TXMontgomeryCounty",
      "US/TX/NuecesCounty",               "TXNuecesCounty",
      "US/TX/Rosenburg",                  "TXRosenburg",
      "US/TX/RoyseCity",                  "TXRoyseCity",
      "US/TX/Seguin",                     "TXKeller",
      "US/TX/VillageFire",                "TXVillage",
      "US/TX/Wilco",                      "TXWilliamsonCountyB",
      "US/TX/WylieFireDispatch",          "TXWylie",
      "US/UT/BoxElderCounty",             "UTBoxElderCounty",
      "US/VA/AlbermarleCounty",           "VAAlbermarleCounty",
      "US/VA/AppomattoxCounty",           "VAAppomattoxCounty",
      "US/VA/DickensonCounty",            "VADickensonCounty",
      "US/VA/Esva911",                    "VANorthamptonCounty",
      "US/VA/FluvannaSheriff",            "VAFluvanna",
      "US/VA/Franklin",                   "VAFranklinB",
      "US/VA/Hanover",                    "VAHanoverCounty",
      "US/VA/NorthumberlandCounty",       "VANorthumberland",
      "US/VA/PrinceWilliamCounty",        "VAPrinceWilliamCountyA",
      "US/WA/BentonCounty",               "WABentonCounty",
      "US/WA/ValleyCom",                  "WAKingCountyC",
      "US/WA/LewisCounty",                "WALewisCounty",
      "US/WA/RiverComm911",               "WAChelanCounty",
      "US/WA/SnohomishCounty",            "WASnohomishCounty",
      "US/WA/ThurstonCounty",             "WAThurstonCounty",
      "US/WA/WestPierceCounty",           "WAPierceCounty",
      "US/WA/WallaWallaCounty",           "WAWallaWallaCounty",
      "US/WI/MukwonagoFire",              "WIWaukeshaCountyB",
      "US/WI/WaukeshaCounty",             "WaWaukeshaCounty",
      "US/WV/BerkeleyCounty",             "WVBerkeleyCounty",
      "US/WV/LincolnCounty",              "WVLincolnCounty",
      "US/WV/RaleighCounty",              "WVRaleighCounty",
      "Utility/General/Default",          "N/A",
      "Vendor/Cadpage/StandardA",         "StandardA"
  });
}
