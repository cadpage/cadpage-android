package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Burlington County, NJ
 */
public class NJBurlingtonCountyCParser extends DispatchA5Parser {
  
  private static final String TRIM_SUBJ_LEADER = "([ ";
  private static final String TRIM_SUBJ_TRAILER = ")]. ";
  private static final Pattern STR_PTN = Pattern.compile(" +(STR +[^ ]+)$");
  
  public NJBurlingtonCountyCParser() {
    super(CITY_ABBRV, CALL_CODES, "BURLINGTON COUNTY", "NJ");
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
  }
  
  @Override
  public String getFilter() {
    return "@CO.BURLINGTON.NJ.US,messaging@iamresponding.com";
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return TN_PTN.matcher(addr).replaceAll("TURN");
  }
  private static final Pattern TN_PTN = Pattern.compile("\\bTN\\b", Pattern.CASE_INSENSITIVE);
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // For some reason, these pages usually alter or eliminate the subject signature
    // that is required for all other A5 parser subclasses.
    String source = null;
    if (!subject.equals(SUBJECT_SIGNATURE)) {
      subject = subject.replace(SUBJECT_SIGNATURE, "").trim();
      int pt1 = 0;
      while (pt1 < subject.length() && TRIM_SUBJ_LEADER.indexOf(subject.charAt(pt1)) >= 0) pt1++;
      int pt2 = subject.length()-1;
      while (pt2 >= pt1 && TRIM_SUBJ_TRAILER.indexOf(subject.charAt(pt2)) >= 0) pt2--;
      source = subject.substring(pt1,pt2+1);
      subject = SUBJECT_SIGNATURE;
    }
    
    // On top of that, IAR can be configured to drop some vital pieces that
    // we will try to replace
    body = body.replace("\nDispatchNature of Call :", "\n\nArea:  Section :   Beat :   Map :\nGrid:  Quadrant:  District:\nPhone Number:  Call Source:\nNature of Call :");
    
    
    if (!super.parseMsg(subject, body, data)) return false;
    
    // Treat STR as an apt tag
    Matcher match = STR_PTN.matcher(data.strAddress);
    if (match.find()) {
      data.strApt = append(data.strApt, "-", match.group(1));
      data.strAddress = data.strAddress.substring(0,match.start());
    }
    
