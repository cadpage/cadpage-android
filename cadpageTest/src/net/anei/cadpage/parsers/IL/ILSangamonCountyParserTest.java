package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sangamon County, IL
Contact: Kirk Polley <kpolley03@gmail.com>
Sender: messaging@iamresponding.com 

Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~400~SATTLEY~ST~\nVenue:~ROCHESTER\nCross Streets~\nE 1ST ST / E 2ND ST\nQuadrant:~ROCHESTER\nDistrict:~Sangamon\n~\nCall Information:\n\nCall Number:~75\nCall Type:~ Cardiac Problem\nSource:~Phone\nPriority:~ High\nStatus:~Aid Call\nAssigned To:~City Fire Phones\nCaller:~FORD,~JODY\nCall Date/Time:~02/14/2013 08:45:07\nDispatch Date/Time:~02/14/2013 08:47:22\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~02/14/2013 08:47:26\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000757~~Lifestar Ambulance\n2013-00000047~~Rochester Fire Protection District ~ Units Sent:~2 RO1, 3F24~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n02/14/13 08:46:07~61YO MALE FAINTED AND IS DIZZY/FATIGUED\n02/14/13 08:46:11~HX OF CARDIAC\n02/14/13 08:46:53~10-D-4
Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~5400~CARDINAL HILL~RD~\nVenue:~ROCHESTER\nCross Streets~\nBRANER RD / CHICKEN BRISTLE RD\n JOHNSON RD\nQuadrant:~ROCHESTER\nDistrict:~Sangamon\n~\nCall Information:\n\nCall Number:~579\nCall Type:~ Seizure\nSource:~Phone\nPriority:~ High\nStatus:~Aid Call\nAssigned To:~County  5\nCaller:~LEE,~JANET\nCall Date/Time:~02/12/2013 06:45:25\nDispatch Date/Time:~02/12/2013 06:48:30\nArrive Date/Time:~\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~\n~\nIncident Number(s)\n2013-00000044~~Rochester Fire Protection District 2013-00001024~~Springfield\nArea Ambulance ~ Units Sent:~2 RO1, 3F95~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n02/12/13 06:46:49~62  consc/breathing/NOT ALERT\n02/12/13 06:47:09~HE IS SCREAMING KEEPS MOVING HIS LEGS UP AND DOWN AND\nDOESN'T RECOGNIZE THE 17\n02/12/13 06:47:34~HE IS FOAMING FROM THE MOUTH NOW\n02/12/13 06:47:52~12-C-1\n02/12/13 06:48:03~HE IS STILL JERKING\n02/12/13 06:48:38~DOOR IS UNLOCKED\n02/12/13 06:49:02~SHE DID WAKE UP IN THE MIDDLE OF THE NIGHT AND HE WAS\nCLAMMY AND ACTING STRANGE POSS HIS 2ND SEIZURE OF THE NIGHT BUT HAS NO HX OF\nSEIZURES
Rip and Run Report\n\n~\nLocation Information:\n\nLocation:~~STATE~ST/~E ~STATE RT 29\nVenue:~ROCHESTER\nCross Streets~\nQuadrant:~ROCHESTER\nDistrict:~Sangamon\n~\nCall Information:\n\nCall Number:~119\nCall Type:~ Accident w/Injuries\nSource:~Phone\nPriority:~ High\nStatus:~Investigation\nAssigned To:~County 1\nCaller:~JONES,~MELISSA\nCall Date/Time:~01/23/2013 09:14:37\nDispatch Date/Time:~01/23/2013 09:15:45\nArrive Date/Time:~01/23/2013 09:18:40\nClear Date/Time:~\nEnroute Date/Time:~\nLatest Unit Cleared Date/Time:~01/23/2013 09:21:34 ~ Incident Number(s)\n2013-00000387~~Lifestar Ambulance 2013-00000018~~Rochester Fire Protection\nDistrict 2013-00000101~~Rochester Police Department 2013-00002041~~Sangamon\nCo Sheriff's Office ~ Units Sent:~5 RO1, 3F21, 743, 119, 117~\n\nAlerts:\n~\nLocation Alerts\n\nPerson Alerts\n\nVehicle Alerts\n~~\nNarrative:\n\nNarrative Time~Narrative\n01/23/13 09:15:13~BLU FORD SUV &amp; WHI WORK TRUCK\n01/23/13 09:15:50~NO INJS\n01/23/13 09:16:17~2ND CALLER JARRED MILLER 821-5426\n01/23/13 09:16:24~HEAD-ON COLLISION\n01/23/13 09:17:05~LARGE WHI BUCKET TRUCK AND DK BLU FORD EXPLORER\n01/23/13 09:19:28~VEHS ARE ACROSS INTERSECTION FROM EACH OTHER NOW\n01/23/13 09:20:52~MALE SUBJ  NEEDS CHECKED OUT HE WILL BE IN TRUE VALUE LOT\n01/23/13 09:22:36~ROP1 IS 10-8\n01/23/13 09:23:00~ROP6 &amp; P7 ARE 10-8\n01/23/13 09:23:37~RO13 IS 10-8\n01/23/13 09:23:52~ROP7 IS 10-23\n01/23/13 09:24:23~ROP11 IS 10-8\n01/23/13 09:24:30~RO10 IS 10-8\n

