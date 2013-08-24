package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Fairfax County, VA
Contact: "Hodgson, Sean" <Sean.Hodgson@fairfaxcounty.gov>
Sender: EAN_23NQ@ean.fairfaxcounty.gov
System: Intergraph

(Emergency Alert from Fairfax County) Box 943 /\nEvent FTH /\nAdrs 3959 EL SONETA PL /\nNote E409 ON SCENE WITH SMOKE SHOWING SIDE A, BC406 WITH COMMAND /\nCh 4H\n\nSent on: 02/23 00:28\n\nSent by Tim Fowler to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages\n\nContact AlertSupport@Fairfaxcounty.gov for help
Box 2908 /\nEvent 1327 WOODSIDE DR /\nAdrs 1327 WOODSIDE DR /\nNote BC401 ON SCENE WITH COMMAND FIRE IN BEDROOM FIRE SHOWING FROM WINDOW SIDE A QUADRANT D /\nCh 4D\n\nSent on: 02/20 19:54\n\nSent by Cynthia Brown to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages\n\nContact AlertSupport@Fairfaxcounty.gov for help
Box 6015 /\nEvent FHOU /\nAdrs 27140 Gum Spring Rd, LOUDOUN COUNTY /\nNote E438, E417, T438, BC403 to Loudoun County for a fire in house with a brush fire.   /\nCh 6D\n\nSent on: 02/18 17:58\n\nSent by kim Hood to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages\n\nContact AlertSupport@Fairfaxcounty.gov for help
Box 4212 /\nEvent FTH /\nAdrs 1009 MOOREFIELD HILL GRV, SW /\nNote Fire in the attic, DFCO-B on scene with command /\nCh 4D\n\nSent on: 02/18 17:35\n\nSent by Cynthia Brown to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages\n\nContact AlertSupport@Fairfaxcounty.gov for help
Box 2694 /\nEvent FGAPT /\nAdrs 4821 MANITOBA DR /\nNote E426 ON SCENE WITH LIGHT SMOKE SHOWING FROM TERRACE LEVEL APT. /\nCh 4D\n\nSent on: 02/17 17:27\n\nSent by Mark Kordalski to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages\n\nContact AlertSupport@Fairfaxcounty.gov for help
Box 1406 /\nEvent FHOU /\nAdrs 9620 BRADDOCK RD /\nNote FIRE SHOWING ON SIDE B AND C WITH FIRE IN GARAGE AND POSSIBLY ATTIC BC443 HAS COMMAND   /\nCh 4D\n\nSent on: 02/17 12:27\n\nSent by Cynthia Brown to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages\n\nContact AlertSupport@Fairfaxcounty.gov for help
Box 2100 /\nEvent ACCTIF /\nAdrs FAIR RIDGE/LEE JACKSON MEMORIAL /\nNote E421 CONFIRMED ONE TRAPPED, BC403 WITH COMMAND /\nCh 4D\n\nSent on: 02/17 00:20\n\nSent by Mark Kordalski to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages\n\nContact AlertSupport@Fairfaxcounty.gov for help
Box 0823 /\nEvent FHOU /\nAdrs 6606 Reserves Hill Ct /\nNote Command requesting 2 additional engines /\nCh 4E\n\nSent on: 02/24 14:17\n\nSent by kim Hood to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n----------------------\n\nUpdate your profile at http://ean.fairfaxcounty.gov/myhome.php\n\nReset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\nRetrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\nReply STOP to stop receiving ALL future alerts and service messages
  
