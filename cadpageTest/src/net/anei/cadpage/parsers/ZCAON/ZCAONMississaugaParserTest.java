package net.anei.cadpage.parsers.ZCAON;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Mississauga, ON
Contact: Active911
Agency name: Respond Search and Rescue Location: Mississauga, ON 
Sender: pager@rsar.ca
  51-PI ACCIDENT/\n CONFEDERATION PY-MG/RATHBURN RD W-MG  \nMap:294      Tac:3 \n P101 S101         \nX1:0 RATHBURN RD W \nX2:0 SQUARE ONE DR \nInc#1232800 19:57:17 
 30-CAR FIRE ON \n 403EB E OF EASTGATE TO EGLINTON       \nMap:         Tac:3 \n P101 A101         \nX1:E OF EASTGATE PY\nX2:W OF EGLINTON AV\nInc#1232801 20:10:55 
 92-OTHER ASSIST\n 89 WALKER DR-BR                       \nMap:118D     Tac:7 \n P202              \nX1:2 WOODSLEA RD   \nX2:2 SUMMERLEA RD &\n        Inc:#1232802 
 24-DIFF BRTH/CH\n 820 SCOLLARD CT-MG                    \nMap:377      Tac:3 \n S101              \nX1:5055 HEATHERLEIG\nX2:                \nInc#1232803 20:31:50 
 24-DIFF BRTH/CH\n 4 JULIAN DR-BR                        \nMap:144D     Tac:7 \n A213              \nX1:4400 CASTLEMORE \nX2:2 FITZPATRICK DR\n        Inc:#1232804 
 47-SENIOR FACIL\n 1376 CREDIT WOODLANDS CT-MG           \nMap:172      Tac:2 \n S107 P112 A107 S11\nX1:1322 WILTSHIRE L\nX2:                \nInc#1232805 20:42:28 
 51-PI ACCIDENT/\n FINCH AV-BR/STEELES AV E-BR           \nMap:139E     Tac:7 \n A213 S203         \nX1:3998 STEELES AV \nX2:54 KENVIEW BV   \n        Inc:#1232806 
 24-DIFF BRTH/CH\n 88 CLARRIDGE CT-BR                    \nMap:55B      Tac:7 \n A207              \nX1:46 ECCLESTONE DR\nX2:                \n        Inc:#1232807 
 22-CHEST PAINS/\n 2231 HENSALL ST-MG                    \nMap:144      Tac:3 \n P110              \nX1:464 VALLEYFIELD \nX2:464 ABINGTON AV \nInc#1232808 21:18:47 
 24-DIFF BRTH/CH\n 11 LISA ST-BR                         \nMap:87B      Tac:7 \n P201              \nX1:2 SILVER MAPLE C\nX2:8800 DIXIE RD   \n        Inc:#1232809 
 22-CHEST PAINS/\n 7625 FINCH AV-BR                      \nMap:150B     Tac:7 \n A213              \nX1:54 KENVIEW BV   \nX2:                \n        Inc:#1232810 
 22-CHEST PAINS/\n 15 TUMBLEWEED TL-BR                   \nMap:50C      Tac:7 \n P206              \nX1:2 CRIMSON CT    \nX2:2 MOONSTONE CT  \n        Inc:#1232811 
 24-DIFF BRTH/CH\n CHARLESTON SR-CA/HEART LAKE RD-CA     \nMap:         Tac:8 \n S309              \nX1:18452 HEART LAKE\nX2:18442 HORSESHOE \n        Inc:#1232812 
 48-False/Restor\n 1295 WILLIAMS PY-BR                   \nMap:95B      Tac:7 \n S203              \nX1:9400 BRAMALEA RD\nX2:2 MACKAY ST S   \n        Inc:#1232813 
 51-PI ACCIDENT/\n 403EB N OF DUNDAS TO WCB              \nMap:         Tac:3 \n A107 S107 BYL1    \nX1:N OF DUNDAS ST  \nX2:W OF WCB        \nInc#1232814 22:54:54 
 51-PI ACCIDENT/\n 401EB COLL FROM DIXIE RD TO RENFORTH  \nMap:         Tac:3 \n P109 S114 BYL1    \nX1:E OF DIXIE RD   \nX2:W OF RENFORTH DR\nInc#1232815 22:58:09 
 24-DIFF BRTH/CH\n 13 PARK ESTATES CT-BR                 \nMap:54D      Tac:7 \n A207              \nX1:240 MURRAY ST & \nX2:                \n        Inc:#1232816 
 22-CHEST PAINS/\n 171 MAIN ST N-BR                      \nMap:66C      Tac:7 \n A207              \nX1:2 ALEXANDER ST  \nX2:2 CHURCH ST W & \n        Inc:#1232817 
 22-CHEST PAINS/\n 12419 KENNEDY RD-CA                   \nMap:         Tac:8 \n S307              \nX1:2 BENADIR AV    \nX2:2 LOSINO ST     \n        Inc:#1232818 
 24-DIFF BRTH/CH\n 1061 SENECA AV-MG                     \nMap:73       Tac:3 \n P102              \nX1:68 FOREST AV    \nX2:16 IROQUOIS AV  \nInc#1232819 00:20:47 
 55-ELEVATOR STA\n 100 JOHN ST-BR                        \nMap:67B      Tac:7 \n A207              \nX1:10 JAMES ST     \nX2:                \n        Inc:#1232820 
 43-RESIDENTIAL \n 2330 CARLANNE PL-MG                   \nMap:162      Tac:2 \n P110 A110         \nX1:688 FIELDSTONE R\nX2:2318 CARLANNE CT\nInc#1232821 01:02:51 
 24-DIFF BRTH/CH\n 2367 MARISA CT-MG                     \nMap:171      Tac:3 \n S107              \nX1:2428 HAMMOND RD \nX2:                \nInc#1232822 01:03:25 
 51-PI ACCIDENT/\n BOVAIRD DR W-BR/WORTHINGTON AV-BR     \nMap:34C      Tac:7 \n A210 S205         \nX1:2 WORTHINGTON AV\nX2:2 BRISDALE DR & \n        Inc:#1232823 
 20-CHILD MEDICA\n 1828 HINDHEAD RD-MG                   \nMap:103      Tac:3 \n P103              \nX1:1240 APRIL DR   \nX2:1036 WELWYN DR  \nInc#1232824 01:27:29 
 24-DIFF BRTH/CH\n 20 CEDARVALLEY BV-BR                  \nMap:52C      Tac:7 \n P205              \nX1:152 WINNERS CL  \nX2:220 VAN KIRK DR \n        Inc:#1232825 
 22-CHEST PAINS/\n 3 UNIONVILLE CR-BR                    \nMap:147B     Tac:7 \n A213              \nX1:OSGOODE DR      \nX2:0 ROYSTON ST    \n        Inc:#1232826 
 41-ALARM BELLS \n 3355 PONYTRAIL DR-MG                  \nMap:191      Tac:2 \n S106 A106         \nX1:3450 FIELDGATE D\nX2:3480 BRIDGEWOOD \nInc#1232827 02:14:51 
 24-DIFF BRTH/CH\n 5695 WHITEHORN AV-MG                  \nMap:381      Tac:3 \n P118              \nX1:1390 PICKWICK DR\nX2:0 TORRINGTON DR \nInc#1232828 02:23:01 
 20-CHILD MEDICA\n 35 BRUCE BEER DR-BR                   \nMap:75C      Tac:7 \n P201              \nX1:92 IVYBRIDGE DR \nX2:IVYBRIDGE DR    \n        Inc:#1232829 
 22-CHEST PAINS/\n HURONTARIO ST-MG/LAKESHORE RD E-MG    \nMap:84       Tac:3 \n P104              \nX1:138 LAKESHORE RD\nX2:90 HIGH ST E    \nInc#1232830 03:07:06 
*LOCATION CHANGE*\n 30 QUEEN ST E-MG                       X1:28 HELENE ST N   X2:28 ELIZABETH ST NMap:84       Tac:3   22-CHEST PAINS/HEARInc:#1232830         
 22-CHEST PAINS/\n 12 BANKS DR-BR                        \nMap:122A     Tac:7 \n P209              \nX1:14 WHITWELL DR  \nX2:2 MALTBY CT & TR\n        Inc:#1232831 
 45-COMMRCIAL/IN\n 5800 KEATON CR-MG                     \nMap:371      Tac:2 \n P114 S114         \nX1:5860 CHEDWORTH W\nX2:240 MATHESON BV \nInc#1232832 03:16:59 
 24-DIFF BRTH/CH\n 50 CORONATION CL-BR                   \nMap:63C      Tac:7 \n P205              \nX1:2 WHITMEN GT    \nX2:86 SUNFOREST DR \n        Inc:#1232833 
 27-VITAL SIGNS \n DIXIE RD-MG/LAKESHORE RD E-MG         \nMap:64       Tac:3 \n P102              \nX1:1381 LAKESHORE R\nX2:1345 ST JAMES AV\nInc#1232834 03:20:45 
*LOCATION CHANGE*\n 1417 LAKESHORE RD E-MG                 X1:0 DETA RD        X2:1022 CHERRIEBELL Map:53       Tac:3   27-VITAL SIGNS ABSEInc:#1232834         
 24-DIFF BRTH/CH\n 3356 QUEEN FREDERICA DR-MG            \nMap:202      Tac:3 \n S106              \nX1:1160 BLOOR ST   \nX2:1198 SYLVANIA DR\nInc#1232835 03:38:09 
 52-MULTI/MAJOR/\n 401WB COLL FROM RENFORTH TO DIXIE RD  \nMap:         Tac:3 \n P119 A105 S105 BYL\nX1:W OF RENFORTH DR\nX2:E OF DIXIE RD   \nInc#1232836 03:38:53 
 43-RESIDENTIAL \n 36 BOBCAT ST-BR                       \nMap:93C      Tac:7 \n A208 P209 C207    \nX1:2 AMAZON CT & HI\nX2:2 FOXTAIL RD & H\n        Inc:#1232837 
 40-OPEN ACCESS \n 88 BRONTE COLLEGE CT-MG               \nMap:154      Tac:2 \n P110 A110         \nX1:2194 HURONTARIO \nX2:                \nInc#1232838 04:37:02 
 92-OTHER ASSIST\n CONESTOGA DR-BR/SANDALWOOD PY E-BR    \nMap:63B      Tac:7 \n P205              \nX1:150 SANDALWOOD P\nX2:2 STEVEN CT     \n        Inc:#1232839 
 24-DIFF BRTH/CH\n 7130 TERRAGAR BV-MG                   \nMap:554      Tac:3 \n S111              \nX1:3286 SCOTCH PINE\nX2:3310 SMOKE TREE \nInc#1232840 05:43:00 
 27-VITAL SIGNS \n 2420 SURVEYOR RD-MG                   \nMap:463B     Tac:3 \n P108              \nX1:6460 MILLCREEK D\nX2:                \nInc#1232841 06:31:37 
