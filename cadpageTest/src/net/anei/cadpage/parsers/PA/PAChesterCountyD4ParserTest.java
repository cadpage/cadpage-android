package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyD4ParserTest extends BaseParserTest {
  
  public PAChesterCountyD4ParserTest() {
    setParser(new PAChesterCountyD4Parser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "Subject: BUILDING FIRE *\n" +
        " Dispatch ** 14:33 ** BUILDING FIRE * ** 6 PONDS EDGE DR ,64 ** LYONS DOUGHERTY LLC- ** NASEEF, MICHAEL ** 610-388-737 ** 2566 ** SMOKE IN BLDG FROM HVAC SYSTEM.\n" +
        "DETAILS TO FOLLOW\n" +
        " ** LOCI: LYONS DOUGHERTY LLC, \n" +
        "TXT: BLDG IS EVAC. \n" +
        ",HVAC UNIT ON ROOF - NEG RELOCATES CHKG ON UTI\n" +
        "LI ** 05/22/12 ** BUILDNG ** LNGF12000506 **  ** Inc History #LNGF12000506  Xref: #64PJ12000154   \n" +
        "                      \n" +
        " Received     05/22/12  14:32:09  BY CT02     713    \n" +
        " Entered      05/22/12  14:33:18  BY CT02     713    \n" +
        " Dispatched   05/22/12  14:33:56  BY FD16     465    \n" +
        " Enroute      05/22/12  14:34:26                     \n" +
        " Onscene      05/22/12  14:40:09                     \n\n" +
        " Initial Type: BUILDNG    Final Type: BUILDNG (BUILDING FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: 9    Primary Unit: LAD25       Rsp: 0033  \n" +
        " Police BOX: 6402  Fire BOX: 2566  EMS BOX: 2566 \n" +
        " Group: 25FD          Section: 25     Map: 40H13    X: 7562189  Y: 3986984\n\n" +
        " Loc: 6 PONDS EDGE DR ,64  btwn E VILLAGE LA & N VILLAGE LA (V) \n" +
        " AKA:   Municipality: PNSBRY Dev: \n" +
        " Loc Info: LYONS DOUGHERTY LLC\n" +
        " Name: NASEEF, MICHAEL         Addr: SAA                     PH: 610-388-7371   \n\n" +
        "/1433  (713   )  ENTRY            SMOKE IN BLDG FROM HVAC SYSTEM.\n" +
        "/1433            ENTRY            DETAILS TO FOLLOW\n" +
        "/1433  (465   )  DTSEEN           INFO SEEN\n" +
        "/1433            DISP    LAD25    \n" +
        "/1433            ASST    ENG252    #ENG252 ENG252 MDT \n" +
        "/1433            ASST    MIC253    #MIC253 MIC253 MDT \n" +
        "/1433            ASST    DTKR59   \n" +
        "/1433            ASST    D592     \n" +
        "/1433            ASST    D593     \n" +
        "/1433            ASST    D594     \n" +
        "/1433            ASST    TKR36    \n" +
        "/1433            ASST    ENG36     #ENG36  ENG36 MDT \n" +
        "/1434  (713   )  SUPP             LOCI: LYONS DOUGHERTY LLC, \n" +
        "                                  TXT: BLDG IS EVAC. \n" +
        "/1434  (MIC253) *ENROUT  MIC253   \n" +
        "/1435  (465   )  CLEAR   MIC253   \n" +
        "/1437            ASSTER  MIC251    #MIC251 MIC251 MDT \n" +
        "/1439           *ENROUT  ENG252   \n" +
        "/1440  (MIC251) *ONSCNE  MIC251   \n" +
        "/1440  (136   )  ENROUT  D592     \n" +
        "/1441  (465   )  ENROUT  ENG36    \n" +
        "/1442           *ENROUT  TKR36    \n" +
        "/1442  (159   )  ASSTER  RES36     #RES36  RES36 MDT \n" +
        "/1442            ASSTOS  CHF25     #CHF25  CHF25 MDT \n" +
        "/1443            ENROUT  LAD25    \n" +
        "/1443  (465   ) *ONSCNE  ENG252   \n" +
        "/1446           *ASSTER  TAC36    \n" +
        "/1449  (159   )  ONSCNE  LAD25    \n" +
        "/1449            NEWLOC  CHF25    [PONDS EDGE CMND] \n" +
        "/1450  (465   )  ONSCNE  D592     \n" +
        "/1450            ONSCNE  D593     \n" +
        "/1451           *ASSTER  TRF25    \n" +
        "/1453           *ONSCNE  TKR36    \n" +
        "/1453           *ONSCNE  ENG36    \n" +
        "/1455           *ONSCNE  TRF25    \n" +
        "/1455  (RES36 ) *ONSCNE  RES36    \n" +
        "/1456  (465   ) *ONSCNE  TAC36    \n" +
        "/1500  (159   )  MISC    CHF25    ,HVAC UNIT ON ROOF - NEG RELOCATES CHKG ON UTI\n" +
        "                                  LITIES\n" +
        "/1500            MISC    CHF25    ,SUC\n" +
        "/1500            FM               Alarm Level 1\n" +
        "/1500            DTSEEN           INFO SEEN\n" +
        "/1500            ASST    FM101     #FM101  WEER, JOHN \n" +
        "/1500            ASST    FM103     #FM103  HOLMES, MIKE \n" +
        "PRIOR PREMISE HISTORY FOR: 6 PONDS EDGE DR ,64                               \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #LNGF12000506 Type: BUILDNG Loc: 6 PONDS EDGE DR ,64\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "64-006      0      105 PONDS EDGE DR, 64\n" +
        "               \n" +
        "64-009      0     NB PONDS EDGE DR SO LAKEVIEW DR ,64\n" +
        "               \n" +
        "64-008      0      307 S VILLAGE LA, 64\n" +
        "               \n" +
        "64-007      0      407 W VILLAGE LA, 64\n" +
        "               \n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** PNSBRY **  ** 25 ** E ** E VILLAGE LA & N VILLAGE **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:14:33",
        "CALL:BUILDING FIRE",
        "ADDR:6 PONDS EDGE DR",
        "CITY:PENNSBURY TWP",
        "PLACE:LYONS DOUGHERTY LLC",
        "NAME:NASEEF, MICHAEL",
        "PHONE:610-388-737",
        "BOX:2566",
        "INFO:SMOKE IN BLDG FROM HVAC SYSTEM.",
        "UNIT:LAD25",
        "X:E VILLAGE LA & N VILLAGE LA");

    doTest("T2",
        "Subject: BUILDING FIRE *\n" +
        " Dispatch ** 00:14 ** BUILDING FIRE * ** 118 N THIRD AV ,16 ** TO REAR OF- ** BIRD DIANE ** 610-384-241 ** 4138 ** UNK TYPE BUILDING\n" +
        "DETAILS TO FOLLOW\n" +
        "LOC: 112 N THIRD AV ,16 -->  200 LUMBER ST ,16\n" +
        "LOC: 200 LUMBE ** TXT: CONFIRMED PEOPLE INSIDE \n" +
        "TXT: PEOPLE ARE NOT GETTING OUT OF THE BUILDIN\n" +
        "G \n" +
        "TXT: PD OS - SMOK ** 05/23/12 ** BUILDNG ** CTVF12000874 **  ** Inc History #CTVF12000874  Xref: #16PJ12007772 #CTVF12000875  \n" +
        "                      \n" +
        " Received     05/23/12  00:13:01  BY CT02     171    \n" +
        " Entered      05/23/12  00:13:44  BY CT02     171    \n" +
        " Dispatched   05/23/12  00:14:39  BY FD16     436    \n" +
        " Enroute      05/23/12  00:14:44                     \n" +
        " Onscene      05/23/12  00:18:26                     \n\n" +
        " Initial Type: BUILDNG    Final Type: BUILDNG (BUILDING FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: 9    Primary Unit: LAD41       Rsp: 0033  \n" +
        " Police BOX: 1603  Fire BOX: 4138  EMS BOX: 4138 \n" +
        " Group: 41FD          Section: 41     Map: 28K5     X: 7582046  Y: 3998514\n\n" +
        " Loc: 118 N THIRD AV ,16  btwn LUMBER ST & FLEETWOOD ST (V) \n" +
        " AKA:   Municipality: COATVL Dev: \n" +
        " Loc Info: TO REAR OF\n" +
        " Name: BIRD DIANE              Addr: 112 N THIRD AV ,16      PH: 610-384-2411   \n\n" +
        "/0013  (171   )  ENTRY            UNK TYPE BUILDING\n" +
        "/0013            ENTRY            DETAILS TO FOLLOW\n" +
        "/0014            SUPP             TXT: CONFIRMED PEOPLE INSIDE \n" +
        "/0014  (436   )  DTSEEN           INFO SEEN\n" +
        "/0014            DTSEEN           INFO SEEN\n" +
        "/0014            DISP    LAD41     #LAD41  LAD41 MDT \n" +
        "/0014            ASST    RES41     #RES41  RES41 MDT \n" +
        "/0014            ASST    AMB413    #AMB413 AMB413 MDT \n" +
        "/0014            ASST    ENG43     #ENG43  ENG43 MDT \n" +
        "/0014            ASST    ENG38     #ENG38  ENG38 MDT \n" +
        "/0014            ASST    ENG371    #ENG371 ENG371 MDT \n" +
        "/0014            ASST    ENG76     #ENG76  ENG76 MDT \n" +
        "/0014            ASST    AMB372    #AMB372 AMB372 MDT \n" +
        "/0014  (580   )  ENROUT  ENG38    \n" +
        "/0015  (171   )  SUPP             TXT: PEOPLE ARE NOT GETTING OUT OF THE BUILDIN\n" +
        "                                  G \n" +
        "/0015  (436   )  ASSTER  TRF38    \n" +
        "/0015  (LAD41 ) *ENROUT  LAD41    \n" +
        "/0016  (528   )  SUPP             TXT: PD OS - SMOKE SHOWING \n" +
        "/0016            SUPP             TXT: SMALL FIRE SHOWING, OFF 200 BLK LUMBER \n" +
        "/0016  (436   )  ASSTER  CHF38     #CHF38  CHF38 MDT \n" +
        "/0016  (528   )  CHANGE           LOC: 112 N THIRD AV ,16 -->  200 LUMBER ST ,16\n" +
        "/0016  (ENG43 ) *ENROUT  ENG43    \n" +
        "/0017  (436   ) $CROSS            #CTVF12000875 \n" +
        "/0017            DUP              #CTVF12000875 \n" +
        "                                  ,SAME AS FIRE INCIDENT\n" +
        "/0017            DUP              NAM: VECTOR SEC, 44 \n" +
        "                                  PHO: 800-638-7077    \n" +
        "/0018            ASSTER  OFC41    [BAT] \n" +
        "/0018            ONSCNE  LAD41    ,SMOKE SHOWING - WFD\n" +
        "/0018           $PREMPT  AMB413   \n" +
        "/0018           $ASSTER  AMB412    #AMB412 AMB412 MDT \n" +
        "/0018            EXCH    AMB413   AMB412   \n" +
        "/0018            WFD              Alarm Level 1\n" +
        "/0019            DTSEEN           INFO SEEN\n" +
        "/0019  (ENG76 ) *ENROUT  ENG76    \n" +
        "/0019  (436   )  ASST    CHF41     #CHF41  CHF41 MDT \n" +
        "/0019            ASST    MED931    #MED931 MED931 MDT \n" +
        "/0020  (AMB412) *MISC    AMB412   ,21194.7\n" +
        "/0020  (MED931) *ENROUT  MED931   \n" +
        "/0020  (436   )  ONSCNE  OFC41    \n" +
        "/0021  (CHF41 ) *ENROUT  CHF41    \n" +
        "/0021  (436   )  ASST    ENG372    #ENG372 ENG372 MDT \n" +
        "/0021            ASSTER  LAD49     #LAD49  LAD49 MDT \n" +
        "/0021            ASSTER  RES45     #RES45  RES45 MDT \n" +
        "/0021            ASSTER  AIR46     #AIR46  AIR46 MDT \n" +
        "/0021            ASSTER  ENG311    #ENG311 ENG311 MDT \n" +
        "/0021  (ENG372) *ENROUT  ENG372   \n" +
        "/0022  (580   )  ONSCNE  ENG38    \n" +
        "/0022  (436   ) *ASSTER  TRF37    \n" +
        "/0023  (580   )  AOR     AIR46    \n" +
        "/0023            ASST    AIR46     #AIR46  AIR46 MDT \n" +
        "/0024  (107   )  CHANGE           LOC: 200 LUMBER ST ,16 -->  118 N THIRD AV ,16\n" +
        "/0024  (436   ) *ASSTER  ENG373    #ENG373 ENG373 MDT \n" +
        "/0024  (MED931) *ONSCNE  MED931   \n" +
        "/0024  (436   )  ONSCNE  AMB412   \n" +
        "/0025  (CHF38 ) *ONSCNE  CHF38    \n" +
        "/0025  (AMB412) *MISC    AMB412   ,21198.4\n" +
        "/0025  (436   )  NEWLOC  OFC41    [BAT/N THIRD AV CMD] \n" +
        "/0025            MISC    LAD41    ,FIRE IN WALL\n" +
        "/0026            MISC    LAD41    ,IN SERVICE 1 AND 1\n" +
        "/0026            ASSTER  CHF49     #CHF49  CHF49 MDT \n" +
        "/0026            ONSCNE  ENG76    \n" +
        "/0027  (ENG372) *ONSCNE  ENG372   \n" +
        "/0028  (436   ) *ENROUT  AIR46    \n" +
        "/0029  (AMB372) *ENROUT  AMB372   \n" +
        "/0030  (107   ) *ASSTER  UTL49    \n" +
        "/0030            AIQ     ENG371   \n" +
        "/0030  (436   ) *ONSCNE  TRF37    \n" +
        "/0030  (107   )  AIQ     RES41    \n" +
        "/0030  (436   ) *ONSCNE  ENG373   \n" +
        "/0034            FM               Alarm Level 1\n" +
        "/0034            DTSEEN           INFO SEEN\n" +
        "/0034            ASST    FM101     #FM101  WEER, JOHN \n" +
        "/0034            ASST    FM103     #FM103  HOLMES, MIKE \n" +
        "PRIOR PREMISE HISTORY FOR: 118 N THIRD AV ,16                                \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #CTVF12000874 Type: BUILDNG Loc: 118 N THIRD AV ,16\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "16-158      0     LUMBER ST/N THIRD AV ,16\n" +
        "               \n" +
        "16-155      0     FLEETWOOD ST/N THIRD AV ,16\n" +
        "               \n" +
        "16-157      0     E DIAMOND ST/N THIRD AV ,16\n" +
        "               \n" +
        "16-202      0      323 E CHESTNUT ST, 16\n" +
        "               \n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** COATVL **  ** 41 ** E ** LUMBER ST & FLEETWOOD ST **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:00:14",
        "CALL:BUILDING FIRE",
        "ADDR:118 N THIRD AV",
        "MADDR:118 N THIRD AVE",
        "CITY:COATESVILLE",
        "PLACE:TO REAR OF",
        "NAME:BIRD DIANE",
        "PHONE:610-384-241",
        "BOX:4138",
        "INFO:UNK TYPE BUILDING",
        "UNIT:LAD41",
        "X:LUMBER ST & FLEETWOOD ST");

    doTest("T3",
        "Subject: NOTIFY FIRE CHIEF\n" +
        " Dispatch ** 13:36 ** NOTIFY FIRE CHIEF ** 251 RED PUMP RD ,68 ** - ** WARD, SANDRA ** 610-932-112 ** 2113 ** FILLING HER 02 TANK AND THE VALVE IS STUCK OPE\n" +
        "N 4FT X 16 INCH TANK - SPRAYING THROUGH THE HO\n" +
        "USE **  ** 05/22/12 ** NOTIFFC ** OXFF12000814 **  ** Inc History #OXFF12000814  Xref: #68PJ12000475 #OXFF12000815  \n" +
        "                      \n" +
        " Received     05/22/12  13:30:01  BY CT06     709    \n" +
        " Entered      05/22/12  13:32:19  BY CT06     709    \n" +
        " Dispatched   05/22/12  13:36:27  BY FD16     465    \n" +
        " Enroute      05/22/12  13:36:27                     \n\n" +
        " Initial Type: NOTIFFC    Final Type: NOTIFFC (NOTIFY FIRE CHIEF)\n" +
        " Initial Priority: 3      Final Priority: 3 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: 9    Primary Unit: AMB212      Rsp: 0027  \n" +
        " Police BOX: 6801  Fire BOX: 2113  EMS BOX: 2113 \n" +
        " Group: 21FD          Section: 21     Map: 50B11    X: 7608341  Y: 3974022\n\n" +
        " Loc: 251 RED PUMP RD ,68  btwn TAYLOR LA & BRYAN LA (V) \n" +
        " AKA:   Municipality: WNOTT  Dev: \n" +
        " Name: WARD, SANDRA            Addr: SAA                     PH: 610-932-1121   \n\n" +
        "/1332  (709   )  ENTRY            FILLING HER 02 TANK AND THE VALVE IS STUCK OPE\n" +
        "                                  N 4FT X 16 INCH TANK - SPRAYING THROUGH THE HO\n" +
        "                                  USE - STILL GOING OFF\n" +
        "/1333           $CROSS            #OXFF12000815 \n" +
        "/1333  (465   )  HOLD             \n" +
        "/1335  (709   ) $CROSS            #68PJ12000475 \n" +
        "/1336  (465   )  DISPER  AMB212    #AMB212 AMB212 MDT \n" +
        "/1337            ASST    OFC15    [CHF] \n" +
        "PRIOR PREMISE HISTORY FOR: 251 RED PUMP RD ,68                               \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** WNOTT **  ** 21 ** 3 ** TAYLOR LA & BRYAN LA **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:13:36",
        "CALL:NOTIFY FIRE CHIEF",
        "ADDR:251 RED PUMP RD",
        "CITY:WEST NOTTINGHAM TWP",
        "NAME:WARD, SANDRA",
        "PHONE:610-932-112",
        "BOX:2113",
        "INFO:FILLING HER 02 TANK AND THE VALVE IS STUCK OPE",
        "UNIT:AMB212",
        "X:TAYLOR LA & BRYAN LA");

    doTest("T4",
        "Subject: HOUSE FIRE *\n" +
        " Dispatch ** 06:50 ** HOUSE FIRE * ** 121 AMBER DR ,69 ** - ** CHF21 **  ** 2112 ** NO FURTHER INFORMATION\n" +
        " **  ** 05/26/12 ** HOUSE ** OXFF12000844 **  ** Inc History #OXFF12000844  Xref: #69PJ12000186   \n" +
        "                      \n" +
        " Entered      05/26/12  06:50:12  BY FD18     113    \n" +
        " Dispatched   05/26/12  06:50:24  BY FD17     111    \n" +
        " Enroute      05/26/12  06:52:53                     \n" +
        " Onscene      05/26/12  06:53:44                     \n\n" +
        " Initial Type: HOUSE      Final Type: HOUSE   (HOUSE FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: LAD21       Rsp: 0033  \n" +
        " Police BOX: 6902  Fire BOX: 2112  EMS BOX: 2112 \n" +
        " Group: 21FD          Section: 21     Map: 52C4     X: 7592617  Y: 3977274\n\n" +
        " Loc: 121 AMBER DR ,69  btwn ELK RIDGE RD & DEAD END (V) \n" +
        " AKA:   Municipality: ENOTT  Dev: AUTUMN HILL\n" +
        " Name: CHF21                   Addr:                         PH:                \n\n" +
        "/0650  (113   )  ENTRY            NO FURTHER INFORMATION\n" +
        "/0650  (111   )  DISP    LAD21    \n" +
        "/0650            ASST    TKR21    \n" +
        "/0650            ASST    ENG211    #ENG211 ENG211 MDT \n" +
        "/0650            ASST    ENG212    #ENG212 ENG212 MDT \n" +
        "/0650            ASST    ENG213   \n" +
        "/0650            ASST    AMB212    #AMB212 AMB212 MDT \n" +
        "/0650            ASST    CENG18   \n" +
        "/0650            ASST    ENG12     #ENG12  ENG12 MDT \n" +
        "/0650            ASST    RES12     #RES12  RES12 MDT \n" +
        "/0650            ASST    TKR22    \n" +
        "/0652  (135   )  WFD              Alarm Level 1\n" +
        "/0652            DTSEEN           INFO SEEN\n" +
        "/0652            ASST    MED941    #MED941 MED941 MDT \n" +
        "/0652            ASST    CENG0812 \n" +
        "/0652            ASST    LAD22     #LAD22  LAD22 MDT \n" +
        "/0652            ASST    RES27     #RES27  RES27 MDT \n" +
        "/0652  (MED941) *ENROUT  MED941   \n" +
        "/0653  (135   ) *ASSTER  AST21     #AST21  AST21 MDT \n" +
        "/0653  (113   )  ASSTOS  CHF21     #CHF21  CHF21 MDT \n" +
        "/0654  (135   ) *ONSCNE  AST21    \n" +
        "/0655  (ENG211) *ENROUT  ENG211   \n" +
        "/0655  (AMB212) *ENROUT  AMB212   ,89406.8\n" +
        "/0656  (113   )  FM               Alarm Level 1\n" +
        "/0656            DTSEEN           INFO SEEN\n" +
        "/0656            ASST    FM101     #FM101  WEER, JOHN \n" +
        "/0656            ASST    FM103     #FM103  HOLMES, MIKE \n" +
        "/0656            ASST    FM69     \n" +
        "PRIOR PREMISE HISTORY FOR: 121 AMBER DR ,69                                  \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n" +
        "ÿ\n" +
        "{\n" +
        " ** ENOTT ** AUTUMN HILL ** 21 ** E ** ELK RIDGE RD & DEAD END **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:06:50",
        "CALL:HOUSE FIRE",
        "ADDR:121 AMBER DR",
        "CITY:EAST NOTTINGHAM TWP",
        "NAME:CHF21",
        "BOX:2112",
        "INFO:NO FURTHER INFORMATION",
        "UNIT:LAD21",
        "X:ELK RIDGE RD & DEAD END");

    doTest("T5",
        "Subject: HOUSE FIRE *\n" +
        " Dispatch ** 11:52 ** HOUSE FIRE * ** 902 SAGINAW RD ,69 ** BEHIND ABV- ** OSBORN, JANE ** UNK-CELL ** 2112 ** DETAILS TO FOLLOW\n" +
        "LOC: 2467 HICKORY HILL RD ,69 -->  902 SAGINAW\n" +
        " RD ,69, \n" +
        "BOX: 2103 -->  2112\n" +
        " ** NAM: OSBORN, JANE, \n" +
        "ADR: SAA, \n" +
        "PHO: 610-858-8325/C, \n" +
        "TXT: UNK IF OCCUPIED/FULLY INV \n" +
        ",89180 STAR ** 05/23/12 ** HOUSE ** OXFF12000820 **  ** Inc History #OXFF12000820  Xref: #69PJ12000178   \n" +
        "                      \n" +
        " Entered      05/23/12  11:51:37  BY CT04     618    \n" +
        " Dispatched   05/23/12  11:52:10  BY FD16     159    \n" +
        " Enroute      05/23/12  11:56:26                     \n" +
        " Onscene      05/23/12  12:02:23                     \n\n" +
        " Initial Type: HOUSE      Final Type: HOUSE   (HOUSE FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: LAD21       Rsp: 0033  \n" +
        " Police BOX: 6902  Fire BOX: 2112  EMS BOX: 2112 \n" +
        " Group: 21FD          Section: 21     Map: 52D6     X: 7592607  Y: 3977539\n\n" +
        " Loc: 902 SAGINAW RD ,69  btwn MUNICIPAL BOUNDARY & RIDGE LA (V) \n" +
        " AKA:   Municipality: ENOTT  Dev: \n" +
        " Loc Info: BEHIND ABV\n" +
        " Name: OSBORN, JANE            Addr: SAA                     PH: UNK-CELL       \n\n" +
        "/1151  (618   )  ENTRY            DETAILS TO FOLLOW\n" +
        "/1152  (159   )  DISP    LAD21    \n" +
        "/1152            ASST    TKR21    \n" +
        "/1152            ASST    ENG211    #ENG211 ENG211 MDT \n" +
        "/1152            ASST    ENG212    #ENG212 ENG212 MDT \n" +
        "/1152            ASST    ENG213   \n" +
        "/1152            ASST    AMB212    #AMB212 AMB212 MDT \n" +
        "/1152            ASST    CENG18   \n" +
        "/1152            ASST    CTKR08   \n" +
        "/1152            ASST    ENG12     #ENG12  ENG12 MDT \n" +
        "/1152            ASST    RES12     #RES12  RES12 MDT \n" +
        "/1152  (618   )  SUPP             NAM: OSBORN, JANE, \n" +
        "                                  ADR: SAA, \n" +
        "                                  PHO: 610-858-8325/C, \n" +
        "                                  TXT: UNK IF OCCUPIED/FULLY INV \n" +
        "/1156  (159   ) *ENROUT  ENG211   \n" +
        "/1156  (AMB212) *ENROUT  AMB212   \n" +
        "/1156           *MISC    AMB212   ,89180 START\n" +
        "/1157  (159   )  ASSTER  ENG22     #ENG22  ENG22 MDT \n" +
        "/1157           *ENROUT  TKR21    \n" +
        "/1159            ASSTER  ENG32     #ENG32  ENG32 MDT \n" +
        "/1159  (ENG212) *ENROUT  ENG212   \n" +
        "/1159  (159   ) *ASSTER  TKR22    \n" +
        "/1201           *ENROUT  ENG12    \n" +
        "/1202            ONSCNE  ENG211   [AREA] \n" +
        "/1203            CHANGE           LOC: 2467 HICKORY HILL RD ,69 -->  902 SAGINAW\n" +
        "                                   RD ,69, \n" +
        "                                  BOX: 2103 -->  2112\n" +
        "/1204            ASSTOS  DEP21    [SAGINAW CMND] \n" +
        "                                   #DEP21  DEP21 MDT \n" +
        "/1204            WFD              Alarm Level 1\n" +
        "/1204            DTSEEN           INFO SEEN\n" +
        "/1204            ASST    MED941    #MED941 MED941 MDT \n" +
        "/1205  (136   )  ASSTER  CENG0813 \n" +
        "/1205  (159   )  MISC    DEP21    ,2 STY SFD FULLY INVOLVED\n" +
        "/1206  (MED941) *ENROUT  MED941   \n" +
        "/1206  (159   ) *ONSCNE  TKR21    \n" +
        "/1207  (465   )  FM               Alarm Level 1\n" +
        "/1207  (159   )  DTSEEN           INFO SEEN\n" +
        "/1207            FM               Alarm Level 1\n" +
        "/1207            DTSEEN           INFO SEEN\n" +
        "/1207            ASST    FM101     #FM101  WEER, JOHN \n" +
        "/1207            ASST    FM103     #FM103  HOLMES, MIKE \n" +
        "PRIOR PREMISE HISTORY FOR: 902 SAGINAW RD ,69                                \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** ENOTT **  ** 21 ** E ** MUNICIPAL BOUNDARY & RIDG **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:11:52",
        "CALL:HOUSE FIRE",
        "ADDR:902 SAGINAW RD",
        "CITY:EAST NOTTINGHAM TWP",
        "PLACE:BEHIND ABV",
        "NAME:OSBORN, JANE",
        "PHONE:UNK-CELL",
        "BOX:2112",
        "UNIT:LAD21",
        "X:MUNICIPAL BOUNDARY & RIDGE LA");

    doTest("T6",
        "Subject: ACCIDENT - ENTRAPMENT *\n" +
        " Dispatch ** 21:44 ** ACCIDENT - ENTRAPMENT * ** RT 472/STREET RD ,56    (V) ** - ** WHARTON. MIKE ** 484-486-970 ** 2111 ** TT TURNED OVER\n" +
        "DETAILS TO FOLLOW\n" +
        "TYP: ACCUNK -->  ACCENT, \n" +
        "RSP: 0050 -->  0002, \n" +
        "PRI: 1 -->  E, ** NAM: WHARTON. MIKE, \n" +
        "ADR: OHIO, \n" +
        "PHO: 302-420-4739CP, \n" +
        "TXT: T/T ROLLED OVER HILLSIDE, POSS MILK T ** 05/26/12 ** ACCENT ** OXFF12000854 **  ** Inc History #OXFF12000854  Xref: #56PJ12000096   \n" +
        "                      \n" +
        " Entered      05/26/12  21:44:14  BY CT09     693    \n" +
        " Dispatched   05/26/12  21:44:22  BY FD16     151    \n" +
        " Enroute      05/26/12  21:45:51                     \n" +
        " Onscene      05/26/12  21:49:50                     \n\n" +
        " Initial Type: ACCUNK     Final Type: ACCENT  (ACCIDENT - ENTRAPMENT *)\n" +
        " Initial Priority: 1      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: RES21       Rsp: 0002  \n" +
        " Police BOX: 5603  Fire BOX: 2111  EMS BOX: 2111 \n" +
        " Group: 21FD          Section: 21     Map:          X: 7601432  Y: 3980081\n\n" +
        " Loc: RT 472/STREET RD ,56    (V) \n" +
        " AKA:                            Municipality: LWROXF Dev:                          \n" +
        " Name: WHARTON. MIKE           Addr: OHIO                    PH: 484-486-9703C  \n\n" +
        "/2144  (693   )  ENTRY            TT TURNED OVER\n" +
        "/2144            ENTRY            DETAILS TO FOLLOW\n" +
        "/2144  (151   )  DISP    RES21    \n" +
        "/2144            ASST    AMB212    #AMB212 AMB212 MDT \n" +
        "/2145  (AMB212) *ENROUT  AMB212   \n" +
        "/2146  (694   )  SUPP             NAM: WHARTON. MIKE, \n" +
        "                                  ADR: OHIO, \n" +
        "                                  PHO: 302-420-4739CP, \n" +
        "                                  TXT: T/T ROLLED OVER HILLSIDE, POSS MILK TANKE\n" +
        "                                  R, OPER OUT OF VEH, HIT HEAD, IS CONSC \n" +
        "/2146  (AMB212) *MISC    AMB212   ,89513\n" +
        "/2146  (550   )  SUPP             NAM: CAPOFERRI, ROBIN/WITN, \n" +
        "                                  ADR: 768 KING PEN RD, \n" +
        "                                  PHO: C-717-940-3744, \n" +
        "                                  TXT: 2 VEHS--OFF TO SIDE---TT ON ITS SIDE--MIL\n" +
        "                                  K TRUCK \n" +
        "/2146  (AMB212) *ACKD    AMB212    #AMB212 AMB212 MDT \n" +
        "/2146  (151   )  ASSTER  OFC21    [DEP] \n" +
        "/2147  (693   )  CHANGE           TYP: ACCUNK -->  ACCENT, \n" +
        "                                  RSP: 0050 -->  0002, \n" +
        "                                  PRI: 1 -->  E, \n" +
        "                                  TXT: ONE TRAPPED UNDERNEATH TT \n" +
        "/2147  (151   )  ASST    ENG211    #ENG211 ENG211 MDT \n" +
        "/2147            ASST    MED941    #MED941 MED941 MDT \n" +
        "/2147            ASST    LMED779  \n" +
        "/2148  (693   )  SUPP             TXT: RP STATING THAT THERE ARE TWO PEOPLE DECE\n" +
        "                                  ASED IN VEH \n" +
        "/2148  (151   )  ASSTER  AST21     #AST21  AST21 MDT \n" +
        "/2148  (MED941) *ENROUT  MED941   \n" +
        "/2149  (151   )  ASSTER  CHF21     #CHF21  CHF21 MDT \n" +
        "/2149           *ENROUT  RES21    \n" +
        "/2149            ONSCNE  OFC21    \n" +
        "/2150            ASST    FP21     \n" +
        "/2150  (528   )  ENROUT  LMED779  \n" +
        "/2151  (151   )  MISC             ,HEAVY ENTRAPMENT ON 2\n" +
        "/2152           *ENROUT  ENG211   \n" +
        "/2152  (114   )  MISC             INC SENT TO KNOWLEDGE CENTER WLEDGE CENTER \n" +
        "/2152  (151   ) *ONSCNE  RES21    \n" +
        "/2153           *ASSTER  ENG213   \n" +
        "/2155  (AMB212) *ONSCNE  AMB212   \n" +
        "/2155  (MED941) *ONSCNE  MED941   \n" +
        "/2158  (151   )  NEWLOC  OFC21    [DEP 472 CMND] \n" +
        "/2158            ASST    OFC15    ,CALL DEP21\n" +
        "PRIOR PREMISE HISTORY FOR: RT 472/STREET RD ,56                              \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " **  **  ** 21 ** E **  **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:21:44",
        "CALL:ACCIDENT - ENTRAPMENT",
        "ADDR:RT 472 & STREET RD",
        "CITY:LOWER OXFORD TWP",
        "NAME:WHARTON. MIKE",
        "PHONE:484-486-970",
        "BOX:2111",
        "INFO:TT TURNED OVER",
        "UNIT:RES21");

    doTest("T7",
        "Subject: HOUSE FIRE *\n" +
        " Dispatch ** 20:32 ** HOUSE FIRE * ** 213 BRANDYWINE AV ,11 ** - ** A/F ** 973-879-050 ** 4601 ** FIRE IN KITCH - GREASE FIRE - BOY FIRNED IS PA\n" +
        "SSED FROM DIABETUS - CAN NOT GET HIM OUT\n" +
        "DETAILS TO ** NAM: A/F, \n" +
        "ADR: SAA, \n" +
        "TXT: RP IS 5 MONTHS PREGNANT - UNABLE TO MOVE \n" +
        "BOYFIRNED FROM UPSTAIRS BEDR ** 05/25/12 ** HOUSE ** DNTF12000653 **  ** Inc History #DNTF12000653  Xref: #11PJ12003491   \n" +
        "                      \n" +
        " Entered      05/25/12  20:32:26  BY CT08     666    \n" +
        " Dispatched   05/25/12  20:32:43  BY FD18     159    \n" +
        " Enroute      05/25/12  20:34:07                     \n" +
        " Onscene      05/25/12  20:34:41                     \n\n" +
        " Initial Type: HOUSE      Final Type: HOUSE   (HOUSE FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: ENG461      Rsp: 0033  \n" +
        " Police BOX: 1105  Fire BOX: 4601  EMS BOX: 4601 \n" +
        " Group: 46FD          Section: 46     Map: 30G2     X: 7570903  Y: 4000581\n\n" +
        " Loc: 213 BRANDYWINE AV ,11  btwn JEFFERSON AV & LOGAN AV (V) \n" +
        " AKA:   Municipality: DNGTWN Dev: \n" +
        " Name: A/F                     Addr: SAA                     PH: 973-879-0505/CP\n\n" +
        "/2032  (666   )  ENTRY            FIRE IN KITCH - GREASE FIRE - BOY FIRNED IS PA\n" +
        "                                  SSED FROM DIABETUS - CAN NOT GET HIM OUT\n" +
        "/2032            ENTRY            DETAILS TO FOLLOW\n" +
        "/2032  (159   )  DTSEEN           INFO SEEN\n" +
        "/2032            DISP    ENG461    #ENG461 ENG461 MDT \n" +
        "/2032            ASST    AMB461    #AMB461 AMB461 MDT \n" +
        "/2032            ASST    ENG45     #ENG45  ENG45 MDT \n" +
        "/2032            ASST    TWR45     #TWR45  TWR45 MDT \n" +
        "/2032  (666   )  SUPP             NAM: A/F, \n" +
        "                                  ADR: SAA, \n" +
        "                                  TXT: RP IS 5 MONTHS PREGNANT - UNABLE TO MOVE \n" +
        "                                  BOYFIRNED FROM UPSTAIRS BEDROOM - NFI DISCONNE\n" +
        "                                  CTED \n" +
        "/2034  (AMB461) *ENROUT  AMB461   \n" +
        "/2034  (159   )  ASSTER  OFC46    [DEP] \n" +
        "/2034            ASSTER  MED461    #MED461 MED461 MDT \n" +
        "/2034  (AMB461) *ONSCNE  AMB461   \n" +
        "/2035  (159   )  MISC    AMB461   ,2.5 STY SFD SMOKE SHOWING SIDE A\n" +
        "/2036            ONSCNE  OFC46    \n" +
        "/2036           *ENROUT  TWR45    \n" +
        "/2036            MISC    OFC46    ,NEG ENTRAPMENT CONFIRMING SMOKE SHOWING\n" +
        "/2037  (ENG461) *ENROUT  ENG461   \n" +
        "/2037  (159   ) *ASSTER  AIR46     #AIR46  AIR46 MDT \n" +
        "/2037           *ASSTER  RES45     #RES45  RES45 MDT \n" +
        "/2038            NEWLOC  OFC46    [DEP/BRANDYWINE AVE CMND] \n" +
        "                                  ,1ST IN ENGINE LAY WATER SUPPLY AND PRECONNECT\n" +
        "/2038  (136   )  ONSCNE  ENG461   \n" +
        "/2038  (159   ) *ONSCNE  TWR45    \n" +
        "/2038           *ENROUT  ENG45    \n" +
        "/2039           *ASSTER  AMB462    #AMB462 AMB462 MDT \n" +
        "/2039           *ONSCNE  AIR46    \n" +
        "/2039           *ONSCNE  RES45    \n" +
        "/2039            ASSTER  FP46     [30] \n" +
        "/2039  (AMB462) *ONSCNE  AMB462   \n" +
        "/2041  (159   )  MISC    OFC46    ,FIRE KNOCKED DOWN CHKG FOR EXTENTIONS ALL UNI\n" +
        "                                  TS WORKING\n" +
        "/2041            NEWLOC  RES45    [BRANDYWINE AV CP] \n" +
        "/2042           *ASSTER  SQD46    \n" +
        "/2042           *ASSTOS  SQD45    \n" +
        "/2044  (RES45 ) *MISC    RES45    ,46C DIV 1\n" +
        "/2046  (159   ) *ASSTER  TRF45    \n" +
        "/2047  (AMB461) *TRANS   AMB461   [PMH] \n" +
        "/2047  (159   ) *ONSCNE  TRF45    \n" +
        "/2049            MISC    AMB461   ,CIVILIAN W/POSS AIRWAY BURNS\n" +
        "/2049            TRANS   MED461   [PMH] \n" +
        "/2052            FM               Alarm Level 1\n" +
        "/2052            DTSEEN           INFO SEEN\n" +
        "/2052            ASST    FM103     #FM103  HOLMES, MIKE \n" +
        "/2052            ASST    FM101     #FM101  WEER, JOHN \n" +
        "PRIOR PREMISE HISTORY FOR: 213 BRANDYWINE AV ,11                             \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #DNTF12000653 Type: HOUSE   Loc: 213 BRANDYWINE AV ,11\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "11-010      0     DOWNING AV/WEBSTER AV ,11\n" +
        "               \n" +
        "11-008      0     DOWNING AV/W PENNSYLVANIA AV ,11\n" +
        "               \n" +
        "11-009      0     W PENNSYLVANIA AV/RT 322 ,11\n" +
        "               \n" +
        "11-018      0      19 DOWNING AV, 11\n" +
        "               \n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** DNGTWN **  ** 46 ** E ** JEFFERSON AV & LOGAN AV **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:20:32",
        "CALL:HOUSE FIRE",
        "ADDR:213 BRANDYWINE AV",
        "MADDR:213 BRANDYWINE AVE",
        "CITY:DOWNINGTOWN",
        "NAME:A/F",
        "PHONE:973-879-050",
        "BOX:4601",
        "INFO:FIRE IN KITCH - GREASE FIRE - BOY FIRNED IS PASSED FROM DIABETUS - CAN NOT GET HIM OUT",
        "UNIT:ENG461",
        "X:JEFFERSON AV & LOGAN AV");

    doTest("T8",
        "Subject: BRUSH FIRE *\n" +
        " Dispatch ** 23:58 ** BRUSH FIRE * ** NB KAOLIN RD NO WOODRIDGE DR ,62   (V) ** IAO SMITH RIDGE DEVELOPMENT- ** JAQUELINE DALLE ** 610-513-918 ** 2407 ** BRUSH ON FIRE/300 FT FROM INTERSECTION\n" +
        "DETAILS TO FOLLOW\n" +
        " ** NAM: JAQUELINE DALLER, \n" +
        "ADR: 123 W CYPRESS ST, \n" +
        "PHO: 610-513-9189/C, \n" +
        "TXT: WILL BE ON THE RIGHT S ** 05/27/12 ** BRUSH ** KSQF12000378 **  ** Inc History #KSQF12000378  Xref: #62PJ12001089 #KSQF12000379  \n" +
        "                      \n" +
        " Entered      05/27/12  23:58:12  BY PD13     650    \n" +
        " Dispatched   05/27/12  23:58:18  BY FD16     528    \n" +
        " Enroute      05/28/12  00:01:46                     \n" +
        " Onscene      05/28/12  00:04:20                     \n\n" +
        " Initial Type: BRUSH      Final Type: BRUSH   (BRUSH FIRE *)\n" +
        " Initial Priority: 2      Final Priority: 2 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: BRU24       Rsp: 0021  \n" +
        " Police BOX: 6201  Fire BOX: 2407  EMS BOX: 2407 \n" +
        " Group: 24FD          Section: 24     Map:          X: 7570604  Y: 3982187\n\n" +
        " Loc: NB KAOLIN RD NO WOODRIDGE DR ,62   (V) \n" +
        " AKA:   Municipality: KNTTWP Dev: \n" +
        " Loc Info: IAO SMITH RIDGE DEVELOPMENT\n" +
        " Name: JAQUELINE DALLER        Addr: 123 W CYPRESS ST        PH: 610-513-9189/C \n\n" +
        "/2358  (650   )  ENTRY            BRUSH ON FIRE/300 FT FROM INTERSECTION\n" +
        "/2358            ENTRY            DETAILS TO FOLLOW\n" +
        "/2358  (528   )  DISP    BRU24    \n" +
        "/2358            ASST    ENG241    #ENG241 ENG241 MDT \n" +
        "/2359  (650   )  SUPP             NAM: JAQUELINE DALLER, \n" +
        "                                  ADR: 123 W CYPRESS ST, \n" +
        "                                  PHO: 610-513-9189/C, \n" +
        "                                  TXT: WILL BE ON THE RIGHT SIDE OF RDWY--RP IS \n" +
        "                                  NOW AT INTERSECTION OF WOODRIDGE AND KAOLIN IN\n" +
        "                                   A WHITE HONDA CIVIC AND CAN DIRECT FD \n" +
        "*** New Date: 05/28/12 ***\n" +
        "/0000  (528   ) $CROSS            #KSQF12000379 \n" +
        "/0000            DUP              #KSQF12000379 \n" +
        "/0000            DUP              NAM: MORRISON, NANCY \n" +
        "                                  ADR: 4 CONCORD WY \n" +
        "                                  PHO: C-410-274-0752  \n" +
        "/0001  (116   )  SUPP             NAM: KAOFFENBERGER, LEIGH, \n" +
        "                                  PHO: 610-620-8549, \n" +
        "                                  TXT: BRUSH BURNING ALONG THE ROAD \n" +
        "/0001  (528   )  ASSTER  DEP24     #DEP24  DEP24 MDT \n" +
        "/0003           *ENROUT  BRU24    \n" +
        "/0004            ONSCNE  DEP24    ,10X10\n" +
        "/0005            MISC    DEP24    ,SPREADING INTO WOODS\n" +
        "/0005            ASSTOS  CHF24     #CHF24  CHF24 MDT \n" +
        "/0005           *ASSTER  ENG242    #ENG242 ENG242 MDT \n" +
        "/0006           *ASSTER  SQD24    \n" +
        "/0006            NEWLOC  CHF24    [KAOLIN CMD] \n" +
        "/0008           *ONSCNE  BRU24    \n" +
        "/0010           *ONSCNE  ENG242   \n" +
        "/0010           *ONSCNE  SQD24    \n" +
        "/0012            ASSTER  AMB241    #AMB241 AMB241 MDT \n" +
        "/0014            FM               Alarm Level 1\n" +
        "/0014            DTSEEN           INFO SEEN\n" +
        "/0015            ASST    FM101     #FM101  WEER, JOHN \n" +
        "PRIOR PREMISE HISTORY FOR: NB KAOLIN RD NO WOODRIDGE DR ,62                  \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** KNTTWP **  ** 24 ** 2 **  **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:23:58",
        "CALL:BRUSH FIRE",
        "ADDR:NB KAOLIN RD NO WOODRIDGE DR",
        "MADDR:KAOLIN RD & WOODRIDGE DR",
        "CITY:KENNETT TWP",
        "PLACE:IAO SMITH RIDGE DEVELOPMENT",
        "NAME:JAQUELINE DALLE",
        "PHONE:610-513-918",
        "BOX:2407",
        "INFO:BRUSH ON FIRE/300 FT FROM INTERSECTION",
        "UNIT:BRU24");

    doTest("T9",
        "Subject: BUILDING FIRE *\n" +
        " Dispatch ** 09:35 ** BUILDING FIRE * ** 113 LANDENBERG RD ,60 ** APT 10- ** PELPS, ANDREW ** 302-489-980 ** 2305 ** SMELLS SMOKE - SMOKE DETECTORS GOING OFF\n" +
        "DETAILS TO FOLLOW\n" +
        "LOC: 115 LANDENBERG RD ,60 -->  113 LAN ** LOCI: APT 10, \n" +
        "NAM: PELPS, ANDREW, \n" +
        "ADR: APT 11, \n" +
        "PHO: 302-489-9800C\n" +
        "PHO: 302-489-9800C, \n" +
        "TXT: ** 05/31/12 ** BUILDNG ** AVNF12000583 **  ** Inc History #AVNF12000583  Xref: #60PJ12002402   \n" +
        "                      \n" +
        " Received     05/31/12  09:33:56  BY CT04     641    \n" +
        " Entered      05/31/12  09:34:50  BY CT04     641    \n" +
        " Dispatched   05/31/12  09:35:18  BY FD16     465    \n" +
        " Enroute      05/31/12  09:44:26                     \n" +
        " Onscene      05/31/12  09:51:23                     \n\n" +
        " Initial Type: INVIN      Final Type: BUILDNG (BUILDING FIRE *)\n" +
        " Initial Priority: 1      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: C    Primary Unit: TKR23       Rsp: 0033  \n" +
        " Police BOX: 6003  Fire BOX: 2305  EMS BOX: 2305 \n" +
        " Group: 23FD          Section: 23     Map: 54G3     X: 7577002  Y: 3977876\n\n" +
        " Loc: 113 LANDENBERG RD ,60  btwn PENN GREEN RD & WABA LA (V) \n" +
        " AKA:   Municipality: NGARDN Dev: \n" +
        " Loc Info: APT 10\n" +
        " Name: PELPS, ANDREW           Addr: APT 11                  PH: 302-489-9800   \n\n" +
        "/0934  (641   )  ENTRY            SMELLS SMOKE - SMOKE DETECTORS GOING OFF\n" +
        "/0934            ENTRY            DETAILS TO FOLLOW\n" +
        "/0935  (465   )  DISP    TKR23    \n" +
        "/0935            ASST    ENG232    #ENG232 ENG232 MDT \n" +
        "/0935  (641   )  SUPP             LOCI: APT 10, \n" +
        "                                  NAM: PELPS, ANDREW, \n" +
        "                                  ADR: APT 11, \n" +
        "                                  PHO: 302-489-9800C\n" +
        "/0936            SUPP             PHO: 302-489-9800C, \n" +
        "                                  TXT: APTS ARE AT THE OLD LANDENBERG POST OFFIC\n" +
        "                                  E \n" +
        "/0936  (465   )  MISC             ,APT COMPLEX NAME UNK\n" +
        "/0942  (704   )  SUPP             TXT: PER PD OS, 113 LANDENBERG IS THE CORRECT \n" +
        "                                  ADDRESS \n" +
        "/0942            CHANGE           LOC: 115 LANDENBERG RD ,60 -->  113 LANDENBERG\n" +
        "                                   RD ,60\n" +
        "/0944  (465   ) *ENROUT  ENG232   \n" +
        "/0944  (704   )  SUPP             TXT: PER PD OS, CONF STRONG ODOR OF SMOKE, BUT\n" +
        "                                   NOTHING SHOWING \n" +
        "/0945            SUPP             TXT: PD OS IS GOING TO FORCE ENTRY INTO THE AP\n" +
        "                                  T \n" +
        "/0945  (465   )  ASST    N193     \n" +
        "/0946            ASSTER  AMB231    #AMB231 AMB231 MDT \n" +
        "/0948            CHANGE           TYP: INVIN -->  BUILDNG, \n" +
        "                                  RSP: 0025 -->  0033, \n" +
        "                                  PRI: 1 -->  E\n" +
        "/0948            ASST    ENG233    #ENG233 ENG233 MDT \n" +
        "/0948            ASST    RES23     #RES23  RES23 MDT \n" +
        "/0948            ASST    NTKR19   \n" +
        "/0948            ASST    NTWR19   \n" +
        "/0948            ASST    N195     \n" +
        "/0948            ASST    ENG22     #ENG22  ENG22 MDT \n" +
        "/0948            ASST    RES22     #RES22  RES22 MDT \n" +
        "/0949  (704   )  SUPP             TXT: PD OS BELIEVES HE HAS FIRE UNDER CONTROL \n" +
        "                                  WITH AN EXTINGUISHER, EXPL TO HIM IT WAS UPGRA\n" +
        "                                  DED TO A BLDG--***PD WOULD LIKE AN ETA FOR FD*\n" +
        "                                  ** \n" +
        "/0951  (465   )  ONSCNE  ENG232   \n" +
        "/0951            ENROUT  NTKR19   \n" +
        "/0952            ONSCNE  AMB231   \n" +
        "/0953  (AMB231) *MISC    AMB231   ,37743 - OS\n" +
        "/0955  (465   ) *ENROUT  ENG22    \n" +
        "/0956            ASSTER  ENG32     #ENG32  ENG32 MDT \n" +
        "/0958           *ENROUT  ENG233   \n" +
        "/0959           *AIQ     ENG233   \n" +
        "/0959            MISC             ,REDUCE AND HOLD\n" +
        "/0959  (704   )  SUPP             TXT: PD OS REQ FIRE MARSHALL TO RESPOND \n" +
        "/1000  (465   )  FM               Alarm Level 1\n" +
        "/1000            DTSEEN           INFO SEEN\n" +
        "/1000            ASST    FM101     #FM101  WEER, JOHN \n" +
        "/1000            ASST    FM103     #FM103  HOLMES, MIKE \n" +
        "PRIOR PREMISE HISTORY FOR: 113 LANDENBERG RD ,60                             \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** NGARDN **  ** 23 ** E ** PENN GREEN RD & WABA LA **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:09:35",
        "CALL:BUILDING FIRE",
        "ADDR:113 LANDENBERG RD",
        "CITY:NEW GARDEN TWP",
        "PLACE:APT 10",
        "NAME:PELPS, ANDREW",
        "PHONE:302-489-980",
        "BOX:2305",
        "INFO:SMELLS SMOKE - SMOKE DETECTORS GOING OFF",
        "UNIT:TKR23",
        "X:PENN GREEN RD & WABA LA");

    doTest("T10",
        "Subject: HOUSE FIRE *\n" +
        " Dispatch ** 08:28 ** HOUSE FIRE * ** 270 KELTON RD ,58 ** - ** MARTIN, NORMA ** 302-333-804 ** 2203 ** DETAILS TO FOLLOW\n" +
        " ** NAM: MARTIN, NORMA, \n" +
        "ADR: SAA, \n" +
        "TXT: EVACUATED -- RP IS SPEAKING IN ANOTHER LA\n" +
        "NGUAGE \n" +
        "NAM: FOX, ** 06/01/12 ** HOUSE ** WGRF12000712 **  ** Inc History #WGRF12000712  Xref: #58PJ12000430   \n" +
        "                      \n" +
        " Entered      06/01/12  08:27:24  BY CT09     693    \n" +
        " Dispatched   06/01/12  08:28:19  BY FD16     125    \n" +
        " Enroute      06/01/12  08:29:15                     \n" +
        " Onscene      06/01/12  08:32:21                     \n\n" +
        " Initial Type: HOUSE      Final Type: HOUSE   (HOUSE FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: LAD22       Rsp: 0033  \n" +
        " Police BOX: 5804  Fire BOX: 2203  EMS BOX: 2203 \n" +
        " Group: 22FD          Section: 22     Map: 45A11    X: 7586689  Y: 3983756\n\n" +
        " Loc: 270 KELTON RD ,58  btwn DUTTON FARMS LA & CORBY RD (V) \n" +
        " AKA:   Municipality: PENN   Dev: \n" +
        " Name: MARTIN, NORMA           Addr: SAA                     PH: 302-333-8049C  \n\n" +
        "/0827  (693   )  ENTRY            DETAILS TO FOLLOW\n" +
        "/0828  (125   )  DTSEEN           INFO SEEN\n" +
        "/0828            DISP    LAD22     #LAD22  LAD22 MDT \n" +
        "/0828            ASST    TKR22    \n" +
        "/0828            ASST    ENG22     #ENG22  ENG22 MDT \n" +
        "/0828            ASST    RES22     #RES22  RES22 MDT \n" +
        "/0828            ASST    ENG12     #ENG12  ENG12 MDT \n" +
        "/0828            ASST    RES12     #RES12  RES12 MDT \n" +
        "/0828            ASST    AMB222    #AMB222 AMB222 MDT \n" +
        "/0828            ASST    ENG32     #ENG32  ENG32 MDT \n" +
        "/0828            ASST    TKR23    \n" +
        "/0828            ASST    ENG232    #ENG232 ENG232 MDT \n" +
        "/0828            ASST    ENG233    #ENG233 ENG233 MDT \n" +
        "/0828            ASST    RES23     #RES23  RES23 MDT \n" +
        "/0828            ASST    AMB211    #AMB211 AMB211 MDT \n" +
        "/0829  (693   )  SUPP             NAM: MARTIN, NORMA, \n" +
        "                                  ADR: SAA, \n" +
        "                                  TXT: EVACUATED -- RP IS SPEAKING IN ANOTHER LA\n" +
        "                                  NGUAGE \n" +
        "/0829  (AMB211) *ENROUT  AMB211   \n" +
        "/0830  (125   )  CLEAR   AMB211   \n" +
        "/0831  (AST22 ) *ASSTER  AST22     #AST22  AST22 MDT \n" +
        "/0831  (125   )  ASSTER  AMB221    #AMB221 AMB221 MDT \n" +
        "/0831  (550   )  SUPP             NAM: FOX, DON, \n" +
        "                                  ADR: 283 KELTON RD, \n" +
        "                                  PHO: 610-869-9295, \n" +
        "                                  TXT: SINGLE WIDE MOBILE HOME--SMOKE SHOWING--E\n" +
        "                                  VAC \n" +
        "/0832  (125   )  ONSCNE  AST22    ,WELL OFF\n" +
        "/0832            WFD              Alarm Level 1\n" +
        "/0833            DTSEEN           INFO SEEN\n" +
        "/0833            ASST    MED941    #MED941 MED941 MDT \n" +
        "/0833            ASST    ENG211    #ENG211 ENG211 MDT \n" +
        "/0833            ASST    RES27     #RES27  RES27 MDT \n" +
        "/0834            DTSEEN           INFO SEEN\n" +
        "/0834            ASST    TKR21    \n" +
        "/0834            ASST    ENG275    #ENG275 ENG275 MDT \n" +
        "/0834  (MED941) *ENROUT  MED941   \n" +
        "/0836  (125   ) *ENROUT  ENG22    \n" +
        "/0836  (151   )  ASST    FM101     #FM101  WEER, JOHN \n" +
        "PRIOR PREMISE HISTORY FOR: 270 KELTON RD ,58                                 \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** PENN **  ** 22 ** E ** DUTTON FARMS LA & CORBY R **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:08:28",
        "CALL:HOUSE FIRE",
        "ADDR:270 KELTON RD",
        "CITY:PENN TWP",
        "NAME:MARTIN, NORMA",
        "PHONE:302-333-804",
        "BOX:2203",
        "UNIT:LAD22",
        "X:DUTTON FARMS LA & CORBY RD");

    doTest("T11",
        "Subject: HOUSE FIRE *\n" +
        " Dispatch ** 11:02 ** HOUSE FIRE * ** 5 EMERY LA ,26 ** - ** NAROSFAVI, JULI ** 267-614-621 ** 6101 ** BLK SMOKE COMING FROM FRT DOORS, RP HASNT SEEN\n" +
        " FLAMES\n" +
        "DETAILS TO FOLLOW\n" +
        " ** NAM: NAROSFAVI, JULIUS, \n" +
        "ADR: SAA, \n" +
        "TXT: RP EVACUATED, SOME PETS STILL INSIDE \n" +
        "TXT: PER PD - BLK ** 06/05/12 ** HOUSE ** KMBF12000470 **  ** Inc History #KMBF12000470  Xref: #26PJ12003193   \n" +
        "                      \n" +
        " Entered      06/05/12  11:01:59  BY CT07     712    \n" +
        " Dispatched   06/05/12  11:02:31  BY FD18     580    \n" +
        " Enroute      06/05/12  11:04:40                     \n" +
        " Onscene      06/05/12  11:08:36                     \n\n" +
        " Initial Type: HOUSE      Final Type: HOUSE   (HOUSE FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: TWR61       Rsp: 0033  \n" +
        " Police BOX: 2601  Fire BOX: 6101  EMS BOX: 6101 \n" +
        " Group: 61FD          Section: 61     Map: 14J3     X: 7555205  Y: 4014231\n\n" +
        " Loc: 5 EMERY LA ,26  btwn ZOLLARS DR & DEAD END (V) \n" +
        " AKA:   Municipality: EPIKEL Dev: \n" +
        " Name: NAROSFAVI, JULIUS       Addr: SAA                     PH: 267-614-6216   \n\n" +
        "/1101  (712   )  ENTRY            BLK SMOKE COMING FROM FRT DOORS, RP HASNT SEEN\n" +
        "                                   FLAMES\n" +
        "/1101            ENTRY            DETAILS TO FOLLOW\n" +
        "/1102  (580   )  DTSEEN           INFO SEEN\n" +
        "/1102            DISP    TWR61     #TWR61  TWR61 MDT \n" +
        "/1102            ASST    TKR61    \n" +
        "/1102            ASST    RES61     #RES61  RES61 MDT \n" +
        "/1102            ASST    ENG61     #ENG61  ENG61 MDT \n" +
        "/1102            ASST    MIC671    #MIC671 MIC671 MDT \n" +
        "/1102            ASST    LAD65     #LAD65  LAD65 MDT \n" +
        "/1102            ASST    ENG651    #ENG651 ENG651 MDT \n" +
        "/1102            ASST    ENG652    #ENG652 ENG652 MDT \n" +
        "/1102            ASST    ENG625    #ENG625 ENG625 MDT \n" +
        "/1103  (712   )  SUPP             NAM: NAROSFAVI, JULIUS, \n" +
        "                                  ADR: SAA, \n" +
        "                                  TXT: RP EVACUATED, SOME PETS STILL INSIDE \n" +
        "/1104  (580   ) *ASSTER  MIC672    #MIC672 MIC672 MDT \n" +
        "/1105           *ASSTER  DEP61     #DEP61  DEP61 MDT \n" +
        "/1105            AOR     MIC671   \n" +
        "/1106  (ENG61 ) *ENROUT  ENG61    \n" +
        "/1106  (666   )  SUPP             TXT: PER PD - BLK SMOKE COMING FROM ROOF OF HO\n" +
        "                                  USE \n" +
        "/1107            SUPP             TXT: EPR PD - NO FLAMES - ENTIRE INSIDE COVERE\n" +
        "                                  D WITH SMOKE \n" +
        "/1107  (580   )  WFD              Alarm Level 1\n" +
        "/1108  (666   )  SUPP             TXT: SMOKE FROM UPSTAIRS BEDROOM WINDOW \n" +
        "/1108  (MIC672) *ONSCNE  MIC672   \n" +
        "/1108  (580   )  ONSCNE  DEP61    ,HVY SMK REAR\n" +
        "/1109            NEWLOC  DEP61    [EMERY CMND] \n" +
        "/1109  (436   )  ASSTER  FM100     #FM100  HOLT, HARRISON \n" +
        "PRIOR PREMISE HISTORY FOR: 5 EMERY LA ,26                                    \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #KMBF12000470 Type: HOUSE   Loc: 5 EMERY LA ,26\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "26-110      0      810 CAMP CI, 26\n" +
        "               \n" +
        "26-109      0      828 CAMP CI, 26\n" +
        "               \n" +
        "26-122      0     CAMP COUNCIL RD/RAPPS DAM RD ,26\n" +
        "               \n" +
        "26-125      0      1115 RAPPS DAM RD, 26\n" +
        "               \n\n" +
        "+++ATE0Q1\n" +
        "ÿ\n" +
        "{\n" +
        " ** EPIKEL **  ** 61 ** E ** ZOLLARS DR & DEAD END **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:11:02",
        "CALL:HOUSE FIRE",
        "ADDR:5 EMERY LA",
        "MADDR:5 EMERY LN",
        "CITY:EAST PIKELAND TWP",
        "NAME:NAROSFAVI, JULI",
        "PHONE:267-614-621",
        "BOX:6101",
        "INFO:BLK SMOKE COMING FROM FRT DOORS, RP HASNT SEEN FLAMES",
        "UNIT:TWR61",
        "X:ZOLLARS DR & DEAD END");

    doTest("T12",
        "Subject: APPLIANCE FIRE *\n" +
        " Dispatch ** 20:51 ** APPLIANCE FIRE * ** 1602 IVY LA ,53 ** - ** PIZARRO DANA R ** 610-431-798 ** 5604 ** DRYER FIRE\n" +
        "DETAILS TO FOLLOW\n" +
        " ** TXT: FIRE CONTAINED INSIDE THE DRYER IN THE BA\n" +
        "SEMENT, ONLY ENTRANCE IS FROM KITCHEN (COME IN\n" +
        " BAC ** 06/05/12 ** APLNC ** GSHF12001524 **  ** Inc History #GSHF12001524  Xref: #53PJ12002503   \n" +
        "                      \n" +
        " Received     06/05/12  20:51:03  BY CT04     435    \n" +
        " Entered      06/05/12  20:51:22  BY CT04     435    \n" +
        " Dispatched   06/05/12  20:51:30  BY FD17     135    \n" +
        " Enroute      06/05/12  20:56:08                     \n" +
        " Onscene      06/05/12  21:01:40                     \n\n" +
        " Initial Type: APLNC      Final Type: APLNC   (APPLIANCE FIRE *)\n" +
        " Initial Priority: 1      Final Priority: 1 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: 9    Primary Unit: ENG56       Rsp: 0034  \n" +
        " Police BOX: 5303  Fire BOX: 5604  EMS BOX: 5604 \n" +
        " Group: 56FD          Section: 56     Map: 22K13    X: 7554773  Y: 4001513\n\n" +
        " Loc: 1602 IVY LA ,53  btwn N CHESTER RD & DEAD END (V) \n" +
        " AKA:   Municipality: EGOSHN Dev: \n" +
        " Name: PIZARRO DANA R          Addr: 1602 IVY LA ,53         PH: 610-431-7985   \n\n" +
        "/2051  (435   )  ENTRY            DRYER FIRE\n" +
        "/2051            ENTRY            DETAILS TO FOLLOW\n" +
        "/2051  (135   )  DISP    ENG56     #ENG56  ENG56 MDT \n" +
        "/2051            ASST    ENG541    #ENG541 ENG541 MDT \n" +
        "/2052  (435   )  SUPP             TXT: FIRE CONTAINED INSIDE THE DRYER IN THE BA\n" +
        "                                  SEMENT, ONLY ENTRANCE IS FROM KITCHEN (COME IN\n" +
        "                                   BACK DOOR PATIO FOR EASIEST ACCESS). THEY ARE\n" +
        "                                   WAITING OUTSIDE DUE TO THE SMOKE. \n" +
        "/2053            SUPP             NAM: PIZARRO, JAN, \n" +
        "                                  TXT: THEY HAVE FANS ON UPSTAIRS IN HOME AND IT\n" +
        "                                   IS DRAWING THE SMOKE FROM THE BASEMENT... BUT\n" +
        "                                   RP DID SHUT DRYER DOOR BEFORE GOING OUTSIDE. \n" +
        "/2056  (135   )  ENROUT  ENG541   \n" +
        "/2058            ASSTER  LAD56     #LAD56  LAD56 MDT \n" +
        "/2058           *ASSTER  TWR54     #TWR54  TWR54 MDT \n" +
        "/2101            ONSCNE  LAD56    \n" +
        "/2102            ONSCNE  ENG541   \n" +
        "/2106  (TWR54 ) *ONSCNE  TWR54    \n" +
        "/2108  (135   )  MISC             ,UC\n" +
        "/2121            ASST    FM100     #FM100  HOLT, HARRISON \n" +
        "PRIOR PREMISE HISTORY FOR: 1602 IVY LA ,53                                   \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #GSHF12001524 Type: APLNC   Loc: 1602 IVY LA ,53\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "53-074      0      715 INVERNESS DR, 53\n" +
        "               \n" +
        "53-273      0      1603 OLD ORCHARD LA, 53\n" +
        "               \n" +
        "53-025      0      692 INVERNESS DR, 53\n" +
        "               \n" +
        "53-272      0      122 ROSSMORE DR, 53\n" +
        "               \n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** EGOSHN **  ** 56 ** 1 ** N CHESTER RD & DEAD END **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:20:51",
        "CALL:APPLIANCE FIRE",
        "ADDR:1602 IVY LA",
        "MADDR:1602 IVY LN",
        "CITY:EAST GOSHEN TWP",
        "NAME:PIZARRO DANA R",
        "PHONE:610-431-798",
        "BOX:5604",
        "INFO:DRYER FIRE",
        "UNIT:ENG56",
        "X:N CHESTER RD & DEAD END");

    doTest("T13",
        "Subject: HOUSE FIRE *\n" +
        " Dispatch ** 16:29 ** HOUSE FIRE * ** 618 COATES ST ,16 ** - ** JACOBS, TYRELL ** 484-786-881 ** 4138 ** DETAILS TO FOLLOW\n" +
        " ** NAM: JACOBS, TYRELL, \n" +
        "ADR: SAA, \n" +
        "PHO: 484-786-8817, \n" +
        "TXT: FIRE IS IN THE KITCHEN--EVERYONE IS EVA ** 06/06/12 ** HOUSE ** CTVF12000991 **  ** Inc History #CTVF12000991  Xref: #16PJ12008654   \n" +
        "                      \n" +
        " Entered      06/06/12  16:28:48  BY CT03     690    \n" +
        " Dispatched   06/06/12  16:29:07  BY FD16     580    \n" +
        " Enroute      06/06/12  16:30:45                     \n" +
        " Onscene      06/06/12  16:34:43                     \n\n" +
        " Initial Type: HOUSE      Final Type: HOUSE   (HOUSE FIRE *)\n" +
        " Initial Priority: E      Final Priority: E \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: LAD41       Rsp: 0033  \n" +
        " Police BOX: 1606  Fire BOX: 4138  EMS BOX: 4138 \n" +
        " Group: 41FD          Section: 41     Map: 28J4     X: 7581693  Y: 3999314\n\n" +
        " Loc: 618 COATES ST ,16  btwn BLACK HORSE HILL RD & N CHESTER AV (V) \n" +
        " AKA:   Municipality: COATVL Dev: \n" +
        " Name: JACOBS, TYRELL          Addr: SAA                     PH: 484-786-8817   \n\n" +
        "/1628  (690   )  ENTRY            DETAILS TO FOLLOW\n" +
        "/1629  (580   )  DTSEEN           INFO SEEN\n" +
        "/1629            DISP    LAD41     #LAD41  LAD41 MDT \n" +
        "/1629            ASST    RES41     #RES41  RES41 MDT \n" +
        "/1629            ASST    AMB412    #AMB412 AMB412 MDT \n" +
        "/1629            ASST    ENG43     #ENG43  ENG43 MDT \n" +
        "/1629            ASST    ENG38     #ENG38  ENG38 MDT \n" +
        "/1629            ASST    RES38     #RES38  RES38 MDT \n" +
        "/1629            ASST    ENG76     #ENG76  ENG76 MDT \n" +
        "/1630  (690   )  SUPP             NAM: JACOBS, TYRELL, \n" +
        "                                  ADR: SAA, \n" +
        "                                  PHO: 484-786-8817, \n" +
        "                                  TXT: FIRE IS IN THE KITCHEN--EVERYONE IS EVACU\n" +
        "                                  ATED \n" +
        "/1630  (580   ) *ENROUT  ENG76    \n" +
        "/1631  (ENG43 ) *ENROUT  ENG43    \n" +
        "/1631  (523   )  SUPP             TXT: PD OS HEAVY SMOKE SHOWING TRO BUILDING \n" +
        "/1631  (580   )  ASSTER  CHF41     #CHF41  CHF41 MDT \n" +
        "/1632            ASSTER  OFC38    [AST] \n" +
        "/1632           *ENROUT  LAD41    \n" +
        "/1632            WFD              Alarm Level 1\n" +
        "/1633  (107   )  ENROUT  RES41    \n" +
        "/1633            ENROUT  AMB412   \n" +
        "/1633  (523   )  SUPP             TXT: PD REQUESTING COATES STREE CLOSED BY FP A\n" +
        "                                  T BLACKHORSE HILL \n" +
        "/1633  (107   )  DTSEEN           INFO SEEN\n" +
        "/1633            ASSTER  AMB413    #AMB413 AMB413 MDT \n" +
        "/1633            ASSTER  PMD939   \n" +
        "/1633  (AMB412) *MISC    AMB412   ,22035.7\n" +
        "/1633  (580   )  ASST    ENG311    #ENG311 ENG311 MDT \n" +
        "/1633            ASST    LAD49     #LAD49  LAD49 MDT \n" +
        "/1633            ASST    RES45     #RES45  RES45 MDT \n" +
        "/1633            ASST    AIR46     #AIR46  AIR46 MDT \n" +
        "/1633            ASST    TON41    \n" +
        "/1633            ASST    MED932    #MED932 MED932 MDT \n" +
        "/1634  (107   )  ONSCNE  ENG76    \n" +
        "/1634  (580   )  NEWLOC  CHF41    [COATES ST CMND] \n" +
        "/1634            MISC    CHF41    ,HVY SMK, WFD\n" +
        "/1635  (AMB412) *ONSCNE  AMB412   \n" +
        "/1635  (580   )  ASST    ENG371    #ENG371 ENG371 MDT \n" +
        "/1635  (436   )  MISC    CHF41    ,OKAY ON PECO ELECTRIC & GAS - ETA WITHIN THE \n" +
        "                                  HOUR\n" +
        "/1635  (AMB413) *ONSCNE  AMB413   \n" +
        "/1636  (107   )  FM               Alarm Level 1\n" +
        "/1636  (580   )  FM               Alarm Level 1\n" +
        "/1636            DTSEEN           INFO SEEN\n" +
        "/1636            ASST    FM101     #FM101  WEER, JOHN \n" +
        "/1636            ASST    FM102     #FM102  KILMER, RUSS \n" +
        "PRIOR PREMISE HISTORY FOR: 618 COATES ST ,16                                 \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #CTVF12000991 Type: HOUSE   Loc: 618 COATES ST ,16\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "38-099      0      237 GILMER RD, 38\n" +
        "               \n" +
        "38-100      0     HASLAN LA/HESTON RD ,38\n" +
        "               \n" +
        "38-096      0     DAWMAN RD/HULNICK RD ,38\n" +
        "               WEST\n" +
        "38-097      0      432 GILMER RD, 38\n" +
        "               \n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** COATVL **  ** 41 ** E ** BLACK HORSE HILL RD & N C **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:16:29",
        "CALL:HOUSE FIRE",
        "ADDR:618 COATES ST",
        "CITY:COATESVILLE",
        "NAME:JACOBS, TYRELL",
        "PHONE:484-786-881",
        "BOX:4138",
        "UNIT:LAD41",
        "X:BLACK HORSE HILL RD & N CHESTER AV");

    doTest("T14",
        "Subject: TRASH/DUMPSTER FIRE *\n" +
        " Dispatch ** 19:51 ** TRASH/DUMPSTER FIRE * ** 301 N POTTSTOWN PK ,41 ** BETWEEN ABOVE AND BOB EVANS-TG ** KNAUSS, HANNAH/ ** 814-312-185 ** 0605 ** PORT O POTTY ON FIRE--GAS CAN NEXT TO IT\n" +
        "DETAILS TO FOLLOW\n" +
        " ** TXT: TREE ABOUT 2 FEET FROM FLAMES \n" +
        "NAM: KNAUSS, HANNAH/PSBY, \n" +
        "ADR: 1981 COMOUNTAIN RD\n" +
        " ** 06/08/12 ** TRASH ** WWHF12000714 **  ** Inc History #WWHF12000714  Xref: #41PJ12011764   \n" +
        "                      \n" +
        " Entered      06/08/12  19:50:23  BY CT08     712    \n" +
        " Dispatched   06/08/12  19:51:58  BY FD18     107    \n" +
        " Enroute      06/08/12  19:53:26                     \n" +
        " Onscene      06/08/12  19:56:18                     \n\n" +
        " Initial Type: TRASH      Final Type: TRASH   (TRASH/DUMPSTER FIRE *)\n" +
        " Initial Priority: 2      Final Priority: 2 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: FM100       Rsp: 0023  \n" +
        " Police BOX: 4104  Fire BOX: 0605  EMS BOX: 0605 \n" +
        " Group: 06FD          Section: 06     Map:          X: 7563256  Y: 4003514\n\n" +
        " Loc: 301 N POTTSTOWN PK ,41 -- TGI FRIDAYS ,41 btwn E SWEDESFORD RD & APPLE DR (V) \n" +
        " AKA:   Municipality: WWHITE Dev: \n" +
        " Loc Info: BETWEEN ABOVE AND BOB EVANS\n" +
        " Name: KNAUSS, HANNAH/PSBY     Addr: 1981 COMOUNTAIN RD      PH: 814-312-1858   \n\n" +
        "/1950  (712   )  ENTRY            PORT O POTTY ON FIRE--GAS CAN NEXT TO IT\n" +
        "/1950            ENTRY            DETAILS TO FOLLOW\n" +
        "/1951            SUPP             TXT: TREE ABOUT 2 FEET FROM FLAMES \n" +
        "/1951            SUPP             NAM: KNAUSS, HANNAH/PSBY, \n" +
        "                                  ADR: 1981 COMOUNTAIN RD\n" +
        "/1951  (107   )  DISP    ENG061    #ENG061 ENG061 MDT \n" +
        "/1953            ASSTER  CHF06     #CHF06  CHF06 MDT \n" +
        "/1953           *ASSTER  ENG062    #ENG062 ENG062 MDT \n" +
        "/1956            ONSCNE  CHF06    ,PRETTY MUCH GONE\n" +
        "/1956  (ENG062) *ONSCNE  ENG062   \n" +
        "/1957  (107   )  AIQ     ENG061   \n" +
        "/2006  (ENG062) *AOR     ENG062   \n" +
        "/2006  (107   )  AIQ     CHF06    \n" +
        "/2006            CLOSE   CHF06    \n" +
        "/2025            REOPEN           ,NO MORE INFORMATION\n" +
        "/2025            FM               Alarm Level 1\n" +
        "/2030            DTSEEN           INFO SEEN\n" +
        "/2030            DISP    FM100     #FM100  HOLT, HARRISON \n" +
        "                                  ,ADVISED.\n" +
        "PRIOR PREMISE HISTORY FOR: 301 N POTTSTOWN PK ,41                            \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #WWHF12000714 Type: TRASH   Loc: 301 N POTTSTOWN PK ,41\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "41-262      0     APPLE DR/RT 100 ,41\n" +
        "               \n" +
        "41-261      0      260 N POTTSTOWN PK, 41\n" +
        "               \n" +
        "41-264      0      260 N POTTSTOWN PK, 41\n" +
        "               \n" +
        "41-005      0      319 N POTTSTOWN PK, 41\n" +
        "               \n\n" +
        "+++ATE0Q1\n" +
        "ÿ\n" +
        "{\n" +
        " ** WWHITE **  ** 06 ** 2 ** E SWEDESFORD RD & APPLE D **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:19:51",
        "CALL:TRASH/DUMPSTER FIRE",
        "ADDR:301 N POTTSTOWN PK",
        "MADDR:301 N POTTSTOWN PIKE",
        "CITY:WEST WHITELAND TWP",
        "PLACE:BETWEEN ABOVE AND BOB EVANS-TG",
        "NAME:KNAUSS, HANNAH/",
        "PHONE:814-312-185",
        "BOX:0605",
        "INFO:PORT O POTTY ON FIRE--GAS CAN NEXT TO IT",
        "UNIT:FM100",
        "X:E SWEDESFORD RD & APPLE DR");

    doTest("T15",
        "Subject: TRASH/DUMPSTER FIRE *\n" +
        " Dispatch ** 02:36 ** TRASH/DUMPSTER FIRE * ** BLACK HORSE HILL RD/COATES ST ,16    (V) ** - **  **  ** 4138 ** 2 MALES ON S FOURTH SEEN LEAVING SCENE -- LAD4\n" +
        "1 ADV IT'S A DOG ON FIRE. 2 B/M BLK SWEATSHIRT\n" +
        " ON ** TXT: THE ACTORS WERE ON FOOT HEADED SB ON FOUR\n" +
        "TH \n" +
        " ** 06/09/12 ** TRASH ** CTVF12001015 **  ** Inc History #CTVF12001015  Xref: #16PJ12008811   \n" +
        "                      \n" +
        " Entered      06/09/12  02:36:24  BY FD16     528    \n" +
        " Dispatched   06/09/12  02:36:49  BY FD16     528    \n" +
        " Enroute      06/09/12  02:37:17                     \n" +
        " Onscene      06/09/12  02:37:17                     \n\n" +
        " Initial Type: TRASH      Final Type: TRASH   (TRASH/DUMPSTER FIRE *)\n" +
        " Initial Priority: 2      Final Priority: 2 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: LAD41       Rsp: 0023  \n" +
        " Police BOX: 1606  Fire BOX: 4138  EMS BOX: 4138 \n" +
        " Group: 41FD          Section: 41     Map:          X: 7581589  Y: 3998760\n\n" +
        " Loc: BLACK HORSE HILL RD/COATES ST ,16    (V) \n" +
        " AKA:                            Municipality: COATVL Dev:                          \n" +
        " Name:                         Addr:                         PH:                \n\n" +
        "/0236  (528   )  ENTRY            2 MALES ON S FOURTH SEEN LEAVING SCENE -- LAD4\n" +
        "                                  1 ADV IT'S A DOG ON FIRE. 2 B/M BLK SWEATSHIRT\n" +
        "                                   ON ONE\n" +
        "/0236            DTSEEN           INFO SEEN\n" +
        "/0236            DISP    LAD41     #LAD41  LAD41 MDT \n" +
        "/0236            ASST    ENG43     #ENG43  ENG43 MDT \n" +
        "/0237            ONSCNE  LAD41    \n" +
        "/0237            SUPP             TXT: THE ACTORS WERE ON FOOT HEADED SB ON FOUR\n" +
        "                                  TH \n" +
        "/0238            AIQ     ENG43    \n" +
        "/0255            FM               Alarm Level 1\n" +
        "/0255            DTSEEN           INFO SEEN\n" +
        "/0255            ASST    FM101     #FM101  WEER, JOHN \n" +
        "/0255            ASST    FM102     #FM102  KILMER, RUSS \n" +
        "PRIOR PREMISE HISTORY FOR: BLACK HORSE HILL RD/COATES ST ,16                 \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #CTVF12001015 Type: TRASH   Loc: BLACK HORSE HILL RD/COATES ST ,16\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "16-029      0     BLACK HORSE HILL RD/COATES ST ,16\n" +
        "               \n" +
        "16-072      0     CEDAR ST/GRAHAM AV ,16\n" +
        "               \n" +
        "16-071      0     WB POPLAR ST WO GRAHAM AV ,16\n" +
        "               WEST END\n" +
        "16-205      0      538 ELM ST, 16\n" +
        "               \n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " **  **  ** 41 ** 2 **  **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:02:36",
        "CALL:TRASH/DUMPSTER FIRE",
        "ADDR:BLACK HORSE HILL RD & COATES ST",
        "CITY:COATESVILLE",
        "BOX:4138",
        "INFO:2 MALES ON S FOURTH SEEN LEAVING SCENE -- LAD4",
        "UNIT:LAD41");

    doTest("T16",
        "Subject: TRUCK FIRE *\n" +
        " Dispatch ** 19:14 ** TRUCK FIRE * ** 397 WATERWAY RD ,69 ** -TIPTON TRUCKING ** JENNINGS,DAN ** 717-989-494 ** 2103 ** TT ON FIRE - FLAMES COMING ENGINE COMPARTMENT\n" +
        "DETAILS TO FOLLOW\n" +
        " ** NAM: JENNINGS,DAN, \n" +
        "ADR: 94 OAK BOTTLE RD, \n" +
        "TXT: TREES CLOSE BY AND OTHER TRUCKS - SHINGLE\n" +
        "S IN T ** 06/09/12 ** TRUCK ** OXFF12000931 **  ** Inc History #OXFF12000931  Xref: #69PJ12000211   \n" +
        "                      \n" +
        " Entered      06/09/12  19:14:37  BY CT05     684    \n" +
        " Dispatched   06/09/12  19:14:46  BY FD16     533    \n" +
        " Enroute      06/09/12  19:19:12                     \n" +
        " Onscene      06/09/12  19:22:51                     \n\n" +
        " Initial Type: TRUCK      Final Type: TRUCK   (TRUCK FIRE *)\n" +
        " Initial Priority: 2      Final Priority: 2 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: ENG211      Rsp: 0019  \n" +
        " Police BOX: 6901  Fire BOX: 2103  EMS BOX: 2103 \n" +
        " Group: 21FD          Section: 21     Map:          X: 7598409  Y: 3976854\n\n" +
        " Loc: 397 WATERWAY RD ,69 -- TIPTON TRUCKING ,69 btwn BALTIMORE PK & MOUNT PLEASANT RD (V) \n" +
        " AKA:   Municipality: ENOTT  Dev: \n" +
        " Name: JENNINGS,DAN            Addr: 94 OAK BOTTLE RD        PH: 717-989-4949-C \n\n" +
        "/1914  (684   )  ENTRY            TT ON FIRE - FLAMES COMING ENGINE COMPARTMENT\n" +
        "/1914            ENTRY            DETAILS TO FOLLOW\n" +
        "/1914  (533   )  DISP    ENG211    #ENG211 ENG211 MDT \n" +
        "/1915  (684   )  SUPP             NAM: JENNINGS,DAN, \n" +
        "                                  ADR: 94 OAK BOTTLE RD, \n" +
        "                                  TXT: TREES CLOSE BY AND OTHER TRUCKS - SHINGLE\n" +
        "                                  S IN THE TRAILER \n" +
        "/1915            SUPP             TXT: ANOTHER TRUCK CATCHING ON FIRE \n" +
        "/1919  (533   )  ASSTER  ENG212    #ENG212 ENG212 MDT \n" +
        "/1920           *ASSTER  TKR21    \n" +
        "/1920  (ENG211) *ENROUT  ENG211   \n" +
        "/1920  (533   )  ASSTER  AMB213    #AMB213 AMB213 MDT \n" +
        "/1920  (AMB213) *MISC    AMB213   ,364\n" +
        "/1922  (533   )  ONSCNE  ENG212   ,LAID IN, 3 TRACTORS INVOLVED\n" +
        "/1923            MISC    ENG211   ,PICKING UP LINE\n" +
        "/1924  (AMB213) *ONSCNE  AMB213   \n" +
        "/1927  (533   )  MISC    ENG212   ,3 LINES IN SERV,WATER SUPPLY ESTABLISHED\n" +
        "/1927            NEWLOC  ENG212   [CAPT = WATERWAY CMND] \n" +
        "/1927            ONSCNE  ENG211   ,?\n" +
        "/1927            ONSCNE  TKR21    ,?\n" +
        "/1934            MISC    ENG212   ,FUC\n" +
        "/1934           *ASSTER  RES21    \n" +
        "/1940           *ONSCNE  RES21    \n" +
        "/1948            FM               Alarm Level 1\n" +
        "/1948            DTSEEN           INFO SEEN\n" +
        "/1948            ASST    FM102     #FM102  KILMER, RUSS \n" +
        "/1948            ASST    FM101     #FM101  WEER, JOHN \n" +
        "PRIOR PREMISE HISTORY FOR: 397 WATERWAY RD ,69                               \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " ** ENOTT **  ** 21 ** 2 ** BALTIMORE PK & MOUNT PLEA **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:19:14",
        "CALL:TRUCK FIRE",
        "ADDR:397 WATERWAY RD",
        "CITY:EAST NOTTINGHAM TWP",
        "PLACE:-TIPTON TRUCKING",
        "NAME:JENNINGS,DAN",
        "PHONE:717-989-494",
        "BOX:2103",
        "INFO:TT ON FIRE - FLAMES COMING ENGINE COMPARTMENT",
        "UNIT:ENG211",
        "X:BALTIMORE PK & MOUNT PLEASANT RD");

    doTest("T17",
        "Subject: TRASH/DUMPSTER FIRE *\n" +
        " Dispatch ** 17:20 ** TRASH/DUMPSTER FIRE * ** DAYTON ST/RAILROAD ST ,15    (V) ** IAO TRAIN TRACKS- ** FORD- BEY, TAHM ** 484-636-851 ** 6501 ** RP SAW FLAMES FROM WOOD PILE\n" +
        "DETAILS TO FOLLOW\n" +
        " ** NAM: FORD- BEY, TAHMIYA, \n" +
        "ADR: 117 RAILROAD ST, 15, \n" +
        "TXT: RP IS NO LONGER ON SCENE -- NFI \n" +
        " ** 06/10/12 ** TRASH ** PHXF12000826 **  ** Inc History #PHXF12000826  Xref: #15PJ12006242   \n" +
        "                      \n" +
        " Entered      06/10/12  17:20:31  BY CT09     693    \n" +
        " Dispatched   06/10/12  17:20:48  BY FD18     483    \n" +
        " Enroute      06/10/12  17:22:09                     \n" +
        " Onscene      06/10/12  17:24:57                     \n\n" +
        " Initial Type: TRASH      Final Type: TRASH   (TRASH/DUMPSTER FIRE *)\n" +
        " Initial Priority: 2      Final Priority: 2 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: ENG651      Rsp: 0023  \n" +
        " Police BOX: 1501  Fire BOX: 6501  EMS BOX: 6501 \n" +
        " Group: 65FD          Section: 65     Map:          X: 7551292  Y: 4013817\n\n" +
        " Loc: DAYTON ST/RAILROAD ST ,15    (V) \n" +
        " AKA:                            Municipality: PHNXVL Dev:                          \n" +
        " Loc Info: IAO TRAIN TRACKS\n" +
        " Name: FORD- BEY, TAHMIYA      Addr: 117 RAILROAD ST, 15     PH: 484-636-8515C  \n\n" +
        "/1720  (693   )  ENTRY            RP SAW FLAMES FROM WOOD PILE\n" +
        "/1720            ENTRY            DETAILS TO FOLLOW\n" +
        "/1720  (483   )  DISP    ENG651    #ENG651 ENG651 MDT \n" +
        "/1721  (693   )  SUPP             NAM: FORD- BEY, TAHMIYA, \n" +
        "                                  ADR: 117 RAILROAD ST, 15, \n" +
        "                                  TXT: RP IS NO LONGER ON SCENE -- NFI \n" +
        "/1722  (ENG651) *ENROUT  ENG651   \n" +
        "/1724           *ONSCNE  ENG651   \n" +
        "/1728  (483   )  ASST    FM100     #FM100  HOLT, HARRISON \n" +
        "PRIOR PREMISE HISTORY FOR: DAYTON ST/RAILROAD ST ,15                         \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #PHXF12000826 Type: TRASH   Loc: DAYTON ST/RAILROAD ST ,15\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "15-034      0     DAYTON ST/RAILROAD ST ,15\n" +
        "               \n" +
        "15-074      0     DAYTON ST/E HIGH ST ,15\n" +
        "               \n" +
        "15-035      0      2 RAILROAD ST, 15\n" +
        "               \n" +
        "15-075      0      21 E HIGH ST, 15\n" +
        "               \n\n" +
        "+++ATE0Q1\n\n" +
        "{\n" +
        " **  **  ** 65 ** 2 **  **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:17:20",
        "CALL:TRASH/DUMPSTER FIRE",
        "ADDR:DAYTON ST & RAILROAD ST",
        "CITY:PHOENIXVILLE",
        "PLACE:IAO TRAIN TRACKS",
        "NAME:FORD- BEY, TAHM",
        "PHONE:484-636-851",
        "BOX:6501",
        "INFO:RP SAW FLAMES FROM WOOD PILE",
        "UNIT:ENG651");

    doTest("T18",
        "Subject: ELECTRICAL FIRE INSIDE *\n" +
        " Dispatch ** 13:51 ** ELECTRICAL FIRE INSIDE * ** 1151 LAURA LA ,52 ** - ** PLIMMICK, COURT ** 610-430-684 ** 5102 ** HOUSE ON FIRE\n" +
        "DETAILS TO FOLLOW\n" +
        " ** TXT: CABLE LINE BEHIND THE TV IN THE WALLS \n" +
        "NAM: PLIMMICK, COURTNEY, \n" +
        "ADR: SAA, \n" +
        "PHO: 610-430-684 ** 06/11/12 ** ELECIN ** WCHF12002024 **  ** Inc History #WCHF12002024  Xref: #52PJ12009781   \n" +
        "                      \n" +
        " Entered      06/11/12  13:51:11  BY CT06     708    \n" +
        " Dispatched   06/11/12  13:51:39  BY FD17     135    \n" +
        " Enroute      06/11/12  13:52:53                     \n" +
        " Onscene      06/11/12  14:00:48                     \n\n" +
        " Initial Type: ELECIN     Final Type: ELECIN  (ELECTRICAL FIRE INSIDE *)\n" +
        " Initial Priority: 1      Final Priority: 1 \n" +
        " Initial Alarm Level: 1   Final Alarm Level: 1\n" +
        " Disposition:        Source: T    Primary Unit: ENG511      Rsp: 0036  \n" +
        " Police BOX: 5201  Fire BOX: 5102  EMS BOX: 5102 \n" +
        " Group: 51FD          Section: 51     Map: 31H5     X: 7562710  Y: 3998799\n\n" +
        " Loc: 1151 LAURA LA ,52  btwn DEAD END & SUNSET HOLLOW RD (V) \n" +
        " AKA:   Municipality: WGOSHN Dev: \n" +
        " Name: PLIMMICK, COURTNEY      Addr: SAA                     PH: 610-430-6845   \n\n" +
        "/1351  (708   )  ENTRY            HOUSE ON FIRE\n" +
        "/1351            ENTRY            DETAILS TO FOLLOW\n" +
        "/1351            SUPP             TXT: CABLE LINE BEHIND THE TV IN THE WALLS \n" +
        "/1351  (135   )  DISP    ENG511    #ENG511 ENG511 MDT \n" +
        "/1351            ASST    ENG512    #ENG512 ENG512 MDT \n" +
        "/1351            ASST    ENG53     #ENG53  ENG53 MDT \n" +
        "/1351            ASST    LAD53    \n" +
        "/1351            ASST    AMB551    #AMB551 AMB551 MDT \n" +
        "/1351  (708   )  SUPP             NAM: PLIMMICK, COURTNEY, \n" +
        "                                  ADR: SAA, \n" +
        "                                  PHO: 610-430-6845, \n" +
        "                                  TXT: RP EVACUATING \n" +
        "/1352  (135   ) *ASSTER  AMB552    #AMB552 AMB552 MDT \n" +
        "/1353            CLEAR   AMB551   \n" +
        "/1355           *ENROUT  LAD53    \n" +
        "/1356            ENROUT  ENG511   \n" +
        "/1358            ENROUT  ENG53    \n" +
        "/1400  (OFC55A) *ASSTOS  EMS5520   #OFC55A EMS5520 MDT \n" +
        "/1401  (135   )  ASSTER  RES53     #RES53  RES53 MDT \n" +
        "/1402  (AMB552) *ONSCNE  AMB552   \n" +
        "/1402  (135   ) *ONSCNE  LAD53    \n" +
        "/1402            ASSTER  TRF52    \n" +
        "/1403  (ENG511) *ONSCNE  ENG511   \n" +
        "/1403  (135   )  MISC    LAD53    ,2 STORY SFD, SMK FROM THE FRONT\n" +
        "/1406            ONSCNE  ENG53    \n" +
        "/1406            NEWLOC  LAD53    [CP] \n" +
        "/1407           *ONSCNE  RES53    \n" +
        "/1408            ONSCNE  TRF52    \n" +
        "/1408            ASSTOS  OFC53    [CAPT 53 CMD] \n" +
        "/1409            ASSTOS  FM52     \n" +
        "/1411            MISC             ,UC\n" +
        "/1412            FM               Alarm Level 1\n" +
        "/1412            DTSEEN           INFO SEEN\n" +
        "/1412            ASST    FM100     #FM100  HOLT, HARRISON \n" +
        "/1412            ASST    FM103     #FM103  HOLMES, MIKE \n" +
        "PRIOR PREMISE HISTORY FOR: 1151 LAURA LA ,52                                 \n\n" +
        "No Prior Premise History found for the Location\n\n" +
        "*** List of closest hydrants ***                                                \n" +
        " Inc #WCHF12002024 Type: ELECIN  Loc: 1151 LAURA LA ,52\n" +
        " ID   STAT  GPM   LOCATION \n\n" +
        "52-293      0     CAROLINA AV/PENNSYLVANIA AV ,52\n" +
        "               \n" +
        "52-080      0      205 NETHERFIELD LA, 52\n" +
        "               \n" +
        "52-290      0      217 PENNSYLVANIA AV, 52\n" +
        "               \n" +
        "52-445      0     GROVE RD/NETHERFIELD LA ,52\n" +
        "               \n\n" +
        "+++\n" +
        "RING\n" +
        "ATE0Q1\n\n" +
        "{\n" +
        " ** WGOSHN **  ** 51 ** 1 ** DEAD END & SUNSET HOLLOW **\n" +
        " \n" +
        " \n" +
        "This County of Chester e-mail message, including any attachments, is intended for the sole use of the individual(s) and entity(ies) to whom it is addressed, and may contain information that is privileged, confidential and exempt from disclosure under applicable law. If you are not the intended addressee, nor authorized to receive for the intended addressee, you are hereby notified that you may not use, copy, disclose or distribute to anyone this e-mail message including any attachments, or any information contained in this e-mail message including any attachments. If you have received this e-mail message in error, please immediately notify the sender by reply e-mail and delete the message. Thank you very much.",

        "TIME:13:51",
        "CALL:ELECTRICAL FIRE INSIDE",
        "ADDR:1151 LAURA LA",
        "MADDR:1151 LAURA LN",
        "CITY:WEST GOSHEN TWP",
        "NAME:PLIMMICK, COURT",
        "PHONE:610-430-684",
        "BOX:5102",
        "INFO:HOUSE ON FIRE",
        "UNIT:ENG511",
        "X:DEAD END & SUNSET HOLLOW RD");
  }
  
  @Test
  public void testOthers() {

    doTest("T1",
        "Dispatch ** 18:00 ** ALARM - FIRE * ** 2316 CONESTOGA RD ,25 ** RITCHIE RES/610-827-9328- ** ADT/GQQ ** 877-238-7730 ** Inc",
        "TIME:18:00",
        "CALL:ALARM - FIRE",
        "ADDR:2316 CONESTOGA RD",
        "CITY:WEST VINCENT TWP",
        "PLACE:RITCHIE RES/610-827-9328",
        "NAME:ADT/GQQ",
        "PHONE:877-238-7730",
        "BOX:Inc");

  }
  
  public static void main(String[] args) {
    new PAChesterCountyD4ParserTest().generateTests("T1");
  }
}