1 of 2\nFRM:EAN\nMSG:Box 3800 / \nEvent FGAPT / \nAdrs 14907 Rydell Rd / \nNote EXPLOSION IN THE TERRANCE LEVEL APARTMENT. BC403 ON SCEN WITH\n(Con't) 2 of 2\nCOMMAND / \nCh 4D\nSent on: 03/02 16:20(End)

*/

public class VAFairfaxCountyParserTest extends BaseParserTest {
  
  public VAFairfaxCountyParserTest() {
    setParser(new VAFairfaxCountyParser(), "FAIRFAX COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Emergency Alert from Fairfax County) Box 943 /\n" +
        "Event FTH /\n" +
        "Adrs 3959 EL SONETA PL /\n" +
        "Note E409 ON SCENE WITH SMOKE SHOWING SIDE A, BC406 WITH COMMAND /\n" +
        "Ch 4H\n\n" +
        "Sent on: 02/23 00:28\n\n" +
        "Sent by Tim Fowler to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages\n\n" +
        "Contact AlertSupport@Fairfaxcounty.gov for help",

        "BOX:943",
        "CALL:FTH",
        "ADDR:3959 EL SONETA PL",
        "INFO:E409 ON SCENE WITH SMOKE SHOWING SIDE A, BC406 WITH COMMAND",
        "CH:4H");

    doTest("T2",
        "Box 2908 /\n" +
        "Event 1327 WOODSIDE DR /\n" +
        "Adrs 1327 WOODSIDE DR /\n" +
        "Note BC401 ON SCENE WITH COMMAND FIRE IN BEDROOM FIRE SHOWING FROM WINDOW SIDE A QUADRANT D /\n" +
        "Ch 4D\n\n" +
        "Sent on: 02/20 19:54\n\n" +
        "Sent by Cynthia Brown to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages\n\n" +
        "Contact AlertSupport@Fairfaxcounty.gov for help",

        "BOX:2908",
        "CALL:1327 WOODSIDE DR",
        "ADDR:1327 WOODSIDE DR",
        "INFO:BC401 ON SCENE WITH COMMAND FIRE IN BEDROOM FIRE SHOWING FROM WINDOW SIDE A QUADRANT D",
        "CH:4D");

    doTest("T3",
        "Box 6015 /\n" +
        "Event FHOU /\n" +
        "Adrs 27140 Gum Spring Rd, LOUDOUN COUNTY /\n" +
        "Note E438, E417, T438, BC403 to Loudoun County for a fire in house with a brush fire.   /\n" +
        "Ch 6D\n\n" +
        "Sent on: 02/18 17:58\n\n" +
        "Sent by kim Hood to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages\n\n" +
        "Contact AlertSupport@Fairfaxcounty.gov for help",

        "BOX:6015",
        "CALL:FHOU",
        "ADDR:27140 Gum Spring Rd",
        "CITY:LOUDOUN COUNTY",
        "INFO:E438, E417, T438, BC403 to Loudoun County for a fire in house with a brush fire.",
        "CH:6D");

    doTest("T4",
        "Box 4212 /\n" +
        "Event FTH /\n" +
        "Adrs 1009 MOOREFIELD HILL GRV, SW /\n" +
        "Note Fire in the attic, DFCO-B on scene with command /\n" +
        "Ch 4D\n\n" +
        "Sent on: 02/18 17:35\n\n" +
        "Sent by Cynthia Brown to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages\n\n" +
        "Contact AlertSupport@Fairfaxcounty.gov for help",

        "BOX:4212",
        "CALL:FTH",
        "ADDR:1009 MOOREFIELD HILL GRV SW",
        "INFO:Fire in the attic, DFCO-B on scene with command",
        "CH:4D");

    doTest("T5",
        "Box 2694 /\n" +
        "Event FGAPT /\n" +
        "Adrs 4821 MANITOBA DR /\n" +
        "Note E426 ON SCENE WITH LIGHT SMOKE SHOWING FROM TERRACE LEVEL APT. /\n" +
        "Ch 4D\n\n" +
        "Sent on: 02/17 17:27\n\n" +
        "Sent by Mark Kordalski to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages\n\n" +
        "Contact AlertSupport@Fairfaxcounty.gov for help",

        "BOX:2694",
        "CALL:FGAPT",
        "ADDR:4821 MANITOBA DR",
        "INFO:E426 ON SCENE WITH LIGHT SMOKE SHOWING FROM TERRACE LEVEL APT.",
        "CH:4D");

    doTest("T6",
        "Box 1406 /\n" +
        "Event FHOU /\n" +
        "Adrs 9620 BRADDOCK RD /\n" +
        "Note FIRE SHOWING ON SIDE B AND C WITH FIRE IN GARAGE AND POSSIBLY ATTIC BC443 HAS COMMAND   /\n" +
        "Ch 4D\n\n" +
        "Sent on: 02/17 12:27\n\n" +
        "Sent by Cynthia Brown to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages\n\n" +
        "Contact AlertSupport@Fairfaxcounty.gov for help",

        "BOX:1406",
        "CALL:FHOU",
        "ADDR:9620 BRADDOCK RD",
        "INFO:FIRE SHOWING ON SIDE B AND C WITH FIRE IN GARAGE AND POSSIBLY ATTIC BC443 HAS COMMAND",
        "CH:4D");

    doTest("T7",
        "Box 2100 /\n" +
        "Event ACCTIF /\n" +
        "Adrs FAIR RIDGE/LEE JACKSON MEMORIAL /\n" +
        "Note E421 CONFIRMED ONE TRAPPED, BC403 WITH COMMAND /\n" +
        "Ch 4D\n\n" +
        "Sent on: 02/17 00:20\n\n" +
        "Sent by Mark Kordalski to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages\n\n" +
        "Contact AlertSupport@Fairfaxcounty.gov for help",

        "BOX:2100",
        "CALL:ACCTIF",
        "ADDR:FAIR RIDGE & LEE JACKSON MEMORIAL",
        "INFO:E421 CONFIRMED ONE TRAPPED, BC403 WITH COMMAND",
        "CH:4D");

    doTest("T8",
        "Box 0823 /\n" +
        "Event FHOU /\n" +
        "Adrs 6606 Reserves Hill Ct /\n" +
        "Note Command requesting 2 additional engines /\n" +
        "Ch 4E\n\n" +
        "Sent on: 02/24 14:17\n\n" +
        "Sent by kim Hood to  FD Incident Notification (E-mail, Pager, Cell Phone) through the Fairfax County Emergency Alert Network ... powered by Cooper Notification RSAN\n\n" +
        "----------------------\n\n" +
        "Update your profile at http://ean.fairfaxcounty.gov/myhome.php\n\n" +
        "Reset your password at http://ean.fairfaxcounty.gov/sendpassword.php\n\n" +
        "Retrieve your username at http://ean.fairfaxcounty.gov/sendusername.php\n\n" +
        "Reply STOP to stop receiving ALL future alerts and service messages",

        "BOX:0823",
        "CALL:FHOU",
        "ADDR:6606 Reserves Hill Ct",
        "INFO:Command requesting 2 additional engines",
        "CH:4E");

    doTest("T9",
        "1 of 2\n" +
        "FRM:EAN\n" +
        "MSG:Box 3800 / \n" +
        "Event FGAPT / \n" +
        "Adrs 14907 Rydell Rd / \n" +
        "Note EXPLOSION IN THE TERRANCE LEVEL APARTMENT. BC403 ON SCEN WITH\n" +
        "(Con't) 2 of 2\n" +
        "COMMAND / \n" +
        "Ch 4D\n" +
        "Sent on: 03/02 16:20(End)",

        "BOX:3800",
        "CALL:FGAPT",
        "ADDR:14907 Rydell Rd",
        "INFO:EXPLOSION IN THE TERRANCE LEVEL APARTMENT. BC403 ON SCEN WITH COMMAND",
        "CH:4D");

  }
  
  public static void main(String[] args) {
    new VAFairfaxCountyParserTest().generateTests("T1");
  }
}