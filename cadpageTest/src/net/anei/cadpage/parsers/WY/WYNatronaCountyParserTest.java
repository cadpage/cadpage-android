package net.anei.cadpage.parsers.WY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Natrona County, WY

Contact: Connor Young <ctown3625@gmail.co
Sender: csphiplink@cityofcasperwy.com
(Message from HipLink) 1/1 EVF \n  Fall\n  1180 WESTERN AVE; Butch's Happy Days Liq\n  351\n  R12\n  ****TAC 4****POSSIBLE BROKEN ANKLE

Contact: Active911
Agency name: Casper Fire-EMS Station 2 Location: Casper, WY 
Sender: csphiplink@cityofcasperwy.com

(Message From Hiplink) CFD \nAccident PI\n1230 E 1ST ST; wyo cardiopulmonary\n312\nE3\nCALLBACK=(307)315-4272 LAT=42.850822 LON=-106.308861 UNC=28\ntac 4 - hit had when rear ended
(Message From Hiplink) CFD \nMedical\n154 N BEECH ST; apt 207\n132\nE1
(Message From Hiplink) CFD \nChest Pain\n2401 GRANDVIEW PL; apt 18\n216\nE1\nrp's brother is having chest pain\n46yom\njust took 2 nitroglycerine
(Message From Hiplink) CFD \nMedical\n945 N ELMA ST; apt 301\n132\nE1\ntac 4 - 3rd party female confused and dehydrated
(Message From Hiplink) CFD \nDiabetic Shock\n1691 BRYAN STOCK TRL; BRYAN STOCK PONDS\n315\nE3\ntac 7\n\nCALLBACK=(904)322-2084 LAT=42.849898 LON=-106.261611 UNC=3674\nmale in diabetic shock\nmale states he is at the duck ponds\n904-322-2084\nmale that is layed out on the ground
(Message From Hiplink) CFD \nMedical\n150 N GRANT ST\n132\nE1\nper le on scene non emergent check on a gal
(Message From Hiplink) CFD \nMedical\n150 N GRANT ST\n132\nE1\ntac 4\n\nper le on scene non emergent check on a gal
(Message From Hiplink) CFD \nUnconsciousness\n155 N BEECH ST; WCDA\n132\nE1\n**tac 4**\n\nmale lying on sidewalk  rp hung up
(Message From Hiplink) CFD \nMedical\n237 E K ST\n132\nE1\nfemale can't get out of bed -- has a pinched nerve
(Message From Hiplink) CFD \nUnconsciousness\n4305 S POPLAR ST;plc\n216\nE2
(Message From Hiplink) CFD \nChest Pain\n300 W B C ST;apt 413\n123\nE1
(Message From Hiplink) CFD \nCardiac Problem\n945 N ELMA ST; apt 205\n132\nE1
(Message From Hiplink) CFD \nDead Body\n300 W B C ST; apt 435\n123\nE2\nrp has key into the apartment
(Message From Hiplink) WMC \nMedical\n527 FULTON ST\nWMC-6\nWMC\ntac 5 - high ammonia level confusion\n\nCALLBACK=(307)277-5648 LAT=42.838978 LON=-106.387650 UNC=16
(Message From Hiplink) CFD \nLockout\n195 PRONGHORN ST; your first steps\n123\nE2\nCALLBACK=(307)359-5006 LAT=42.851808 LON=-106.270881 UNC=19\nchildren locked in veh\nbeen there about 5 mins
(Message From Hiplink) CFD \nAccident PI\n41 SE WYOMING BLVD; FLYING J\nWMC-7\nE5\nthis is from a hit and run that occured 30 min ago -- subject is now complaining\nof head pain
(Message From Hiplink) WMC \nBreathing\n154 N BEECH ST; apt 207\nWMC-7\nWMC\n**tac 5** is having a hard time breathing -- has copd
(Message From Hiplink) CFD \nBreathing\n1120 N DURBIN ST\n132\nE1\n55yof\nhas copd and chronic pancreatitis\nis cons\nbreathing\nis on o2\nno trouble speaking bet breaths
(Message From Hiplink) WMC \nBreathing\n1120 N DURBIN ST\nWMC-7\nWMC\n55yof\nhas copd and chronic pancreatitis\nis cons\nbreathing\nis on o2\nno trouble speaking bet breaths\nneg chging color
(Message From Hiplink) WMC \nSeizure\n915 S MCKINLEY ST;ycc\nWMC-7\nWMC\n16 yof\ncons\nbreathing\nsays she cant feel her body\nhx of seizures\nhas meds for it
(Message From Hiplink) WMC \nTraumatic Inj\n1120 N KIMBALL ST; MARION KREINER PARK\nWMC-7\nWMC\nmale hit in head with rock
(Message From Hiplink) CFD \nMedical\n1835 HYVIEW DR\n216\nE2\ntac 4
(Message From Hiplink) CFD \nAlarm Medical\n1444 S LAUREL ST\n216\nE2\ntac 4   female pressed her lifeline alarm   she fell out of bed and needs help back to bed
(Message From Hiplink) NCF \nFall\n4240 FOX\n7629\nSQ7\ntac 4 - fell and hit her head, still on the floor\n85yof
(Message From Hiplink) CFD \nBreathing\n2401 GRANDVIEW PL; APT 18\n216\nE2\nFEMALE STATING THAT SHE CAN'T BREATHE
(Message From Hiplink) WMC \nUnconsciousness\n307 E 2ND ST; NATRONA COUNTY PUBLIC LIBR\nWMC-7\nWMC\nfemale passed out will not wake up in the back by the parking lot may be dk
(Message From Hiplink) WMC \nMedical\n229 LATHROP RD; lot 11\nWMC-1\nWMC\ntac 6\n\nnon emerg per le for 13yo w abraisons
(Message From Hiplink) CFD \nStructure FIRE\nBURLINGTON AVE; NEAR THE INTERSTATE\n132\nE1\nRP SAW FROM THE LANDFILL WHAT APPEARS TO BE A HOUSE ON FIRE DOWN THE HILL
(Message From Hiplink) WMC \nMedical\nE 2ND ST & S WOLCOTT ST\nWMC-7\nWMC\nnon emerg to check blood sugar per le
(Message From Hiplink) WMC \nAccident PI\n18500 INTERSTATE 25; MP 185 ;eb\nWMC-0\nWMC\ntac 5\n\ntuck rolled over\nfire by the truck\nsemi\nis across the interstate\nnb lanes\none of the rp's says that the driver is out and is fine\nrp witnessed 251 4795 asia
(Message From Hiplink) WMC \nMedical\n1691 BRYAN STOCK TRL; BRYAN STOCK PONDS\nWMC-7\nWMC\ntac 6\nfemale assault vic'
(Message From Hiplink) WMC \nFall\n651 ANDREA LN ;apt 8\nWMC-7\nWMC\ntac 4\nfemale fell down steps
(Message From Hiplink) CFD \nWildland FIRE\n1701 E K ST\n132\nE1\nflames
(Message From Hiplink) WMC \nAlarm Medical\n1930 E 12TH ST; park place\nWMC-7\nWMC\napt 212\nfemale is responsive -- need assistance getting her up\ndid not give any other information\nunk age
(Message From Hiplink) WMC \nMedical\nCOTTONWOOD CREEK RD;cottonwood beach\nWMC-0\nWMC\ntac 4\n36 yof\nseems dehydrated\nvomiting
(Message From Hiplink) CFD \nSmoke Investig\n2144 BOXELDER AVE\n216\nE2\nsmoke in attic no flames
(Message From Hiplink) WMC \nMedical\n24025 LAKESHORE DR; ALCOVA LAKESIDE MARI\nWMC-0\nWMC\ntac 4\nmale with laceration to his head
(Message From Hiplink) CFD \nService Call\nE 2ND ST & S BEVERLY ST\n312\nE2\nthere is oil on the street from Beverly to Sun on 2nd\nrp states he just about lost control of his vehicle because of it\nin the inside eb lane\n"a lot" of oil\nlooks like someone dropped an oil plug
(Message From Hiplink) CFD \nUnconsciousness\n234 E 1ST ST; WELLS FARGO BANK\n132\nE2\n******** tac 4********\ncome to east side entrance\nmale age 40\nbreathing
(Message From Hiplink) WMC \nBreathing\n322 COLUMBINE\nWMC-7\nWMC\nCALLBACK=(307)259-5962 LAT=42.812154 LON=-106.408789 UNC=51\nrp's mother, 78yof, is on oxygen and is writinbg her a note saying she cannot\nbreathe\nthe meter on her finger says 93, pulse 87\n259-5962\ncounsciou
(Message From Hiplink) WMC \nDead Body\n1714 S WASHINGTON ST\nWMC-7\nWMC\nfemale in bed\n48 yof\nsays that she drank alot\nbelieves that she is beyond help\nsays that her body is cold and is changing colors\nrp is there by herself\nfemale is adrienne lawson\nhad been bleeding fro
(Message From Hiplink) WMC \nChest Pain\n6500 E 2ND ST; suite200, Western Med. As\nWMC-7\nWMC\ntac 4\n\n\n66yom\nhigh cholesterol\nhypertension\nwas scheduled for a regular check up and came in early with chest pain\ncannot lay down for EKG due to chest pain\nbp 126/90, heartrate
(Message From Hiplink) WMC \nMedical\n40 SE WYOMING BLVD; MCDONALDS RESTAURANT\nWMC-7\nWMC\ntac 4\n\nrp's friend passed out\n6yom\npassed out and fell to the floor\nconcious
(Message From Hiplink) WMC \nSuicide Attempt\n4645 SMOKE RISE RD\nWMC-0\nWMC\ntac 5\n\n15 yo daughter ate some decon\nate a couple of tablespoons\nis refusing to get into the car\ncan hear her yelling & screaming in the background
(Message From Hiplink) CFD \nMedical\n4255 CY AVE; regal nails\n7629\nE2\nfemale passed out\n20yof\n21 yof\nshe is dizzy
(Message From Hiplink) WMC \nMedical\n4255 CY AVE; regal nails\nWMC-7\nWMC\nfemale passed out\n20yof\n21 yof\nshe is dizzy
(Message From Hiplink) NCF \nSmoke Investig\n2955 CENTRAL DR; cmmts\n7629\nE7\nfield behind greiner ford\nrp is not seeing flames but sees a lot of gry smoke\nsays that it got very smokey very fast and it is now starting to dissipate
(Message From Hiplink) NCF \nSmoke Investig\n2955 CENTRAL DR; cmmts\n7629\nE7\ntac 5\n\nfield behind greiner ford\nrp is not seeing flames but sees a lot of gry smoke\nsays that it got very smokey very fast and it is now starting to dissipate
(Message From Hiplink) CFD \nTransfer\n1416 E A ST; Cenral WY Urology STE 101\n312\nE3\ntac 4\n\nthere is a patient there that has not been taking his meds\nthe rp would like to have him taken over to WBI\nhe has a hx of manic depression\nthe rp has spoken to WBI and they sugge
(Message From Hiplink) CFD \nMedical\n730 OAKCREST AVE\n312\nE3\ntac 4 male that is having multiple issues\nTAC 4\ndif breathing\nincrease heart rate

