package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Callaway County, MO
Contact: support@active911.com
Sender: EnterpolAlerts@cceoc.org

Subject: NEWOCC #12-1590  12 - Convulsions/Seizures\nNEWOCC #12-1590  12 - Convulsions/Seizures\nAddress: Mertens Mini Mart - 6603 St Hwy NN, Callaway County\nReporting Person: Andrea Phone: 642-6443\nDetail: subject had a siezure, no longer siezing\npossibly because of drugs
Subject: NEWOCC #12-1589  602 - Structure Fire\nNEWOCC #12-1589  602 - Structure Fire\nAddress: 181 Lorene, Holts Summit\nReporting Person: Lisa Phone: 616-1063\nDetail: 
Subject: NEWOCC #12-1582  6 - Breathing Problems\nNEWOCC #12-1582  6 - Breathing Problems\nAddress: 921 Merklin Dr, Fulton\nReporting Person: Frita Phone: 642-6978\nDetail: 
Subject: NEWOCC #12-1617  10 - Chest Pain\nNEWOCC #12-1617  10 - Chest Pain\nAddress: FRDC - 1205 SR O, Fulton\nReporting Person: Officer Phone: 573-592-4040\nDetail: patient complaining of chest pains\nneeding to go to Cap Region by ambulance per the doctor
Subject: NEWOCC #12-1596  33 - Transfer/Interfacility\nNEWOCC #12-1596  33 - Transfer/Interfacility\nAddress: CCH - 10 Hospital Dr, Fulton\nReporting Person:  Phone: \nDetail: cch to university
Subject: NEWOCC #12-1581  26 - Sick Person\nNEWOCC #12-1581  26 - Sick Person\nAddress: J & L Mobile Home Park - 320 N Summit Dr (30), Holts Summit\nReporting Person: susan Phone: 573-434-6225\nDetail: daughts is have sever pain in the area of her blader
Subject: NEWOCC #12-1616  25 - Psychiatric/Suicide Attempt\nNEWOCC #12-1616  25 - Psychiatric/Suicide Attempt\nAddress: 4162 CR 4006, Callaway County\nReporting Person: Christina Phone: 295-6332\nDetail: teenage son recently had surgery, released out of hospital friday morning\ngave him a full bottle of hydrocodine when he was released - and took the entire bottle of it today\nleft a note on the table that said "leave me be and let me die"\nson, Dylan Wolfenden, dob 06211992\napproximately 30 pills taken, 5/325 mg
Subject: NEWOCC #12-1580  26 - Sick Person\nNEWOCC #12-1580  26 - Sick Person\nAddress: 5039 Red Maple Ln (Room: frances), Callaway County\nReporting Person: frances Phone: 573-592-0024\nDetail: high blood presher
Subject: NEWOCC #12-1600  29 - Traffic/Transp Incidents (EMD)\nNEWOCC #12-1600  29 - Traffic/Transp Incidents (EMD)\nAddress: 204 Oak St, Auxvasse\nReporting Person: zachary Phone: 5738261761\nDetail: occur cr 260 subj walked home
Subject: NEWOCC #12-1595  17 - Falls\nNEWOCC #12-1595  17 - Falls\nAddress: 1401 Pollock rd, Mexico\nReporting Person: Audrain Phone: \nDetail: 60 yr old male fell off ladder atleast 10ft
Subject: NEWOCC #12-1585  11 - Choking\nNEWOCC #12-1585  11 - Choking\nAddress: Lions Club/Fulton - 1 Ray Worth  Dr (Bldg), Fulton\nReporting Person: Anita Phone: 573-310-1327\nDetail: granddaughter is choking
Subject: NEWOCC #12-1615  10 - Chest Pain\nNEWOCC #12-1615  10 - Chest Pain\nAddress: Westland Travel Center - 3296 Gold Rd, Callaway County\nReporting Person:  Phone: 573-826-0287\nDetail: crying and chest hurts sharp pains
Subject: NEWOCC #12-1584  26 - Sick Person\nNEWOCC #12-1584  26 - Sick Person\nAddress: 1959 Owl Creek Ln, Callaway County\nReporting Person: Darline Phone: 573-642-3083\nDetail: needs an ambulance \nmultiple sclorosis\nand just became parilyzed
Subject: NEWOCC #12-1583  29 - Traffic/Transp Incidents (EMD)\nNEWOCC #12-1583  29 - Traffic/Transp Incidents (EMD)\nAddress: 142.2mm - 3600 I70, Callaway County\nReporting Person: Whitney Phone: 919-949-6518\nDetail: 2 vehicles\neb lane rollover accident\nbrown jeep cherokee\nnon blocking
Subject: NEWOCC #12-1614  17 - Falls\nNEWOCC #12-1614  17 - Falls\nAddress: 12469 CR 4047, Callaway County\nReporting Person: Osage County Phone: 897-2285\nDetail: Fall victim, back pain, fell from a standing position \nConscious and breathing\nSubject is 275 lbs\n24 yom\n573-645-3219 Karen Hoellering
Subject: NEWOCC #12-1613  5 - Back Pain (Non-Traumatic)\nNEWOCC #12-1613  5 - Back Pain (Non-Traumatic)\nAddress: 1005 Nichols St, Fulton\nReporting Person: Raneda Phone: 642-2619\nDetail: back pain
Subject: NEWOCC #12-1588  26 - Sick Person\nNEWOCC #12-1588  26 - Sick Person\nAddress: 205 KD Dr (B), Auxvasse\nReporting Person: Marilyn Phone: 386-3465\nDetail: just had exploratory surgery\npain in her abdomen
Subject: NEWOCC #12-1612  26 - Sick Person\nNEWOCC #12-1612  26 - Sick Person\nAddress: Riverview Nursing Home - 10303 St Hwy C, Callaway County\nReporting Person: Wendy Phone: 573-676-3137\nDetail: Right foot and ankle red and swollen - patient is unable to move it\n63 yof
Subject: NEWOCC #12-1587  26 - Sick Person\nNEWOCC #12-1587  26 - Sick Person\nAddress: 7054 CR 400, Callaway County\nReporting Person: Becky Phone: 676-5788\nDetail: mother is 75yo\njust started vomiting, 123 blood sugar, clammy, \nbp 193/87\nheart rate 60\nweak legs
Subject: NEWOCC #12-1611  33 - Transfer/Interfacility\nNEWOCC #12-1611  33 - Transfer/Interfacility\nAddress: CCH - 10 Hospital Dr, Fulton\nReporting Person:  Phone: \nDetail: to univeristy\nspinal imobilization
Subject: NEWOCC #12-1610  10 - Chest Pain\nNEWOCC #12-1610  10 - Chest Pain\nAddress: Dollar General Warehouse - 1900 Cardinal Dr, Fulton\nReporting Person:  Phone: 592-3578\nDetail: believes that he is having a heart attack
Subject: NEWOCC #12-1579  32 - Unknown Problem (EMD)\nNEWOCC #12-1579  32 - Unknown Problem (EMD)\nAddress: 103 Senior Center Dr (1), Auxvasse\nReporting Person: Lifeline Phone: 888-289-2018\nDetail: signal from Sara Buckner, 80 yof\nhas attempted to resignal several times, but she is not getting a verbal response out of her\nBuckner has severe allergies\n#573-386-5267\nRef: 134111588, Resignal when they get OS
Subject: NEWOCC #12-1578  306 - Standby\nNEWOCC #12-1578  306 - Standby\nAddress: Callaway Raceways - 7419 CR 405, Callaway County\nReporting Person:  Phone: \nDetail: 
Subject: NEWOCC #12-1605  32 - Unknown Problem (EMD)\nNEWOCC #12-1605  32 - Unknown Problem (EMD)\nAddress: 103 Senior Center Dr (1), Auxvasse\nReporting Person: Lifeline Phone: 888-289-2018\nDetail: Sara Buckner, 80 yof\nhad a signal that she pressed her button, unsure what is going on\nshe fell out of her chair - not hurt, just needs help up - but not sure if this was her they heard or someone else\nref: 134195938\n#: 573-386-5267
Subject: NEWOCC #12-1607  23 - Overdose/Poisoning\nNEWOCC #12-1607  23 - Overdose/Poisoning\nAddress: 479 Law Ct, Fulton\nReporting Person: Rachel Phone: 230-9936\nDetail: mother has taken a lot of meds does not know how much
Subject: NEWOCC #12-1608  29 - Traffic/Transp Incidents (EMD)\nNEWOCC #12-1608  29 - Traffic/Transp Incidents (EMD)\nAddress: 137.4mm - 1800 I70, Callaway County\nReporting Person: Erica Phone: 314-599-5252\nDetail: wb - tractor trailer just ran off the road\njust east of the 136mm\nwent into the median, swerved back and then went back in the ditch - tipped over on it's side a bit but not rolled over
Subject: NEWOCC #12-1609  12 - Convulsions/Seizures\nNEWOCC #12-1609  12 - Convulsions/Seizures\nAddress: Westwood Motel - 422 Gaylord Dr (17), Fulton\nReporting Person: James Phone: 544-6207\nDetail: 
Subject: NEWOCC #12-1594  6 - Breathing Problems\nNEWOCC #12-1594  6 - Breathing Problems\nAddress: Biggs Unit - 1157 SR O (12), Fulton\nReporting Person: pat Phone: 592-2712\nDetail: subject came out of his room struggling with breath 
Subject: NEWOCC #12-1593  33 - Transfer/Interfacility\nNEWOCC #12-1593  33 - Transfer/Interfacility\nAddress: CCH - 10 Hospital Dr, Fulton\nReporting Person: amb rd Phone: \nDetail: to umc\n54yoa fem abdom pain
Subject: NEWOCC #12-1592  17 - Falls\nNEWOCC #12-1592  17 - Falls\nAddress: Seges Mobile Home - 188 N Summit Dr (79), Holts Summit\nReporting Person: gladys Phone: 8964079\nDetail: 
Subject: NEWOCC #12-1606  32 - Unknown Problem (EMD)\nNEWOCC #12-1606  32 - Unknown Problem (EMD)\nAddress: 162mm - 11600 I70, Callaway County\nReporting Person: troop Phone: \nDetail: eb\ndark older model pick up - broken down\nmale subject walked to the south outer road from the 162 EB and is laying in traffic - unknown if medical or not \nalso a small child with a dog on a leash at his location with him
Subject: NEWOCC #12-1586  29 - Traffic/Transp Incidents (EMD)\nNEWOCC #12-1586  29 - Traffic/Transp Incidents (EMD)\nAddress: Wildwood Estates - 7233 Wildwood Estates Dr, Callaway County\nReporting Person: Whitney Phone: 573-676-3459\nDetail: report of an accident, needing an ambulance\nunknown exact location\ninvolved an ATV\nunknown number of patients
Subject: NEWOCC #12-1601  26 - Sick Person\nNEWOCC #12-1601  26 - Sick Person\nAddress: 11052 Brad Dr, Callaway County\nReporting Person: cieara Phone: 573-338-0286\nDetail: rp states that anna woke up and is numb in the neck and arms \n27
Subject: NEWOCC #12-1597  10 - Chest Pain\nNEWOCC #12-1597  10 - Chest Pain\nAddress: 405 Canterbury Dr, Fulton\nReporting Person: Dean Phone: 642-7132\nDetail: rp reports that he has a step son who he thinks is having a heart attack.
Subject: NEWOCC #12-1618  26 - Sick Person\nNEWOCC #12-1618  26 - Sick Person\nAddress: Fulton Police Department - 510 Market St, Fulton\nReporting Person: 35 Phone: \nDetail: wrist pain
Subject: NEWOCC #12-1591  21 - Hemorrhage/Lacerations\nNEWOCC #12-1591  21 - Hemorrhage/Lacerations\nAddress: 101 Mill St, Auxvasse\nReporting Person: david Phone: 721-8990\nDetail: past assault - nose wont stop bleeding now
Subject: NEWOCC #12-1577  602 - Structure Fire\nNEWOCC #12-1577  602 - Structure Fire\nAddress: 10084 CR 441, Callaway County\nReporting Person: Tina Phone: 573-353-6763\nDetail: Camper and other things on fire right next to rp's address
Subject: NEWOCC #12-1619  26 - Sick Person\nNEWOCC #12-1619  26 - Sick Person\nAddress: Fulton Nursing and Rehab Center - 1510 N Bus 54, Fulton\nReporting Person: nancy Phone: 6420202\nDetail: to umc for orthopedic\ndrainage due to surgery needs transport
Subject: NEWOCC #12-1620  602 - Structure Fire\nNEWOCC #12-1620  602 - Structure Fire\nAddress: SR AE and St Hwy TT - Callaway County\nReporting Person: Katie Phone: 573-418-1072\nDetail: AE/TT Exit looks to be a buiding on fire \nRight side\nBig flames \nTowards JC 
Subject: NEWOCC #12-1604  29 - Traffic/Transp Incidents (EMD)\nNEWOCC #12-1604  29 - Traffic/Transp Incidents (EMD)\nAddress: Carver Park - 1003 Westminster Ave, Fulton\nReporting Person:  Phone: \nDetail: female contacted the PD and advised that her vehicle was struck by another vehicle and then hung up
Subject: NEWOCC #12-1576  12 - Convulsions/Seizures\nNEWOCC #12-1576  12 - Convulsions/Seizures\nAddress: 1809 Devonshire Cir (A), Callaway County\nReporting Person:  Phone: 660-238-9808\nDetail: 
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: 4043 CR 259, Callaway County\nReporting Person:  Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: 7571 Primrose Ln, Callaway County\nReporting Person:  Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: Callaway Ambulance Station 2 - 249 Karen Ave, Holts Summit\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: 206 Fulton Ave, Mokane\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: 206 Fulton Rd., Callaway County\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: 201 Mill St, Auxvasse\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: WalMart - 1701 N Bus 54, Fulton\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: 1913 Lake Dr, Fulton\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: Walgreen's - 1410 Bluff St, Fulton\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #OUTS  988 - Test Call\nNEWOCC #OUTS  988 - Test Call\nAddress: Cranes Country Store - 10675 Old Hwy 40, Callaway County\nReporting Person: John Phone: \nDetail: test call
Subject: NEWOCC #12-1603  17 - Falls\nNEWOCC #12-1603  17 - Falls\nAddress: El Vaquero - 721 Bluff St, Fulton\nReporting Person:  Phone: 660-342-0857\nDetail: 
Subject: NEWOCC #12-1602  927 - Standby, Fire\nNEWOCC #12-1602  927 - Standby, Fire\nAddress: Foster Brothers Wood Products - 6465 St Hwy E, Callaway County\nReporting Person:  Phone: \nDetail: shop onthe ridge smoking
Subject: NEWOCC #12-1598  29 - Traffic/Transp Incidents (EMD)\nNEWOCC #12-1598  29 - Traffic/Transp Incidents (EMD)\nAddress: 5202 CR 240, Callaway County\nReporting Person: mshp Phone: \nDetail: silver eclipse in ditch hp enrt unk injs
Subject: NEWOCC #12-1599  26 - Sick Person\nNEWOCC #12-1599  26 - Sick Person\nAddress: Bridgeway RCF - 828 Jefferson St, Fulton\nReporting Person: Anita Phone: 642-7770\nDetail: 
Subject: NEWOCC #12-1621  10 - Chest Pain\nNEWOCC #12-1621  10 - Chest Pain\nAddress: 1052 S Summit Dr (6), Holts Summit\nReporting Person: tamy Phone: 573-462-6747\nDetail: husband believes that hes having a heart attack
Subject: NEWOCC #12-1622  17 - Falls\nNEWOCC #12-1622  17 - Falls\nAddress: ATCHLEY MIKE - 1595 CR 256, Callaway County\nReporting Person: Sherry Phone: 573-886-9790\nDetail: mother has fallen might have broken or sprained foot
Subject: NEWOCC #12-1623  17 - Falls\nNEWOCC #12-1623  17 - Falls\nAddress: Bridgeway RCF - 828 Jefferson St, Fulton\nReporting Person: Nancy Phone: 642-7770\nDetail: gentleman fell\n1925
Subject: NEWOCC #12-1624  2 - Allergies/Envenomations\nNEWOCC #12-1624  2 - Allergies/Envenomations\nAddress: Fulton City Pool - Hornet Dr, Fulton\nReporting Person: Kristen Phone: 573-642-4346\nDetail: advised patient has a feeling of a squeezing sensation on her arms and a rash
Subject: NEWOCC #12-1625  26 - Sick Person\nNEWOCC #12-1625  26 - Sick Person\nAddress: Bridgeway RCF - 828 Jefferson St, Fulton\nReporting Person: Latasha Phone: 573-230-0009\nDetail: rp needs an ambulance because he needs to be transported to amc
Subject: NEWOCC #12-1626  25 - Psychiatric/Suicide Attempt\nNEWOCC #12-1626  25 - Psychiatric/Suicide Attempt\nAddress: 181 Lorene, Holts Summit\nReporting Person: Alicia Phone: 415-6246\nDetail: brother is there threatened to kill himself - did not state a method, he is intoxicated\nStephen Grohs, 19yo\n\nmother is there, sleeping - Lisa McKee\n\nbrother is not answering the phone now
Subject: NEWOCC #12-1627  10 - Chest Pain\nNEWOCC #12-1627  10 - Chest Pain\nAddress: 125 Senior Center Dr (1), Auxvasse\nReporting Person:  Phone: 338-6793\nDetail: rp reports that his wife just had a seizure and she can't remember anything
Subject: NEWINC #12-23827 12 - Convulsions/Seizures\nNEWINC #12-23827 12 - Convulsions/Seizures\nAddress: 125 Senior Center Dr (1), Auxvasse\nReporting Person:  Phone: 338-6793\nDetail: rp reports that his wife just had a seizure and she can't remember anything
Subject: NEWOCC #12-1628  25 - Psychiatric/Suicide Attempt\nNEWOCC #12-1628  25 - Psychiatric/Suicide Attempt\nAddress: Churchill Terrace - 120 Hospital Dr, Fulton\nReporting Person: Stephen Phone: 642-1332\nDetail: Patient being combative \nmentally unstable
Subject: NEWOCC #13-52  602B - Structure Fire - Commercial\nNEWOCC #13-52  602B - Structure Fire - Commercial\r\nAddress: Fulton Nursing and Rehab Center - 1510 N Bus 54, Fulton\r\nReporting Person: Melissa Phone: 573-642-0202\r\nDetail: Hvy smoke seen 200 hall

