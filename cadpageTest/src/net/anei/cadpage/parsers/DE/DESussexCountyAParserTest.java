package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.DE.DESussexCountyAParser;

import org.junit.Test;

/*
[86 EMS] -- 31C2 -- 33384 Hartford Ct Lewes
[86 EMS] -- 33A1 -- 36101 Seaside Blvd Rehoboth
[86 EMS] -- 17A1 -- 18958 Coastal Hwy Lewes
[86 Fire] -- F - Auto Fire Alarm -- Hallmark, Parcel Post, Safeway -- 19266 Coastal Hwy Rehoboth -- INC #602
[86 Fire] -- F - Standby -- Bethany Beach Station 70 Rehoboth Beach -- INC #599
[83 FIRE] -- Traffic/TransportationAcdntALS -- 228 W Dupont Hwy Millsboro 19966 -- Food Lion (83)
[83 FIRE] -- Vehicle Fire -- 26026 Patriots Way Georgetown 19947 -- Sussex Central High School
[83 FIRE] -- Carbon Monoxide Detector -- 28 Patterson Dr Georgetown 19947 
[83 FIRE] -- Washdown (Fuel Spill) -- 26972 - 28044 Zoar Rd Georgetown 19947
[83 FIRE] -- Traffic/TransportationAcdntBLS -- 0 Dupont Blvd & Av Of Honor Georgetown 19947
[83 FIRE] -- Structure Fire -- 0 JOHNSON RD & JESTICE FARM RD Laurel 19956
[83 FIRE] -- Cardiac/Resp./Death-ALS -- 28723 Woodcrest Dr Harbeson 19951
[81 FIRE] -- Traffic/TransportaionAcdntBLS -- 0 Discount Land Rd & Sussex Hw
[81 EMS] -- Chest Pain-ALS -- 34544 Doe Dr Laurel 19956
[81 FIRE] -- Cardiac/Res./Death-ALS -- 815 S Central Ave Laurel 19956 -- Laurel Middle / intermediate n
[81 EMS] -- Abdominal Pain-BLS -- 30594 SUssex Hwy Laurel 19956 -- Relax Inn
[81 EMS] -- Unconcious/Fainting(Near)-ALS -- 31574 White Ave Laurel 19956
[81 EMS] -- Falls-BLS -- 609 Little Creek Dr Laurel 19956

Specific to Seaford
[87 EMS] -- 1A Abdominal Pains (ALS) -- 6412 Woodduck Dr Seaford de, 19973
[87 FIRE] -- Smoke Investigation -- 6341 Baker Rd Seaford de, 19973
[87 EMS] -- 6A Breathing Problems (ALS) -- 24642 Shufelt Rd Seaford de, 19973
[87 FIRE] -- Assist Other Agency -- Hickory Hill Rd/ Guard Rd Seaford de, 19973
[87 EMS] -- 33A Interfacility (ALS) -- 715 E King St 204a Seaford de, 19973
[87 EMS] -- 13A Diabetic Problems (ALS) -- 24101 Dove Rd Seaford de, 19973

[STA:91] -- Unknown Problem(Man Down)-BLS -- 31905 Long Neck Rd Millsboro 19966 -- Wilmington Trust Company
[STA:91] -- Breathing Problems-ALS -- 32523 E Baltimore Ct Millsboro 19966
[STA:91] -- Falls-BLS -- 0 Long Neck Rd & School Ln Millsboro 19966 -- NO IDEA
[STA:91] -- Convulsions/Seizures-BLS -- 32532 Long Neck Rd Millsboro 19966 -- Lingo Creek Apt

Contact: Sean Humphreys <hump7777@gmail.com>
Sender: msg@cfmsg.com <From%3Amsg@cfmsg.com>
(Chief ALT) [86 EMS] -- 1C6 -- 1 Sconset Ct Rehoboth Beach
(Chief ALT) [86 EMS] -- 26C2 -- 36121 Knight St Rehoboth Beach
(Chief ALT) [86 EMS] -- 5A1 -- 35645 Buttermilk Dr ASPEN MEADOWS
(Chief ALT) [86 EMS] -- 32B2 -- 36299 Shady Dr SHADY GROVE

Contact: cmr199182@yahoo.com
(Chief ALT) [82 EMS] -- Medical Alert -- 18240 Robinsonville Rd Lewes 19958 -- Gosling Creek Purchase/ 123 Ha
(Chief ALT) [82 EMS] -- Interfacillity/Palliative-ALS -- 36101 Seaside Blvd Rehoboth Beach 19971 -- Brandywine Assisted Living

COntact: "cignotis7@gmail.com" <cignotis7@gmail.com>
Sender: msg@cfmsg.com
Subject:Chief ALT\n[71 EMS] -- Assault/Sexual Assault-ALS -- 25687 Cornelia St Seaford 19973\n

Contact: Lew Talley <lew.talley83@gmail.com>
Sender: alert@cfmsg.com
(Chief ALT) [83 FIRE] -- Outside Fire -- 24322 - 24557 Godwin Scho Millsboro 19966 -- XST: Revel Rd & Belmont Blvd

Contact: Active911
Agency name: Mid Sussex Rescue Squad
Location: Millsboro, DE, United States
Sender: alert@cfmsg.com

{Chief ALT}[STA:91] -- Chest Pain-ALS -- 32976 Anglers Cove Millsboro 19966 -- XST: Castaway Cir & Dead End
{Chief ALT}[STA:91] -- Unknown Problem(man Down)-BLS -- 26155 Tucks Rd Millsboro 19966 -- XST: Abby Way & Sherwood Frst
{Chief ALT}[STA:91] -- Chest Pain-ALS -- 5 Ritter Dr Millsboro 19966 -- XST: School Ln & William Dr
{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 32592 Long Neck Rd Millsboro 19966 -- Am Vets -- XST: Lingo Ln & Rudder Rd
{Chief ALT}[STA:91] -- Stroke-ALS -- 26744 John J Williams Hwy Millsboro 19966 -- Suite 6     1st Floor/aqu -- XST: Mount Joy Rd & Piaffe Ln
{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 27690 Devon Dr Millsboro 19966 -- XST: Sandy Dr & Amber Dr
{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 25750 E Wind Dr Millsboro 19966 -- XST: Ridgewood Rd & Gull Dr S
{Chief ALT}[STA:91] -- Interfacillity/palliative-ALS -- 26002 John J Williams Hwy Millsboro 19966 -- Renaissance Healthcare Fe -- XST: Timber Acres Cir & Plaza Dr
{Chief ALT}[STA:91] -- Stroke-ALS -- 23 Falcon Crest Dr Harbeson 19951 -- XST: Walls St & Walls St
{Chief ALT}[STA:91] -- Breathing Problems-ALS -- 26021 Redwing Ln Millsboro 19966 -- XST: Seahawk Ln & Bay Blvd
{Chief ALT}[STA:91] -- Breathing Problems-ALS -- 27548 Mayfield Rd Millsboro 19966 -- XST: Victorias Landing Rd & Devonshire Rd
{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 25753 E Wind Dr Millsboro 19966 -- XST: Ridgewood Rd & Gull Dr S
{Chief ALT}[STA:91] -- Unconscious/fainting(near)-ALS -- 35001 Starboard Ct Millsboro 19966 -- XST: Flying Bridge Ct & Portside Ln
{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 33035 Castaway Cir Millsboro 19966 -- Castaway Cove -- XST: Scenic Cove & Dead End
{Chief ALT}[STA:91] -- Falls-BLS -- 27690 Devon Dr Millsboro 19966 -- XST: Sandy Dr & Amber Dr
{Chief ALT}[STA:91] -- Chest Pain-ALS -- 27402 Sandpebble Dr S Millsboro 19966 -- XST: Driftwood Vlg & Dead End
{Chief ALT}[STA:91] -- Breathing Problems-ALS -- 34642 Gunnel Rd Millsboro 19966 -- XST: Easy St & Fleet St
{Chief ALT}[STA:91] -- Diabetic Problems-BLS -- 1 Arrowhead Trl Millsboro 19966 -- XST: John J Williams Hwy & Tecumseh Pass
{Chief ALT}[STA:91] -- Unconscious/fainting(near)-ALS -- 28334 Wynikako Ave Millsboro 19966 -- XST: Dead End & North Ave
{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 26597 Whitewater Cove Millsboro 19966 -- XST: Creekwood Cir & Dead End

 */

