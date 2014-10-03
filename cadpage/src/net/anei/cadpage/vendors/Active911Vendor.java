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
      "CA/AB/RedDeerCounty",              "ZCAABRedDeerCounty",
      "CA/AB/ClearwaterCounty",           "ZCAABClearwaterCounty",
      "CA/AB/highriver",                  "ZCAABCanmore",
      "CA/BC/MidIsland",                  "ZCABCMidIslandRegion",
      "CA/QC/Quebec",                     "ZCAQCQuebec",
      "NZ/NI/Auckland",                   "ZNZNewZealand",
      "NZ/NI/Northland",                  "ZNZNewZealand",
      "NZ/NI/Waikato",                    "ZNZNewZealand",
      "US/AL/AthensLimestoneCounty",      "ALLimestoneCounty",
      "US/AL/ChambersCounty",             "ALChambersCounty",
      "US/AL/Cherokee",                   "ALCherokee",
      "US/AL/ChiltonCounty",              "ALChiltonCounty",
      "US/AL/CoffeeCounty",               "ALCoffeeCounty",
      "US/AL/CityofPelham",               "ALPelham",
      "US/AL/Colbert",                    "ALColbertCountyParser",
      "US/AL/Hoover",                     "ALHoover",
      "US/AL/MarshallCounty",             "ALMarshallCounty",
      "US/AL/MobileCounty",               "ALMobileCounty",
      "US/AL/MorganCounty",               "ALMorganCounty",
      "US/AL/Shelby",                     "ALShelbyCounty",
      "US/AL/TalladegaCounty",            "ALTalladega",
      "US/AL/Tallapoosa911",              "StandardA",
      "US/AR/CityofRogers",               "ARBentonCountyB",
      "US/AR/LifeNetEms",                 "ARGarlandCounty",
      "US/AZ/NavajoCounty",               "AZNavajoCounty",
      "US/CA/AmadorCounty",               "CAAmadorCounty",
      "US/CA/CalaverasCounty",            "CACalaverasCounty",
      "US/CA/CDFandGrassValleyECC",       "CAPlacerCountyParser",
      "US/CA/CityofNapa",                 "CANapa",
      "US/CA/CityofRocklin",              "CARocklin",
      "US/CA/CityofSLakeTahoe",           "CASouthLakeTahoe",
      "US/CA/ContraCostaCounty",          "CAContraCostaCounty",
      "US/CA/CSB",                        "CASanBernardinoCountyB",
      "US/CA/ElDoradoCounty",             "CAElDoradoCounty",
      "US/CA/FresnoCounty",               "CAFresnoCounty",
      "US/CA/Jpapage",                    "CASanDiegoCountyA",
      "US/CA/Hanford",                    "CAHanford",
      "US/CA/Hayward",                    "CAHayward",
      "US/CA/LakeCounty",                 "CALakeCounty",
      "US/CA/LifecommCellPaging",         "CASanJoaquinCounty",
      "US/CA/MendocinoCounty",            "CAMendocinoCounty",
      "US/CA/Monterey",                   "CAMontereyCountyParser",
      "US/CA/OrovillePD",                 "CAPlacerCounty",
      "US/CA/CityofPasoRobles",           "CAPasoRobles",
      "US/CA/SacramentoFire",             "CASacramentoCounty",
      "US/CA/SanBernardinoCounty",        "CASanBernardinoCountyA",
      "US/CA/SantaClaraCounty",           "CASantaClaraCountyB",
      "US/CA/SantaCruzCounty",            "CASantaCruzCounty",
      "US/CA/SantaCruzlimited",           "CASantaCruzCounty",
      "US/CA/ShastaCounty",               "CAShastaCountyA",
      "US/CA/ShastaCom911",               "CAShastaCountyB",
      "US/CA/SonomaCounty",               "CASonomaCounty",
      "US/CA/StanislausCounty",           "CAStanislausCounty",
      "US/CA/Suisun",                     "CASuisun",
      "US/CO/AdamsCounty",                "COAdamsCounty",
      "US/CO/CityofDurango",              "COLaPlataCounty",
      "US/CO/ColoradoSprings",            "COElPasoCountyB",
      "US/CO/DeltaCountyAmbulance",       "CODeltaCounty",
      "US/CO/DouglasCounty",              "CODouglasCountyA",
      "US/CO/ElPasoCounty",               "COElPasoCountyA",
      "US/CO/CityofGolden",               "COGolden",
      "US/CO/CityofLoveland",             "COLarimerCountyA",
      "US/CO/NWSAlert",                   "StandardNationalWeatherService",
      "US/CO/OlatheFire",                 "Cadpage2",
      "US/CO/MorganCounty",               "COMorganCounty",
      "US/CO/WeldCounty",                 "COWeldCounty",
      "US/CT/CityofLedyard",              "CTNewLondonCounty",
      "US/CT/DMS",                        "CTFairfieldCountyB",
      "US/CT/EastLyme",                   "CTEastLyme",
      "US/CT/Groton",                     "CTGroton",
      "US/CT/LitchfieldCounty",           "CTLitchfieldCountyA",
      "US/CT/WaterfordFD",                "CTWaterfordTownParser",
      "US/CT/Uconn",                      "CTTollandCountyB",
      "US/CT/Valleyshore911",             "CTMiddlesexCounty",
      "US/DE/ChiefMsg",                   "DESussexCountyA",
      "US/DE/Dover",                      "DEKentCounty",
      "US/DE/NewCastleCounty",            "DENewCastleCounty",
      "US/DE/SussexCounty",               "DESussexCounty",
      "US/FL/BayCounty",                  "FLBayCounty",
      "US/FL/CharlotteCountySheriff",     "FLCharlotteCounty",
      "US/FL/CollierCounty",              "FLCollierCounty",
      "US/FL/Hendry",                     "FLHendryCounty",
      "US/FL/LongboatKey",                "FLManateeCounty",
      "US/FL/ManateeCounty",              "FLManateeCounty",
      "US/FL/PalmBeachCounty",            "FLPalmBeachCounty",
      "US/FL/SeminoleCounty",             "FLSeminoleCounty",
      "US/GA/EffinghamCounty",            "GAEffinghamCounty",
      "US/GA/HabershamCounty",            "GAHabershamCounty",
      "US/GA/RabunCounty",                "GARabunCounty",
      "US/GA/SouthsideFire",              "GAChathamCounty",
      "US/GA/WhiteCounty",                "GAWhiteCounty",
      "US/ID/BlaineCounty",               "IDBlaineCounty",
      "US/ID/KootenaiCounty",             "IDKootenaiCountyParser",
      "US/IL/AdamsCounty",                "ILAdamsCounty",
      "US/IL/DownersGrove",               "ILDuPageCountyB",
      "US/IL/GlenCarbon",                 "ILMadisonCounty",
      "US/IL/KaneCounty",                 "ILKaneCounty",
      "US/IL/OFallon",                    "ILOFallon",
      "US/IN/BartholomewCounty",          "INBartholomewCounty",
      "US/IN/Bristol",                    "INElkhartCounty",
      "US/IN/HancockCounty",              "INHancockCounty",
      "US/IN/LakeCounty",                 "INLakeCounty",
      "US/IN/Indianapolis",               "INMarionCounty",
      "US/IN/JasperCounty",               "INJasperCounty",
      "US/IN/KnoxCounty",                 "INKnoxCounty",
      "US/IN/ShelbyCounty",               "INShelbyCounty",
      "US/IN/PorterCounty",               "INPorterCounty",
      "US/IN/VigoCounty",                 "INVigoCounty",
      "US/KS/CowleyCounty",               "KSCowleyCounty",
      "US/KS/JohnsonCounty",              "KSJohnsonCounty",
      "US/KY/LarueCounty",                "KYLaRueCounty",
      "US/KS/LeavenworthCounty",          "KSLeavenworthCounty",
      "US/KS/MarionCounty",               "KSMarionCounty",
      "US/KS/MontgomeryCounty",           "KSMontgomeryCounty",
      "US/KS/NeoshoCounty",               "KSNeoshoCounty",
      "US/KS/Renolec",                    "KSRenoCounty",
      "US/KS/RiceCounty",                 "KSRiceCounty",
      "US/KS/SedgwickCounty",             "KSSedgwickCounty",
      "US/KS/FirePage",                   "KSWichita",
      "US/KY/BooneCounty",                "KYBooneCounty",
      "US/KY/CampbellCounty",             "KYCampbellCounty",
      "US/KY/ErlangerPD",                 "KYErlangerDispatch",
      "US/KY/GallatinCounty",             "KYGallatinCounty",
      "US/KY/HardinCounty",               "KYHardinCountyC",
      "US/KY/KentonCounty",               "KYKentonCounty",
      "US/KY/KSPP1",                      "KYStatePolice",
      "US/KY/KSPP3",                      "KYStatePolice",
      "US/KY/KSPP5",                      "KYStatePolice",
      "US/KY/KSPP6",                      "KYStatePolice",
      "US/KY/LawrenceCounty",             "KYLawrenceCounty",
      "US/KY/Louisville",                 "KYLouisville",
      "US/KY/MadisonCounty",              "KYMadisonCounty",
      "US/KY/MarshallCountyFire",         "KYMarshallCounty",
      "US/KY/Nexigen",                    "Cadpage2",
      "US/LA/AscensionParish",            "LAAscensionParish",
      "US/LA/LafayetteParish",            "LALafayetteParish",
      "US/LA/LafourcheParish",            "LALafourcheParish",
      "US/LA/TerrebonneParish",           "LATerrebonneParish",
      "US/LA/WestBatonRougeCouncil",      "LAWestBatonRougeParish",
      "US/ME/YorkCounty",                 "MEYorkCounty",
      "US/MD/CalvertCounty",              "MDCalvertCounty",
      "US/MD/CecilCounty",                "Cadpage2",
      "US/MD/CharlesCounty",              "MDCharlesCountyA",
      "US/MD/ChiefAlert",                 "MDCarolineCounty",
      "US/MD/Fastalert",                  "MDCarrollCountyB",
      "US/MD/Fireblitz",                  "MDPrinceGeorgesCountyFireBiz",
      "US/MD/HarfordCounty",              "Cadpage2",
      "US/MD/PrinceGeorgesCounty",        "MDPrinceGeorgesCounty",
      "US/MD/PrintManager",               "MDAnneArundelCountyAnnapolis",
      "US/MD/QueenAnnesCounty",           "MDQueenAnnesCounty",
      "US/MD/StMarysCounty",              "MDStMarysCounty",
      "US/MD/WashingtonCounty",           "MDWashingtonCounty",
      "US/MI/AlleganCounty",              "MIAlleganCounty",
      "US/MI/AlpenaCounty",               "MIAlpenaCounty",
      "US/MI/BarryCounty",                "MIBarryCounty",
      "US/MI/BayCounty",                  "MIBayCountyB",
      "US/MI/CalhounCounty",              "MICalhounCounty",
      "US/MI/CharlevoixCounty",           "MICharlevoixCounty",
      "US/MI/Chippewa",                   "MIChippewaCounty",
      "US/MN/CrowWingCounty",             "MNCrowWingCounty",
      "US/MN/GoodhueCounty",              "MNGoodhueCounty",
      "US/MI/EatonCounty",                "MIEatonCounty",
      "US/MI/GrandTraverse",              "MIGrandTraverseCounty",
      "US/MI/GrandTraverseAttachment",    "MIGrandTraverseCounty",
      "US/MI/InghamCounty",               "MIInghamCounty",
      "US/MI/IoscoCounty",                "MIIoscoCounty",
      "US/MI/LenaweeCounty",              "MILenaweeCountyB",
      "US/MI/MidlandCounty",              "MIMidlandCounty",
      "US/MD/MontgomeryCounty",           "MDMontgomeryCounty",
      "US/MI/ShiawasseeCounty",           "MIShiawasseeCounty",
      "US/MN/BeckerCounty",               "MNBeckerCounty",
      "US/MN/BloomingtonFD",              "MNMinneapolisStPaul",
      "US/MN/CarverCounty",               "MNCarverCounty",
      "US/MN/DakotaCounty",               "MNDakotaCounty",
      "US/MN/Edina",                      "MNEdina",
      "US/MN/HennepinCounty",             "MN/HennepinCounty",
      "US/MN/MilleLacsCounty",            "Cadpage2",
      "US/MN/MowerCounty",                "Cadpage2",
      "US/MN/NormanCounty",               "Cadpage2",
      "US/MN/OtterTailCounty",            "MNOtterTailCounty",
      "US/MN/PenningtonCounty",           "MNPenningtonCounty",
      "US/MN/SherburneCounty",            "MNSherburneCounty",
      "US/MN/StPaul",                     "MNMinneapolisStPaul",
      "US/MN/WabashaCounty",              "MNWabashaCounty",
      "US/MN/WadenaCounty",               "MNWadenaCounty",
      "US/MN/WashingtonCounty",           "MNWashingtonCounty",
      "US/MN/WinomaCounty",               "MNWinomaCounty",
      "US/MN/WrightCounty",               "MNWrightCounty",
      "US/MO/ADSiCad",                    "MOLawrenceCounty",
      "US/MO/AndrewCounty",               "Cadpage2",
      "US/MO/BarryCounty",                "MOBarryCountyB",
      "US/MO/CityofFestus",               "MOFestusB",
      "US/MO/ChristianCounty",            "MOChristianCounty",
      "US/MO/CityofBranson",              "MOBranson",
      "US/MO/ClintonCounty",              "MOClintonCounty",
      "US/MO/ColeCounty",                 "MOJeffersonCounty",
      "US/MO/CrawfordCounty",             "MOCrawfordCountyB",
      "US/MO/FranklinCounty",             "MOFranklinCounty",
      "US/MO/JeffersonCity",              "MOJeffersonCity",
      "US/NC/JohnstonCounty",             "NCJohnstonCounty",
      "US/MO/LincolnCounty",              "MOLincolnCounty",
      "US/MO/MarshfieldFire",             "MOWebsterCounty",
      "US/MO/MoniteauCounty",             "MOMoniteauCounty",
      "US/MO/PikeCounty",                 "MOLincolnCounty",
      "US/MO/PolkCounty",                 "MOPolkCounty",
      "US/MO/Rejis",                      "MOStLouisCountyE",
      "US/MO/StCharlesCounty",            "MOStCharlesCounty",
      "US/MO/StoneCounty",                "MOStoneCounty",
      "US/MO/SouthernBoone",              "MOBooneCounty",
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
      "US/NC/ClayCounty",                 "NCClayCounty",
      "US/NC/ClevelandCounty",            "NCClevelandCounty",
      "US/NC/Concord",                    "NCCabarrusCountyAParser",
      "US/NC/CravenCounty",               "NCCravenCounty",
      "US/NC/DavidsonCounty",             "NCDavidsonCounty",
      "US/NC/DavieCounty",                "NCDavieCounty",
      "US/NC/EdgecombeCounty",            "NCEdgecombeCounty",
      "US/NC/FranklinCounty",             "NCFranklinCounty",
      "US/NC/GastonCounty",               "NCGastonCounty",
      "US/NC/GatesCounty",                "NCGatesCountyParser",
      "US/MO/GreeneCounty",               "MOGreeneCounty",
      "US/NC/GuilfordCounty",             "NCGuilfordCounty",
      "US/NC/HarnettCounty",              "NCHarnettCountyC",
      "US/NC/Havelock",                   "NCHavelock",
      "US/NC/IredellCounty",              "NCIredellCounty",
      "US/NC/JacksonCounty",              "NCJacksonCounty",
      "US/NC/JohnstonCounty",             "NCJohnstonCounty",
      "US/NC/LincolnCounty",              "NCLincolnCounty",
      "US/NC/MecklenburgCounty",          "NCMecklenburgCounty",
      "US/NC/MitchellCounty",             "NCMitchellCounty",
      "US/NC/NashCounty",                 "NCNashCounty",
      "US/NC/PenderCounty",               "NCPenderCounty",
      "US/NC/PittCounty",                 "NCPittCounty",
      "US/NC/RobesonCounty",              "NCRobesonCounty",
      "US/NC/RockinghamCounty",           "NCRockinghamCounty",
      "US/NC/RowanCounty",                "NCRowanCounty",
      "US/NC/SampsonCounty",              "NCSampsonCounty",
      "US/NC/TransylvaniaCounty",         "NCTransylvaniaCounty",
      "US/NC/USAMobility",                "NCWayneCountyA",
      "US/NC/WarrenCounty",               "NCWarrenCounty",
      "US/NC/WayneCounty",                "NCWayneCountyB",
      "US/NC/WilkesCounty",               "NCWilkesCounty",
      "US/NC/WilsonCounty",               "NCWilsonCounty",
      "US/NH/Hanover",                    "NHHanover,Cadpage2",
      "US/NH/LRMFA",                      "NHGraftonCounty",
      "US/NJ/BurlingtonCounty",           "NJBurlingtonCountyC",
      "US/NJ/CamdenCounty",               "NJCamdenCounty",
      "US/NJ/EggHarborTownship",          "NJAtlanticCounty",
      "US/NJ/GloucesterCounty",           "NJGloucesterCountyA",
      "US/NJ/HamiltonTownship",           "NJAtlanticCountyB",
      "US/NJ/HunterdonCounty",            "NJHunterdonCounty",
      "US/NJ/LifeCommCad",                "NJMercerCountyA",
      "US/NJ/MercerCounty",               "NJMercerCountyB",
      "US/NJ/MorrisCounty",               "NJMorrisCounty",
      "US/NJ/Linwood",                    "Cadpage2",
      "US/NJ/NPD",                        "NJSussexCountyA",
      "US/NJ/Nwbcd",                      "NJSussexCountyA",
      "US/NJ/OceanCounty",                "NJOceanCounty",
      "US/NJ/SpartaPD",                   "NJSussexCountyA",
      "US/NJ/SussexCountySherif",         "NJSussexCountyB",
      "US/NJ/TomsRiverPolice",            "NJOceanCountyB",
      "US/NJ/WayneTownship",              "NJWayneTownship",
      "US/NV/Elko",                       "NVElkoCounty",
      "US/NV/CityofElko",                 "NVElkoCountyA",
      "US/NV/WestWendover",               "NVElkoCountyB",
      "US/NY/Albany",                     "NYAlbanyCountyC",
      "US/NY/AlleganyCounty911",          "NYAlleganyCounty",
      "US/NY/BCFA",                       "NYSuffolkCountyB",
      "US/NY/ChiliFD",                    "NYMonroeCounty",
      "US/NY/Erie",                       "NYErieCountyF",
      "US/NY/FireRescueSystems",          "NYSuffolkCountyBFI",
      "US/NY/Lewis911",                   "NYLewisCounty",
      "US/NY/MonroeCounty",               "NYMonroeCountyWebster",
      "US/NY/OneidaIAR",                  "NYOneidaCounty",
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
      "US/OH/BelmontCounty",              "OHBelmontCounty",
      "US/OH/ButlerCountySheriff",        "OHButlerCountyA",
      "US/OH/ChampaignCounty",            "OHChampaignCounty",
      "US/OH/CityofFairfield",            "OHFairfield",
      "US/OH/CityofXenia",                "OHGreeneCounty",
      "US/OH/CityofVandalia",             "OHMontgomeryCountyB",
      "US/OH/DarkeCountySheriff",         "OHDarkeCounty",
      "US/OH/Fairfield",                  "OHFairfieldCounty",
      "US/OH/GeaugaCounty",               "OHGeaugaCountyB",
      "US/OH/HamiltonCounty",             "OHHamiltonCounty",
      "US/OH/Harveysburg",                "OHWarrenCountyC",
      "US/OH/HolmesCountySheriff",        "OHHolmesCounty",
      "US/OH/LoganCounty",                "OHLoganCounty",
      "US/OH/Sebring",                    "OHMahoningCounty",
      "US/OH/TrumbullCounty",             "OHTrumbullCounty",
      "US/OH/WarrenCountyEmergitech",     "OHFranklin",
      "US/OH/WarrenCountyLogis",          "OHWarrenCountyA",
      "US/OH/WashingtonCountySheriff",    "OHWashingtonCountyA",
      "US/OK/CityofTulsa",                "OKTulsaB",
      "US/OK/CherokeeCounty",             "OKCherokeeCounty",
      "US/OK/LoveCounty",                 "OKLoveCounty",
      "US/OR/Benton",                     "ORBentonCounty",
      "US/OR/CityofSalem",                "ORMarionCountyB",
      "US/OR/ClackamasCounty",            "ORClackamasCountyA",
      "US/OR/ColumbiaCounty",             "ORColumbiaCounty",
      "US/OR/CookCounty",                 "ORCookCounty",
      "US/OR/DeschutesCounty",            "ORDeschutesCounty",
      "US/OR/GilliamCounty",              "ORGilliamCounty",
      "US/OR/HoodRiverCounty",            "ORHoodRiverCounty",
      "US/OR/Jackson",                    "ORJacksonCounty",
      "US/OR/JeffersonCounty",            "ORJeffersonCounty",
      "US/OR/Pacific",                    "ORJosephineCounty",
      "US/OR/Klamath",                    "ORKlamathCounty",
      "US/OR/LaneCounty",                 "ORLaneCounty",
      "US/OR/Lincoln",                    "ORLincolnCounty",
      "US/OR/Linn",                       "ORLinnCounty",
      "US/OR/MultnomahCounty",            "ORMultnomahCounty",
      "US/OR/NewbergFire",                "ORYamhillCountyA",
      "US/OR/PolkCounty",                 "ORPolkCounty",
      "US/OR/PortlandAMR",                "ORClackamasCountyC",
      "US/OR/PrinevillePD",               "ORCrookCounty",
      "US/OR/ShermanCounty",              "ORShermanCounty",
      "US/OR/WashingtonCounty",           "ORWashingtonCounty",
      "US/OR/WheelerCounty",              "ORWheelerCounty",
      "US/OR/Woodburn",                   "ORMarionCounty",
      "US/OR/Yamhill",                    "ORYamhillCountyB",
      "US/PA/AdamsCounty",                "PAAdamsCounty",
      "US/PA/AlleghenyCounty",            "PAAlleghenyCounty",
      "US/PA/ArmstrongCounty",            "PAArmstrongCounty",
      "US/PA/BerwynFire",                 "PAChesterCountyD1",
      "US/PA/BeaverCounty",               "PABeaverCounty",
      "US/PA/BlairCounty",                "PABlairCount",
      "US/PA/BradfordCounty",             "PABradfordCounty",
      "US/PA/BucksCounty",                "PABucksCounty",
      "US/PA/BucksEMA",                   "PABucksCountyA",
      "US/PA/ButlerCounty",               "PAButlerCounty",
      "US/PA/CentreCounty",               "PACentreCounty",
      "US/PA/ClearfieldCounty",           "PAClearfieldCounty",
      "US/PA/ColumbiaCounty",             "PAColumbiaCounty",
      "US/PA/CumberlandCounty",           "PACumberlandCounty",
      "US/PA/DelawareCounty",             "PADelawareCountyB,PADelawareCountyG",
      "US/PA/DauphinCounty",              "PADauphinCounty",
      "US/PA/FDCMS",                      "PAChesterCountyVariant",
      "US/PA/FlourtownFire",              "PAMontgomeryCountyD",
      "US/PA/FranklinCounty",             "PAFranklinCounty",
      "US/PA/FultonCounty",               "PAFultonCounty",
      "US/PA/GoodFellowshipAmbulance",    "PAChesterCountyG",
      "US/PA/GladwyneFire",               "PAMontgomeryCountyD",
      "US/PA/Km911",                      "PALebanonCounty",
      "US/PA/LackawannaCounty",           "PALackawannaCounty",
      "US/PA/LancasterCounty",            "PALancasterCounty",
      "US/PA/LuzerneCounty",              "PALuzerneCounty",
      "US/PA/LehighCounty",               "PALehighCounty",
      "US/PA/Lvh",                        "PALehighCountyB",
      "US/PA/MercerCounty",               "PAMercerCounty",
      "US/PA/MessiahEMS",                 "PAGrantham",
      "US/PA/Monroeville",                "PAMonroville",
      "US/PA/MontgomeryCounty",           "PAMontgomeryCountyC",
      "US/PA/PikeCounty",                 "PAPikeCountyB",
      "US/PA/SchuylkillCounty",           "PASchuylkillCounty",
      "US/PA/SomersetCounty",             "PASomersetCounty",
      "US/PA/Springfield",                "PADelawareCountyG",
      "US/PA/TrappeIAR",                  "PAChesterCountyL",
      "US/PA/VenangoCounty",              "PAVenagoCountyB",
      "US/PA/WashingtonCounty",           "PAWashingonCounty",
      "US/PA/WayneCounty",                "PAWayneCounty",
      "US/PA/YorkCounty",                 "PAYorkCountyD",
      "US/SC/AndersonSheriff",            "SCAndersonCounty",
      "US/SC/CherokeeCounty",             "SCherokeeCounty",
      "US/SC/DorchesterCounty",           "SCDorchesterCounty",
      "US/SC/GeorgetownCounty",           "SCGeorgetownCounty",
      "US/SC/HartsvilleFD",               "SCDarlingtonCounty",
      "US/SC/JasperCounty",               "SCJasperCounty",
      "US/SC/LancasterCounty",            "SCLancasterCounty",
      "US/SC/OrangeburgCounty",           "OrangeburgCounty",
      "US/SC/PickensCounty",              "SCPickensCounty",
      "US/SC/SpartanburgCounty",          "SCSpartanburgCounty",
      "US/SC/SumterCounty",               "SCSumterCounty",
      "US/SD/LincolnCounty",              "SDLincolnCounty",
      "US/SD/MinnehahaCounty",            "SDMinnehahaCounty",
      "US/TN/BedfordCounty",              "TNBedfordCounty",
      "US/TN/CampbellCounty",             "TNCampbellCounty",
      "US/TN/CumberlandCounty",           "TNCumberlandCounty",
      "US/TN/Overton",                    "TNOvertonCounty",
      "US/TX/AngletonPD",                 "TXAngleton",
      "US/TX/AransasCounty",              "TXAransasCounty",
      "US/TX/Austin",                     "TXTravisCounty",
      "US/TX/BellCounty",                 "TXBellCounty",
      "US/TX/Carrollton",                 "TXCarrollton",
      "US/TX/CityofDickinson",            "TXGalvestonCounty",
      "US/TX/CityofKeller",               "TXKeller",
      "US/TX/CityofCrowley",              "TXCrowley",
      "US/TX/DentonCounty",               "TXDentonCounty",
      "US/TX/FlightVector",               "TXFlightVector",
      "US/TX/FortBendCounty",             "TXFortBendCountyA",
      "US/TX/FreeportDispatch",           "TXBrazoriaCountyB",
      "US/TX/Gatesville",                 "TXGatesville",
      "US/TX/GreggCounty",                "TXGreggCounty",
      "US/TX/HarrisCountyEC",             "TXHarrisCountyESD1B",
      "US/TX/HaysUSA",                    "KSHays",
      "US/TX/HuntCounty",                 "TXHuntCounty",
      "US/TX/JohnsonCounty",              "TXJohnsonCountyB",
      "US/TX/Katy",                       "TXCyCreekCommCenter",
      "US/TX/KaufmanCounty",              "TXKaufmanCounty",
      "US/TX/KendallCounty",              "TXKendallCounty",
      "US/TX/OssiCAD",                    "TXLaPorte",
      "US/TX/LeonCounty",                 "TXLeonCounty",
      "US/TX/Lufkin",                     "TXLufkin",
      "US/TX/Midlothian",                 "TXKeller",
      "US/TX/MontgomeryCounty",           "TXMontgomeryCounty",
      "US/TX/MontgomeryCounty",           "TXMontgomeryCounty",
      "US/TX/NuecesCounty",               "TXNuecesCounty",
      "US/TX/Rosenburg",                  "TXRosenburg",
      "US/TX/RoyseCity",                  "TXRoyseCity",
      "US/TX/SanMarcosCounty",            "TXSanMarcosCounty",
      "US/TX/Seguin",                     "TXKeller",
      "US/TX/Smhcems",                    "TXHaysCounty",
      "US/TX/Stationalerting",            "TXFortBendCountyB",
      "US/TX/VillageFire",                "TXVillage",
      "US/TX/West",                       "TXMclennanCounty",
      "US/TX/Wilco",                      "TXWilliamsonCountyB",
      "US/TX/West",                       "TXMclennanCounty",
      "US/TX/WylieFireDispatch",          "TXWylie",
      "US/UT/BoxElderCounty",             "UTBoxElderCounty",
      "US/UT/SaltLakeCounty",             "UTSaltLakeCounty",
      "US/VA/AlbermarleCounty",           "VAAlbermarleCounty",
      "US/VA/AppomattoxCounty",           "VAAppomattoxCounty",
      "US/VA/BrunswickCounty",            "VABrunswickCounty",
      "US/VA/DickensonCounty",            "VADickensonCounty",
      "US/VA/Esva911",                    "VANorthamptonCounty",
      "US/VA/FluvannaSheriff",            "VAFluvanna",
      "US/VA/Franklin",                   "VAFranklinB",
      "US/VA/FranklinCounty",             "VAFranklinCountyB",
      "US/VA/Hanover",                    "VAHanoverCounty",
      "US/VA/HenryCounty",                "VAHenryCounty",
      "US/VA/LoudounCounty",              "VALoudounCounty",
      "US/VA/MecklenburgCounty",          "VAMecklenburgCounty",
      "US/VA/NorthumberlandCounty",       "VANorthumberland",
      "US/VA/JamesCityCounty",            "VAJamesCityCounty",
      "US/VA/PrinceWilliamCounty",        "VAPrinceWilliamCountyA",
      "US/VT/Hartford",                   "VTHartford",
      "US/WA/BentonCounty",               "WABentonCounty",
      "US/WA/ValleyCom",                  "WAKingCountyC",
      "US/WA/LewisCounty",                "WALewisCounty",
      "US/WA/PendOreilleCounty",          "WAPendOreilleCounty",
      "US/WA/RiverComm911",               "WAChelanCounty",
      "US/WA/SnohomishCounty",            "WASnohomishCounty",
      "US/WA/ThurstonCounty",             "WAThurstonCounty",
      "US/WA/USAMobility",                "WAPierceCountyA",
      "US/WA/WestPierceCounty",           "WAPierceCountyD",
      "US/WA/WallaWallaCounty",           "WAWallaWallaCounty",
      "US/WI/MukwonagoFire",              "WIWaukeshaCountyB",
      "US/WI/WaukeshaCounty",             "WaWaukeshaCounty",
      "US/WV/BerkeleyCounty",             "WVBerkeleyCounty",
      "US/WV/HampshireCounty",            "WVHampshireCounty",
      "US/WV/LincolnCounty",              "WVLincolnCounty",
      "US/WV/RaleighCounty",              "WVRaleighCounty",
      "US/WV/Wyoming",                    "WVWyomingCounty",
      "Utility/General/Default",          "N/A",
      "Vendor/Cadpage/Default",           "Cadpage2",
      "Vendor/Cadpage/StandardA",         "StandardA",
      "Vendor/Sweden/Zenit",              "ZSESweden"
  });
}
