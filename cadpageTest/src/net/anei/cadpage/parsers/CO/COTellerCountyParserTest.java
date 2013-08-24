package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Teller County, CO
Contact: Active911
Agency name: NE Teller County Fire
Location: Woodland Park, CO, United States

PROB:219 W Dewell Rd                    ADD: Alarm Call                    APT:     LOC:
PROB:1261 Charwest Dr                   ADD: 911 Medical                   APT:     LOC:
PROB:113 E Bowman Ave                   ADD: 911 Medical                   APT:     LOC:
PROB:19600 E Hwy 24                     ADD: 911 Medical                   APT:     LOC:
PROB:100 PANTHER WAY                    ADD: School Check Outside          APT:     LOC:Columbine ElementaryColumbine Elementary
PROB:722 N Walnut St                    ADD: 911 Medical                   APT:     LOC:
PROB:225 S Park                         ADD: 911 Medical                   APT:     LOC:
PROB:300 S Park St                      ADD: Unconscious Person            APT:A7   LOC:
PROB:116 N Elm St                       ADD: 911 Medical                   APT:     LOC:
PROB:300 E Hwy 24                       ADD: 911 Medical                   APT:UNITALOC:
PROB:1040 Sundance St                   ADD: Citizen Contact               APT:     LOC:
PROB:1435 Kings Crown Rd                ADD: 911 Medical                   APT:     LOC:
PROB:E Kelleys Rd/main St               ADD: Traffic Accident              APT:     LOC:
PROB:515 Regent Ln                      ADD: 911 Medical                   APT:     LOC:
PROB:140 Paradise Cir                   ADD: Fraud                         APT:     LOC:Walgreens           Walgreens
PROB:305 E LAKE AVE                     ADD: Suicidal Party                APT:     LOC:
PROB:1360 Masters Dr                    ADD: 911 Medical                   APT:     LOC:
PROB:911 Tamarac Pkwy                   ADD: Test Call                     APT:     LOC:Woodland Park PD    Woodland Park PD
PROB:777 Gold Hill Pl                   ADD: Test Call                     APT:     LOC:City Market         City Market
PROB:555 Chester Ave                    ADD: Test Call                     APT:     LOC:Big O Tires         Big O Tires
PROB:1011 E 24 Hwy                      ADD: Test Call                     APT:     LOC:AUTO ZONE           AUTO ZONE
PROB:151 PANTHER WAY                    ADD: Assist School District        APT:     LOC:WPHS (Woodland Park WPHS (Woodland Park High School SOUTH)
PROB:W Hwy 24 / Walmart                 ADD: 911 Fire                      APT:CALLBLOC:
PROB:300 S Park St                      ADD: Suicidal Party                APT:A12  LOC:
PROB:Autozone                           ADD: 911 Medical                   APT:     LOC:
PROB:911 Tamarac Pkwy                   ADD: Test Call                     APT:     LOC:Woodland Park PD    Woodland Park PD
PROB:1 Test Dr                          ADD: Assist Fire Department        APT:     LOC:Woodland Park PD    Woodland Park PD

Contact: Active911
Agency name: NE Teller County Fire
Location: Woodland Park, CO, United States
Sender: ept@ept911.info

Add:11400 Hwy 24                       Problem:Traffic Accident                   Loc:
Add:11400 24 HWY                                                                    Problem:Citizen Assist
Add:450 Homestead Dr                                                                Problem:Abdominal Pain
Add:3277 Spruce Rd                                                                  Problem:Traffic Accident
Add:440 Cochetopa Rd                                                                Problem:Fire
Add:28548 Hwy 67                                                                    Problem:Fall
Add:Back Side Mt Herman                                                             Problem:Fire
Add:107 Aspen Road                                                                  Problem:Medical
Add:425 Cr 21                                                                       Problem:Medical
Add:1451  Blackfoot Tr                                                              Problem:Hemorrhage/Lacerations
Add:CME Entrance                                                                    Problem:Smoke Report
Add:28564 Hwy 67                                                                    Problem:Smoke Report
Add:1451 Blackfoot Trl                                                              Problem:Breathing Problems
Add:Red Rocks Right Off Hwy 67                                                      Problem:Traffic Accident
Add:3 Miles North Of Wp On Hwy 67                                                   Problem:Smoke Report

 */

public class COTellerCountyParserTest extends BaseParserTest {
  
  public COTellerCountyParserTest() {
    setParser(new COTellerCountyParser(), "TELLER COUNTY", "CO");
  }
  
  @Test
  public void testNETellerCountyFire() {

    doTest("T1",
        "PROB:219 W Dewell Rd                    ADD: Alarm Call                    APT:     LOC:",
        "ADDR:219 W Dewell Rd",
        "CALL:Alarm Call");

    doTest("T2",
        "PROB:1261 Charwest Dr                   ADD: 911 Medical                   APT:     LOC:",
        "ADDR:1261 Charwest Dr",
        "CALL:911 Medical");

    doTest("T3",
        "PROB:113 E Bowman Ave                   ADD: 911 Medical                   APT:     LOC:",
        "ADDR:113 E Bowman Ave",
        "CALL:911 Medical");

    doTest("T4",
        "PROB:19600 E Hwy 24                     ADD: 911 Medical                   APT:     LOC:",
        "ADDR:19600 E Hwy 24",
        "CALL:911 Medical");

    doTest("T5",
        "PROB:100 PANTHER WAY                    ADD: School Check Outside          APT:     LOC:Columbine ElementaryColumbine Elementary",
        "ADDR:100 PANTHER WAY",
        "CALL:School Check Outside",
        "PLACE:Columbine Elementary");

    doTest("T6",
        "PROB:722 N Walnut St                    ADD: 911 Medical                   APT:     LOC:",
        "ADDR:722 N Walnut St",
        "CALL:911 Medical");

    doTest("T7",
        "PROB:225 S Park                         ADD: 911 Medical                   APT:     LOC:",
        "ADDR:225 S Park",
        "CALL:911 Medical");

    doTest("T8",
        "PROB:300 S Park St                      ADD: Unconscious Person            APT:A7   LOC:",
        "ADDR:300 S Park St",
        "CALL:Unconscious Person",
        "APT:A7");

    doTest("T9",
        "PROB:116 N Elm St                       ADD: 911 Medical                   APT:     LOC:",
        "ADDR:116 N Elm St",
        "CALL:911 Medical");

    doTest("T10",
        "PROB:300 E Hwy 24                       ADD: 911 Medical                   APT:UNITALOC:",
        "ADDR:300 E Hwy 24",
        "CALL:911 Medical",
        "APT:UNITA");

    doTest("T11",
        "PROB:1040 Sundance St                   ADD: Citizen Contact               APT:     LOC:",
        "ADDR:1040 Sundance St",
        "CALL:Citizen Contact");

    doTest("T12",
        "PROB:1435 Kings Crown Rd                ADD: 911 Medical                   APT:     LOC:",
        "ADDR:1435 Kings Crown Rd",
        "CALL:911 Medical");

    doTest("T13",
        "PROB:E Kelleys Rd/main St               ADD: Traffic Accident              APT:     LOC:",
        "ADDR:E Kelleys Rd & main St",
        "CALL:Traffic Accident");

    doTest("T14",
        "PROB:515 Regent Ln                      ADD: 911 Medical                   APT:     LOC:",
        "ADDR:515 Regent Ln",
        "CALL:911 Medical");

    doTest("T15",
        "PROB:140 Paradise Cir                   ADD: Fraud                         APT:     LOC:Walgreens           Walgreens",
        "ADDR:140 Paradise Cir",
        "CALL:Fraud",
        "PLACE:Walgreens");

    doTest("T16",
        "PROB:305 E LAKE AVE                     ADD: Suicidal Party                APT:     LOC:",
        "ADDR:305 E LAKE AVE",
        "CALL:Suicidal Party");

    doTest("T17",
        "PROB:1360 Masters Dr                    ADD: 911 Medical                   APT:     LOC:",
        "ADDR:1360 Masters Dr",
        "CALL:911 Medical");

    doTest("T18",
        "PROB:911 Tamarac Pkwy                   ADD: Test Call                     APT:     LOC:Woodland Park PD    Woodland Park PD",
        "ADDR:911 Tamarac Pkwy",
        "CALL:Test Call",
        "PLACE:Woodland Park PD");

    doTest("T19",
        "PROB:777 Gold Hill Pl                   ADD: Test Call                     APT:     LOC:City Market         City Market",
        "ADDR:777 Gold Hill Pl",
        "CALL:Test Call",
        "PLACE:City Market");

    doTest("T20",
        "PROB:555 Chester Ave                    ADD: Test Call                     APT:     LOC:Big O Tires         Big O Tires",
        "ADDR:555 Chester Ave",
        "CALL:Test Call",
        "PLACE:Big O Tires");

    doTest("T21",
        "PROB:1011 E 24 Hwy                      ADD: Test Call                     APT:     LOC:AUTO ZONE           AUTO ZONE",
        "ADDR:1011 E 24 Hwy",
        "MADDR:1011 E Hwy 24",
        "CALL:Test Call",
        "PLACE:AUTO ZONE");

    doTest("T22",
        "PROB:151 PANTHER WAY                    ADD: Assist School District        APT:     LOC:WPHS (Woodland Park WPHS (Woodland Park High School SOUTH)",
        "ADDR:151 PANTHER WAY",
        "CALL:Assist School District",
        "PLACE:WPHS (Woodland Park");

    doTest("T23",
        "PROB:W Hwy 24 / Walmart                 ADD: 911 Fire                      APT:CALLBLOC:",
        "ADDR:W Hwy 24 & Walmart",
        "CALL:911 Fire",
        "APT:CALLB");

    doTest("T24",
        "PROB:300 S Park St                      ADD: Suicidal Party                APT:A12  LOC:",
        "ADDR:300 S Park St",
        "CALL:Suicidal Party",
        "APT:A12");

    doTest("T25",
        "PROB:Autozone                           ADD: 911 Medical                   APT:     LOC:",
        "ADDR:Autozone",
        "CALL:911 Medical");

    doTest("T26",
        "PROB:911 Tamarac Pkwy                   ADD: Test Call                     APT:     LOC:Woodland Park PD    Woodland Park PD",
        "ADDR:911 Tamarac Pkwy",
        "CALL:Test Call",
        "PLACE:Woodland Park PD");

    doTest("T27",
        "PROB:1 Test Dr                          ADD: Assist Fire Department        APT:     LOC:Woodland Park PD    Woodland Park PD",
        "ADDR:1 Test Dr",
        "CALL:Assist Fire Department",
        "PLACE:Woodland Park PD");
    
  }
  
  public void testNETellerCountyFire2() {

    doTest("T1",
        "Add:11400 Hwy 24                       Problem:Traffic Accident                   Loc:",
        "ADDR:11400 Hwy 24",
        "CALL:Traffic Accident");

    doTest("T2",
        "Add:11400 24 HWY                                                                    Problem:Citizen Assist",
        "ADDR:11400 24 HWY",
        "MADDR:11400 HWY 24",
        "CALL:Citizen Assist");

    doTest("T3",
        "Add:450 Homestead Dr                                                                Problem:Abdominal Pain",
        "ADDR:450 Homestead Dr",
        "CALL:Abdominal Pain");

    doTest("T4",
        "Add:3277 Spruce Rd                                                                  Problem:Traffic Accident",
        "ADDR:3277 Spruce Rd",
        "CALL:Traffic Accident");

    doTest("T5",
        "Add:440 Cochetopa Rd                                                                Problem:Fire",
        "ADDR:440 Cochetopa Rd",
        "CALL:Fire");

    doTest("T6",
        "Add:28548 Hwy 67                                                                    Problem:Fall",
        "ADDR:28548 Hwy 67",
        "CALL:Fall");

    doTest("T7",
        "Add:Back Side Mt Herman                                                             Problem:Fire",
        "ADDR:Back Side Mt Herman",
        "CALL:Fire");

    doTest("T8",
        "Add:107 Aspen Road                                                                  Problem:Medical",
        "ADDR:107 Aspen Road",
        "CALL:Medical");

    doTest("T9",
        "Add:425 Cr 21                                                                       Problem:Medical",
        "ADDR:425 Cr 21",
        "MADDR:425 COUNTY ROAD 21",
        "CALL:Medical");

    doTest("T10",
        "Add:1451  Blackfoot Tr                                                              Problem:Hemorrhage/Lacerations",
        "ADDR:1451  Blackfoot Tr",
        "CALL:Hemorrhage/Lacerations");

    doTest("T11",
        "Add:CME Entrance                                                                    Problem:Smoke Report",
        "ADDR:CME Entrance",
        "CALL:Smoke Report");

    doTest("T12",
        "Add:28564 Hwy 67                                                                    Problem:Smoke Report",
        "ADDR:28564 Hwy 67",
        "CALL:Smoke Report");

    doTest("T13",
        "Add:1451 Blackfoot Trl                                                              Problem:Breathing Problems",
        "ADDR:1451 Blackfoot Trl",
        "CALL:Breathing Problems");

    doTest("T14",
        "Add:Red Rocks Right Off Hwy 67                                                      Problem:Traffic Accident",
        "ADDR:Red Rocks Right Off Hwy 67",
        "MADDR:Red Rocks Right & Hwy 67",
        "CALL:Traffic Accident");

    doTest("T15",
        "Add:3 Miles North Of Wp On Hwy 67                                                   Problem:Smoke Report",
        "ADDR:3 Miles North Of Wp On Hwy 67",
        "MADDR:3 Miles",
        "CALL:Smoke Report");

  }
  
  public static void main(String[] args) {
    new COTellerCountyParserTest().generateTests("T1");
  }
}