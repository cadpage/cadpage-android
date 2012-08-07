package net.anei.cadpage.parsers.WY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Natrona County, WY
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
(Message From Hiplink) CFD \nMedical\nE 2ND ST & S LENNOX ST\n312\nE3\nemerg bleeding male on lennox\nTAC 4
(Message From Hiplink) CFD \nMedical\n835 E 12TH ST; APT 1\n312\nE3\nEMERGENT FOR CHEST PAINS PER LE ON SCENE\nTAC 4
(Message From Hiplink) CFD \nStructure FIRE\n125 SHERWOOD CIR\n531\nE5\nCALLBACK=(307)259-6585 LAT=42.780548 LON=-105.469116 UNC=46\n\n\nmale advising grease fire in the kitchen -- rp is calling from douglas\nTAC 4
(Message From Hiplink) CFD \nMedical\n760 LANDMARK DR; g614\n531\nE5\njanice stenger is dizzy and is puking lock box\nTAC 4
(Message From Hiplink) CFD \nBreathing\n60 MAGNOLIA; sov\n672\nE6
(Message From Hiplink) CFD \nUnconsciousness\n440 E A ST; ON THE CORNER\n132\nE1\nTHERE IS A MALE BY THE TRASHCAN THAT APPEARS TO BE UNCONSCIOUS\nTAC 4
(Message From Hiplink) CFD \nSeizure\n1522 WESTRIDGE TER\n216\nE2\nCALLBACK=(911)628-2821 LAT=42.841240 LON=-106.361539 UNC=2278\n63yom having seizures
(Message From Hiplink) CFD \nMedical\n760 LANDMARK DR; turnabout\n531\nE5\ntac 4 - viking and blackmore emergent
(Message From Hiplink) CFD \nMedical\n410 S HUBER DR\n351\nE3\nrp stated a man got out of the hospital yesterday and is on the floor\nrequesting a lift assist\nrequested no ambulance, just lift assist\ndisconnected
(Message From Hiplink) CFD \nFall\n814 S DURBIN ST\n132\nE1\n85yof\nfell & hit her head
(Message From Hiplink) CFD \nChest Pain\n830 E A ST; VIRGINIAN MOTEL; room 20\n132\nE1\ntac 4 per le on scene
(Message From Hiplink) CFD \nAlarm Fire\n53 GARDENIA; Ludiker Residence\n672\nE6\nkey pad code
(Message From Hiplink) CFD \nMedical\n4006 E 12TH ST\n531\nE3\nrp's husband was supposed to go to hospital today to check his gallbladder
(Message From Hiplink) CFD \nMedical\n914 LINCOLN AVE\n312\nE3\nvery faint voice on phone
(Message From Hiplink) CFD \nMedical\n914 LINCOLN AVE\n312\nE3\nvery faint voice on phone\nasking for ambulance "to get checked out"\nnot speaking very clearly\nvoice very wheezy and threasy\nthready
(Message From Hiplink) CFD \nTraumatic Inj\n1801 E 4TH ST; AQUATICS CENTER\n351\nE3\nneda bleeding\nhead\n11 yom\ncons\nbreathing\nnot in water\nhit head on metal bar coming slide
(Message From Hiplink) CFD \nSuicide Attempt\n5529 PATHFINDER\n672\nE6\nCALLBACK=(307)251-5415 LAT=42.827840 LON=-106.400850 UNC=19\nbrother tried to hang himself\nrp cut him down\nhe is breathing\nsays that he is not responding to the rp says that he is choking
(Message From Hiplink) CFD \nChest Pain\n4134 TALON DR; apt b 307\n7629\nE6\nCALLBACK=(307)840-6946 LAT=42.815544 LON=-106.374046 UNC=19\n\n\ntac 4 female first party with chest pain\nTAC 4
(Message From Hiplink) CFD \nUnusual Odor\n2151 E 12TH ST; RENT A CENTER\n352\nE3\nper a196 requesting e3 to respond over to his location\n\nrp says that the dumpster by rent a center smells like there is something dead\nin there\nrp called metro who responded and said that th
(Message From Hiplink) CFD \nSickness\n630 E 5TH ST; apt b\n132\nE1\nmale that is not felling well states he is very sick and now it is causing\nchest pain\nTAC 6
(Message From Hiplink) CFD \nAbdominal\n1894 LILAC\n672\nE6\nMALE IS CONSCIOUS BUT NOT ALERT -- ABDOMINAL PAIN\nTAC 5
(Message From Hiplink) CFD \n911-Welfare\n1321 KINGSBURY DR\n531\nE5\nnon-emergent to stage\n\nCALLBACK=(307)277-8491 LAT=42.837689 LON=-106.281352 UNC=11\nNEIGHBOR LADY CAME OUT AND ASKED THE RP TO CALL\nTHE FEMALE THEN WENT BACK INTO HER HOUSE -- NEIGHBOR HAS NO IDEA WHAT IS
(Message From Hiplink) CFD \nFall\n931 GOODSTEIN DR\n276\nE2\nCALLBACK=(307)251-3306 LAT=42.828054 LON=-106.312680 UNC=28\nRP'S GRANDMOTHER HAS FALLEN AND HIT HER HEAD -- RP IS NOT ON SCENE\nTAC 4
(Message From Hiplink) CFD \nBreathing\n3300 RIDGECREST DR\n216\nE2\ntac 4 92yof gasping for air\n2355183\nTAC 4\nfemale is laying down gasping and growning
(Message From Hiplink) CFD \nAbdominal\n2401 GRANDVIEW PL; 18\n216\nE2\nRP FELL A FEW DAYS AGO AND NOW IS HAVING TERRIBLE PAINS IN HER SIDE\nTAC 5
(Message From Hiplink) CFD \nUnconsciousness\n41 SE WYOMING BLVD; flying j\n531\nE5\ntac 4 male that just layed down and will not wake up -- unk if he is dk
(Message From Hiplink) CFD \nMedical\n3930 DENIS DR; shell\n7629\nE6\nemerg per le on scene male w head injury\nTAC 4
(Message From Hiplink) CFD \nChest Pain\n1216 S BOXELDER ST\n123\nE1\nCALLBACK=(307)251-3573 LAT=42.838150 LON=-106.338494 UNC=19\nCHEST PAIN\nTAC 5
(Message From Hiplink) CFD \nAlarm Fire\n4445 S POPLAR ST; CREST HILL SCHOOL\n216\nE2\ntac 4  general fire alarm
(Message From Hiplink) CFD \nService Call\n1930 E 12TH ST; PARK PLACE; Apt 212\n352\nE3\nassistance required by wmc for overweight  female
(Message From Hiplink) CFD \nAlarm Medical\n300 E COLLINS DR; apt 508\n132\nE1\ntac 4   female yelling for help
(Message From Hiplink) CFD \nBreathing\n1137 S CHESTNUT ST\n123\nE2\ntac 6\n\n73 yo female / breathing diff\nhad pulmonary embolism in her lung last week\nhas chest pain as well\nfront door is unlocked
(Message From Hiplink) CFD \nSeizure\n1845 W 29TH ST\n216\nE2
(Message From Hiplink) CFD \nMedical\n315 E 15TH ST; YMCA\n213\nE2\nCALLBACK=(307)462-1230 LAT=42.845532 LON=-106.312444 UNC=16
(Message From Hiplink) NCF \nMedical\n60 E MANLY RD; west station\n1472\nSQ7\nClarence Vandenheed has an altered mental state\nconfused, not responding appropriately\nvitals,
(Message From Hiplink) CFD \nGas Leak\n4340 S ASH ST\n216\nE2\nrp is working outside and they hit the gas meter\nhit with a "little machine"
(Message From Hiplink) CFD \nGas Leak\n4340 S ASH ST\n216\nE2\n**** tac 5 ****\n\nrp is working outside and they hit the gas meter\nhit with a "little machine"\nrp is hard to understand\nbobcat\nkind of a bobcat type machine\nrp is on a work crew
(Message From Hiplink) CFD \nBreathing\n1202 W 11TH ST\n123\nE1\ntac 4 female having trouble breathing
(Message From Hiplink) CFD \nDiabetic Shock\n1848 FREMONT AVE\n7621\nE6
(Message From Hiplink) CFD \nDiabetic Shock\n1848 FREMONT AVE\n7621\nE6\ntac 5\n\nrp's sister is diabetic\nshe passed out on the floor\nunconscious
(Message From Hiplink) CFD \nFireworks\n1 EVENTS DR; EVENTS CENTER\n123\nF1\nevent 12 tac 8 and tac 9 e3 f1 br2
(Message From Hiplink) CFD \nMedical\n1045 BEAUMONT DR\n216\nE2\nrp has MS and is having an exacerbation\nhe is VERY weak\n77yom
(Message From Hiplink) CFD \nUnconsciousness\n1023 E 2ND ST; DEPEND A PAWN\n312\nE1\nCALLBACK=(307)315-2134 LAT=42.848321 LON=-106.312015 UNC=46
(Message From Hiplink) CFD \nFall\n2502 NANPAP RD\n123\nE1\nCALLBACK=(307)259-8453 LAT=42.881763 LON=-106.335320 UNC=71\nbaby fell off of a tailgate\nis 7 months old
(Message From Hiplink) CFD \nFall\n2502 NANPAP RD\n123\nE1\ntac 4\n\nCALLBACK=(307)259-8453 LAT=42.881763 LON=-106.335320 UNC=71\nbaby fell off of a tailgate\nis 7 months old\nbaby is making a funny noise\nrp states he has a "flat" cry\nunknown when it occurred he was "informed"
(Message From Hiplink) CFD \nFireworks\n1 EVENTS DR; EVENTS CENTER\n123\nF1\nevent 12 tac 8 and tac 9 e3 f1 br2\ncreated per f1
(Message From Hiplink) CFD \nFall\n53 GARDENIA\n672\nE6\nFEMALE WAS LAYING ON THE GROUND
(Message From Hiplink) CFD \nAccident PI\nE 2ND ST & S MCKINLEY ST\n312\nE3\ntac 4 2 veh accidnet unk inj\nthis rp is inolved
(Message From Hiplink) CFD \nAccident PI\nE 2ND ST & S MCKINLEY ST\n312\nE3\ntac 4 2 veh accidnet unk inj\nthis rp is inolved\nwas going through a yellow flashing and the other person went anyway\nneg inj in this vehicle\nneg air bag
(Message From Hiplink) CFD \nFall\n440 E A ST; Royal Inn\n132\nE1
(Message From Hiplink) CFD \nMedical\n1609 S CONWELL ST\n352\nE3\ntac 4 female with unk problem she is breathing
(Message From Hiplink) CFD \nAlarm Fire\n4305 S POPLAR ST; POPLAR LIVING CENTER\n216\nE2
(Message From Hiplink) CFD \nFall\n3331 OX CART CT\n672\nE6\n74 yao male
(Message From Hiplink) CFD \nSeizure\n1742 LISCO DR; LOFTIN LIFE SCIENCES\n213\nE2
(Message From Hiplink) CFD \nAlarm Fire\n140 W 9TH ST; PARK ELEMENTARY\n123\nE1\ngeneral fire alarm
(Message From Hiplink) CFD \nSeizure\n572 WESTSHORE RD\n123\nE1\ntac 4\nrp states her fiance is drunk again and is going to have a seizure
(Message From Hiplink) CFD \nDiabetic Shock\nS POPLAR ST & W COLLINS DR\n123\nE1\nTAC 4 / non emergent per leo on scene
(Message From Hiplink) CFD \nService Call\n3400 E 12TH ST; KELLY WALSH POOL\n531\nE5\nNo one is in the water, lighting hit the building and caused a power\ninteruption
(Message From Hiplink) CFD \nAccident PI\nS ELM ST & W 12TH ST\n123\nE1\nCALLBACK=(307)315-4449 LAT=42.837646 LON=-106.329117 UNC=21\n2 vehicle accident\ntraffic blockage
(Message From Hiplink) CFD \nUnconsciousness\n79 MAGNOLIA\n672\nE6
(Message From Hiplink) CFD \nAccident PI\nKING BLVD & S POPLAR ST\n123\nE1
(Message From Hiplink) CFD \nMedical\nE 2ND ST & S WASHINGTON ST\n312\nE3\nNON EMERGENT PER LE ON SCENE / C/O NECK PAIN
(Message From Hiplink) CFD \nFall\n1930 E 12TH ST; rm #212\n352\nE5\nstates there is a resident that fell and needs help getting up\nnot aware of any injury, just needs lift assist
(Message From Hiplink) CFD \nService Call\nE 2ND ST & S WASHINGTON ST\n312\nE3\na lot of oil on the ground
(Message From Hiplink) CFD \nUnconsciousness\n1930 E 12TH ST\n352\nE3\nunconscious female\nnot breathing\nthere is a pulse
(Message From Hiplink) CFD \nUnconsciousness\n1930 E 12TH ST\n352\nE3\n****tac 5****\n\nunconscious female\nnot breathing\nthere is a pulse\nnurses are starting CPR\nher name is Deryce Clapp\n75yof\nin dining room\nTHIS IS A NURSING HOME THEY DO NOT NEED LAW RESPONSE\nparkinsons, cv
(Message From Hiplink) CFD \nMedical\n1122 S CEDAR ST\n123\nE1
(Message From Hiplink) CFD \nMedical\n570 S WALSH DR\n531\nE5\nrp rec'd a medical alarm from the female, believes she has fallen\nborn in 1952, rp can barely hear her on the medical phone
(Message From Hiplink) CFD \nMedical\n266 HONEYSUCKLE\n672\nE6
(Message From Hiplink) CFD \nFall\n1130 E F ST\n132\nE1
(Message From Hiplink) CFD \nMedical\nCY AVE & BOXELDER AVE\n216\nE2\nELDERLY MALE POSSIBLY HEART ATTACK OR STROKE
(Message From Hiplink) CFD \nMedical\n1455 S MCKINLEY ST\n352\nE3
(Message From Hiplink) CFD \nBreathing\n4900 E 2ND ST; HOME DEPOT\n531\nE5\nat home depot at the service desk
(Message From Hiplink) CFD \nTest Spillman\n270 VALLEY DR; STATION 6\n672\nE6\nTEST PER STATION 6
(Message From Hiplink) CFD \nSuicide Attempt\n103 JONQUIL\n672\nE6
(Message From Hiplink) CFD \nSuicide Attempt\n103 JONQUIL\n672\nE6\n80ish yo male shot himself\nunk where\nis breathing\nANOTHER RP / IS OUTSIDE IN THE GARAGE / HELPING UNPACK BOXES\nWIFE IS STILL INSIDE WITH THE MALE
(Message From Hiplink) CFD \nService Call\n3408 APPLEGATE DR\n672\nE6\nbehind the rp's house in a field there is a pile of wood\nthat has been doust in gasoline
(Message From Hiplink) CFD \nUnconsciousness\n2050 S BEVERLY ST\n352\nE3\n32 yo female collapsed\nis breathing\nnot awake
(Message From Hiplink) CFD \nSeizure\n245 COLUMBINE\n672\nE6\n**tac 5** early 40's female keeps having seizures
(Message From Hiplink) CFD \nMedical\n2655 COULTER DR\n7621\nE6\nelbow and shoulder pain for female le is on
(Message From Hiplink) CFD \nMedical\n20 SE WYOMING BLVD; 29 1st Interstate\n531\nE5\nCALLBACK=(307)251-9124 LAT=42.852559 LON=-106.272490 UNC=21\nstarted 20 min ago\nshaking and feeling weird
(Message From Hiplink) CFD \nMedical\n340 S MCKINLEY ST\n312\nE3\n**tac 4** 43 yom with severe pain in his shoulder\nin front of the building\nrp now saying the male dislocated his shoulder when he was going to sleep\nmale is complaining of sweating and feeling like he is goi
(Message From Hiplink) CFD \nMedical\nHERRINGTON DR & VILLAGE DR\n672\nE6
(Message From Hiplink) CFD \nMedical\n554 GRANT AVE\n312\nE3
(Message From Hiplink) CFD \nMedical\n1081 S FOREST DR\n531\nE5
(Message From Hiplink) CFD \nMedical\n935 S CEDAR ST\n123\nE1
(Message From Hiplink) CFD \nAlarm Medical\n825 ST JOHN ST; 1/2\n132\nE1
(Message From Hiplink) CFD \nService Call\n532 S JACKSON ST\n312\nE3\nPER E3
(Message From Hiplink) CFD \nMedical\n4400 E 2ND ST; WALMART\n531\nE5
(Message From Hiplink) CFD \nChest Pain\n1440 WILKINS CIR; Counseling Center\n123\nE1\nTAC 4\nin the back by the substance abuse section
(Message From Hiplink) CFD \nFall\n4400 E 2ND ST; WALMART\n531\nE5
(Message From Hiplink) CFD \nAlarm Medical\n2955 CENTRAL DR; Apt 105\n7629\nE6\nTAC 4 - medical panic alarm
(Message From Hiplink) CFD \nFall\n2731 CHEROKEE LN\n672\nE6
(Message From Hiplink) CFD \nUnconsciousness\n2401 GRANDVIEW PL; 19\n216\nE2
(Message From Hiplink) CFD \nAccident PI\nCY AVE & S ROBERTSON RD\n672\nE6\nmale in truck is complaining of head pain and memory loss
(Message From Hiplink) CFD \nMedical\n3625 WHISPERING SPRINGS RD\n672\nE6
(Message From Hiplink) CFD \nFall\n2000 FAIRGROUNDS RD; Fairgrounds Center\n7629\nE6\n93yof fell out of wheelchair, emerg per le, in C spine at this time
(Message From Hiplink) CFD \nMedical\n1250 N CENTER ST; 43\n132\nE1
(Message From Hiplink) CFD \nUnusual Odor\n954 S WASHINGTON ST\n312\nE3
(Message From Hiplink) CFD \nSeizure\n4400 E 2ND ST; WALMART\n531\nE5
(Message From Hiplink) CFD \nMedical\n1380 IVY LN\n531\nE5
(Message From Hiplink) CFD \nMedical\n19 VALLEY DR\n672\nE6\nNON EMERGENT per le on scene for female who hit head during accident
(Message From Hiplink) CFD \nStroke\n114 N MONTANA AVE\n351\nE3
(Message From Hiplink) CFD \nMedical\n77 GARDENIA\n672\nE6
(Message From Hiplink) CFD \nDiabetic Shock\n4340 S CENTER ST\n216\nE2\ntac 4
(Message From Hiplink) CFD \nSeizure\n1705 E 2ND ST; JOHNNY J'S\n312\nE3\ntac 4\nmale just collasped on the floor and is shaking\nsays that he walked up to the truck and collasped\nright in front of the restaurant\non the corner by a white chevy truck\nis on his side\nis breathi
(Message From Hiplink) CFD \nSeizure\n450 S WOLCOTT ST; poverty resistance\n132\nE1\nfront part of the store\nin his 40's
(Message From Hiplink) CFD \nBreathing\n1745 W COFFMAN AVE\n216\nE2\ntac 5
(Message From Hiplink) CFD \nFall\n2101 E 12TH ST; Dollar Tree\n352\nE3\ntac 6
(Message From Hiplink) CFD \nTraumatic Inj\n111 N FOREST DR; lot 18\n531\nE5
(Message From Hiplink) NCF \nDrowning\n2800 SW WYOMING BLVD; MORAD PARK\n7629\nSQ7\nCALLBACK=(307)258-0701 LAT=42.823935 LON=-106.371152 UNC=25\nright at the dock\nrp is at the dock\nsays that there is someone shouting from the river -- saw them go by and\nsomeone was yelling
(Message From Hiplink) CFD \nFall\n1410 S PENNSYLVANIA AVE; 5\n352\nE3\ntac 5\n68YOF FELL HIT HER HEAD\nNEG BLEEDING
(Message From Hiplink) CFD \nAccident PI\nCY AVE & W 12TH ST\n123\nE1\ntac 5  mc accident
(Message From Hiplink) CFD \nFall\n30 DAHLIA\n672\nE6\ntac 4 - elderly female fell
(Message From Hiplink) CFD \nMedical\n7515 W YELLOWSTONE HWY; Horseshoe Bar\n7911\nE1\nFEMALE AT THE BAR THAT IS NOT ABLE TO STAND UP -- HAS HAD TOO MUCH TO DRINK -- IS NOT ABLE TO STAND -- REFUSING FOOD AND WATER\n29ISH YOF\nSHE IS VERY INTOXICATED -- SHE HAS THROWN UP A CO
(Message From Hiplink) CFD \nUnusual Odor\nE 21ST ST & S MISSOURI AVE\n352\nE3\ntac 4 - smell, possibly natural gas at this intersection
(Message From Hiplink) CFD \nSuicide Attempt\n1005 N ELMA ST; apt 214\n132\nE1\ntac 4 - female
(Message From Hiplink) CFD \nService Call\n1514 E 12TH ST; Life Steps;building d\n352\nE3\ntac 5\n\nRp states the fire alarm goes of for like 2 minutes and then shuts off -- this\nhas been occurring for the last 2 hours\nThere is a female on site -- Stephanie\nrp is not onscene
(Message From Hiplink) CFD \nAccident PI\nBLACKMORE RD & SE WYOMING BLVD\n531\nE5\nCALLBACK=(307)258-1140 LAT=42.840897 LON=-106.265430 UNC=16\nairbag deployment\nsaying no injuries\nhonda accord vs pont grand am
(Message From Hiplink) CFD \nSeizure\n300 W F ST; RAMADA INN\n123\nE1\nCALLBACK=(303)263-7006 LAT=42.859812 LON=-106.328259 UNC=25\ntac 4\nCALLBACK=(303)263-7006 LAT=42.859812 LON=-106.328259 UNC=25
(Message From Hiplink) EVF \nAccident PI\n223 WILLIAMS ST\n12135\nR12\ncall to station 5 from Life Alert
(Message From Hiplink) CFD \nFall\n154 N BEECH ST; apt 207\n132\nE1
(Message From Hiplink) CFD \nFall\n3955 E 12TH ST; meadow wind assisted\n531\nE5\nin the dining room\nmale, 70's, fell from his chair\nhaving a hard time breathing\nno bleeding\nhe is with CNA's
(Message From Hiplink) CFD \nAlarm Fire\n6301 E 2ND ST; GMC dealer\n513\nE5\nCALLBACK=(307)267-7970 LAT=42.830071 LON=-106.313131 UNC=14\nzone 1, no description\nalarm co is contacting resp
(Message From Hiplink) CFD \nPower Line Down\n933 N WASHINGTON ST; in alley\n132\nE1\nthere is a power pole with an arm broken and the lines are about to fall down\nthere are children that play in the yards and the rp is worried it will fall\nand hurt someone
(Message From Hiplink) CFD \nSeizure\nW 15TH ST & S POPLAR ST\n216\nE2\nCALLBACK=(307)262-1854 LAT=42.835554 LON=-106.337206 UNC=14\nmale having a seizure behind the albertsons gas station\nabout late 30's
(Message From Hiplink) CFD \nSmoke Investig\n232 W 1ST ST; SEASONS DAY SPA\n123\nE1\nrp is at modern electric\nsays with last lightning strike there was a cloud of smoke that went over the\nseasons day spa\nwas loking out windows and saw a bright flash and puff of smoke on ba
(Message From Hiplink) CFD \nAlarm Medical\n760 LANDMARK DR; apt g614\n531\nE5\ntac 4 female having major stomach pain\n54yof
(Message From Hiplink) CFD \nMedical\n3955 E 12TH ST; MEADOW WIND\n531\nE5\nFEMALE IN RM 320 -- 71 YOF HAVING DIFFICULTY FORMING WORDS
(Message From Hiplink) CFD \nDiabetic Shock\n1451 MISSOURI AVE; apt 5 c\n352\nE3\ntac 5 - male
(Message From Hiplink) CFD \nChest Pain\n1601 KING BLVD; Three Crowns\n123\nE1\ntac 4\n\nCALLBACK=(307)277-4751 LAT=42.842873 LON=-106.350121 UNC=21\n\n\nat the number 10 tee box\njust a little west of the club house\nfemale will be waiting at the club house to help guide them\n53
(Message From Hiplink) CFD \nUnconsciousness\nE A ST & N ELK ST\n312\nE3\nCALLBACK=(307)258-3763 LAT=42.852657 LON=-106.302208 UNC=14
(Message From Hiplink) CFD \nFall\n2521 E 15TH ST; wbi adult unit\n352\nE3\nfemale fell and is having some issues from the fall\nshe is cons and breathing\nrp states she is having weird eye movement
(Message From Hiplink) NCF \nBreathing\n2000 FAIRGROUNDS RD; Fairgrounds Center\n7629\nSQ7\ntac 4 - back lot at bunkhouses\nnear gate b\nbeside the coliseum, where the petting zoo\nsaid he can't breath\nchest pain\n43yom\nsomeone will be waiting at the west gate\nmostly alert
(Message From Hiplink) CFD \nBreathing\n1804 AMHERST AVE\n352\nE3\ntac 4 - female
(Message From Hiplink) CFD \nHemorrhage\n224 N JEFFERSON ST\n132\nE1\ntac 4 - ear bleeding
(Message From Hiplink) CFD \nBreathing\n1137 S CHESTNUT ST\n123\nE1\ntac 4 first party female having dif breathing\n4723014\nrp is not home alone
(Message From Hiplink) CFD \nMedical\nE A ST & N WILSON ST\n312\nE3\nfemale complaing of rib pain per a131
(Message From Hiplink) CFD \nService Call\n1930 E 12TH ST; PARK PLACE; room 103\n352\nE3\nmary heinerman needs a lift assist
(Message From Hiplink) CFD \nMedical\nFARNUM ST & S WASHINGTON ST\n352\nE3\nMEDICAL NON EMERG PER LE ON SCENE FOR A MALE THAT ISN'T WAKING UP -- POSSIBLY TOOK SOME MUSCLE RELAXERS AND ALCOHOL
(Message From Hiplink) CFD \nMedical\n320 INDIAN PAINTBRUSH\n672\nE6\ntac 4  bi polar male suffering from depression has not been taking care of himself and would like to be taken to the wmc
(Message From Hiplink) CFD \nAccident PI\nE 12TH ST & S WOLCOTT ST; cmnts\n132\nE1\ntac 4\n\njust east of the intersection\nneg injuries, but rp has 2 kids she would like medical just in case\nmar dodge durango vs sil honda crv\nTRAFFIC BLOCKAGE
(Message From Hiplink) CFD \nStructure FIRE\nBURLINGTON AVE & N BEVERLY ST\n132\nE1\ntac 5
(Message From Hiplink) CFD \nAbdominal\n1021 S WISCONSIN AVE ;4\n351\nE3\n56 yof\ncons\nbreathing
(Message From Hiplink) CFD \nFall\n211 E 6TH ST; apt 809\n132\nE1\ntac 5   female fell in bathtub
(Message From Hiplink) CFD \nMedical\n733 E 13TH ST\n352\nE3\nrp's sister is so weak she can't walk\n96yof\ncorrection, 93yof
(Message From Hiplink) CFD \nCardiac Problem\n419 S WASHINGTON ST; Sage Primary Care\n312\nE1\nDr. Lloyd's office in McMurry center\nhaving trouble breathing also\n85yof\ncons\nbreathing\nlot of difficulty\ndr and nurses are with her\nunk heart hx\nCall type f reopened by Jackson,
(Message From Hiplink) NCF \nTraumatic Inj\n2800 SW WYOMING BLVD; MORAD PARK\n7629\nSQ7\nCALLBACK=(307)277-2540 LAT=42.821478 LON=-106.374264 UNC=57\nback pain\nbicycle accident\nlower back pain\ndogs ran out in front of pt\nneg bleeding\ncons\nbreathing
(Message From Hiplink) CFD \nFall\n2225 E 5TH ST\n351\nE3\nLift assist\nrp's husband has MS and his legs gave out
(Message From Hiplink) NCF \nChest Pain\n1020 EAST END RD; ste 200\n1475\nSQ7\n73 yom\ncons\nbreathing\ndr is with him\nhas pacemaker and defibrillator\npacemaker hasnt activated
(Message From Hiplink) CFD \nMedical\n201 N DAVID ST\n123\nE1\ninvestigations -- male is over heating and vomitting\nCall type f reopened by Jackson, Lori at 11 43 44 07/10/2012
(Message From Hiplink) CFD \nAccident PI\nSW WYOMING BLVD & S POPLAR ST\n276\nE2\nCALLBACK=(307)315-1858 LAT=42.806017 LON=-106.344845 UNC=36\naccident w/inj\n2 vehicle\nknocked out power to stop light\nmar suv and 4 dr sedan\ncorr pu and 4 dr sedan\nred truck vs red car\nthis rp
(Message From Hiplink) CFD \nAccident PI\nW 1ST ST & N POPLAR ST\n123\nE1\nCALLBACK=(307)258-4952 LAT=42.845510 LON=-106.352570 UNC=14\nKimberly Wilkinson witness, people are hit and horses are hit\nhorse trailer down\ndoesn't know what hit them\njust saw wagons go flying\nKimb
(Message From Hiplink) CFD \nAlarm Fire\n4260 HOSPITALITY LN; courtyard marriott\n531\nE5\naudible fire alarm -- general
(Message From Hiplink) CFD \nAccident PI\nW 1ST ST & N POPLAR ST\n123\nE1\ntac 6\n\nCALLBACK=(307)258-4952 LAT=42.845510 LON=-106.352570 UNC=14\nKimberly Wilkinson witness, people are hit and horses are hit\nhorse trailer down\ndoesn't know what hit them\njust saw wagons go flyi
(Message From Hiplink) CFD \nAbdominal\n2000 W 38TH ST\n216\nE2\nCALLBACK=(307)259-0368 LAT=42.812669 LON=-106.348708 UNC=19\na woman beside her car with severe abdominal and back pain
(Message From Hiplink) CFD \nUnconsciousness\nN ASH ST & W A ST\n123\nE1\ntac 5 male in the street
(Message From Hiplink) CFD \nGas Leak\n972 CORNWALL\n531\nE5\nCALLBACK=(307)277-4466 LAT=42.838923 LON=-106.254637 UNC=46\nback hoe was digging and hit a main gas line\nrp said everybody was out of the are "for the most part"\nsaid he had to call someone who was going to head
(Message From Hiplink) CFD \nFall\n612 PARK AVE; cmmts\n312\nE3\nin the alley off of kirk\nsays that he slipped down to the ground\nweighs about 200 lbs\nand they can't get him up\nnot injured\nhas been on the ground for about 5 min
(Message From Hiplink) CFD \nFall\n3331 OX CART CT\n672\nE6\ntac 4 - male fell, not injured
(Message From Hiplink) CFD \nAccident PI\nE 2ND ST & THELMA DR\n531\nE5\nCALLBACK=(620)344-0668 LAT=42.848718 LON=-106.274679 UNC=28\nMC VS PC
(Message From Hiplink) CFD \nMedical\n1309 W 12TH ST\n123\nE1\nNON EMERGENT FOR PERSON THAT FELL OFF A PORCH
(Message From Hiplink) CFD \nDiabetic Shock\n1451 MISSOURI AVE; apt 5 c\n352\nE3\ntac 4- combative diabetic
(Message From Hiplink) CFD \nAbdominal\n611 LIND AVE; apt 204\n312\nE3\ntac 4 - female w severe diahrea\nRP'S MOTHER IS NOT ALERT -- JUST GOT OUT OF THE HOSPITAL YESTERDAY -- SHE IS NOT\nRESPONDING -- SHE IS IN THE BATHROOM\nSHE IS BARELY CONSCIOUS -- SHE IS 59 YOF\nSHE IS NOT
(Message From Hiplink) CFD \nAlarm Medical\n1035 N WASHINGTON ST\n132\nE1\ntac 6 - no response on alarm
(Message From Hiplink) CFD \nMedical\n1220 KINGSBURY DR\n531\nE5\nper a190 non emergent
(Message From Hiplink) CFD \nMedical\n4149 COUNTRY CLUB RD; casper country clu\n5137\nE5\ntac 4 non emergent per law to check on a few that were involved in a foot\npursuit\nTAC 4
(Message From Hiplink) CFD \nMedical\n2014 LARAMIE AVE\n7621\nE6\ntac 4 -
(Message From Hiplink) CFD \nAccident PI\nS POPLAR ST & KING BLVD\n123\nE1\nTAC 4 - 2 vehs vs SEMI
(Message From Hiplink) CFD \nSickness\n1125 N WOLCOTT ST; #5\n132\nE3\nTAC 4\n\nrp's roommate's son is really sick and needs an ambulance\nhe has lost 27 lbs, turning yellow, will not go to dr.\n64yom\nnow saying they are at 1145 N wolcott
(Message From Hiplink) CFD \nChest Pain\n190 ASTER\n672\nE6\n*TAC 4* 90 yo female w/ chest and back pain
(Message From Hiplink) CFD \nAbdominal\n4140 S POPLAR ST; va clinic\n216\nE2\npt fell struck his ribcage on the right has abdominal pain has had a BM in over a month hyper active bowel sounds --vital signs are stable\nis with a dr
(Message From Hiplink) CFD \nFall\n111 W MIDWEST AVE; slumberland\n123\nE1\ntac 4   male fell onto sidewalk
(Message From Hiplink) CFD \nDead Body\n1005 N ELMA ST; apt #111\n132\nE1\n*****TAC 4\nrp states her mother is dead\nshe is freezing cold\nnot breathing\nmother is 75yoa\nCarol Christy\nrp has not been able to reach her today\nrp went to the apt. and the landlord let her in\nrp's
(Message From Hiplink) CFD \nSmoke Investig\nCOLE CREEK RD & E SANDPIPER ST\n1312\nE5\nE5 INVESTIGATE PER FD1\nhave another rp who is on appian lane who can see smoke\ncan not see fire just smoke\nSERVERAL CALLS / STATE TO THE SOUTH OF / NEAR SANDPIPER AND COLE CREEK
(Message From Hiplink) CFD \nLockout\n3552 E 22ND ST\n531\nE5\nCALLBACK=(307)797-2137 LAT=42.828217 LON=-106.278969 UNC=16\ntac 6 -4yo locked in veh
(Message From Hiplink) CFD \nMedical\n1631 CAMPUS DR; krampert theatre\n213\nE2\ntac 6 - female collapsed, unknown further, 3rd party
(Message From Hiplink) CFD \nDiabetic Shock\n1440 WILKINS CIR; cwcc\n123\nE1\ntac 6 -
(Message From Hiplink) CFD \nMedical\n1326 OAKCREST AVE\n352\nE3\ntac 4- male very dk, advising he doesn't feel welll\n\nCALLBACK=(307)258-7633 LAT=42.836970 LON=-106.318259 UNC=16
(Message From Hiplink) CFD \nService Call\n148 COLUMBINE\n672\nE6\nnowcap residence unusual odor engine 6 self dispatched created per e6
(Message From Hiplink) CFD \nMedical\n1120 N DURBIN ST\n132\nE1\nRP SAYS GRANDMOTHER IS PARANOID AND CAN NOT MAKE IT OUT THE DOOR
(Message From Hiplink) CFD \nMedical\n1700 W 25TH ST ;apt 19d\n216\nE2\ntac 4'
(Message From Hiplink) CFD \nFall\n1705 E 2ND ST; JOHNNY J'S\n312\nE3\na woman tripped on the curb\nno bleeding\nfell on her hip and is hurting\nrequesting non-emergent
(Message From Hiplink) CFD \nMedical\n300 E COLLINS DR\n132\nE1\nAPT 1101\nthere is a lady that is dizzy and has a headache\n86yof\nSkyline apartments\nis awake and breathing normally\nthis has happened before\nvision is blurry\nstarted yesterday\nfront door is unlocked
(Message From Hiplink) CFD \nMedical\n2263 W 42ND ST\n216\nE2
(Message From Hiplink) CFD \nGas Leak\n1634 BELLAIRE DR\n216\nE2\nsmells like gas outside her house
(Message From Hiplink) CFD \nUnconsciousness\n1304 S LAUREL ST\n216\nE2\n****TAC 4***** NOT BREATHING
(Message From Hiplink) CFD \nMisc. FIRE\n623 S WOLCOTT ST\n132\nF1\nCALLBACK=(307)262-6591 LAT=42.844234 LON=-106.323216 UNC=21\nflat bed trailer with trash on it on fire\nbest access 7th & wolcott\noff duty fire fighter on site\nWOLCOT BEST SPOT TO COME IN / EVERYTHIGN LEFT B
(Message From Hiplink) CFD \nGas Leak\n596 N POPLAR ST; BURGER KING\n123\nE1\nRP did not stay on line and advise how much gas is leaking frm gas line to\ngenerator
(Message From Hiplink) NCF \nAlarm Fire\n5800 S POPLAR ST\n762\nE7\ntac 5\n\nzone 30 smoke\nLeslie Chapin -- is there and can not find any problems\n472-3177\nno rp\ngetting an additional fire alarm
(Message From Hiplink) CFD \nWildland FIRE\n1654 SYCAMORE ST\n216\nBR2
(Message From Hiplink) CFD \nStabbing\n1200 BOULDER DR; apt 37a\n216\nE2\nmale stabbed in neck\nis walking to the mini mart\njames wilkins is the suspect\nrp was stabbed in the neck\njames is in still in the rps apt\njames kicked in the rps door
(Message From Hiplink) CFD \nMedical\n1951 BRENTWOOD DR\n216\nE2
(Message From Hiplink) CFD \nFall\n4041 S POPLAR ST; LCCC\n216\nE2\nPOSSIBLE HIP FRACTURE FROM FALL -- RESPOND TO DOOR 2 -- TAC 4
(Message From Hiplink) CFD \nMedical\n4140 S POPLAR ST\n216\nE2\npt with generalized weakness, hard to walk
(Message From Hiplink) CFD \nMedical\n4400 SE WYOMING BLVD\n216\nE2\nspiting up blood requests ambulance
(Message From Hiplink) CFD \nSmoke Investig\nS POPLAR ST & SW WYOMING BLVD\n216\nE2\nrp sees and smells smoke around the area of outer drive and poplar
(Message From Hiplink) CFD \nAlarm Medical\n2600 S POPLAR ST\n216\nE2\ntac 4  86 yo male with chest pains and breathing
(Message From Hiplink) CFD \nGas Leak\n204 W 15TH ST\n213\nE2\nhit a gas line with a nail\ncan hear hissing
(Message From Hiplink) NCF \nFall\n2600 FLEETWOOD PL; 111\n7621\nSQ7\n**tac 4** 75 yof fell and needs help getting back up / non emergent per rp, female just needs help up
(Message From Hiplink) CFD \nAlarm Medical\n2030 W 44TH ST; Spencer Hedges residence\n216\nE2\nalarm co has rcvd 7 hits from this alarm\nno answer at residence
(Message From Hiplink) CFD \nCardiac Problem\n4140 S POPLAR ST; va clinic\n216\nE2\n***tac 4*** 66 yof possilby having and MI
(Message From Hiplink) CFD \nStroke\n4305 S POPLAR ST; POPLAR LIVING CENTER\n216\nE2\n***Tac4*** 91 female cva 607b
(Message From Hiplink) CFD \nAccident PI\nS POPLAR ST & BOULDER DR\n216\nE2\nneg inj\nsome road blockage\nwhite elantra vs mc
(Message From Hiplink) CFD \nSeizure\n1522 WESTRIDGE TER\n216\nE2\nCALLBACK=(504)609-1730 LAT=42.841240 LON=-106.361539 UNC=2278
(Message From Hiplink) CFD \nAbdominal\n1912 BOXELDER AVE\n216\nE2
(Message From Hiplink) CFD \nChest Pain\n2130 W 41ST ST\n216\nE2
(Message From Hiplink) CFD \nMedical\n2401 GRANDVIEW PL; apt 22\n216\nE2
(Message From Hiplink) CFD \nBreathing\n548 WESTSHORE RD\n123\nE1\ntac 4\nthird party caller\ntold rp that by the time she got there he would be dead\n80 something yo male
(Message From Hiplink) CFD \nFall\n2325 CRESCENT AVE\n216\nE2\ntac 4
(Message From Hiplink) CFD \nMedical\n3300 RIDGECREST DR\n216\nE2\ntac 4    92 yo female very high fever and dehydrated
(Message From Hiplink) NCF \nAccident PI\nCASPER MOUNTAIN RD; past lookout poin\n1472\nSQ7\ntac 7\n\nmc went off road blleding badly 2 vic\npast the outlook going up the mountian\nmale and female\nboth bleeding out of the head\n6 feet off the road\nboth conc and breathing\nWHP NOT
(Message From Hiplink) CFD \nAlarm Fire\n930 S ELM ST; NCHS\n123\nE2\ngeneral fire alarm
(Message From Hiplink) CFD \nMedical\n1717 S CHESTNUT ST\n213\nE2
(Message From Hiplink) CFD \nAlarm Medical\n1449 W 29TH ST; Tibbit Res\n216\nE2\n80 yo male Fell came from life alert
(Message From Hiplink) CFD \nFall\n1081 N POPLAR ST; mike lansing\n123\nE2\nCALLBACK=(307)277-3506 LAT=42.860027 LON=-106.330360 UNC=21\n\n\nelderly male that fell and hurt his leg\nTAC 6\nbest access is through the back gate off katie ln and F st
(Message From Hiplink) CFD \nSeizure\nCASPER MOUNTAIN RD & SE WYOMING BLVD\n216\nE2\nCALLBACK=(817)564-1952 LAT=42.796650 LON=-106.339355 UNC=1881
(Message From Hiplink) CFD \nMedical\n125 COLLEGE DR; CASPER C; student center\n213\nE2
(Message From Hiplink) CFD \nMedical\n2130 W 41ST ST\n216\nE2\ntac 4\n\nnon emergent per law to check on an elderly female
(Message From Hiplink) CFD \nWildland FIRE\n1886 STATION RD\n315\nE3\ntac 4

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
public class WYNatronaCountyParser extends FieldProgramParser {
  