*LOCATION CHANGE*\n 2420 SURVEYOR RD-MG                    X1:6460 MILLCREEK DRX2:                 Map:463B     Tac:3   27-VITAL SIGNS ABSEInc:#1232841         
 20-CHILD MEDICA\n 25 RAMBLER DR-BR                      \nMap:69B      Tac:7 \n P206              \nX1:112 TOWN HOUSE C\nX2:348 BARTLEY BULL\n        Inc:#1232842 
 24-DIFF BRTH/CH\n 2020 BARSUDA DR-MG                    \nMap:103      Tac:3 \n P103              \nX1:1994 AMBRIDGE CT\nX2:1992 TRUSCOTT DR\nInc#1232843 06:52:35 
 OR-OR OUT OF SE\n 2267 BRITANNIA RD W-MG                \nMap:463B     Tac:1 \n P108              \nX1:5999 TURNEY DR  \nX2:4 THEODORE DR   \nInc#1232844 07:14:40 
 51-PI ACCIDENT/\n 410NB N OF WILLIAMS PY TO BOVAIRD DR  \nMap:         Tac:7 \n P201 S201         \nX1:N OF WILLIAMS PY\nX2:S OF BOVAIRD BV \n        Inc:#1232845 
 96-CO DETECTOR \n 5625 GLEN ERIN DR-MG                  \nMap:395      Tac:3 \n P122              \nX1:0 THOMAS ST     \nX2:2786 CASTLEBRIDG\nInc#1232846 07:50:18 
 51-PI ACCIDENT/\n SOUTHLAKE BV-BR/BOVAIRD DR E-BR       \nMap:74D      Tac:7 \n A208 S205         \nX1:898 BOVAIRD DR E\nX2:2 SEA LION RD   \n        Inc:#1232847 
 OR-OR OUT OF SE\n 15 FAIRVIEW RD W-MG                   \nMap:222      Tac:1 \n A101              \nX1:2 HANSON RD     \nX2:0 HURONTARIO ST \nInc#1232848 08:00:15 
 45-COMMRCIAL/IN\n 1285 EGLINTON AV E-MG                 \nMap:272      Tac:2 \n P117 S106         \nX1:4626 BURGOYNE ST\nX2:4900 DIXIE RD   \nInc#1232849 08:03:13 
 51-PI ACCIDENT/\n HWY 9 HY-CA/MOUNT PLEASANT RD-CA      \nMap:         Tac:8 \n P306 S306 T306 S31\nX1:17610 MOUNT PLEA\nX2:17298 MOUNT WOLF\n        Inc:#1232850 
 51-PI ACCIDENT/\n BOVAIRD DR W-BR/MCLAUGHLIN RD-BR      \nMap:54A      Tac:7 \n A208 S205         \nX1:9998 MCLAUGHLIN \nX2:2 VAN KIRK DR & \n        Inc:#1232851 
 OR-OR OUT OF SE\n 2316 HURONTARIO ST-MG                 \nMap:152      Tac:1 \n A110              \nX1:21 QUEENSWAY W &\nX2:88 BRONTE COLLEG\nInc#1232852 08:08:27 
 51-PI ACCIDENT/\n HWY 9 HY-CA/MOUNT PLEASANT RD-CA      \nMap:         Tac:8 \n P306 S306 T306 S31\nX1:17610 MOUNT PLEA\nX2:17298 MOUNT WOLF\n        Inc:#1232850 
 24-DIFF BRTH/CH\n 5000 MAYFIELD RD-CA                   \nMap:         Tac:8 \n S307              \nX1:BRAMALEA RD     \nX2:TORBRAM RD      \n        Inc:#1232853 
 76-NATURAL GAS \n 1428 LARCHVIEW TL-MG                  \nMap:51       Tac:3 \n S106 P102 A106 S10\nX1:1429 DIXIE RD   \nX2:1416 LONDONDERRY\nInc#1232854 08:23:45 
 51-PI ACCIDENT/\n BURT DR-BR/CHINGUACOUSY RD-BR         \nMap:46C      Tac:7 \n P204 S206         \nX1:9198 CHINGUACOUS\nX2:2 CORKETT DR    \n        Inc:#1232855 
 51-PI ACCIDENT/\n AIRPORT RD-MG/MORNING STAR DR-MG      \nMap:483      Tac:4 \n A105 S105         \nX1:3001 MORNING STA\nX2:6 BEVERLEY ST & \nInc#1232856 08:32:32 
 OR-OR OUT OF SE\n 1735 BRITANNIA RD E-MG                \nMap:423      Tac:1 \n T101              \nX1:5970 ATLANTIC DR\nX2:6045 NETHERHART \nInc#1232857 08:35:03 
P116 TO REPLACE UNIT A105\nIN STATION 105\n7101 GOREWAY DR\n2012/09/12  03:42:03 
S105 TO REPLACE UNIT P119\nIN STATION 119\n3201 ELMBANK DR\n2012/09/12  03:57:24 
A202 TO REPLACE UNIT A213\nIN STATION 213\n4075 EBENEZER RD\n2012/09/12  02:19:02 
P205 TO REPLACE UNIT A207\nIN STATION 207\n75 VODDEN ST E\n2012/09/12  01:03:00 
S114 TO REPLACE UNIT P109\nIN STATION 109\n1735 BRITANNIA RD E\n2012/09/11  23:09:50 
P110 TO REPLACE UNIT P101\nIN STATION 101\n15 FAIRVIEW RD W\n2012/09/11  20:33:16 
P115 TO REPLACE UNIT P108\nIN STATION 108\n2267 BRITANNIA RD W\n2012/09/12  06:39:16 
A111 TO REPLACE UNIT P108\nIN STATION 108\n2267 BRITANNIA RD W\n2012/09/12  07:14:07 
A202 TO REPLACE UNIT P201\nIN STATION 201\n8 RUTHERFORD RD S\n2012/09/12  07:26:00 
P116 TO REPLACE UNIT A105\nIN STATION 105\n7101 GOREWAY DR\n2012/09/12  08:33:25 
P117 TO REPLACE UNIT A106\nIN STATION 106\n3450 DIXIE RD\n2012/09/12  08:36:22 
P114 TO REPLACE UNIT P117\nIN STATION 117\n1090 NUVIK CT\n2012/09/12  08:36:44 
P206 TO REPLACE UNIT P204\nIN STATION 204\n675 QUEEN ST W\n2012/09/12  08:39:58 
A210 TO REPLACE UNIT P205\nIN STATION 205\n95 SANDALWOOD PY E\n2012/09/12  09:19:54 
S106 TO REPLACE UNIT P117\nIN STATION 117\n1090 NUVIK CT\n2012/09/12  10:59:27 
P206 TO REPLACE UNIT P212\nIN STATION 212\n8220 MISSISSAUGA RD\n2012/09/12  11:33:47 
A107 TO REPLACE UNIT P103\nIN STATION 103\n2035 LUSHES AV\n2012/09/12  12:25:12 
P101 TO REPLACE UNIT P110\nIN STATION 110\n2316 HURONTARIO ST\n2012/09/12  12:25:12 
P115 TO REPLACE UNIT A107\nIN STATION 107\n1965 DUNDAS ST W\n2012/09/12  12:25:12 
P110 TO REPLACE UNIT P104\nIN STATION 104\n62 PORT ST\n2012/09/12  12:25:12 
 51-PI ACCIDENT/\n DIXIE RD-BR/STEELES AV E-BR           \nMap:89D      Tac:7 \n P202 S206         \nX1:1500 STEELES AV \nX2:208 ADVANCE BV  \n        Inc:#1232858 
 45-COMMRCIAL/IN\n 6420 SILVER DART DR-MG                \nMap:414      Tac:2 \n P119 P109         \nX1:3090 AMERICAN DR\nX2:                \nInc#1232859 08:43:47 
 51-PI ACCIDENT/\n HIGHWOOD RD-BR/HURONTARIO ST-BR       \nMap:61A      Tac:7 \n P205 S205         \nX1:12188 HURONTARIO\nX2:100 HILLPATH CR \n        Inc:#1232860 
 47-SENIOR FACIL\n 1376 CREDIT WOODLANDS CT-MG           \nMap:172      Tac:2 \n S107 P112 A107 S10\nX1:1322 WILTSHIRE L\nX2:                \nInc#1232861 09:12:19 
 48-False/Restor\n 85 KING ST E-MG                       \nMap:141      Tac:2 \n P110              \nX1:2560 SHEPARD AV \nX2:2513 CATHERINE J\nInc#1232862 09:21:00 
 96-CO DETECTOR \n 70 PIANE AV-BR                        \nMap:47A      Tac:7 \n P204              \nX1:214 DRINKWATER R\nX2:0 VENTURA AV    \n        Inc:#1232863 
 41-ALARM BELLS \n 310 BURNHAMTHORPE RD W-MG             \nMap:294      Tac:2 \n P101 S101         \nX1:3888 DUKE OF YOR\nX2:0 LIVING ARTS DR\nInc#1232864 09:31:30 
 45-COMMRCIAL/IN\n 5830 COOPERS AV-MG                    \nMap:361      Tac:2 \n P114 S114         \nX1:450 BRITANNIA RD\nX2:5730 ROSE CHERRY\nInc#1232865 09:45:37 
 22-CHEST PAINS/\n 1450 MEYERSIDE DR-MG                  \nMap:428      Tac:3 \n P109              \nX1:6240 DIXIE RD   \nX2:6300 ORDAN DR   \nInc#1232866 09:47:34 
 45-COMMRCIAL/IN\n 3160 DERRY RD E-MG                    \nMap:406      Tac:2 \n S105 A105         \nX1:6894 PROFESSIONA\nX2:0 HULL ST       \nInc#1232867 09:56:16 
 24-DIFF BRTH/CH\n 6 BRANT AV-MG                         \nMap:73       Tac:3 \n P102              \nX1:260 LAKESHORE RD\nX2:0 FOREST AV     \nInc#1232868 09:57:26 
 24-DIFF BRTH/CH\n 1055 SOUTHDOWN RD-MG                  \nMap:114      Tac:3 \n P103              \nX1:LAKESHORE RD W &\nX2:2070 BROMSGROVE \nInc#1232869 10:23:04 
 24-DIFF BRTH/CH\n 49 LONGBOURNE CR-BR                   \nMap:86C      Tac:7 \n S201              \nX1:LAURELCREST ST  \nX2:34 LAURELCREST S\n        Inc:#1232870 
 24-DIFF BRTH/CH\n 25 CORPORATION DR-BR                  \nMap:116C     Tac:7 \n S203              \nX1:9300 TORBRAM RD \nX2:2 BRAMKAY ST & P\n        Inc:#1232871 
 24-DIFF BRTH/CH\n 1389 CAWTHRA RD-MG                    \nMap:72       Tac:3 \n P102              \nX1:0 ARBOR CT & ARB\nX2:0 CAWTHRA CT & S\nInc#1232872 10:36:14 
 OR-OR OUT OF SE\n 15 FAIRVIEW RD W-MG                   \nMap:222      Tac:1 \n S114              \nX1:2 HANSON RD     \nX2:0 HURONTARIO ST \nInc#1232873 10:45:06 
 OR-OR OUT OF SE\n MILLTOWER CT                          \nMap:         Tac:1 \n S111              \nX1:                \nX2:                \nInc#1232874 10:45:34 
 76-NATURAL GAS \n 5580 EXPLORER DR-MG                   \nMap:348      Tac:3 \n P117 P109 A105 S10\nX1:5300 SATELLITE D\nX2:5290 ORBITOR DR \nInc#1232875 10:48:26 
 
