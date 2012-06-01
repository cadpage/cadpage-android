package net.anei.cadpage.parsers.MO;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


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

*/

public class MOCallawayCountyParser extends FieldProgramParser {
 
  public MOCallawayCountyParser() {
    super("CALLAWAY COUNTY", "MO",
          "IDCALL! Address:ADDR! Reporting_Person:NAME! Phone:PHONE! Detail:INFO");
  }
  
  @Override
  public String getFilter() {
    return "EnterpolAlerts@cceoc.org";
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("NEW")) return false;
    body = body.replaceAll(" Phone:", "\nPhone:");
    if (! parseFields(body.split("\n"), data)) return false;
    if (data.strCity.equalsIgnoreCase("CALLAWAY COUNTY")) data.strCity = "";
    return true;
  }
  
  private static final Pattern ID_CODE_CALL_PTN = Pattern.compile("NEW[A-Z]{3} +#(\\d\\d-\\d+|OUTS) +(\\d)+ +- +(.*)");;
  private class MyIdCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_CODE_CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      data.strCode = match.group(2);
      data.strCall = match.group(3).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ID CODE CALL";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.getLastOptional(',');
      data.strPlace = p.getOptional(" - ");
      String sAddr = p.get('(');
      data.strApt = append(p.get(')'), " - ", p.get());
      if (data.strCity.length() == 0 && data.strPlace.length() > 0) {
        data.strCity = sAddr;
        sAddr = data.strPlace;
        data.strPlace = "";
      }
      super.parse(sAddr, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames() + " APT CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("IDCALL")) return new MyIdCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  @Override
  public String adjustMapAddress(String sAddress) {
    return ST_PTN.matcher(sAddress).replaceAll("MO");
  }
  private static final Pattern ST_PTN = Pattern.compile("\\b(?:ST HWY|SR)(?= +([A-Z])\\1?| +A[A-F])\\b", Pattern.CASE_INSENSITIVE);
}