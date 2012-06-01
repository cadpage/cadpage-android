package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJMonmouthCountyAParserTest extends BaseParserTest {
  
  public NJMonmouthCountyAParserTest() {
    setParser(new NJMonmouthCountyAParser(), "MONMOUTH COUNTY", "NJ");
  }
  
  @Test
  public void testRunReport() {
    doTest("T1", "(<mcsoza7@MCSONJ.ORG>) S: Automatic R&R Notification\n** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** ** ** ** ** **  \nIncident Number  : 2012-00000042                    ORI: 26-2          Station: STA 26-2  \nIncident Type  . : FIRS F FIRE STRUC           Priority: 1  \nIncident Location: 90 OAKLAND MILLS RD                                  Venue: MANALAPAN \n\nCall Time- 17:25:27                                Date- 01/19/2012  \nDispatch - 17:25:50     En-route- 17:29:37     On-scene- 17:31:16     Depart 1-  \nArrive 2 -              Depart 2-              In-statn-              Cleared - 18:18:23 \n\nArea: 26A4              Section :   33         Beat  . : 26A4  \nGrid:                   Quadrant: 262S         District: E262 \n\nPhone Number: (732) 308-4591                Call Source:  911 \n\nCaller. . . : ROB YUHAS \n\nUnits sent  :  \n 12-1        F12A                 26-2        F262A  \n 32-1        F32A                 12-1        1266  \n 12-1        1269                 12-1        1274  \n 12-1        1275                 26-2        26286  \n 32-1        3266                 32-1        3290  \n 32-1        3296                 26-2        26266  \n 26-2        26267                26-2        26290 \n\nNature of Call : CHIMNEY FIRE/ ADVISED TO EVACUATE \n\nAdditional Info  \n  RESD: \n\nNarrative  \n Information on the units assigned to the call follows.  \n     Unit#: F12A   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:25   ENR:            :    ARV:            :  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 17:30  \n     Unit#: 1266   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:36  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 1274   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:33   ENR: 01/19/12 17:33  ARV: 01/19/12 17:54  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 1275   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:34   ENR: 01/19/12 17:34  ARV: 01/19/12 17:40  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 1269   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:34   ENR: 01/19/12 17:34  ARV: 01/19/12 17:39  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: F262A  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:25   ENR:            :    ARV:            :  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 17:30  \n     Unit#: 26286  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:54  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 26266  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:31  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 26267  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:34  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 26290  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:33   ENR: 01/19/12 17:33  ARV: 01/19/12 17:36  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: F32A   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:25   ENR:            :    ARV:            :  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 17:30  \n     Unit#: 3290   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:36  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:08  \n     Unit#: 3266   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:37   ENR: 01/19/12 17:37  ARV: 01/19/12 17:45  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:08  \n     Unit#: 3296   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP:            :     ENR:            :    ARV: 01/19/12 17:40  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:08  \n PD 26 NTFD  \n CODE 2  \n 26 21",
           "CALL:RUN REPORT",
           "PLACE:** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** ** ** ** ** **  \nIncident Number  : 2012-00000042                    ORI: 26-2          Station: STA 26-2  \nIncident Type  . : FIRS F FIRE STRUC           Priority: 1  \nIncident Location: 90 OAKLAND MILLS RD                                  Venue: MANALAPAN \n\nCall Time- 17:25:27                                Date- 01/19/2012  \nDispatch - 17:25:50     En-route- 17:29:37     On-scene- 17:31:16     Depart 1-  \nArrive 2 -              Depart 2-              In-statn-              Cleared - 18:18:23 \n\nArea: 26A4              Section :   33         Beat  . : 26A4  \nGrid:                   Quadrant: 262S         District: E262 \n\nPhone Number: (732) 308-4591                Call Source:  911 \n\nCaller. . . : ROB YUHAS \n\nUnits sent  :  \n 12-1        F12A                 26-2        F262A  \n 32-1        F32A                 12-1        1266  \n 12-1        1269                 12-1        1274  \n 12-1        1275                 26-2        26286  \n 32-1        3266                 32-1        3290  \n 32-1        3296                 26-2        26266  \n 26-2        26267                26-2        26290 \n\nNature of Call : CHIMNEY FIRE/ ADVISED TO EVACUATE \n\nAdditional Info  \n  RESD: \n\nNarrative  \n Information on the units assigned to the call follows.  \n     Unit#: F12A   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:25   ENR:            :    ARV:            :  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 17:30  \n     Unit#: 1266   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:36  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 1274   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:33   ENR: 01/19/12 17:33  ARV: 01/19/12 17:54  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 1275   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:34   ENR: 01/19/12 17:34  ARV: 01/19/12 17:40  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 1269   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:34   ENR: 01/19/12 17:34  ARV: 01/19/12 17:39  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: F262A  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:25   ENR:            :    ARV:            :  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 17:30  \n     Unit#: 26286  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:54  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 26266  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:31  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 26267  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:34  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: 26290  Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:33   ENR: 01/19/12 17:33  ARV: 01/19/12 17:36  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:18  \n     Unit#: F32A   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:25   ENR:            :    ARV:            :  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 17:30  \n     Unit#: 3290   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:29   ENR: 01/19/12 17:29  ARV: 01/19/12 17:36  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:08  \n     Unit#: 3266   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP: 01/19/12 17:37   ENR: 01/19/12 17:37  ARV: 01/19/12 17:45  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:08  \n     Unit#: 3296   Radio#:        Ofcr 1:             Ofcr 2:  \n        DSP:            :     ENR:            :    ARV: 01/19/12 17:40  \n        DPT:            :     AR2:            :    DP2:            :  \n        QTR:            :     CLR: 01/19/12 18:08  \n PD 26 NTFD  \n CODE 2  \n 26 21");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(<mcsoz6@MCSONJ.ORG>) S:Automatic R&R Notification\n\n" +
        "Incident Number  : 2012-00000040                    ORI: 26-2          Station: STA 26-2\n" +
        "Incident Type  . : CRBA F CARB MONOX           Priority: 1\n" +
        "Incident Location: 686 ST ANDREWS PL                                    Venue: MANALAPAN\n" +
        "Located Between  : SAWGRASS DR/\n\n" +
        "Call Time- 21:28:10                                Date- 01/18/2012\n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-\n" +
        "Arrive 2 -              Depart 2-              In-statn-\n\n" +
        "Area: 26A4              Section :   29         Beat  . : 26A4        Map . . :\n" +
        "Grid:                   Quadrant: F262         District: E262\n\n" +
        "Phone Number: (908) 770-0906                Call Source:  911\n\n" +
        "Caller. . . : JESSICA SEAGULL\n\n" +
        "Nature of Call : CO ALARM SOUNDING/HAS GAS FIREPLACE ON EARLIE\n\n" +
        "Additional Info\n" +
        "  WPH1:  RADIUS 01 MILES\n" +
        "  R PD 26 NTFD\n\n" +
        "Additional Inc#s:\n\n" +
        "The Call Taker is FRUEH DOUGLAS\n" +
        "The Dispatcher is MCCORMICK KIEL",

        "ID:2012-00000040",
        "SRC:STA 26-2",
        "CALL:CRBA F CARB MONOX",
        "PRI:1",
        "ADDR:686 ST ANDREWS PL",
        "CITY:MANALAPAN",
        "X:SAWGRASS DR",
        "TIME:21:28:10",
        "DATE:01/18/2012",
        "MAP:E262/F262/29/26A4",
        "PHONE:(908) 770-0906",
        "NAME:JESSICA SEAGULL",
        "INFO:CO ALARM SOUNDING/HAS GAS FIREPLACE ON EARLIE");

    doTest("T2",
        "(<mcsoz6@MCSONJ.ORG>) S:Automatic R&R Notification\n" +
        "Incident Number : 2012-00000039 ORI: 26-2\n" +
        "Station: STA 26-2\n" +
        "Incident Type . : FIRA F FIRE ALARM Priority: 1\n" +
        "Incident Location: 103 PENSION RD\n" +
        "Venue: MANALAPAN\n" +
        "Located Between : GORDONS CORNER RD/PINE BROOK RD\n" +
        "Common Name. . . : WESTERN MONMOUTH UTILITIES\n\n" +
        "Call Time- 20:50:27 Date- 01/17/2012\n" +
        "Dispatch - 20:51:05 En-route- On-scene- Depart\n" +
        "1-\n" +
        "Arrive 2 - Depart 2- In-statn-\n\n" +
        "Area: 26A3 Section : 20 Beat . : 26A3 Map . .:\n" +
        "Grid: Quadrant: 1226 District: E262\n\n" +
        "Phone Number: (800) 434-4000 Call Source: TEL\n\n" +
        "Caller. . . : COMPLETE SEC MJ01\n\n" +
        "Units sent :\n" +
        "12-1 F12A 26-2 F262A\n\n" +
        "Nature of Call : WESTERN MONMOUTH UTILITIES ZONE//FILTRATION\n\n" +
        "Additional Info\n" +
        "REF#3231017\n" +
        "BLDG PREM//732-614-1586\n\n" +
        "Narrative\n" +
        "PD NTFD CMCCARTH 20:50:41\n" +
        "ALARM CO ATT TO NTFY KH CMCCARTH 20:50:45\n\n" +
        "Additional Inc#s:\n" +
        "12-1 201200000035\n\n" +
        "The Call Taker is MCCARTHY CHRISTINE\n" +
        "The Dispatcher is KNIGHTON JUSTIN",

        "ID:2012-00000039",
        "SRC:STA 26-2",
        "CALL:FIRA F FIRE ALARM",
        "PRI:1",
        "ADDR:103 PENSION RD",
        "CITY:MANALAPAN",
        "X:GORDONS CORNER RD/PINE BROOK RD",
        "PLACE:WESTERN MONMOUTH UTILITIES",
        "TIME:20:50:27",
        "DATE:01/17/2012",
        "MAP:E262/1226/20/26A3",
        "PHONE:(800) 434-4000",
        "NAME:COMPLETE SEC MJ01",
        "UNIT:12-1 F12A 26-2 F262A",
        "INFO:WESTERN MONMOUTH UTILITIES ZONE//FILTRATION");

    doTest("T3",
        "(<MCSOZD2@MCSONJ.ORG>) S:Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000042                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : FIRS F FIRE STRUC           Priority: 1  \n" +
        "Incident Location: 90 OAKLAND MILLS RD                                  Venue: MANALAPAN  \n" +
        "Located Between  : MILL RD/ \n\n" +
        "Call Time- 17:25:27                                Date- 01/19/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   33         Beat  . : 26A4        Map . . :  \n" +
        "Grid:                   Quadrant: 262S         District: E262 \n\n" +
        "Phone Number: (732) 308-4591                Call Source:  911 \n\n" +
        "Caller. . . : ROB YUHAS \n\n" +
        "Nature of Call : CHIMNEY FIRE/ ADVISED TO EVACUATE \n\n" +
        "Additional Info  \n" +
        "  RESD: \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is DALY EVAN  \n" +
        "The Dispatcher is BRUNO CHRISTOPHER",

        "ID:2012-00000042",
        "SRC:STA 26-2",
        "CALL:FIRS F FIRE STRUC",
        "PRI:1",
        "ADDR:90 OAKLAND MILLS RD",
        "CITY:MANALAPAN",
        "X:MILL RD",
        "TIME:17:25:27",
        "DATE:01/19/2012",
        "MAP:E262/262S/33/26A4",
        "PHONE:(732) 308-4591",
        "NAME:ROB YUHAS",
        "INFO:CHIMNEY FIRE/ ADVISED TO EVACUATE");

    doTest("T4",
        "(<MCSOZD2@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000043                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : CRBA F CARB MONOX           Priority: 1  \n" +
        "Incident Location: 41 YATES RD                                          Venue: MANALAPAN  \n" +
        "Located Between  : SALTER CT/CRAWFORD RD \n\n" +
        "Call Time- 22:31:12                                Date- 01/19/2012  \n" +
        "Dispatch - 22:31:47     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   34         Beat  . : 26A4        Map . . :  \n" +
        "Grid:                   Quadrant: F262         District: E262 \n" +
        "++\n" +
        "Phone Number: (732) 462-4033                Call Source:  TEL \n\n" +
        "Caller. . . : NICHOLAS VULTIS \n\n" +
        "Units sent  :  \n" +
        " 26-2        F262A \n\n" +
        "Nature of Call : CO ALARM SOUNDING/RESIDENTS EVACUATING/NO \n\n" +
        "Additional Info  \n" +
        "  SYMPTOMS - JUST GOT HOME FROM VACATION \n\n" +
        "Narrative  \n" +
        " CODE 3                                            RMCDONAL   22:31:16  \n" +
        " MCRR NOTIFIED FOR FIRE DEPT                       RMCDONAL   22:31:31 \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is MCDONALD ROBIN  \n" +
        "The Dispatcher is BRUNO CHRISTOPHER",

        "ID:2012-00000043",
        "SRC:STA 26-2",
        "CALL:CRBA F CARB MONOX",
        "PRI:1",
        "ADDR:41 YATES RD",
        "CITY:MANALAPAN",
        "X:SALTER CT/CRAWFORD RD",
        "TIME:22:31:12",
        "DATE:01/19/2012",
        "MAP:E262/F262/34/26A4",
        "PHONE:(732) 462-4033",
        "NAME:NICHOLAS VULTIS",
        "UNIT:26-2 F262A",
        "INFO:CO ALARM SOUNDING/RESIDENTS EVACUATING/NO");

    doTest("T5",
        "(<mcson6@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000044                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : FIRA F FIRE ALARM           Priority: 1  \n" +
        "Incident Location: 327 ST HWY 33                                        Venue: MANALAPAN  \n" +
        "Located Between  : WOODWARD RD/IRON ORE RD  \n" +
        "Common Name. . . : MARRIANE MANOR LLC \n\n" +
        "Call Time- 23:21:19                                Date- 01/19/2012  \n" +
        "Dispatch - 23:22:20     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   30         Beat  . : 26A4        Map . . :    E  \n" +
        "Grid:                   Quadrant: F262         District: E262 \n\n" +
        "Phone Number: (000) 000-0000                Call Source:  TEL \n\n" +
        "Units sent  :  \n" +
        " 26-2        F262A \n\n" +
        "Nature of Call : FIRE ALARM/ASSOC FIRE PROTECTION 8009323822 \n\n" +
        "Additional Info  \n" +
        "  SRN #75548 \n\n" +
        "Narrative  \n" +
        " PD 26 CALLED IN                                   DMELLACI   23:22:20 \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is NIGRO-CIOFFI MARIA  \n" +
        "The Dispatcher is HORN EDWARD",

        "ID:2012-00000044",
        "SRC:STA 26-2",
        "CALL:FIRA F FIRE ALARM",
        "PRI:1",
        "ADDR:327 ST HWY 33",
        "MADDR:327 NJ 33",
        "CITY:MANALAPAN",
        "X:WOODWARD RD/IRON ORE RD",
        "PLACE:MARRIANE MANOR LLC",
        "TIME:23:21:19",
        "DATE:01/19/2012",
        "MAP:E262/F262/30/26A4",
        "UNIT:26-2 F262A",
        "INFO:FIRE ALARM/ASSOC FIRE PROTECTION 8009323822");

    doTest("T5",
        "(<mcsozb8@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000046                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : CRBA F CARB MONOX           Priority: 1  \n" +
        "Incident Location: 4 SUMMIT AV                                          Venue: MANALAPAN  \n" +
        "Located Between  : SWEETMANS LN/ \n\n" +
        "Call Time- 14:52:48                                Date- 01/22/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   32         Beat  . : 26A4        Map . . :  \n" +
        "Grid:                   Quadrant: 26SS         District: E262 \n\n" +
        "Phone Number: (732) 845-4737                Call Source:  911 \n\n" +
        "Caller. . . : DAWN HIGGINS \n\n" +
        "Nature of Call : NO SYMPTOMS. PD NTFD \n\n" +
        "Additional Info  \n" +
        "  RESD: \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is MAGNIN KARIN  \n" +
        "The Dispatcher is WARD JOSEPH",

        "ID:2012-00000046",
        "SRC:STA 26-2",
        "CALL:CRBA F CARB MONOX",
        "PRI:1",
        "ADDR:4 SUMMIT AV",
        "MADDR:4 SUMMIT AVE",
        "CITY:MANALAPAN",
        "X:SWEETMANS LN",
        "TIME:14:52:48",
        "DATE:01/22/2012",
        "MAP:E262/26SS/32/26A4",
        "PHONE:(732) 845-4737",
        "NAME:DAWN HIGGINS",
        "INFO:NO SYMPTOMS. PD NTFD");

    doTest("T6",
        "(<mcson6@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000104                    ORI: 16-1          Station: STA 16-1  \n" +
        "Incident Type  . : FIRS F FIRE STRUC           Priority: 1  \n" +
        "Incident Location: 103 SILOAM RD                                        Venue: FRHLD TWP  \n" +
        "Located Between  : HENDRICKSON RD/TURKEY SWAMP RD \n\n" +
        "Call Time- 02:08:05                                Date- 01/24/2012  \n" +
        "Dispatch - 02:21:29     En-route- 02:21:29     On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1600              Section : 1796         Beat  . : FT03        Map . . :  \n" +
        "Grid:                   Quadrant: 1611         District: E151 \n\n" +
        "Phone Number: (908) 770-5342                Call Source:  911 \n\n" +
        "Caller. . . : VERIZON WIRELESS \n\n" +
        "Units sent  :  \n" +
        " 32-1        F32A                 16-1        F161B  \n" +
        " 32-1        3266                 32-1        3275  \n" +
        " 32-1        3296                 16-1        16166  \n" +
        " 16-1        16167                16-1        16168  \n" +
        " 16-1        16169                16-1        16170  \n" +
        " 16-1        16171                16-1        16177  \n" +
        " 16-1        16179                16-1        16190  \n" +
        " 16-1        16196                26-2        26266  \n" +
        " D19         19266                D19         19296 \n\n" +
        "Nature of Call : HOUSE ON FIRE//SEES FLAMES NEAR #95 \n\n" +
        "Additional Info  \n" +
        "  WPH1:  RADIUS 01 MILES \n\n" +
        "Narrative  \n" +
        " PASSERBY//CHECKING TO SEE IF ANYONE IS HOME       LCIVELLO    2:08:29  \n" +
        " NO CARS IN DRIVE//MAY BE ABANDOONED               LCIVELLO    2:08:40  \n" +
        " ON SIDE OF HOUSE BY CHIMNEY                       LCIVELLO    2:08:49  \n" +
        " THERES AN OIL TANK THERE ALSO                     LCIVELLO    2:08:55  \n" +
        " TOTALLY DARK//BANGED ON WINDOWS                   LCIVELLO    2:09:11  \n" +
        " NO ONE IS ANSWERING                               LCIVELLO    2:09:23  \n" +
        " HOUSE #103                                        LCIVELLO    2:09:35  \n" +
        " MIKE KILKENNY 908-770-5342                        LCIVELLO    2:10:10  \n" +
        " CALLER HAS TO GO TO WORK AND IS LEAVING           LCIVELLO    2:10:28  \n" +
        " REQ 32-1                                          EHORN       2:10:58  \n" +
        " NJNG BEING NTFD                                   CMCCARTH    2:11:33  \n" +
        " NTFY JCP&L                                        NMURACO     2:12:10  \n" +
        " NJNG COMING FROM WALL                             CMCCARTH    2:12:23  \n" +
        " 19-2 FOR RIT AS PER 1-67                          EHORN       2:12:25  \n" +
        " JCP&L NTFD                                        NMURACO     2:13:39  \n" +
        " 1 HOUR #325382367                                 NMURACO     2:15:43  \n" +
        " HOUSE FULLY INVOLVED PER PTLS                     JFERA       2:15:59  \n" +
        " PTLS EVACA SURROUNDING HOUSES                     JFERA       2:16:47  \n" +
        " SILOAM RD S AT RT 537                             JFERA       2:17:16  \n" +
        " TO BE CLOSED BY PD 26                             JFERA       2:17:44  \n" +
        " 16-1-66 REQ 26-2 FOR TANKER                       EHORN       2:17:52  \n" +
        " FIRE DEPT MEMBER ON LOC PER PTLS                  JFERA       2:17:55  \n" +
        " FIRE TRUCK 10-9 PER PTLS                          JFERA       2:18:07  \n" +
        " 32-1 2ND ALERT                                    EHORN       2:18:56  \n" +
        " 19-2 FOR THE TANKER                               NMURACO     2:19:09  \n" +
        " 19-1 FOR TANKER                                   EHORN       2:19:25  \n" +
        " 19-2 FOR TANKER                                   EHORN       2:19:59  \n" +
        " 2658 ON LOC FOR STAND BY                          JFERA       2:21:09 \n\n" +
        "Additional Inc#s:  \n" +
        " D19         201200000023             26-2        201200000048  \n" +
        " 32-1        201200000047 \n\n" +
        "The Call Taker is CIVELLO LORI MARIE  \n" +
        "The Dispatcher is HORN EDWARD",

        "ID:2012-00000104",
        "SRC:STA 16-1",
        "CALL:FIRS F FIRE STRUC",
        "PRI:1",
        "ADDR:103 SILOAM RD",
        "CITY:FRHLD TWP",
        "X:HENDRICKSON RD/TURKEY SWAMP RD",
        "TIME:02:08:05",
        "DATE:01/24/2012",
        "MAP:E151/1611/1796/1600",
        "PHONE:(908) 770-5342",
        "NAME:VERIZON WIRELESS",
        "UNIT:32-1 F32A 16-1 F161B 32-1 3266 32-1 3275 32-1 3296 16-1 16166 16-1 16167 16-1 16168 16-1 16169 16-1 16170 16-1 16171 16-1 16177 16-1 16179 16-1 16190 16-1 16196 26-2 26266 D19 19266 D19 19296",
        "INFO:HOUSE ON FIRE//SEES FLAMES NEAR #95");

    doTest("T7",
        "(<MCSOZC2@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000057                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : FIRS F FIRE STRUC           Priority: 1  \n" +
        "Incident Location: AVALON LA                                            Venue: MANALAPAN  \n" +
        "Located Between  : SPRINGHOUSE CI/ \n\n" +
        "Call Time- 18:59:46                                Date- 01/27/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   31         Beat  . : 26A4        Map . . :  \n" +
        "Grid:                   Quadrant: 1226         District: E262 \n\n" +
        "Phone Number: (000) 000-0000                Call Source:  TEL \n\n" +
        "Nature of Call : ACROSS FROM 13 NO HOUSE NUMBER//SEES FLAMES \n\n" +
        "Additional Info  \n" +
        "  SRN \n\n" +
        "Narrative  \n" +
        " CODE 2                                            DERNDL     19:00:16  \n" +
        " PD 26 CALLED IN                                   MKATZ      19:00:43 \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is ERNDL DOREEN  \n" +
        "The Dispatcher is DALY EVAN",

        "ID:2012-00000057",
        "SRC:STA 26-2",
        "CALL:FIRS F FIRE STRUC",
        "PRI:1",
        "ADDR:AVALON LA",
        "MADDR:AVALON LN & SPRINGHOUSE CIR",
        "CITY:MANALAPAN",
        "X:SPRINGHOUSE CI",
        "TIME:18:59:46",
        "DATE:01/27/2012",
        "MAP:E262/1226/31/26A4",
        "INFO:ACROSS FROM 13 NO HOUSE NUMBER//SEES FLAMES");

    doTest("T8",
        "(<mcsoo8@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000055                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : FIRS F FIRE STRUC           Priority: 1  \n" +
        "Incident Location: 15 APPLE BLOSSOM LN BLOSSUM                          Venue: MANALAPAN  \n" +
        "Located Between  : THOMPSON GROVE RD/ \n\n" +
        "Call Time- 21:22:19                                Date- 01/26/2012  \n" +
        "Dispatch - 21:22:35     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   35         Beat  . : 26A4        Map . . :  \n" +
        "Grid:                   Quadrant: F262         District: E262 \n\n" +
        "Phone Number: (732) 744-4549                Call Source:  911 \n\n" +
        "Caller. . . : VALENTINA SEAMAN \n\n" +
        "Units sent  :  \n" +
        " 26-2        F262A \n\n" +
        "Nature of Call : FIRE IN GARAGE \n\n" +
        "Additional Info  \n" +
        "  WPH1:  RADIUS 01 MILES \n\n" +
        "Additional Inc#s:  \n" +
        " 12-1        201200000046 \n\n" +
        "The Call Taker is SMITH BRUCE  \n" +
        "The Dispatcher is DONATELLI ROBERT",

        "ID:2012-00000055",
        "SRC:STA 26-2",
        "CALL:FIRS F FIRE STRUC",
        "PRI:1",
        "ADDR:15 APPLE BLOSSOM LN BLOSSUM",
        "CITY:MANALAPAN",
        "X:THOMPSON GROVE RD",
        "TIME:21:22:19",
        "DATE:01/26/2012",
        "MAP:E262/F262/35/26A4",
        "PHONE:(732) 744-4549",
        "NAME:VALENTINA SEAMAN",
        "UNIT:26-2 F262A",
        "INFO:FIRE IN GARAGE");

    doTest("T9",
        "(<MCSOZ3@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000051                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : FIRA F FIRE ALARM           Priority: 1  \n" +
        "Incident Location: 124 SHINNECOCK DR                                    Venue: MANALAPAN  \n" +
        "Located Between  : MUIRFIELD DR/ \n\n" +
        "Call Time- 15:31:14                                Date- 01/26/2012  \n" +
        "Dispatch -              En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   29         Beat  . : 26A4        Map . . :  \n" +
        "Grid:                   Quadrant: 1226         District: E262 \n\n" +
        "Phone Number: (732) 792-1073                Call Source:  911 \n\n" +
        "Caller. . . : GERARD LAINO \n\n" +
        "Nature of Call : LEFT POT ON STOVE//HOUSE FILLED W/SMOKE \n\n" +
        "Additional Info  \n" +
        "  RESD: \n\n" +
        "Narrative  \n" +
        " PD NTFD                                           SPRINCIN   15:31:35 \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is PRINCING SHARON  \n" +
        "The Dispatcher is SPANO MICHAEL",

        "ID:2012-00000051",
        "SRC:STA 26-2",
        "CALL:FIRA F FIRE ALARM",
        "PRI:1",
        "ADDR:124 SHINNECOCK DR",
        "CITY:MANALAPAN",
        "X:MUIRFIELD DR",
        "TIME:15:31:14",
        "DATE:01/26/2012",
        "MAP:E262/1226/29/26A4",
        "PHONE:(732) 792-1073",
        "NAME:GERARD LAINO",
        "INFO:LEFT POT ON STOVE//HOUSE FILLED W/SMOKE");

    doTest("T10",
        "(<MCSOZ3@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000066                    ORI: 16-2          Station: STA 16-2  \n" +
        "Incident Type  . : FIRA F FIRE ALARM           Priority: 1  \n" +
        "Incident Location: 4189 N RT 9                                          Venue: FRHLD TWP  \n" +
        "Located Between  : RT 522/SCHIBANOFF RD  \n" +
        "Common Name. . . : BROCK FARMS \n\n" +
        "Call Time- 15:30:16                                Date- 01/26/2012  \n" +
        "Dispatch - 15:34:22     En-route- 15:34:22     On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 1600              Section : 1797         Beat  . : FT01        Map . . :    N  \n" +
        "Grid:                   Quadrant: 1626         District: E151 \n\n" +
        "Phone Number: (908) 810-8833                Call Source:  TEL \n\n" +
        "Caller. . . : OPER MAGGIE \n\n" +
        "Units sent  :  \n" +
        " 16-2        F162A                26-2        26266 \n\n" +
        "Nature of Call : BUSN: BROCK FARMS // ZONE: GENERAL \n\n" +
        "Additional Info  \n" +
        "  SUPREME SECURITY  \n" +
        "  PREMIS: 732-462-2700 \n\n" +
        "Narrative  \n" +
        " P16180 ADVISES NO SMOKE VISIBLE FROM OUTSIDE      LCIVELLO   15:31:26 \n\n" +
        "Additional Inc#s:  \n" +
        " 26-2        201200000052 \n\n" +
        "The Call Taker is HAMMEL THOMAS C  \n" +
        "The Dispatcher is SPANO MICHAEL",

        "ID:2012-00000066",
        "SRC:STA 16-2",
        "CALL:FIRA F FIRE ALARM",
        "PRI:1",
        "ADDR:4189 N RT 9",
        "CITY:FRHLD TWP",
        "X:RT 522/SCHIBANOFF RD",
        "PLACE:BROCK FARMS",
        "TIME:15:30:16",
        "DATE:01/26/2012",
        "MAP:E151/1626/1797/1600",
        "PHONE:(908) 810-8833",
        "NAME:OPER MAGGIE",
        "UNIT:16-2 F162A 26-2 26266",
        "INFO:BUSN: BROCK FARMS // ZONE: GENERAL");

    doTest("T11",
        "(<MCSOZ3@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000055                    ORI: 32-1          Station: STA 32-1  \n" +
        "Incident Type  . : FIRS F FIRE STRUC           Priority: 1  \n" +
        "Incident Location: CHARLESTON SPRING RD                                 Venue: MILLSTONE  \n" +
        "  Cross Street . : CARRIAGE WY \n\n" +
        "Call Time- 16:26:27                                Date- 01/26/2012  \n" +
        "Dispatch - 16:32:31     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 3200              Section : 1851         Beat  . :   32        Map . . :  \n" +
        "Grid:                   Quadrant: 3215         District: E321 \n\n" +
        "Phone Number: (609) 396-8852                Call Source:  911 \n\n" +
        "Caller. . . : ELIZABETH GOLDMAN \n\n" +
        "Units sent  :  \n" +
        " 26-2        F262A                32-1        F32A  \n" +
        " 16-1        F161A                32-1        3275 \n\n" +
        "Nature of Call : REPORTING A HOUSE FIRE \n\n" +
        "Additional Info  \n" +
        "  WPH2:  RADIUS 01 MILES  \n" +
        "  SAW SMOKE FROM WINDOW 2ND FLR \n\n" +
        "Narrative  \n" +
        " CALLER DROVE PAST ON SCHOOL BUS                   MHEATON    16:26:56  \n" +
        " IS ATTEMPTING TO DRIVE BACK                       MHEATON    16:27:01  \n" +
        " NJSP NTFD                                         MHEATON    16:27:43  \n" +
        " 44 CHARLESTOWN SPRINGS                            MHEATON    16:32:27 \n\n" +
        "Additional Inc#s:  \n" +
        " 16-1        201200000112             26-2        201200000053 \n\n" +
        "The Call Taker is HEATON MICHAEL  \n" +
        "The Dispatcher is SPANO MICHAEL",

        "ID:2012-00000055",
        "SRC:STA 32-1",
        "CALL:FIRS F FIRE STRUC",
        "PRI:1",
        "ADDR:CHARLESTON SPRING RD",
        "MADDR:CHARLESTON SPRING RD & CARRIAGE WY",
        "CITY:MILLSTONE",
        "X:CARRIAGE WY",
        "TIME:16:26:27",
        "DATE:01/26/2012",
        "MAP:E321/3215/1851/3200",
        "PHONE:(609) 396-8852",
        "NAME:ELIZABETH GOLDMAN",
        "UNIT:26-2 F262A 32-1 F32A 16-1 F161A 32-1 3275",
        "INFO:REPORTING A HOUSE FIRE");

    doTest("T12",
        "(<mcsop7@MCSONJ.ORG>) S: Automatic R&R Notification\n" +
        "Incident Number  : 2012-00000054                    ORI: 26-2          Station: STA 26-2  \n" +
        "Incident Type  . : AIDF F AID-F                Priority: 1  \n" +
        "Incident Location: 5 SWEETMANS LN                                       Venue: MANALAPAN  \n" +
        "Located Between  : BORDER-MILLSTONE TWP/ST HWY 33 W  \n" +
        "Common Name. . . : STATION 26-2 \n\n" +
        "Call Time- 16:34:08                                Date- 01/26/2012  \n" +
        "Dispatch - 16:34:38     En-route-              On-scene-              Depart 1-  \n" +
        "Arrive 2 -              Depart 2-              In-statn- \n\n" +
        "Area: 26A4              Section :   32         Beat  . : 26A4        Map . . :  \n" +
        "Grid:                   Quadrant: F262         District: E262 \n\n" +
        "Phone Number: (000) 000-0000                Call Source:  TEL \n\n" +
        "Caller. . . : 3275 \n\n" +
        "Units sent  :  \n" +
        " 26-2        F262A \n\n" +
        "Nature of Call : IN MILLSTONE CHARLSTON SPRING STRUCTURE \n\n" +
        "Additional Info  \n" +
        "  SAME ABOVE \n\n" +
        "Additional Inc#s: \n\n" +
        "The Call Taker is KNIGHTON JUSTIN  \n" +
        "The Dispatcher is KNIGHTON JUSTIN",

        "ID:2012-00000054",
        "SRC:STA 26-2",
        "CALL:AIDF F AID-F",
        "PRI:1",
        "ADDR:5 SWEETMANS LN",
        "CITY:MANALAPAN",
        "X:BORDER-MILLSTONE TWP/ST HWY 33 W",
        "PLACE:STATION 26-2",
        "TIME:16:34:08",
        "DATE:01/26/2012",
        "MAP:E262/F262/32/26A4",
        "NAME:3275",
        "UNIT:26-2 F262A",
        "INFO:IN MILLSTONE CHARLSTON SPRING STRUCTURE");
  }
  
  public static void main(String[] args) {
    new NJMonmouthCountyAParserTest().generateTests("T5");
  }
}