*/
public class ZCAONMississaugaParserTest extends BaseParserTest {
  
  public ZCAONMississaugaParserTest() {
    setParser(new ZCAONMississaugaParser(), "PEEL REGIONAL MUNICIPALITY", "ON");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "  51-PI ACCIDENT/\n" +
        " CONFEDERATION PY-MG/RATHBURN RD W-MG  \n" +
        "Map:294      Tac:3 \n" +
        " P101 S101         \n" +
        "X1:0 RATHBURN RD W \n" +
        "X2:0 SQUARE ONE DR \n" +
        "Inc#1232800 19:57:17 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:CONFEDERATION PY & RATHBURN RD W",
        "MADDR:CONFEDERATION PKWY & RATHBURN RD W",
        "CITY:MISSISSAUGA",
        "MAP:294",
        "CH:3",
        "UNIT:P101 S101",
        "X:RATHBURN RD W & SQUARE ONE DR",
        "ID:1232800",
        "TIME:19:57:17");

    doTest("T2",
        " 30-CAR FIRE ON \n" +
        " 403EB E OF EASTGATE TO EGLINTON       \n" +
        "Map:         Tac:3 \n" +
        " P101 A101         \n" +
        "X1:E OF EASTGATE PY\n" +
        "X2:W OF EGLINTON AV\n" +
        "Inc#1232801 20:10:55 ",

        "CALL:30-CAR FIRE ON",
        "ADDR:403EB E OF EASTGATE TO EGLINTON",
        "MADDR:403EB & EASTGATE TO EGLINTON",
        "CH:3",
        "UNIT:P101 A101",
        "X:EASTGATE PY & EGLINTON AV",
        "ID:1232801",
        "TIME:20:10:55");

    doTest("T3",
        " 92-OTHER ASSIST\n" +
        " 89 WALKER DR-BR                       \n" +
        "Map:118D     Tac:7 \n" +
        " P202              \n" +
        "X1:2 WOODSLEA RD   \n" +
        "X2:2 SUMMERLEA RD &\n" +
        "        Inc:#1232802 ",

        "CALL:92-OTHER ASSIST",
        "ADDR:89 WALKER DR",
        "CITY:BRAMPTON",
        "MAP:118D",
        "CH:7",
        "UNIT:P202",
        "X:2 WOODSLEA RD & 2 SUMMERLEA RD",
        "ID:1232802");

    doTest("T4",
        " 24-DIFF BRTH/CH\n" +
        " 820 SCOLLARD CT-MG                    \n" +
        "Map:377      Tac:3 \n" +
        " S101              \n" +
        "X1:5055 HEATHERLEIG\n" +
        "X2:                \n" +
        "Inc#1232803 20:31:50 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:820 SCOLLARD CT",
        "CITY:MISSISSAUGA",
        "MAP:377",
        "CH:3",
        "UNIT:S101",
        "X:5055 HEATHERLEIG",
        "ID:1232803",
        "TIME:20:31:50");

    doTest("T5",
        " 24-DIFF BRTH/CH\n" +
        " 4 JULIAN DR-BR                        \n" +
        "Map:144D     Tac:7 \n" +
        " A213              \n" +
        "X1:4400 CASTLEMORE \n" +
        "X2:2 FITZPATRICK DR\n" +
        "        Inc:#1232804 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:4 JULIAN DR",
        "CITY:BRAMPTON",
        "MAP:144D",
        "CH:7",
        "UNIT:A213",
        "X:4400 CASTLEMORE & 2 FITZPATRICK DR",
        "ID:1232804");

    doTest("T6",
        " 47-SENIOR FACIL\n" +
        " 1376 CREDIT WOODLANDS CT-MG           \n" +
        "Map:172      Tac:2 \n" +
        " S107 P112 A107 S11\n" +
        "X1:1322 WILTSHIRE L\n" +
        "X2:                \n" +
        "Inc#1232805 20:42:28 ",

        "CALL:47-SENIOR FACIL",
        "ADDR:1376 CREDIT WOODLANDS CT",
        "CITY:MISSISSAUGA",
        "MAP:172",
        "CH:2",
        "UNIT:S107 P112 A107 S11",
        "X:1322 WILTSHIRE L",
        "ID:1232805",
        "TIME:20:42:28");

    doTest("T7",
        " 51-PI ACCIDENT/\n" +
        " FINCH AV-BR/STEELES AV E-BR           \n" +
        "Map:139E     Tac:7 \n" +
        " A213 S203         \n" +
        "X1:3998 STEELES AV \n" +
        "X2:54 KENVIEW BV   \n" +
        "        Inc:#1232806 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:FINCH AV & STEELES AV E",
        "MADDR:FINCH AVE & STEELES AVE E",
        "CITY:BRAMPTON",
        "MAP:139E",
        "CH:7",
        "UNIT:A213 S203",
        "X:3998 STEELES AV & 54 KENVIEW BV",
        "ID:1232806");

    doTest("T8",
        " 24-DIFF BRTH/CH\n" +
        " 88 CLARRIDGE CT-BR                    \n" +
        "Map:55B      Tac:7 \n" +
        " A207              \n" +
        "X1:46 ECCLESTONE DR\n" +
        "X2:                \n" +
        "        Inc:#1232807 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:88 CLARRIDGE CT",
        "CITY:BRAMPTON",
        "MAP:55B",
        "CH:7",
        "UNIT:A207",
        "X:46 ECCLESTONE DR",
        "ID:1232807");

    doTest("T9",
        " 22-CHEST PAINS/\n" +
        " 2231 HENSALL ST-MG                    \n" +
        "Map:144      Tac:3 \n" +
        " P110              \n" +
        "X1:464 VALLEYFIELD \n" +
        "X2:464 ABINGTON AV \n" +
        "Inc#1232808 21:18:47 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:2231 HENSALL ST",
        "CITY:MISSISSAUGA",
        "MAP:144",
        "CH:3",
        "UNIT:P110",
        "X:464 VALLEYFIELD & 464 ABINGTON AV",
        "ID:1232808",
        "TIME:21:18:47");

    doTest("T10",
        " 24-DIFF BRTH/CH\n" +
        " 11 LISA ST-BR                         \n" +
        "Map:87B      Tac:7 \n" +
        " P201              \n" +
        "X1:2 SILVER MAPLE C\n" +
        "X2:8800 DIXIE RD   \n" +
        "        Inc:#1232809 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:11 LISA ST",
        "CITY:BRAMPTON",
        "MAP:87B",
        "CH:7",
        "UNIT:P201",
        "X:2 SILVER MAPLE C & 8800 DIXIE RD",
        "ID:1232809");

    doTest("T11",
        " 22-CHEST PAINS/\n" +
        " 7625 FINCH AV-BR                      \n" +
        "Map:150B     Tac:7 \n" +
        " A213              \n" +
        "X1:54 KENVIEW BV   \n" +
        "X2:                \n" +
        "        Inc:#1232810 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:7625 FINCH AV",
        "MADDR:7625 FINCH AVE",
        "CITY:BRAMPTON",
        "MAP:150B",
        "CH:7",
        "UNIT:A213",
        "X:54 KENVIEW BV",
        "ID:1232810");

    doTest("T12",
        " 22-CHEST PAINS/\n" +
        " 15 TUMBLEWEED TL-BR                   \n" +
        "Map:50C      Tac:7 \n" +
        " P206              \n" +
        "X1:2 CRIMSON CT    \n" +
        "X2:2 MOONSTONE CT  \n" +
        "        Inc:#1232811 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:15 TUMBLEWEED TL",
        "MADDR:15 TUMBLEWEED TRL",
        "CITY:BRAMPTON",
        "MAP:50C",
        "CH:7",
        "UNIT:P206",
        "X:2 CRIMSON CT & 2 MOONSTONE CT",
        "ID:1232811");

    doTest("T13",
        " 24-DIFF BRTH/CH\n" +
        " CHARLESTON SR-CA/HEART LAKE RD-CA     \n" +
        "Map:         Tac:8 \n" +
        " S309              \n" +
        "X1:18452 HEART LAKE\n" +
        "X2:18442 HORSESHOE \n" +
        "        Inc:#1232812 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:CHARLESTON SR & HEART LAKE RD",
        "MADDR:CHARLESTON SIDE ROAD & HEART LAKE RD",
        "CITY:CALEDON",
        "CH:8",
        "UNIT:S309",
        "X:18452 HEART LAKE & 18442 HORSESHOE",
        "ID:1232812");