public class DESussexCountyAParserTest extends BaseParserTest {
  
  public DESussexCountyAParserTest() {
    setParser(new DESussexCountyAParser(), "SUSSEX COUNTY", "DE");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
    		"[86 EMS] -- 31C2 -- 33384 Hartford Ct Lewes",
    		"SRC:86 EMS",
    		"CALL:31C2",
    		"ADDR:33384 Hartford Ct",
    		"CITY:Lewes"
    		);
    doTest("T2",
    		"[86 EMS] -- 33A1 -- 36101 Seaside Blvd Rehoboth",
        "SRC:86 EMS",
    		"CALL:33A1",
    		"ADDR:36101 Seaside Blvd",
    		"CITY:Rehoboth"
    		);
    doTest("T3",
        "[86 EMS] -- 17A1 -- 18958 Coastal Hwy Lewes",
        "SRC:86 EMS",
        "CALL:17A1",
        "ADDR:18958 Coastal Hwy",
        "CITY:Lewes"
        );
    doTest("T4",
    		"[86 Fire] -- F - Auto Fire Alarm -- Hallmark, Parcel Post, Safeway -- 19266 Coastal Hwy Rehoboth -- INC #602",
        "SRC:86 Fire",
    		"CALL:F - Auto Fire Alarm",
    		"ADDR:19266 Coastal Hwy",
    		"CITY:Rehoboth",
    		"PLACE:Hallmark, Parcel Post, Safeway"
    		);
    doTest("T5",
        "[86 Fire] -- F - Standby -- Bethany Beach Station 70 Rehoboth Beach -- INC #599",
        "SRC:86 Fire",
        "CALL:F - Standby",
        "ADDR:Bethany Beach Station 70",
        "CITY:Rehoboth Beach"
        );
    doTest("T6",
    		"[83 FIRE] -- Traffic/TransportationAcdntALS -- 228 W Dupont Hwy Millsboro 19966 -- Food Lion (83)",
        "SRC:83 FIRE",
    		"CALL:Traffic/TransportationAcdntALS",
    		"ADDR:228 W Dupont Hwy",
    		"CITY:Millsboro",
    		"PLACE:Food Lion (83)"
    		);
    doTest("T7",
        "[83 FIRE] -- Vehicle Fire -- 26026 Patriots Way Georgetown 19947 -- Sussex Central High School",
        "SRC:83 FIRE",
        "CALL:Vehicle Fire",
        "ADDR:26026 Patriots Way",
        "CITY:Georgetown",
        "PLACE:Sussex Central High School"
        );
    doTest("T8",
        "[83 FIRE] -- Carbon Monoxide Detector -- 28 Patterson Dr Georgetown 19947",
        "SRC:83 FIRE",
        "CALL:Carbon Monoxide Detector",
        "ADDR:28 Patterson Dr",
        "CITY:Georgetown"
        );
    doTest("T9",
        "[83 FIRE] -- Washdown (Fuel Spill) -- 26972 - 28044 Zoar Rd Georgetown 19947",
        "SRC:83 FIRE",
        "CALL:Washdown (Fuel Spill)",
        "ADDR:26972 - 28044 Zoar Rd",
        "MADDR:26972 Zoar Rd",
        "CITY:Georgetown"
        );
    doTest("T10",
        "[83 FIRE] -- Traffic/TransportationAcdntBLS -- 0 Dupont Blvd & Av Of Honor Georgetown 19947",
        "SRC:83 FIRE",
        "CALL:Traffic/TransportationAcdntBLS",
        "ADDR:Dupont Blvd & Av Of Honor",
        "MADDR:Dupont Blvd & Ave Of Honor",
        "CITY:Georgetown"
        );
    doTest("T11",
    		"[83 FIRE] -- Structure Fire -- 0 JOHNSON RD & JESTICE FARM RD Laurel 19956",
        "SRC:83 FIRE",
    		"CALL:Structure Fire",
    		"ADDR:JOHNSON RD & JESTICE FARM RD",
    		"CITY:Laurel"
    		);
    doTest("T12",
        "[83 FIRE] -- Cardiac/Resp./Death-ALS -- 28723 Woodcrest Dr Harbeson 19951",
        "SRC:83 FIRE",
        "CALL:Cardiac/Resp./Death-ALS",
        "ADDR:28723 Woodcrest Dr",
        "CITY:Harbeson"
        );
    