  public WYNatronaCountyParser() {
    super("NATRONA COUNTY", "WY",
           "SRC CALL ADDR MAP UNIT INFO+");
  }
  
  @Override
  public String getFilter() {
    return "csphiplink@cityofcasperwy.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Message From Hiplink")) return false;
    return parseFields(body.split("\n"), 4, data);
  }
  
  private static final Pattern ADDR_EXT_PTN = Pattern.compile("(?:APT|LOT|SUITE|STE|ROOM|RM|#)[ #]*(.*)|(\\d+[A-Z]?)|(M[MP] .*|[NSEW]B)");
  private static final Pattern COMMENTS_PTN = Pattern.compile("CMNTS|COMMENTS", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String[] flds = field.split(";");
      parseAddress(flds[0], data);
      for (int ndx = 1; ndx < flds.length; ndx++) {
        String fld = flds[ndx].trim().toUpperCase();
        Matcher match = ADDR_EXT_PTN.matcher(fld);
        if (match.matches()) {
          String apt = match.group(1);
          if (apt == null) apt = match.group(2);
          if (apt != null) {
            data.strApt = append(data.strApt, "-", apt);
          } else {
            data.strAddress = data.strAddress + ' ' + fld;
          }
        } else if (! COMMENTS_PTN.matcher(fld).matches()) {
          data.strPlace = append(data.strPlace, " - ", fld);
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE APT";
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      if (field.startsWith("PD-")) data.strCity = "CASPER";
      else if (field.startsWith("NC")) data.strCity = "NATRONA COUNTY";
      else {
        String city = CITY_CODES.getProperty(field);
        if (city != null) data.strCity = city;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CITY MAP";
    }
  }

  private static final Pattern CALLBACK_PTN = Pattern.compile("CALLBACK=([^ ]*?) LAT=([^ ]*?) LON=([^ ]*?) UNC=.*");
  private static final Pattern CHANNEL_PTN = Pattern.compile("[\\* ]*(TAC +\\d+)[-\\* ]*(.*)", Pattern.CASE_INSENSITIVE);
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALLBACK_PTN.matcher(field);
      if (match.matches()) {
        data.strPhone = match.group(1);
        data.strGPSLoc = match.group(2) + ' ' + match.group(3);
        return;
      }
      match = CHANNEL_PTN.matcher(field);
      if (match.matches()) {
        data.strChannel = match.group(1);
        field = match.group(2);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PHONE GPS CH INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{3,4}");
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALRD",   "ALCOVA LAKE",
      "MWRD",   "MIDWEST",
  });
}