    doTest("T14",
        " 48-False/Restor\n" +
        " 1295 WILLIAMS PY-BR                   \n" +
        "Map:95B      Tac:7 \n" +
        " S203              \n" +
        "X1:9400 BRAMALEA RD\n" +
        "X2:2 MACKAY ST S   \n" +
        "        Inc:#1232813 ",

        "CALL:48-False/Restor",
        "ADDR:1295 WILLIAMS PY",
        "MADDR:1295 WILLIAMS PKWY",
        "CITY:BRAMPTON",
        "MAP:95B",
        "CH:7",
        "UNIT:S203",
        "X:9400 BRAMALEA RD & 2 MACKAY ST S",
        "ID:1232813");

    doTest("T15",
        " 51-PI ACCIDENT/\n" +
        " 403EB N OF DUNDAS TO WCB              \n" +
        "Map:         Tac:3 \n" +
        " A107 S107 BYL1    \n" +
        "X1:N OF DUNDAS ST  \n" +
        "X2:W OF WCB        \n" +
        "Inc#1232814 22:54:54 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:403EB N OF DUNDAS TO WCB",
        "MADDR:403EB & DUNDAS TO WCB",
        "CH:3",
        "UNIT:A107 S107 BYL1",
        "X:DUNDAS ST & WCB",
        "ID:1232814",
        "TIME:22:54:54");

    doTest("T16",
        " 51-PI ACCIDENT/\n" +
        " 401EB COLL FROM DIXIE RD TO RENFORTH  \n" +
        "Map:         Tac:3 \n" +
        " P109 S114 BYL1    \n" +
        "X1:E OF DIXIE RD   \n" +
        "X2:W OF RENFORTH DR\n" +
        "Inc#1232815 22:58:09 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:401EB COLL FROM DIXIE RD TO RENFORTH",
        "MADDR:401EB COLL FROM DIXIE RD TO RENFORTH & DIXIE RD",
        "CH:3",
        "UNIT:P109 S114 BYL1",
        "X:DIXIE RD & RENFORTH DR",
        "ID:1232815",
        "TIME:22:58:09");

    doTest("T17",
        " 24-DIFF BRTH/CH\n" +
        " 13 PARK ESTATES CT-BR                 \n" +
        "Map:54D      Tac:7 \n" +
        " A207              \n" +
        "X1:240 MURRAY ST & \n" +
        "X2:                \n" +
        "        Inc:#1232816 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:13 PARK ESTATES CT",
        "CITY:BRAMPTON",
        "MAP:54D",
        "CH:7",
        "UNIT:A207",
        "X:240 MURRAY ST",
        "ID:1232816");

    doTest("T18",
        " 22-CHEST PAINS/\n" +
        " 171 MAIN ST N-BR                      \n" +
        "Map:66C      Tac:7 \n" +
        " A207              \n" +
        "X1:2 ALEXANDER ST  \n" +
        "X2:2 CHURCH ST W & \n" +
        "        Inc:#1232817 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:171 MAIN ST N",
        "CITY:BRAMPTON",
        "MAP:66C",
        "CH:7",
        "UNIT:A207",
        "X:2 ALEXANDER ST & 2 CHURCH ST W",
        "ID:1232817");

    doTest("T19",
        " 22-CHEST PAINS/\n" +
        " 12419 KENNEDY RD-CA                   \n" +
        "Map:         Tac:8 \n" +
        " S307              \n" +
        "X1:2 BENADIR AV    \n" +
        "X2:2 LOSINO ST     \n" +
        "        Inc:#1232818 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:12419 KENNEDY RD",
        "CITY:CALEDON",
        "CH:8",
        "UNIT:S307",
        "X:2 BENADIR AV & 2 LOSINO ST",
        "ID:1232818");

    doTest("T20",
        " 24-DIFF BRTH/CH\n" +
        " 1061 SENECA AV-MG                     \n" +
        "Map:73       Tac:3 \n" +
        " P102              \n" +
        "X1:68 FOREST AV    \n" +
        "X2:16 IROQUOIS AV  \n" +
        "Inc#1232819 00:20:47 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:1061 SENECA AV",
        "MADDR:1061 SENECA AVE",
        "CITY:MISSISSAUGA",
        "MAP:73",
        "CH:3",
        "UNIT:P102",
        "X:68 FOREST AV & 16 IROQUOIS AV",
        "ID:1232819",
        "TIME:00:20:47");

    doTest("T21",
        " 55-ELEVATOR STA\n" +
        " 100 JOHN ST-BR                        \n" +
        "Map:67B      Tac:7 \n" +
        " A207              \n" +
        "X1:10 JAMES ST     \n" +
        "X2:                \n" +
        "        Inc:#1232820 ",

        "CALL:55-ELEVATOR STA",
        "ADDR:100 JOHN ST",
        "CITY:BRAMPTON",
        "MAP:67B",
        "CH:7",
        "UNIT:A207",
        "X:10 JAMES ST",
        "ID:1232820");

    doTest("T22",
        " 43-RESIDENTIAL \n" +
        " 2330 CARLANNE PL-MG                   \n" +
        "Map:162      Tac:2 \n" +
        " P110 A110         \n" +
        "X1:688 FIELDSTONE R\n" +
        "X2:2318 CARLANNE CT\n" +
        "Inc#1232821 01:02:51 ",

        "CALL:43-RESIDENTIAL",
        "ADDR:2330 CARLANNE PL",
        "CITY:MISSISSAUGA",
        "MAP:162",
        "CH:2",
        "UNIT:P110 A110",
        "X:688 FIELDSTONE R & 2318 CARLANNE CT",
        "ID:1232821",
        "TIME:01:02:51");

    doTest("T23",
        " 24-DIFF BRTH/CH\n" +
        " 2367 MARISA CT-MG                     \n" +
        "Map:171      Tac:3 \n" +
        " S107              \n" +
        "X1:2428 HAMMOND RD \n" +
        "X2:                \n" +
        "Inc#1232822 01:03:25 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:2367 MARISA CT",
        "CITY:MISSISSAUGA",
        "MAP:171",
        "CH:3",
        "UNIT:S107",
        "X:2428 HAMMOND RD",
        "ID:1232822",
        "TIME:01:03:25");

    doTest("T24",
        " 51-PI ACCIDENT/\n" +
        " BOVAIRD DR W-BR/WORTHINGTON AV-BR     \n" +
        "Map:34C      Tac:7 \n" +
        " A210 S205         \n" +
        "X1:2 WORTHINGTON AV\n" +
        "X2:2 BRISDALE DR & \n" +
        "        Inc:#1232823 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:BOVAIRD DR W & WORTHINGTON AV",
        "MADDR:BOVAIRD DR W & WORTHINGTON AVE",
        "CITY:BRAMPTON",
        "MAP:34C",
        "CH:7",
        "UNIT:A210 S205",
        "X:2 WORTHINGTON AV & 2 BRISDALE DR",
        "ID:1232823");

    doTest("T25",
        " 20-CHILD MEDICA\n" +
        " 1828 HINDHEAD RD-MG                   \n" +
        "Map:103      Tac:3 \n" +
        " P103              \n" +
        "X1:1240 APRIL DR   \n" +
        "X2:1036 WELWYN DR  \n" +
        "Inc#1232824 01:27:29 ",

        "CALL:20-CHILD MEDICA",
        "ADDR:1828 HINDHEAD RD",
        "CITY:MISSISSAUGA",
        "MAP:103",
        "CH:3",
        "UNIT:P103",
        "X:1240 APRIL DR & 1036 WELWYN DR",
        "ID:1232824",
        "TIME:01:27:29");

    doTest("T26",
        " 24-DIFF BRTH/CH\n" +
        " 20 CEDARVALLEY BV-BR                  \n" +
        "Map:52C      Tac:7 \n" +
        " P205              \n" +
        "X1:152 WINNERS CL  \n" +
        "X2:220 VAN KIRK DR \n" +
        "        Inc:#1232825 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:20 CEDARVALLEY BV",
        "CITY:BRAMPTON",
        "MAP:52C",
        "CH:7",
        "UNIT:P205",
        "X:152 WINNERS CL & 220 VAN KIRK DR",
        "ID:1232825");

    doTest("T27",
        " 22-CHEST PAINS/\n" +
        " 3 UNIONVILLE CR-BR                    \n" +
        "Map:147B     Tac:7 \n" +
        " A213              \n" +
        "X1:OSGOODE DR      \n" +
        "X2:0 ROYSTON ST    \n" +
        "        Inc:#1232826 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:3 UNIONVILLE CR",
        "MADDR:3 UNIONVILLE CIR",
        "CITY:BRAMPTON",
        "MAP:147B",
        "CH:7",
        "UNIT:A213",
        "X:OSGOODE DR & ROYSTON ST",
        "ID:1232826");

    doTest("T28",
        " 41-ALARM BELLS \n" +
        " 3355 PONYTRAIL DR-MG                  \n" +
        "Map:191      Tac:2 \n" +
        " S106 A106         \n" +
        "X1:3450 FIELDGATE D\n" +
        "X2:3480 BRIDGEWOOD \n" +
        "Inc#1232827 02:14:51 ",

        "CALL:41-ALARM BELLS",
        "ADDR:3355 PONYTRAIL DR",
        "CITY:MISSISSAUGA",
        "MAP:191",
        "CH:2",
        "UNIT:S106 A106",
        "X:3450 FIELDGATE D & 3480 BRIDGEWOOD",
        "ID:1232827",
        "TIME:02:14:51");

    doTest("T29",
        " 24-DIFF BRTH/CH\n" +
        " 5695 WHITEHORN AV-MG                  \n" +
        "Map:381      Tac:3 \n" +
        " P118              \n" +
        "X1:1390 PICKWICK DR\n" +
        "X2:0 TORRINGTON DR \n" +
        "Inc#1232828 02:23:01 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:5695 WHITEHORN AV",
        "MADDR:5695 WHITEHORN AVE",
        "CITY:MISSISSAUGA",
        "MAP:381",
        "CH:3",
        "UNIT:P118",
        "X:1390 PICKWICK DR & TORRINGTON DR",
        "ID:1232828",
        "TIME:02:23:01");

    doTest("T30",
        " 20-CHILD MEDICA\n" +
        " 35 BRUCE BEER DR-BR                   \n" +
        "Map:75C      Tac:7 \n" +
        " P201              \n" +
        "X1:92 IVYBRIDGE DR \n" +
        "X2:IVYBRIDGE DR    \n" +
        "        Inc:#1232829 ",

        "CALL:20-CHILD MEDICA",
        "ADDR:35 BRUCE BEER DR",
        "CITY:BRAMPTON",
        "MAP:75C",
        "CH:7",
        "UNIT:P201",
        "X:92 IVYBRIDGE DR & IVYBRIDGE DR",
        "ID:1232829");

