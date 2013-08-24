package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Dakota County, MN
Contact: Active911
Agency name: Miesville Fire and Rescue
Location: Miesville, MN, United States
Sender: CIS Active 911 <noreply@cisusa.org>

(Medical Call at 26674 144th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 26674 144th Ave Way, Welch, 55089\n\nMedical Call at 26674 144th Ave Way, Welch, 55089\n\nMiesville Fire Dept - 201300000009\n\nTime reported: 07/13/2013 11:32:21 AM\nTime completed: 07/13/2013 12:09:46 PM\n\nUnit(s) responded: \nMI1R\nwife has fallen on bike trail and has hip and shoulder pain. 1146 hours: Miesville chief 3 on scene 1149 hours: Brush 1 scene
(Medical Call at 26674 144th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 26674 144th Ave Way, Welch, 55089\n\nMedical Call at 26674 144th Ave Way, Welch, 55089\n\nMiesville Fire Dept - 201300000009\n\nTime reported: 07/13/2013 11:32:21 AM\n\n\nUnit(s) responded: \nMI1R\nwife has fallen on bike trail and has hip and shoulder pain.
(Medical Call at 13179 Highway 61, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 13179 Highway 61, Welch, 55089\n\nMedical Call at 13179 Highway 61, Welch, 55089\n\nMiesville Fire Dept - 201300000008\n\nTime reported: 07/12/2013 9:32:40 AM\nTime completed: 07/12/2013 9:51:42 AM\n\nUnit(s) responded: \nMI1R\n1210:   Lifeline rec'd a signal stating that she has fallen.   No response.  Deloris Lawrence residence premise ph/651-388-6213  Keybox for front door   code/888  Press help button once on scene.  Cancelled per MI1R - female is fine & did not know she pressed the button.  Amb cancelled.
(Medical Call at 13179 Highway 61, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 13179 Highway 61, Welch, 55089\n\nMedical Call at 13179 Highway 61, Welch, 55089\n\nMiesville Fire Dept - 201300000008\n\nTime reported: 07/12/2013 9:32:40 AM\n\n\nUnit(s) responded: \nMI1R\n1210:   Lifeline rec'd a signal stating that she has fallen.   No response.  Deloris Lawrence premise ph/651-388-6213  Keybox for front door   code/888  Press help button once on scene.
(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000007\n\nTime reported: 07/11/2013 3:04:49 PM\nTime completed: 07/11/2013 3:33:40 PM\n\nUnit(s) responded: \nMI1R\nrequest for ambulance for female extremely intoxicated and non responsive.
(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000007\n\nTime reported: 07/11/2013 3:04:49 PM\n\n\nUnit(s) responded: \nMI1R\nrequest for ambulance for female extremely intoxicated and non responsive.
(Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089) Notification from CIS Active 911:\n\nGrass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\nGrass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000006\n\nTime reported: 07/10/2013 2:30:15 PM\nTime completed: 07/10/2013 5:18:42 PM\n\nUnit(s) responded: \nMIFD\n1211 check on a grass fire on 18/prairie island  100 yard long grass fire by the rr tracks co 18/prairie island blvd
(Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089) Notification from CIS Active 911:\n\nGrass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\nGrass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000006\n\nTime reported: 07/10/2013 2:30:15 PM\n\n\nUnit(s) responded: \n1211 check on a grass fire on 18/prairie island  100 yard long grass fire by the rr tracks co 18/prairie island blvd
(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000005\n\nTime reported: 07/04/2013 12:16:22 PM\nTime completed: 07/04/2013 12:55:07 PM\n\nUnit(s) responded: \nMI1R\nrequest for medical for party passed out on bridge in welch. she walked to the office and states she is fine no ambulance needed
(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000005\n\nTime reported: 07/04/2013 12:16:22 PM\n\n\nUnit(s) responded: \nMI1R\nrequest for medical for party passed out on bridge in welch.
(Fire Calls at Welch Trl/130th Ave, Welch, 55089) Notification from CIS Active 911:\n\nFire Calls at Welch Trl/130th Ave, Welch, 55089\n\nFire Calls at Welch Trl/130th Ave, Welch, 55089\n\nMiesville Fire Dept - 201300000004\n\nTime reported: 07/04/2013 11:56:36 AM\nTime completed: 07/04/2013 12:17:07 PM\n\nUnit(s) responded: \nMI1R\naccident with injuries Hastings ambulance sent for mutual aid
(Fire Calls at Welch Trl/130th Ave, Welch, 55089) Notification from CIS Active 911:\n\nFire Calls at Welch Trl/130th Ave, Welch, 55089\n\nFire Calls at Welch Trl/130th Ave, Welch, 55089\n\nMiesville Fire Dept - 201300000004\n\nTime reported: 07/04/2013 11:56:36 AM\n\n\nUnit(s) responded: \nMI1R\naccident with injuries
(Medical Call at 25330 140th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 25330 140th Ave Way, Welch, 55089\n\nMedical Call at 25330 140th Ave Way, Welch, 55089\n\nMiesville Fire Dept - 201300000003\n\nTime reported: 07/03/2013 4:15:50 PM\nTime completed: 07/03/2013 4:17:29 PM\n\nUnit(s) responded: \nMI1R
(Medical Call at 25330 140th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\nMedical Call at 25330 140th Ave Way, Welch, 55089\n\nMedical Call at 25330 140th Ave Way, Welch, 55089\n\nMiesville Fire Dept - 201300000003\n\nTime reported: 07/03/2013 4:15:50 PM\n\n\nUnit(s) responded: \nMI1R

*/

public class MNDakotaCountyParserTest extends BaseParserTest {
  
  public MNDakotaCountyParserTest() {
    setParser(new MNDakotaCountyParser(), "DAKOTA COUNTY", "MN");
  }
  
  @Test
  public void testMiesvilleFireAndRescue() {

    doTest("T1",
        "(Medical Call at 26674 144th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 26674 144th Ave Way, Welch, 55089\n\n" +
        "Medical Call at 26674 144th Ave Way, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000009\n\n" +
        "Time reported: 07/13/2013 11:32:21 AM\n" +
        "Time completed: 07/13/2013 12:09:46 PM\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "wife has fallen on bike trail and has hip and shoulder pain. 1146 hours: Miesville chief 3 on scene 1149 hours: Brush 1 scene",

        "CALL:RUN REPORT",
        "ID:201300000009",
        "PLACE:Medical Call at 26674 144th Ave Way, Welch, 55089\n\nMedical Call at 26674 144th Ave Way, Welch, 55089\n\nMiesville Fire Dept - 201300000009\n\nTime reported: 07/13/2013 11:32:21 AM\nTime completed: 07/13/2013 12:09:46 PM\n\nUnit(s) responded: \nMI1R\nwife has fallen on bike trail and has hip and shoulder pain. 1146 hours: Miesville chief 3 on scene 1149 hours: Brush 1 scene");

    doTest("T2",
        "(Medical Call at 26674 144th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 26674 144th Ave Way, Welch, 55089\n\n" +
        "Medical Call at 26674 144th Ave Way, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000009\n\n" +
        "Time reported: 07/13/2013 11:32:21 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "wife has fallen on bike trail and has hip and shoulder pain.",

        "CALL:Medical Call",
        "ADDR:26674 144th Ave Way",
        "CITY:Welch",
        "SRC:Miesville Fire Dept",
        "ID:201300000009",
        "DATE:07/13/2013",
        "TIME:11:32:21",
        "INFO:MI1R\nwife has fallen on bike trail and has hip and shoulder pain.");

    doTest("T3",
        "(Medical Call at 13179 Highway 61, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 13179 Highway 61, Welch, 55089\n\n" +
        "Medical Call at 13179 Highway 61, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000008\n\n" +
        "Time reported: 07/12/2013 9:32:40 AM\n" +
        "Time completed: 07/12/2013 9:51:42 AM\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "1210:   Lifeline rec'd a signal stating that she has fallen.   No response.  Deloris Lawrence residence premise ph/651-388-6213  Keybox for front door   code/888  Press help button once on scene.  Cancelled per MI1R - female is fine & did not know she pressed the button.  Amb cancelled.",

        "CALL:RUN REPORT",
        "ID:201300000008",
        "PLACE:Medical Call at 13179 Highway 61, Welch, 55089\n\nMedical Call at 13179 Highway 61, Welch, 55089\n\nMiesville Fire Dept - 201300000008\n\nTime reported: 07/12/2013 9:32:40 AM\nTime completed: 07/12/2013 9:51:42 AM\n\nUnit(s) responded: \nMI1R\n1210:   Lifeline rec'd a signal stating that she has fallen.   No response.  Deloris Lawrence residence premise ph/651-388-6213  Keybox for front door   code/888  Press help button once on scene.  Cancelled per MI1R - female is fine & did not know she pressed the button.  Amb cancelled.");

    doTest("T4",
        "(Medical Call at 13179 Highway 61, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 13179 Highway 61, Welch, 55089\n\n" +
        "Medical Call at 13179 Highway 61, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000008\n\n" +
        "Time reported: 07/12/2013 9:32:40 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "1210:   Lifeline rec'd a signal stating that she has fallen.   No response.  Deloris Lawrence premise ph/651-388-6213  Keybox for front door   code/888  Press help button once on scene.",

        "CALL:Medical Call",
        "ADDR:13179 Highway 61",
        "CITY:Welch",
        "SRC:Miesville Fire Dept",
        "ID:201300000008",
        "DATE:07/12/2013",
        "TIME:09:32:40",
        "INFO:MI1R\n1210:   Lifeline rec'd a signal stating that she has fallen.   No response.  Deloris Lawrence premise ph/651-388-6213  Keybox for front door   code/888  Press help button once on scene.");

    doTest("T5",
        "(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000007\n\n" +
        "Time reported: 07/11/2013 3:04:49 PM\n" +
        "Time completed: 07/11/2013 3:33:40 PM\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "request for ambulance for female extremely intoxicated and non responsive.",

        "CALL:RUN REPORT",
        "ID:201300000007",
        "PLACE:Medical Call at 26389 County 7 Blvd, Welch, 55089\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000007\n\nTime reported: 07/11/2013 3:04:49 PM\nTime completed: 07/11/2013 3:33:40 PM\n\nUnit(s) responded: \nMI1R\nrequest for ambulance for female extremely intoxicated and non responsive.");

    doTest("T6",
        "(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000007\n\n" +
        "Time reported: 07/11/2013 3:04:49 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "request for ambulance for female extremely intoxicated and non responsive.",

        "CALL:Medical Call",
        "ADDR:26389 County 7 Blvd",
        "CITY:Welch",
        "SRC:Miesville Fire Dept",
        "ID:201300000007",
        "DATE:07/11/2013",
        "TIME:15:04:49",
        "INFO:MI1R\nrequest for ambulance for female extremely intoxicated and non responsive.");

    doTest("T7",
        "(Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\n" +
        "Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000006\n\n" +
        "Time reported: 07/10/2013 2:30:15 PM\n" +
        "Time completed: 07/10/2013 5:18:42 PM\n\n" +
        "Unit(s) responded: \n" +
        "MIFD\n" +
        "1211 check on a grass fire on 18/prairie island  100 yard long grass fire by the rr tracks co 18/prairie island blvd",

        "CALL:RUN REPORT",
        "ID:201300000006",
        "PLACE:Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\nGrass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000006\n\nTime reported: 07/10/2013 2:30:15 PM\nTime completed: 07/10/2013 5:18:42 PM\n\nUnit(s) responded: \nMIFD\n1211 check on a grass fire on 18/prairie island  100 yard long grass fire by the rr tracks co 18/prairie island blvd");

    doTest("T8",
        "(Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\n" +
        "Grass Fire at County 18 Blvd/Prairie Island Blvd, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000006\n\n" +
        "Time reported: 07/10/2013 2:30:15 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "1211 check on a grass fire on 18/prairie island  100 yard long grass fire by the rr tracks co 18/prairie island blvd",

        "CALL:Grass Fire",
        "ADDR:County 18 Blvd & Prairie Island Blvd",
        "CITY:Welch",
        "SRC:Miesville Fire Dept",
        "ID:201300000006",
        "DATE:07/10/2013",
        "TIME:14:30:15",
        "INFO:1211 check on a grass fire on 18/prairie island  100 yard long grass fire by the rr tracks co 18/prairie island blvd");

    doTest("T9",
        "(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000005\n\n" +
        "Time reported: 07/04/2013 12:16:22 PM\n" +
        "Time completed: 07/04/2013 12:55:07 PM\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "request for medical for party passed out on bridge in welch. she walked to the office and states she is fine no ambulance needed",

        "CALL:RUN REPORT",
        "ID:201300000005",
        "PLACE:Medical Call at 26389 County 7 Blvd, Welch, 55089\n\nMedical Call at 26389 County 7 Blvd, Welch, 55089\n\nMiesville Fire Dept - 201300000005\n\nTime reported: 07/04/2013 12:16:22 PM\nTime completed: 07/04/2013 12:55:07 PM\n\nUnit(s) responded: \nMI1R\nrequest for medical for party passed out on bridge in welch. she walked to the office and states she is fine no ambulance needed");

    doTest("T10",
        "(Medical Call at 26389 County 7 Blvd, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Medical Call at 26389 County 7 Blvd, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000005\n\n" +
        "Time reported: 07/04/2013 12:16:22 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "request for medical for party passed out on bridge in welch.",

        "CALL:Medical Call",
        "ADDR:26389 County 7 Blvd",
        "CITY:Welch",
        "SRC:Miesville Fire Dept",
        "ID:201300000005",
        "DATE:07/04/2013",
        "TIME:12:16:22",
        "INFO:MI1R\nrequest for medical for party passed out on bridge in welch.");

    doTest("T11",
        "(Fire Calls at Welch Trl/130th Ave, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Fire Calls at Welch Trl/130th Ave, Welch, 55089\n\n" +
        "Fire Calls at Welch Trl/130th Ave, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000004\n\n" +
        "Time reported: 07/04/2013 11:56:36 AM\n" +
        "Time completed: 07/04/2013 12:17:07 PM\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "accident with injuries Hastings ambulance sent for mutual aid",

        "CALL:RUN REPORT",
        "ID:201300000004",
        "PLACE:Fire Calls at Welch Trl/130th Ave, Welch, 55089\n\nFire Calls at Welch Trl/130th Ave, Welch, 55089\n\nMiesville Fire Dept - 201300000004\n\nTime reported: 07/04/2013 11:56:36 AM\nTime completed: 07/04/2013 12:17:07 PM\n\nUnit(s) responded: \nMI1R\naccident with injuries Hastings ambulance sent for mutual aid");

    doTest("T12",
        "(Fire Calls at Welch Trl/130th Ave, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Fire Calls at Welch Trl/130th Ave, Welch, 55089\n\n" +
        "Fire Calls at Welch Trl/130th Ave, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000004\n\n" +
        "Time reported: 07/04/2013 11:56:36 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "MI1R\n" +
        "accident with injuries",

        "CALL:Fire Calls",
        "ADDR:Welch Trl & 130th Ave",
        "CITY:Welch",
        "SRC:Miesville Fire Dept",
        "ID:201300000004",
        "DATE:07/04/2013",
        "TIME:11:56:36",
        "INFO:MI1R\naccident with injuries");

    doTest("T13",
        "(Medical Call at 25330 140th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 25330 140th Ave Way, Welch, 55089\n\n" +
        "Medical Call at 25330 140th Ave Way, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000003\n\n" +
        "Time reported: 07/03/2013 4:15:50 PM\n" +
        "Time completed: 07/03/2013 4:17:29 PM\n\n" +
        "Unit(s) responded: \n" +
        "MI1R",

        "CALL:RUN REPORT",
        "ID:201300000003",
        "PLACE:Medical Call at 25330 140th Ave Way, Welch, 55089\n\nMedical Call at 25330 140th Ave Way, Welch, 55089\n\nMiesville Fire Dept - 201300000003\n\nTime reported: 07/03/2013 4:15:50 PM\nTime completed: 07/03/2013 4:17:29 PM\n\nUnit(s) responded: \nMI1R");

    doTest("T14",
        "(Medical Call at 25330 140th Ave Way, Welch, 55089) Notification from CIS Active 911:\n\n" +
        "Medical Call at 25330 140th Ave Way, Welch, 55089\n\n" +
        "Medical Call at 25330 140th Ave Way, Welch, 55089\n\n" +
        "Miesville Fire Dept - 201300000003\n\n" +
        "Time reported: 07/03/2013 4:15:50 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "MI1R",

        "CALL:Medical Call",
        "ADDR:25330 140th Ave Way",
        "CITY:Welch",
        "SRC:Miesville Fire Dept",
        "ID:201300000003",
        "DATE:07/03/2013",
        "TIME:16:15:50",
        "INFO:MI1R");

  }
  
  public static void main(String[] args) {
    new MNDakotaCountyParserTest().generateTests("T1");
  }
}