Contact: Active911
Agency name: PSCC Location: Casper, WY 
Sender: <csphiplink@cityofcasperwy.com>
  
(Message From Hiplink) NCSO\nFire assist\n2515 DOANE LN; Paula Kraushaar residence\nNCSW\nC45\ncoming from hallway\nhas had two hits on it\ncould not contact resp
(Message From Hiplink) NCSO\nFire assist\nCOUNTY LINE RD\nNCSE\nC42
(Message From Hiplink) NCSO\nFire assist\n3408 APPLEGATE DR; comments\nNCSO\nC57\ne6 responded to field behind this address / area of of trappers route / they\nbelieve it's county / they found a lot of dump trailers with construction trash\nand are requesting a deputy
(Message From Hiplink) NCSO\nHazardous Mat\n19100 INTERSTATE 25; MP 191;UNDERPASS\nNCSE\nC41\nOILY SUBSTANCE ON THE RD UNDER THE UNDERPASS / RP ALMOST CRASHED / 1/4 MILE LONG / UNKN WHAT IT IS AND IT IS VERY SLICK\nSTARTS AT THE OFF RAMP / UNDER THE UNDERPASS AND ALMOST TO
(Message From Hiplink) NCSO\nFire assist\n23000 INTERSTATE 25; MP 230\nMWRD\nC56\n**tac 4**\n\nRP SAYS THE FIRE IS ABOUT 20 YARDS IN SIZE\nHE IS SEEING FLAMES\non the west side of the highway per rp\nON THE SOUTH BOUND SIDE OF THE ROAD\nRP IS NOT SEEING ANY STRUCTURES / THE ONL
(Message From Hiplink) NCSO\nExplosives\n1855 SOUTH LOOP AVE; Def Tech\nNCSW\nC33\nexplosives for disposal
(Message From Hiplink) NCSO\nFire assist\nE ORMSBY RD; COMMENTS\nNCSN\nC16\ntac 5\n\nCALLBACK=(307)258-8361 LAT=42.849918 LON=-106.274765 UNC=25\nTAKE ORMSBY RD 10.5 MILES FROM I25 FOLLOWING THE FLAGGING\nTHE FIRE IS ABOUT 1/4 ACRE BUT HE IS STILL A LITTLE WAYS AWAY
(Message From Hiplink) NCSO\nSmoke Investig\nCASPER MOUNTAIN RD; WEST END\nMTRD\nC49\ntac 6\n\nRP REPORTING SMOKE ON THE WEST END OF THE MTN\nRIGHT BENEATH THE DARK CLOUDS THERE APPEARS TO BE SMOKE COMING FROM THE BACK\nSIDE OF THE MTN
(Message From Hiplink) NCSO\nExplosives\n1855 SOUTH LOOP AVE; Def Tech\nNCSW\nC33\nexplosives for disposal
(Message From Hiplink) NCSO\nFire assist\n17800 INTERSTATE 25; MP 178\nNCSE\nC46\ntac 5\nnb lane just east of 178\nlittle strip on fire\nabout 250-300 yards off the side of the road\nits past the fence and up on a hil\nanother rp, about 300 yards north of the highway, starting
(Message From Hiplink) NCSO\nExplosives\n1855 SOUTH LOOP AVE; Defense Technology\nNCSW\nC33\ncreated for C33
(Message From Hiplink) NCSO\nFire assist\n10995 E WAGON TRAIL RD\nNCSE\nC63\n****tac 5****\n\nwildland fire\nhalf the size of a car in size\nbehind this address\nrp son is trying to put the fire out with a shovel
(Message From Hiplink) NCSO\nFire assist\n14200 W POISON SPIDER RD; POISON SPIDER;\nNCSW\nC12\nCALLBACK=(307)262-5083 LAT=42.834567 LON=-106.562533 UNC=46\napprox 2 miles north/west of poison spider school\nthe rp says the fire is about 3 acres big
(Message From Hiplink) NCSO\nFire assist\nW POISON SPIDER RD\nALRD\nC45\ntac 4\n\nrp sees lots of smoke\nsilvery white smoke\nrp is on poison spider about 3 mileswest of school and says that they see smoke\nabout 4 miles to the north of them\nlooks like west of mills ranch abou
(Message From Hiplink) NCSO\nFire assist\n5800 S POPLAR ST\nNCSS\nC49\ntac 5\n\nzone 30 smoke\nLeslie Chapin -- is there and can not find any problems\n472-3177
(Message From Hiplink) NCSO\nFire assist\n28300 W US HIGHWAY 20-26; MP 32\nNCSW\nC27\ntac 4\n\nsouth of this mm -- about  1mile off the road --\nstates east of the wheat fields west of where the old natrona shed used to be\nlarger than a house\nnot a lot of flames\nunk if there
(Message From Hiplink) NCSO\nFire assist\n10300 THIRTY THREE MILE RD\nNCSW\nC62\n**tac 4**\n\nneighbor to the south / lightening started a fire\nrp can see flames she is about 1/4 mile from the neighbor\n----------------\nNCSO briefing notified\n----------------\nrp says the way
(Message From Hiplink) NCSO\nSmoke Investig\n2571 EAST END RD\nMTRD\nC14\ntac 4\nrp says she smells smoke\nthinks it might be a campefire at beartrap\ncant see smoke or flames\njust smells is\nsince about 0300
(Message From Hiplink) NCSO\nSmoke Investig\n11155 W GOOSE EGG RD\nMTRD\nC60\n1 mile from the goose egg inn smelling smoke add contact info 2346579
(Message From Hiplink) NCSO\nFire assist\nKORTES RD; COMMENTS\nALRD\nC30\nTOWARDS CLARKWELL RANCH -- THERE IS A LARGE WILDLAND FIRE AND CARBON CO IS REQUESTING ASSISTANCE FROM US
(Message From Hiplink) CPD\nBomb Incident\n201 N DAVID ST;fremont county\nPD-3\nC33\ncreated per c33  assist in fremont county
(Message From Hiplink) CPD\nTest Spillman\n201 N DAVID ST; CPD\nPD-3\nA119\nPage the BANKS group --- this is to be done every 1st Monday of every month per\nthe chief at 10 00hrs\n\n--send text message that states --\n\nThis is a test, and to call 307-235-8278 to confirm recei
(Message From Hiplink) NCSO\nFire assist\nTWELVE MILE RD & W POISON SPIDER RD\nNCSW\nC12\ntac 5  near the platte river gun club\nfire appears to be dying down a little bit\n20-50 yards wide at this time
(Message From Hiplink) NCSO\nFire assist\nCOLE CREEK RD\nNCSE\nC12\ntac 4\n\n\nCALLBACK=(307)259-5500 LAT=42.865455 LON=-106.207924 UNC=28\nfire in the grass at the bridge on cole creek\nsecond rp, about the size of a camp trailer\nit's really growing from the wind\nno structure
(Message From Hiplink) NCSO\nExplosives\n515 E 13TH ST\nNCSO\nC33\nold ammo and fireworks
(Message From Hiplink) NCSO\nFire assist\n1922 ABSAROKA TRL; heinve res\nNCSW\nC64\naudiable smoke alarm / hallway / vivent is attemtping to contact respond / p210 8773203858
(Message From Hiplink) NCSO\nFire assist\n37250 STATE HIGHWAY 259;WEST OF MIDWEST\nMWRD\nFD1\ntac 4\n\nMADISON18 / RP CAN SEE SMOKE IN THE FIELD\nCAN SEE SMOKE\nRP CAN SEE THE SUB OFFICE AND SMOKE\nRP IS ON CREW 6 RD / CAN SEE SMOKE / THINKS IT IS ABOUT 8  MILES EAST OF\nMIDWES
(Message From Hiplink) CPD\nTest Spillman\n201 N DAVID ST; logging new units\nPD-3\nA245
(Message From Hiplink) NCSO\nSmoke Investig\nCOLE CREEK RD\nNCSE\nC14\ntac 4\nper c14 he sees column of smoke
(Message From Hiplink) NCSO\nFire assist\n1949 N PYRITE RD; Cathedral Energy\nNCSW\nNCSO\nzone 11 fire alarm\nalarm co will call resp\nshe thinks they may be switching out batteries\nright before they got the alarm they got a low battery\nsignal
(Message From Hiplink) NCSO\nAlert 1-Aircraf\n8500 AIRPORT PKY; AIRPORT\nNCSW\nC56\ntac 6\n\nglider making a cross landing
(Message From Hiplink) NCSO\nExplosives\n2888 SIX MILE RD\nNCSW\nC56\nrp found a tube with  duct tape on the ends and some kind of fertalizer in it thrown in his yard\nrp thinks it is a pipe bomb of some kind
(Message From Hiplink) CPD\nProj. Lifesave\n2885 INDIAN SPRINGS DR\nPD-6\nA209\nrichard jackson has wandered away / was found at the mini mart last week / freq # 215945 he is in cad under Carl and he answers to Carl
*/