    doTest("T31",
        " 22-CHEST PAINS/\n" +
        " HURONTARIO ST-MG/LAKESHORE RD E-MG    \n" +
        "Map:84       Tac:3 \n" +
        " P104              \n" +
        "X1:138 LAKESHORE RD\n" +
        "X2:90 HIGH ST E    \n" +
        "Inc#1232830 03:07:06 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:HURONTARIO ST & LAKESHORE RD E",
        "CITY:MISSISSAUGA",
        "MAP:84",
        "CH:3",
        "UNIT:P104",
        "X:138 LAKESHORE RD & 90 HIGH ST E",
        "ID:1232830",
        "TIME:03:07:06");

    doTest("T32",
        "*LOCATION CHANGE*\n" +
        " 30 QUEEN ST E-MG                       X1:28 HELENE ST N   X2:28 ELIZABETH ST NMap:84       Tac:3   22-CHEST PAINS/HEARInc:#1232830         ",

        "CALL:LOC CHANGE - 22-CHEST PAINS/HEAR",
        "ADDR:30 QUEEN ST E",
        "CITY:MISSISSAUGA",
        "MAP:84",
        "CH:3",
        "X:28 HELENE ST N & 28 ELIZABETH ST N",
        "ID:1232830");

    doTest("T33",
        " 22-CHEST PAINS/\n" +
        " 12 BANKS DR-BR                        \n" +
        "Map:122A     Tac:7 \n" +
        " P209              \n" +
        "X1:14 WHITWELL DR  \n" +
        "X2:2 MALTBY CT & TR\n" +
        "        Inc:#1232831 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:12 BANKS DR",
        "CITY:BRAMPTON",
        "MAP:122A",
        "CH:7",
        "UNIT:P209",
        "X:14 WHITWELL DR & 2 MALTBY CT & TR",
        "ID:1232831");

    doTest("T34",
        " 45-COMMRCIAL/IN\n" +
        " 5800 KEATON CR-MG                     \n" +
        "Map:371      Tac:2 \n" +
        " P114 S114         \n" +
        "X1:5860 CHEDWORTH W\n" +
        "X2:240 MATHESON BV \n" +
        "Inc#1232832 03:16:59 ",

        "CALL:45-COMMRCIAL/IN",
        "ADDR:5800 KEATON CR",
        "MADDR:5800 KEATON CIR",
        "CITY:MISSISSAUGA",
        "MAP:371",
        "CH:2",
        "UNIT:P114 S114",
        "X:5860 CHEDWORTH W & 240 MATHESON BV",
        "ID:1232832",
        "TIME:03:16:59");

    doTest("T35",
        " 24-DIFF BRTH/CH\n" +
        " 50 CORONATION CL-BR                   \n" +
        "Map:63C      Tac:7 \n" +
        " P205              \n" +
        "X1:2 WHITMEN GT    \n" +
        "X2:86 SUNFOREST DR \n" +
        "        Inc:#1232833 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:50 CORONATION CL",
        "CITY:BRAMPTON",
        "MAP:63C",
        "CH:7",
        "UNIT:P205",
        "X:2 WHITMEN GT & 86 SUNFOREST DR",
        "ID:1232833");

    doTest("T36",
        " 27-VITAL SIGNS \n" +
        " DIXIE RD-MG/LAKESHORE RD E-MG         \n" +
        "Map:64       Tac:3 \n" +
        " P102              \n" +
        "X1:1381 LAKESHORE R\n" +
        "X2:1345 ST JAMES AV\n" +
        "Inc#1232834 03:20:45 ",

        "CALL:27-VITAL SIGNS",
        "ADDR:DIXIE RD & LAKESHORE RD E",
        "CITY:MISSISSAUGA",
        "MAP:64",
        "CH:3",
        "UNIT:P102",
        "X:1381 LAKESHORE R & 1345 ST JAMES AV",
        "ID:1232834",
        "TIME:03:20:45");

    doTest("T37",
        "*LOCATION CHANGE*\n" +
        " 1417 LAKESHORE RD E-MG                 X1:0 DETA RD        X2:1022 CHERRIEBELL Map:53       Tac:3   27-VITAL SIGNS ABSEInc:#1232834         ",

        "CALL:LOC CHANGE - 27-VITAL SIGNS ABSE",
        "ADDR:1417 LAKESHORE RD E",
        "CITY:MISSISSAUGA",
        "MAP:53",
        "CH:3",
        "X:DETA RD & 1022 CHERRIEBELL",
        "ID:1232834");

    doTest("T38",
        " 24-DIFF BRTH/CH\n" +
        " 3356 QUEEN FREDERICA DR-MG            \n" +
        "Map:202      Tac:3 \n" +
        " S106              \n" +
        "X1:1160 BLOOR ST   \n" +
        "X2:1198 SYLVANIA DR\n" +
        "Inc#1232835 03:38:09 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:3356 QUEEN FREDERICA DR",
        "CITY:MISSISSAUGA",
        "MAP:202",
        "CH:3",
        "UNIT:S106",
        "X:1160 BLOOR ST & 1198 SYLVANIA DR",
        "ID:1232835",
        "TIME:03:38:09");

    doTest("T39",
        " 52-MULTI/MAJOR/\n" +
        " 401WB COLL FROM RENFORTH TO DIXIE RD  \n" +
        "Map:         Tac:3 \n" +
        " P119 A105 S105 BYL\n" +
        "X1:W OF RENFORTH DR\n" +
        "X2:E OF DIXIE RD   \n" +
        "Inc#1232836 03:38:53 ",

        "CALL:52-MULTI/MAJOR/",
        "ADDR:401WB COLL FROM RENFORTH TO DIXIE RD",
        "MADDR:401WB COLL FROM RENFORTH TO DIXIE RD & RENFORTH DR",
        "CH:3",
        "UNIT:P119 A105 S105 BYL",
        "X:RENFORTH DR & DIXIE RD",
        "ID:1232836",
        "TIME:03:38:53");

    doTest("T40",
        " 43-RESIDENTIAL \n" +
        " 36 BOBCAT ST-BR                       \n" +
        "Map:93C      Tac:7 \n" +
        " A208 P209 C207    \n" +
        "X1:2 AMAZON CT & HI\n" +
        "X2:2 FOXTAIL RD & H\n" +
        "        Inc:#1232837 ",

        "CALL:43-RESIDENTIAL",
        "ADDR:36 BOBCAT ST",
        "CITY:BRAMPTON",
        "MAP:93C",
        "CH:7",
        "UNIT:A208 P209 C207",
        "X:2 AMAZON CT & HI & 2 FOXTAIL RD & H",
        "ID:1232837");

    doTest("T41",
        " 40-OPEN ACCESS \n" +
        " 88 BRONTE COLLEGE CT-MG               \n" +
        "Map:154      Tac:2 \n" +
        " P110 A110         \n" +
        "X1:2194 HURONTARIO \n" +
        "X2:                \n" +
        "Inc#1232838 04:37:02 ",

        "CALL:40-OPEN ACCESS",
        "ADDR:88 BRONTE COLLEGE CT",
        "CITY:MISSISSAUGA",
        "MAP:154",
        "CH:2",
        "UNIT:P110 A110",
        "X:2194 HURONTARIO",
        "ID:1232838",
        "TIME:04:37:02");

    doTest("T42",
        " 92-OTHER ASSIST\n" +
        " CONESTOGA DR-BR/SANDALWOOD PY E-BR    \n" +
        "Map:63B      Tac:7 \n" +
        " P205              \n" +
        "X1:150 SANDALWOOD P\n" +
        "X2:2 STEVEN CT     \n" +
        "        Inc:#1232839 ",

        "CALL:92-OTHER ASSIST",
        "ADDR:CONESTOGA DR & SANDALWOOD PY E",
        "MADDR:CONESTOGA DR & SANDALWOOD PKWY E",
        "CITY:BRAMPTON",
        "MAP:63B",
        "CH:7",
        "UNIT:P205",
        "X:150 SANDALWOOD P & 2 STEVEN CT",
        "ID:1232839");

    doTest("T43",
        " 24-DIFF BRTH/CH\n" +
        " 7130 TERRAGAR BV-MG                   \n" +
        "Map:554      Tac:3 \n" +
        " S111              \n" +
        "X1:3286 SCOTCH PINE\n" +
        "X2:3310 SMOKE TREE \n" +
        "Inc#1232840 05:43:00 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:7130 TERRAGAR BV",
        "CITY:MISSISSAUGA",
        "MAP:554",
        "CH:3",
        "UNIT:S111",
        "X:3286 SCOTCH PINE & 3310 SMOKE TREE",
        "ID:1232840",
        "TIME:05:43:00");

    doTest("T44",
        " 27-VITAL SIGNS \n" +
        " 2420 SURVEYOR RD-MG                   \n" +
        "Map:463B     Tac:3 \n" +
        " P108              \n" +
        "X1:6460 MILLCREEK D\n" +
        "X2:                \n" +
        "Inc#1232841 06:31:37 ",

        "CALL:27-VITAL SIGNS",
        "ADDR:2420 SURVEYOR RD",
        "CITY:MISSISSAUGA",
        "MAP:463B",
        "CH:3",
        "UNIT:P108",
        "X:6460 MILLCREEK D",
        "ID:1232841",
        "TIME:06:31:37");

    doTest("T45",
        "*LOCATION CHANGE*\n" +
        " 2420 SURVEYOR RD-MG                    X1:6460 MILLCREEK DRX2:                 Map:463B     Tac:3   27-VITAL SIGNS ABSEInc:#1232841         ",

        "CALL:LOC CHANGE - 27-VITAL SIGNS ABSE",
        "ADDR:2420 SURVEYOR RD",
        "CITY:MISSISSAUGA",
        "MAP:463B",
        "CH:3",
        "X:6460 MILLCREEK DR",
        "ID:1232841");