*/

public class MOCallawayCountyParserTest extends BaseParserTest {
  
  public MOCallawayCountyParserTest() {
    setParser(new MOCallawayCountyParser(), "CALLAWAY COUNTY", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject: NEWOCC #12-1590  12 - Convulsions/Seizures\n" +
        "NEWOCC #12-1590  12 - Convulsions/Seizures\n" +
        "Address: Mertens Mini Mart - 6603 St Hwy NN, Callaway County\n" +
        "Reporting Person: Andrea Phone: 642-6443\n" +
        "Detail: subject had a siezure, no longer siezing\n" +
        "possibly because of drugs",

        "ID:12-1590",
        "CODE:2",
        "CALL:Convulsions/Seizures",
        "PLACE:Mertens Mini Mart",
        "ADDR:6603 St Hwy NN",
        "MADDR:6603 MO NN",
        "NAME:Andrea",
        "PHONE:642-6443",
        "INFO:subject had a siezure, no longer siezing");

    doTest("T2",
        "Subject: NEWOCC #12-1589  602 - Structure Fire\n" +
        "NEWOCC #12-1589  602 - Structure Fire\n" +
        "Address: 181 Lorene, Holts Summit\n" +
        "Reporting Person: Lisa Phone: 616-1063\n" +
        "Detail: ",

        "ID:12-1589",
        "CODE:2",
        "CALL:Structure Fire",
        "ADDR:181 Lorene",
        "CITY:Holts Summit",
        "NAME:Lisa",
        "PHONE:616-1063");

    doTest("T3",
        "Subject: NEWOCC #12-1582  6 - Breathing Problems\n" +
        "NEWOCC #12-1582  6 - Breathing Problems\n" +
        "Address: 921 Merklin Dr, Fulton\n" +
        "Reporting Person: Frita Phone: 642-6978\n" +
        "Detail: ",

        "ID:12-1582",
        "CODE:6",
        "CALL:Breathing Problems",
        "ADDR:921 Merklin Dr",
        "CITY:Fulton",
        "NAME:Frita",
        "PHONE:642-6978");

    doTest("T4",
        "Subject: NEWOCC #12-1617  10 - Chest Pain\n" +
        "NEWOCC #12-1617  10 - Chest Pain\n" +
        "Address: FRDC - 1205 SR O, Fulton\n" +
        "Reporting Person: Officer Phone: 573-592-4040\n" +
        "Detail: patient complaining of chest pains\n" +
        "needing to go to Cap Region by ambulance per the doctor",

        "ID:12-1617",
        "CODE:0",
        "CALL:Chest Pain",
        "PLACE:FRDC",
        "ADDR:1205 SR O",
        "MADDR:1205 MO O",
        "CITY:Fulton",
        "NAME:Officer",
        "PHONE:573-592-4040",
        "INFO:patient complaining of chest pains");

    doTest("T5",
        "Subject: NEWOCC #12-1596  33 - Transfer/Interfacility\n" +
        "NEWOCC #12-1596  33 - Transfer/Interfacility\n" +
        "Address: CCH - 10 Hospital Dr, Fulton\n" +
        "Reporting Person:  Phone: \n" +
        "Detail: cch to university",

        "ID:12-1596",
        "CODE:3",
        "CALL:Transfer/Interfacility",
        "PLACE:CCH",
        "ADDR:10 Hospital Dr",
        "CITY:Fulton",
        "INFO:cch to university");

    doTest("T6",
        "Subject: NEWOCC #12-1581  26 - Sick Person\n" +
        "NEWOCC #12-1581  26 - Sick Person\n" +
        "Address: J & L Mobile Home Park - 320 N Summit Dr (30), Holts Summit\n" +
        "Reporting Person: susan Phone: 573-434-6225\n" +
        "Detail: daughts is have sever pain in the area of her blader",

        "ID:12-1581",
        "CODE:6",
        "CALL:Sick Person",
        "PLACE:J & L Mobile Home Park",
        "ADDR:320 N Summit Dr",
        "APT:30",
        "CITY:Holts Summit",
        "NAME:susan",
        "PHONE:573-434-6225",
        "INFO:daughts is have sever pain in the area of her blader");

    doTest("T7",
        "Subject: NEWOCC #12-1616  25 - Psychiatric/Suicide Attempt\n" +
        "NEWOCC #12-1616  25 - Psychiatric/Suicide Attempt\n" +
        "Address: 4162 CR 4006, Callaway County\n" +
        "Reporting Person: Christina Phone: 295-6332\n" +
        "Detail: teenage son recently had surgery, released out of hospital friday morning\n" +
        "gave him a full bottle of hydrocodine when he was released - and took the entire bottle of it today\n" +
        "left a note on the table that said \"leave me be and let me die\"\n" +
        "son, Dylan Wolfenden, dob 06211992\n" +
        "approximately 30 pills taken, 5/325 mg",

        "ID:12-1616",
        "CODE:5",
        "CALL:Psychiatric/Suicide Attempt",
        "ADDR:4162 CR 4006",
        "MADDR:4162 COUNTY ROAD 4006",
        "NAME:Christina",
        "PHONE:295-6332",
        "INFO:teenage son recently had surgery, released out of hospital friday morning");

    doTest("T8",
        "Subject: NEWOCC #12-1580  26 - Sick Person\n" +
        "NEWOCC #12-1580  26 - Sick Person\n" +
        "Address: 5039 Red Maple Ln (Room: frances), Callaway County\n" +
        "Reporting Person: frances Phone: 573-592-0024\n" +
        "Detail: high blood presher",

        "ID:12-1580",
        "CODE:6",
        "CALL:Sick Person",
        "ADDR:5039 Red Maple Ln",
        "APT:Room: frances",
        "NAME:frances",
        "PHONE:573-592-0024",
        "INFO:high blood presher");

    doTest("T9",
        "Subject: NEWOCC #12-1600  29 - Traffic/Transp Incidents (EMD)\n" +
        "NEWOCC #12-1600  29 - Traffic/Transp Incidents (EMD)\n" +
        "Address: 204 Oak St, Auxvasse\n" +
        "Reporting Person: zachary Phone: 5738261761\n" +
        "Detail: occur cr 260 subj walked home",

        "ID:12-1600",
        "CODE:9",
        "CALL:Traffic/Transp Incidents (EMD)",
        "ADDR:204 Oak St",
        "CITY:Auxvasse",
        "NAME:zachary",
        "PHONE:5738261761",
        "INFO:occur cr 260 subj walked home");

    doTest("T10",
        "Subject: NEWOCC #12-1595  17 - Falls\n" +
        "NEWOCC #12-1595  17 - Falls\n" +
        "Address: 1401 Pollock rd, Mexico\n" +
        "Reporting Person: Audrain Phone: \n" +
        "Detail: 60 yr old male fell off ladder atleast 10ft",

        "ID:12-1595",
        "CODE:7",
        "CALL:Falls",
        "ADDR:1401 Pollock rd",
        "CITY:Mexico",
        "NAME:Audrain",
        "INFO:60 yr old male fell off ladder atleast 10ft");

    doTest("T11",
        "Subject: NEWOCC #12-1585  11 - Choking\n" +
        "NEWOCC #12-1585  11 - Choking\n" +
        "Address: Lions Club/Fulton - 1 Ray Worth  Dr (Bldg), Fulton\n" +
        "Reporting Person: Anita Phone: 573-310-1327\n" +
        "Detail: granddaughter is choking",

        "ID:12-1585",
        "CODE:1",
        "CALL:Choking",
        "PLACE:Lions Club/Fulton",
        "ADDR:1 Ray Worth  Dr",  // Not mapping 
        "APT:Bldg",
        "CITY:Fulton",
        "NAME:Anita",
        "PHONE:573-310-1327",
        "INFO:granddaughter is choking");

    doTest("T12",
        "Subject: NEWOCC #12-1615  10 - Chest Pain\n" +
        "NEWOCC #12-1615  10 - Chest Pain\n" +
        "Address: Westland Travel Center - 3296 Gold Rd, Callaway County\n" +
        "Reporting Person:  Phone: 573-826-0287\n" +
        "Detail: crying and chest hurts sharp pains",

        "ID:12-1615",
        "CODE:0",
        "CALL:Chest Pain",
        "PLACE:Westland Travel Center",
        "ADDR:3296 Gold Rd",
        "PHONE:573-826-0287",
        "INFO:crying and chest hurts sharp pains");

    doTest("T13",
        "Subject: NEWOCC #12-1584  26 - Sick Person\n" +
        "NEWOCC #12-1584  26 - Sick Person\n" +
        "Address: 1959 Owl Creek Ln, Callaway County\n" +
        "Reporting Person: Darline Phone: 573-642-3083\n" +
        "Detail: needs an ambulance \n" +
        "multiple sclorosis\n" +
        "and just became parilyzed",

        "ID:12-1584",
        "CODE:6",
        "CALL:Sick Person",
        "ADDR:1959 Owl Creek Ln",
        "NAME:Darline",
        "PHONE:573-642-3083",
        "INFO:needs an ambulance");

    doTest("T14",
        "Subject: NEWOCC #12-1583  29 - Traffic/Transp Incidents (EMD)\n" +
        "NEWOCC #12-1583  29 - Traffic/Transp Incidents (EMD)\n" +
        "Address: 142.2mm - 3600 I70, Callaway County\n" +
        "Reporting Person: Whitney Phone: 919-949-6518\n" +
        "Detail: 2 vehicles\n" +
        "eb lane rollover accident\n" +
        "brown jeep cherokee\n" +
        "non blocking",

        "ID:12-1583",
        "CODE:9",
        "CALL:Traffic/Transp Incidents (EMD)",
        "PLACE:142.2mm",
        "ADDR:3600 I70",
        "MADDR:3600 I 70",
        "NAME:Whitney",
        "PHONE:919-949-6518",
        "INFO:2 vehicles");

    doTest("T15",
        "Subject: NEWOCC #12-1614  17 - Falls\n" +
        "NEWOCC #12-1614  17 - Falls\n" +
        "Address: 12469 CR 4047, Callaway County\n" +
        "Reporting Person: Osage County Phone: 897-2285\n" +
        "Detail: Fall victim, back pain, fell from a standing position \n" +
        "Conscious and breathing\n" +
        "Subject is 275 lbs\n" +
        "24 yom\n" +
        "573-645-3219 Karen Hoellering",

        "ID:12-1614",
        "CODE:7",
        "CALL:Falls",
        "ADDR:12469 CR 4047",
        "MADDR:12469 COUNTY ROAD 4047",
        "NAME:Osage County",
        "PHONE:897-2285",
        "INFO:Fall victim, back pain, fell from a standing position");

    doTest("T16",
        "Subject: NEWOCC #12-1613  5 - Back Pain (Non-Traumatic)\n" +
        "NEWOCC #12-1613  5 - Back Pain (Non-Traumatic)\n" +
        "Address: 1005 Nichols St, Fulton\n" +
        "Reporting Person: Raneda Phone: 642-2619\n" +
        "Detail: back pain",

        "ID:12-1613",
        "CODE:5",
        "CALL:Back Pain (Non-Traumatic)",
        "ADDR:1005 Nichols St",
        "CITY:Fulton",
        "NAME:Raneda",
        "PHONE:642-2619",
        "INFO:back pain");

    doTest("T17",
        "Subject: NEWOCC #12-1588  26 - Sick Person\n" +
        "NEWOCC #12-1588  26 - Sick Person\n" +
        "Address: 205 KD Dr (B), Auxvasse\n" +
        "Reporting Person: Marilyn Phone: 386-3465\n" +
        "Detail: just had exploratory surgery\n" +
        "pain in her abdomen",

        "ID:12-1588",
        "CODE:6",
        "CALL:Sick Person",
        "ADDR:205 KD Dr",    // Not maping
        "APT:B",
        "CITY:Auxvasse",
        "NAME:Marilyn",
        "PHONE:386-3465",
        "INFO:just had exploratory surgery");

    doTest("T18",
        "Subject: NEWOCC #12-1612  26 - Sick Person\n" +
        "NEWOCC #12-1612  26 - Sick Person\n" +
        "Address: Riverview Nursing Home - 10303 St Hwy C, Callaway County\n" +
        "Reporting Person: Wendy Phone: 573-676-3137\n" +
        "Detail: Right foot and ankle red and swollen - patient is unable to move it\n" +
        "63 yof",

        "ID:12-1612",
        "CODE:6",
        "CALL:Sick Person",
        "PLACE:Riverview Nursing Home",
        "ADDR:10303 St Hwy C",         // Not mapping
        "MADDR:10303 MO C",
        "NAME:Wendy",
        "PHONE:573-676-3137",
        "INFO:Right foot and ankle red and swollen - patient is unable to move it");

    doTest("T19",
        "Subject: NEWOCC #12-1587  26 - Sick Person\n" +
        "NEWOCC #12-1587  26 - Sick Person\n" +
        "Address: 7054 CR 400, Callaway County\n" +
        "Reporting Person: Becky Phone: 676-5788\n" +
        "Detail: mother is 75yo\n" +
        "just started vomiting, 123 blood sugar, clammy, \n" +
        "bp 193/87\n" +
        "heart rate 60\n" +
        "weak legs",

        "ID:12-1587",
        "CODE:6",
        "CALL:Sick Person",
        "ADDR:7054 CR 400",
        "MADDR:7054 COUNTY ROAD 400",
        "NAME:Becky",
        "PHONE:676-5788",
        "INFO:mother is 75yo");

    doTest("T20",
        "Subject: NEWOCC #12-1611  33 - Transfer/Interfacility\n" +
        "NEWOCC #12-1611  33 - Transfer/Interfacility\n" +
        "Address: CCH - 10 Hospital Dr, Fulton\n" +
        "Reporting Person:  Phone: \n" +
        "Detail: to univeristy\n" +
        "spinal imobilization",

        "ID:12-1611",
        "CODE:3",
        "CALL:Transfer/Interfacility",
        "PLACE:CCH",
        "ADDR:10 Hospital Dr",
        "CITY:Fulton",
        "INFO:to univeristy");

    doTest("T21",
        "Subject: NEWOCC #12-1610  10 - Chest Pain\n" +
        "NEWOCC #12-1610  10 - Chest Pain\n" +
        "Address: Dollar General Warehouse - 1900 Cardinal Dr, Fulton\n" +
        "Reporting Person:  Phone: 592-3578\n" +
        "Detail: believes that he is having a heart attack",

        "ID:12-1610",
        "CODE:0",
        "CALL:Chest Pain",
        "PLACE:Dollar General Warehouse",
        "ADDR:1900 Cardinal Dr",
        "CITY:Fulton",
        "PHONE:592-3578",
        "INFO:believes that he is having a heart attack");

    doTest("T22",
        "Subject: NEWOCC #12-1579  32 - Unknown Problem (EMD)\n" +
        "NEWOCC #12-1579  32 - Unknown Problem (EMD)\n" +
        "Address: 103 Senior Center Dr (1), Auxvasse\n" +
        "Reporting Person: Lifeline Phone: 888-289-2018\n" +
        "Detail: signal from Sara Buckner, 80 yof\n" +
        "has attempted to resignal several times, but she is not getting a verbal response out of her\n" +
        "Buckner has severe allergies\n" +
        "#573-386-5267\n" +
        "Ref: 134111588, Resignal when they get OS",

        "ID:12-1579",
        "CODE:2",
        "CALL:Unknown Problem (EMD)",
        "ADDR:103 Senior Center Dr",
        "APT:1",
        "CITY:Auxvasse",
        "NAME:Lifeline",
        "PHONE:888-289-2018",
        "INFO:signal from Sara Buckner, 80 yof");

    doTest("T23",
        "Subject: NEWOCC #12-1578  306 - Standby\n" +
        "NEWOCC #12-1578  306 - Standby\n" +
        "Address: Callaway Raceways - 7419 CR 405, Callaway County\n" +
        "Reporting Person:  Phone: \n" +
        "Detail: ",

        "ID:12-1578",
        "CODE:6",
        "CALL:Standby",
        "PLACE:Callaway Raceways",
        "ADDR:7419 CR 405",
        "MADDR:7419 COUNTY ROAD 405");

    doTest("T24",
        "Subject: NEWOCC #12-1605  32 - Unknown Problem (EMD)\n" +
        "NEWOCC #12-1605  32 - Unknown Problem (EMD)\n" +
        "Address: 103 Senior Center Dr (1), Auxvasse\n" +
        "Reporting Person: Lifeline Phone: 888-289-2018\n" +
        "Detail: Sara Buckner, 80 yof\n" +
        "had a signal that she pressed her button, unsure what is going on\n" +
        "she fell out of her chair - not hurt, just needs help up - but not sure if this was her they heard or someone else\n" +
        "ref: 134195938\n" +
        "#: 573-386-5267",

        "ID:12-1605",
        "CODE:2",
        "CALL:Unknown Problem (EMD)",
        "ADDR:103 Senior Center Dr",
        "APT:1",
        "CITY:Auxvasse",
        "NAME:Lifeline",
        "PHONE:888-289-2018",
        "INFO:Sara Buckner, 80 yof");

    doTest("T25",
        "Subject: NEWOCC #12-1607  23 - Overdose/Poisoning\n" +
        "NEWOCC #12-1607  23 - Overdose/Poisoning\n" +
        "Address: 479 Law Ct, Fulton\n" +
        "Reporting Person: Rachel Phone: 230-9936\n" +
        "Detail: mother has taken a lot of meds does not know how much",

        "ID:12-1607",
        "CODE:3",
        "CALL:Overdose/Poisoning",
        "ADDR:479 Law Ct",
        "CITY:Fulton",
        "NAME:Rachel",
        "PHONE:230-9936",
        "INFO:mother has taken a lot of meds does not know how much");

    doTest("T26",
        "Subject: NEWOCC #12-1608  29 - Traffic/Transp Incidents (EMD)\n" +
        "NEWOCC #12-1608  29 - Traffic/Transp Incidents (EMD)\n" +
        "Address: 137.4mm - 1800 I70, Callaway County\n" +
        "Reporting Person: Erica Phone: 314-599-5252\n" +
        "Detail: wb - tractor trailer just ran off the road\n" +
        "just east of the 136mm\n" +
        "went into the median, swerved back and then went back in the ditch - tipped over on it's side a bit but not rolled over",

        "ID:12-1608",
        "CODE:9",
        "CALL:Traffic/Transp Incidents (EMD)",
        "PLACE:137.4mm",
        "ADDR:1800 I70",
        "MADDR:1800 I 70",
        "NAME:Erica",
        "PHONE:314-599-5252",
        "INFO:wb - tractor trailer just ran off the road");

    doTest("T27",
        "Subject: NEWOCC #12-1609  12 - Convulsions/Seizures\n" +
        "NEWOCC #12-1609  12 - Convulsions/Seizures\n" +
        "Address: Westwood Motel - 422 Gaylord Dr (17), Fulton\n" +
        "Reporting Person: James Phone: 544-6207\n" +
        "Detail: ",

        "ID:12-1609",
        "CODE:2",
        "CALL:Convulsions/Seizures",
        "PLACE:Westwood Motel",
        "ADDR:422 Gaylord Dr",
        "APT:17",
        "CITY:Fulton",
        "NAME:James",
        "PHONE:544-6207");

    doTest("T28",
        "Subject: NEWOCC #12-1594  6 - Breathing Problems\n" +
        "NEWOCC #12-1594  6 - Breathing Problems\n" +
        "Address: Biggs Unit - 1157 SR O (12), Fulton\n" +
        "Reporting Person: pat Phone: 592-2712\n" +
        "Detail: subject came out of his room struggling with breath ",

        "ID:12-1594",
        "CODE:6",
        "CALL:Breathing Problems",
        "PLACE:Biggs Unit",
        "ADDR:1157 SR O",
        "MADDR:1157 MO O",
        "APT:12",
        "CITY:Fulton",
        "NAME:pat",
        "PHONE:592-2712",
        "INFO:subject came out of his room struggling with breath");

    doTest("T29",
        "Subject: NEWOCC #12-1593  33 - Transfer/Interfacility\n" +
        "NEWOCC #12-1593  33 - Transfer/Interfacility\n" +
        "Address: CCH - 10 Hospital Dr, Fulton\n" +
        "Reporting Person: amb rd Phone: \n" +
        "Detail: to umc\n" +
        "54yoa fem abdom pain",

        "ID:12-1593",
        "CODE:3",
        "CALL:Transfer/Interfacility",
        "PLACE:CCH",
        "ADDR:10 Hospital Dr",
        "CITY:Fulton",
        "NAME:amb rd",
        "INFO:to umc");

    doTest("T30",
        "Subject: NEWOCC #12-1592  17 - Falls\n" +
        "NEWOCC #12-1592  17 - Falls\n" +
        "Address: Seges Mobile Home - 188 N Summit Dr (79), Holts Summit\n" +
        "Reporting Person: gladys Phone: 8964079\n" +
        "Detail: ",

        "ID:12-1592",
        "CODE:7",
        "CALL:Falls",
        "PLACE:Seges Mobile Home",
        "ADDR:188 N Summit Dr",
        "APT:79",
        "CITY:Holts Summit",
        "NAME:gladys",
        "PHONE:8964079");

    doTest("T31",
        "Subject: NEWOCC #12-1606  32 - Unknown Problem (EMD)\n" +
        "NEWOCC #12-1606  32 - Unknown Problem (EMD)\n" +
        "Address: 162mm - 11600 I70, Callaway County\n" +
        "Reporting Person: troop Phone: \n" +
        "Detail: eb\n" +
        "dark older model pick up - broken down\n" +
        "male subject walked to the south outer road from the 162 EB and is laying in traffic - unknown if medical or not \n" +
        "also a small child with a dog on a leash at his location with him",

        "ID:12-1606",
        "CODE:2",
        "CALL:Unknown Problem (EMD)",
        "PLACE:162mm",
        "ADDR:11600 I70",
        "MADDR:11600 I 70",
        "NAME:troop",
        "INFO:eb");

    doTest("T32",
        "Subject: NEWOCC #12-1586  29 - Traffic/Transp Incidents (EMD)\n" +
        "NEWOCC #12-1586  29 - Traffic/Transp Incidents (EMD)\n" +
        "Address: Wildwood Estates - 7233 Wildwood Estates Dr, Callaway County\n" +
        "Reporting Person: Whitney Phone: 573-676-3459\n" +
        "Detail: report of an accident, needing an ambulance\n" +
        "unknown exact location\n" +
        "involved an ATV\n" +
        "unknown number of patients",

        "ID:12-1586",
        "CODE:9",
        "CALL:Traffic/Transp Incidents (EMD)",
        "PLACE:Wildwood Estates",
        "ADDR:7233 Wildwood Estates Dr",  // Not mapping
        "NAME:Whitney",
        "PHONE:573-676-3459",
        "INFO:report of an accident, needing an ambulance");

    doTest("T33",
        "Subject: NEWOCC #12-1601  26 - Sick Person\n" +
        "NEWOCC #12-1601  26 - Sick Person\n" +
        "Address: 11052 Brad Dr, Callaway County\n" +
        "Reporting Person: cieara Phone: 573-338-0286\n" +
        "Detail: rp states that anna woke up and is numb in the neck and arms \n" +
        "27",

        "ID:12-1601",
        "CODE:6",
        "CALL:Sick Person",
        "ADDR:11052 Brad Dr",  // Not mapping
        "NAME:cieara",
        "PHONE:573-338-0286",
        "INFO:rp states that anna woke up and is numb in the neck and arms");

    doTest("T34",
        "Subject: NEWOCC #12-1597  10 - Chest Pain\n" +
        "NEWOCC #12-1597  10 - Chest Pain\n" +
        "Address: 405 Canterbury Dr, Fulton\n" +
        "Reporting Person: Dean Phone: 642-7132\n" +
        "Detail: rp reports that he has a step son who he thinks is having a heart attack.",

        "ID:12-1597",
        "CODE:0",
        "CALL:Chest Pain",
        "ADDR:405 Canterbury Dr",
        "CITY:Fulton",
        "NAME:Dean",
        "PHONE:642-7132",
        "INFO:rp reports that he has a step son who he thinks is having a heart attack.");

    doTest("T35",
        "Subject: NEWOCC #12-1618  26 - Sick Person\n" +
        "NEWOCC #12-1618  26 - Sick Person\n" +
        "Address: Fulton Police Department - 510 Market St, Fulton\n" +
        "Reporting Person: 35 Phone: \n" +
        "Detail: wrist pain",

        "ID:12-1618",
        "CODE:6",
        "CALL:Sick Person",
        "PLACE:Fulton Police Department",
        "ADDR:510 Market St",
        "CITY:Fulton",
        "NAME:35",
        "INFO:wrist pain");

    doTest("T36",
        "Subject: NEWOCC #12-1591  21 - Hemorrhage/Lacerations\n" +
        "NEWOCC #12-1591  21 - Hemorrhage/Lacerations\n" +
        "Address: 101 Mill St, Auxvasse\n" +
        "Reporting Person: david Phone: 721-8990\n" +
        "Detail: past assault - nose wont stop bleeding now",

        "ID:12-1591",
        "CODE:1",
        "CALL:Hemorrhage/Lacerations",
        "ADDR:101 Mill St",
        "CITY:Auxvasse",
        "NAME:david",
        "PHONE:721-8990",
        "INFO:past assault - nose wont stop bleeding now");

    doTest("T37",
        "Subject: NEWOCC #12-1577  602 - Structure Fire\n" +
        "NEWOCC #12-1577  602 - Structure Fire\n" +
        "Address: 10084 CR 441, Callaway County\n" +
        "Reporting Person: Tina Phone: 573-353-6763\n" +
        "Detail: Camper and other things on fire right next to rp's address",

        "ID:12-1577",
        "CODE:2",
        "CALL:Structure Fire",
        "ADDR:10084 CR 441",
        "MADDR:10084 COUNTY ROAD 441",
        "NAME:Tina",
        "PHONE:573-353-6763",
        "INFO:Camper and other things on fire right next to rp's address");

    doTest("T38",
        "Subject: NEWOCC #12-1619  26 - Sick Person\n" +
        "NEWOCC #12-1619  26 - Sick Person\n" +
        "Address: Fulton Nursing and Rehab Center - 1510 N Bus 54, Fulton\n" +
        "Reporting Person: nancy Phone: 6420202\n" +
        "Detail: to umc for orthopedic\n" +
        "drainage due to surgery needs transport",

        "ID:12-1619",
        "CODE:6",
        "CALL:Sick Person",
        "PLACE:Fulton Nursing and Rehab Center",
        "ADDR:1510 N Bus 54",
        "CITY:Fulton",
        "NAME:nancy",
        "PHONE:6420202",
        "INFO:to umc for orthopedic");

    doTest("T39",
        "Subject: NEWOCC #12-1620  602 - Structure Fire\n" +
        "NEWOCC #12-1620  602 - Structure Fire\n" +
        "Address: SR AE and St Hwy TT - Callaway County\n" +
        "Reporting Person: Katie Phone: 573-418-1072\n" +
        "Detail: AE/TT Exit looks to be a buiding on fire \n" +
        "Right side\n" +
        "Big flames \n" +
        "Towards JC ",

        "ID:12-1620",
        "CODE:2",
        "CALL:Structure Fire",
        "ADDR:SR AE and St Hwy TT",
        "MADDR:MO AE & MO TT",
        "NAME:Katie",
        "PHONE:573-418-1072",
        "INFO:AE/TT Exit looks to be a buiding on fire");

    doTest("T40",
        "Subject: NEWOCC #12-1604  29 - Traffic/Transp Incidents (EMD)\n" +
        "NEWOCC #12-1604  29 - Traffic/Transp Incidents (EMD)\n" +
        "Address: Carver Park - 1003 Westminster Ave, Fulton\n" +
        "Reporting Person:  Phone: \n" +
        "Detail: female contacted the PD and advised that her vehicle was struck by another vehicle and then hung up",

        "ID:12-1604",
        "CODE:9",
        "CALL:Traffic/Transp Incidents (EMD)",
        "PLACE:Carver Park",
        "ADDR:1003 Westminster Ave",
        "CITY:Fulton",
        "INFO:female contacted the PD and advised that her vehicle was struck by another vehicle and then hung up");

    doTest("T41",
        "Subject: NEWOCC #12-1576  12 - Convulsions/Seizures\n" +
        "NEWOCC #12-1576  12 - Convulsions/Seizures\n" +
        "Address: 1809 Devonshire Cir (A), Callaway County\n" +
        "Reporting Person:  Phone: 660-238-9808\n" +
        "Detail: ",

        "ID:12-1576",
        "CODE:2",
        "CALL:Convulsions/Seizures",
        "ADDR:1809 Devonshire Cir",
        "APT:A",
        "PHONE:660-238-9808");

    doTest("T42",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: 4043 CR 259, Callaway County\n" +
        "Reporting Person:  Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "ADDR:4043 CR 259",
        "MADDR:4043 COUNTY ROAD 259",
        "INFO:test call");

    doTest("T43",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: 7571 Primrose Ln, Callaway County\n" +
        "Reporting Person:  Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "ADDR:7571 Primrose Ln",   // Not mapping - test call
        "INFO:test call");

    doTest("T44",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: Callaway Ambulance Station 2 - 249 Karen Ave, Holts Summit\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "PLACE:Callaway Ambulance Station 2",
        "ADDR:249 Karen Ave",
        "CITY:Holts Summit",
        "NAME:John",
        "INFO:test call");

    doTest("T45",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: 206 Fulton Ave, Mokane\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "ADDR:206 Fulton Ave",
        "CITY:Mokane",
        "NAME:John",
        "INFO:test call");

    doTest("T46",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: 206 Fulton Rd., Callaway County\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "ADDR:206 Fulton Rd",
        "NAME:John",
        "INFO:test call");

    doTest("T47",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: 201 Mill St, Auxvasse\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "ADDR:201 Mill St",
        "CITY:Auxvasse",
        "NAME:John",
        "INFO:test call");

    doTest("T48",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: WalMart - 1701 N Bus 54, Fulton\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "PLACE:WalMart",
        "ADDR:1701 N Bus 54",
        "CITY:Fulton",
        "NAME:John",
        "INFO:test call");

    doTest("T49",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: 1913 Lake Dr, Fulton\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "ADDR:1913 Lake Dr",
        "CITY:Fulton",
        "NAME:John",
        "INFO:test call");

    doTest("T50",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: Walgreen's - 1410 Bluff St, Fulton\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "PLACE:Walgreen's",
        "ADDR:1410 Bluff St",
        "CITY:Fulton",
        "NAME:John",
        "INFO:test call");

    doTest("T51",
        "Subject: NEWOCC #OUTS  988 - Test Call\n" +
        "NEWOCC #OUTS  988 - Test Call\n" +
        "Address: Cranes Country Store - 10675 Old Hwy 40, Callaway County\n" +
        "Reporting Person: John Phone: \n" +
        "Detail: test call",

        "ID:OUTS",
        "CODE:8",
        "CALL:Test Call",
        "PLACE:Cranes Country Store",
        "ADDR:10675 Old Hwy 40",  // Not mapping
        "NAME:John",
        "INFO:test call");

    doTest("T52",
        "Subject: NEWOCC #12-1603  17 - Falls\n" +
        "NEWOCC #12-1603  17 - Falls\n" +
        "Address: El Vaquero - 721 Bluff St, Fulton\n" +
        "Reporting Person:  Phone: 660-342-0857\n" +
        "Detail: ",

        "ID:12-1603",
        "CODE:7",
        "CALL:Falls",
        "PLACE:El Vaquero",
        "ADDR:721 Bluff St",
        "CITY:Fulton",
        "PHONE:660-342-0857");

    doTest("T53",
        "Subject: NEWOCC #12-1602  927 - Standby, Fire\n" +
        "NEWOCC #12-1602  927 - Standby, Fire\n" +
        "Address: Foster Brothers Wood Products - 6465 St Hwy E, Callaway County\n" +
        "Reporting Person:  Phone: \n" +
        "Detail: shop onthe ridge smoking",

        "ID:12-1602",
        "CODE:7",
        "CALL:Standby, Fire",
        "PLACE:Foster Brothers Wood Products",
        "ADDR:6465 St Hwy E",  // Not mapping
        "MADDR:6465 MO E",
        "INFO:shop onthe ridge smoking");

    doTest("T54",
        "Subject: NEWOCC #12-1598  29 - Traffic/Transp Incidents (EMD)\n" +
        "NEWOCC #12-1598  29 - Traffic/Transp Incidents (EMD)\n" +
        "Address: 5202 CR 240, Callaway County\n" +
        "Reporting Person: mshp Phone: \n" +
        "Detail: silver eclipse in ditch hp enrt unk injs",

        "ID:12-1598",
        "CODE:9",
        "CALL:Traffic/Transp Incidents (EMD)",
        "ADDR:5202 CR 240",
        "MADDR:5202 COUNTY ROAD 240",
        "NAME:mshp",
        "INFO:silver eclipse in ditch hp enrt unk injs");

    doTest("T55",
        "Subject: NEWOCC #12-1599  26 - Sick Person\n" +
        "NEWOCC #12-1599  26 - Sick Person\n" +
        "Address: Bridgeway RCF - 828 Jefferson St, Fulton\n" +
        "Reporting Person: Anita Phone: 642-7770\n" +
        "Detail: ",

        "ID:12-1599",
        "CODE:6",
        "CALL:Sick Person",
        "PLACE:Bridgeway RCF",
        "ADDR:828 Jefferson St",
        "CITY:Fulton",
        "NAME:Anita",
        "PHONE:642-7770");

    doTest("T56",
        "Subject: NEWOCC #12-1621  10 - Chest Pain\n" +
        "NEWOCC #12-1621  10 - Chest Pain\n" +
        "Address: 1052 S Summit Dr (6), Holts Summit\n" +
        "Reporting Person: tamy Phone: 573-462-6747\n" +
        "Detail: husband believes that hes having a heart attack",

        "ID:12-1621",
        "CODE:0",
        "CALL:Chest Pain",
        "ADDR:1052 S Summit Dr",
        "APT:6",
        "CITY:Holts Summit",
        "NAME:tamy",
        "PHONE:573-462-6747",
        "INFO:husband believes that hes having a heart attack");

    doTest("T57",
        "Subject: NEWOCC #12-1622  17 - Falls\n" +
        "NEWOCC #12-1622  17 - Falls\n" +
        "Address: ATCHLEY MIKE - 1595 CR 256, Callaway County\n" +
        "Reporting Person: Sherry Phone: 573-886-9790\n" +
        "Detail: mother has fallen might have broken or sprained foot",

        "ID:12-1622",
        "CODE:7",
        "CALL:Falls",
        "PLACE:ATCHLEY MIKE",
        "ADDR:1595 CR 256",
        "MADDR:1595 COUNTY ROAD 256",
        "NAME:Sherry",
        "PHONE:573-886-9790",
        "INFO:mother has fallen might have broken or sprained foot");

    doTest("T58",
        "Subject: NEWOCC #12-1623  17 - Falls\n" +
        "NEWOCC #12-1623  17 - Falls\n" +
        "Address: Bridgeway RCF - 828 Jefferson St, Fulton\n" +
        "Reporting Person: Nancy Phone: 642-7770\n" +
        "Detail: gentleman fell\n" +
        "1925",

        "ID:12-1623",
        "CODE:7",
        "CALL:Falls",
        "PLACE:Bridgeway RCF",
        "ADDR:828 Jefferson St",
        "CITY:Fulton",
        "NAME:Nancy",
        "PHONE:642-7770",
        "INFO:gentleman fell");

    doTest("T59",
        "Subject: NEWOCC #12-1624  2 - Allergies/Envenomations\n" +
        "NEWOCC #12-1624  2 - Allergies/Envenomations\n" +
        "Address: Fulton City Pool - Hornet Dr, Fulton\n" +
        "Reporting Person: Kristen Phone: 573-642-4346\n" +
        "Detail: advised patient has a feeling of a squeezing sensation on her arms and a rash",

        "ID:12-1624",
        "CODE:2",
        "CALL:Allergies/Envenomations",
        "PLACE:Fulton City Pool",
        "ADDR:Hornet Dr",
        "CITY:Fulton",
        "NAME:Kristen",
        "PHONE:573-642-4346",
        "INFO:advised patient has a feeling of a squeezing sensation on her arms and a rash");

    doTest("T60",
        "Subject: NEWOCC #12-1625  26 - Sick Person\n" +
        "NEWOCC #12-1625  26 - Sick Person\n" +
        "Address: Bridgeway RCF - 828 Jefferson St, Fulton\n" +
        "Reporting Person: Latasha Phone: 573-230-0009\n" +
        "Detail: rp needs an ambulance because he needs to be transported to amc",

        "ID:12-1625",
        "CODE:6",
        "CALL:Sick Person",
        "PLACE:Bridgeway RCF",
        "ADDR:828 Jefferson St",
        "CITY:Fulton",
        "NAME:Latasha",
        "PHONE:573-230-0009",
        "INFO:rp needs an ambulance because he needs to be transported to amc");

    doTest("T61",
        "Subject: NEWOCC #12-1626  25 - Psychiatric/Suicide Attempt\n" +
        "NEWOCC #12-1626  25 - Psychiatric/Suicide Attempt\n" +
        "Address: 181 Lorene, Holts Summit\n" +
        "Reporting Person: Alicia Phone: 415-6246\n" +
        "Detail: brother is there threatened to kill himself - did not state a method, he is intoxicated\n" +
        "Stephen Grohs, 19yo\n\n" +
        "mother is there, sleeping - Lisa McKee\n\n" +
        "brother is not answering the phone now",

        "ID:12-1626",
        "CODE:5",
        "CALL:Psychiatric/Suicide Attempt",
        "ADDR:181 Lorene",
        "CITY:Holts Summit",
        "NAME:Alicia",
        "PHONE:415-6246",
        "INFO:brother is there threatened to kill himself - did not state a method, he is intoxicated");

    doTest("T62",
        "Subject: NEWOCC #12-1627  10 - Chest Pain\n" +
        "NEWOCC #12-1627  10 - Chest Pain\n" +
        "Address: 125 Senior Center Dr (1), Auxvasse\n" +
        "Reporting Person:  Phone: 338-6793\n" +
        "Detail: rp reports that his wife just had a seizure and she can't remember anything",

        "ID:12-1627",
        "CODE:0",
        "CALL:Chest Pain",
        "ADDR:125 Senior Center Dr",
        "APT:1",
        "CITY:Auxvasse",
        "PHONE:338-6793",
        "INFO:rp reports that his wife just had a seizure and she can't remember anything");

    doTest("T63",
        "Subject: NEWINC #12-23827 12 - Convulsions/Seizures\n" +
        "NEWINC #12-23827 12 - Convulsions/Seizures\n" +
        "Address: 125 Senior Center Dr (1), Auxvasse\n" +
        "Reporting Person:  Phone: 338-6793\n" +
        "Detail: rp reports that his wife just had a seizure and she can't remember anything",

        "ID:12-23827",
        "CODE:2",
        "CALL:Convulsions/Seizures",
        "ADDR:125 Senior Center Dr",
        "APT:1",
        "CITY:Auxvasse",
        "PHONE:338-6793",
        "INFO:rp reports that his wife just had a seizure and she can't remember anything");

    doTest("T64",
        "Subject: NEWOCC #12-1628  25 - Psychiatric/Suicide Attempt\n" +
        "NEWOCC #12-1628  25 - Psychiatric/Suicide Attempt\n" +
        "Address: Churchill Terrace - 120 Hospital Dr, Fulton\n" +
        "Reporting Person: Stephen Phone: 642-1332\n" +
        "Detail: Patient being combative \n" +
        "mentally unstable",

        "ID:12-1628",
        "CODE:5",
        "CALL:Psychiatric/Suicide Attempt",
        "PLACE:Churchill Terrace",
        "ADDR:120 Hospital Dr",
        "CITY:Fulton",
        "NAME:Stephen",
        "PHONE:642-1332",
        "INFO:Patient being combative");

    doTest("T65",
        "Subject: NEWOCC #13-52  602B - Structure Fire - Commercial\n" +
        "NEWOCC #13-52  602B - Structure Fire - Commercial\r\n" +
        "Address: Fulton Nursing and Rehab Center - 1510 N Bus 54, Fulton\r\n" +
        "Reporting Person: Melissa Phone: 573-642-0202\r\n" +
        "Detail: Hvy smoke seen 200 hall",

        "ID:13-52",
        "CODE:2B",
        "CALL:Structure Fire - Commercial",
        "PLACE:Fulton Nursing and Rehab Center",
        "ADDR:1510 N Bus 54",
        "CITY:Fulton",
        "NAME:Melissa",
        "PHONE:573-642-0202",
        "INFO:Hvy smoke seen 200 hall");

  }
  
  public static void main(String[] args) {
    new MOCallawayCountyParserTest().generateTests("T1");
  }
}