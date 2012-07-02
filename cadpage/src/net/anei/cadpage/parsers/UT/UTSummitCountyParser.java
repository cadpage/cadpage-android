package net.anei.cadpage.parsers.UT;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Summit County, UT
Contact: Active911
Agency name: Summit County Search and Rescue Location: Park City, UT 
Sender: scso911@summitcounty.org

UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS RD; SILVER SP,PC\nUHP\n563\nTraffic stop                                                                    \n22:30:34 06/07/2012 - Rose A         \n\nState Response:\n\nAlert: REPORTED TO INSURITE SOLD OR REG OUT OF STATE\nLicense Plate: 963KPF, UT\nVIN: F36ZPGH0035\nExpires: --\nColor: \nYe
UHP\nTraffic Stop\nN SR224 & W SUN PEAK DR; OLD RANCH RD,PC\nUHP\nK33\n10-60
UHP\nTraffic Stop\nN SR224 & W SUN PEAK DR; SUN PEAK DR,PC\nUHP\nK18\nTraffic stop
UHP\nTraffic Stop\n11 SR224,PC\nUHP\n563\nTraffic stop
UHP\nTraffic Stop\n144 I80 EASTBOUND,PC\nUHP\n401\nTraffic stop
PCFD\nMedical Aid\n6609 N LANDMARK DR; LANDMARK DR,PC\nPCFD\nA37
SCSO\nTraffic Stop\nW KILBY RD; Ecker Hill,PC\nSCZ5\nK76\n10-60
SCSO\nTraffic Stop\nPINEBROOK BLVD; #1480-1601,1602-1653,165,PC\nSCZ5\nK76\n10-60
UHP\nInjury Accident\n8 SR40 EASTBOUND,HEB\nUHP\n537\nWhite durango,nissan titan alph bravo injuries.
SCSO\nTraffic Stop\npinebrook & point @\nYANK3\nK76\n10-60
SCSO\nTraffic Stop\n3151 W KILBY RD,PC\nSCZ5\nK49\n10-60
SCSO\nTraffic Stop\nN LANDMARK DR,PC\nSCZ5\nK76\n10-60
UHP\nTraffic Stop\n4 SR40 WESTBOUND; ramp,PC\nUHP\n240\n1060
PCFD\nMedical Aid\n199 DALY AVE,PCC\nPCFD\nA37
PCFD\nFire Alrm Comml\n6344 N PROMONTORY RANCH RD; PROMONTORY R,PC\nPCFD\nE37\nMarket place audible zone 7 water flow rp pending dt 1403 inside 465-649-4433
SCSO\nTraffic Stop\nN SILVER SPRINGS RD & N EAST MEADOWS DR,PC\nSCZ3\nK76\n10-60
SCSO\nTraffic Stop\nN SILVER SPRINGS DR & N EAST MEADOWS DR,PC\nSCZ3\nK76\n10-60
SCSO\nTraffic Stop\n@\nYANK3\nK76\n b495le ut
UHP\nTraffic Stop\n146 I80 EASTBOUND,PC\nUHP\n563\n1060
UHP\nTraffic Stop\n7 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic
SCSO\nTraffic Stop\n300 N MAIN ST,COA\nSCZ2\nK64\n traffic
SCSO\nTraffic Stop\n200 N MAIN ST,COA\nSCZ2\nK64\ntraffic
PCFD\nFire Alrm Comml\n8417 N RANCH CLUB TRL,PC\nPCFD\nE37\nPromontory Kids Cabin (435)333-4050 - POA: GENERAL - DT: 19:02 - RP: Pending.
PCFD\nMedical Aid\n7700 STEIN WAY,PCC\nPCFD\nA34\nmale 20 ish face down hotel floor - not breathing\n19:08:06 06/08/2012 - Peterson T B\nProQA Medical Recommended Dispatch Level = 31D02\n20 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller S
SCSO\nTraffic Stop\nE ECHO DAM RD,COA\nSCZ2\nK64\n10-60 south beach
UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nUHP\nK46\n10-60
PCFD\nMedical Aid\n1776 KEARNS BLVD,PCC\nPCFD\nE31\nApprox 16-17 year old female, c/b/a, struck by a vehicle in front of the high\nschool, she is pinned under the vehicle, bleeding from the nose is the only\nobvious bleeding at this time, caller is unable to get closer to assess\ninjuries.\n18:51:51 06/08/2012
PCFD\nMedical Aid\n516 MARSAC AVE,PCC\nPCFD\nA37\nKenna at the Peace House contacted UNI Crisis hotline - She has an early 20's\nfemale c/b/a that has a severe mental illness, has been in and out of\ninstitutions for 6 years. She has been off meds for an unknown period of time\nand is anxious and paranoid.
SCSO\nTraffic Stop\nE OLD RANCH RD,PC\nSCZ3\nK46\n10-60
SCSO\nTraffic Stop\n600 S MAIN ST,COA\nSCZ2\nK64\ntraffic
UHP\nTraffic Stop\n9 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic
UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nUHP\nK46\n10-60
UHP\nTraffic Stop\n4 SR40 EASTBOUND,PC\nUHP\n401\ntraffic
SCSO\nTraffic Stop\nN CREEKSIDE LN,PC\nSCZ3\nK71\n10-60
UHP\nTraffic Stop\nE MIRROR LAKE; 200 E,KAM\nUHP\n563\ntraffic
UHP\nTraffic Stop\nN SR224 & W UTE BLVD; UTE BLVD,PC\nUHP\nK71\n10-60
UHP\nTraffic Stop\nN SR224 & COVE CANYON DR,PC\nUHP\nK46\n10-60
UHP\nTraffic Stop\n22 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic
UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR,PC\nUHP\nK46\n10-60
UHP\nTraffic Stop\n47 SR40 EASTBOUND,HEB\nUHP\n401\ntraffic
SCSO\nTraffic Stop\n300 N MAIN ST,COA\nSCZ2\n1A68\n10-60
SCSO\nTraffic Stop\nCOVE CANYON DR,PC\nSCZ5\nK62\n1060 sr224
SCSO\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nSCSO\nK45\nK45 advised traffic
SCSO\nTraffic Stop\nsr 302,PEO\nSCSO\nK72\nK72 advised out with a vehicle
SCSO\nTraffic Stop\n23 MIRROR LAKE HWY; U150,EVA\nSCSO\nK80\nK80 advised traffic
SCSO\nTraffic Stop\nQUARRY MOUNTAIN RD,PC\nSCZ3\n420\n1060 Quarry Village Parking lot
SCSO\nTraffic Stop\n6545 N LANDMARK DR,PC\nSCZ5\nK45\nK45 advised traffic
SCSO\nTraffic Stop\nE HIGHLAND DR; Swaner lookout,PC\nSCZ3\nK57\nK57 advised traffic stop.
SCSO\nSAR Training\nS ROCKPORT ASPEN CIR,RKP\nSCZ2\nK10\ncase requested
SCSO\nTraffic Stop\n68 S MAIN ST,COA\nSCZ2\nK71\n 10-60
SCSO\nTraffic Stop\nS 50 E,COA\nSCZ2\nK71\n10-60
SCSO\nTraffic Stop\nN SILVER CREEK DR & N PROMONTORY RANCH R,PC\nSCZ3\nK55\n10-60 whi ford x1
SCSO\nTraffic Stop\nsr32 & oakley downs rd @\nZULU2\nK71\n 10-60
SCSO\nTraffic Stop\n1390 S HOYTSVILLE RD,HOY\nSCZ2\nK71\n 10-60
PCFD\nFire Alrm Comml\n1305 LOWELL AVE,PCC\nPCFD\nE31\nmarriot resorts. POA water flow alarm. 435 940 2000. RP is pending.
PCFD\nMedical Aid\n15 PROSPECTOR DR,PCC\nPCFD\nE38\n82 yo female that has pain in her stomach.
UHP\nInjury Accident\n146 I80 EASTBOUND,PC\nUHP\n563\nfour car accident two black cars, 1 blue car, 1 white car. Non injuries, not\nblocking.\n16:27:06 06/15/2012 - Pyper J\nwhite jetta 21 yof c/b/a complaining of neck pain\n16:28:02 06/15/2012 - Pyper J\ncomp in the white jetta needs a tow 610h9 Matt Strader 435
PCFD\nMedical Aid\n1800 PARK AVE,PCC\nPCFD\nA31\n17:16:46 06/15/2012 - Odenbach T\nProQA Medical Recommended Dispatch Level = 21A01\n23 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: intoxicated female with blood on her.\n 1. She is complete
PCFD\nMedical Aid\n4045 W HILLTOP CT; HILLTOP CT,PC\nPCFD\nA35\n18:13:13 06/15/2012 - Odenbach T\nProQA Medical Recommended Dispatch Level = 31D02\n32 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller Statement: siezure.\n 1. His breathing is not complete
PCFD\nFire Alrm Comml\n7620 ROYAL ST E,PCC\nPCFD\nE34\nDeer Valley Resort 615-6395 - POA: GENERAL - DT: 18:32 - RP: Pending
PCFD\nMedical Aid\n373 GILLMOR WAY,PCC\nPCFD\nA31\nlower baseball south east field - near where the diamond and grass meet \n18:49:26 06/15/2012 - Peterson T B\nProQA Medical Recommended Dispatch Level = 30B01\n12 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body
PCFD\nFire Alrm Comml\n710 MAIN ST,PCC\nPCFD\nE38\nMarriott Summit Watch - POA: Ontario Bldg - DT: 19:15 - RP: Pending.
NSFD\nBrush Fire\n169 I80 WESTBOUND,COA\nNSFD\nNSFD\neast of echo on i80 on the tracks\n15:08:50 06/15/2012 - Pyper J\nunion pacific notified they will stop the trains\n15:32:31 06/15/2012 - Pyper J\nfire contained at this time\n17:22:58 06/15/2012 - Pyper J\nhave reopened the railroad at reduced speed rp on scen
PCFD\nMedical Aid\n1010 WOODSIDE AVE,PCC\nPCFD\nA31\n11 yom fell skate boarding - c/dif breathing/ alert
PCFD\nMedical Aid\n1456 W NEWPARK BLVD,PC\nPCFD\nA35
PCFD\nMedical Aid\nW NEWPARK BLVD,PC\nPCFD\nA37\nmale indv votiming c/b/a
UHP\nInjury Accident\nSR189,HEB\nUHP\n448\n22:36:49 06/15/2012 - Harrison S\nProQA Medical Case C12-41360 Aborted: 9. Test case
UHP\nMissing Person\nMIRROR LAKE HWY,EVA\nUHP\nK30\nMale in sil gmc sierra/called evanston saying he has lost his wife and is\ndisoriented and confused/unk if she was in a vehicle or if she is hiking\naround/is somewhere on the road to whitney res near bear river service on mirror\nlake highway
SCSO\nSearch/Rescue\nMIRROR LAKE HWY,KAM\nUHP\nS52
SAR \nSAR Training\nSoapstone Guard Station,KAM\nSCZ4\nS24\nTraining until tomorrow sometime
SCSO\nMissing Person\n9 MIRROR LAKE HWY; U150,KAM\nUHP\nS52\nthree missing teenagers two male, one female that have been missing for three\nhrs.
SAR \nSAR Training\nSoapstone Guard Station,KAM\nSCZ4\nS24\nTraining until tomorrow sometime
SCSO\nMissing Person\n100 E CENTER ST,KAM\nSCSO\nK54\nK54 advised some people rolled up on me and advised their father is missing.  \nLicense Number:  1953549  Sex:  M \nID Number:   Height:  511 \nName:  VERN A CARTER  Weight:  195 \nAddress:  13800 WEST 3800 NORTH\nTABIONA, UT 84072 Eye:  BLU \nLast Address Upda
SCSO\nSearch/Rescue\nHOYTS CANYON,KAM\nSCZ4\nK10\n82 yom missing. Made contact with a friend Don Soyer last night around 00:00 and\nstated he was up Hoyts Peak near the Lost Mine and he was stuck and his phone\nwas going to die.
SCSO\nMissing Person\nCRESTVIEW DR,PC\nSCZ5\nK56\nChristopher Goode been missing for two weeks, last seen a month ago. Has been in\nCalifornia until 2 weeks ago, unable to make contact with him for two weeks,\nphone is shut off. Might still be in California but not known. Working around\nTahoe.
UHP\nMissing Person\nE MIRROR LAKE HWY,KAM\nUHP\nK43\nComp has Tukwila Police Dept in Tukwila Washington have started a report #124572\nCaller stated Summit county pinged the cell phone last night and it came from\nthe great lakes area last night close to midnight.\n\n**It is imperative to get the person's cell
PCFD\nBrush Fire\n2466 MEADOWS DR,PCC\nPCFD\nE31\nBrush fire below Meadows Dr on the west side of Park Meadows, no flames seen\n19:17:40 06/28/2012 - Hewitt H       \nNear Eagle Point