    doTest("T46",
        " 20-CHILD MEDICA\n" +
        " 25 RAMBLER DR-BR                      \n" +
        "Map:69B      Tac:7 \n" +
        " P206              \n" +
        "X1:112 TOWN HOUSE C\n" +
        "X2:348 BARTLEY BULL\n" +
        "        Inc:#1232842 ",

        "CALL:20-CHILD MEDICA",
        "ADDR:25 RAMBLER DR",
        "CITY:BRAMPTON",
        "MAP:69B",
        "CH:7",
        "UNIT:P206",
        "X:112 TOWN HOUSE C & 348 BARTLEY BULL",
        "ID:1232842");

    doTest("T47",
        " 24-DIFF BRTH/CH\n" +
        " 2020 BARSUDA DR-MG                    \n" +
        "Map:103      Tac:3 \n" +
        " P103              \n" +
        "X1:1994 AMBRIDGE CT\n" +
        "X2:1992 TRUSCOTT DR\n" +
        "Inc#1232843 06:52:35 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:2020 BARSUDA DR",
        "CITY:MISSISSAUGA",
        "MAP:103",
        "CH:3",
        "UNIT:P103",
        "X:1994 AMBRIDGE CT & 1992 TRUSCOTT DR",
        "ID:1232843",
        "TIME:06:52:35");

    doTest("T48",
        " OR-OR OUT OF SE\n" +
        " 2267 BRITANNIA RD W-MG                \n" +
        "Map:463B     Tac:1 \n" +
        " P108              \n" +
        "X1:5999 TURNEY DR  \n" +
        "X2:4 THEODORE DR   \n" +
        "Inc#1232844 07:14:40 ",

        "CALL:OR-OR OUT OF SE",
        "ADDR:2267 BRITANNIA RD W",
        "CITY:MISSISSAUGA",
        "MAP:463B",
        "CH:1",
        "UNIT:P108",
        "X:5999 TURNEY DR & 4 THEODORE DR",
        "ID:1232844",
        "TIME:07:14:40");

    doTest("T49",
        " 51-PI ACCIDENT/\n" +
        " 410NB N OF WILLIAMS PY TO BOVAIRD DR  \n" +
        "Map:         Tac:7 \n" +
        " P201 S201         \n" +
        "X1:N OF WILLIAMS PY\n" +
        "X2:S OF BOVAIRD BV \n" +
        "        Inc:#1232845 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:410NB N OF WILLIAMS PY TO BOVAIRD DR",
        "MADDR:410NB & WILLIAMS PKWY TO BOVAIRD DR",
        "CH:7",
        "UNIT:P201 S201",
        "X:WILLIAMS PY & BOVAIRD BV",
        "ID:1232845");

    doTest("T50",
        " 96-CO DETECTOR \n" +
        " 5625 GLEN ERIN DR-MG                  \n" +
        "Map:395      Tac:3 \n" +
        " P122              \n" +
        "X1:0 THOMAS ST     \n" +
        "X2:2786 CASTLEBRIDG\n" +
        "Inc#1232846 07:50:18 ",

        "CALL:96-CO DETECTOR",
        "ADDR:5625 GLEN ERIN DR",
        "CITY:MISSISSAUGA",
        "MAP:395",
        "CH:3",
        "UNIT:P122",
        "X:THOMAS ST & 2786 CASTLEBRIDG",
        "ID:1232846",
        "TIME:07:50:18");

    doTest("T51",
        " 51-PI ACCIDENT/\n" +
        " SOUTHLAKE BV-BR/BOVAIRD DR E-BR       \n" +
        "Map:74D      Tac:7 \n" +
        " A208 S205         \n" +
        "X1:898 BOVAIRD DR E\n" +
        "X2:2 SEA LION RD   \n" +
        "        Inc:#1232847 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:SOUTHLAKE BV & BOVAIRD DR E",
        "CITY:BRAMPTON",
        "MAP:74D",
        "CH:7",
        "UNIT:A208 S205",
        "X:898 BOVAIRD DR E & 2 SEA LION RD",
        "ID:1232847");

    doTest("T52",
        " OR-OR OUT OF SE\n" +
        " 15 FAIRVIEW RD W-MG                   \n" +
        "Map:222      Tac:1 \n" +
        " A101              \n" +
        "X1:2 HANSON RD     \n" +
        "X2:0 HURONTARIO ST \n" +
        "Inc#1232848 08:00:15 ",

        "CALL:OR-OR OUT OF SE",
        "ADDR:15 FAIRVIEW RD W",
        "CITY:MISSISSAUGA",
        "MAP:222",
        "CH:1",
        "UNIT:A101",
        "X:2 HANSON RD & HURONTARIO ST",
        "ID:1232848",
        "TIME:08:00:15");

    doTest("T53",
        " 45-COMMRCIAL/IN\n" +
        " 1285 EGLINTON AV E-MG                 \n" +
        "Map:272      Tac:2 \n" +
        " P117 S106         \n" +
        "X1:4626 BURGOYNE ST\n" +
        "X2:4900 DIXIE RD   \n" +
        "Inc#1232849 08:03:13 ",

        "CALL:45-COMMRCIAL/IN",
        "ADDR:1285 EGLINTON AV E",
        "MADDR:1285 EGLINTON AVE E",
        "CITY:MISSISSAUGA",
        "MAP:272",
        "CH:2",
        "UNIT:P117 S106",
        "X:4626 BURGOYNE ST & 4900 DIXIE RD",
        "ID:1232849",
        "TIME:08:03:13");

    doTest("T54",
        " 51-PI ACCIDENT/\n" +
        " HWY 9 HY-CA/MOUNT PLEASANT RD-CA      \n" +
        "Map:         Tac:8 \n" +
        " P306 S306 T306 S31\n" +
        "X1:17610 MOUNT PLEA\n" +
        "X2:17298 MOUNT WOLF\n" +
        "        Inc:#1232850 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:HWY 9 HY & MOUNT PLEASANT RD",
        "MADDR:HWY HWY 9 & MOUNT PLEASANT RD",
        "CITY:CALEDON",
        "CH:8",
        "UNIT:P306 S306 T306 S31",
        "X:17610 MOUNT PLEA & 17298 MOUNT WOLF",
        "ID:1232850");

    doTest("T55",
        " 51-PI ACCIDENT/\n" +
        " BOVAIRD DR W-BR/MCLAUGHLIN RD-BR      \n" +
        "Map:54A      Tac:7 \n" +
        " A208 S205         \n" +
        "X1:9998 MCLAUGHLIN \n" +
        "X2:2 VAN KIRK DR & \n" +
        "        Inc:#1232851 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:BOVAIRD DR W & MCLAUGHLIN RD",
        "CITY:BRAMPTON",
        "MAP:54A",
        "CH:7",
        "UNIT:A208 S205",
        "X:9998 MCLAUGHLIN & 2 VAN KIRK DR",
        "ID:1232851");

    doTest("T56",
        " OR-OR OUT OF SE\n" +
        " 2316 HURONTARIO ST-MG                 \n" +
        "Map:152      Tac:1 \n" +
        " A110              \n" +
        "X1:21 QUEENSWAY W &\n" +
        "X2:88 BRONTE COLLEG\n" +
        "Inc#1232852 08:08:27 ",

        "CALL:OR-OR OUT OF SE",
        "ADDR:2316 HURONTARIO ST",
        "CITY:MISSISSAUGA",
        "MAP:152",
        "CH:1",
        "UNIT:A110",
        "X:21 QUEENSWAY W & 88 BRONTE COLLEG",
        "ID:1232852",
        "TIME:08:08:27");

    doTest("T57",
        " 51-PI ACCIDENT/\n" +
        " HWY 9 HY-CA/MOUNT PLEASANT RD-CA      \n" +
        "Map:         Tac:8 \n" +
        " P306 S306 T306 S31\n" +
        "X1:17610 MOUNT PLEA\n" +
        "X2:17298 MOUNT WOLF\n" +
        "        Inc:#1232850 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:HWY 9 HY & MOUNT PLEASANT RD",
        "MADDR:HWY HWY 9 & MOUNT PLEASANT RD",
        "CITY:CALEDON",
        "CH:8",
        "UNIT:P306 S306 T306 S31",
        "X:17610 MOUNT PLEA & 17298 MOUNT WOLF",
        "ID:1232850");

    doTest("T58",
        " 24-DIFF BRTH/CH\n" +
        " 5000 MAYFIELD RD-CA                   \n" +
        "Map:         Tac:8 \n" +
        " S307              \n" +
        "X1:BRAMALEA RD     \n" +
        "X2:TORBRAM RD      \n" +
        "        Inc:#1232853 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:5000 MAYFIELD RD",
        "CITY:CALEDON",
        "CH:8",
        "UNIT:S307",
        "X:BRAMALEA RD & TORBRAM RD",
        "ID:1232853");

    doTest("T59",
        " 76-NATURAL GAS \n" +
        " 1428 LARCHVIEW TL-MG                  \n" +
        "Map:51       Tac:3 \n" +
        " S106 P102 A106 S10\n" +
        "X1:1429 DIXIE RD   \n" +
        "X2:1416 LONDONDERRY\n" +
        "Inc#1232854 08:23:45 ",

        "CALL:76-NATURAL GAS",
        "ADDR:1428 LARCHVIEW TL",
        "MADDR:1428 LARCHVIEW TRL",
        "CITY:MISSISSAUGA",
        "MAP:51",
        "CH:3",
        "UNIT:S106 P102 A106 S10",
        "X:1429 DIXIE RD & 1416 LONDONDERRY",
        "ID:1232854",
        "TIME:08:23:45");

    doTest("T60",
        " 51-PI ACCIDENT/\n" +
        " BURT DR-BR/CHINGUACOUSY RD-BR         \n" +
        "Map:46C      Tac:7 \n" +
        " P204 S206         \n" +
        "X1:9198 CHINGUACOUS\n" +
        "X2:2 CORKETT DR    \n" +
        "        Inc:#1232855 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:BURT DR & CHINGUACOUSY RD",
        "CITY:BRAMPTON",
        "MAP:46C",
        "CH:7",
        "UNIT:P204 S206",
        "X:9198 CHINGUACOUS & 2 CORKETT DR",
        "ID:1232855");

    doTest("T61",
        " 51-PI ACCIDENT/\n" +
        " AIRPORT RD-MG/MORNING STAR DR-MG      \n" +
        "Map:483      Tac:4 \n" +
        " A105 S105         \n" +
        "X1:3001 MORNING STA\n" +
        "X2:6 BEVERLEY ST & \n" +
        "Inc#1232856 08:32:32 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:AIRPORT RD & MORNING STAR DR",
        "CITY:MISSISSAUGA",
        "MAP:483",
        "CH:4",
        "UNIT:A105 S105",
        "X:3001 MORNING STA & 6 BEVERLEY ST",
        "ID:1232856",
        "TIME:08:32:32");

