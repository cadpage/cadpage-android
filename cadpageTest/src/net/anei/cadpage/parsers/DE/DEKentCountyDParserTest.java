package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kent County, DE (variant D)

Contact: Active911
Agency name: Leipsic Volunteer Fire Co.
Location: Leipsic, DE, United States
Sender: kentcenter@state.de.us

(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~1308~DYKE BRANCH~RD~\r\nVenue:~Dover\r\nCross Streets~\r\nLEWIS DR\r\n E DENNEYS RD / HAZELWOOD DR\r\nStation:~Station 53\r\nQuadrant:~53C\r\nDistrict:~53C\r\n~\r\nCall Information:\r\n\r\nCall Number:~2909\r\nCall Type:~ 13C1 Diabetic - Not Alert\r\nSource:~911\r\nPriority:~ 3\r\nStatus:~In Progress\r\nCaller:~MCEACHIN,~JOYCE\r\nCall Date/Time:~11/07/2012 12:46:52\r\nDispatch Date/Time:~11/07/2012 12:49:06\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~11/07/2012 12:51:08\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00731512~~Cheswold Fire Company EMS\r\n2012-00021691~~Kent County Department of Public Safety\r\n2012-06710002~~Kent County Emergency Medical Services\r\n2012-00830252~~Leipsic Fire Company EMS\r\n~\r\nUnits Sent:~4\r\nKM6A, P53E, B53, A43~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n11/07/12 12:49:04~You are responding to a patient with diabetic problems.  The patient is a  49-year-old male, who is conscious and breathing. Not alert.  1.He is not completely alert (not responding appropriately).  2.He is not behaving normally now.  3.He is breathing normally.\r\n11/07/12 12:49:04~Problem: DIABETIC PROBLEM.  Patient Info: 1 patient(s); 49 Years old; Male; Conscious: Yes; Breathing: Yes;\r\n11/07/12 12:49:04~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 13; Dispatch Level: 13C01; Response Text: BLS, ALS\r\n11/07/12 12:49:24~ProQA Medical Questionnaire Completed; Chief Complaint Number: 13; Dispatch Level: 13C01; Response Text: BLS, ALS\r\n11/07/12 12:49:24~Problem: DIABETIC PROBLEM.  Patient Info: 1 patient(s); 49 Years old; Male; Conscious: Yes; Breathing: Yes;\r\n11/07/12 12:49:24~49-year-old male, who is conscious and breathing. Not alert.\r\n11/07/12 12:49:40~49 Y/O M C B DIABETIC PROBLEM NOT ALERT\r\n11/07/12 12:49:44~GRID 53C\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~230~MAIN~ST~\r\nVenue:~Dover\r\nCross Streets~\r\n2ND ST / TEXAS LN\r\nPhone:~734-7264\r\nStation:~Station 53\r\nQuadrant:~53D\r\nDistrict:~53D\r\n~\r\nCall Information:\r\n\r\nCall Number:~2381\r\nCall Type:~ 10D4 Chest Pains - Clammy\r\nSource:~911\r\nPriority:~ 2\r\nStatus:~In Progress\r\nCaller:~SIPPLE,~DONNA\r\nCall Date/Time:~11/05/2012 20:31:10\r\nDispatch Date/Time:~11/05/2012 20:33:30\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~11/05/2012 20:34:35\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00021560~~Kent County Department of Public Safety\r\n2012-06709957~~Kent County Emergency Medical Services\r\n2012-00830249~~Leipsic Fire Company EMS\r\n~\r\nUnits Sent:~3\r\nKM6A, P53E, B53~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n11/05/12 20:33:23~Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n11/05/12 20:33:23~You are responding to a patient with chest pain.  The patient is a 63-year-old  female, who is conscious and breathing. Clammy.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She is changing color.  4.Her color change is pale.  5.She is clammy.\r\n11/05/12 20:33:23~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS\r\n11/05/12 20:33:55~Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n11/05/12 20:33:55~6.She has had angina (heart pains) before.  7.She did not take any drugs (medications) in the past 12hrs.\r\n11/05/12 20:33:55~ProQA Medical Key Questions have been completed; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS\r\n11/05/12 20:34:21~ProQA Medical Questionnaire Completed; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS\r\n11/05/12 20:34:21~Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n11/05/12 20:34:21~-Aspirin Diagnostic: No aspirin is available at scene.-\r\n11/05/12 20:34:52~63 YOF CHEST PAINS FOR 2 HRS WITH PAIN RADIATING DOWN HER ARM\r\n11/05/12 20:35:03~HAS CARDIAC HX\r\n11/05/12 20:35:32~RP ADVISED PT TOOK ASPIRIN\r\n11/05/12 20:35:42~53D\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~54~N ~DELAWARE BAY~\r\nCommon Name:~BAY- 54 NORTH DISTRICT\r\nVenue:~Dover\r\nCross Streets~\r\nNo Cross Streets Found\r\nStation:~Station 54\r\nQuadrant:~54W\r\nDistrict:~54W (53 EMS)\r\n~\r\nCall Information:\r\n\r\nCall Number:~2052\r\nCall Type:~ Watercraft in Distress (Pri 2)\r\nSource:~911\r\nPriority:~ 4\r\nStatus:~In Progress\r\nCaller:~\r\nCall Date/Time:~11/04/2012 16:17:22\r\nDispatch Date/Time:~11/04/2012 16:23:24\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00021489~~Kent County Department of Public Safety\r\n2012-00530098~~Leipsic Fire Company\r\n2012-00830248~~Leipsic Fire Company EMS\r\n2012-00540270~~Little Creek Fire Company\r\n2012-00900346~~Medical Aviation Units\r\n2012-00001779~~Misc Fire Units\r\n~\r\nUnits Sent:~11\r\nT4, P54F, P53F, MP1, CG2, B53, 53M1, 539, R54, 54M1, 548~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~126~N ~SANDPIPER~DR~\r\nVenue:~Dover\r\nCross Streets~\r\nDEAD END / S SANDPIPER DR\r\n PICKERING BEACH RD\r\nStation:~Station 54\r\nQuadrant:~54E\r\nDistrict:~54E (53 EMS)\r\n~\r\nCall Information:\r\n\r\nCall Number:~1555\r\nCall Type:~ 6D2 Breathing Problems\r\nSource:~911\r\nPriority:~ 2\r\nStatus:~In Progress\r\nCaller:~JOKES,~RICHARD\r\nCall Date/Time:~11/03/2012 04:15:29\r\nDispatch Date/Time:~11/03/2012 04:16:43\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~11/03/2012 04:18:28\r\nLatest Unit Cleared Date/Time:~11/03/2012 04:18:23\r\n~\r\nIncident Number(s)\r\n2012-06305577~~City Of Dover Ambulance Service\r\n2012-00021386~~Kent County Department of Public Safety\r\n2012-06709878~~Kent County Emergency Medical Services\r\n2012-00830246~~Leipsic Fire Company EMS\r\n2012-00540268~~Little Creek Fire Company\r\n~\r\nUnits Sent:~6\r\nKM5A, P54E, P53E, A63, A53, R54~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n11/03/12 04:16:36~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS\r\n11/03/12 04:16:36~Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n11/03/12 04:16:36~You are responding to a patient with breathing problems.  The patient is a  48-year-old female, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  DIFFICULTY SPEAKING BETWEEN BREATHS.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.\r\n11/03/12 04:16:56~3.She is not changing color.  4.She is not clammy.  5.She does not have asthma.  6.N/A\r\n11/03/12 04:16:56~ProQA Medical Key Questions have been completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS\r\n11/03/12 04:16:56~Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n11/03/12 04:17:30~Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n11/03/12 04:17:30~SPEAKING BETWEEN BREATHS.\r\n11/03/12 04:17:30~ProQA Medical Questionnaire Completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS\r\n11/03/12 04:17:39~48 F C TRBR HX OS DAME\r\n11/03/12 04:17:44~54E\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~68~SIPPLE~RD~\r\nVenue:~Dover\r\nCross Streets~\r\nNo Cross Streets Found\r\nStation:~Station 53\r\nQuadrant:~53B\r\nDistrict:~53B\r\n~\r\nCall Information:\r\n\r\nCall Number:~1208\r\nCall Type:~ Structure-Residential Single\r\nSource:~911\r\nPriority:~ 2\r\nStatus:~In Progress\r\nCaller:~NAME,~NO\r\nCall Date/Time:~11/01/2012 21:32:34\r\nDispatch Date/Time:~11/01/2012 21:34:35\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00021320~~Kent County Department of Public Safety\r\n2012-00530097~~Leipsic Fire Company\r\n2012-00540267~~Little Creek Fire Company\r\n~\r\nUnits Sent:~9\r\nP54F, P53F, 537, 536, 535, 532, R54, 545, 542~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n11/01/12 21:32:58~IN THE A/O\r\n11/01/12 21:33:32~New ProQA Fire Case Number has been assigned: -661138\r\n11/01/12 21:34:28~Structure Fire.  Residential (single).Caller Statement: NATURE UNKNOWN.  1.The caller is not on scene.  2.Both smoke and flames are visible.  3.The incident involves a single-family residential structure.  4.It is not known how many levels or stories there are.  5.The caller has not indicated that there are trapped person(s).\r\n11/01/12 21:34:28~ProQA Fire Dispatch Message Sent; Chief Complaint Number: 69; Dispatch Level: 69D06; Response Text: a\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~~BAYSIDE~DR/~PERSIMMON TREE~LN\r\nVenue:~Dover\r\nCross Streets~\r\nPhone:~632-7238\r\nStation:~Station 53\r\nQuadrant:~53B\r\nDistrict:~53B\r\n~\r\nCall Information:\r\n\r\nCall Number:~268\r\nCall Type:~ 29D2S MVC - Sinking Vehicle\r\nSource:~911\r\nPriority:~ 2\r\nStatus:~In Progress\r\nCaller:~LOHAMN,~CARLOS\r\nCall Date/Time:~10/29/2012 23:02:45\r\nDispatch Date/Time:~10/29/2012 23:05:34\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00021116~~Kent County Department of Public Safety\r\n2012-06709754~~Kent County Emergency Medical Services\r\n2012-00530095~~Leipsic Fire Company\r\n2012-00830243~~Leipsic Fire Company EMS\r\n~\r\nUnits Sent:~5\r\nKM7A, P53F, B53, 536, 532~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/29/12 23:04:38~You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) HIGH MECHANISM (k through s)  (Sinking vehicle).  Unknown number of patients involved.  HIGH MECHANISM (k through s)  (Sinking vehicle).  1.The incident involves a sinking vehicle.\r\n10/29/12 23:04:38~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: s; Response Text: BLS, ALS, AVIATION\r\n10/29/12 23:04:38~Problem: Sinking vehicle -- Caller inside.  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Yes; Breathing: Yes;\r\n\r\n
(Rip and Run Report) Rip and Run Report\r\n\r\n~\r\nLocation Information:\r\n\r\nLocation:~30~TEXAS~LN~\r\nVenue:~Dover\r\nCross Streets~\r\nMAIN ST / SAVANNAH RD\r\nPhone:~(800) 932-3822\r\nStation:~Station 53\r\nQuadrant:~53B\r\nDistrict:~53B\r\n~\r\nCall Information:\r\n\r\nCall Number:~190\r\nCall Type:~ Alarms-Residential (single)\r\nSource:~Telephone ( Non - 911)\r\nPriority:~ 4\r\nStatus:~In Progress\r\nCaller:~CMH,~ADVANTECH\r\nCall Date/Time:~10/29/2012 18:04:25\r\nDispatch Date/Time:~10/29/2012 18:07:57\r\nArrive Date/Time:~\r\nClear Date/Time:~\r\nEnroute Date/Time:~\r\nLatest Unit Cleared Date/Time:~\r\n~\r\nIncident Number(s)\r\n2012-00021081~~Kent County Department of Public Safety\r\n2012-00530093~~Leipsic Fire Company\r\n2012-00540260~~Little Creek Fire Company\r\n~\r\nUnits Sent:~9\r\nP54F, P53F, 537, 536, 535, 532, R54, 545, 544~\r\n\r\nAlerts:\r\n~\r\nLocation Alerts\r\n\r\nPerson Alerts\r\n\r\nVehicle Alerts\r\n~~\r\nNarrative:\r\n\r\nNarrative Time~Narrative\r\n10/29/12 18:05:55~AFA SMOKE DECT BASEMENT\r\n10/29/12 18:06:02~ProQA Medical Questionnaire Aborted - 8. Non-medical call\r\n10/29/12 18:06:07~New ProQA Fire Case Number has been assigned: -660120\r\n10/29/12 18:07:23~Alarms.  Residential (single)  (Smoke detector).Caller Statement: BASEMENT SMOKE DECT.  1.The caller is an alarm monitoring company.  2.It is a smoke detector alarm.  3.The incident involves a single-family residential structure.  4.The name of the business/resident/owner is: L.CARREY  5.The area or zone activated is: BASEMENT/ZONE 1  6.The phone number of the business/resident/owner is: 3027304042-Comments: L.CARREY--Comments: BASEMENT/ZONE 1--Comments: 3027304042-\r\n10/29/12 18:07:23~ProQA Fire Dispatch Message Sent; Chief Complaint Number: 52; Dispatch Level: 52B01; Dispatch Level Suffix: S; Response Text: o\r\n10/29/12 18:07:37~Alarms.  Residential (single)  (Smoke detector).Caller Statement: BASEMENT SMOKE DECT.  1.The caller is an alarm monitoring company.  2.It is a smoke detector alarm.  3.The incident involves a single-family residential structure.  4.The name of the business/resident/owner is: L.CARREY  5.The area or zone activated is: BASEMENT/ZONE 1  6.The phone number of the business/resident/owner is: 3027304042-Comments: L.CARREY--Comments: BASEMENT/ZONE 1--Comments: 3027304042-\r\n10/29/12 18:07:37~ProQA Fire Questionnaire Completed; Chief Complaint Number: 52; Dispatch Level: 52B01; Dispatch Level Suffix: S; Response Text: o\r\n\r\n