public class WYNatronaCountyParserTest extends BaseParserTest {
  
  public WYNatronaCountyParserTest() {
    setParser(new WYNatronaCountyParser(), "NATRONA COUNTY", "WY");
  }
  
  @Test
  public void testConnorYoung() {

    doTest("T1",
        "(Message from HipLink) 1/1 EVF \n" +
        "  Fall\n" +
        "  1180 WESTERN AVE; Butch's Happy Days Liq\n" +
        "  351\n" +
        "  R12\n" +
        "  ****TAC 4****POSSIBLE BROKEN ANKLE",

        "SRC:EVF",
        "CALL:Fall",
        "ADDR:1180 WESTERN AVE",
        "PLACE:BUTCH'S HAPPY DAYS LIQ",
        "MAP:351",
        "UNIT:R12",
        "CH:TAC 4",
        "INFO:POSSIBLE BROKEN ANKLE");
  
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Message From Hiplink) CFD \n" +
        "Accident PI\n" +
        "1230 E 1ST ST; wyo cardiopulmonary\n" +
        "312\n" +
        "E3\n" +
        "CALLBACK=(307)315-4272 LAT=42.850822 LON=-106.308861 UNC=28\n" +
        "tac 4 - hit had when rear ended",

        "SRC:CFD",
        "CALL:Accident PI",
        "ADDR:1230 E 1ST ST",
        "PLACE:WYO CARDIOPULMONARY",
        "MAP:312",
        "UNIT:E3",
        "PHONE:(307)315-4272",
        "GPS:+42.850822,-106.308861",
        "CH:tac 4",
        "INFO:hit had when rear ended");

    doTest("T2",
        "(Message From Hiplink) CFD \nMedical\n154 N BEECH ST; apt 207\n132\nE1",
        "SRC:CFD",
        "CALL:Medical",
        "ADDR:154 N BEECH ST",
        "APT:207",
        "MAP:132",
        "UNIT:E1");

    doTest("T3",
        "(Message From Hiplink) CFD \n" +
        "Chest Pain\n" +
        "2401 GRANDVIEW PL; apt 18\n" +
        "216\n" +
        "E1\n" +
        "rp's brother is having chest pain\n" +
        "46yom\n" +
        "just took 2 nitroglycerine",

        "SRC:CFD",
        "CALL:Chest Pain",
        "ADDR:2401 GRANDVIEW PL",
        "APT:18",
        "MAP:216",
        "UNIT:E1",
        "INFO:rp's brother is having chest pain / 46yom / just took 2 nitroglycerine");

    doTest("T4",
        "(Message From Hiplink) CFD \nMedical\n945 N ELMA ST; apt 301\n132\nE1\ntac 4 - 3rd party female confused and dehydrated",
        "SRC:CFD",
        "CALL:Medical",
        "ADDR:945 N ELMA ST",
        "APT:301",
        "MAP:132",
        "UNIT:E1",
        "CH:tac 4",
        "INFO:3rd party female confused and dehydrated");

    doTest("T5",
        "(Message From Hiplink) CFD \n" +
        "Diabetic Shock\n" +
        "1691 BRYAN STOCK TRL; BRYAN STOCK PONDS\n" +
        "315\n" +
        "E3\n" +
        "tac 7\n\n" +
        "CALLBACK=(904)322-2084 LAT=42.849898 LON=-106.261611 UNC=3674\n" +
        "male in diabetic shock\n" +
        "male states he is at the duck ponds\n" +
        "904-322-2084\n" +
        "male that is layed out on the ground",

        "SRC:CFD",
        "CALL:Diabetic Shock",
        "ADDR:1691 BRYAN STOCK TRL",
        "PLACE:BRYAN STOCK PONDS",
        "MAP:315",
        "UNIT:E3",
        "PHONE:(904)322-2084",
        "GPS:+42.849898,-106.261611",
        "CH:tac 7",
        "INFO:male in diabetic shock / male states he is at the duck ponds / 904-322-2084 / male that is layed out on the ground");

    doTest("T6",
        "(Message From Hiplink) CFD \nMedical\n150 N GRANT ST\n132\nE1\nper le on scene non emergent check on a gal",
        "SRC:CFD",
        "CALL:Medical",
        "ADDR:150 N GRANT ST",
        "MAP:132",
        "UNIT:E1",
        "INFO:per le on scene non emergent check on a gal");

    doTest("T7",
        "(Message From Hiplink) CFD \nMedical\n150 N GRANT ST\n132\nE1\ntac 4\n\nper le on scene non emergent check on a gal",
        "SRC:CFD",
        "CALL:Medical",
        "ADDR:150 N GRANT ST",
        "MAP:132",
        "UNIT:E1",
        "CH:tac 4",
        "INFO:per le on scene non emergent check on a gal");

    doTest("T8",
        "(Message From Hiplink) CFD \nUnconsciousness\n155 N BEECH ST; WCDA\n132\nE1\n**tac 4**\n\nmale lying on sidewalk  rp hung up",
        "SRC:CFD",
        "CALL:Unconsciousness",
        "ADDR:155 N BEECH ST",
        "PLACE:WCDA",
        "MAP:132",
        "UNIT:E1",
        "CH:tac 4",
        "INFO:male lying on sidewalk  rp hung up");

    doTest("T9",
        "(Message From Hiplink) CFD \nMedical\n237 E K ST\n132\nE1\nfemale can't get out of bed -- has a pinched nerve",
        "SRC:CFD",
        "CALL:Medical",
        "ADDR:237 E K ST",
        "MAP:132",
        "UNIT:E1",
        "INFO:female can't get out of bed -- has a pinched nerve");

    doTest("T10",
        "(Message From Hiplink) CFD \nUnconsciousness\n4305 S POPLAR ST;plc\n216\nE2",
        "SRC:CFD",
        "CALL:Unconsciousness",
        "ADDR:4305 S POPLAR ST",
        "PLACE:PLC",
        "MAP:216",
        "UNIT:E2");

    doTest("T11",
        "(Message From Hiplink) CFD \nChest Pain\n300 W B C ST;apt 413\n123\nE1",
        "SRC:CFD",
        "CALL:Chest Pain",
        "ADDR:300 W B C ST",
        "APT:413",
        "MAP:123",
        "UNIT:E1");

    doTest("T12",
        "(Message From Hiplink) CFD \nCardiac Problem\n945 N ELMA ST; apt 205\n132\nE1",
        "SRC:CFD",
        "CALL:Cardiac Problem",
        "ADDR:945 N ELMA ST",
        "APT:205",
        "MAP:132",
        "UNIT:E1");

    doTest("T13",
        "(Message From Hiplink) CFD \nDead Body\n300 W B C ST; apt 435\n123\nE2\nrp has key into the apartment",
        "SRC:CFD",
        "CALL:Dead Body",
        "ADDR:300 W B C ST",
        "APT:435",
        "MAP:123",
        "UNIT:E2",
        "INFO:rp has key into the apartment");

    doTest("T14",
        "(Message From Hiplink) WMC \n" +
        "Medical\n" +
        "527 FULTON ST\n" +
        "WMC-6\n" +
        "WMC\n" +
        "tac 5 - high ammonia level confusion\n\n" +
        "CALLBACK=(307)277-5648 LAT=42.838978 LON=-106.387650 UNC=16",

        "SRC:WMC",
        "CALL:Medical",
        "ADDR:527 FULTON ST",
        "MAP:WMC-6",
        "UNIT:WMC",
        "PHONE:(307)277-5648",
        "GPS:+42.838978,-106.387650",
        "CH:tac 5",
        "INFO:high ammonia level confusion");

    doTest("T15",
        "(Message From Hiplink) CFD \n" +
        "Lockout\n" +
        "195 PRONGHORN ST; your first steps\n" +
        "123\n" +
        "E2\n" +
        "CALLBACK=(307)359-5006 LAT=42.851808 LON=-106.270881 UNC=19\n" +
        "children locked in veh\n" +
        "been there about 5 mins",

        "SRC:CFD",
        "CALL:Lockout",
        "ADDR:195 PRONGHORN ST",
        "PLACE:YOUR FIRST STEPS",
        "MAP:123",
        "UNIT:E2",
        "PHONE:(307)359-5006",
        "GPS:+42.851808,-106.270881",
        "INFO:children locked in veh / been there about 5 mins");

    doTest("T16",
        "(Message From Hiplink) CFD \n" +
        "Accident PI\n" +
        "41 SE WYOMING BLVD; FLYING J\n" +
        "WMC-7\n" +
        "E5\n" +
        "this is from a hit and run that occured 30 min ago -- subject is now complaining\n" +
        "of head pain",

        "SRC:CFD",
        "CALL:Accident PI",
        "ADDR:41 SE WYOMING BLVD",
        "PLACE:FLYING J",
        "MAP:WMC-7",
        "UNIT:E5",
        "INFO:this is from a hit and run that occured 30 min ago -- subject is now complaining / of head pain");

    doTest("T17",
        "(Message From Hiplink) WMC \nBreathing\n154 N BEECH ST; apt 207\nWMC-7\nWMC\n**tac 5** is having a hard time breathing -- has copd",
        "SRC:WMC",
        "CALL:Breathing",
        "ADDR:154 N BEECH ST",
        "APT:207",
        "MAP:WMC-7",
        "UNIT:WMC",
        "CH:tac 5",
        "INFO:is having a hard time breathing -- has copd");

    doTest("T18",
        "(Message From Hiplink) CFD \n" +
        "Breathing\n" +
        "1120 N DURBIN ST\n" +
        "132\n" +
        "E1\n" +
        "55yof\n" +
        "has copd and chronic pancreatitis\n" +
        "is cons\n" +
        "breathing\n" +
        "is on o2\n" +
        "no trouble speaking bet breaths",

        "SRC:CFD",
        "CALL:Breathing",
        "ADDR:1120 N DURBIN ST",
        "MAP:132",
        "UNIT:E1",
        "INFO:55yof / has copd and chronic pancreatitis / is cons / breathing / is on o2 / no trouble speaking bet breaths");

    doTest("T19",
        "(Message From Hiplink) WMC \n" +
        "Breathing\n" +
        "1120 N DURBIN ST\n" +
        "WMC-7\n" +
        "WMC\n" +
        "55yof\n" +
        "has copd and chronic pancreatitis\n" +
        "is cons\n" +
        "breathing\n" +
        "is on o2\n" +
        "no trouble speaking bet breaths\n" +
        "neg chging color",

        "SRC:WMC",
        "CALL:Breathing",
        "ADDR:1120 N DURBIN ST",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:55yof / has copd and chronic pancreatitis / is cons / breathing / is on o2 / no trouble speaking bet breaths / neg chging color");

    doTest("T20",
        "(Message From Hiplink) WMC \n" +
        "Seizure\n" +
        "915 S MCKINLEY ST;ycc\n" +
        "WMC-7\n" +
        "WMC\n" +
        "16 yof\n" +
        "cons\n" +
        "breathing\n" +
        "says she cant feel her body\n" +
        "hx of seizures\n" +
        "has meds for it",

        "SRC:WMC",
        "CALL:Seizure",
        "ADDR:915 S MCKINLEY ST",
        "PLACE:YCC",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:16 yof / cons / breathing / says she cant feel her body / hx of seizures / has meds for it");

    doTest("T21",
        "(Message From Hiplink) WMC \nTraumatic Inj\n1120 N KIMBALL ST; MARION KREINER PARK\nWMC-7\nWMC\nmale hit in head with rock",
        "SRC:WMC",
        "CALL:Traumatic Inj",
        "ADDR:1120 N KIMBALL ST",
        "PLACE:MARION KREINER PARK",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:male hit in head with rock");

    doTest("T22",
        "(Message From Hiplink) CFD \nMedical\n1835 HYVIEW DR\n216\nE2\ntac 4",
        "SRC:CFD",
        "CALL:Medical",
        "ADDR:1835 HYVIEW DR",
        "MAP:216",
        "UNIT:E2",
        "CH:tac 4");

    doTest("T23",
        "(Message From Hiplink) CFD \n" +
        "Alarm Medical\n" +
        "1444 S LAUREL ST\n" +
        "216\n" +
        "E2\n" +
        "tac 4   female pressed her lifeline alarm   she fell out of bed and needs help back to bed",

        "SRC:CFD",
        "CALL:Alarm Medical",
        "ADDR:1444 S LAUREL ST",
        "MAP:216",
        "UNIT:E2",
        "CH:tac 4",
        "INFO:female pressed her lifeline alarm   she fell out of bed and needs help back to bed");

    doTest("T24",
        "(Message From Hiplink) NCF \nFall\n4240 FOX\n7629\nSQ7\ntac 4 - fell and hit her head, still on the floor\n85yof",
        "SRC:NCF",
        "CALL:Fall",
        "ADDR:4240 FOX",
        "MAP:7629",
        "UNIT:SQ7",
        "CH:tac 4",
        "INFO:fell and hit her head, still on the floor / 85yof");

    doTest("T25",
        "(Message From Hiplink) CFD \nBreathing\n2401 GRANDVIEW PL; APT 18\n216\nE2\nFEMALE STATING THAT SHE CAN'T BREATHE",
        "SRC:CFD",
        "CALL:Breathing",
        "ADDR:2401 GRANDVIEW PL",
        "APT:18",
        "MAP:216",
        "UNIT:E2",
        "INFO:FEMALE STATING THAT SHE CAN'T BREATHE");

    doTest("T26",
        "(Message From Hiplink) WMC \n" +
        "Unconsciousness\n" +
        "307 E 2ND ST; NATRONA COUNTY PUBLIC LIBR\n" +
        "WMC-7\n" +
        "WMC\n" +
        "female passed out will not wake up in the back by the parking lot may be dk",

        "SRC:WMC",
        "CALL:Unconsciousness",
        "ADDR:307 E 2ND ST",
        "PLACE:NATRONA COUNTY PUBLIC LIBR",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:female passed out will not wake up in the back by the parking lot may be dk");

    doTest("T27",
        "(Message From Hiplink) WMC \nMedical\n229 LATHROP RD; lot 11\nWMC-1\nWMC\ntac 6\n\nnon emerg per le for 13yo w abraisons",
        "SRC:WMC",
        "CALL:Medical",
        "ADDR:229 LATHROP RD",
        "APT:11",
        "MAP:WMC-1",
        "UNIT:WMC",
        "CH:tac 6",
        "INFO:non emerg per le for 13yo w abraisons");

    doTest("T28",
        "(Message From Hiplink) CFD \n" +
        "Structure FIRE\n" +
        "BURLINGTON AVE; NEAR THE INTERSTATE\n" +
        "132\n" +
        "E1\n" +
        "RP SAW FROM THE LANDFILL WHAT APPEARS TO BE A HOUSE ON FIRE DOWN THE HILL",

        "SRC:CFD",
        "CALL:Structure FIRE",
        "ADDR:BURLINGTON AVE",
        "PLACE:NEAR THE INTERSTATE",
        "MAP:132",
        "UNIT:E1",
        "INFO:RP SAW FROM THE LANDFILL WHAT APPEARS TO BE A HOUSE ON FIRE DOWN THE HILL");

    doTest("T29",
        "(Message From Hiplink) WMC \nMedical\nE 2ND ST & S WOLCOTT ST\nWMC-7\nWMC\nnon emerg to check blood sugar per le",
        "SRC:WMC",
        "CALL:Medical",
        "ADDR:E 2ND ST & S WOLCOTT ST",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:non emerg to check blood sugar per le");

    doTest("T30",
        "(Message From Hiplink) WMC \n" +
        "Accident PI\n" +
        "18500 INTERSTATE 25; MP 185 ;eb\n" +
        "WMC-0\n" +
        "WMC\n" +
        "tac 5\n\n" +
        "tuck rolled over\n" +
        "fire by the truck\n" +
        "semi\n" +
        "is across the interstate\n" +
        "nb lanes\n" +
        "one of the rp's says that the driver is out and is fine\n" +
        "rp witnessed 251 4795 asia",

        "SRC:WMC",
        "CALL:Accident PI",
        "ADDR:18500 INTERSTATE 25 MP 185 EB",
        "MADDR:18500 INTERSTATE 25 MP 185",
        "MAP:WMC-0",
        "UNIT:WMC",
        "CH:tac 5",
        "INFO:tuck rolled over / fire by the truck / semi / is across the interstate / nb lanes / one of the rp's says that the driver is out and is fine / rp witnessed 251 4795 asia");

    doTest("T31",
        "(Message From Hiplink) WMC \nMedical\n1691 BRYAN STOCK TRL; BRYAN STOCK PONDS\nWMC-7\nWMC\ntac 6\nfemale assault vic'",
        "SRC:WMC",
        "CALL:Medical",
        "ADDR:1691 BRYAN STOCK TRL",
        "PLACE:BRYAN STOCK PONDS",
        "MAP:WMC-7",
        "UNIT:WMC",
        "CH:tac 6",
        "INFO:female assault vic'");

    doTest("T32",
        "(Message From Hiplink) WMC \nFall\n651 ANDREA LN ;apt 8\nWMC-7\nWMC\ntac 4\nfemale fell down steps",
        "SRC:WMC",
        "CALL:Fall",
        "ADDR:651 ANDREA LN",
        "APT:8",
        "MAP:WMC-7",
        "UNIT:WMC",
        "CH:tac 4",
        "INFO:female fell down steps");

    doTest("T33",
        "(Message From Hiplink) CFD \nWildland FIRE\n1701 E K ST\n132\nE1\nflames",
        "SRC:CFD",
        "CALL:Wildland FIRE",
        "ADDR:1701 E K ST",
        "MAP:132",
        "UNIT:E1",
        "INFO:flames");

    doTest("T34",
        "(Message From Hiplink) WMC \n" +
        "Alarm Medical\n" +
        "1930 E 12TH ST; park place\n" +
        "WMC-7\n" +
        "WMC\n" +
        "apt 212\n" +
        "female is responsive -- need assistance getting her up\n" +
        "did not give any other information\n" +
        "unk age",

        "SRC:WMC",
        "CALL:Alarm Medical",
        "ADDR:1930 E 12TH ST",
        "APT:212",
        "PLACE:PARK PLACE",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:female is responsive -- need assistance getting her up / did not give any other information / unk age");

    doTest("T35",
        "(Message From Hiplink) WMC \nMedical\nCOTTONWOOD CREEK RD;cottonwood beach\nWMC-0\nWMC\ntac 4\n36 yof\nseems dehydrated\nvomiting",
        "SRC:WMC",
        "CALL:Medical",
        "ADDR:COTTONWOOD CREEK RD",
        "PLACE:COTTONWOOD BEACH",
        "MAP:WMC-0",
        "UNIT:WMC",
        "CH:tac 4",
        "INFO:36 yof / seems dehydrated / vomiting");

    doTest("T36",
        "(Message From Hiplink) CFD \nSmoke Investig\n2144 BOXELDER AVE\n216\nE2\nsmoke in attic no flames",
        "SRC:CFD",
        "CALL:Smoke Investig",
        "ADDR:2144 BOXELDER AVE",
        "MAP:216",
        "UNIT:E2",
        "INFO:smoke in attic no flames");

    doTest("T37",
        "(Message From Hiplink) WMC \nMedical\n24025 LAKESHORE DR; ALCOVA LAKESIDE MARI\nWMC-0\nWMC\ntac 4\nmale with laceration to his head",
        "SRC:WMC",
        "CALL:Medical",
        "ADDR:24025 LAKESHORE DR",
        "PLACE:ALCOVA LAKESIDE MARI",
        "MAP:WMC-0",
        "UNIT:WMC",
        "CH:tac 4",
        "INFO:male with laceration to his head");

    doTest("T38",
        "(Message From Hiplink) CFD \n" +
        "Service Call\n" +
        "E 2ND ST & S BEVERLY ST\n" +
        "312\n" +
        "E2\n" +
        "there is oil on the street from Beverly to Sun on 2nd\n" +
        "rp states he just about lost control of his vehicle because of it\n" +
        "in the inside eb lane\n" +
        "\"a lot\" of oil\n" +
        "looks like someone dropped an oil plug",

        "SRC:CFD",
        "CALL:Service Call",
        "ADDR:E 2ND ST & S BEVERLY ST",
        "MAP:312",
        "UNIT:E2",
        "INFO:there is oil on the street from Beverly to Sun on 2nd / rp states he just about lost control of his vehicle because of it / in the inside eb lane / \"a lot\" of oil / looks like someone dropped an oil plug");

    doTest("T39",
        "(Message From Hiplink) CFD \n" +
        "Unconsciousness\n" +
        "234 E 1ST ST; WELLS FARGO BANK\n" +
        "132\n" +
        "E2\n" +
        "******** tac 4********\n" +
        "come to east side entrance\n" +
        "male age 40\n" +
        "breathing",

        "SRC:CFD",
        "CALL:Unconsciousness",
        "ADDR:234 E 1ST ST",
        "PLACE:WELLS FARGO BANK",
        "MAP:132",
        "UNIT:E2",
        "CH:tac 4",
        "INFO:come to east side entrance / male age 40 / breathing");

    doTest("T40",
        "(Message From Hiplink) WMC \n" +
        "Breathing\n" +
        "322 COLUMBINE\n" +
        "WMC-7\n" +
        "WMC\n" +
        "CALLBACK=(307)259-5962 LAT=42.812154 LON=-106.408789 UNC=51\n" +
        "rp's mother, 78yof, is on oxygen and is writinbg her a note saying she cannot\n" +
        "breathe\n" +
        "the meter on her finger says 93, pulse 87\n" +
        "259-5962\n" +
        "counsciou",

        "SRC:WMC",
        "CALL:Breathing",
        "ADDR:322 COLUMBINE",
        "MAP:WMC-7",
        "UNIT:WMC",
        "PHONE:(307)259-5962",
        "GPS:+42.812154,-106.408789",
        "INFO:rp's mother, 78yof, is on oxygen and is writinbg her a note saying she cannot / breathe / the meter on her finger says 93, pulse 87 / 259-5962 / counsciou");

    doTest("T41",
        "(Message From Hiplink) WMC \n" +
        "Dead Body\n" +
        "1714 S WASHINGTON ST\n" +
        "WMC-7\n" +
        "WMC\n" +
        "female in bed\n" +
        "48 yof\n" +
        "says that she drank alot\n" +
        "believes that she is beyond help\n" +
        "says that her body is cold and is changing colors\n" +
        "rp is there by herself\n" +
        "female is adrienne lawson\n" +
        "had been bleeding fro",

        "SRC:WMC",
        "CALL:Dead Body",
        "ADDR:1714 S WASHINGTON ST",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:female in bed / 48 yof / says that she drank alot / believes that she is beyond help / says that her body is cold and is changing colors / rp is there by herself / female is adrienne lawson / had been bleeding fro");

    doTest("T42",
        "(Message From Hiplink) WMC \n" +
        "Chest Pain\n" +
        "6500 E 2ND ST; suite200, Western Med. As\n" +
        "WMC-7\n" +
        "WMC\n" +
        "tac 4\n\n\n" +
        "66yom\n" +
        "high cholesterol\n" +
        "hypertension\n" +
        "was scheduled for a regular check up and came in early with chest pain\n" +
        "cannot lay down for EKG due to chest pain\n" +
        "bp 126/90, heartrate",

        "SRC:WMC",
        "CALL:Chest Pain",
        "ADDR:6500 E 2ND ST",
        "APT:200, WESTERN MED. AS",
        "MAP:WMC-7",
        "UNIT:WMC",
        "CH:tac 4",
        "INFO:66yom / high cholesterol / hypertension / was scheduled for a regular check up and came in early with chest pain / cannot lay down for EKG due to chest pain / bp 126/90, heartrate");

    doTest("T43",
        "(Message From Hiplink) WMC \n" +
        "Medical\n" +
        "40 SE WYOMING BLVD; MCDONALDS RESTAURANT\n" +
        "WMC-7\n" +
        "WMC\n" +
        "tac 4\n\n" +
        "rp's friend passed out\n" +
        "6yom\n" +
        "passed out and fell to the floor\n" +
        "concious",

        "SRC:WMC",
        "CALL:Medical",
        "ADDR:40 SE WYOMING BLVD",
        "PLACE:MCDONALDS RESTAURANT",
        "MAP:WMC-7",
        "UNIT:WMC",
        "CH:tac 4",
        "INFO:rp's friend passed out / 6yom / passed out and fell to the floor / concious");

    doTest("T44",
        "(Message From Hiplink) WMC \n" +
        "Suicide Attempt\n" +
        "4645 SMOKE RISE RD\n" +
        "WMC-0\n" +
        "WMC\n" +
        "tac 5\n\n" +
        "15 yo daughter ate some decon\n" +
        "ate a couple of tablespoons\n" +
        "is refusing to get into the car\n" +
        "can hear her yelling & screaming in the background",

        "SRC:WMC",
        "CALL:Suicide Attempt",
        "ADDR:4645 SMOKE RISE RD",
        "MAP:WMC-0",
        "UNIT:WMC",
        "CH:tac 5",
        "INFO:15 yo daughter ate some decon / ate a couple of tablespoons / is refusing to get into the car / can hear her yelling & screaming in the background");

    doTest("T45",
        "(Message From Hiplink) CFD \nMedical\n4255 CY AVE; regal nails\n7629\nE2\nfemale passed out\n20yof\n21 yof\nshe is dizzy",
        "SRC:CFD",
        "CALL:Medical",
        "ADDR:4255 CY AVE",
        "PLACE:REGAL NAILS",
        "MAP:7629",
        "UNIT:E2",
        "INFO:female passed out / 20yof / 21 yof / she is dizzy");

    doTest("T46",
        "(Message From Hiplink) WMC \nMedical\n4255 CY AVE; regal nails\nWMC-7\nWMC\nfemale passed out\n20yof\n21 yof\nshe is dizzy",
        "SRC:WMC",
        "CALL:Medical",
        "ADDR:4255 CY AVE",
        "PLACE:REGAL NAILS",
        "MAP:WMC-7",
        "UNIT:WMC",
        "INFO:female passed out / 20yof / 21 yof / she is dizzy");

    doTest("T47",
        "(Message From Hiplink) NCF \n" +
        "Smoke Investig\n" +
        "2955 CENTRAL DR; cmmts\n" +
        "7629\n" +
        "E7\n" +
        "field behind greiner ford\n" +
        "rp is not seeing flames but sees a lot of gry smoke\n" +
        "says that it got very smokey very fast and it is now starting to dissipate",

        "SRC:NCF",
        "CALL:Smoke Investig",
        "ADDR:2955 CENTRAL DR",
        "PLACE:CMMTS",
        "MAP:7629",
        "UNIT:E7",
        "INFO:field behind greiner ford / rp is not seeing flames but sees a lot of gry smoke / says that it got very smokey very fast and it is now starting to dissipate");

    doTest("T48",
        "(Message From Hiplink) NCF \n" +
        "Smoke Investig\n" +
        "2955 CENTRAL DR; cmmts\n" +
        "7629\n" +
        "E7\n" +
        "tac 5\n\n" +
        "field behind greiner ford\n" +
        "rp is not seeing flames but sees a lot of gry smoke\n" +
        "says that it got very smokey very fast and it is now starting to dissipate",

        "SRC:NCF",
        "CALL:Smoke Investig",
        "ADDR:2955 CENTRAL DR",
        "PLACE:CMMTS",
        "MAP:7629",
        "UNIT:E7",
        "CH:tac 5",
        "INFO:field behind greiner ford / rp is not seeing flames but sees a lot of gry smoke / says that it got very smokey very fast and it is now starting to dissipate");

    doTest("T49",
        "(Message From Hiplink) CFD \n" +
        "Transfer\n" +
        "1416 E A ST; Cenral WY Urology STE 101\n" +
        "312\n" +
        "E3\n" +
        "tac 4\n\n" +
        "there is a patient there that has not been taking his meds\n" +
        "the rp would like to have him taken over to WBI\n" +
        "he has a hx of manic depression\n" +
        "the rp has spoken to WBI and they sugge",

        "SRC:CFD",
        "CALL:Transfer",
        "ADDR:1416 E A ST",
        "PLACE:CENRAL WY UROLOGY STE 101",
        "MAP:312",
        "UNIT:E3",
        "CH:tac 4",
        "INFO:there is a patient there that has not been taking his meds / the rp would like to have him taken over to WBI / he has a hx of manic depression / the rp has spoken to WBI and they sugge");

    doTest("T50",
        "(Message From Hiplink) CFD \n" +
        "Medical\n" +
        "730 OAKCREST AVE\n" +
        "312\n" +
        "E3\n" +
        "tac 4 male that is having multiple issues\n" +
        "TAC 4\n" +
        "dif breathing\n" +
        "increase heart rate",

        "SRC:CFD",
        "CALL:Medical",
        "ADDR:730 OAKCREST AVE",
        "MAP:312",
        "UNIT:E3",
        "CH:TAC 4",
        "INFO:male that is having multiple issues / dif breathing / increase heart rate");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "2515 DOANE LN; Paula Kraushaar residence\n" +
        "NCSW\n" +
        "C45\n" +
        "coming from hallway\n" +
        "has had two hits on it\n" +
        "could not contact resp",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:2515 DOANE LN",
        "PLACE:PAULA KRAUSHAAR RESIDENCE",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C45",
        "INFO:coming from hallway / has had two hits on it / could not contact resp");

    doTest("T2",
        "(Message From Hiplink) NCSO\nFire assist\nCOUNTY LINE RD\nNCSE\nC42",
        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:COUNTY LINE RD",
        "CITY:NATRONA COUNTY",
        "MAP:NCSE",
        "UNIT:C42");

    doTest("T3",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "3408 APPLEGATE DR; comments\n" +
        "NCSO\n" +
        "C57\n" +
        "e6 responded to field behind this address / area of of trappers route / they\n" +
        "believe it's county / they found a lot of dump trailers with construction trash\n" +
        "and are requesting a deputy",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:3408 APPLEGATE DR",
        "CITY:NATRONA COUNTY",
        "MAP:NCSO",
        "UNIT:C57",
        "INFO:e6 responded to field behind this address / area of of trappers route / they / believe it's county / they found a lot of dump trailers with construction trash / and are requesting a deputy");

    doTest("T4",
        "(Message From Hiplink) NCSO\n" +
        "Hazardous Mat\n" +
        "19100 INTERSTATE 25; MP 191;UNDERPASS\n" +
        "NCSE\n" +
        "C41\n" +
        "OILY SUBSTANCE ON THE RD UNDER THE UNDERPASS / RP ALMOST CRASHED / 1/4 MILE LONG / UNKN WHAT IT IS AND IT IS VERY SLICK\n" +
        "STARTS AT THE OFF RAMP / UNDER THE UNDERPASS AND ALMOST TO",

        "SRC:NCSO",
        "CALL:Hazardous Mat",
        "ADDR:19100 INTERSTATE 25 MP 191",
        "PLACE:UNDERPASS",
        "CITY:NATRONA COUNTY",
        "MAP:NCSE",
        "UNIT:C41",
        "INFO:OILY SUBSTANCE ON THE RD UNDER THE UNDERPASS / RP ALMOST CRASHED / 1/4 MILE LONG / UNKN WHAT IT IS AND IT IS VERY SLICK / STARTS AT THE OFF RAMP / UNDER THE UNDERPASS AND ALMOST TO");

    doTest("T5",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "23000 INTERSTATE 25; MP 230\n" +
        "MWRD\n" +
        "C56\n" +
        "**tac 4**\n\n" +
        "RP SAYS THE FIRE IS ABOUT 20 YARDS IN SIZE\n" +
        "HE IS SEEING FLAMES\n" +
        "on the west side of the highway per rp\n" +
        "ON THE SOUTH BOUND SIDE OF THE ROAD\n" +
        "RP IS NOT SEEING ANY STRUCTURES / THE ONL",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:23000 INTERSTATE 25 MP 230",
        "CITY:MIDWEST",
        "MAP:MWRD",
        "UNIT:C56",
        "CH:tac 4",
        "INFO:RP SAYS THE FIRE IS ABOUT 20 YARDS IN SIZE / HE IS SEEING FLAMES / on the west side of the highway per rp / ON THE SOUTH BOUND SIDE OF THE ROAD / RP IS NOT SEEING ANY STRUCTURES / THE ONL");

    doTest("T6",
        "(Message From Hiplink) NCSO\nExplosives\n1855 SOUTH LOOP AVE; Def Tech\nNCSW\nC33\nexplosives for disposal",
        "SRC:NCSO",
        "CALL:Explosives",
        "ADDR:1855 SOUTH LOOP AVE",
        "PLACE:DEF TECH",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C33",
        "INFO:explosives for disposal");

    doTest("T7",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "E ORMSBY RD; COMMENTS\n" +
        "NCSN\n" +
        "C16\n" +
        "tac 5\n\n" +
        "CALLBACK=(307)258-8361 LAT=42.849918 LON=-106.274765 UNC=25\n" +
        "TAKE ORMSBY RD 10.5 MILES FROM I25 FOLLOWING THE FLAGGING\n" +
        "THE FIRE IS ABOUT 1/4 ACRE BUT HE IS STILL A LITTLE WAYS AWAY",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:E ORMSBY RD",
        "CITY:NATRONA COUNTY",
        "MAP:NCSN",
        "UNIT:C16",
        "PHONE:(307)258-8361",
        "GPS:+42.849918,-106.274765",
        "CH:tac 5",
        "INFO:TAKE ORMSBY RD 10.5 MILES FROM I25 FOLLOWING THE FLAGGING / THE FIRE IS ABOUT 1/4 ACRE BUT HE IS STILL A LITTLE WAYS AWAY");

    doTest("T8",
        "(Message From Hiplink) NCSO\n" +
        "Smoke Investig\n" +
        "CASPER MOUNTAIN RD; WEST END\n" +
        "MTRD\n" +
        "C49\n" +
        "tac 6\n\n" +
        "RP REPORTING SMOKE ON THE WEST END OF THE MTN\n" +
        "RIGHT BENEATH THE DARK CLOUDS THERE APPEARS TO BE SMOKE COMING FROM THE BACK\n" +
        "SIDE OF THE MTN",

        "SRC:NCSO",
        "CALL:Smoke Investig",
        "ADDR:CASPER MOUNTAIN RD",
        "PLACE:WEST END",
        "MAP:MTRD",
        "UNIT:C49",
        "CH:tac 6",
        "INFO:RP REPORTING SMOKE ON THE WEST END OF THE MTN / RIGHT BENEATH THE DARK CLOUDS THERE APPEARS TO BE SMOKE COMING FROM THE BACK / SIDE OF THE MTN");

    doTest("T9",
        "(Message From Hiplink) NCSO\nExplosives\n1855 SOUTH LOOP AVE; Def Tech\nNCSW\nC33\nexplosives for disposal",
        "SRC:NCSO",
        "CALL:Explosives",
        "ADDR:1855 SOUTH LOOP AVE",
        "PLACE:DEF TECH",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C33",
        "INFO:explosives for disposal");

    doTest("T10",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "17800 INTERSTATE 25; MP 178\n" +
        "NCSE\n" +
        "C46\n" +
        "tac 5\n" +
        "nb lane just east of 178\n" +
        "little strip on fire\n" +
        "about 250-300 yards off the side of the road\n" +
        "its past the fence and up on a hil\n" +
        "another rp, about 300 yards north of the highway, starting",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:17800 INTERSTATE 25 MP 178",
        "CITY:NATRONA COUNTY",
        "MAP:NCSE",
        "UNIT:C46",
        "CH:tac 5",
        "INFO:nb lane just east of 178 / little strip on fire / about 250-300 yards off the side of the road / its past the fence and up on a hil / another rp, about 300 yards north of the highway, starting");

    doTest("T11",
        "(Message From Hiplink) NCSO\nExplosives\n1855 SOUTH LOOP AVE; Defense Technology\nNCSW\nC33\ncreated for C33",
        "SRC:NCSO",
        "CALL:Explosives",
        "ADDR:1855 SOUTH LOOP AVE",
        "PLACE:DEFENSE TECHNOLOGY",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C33",
        "INFO:created for C33");

    doTest("T12",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "10995 E WAGON TRAIL RD\n" +
        "NCSE\n" +
        "C63\n" +
        "****tac 5****\n\n" +
        "wildland fire\n" +
        "half the size of a car in size\n" +
        "behind this address\n" +
        "rp son is trying to put the fire out with a shovel",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:10995 E WAGON TRAIL RD",
        "CITY:NATRONA COUNTY",
        "MAP:NCSE",
        "UNIT:C63",
        "CH:tac 5",
        "INFO:wildland fire / half the size of a car in size / behind this address / rp son is trying to put the fire out with a shovel");

    doTest("T13",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "14200 W POISON SPIDER RD; POISON SPIDER;\n" +
        "NCSW\n" +
        "C12\n" +
        "CALLBACK=(307)262-5083 LAT=42.834567 LON=-106.562533 UNC=46\n" +
        "approx 2 miles north/west of poison spider school\n" +
        "the rp says the fire is about 3 acres big",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:14200 W POISON SPIDER RD",
        "PLACE:POISON SPIDER",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C12",
        "PHONE:(307)262-5083",
        "GPS:+42.834567,-106.562533",
        "INFO:approx 2 miles north/west of poison spider school / the rp says the fire is about 3 acres big");

    doTest("T14",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "W POISON SPIDER RD\n" +
        "ALRD\n" +
        "C45\n" +
        "tac 4\n\n" +
        "rp sees lots of smoke\n" +
        "silvery white smoke\n" +
        "rp is on poison spider about 3 mileswest of school and says that they see smoke\n" +
        "about 4 miles to the north of them\n" +
        "looks like west of mills ranch abou",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:W POISON SPIDER RD",
        "CITY:ALCOVA LAKE",
        "MAP:ALRD",
        "UNIT:C45",
        "CH:tac 4",
        "INFO:rp sees lots of smoke / silvery white smoke / rp is on poison spider about 3 mileswest of school and says that they see smoke / about 4 miles to the north of them / looks like west of mills ranch abou");

    doTest("T15",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "5800 S POPLAR ST\n" +
        "NCSS\n" +
        "C49\n" +
        "tac 5\n\n" +
        "zone 30 smoke\n" +
        "Leslie Chapin -- is there and can not find any problems\n" +
        "472-3177",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:5800 S POPLAR ST",
        "CITY:NATRONA COUNTY",
        "MAP:NCSS",
        "UNIT:C49",
        "CH:tac 5",
        "INFO:zone 30 smoke / Leslie Chapin -- is there and can not find any problems / 472-3177");

    doTest("T16",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "28300 W US HIGHWAY 20-26; MP 32\n" +
        "NCSW\n" +
        "C27\n" +
        "tac 4\n\n" +
        "south of this mm -- about  1mile off the road --\n" +
        "states east of the wheat fields west of where the old natrona shed used to be\n" +
        "larger than a house\n" +
        "not a lot of flames\n" +
        "unk if there",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:28300 W US HIGHWAY 20-26 MP 32",
        "MADDR:28300 W US 20-26 MP 32",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C27",
        "CH:tac 4",
        "INFO:south of this mm -- about  1mile off the road -- / states east of the wheat fields west of where the old natrona shed used to be / larger than a house / not a lot of flames / unk if there");

    doTest("T17",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "10300 THIRTY THREE MILE RD\n" +
        "NCSW\n" +
        "C62\n" +
        "**tac 4**\n\n" +
        "neighbor to the south / lightening started a fire\n" +
        "rp can see flames she is about 1/4 mile from the neighbor\n" +
        "----------------\n" +
        "NCSO briefing notified\n" +
        "----------------\n" +
        "rp says the way",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:10300 THIRTY THREE MILE RD",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C62",
        "CH:tac 4",
        "INFO:neighbor to the south / lightening started a fire / rp can see flames she is about 1/4 mile from the neighbor / ---------------- / NCSO briefing notified / ---------------- / rp says the way");

    doTest("T18",
        "(Message From Hiplink) NCSO\n" +
        "Smoke Investig\n" +
        "2571 EAST END RD\n" +
        "MTRD\n" +
        "C14\n" +
        "tac 4\n" +
        "rp says she smells smoke\n" +
        "thinks it might be a campefire at beartrap\n" +
        "cant see smoke or flames\n" +
        "just smells is\n" +
        "since about 0300",

        "SRC:NCSO",
        "CALL:Smoke Investig",
        "ADDR:2571 EAST END RD",
        "MAP:MTRD",
        "UNIT:C14",
        "CH:tac 4",
        "INFO:rp says she smells smoke / thinks it might be a campefire at beartrap / cant see smoke or flames / just smells is / since about 0300");

    doTest("T19",
        "(Message From Hiplink) NCSO\n" +
        "Smoke Investig\n" +
        "11155 W GOOSE EGG RD\n" +
        "MTRD\n" +
        "C60\n" +
        "1 mile from the goose egg inn smelling smoke add contact info 2346579",

        "SRC:NCSO",
        "CALL:Smoke Investig",
        "ADDR:11155 W GOOSE EGG RD",
        "MAP:MTRD",
        "UNIT:C60",
        "INFO:1 mile from the goose egg inn smelling smoke add contact info 2346579");

    doTest("T20",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "KORTES RD; COMMENTS\n" +
        "ALRD\n" +
        "C30\n" +
        "TOWARDS CLARKWELL RANCH -- THERE IS A LARGE WILDLAND FIRE AND CARBON CO IS REQUESTING ASSISTANCE FROM US",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:KORTES RD",
        "CITY:ALCOVA LAKE",
        "MAP:ALRD",
        "UNIT:C30",
        "INFO:TOWARDS CLARKWELL RANCH -- THERE IS A LARGE WILDLAND FIRE AND CARBON CO IS REQUESTING ASSISTANCE FROM US");

    doTest("T21",
        "(Message From Hiplink) CPD\nBomb Incident\n201 N DAVID ST;fremont county\nPD-3\nC33\ncreated per c33  assist in fremont county",
        "SRC:CPD",
        "CALL:Bomb Incident",
        "ADDR:201 N DAVID ST",
        "PLACE:FREMONT COUNTY",
        "CITY:CASPER",
        "MAP:PD-3",
        "UNIT:C33",
        "INFO:created per c33  assist in fremont county");

    doTest("T22",
        "(Message From Hiplink) CPD\n" +
        "Test Spillman\n" +
        "201 N DAVID ST; CPD\n" +
        "PD-3\n" +
        "A119\n" +
        "Page the BANKS group --- this is to be done every 1st Monday of every month per\n" +
        "the chief at 10 00hrs\n\n" +
        "--send text message that states --\n\n" +
        "This is a test, and to call 307-235-8278 to confirm recei",

        "SRC:CPD",
        "CALL:Test Spillman",
        "ADDR:201 N DAVID ST",
        "PLACE:CPD",
        "CITY:CASPER",
        "MAP:PD-3",
        "UNIT:A119",
        "INFO:Page the BANKS group --- this is to be done every 1st Monday of every month per / the chief at 10 00hrs / --send text message that states -- / This is a test, and to call 307-235-8278 to confirm recei");

    doTest("T23",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "TWELVE MILE RD & W POISON SPIDER RD\n" +
        "NCSW\n" +
        "C12\n" +
        "tac 5  near the platte river gun club\n" +
        "fire appears to be dying down a little bit\n" +
        "20-50 yards wide at this time",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:TWELVE MILE RD & W POISON SPIDER RD",  // Google can't find this
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C12",
        "CH:tac 5",
        "INFO:near the platte river gun club / fire appears to be dying down a little bit / 20-50 yards wide at this time");

    doTest("T24",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "COLE CREEK RD\n" +
        "NCSE\n" +
        "C12\n" +
        "tac 4\n\n\n" +
        "CALLBACK=(307)259-5500 LAT=42.865455 LON=-106.207924 UNC=28\n" +
        "fire in the grass at the bridge on cole creek\n" +
        "second rp, about the size of a camp trailer\n" +
        "it's really growing from the wind\n" +
        "no structure",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:COLE CREEK RD",
        "CITY:NATRONA COUNTY",
        "MAP:NCSE",
        "UNIT:C12",
        "PHONE:(307)259-5500",
        "GPS:+42.865455,-106.207924",
        "CH:tac 4",
        "INFO:fire in the grass at the bridge on cole creek / second rp, about the size of a camp trailer / it's really growing from the wind / no structure");

    doTest("T25",
        "(Message From Hiplink) NCSO\nExplosives\n515 E 13TH ST\nNCSO\nC33\nold ammo and fireworks",
        "SRC:NCSO",
        "CALL:Explosives",
        "ADDR:515 E 13TH ST",
        "CITY:NATRONA COUNTY",
        "MAP:NCSO",
        "UNIT:C33",
        "INFO:old ammo and fireworks");

    doTest("T26",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "1922 ABSAROKA TRL; heinve res\n" +
        "NCSW\n" +
        "C64\n" +
        "audiable smoke alarm / hallway / vivent is attemtping to contact respond / p210 8773203858",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:1922 ABSAROKA TRL",
        "PLACE:HEINVE RES",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C64",
        "INFO:audiable smoke alarm / hallway / vivent is attemtping to contact respond / p210 8773203858");

    doTest("T27",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "37250 STATE HIGHWAY 259;WEST OF MIDWEST\n" +
        "MWRD\n" +
        "FD1\n" +
        "tac 4\n\n" +
        "MADISON18 / RP CAN SEE SMOKE IN THE FIELD\n" +
        "CAN SEE SMOKE\n" +
        "RP CAN SEE THE SUB OFFICE AND SMOKE\n" +
        "RP IS ON CREW 6 RD / CAN SEE SMOKE / THINKS IT IS ABOUT 8  MILES EAST OF\n" +
        "MIDWES",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:37250 STATE HIGHWAY 259",
        "MADDR:37250 STATE 259",
        "PLACE:WEST OF MIDWEST",
        "CITY:MIDWEST",
        "MAP:MWRD",
        "UNIT:FD1",
        "CH:tac 4",
        "INFO:MADISON18 / RP CAN SEE SMOKE IN THE FIELD / CAN SEE SMOKE / RP CAN SEE THE SUB OFFICE AND SMOKE / RP IS ON CREW 6 RD / CAN SEE SMOKE / THINKS IT IS ABOUT 8  MILES EAST OF / MIDWES");

    doTest("T28",
        "(Message From Hiplink) CPD\nTest Spillman\n201 N DAVID ST; logging new units\nPD-3\nA245",
        "SRC:CPD",
        "CALL:Test Spillman",
        "ADDR:201 N DAVID ST",
        "PLACE:LOGGING NEW UNITS",
        "CITY:CASPER",
        "MAP:PD-3",
        "UNIT:A245");

    doTest("T29",
        "(Message From Hiplink) NCSO\nSmoke Investig\nCOLE CREEK RD\nNCSE\nC14\ntac 4\nper c14 he sees column of smoke",
        "SRC:NCSO",
        "CALL:Smoke Investig",
        "ADDR:COLE CREEK RD",
        "CITY:NATRONA COUNTY",
        "MAP:NCSE",
        "UNIT:C14",
        "CH:tac 4",
        "INFO:per c14 he sees column of smoke");

    doTest("T30",
        "(Message From Hiplink) NCSO\n" +
        "Fire assist\n" +
        "1949 N PYRITE RD; Cathedral Energy\n" +
        "NCSW\n" +
        "NCSO\n" +
        "zone 11 fire alarm\n" +
        "alarm co will call resp\n" +
        "she thinks they may be switching out batteries\n" +
        "right before they got the alarm they got a low battery\n" +
        "signal",

        "SRC:NCSO",
        "CALL:Fire assist",
        "ADDR:1949 N PYRITE RD",
        "PLACE:CATHEDRAL ENERGY",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:NCSO",
        "INFO:zone 11 fire alarm / alarm co will call resp / she thinks they may be switching out batteries / right before they got the alarm they got a low battery / signal");

    doTest("T31",
        "(Message From Hiplink) NCSO\nAlert 1-Aircraf\n8500 AIRPORT PKY; AIRPORT\nNCSW\nC56\ntac 6\n\nglider making a cross landing",
        "SRC:NCSO",
        "CALL:Alert 1-Aircraf",
        "ADDR:8500 AIRPORT PKY",
        "MADDR:8500 AIRPORT PKWY",
        "PLACE:AIRPORT",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C56",
        "CH:tac 6",
        "INFO:glider making a cross landing");

    doTest("T32",
        "(Message From Hiplink) NCSO\n" +
        "Explosives\n" +
        "2888 SIX MILE RD\n" +
        "NCSW\n" +
        "C56\n" +
        "rp found a tube with  duct tape on the ends and some kind of fertalizer in it thrown in his yard\n" +
        "rp thinks it is a pipe bomb of some kind",

        "SRC:NCSO",
        "CALL:Explosives",
        "ADDR:2888 SIX MILE RD",
        "CITY:NATRONA COUNTY",
        "MAP:NCSW",
        "UNIT:C56",
        "INFO:rp found a tube with  duct tape on the ends and some kind of fertalizer in it thrown in his yard / rp thinks it is a pipe bomb of some kind");

    doTest("T33",
        "(Message From Hiplink) CPD\n" +
        "Proj. Lifesave\n" +
        "2885 INDIAN SPRINGS DR\n" +
        "PD-6\n" +
        "A209\n" +
        "richard jackson has wandered away / was found at the mini mart last week / freq # 215945 he is in cad under Carl and he answers to Carl",

        "SRC:CPD",
        "CALL:Proj. Lifesave",
        "ADDR:2885 INDIAN SPRINGS DR",
        "CITY:CASPER",
        "MAP:PD-6",
        "UNIT:A209",
        "INFO:richard jackson has wandered away / was found at the mini mart last week / freq # 215945 he is in cad under Carl and he answers to Carl");

  }
  
  public static void main(String[] args) {
    new WYNatronaCountyParserTest().generateTests("T1");
  }
}