    doTest("T13",
        "[81 FIRE] -- Traffic/TransportaionAcdntBLS -- 0 Discount Land Rd & Sussex Hw",
        "SRC:81 FIRE",
        "CALL:Traffic/TransportaionAcdntBLS",
        "ADDR:Discount Land Rd & Sussex Hw",
        "MADDR:Discount Land Rd & Sussex Hwy"
        );
    doTest("T14",
        "[81 EMS] -- Chest Pain-ALS -- 34544 Doe Dr Laurel 19956",
        "SRC:81 EMS",
        "CALL:Chest Pain-ALS",
        "ADDR:34544 Doe Dr",
        "CITY:Laurel"
        );
    doTest("T15",
        "[81 FIRE] -- Cardiac/Res./Death-ALS -- 815 S Central Ave Laurel 19956 -- Laurel Middle / intermediate n",
        "SRC:81 FIRE",
        "CALL:Cardiac/Res./Death-ALS",
        "PLACE:Laurel Middle / intermediate n",
        "ADDR:815 S Central Ave",
        "CITY:Laurel"
        );
    doTest("T16",
        "[81 EMS] -- Abdominal Pain-BLS -- 30594 SUssex Hwy Laurel 19956 -- Relax Inn",
        "SRC:81 EMS",
        "CALL:Abdominal Pain-BLS",
        "ADDR:30594 SUssex Hwy",
        "CITY:Laurel",
        "PLACE:Relax Inn"
        );
    doTest("T17",
        "[81 EMS] -- Unconcious/Fainting(Near)-ALS -- 31574 White Ave Laurel 19956",
        "SRC:81 EMS",
        "CALL:Unconcious/Fainting(Near)-ALS",
        "ADDR:31574 White Ave",
        "CITY:Laurel"
        );
    doTest("T18",
        "[81 EMS] -- Falls-BLS -- 609 Little Creek Dr Laurel 19956",
        "SRC:81 EMS",
        "CALL:Falls-BLS",
        "ADDR:609 Little Creek Dr",
        "CITY:Laurel"
        );
  }
  
  @Test
  public void testSeaford() {
    doTest("T1",
        "[87 EMS] -- 1A Abdominal Pains (ALS) -- 6412 Woodduck Dr Seaford de, 19973",
        "SRC:87 EMS",
        "CALL:1A Abdominal Pains (ALS)",
        "ADDR:6412 Woodduck Dr",
        "CITY:Seaford"
        );
    doTest("T2",
        "[87 FIRE] -- Smoke Investigation -- 6341 Baker Rd Seaford de, 19973",
        "SRC:87 FIRE",
        "CALL:Smoke Investigation",
        "ADDR:6341 Baker Rd",
        "CITY:Seaford"
        );
    doTest("T3",
        "[87 EMS] -- 6A Breathing Problems (ALS) -- 24642 Shufelt Rd Seaford de, 19973",
        "SRC:87 EMS",
        "CALL:6A Breathing Problems (ALS)",
        "ADDR:24642 Shufelt Rd",
        "CITY:Seaford"
        );
    doTest("T4",
        "[87 FIRE] -- Assist Other Agency -- Hickory Hill Rd/ Guard Rd Seaford de, 19973",
        "SRC:87 FIRE",
        "CALL:Assist Other Agency",
        "ADDR:Hickory Hill Rd & Guard Rd",
        "CITY:Seaford"
        );
    doTest("T5",
        "[87 EMS] -- 33A Interfacility (ALS) -- 715 E King St 204a Seaford de, 19973",
        "SRC:87 EMS",
        "CALL:33A Interfacility (ALS)",
        "ADDR:715 E King St 204a",
        "CITY:Seaford"
        );
    doTest("T6",
        "[87 EMS] -- 13A Diabetic Problems (ALS) -- 24101 Dove Rd Seaford de, 19973",
        "SRC:87 EMS",
        "CALL:13A Diabetic Problems (ALS)",
        "ADDR:24101 Dove Rd",
        "CITY:Seaford"
        );
    
    doTest("T7",
        "(Chief ALT) [82 EMS] -- Medical Alert -- 18240 Robinsonville Rd Lewes 19958 -- Gosling Creek Purchase/ 123 Ha",
        "SRC:82 EMS",
        "CALL:Medical Alert",
        "ADDR:18240 Robinsonville Rd",
        "CITY:Lewes",
        "PLACE:Gosling Creek Purchase/ 123 Ha");

    doTest("T8",
        "(Chief ALT) [82 EMS] -- Interfacillity/Palliative-ALS -- 36101 Seaside Blvd Rehoboth Beach 19971 -- Brandywine Assisted Living",
        "SRC:82 EMS",
        "CALL:Interfacillity/Palliative-ALS",
        "ADDR:36101 Seaside Blvd",
        "CITY:Rehoboth Beach",
        "PLACE:Brandywine Assisted Living");

    doTest("T9",
        "Subject:Chief ALT\n[71 EMS] -- Assault/Sexual Assault-ALS -- 25687 Cornelia St Seaford 19973\n",
        "SRC:71 EMS",
        "CALL:Assault/Sexual Assault-ALS",
        "ADDR:25687 Cornelia St",
        "CITY:Seaford");
    
  }
  
  
  @Test
  public void testparser2() {

    doTest("T1",
        "[STA:91] -- Unknown Problem(Man Down)-BLS -- 31905 Long Neck Rd Millsboro 19966 -- Wilmington Trust Company",
        "SRC:STA:91",
        "CALL:Unknown Problem(Man Down)-BLS",
        "ADDR:31905 Long Neck Rd",
        "CITY:Millsboro",
        "PLACE:Wilmington Trust Company");

    doTest("T2",
        "[STA:91] -- Breathing Problems-ALS -- 32523 E Baltimore Ct Millsboro 19966",
        "SRC:STA:91",
        "CALL:Breathing Problems-ALS",
        "ADDR:32523 E Baltimore Ct",
        "CITY:Millsboro");

    doTest("T3",
        "[STA:91] -- Falls-BLS -- 0 Long Neck Rd & School Ln Millsboro 19966 -- NO IDEA",
        "SRC:STA:91",
        "CALL:Falls-BLS",
        "ADDR:Long Neck Rd & School Ln",
        "CITY:Millsboro",
        "PLACE:NO IDEA");

    doTest("T4",
        "[STA:91] -- Convulsions/Seizures-BLS -- 32532 Long Neck Rd Millsboro 19966 -- Lingo Creek Apt",
        "SRC:STA:91",
        "CALL:Convulsions/Seizures-BLS",
        "ADDR:32532 Long Neck Rd",
        "CITY:Millsboro",
        "PLACE:Lingo Creek Apt");
    
  }
  
  
  @Test
  public void testSeanHumphries() {

    doTest("T1",
        "(Chief ALT) [86 EMS] -- 1C6 -- 1 Sconset Ct Rehoboth Beach",
        "SRC:86 EMS",
        "CALL:1C6",
        "ADDR:1 Sconset Ct",
        "CITY:Rehoboth Beach");

    doTest("T2",
        "(Chief ALT) [86 EMS] -- 26C2 -- 36121 Knight St Rehoboth Beach",
        "SRC:86 EMS",
        "CALL:26C2",
        "ADDR:36121 Knight St",
        "CITY:Rehoboth Beach");

    doTest("T3",
        "(Chief ALT) [86 EMS] -- 5A1 -- 35645 Buttermilk Dr ASPEN MEADOWS",
        "SRC:86 EMS",
        "CALL:5A1",
        "ADDR:35645 Buttermilk Dr",
        "CITY:REHOBOTH BEACH",
        "PLACE:ASPEN MEADOWS");

    doTest("T4",
        "(Chief ALT) [86 EMS] -- 32B2 -- 36299 Shady Dr SHADY GROVE",
        "SRC:86 EMS",
        "CALL:32B2",
        "ADDR:36299 Shady Dr",
        "CITY:REHOBOTH BEACH",
        "PLACE:SHADY GROVE");

  }
  
  @Test
  public void testcmr199182() {

    doTest("T1",
        "(Chief ALT) [82 EMS] -- Medical Alert -- 18240 Robinsonville Rd Lewes 19958 -- Gosling Creek Purchase/ 123 Ha",
        "SRC:82 EMS",
        "CALL:Medical Alert",
        "ADDR:18240 Robinsonville Rd",
        "CITY:Lewes",
        "PLACE:Gosling Creek Purchase/ 123 Ha");

    doTest("T2",
        "(Chief ALT) [82 EMS] -- Interfacillity/Palliative-ALS -- 36101 Seaside Blvd Rehoboth Beach 19971 -- Brandywine Assisted Living",
        "SRC:82 EMS",
        "CALL:Interfacillity/Palliative-ALS",
        "ADDR:36101 Seaside Blvd",
        "CITY:Rehoboth Beach",
        "PLACE:Brandywine Assisted Living");
   
  }
  
  
  @Test
  public void testLewTalley() {

    doTest("T1",
        "(Chief ALT) [83 FIRE] -- Outside Fire -- 24322 - 24557 Godwin Scho Millsboro 19966 -- XST: Revel Rd & Belmont Blvd",
        "SRC:83 FIRE",
        "CALL:Outside Fire",
        "ADDR:24322 - 24557 Godwin Scho",
        "MADDR:24322 Godwin Scho",
        "CITY:Millsboro",
        "PLACE:XST: Revel Rd & Belmont Blvd");
   
  }
  
  @Test
  public void testCignotis7() {

    doTest("T1",
        "Subject:Chief ALT\n[71 EMS] -- Assault/Sexual Assault-ALS -- 25687 Cornelia St Seaford 19973\n",
        "SRC:71 EMS",
        "CALL:Assault/Sexual Assault-ALS",
        "ADDR:25687 Cornelia St",
        "CITY:Seaford");
   
  }
  
  @Test
  public void testMisSussexRescue() {

    doTest("T1",
        "{Chief ALT}[STA:91] -- Chest Pain-ALS -- 32976 Anglers Cove Millsboro 19966 -- XST: Castaway Cir & Dead End",
        "SRC:STA:91",
        "CALL:Chest Pain-ALS",
        "ADDR:32976 Anglers Cove",
        "CITY:Millsboro",
        "PLACE:XST: Castaway Cir & Dead End");

    doTest("T2",
        "{Chief ALT}[STA:91] -- Unknown Problem(man Down)-BLS -- 26155 Tucks Rd Millsboro 19966 -- XST: Abby Way & Sherwood Frst",
        "SRC:STA:91",
        "CALL:Unknown Problem(man Down)-BLS",
        "ADDR:26155 Tucks Rd",
        "CITY:Millsboro",
        "PLACE:XST: Abby Way & Sherwood Frst");

    doTest("T3",
        "{Chief ALT}[STA:91] -- Chest Pain-ALS -- 5 Ritter Dr Millsboro 19966 -- XST: School Ln & William Dr",
        "SRC:STA:91",
        "CALL:Chest Pain-ALS",
        "ADDR:5 Ritter Dr",
        "CITY:Millsboro",
        "PLACE:XST: School Ln & William Dr");

    doTest("T4",
        "{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 32592 Long Neck Rd Millsboro 19966 -- Am Vets -- XST: Lingo Ln & Rudder Rd",
        "SRC:STA:91",
        "CALL:Sick Person(specific Diag)-BLS",
        "ADDR:32592 Long Neck Rd",
        "CITY:Millsboro",
        "PLACE:Am Vets");

    doTest("T5",
        "{Chief ALT}[STA:91] -- Stroke-ALS -- 26744 John J Williams Hwy Millsboro 19966 -- Suite 6     1st Floor/aqu -- XST: Mount Joy Rd & Piaffe Ln",
        "SRC:STA:91",
        "CALL:Stroke-ALS",
        "ADDR:26744 John J Williams Hwy",
        "CITY:Millsboro",
        "PLACE:Suite 6     1st Floor/aqu");

    doTest("T6",
        "{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 27690 Devon Dr Millsboro 19966 -- XST: Sandy Dr & Amber Dr",
        "SRC:STA:91",
        "CALL:Sick Person(specific Diag)-BLS",
        "ADDR:27690 Devon Dr",
        "CITY:Millsboro",
        "PLACE:XST: Sandy Dr & Amber Dr");

    doTest("T7",
        "{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 25750 E Wind Dr Millsboro 19966 -- XST: Ridgewood Rd & Gull Dr S",
        "SRC:STA:91",
        "CALL:Sick Person(specific Diag)-BLS",
        "ADDR:25750 E Wind Dr",
        "CITY:Millsboro",
        "PLACE:XST: Ridgewood Rd & Gull Dr S");

    doTest("T8",
        "{Chief ALT}[STA:91] -- Interfacillity/palliative-ALS -- 26002 John J Williams Hwy Millsboro 19966 -- Renaissance Healthcare Fe -- XST: Timber Acres Cir & Plaza Dr",
        "SRC:STA:91",
        "CALL:Interfacillity/palliative-ALS",
        "ADDR:26002 John J Williams Hwy",
        "CITY:Millsboro",
        "PLACE:Renaissance Healthcare Fe");

    doTest("T9",
        "{Chief ALT}[STA:91] -- Stroke-ALS -- 23 Falcon Crest Dr Harbeson 19951 -- XST: Walls St & Walls St",
        "SRC:STA:91",
        "CALL:Stroke-ALS",
        "ADDR:23 Falcon Crest Dr",
        "CITY:Harbeson",
        "PLACE:XST: Walls St & Walls St");

    doTest("T10",
        "{Chief ALT}[STA:91] -- Breathing Problems-ALS -- 26021 Redwing Ln Millsboro 19966 -- XST: Seahawk Ln & Bay Blvd",
        "SRC:STA:91",
        "CALL:Breathing Problems-ALS",
        "ADDR:26021 Redwing Ln",
        "CITY:Millsboro",
        "PLACE:XST: Seahawk Ln & Bay Blvd");

    doTest("T11",
        "{Chief ALT}[STA:91] -- Breathing Problems-ALS -- 27548 Mayfield Rd Millsboro 19966 -- XST: Victorias Landing Rd & Devonshire Rd",
        "SRC:STA:91",
        "CALL:Breathing Problems-ALS",
        "ADDR:27548 Mayfield Rd",
        "CITY:Millsboro",
        "PLACE:XST: Victorias Landing Rd & Devonshire Rd");

    doTest("T12",
        "{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 25753 E Wind Dr Millsboro 19966 -- XST: Ridgewood Rd & Gull Dr S",
        "SRC:STA:91",
        "CALL:Sick Person(specific Diag)-BLS",
        "ADDR:25753 E Wind Dr",
        "CITY:Millsboro",
        "PLACE:XST: Ridgewood Rd & Gull Dr S");

    doTest("T13",
        "{Chief ALT}[STA:91] -- Unconscious/fainting(near)-ALS -- 35001 Starboard Ct Millsboro 19966 -- XST: Flying Bridge Ct & Portside Ln",
        "SRC:STA:91",
        "CALL:Unconscious/fainting(near)-ALS",
        "ADDR:35001 Starboard Ct",
        "CITY:Millsboro",
        "PLACE:XST: Flying Bridge Ct & Portside Ln");

    doTest("T14",
        "{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 33035 Castaway Cir Millsboro 19966 -- Castaway Cove -- XST: Scenic Cove & Dead End",
        "SRC:STA:91",
        "CALL:Sick Person(specific Diag)-BLS",
        "ADDR:33035 Castaway Cir",
        "CITY:Millsboro",
        "PLACE:Castaway Cove");

    doTest("T15",
        "{Chief ALT}[STA:91] -- Falls-BLS -- 27690 Devon Dr Millsboro 19966 -- XST: Sandy Dr & Amber Dr",
        "SRC:STA:91",
        "CALL:Falls-BLS",
        "ADDR:27690 Devon Dr",
        "CITY:Millsboro",
        "PLACE:XST: Sandy Dr & Amber Dr");

    doTest("T16",
        "{Chief ALT}[STA:91] -- Chest Pain-ALS -- 27402 Sandpebble Dr S Millsboro 19966 -- XST: Driftwood Vlg & Dead End",
        "SRC:STA:91",
        "CALL:Chest Pain-ALS",
        "ADDR:27402 Sandpebble Dr S",
        "CITY:Millsboro",
        "PLACE:XST: Driftwood Vlg & Dead End");

    doTest("T17",
        "{Chief ALT}[STA:91] -- Breathing Problems-ALS -- 34642 Gunnel Rd Millsboro 19966 -- XST: Easy St & Fleet St",
        "SRC:STA:91",
        "CALL:Breathing Problems-ALS",
        "ADDR:34642 Gunnel Rd",
        "CITY:Millsboro",
        "PLACE:XST: Easy St & Fleet St");

    doTest("T18",
        "{Chief ALT}[STA:91] -- Diabetic Problems-BLS -- 1 Arrowhead Trl Millsboro 19966 -- XST: John J Williams Hwy & Tecumseh Pass",
        "SRC:STA:91",
        "CALL:Diabetic Problems-BLS",
        "ADDR:1 Arrowhead Trl",
        "CITY:Millsboro",
        "PLACE:XST: John J Williams Hwy & Tecumseh Pass");

    doTest("T19",
        "{Chief ALT}[STA:91] -- Unconscious/fainting(near)-ALS -- 28334 Wynikako Ave Millsboro 19966 -- XST: Dead End & North Ave",
        "SRC:STA:91",
        "CALL:Unconscious/fainting(near)-ALS",
        "ADDR:28334 Wynikako Ave",
        "CITY:Millsboro",
        "PLACE:XST: Dead End & North Ave");

    doTest("T20",
        "{Chief ALT}[STA:91] -- Sick Person(specific Diag)-BLS -- 26597 Whitewater Cove Millsboro 19966 -- XST: Creekwood Cir & Dead End",
        "SRC:STA:91",
        "CALL:Sick Person(specific Diag)-BLS",
        "ADDR:26597 Whitewater Cove",
        "CITY:Millsboro",
        "PLACE:XST: Creekwood Cir & Dead End");

  }
  
  public static void main(String[] args) {
    new DESussexCountyAParserTest().generateTests("T1");
  }
}
    		