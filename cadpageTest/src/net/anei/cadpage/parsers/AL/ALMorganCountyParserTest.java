package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALMorganCountyParserTest;

import org.junit.Test;


/*
Morgan County, AL
Contact: Chris Phillips <cpffemt@aol.com>
Sender: cad@morgan911.org

CAD:MORGAN CO JAIL 119 LEE ST NE SEIZURES CAT1 CANAL ST NE OAK ST NE 11009615 DFS1
CAD:707-1/2 5TH AV SE UNCONSCIOUS OR SYNCOPE CAT1 PROSPECT DR SE 4TH ST SE DFS1
CAD:404 7TH AV SW TRAUMA WITH INJURY CAT1 1ST ST SW 2ND ST SW 11009612 DFS1
CAD:BETTY ST SW/5TH AV SW SMOKE INVESTIGATION 11009584 DFS1
CAD:1810 MARTIN ST SE UNCONSCIOUS OR SYNCOPE CAT1 18TH AV SE 19TH AV SE 11009594 DFS3
CAD:GORDON DR SW/CENTRAL PKWY SW STRUCTURE FIRE 11009333 DFS1
CAD:1002 15TH AV SW RESIDENTIAL FIRE ALARM DOUTHIT ST SW FAYE ST SW 11011144 DFS1
CAD:400-BLK EVERETT DR SW STRUCTURE FIRE SANDLIN RD SW WILLIAMS ST SW 11011173 DFS6

Contact: James Wakefield <jameswakafield83@gmail.com>
Sender: cad@morgan911.org
CAD:JONES, DYLAN RESIDENCE 2412 KIRBY BRIDGE RD TRAUMA WITH INJURY CAT1 LIBERTY RD TAYLOR ROYER RD 13001576 MTFS

Contact: Active911
Agency name: Mud Tavern Volunteer Fire Rescue Location: Decatur, Al 
Sender: CAD@morgan911.org

224 HAROLD DR UNCONSCIOUS OR SYNCOPE CAT1 MODAUS RD SW MIRIAM PVT DR 12007229 MTFS
72 PARKER ST TRAUMA WITH INJURY CAT2 W CHAPEL HILL RD W CHAPEL HILL RD 12007332 MTFS
77 RUSSELL RD CHEST PAIN CAT1 W CHAPEL HILL RD 12007354 MTFS

*/

public class ALMorganCountyParserTest extends BaseParserTest {
  
