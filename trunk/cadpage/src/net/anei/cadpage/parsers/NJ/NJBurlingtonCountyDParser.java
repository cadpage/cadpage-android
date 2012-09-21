package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Burlington County, NJ (Variant D)
Contact: support@active911.com
Sender: riprun@westamptonfire.org

(Messenger 911) Call Time: 11:58:04\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3410\nLocation: 1 STUDENT DR\nLocated Btwn: WOODLANE RD/DEAD END\nNature: JUV FELL OFF JUNGLE GYM
(Messenger 911) Call Time: 17:34:50\nIncident #: 03131         S\nIncident Type: 16 F Alarms\nQuadrant: 1340\nLocation: 1570 E RT38\nLocated Btwn: MT HOLLY BP/MAIN ST\nNature: FIRE ALARM//BASEMENT SMOKE DET
(Messenger 911) Call Time: 18:41:40\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2731\nLocation: 71 FIELDCREST DR\nLocated Btwn: WILDBERRY DR/SHARPLESS BV\nNature: MALE SLID OFF BED ONTO FLOOR
(Messenger 911) Call Time: 12:03:04\nIncident #: E509          S\nIncident Type: 106 E Breathin\nQuadrant: 5030\nLocation: 7 SAUL PL\nLocated Btwn: LEVIS DR/DEAD END\nNature: 78 Y/O M//RESP DISTRESS/HENRY 
(Messenger 911) Call Time: 13:30:23\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2731\nLocation: SPRINGSIDE RD\nLocated Btwn: IKEA DR\nNature: MVA/INJURIES
(Messenger 911) Call Time: 19:34:17\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3401\nLocation: 26 W RAILROAD AV\nLocated Btwn: LAKE DR/HAND LA\nNature: CARL BUTLER / SCIP TRANSPORT
(Messenger 911) Call Time: 18:42:15\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2721\nLocation: BURLINGTON MT HOLLY RD\nLocated Btwn: WOODLANE RD\nNature: MVA W/INJ
(Messenger 911) Call Time: 07:02:12\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2721\nLocation: 1012 HOLLY LA\nLocated Btwn: OGDEN DR/HOWELL DR\nNature: CONFUSED ELDERLY FEMALE
(Messenger 911) Call Time: 08:57:48\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3401\nLocation: MILL CREEK RD\nLocated Btwn: POWELL RD/E MILL CREEK RD\nNature: JUV/ASTHMA ATTACK
(Messenger 911) Call Time: 14:35:08\nIncident #: 03161         S\nIncident Type: FIRE F Fire Call\nQuadrant: 1603\nLocation: 6 GUNNER LA\nLocated Btwn: GRAMERCY LA/GENESEE LA\nNature: KITCHEN FIRE
(Messenger 911) Call Time: 16:00:37\nIncident #: 03272         S\nIncident Type: FIRE F Fire Call\nQuadrant: 2721\nLocation: 700 RANCOCAS RD\nLocated Btwn: MUNICIPAL DR/IRICK RD\nNature: ACT GENERAL FIRE ALARM//WILL N
(Messenger 911) Call Time: 20:20:30\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3402\nLocation: 1 JESS CT\nLocated Btwn: JOE RD/DEAD END\nNature: FEMALE NOT BREATHING
(Messenger 911) Call Time: 00:41:36\nIncident #: 03272         S\nIncident Type: 132 E UnkMedEmrg\nQuadrant: 3401\nLocation: 26 W RAILROAD AV\nLocated Btwn: LAKE DR/HAND LA\nNature: CHANGE IN MEMTAL STATUS

Burlington County, NJ
Contact: support@active911.com
Sender: medfordfirerescue@gmail.com