*/


public class UTSummitCountyParser extends FieldProgramParser {
  
  public UTSummitCountyParser() {
    super("SUMMIT COUNTY", "UT",
           "SRC CALL ADDR! UNIT+? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "scso911@summitcounty.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), 4, data);
  }
  
  private static final Pattern BOUND_PTN = Pattern.compile("\\b(?:NORTH|EAST|SOUTH|WEST)BOUND\\b");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = convertCodes(p.getLastOptional(','), CITY_CODES);
      int pt = city.lastIndexOf(',');
      if (pt >= 0) {
        data.strState = city.substring(pt+1);
        city = city.substring(0,pt);
      }
      data.strCity = city;
      data.strCross = p.getLastOptional(';');
      String sAddr = p.get();
      if (sAddr.endsWith("@")) sAddr = sAddr.substring(0,sAddr.length()-1).trim();
      StringBuffer sb = new StringBuffer();
      Matcher match = BOUND_PTN.matcher(sAddr);
      while (match.find()) {
        match.appendReplacement(sb, "");
        sb.append(match.group().charAt(0));
        sb.append('B');
      }
      match.appendTail(sb);
      parseAddress(sb.toString(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X CITY ST";
    }
  }

  private class MyUnitField extends UnitField {
    public MyUnitField() {
      super("[A-Za-z]*[0-9]*");
    }
    
    @Override 
    public void parse(String field, Data data) {
      if (field.equals(data.strSource)) return;
      data.strUnit = append(data.strUnit, ",", field);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.startsWith(field)) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{3,4}");
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "COA",  "COALVILLE",
      "EVA",  "KAMAS",        // ?????
      "HEB",  "HEBER",        // Wasatch County
      "HOY",  "HOYTSVILLE",
      "KAM",  "KAMAS",
      "OAK",  "OAKLY",
      "PC",   "PARK CITY",
      "PCC",  "PARK CITY",
      "PEO",  "PEOA",
      "RKP",  "ROCKPORT"
  });
}
