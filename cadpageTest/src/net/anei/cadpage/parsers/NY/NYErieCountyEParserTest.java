package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYErieCountyEParser;

import org.junit.Test;

/*
Erie County, NY

Contact: nyerpa96 <nyerpa96@gmail.com>
Contact: Scott Yager <yagers13@yahoo.com>
Contact: Ron Becker <wcfireman03@gmail.com>
ALERT@ERIE.GOV FIRE CO-DETECTOR 262 MILLER ST APT: GARAGE LANCASTER TOWN CO DETECTOR ACTIV / NO SYMPTOMS
ALERT@ERIE.GOV EMS 4779 TRANSIT RD LANCASTER TOWN GREEN DODGE CALIBER 25 YO FEMALE FEELS AS THOUGH SHE MAY PASS OUT
ALERT@ERIE.GOV EMS 4805 TRANSIT RD APT: 1106 LANCASTER TOWN EMS- 59 YO MALE, LEG PAIN AS A RESULT OF A FALL EARLIER
ALERT@ERIE.GOV EMS 48 BENTLEY CR LANCASTER TOWN 79 Y/O FEMALE LETHARGIC
ALERT@ERIE.GOV FIRE CO-DETECTOR 47 VIA DONATO E LANCASTER TOWN CO DETECTOR NO SYMPTOMS REFER TWIN DISTRICT FD
ALERT@ERIE.GOV EMS 4805 TRANSIT RD APT: 3105 LANCASTER TOWN EMS/66 YO FEMALE SEVERE HEADACHE/GENERAL ILLNESS REFER TWIN DISTRICT FD REF
ALERT@ERIE.GOV FIRE-COMMERCIAL 2170 UNION RD WSE GENERAL FIRE ALARM GOING OFF.
ALERT@ERIE.GOV EMS 13191 CENTERLINE RD F-FELL UNK IF INJURED

Contact: Todd Rzeszutek <firefighter5502@yahoo.com>
Sender: 9300xxxx
NOTIFICATIONS 85 MANITOU ST DEPEW DEPEW FIRE DEPARTMENT- DAILY TEST
NOTIFICATIONS 85 MANITOU ST DEPEW CONDUCTED THE DAILY FIRE RADIO AND PAGER TEST
4569 BROADWAY DEPEW COMMERCIAL FIRE ALARM COMING FROM THE BANQUET ROOM

Contact: Kira Wilson <kira.jeanne0106@gmail.com>
ALERT@ERIE.GOV EMS DOG BITE 140 VALLEY VIEW

Contact: Bob Taylor <btthevoice@gmail.com>
Sender: 15373@alert.erie.gov
(Call) FIRE RESIDENTIAL 6680 LAKE SHORE RD EVANS FOREGIN OBJECT STRUCK A LIVE ELECTRICAL OUTLET.?\n
(Call) EMS 1425 STURGEON PT RD EVANS H/NE/RM ACT  CARBON MONOXIDE DETECTOR WITH ILLNESS IN THE RESIDENCE?\n
(Call) NE ACT FOR A ENGINE M/A TO LAKEVIEW FOR AN AUTO ACCIDENT ROUTE 5 AND OLD LAKESHORE RD?\n
(Call) WIRES DOWN 7967 KEENE RD @ BURNS DISP NE - PATROL REQUESTING A CHIEF TO THE SCENE FOR WIRES IN THE TREE ARCHING?\n
(Call) RE TRANSMIT OF PAGE FOR INJURY ACCIDENT IFO 8061 SOUTHWESTERN-NORTH EVANS ONLY?\r\n
(Call) ALARM RINGING 8545 N MAIN ST EVANS FIRE ALARM ACTIVATION COMING FROM FIRE PANEL?\r\n

Contact: "Chuck" <lebhoser@yahoo.com>
Sender: ALERT@ERIE.GOV
ALERT@ERIE.GOV EMS 10703 PERRY ST BRANT ELDERLY FEMALE FELL, LIFT ASSSIT

Not yet implemented!
Contact: peter putnam <medic4451@gmail.com>
Sender: 17165415102
Erie_Alert MUTUAL AID TO LAKEVIEW - FIRE ALARM ACTIVATION AT 5502 BIRCHWOOD.  <NOREPLY>


Possible call code values

AMA             MUTUAL AID-Automatic Mutual Aid                   
AP              AIRPORT ALERT                                    
AST             MISCELLANEOUS-Assist                             
BA              ALARMS-Box Alarm                                 
DUP             Duplicate Call                                    
E911            Emergency Call                                    
EMA             ALARMS-EMS Alarm                                 
EMS             EMS-Emergency Medical Service                    
EMSC            EMS-Emergency Medical Service Cold               
F               Structure                                        
FAL             ALARMS-Fire Alarm Activation                     
HM              HAZMAT-Leak, Spill                               
MAA             MUTUAL AID-Ambulance                             
MAF             MUTUAL AID-Fire                                  
MAR             MUTUAL AID-Rescue                                
MAS             MUTUAL AID-Standby                               
MF              Miscellaneous                                    
MVA             EMS-Motor Vehicle Accident                       
MVF             Motor Vehicle                                    
NOT             Notification                                     
POL             Police Emergency                                 
R               EMS-Rescue                                       
SA              Silent Alarm                                     
TR              EMS-Transportation                               
TRC             EMS-Transportation Cold                          
TRH             EMS-Transportation Hot  
*/

