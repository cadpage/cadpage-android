package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
King County, WA
Contact: Active911
Agency name: King County FPD#50
Location: Skykomish, WA, United States
Sender: CAD@bellevuewa.gov

92701 Stevens Pass Hwy                            #          Aid - Emergency               A295      A295
19426 636th Ave Ne                                #          Aid - Emergency               A296      A295,A296,A296,295ST,SPM54
141 Old Cascade Hwy E                             #          Aid - Emergency               A295      A295
107 W Cascade Hwy                                 #          Cardiac Arrest                R295      A295,R295,CMD50,SPM54
75723 Ne 122nd St                                 #          Aid - Emergency               A295      A295
540 Sky Ln                                        #          Smoke - Residence             R295      R295,E295
82200 Stevens Pass Hwy                            #          Aid - Emergency               A295A     A295A,A295
107 W Cascade Hwy                                 #          Test Call                     E295      E295
102 6th St N                                      #          Aid - Emergency               A295      A295
93900 Stevens Pass Hwy                            #          Smoke - Haze In The Area      E295A     E295A,R295,E295
7000 Ne Money Creek Rd                            #          Smoke - Burn Complaint        E295      E295
66700 Stevens Pass Hwy                            #          Smoke - Haze In The Area      E296      E296,R295
63501 Stevens Pass Hwy                            #          Smoke - Haze In The Area      E295A     E295A,E296,R295
69500 - 69999 Ne Money Creek Rd                   #          Brush - Fire                  E295A     E295A,R295,CMD50,E295
512 Railroad Ave E                                #          Aid - Emergency               A295      A295
0 Nfd 65 Rd                                       #          Smoke - Haze In The Area      E295      R295,E295
92701 Stevens Pass Hwy                            #          Aid - Emergency               A295      A295
63620 Ne 194th Pl                                 #          Aid - Emergency               A295      A295,A296,295ST

Contact: Active911
Agency name: Eastside Fire  Rescue
Location: Issaquah, WA, United States
Sender: CAD@bellevuewa.gov

2436 34th Ave Ne                                  #          ISSAQUAH                           Cardiac Arrest                FTAC2     M14,73ST,B71,E71,A83,MSO5
22975 Se Black Nugget Rd                          #456       ISSAQUAH                           Aid - Emergency               FTAC1     A73
33700 Wb90 West Of Sr18                           #          KING COUNTY                        MVA - Aid Emergency           FTAC2     E281,A87,71ST,B71,L73,A74
100 Timber Ridge Way Nw                           #2103      ISSAQUAH                           AFA - Multi-Family            FTAC2     E72,B71,E71,L73,E8
22975 Se Black Nugget Rd                          #140       ISSAQUAH                           Aid - Emergency               FTAC1     A73
1615 Bendigo Blvd N                               #          NORTH BEND                         AFA - Commercial              FTAC1     L87,L73
705 Rainier Blvd N                                #          ISSAQUAH                           Cardiac Arrest                FTAC1     B71,E71,A72,M14,MSO5
2548 Longmire Ct Ne                               #          ISSAQUAH                           Service Call - Fire           FTAC1     L73
24014 Se 46th Pl                                  #          KING COUNTY                        Aid - Emergency               FTAC1     83ST,A73
34400 WB90                                        #          KING COUNTY                        Vehicle - Fire                FTAC2     B71,L87
317 Nw Gilman Blvd                                #37        ISSAQUAH                           AFA - Commercial              FTAC2     E71,L73
5504 231st Ave Se                                 #          ISSAQUAH                           Aid - Emergency               FTAC1     A73
30816 Se 86th St                                  #          KING COUNTY                        Structure Fire - Residential  FTAC2     74ST,B71,E71,E271,E72,L73,AU81,A75
30816 Se 86th St                                  #          KING COUNTY                        Structure Fire - Residential  FTAC2     74ST,B71,E71,E271,E72,L73,AU81,A75
22975 Se Black Nugget Rd                          #207       ISSAQUAH                           Aid - Emergency               FTAC1     A73
650 1st Ave Ne                                    #99        ISSAQUAH                           Cardiac Arrest                FTAC3     A71,B71,E72,M14,MSO5
14238 442nd Ave SE                                #          KING COUNTY                        Aid - Emergency               FTAC1     L87,B71
8300 304th Ave Se                                 #          KING COUNTY                        AFA - Commercial              FTAC1     E71,L73,E74
1907 Ne Park Dr                                   #          ISSAQUAH                           Aid - Emergency               FTAC1     A73
22975 Se Black Nugget Rd                          #228       ISSAQUAH                           Aid - Emergency               FTAC1     A73