    doTest("T62",
        " OR-OR OUT OF SE\n" +
        " 1735 BRITANNIA RD E-MG                \n" +
        "Map:423      Tac:1 \n" +
        " T101              \n" +
        "X1:5970 ATLANTIC DR\n" +
        "X2:6045 NETHERHART \n" +
        "Inc#1232857 08:35:03 ",

        "CALL:OR-OR OUT OF SE",
        "ADDR:1735 BRITANNIA RD E",
        "CITY:MISSISSAUGA",
        "MAP:423",
        "CH:1",
        "UNIT:T101",
        "X:5970 ATLANTIC DR & 6045 NETHERHART",
        "ID:1232857",
        "TIME:08:35:03");

    doTest("T63",
        "P116 TO REPLACE UNIT A105\nIN STATION 105\n7101 GOREWAY DR\n2012/09/12  03:42:03 ",
        "CALL:P116 TO REPLACE UNIT A105",
        "ADDR:7101 GOREWAY DR",
        "TIME:03:42:03",
        "PLACE:IN STATION 105",
        "DATE:09/12/2012");

    doTest("T64",
        "S105 TO REPLACE UNIT P119\nIN STATION 119\n3201 ELMBANK DR\n2012/09/12  03:57:24 ",
        "CALL:S105 TO REPLACE UNIT P119",
        "ADDR:3201 ELMBANK DR",
        "TIME:03:57:24",
        "PLACE:IN STATION 119",
        "DATE:09/12/2012");

    doTest("T65",
        "A202 TO REPLACE UNIT A213\nIN STATION 213\n4075 EBENEZER RD\n2012/09/12  02:19:02 ",
        "CALL:A202 TO REPLACE UNIT A213",
        "ADDR:4075 EBENEZER RD",
        "TIME:02:19:02",
        "PLACE:IN STATION 213",
        "DATE:09/12/2012");

    doTest("T66",
        "P205 TO REPLACE UNIT A207\nIN STATION 207\n75 VODDEN ST E\n2012/09/12  01:03:00 ",
        "CALL:P205 TO REPLACE UNIT A207",
        "ADDR:75 VODDEN ST E",
        "TIME:01:03:00",
        "PLACE:IN STATION 207",
        "DATE:09/12/2012");

    doTest("T67",
        "S114 TO REPLACE UNIT P109\nIN STATION 109\n1735 BRITANNIA RD E\n2012/09/11  23:09:50 ",
        "CALL:S114 TO REPLACE UNIT P109",
        "ADDR:1735 BRITANNIA RD E",
        "TIME:23:09:50",
        "PLACE:IN STATION 109",
        "DATE:09/11/2012");

    doTest("T68",
        "P110 TO REPLACE UNIT P101\nIN STATION 101\n15 FAIRVIEW RD W\n2012/09/11  20:33:16 ",
        "CALL:P110 TO REPLACE UNIT P101",
        "ADDR:15 FAIRVIEW RD W",
        "TIME:20:33:16",
        "PLACE:IN STATION 101",
        "DATE:09/11/2012");

    doTest("T69",
        "P115 TO REPLACE UNIT P108\nIN STATION 108\n2267 BRITANNIA RD W\n2012/09/12  06:39:16 ",
        "CALL:P115 TO REPLACE UNIT P108",
        "ADDR:2267 BRITANNIA RD W",
        "TIME:06:39:16",
        "PLACE:IN STATION 108",
        "DATE:09/12/2012");

    doTest("T70",
        "A111 TO REPLACE UNIT P108\nIN STATION 108\n2267 BRITANNIA RD W\n2012/09/12  07:14:07 ",
        "CALL:A111 TO REPLACE UNIT P108",
        "ADDR:2267 BRITANNIA RD W",
        "TIME:07:14:07",
        "PLACE:IN STATION 108",
        "DATE:09/12/2012");

    doTest("T71",
        "A202 TO REPLACE UNIT P201\nIN STATION 201\n8 RUTHERFORD RD S\n2012/09/12  07:26:00 ",
        "CALL:A202 TO REPLACE UNIT P201",
        "ADDR:8 RUTHERFORD RD S",
        "TIME:07:26:00",
        "PLACE:IN STATION 201",
        "DATE:09/12/2012");

    doTest("T72",
        "P116 TO REPLACE UNIT A105\nIN STATION 105\n7101 GOREWAY DR\n2012/09/12  08:33:25 ",
        "CALL:P116 TO REPLACE UNIT A105",
        "ADDR:7101 GOREWAY DR",
        "TIME:08:33:25",
        "PLACE:IN STATION 105",
        "DATE:09/12/2012");

    doTest("T73",
        "P117 TO REPLACE UNIT A106\nIN STATION 106\n3450 DIXIE RD\n2012/09/12  08:36:22 ",
        "CALL:P117 TO REPLACE UNIT A106",
        "ADDR:3450 DIXIE RD",
        "TIME:08:36:22",
        "PLACE:IN STATION 106",
        "DATE:09/12/2012");

    doTest("T74",
        "P114 TO REPLACE UNIT P117\nIN STATION 117\n1090 NUVIK CT\n2012/09/12  08:36:44 ",
        "CALL:P114 TO REPLACE UNIT P117",
        "ADDR:1090 NUVIK CT",
        "TIME:08:36:44",
        "PLACE:IN STATION 117",
        "DATE:09/12/2012");

    doTest("T75",
        "P206 TO REPLACE UNIT P204\nIN STATION 204\n675 QUEEN ST W\n2012/09/12  08:39:58 ",
        "CALL:P206 TO REPLACE UNIT P204",
        "ADDR:675 QUEEN ST W",
        "TIME:08:39:58",
        "PLACE:IN STATION 204",
        "DATE:09/12/2012");

    doTest("T76",
        "A210 TO REPLACE UNIT P205\nIN STATION 205\n95 SANDALWOOD PY E\n2012/09/12  09:19:54 ",
        "CALL:A210 TO REPLACE UNIT P205",
        "ADDR:95 SANDALWOOD PY E",
        "MADDR:95 SANDALWOOD PKWY E",
        "TIME:09:19:54",
        "PLACE:IN STATION 205",
        "DATE:09/12/2012");

    doTest("T77",
        "S106 TO REPLACE UNIT P117\nIN STATION 117\n1090 NUVIK CT\n2012/09/12  10:59:27 ",
        "CALL:S106 TO REPLACE UNIT P117",
        "ADDR:1090 NUVIK CT",
        "TIME:10:59:27",
        "PLACE:IN STATION 117",
        "DATE:09/12/2012");

    doTest("T78",
        "P206 TO REPLACE UNIT P212\nIN STATION 212\n8220 MISSISSAUGA RD\n2012/09/12  11:33:47 ",
        "CALL:P206 TO REPLACE UNIT P212",
        "ADDR:8220 MISSISSAUGA RD",
        "TIME:11:33:47",
        "PLACE:IN STATION 212",
        "DATE:09/12/2012");

    doTest("T79",
        "A107 TO REPLACE UNIT P103\nIN STATION 103\n2035 LUSHES AV\n2012/09/12  12:25:12 ",
        "CALL:A107 TO REPLACE UNIT P103",
        "ADDR:2035 LUSHES AV",
        "MADDR:2035 LUSHES AVE",
        "TIME:00:25:12",
        "PLACE:IN STATION 103",
        "DATE:09/12/2012");

    doTest("T80",
        "P101 TO REPLACE UNIT P110\nIN STATION 110\n2316 HURONTARIO ST\n2012/09/12  12:25:12 ",
        "CALL:P101 TO REPLACE UNIT P110",
        "ADDR:2316 HURONTARIO ST",
        "TIME:00:25:12",
        "PLACE:IN STATION 110",
        "DATE:09/12/2012");

    doTest("T81",
        "P115 TO REPLACE UNIT A107\nIN STATION 107\n1965 DUNDAS ST W\n2012/09/12  12:25:12 ",
        "CALL:P115 TO REPLACE UNIT A107",
        "ADDR:1965 DUNDAS ST W",
        "TIME:00:25:12",
        "PLACE:IN STATION 107",
        "DATE:09/12/2012");

    doTest("T82",
        "P110 TO REPLACE UNIT P104\nIN STATION 104\n62 PORT ST\n2012/09/12  12:25:12 ",
        "CALL:P110 TO REPLACE UNIT P104",
        "ADDR:62 PORT ST",
        "TIME:00:25:12",
        "PLACE:IN STATION 104",
        "DATE:09/12/2012");

    doTest("T83",
        " 51-PI ACCIDENT/\n" +
        " DIXIE RD-BR/STEELES AV E-BR           \n" +
        "Map:89D      Tac:7 \n" +
        " P202 S206         \n" +
        "X1:1500 STEELES AV \n" +
        "X2:208 ADVANCE BV  \n" +
        "        Inc:#1232858 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:DIXIE RD & STEELES AV E",
        "MADDR:DIXIE RD & STEELES AVE E",
        "CITY:BRAMPTON",
        "MAP:89D",
        "CH:7",
        "UNIT:P202 S206",
        "X:1500 STEELES AV & 208 ADVANCE BV",
        "ID:1232858");

    doTest("T84",
        " 45-COMMRCIAL/IN\n" +
        " 6420 SILVER DART DR-MG                \n" +
        "Map:414      Tac:2 \n" +
        " P119 P109         \n" +
        "X1:3090 AMERICAN DR\n" +
        "X2:                \n" +
        "Inc#1232859 08:43:47 ",

        "CALL:45-COMMRCIAL/IN",
        "ADDR:6420 SILVER DART DR",
        "CITY:MISSISSAUGA",
        "MAP:414",
        "CH:2",
        "UNIT:P119 P109",
        "X:3090 AMERICAN DR",
        "ID:1232859",
        "TIME:08:43:47");

    doTest("T85",
        " 51-PI ACCIDENT/\n" +
        " HIGHWOOD RD-BR/HURONTARIO ST-BR       \n" +
        "Map:61A      Tac:7 \n" +
        " P205 S205         \n" +
        "X1:12188 HURONTARIO\n" +
        "X2:100 HILLPATH CR \n" +
        "        Inc:#1232860 ",

        "CALL:51-PI ACCIDENT/",
        "ADDR:HIGHWOOD RD & HURONTARIO ST",
        "CITY:BRAMPTON",
        "MAP:61A",
        "CH:7",
        "UNIT:P205 S205",
        "X:12188 HURONTARIO & 100 HILLPATH CR",
        "ID:1232860");