public class NYErieCountyEParserTest extends BaseParserTest {
  
  public NYErieCountyEParserTest() {
    setParser(new NYErieCountyEParser(), "ERIE COUNTY", "NY");
    
    // This is for the test generator, For unit tests it will be reset
    // the the default value before each test run
    setFromAddress("9300xxxx");
  }
  
  @Test
  public void testErieParser() {
    doTest("T1",
        "ALERT@ERIE.GOV FIRE CO-DETECTOR 262 MILLER ST APT: GARAGE LANCASTER TOWN CO DETECTOR ACTIV / NO SYMPTOMS",
        "CALL:FIRE CO-DETECTOR",
        "ADDR:262 MILLER ST",
        "APT:GARAGE",
        "CITY:LANCASTER TOWN",
        "INFO:CO DETECTOR ACTIV / NO SYMPTOMS");

    doTest("T2",
        "ALERT@ERIE.GOV EMS 4779 TRANSIT RD LANCASTER TOWN GREEN DODGE CALIBER 25 YO FEMALE FEELS AS THOUGH SHE MAY PASS OUT",
        "CALL:EMS",
        "ADDR:4779 TRANSIT RD",
        "CITY:LANCASTER TOWN",
        "INFO:GREEN DODGE CALIBER 25 YO FEMALE FEELS AS THOUGH SHE MAY PASS OUT");

    doTest("T3",
        "ALERT@ERIE.GOV EMS 4805 TRANSIT RD APT: 1106 LANCASTER TOWN EMS- 59 YO MALE, LEG PAIN AS A RESULT OF A FALL EARLIER",
        "CALL:EMS",
        "ADDR:4805 TRANSIT RD",
        "APT:1106",
        "CITY:LANCASTER TOWN",
        "INFO:EMS- 59 YO MALE, LEG PAIN AS A RESULT OF A FALL EARLIER");

    doTest("T4",
        "ALERT@ERIE.GOV EMS 48 BENTLEY CR LANCASTER TOWN 79 Y/O FEMALE LETHARGIC",
        "CALL:EMS",
        "ADDR:48 BENTLEY CR",
        "MADDR:48 BENTLEY CIR",
        "CITY:LANCASTER TOWN",
        "INFO:79 Y/O FEMALE LETHARGIC");
    
    doTest("T5",
        "ALERT@ERIE.GOV FIRE CO-DETECTOR 47 VIA DONATO E LANCASTER TOWN CO DETECTOR NO SYMPTOMS REFER TWIN DISTRICT FD",
        "CALL:FIRE CO-DETECTOR",
        "ADDR:47 VIA DONATO E",
        "CITY:LANCASTER TOWN",
        "INFO:CO DETECTOR NO SYMPTOMS REFER TWIN DISTRICT FD");

    doTest("T6",
        "ALERT@ERIE.GOV FIRE-COMMERCIAL 2170 UNION RD WSE GENERAL FIRE ALARM GOING OFF.",
        "CALL:FIRE-COMMERCIAL",
        "ADDR:2170 UNION RD",
        "CITY:WEST SENECA",
        "INFO:GENERAL FIRE ALARM GOING OFF.");

    doTest("T7",
        "ALERT@ERIE.GOV EMS 13191 CENTERLINE RD F-FELL UNK IF INJURED",
        "CALL:EMS",
        "ADDR:13191 CENTERLINE RD",
        "INFO:F-FELL UNK IF INJURED");

  }
  