*/

public class WAKingCountyAParserTest extends BaseParserTest {
  
  public WAKingCountyAParserTest() {
    setParser(new WAKingCountyAParser(), "KING COUNTY", "WA");
  }
  
  @Test
  public void testKingCountyFPD50() {

    doTest("T1",
        "92701 Stevens Pass Hwy                            #          Aid - Emergency               A295      A295",
        "ADDR:92701 Stevens Pass Hwy",
        "CALL:Aid - Emergency",
        "UNIT:A295");

    doTest("T2",
        "19426 636th Ave Ne                                #          Aid - Emergency               A296      A295,A296,A296,295ST,SPM54",
        "ADDR:19426 636th Ave Ne",
        "CALL:Aid - Emergency",
        "UNIT:A295,A296,A296,295ST,SPM54");

    doTest("T3",
        "141 Old Cascade Hwy E                             #          Aid - Emergency               A295      A295",
        "ADDR:141 Old Cascade Hwy E",
        "CALL:Aid - Emergency",
        "UNIT:A295");

    doTest("T4",
        "107 W Cascade Hwy                                 #          Cardiac Arrest                R295      A295,R295,CMD50,SPM54",
        "ADDR:107 W Cascade Hwy",
        "CALL:Cardiac Arrest",
        "UNIT:A295,R295,CMD50,SPM54");

    doTest("T5",
        "75723 Ne 122nd St                                 #          Aid - Emergency               A295      A295",
        "ADDR:75723 Ne 122nd St",
        "CALL:Aid - Emergency",
        "UNIT:A295");

    doTest("T6",
        "540 Sky Ln                                        #          Smoke - Residence             R295      R295,E295",
        "ADDR:540 Sky Ln",  // Not mapping
        "CALL:Smoke - Residence",
        "UNIT:R295,E295");

    doTest("T7",
        "82200 Stevens Pass Hwy                            #          Aid - Emergency               A295A     A295A,A295",
        "ADDR:82200 Stevens Pass Hwy",
        "CALL:Aid - Emergency",
        "UNIT:A295A,A295");

    doTest("T8",
        "107 W Cascade Hwy                                 #          Test Call                     E295      E295",
        "ADDR:107 W Cascade Hwy",
        "CALL:Test Call",
        "UNIT:E295");

    doTest("T9",
        "102 6th St N                                      #          Aid - Emergency               A295      A295",
        "ADDR:102 6th St N",
        "CALL:Aid - Emergency",
        "UNIT:A295");

    doTest("T10",
        "93900 Stevens Pass Hwy                            #          Smoke - Haze In The Area      E295A     E295A,R295,E295",
        "ADDR:93900 Stevens Pass Hwy",
        "CALL:Smoke - Haze In The Area",
        "UNIT:E295A,R295,E295");

    doTest("T11",
        "7000 Ne Money Creek Rd                            #          Smoke - Burn Complaint        E295      E295",
        "ADDR:7000 Ne Money Creek Rd",
        "CALL:Smoke - Burn Complaint",
        "UNIT:E295");

    doTest("T12",
        "66700 Stevens Pass Hwy                            #          Smoke - Haze In The Area      E296      E296,R295",
        "ADDR:66700 Stevens Pass Hwy",
        "CALL:Smoke - Haze In The Area",
        "UNIT:E296,R295");

    doTest("T13",
        "63501 Stevens Pass Hwy                            #          Smoke - Haze In The Area      E295A     E295A,E296,R295",
        "ADDR:63501 Stevens Pass Hwy",
        "CALL:Smoke - Haze In The Area",
        "UNIT:E295A,E296,R295");

    doTest("T14",
        "69500 - 69999 Ne Money Creek Rd                   #          Brush - Fire                  E295A     E295A,R295,CMD50,E295",
        "ADDR:69500 - 69999 Ne Money Creek Rd",
        "MADDR:69500 Ne Money Creek Rd",
        "CALL:Brush - Fire",
        "UNIT:E295A,R295,CMD50,E295");

    doTest("T15",
        "512 Railroad Ave E                                #          Aid - Emergency               A295      A295",
        "ADDR:512 Railroad Ave E",
        "CALL:Aid - Emergency",
        "UNIT:A295");

    doTest("T16",
        "0 Nfd 65 Rd                                       #          Smoke - Haze In The Area      E295      R295,E295",
        "ADDR:Nfd 65 Rd",
        "CALL:Smoke - Haze In The Area",
        "UNIT:R295,E295");

    doTest("T17",
        "92701 Stevens Pass Hwy                            #          Aid - Emergency               A295      A295",
        "ADDR:92701 Stevens Pass Hwy",
        "CALL:Aid - Emergency",
        "UNIT:A295");

    doTest("T18",
        "63620 Ne 194th Pl                                 #          Aid - Emergency               A295      A295,A296,295ST",
        "ADDR:63620 Ne 194th Pl",
        "CALL:Aid - Emergency",
        "UNIT:A295,A296,295ST");

  }
  