    doTest("T86",
        " 47-SENIOR FACIL\n" +
        " 1376 CREDIT WOODLANDS CT-MG           \n" +
        "Map:172      Tac:2 \n" +
        " S107 P112 A107 S10\n" +
        "X1:1322 WILTSHIRE L\n" +
        "X2:                \n" +
        "Inc#1232861 09:12:19 ",

        "CALL:47-SENIOR FACIL",
        "ADDR:1376 CREDIT WOODLANDS CT",
        "CITY:MISSISSAUGA",
        "MAP:172",
        "CH:2",
        "UNIT:S107 P112 A107 S10",
        "X:1322 WILTSHIRE L",
        "ID:1232861",
        "TIME:09:12:19");

    doTest("T87",
        " 48-False/Restor\n" +
        " 85 KING ST E-MG                       \n" +
        "Map:141      Tac:2 \n" +
        " P110              \n" +
        "X1:2560 SHEPARD AV \n" +
        "X2:2513 CATHERINE J\n" +
        "Inc#1232862 09:21:00 ",

        "CALL:48-False/Restor",
        "ADDR:85 KING ST E",
        "CITY:MISSISSAUGA",
        "MAP:141",
        "CH:2",
        "UNIT:P110",
        "X:2560 SHEPARD AV & 2513 CATHERINE J",
        "ID:1232862",
        "TIME:09:21:00");

    doTest("T88",
        " 96-CO DETECTOR \n" +
        " 70 PIANE AV-BR                        \n" +
        "Map:47A      Tac:7 \n" +
        " P204              \n" +
        "X1:214 DRINKWATER R\n" +
        "X2:0 VENTURA AV    \n" +
        "        Inc:#1232863 ",

        "CALL:96-CO DETECTOR",
        "ADDR:70 PIANE AV",
        "MADDR:70 PIANE AVE",
        "CITY:BRAMPTON",
        "MAP:47A",
        "CH:7",
        "UNIT:P204",
        "X:214 DRINKWATER R & VENTURA AV",
        "ID:1232863");

    doTest("T89",
        " 41-ALARM BELLS \n" +
        " 310 BURNHAMTHORPE RD W-MG             \n" +
        "Map:294      Tac:2 \n" +
        " P101 S101         \n" +
        "X1:3888 DUKE OF YOR\n" +
        "X2:0 LIVING ARTS DR\n" +
        "Inc#1232864 09:31:30 ",

        "CALL:41-ALARM BELLS",
        "ADDR:310 BURNHAMTHORPE RD W",
        "CITY:MISSISSAUGA",
        "MAP:294",
        "CH:2",
        "UNIT:P101 S101",
        "X:3888 DUKE OF YOR & LIVING ARTS DR",
        "ID:1232864",
        "TIME:09:31:30");

    doTest("T90",
        " 45-COMMRCIAL/IN\n" +
        " 5830 COOPERS AV-MG                    \n" +
        "Map:361      Tac:2 \n" +
        " P114 S114         \n" +
        "X1:450 BRITANNIA RD\n" +
        "X2:5730 ROSE CHERRY\n" +
        "Inc#1232865 09:45:37 ",

        "CALL:45-COMMRCIAL/IN",
        "ADDR:5830 COOPERS AV",
        "MADDR:5830 COOPERS AVE",
        "CITY:MISSISSAUGA",
        "MAP:361",
        "CH:2",
        "UNIT:P114 S114",
        "X:450 BRITANNIA RD & 5730 ROSE CHERRY",
        "ID:1232865",
        "TIME:09:45:37");

    doTest("T91",
        " 22-CHEST PAINS/\n" +
        " 1450 MEYERSIDE DR-MG                  \n" +
        "Map:428      Tac:3 \n" +
        " P109              \n" +
        "X1:6240 DIXIE RD   \n" +
        "X2:6300 ORDAN DR   \n" +
        "Inc#1232866 09:47:34 ",

        "CALL:22-CHEST PAINS/",
        "ADDR:1450 MEYERSIDE DR",
        "CITY:MISSISSAUGA",
        "MAP:428",
        "CH:3",
        "UNIT:P109",
        "X:6240 DIXIE RD & 6300 ORDAN DR",
        "ID:1232866",
        "TIME:09:47:34");

    doTest("T92",
        " 45-COMMRCIAL/IN\n" +
        " 3160 DERRY RD E-MG                    \n" +
        "Map:406      Tac:2 \n" +
        " S105 A105         \n" +
        "X1:6894 PROFESSIONA\n" +
        "X2:0 HULL ST       \n" +
        "Inc#1232867 09:56:16 ",

        "CALL:45-COMMRCIAL/IN",
        "ADDR:3160 DERRY RD E",
        "CITY:MISSISSAUGA",
        "MAP:406",
        "CH:2",
        "UNIT:S105 A105",
        "X:6894 PROFESSIONA & HULL ST",
        "ID:1232867",
        "TIME:09:56:16");

    doTest("T93",
        " 24-DIFF BRTH/CH\n" +
        " 6 BRANT AV-MG                         \n" +
        "Map:73       Tac:3 \n" +
        " P102              \n" +
        "X1:260 LAKESHORE RD\n" +
        "X2:0 FOREST AV     \n" +
        "Inc#1232868 09:57:26 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:6 BRANT AV",
        "MADDR:6 BRANT AVE",
        "CITY:MISSISSAUGA",
        "MAP:73",
        "CH:3",
        "UNIT:P102",
        "X:260 LAKESHORE RD & FOREST AV",
        "ID:1232868",
        "TIME:09:57:26");

    doTest("T94",
        " 24-DIFF BRTH/CH\n" +
        " 1055 SOUTHDOWN RD-MG                  \n" +
        "Map:114      Tac:3 \n" +
        " P103              \n" +
        "X1:LAKESHORE RD W &\n" +
        "X2:2070 BROMSGROVE \n" +
        "Inc#1232869 10:23:04 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:1055 SOUTHDOWN RD",
        "CITY:MISSISSAUGA",
        "MAP:114",
        "CH:3",
        "UNIT:P103",
        "X:LAKESHORE RD W & 2070 BROMSGROVE",
        "ID:1232869",
        "TIME:10:23:04");

    doTest("T95",
        " 24-DIFF BRTH/CH\n" +
        " 49 LONGBOURNE CR-BR                   \n" +
        "Map:86C      Tac:7 \n" +
        " S201              \n" +
        "X1:LAURELCREST ST  \n" +
        "X2:34 LAURELCREST S\n" +
        "        Inc:#1232870 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:49 LONGBOURNE CR",
        "MADDR:49 LONGBOURNE CIR",
        "CITY:BRAMPTON",
        "MAP:86C",
        "CH:7",
        "UNIT:S201",
        "X:LAURELCREST ST & 34 LAURELCREST S",
        "ID:1232870");

    doTest("T96",
        " 24-DIFF BRTH/CH\n" +
        " 25 CORPORATION DR-BR                  \n" +
        "Map:116C     Tac:7 \n" +
        " S203              \n" +
        "X1:9300 TORBRAM RD \n" +
        "X2:2 BRAMKAY ST & P\n" +
        "        Inc:#1232871 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:25 CORPORATION DR",
        "CITY:BRAMPTON",
        "MAP:116C",
        "CH:7",
        "UNIT:S203",
        "X:9300 TORBRAM RD & 2 BRAMKAY ST & P",
        "ID:1232871");

    doTest("T97",
        " 24-DIFF BRTH/CH\n" +
        " 1389 CAWTHRA RD-MG                    \n" +
        "Map:72       Tac:3 \n" +
        " P102              \n" +
        "X1:0 ARBOR CT & ARB\n" +
        "X2:0 CAWTHRA CT & S\n" +
        "Inc#1232872 10:36:14 ",

        "CALL:24-DIFF BRTH/CH",
        "ADDR:1389 CAWTHRA RD",
        "CITY:MISSISSAUGA",
        "MAP:72",
        "CH:3",
        "UNIT:P102",
        "X:ARBOR CT & ARB & CAWTHRA CT & S",
        "ID:1232872",
        "TIME:10:36:14");

    doTest("T98",
        " OR-OR OUT OF SE\n" +
        " 15 FAIRVIEW RD W-MG                   \n" +
        "Map:222      Tac:1 \n" +
        " S114              \n" +
        "X1:2 HANSON RD     \n" +
        "X2:0 HURONTARIO ST \n" +
        "Inc#1232873 10:45:06 ",

        "CALL:OR-OR OUT OF SE",
        "ADDR:15 FAIRVIEW RD W",
        "CITY:MISSISSAUGA",
        "MAP:222",
        "CH:1",
        "UNIT:S114",
        "X:2 HANSON RD & HURONTARIO ST",
        "ID:1232873",
        "TIME:10:45:06");

    doTest("T99",
        " OR-OR OUT OF SE\n" +
        " MILLTOWER CT                          \n" +
        "Map:         Tac:1 \n" +
        " S111              \n" +
        "X1:                \n" +
        "X2:                \n" +
        "Inc#1232874 10:45:34 ",

        "CALL:OR-OR OUT OF SE",
        "ADDR:MILLTOWER CT",
        "CH:1",
        "UNIT:S111",
        "ID:1232874",
        "TIME:10:45:34");

    doTest("T100",
        " 76-NATURAL GAS \n" +
        " 5580 EXPLORER DR-MG                   \n" +
        "Map:348      Tac:3 \n" +
        " P117 P109 A105 S10\n" +
        "X1:5300 SATELLITE D\n" +
        "X2:5290 ORBITOR DR \n" +
        "Inc#1232875 10:48:26 ",

        "CALL:76-NATURAL GAS",
        "ADDR:5580 EXPLORER DR",
        "CITY:MISSISSAUGA",
        "MAP:348",
        "CH:3",
        "UNIT:P117 P109 A105 S10",
        "X:5300 SATELLITE D & 5290 ORBITOR DR",
        "ID:1232875",
        "TIME:10:48:26");

  }
  
  public static void main(String[] args) {
    new ZCAONMississaugaParserTest().generateTests("T1");
  }
}