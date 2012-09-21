package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNightwatchSecurityParserTest extends BaseParserTest {
  
  public NYNightwatchSecurityParserTest() {
    setParser(new NYNightwatchSecurityParser(), "STATEN ISLAND", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(TEST) ********** Nightwatch Security - Account 3694 ********** \n\n" +
        "                  =========================== \n\n" +
        "  Reason for Call: 04-SERVICE & BILLING CALL                 Date:\n" +
        "12/30/2010\n" +
        "  Order Number: 2400000946                                   Time: 13:46:11\n" +
        "  Operator: AMM\n" +
        "  Name: Jackie Johnston\n" +
        "  Callback Number: (347)265-6123\n" +
        "  Call For: \n" +
        "  Patched: YES\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: AUTOZONE #4713 (STATEN ISLAND)\n" +
        "  Dispatch Notes: \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 3472656123\n" +
        "  Message: \n" +
        "   \n\n" +
        "   \n\n" +
        "                                   Message # 1\n\n\n" +
        " ===================================",

        "CALL:04-SERVICE & BILLING CALL",
        "DATE:12/30/2010",
        "ID:2400000946",
        "TIME:13:46:11",
        "NAME:Jackie Johnston",
        "PHONE:(347)265-6123",
        "ADDR:AUTOZONE #4713 (STATEN ISLAND)");

    doTest("T2",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 06-MONITORING CENTER                      Date:\n" +
        "12/09/2010\n" +
        "  Order Number: 2400000925                                   Time: 23:54:31\n" +
        "  Operator: AJH\n" +
        "  Name: Lb03\n" +
        "  Callback Number: (800)434-4000\n" +
        "  Call For: \n" +
        "  Patched: \n" +
        "  Police Needed: YES\n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: 3340 STREET ROAD\n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 7183326100\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1\n\n" +
        " ===================================\n" +
        " End of Report Statement       : 12/10/2010 00:04:39\n" +
        " \n" +
        " Total Number of Orders Records:          1",

        "CALL:06-MONITORING CENTER",
        "DATE:12/09/2010",
        "ID:2400000925",
        "TIME:23:54:31",
        "NAME:Lb03",
        "PHONE:(800)434-4000",
        "ADDR:3340 STREET ROAD");   // Not mapping

    doTest("T3",
        "(new messages for 3694) \n" +
        "      ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date:\n" +
        "05/22/2012\n" +
        "  Order Number: 2400002076                                   Time: 09:15:26\n" +
        "  Operator: MBC\n" +
        "  Name: Steve Galindo W/ L1 Idenity Solutios\n" +
        "  Callback Number: (615)342-9256\n" +
        "  Call For: John Burbridge\n" +
        "  Patched: NO\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 6153429256\n" +
        "  Message: PLEASE CALL\n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1\n\n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:05/22/2012",
        "ID:2400002076",
        "TIME:09:15:26",
        "NAME:Steve Galindo W/ L1 Idenity Solutios",
        "PHONE:(615)342-9256",
        "INFO:PLEASE CALL");

    doTest("T4",
        "(new messages for 3694) \n" +
        "      ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date:\n" +
        "05/22/2012\n" +
        "  Order Number: 2400002076                                   Time: 09:15:26\n" +
        "  Operator: MBC\n" +
        "  Name: Steve Galindo W/ L1 Idenity Solutios\n" +
        "  Callback Number: (615)342-9256\n" +
        "  Call For: John\n" +
        "  Patched: NO\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 6153429256\n" +
        "  Message: PLEASE CALL\n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1\n\n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:05/22/2012",
        "ID:2400002076",
        "TIME:09:15:26",
        "NAME:Steve Galindo W/ L1 Idenity Solutios",
        "PHONE:(615)342-9256",
        "INFO:PLEASE CALL");

    doTest("T5",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 11-EMPLOYMENT                             Date: 05/30/2012\n" +
        "  Order Number: 2400002093                                   Time: 13:15:15\n" +
        "  Operator: SMC\n" +
        "  Name: Lynette Rodriguez\n" +
        "  Callback Number: (347)756-8975\n" +
        "  Call For: \n" +
        "  Patched: \n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 3478568975\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:11-EMPLOYMENT",
        "DATE:05/30/2012",
        "ID:2400002093",
        "TIME:13:15:15",
        "NAME:Lynette Rodriguez",
        "PHONE:(347)756-8975");

    doTest("T6",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 06-MONITORING CENTER                      Date: 06/03/2012\n" +
        "  Order Number: 2400002096                                   Time: 08:42:30\n" +
        "  Operator: MBC\n" +
        "  Name: Jasmine 433\n" +
        "  Callback Number: (718)494-6414\n" +
        "  Call For: \n" +
        "  Patched: \n" +
        "  Police Needed: NO\n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 7186973200\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:06-MONITORING CENTER",
        "DATE:06/03/2012",
        "ID:2400002096",
        "TIME:08:42:30",
        "NAME:Jasmine 433",
        "PHONE:(718)494-6414");

    doTest("T7",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/07/2012\n" +
        "  Order Number: 2400002104                                   Time: 12:23:33\n" +
        "  Operator: MRH\n" +
        "  Name: Mike Antoik\n" +
        "  Callback Number: (212)801-1067\n" +
        "  Call For: \n" +
        "  Patched: NO\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 2128011067\n" +
        "  Message: PLEASE CALL\n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================\n" +
        " ",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:06/07/2012",
        "ID:2400002104",
        "TIME:12:23:33",
        "NAME:Mike Antoik",
        "PHONE:(212)801-1067",
        "INFO:PLEASE CALL");

    doTest("T8",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/08/2012\n" +
        "  Order Number: 2400002109                                   Time: 14:27:18\n" +
        "  Operator: JDB\n" +
        "  Name: Jesse Rivest\n" +
        "  Callback Number: (860)471-0136\n" +
        "  Call For: \n" +
        "  Patched: YES\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 8604710136\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:06/08/2012",
        "ID:2400002109",
        "TIME:14:27:18",
        "NAME:Jesse Rivest",
        "PHONE:(860)471-0136");

    doTest("T9",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 11-EMPLOYMENT                             Date: 06/10/2012\n" +
        "  Order Number: 2400002113                                   Time: 09:06:09\n" +
        "  Operator: SMC\n" +
        "  Name: Richard Pacilli\n" +
        "  Callback Number: (347)924-3197\n" +
        "  Call For: \n" +
        "  Patched: \n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 3479243197\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:11-EMPLOYMENT",
        "DATE:06/10/2012",
        "ID:2400002113",
        "TIME:09:06:09",
        "NAME:Richard Pacilli",
        "PHONE:(347)924-3197");

    doTest("T10",
        "(General Alert) 1911 Richmond Avenue",
        "CALL:** General Alert **",
        "ADDR:1911 Richmond Avenue");

    doTest("T11",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 11-EMPLOYMENT                             Date: 06/11/2012\n" +
        "  Order Number: 2400002114                                   Time: 08:54:05\n" +
        "  Operator: MRH\n" +
        "  Name: Ayomide Awopetu\n" +
        "  Callback Number: (347)500-9095\n" +
        "  Call For: \n" +
        "  Patched: \n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 3475009095\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:11-EMPLOYMENT",
        "DATE:06/11/2012",
        "ID:2400002114",
        "TIME:08:54:05",
        "NAME:Ayomide Awopetu",
        "PHONE:(347)500-9095");

    doTest("T12",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/15/2012\n" +
        "  Order Number: 2400002116                                   Time: 10:36:45\n" +
        "  Operator: LMH\n" +
        "  Name: Anthony Missud\n" +
        "  Callback Number: (718)370-2171 1 41\n" +
        "  Call For: Mr. Burbridge\n" +
        "  Patched: NO\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 7183702171\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:06/15/2012",
        "ID:2400002116",
        "TIME:10:36:45",
        "NAME:Anthony Missud",
        "PHONE:(718)370-2171 1 41");

    doTest("T13",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 11-EMPLOYMENT                             Date: 06/16/2012\n" +
        "  Order Number: 2400002118                                   Time: 09:10:15\n" +
        "  Operator: JLX\n" +
        "  Name: Andre Ortiz\n" +
        "  Callback Number: (347)499-6792\n" +
        "  Call For: \n" +
        "  Patched: \n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 3474996792\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:11-EMPLOYMENT",
        "DATE:06/16/2012",
        "ID:2400002118",
        "TIME:09:10:15",
        "NAME:Andre Ortiz",
        "PHONE:(347)499-6792");

    doTest("T14",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 10-PUT ALARM IN TEST                      Date: 06/18/2012\n" +
        "  Order Number: 2400002119                                   Time: 08:24:22\n" +
        "  Operator: 9JC\n" +
        "  Name: Nancy Mctaggart\n" +
        "  Callback Number: (215)638-2283\n" +
        "  Call For: \n" +
        "  Patched: YES\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 2156382283\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:10-PUT ALARM IN TEST",
        "DATE:06/18/2012",
        "ID:2400002119",
        "TIME:08:24:22",
        "NAME:Nancy Mctaggart",
        "PHONE:(215)638-2283");

    doTest("T15",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/19/2012\n" +
        "  Order Number: 2400002122                                   Time: 12:41:36\n" +
        "  Operator: 9GP\n" +
        "  Name: Jennifer Coss\n" +
        "  Callback Number: (866)421-2374\n" +
        "  Call For: John\n" +
        "  Patched: NO\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 8433795113\n" +
        "  Message: \n" +
        "   WANTS TO KNOW IF A CREDIT CARD PAYMENT WENT THROUGH.\n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:06/19/2012",
        "ID:2400002122",
        "TIME:12:41:36",
        "NAME:Jennifer Coss",
        "PHONE:(866)421-2374",
        "INFO:WANTS TO KNOW IF A CREDIT CARD PAYMENT WENT THROUGH.");

    doTest("T16",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/21/2012\n" +
        "  Order Number: 2400002127                                   Time: 05:30:35\n" +
        "  Operator: PJG\n" +
        "  Name: Jasmine Carter\n" +
        "  Callback Number: (317)601-5373\n" +
        "  Call For: John\n" +
        "  Patched: \n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 3176015376\n" +
        "  Message: PLEASE CALL. WANTS PRICING TO HAVE SYSTEM INSTALLED. SHE WAS ROBBED\n" +
        "   RECENTLY AT GUNPOINT. STOLE HER CAR & HAS HER GPS. SHE IS SCARED THEY\n" +
        "   WILL GET HER ADDRESS & HER PARENTS ADDRESS.\n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:06/21/2012",
        "ID:2400002127",
        "TIME:05:30:35",
        "NAME:Jasmine Carter",
        "PHONE:(317)601-5373",
        "INFO:PLEASE CALL. WANTS PRICING TO HAVE SYSTEM INSTALLED. SHE WAS ROBBED / RECENTLY AT GUNPOINT. STOLE HER CAR & HAS HER GPS. SHE IS SCARED THEY / WILL GET HER ADDRESS & HER PARENTS ADDRESS.");

    doTest("T17",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/26/2012\n" +
        "  Order Number: 2400002129                                   Time: 15:06:55\n" +
        "  Operator: JDB\n" +
        "  Name: Nicki\n" +
        "  Callback Number: (631)782-1700\n" +
        "  Call For: John Burbridge\n" +
        "  Patched: YES\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 6317821700\n" +
        "  Message: \n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:06/26/2012",
        "ID:2400002129",
        "TIME:15:06:55",
        "NAME:Nicki",
        "PHONE:(631)782-1700");

    doTest("T18",
        "(new messages for 3694)       ********** Nightwatch Security - Account 3694 ********** \n" +
        "                  =========================== \n" +
        "  Reason for Call: 05-CALL FOR PARTICULAR PERSON             Date: 06/27/2012\n" +
        "  Order Number: 2400002132                                   Time: 10:16:11\n" +
        "  Operator: LMH\n" +
        "  Name: Jennifer\n" +
        "  Callback Number: (866)421-2374 X 211\n" +
        "  Call For: John Burbiege\n" +
        "  Patched: NO\n" +
        "  Police Needed: \n" +
        "  Police Called: \n" +
        "  Description Of Incident: \n" +
        "  Description Of Incident: \n" +
        "  Location: \n" +
        "  Dispatch Notes: \n" +
        "   \n" +
        "  Attendance: \n" +
        "  When Arriving: \n" +
        "  Time Assigned: \n" +
        "  Caller ID: 2627218855\n" +
        "  Message: PER JOHN WILL CALL HER BACK AT 2PM\n" +
        "   \n" +
        "   \n" +
        "   \n" +
        "                                   Message # 1                                   \n" +
        " ===================================",

        "CALL:05-CALL FOR PARTICULAR PERSON",
        "DATE:06/27/2012",
        "ID:2400002132",
        "TIME:10:16:11",
        "NAME:Jennifer",
        "PHONE:(866)421-2374 X 211",
        "INFO:PER JOHN WILL CALL HER BACK AT 2PM");
  }
  
  public static void main(String[] args) {
    new NYNightwatchSecurityParserTest().generateTests("T1");
  }
}