  @Test
  public void testEastsideFireRescue() {

    doTest("T1",
        "2436 34th Ave Ne                                  #          ISSAQUAH                           Cardiac Arrest                FTAC2     M14,73ST,B71,E71,A83,MSO5",
        "ADDR:2436 34th Ave Ne",
        "CITY:ISSAQUAH",
        "CALL:Cardiac Arrest",
        "UNIT:M14,73ST,B71,E71,A83,MSO5");

    doTest("T2",
        "22975 Se Black Nugget Rd                          #456       ISSAQUAH                           Aid - Emergency               FTAC1     A73",
        "ADDR:22975 Se Black Nugget Rd",
        "APT:456",
        "CITY:ISSAQUAH",
        "CALL:Aid - Emergency",
        "UNIT:A73");

    doTest("T3",
        "33700 Wb90 West Of Sr18                           #          KING COUNTY                        MVA - Aid Emergency           FTAC2     E281,A87,71ST,B71,L73,A74",
        "ADDR:33700 Wb90 West Of Sr18",
        "MADDR:33700 Wb90",
        "CITY:KING COUNTY",
        "CALL:MVA - Aid Emergency",
        "UNIT:E281,A87,71ST,B71,L73,A74");

    doTest("T4",
        "100 Timber Ridge Way Nw                           #2103      ISSAQUAH                           AFA - Multi-Family            FTAC2     E72,B71,E71,L73,E8",
        "ADDR:100 Timber Ridge Way Nw",
        "APT:2103",
        "CITY:ISSAQUAH",
        "CALL:AFA - Multi-Family",
        "UNIT:E72,B71,E71,L73,E8");

    doTest("T5",
        "22975 Se Black Nugget Rd                          #140       ISSAQUAH                           Aid - Emergency               FTAC1     A73",
        "ADDR:22975 Se Black Nugget Rd",
        "APT:140",
        "CITY:ISSAQUAH",
        "CALL:Aid - Emergency",
        "UNIT:A73");

    doTest("T6",
        "1615 Bendigo Blvd N                               #          NORTH BEND                         AFA - Commercial              FTAC1     L87,L73",
        "ADDR:1615 Bendigo Blvd N",
        "CITY:NORTH BEND",
        "CALL:AFA - Commercial",
        "UNIT:L87,L73");

    doTest("T7",
        "705 Rainier Blvd N                                #          ISSAQUAH                           Cardiac Arrest                FTAC1     B71,E71,A72,M14,MSO5",
        "ADDR:705 Rainier Blvd N",
        "CITY:ISSAQUAH",
        "CALL:Cardiac Arrest",
        "UNIT:B71,E71,A72,M14,MSO5");

    doTest("T8",
        "2548 Longmire Ct Ne                               #          ISSAQUAH                           Service Call - Fire           FTAC1     L73",
        "ADDR:2548 Longmire Ct Ne",
        "CITY:ISSAQUAH",
        "CALL:Service Call - Fire",
        "UNIT:L73");

    doTest("T9",
        "24014 Se 46th Pl                                  #          KING COUNTY                        Aid - Emergency               FTAC1     83ST,A73",
        "ADDR:24014 Se 46th Pl",
        "CITY:KING COUNTY",
        "CALL:Aid - Emergency",
        "UNIT:83ST,A73");

    doTest("T10",
        "34400 WB90                                        #          KING COUNTY                        Vehicle - Fire                FTAC2     B71,L87",
        "ADDR:34400 WB90",
        "CITY:KING COUNTY",
        "CALL:Vehicle - Fire",
        "UNIT:B71,L87");

    doTest("T11",
        "317 Nw Gilman Blvd                                #37        ISSAQUAH                           AFA - Commercial              FTAC2     E71,L73",
        "ADDR:317 Nw Gilman Blvd",
        "APT:37",
        "CITY:ISSAQUAH",
        "CALL:AFA - Commercial",
        "UNIT:E71,L73");

    doTest("T12",
        "5504 231st Ave Se                                 #          ISSAQUAH                           Aid - Emergency               FTAC1     A73",
        "ADDR:5504 231st Ave Se",
        "CITY:ISSAQUAH",
        "CALL:Aid - Emergency",
        "UNIT:A73");

    doTest("T13",
        "30816 Se 86th St                                  #          KING COUNTY                        Structure Fire - Residential  FTAC2     74ST,B71,E71,E271,E72,L73,AU81,A75",
        "ADDR:30816 Se 86th St",
        "CITY:KING COUNTY",
        "CALL:Structure Fire - Residential",
        "UNIT:74ST,B71,E71,E271,E72,L73,AU81,A75");

    doTest("T14",
        "30816 Se 86th St                                  #          KING COUNTY                        Structure Fire - Residential  FTAC2     74ST,B71,E71,E271,E72,L73,AU81,A75",
        "ADDR:30816 Se 86th St",
        "CITY:KING COUNTY",
        "CALL:Structure Fire - Residential",
        "UNIT:74ST,B71,E71,E271,E72,L73,AU81,A75");

    doTest("T15",
        "22975 Se Black Nugget Rd                          #207       ISSAQUAH                           Aid - Emergency               FTAC1     A73",
        "ADDR:22975 Se Black Nugget Rd",
        "APT:207",
        "CITY:ISSAQUAH",
        "CALL:Aid - Emergency",
        "UNIT:A73");

    doTest("T16",
        "650 1st Ave Ne                                    #99        ISSAQUAH                           Cardiac Arrest                FTAC3     A71,B71,E72,M14,MSO5",
        "ADDR:650 1st Ave Ne",
        "APT:99",
        "CITY:ISSAQUAH",
        "CALL:Cardiac Arrest",
        "UNIT:A71,B71,E72,M14,MSO5");

    doTest("T17",
        "14238 442nd Ave SE                                #          KING COUNTY                        Aid - Emergency               FTAC1     L87,B71",
        "ADDR:14238 442nd Ave SE",
        "CITY:KING COUNTY",
        "CALL:Aid - Emergency",
        "UNIT:L87,B71");

    doTest("T18",
        "8300 304th Ave Se                                 #          KING COUNTY                        AFA - Commercial              FTAC1     E71,L73,E74",
        "ADDR:8300 304th Ave Se",
        "CITY:KING COUNTY",
        "CALL:AFA - Commercial",
        "UNIT:E71,L73,E74");

    doTest("T19",
        "1907 Ne Park Dr                                   #          ISSAQUAH                           Aid - Emergency               FTAC1     A73",
        "ADDR:1907 Ne Park Dr",
        "CITY:ISSAQUAH",
        "CALL:Aid - Emergency",
        "UNIT:A73");

    doTest("T20",
        "22975 Se Black Nugget Rd                          #228       ISSAQUAH                           Aid - Emergency               FTAC1     A73",
        "ADDR:22975 Se Black Nugget Rd",
        "APT:228",
        "CITY:ISSAQUAH",
        "CALL:Aid - Emergency",
        "UNIT:A73");
  
  }
  
  public static void main(String[] args) {
    new WAKingCountyAParserTest().generateTests("T1");
  }
}