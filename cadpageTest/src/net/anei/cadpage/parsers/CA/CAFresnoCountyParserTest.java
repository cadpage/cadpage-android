package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Fresno County, CA

Contact: Active911
Agency name: Fresno County EMS Communications Center
Location: Fresno, CA, United States
Sender: VCMail@co.fresno.ca.us

(VisiCad Email) MED-Breathing Problems                  For:T11            Zone: 40588        1670 E Stuart Ave                                 Apt:                Between:N 10TH ST/N CEDAR AVE         Location Name:\r
(VisiCad Email) MED2-Unknown Problem(Man Down)          For:E02            Zone: 41553        5610 N Arthur Ave                                 Apt:                Between:W BROWNING AVE/W CELESTE AVE  Location Name:\r
(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 40527        6175 N Figarden Dr                                Apt:125             Between:W BULLARD AVE/CANYON SPGS     Location Name:\r
(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 40527        6175 N Figarden Dr                                Apt:125             Between:W BULLARD AVE/CANYON SPGS     Location Name:\r
(VisiCad Email) MED-Traffic Accidents                   For:E12            Zone: 41534        N Marks Ave & W Bullard Ave                       Apt:                Between:                              Location Name:\r
(VisiCad Email) *Fire-Vehicle                           For:T11            Zone: 41574        N 1st St & E Bullard Ave                          Apt:                Between:                              Location Name:\r
(VisiCad Email) MED-Breathing Problems                  For:T11            Zone: 42573        5207 N Augusta St                                 Apt:                Between:E SAN JOSE AVE/E SAN BRUNO AVELocation Name:\r
(VisiCad Email) MED-Breathing Problems                  For:E12            Zone: 41531        5770 N Gentry Ave                                 Apt:APT 121         Between:Dead End/W BULLARD AVE        Location Name:Bridgewood Apartments (5770)\r
(VisiCad Email) MED-Traffic Accidents                   For:T11            Zone: 41561        W Bullard Ave & N Palm Ave                        Apt:                Between:                              Location Name:\r
(VisiCad Email) *Alarm-Commercial                       For:E02            Zone: 43532        3567 W Shaw Ave                                   Apt:                Between:N MARTY AVE/PRIVATE DR        Location Name:\r
(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 42513        5425 N Golden State Blvd                          Apt:                Between:N MARKET ST/W BARSTOW AVE     Location Name:\r
(VisiCad Email) *Fire-Vegetation (Small)                For:E12            Zone: 47524        2698 N Brawley Ave                                Apt:                Between:Dead End/W SHIELDS AVE        Location Name:C.L.A.S.S.\r
(VisiCad Email) *Cit Assist-Other                       For:E14            Zone: 40526        4592 W Laurendale Dr                              Apt:                Between:N ALEXIS DR/N STOCKDALE DR    Location Name:\r
(VisiCad Email) MED-Breathing Problems                  For:E12            Zone: 44541        2707 W Indianapolis Ave                           Apt:                Between:N BRIARWOOD AVE/N EMERSON AVE Location Name:\r
(VisiCad Email) *Alarm-Commercial                       For:T11            Zone: 41575        5422 N Blackstone Ave                             Apt:                Between:UNNAMED STREET/E AUTO CENTER DLocation Name:Food Maxx  (Blackstone & Barst\r
(VisiCad Email) MED-Chest Pain                          For:E14            Zone: 42521        5318 N Salinas Ave                                Apt:                Between:Dead End/W SAN JOSE AVE       Location Name:\r
(VisiCad Email) *Alarm-Commercial                       For:T11            Zone: 41576        5555 N Fresno St                                  Apt:                Between:E WRENWOOD LN/E BROWNING AVE  Location Name:The Terraces at San Joaquin Ga\r
(VisiCad Email) MED-Cardiac or Resp Arrest              For:E14            Zone: 39512        5610 W Fremont Ave                                Apt:                Between:N LOLA AVE/N WHEELER AVE      Location Name:\r
(VisiCad Email) MED-Chest Pain                          For:E12            Zone: 43552        4890 N Teilman Ave                                Apt:                Between:W ALAMOS AVE/W FAIRMONT AVE   Location Name:\r
(VisiCad Email) MED-Choking                             For:E12            Zone: 43551        1222 W Sierra Madre Ave                           Apt:                Between:N WEST AVE/N CHANNING AVE     Location Name:\r
(VisiCad Email) MED-Chest Pain                          For:E14            Zone: 37518        5174 W Athens Ave                                 Apt:                Between:N CONSTANCE AVE/W DECATUR AVE Location Name:\r
(VisiCad Email) MED-Traffic Accident Rollover           For:T11            Zone: 32593        E International Ave & N Maple Ave                 Apt:                Between:                              Location Name:\r
(VisiCad Email) *Fire-Apartment                         For:T11            Zone: 45608        3855 N Peach Ave                                  Apt:APT 122         Between:Peach/Ashlan                  Location Name:Valley View Apartments (3855)\r
(VisiCad Email) *Invest-Odor Smoke (Inside)             For:E12            Zone: 39538        6435 N Hazel Ave                                  Apt:                Between:W SIERRA AVE/W MENLO AVE      Location Name:\r
(VisiCad Email) *Cit Assist-Other                       For:T11            Zone: 44581        3215 E Ashcroft Ave                               Apt:121             Between:Dead End/N 1ST ST             Location Name:Woodside Apartments (3215)\r
(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 39526        6538 N Mitre Ave                                  Apt:                Between:W MENLO AVE/W PALO ALTO AVE   Location Name:\r
(VisiCad Email) MED-Breathing Problems                  For:T11            Zone: 43581        1021 E Shaw Ave                                   Apt:                Between:N 1ST ST/N FISHER AVE         Location Name:Shell\r
(VisiCad Email) MED-Breathing Problems                  For:E12            Zone: 39547        6418 N Sequoia Dr                                 Apt:                Between:W SIERRA AVE/W PALO ALTO AVE  Location Name:\r
(VisiCad Email) MED-Traffic Accidents                   For:E02            Zone: 39561        W Herndon Ave & N Palm Ave                        Apt:                Between:                              Location Name:\r
(VisiCad Email) MED-Unconscious/Fainting(Near)          For:T11            Zone: 40577        6062 N Fresno St                                  Apt:                Between:E BULLARD AVE/E CALIMYRNA AVE Location Name:No Name On Complex (6062)\r

// Not parsing (at least not yet)
(VisiCad Email) Apartment Fire - 4853 E University .. Anthony\r
(VisiCad Email) Unit:EMS03,Pri:1, Loc:335 W Cinnamon Dr             ,MapPage:TB1712/J3 ,Apt:158       ,City:Lemoore        ,Nature:*Aircraft Down (Off FYI)      ,Zone:KM06  ,EMS#:201308140167, XStreet:FOX ST/ETON DR                 ,\r
(VisiCad Email) MED-Unconscious/Fainting(Near)          For:Company 69     Dist:NOT FOUND    Address:3086 W Mt Whitney Ave              Apt:                Between:S FELAND AVE/S MARKS AVE                Location Name:\r

 */

public class CAFresnoCountyParserTest extends BaseParserTest {
  
  public CAFresnoCountyParserTest() {
    setParser(new CAFresnoCountyParser(), "FRESNO COUNTY", "CA");
  }
  
  @Test
  public void testFresnoCountyEMSCommunicationsCenter() {

    doTest("T1",
        "(VisiCad Email) MED-Breathing Problems                  For:T11            Zone: 40588        1670 E Stuart Ave                                 Apt:                Between:N 10TH ST/N CEDAR AVE         Location Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:T11",
        "MAP:40588",
        "ADDR:1670 E Stuart Ave",
        "X:N 10TH ST/N CEDAR AVE");

    doTest("T2",
        "(VisiCad Email) MED2-Unknown Problem(Man Down)          For:E02            Zone: 41553        5610 N Arthur Ave                                 Apt:                Between:W BROWNING AVE/W CELESTE AVE  Location Name:",
        "CALL:MED2-Unknown Problem(Man Down)",
        "UNIT:E02",
        "MAP:41553",
        "ADDR:5610 N Arthur Ave",
        "X:W BROWNING AVE/W CELESTE AVE");

    doTest("T3",
        "(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 40527        6175 N Figarden Dr                                Apt:125             Between:W BULLARD AVE/CANYON SPGS     Location Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:E14",
        "MAP:40527",
        "ADDR:6175 N Figarden Dr",
        "APT:125",
        "X:W BULLARD AVE/CANYON SPGS");

    doTest("T4",
        "(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 40527        6175 N Figarden Dr                                Apt:125             Between:W BULLARD AVE/CANYON SPGS     Location Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:E14",
        "MAP:40527",
        "ADDR:6175 N Figarden Dr",
        "APT:125",
        "X:W BULLARD AVE/CANYON SPGS");

    doTest("T5",
        "(VisiCad Email) MED-Traffic Accidents                   For:E12            Zone: 41534        N Marks Ave & W Bullard Ave                       Apt:                Between:                              Location Name:",
        "CALL:MED-Traffic Accidents",
        "UNIT:E12",
        "MAP:41534",
        "ADDR:N Marks Ave & W Bullard Ave");

    doTest("T6",
        "(VisiCad Email) *Fire-Vehicle                           For:T11            Zone: 41574        N 1st St & E Bullard Ave                          Apt:                Between:                              Location Name:",
        "CALL:Fire-Vehicle",
        "UNIT:T11",
        "MAP:41574",
        "ADDR:N 1st St & E Bullard Ave");

    doTest("T7",
        "(VisiCad Email) MED-Breathing Problems                  For:T11            Zone: 42573        5207 N Augusta St                                 Apt:                Between:E SAN JOSE AVE/E SAN BRUNO AVELocation Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:T11",
        "MAP:42573",
        "ADDR:5207 N Augusta St",
        "X:E SAN JOSE AVE/E SAN BRUNO AVE");

    doTest("T8",
        "(VisiCad Email) MED-Breathing Problems                  For:E12            Zone: 41531        5770 N Gentry Ave                                 Apt:APT 121         Between:Dead End/W BULLARD AVE        Location Name:Bridgewood Apartments (5770)",
        "CALL:MED-Breathing Problems",
        "UNIT:E12",
        "MAP:41531",
        "ADDR:5770 N Gentry Ave",
        "APT:121",
        "X:Dead End/W BULLARD AVE",
        "PLACE:Bridgewood Apartments (5770)");

    doTest("T9",
        "(VisiCad Email) MED-Traffic Accidents                   For:T11            Zone: 41561        W Bullard Ave & N Palm Ave                        Apt:                Between:                              Location Name:",
        "CALL:MED-Traffic Accidents",
        "UNIT:T11",
        "MAP:41561",
        "ADDR:W Bullard Ave & N Palm Ave");

    doTest("T10",
        "(VisiCad Email) *Alarm-Commercial                       For:E02            Zone: 43532        3567 W Shaw Ave                                   Apt:                Between:N MARTY AVE/PRIVATE DR        Location Name:",
        "CALL:Alarm-Commercial",
        "UNIT:E02",
        "MAP:43532",
        "ADDR:3567 W Shaw Ave",
        "X:N MARTY AVE/PRIVATE DR");

    doTest("T11",
        "(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 42513        5425 N Golden State Blvd                          Apt:                Between:N MARKET ST/W BARSTOW AVE     Location Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:E14",
        "MAP:42513",
        "ADDR:5425 N Golden State Blvd",
        "X:N MARKET ST/W BARSTOW AVE");

    doTest("T12",
        "(VisiCad Email) *Fire-Vegetation (Small)                For:E12            Zone: 47524        2698 N Brawley Ave                                Apt:                Between:Dead End/W SHIELDS AVE        Location Name:C.L.A.S.S.",
        "CALL:Fire-Vegetation (Small)",
        "UNIT:E12",
        "MAP:47524",
        "ADDR:2698 N Brawley Ave",  // Not mapping
        "X:Dead End/W SHIELDS AVE",
        "PLACE:C.L.A.S.S.");

    doTest("T13",
        "(VisiCad Email) *Cit Assist-Other                       For:E14            Zone: 40526        4592 W Laurendale Dr                              Apt:                Between:N ALEXIS DR/N STOCKDALE DR    Location Name:",
        "CALL:Cit Assist-Other",
        "UNIT:E14",
        "MAP:40526",
        "ADDR:4592 W Laurendale Dr",
        "X:N ALEXIS DR/N STOCKDALE DR");

    doTest("T14",
        "(VisiCad Email) MED-Breathing Problems                  For:E12            Zone: 44541        2707 W Indianapolis Ave                           Apt:                Between:N BRIARWOOD AVE/N EMERSON AVE Location Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:E12",
        "MAP:44541",
        "ADDR:2707 W Indianapolis Ave",
        "X:N BRIARWOOD AVE/N EMERSON AVE");

    doTest("T15",
        "(VisiCad Email) *Alarm-Commercial                       For:T11            Zone: 41575        5422 N Blackstone Ave                             Apt:                Between:UNNAMED STREET/E AUTO CENTER DLocation Name:Food Maxx  (Blackstone & Barst",
        "CALL:Alarm-Commercial",
        "UNIT:T11",
        "MAP:41575",
        "ADDR:5422 N Blackstone Ave",
        "X:UNNAMED STREET/E AUTO CENTER D",
        "PLACE:Food Maxx  (Blackstone & Barst");

    doTest("T16",
        "(VisiCad Email) MED-Chest Pain                          For:E14            Zone: 42521        5318 N Salinas Ave                                Apt:                Between:Dead End/W SAN JOSE AVE       Location Name:",
        "CALL:MED-Chest Pain",
        "UNIT:E14",
        "MAP:42521",
        "ADDR:5318 N Salinas Ave",
        "X:Dead End/W SAN JOSE AVE");

    doTest("T17",
        "(VisiCad Email) *Alarm-Commercial                       For:T11            Zone: 41576        5555 N Fresno St                                  Apt:                Between:E WRENWOOD LN/E BROWNING AVE  Location Name:The Terraces at San Joaquin Ga",
        "CALL:Alarm-Commercial",
        "UNIT:T11",
        "MAP:41576",
        "ADDR:5555 N Fresno St",
        "X:E WRENWOOD LN/E BROWNING AVE",
        "PLACE:The Terraces at San Joaquin Ga");

    doTest("T18",
        "(VisiCad Email) MED-Cardiac or Resp Arrest              For:E14            Zone: 39512        5610 W Fremont Ave                                Apt:                Between:N LOLA AVE/N WHEELER AVE      Location Name:",
        "CALL:MED-Cardiac or Resp Arrest",
        "UNIT:E14",
        "MAP:39512",
        "ADDR:5610 W Fremont Ave",
        "X:N LOLA AVE/N WHEELER AVE");

    doTest("T19",
        "(VisiCad Email) MED-Chest Pain                          For:E12            Zone: 43552        4890 N Teilman Ave                                Apt:                Between:W ALAMOS AVE/W FAIRMONT AVE   Location Name:",
        "CALL:MED-Chest Pain",
        "UNIT:E12",
        "MAP:43552",
        "ADDR:4890 N Teilman Ave",
        "X:W ALAMOS AVE/W FAIRMONT AVE");

    doTest("T20",
        "(VisiCad Email) MED-Choking                             For:E12            Zone: 43551        1222 W Sierra Madre Ave                           Apt:                Between:N WEST AVE/N CHANNING AVE     Location Name:",
        "CALL:MED-Choking",
        "UNIT:E12",
        "MAP:43551",
        "ADDR:1222 W Sierra Madre Ave",
        "X:N WEST AVE/N CHANNING AVE");

    doTest("T21",
        "(VisiCad Email) MED-Chest Pain                          For:E14            Zone: 37518        5174 W Athens Ave                                 Apt:                Between:N CONSTANCE AVE/W DECATUR AVE Location Name:",
        "CALL:MED-Chest Pain",
        "UNIT:E14",
        "MAP:37518",
        "ADDR:5174 W Athens Ave",
        "X:N CONSTANCE AVE/W DECATUR AVE");

    doTest("T22",
        "(VisiCad Email) MED-Traffic Accident Rollover           For:T11            Zone: 32593        E International Ave & N Maple Ave                 Apt:                Between:                              Location Name:",
        "CALL:MED-Traffic Accident Rollover",
        "UNIT:T11",
        "MAP:32593",
        "ADDR:E International Ave & N Maple Ave");

    doTest("T23",
        "(VisiCad Email) *Fire-Apartment                         For:T11            Zone: 45608        3855 N Peach Ave                                  Apt:APT 122         Between:Peach/Ashlan                  Location Name:Valley View Apartments (3855)",
        "CALL:Fire-Apartment",
        "UNIT:T11",
        "MAP:45608",
        "ADDR:3855 N Peach Ave",
        "APT:122",
        "X:Peach/Ashlan",
        "PLACE:Valley View Apartments (3855)");

    doTest("T24",
        "(VisiCad Email) *Invest-Odor Smoke (Inside)             For:E12            Zone: 39538        6435 N Hazel Ave                                  Apt:                Between:W SIERRA AVE/W MENLO AVE      Location Name:",
        "CALL:Invest-Odor Smoke (Inside)",
        "UNIT:E12",
        "MAP:39538",
        "ADDR:6435 N Hazel Ave",
        "X:W SIERRA AVE/W MENLO AVE");

    doTest("T25",
        "(VisiCad Email) *Cit Assist-Other                       For:T11            Zone: 44581        3215 E Ashcroft Ave                               Apt:121             Between:Dead End/N 1ST ST             Location Name:Woodside Apartments (3215)",
        "CALL:Cit Assist-Other",
        "UNIT:T11",
        "MAP:44581",
        "ADDR:3215 E Ashcroft Ave",
        "APT:121",
        "X:Dead End/N 1ST ST",
        "PLACE:Woodside Apartments (3215)");

    doTest("T26",
        "(VisiCad Email) MED-Breathing Problems                  For:E14            Zone: 39526        6538 N Mitre Ave                                  Apt:                Between:W MENLO AVE/W PALO ALTO AVE   Location Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:E14",
        "MAP:39526",
        "ADDR:6538 N Mitre Ave",
        "X:W MENLO AVE/W PALO ALTO AVE");

    doTest("T27",
        "(VisiCad Email) MED-Breathing Problems                  For:T11            Zone: 43581        1021 E Shaw Ave                                   Apt:                Between:N 1ST ST/N FISHER AVE         Location Name:Shell",
        "CALL:MED-Breathing Problems",
        "UNIT:T11",
        "MAP:43581",
        "ADDR:1021 E Shaw Ave",
        "X:N 1ST ST/N FISHER AVE",
        "PLACE:Shell");

    doTest("T28",
        "(VisiCad Email) MED-Breathing Problems                  For:E12            Zone: 39547        6418 N Sequoia Dr                                 Apt:                Between:W SIERRA AVE/W PALO ALTO AVE  Location Name:",
        "CALL:MED-Breathing Problems",
        "UNIT:E12",
        "MAP:39547",
        "ADDR:6418 N Sequoia Dr",
        "X:W SIERRA AVE/W PALO ALTO AVE");

    doTest("T29",
        "(VisiCad Email) MED-Traffic Accidents                   For:E02            Zone: 39561        W Herndon Ave & N Palm Ave                        Apt:                Between:                              Location Name:",
        "CALL:MED-Traffic Accidents",
        "UNIT:E02",
        "MAP:39561",
        "ADDR:W Herndon Ave & N Palm Ave");

    doTest("T30",
        "(VisiCad Email) MED-Unconscious/Fainting(Near)          For:T11            Zone: 40577        6062 N Fresno St                                  Apt:                Between:E BULLARD AVE/E CALIMYRNA AVE Location Name:No Name On Complex (6062)",
        "CALL:MED-Unconscious/Fainting(Near)",
        "UNIT:T11",
        "MAP:40577",
        "ADDR:6062 N Fresno St",
        "X:E BULLARD AVE/E CALIMYRNA AVE",
        "PLACE:No Name On Complex (6062)");

  }
  
  public static void main(String[] args) {
    new CAFresnoCountyParserTest().generateTests("T1");
  }
}