(Rip and Run Report) Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~3034~S ~DUPONT~BLVD~\nAdditional Location Information:FLR GRD\nCommon Name:~ PINNACLE HEALTH AND REHAB CTR\nVenue:~Smyrna\nCross Streets~\nUNKNOWN / VILLAGE DR\nPhone:~(302) 653-5085\nStation:~Station 44\nQuadrant:~44F\nDistrict:~44A (64 EMS)\n~\nCall Information:\n\nCall Number:~4277\nCall Type:~ 33C2T Transfer/Interfacility\nSource:~911\nPriority:~ 3\nStatus:~In Progress\nCaller:~PRICE,~CICILIA\nCall Date/Time:~04/08/2013 12:00:20\nDispatch Date/Time:~04/08/2013 12:02:10\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-06702948~~Kent County Emergency Medical Services\n2013-00640798~~Smyrna Americian Legion Ambulance\n~\nUnits Sent:~2\nKM6A, A64~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n04/08/13 12:00:20~E911 Info - Class of Service: BUS Special Response Info: POLICE:   STATE POLICE        FIRE:     STATION 44          MEDICAL:\n04/08/13 12:00:34~SIERRA RM 130 B\n04/08/13 12:01:58~Problem: LOW SAT .  Patient Info: 1 patient(s); 66 Years old; Female; Conscious: Yes; Breathing: Yes;\n04/08/13 12:01:58~ProQA Medical Dispatch Message Sent; Dispatch Code: 33-C-02T\n04/08/13 12:01:58~You are responding to a patient transfer or medical care facility situation.  The patient is a 66-year-old female, who is conscious and breathing.  Abnormal breathing (acute onset)  (Transfer).  1.This call is a result of an evaluation by a nurse or doctor.  2.This is a transfer/interfacility case.  3.She is completely alert (responding appropriately).  4.She is not breathing normally.  5.This is a sudden or unexpected change in her condition.  6.She does not have significant bleeding or symptoms of shock.  7.She is not in severe pain.  8.Special equipment is not necessary.  9.Additional personnel will not be needed.\n04/08/13 12:02:04~ProQA Medical Key Questions have been completed; Dispatch Code: 33-C-02T\n04/08/13 12:02:04~10.MD/RN names and facility numbers (as applicable) have been obtained outside of ProQA.\n04/08/13 12:02:04~Problem: LOW SAT .  Patient Info: 1 patient(s); 66 Years old; Female; Conscious: Yes; Breathing: Yes;\n\n\n

 */