*/

public class ILSangamonCountyParserTest extends BaseParserTest {
  
  public ILSangamonCountyParserTest() {
    setParser(new ILSangamonCountyParser(), "SANGAMON COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~400~SATTLEY~ST~\n" +
        "Venue:~ROCHESTER\n" +
        "Cross Streets~\n" +
        "E 1ST ST / E 2ND ST\n" +
        "Quadrant:~ROCHESTER\n" +
        "District:~Sangamon\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~75\n" +
        "Call Type:~ Cardiac Problem\n" +
        "Source:~Phone\n" +
        "Priority:~ High\n" +
        "Status:~Aid Call\n" +
        "Assigned To:~City Fire Phones\n" +
        "Caller:~FORD,~JODY\n" +
        "Call Date/Time:~02/14/2013 08:45:07\n" +
        "Dispatch Date/Time:~02/14/2013 08:47:22\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~02/14/2013 08:47:26\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000757~~Lifestar Ambulance\n" +
        "2013-00000047~~Rochester Fire Protection District ~ Units Sent:~2 RO1, 3F24~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "02/14/13 08:46:07~61YO MALE FAINTED AND IS DIZZY/FATIGUED\n" +
        "02/14/13 08:46:11~HX OF CARDIAC\n" +
        "02/14/13 08:46:53~10-D-4",

        "ADDR:400 SATTLEY ST",
        "CITY:ROCHESTER",
        "X:E 1ST ST / E 2ND ST",
        "ID:75",
        "CALL:Cardiac Problem",
        "PRI:High",
        "NAME:FORD, JODY",
        "DATE:02/14/2013",
        "TIME:08:47:22");

    doTest("T2",
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~5400~CARDINAL HILL~RD~\n" +
        "Venue:~ROCHESTER\n" +
        "Cross Streets~\n" +
        "BRANER RD / CHICKEN BRISTLE RD\n" +
        " JOHNSON RD\n" +
        "Quadrant:~ROCHESTER\n" +
        "District:~Sangamon\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~579\n" +
        "Call Type:~ Seizure\n" +
        "Source:~Phone\n" +
        "Priority:~ High\n" +
        "Status:~Aid Call\n" +
        "Assigned To:~County  5\n" +
        "Caller:~LEE,~JANET\n" +
        "Call Date/Time:~02/12/2013 06:45:25\n" +
        "Dispatch Date/Time:~02/12/2013 06:48:30\n" +
        "Arrive Date/Time:~\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~\n" +
        "~\n" +
        "Incident Number(s)\n" +
        "2013-00000044~~Rochester Fire Protection District 2013-00001024~~Springfield\n" +
        "Area Ambulance ~ Units Sent:~2 RO1, 3F95~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "02/12/13 06:46:49~62  consc/breathing/NOT ALERT\n" +
        "02/12/13 06:47:09~HE IS SCREAMING KEEPS MOVING HIS LEGS UP AND DOWN AND\n" +
        "DOESN'T RECOGNIZE THE 17\n" +
        "02/12/13 06:47:34~HE IS FOAMING FROM THE MOUTH NOW\n" +
        "02/12/13 06:47:52~12-C-1\n" +
        "02/12/13 06:48:03~HE IS STILL JERKING\n" +
        "02/12/13 06:48:38~DOOR IS UNLOCKED\n" +
        "02/12/13 06:49:02~SHE DID WAKE UP IN THE MIDDLE OF THE NIGHT AND HE WAS\n" +
        "CLAMMY AND ACTING STRANGE POSS HIS 2ND SEIZURE OF THE NIGHT BUT HAS NO HX OF\n" +
        "SEIZURES",

        "ADDR:5400 CARDINAL HILL RD",
        "CITY:ROCHESTER",
        "X:BRANER RD / CHICKEN BRISTLE RD",
        "ID:579",
        "CALL:Seizure",
        "PRI:High",
        "NAME:LEE, JANET",
        "DATE:02/12/2013",
        "TIME:06:48:30");

    doTest("T3",
        "Rip and Run Report\n\n" +
        "~\n" +
        "Location Information:\n\n" +
        "Location:~~STATE~ST/~E ~STATE RT 29\n" +
        "Venue:~ROCHESTER\n" +
        "Cross Streets~\n" +
        "Quadrant:~ROCHESTER\n" +
        "District:~Sangamon\n" +
        "~\n" +
        "Call Information:\n\n" +
        "Call Number:~119\n" +
        "Call Type:~ Accident w/Injuries\n" +
        "Source:~Phone\n" +
        "Priority:~ High\n" +
        "Status:~Investigation\n" +
        "Assigned To:~County 1\n" +
        "Caller:~JONES,~MELISSA\n" +
        "Call Date/Time:~01/23/2013 09:14:37\n" +
        "Dispatch Date/Time:~01/23/2013 09:15:45\n" +
        "Arrive Date/Time:~01/23/2013 09:18:40\n" +
        "Clear Date/Time:~\n" +
        "Enroute Date/Time:~\n" +
        "Latest Unit Cleared Date/Time:~01/23/2013 09:21:34 ~ Incident Number(s)\n" +
        "2013-00000387~~Lifestar Ambulance 2013-00000018~~Rochester Fire Protection\n" +
        "District 2013-00000101~~Rochester Police Department 2013-00002041~~Sangamon\n" +
        "Co Sheriff's Office ~ Units Sent:~5 RO1, 3F21, 743, 119, 117~\n\n" +
        "Alerts:\n" +
        "~\n" +
        "Location Alerts\n\n" +
        "Person Alerts\n\n" +
        "Vehicle Alerts\n" +
        "~~\n" +
        "Narrative:\n\n" +
        "Narrative Time~Narrative\n" +
        "01/23/13 09:15:13~BLU FORD SUV &amp; WHI WORK TRUCK\n" +
        "01/23/13 09:15:50~NO INJS\n" +
        "01/23/13 09:16:17~2ND CALLER JARRED MILLER 821-5426\n" +
        "01/23/13 09:16:24~HEAD-ON COLLISION\n" +
        "01/23/13 09:17:05~LARGE WHI BUCKET TRUCK AND DK BLU FORD EXPLORER\n" +
        "01/23/13 09:19:28~VEHS ARE ACROSS INTERSECTION FROM EACH OTHER NOW\n" +
        "01/23/13 09:20:52~MALE SUBJ  NEEDS CHECKED OUT HE WILL BE IN TRUE VALUE LOT\n" +
        "01/23/13 09:22:36~ROP1 IS 10-8\n" +
        "01/23/13 09:23:00~ROP6 &amp; P7 ARE 10-8\n" +
        "01/23/13 09:23:37~RO13 IS 10-8\n" +
        "01/23/13 09:23:52~ROP7 IS 10-23\n" +
        "01/23/13 09:24:23~ROP11 IS 10-8\n" +
        "01/23/13 09:24:30~RO10 IS 10-8\n",

        "ADDR:STATE ST & E  STATE RT 29",
        "MADDR:STATE ST & E  STATE 29",
        "CITY:ROCHESTER",
        "ID:119",
        "CALL:Accident w/Injuries",
        "PRI:High",
        "NAME:JONES, MELISSA",
        "DATE:01/23/2013",
        "TIME:09:15:45");
  
  }
  
  public static void main(String[] args) {
    new ILSangamonCountyParserTest().generateTests("T1");
  }
}