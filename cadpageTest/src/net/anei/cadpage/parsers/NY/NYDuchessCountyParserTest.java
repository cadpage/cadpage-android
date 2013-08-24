package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Duchess County, NY
Contact: "corey1193@gmail.com" <corey1193@gmail.com>
Sender: Pleasantvalleyfire@response.spotteddogtech.com

PV-1: PIAA P3|  | SALT POINT TRNPK and DAVID DR , PLEASANT VALLEY, New York |  AUTO ACCIDENT 3 CAR MVA |Cross:| Active
PV-1: Miscellaneous| PV METHODIST CHURCH | 92 MARTIN RD , PLEASANT VALLEY, New York |  5 MO CHILD LOCKED IN RUNNING VEHICLE |Cross:NO
PV-1: PIAA P3|  | TSP S and ROSSWAY RD , PLEASANT VALLEY, New York |  TWO CAR PIAA |Cross:| Active
PV-1: EMS P1|  | 40 LOCUST Avenue , PLEASANT VALLEY, New York |  16 YOM RAPID HEART RATE |Cross:BLACK OAK DR - SHAGBARK AV| Active

*/

public class NYDuchessCountyParserTest extends BaseParserTest {
  
  public NYDuchessCountyParserTest() {
    setParser(new NYDuchessCountyParser(), "DUCHESS COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "PV-1: PIAA P3|  | SALT POINT TRNPK and DAVID DR , PLEASANT VALLEY, New York |  AUTO ACCIDENT 3 CAR MVA |Cross:| Active",
        "SRC:PV-1",
        "CALL:PIAA P3 - AUTO ACCIDENT 3 CAR MVA",
        "ADDR:SALT POINT TRNPK and DAVID DR",
        "MADDR:SALT POINT TRNPK & DAVID DR",
        "CITY:PLEASANT VALLEY",
        "INFO:Active");

    doTest("T2",
        "PV-1: Miscellaneous| PV METHODIST CHURCH | 92 MARTIN RD , PLEASANT VALLEY, New York |  5 MO CHILD LOCKED IN RUNNING VEHICLE |Cross:NO",
        "SRC:PV-1",
        "CALL:Miscellaneous - 5 MO CHILD LOCKED IN RUNNING VEHICLE",
        "PLACE:PV METHODIST CHURCH",
        "ADDR:92 MARTIN RD",
        "CITY:PLEASANT VALLEY",
        "X:NO");

    doTest("T3",
        "PV-1: PIAA P3|  | TSP S and ROSSWAY RD , PLEASANT VALLEY, New York |  TWO CAR PIAA |Cross:| Active",
        "SRC:PV-1",
        "CALL:PIAA P3 - TWO CAR PIAA",
        "ADDR:TSP S and ROSSWAY RD",
        "MADDR:TACONIC STATE PKWY S & ROSSWAY RD",
        "CITY:PLEASANT VALLEY",
        "INFO:Active");

    doTest("T4",
        "PV-1: EMS P1|  | 40 LOCUST Avenue , PLEASANT VALLEY, New York |  16 YOM RAPID HEART RATE |Cross:BLACK OAK DR - SHAGBARK AV| Active",
        "SRC:PV-1",
        "CALL:EMS P1 - 16 YOM RAPID HEART RATE",
        "ADDR:40 LOCUST Avenue",
        "CITY:PLEASANT VALLEY",
        "X:BLACK OAK DR / SHAGBARK AV",
        "INFO:Active");

  }
  
  public static void main(String[] args) {
    new NYDuchessCountyParserTest().generateTests("T1");
  }
}