    if (data.strSource.length() == 0 && source != null) data.strSource = source;
    return true;
  }
  
  private static Properties CITY_ABBRV = buildCodeTable(new String[]{
      "BdntwnCity", "Bordentown",
      "BrdntwnTwp", "Bordentown Twp",
      "Burl City",  "Burlington",
      "Burl Twp",   "Burlington Twp",
      "Camden Co",  "Camden County",
      "Chesterfld", "Chesterfield",
      "Cinnaminsn", "Cinnaminson Twp",
      "MapleShade", "Maple Shade Twp",
      "McGuireAFB", "McGuire AFB",
      "MedfordLks", "Medford Lakes",
      "MedfordTwp", "Medford Twp",
      "N Hanover",  "North Hanover",
      "NewHanover", "New Hanover",
      "Ocean Co",   "Ocean County",
      "Pembtn Twp", "Pemberton Twp",
      "Southamptn", "Southampton",
      "Springfld",  "Springfield",
      "Willingbor", "Willingboro",
      "Wrghtstwn",  "Wrightstown",
      
      "Alarm List", "",
      "NJTP",       ""
  });
  
  private static final CodeTable CALL_CODES = new CodeTable(
      "101",   "Abdominal Pain/Problems",
      "102",   "Allergies/Hives/Reaction/Stings",
      "103",   "Animal Bites",
      "104",   "Assault/Rape",
      "105",   "Back Pain",
      "106",   "Breathing Problems",
      "107",   "Burns-Thermal/Chemical",
      "108",   "Carbon Mono/Inhalation/Haz Mat",
      "109",   "Cardiac/Respiratory Arrest",
      "110",   "Chest Pain",
      "111",   "Choking",
      "112",   "Convulsions/Seizures",
      "113",   "Diabetic Problems",
      "114",   "Drowning (near)/Diving Accident",
      "115",   "Electrocution",
      "116",   "Eye Problems",
      "117",   "Falls/Fractures",
      "118",   "Headache",
      "119",   "Heart Problems",
      "120",   "Heat/Cold Exposure",
      "121",   "Hemorrhage",
      "122",   "Industrial/Machinery Accidents",
      "123",   "Overdose/Poisoning/Ingestion",
      "124",   "Pregnancy",
      "125",   "Psychiatric/Behavorial Problems",
      "126",   "Sick Person (specific diagnosis)",
      "127",   "Pentrating Wound/Stab/Gun",
      "128",   "Stroke/CVA",
      "129",   "Traffic Injury Accidents",
      "129F",  "Motor Vehicle Accident Fire Response",
      "130",   "Traumatic Injuries/Lacerations",
      "131",   "Unconsciousness/Fainting",
      "132",   "Medical Emergency (Unknown Problem)",
      "133",   "Traffic Accidents/Entrapment",
      "134",   "Special Assignment",
      "135",   "Fire Standby",
      "136",   "Non Emergency Transportation",
      "137",   "Cover Assignment",
      "138",   "Training Session/Drills",
      "139",   "School Standyby,Education",
      "11",    "Structure,Building Fire",
      "12",    "Structure-Non Fire",
      "13",    "Vehicles/Non Structure Fires",
      "14",    "Brush, Trees, Woods",
      "15",    "Non-Fire/Investigations, Odors,",
      "16",    "Alarm Systems",
      "17",    "Natural Gas, Propane Gas, Fumes,",
      "18",    "Wash Highway, Wash Roadway",
      "30",    "Rescue Assignment",
      "32",    "Medical Call, Assist BLS",
      "42",    "Explosive Device, Bomb Threat",
      "44",    "Wires, Transformers, Poles",
      "46",    "Helicopter Landings, Aircraft Stand By",
      "47",    "Hazardous Materials Incident",
      "51",    "Lock Out,Assist Police",
      "52",    "Pump Out, Water in Basement",
      "54",    "Animal Rescue",
      "55",    "Assist Police, Fire Police",
      "57",    "Cover Assignment",
      "AOS",   "Alarm Out of Service",
      "BURN",  "Controlled Burn",
      "CCD",   "Critical Care Divert",
      "DUP",   "Duplicate Incident",
      "DUP",   "Duplicate Incident",
      "EMS",   "EMS Call",
      "ERB",   "ER ByPass",
      "FIRE",  "Fire Call",
      "TCD",   "Total Care Divert"

  );
  
  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      
      // NJTP Mile Markers
      "2500 NJTP", "39.8555869441,-75.096062570",
      "2510 NJTP", "39.8560554652,-75.0942828735",
      "2520 NJTP", "39.8564666802,-75.0924794987",
      "2530 NJTP", "39.8568193110,-75.0906553840",
      "2540 NJTP", "39.8571396613,-75.0888210637",
      "2550 NJTP", "39.8574621486,-75.0869873629",
      "2560 NJTP", "39.8577866378,-75.0851542478",
      "2570 NJTP", "39.858108060,-75.0833202145",
      "2580 NJTP", "39.8584304060,-75.0814864452",
      "2590 NJTP", "39.8587517529,-75.0796523725",
      "2600 NJTP", "39.8590723392,-75.0778180662",
      "2610 NJTP", "39.8593942671,-75.0759841462",
      "2620 NJTP", "39.8597165456,-75.0741503210",
      "2630 NJTP", "39.8600401805,-75.0723168893",
      "2640 NJTP", "39.8603616758,-75.0704828155",
      "2650 NJTP", "39.8606834226,-75.0686488071",
      "2660 NJTP", "39.8610089102,-75.0668159017",
      "2670 NJTP", "39.8613306358,-75.0649818731",
      "2680 NJTP", "39.8616530705,-75.0631480418",
      "2690 NJTP", "39.8619724928,-75.0613133143",
      "2700 NJTP", "39.8622935469,-75.0594790580",
      "2710 NJTP", "39.8626161754,-75.0576452560",
      "2720 NJTP", "39.8629387390,-75.0558114258",
      "2730 NJTP", "39.8632606312,-75.0539773881",
      "2740 NJTP", "39.8635837134,-75.0521436942",
      "2750 NJTP", "39.8639073836,-75.0503101655",
      "2760 NJTP", "39.8642270650,-75.0484754507",
      "2770 NJTP", "39.8645495767,-75.0466415607",
      "2780 NJTP", "39.8648723241,-75.0448077314",
      "2790 NJTP", "39.8651946204,-75.0429737598",
      "2800 NJTP", "39.8655161535,-75.0411395535",
      "2810 NJTP", "39.8658374049,-75.0393052553",
      "2820 NJTP", "39.8661728104,-75.0374752682",
      "2830 NJTP", "39.8665599152,-75.0356627249",
      "2840 NJTP", "39.8670099266,-75.0338748034",
      "2850 NJTP", "39.8675188486,-75.0321135888",
      "2860 NJTP", "39.8680889687,-75.0303842549",
      "2870 NJTP", "39.8687158471,-75.0286882804",
      "2880 NJTP", "39.8693780025,-75.0270148497",
      "2890 NJTP", "39.8700383658,-75.0253402107",
      "2900 NJTP", "39.8707001963,-75.0236665309",
      "2910 NJTP", "39.8713617726,-75.0219926652",
      "2920 NJTP", "39.8720229594,-75.0203185252",
      "2930 NJTP", "39.8726928108,-75.0186502639",
      "2940 NJTP", "39.8734035950,-75.0170109017",
      "2950 NJTP", "39.8741771752,-75.0154201050",
      "2960 NJTP", "39.8750063715,-75.0138773995",
      "2970 NJTP", "39.8758790204,-75.0123754144",
      "2980 NJTP", "39.8768013676,-75.0109243869",
      "2990 NJTP", "39.8777708322,-75.0095258939",
      "3000 NJTP", "39.8787909990,-75.0081895509",
      "3010 NJTP", "39.8798526798,-75.0069087690",
      "3020 NJTP", "39.8809565542,-75.0056894789",
      "3030 NJTP", "39.8821024835,-75.0045373448",
      "3040 NJTP", "39.8832614880,-75.0034073299",
      "3050 NJTP", "39.8844195185,-75.0022756070",
      "3060 NJTP", "39.8855760679,-75.0011413146",
      "3070 NJTP", "39.8867343970,-75.0000100691",
      "3080 NJTP", "39.8878912013,-74.9988761839",
      "3090 NJTP", "39.8890485892,-74.9977432730",
      "3100 NJTP", "39.8902052125,-74.9966090272",
      "3110 NJTP", "39.8913621638,-74.9954753263",
      "3120 NJTP", "39.8925205746,-74.9943441218",
      "3130 NJTP", "39.8936755012,-74.9932069170",
      "3140 NJTP", "39.8948343353,-74.9920764088",
      "3150 NJTP", "39.8959903482,-74.9909410233",
      "3160 NJTP", "39.8971483091,-74.9898089659",
      "3170 NJTP", "39.8983063267,-74.9886769873",
      "3180 NJTP", "39.8994616139,-74.9875403121",
      "3190 NJTP", "39.9006216433,-74.9864117743",
      "3200 NJTP", "39.9017780458,-74.9852769634",
      "3210 NJTP", "39.9029354228,-74.9841438124",
      "3220 NJTP", "39.9040924515,-74.9830100393",
      "3230 NJTP", "39.9052503482,-74.9818777502",
      "3240 NJTP", "39.9064089826,-74.9807467123",
      "3250 NJTP", "39.9075640323,-74.9796094988",
      "3260 NJTP", "39.9087230054,-74.9784790937",
      "3270 NJTP", "39.9098825490,-74.9773495956",
      "3280 NJTP", "39.9110393860,-74.9762153806",
      "3290 NJTP", "39.9121958267,-74.9750807992",
      "3300 NJTP", "39.9133532232,-74.9739475083",
      "3310 NJTP", "39.9145071704,-74.9728082824",
      "3320 NJTP", "39.9156387304,-74.9716318498",
      "3330 NJTP", "39.9167474182,-74.9704192368",
      "3340 NJTP", "39.9178313167,-74.9691694619",
      "3350 NJTP", "39.9188920362,-74.9678864538",
      "3360 NJTP", "39.9199484293,-74.9665973676",
      "3370 NJTP", "39.9210070960,-74.9653114325",
      "3380 NJTP", "39.9220628020,-74.9640213564",
      "3390 NJTP", "39.9231196775,-74.9627328761",
      "3400 NJTP", "39.9241760617,-74.9614436968",
      "3410 NJTP", "39.9252321353,-74.9601540697",
      "3420 NJTP", "39.9262905793,-74.9588677044",
      "3430 NJTP", "39.9273499497,-74.9575826260",
      "3440 NJTP", "39.9284077396,-74.9562953220",
      "3450 NJTP", "39.9294622121,-74.9550034227",
      "3460 NJTP", "39.9305094596,-74.9537019214",
      "3470 NJTP", "39.9315739365,-74.9524238887",
      "3480 NJTP", "39.9326349306,-74.9511409637",
      "3490 NJTP", "39.9336909257,-74.9498510955",
      "3500 NJTP", "39.9347389365,-74.9485502996",
      "3510 NJTP", "39.9357917068,-74.9472560402",
      "3520 NJTP", "39.9368500843,-74.9459693846",
      "3530 NJTP", "39.9379022996,-74.9446742731",
      "3540 NJTP", "39.9389394218,-74.9433587844",
      "3550 NJTP", "39.9399564141,-74.9420169879",
      "3560 NJTP", "39.9409639746,-74.9406631620",
      "3570 NJTP", "39.9419675966,-74.9393043920",
      "3580 NJTP", "39.9429763387,-74.9379520113",
      "3590 NJTP", "39.9439785314,-74.9365914424",
      "3600 NJTP", "39.9449885620,-74.9352406379",
      "3610 NJTP", "39.9459950159,-74.9338853250",
      "3620 NJTP", "39.9469967147,-74.9325241007",
      "3630 NJTP", "39.9480045391,-74.9311704609",
      "3640 NJTP", "39.9490103548,-74.9298142927",
      "3650 NJTP", "39.9500184440,-74.9284611330",
      "3660 NJTP", "39.9510425478,-74.9271282164",
      "3670 NJTP", "39.9520820893,-74.9258157066",
      "3680 NJTP", "39.9531333319,-74.9245189485",
      "3690 NJTP", "39.9541812773,-74.9232177135",
      "3700 NJTP", "39.9552310874,-74.9219189186",
      "3710 NJTP", "39.9562811230,-74.9206204116",
      "3720 NJTP", "39.9573300130,-74.9193203227",
      "3730 NJTP", "39.9583789488,-74.9180202761",
      "3740 NJTP", "39.9594271730,-74.9167192429",
      "3750 NJTP", "39.9604751045,-74.9154177958",
      "3760 NJTP", "39.9615287695,-74.9141241735",
      "3770 NJTP", "39.9625790144,-74.9128259403",
      "3780 NJTP", "39.9636504249,-74.9115571595",
      "3790 NJTP", "39.9647372892,-74.9103108031",
      "3800 NJTP", "39.9658418847,-74.9090909565",
      "3810 NJTP", "39.9669549992,-74.9078842858",
      "3820 NJTP", "39.9680750338,-74.9066884079",
      "3830 NJTP", "39.9691905960,-74.9054854724",
      "3840 NJTP", "39.9703080084,-74.9042854194",
      "3850 NJTP", "39.9714242921,-74.9030835742",
      "3860 NJTP", "39.9725426813,-74.9018850241",
      "3870 NJTP", "39.9736601818,-74.9006850570",
      "3880 NJTP", "39.9747727771,-74.8994774224",
      "3890 NJTP", "39.9758587767,-74.8982297261",
      "3900 NJTP", "39.9768958366,-74.8969135401",
      "3910 NJTP", "39.9778933449,-74.8955466436",
      "3920 NJTP", "39.9788256528,-74.8941043007",
      "3930 NJTP", "39.9797364985,-74.8926387312",
      "3940 NJTP", "39.9805790468,-74.8911060148",
      "3950 NJTP", "39.9813882499,-74.8895428816",
      "3960 NJTP", "39.9821996410,-74.8879814615",
      "3970 NJTP", "39.9830022792,-74.8864124013",
      "3980 NJTP", "39.9838070432,-74.8848451652",
      "3990 NJTP", "39.9846040043,-74.8832711935",
      "4000 NJTP", "39.9854107962,-74.8817057242",
      "4010 NJTP", "39.9862169820,-74.8801396709",
      "4020 NJTP", "39.9870610185,-74.8786090424",
      "4030 NJTP", "39.9879371780,-74.8771078126",
      "4040 NJTP", "39.9888375166,-74.8756312696",
      "4050 NJTP", "39.9897703417,-74.8741889480",
      "4060 NJTP", "39.9907312193,-74.8727780397",
      "4070 NJTP", "39.9916972398,-74.8713729927",
      "4080 NJTP", "39.9926618144,-74.8699662533",
      "4090 NJTP", "39.9936264856,-74.8685596460",
      "4100 NJTP", "39.9946015582,-74.8671651543",
      "4110 NJTP", "39.9955695305,-74.8657623051",
      "4120 NJTP", "39.9965310155,-74.8643519121",
      "4130 NJTP", "39.9974561918,-74.8629012744",
      "4140 NJTP", "39.9983193835,-74.8613875624",
      "4150 NJTP", "39.9991420186,-74.8598360780",
      "4160 NJTP", "39.9999062975,-74.8582347773",
      "4170 NJTP", "40.0006246808,-74.8565981869",
      "4180 NJTP", "40.0012953582,-74.8549273328",
      "4190 NJTP", "40.0019609623,-74.8532529684",
      "4200 NJTP", "40.0026276571,-74.8515793192",
      "4210 NJTP", "40.0032944803,-74.8499057366",
      "4220 NJTP", "40.0039859932,-74.8482495132",
      "4230 NJTP", "40.0047325560,-74.8466340645",
      "4240 NJTP", "40.0055343066,-74.8450639406",
      "4250 NJTP", "40.0063905744,-74.8435431760",
      "4260 NJTP", "40.0072995041,-74.8420749642",
      "4270 NJTP", "40.0082540034,-74.8406566558",
      "4280 NJTP", "40.0092555444,-74.8392944736",
      "4290 NJTP", "40.0103023830,-74.8379910304",
      "4300 NJTP", "40.0113908468,-74.8367464232",
      "4310 NJTP", "40.0125192413,-74.8355633441",
      "4320 NJTP", "40.0136676067,-74.8344129972",
      "4330 NJTP", "40.0148128116,-74.8332573051",
      "4340 NJTP", "40.0159573482,-74.8321004792",
      "4350 NJTP", "40.0171053751,-74.8309495044",
      "4360 NJTP", "40.0182510123,-74.8297944789",
      "4370 NJTP", "40.0193967968,-74.8286396777",
      "4380 NJTP", "40.0205423368,-74.8274844464",
      "4390 NJTP", "40.0216879006,-74.8263292359",
      "4400 NJTP", "40.0228334607,-74.8251740001",
      "4410 NJTP", "40.0239790518,-74.8240187972",
      "4420 NJTP", "40.0251248165,-74.8228638663",
      "4430 NJTP", "40.0262705426,-74.8217088517",
      "4440 NJTP", "40.0274165564,-74.8205543007",
      "4450 NJTP", "40.0285625680,-74.8193997270",
      "4460 NJTP", "40.0297082058,-74.8182445069",
      "4470 NJTP", "40.0308536797,-74.8170889924",
      "4480 NJTP", "40.0319991306,-74.8159334201",
      "4490 NJTP", "40.0331445541,-74.8147777828",
      "4500 NJTP", "40.0342898539,-74.8136219189",
      "4510 NJTP", "40.0354344527,-74.8124648612",
      "4520 NJTP", "40.0365790399,-74.8113077649",
      "4530 NJTP", "40.0377182345,-74.8101417685",
      "4540 NJTP", "40.0388393033,-74.8089465480",
      "4550 NJTP", "40.0399340872,-74.8077107066",
      "4560 NJTP", "40.0410066403,-74.8064421109",
      "4570 NJTP", "40.0420454801,-74.8051269381",
      "4580 NJTP", "40.0430614434,-74.8037818370",
      "4590 NJTP", "40.0440557903,-74.8024097785",
      "4600 NJTP", "40.0450141277,-74.8009948771",
      "4610 NJTP", "40.0459462216,-74.7995505490",
      "4620 NJTP", "40.0468533680,-74.7980794998",
      "4630 NJTP", "40.0477213528,-74.7965690372",
      "4640 NJTP", "40.0485707712,-74.7950407119",
      "4650 NJTP", "40.0494087792,-74.7935017174",
      "4660 NJTP", "40.0502492855,-74.7919650130",
      "4670 NJTP", "40.0510907008,-74.7904291317",
      "4680 NJTP", "40.0519312820,-74.7888924587",
      "4690 NJTP", "40.0527711043,-74.7873550639",
      "4700 NJTP", "40.0536106637,-74.7858174070",
      "4710 NJTP", "40.0544530764,-74.7842823770",
      "4720 NJTP", "40.0552959305,-74.7827477397",
      "4730 NJTP", "40.0561354407,-74.7812099836",
      "4740 NJTP", "40.0569776481,-74.7796747147",
      "4750 NJTP", "40.0578535723,-74.7781717504",
      "4760 NJTP", "40.0587506201,-74.7766901876",
      "4770 NJTP", "40.0596791545,-74.7752416766",
      "4780 NJTP", "40.0606366723,-74.7738255806",
      "4790 NJTP", "40.0616280294,-74.7724494803",
      "4800 NJTP", "40.0626376111,-74.7710958131",
      "4810 NJTP", "40.0636519520,-74.7697481628",
      "4820 NJTP", "40.0646664139,-74.7684006245",
      "4830 NJTP", "40.0656821460,-74.7670546873",
      "4840 NJTP", "40.0666999179,-74.7657113425",
      "4850 NJTP", "40.0677145797,-74.7643640074",
      "4860 NJTP", "40.0687269246,-74.7630136936",
      "4870 NJTP", "40.0697387878,-74.7616627485",
      "4880 NJTP", "40.0707530335,-74.7603148134",
      "4890 NJTP", "40.0717685116,-74.7589684325",
      "4900 NJTP", "40.0727834352,-74.7576213234",
      "4910 NJTP", "40.0737975684,-74.7562731851",
      "4920 NJTP", "40.0748112634,-74.7549244696",
      "4930 NJTP", "40.0758231555,-74.7535734411",
      "4940 NJTP", "40.0768362884,-74.7522239726",
      "4950 NJTP", "40.0778500640,-74.7508753002",
      "4960 NJTP", "40.0788642652,-74.7495271560",
      "4970 NJTP", "40.0798851337,-74.7481875751",
      "4980 NJTP", "40.0809213362,-74.7468680416",
      "4990 NJTP", "40.0819695002,-74.7455646824",
      "5000 NJTP", "40.0830338142,-74.7442836666",
      "5010 NJTP", "40.0841040073,-74.7430109021",
      "5020 NJTP", "40.0851927019,-74.7417650384",
      "5030 NJTP", "40.0862912315,-74.7405338116",
      "5040 NJTP", "40.0874033575,-74.7393235874",
      "5050 NJTP", "40.0885313870,-74.7381383960",
      "5060 NJTP", "40.0896642782,-74.7369612067",
      "5070 NJTP", "40.0908082156,-74.7358021195",
      "5080 NJTP", "40.0919641673,-74.7346637106",
      "5090 NJTP", "40.0931179679,-74.7335220292",
      "5100 NJTP", "40.0942692645,-74.7323753053",
      "5110 NJTP", "40.0954226877,-74.7312321816",
      "5120 NJTP", "40.0965767764,-74.7300901773",
      "5130 NJTP", "40.0977299260,-74.7289465478",
      "5140 NJTP", "40.0988831379,-74.7278030084",
      "5150 NJTP", "40.1000355236,-74.7266580358",
      "5160 NJTP", "40.1011885720,-74.7255141750",
      "5170 NJTP", "40.1023412736,-74.7243697025",
      "5180 NJTP", "40.1034955926,-74.7232279803",
      "5190 NJTP", "40.1046495704,-74.7220856676",
      "5200 NJTP", "40.1058034739,-74.7209437786",
      "5210 NJTP", "40.1069572436,-74.7198010585",
      "5220 NJTP", "40.1081088088,-74.7186545521",
      "5230 NJTP", "40.1092575325,-74.7175032047",
      "5240 NJTP", "40.1103979015,-74.7163378689",
      
      // Route 295 mile markers
      "3200 RT295", "39.8764810,-75.0144070",
      "3210 RT295", "39.8774860,-75.0132540",
      "3220 RT295", "39.8786370,-75.0121140",
      "3230 RT295", "39.8798000,-75.0110070",
      "3240 RT295", "39.8810150,-75.0098000",
      "3250 RT295", "39.8821140,-75.0087170",
      "3260 RT295", "39.8833260,-75.0075120",
      "3270 RT295", "39.8844350,-75.0064740",
      "3280 RT295", "39.8856300,-75.0053020",
      "3290 RT295", "39.8867490,-75.0041920",
      "3300 RT295", "39.8879790,-75.0029730",
      "3310 RT295", "39.8891370,-75.0020770",
      "3320 RT295", "39.8900890,-75.0005270",
      "3330 RT295", "39.8910670,-74.9992360",
      "3340 RT295", "39.8920840,-74.9977770",
      "3350 RT295", "39.8934590,-74.9958690",
      "3360 RT295", "39.8940470,-74.9950550",
      "3370 RT295", "39.8950950,-74.9937230",
      "3380 RT295", "39.8961860,-74.9924800",
      "3390 RT295", "39.8973180,-74.9913200",
      "3400 RT295", "39.8984700,-74.9902400",
      "3410 RT295", "39.8996580,-74.9892760",
      "3420 RT295", "39.9009210,-74.9883550",
      "3430 RT295", "39.9021600,-74.9875490",
      "3440 RT295", "39.9035000,-74.9867950",
      "3450 RT295", "39.9048360,-74.9861540",
      "3460 RT295", "39.9061280,-74.9855790",
      "3470 RT295", "39.9075840,-74.9849310",
      "3480 RT295", "39.9089910,-74.9842950",
      "3490 RT295", "39.9103110,-74.9837210",
      "3500 RT295", "39.9116500,-74.9831320",
      "3510 RT295", "39.9130990,-74.9824820",
      "3520 RT295", "39.9148510,-74.9816960",
      "3530 RT295", "39.9157850,-74.9812780",
      "3540 RT295", "39.9171650,-74.9806680",
      "3550 RT295", "39.9185180,-74.9800550",
      "3560 RT295", "39.9198580,-74.9794620",
      "3570 RT295", "39.9212960,-74.9787550",
      "3580 RT295", "39.9226260,-74.9780560",
      "3590 RT295", "39.9238690,-74.9772890",
      "3600 RT295", "39.9252100,-74.9763720",
      "3610 RT295", "39.9263430,-74.9755100",
      "3620 RT295", "39.9276360,-74.9744140",
      "3630 RT295", "39.9288860,-74.9732750",
      "3640 RT295", "39.9302380,-74.9719150",
      "3650 RT295", "39.9313220,-74.9706670",
      "3660 RT295", "39.9288940,-74.9732750",
      "3670 RT295", "39.9333640,-74.9680330",
      "3680 RT295", "39.9343600,-74.9665470",
      "3690 RT295", "39.9351520,-74.9652490",
      "3700 RT295", "39.9342740,-74.9666840",
      "3710 RT295", "39.9360950,-74.9636610",
      "3720 RT295", "39.9372740,-74.9613650",
      "3730 RT295", "39.9383230,-74.9589830",
      "3740 RT295", "39.9390110,-74.9571300",
      "3750 RT295", "39.9395570,-74.9554950",
      "3760 RT295", "39.9401140,-74.9536560",
      "3770 RT295", "39.9406920,-74.9518830",
      "3780 RT295", "39.9412190,-74.9501250",
      "3790 RT295", "39.9417750,-74.9483120",
      "3800 RT295", "39.9422820,-74.9466720",
      "3810 RT295", "39.9428060,-74.9449150",
      "3820 RT295", "39.9432320,-74.9435930",
      "3830 RT295", "39.9439870,-74.9415530",
      "3840 RT295", "39.9446340,-74.9399480",
      "3850 RT295", "39.9453390,-74.9383050",
      "3860 RT295", "39.9461230,-74.9366200",
      "3870 RT295", "39.9469500,-74.9350990",
      "3880 RT295", "39.9478320,-74.9335790",
      "3890 RT295", "39.9487380,-74.9321420",
      "3900 RT295", "39.9496730,-74.9307850",
      "3910 RT295", "39.9506300,-74.9294860",
      "3920 RT295", "39.9516990,-74.9281490",
      "3930 RT295", "39.9526960,-74.9269110",
      "3940 RT295", "39.9536860,-74.9256550",
      "3950 RT295", "39.9546750,-74.9244240",
      "3960 RT295", "39.9559240,-74.9229890",
      "3970 RT295", "39.9569310,-74.9216470",
      "3980 RT295", "39.9580050,-74.9202990",
      "3990 RT295", "39.9590620,-74.9190650",
      "4000 RT295", "39.9602190,-74.9178600",
      "4010 RT295", "39.9614520,-74.9166780",
      "4020 RT295", "39.9626950,-74.9155840",
      "4030 RT295", "39.9637010,-74.9146780",
      "4040 RT295", "39.9649090,-74.9136000",
      "4050 RT295", "39.9660430,-74.9124750",
      "4060 RT295", "39.9671770,-74.9113500",
      "4070 RT295", "39.9682690,-74.9100110",
      "4080 RT295", "39.9692680,-74.9086030",
      "4090 RT295", "39.9702670,-74.9071950",
      "4100 RT295", "39.9717315,-74.9051380",
      "4110 RT295", "39.9731960,-74.9030810",
      "4120 RT295", "39.9732010,-74.9030930",
      "4130 RT295", "39.9742920,-74.9018630",
      "4140 RT295", "39.9753730,-74.9005830",
      "4150 RT295", "39.9753730,-74.9005830",
      "4160 RT295", "39.9774860,-74.8980770",
      "4170 RT295", "39.9786170,-74.8967710",
      "4180 RT295", "39.9797180,-74.8954930",
      "4190 RT295", "39.9808060,-74.8944140",
      "4200 RT295", "39.9820150,-74.8932620",
      "4210 RT295", "39.9831000,-74.8922440",
      "4220 RT295", "39.9842380,-74.8909170",
      "4230 RT295", "39.9852840,-74.8895020",
      "4240 RT295", "39.9862090,-74.8880720",
      "4250 RT295", "39.9871100,-74.8865660",
      "4260 RT295", "39.9879900,-74.8850920",
      "4270 RT295", "39.9888680,-74.8835850",
      "4280 RT295", "39.9897220,-74.8820950",
      "4290 RT295", "39.9905930,-74.8805720",
      "4300 RT295", "39.9913530,-74.8789500",
      "4310 RT295", "39.9920880,-74.8772290",
      "4320 RT295", "39.9926900,-74.8755950",
      "4330 RT295", "39.9933490,-74.8737980",
      "4340 RT295", "39.9939870,-74.8721670",
      "4350 RT295", "39.9946610,-74.8705560",
      "4360 RT295", "39.9954400,-74.8689430",
      "4370 RT295", "39.9963480,-74.8674890",
      "4380 RT295", "39.9973120,-74.8662030",
      "4390 RT295", "39.9983300,-74.8647810",
      "4400 RT295", "39.9993540,-74.8634160",
      "4410 RT295", "40.0003260,-74.8621070",
      "4420 RT295", "40.0013710,-74.8608140",
      "4430 RT295", "40.0023970,-74.8594990",
      "4440 RT295", "40.0033980,-74.8582020",
      "4450 RT295", "40.0044390,-74.8568540",
      "4460 RT295", "40.0054590,-74.8554790",
      "4470 RT295", "40.0065140,-74.8542130",
      "4480 RT295", "40.0075840,-74.8529800",
      "4490 RT295", "40.0086750,-74.8518010",
      "4500 RT295", "40.0098645,-74.8507310",
      "4510 RT295", "40.0110880,-74.8497460"
  });
}