public class DEKentCountyDParserTest extends BaseParserTest {
  
  public DEKentCountyDParserTest() {
    setParser(new DEKentCountyDParser(), "KENT COUNTY", "DE");
  }
  
  @Test
  public void testLeipsicFire() {

    doTest("T1",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~1308~DYKE BRANCH~RD~\r\n" +
        "Venue:~Dover\r\n" +
        "Cross Streets~\r\n" +
        "LEWIS DR\r\n" +
        " E DENNEYS RD / HAZELWOOD DR\r\n" +
        "Station:~Station 53\r\n" +
        "Quadrant:~53C\r\n" +
        "District:~53C\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~2909\r\n" +
        "Call Type:~ 13C1 Diabetic - Not Alert\r\n" +
        "Source:~911\r\n" +
        "Priority:~ 3\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~MCEACHIN,~JOYCE\r\n" +
        "Call Date/Time:~11/07/2012 12:46:52\r\n" +
        "Dispatch Date/Time:~11/07/2012 12:49:06\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~11/07/2012 12:51:08\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00731512~~Cheswold Fire Company EMS\r\n" +
        "2012-00021691~~Kent County Department of Public Safety\r\n" +
        "2012-06710002~~Kent County Emergency Medical Services\r\n" +
        "2012-00830252~~Leipsic Fire Company EMS\r\n" +
        "~\r\n" +
        "Units Sent:~4\r\n" +
        "KM6A, P53E, B53, A43~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "11/07/12 12:49:04~You are responding to a patient with diabetic problems.  The patient is a  49-year-old male, who is conscious and breathing. Not alert.  1.He is not completely alert (not responding appropriately).  2.He is not behaving normally now.  3.He is breathing normally.\r\n" +
        "11/07/12 12:49:04~Problem: DIABETIC PROBLEM.  Patient Info: 1 patient(s); 49 Years old; Male; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/07/12 12:49:04~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 13; Dispatch Level: 13C01; Response Text: BLS, ALS\r\n" +
        "11/07/12 12:49:24~ProQA Medical Questionnaire Completed; Chief Complaint Number: 13; Dispatch Level: 13C01; Response Text: BLS, ALS\r\n" +
        "11/07/12 12:49:24~Problem: DIABETIC PROBLEM.  Patient Info: 1 patient(s); 49 Years old; Male; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/07/12 12:49:24~49-year-old male, who is conscious and breathing. Not alert.\r\n" +
        "11/07/12 12:49:40~49 Y/O M C B DIABETIC PROBLEM NOT ALERT\r\n" +
        "11/07/12 12:49:44~GRID 53C\r\n" +
        "\r\n",

        "ADDR:1308 DYKE BRANCH RD",
        "CITY:Dover",
        "X:LEWIS DR",
        "SRC:Station 53",
        "MAP:53C",
        "ID:2909",
        "CALL:13C1 Diabetic - Not Alert",
        "PRI:3",
        "NAME:MCEACHIN, JOYCE",
        "DATE:11/07/2012",
        "TIME:12:49:06",
        "UNIT:KM6A, P53E, B53, A43",
        "INFO:You are responding to a patient with diabetic problems.  The patient is a  49-year-old male, who is conscious and breathing. Not alert.  1.He is not completely alert (not responding appropriately).  2.He is not behaving normally now.  3.He is breathing normally. / Problem: DIABETIC PROBLEM.  Patient Info: 1 patient(s); 49 Years old; Male; Conscious: Yes; Breathing: Yes; / ProQA Medical Dispatch Message Sent; Chief Complaint Number: 13; Dispatch Level: 13C01; Response Text: BLS, ALS / ProQA Medical Questionnaire Completed; Chief Complaint Number: 13; Dispatch Level: 13C01; Response Text: BLS, ALS / Problem: DIABETIC PROBLEM.  Patient Info: 1 patient(s); 49 Years old; Male; Conscious: Yes; Breathing: Yes; / 49-year-old male, who is conscious and breathing. Not alert. / 49 Y/O M C B DIABETIC PROBLEM NOT ALERT / GRID 53C");

    doTest("T2",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~230~MAIN~ST~\r\n" +
        "Venue:~Dover\r\n" +
        "Cross Streets~\r\n" +
        "2ND ST / TEXAS LN\r\n" +
        "Phone:~734-7264\r\n" +
        "Station:~Station 53\r\n" +
        "Quadrant:~53D\r\n" +
        "District:~53D\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~2381\r\n" +
        "Call Type:~ 10D4 Chest Pains - Clammy\r\n" +
        "Source:~911\r\n" +
        "Priority:~ 2\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~SIPPLE,~DONNA\r\n" +
        "Call Date/Time:~11/05/2012 20:31:10\r\n" +
        "Dispatch Date/Time:~11/05/2012 20:33:30\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~11/05/2012 20:34:35\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00021560~~Kent County Department of Public Safety\r\n" +
        "2012-06709957~~Kent County Emergency Medical Services\r\n" +
        "2012-00830249~~Leipsic Fire Company EMS\r\n" +
        "~\r\n" +
        "Units Sent:~3\r\n" +
        "KM6A, P53E, B53~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "11/05/12 20:33:23~Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/05/12 20:33:23~You are responding to a patient with chest pain.  The patient is a 63-year-old  female, who is conscious and breathing. Clammy.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She is changing color.  4.Her color change is pale.  5.She is clammy.\r\n" +
        "11/05/12 20:33:23~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS\r\n" +
        "11/05/12 20:33:55~Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/05/12 20:33:55~6.She has had angina (heart pains) before.  7.She did not take any drugs (medications) in the past 12hrs.\r\n" +
        "11/05/12 20:33:55~ProQA Medical Key Questions have been completed; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS\r\n" +
        "11/05/12 20:34:21~ProQA Medical Questionnaire Completed; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS\r\n" +
        "11/05/12 20:34:21~Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/05/12 20:34:21~-Aspirin Diagnostic: No aspirin is available at scene.-\r\n" +
        "11/05/12 20:34:52~63 YOF CHEST PAINS FOR 2 HRS WITH PAIN RADIATING DOWN HER ARM\r\n" +
        "11/05/12 20:35:03~HAS CARDIAC HX\r\n" +
        "11/05/12 20:35:32~RP ADVISED PT TOOK ASPIRIN\r\n" +
        "11/05/12 20:35:42~53D\r\n" +
        "\r\n",

        "ADDR:230 MAIN ST",
        "CITY:Dover",
        "X:2ND ST / TEXAS LN",
        "PHONE:734-7264",
        "SRC:Station 53",
        "MAP:53D",
        "ID:2381",
        "CALL:10D4 Chest Pains - Clammy",
        "PRI:2",
        "NAME:SIPPLE, DONNA",
        "DATE:11/05/2012",
        "TIME:20:33:30",
        "UNIT:KM6A, P53E, B53",
        "INFO:Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes; / You are responding to a patient with chest pain.  The patient is a 63-year-old  female, who is conscious and breathing. Clammy.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She is changing color.  4.Her color change is pale.  5.She is clammy. / ProQA Medical Dispatch Message Sent; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS / Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes; / 6.She has had angina (heart pains) before.  7.She did not take any drugs (medications) in the past 12hrs. / ProQA Medical Key Questions have been completed; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS / ProQA Medical Questionnaire Completed; Chief Complaint Number: 10; Dispatch Level: 10D04; Response Text: BLS, ALS / Problem: 10.  Patient Info: 1 patient(s); 63 Years old; Female; Conscious: Yes; Breathing: Yes; / -Aspirin Diagnostic: No aspirin is available at scene.- / 63 YOF CHEST PAINS FOR 2 HRS WITH PAIN RADIATING DOWN HER ARM / HAS CARDIAC HX / RP ADVISED PT TOOK ASPIRIN / 53D");

    doTest("T3",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~54~N ~DELAWARE BAY~\r\n" +
        "Common Name:~BAY- 54 NORTH DISTRICT\r\n" +
        "Venue:~Dover\r\n" +
        "Cross Streets~\r\n" +
        "No Cross Streets Found\r\n" +
        "Station:~Station 54\r\n" +
        "Quadrant:~54W\r\n" +
        "District:~54W (53 EMS)\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~2052\r\n" +
        "Call Type:~ Watercraft in Distress (Pri 2)\r\n" +
        "Source:~911\r\n" +
        "Priority:~ 4\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~\r\n" +
        "Call Date/Time:~11/04/2012 16:17:22\r\n" +
        "Dispatch Date/Time:~11/04/2012 16:23:24\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00021489~~Kent County Department of Public Safety\r\n" +
        "2012-00530098~~Leipsic Fire Company\r\n" +
        "2012-00830248~~Leipsic Fire Company EMS\r\n" +
        "2012-00540270~~Little Creek Fire Company\r\n" +
        "2012-00900346~~Medical Aviation Units\r\n" +
        "2012-00001779~~Misc Fire Units\r\n" +
        "~\r\n" +
        "Units Sent:~11\r\n" +
        "T4, P54F, P53F, MP1, CG2, B53, 53M1, 539, R54, 54M1, 548~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "\r\n",

        "ADDR:54 N  DELAWARE BAY",
        "PLACE:BAY- 54 NORTH DISTRICT",
        "CITY:Dover",
        "SRC:Station 54",
        "MAP:54W-54W (53 EMS)",
        "ID:2052",
        "CALL:Watercraft in Distress (Pri 2)",
        "PRI:4",
        "DATE:11/04/2012",
        "TIME:16:23:24",
        "UNIT:T4, P54F, P53F, MP1, CG2, B53, 53M1, 539, R54, 54M1, 548");

    doTest("T4",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~126~N ~SANDPIPER~DR~\r\n" +
        "Venue:~Dover\r\n" +
        "Cross Streets~\r\n" +
        "DEAD END / S SANDPIPER DR\r\n" +
        " PICKERING BEACH RD\r\n" +
        "Station:~Station 54\r\n" +
        "Quadrant:~54E\r\n" +
        "District:~54E (53 EMS)\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~1555\r\n" +
        "Call Type:~ 6D2 Breathing Problems\r\n" +
        "Source:~911\r\n" +
        "Priority:~ 2\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~JOKES,~RICHARD\r\n" +
        "Call Date/Time:~11/03/2012 04:15:29\r\n" +
        "Dispatch Date/Time:~11/03/2012 04:16:43\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~11/03/2012 04:18:28\r\n" +
        "Latest Unit Cleared Date/Time:~11/03/2012 04:18:23\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-06305577~~City Of Dover Ambulance Service\r\n" +
        "2012-00021386~~Kent County Department of Public Safety\r\n" +
        "2012-06709878~~Kent County Emergency Medical Services\r\n" +
        "2012-00830246~~Leipsic Fire Company EMS\r\n" +
        "2012-00540268~~Little Creek Fire Company\r\n" +
        "~\r\n" +
        "Units Sent:~6\r\n" +
        "KM5A, P54E, P53E, A63, A53, R54~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "11/03/12 04:16:36~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS\r\n" +
        "11/03/12 04:16:36~Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/03/12 04:16:36~You are responding to a patient with breathing problems.  The patient is a  48-year-old female, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  DIFFICULTY SPEAKING BETWEEN BREATHS.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.\r\n" +
        "11/03/12 04:16:56~3.She is not changing color.  4.She is not clammy.  5.She does not have asthma.  6.N/A\r\n" +
        "11/03/12 04:16:56~ProQA Medical Key Questions have been completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS\r\n" +
        "11/03/12 04:16:56~Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/03/12 04:17:30~Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes;\r\n" +
        "11/03/12 04:17:30~SPEAKING BETWEEN BREATHS.\r\n" +
        "11/03/12 04:17:30~ProQA Medical Questionnaire Completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS\r\n" +
        "11/03/12 04:17:39~48 F C TRBR HX OS DAME\r\n" +
        "11/03/12 04:17:44~54E\r\n" +
        "\r\n",

        "ADDR:126 N  SANDPIPER DR",
        "CITY:Dover",
        "X:DEAD END / S SANDPIPER DR",
        "SRC:Station 54",
        "MAP:54E-54E (53 EMS)",
        "ID:1555",
        "CALL:6D2 Breathing Problems",
        "PRI:2",
        "NAME:JOKES, RICHARD",
        "DATE:11/03/2012",
        "TIME:04:16:43",
        "UNIT:KM5A, P54E, P53E, A63, A53, R54",
        "INFO:ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS / Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes; / You are responding to a patient with breathing problems.  The patient is a  48-year-old female, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  DIFFICULTY SPEAKING BETWEEN BREATHS.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths. / 3.She is not changing color.  4.She is not clammy.  5.She does not have asthma.  6.N/A / ProQA Medical Key Questions have been completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS / Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes; / Problem: TRBR .  Patient Info: 1 patient(s); 48 Years old; Female; Conscious: Yes; Breathing: Yes; / SPEAKING BETWEEN BREATHS. / ProQA Medical Questionnaire Completed; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: BLS, ALS / 48 F C TRBR HX OS DAME / 54E");

    doTest("T5",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~68~SIPPLE~RD~\r\n" +
        "Venue:~Dover\r\n" +
        "Cross Streets~\r\n" +
        "No Cross Streets Found\r\n" +
        "Station:~Station 53\r\n" +
        "Quadrant:~53B\r\n" +
        "District:~53B\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~1208\r\n" +
        "Call Type:~ Structure-Residential Single\r\n" +
        "Source:~911\r\n" +
        "Priority:~ 2\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~NAME,~NO\r\n" +
        "Call Date/Time:~11/01/2012 21:32:34\r\n" +
        "Dispatch Date/Time:~11/01/2012 21:34:35\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00021320~~Kent County Department of Public Safety\r\n" +
        "2012-00530097~~Leipsic Fire Company\r\n" +
        "2012-00540267~~Little Creek Fire Company\r\n" +
        "~\r\n" +
        "Units Sent:~9\r\n" +
        "P54F, P53F, 537, 536, 535, 532, R54, 545, 542~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "11/01/12 21:32:58~IN THE A/O\r\n" +
        "11/01/12 21:33:32~New ProQA Fire Case Number has been assigned: -661138\r\n" +
        "11/01/12 21:34:28~Structure Fire.  Residential (single).Caller Statement: NATURE UNKNOWN.  1.The caller is not on scene.  2.Both smoke and flames are visible.  3.The incident involves a single-family residential structure.  4.It is not known how many levels or stories there are.  5.The caller has not indicated that there are trapped person(s).\r\n" +
        "11/01/12 21:34:28~ProQA Fire Dispatch Message Sent; Chief Complaint Number: 69; Dispatch Level: 69D06; Response Text: a\r\n" +
        "\r\n",

        "ADDR:68 SIPPLE RD",
        "CITY:Dover",
        "SRC:Station 53",
        "MAP:53B",
        "ID:1208",
        "CALL:Structure-Residential Single",
        "PRI:2",
        "NAME:NAME, NO",
        "DATE:11/01/2012",
        "TIME:21:34:35",
        "UNIT:P54F, P53F, 537, 536, 535, 532, R54, 545, 542",
        "INFO:IN THE A/O / New ProQA Fire Case Number has been assigned: -661138 / Structure Fire.  Residential (single).Caller Statement: NATURE UNKNOWN.  1.The caller is not on scene.  2.Both smoke and flames are visible.  3.The incident involves a single-family residential structure.  4.It is not known how many levels or stories there are.  5.The caller has not indicated that there are trapped person(s). / ProQA Fire Dispatch Message Sent; Chief Complaint Number: 69; Dispatch Level: 69D06; Response Text: a");

    doTest("T6",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~~BAYSIDE~DR/~PERSIMMON TREE~LN\r\n" +
        "Venue:~Dover\r\n" +
        "Cross Streets~\r\n" +
        "Phone:~632-7238\r\n" +
        "Station:~Station 53\r\n" +
        "Quadrant:~53B\r\n" +
        "District:~53B\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~268\r\n" +
        "Call Type:~ 29D2S MVC - Sinking Vehicle\r\n" +
        "Source:~911\r\n" +
        "Priority:~ 2\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~LOHAMN,~CARLOS\r\n" +
        "Call Date/Time:~10/29/2012 23:02:45\r\n" +
        "Dispatch Date/Time:~10/29/2012 23:05:34\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00021116~~Kent County Department of Public Safety\r\n" +
        "2012-06709754~~Kent County Emergency Medical Services\r\n" +
        "2012-00530095~~Leipsic Fire Company\r\n" +
        "2012-00830243~~Leipsic Fire Company EMS\r\n" +
        "~\r\n" +
        "Units Sent:~5\r\n" +
        "KM7A, P53F, B53, 536, 532~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/29/12 23:04:38~You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) HIGH MECHANISM (k through s)  (Sinking vehicle).  Unknown number of patients involved.  HIGH MECHANISM (k through s)  (Sinking vehicle).  1.The incident involves a sinking vehicle.\r\n" +
        "10/29/12 23:04:38~ProQA Medical Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: s; Response Text: BLS, ALS, AVIATION\r\n" +
        "10/29/12 23:04:38~Problem: Sinking vehicle -- Caller inside.  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Yes; Breathing: Yes;\r\n" +
        "\r\n",

        "ADDR:BAYSIDE DR & PERSIMMON TREE LN",
        "CITY:Dover",
        "PHONE:632-7238",
        "SRC:Station 53",
        "MAP:53B",
        "ID:268",
        "CALL:29D2S MVC - Sinking Vehicle",
        "PRI:2",
        "NAME:LOHAMN, CARLOS",
        "DATE:10/29/2012",
        "TIME:23:05:34",
        "UNIT:KM7A, P53F, B53, 536, 532",
        "INFO:You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) HIGH MECHANISM (k through s)  (Sinking vehicle).  Unknown number of patients involved.  HIGH MECHANISM (k through s)  (Sinking vehicle).  1.The incident involves a sinking vehicle. / ProQA Medical Dispatch Message Sent; Chief Complaint Number: 29; Dispatch Level: 29D02; Dispatch Level Suffix: s; Response Text: BLS, ALS, AVIATION / Problem: Sinking vehicle -- Caller inside.  Patient Info: Unknown number of patients; Unknown Range old; Unknown; Conscious: Yes; Breathing: Yes;");

    doTest("T7",
        "(Rip and Run Report) Rip and Run Report\r\n" +
        "\r\n" +
        "~\r\n" +
        "Location Information:\r\n" +
        "\r\n" +
        "Location:~30~TEXAS~LN~\r\n" +
        "Venue:~Dover\r\n" +
        "Cross Streets~\r\n" +
        "MAIN ST / SAVANNAH RD\r\n" +
        "Phone:~(800) 932-3822\r\n" +
        "Station:~Station 53\r\n" +
        "Quadrant:~53B\r\n" +
        "District:~53B\r\n" +
        "~\r\n" +
        "Call Information:\r\n" +
        "\r\n" +
        "Call Number:~190\r\n" +
        "Call Type:~ Alarms-Residential (single)\r\n" +
        "Source:~Telephone ( Non - 911)\r\n" +
        "Priority:~ 4\r\n" +
        "Status:~In Progress\r\n" +
        "Caller:~CMH,~ADVANTECH\r\n" +
        "Call Date/Time:~10/29/2012 18:04:25\r\n" +
        "Dispatch Date/Time:~10/29/2012 18:07:57\r\n" +
        "Arrive Date/Time:~\r\n" +
        "Clear Date/Time:~\r\n" +
        "Enroute Date/Time:~\r\n" +
        "Latest Unit Cleared Date/Time:~\r\n" +
        "~\r\n" +
        "Incident Number(s)\r\n" +
        "2012-00021081~~Kent County Department of Public Safety\r\n" +
        "2012-00530093~~Leipsic Fire Company\r\n" +
        "2012-00540260~~Little Creek Fire Company\r\n" +
        "~\r\n" +
        "Units Sent:~9\r\n" +
        "P54F, P53F, 537, 536, 535, 532, R54, 545, 544~\r\n" +
        "\r\n" +
        "Alerts:\r\n" +
        "~\r\n" +
        "Location Alerts\r\n" +
        "\r\n" +
        "Person Alerts\r\n" +
        "\r\n" +
        "Vehicle Alerts\r\n" +
        "~~\r\n" +
        "Narrative:\r\n" +
        "\r\n" +
        "Narrative Time~Narrative\r\n" +
        "10/29/12 18:05:55~AFA SMOKE DECT BASEMENT\r\n" +
        "10/29/12 18:06:02~ProQA Medical Questionnaire Aborted - 8. Non-medical call\r\n" +
        "10/29/12 18:06:07~New ProQA Fire Case Number has been assigned: -660120\r\n" +
        "10/29/12 18:07:23~Alarms.  Residential (single)  (Smoke detector).Caller Statement: BASEMENT SMOKE DECT.  1.The caller is an alarm monitoring company.  2.It is a smoke detector alarm.  3.The incident involves a single-family residential structure.  4.The name of the business/resident/owner is: L.CARREY  5.The area or zone activated is: BASEMENT/ZONE 1  6.The phone number of the business/resident/owner is: 3027304042-Comments: L.CARREY--Comments: BASEMENT/ZONE 1--Comments: 3027304042-\r\n" +
        "10/29/12 18:07:23~ProQA Fire Dispatch Message Sent; Chief Complaint Number: 52; Dispatch Level: 52B01; Dispatch Level Suffix: S; Response Text: o\r\n" +
        "10/29/12 18:07:37~Alarms.  Residential (single)  (Smoke detector).Caller Statement: BASEMENT SMOKE DECT.  1.The caller is an alarm monitoring company.  2.It is a smoke detector alarm.  3.The incident involves a single-family residential structure.  4.The name of the business/resident/owner is: L.CARREY  5.The area or zone activated is: BASEMENT/ZONE 1  6.The phone number of the business/resident/owner is: 3027304042-Comments: L.CARREY--Comments: BASEMENT/ZONE 1--Comments: 3027304042-\r\n" +
        "10/29/12 18:07:37~ProQA Fire Questionnaire Completed; Chief Complaint Number: 52; Dispatch Level: 52B01; Dispatch Level Suffix: S; Response Text: o\r\n" +
        "\r\n",

        "ADDR:30 TEXAS LN",
        "CITY:Dover",
        "X:MAIN ST / SAVANNAH RD",
        "PHONE:(800) 932-3822",
        "SRC:Station 53",
        "MAP:53B",
        "ID:190",
        "CALL:Alarms-Residential (single)",
        "PRI:4",
        "NAME:CMH, ADVANTECH",
        "DATE:10/29/2012",
        "TIME:18:07:57",
        "UNIT:P54F, P53F, 537, 536, 535, 532, R54, 545, 544",
        "INFO:AFA SMOKE DECT BASEMENT / ProQA Medical Questionnaire Aborted - 8. Non-medical call / New ProQA Fire Case Number has been assigned: -660120 / Alarms.  Residential (single)  (Smoke detector).Caller Statement: BASEMENT SMOKE DECT.  1.The caller is an alarm monitoring company.  2.It is a smoke detector alarm.  3.The incident involves a single-family residential structure.  4.The name of the business/resident/owner is: L.CARREY  5.The area or zone activated is: BASEMENT/ZONE 1  6.The phone number of the business/resident/owner is: 3027304042-Comments: L.CARREY--Comments: BASEMENT/ZONE 1--Comments: 3027304042- / ProQA Fire Dispatch Message Sent; Chief Complaint Number: 52; Dispatch Level: 52B01; Dispatch Level Suffix: S; Response Text: o / Alarms.  Residential (single)  (Smoke detector).Caller Statement: BASEMENT SMOKE DECT.  1.The caller is an alarm monitoring company.  2.It is a smoke detector alarm.  3.The incident involves a single-family residential structure.  4.The name of the business/resident/owner is: L.CARREY  5.The area or zone activated is: BASEMENT/ZONE 1  6.The phone number of the business/resident/owner is: 3027304042-Comments: L.CARREY--Comments: BASEMENT/ZONE 1--Comments: 3027304042- / ProQA Fire Questionnaire Completed; Chief Complaint Number: 52; Dispatch Level: 52B01; Dispatch Level Suffix: S; Response Text: o");

    doTest("T8",
        "(Rip and Run Report) Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~3034~S ~DUPONT~BLVD~\n" +
        "Additional Location Information:FLR GRD\n" +
        "Common Name:~ PINNACLE HEALTH AND REHAB CTR\n" +
        "Venue:~Smyrna\n" +
        "Cross Streets~\n" +
        "UNKNOWN / VILLAGE DR\n" +
        "Phone:~(302) 653-5085\n" +
        "Station:~Station 44\n" +
        "Quadrant:~44F\n" +
        "District:~44A (64 EMS)\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~4277\n" +
        "Call Type:~ 33C2T Transfer/Interfacility\n" +
        "Source:~911\n" +
        "Priority:~ 3\n" +
        "Status:~In Progress\n" +
        "Caller:~PRICE,~CICILIA\n" +
        "Call Date/Time:~04/08/2013 12:00:20\n" +
        "Dispatch Date/Time:~04/08/2013 12:02:10\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-06702948~~Kent County Emergency Medical Services\n" +
        "2013-00640798~~Smyrna Americian Legion Ambulance\n" +
        "~\n" +
        "Units Sent:~2\n" +
        "KM6A, A64~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "04/08/13 12:00:20~E911 Info - Class of Service: BUS Special Response Info: POLICE:   STATE POLICE        FIRE:     STATION 44          MEDICAL:\n" +
        "04/08/13 12:00:34~SIERRA RM 130 B\n" +
        "04/08/13 12:01:58~Problem: LOW SAT .  Patient Info: 1 patient(s); 66 Years old; Female; Conscious: Yes; Breathing: Yes;\n" +
        "04/08/13 12:01:58~ProQA Medical Dispatch Message Sent; Dispatch Code: 33-C-02T\n" +
        "04/08/13 12:01:58~You are responding to a patient transfer or medical care facility situation.  The patient is a 66-year-old female, who is conscious and breathing.  Abnormal breathing (acute onset)  (Transfer).  1.This call is a result of an evaluation by a nurse or doctor.  2.This is a transfer/interfacility case.  3.She is completely alert (responding appropriately).  4.She is not breathing normally.  5.This is a sudden or unexpected change in her condition.  6.She does not have significant bleeding or symptoms of shock.  7.She is not in severe pain.  8.Special equipment is not necessary.  9.Additional personnel will not be needed.\n" +
        "04/08/13 12:02:04~ProQA Medical Key Questions have been completed; Dispatch Code: 33-C-02T\n" +
        "04/08/13 12:02:04~10.MD/RN names and facility numbers (as applicable) have been obtained outside of ProQA.\n" +
        "04/08/13 12:02:04~Problem: LOW SAT .  Patient Info: 1 patient(s); 66 Years old; Female; Conscious: Yes; Breathing: Yes;\n\n\n",

        "ADDR:3034 S  DUPONT BLVD",
        "APT:FLR GRD",
        "PLACE:PINNACLE HEALTH AND REHAB CTR",
        "CITY:Smyrna",
        "X:UNKNOWN / VILLAGE DR",
        "PHONE:(302) 653-5085",
        "SRC:Station 44",
        "MAP:44F-44A (64 EMS)",
        "ID:4277",
        "CALL:33C2T Transfer/Interfacility",
        "PRI:3",
        "NAME:PRICE, CICILIA",
        "DATE:04/08/2013",
        "TIME:12:02:10",
        "UNIT:KM6A, A64",
        "INFO:E911 Info - Class of Service: BUS Special Response Info: POLICE:   STATE POLICE        FIRE:     STATION 44          MEDICAL: / SIERRA RM 130 B / Problem: LOW SAT .  Patient Info: 1 patient(s); 66 Years old; Female; Conscious: Yes; Breathing: Yes; / ProQA Medical Dispatch Message Sent; Dispatch Code: 33-C-02T / You are responding to a patient transfer or medical care facility situation.  The patient is a 66-year-old female, who is conscious and breathing.  Abnormal breathing (acute onset)  (Transfer).  1.This call is a result of an evaluation by a nurse or doctor.  2.This is a transfer/interfacility case.  3.She is completely alert (responding appropriately).  4.She is not breathing normally.  5.This is a sudden or unexpected change in her condition.  6.She does not have significant bleeding or symptoms of shock.  7.She is not in severe pain.  8.Special equipment is not necessary.  9.Additional personnel will not be needed. / ProQA Medical Key Questions have been completed; Dispatch Code: 33-C-02T / 10.MD/RN names and facility numbers (as applicable) have been obtained outside of ProQA. / Problem: LOW SAT .  Patient Info: 1 patient(s); 66 Years old; Female; Conscious: Yes; Breathing: Yes;");

  }
  
  public static void main(String[] args) {
    new DEKentCountyDParserTest().generateTests("T1");
  }
}
    		