(Messenger 911) Call Time: 00:02:10\nIncident #: 2012-00000854\nIncident Type: EMS E EMS Call\nLocation: 9 VILLAGE CT\nLocated Btwn: OAK KNOLL DR/DEAD END\nNature: DIABETIC EMERG\nQuadrant: 2516
(Messenger 911) Call Time: 22:20:02\nIncident #: 2012-00000378\nIncident Type: 44 F Wires\nLocation: CENTENNIAL AV\nLocated Btwn: GOTTLIEBS FIELD RD\nNature: TRANSFORMER ARCING\nQuadrant: 2521
(Messenger 911) Call Time: 23:39:10\nIncident #: 2012-00000853\nIncident Type: EMS E EMS Call\nLocation: 52 TURTLE CREEK DR\nLocated Btwn: EAVES MILL RD/EAVES MILL RD\nNature: MALE IN PAIN\nQuadrant: 2514
(Messenger 911) Call Time: 20:55:02\nIncident #: 2012-00000543\nIncident Type: EMS E EMS Call\nLocation: 335 RED LION RD\nLocated Btwn: NEW FREEDOM RD/HILLIARDS BRIDG\nNature: CALLER REPORTING VEH ON TOP OF\nQuadrant: 1712
(Messenger 911) [Update]\nCall Time: 20:55:02\nIncident #: 2012-00000543\nIncident Type: 133 E TrfcEntp\nLocation: 335 RED LION RD\nLocated Btwn: NEW FREEDOM RD/HILLIARDS BRIDG\nNature: CALLER REPORTING VEH ON TOP OF\nQuadrant: 1712
(Messenger 911) Call Time: 15:38:21\nIncident #: 2012-00000850\nIncident Type: EMS E EMS Call\nLocation: 8 BROOKSIDE DR\nLocated Btwn: SE LAKESIDE DR/BIRCHWOOD DR\nNature: DIFF BREATHING FOR 4 DAYS\nQuadrant: 2512
(Messenger 911) Call Time: 08:12:15\nIncident #: 2012-00000161\nIncident Type: FIRE F Fire Call\nLocation: 1414 OLD INDIAN MILLS RD\nLocated Btwn: TUCKERTON RD/RT206\nNature: ELECTRIC FIRE IN HOUSE\nQuadrant: 2810
(Messenger 911) [Update]\nCall Time: 08:12:15\nIncident #: 2012-00000161\nIncident Type: 11 F StrctrFire\nLocation: 1414 OLD INDIAN MILLS RD\nLocated Btwn: TUCKERTON RD/RT206\nNature: ELECTRIC FIRE IN HOUSE\nQuadrant: 2810
(Messenger 911) Call Time: 08:32:49\nIncident #: 2012-00000162\nIncident Type: 57 F Cover Sta\nLocation: 48 WILLOW GROVE RD\nLocated Btwn: INDIAN MILLS RD/BURNT HOUSE RD\nNature: COVER ASSIGNMENT\nQuadrant: 2810
(Messenger 911) Call Time: 11:32:54\nIncident #: 2012-00000116\nIncident Type: EMS E EMS Call\nLocation: 31 HIAWATHA TR\nLocated Btwn: OSWEGO TR/KOSOTO TR\nNature: 89YOA FEM DEHYDRATED/FLU LIKE \nQuadrant: 3711
(Messenger 911) Call Time: 18:12:30\nIncident #: 2012-00000851\nIncident Type: EMS E EMS Call\nLocation: 53 N MAIN ST\nLocated Btwn: BRANCH ST/RAILROAD AV\nNature: 1 VEHL INTO TREE IFO RESD\nQuadrant: 2513
(Messenger 911) [Update]\nCall Time: 18:12:30\nIncident #: 2012-00000851\nIncident Type: 129F E Mva/Fire\nLocation: 53 N MAIN ST\nLocated Btwn: BRANCH ST/RAILROAD AV\nNature: 1 VEHL INTO TREE IFO RESD\nQuadrant: 2513
(Messenger 911) Call Time: 09:01:18\nIncident #: 2012-00000087\nIncident Type: 15 F Rubbish\nLocation: HIAWATHA TR\nLocated Btwn: LENAPE TR\nNature: SMELL OF SMOKE IN THE AIR/UNK \nQuadrant: 3711
(Messenger 911) Call Time: 21:42:31\nIncident #: 2012-00000846\nIncident Type: EMS E EMS Call\nLocation: 3 CORKERY LA\nLocated Btwn: CROPWELL LA/DEAD END\nNature: HAVING SOME TYPE OF REACTION P\nQuadrant: 2514
(Messenger 911) [Update]\nCall Time: 21:42:31\nIncident #: 2012-00000846\nIncident Type: 132 E UnkMedEmrg\nLocation: 3 CORKERY LA\nLocated Btwn: CROPWELL LA/DEAD END\nNature: HAVING SOME TYPE OF REACTION P\nQuadrant: 2514
(Messenger 911) Call Time: 04:17:58\nIncident #: 2012-00001827\nIncident Type: 106 E Breathin\nLocation: 870 E RT70\nLocated Btwn: TROTH RD/MEDFORD TWP LINE\nNature: 86F RESP DISTRESS, SYNCOPAL EP\nQuadrant: 2223
(Messenger 911) [Update]\nCall Time: 17:01:23\nIncident #: 2012-00000373\nIncident Type: 15 F Rubbish\nLocation: 710 HAYNES RUN CL\nLocated Btwn: RT70/EAYRESTOWN RD\nNature: DUMPSTER FIRE\nQuadrant: 2513
(Messenger 911) [Update]\nCall Time: 15:15:35\nIncident #: 2012-00000372\nIncident Type: 16 F Alarms\nLocation: 6 MAGNOLIA CT\nLocated Btwn: HOPEWELL RD/DEAD END\nNature: DIRENZO RESD GEN FIRE........8\nQuadrant: 2520
(Messenger 911) Call Time: 17:01:23\nIncident #: 2012-00000373\nIncident Type: FIRE F Fire Call\nLocation: 407 HAYNES RUN CL UNIT B\nLocated Btwn: RT70/EAYRESTOWN RD\nNature: DUMPSTER FIRE\nQuadrant: 2513
(Messenger 911) Call Time: 15:15:35\nIncident #: 2012-00000372\nIncident Type: FIRE F Fire Call\nLocation: 6 MAGNOLIA CT\nLocated Btwn: HOPEWELL RD/DEAD END\nNature: DIRENZO RESD GEN FIRE........8\nQuadrant: 2520
(Messenger 911) Call Time: 10:55:12\nIncident #: 2012-00000857\nIncident Type: EMS E EMS Call\nLocation: 155 RT70\nLocated Btwn: HARTFORD RD/EUGENIA DR\nNature: POSS APPENDICITIS\nQuadrant: 2514
(Messenger 911) [Update]\nCall Time: 10:55:12\nIncident #: 2012-00000857\nIncident Type: 101 E AbdmPain\nLocation: 155 RT70\nLocated Btwn: HARTFORD RD/EUGENIA DR\nNature: POSS APPENDICITIS\nQuadrant: 2514
(Messenger 911) Call Time: 11:32:49\nIncident #: 2012-00000858\nIncident Type: EMS E EMS Call\nLocation: 1 MEDFORD LEAS WY\nLocated Btwn: RT70/NEW FREEDOM RD\nNature: 90YOF// SOB AND CHEST PAINS\nQuadrant: 2500
(Messenger 911) [Update]\nCall Time: 11:32:49\nIncident #: 2012-00000858\nIncident Type: 110 E ChestPain\nLocation: 1 MEDFORD LEAS WY\nLocated Btwn: RT70/NEW FREEDOM RD\nNature: 90YOF// SOB AND CHEST PAINS\nQuadrant: 2500
(Messenger 911) Call Time: 12:16:43\nIncident #: 2012-00000859\nIncident Type: EMS E EMS Call\nLocation: 185 TUCKERTON RD FLR 1\nLocated Btwn: MAINE TR/TAUNTON RD\nNature: 86M VICTIM HEAD INJS\nQuadrant: 2525
(Messenger 911) [Update]\nCall Time: 12:16:43\nIncident #: 2012-00000859\nIncident Type: 117 E Falls\nLocation: 185 TUCKERTON RD FLR 1\nLocated Btwn: MAINE TR/TAUNTON RD\nNature: 86YOA MALE/FALL/HEAD LACERATIO\nQuadrant: 2525
(Messenger 911) Call Time: 18:02:20\nIncident #: 2012-00000860\nIncident Type: EMS E EMS Call\nLocation: 3 GOLDEN CLUB DR\nLocated Btwn: W CENTENNIAL DR/WATERLILY CT\nNature: 57F INTOX\nQuadrant: 2521
(Messenger 911) Call Time: 00:15:26\nIncident #: 2012-00000861\nIncident Type: EMS E EMS Call\nLocation: 1 LINCOLNDALE CT\nLocated Btwn: WRENTHAM DR/DEAD END\nNature: VERGARA,MAUREEN/609-257-3003/R\nQuadrant: 2524
(Messenger 911) [Update]\nCall Time: 00:15:26\nIncident #: 2012-00000861\nIncident Type: 106 E Breathin\nLocation: 1 LINCOLNDALE CT\nLocated Btwn: WRENTHAM DR/DEAD END\nNature: VERGARA,MAUREEN/609-257-3003/R\nQuadrant: 2524
(Messenger 911) Call Time: 08:11:10\nIncident #: 2012-00000862\nIncident Type: EMS E EMS Call\nLocation: 13 CAROL JOY RD\nLocated Btwn: JACKSON RD/MEADOW WOOD CT\nNature: 77YOF// PARKINSONS PATIENT// I\nQuadrant: 2512
(Messenger 911) Call Time: 11:34:02\nIncident #: 2012-00000379\nIncident Type: FIRE F Fire Call\nLocation: 6 MUIRFIELD CT\nLocated Btwn: OLD MARLTON PK/BELLWETHER CT\nNature: CHEMICAL SMELL OUTSIDE\nQuadrant: 2513
(Messenger 911) Call Time: 11:52:21\nIncident #: 2012-00000863\nIncident Type: EMS E EMS Call\nLocation: 1911 CEDAR DR\nLocated Btwn: EUGENIA DR/DEAD END\nNature: FEMALE UNABLE TO STAND OR BEAR\nQuadrant: 2514
(Messenger 911) Call Time: 13:01:35\nIncident #: 2012-00000864\nIncident Type: EMS E EMS Call\nLocation: 208 RT70\nLocated Btwn: CHARLES ST/HAYNES CREEK LA\nNature: PASSED OUT IS CONSCIOUS AT PRE\nQuadrant: 2513
(Messenger 911) Call Time: 15:51:09\nIncident #: 2012-00000865\nIncident Type: 106 E Breathin\nLocation: 120 S MAIN ST\nLocated Btwn: MILL ST/TRIMBLE ST\nNature: RESP\nQuadrant: 2513
(Messenger 911) Call Time: 07:31:14\nIncident #: 2012-00000867\nIncident Type: EMS E EMS Call\nLocation: 808 HAYNES RUN CL\nLocated Btwn: RT70/EAYRESTOWN RD\nNature: FEMALE SHARP HEAD PAIN SAME HI\nQuadrant: 2513
(Messenger 911) Call Time: 10:17:01\nIncident #: 2012-00000868\nIncident Type: EMS E EMS Call\nLocation: 128 RT70\nLocated Btwn: EVESBORO MEDFORD RD/HARTFORD R\nNature: SUBJECT UNCON\nQuadrant: 2513
(Messenger 911) Call Time: 11:39:08\nIncident #: 2012-00000118\nIncident Type: EMS E EMS Call\nLocation: 136 HIAWATHA TR\nLocated Btwn: KAWESEA TR/MUDJEKEEWIS TR\nNature: FEM PATIENT DIFF BREATHING\nQuadrant: 3711
(Messenger 911) Call Time: 14:39:28\nIncident #: 2012-00000871\nIncident Type: EMS E EMS Call\nLocation: 24 ALLEN AV\nLocated Btwn: UNION ST/GILL RD\nNature: CHILD PASSED OUT\nQuadrant: 2513
(Messenger 911) Call Time: 15:45:05\nIncident #: 2012-00000384\nIncident Type: FIRE F Fire Call\nLocation: MT HOLLY RD\nLocated Btwn: RT70/TURTLE CREEK DR\nNature: TRANSFORMER FIRE\nQuadrant: 2514
(Messenger 911) Call Time: 15:59:37\nIncident #: 2012-00000385\nIncident Type: FIRE F Fire Call\nLocation: 109 SKEET RD\nLocated Btwn: MAPLE ST/HAWKIN RD\nNature: TRANSFORMER BLEW UP\nQuadrant: 2510
(Messenger 911) Call Time: 19:12:01\nIncident #: 2012-00000386\nIncident Type: 16 F Alarms\nLocation: 196 RT70\nLocated Btwn: JONES RD/N MAIN ST\nNature: AUDIBLE GFA//654-2546\nQuadrant: 2513
(Messenger 911) Call Time: 20:46:31\nIncident #: 2012-00000387\nIncident Type: FIRE F Fire Call\nLocation: TUCKERTON RD\nLocated Btwn: ROBIN HOOD DR\nNature: BLOWN TRANSFORMER\nQuadrant: 2524
(Messenger 911) Call Time: 21:09:55\nIncident #: 2012-00000388\nIncident Type: FIRE F Fire Call\nLocation: HARTFORD RD\nLocated Btwn: COOPER TOMLINSON RD\nNature: WURES\nQuadrant: 2512
(Messenger 911) Call Time: 00:19:19\nIncident #: 2012-00000872\nIncident Type: EMS E EMS Call\nLocation: EAYRESTOWN RD\nLocated Btwn: RT70\nNature: MVA .. VEHICLE STRUCK POLE  ..\nQuadrant: 2514
(Messenger 911) Call Time: 09:47:08\nIncident #: 2012-00000873\nIncident Type: EMS E EMS Call\nLocation: 1 RIDGE CT\nLocated Btwn: MCKENDIMEN RD/DEAD END\nNature: EMOTIONAL BREAK DOWN\nQuadrant: 2510
(Messenger 911) Call Time: 12:24:48\nIncident #: 2012-00000874\nIncident Type: EMS E EMS Call\nLocation: 16 SKEET RD\nLocated Btwn: DIXONTOWN RD/HAWKIN RD\nNature: NUMBNESS IN LEG/ABDOMINAL PAIN\nQuadrant: 2510
(Messenger 911) Call Time: 15:29:54\nIncident #: 2012-00000875\nIncident Type: EMS E EMS Call\nLocation: 1 UTAH TR\nLocated Btwn: CHRISTOPHER MILL RD/BAYAU TR\nNature: ADULT MALE CHOKING\nQuadrant: 2512
(Messenger 911) Call Time: 22:49:55\nIncident #: 2012-00000877\nIncident Type: EMS E EMS Call\nLocation: 211 BRANDYWINE CT\nLocated Btwn: WILLIAMSBURG CL/WILLIAMSBURG C\nNature: BROTHER HAS A KNIFE AND IS LOC\nQuadrant: 2522
(Messenger 911) Call Time: 07:46:29\nIncident #: 2012-00000878\nIncident Type: EMS E EMS Call\nLocation: 56 HAWKIN RD\nLocated Btwn: SKEET RD/SOUTHAMPTON TWP LINE\nNature: FEMALE HAVING TROUBLE BREATHIN\nQuadrant: 2510
(Messenger 911) Call Time: 09:36:02\nIncident #: 2012-00000879\nIncident Type: EMS E EMS Call\nLocation: CHURCH RD\nLocated Btwn: HARTFORD RD\nNature: CHEST PAINS\nQuadrant: 2515
(Messenger 911) Call Time: 13:25:53\nIncident #: 2012-00000880\nIncident Type: EMS E EMS Call\nLocation: 180 RT70\nLocated Btwn: JONES RD/N MAIN ST\nNature: VERTIGO/UNABLE TO STAND\nQuadrant: 2513
(Messenger 911) Call Time: 15:13:58\nIncident #: 2012-00000881\nIncident Type: EMS E EMS Call\nLocation: TUCKERTON RD\nLocated Btwn: HEATH RD\nNature: NECK AND BACK PAIN DUE TO MVA\nQuadrant: 2520
(Messenger 911) Call Time: 15:15:36\nIncident #: 2012-00000882\nIncident Type: EMS E EMS Call\nLocation: 9 PINECREST DR\nLocated Btwn: TUCKERTON RD/DEAD END\nNature: 83F/CHEST PAINS\nQuadrant: 2516
(Messenger 911) Call Time: 16:32:40\nIncident #: 2012-00000390\nIncident Type: FIRE F Fire Call\nLocation: 34 S MAIN ST\nLocated Btwn: FRIENDS AV/ALLEN AV\nNature: ACTIVATED FIRE ALARM//NOTHING \nQuadrant: 2513
(Messenger 911) Call Time: 19:59:36\nIncident #: 2012-00000883\nIncident Type: EMS E EMS Call\nLocation: 300 JACKSON RD\nLocated Btwn: MACCLESFIELD DR/BLUE HERON CT\nNature: FEM CALLER STD HUSBAND TOOK VA\nQuadrant: 2523
(Messenger 911) Call Time: 20:13:09\nIncident #: 2012-00000392\nIncident Type: FIRE F Fire Call\nLocation: 267 HARTFORD RD\nLocated Btwn: CHURCH RD/MT LAUREL TWP LINE\nNature: ACTIVATED ALARM - GENERAL\nQuadrant: 2515
(Messenger 911) Call Time: 22:50:20\nIncident #: 2012-00000884\nIncident Type: EMS E EMS Call\nLocation: 11 ARKANSAS TR\nLocated Btwn: MISSISSIPPI TR/MAINE TR\nNature: ABDOMINAL PAIN\nQuadrant: 2512
(Messenger 911) Call Time: 08:46:17\nIncident #: 2012-00000886\nIncident Type: EMS E EMS Call\nLocation: 1 MEDFORD LEAS WY\nLocated Btwn: RT70/NEW FREEDOM RD\nNature: 91 YROM STOMACH PAINS\nQuadrant: 2500
(Messenger 911) Call Time: 16:15:17\nIncident #: 2012-00000395\nIncident Type: FIRE F Fire Call\nLocation: 36 SW LAKESIDE DR\nLocated Btwn: JACKSON RD/ELM DR\nNature: FIRE ALARM//TRIGG,HARRY//SMOKE\nQuadrant: 2512
(Messenger 911) Call Time: 08:01:00\nIncident #: 2012-00000122\nIncident Type: EMS E EMS Call\nLocation: 160 PAUPUKKEEWIS TR\nLocated Btwn: ASKORAN TR/MIGAZEE TR\nNature: 78 YROF FALL VICTIM\nQuadrant: 3711
(Messenger 911) Call Time: 11:04:23\nIncident #: 2012-00000390\nIncident Type: AOS F Alarm OOS\nLocation: 25-2 CAROL JOY RD\nLocated Btwn: /\nNature: FM25
(Messenger 911) Call Time: 11:22:26\nIncident #: 2012-00000889\nIncident Type: EMS E EMS Call\nLocation: 23 MEDFORD LEAS WY\nLocated Btwn: RT70/NEW FREEDOM RD\nNature: 81YRO FM/FALL VICTIM /HEAD INJ\nQuadrant: 2500
(Messenger 911) Call Time: 17:13:19\nIncident #: 2012-00000890\nIncident Type: EMS E EMS Call\nLocation: 5 TAMARAC LA\nLocated Btwn: E WOODTHRUSH TR/HEATH RD\nNature: FM/CHEST PAINS\nQuadrant: 2520
(Messenger 911) Call Time: 18:56:53\nIncident #: 2012-00000891\nIncident Type: 106 E Breathin\nLocation: 205 TUCKERTON RD 1ST FLOOR\nLocated Btwn: MAINE TR/TAUNTON RD\nNature: SUBJECT W/PNUEMONIA HAVING RES\nQuadrant: 2520
(Messenger 911) Call Time: 18:57:41\nIncident #: 2012-00000892\nIncident Type: EMS E EMS Call\nLocation: 7 BRADFORD CT\nLocated Btwn: BROOKWOOD DR/DEAD END\nNature: 8 YROF FELL DOWN STAIRS/TROUBL\nQuadrant: 2521
(Messenger 911) Call Time: 09:58:42\nIncident #: 2012-00000893\nIncident Type: EMS E EMS Call\nLocation: 48 MULBERRY ST\nLocated Btwn: FILBERT ST/MCCLAIN AV\nNature: FEMALE FALL VIC\nQuadrant: 2513
(Messenger 911) Call Time: 10:55:24\nIncident #: 2012-00000894\nIncident Type: EMS E EMS Call\nLocation: 103 OLD MARLTON PK SUITE 103\nLocated Btwn: JONES RD/CHESTER AV\nNature: STROKE VICTIM\nQuadrant: 2513
(Messenger 911) Call Time: 12:41:25\nIncident #: 2012-00000895\nIncident Type: EMS E EMS Call\nLocation: 133 CHURCH RD\nLocated Btwn: HARTFORD RD/ARK RD\nNature: MALE JUVL FELL IN ANIMAL PEN, \nQuadrant: 2514
(Messenger 911) Call Time: 14:59:01\nIncident #: 2012-00000897\nIncident Type: EMS E EMS Call\nLocation: RT541 (MT HOLLY RD)\nLocated Btwn: RT70\nNature: HEAD INJ DUE TO MVA\nQuadrant: 2514
(Messenger 911) Call Time: 23:29:05\nIncident #: 2012-00000898\nIncident Type: EMS E EMS Call\nLocation: 3 CEDAR ST\nLocated Btwn: N MAIN ST/CHERRY ST\nNature: MALE/VOMITING,DEHYDRATED\nQuadrant: 2513
(Messenger 911) Call Time: 08:54:53\nIncident #: 2012-00000899\nIncident Type: EMS E EMS Call\nLocation: 112 PINE VALLEY DR\nLocated Btwn: SCHOOL HOUSE DR/DEAD END\nNature: F HER FACE IS DROOPING AND NOT\nQuadrant: 2519
(Messenger 911) Call Time: 10:49:53\nIncident #: 2012-00000397\nIncident Type: FIRE F Fire Call\nLocation: 179 RT70\nLocated Btwn: JENNINGS RD/MT HOLLY RD\nNature: 2 MONTH OLD LOCKED IN VEH\nQuadrant: 2514
(Messenger 911) Call Time: 14:08:38\nIncident #: 2012-00000398\nIncident Type: FIRE F Fire Call\nLocation: 124 W CENTENNIAL DR\nLocated Btwn: CENTENNIAL DAM RD/TEABERRY DR\nNature: SILVER RESD SMOKE DETECTOR ACT\nQuadrant: 2521
(Messenger 911) Call Time: 10:24:38\nIncident #: 2012-00000901\nIncident Type: EMS E EMS Call\nLocation: 240 TAUNTON BV\nLocated Btwn: CHESTNUT RD/TOMLINSON MILL RD\nNature: MVA/NECK AND BACK PAIN\nQuadrant: 2520
(Messenger 911) Call Time: 11:45:13\nIncident #: 2012-00000902\nIncident Type: EMS E EMS Call\nLocation: 1 MEDFORD LEAS WY\nLocated Btwn: RT70/NEW FREEDOM RD\nNature: 77 Y/OF ABDOMINAL PAIN AND HYP\nQuadrant: 2500


*/

public class NJBurlingtonCountyDParser extends FieldProgramParser {
  
  public NJBurlingtonCountyDParser() {
    super("BURLINGTON COUNTY", "NJ",
           "Call_Time:TIME! Incident_#:ID! Incident_Type:CALL! ( Located_Btwn:X! Nature:INFO! Quadrant:MAP | Quadrant:MAP Location:ADDR! Located_Btwn:X! Nature:INFO! )");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.startsWith("Messenger 911")) return false;
    return parseFields(body.split("\n"), 6, data);
  }
  
  private class MyIDField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" S")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIDField();
    return super.getField(name);
  }

  @Override
  public String adjustMapAddress(String sAddress) {
    if (sAddress.endsWith(" CL")) sAddress = sAddress.substring(0,sAddress.length()-3).trim();
    sAddress = PAREN_PTN.matcher(sAddress).replaceAll(" ");
    return sAddress;
  }
  private static final Pattern PAREN_PTN = Pattern.compile("\\(.*\\)");
}