  public ALMorganCountyParserTest() {
    setParser(new ALMorganCountyParser(), "MORGAN COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:MORGAN CO JAIL 119 LEE ST NE SEIZURES CAT1 CANAL ST NE OAK ST NE 11009615 DFS1",
        "PLACE:MORGAN CO JAIL",
        "ADDR:119 LEE ST NE",
        "CALL:SEIZURES",
        "PRI:1",
        "X:CANAL ST NE / OAK ST NE",
        "ID:11009615",
        "SRC:DFS1");

    doTest("T2",
        "CAD:707-1/2 5TH AV SE UNCONSCIOUS OR SYNCOPE CAT1 PROSPECT DR SE 4TH ST SE DFS1",
        "ADDR:707-1/2 5TH AV SE",
        "MADDR:707 5TH AVE SE",
        "CALL:UNCONSCIOUS OR SYNCOPE",
        "PRI:1",
        "X:PROSPECT DR SE / 4TH ST SE",
        "SRC:DFS1");

    doTest("T3",
        "CAD:404 7TH AV SW TRAUMA WITH INJURY CAT1 1ST ST SW 2ND ST SW 11009612 DFS1",
        "ADDR:404 7TH AV SW",
        "MADDR:404 7TH AVE SW",
        "CALL:TRAUMA WITH INJURY",
        "PRI:1",
        "X:1ST ST SW / 2ND ST SW",
        "ID:11009612",
        "SRC:DFS1");

    doTest("T4",
        "CAD:BETTY ST SW/5TH AV SW SMOKE INVESTIGATION 11009584 DFS1",
        "ADDR:BETTY ST SW & 5TH AV SW",
        "MADDR:BETTY ST SW & 5TH AVE SW",
        "CALL:SMOKE INVESTIGATION",
        "ID:11009584",
        "SRC:DFS1");

    doTest("T5",
        "CAD:1810 MARTIN ST SE UNCONSCIOUS OR SYNCOPE CAT1 18TH AV SE 19TH AV SE 11009594 DFS3",
        "ADDR:1810 MARTIN ST SE",
        "CALL:UNCONSCIOUS OR SYNCOPE",
        "PRI:1",
        "X:18TH AV SE / 19TH AV SE",
        "ID:11009594",
        "SRC:DFS3");

    doTest("T6",
        "CAD:GORDON DR SW/CENTRAL PKWY SW STRUCTURE FIRE 11009333 DFS1",
        "ADDR:GORDON DR SW & CENTRAL PKWY SW",
        "CALL:STRUCTURE FIRE",
        "ID:11009333",
        "SRC:DFS1");

    doTest("T7",
        "CAD:1002 15TH AV SW RESIDENTIAL FIRE ALARM DOUTHIT ST SW FAYE ST SW 11011144 DFS1",
        "ADDR:1002 15TH AV SW",
        "MADDR:1002 15TH AVE SW",
        "CALL:RESIDENTIAL FIRE ALARM",
        "X:DOUTHIT ST SW / FAYE ST SW",
        "ID:11011144",
        "SRC:DFS1");

    doTest("T8",
        "CAD:400-BLK EVERETT DR SW STRUCTURE FIRE SANDLIN RD SW WILLIAMS ST SW 11011173 DFS6",
        "ADDR:400-BLK EVERETT DR SW",
        "MADDR:400 EVERETT DR SW",
        "CALL:STRUCTURE FIRE",
        "X:SANDLIN RD SW / WILLIAMS ST SW",
        "ID:11011173",
        "SRC:DFS6");

  }
  
  @Test
  public void testJamesWakefield() {

    doTest("T1",
        "CAD:JONES, DYLAN RESIDENCE 2412 KIRBY BRIDGE RD TRAUMA WITH INJURY CAT1 LIBERTY RD TAYLOR ROYER RD 13001576 MTFS",
        "PLACE:JONES, DYLAN RESIDENCE",
        "ADDR:2412 KIRBY BRIDGE RD",
        "CALL:TRAUMA WITH INJURY",
        "PRI:1",
        "X:LIBERTY RD / TAYLOR ROYER RD",
        "ID:13001576",
        "SRC:MTFS");
 
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "224 HAROLD DR UNCONSCIOUS OR SYNCOPE CAT1 MODAUS RD SW MIRIAM PVT DR 12007229 MTFS",
        "ADDR:224 HAROLD DR",
        "CALL:UNCONSCIOUS OR SYNCOPE",
        "PRI:1",
        "X:MODAUS RD / SW MIRIAM PVT DR",
        "ID:12007229",
        "SRC:MTFS");

    doTest("T2",
        "72 PARKER ST TRAUMA WITH INJURY CAT2 W CHAPEL HILL RD W CHAPEL HILL RD 12007332 MTFS",
        "ADDR:72 PARKER ST",
        "CALL:TRAUMA WITH INJURY",
        "PRI:2",
        "X:W CHAPEL HILL RD / W CHAPEL HILL RD",
        "ID:12007332",
        "SRC:MTFS");

    doTest("T3",
        "77 RUSSELL RD CHEST PAIN CAT1 W CHAPEL HILL RD 12007354 MTFS",
        "ADDR:77 RUSSELL RD",
        "CALL:CHEST PAIN",
        "PRI:1",
        "X:W CHAPEL HILL RD",
        "ID:12007354",
        "SRC:MTFS");

  }
  
  public static void main(String[] args) {
    new ALMorganCountyParserTest().generateTests("T1");
  }
}