  @Test
  public void testDepewParser() {
    setFromAddress("9300xxxxxx");

    doTest("T1",
        "NOTIFICATIONS 85 MANITOU ST DEPEW DEPEW FIRE DEPARTMENT- DAILY TEST",
        "CALL:NOTIFICATIONS",
        "ADDR:85 MANITOU ST",
        "CITY:DEPEW",
        "INFO:DEPEW FIRE DEPARTMENT- DAILY TEST");

    doTest("T2",
        "NOTIFICATIONS 85 MANITOU ST DEPEW CONDUCTED THE DAILY FIRE RADIO AND PAGER TEST",
        "CALL:NOTIFICATIONS",
        "ADDR:85 MANITOU ST",
        "CITY:DEPEW",
        "INFO:CONDUCTED THE DAILY FIRE RADIO AND PAGER TEST");

    doTest("T3",
        "4569 BROADWAY DEPEW COMMERCIAL FIRE ALARM COMING FROM THE BANQUET ROOM",
        "CALL:COMMERCIAL FIRE ALARM COMING FROM THE BANQUET ROOM",
        "ADDR:4569 BROADWAY",
        "CITY:DEPEW");
    
  }
  
  @Test
  public void testEvansParser() {

    doTest("T1",
        "(Call) FIRE RESIDENTIAL 6680 LAKE SHORE RD EVANS FOREGIN OBJECT STRUCK A LIVE ELECTRICAL OUTLET.?\n",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:6680 LAKE SHORE RD",
        "CITY:EVANS",
        "INFO:FOREGIN OBJECT STRUCK A LIVE ELECTRICAL OUTLET.");

    doTest("T2",
        "(Call) EMS 1425 STURGEON PT RD EVANS H/NE/RM ACT  CARBON MONOXIDE DETECTOR WITH ILLNESS IN THE RESIDENCE?\n",
        "CALL:EMS",
        "ADDR:1425 STURGEON PT RD",
        "CITY:EVANS",
        "INFO:H/NE/RM ACT  CARBON MONOXIDE DETECTOR WITH ILLNESS IN THE RESIDENCE");

    doTest("T3",
        "(Call) NE ACT FOR A ENGINE M/A TO LAKEVIEW FOR AN AUTO ACCIDENT ROUTE 5 AND OLD LAKESHORE RD\n",
        "CALL:NE ACT FOR A ENGINE M/A TO LAKEVIEW FOR AN AUTO ACCIDENT",
        "ADDR:ROUTE 5 AND OLD LAKESHORE RD",
        "MADDR:ROUTE 5 & OLD LAKESHORE RD");

    doTest("T4",
        "(Call) WIRES DOWN 7967 KEENE RD @ BURNS DISP NE - PATROL REQUESTING A CHIEF TO THE SCENE FOR WIRES IN THE TREE ARCHING?\n",
        "CALL:WIRES DOWN 7967 KEENE RD",
        "ADDR:BURNS DISP NE - PATROL REQUESTING A CHIEF TO THE SCENE FOR WIRES IN THE TREE ARCHING");

    doTest("T5",
        "(Call) RE TRANSMIT OF PAGE FOR INJURY ACCIDENT IFO 8061 SOUTHWESTERN-NORTH EVANS ONLY?\r\n",
        "CALL:RE TRANSMIT OF PAGE FOR INJURY ACCIDENT IFO",
        "ADDR:8061 SOUTHWESTERN-NORTH",
        "CITY:EVANS",
        "INFO:ONLY");

    doTest("T6",
        "(Call) ALARM RINGING 8545 N MAIN ST EVANS FIRE ALARM ACTIVATION COMING FROM FIRE PANEL?\r\n",
        "CALL:ALARM RINGING",
        "ADDR:8545 N MAIN ST",
        "CITY:EVANS",
        "INFO:FIRE ALARM ACTIVATION COMING FROM FIRE PANEL");

  }
  
  @Test
  public void testChuck() {

    doTest("T1",
        "ALERT@ERIE.GOV EMS 10703 PERRY ST BRANT ELDERLY FEMALE FELL, LIFT ASSSIT",
        "CALL:EMS",
        "ADDR:10703 PERRY ST",
        "CITY:BRANT",
        "INFO:ELDERLY FEMALE FELL, LIFT ASSSIT");

  }
  
  public static void main(String[] args) {
    new NYErieCountyEParserTest().generateTests("T1");
  }
}