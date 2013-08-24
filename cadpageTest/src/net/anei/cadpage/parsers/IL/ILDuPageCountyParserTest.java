package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
DuPage County, IL

Contact: Active911
Agency name: Bartlett Fire Protection District
Location: Bartlett, IL, United States
Sender:DU-COMM@ducomm.org

INC01 1.0 EV-XXX 0       FBR130118000193600 ROSE LN                     A311BREATHING PROBLEMS                                                                                                                   6M    MA                                                                                        2                  6120763 FBR130118000194BA
INC01 1.0 EV-XXX 0       FBR130118000192101 N EASTERN AV                A112OUTSIDE FIRE                                                                                                                         F102  ST                                                                                        3                  6120576 FBR130118000193BA
INC01 1.0 EV-XXX 0       FBR1301180001911603 COLUMBIA CIR               A211ABDOMINAL PAIN/PROBLUNIT 3                                                                                                           1M    MB                                                                                        2                  6120219 FBR130118000192BA
INC01 1.0 EV-XXX 0       FBR130118000189829 CARILLON DR                 A119BREATHING PROBLEMS  CLARE OAKS                                                                                                       6M    MA                                                                                        2                  6119899 FBR130118000189BA
INC01 1.0 EV-XXX 0       FBR130117000188998 CUYAHOGA DR                 A211ALARM INVESTIGATION                                                                                                                  F501  ST                                                                                        8                  6119874 FBR130117000188BA
INC01 1.0 EV-XXX 0       FBR130117000187156 ORCHARDS PASS               A211TRAUMATIC INJURIES                                                                                                                   30M   MB                                                                                        2                  6119596 FBR130117000187BA
INC01 1.0 EV-XXX 0       FBR1301170001861956 ANGELICA LN                A311UNKNOWN PROBLEM (MANHUSSAIN RES/630 497 1800                                                                                         32M   MA                                                                                        2                  6119461 FBR130117000186BA
INC01 1.0 EV-XXX 0       FHA1301170001621600 W CENTRAL AV               R1  AUTOMATIC FIRE ALARMAMB PROPERTY TX UNK                                                                                              F500C FS                                                                                        4                  6119077 FRF130117000133RO
INC01 1.0 EV-XXX 0       FHA1301170001612051 LEEWARD LN                 E611SICK PERSON                                                                                                                          26M   MD                                                                                        2                  6118917 FHA130117000142HP
INC01 1.0 EV-XXX 0       FBR130117000185154 STANTON DR                  A311INVALID ASSIST                                                                                                                       IAM   MB                                                                                        2                  6118695 FBR130117000185BA
INC01 1.0 EV-XXX 0       FHA1301170001603900 SANDPIPER DR               E611PSYCHIATRIC/SUICIDE                                                                                                                  25M   MA                                                                                        2                  6118580 FHA130117000141HP
INC01 1.0 EV-XXX 0       FHA1301170001591515 LAKE ST                    E713CHEST PAIN          ABMG                                                                                                             10M   MA                                                                                        2                  6118541 FHA130117000140HP
INC01 1.0 EV-XXX 0       FHA130117000158370 RODENBURG RD                R3  BREATHING PROBLEMS                                                                                                                   6M    MS                                                                                        2                  6118526 FRF130117000130RO
INC01 1.0 EV-XXX 0       FHA1301170001573955 PORT DR                    E611SICK PERSON                                                                                                                          26M   MD                                                                                        2                  6118350 FHA130117000139HP
INC01 1.0 EV-XXX 0       FBR130117000184827 CARILLON DR                 A119SICK PERSON         CLARE OAKS                                                                                                       26M   MB                                                                                        2                  6118321 FBR130117000184BA
INC01 1.0 EV-XXX 0       FHA1301170001565580 COURT H                    E712SICK PERSON                                                                                                                          26M   MD                                                                                        2                  6118263 FHA130117000138HP
INC01 1.0 EV-XXX 0       FBR130117000183329 DONNA CT                    A112PSYCHIATRIC/SUICIDE                                                                                                                  25M   MB                                                                                        2                  6118177 FBR130117000183BA
INC01 1.0 EV-XXX 0       FHA1301160001551235 SAN SIMEON DR              E712LEAKS/SPILLS (INSIDE                                                                                                                 F401  FS                                                                                        3                  6117897 FHA130116000137HP
INC01 1.0 EV-XXX 0       FBR130116000182902 MABLE LN                    A301CHEST PAIN                                                                                                                           10M   MA                                                                                        2                  6117783 FBR130116000182BA
INC01 1.0 EV-XXX 0       FHA130116000154LAKE ST&BARTELS RD              E713TRAFFIC ACCIDENTS                                                                                                                    29M   MC                                                                                        2                  6117606 FHA130116000136HP

Contact: Active911
Agency name: Tri-State Fire Protection District
Location: Darien, IL, United States
Sender: DU-COMM@ducomm.org

INC01 1.0 EV-XXX 0       FTS130118000196825 TAMARACK DR               TSTS2AAMB - W/ENGINE ASSIS                                             RICHMOND AV         SEMINOLE DR                            A01182013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/18/201319:37:41
INC01 1.0 EV-XXX 0       FTS1301180001957000 S ADAMS                  TSTS2AAMB - W/ENGINE ASSIS                                                                                                        A01182013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E521    101/18/201314:25:51
INC01 1.0 EV-XXX 0       FTS130118000194221 STANHOPE DR               TSTS4AAMB - W/ENGINE ASSIS                                             BROOKSIDE LN        WILLOWHILL RD                  C       A01182013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E541    101/18/201313:17:33
INC01 1.0 EV-XXX 0       FTS13011800019316W477 MOCKINGBIRD LN         TSTS3BTRUE ALARM                                                       IL 83               LILAC LN                           SO74A01182013TS21  TQIncident Initiated By: TS/BARTUNEK,BRETT                                        T539    301/18/201312:11:30
INC01 1.0 EV-XXX 0       FTS1301180001921132 HINSWOOD DR              TSTS2BTRUE ALARM                                                       RIPPLE RIDGE        CASS AV                                A01182013TS21  TQIncident Initiated By: TS/BARTUNEK,BRETT                                        T539    301/18/201311:44:01
INC01 1.0 EV-XXX 0       FTS1301180001917014 SIERRA DR                TSTS2AAMB HOME                                                         SIERRA CT           71ST ST                                A01182013TS31  TEIncident Initiated By: TS/BARTUNEK,BRETT                                        COMM    101/18/201311:42:44
INC01 1.0 EV-XXX 0       FTS1301180001908029 CLARENDON HILLS RD       TSTS1BAMB HOME                                                         80TH ST             81ST ST                            SO74 01182013TS31  TEIncident Initiated By: TS/PANOCK,LISA                                           A524    101/18/201311:41:26
INC01 1.0 EV-XXX 0       FTS1301180001898974 RESERVE                  TSTS3AMUTUAL AID - TRUCK                                                                                                          A01182013TS92  TKIncident Initiated By: TS/PANOCK,LISA                                           T539    201/18/201310:08:19
INC01 1.0 EV-XXX 0       FTS1301180001888 ARCADIA CT                  TSTS3ATRUE ALARM                                                       FALLINGWATER DR E                                          A01182013TS21  TQIncident Initiated By: TS/PANOCK,LISA                                           T539    301/18/201307:49:00
INC01 1.0 EV-XXX 0       FTS1301180001876340 AMERICANA DR             TSTS2AAMB - W/ENGINE ASSIS               LAKE HINSDALE TOWER           63RD ST                                            320     A01182013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/18/201303:32:08
INC01 1.0 EV-XXX 0       FTS1301180001867517 COUNTRY LN S             TSTS2BCO DETECTOR                        COUNTRY LANE APARTMENTS       COUNTRY LN E        COUNTRY LN W                   2W      A01182013TS24  TRIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A534    301/18/201301:21:00
INC01 1.0 EV-XXX 0       FTS1301180001857200 BIRCHWOOD COURT          TSTS2AAMB - W/ENGINE ASSIS               LAKE WILLOWAY                                                                    B       A01182013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/18/201300:56:05
INC01 1.0 EV-XXX 0       FTS1301170001846801 HIGH GROVE BL            TSTS2AAMB - W/ENGINE ASSIS               EMERITIS OF BURR RIDGE        PLAINFIELD RD       INTERNATIONAL ST               103     A01172013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A534    101/17/201321:53:15
INC01 1.0 EV-XXX 0       FTS1301170001836810 CLARENDON HILLS RD       TSTS2AAMB - W/ENGINE ASSIS                                             68TH ST             69TH ST                                A01172013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/17/201321:35:35
INC01 1.0 EV-XXX 0       FTS130117000182125 ANSLIE                    TSTS4AMUTUAL AID - ENGINE                                                                                                         A01172013TS91  TAIncident Initiated By: TS/PANOCK,LISA                                           E541    201/17/201315:51:29
INC01 1.0 EV-XXX 0       FTS1301170001818412 CLYNDERVEN RD            TSTS3AAMB - W/ENGINE ASSIS                                             KIRKWOOD COVE       BRIARWOOD DR                           A01172013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S536    101/17/201314:49:41
INC01 1.0 EV-XXX 0       FTS130117000180S MADISON ST&PLAINFIELD RD    TSTS2AAMB - ROAD                                                                                                                  A01172013TS32  TGIncident Initiated By: TS/PANOCK,LISA                                           E541    101/17/201314:33:49
INC01 1.0 EV-XXX 0       FTS13011700017977 LAKE HINSDALE DR           TSTS2AAMB - W/ENGINE ASSIS                                             KYLE CT             LAKE HINSDALE DR                       A01172013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E541    101/17/201313:05:08
INC01 1.0 EV-XXX 0       FTS1301170001787440 TENNESSEE                TSTS2AFIRE - VEHICLE                                                                                                              A01172013TS14  TAIncident Initiated By: TS/PANOCK,LISA                                           E521    201/17/201311:42:10
INC01 1.0 EV-XXX 0       FTS1301160001776340 AMERICANA DR             TSTS2AAMB - W/ENGINE ASSIS               LAKE HINSDALE TOWER           63RD ST                                            605     A01162013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/16/201323:48:13
INC01 1.0 EV-XXX 0       FTS1301160001765757 ALABAMA AV               TSTS4BSPECIAL DUTY                                                     57TH ST             58TH ST                            SO71A01162013TS61  TAIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    601/16/201321:43:29
INC01 1.0 EV-XXX 0       FTS13011600017511S370 IL 83                  TSTS3AAMB - W/ENGINE ASSIS               CLARK GAS STATION             BLUFF RD            99TH ST                            SO74A01162013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A534    101/16/201321:08:04
INC01 1.0 EV-XXX 0       FTS1301160001749S070 LAKE DR                 TSTS1BAMB - W/ENGINE ASSIS                                             N FRONTAGE RD       LAKE DR                            SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201317:51:24
INC01 1.0 EV-XXX 0       FTS1301160001731110 TAMARACK DR              TSTS2AAMB - W/ENGINE ASSIS                                             SEMINOLE DR         BEECHNUT LN                            A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201317:00:24
INC01 1.0 EV-XXX 0       FTS13011600017215W660 79TH ST                TSTS3AAMB - W/ENGINE ASSIS               M & M MARS                    LAKE RIDGE CLUB DR  S MADISON ST                           A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S536    101/16/201316:48:10
INC01 1.0 EV-XXX 0       FTS13011600017177 LAKE HINSDALE DR           TSTS2AAMB - W/ENGINE ASSIS                                             KYLE CT             LAKE HINSDALE DR               405     A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201315:26:16
INC01 1.0 EV-XXX 0       FTS1301160001709S125 LAKE DR                 TSTS1BAMB - W/ENGINE ASSIS               STRATFORD GREEN               N FRONTAGE RD       LAKE DR                    21B 105 SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201314:45:16
INC01 1.0 EV-XXX 0       FTS13011600016916W486 LAKE DRIVE             TSTS1BAMB - W/ENGINE ASSIS                                             LAKE DR             N FRONTAGE RD                      SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E511    101/16/201312:24:51
INC01 1.0 EV-XXX 0       FTS1301160001688614 MEADOWBROOK DR           TSTS1AAMB - W/ENGINE ASSIS                                             83RD CT             CIRCLE AV                          SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E511    101/16/201311:53:32

Contact: Active911
Agency name: Villa Park Fire Department
Location: Villa Park, IL, United States
Sender: DU-COMM@ducomm.org

INC01 1.0 EV-XXX 0       FVF1301180001072 W ROOSEVELT RD                H2B OVERDOSE/INGESTION/PSIMONS RESTAURANT                                                                                                23M   MB                                                                                        2                  6121211 FVF130118000105VP
INC01 1.0 EV-XXX 0       FVF130118000106621 W VERMONT ST                H8A PSYCHIATRIC/SUICIDE                                                                                                                  25M   MB                                                                                        2                  6120994 FVF130118000104VP
INC01 1.0 EV-XXX 0       FVF130117000105525 S ARDMORE AV                H3A BREATHING PROBLEMS                                                                                                                   6M    MB                                                                                        2                  6119821 FVF130117000103VP
INC01 1.0 EV-XXX 0       FVF130117000104632 W PLEASANT AV               H8A INVESTIGATIONS                                                                                                                       F600  ST                                                                                        3                  6119228 FVF130117000102VP
INC01 1.0 EV-XXX 0       FVF1301170001031643 S MICHIGAN AV              H201DIABETIC PROBLEMS                                                                                                                    13M   MB                                                                                        2                  6118952 FVF130117000101VP
INC01 1.0 EV-XXX 0       FVF13011700010210 W ROOSEVELT RD               H2B BACK PAIN (NON-TRAUMMOTEL 6                                                                                                          5M    MB                                                                                        2                  6118679 FVF130117000100VP
INC01 1.0 EV-XXX 0       FVF130117000101827 S EUCLID AV                 H1A SICK PERSON                                                                                                                          26M   MB                                                                                        2                  6118536 FVF130117000099VP
INC01 1.0 EV-XXX 0       FVF130116000100S ARDMORE AV&W ROOSEVELT RD     H2B INJURIES FROM AN ACC                                                                                                                 29PD  MB                                                                                        2                  6117695 FVF130116000098VP
INC01 1.0 EV-XXX 0       FVF130116000099400 E ROOSEVELT RD              H1B TRAUMATIC INJURIES  CASTLE CHEVROLET                                                                                                 30M   MB                                                                                        2                  6117562 FVF130116000097VP
INC01 1.0 EV-XXX 0       FVF130116000098425 E ST CHARLES RD             H5B INJURIES FROM AN ACC                                                                                                                 29PD  MB                                                                                        2                  6117265 FVF130116000096VP

Contact: Active911
Agency name: Itasca Fire Protection District
Location: Itasca, IL, United States
Sender: DU-COMM@ducomm.org

INC01 1.0 EV-XXX 0       FIF130118000083880 W THORNDALE AV              T673AUTOMATIC FIRE ALARMGIVAUDAN BUSINESS                                               
INC01 1.0 EV-XXX 0       FIF130118000082645 COUNTRY CLUB LN             T673PSYCHIATRIC/SUICIDE                                                                 
INC01 1.0 EV-XXX 0       FIF130118000081710 CIRCLE DR                   R2  SMOKE INVESTIGATION                                                                 
INC01 1.0 EV-XXX 0       FIF130118000080520 W IRVING PARK RD            T663SICK PERSON         IFFD STATION 66                                                 
INC01 1.0 EV-XXX 0       FIF130117000079440 S OAK ST                    T663AUTOMATIC FIRE ALARM                                                                
INC01 1.0 EV-XXX 0       FIF130116000078535 S ELM ST                    T667BREATHING PROBLEMS  FOREST VIEW REHABIL                                             
INC01 1.0 EV-XXX 0       FIF1301160000771445 NORWOOD AV                 T673AUTOMATIC FIRE ALARMNESTLE WILLY WONKA                                              
INC01 1.0 EV-XXX 0       FIF130115000076513 S CHERRY ST                 T663INVALID ASSIST                                                                      
INC01 1.0 EV-XXX 0       FIF1301150000751301 E IRVING PARK RD           U693AUTOMATIC FIRE ALARMMCDONALDS                                                       
INC01 1.0 EV-XXX 0       FIF130115000074301 E NORTH ST                  T677BACK PAIN (NON-TRAUMPEACOCK JR HIGH SCH                                             

Contact: Active911
Agency name: Elmhurst Fire Department
Location: Elmhurst, IL, United States
Sender: DU-COMM@ducomm.org

INC01 1.0 EV-XXX 0       FEF130118000252423 MELROSE...HILLSIDE              AUTO AID FIRE EQUIPMSTRUCTURE FIRE.                                                                                                  F700                                                                                            8                  6121745 FEF130118000256
INC01 1.0 EV-XXX 0       FEF130118000251112 FAIRLANE AV                 C6A CO DETECTOR (NO ILLN                                                                                                                 F502  ST                                                                                        8                  6121613 FEF130118000255EL
INC01 1.0 EV-XXX 0       FEF130118000250220 S HAWTHORNE AV              C7A FALLS/BACK INJURIES                                                                                                                  17M   MB                                                                                        2                  6121234 FEF130118000254EL
INC01 1.0 EV-XXX 0       FEF130118000249531 N VAN AUKEN ST              C2A ABDOMINAL PAIN/PROBL                                                                                                                 1M    MB                                                                                        2                  6121080 FEF130118000253EL
INC01 1.0 EV-XXX 0       FEF130118000248422 W 2ND ST                    C5A AUTOMATIC FIRE ALARM                                                                                                                 F500A FS                                                                                        4                  6121023 FEF130118000252EL
INC01 1.0 EV-XXX 0       FEF130118000247583 N KENILWORTH AV             C2A CHEST PAIN                                                                                                                           10M   MA                                                                                        2                  6120962 FEF130118000251EL
INC01 1.0 EV-XXX 0       FEF130118000246387 N EMROY AV                  C4A FALLS/BACK INJURIES HODATP RESIDENCE                                                                                                 17M   MB                                                                                        2                  6120665 FEF130118000249EL
INC01 1.0 EV-XXX 0       FEF1301180002453N545 CROWN RD                  C2A INVESTIGATIONS                                                                                                                       F600  ST                                                                                        3                  6120639 FEF130118000248EL
INC01 1.0 EV-XXX 0       FEF130118000244N IL 83&W LAKE ST               C3B TRAFFIC ACCIDENTS                                                                                                                    29M   MA                                                                                        2                  6120440 FEF130118000247EL
INC01 1.0 EV-XXX 0       FEF1301180002431150 S EUCLID AV                C12BBREATHING PROBLEMS  PARK PLACE OF EL                                                                                                 6M    MA                                                                                        2                  6120242 FEF130118000246EL

Contact: Active911
Agency name: Villa Park Police Department
Location: Villa Park, IL, United States

INC01 1.0 EV-XXX 0       LVP130119001667121 S VILLA AV                VPVP05BAR CHECK                                                        GREAT WESTERN TR    E KENILWORTH AV     AV_60          218HA011920139111    Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V2     701/19/201300:41:506121845
INC01 1.0 EV-XXX 0       LVP1301190016641250 S ARDMORE AV             VPVP03BUILDING CHECK  (OFF               WILLOWBROOK HS 8063           W HIGH RIDGE RD     E RIORDAN RD        BA_58          312HA011920139022    Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V31    701/19/201300:32:036121834
INC01 1.0 EV-XXX 0       LVP130119001662DD                            VP    BAR CHECK                                                                                                                   A011920139111    Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V2     701/19/201300:27:046121830
INC01 1.0 EV-XXX 0       LVP130119001660537 S VILLA AV                VPVP05EXCESSIVE NOISE                                                  E HIGHLAND AV       E WASHINGTON ST     AW_60          224HA01192013EN      Incident Initiated By: DC/KLEIN,JEFFREY                                         3V2     601/19/201300:16:156121811
INC01 1.0 EV-XXX 0       LVP130118001655308 W DIVISION ST             VPVP04ASSIST OTHER AGENCY                                              N MICHIGAN AV       N WISCONSIN AV      AU_56          203HA01182013AOA     Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V20    701/18/201323:42:166121747
INC01 1.0 EV-XXX 0       LVP130118001652455 N HARVARD AV              VPVP01SUSPICIOUS PERSON                                                W VERMONT ST        W PLYMOUTH ST       AT_57          123HA01182013SP      Incident Initiated By: DC/DOBSON,DIANA                                          3V1     501/18/201323:29:216121725
INC01 1.0 EV-XXX 0       LVP130118001650E NORTH AV&N ELLSWORTH AV     VPVP01ASSIST OTHER AGENCY                                                                                      AS_59          109HA01182013AOA     Incident Initiated By: DC/HUNSAKER,MADELINE                                     2V112   701/18/201323:15:056121701
INC01 1.0 EV-XXX 0       LVP13011800164440 S ARDMORE AV               VPVP05CITIZEN ASSIST                     VPPD                          W HOME AV           GREAT WESTERN TR    AV_58          208HA01182013CA      Incident Initiated By: DC/GARDINER,HEATHER                                      3V20    701/18/201322:58:186121661
INC01 1.0 EV-XXX 0       LVP130118001642324 N ILLINOIS                VP    OVERNIGHT PARKER                                                                                                            A01182013ONP     Incident Initiated By: VP/TAUSCHER,ALBERTA                                      2V19    901/18/201322:40:346121635
INC01 1.0 EV-XXX 0       LVP130118001641240 E ROOSEVELT RD            VP    ASSIST OTHER AGENCY                LAZYBOY                       S HAMMERSCHMIDT AV  S STEWART AV        BB_51          170FA01182013AOA     Incident Initiated By: DC/HUNSAKER,MADELINE                                     2V26    701/18/201322:28:216121598

Contact: Active911
Agency name: Roselle Police
Location: Roselle, IL, United States

INC01 1.0 EV-XXX 0       LRO130118001308231 E IRVING PARK RD          RORO02SUSPICIOUS VEHICLE                 FAMILY PRIDE LAUNDRY          N PARK ST           LAWRENCE AV         AC_39          DUCOA011820139101    Incident Initiated By: DC/DOBSON,DIANA                                          2R2     501/18/201323:56:556121780
INC01 1.0 EV-XXX 0       LRO130118001304100 N PARK CT                 RORO01CITIZEN ASSIST                                                   E HATTENDORF AV                         AC_38          DUCOA01182013CA      Incident Initiated By: DC/MOOI,JESSICA                                          3R90    701/18/201323:42:076121743
INC01 1.0 EV-XXX 0       LRO130118001301Z4 LAKE ST                    RO    BUILDING CHECK  (OFF                                                                                                        A011820139022    Incident Initiated By: RO/COOK,TIM                                              2R4     701/18/201323:32:076121731
INC01 1.0 EV-XXX 0       LRO130118001292601 PLUM GROVE RD             RORO01SEX OFFENSE - GENERA               THE MOORINGS                  OREGON TR           CROSS CREEK CT      AA_41              A01182013SEX     Incident Initiated By: DC/SATALA,GEORGE                                         2R1     501/18/201322:02:006121556
INC01 1.0 EV-XXX 0       LRO130118001283500 W BRYN MAWR AV            RORO03SUSPICIOUS PERSON                  LAKE PARK HS WEST             WEST END RD         PEARSON DR          AE_35          DUCOA01182013SP      Incident Initiated By: DC/WYATT,TIANA                                           2R3     501/18/201320:48:226121433
INC01 1.0 EV-XXX 0       LRO130118001282GUN DR                        RO    BUILDING CHECK  (OFF                                                                                                        A011820139022    Incident Initiated By: RO/COOK,TIM                                              2R4     701/18/201320:44:536121428
INC01 1.0 EV-XXX 0       LRO130118001280222 PARK LN                   RORO01INFORMATION ONLY                                                 N PARK CT           PARK LN             AC_39          DUCOO01182013INFO    Incident Initiated By: DC/TURANO,NICHOLAS                                       2R90    701/18/201320:01:216121350
INC01 1.0 EV-XXX 0       LRO130118001279103 S PROSPECT                RORO02THIS IS A TEST TICKE               ROPD                          E ELM ST            ALLEY               AD_38          DUCOA01182013TEST    Incident Initiated By: DC/TURANO,NICHOLAS                                       2R1     901/18/201319:11:346121272
INC01 1.0 EV-XXX 0       LRO130118001278525 S SPRING                  RORO02NEIGHBOR OR TENANT D                                             BERKSHIRE TER       ORCHARD TER         AE_39          DUCOA01182013NDR     Incident Initiated By: DC/GLOVER, MARISA                                        2R2     901/18/201318:55:526121253
INC01 1.0 EV-XXX 0       LRO130118001276226 PARK LN                   RORO01WATER MAIN BREAK/WAT                                             N PARK CT           PARK LN             AC_39          DUCOA01182013WATR    Incident Initiated By: DC/BAIRD,JAMIE                                           2R90    701/18/201318:25:106121213

Contact: Active911
Agency name: West Chicago Fire District
Location: West Chicago, IL, United States
Sender: DU-COMM@ducomm.org

INC01 1.0 EV-XXX 0       FWG130118000137545 BELMONT LN                  B293GEN - FIRES (HIGH PRBELMONT VILLAGE                                                                                                  F100  10                                                                                        3                  6121508 FCR130118000197CS
INC01 1.0 EV-XXX 0       FWG130118000136421 N OAK AV                    I063CO DETECTOR (NO ILLN                                                                                                                 F502  52                                                                                        8                  6121502 FWG130118000143WC
INC01 1.0 EV-XXX 0       FWG130118000135421 N OAK AV                    I063ALARM INVESTIGATION                                                                                                                  F501  51                                                                                        8                  6121308 FWG130118000142WC
INC01 1.0 EV-XXX 0       FWG13011800013329W054 GENEVA RD                I063UNKNOWN PROBLEM (MAN                                                                                                                 32M   M1                                                                                        2                  6120967 FWG130118000140WC
INC01 1.0 EV-XXX 0       FWG130118000132202 W GRAND LAKE BL             I063FALLS/BACK INJURIES                                                                                                                  17M   M1                                                                                        2                  6120788 FWG130118000139WC
INC01 1.0 EV-XXX 0       FWG13011800013129W054 GENEVA RD                I063UNKNOWN PROBLEM (MANROHR,WAYNE 6302313209                                                                                            32M   M1                                                                                        2                  6120645 FWG130118000138WC
INC01 1.0 EV-XXX 0       FWG1301180001301213 JOLIET ST                  I074AUTOMATIC FIRE ALARMWC CENTER TX8477067150                                                                                           F500C 5C                                                                                        4                  6120531 FWG130118000137WC
INC01 1.0 EV-XXX 0       FWG130118000129650 W FOREST AV                 I073AUTOMATIC FIRE ALARMTOWN AND COUNTRY APTS                                                                                            F500B 5B                                                                                        4                  6120391 FWG130118000136WC
INC01 1.0 EV-XXX 0       FWG1301180001281800 W HAWTHORNE LN             I078AUTOMATIC FIRE ALARMLAGROU                                                                                                           F500C 5C                                                                                        4                  6120274 FWG130118000135WC
INC01 1.0 EV-XXX 0       FWG1301180001271228 KINGS CIR                  I054STROKE/ (CVA)       SOUTH BLDG APT 301                                                                                               28M   M2                                                                                        2                  6120221 FWG130118000134WC

Contact: Active911
Agency name: DU-COMM
Location: Glendale Heights, IL, United States
Sender: DU-COMM@ducomm.org

INC01 1.0 EV-XXX 0       FGS130507000758E FULLERTON AV&BLOOMINGDALE RD  N594TRAUMATIC INJURIES  CAMERA PARK                                                                                                      30M   M2                                                                                        2                  6305786 FGS130507000778GL2013-05-07 20:24:21.
INC01 1.0 EV-XXX 0       FWT130507001879502 S WOODLAWN ST               K383FALLS/BACK INJURIES                                                                                                                  17M   M1                                                                                        2                  6305779 FWT130507001757WH2013-05-07 20:22:50.
INC01 1.0 EV-XXX 0       FBR130507001287235 N HALE AV                   A013CHEST PAIN                                                                                                                           10M   M2                                                                                        2                  6305768 FBR130507001278BA2013-05-07 20:15:25.
INC01 1.0 EV-XXX 0       FDW1305070008757512 ORCHARD LN                 S12 AUTOMATIC FIRE ALARMDYNASTY POINT APARTMENTS                                                                                         F500B FS                                                                                        4                  6305746 FDW130507000893WO2013-05-07 20:04:25.
INC01 1.0 EV-XXX 0       FLW130507002270613 INVERNESS RD                M510OVERDOSE/INGESTION/P                                                                                                                 23M   M1                                                                                        2                  6305739 FLW130507002272LI2013-05-07 20:00:11.
INC01 1.0 EV-XXX 0       FBR130507001286KATHY LN&LITTLE JOHN CT         A014PSYCHIATRIC/SUICIDE                                                                                                                  25M   M1                                                                                        2                  6305724 FBR130507001277BA2013-05-07 19:49:16.
INC01 1.0 EV-XXX 0       FGS130507000757780 E NORTH AV                  N594ALARM INVESTIGATION RAMADA INN 2812                                                                                                  F501  51                                                                                        8                  6305707 FGS130507000777GL2013-05-07 19:39:28.
INC01 1.0 EV-XXX 0       FVF130507000894742 S ILLINOIS AV               H1A BREATHING PROBLEMS                                                                                                                   6M    MB                                                                                        2                  6305687 FVF130507000873VP2013-05-07 19:29:00.
INC01 1.0 EV-XXX 0       FBR130507001285409 LELA LN                     A014AUTOMATIC FIRE ALARMAHMED/6303730704                                                                                                 F500A 5A                                                                                        4                  6305670 FBR130507001276BA2013-05-07 19:14:35.
INC01 1.0 EV-XXX 0       FEF130507001849681 W NORTH AV                  C50BOUTSIDE FIRE        DIPLOMAT WEST BANQUET HALLS                                                                                      F102  ST                                                                                        3                  6305657 FEF130507001841EL2013-05-07 19:08:10.

*/

public class ILDuPageCountyParserTest extends BaseParserTest {
  
  public ILDuPageCountyParserTest() {
    setParser(new ILDuPageCountyParser(), "DUPAGE COUNTY", "IL");
  }
  
  @Test
  public void testBartlettFire() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       FBR130118000193600 ROSE LN                     A311BREATHING PROBLEMS                                                                                                                   6M    MA                                                                                        2                  6120763 FBR130118000194BA",
        "ID:FBR130118000193",
        "ADDR:600 ROSE LN",
        "UNIT:A311",
        "CALL:BREATHING PROBLEMS",
        "CITY:BARTLETT");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       FBR130118000192101 N EASTERN AV                A112OUTSIDE FIRE                                                                                                                         F102  ST                                                                                        3                  6120576 FBR130118000193BA",
        "ID:FBR130118000192",
        "ADDR:101 N EASTERN AV",
        "MADDR:101 N EASTERN AVE",
        "UNIT:A112",
        "CALL:OUTSIDE FIRE",
        "CITY:BARTLETT");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       FBR1301180001911603 COLUMBIA CIR               A211ABDOMINAL PAIN/PROBLUNIT 3                                                                                                           1M    MB                                                                                        2                  6120219 FBR130118000192BA",
        "ID:FBR130118000191",
        "ADDR:1603 COLUMBIA CIR",
        "UNIT:A211",
        "CALL:ABDOMINAL PAIN/PROBL",
        "PLACE:UNIT 3",
        "CITY:BARTLETT");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       FBR130118000189829 CARILLON DR                 A119BREATHING PROBLEMS  CLARE OAKS                                                                                                       6M    MA                                                                                        2                  6119899 FBR130118000189BA",
        "ID:FBR130118000189",
        "ADDR:829 CARILLON DR",
        "UNIT:A119",
        "CALL:BREATHING PROBLEMS",
        "PLACE:CLARE OAKS",
        "CITY:BARTLETT");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       FBR130117000188998 CUYAHOGA DR                 A211ALARM INVESTIGATION                                                                                                                  F501  ST                                                                                        8                  6119874 FBR130117000188BA",
        "ID:FBR130117000188",
        "ADDR:998 CUYAHOGA DR",
        "UNIT:A211",
        "CALL:ALARM INVESTIGATION",
        "CITY:BARTLETT");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       FBR130117000187156 ORCHARDS PASS               A211TRAUMATIC INJURIES                                                                                                                   30M   MB                                                                                        2                  6119596 FBR130117000187BA",
        "ID:FBR130117000187",
        "ADDR:156 ORCHARDS PASS",
        "UNIT:A211",
        "CALL:TRAUMATIC INJURIES",
        "CITY:BARTLETT");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       FBR1301170001861956 ANGELICA LN                A311UNKNOWN PROBLEM (MANHUSSAIN RES/630 497 1800                                                                                         32M   MA                                                                                        2                  6119461 FBR130117000186BA",
        "ID:FBR130117000186",
        "ADDR:1956 ANGELICA LN",
        "UNIT:A311",
        "CALL:UNKNOWN PROBLEM (MAN",
        "PLACE:HUSSAIN RES/630 497 1800",
        "CITY:BARTLETT");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       FHA1301170001621600 W CENTRAL AV               R1  AUTOMATIC FIRE ALARMAMB PROPERTY TX UNK                                                                                              F500C FS                                                                                        4                  6119077 FRF130117000133RO",
        "ID:FHA130117000162",
        "ADDR:1600 W CENTRAL AV",
        "MADDR:1600 W CENTRAL AVE",
        "UNIT:R1",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:AMB PROPERTY TX UNK",
        "CITY:ROSELLE");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       FHA1301170001612051 LEEWARD LN                 E611SICK PERSON                                                                                                                          26M   MD                                                                                        2                  6118917 FHA130117000142HP",
        "ID:FHA130117000161",
        "ADDR:2051 LEEWARD LN",
        "UNIT:E611",
        "CALL:SICK PERSON",
        "CITY:HANOVER PARK");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       FBR130117000185154 STANTON DR                  A311INVALID ASSIST                                                                                                                       IAM   MB                                                                                        2                  6118695 FBR130117000185BA",
        "ID:FBR130117000185",
        "ADDR:154 STANTON DR",
        "UNIT:A311",
        "CALL:INVALID ASSIST",
        "CITY:BARTLETT");

    doTest("T11",
        "INC01 1.0 EV-XXX 0       FHA1301170001603900 SANDPIPER DR               E611PSYCHIATRIC/SUICIDE                                                                                                                  25M   MA                                                                                        2                  6118580 FHA130117000141HP",
        "ID:FHA130117000160",
        "ADDR:3900 SANDPIPER DR",
        "UNIT:E611",
        "CALL:PSYCHIATRIC/SUICIDE",
        "CITY:HANOVER PARK");

    doTest("T12",
        "INC01 1.0 EV-XXX 0       FHA1301170001591515 LAKE ST                    E713CHEST PAIN          ABMG                                                                                                             10M   MA                                                                                        2                  6118541 FHA130117000140HP",
        "ID:FHA130117000159",
        "ADDR:1515 LAKE ST",
        "UNIT:E713",
        "CALL:CHEST PAIN",
        "PLACE:ABMG",
        "CITY:HANOVER PARK");

    doTest("T13",
        "INC01 1.0 EV-XXX 0       FHA130117000158370 RODENBURG RD                R3  BREATHING PROBLEMS                                                                                                                   6M    MS                                                                                        2                  6118526 FRF130117000130RO",
        "ID:FHA130117000158",
        "ADDR:370 RODENBURG RD",
        "UNIT:R3",
        "CALL:BREATHING PROBLEMS",
        "CITY:ROSELLE");

    doTest("T14",
        "INC01 1.0 EV-XXX 0       FHA1301170001573955 PORT DR                    E611SICK PERSON                                                                                                                          26M   MD                                                                                        2                  6118350 FHA130117000139HP",
        "ID:FHA130117000157",
        "ADDR:3955 PORT DR",
        "UNIT:E611",
        "CALL:SICK PERSON",
        "CITY:HANOVER PARK");

    doTest("T15",
        "INC01 1.0 EV-XXX 0       FBR130117000184827 CARILLON DR                 A119SICK PERSON         CLARE OAKS                                                                                                       26M   MB                                                                                        2                  6118321 FBR130117000184BA",
        "ID:FBR130117000184",
        "ADDR:827 CARILLON DR",
        "UNIT:A119",
        "CALL:SICK PERSON",
        "PLACE:CLARE OAKS",
        "CITY:BARTLETT");

    doTest("T16",
        "INC01 1.0 EV-XXX 0       FHA1301170001565580 COURT H                    E712SICK PERSON                                                                                                                          26M   MD                                                                                        2                  6118263 FHA130117000138HP",
        "ID:FHA130117000156",
        "ADDR:5580 COURT H",
        "UNIT:E712",
        "CALL:SICK PERSON",
        "CITY:HANOVER PARK");

    doTest("T17",
        "INC01 1.0 EV-XXX 0       FBR130117000183329 DONNA CT                    A112PSYCHIATRIC/SUICIDE                                                                                                                  25M   MB                                                                                        2                  6118177 FBR130117000183BA",
        "ID:FBR130117000183",
        "ADDR:329 DONNA CT",
        "UNIT:A112",
        "CALL:PSYCHIATRIC/SUICIDE",
        "CITY:BARTLETT");

    doTest("T18",
        "INC01 1.0 EV-XXX 0       FHA1301160001551235 SAN SIMEON DR              E712LEAKS/SPILLS (INSIDE                                                                                                                 F401  FS                                                                                        3                  6117897 FHA130116000137HP",
        "ID:FHA130116000155",
        "ADDR:1235 SAN SIMEON DR",
        "UNIT:E712",
        "CALL:LEAKS/SPILLS (INSIDE",
        "CITY:HANOVER PARK");

    doTest("T19",
        "INC01 1.0 EV-XXX 0       FBR130116000182902 MABLE LN                    A301CHEST PAIN                                                                                                                           10M   MA                                                                                        2                  6117783 FBR130116000182BA",
        "ID:FBR130116000182",
        "ADDR:902 MABLE LN",
        "UNIT:A301",
        "CALL:CHEST PAIN",
        "CITY:BARTLETT");

    doTest("T20",
        "INC01 1.0 EV-XXX 0       FHA130116000154LAKE ST&BARTELS RD              E713TRAFFIC ACCIDENTS                                                                                                                    29M   MC                                                                                        2                  6117606 FHA130116000136HP",
        "ID:FHA130116000154",
        "ADDR:LAKE ST & BARTELS RD",
        "UNIT:E713",
        "CALL:TRAFFIC ACCIDENTS",
        "CITY:HANOVER PARK");

  }
  
  @Test
  public void testTriStateFire() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       FTS130118000196825 TAMARACK DR               TSTS2AAMB - W/ENGINE ASSIS                                             RICHMOND AV         SEMINOLE DR                            A01182013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/18/201319:37:41",
        "ID:FTS130118000196",
        "ADDR:825 TAMARACK DR",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:RICHMOND AV & SEMINOLE DR");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       FTS1301180001957000 S ADAMS                  TSTS2AAMB - W/ENGINE ASSIS                                                                                                        A01182013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E521    101/18/201314:25:51",
        "ID:FTS130118000195",
        "ADDR:7000 S ADAMS",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       FTS130118000194221 STANHOPE DR               TSTS4AAMB - W/ENGINE ASSIS                                             BROOKSIDE LN        WILLOWHILL RD                  C       A01182013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E541    101/18/201313:17:33",
        "ID:FTS130118000194",
        "ADDR:221 STANHOPE DR",
        "SRC:TS",
        "UNIT:TS4A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:BROOKSIDE LN & WILLOWHILL RD");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       FTS13011800019316W477 MOCKINGBIRD LN         TSTS3BTRUE ALARM                                                       IL 83               LILAC LN                           SO74A01182013TS21  TQIncident Initiated By: TS/BARTUNEK,BRETT                                        T539    301/18/201312:11:30",
        "ID:FTS130118000193",
        "ADDR:16W477 MOCKINGBIRD LN",  // Not mapping
        "SRC:TS",
        "UNIT:TS3B",
        "CALL:TRUE ALARM",
        "X:IL 83 & LILAC LN");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       FTS1301180001921132 HINSWOOD DR              TSTS2BTRUE ALARM                                                       RIPPLE RIDGE        CASS AV                                A01182013TS21  TQIncident Initiated By: TS/BARTUNEK,BRETT                                        T539    301/18/201311:44:01",
        "ID:FTS130118000192",
        "ADDR:1132 HINSWOOD DR",
        "SRC:TS",
        "UNIT:TS2B",
        "CALL:TRUE ALARM",
        "X:RIPPLE RIDGE & CASS AV");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       FTS1301180001917014 SIERRA DR                TSTS2AAMB HOME                                                         SIERRA CT           71ST ST                                A01182013TS31  TEIncident Initiated By: TS/BARTUNEK,BRETT                                        COMM    101/18/201311:42:44",
        "ID:FTS130118000191",
        "ADDR:7014 SIERRA DR",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB HOME",
        "X:SIERRA CT & 71ST ST");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       FTS1301180001908029 CLARENDON HILLS RD       TSTS1BAMB HOME                                                         80TH ST             81ST ST                            SO74 01182013TS31  TEIncident Initiated By: TS/PANOCK,LISA                                           A524    101/18/201311:41:26",
        "ID:FTS130118000190",
        "ADDR:8029 CLARENDON HILLS RD",
        "SRC:TS",
        "UNIT:TS1B",
        "CALL:AMB HOME",
        "X:80TH ST & 81ST ST");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       FTS1301180001898974 RESERVE                  TSTS3AMUTUAL AID - TRUCK                                                                                                          A01182013TS92  TKIncident Initiated By: TS/PANOCK,LISA                                           T539    201/18/201310:08:19",
        "ID:FTS130118000189",
        "ADDR:8974 RESERVE",  // Not mapping
        "SRC:TS",
        "UNIT:TS3A",
        "CALL:MUTUAL AID - TRUCK");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       FTS1301180001888 ARCADIA CT                  TSTS3ATRUE ALARM                                                       FALLINGWATER DR E                                          A01182013TS21  TQIncident Initiated By: TS/PANOCK,LISA                                           T539    301/18/201307:49:00",
        "ID:FTS130118000188",
        "ADDR:8 ARCADIA CT",
        "SRC:TS",
        "UNIT:TS3A",
        "CALL:TRUE ALARM",
        "X:FALLINGWATER DR E");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       FTS1301180001876340 AMERICANA DR             TSTS2AAMB - W/ENGINE ASSIS               LAKE HINSDALE TOWER           63RD ST                                            320     A01182013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/18/201303:32:08",
        "ID:FTS130118000187",
        "ADDR:6340 AMERICANA DR",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "PLACE:LAKE HINSDALE TOWER",
        "X:63RD ST");

    doTest("T11",
        "INC01 1.0 EV-XXX 0       FTS1301180001867517 COUNTRY LN S             TSTS2BCO DETECTOR                        COUNTRY LANE APARTMENTS       COUNTRY LN E        COUNTRY LN W                   2W      A01182013TS24  TRIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A534    301/18/201301:21:00",
        "ID:FTS130118000186",
        "ADDR:7517 COUNTRY LN S",
        "SRC:TS",
        "UNIT:TS2B",
        "CALL:CO DETECTOR",
        "PLACE:COUNTRY LANE APARTMENTS",
        "X:COUNTRY LN E & COUNTRY LN W");

    doTest("T12",
        "INC01 1.0 EV-XXX 0       FTS1301180001857200 BIRCHWOOD COURT          TSTS2AAMB - W/ENGINE ASSIS               LAKE WILLOWAY                                                                    B       A01182013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/18/201300:56:05",
        "ID:FTS130118000185",
        "ADDR:7200 BIRCHWOOD COURT",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "PLACE:LAKE WILLOWAY");

    doTest("T13",
        "INC01 1.0 EV-XXX 0       FTS1301170001846801 HIGH GROVE BL            TSTS2AAMB - W/ENGINE ASSIS               EMERITIS OF BURR RIDGE        PLAINFIELD RD       INTERNATIONAL ST               103     A01172013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A534    101/17/201321:53:15",
        "ID:FTS130117000184",
        "ADDR:6801 HIGH GROVE BL",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "PLACE:EMERITIS OF BURR RIDGE",
        "X:PLAINFIELD RD & INTERNATIONAL ST");

    doTest("T14",
        "INC01 1.0 EV-XXX 0       FTS1301170001836810 CLARENDON HILLS RD       TSTS2AAMB - W/ENGINE ASSIS                                             68TH ST             69TH ST                                A01172013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/17/201321:35:35",
        "ID:FTS130117000183",
        "ADDR:6810 CLARENDON HILLS RD",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:68TH ST & 69TH ST");

    doTest("T15",
        "INC01 1.0 EV-XXX 0       FTS130117000182125 ANSLIE                    TSTS4AMUTUAL AID - ENGINE                                                                                                         A01172013TS91  TAIncident Initiated By: TS/PANOCK,LISA                                           E541    201/17/201315:51:29",
        "ID:FTS130117000182",
        "ADDR:125 ANSLIE",
        "SRC:TS",
        "UNIT:TS4A",
        "CALL:MUTUAL AID - ENGINE");

    doTest("T16",
        "INC01 1.0 EV-XXX 0       FTS1301170001818412 CLYNDERVEN RD            TSTS3AAMB - W/ENGINE ASSIS                                             KIRKWOOD COVE       BRIARWOOD DR                           A01172013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S536    101/17/201314:49:41",
        "ID:FTS130117000181",
        "ADDR:8412 CLYNDERVEN RD",
        "SRC:TS",
        "UNIT:TS3A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:KIRKWOOD COVE & BRIARWOOD DR");

    doTest("T17",
        "INC01 1.0 EV-XXX 0       FTS130117000180S MADISON ST&PLAINFIELD RD    TSTS2AAMB - ROAD                                                                                                                  A01172013TS32  TGIncident Initiated By: TS/PANOCK,LISA                                           E541    101/17/201314:33:49",
        "ID:FTS130117000180",
        "ADDR:S MADISON ST & PLAINFIELD RD",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - ROAD");

    doTest("T18",
        "INC01 1.0 EV-XXX 0       FTS13011700017977 LAKE HINSDALE DR           TSTS2AAMB - W/ENGINE ASSIS                                             KYLE CT             LAKE HINSDALE DR                       A01172013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E541    101/17/201313:05:08",
        "ID:FTS130117000179",
        "ADDR:77 LAKE HINSDALE DR",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:KYLE CT & LAKE HINSDALE DR");

    doTest("T19",
        "INC01 1.0 EV-XXX 0       FTS1301170001787440 TENNESSEE                TSTS2AFIRE - VEHICLE                                                                                                              A01172013TS14  TAIncident Initiated By: TS/PANOCK,LISA                                           E521    201/17/201311:42:10",
        "ID:FTS130117000178",
        "ADDR:7440 TENNESSEE",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:FIRE - VEHICLE");

    doTest("T20",
        "INC01 1.0 EV-XXX 0       FTS1301160001776340 AMERICANA DR             TSTS2AAMB - W/ENGINE ASSIS               LAKE HINSDALE TOWER           63RD ST                                            605     A01162013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    101/16/201323:48:13",
        "ID:FTS130116000177",
        "ADDR:6340 AMERICANA DR",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "PLACE:LAKE HINSDALE TOWER",
        "X:63RD ST");

    doTest("T21",
        "INC01 1.0 EV-XXX 0       FTS1301160001765757 ALABAMA AV               TSTS4BSPECIAL DUTY                                                     57TH ST             58TH ST                            SO71A01162013TS61  TAIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A524    601/16/201321:43:29",
        "ID:FTS130116000176",
        "ADDR:5757 ALABAMA AV",
        "MADDR:5757 ALABAMA AVE",
        "SRC:TS",
        "UNIT:TS4B",
        "CALL:SPECIAL DUTY",
        "X:57TH ST & 58TH ST");

    doTest("T22",
        "INC01 1.0 EV-XXX 0       FTS13011600017511S370 IL 83                  TSTS3AAMB - W/ENGINE ASSIS               CLARK GAS STATION             BLUFF RD            99TH ST                            SO74A01162013TS34  TFIncident Initiated By: TS/JAKUBOSKY, MIKE                                       A534    101/16/201321:08:04",
        "ID:FTS130116000175",
        "ADDR:11S370 IL 83",  // Not mapping
        "SRC:TS",
        "UNIT:TS3A",
        "CALL:AMB - W/ENGINE ASSIS",
        "PLACE:CLARK GAS STATION",
        "X:BLUFF RD & 99TH ST");

    doTest("T23",
        "INC01 1.0 EV-XXX 0       FTS1301160001749S070 LAKE DR                 TSTS1BAMB - W/ENGINE ASSIS                                             N FRONTAGE RD       LAKE DR                            SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201317:51:24",
        "ID:FTS130116000174",
        "ADDR:9S070 LAKE DR",
        "SRC:TS",
        "UNIT:TS1B",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:N FRONTAGE RD & LAKE DR");

    doTest("T24",
        "INC01 1.0 EV-XXX 0       FTS1301160001731110 TAMARACK DR              TSTS2AAMB - W/ENGINE ASSIS                                             SEMINOLE DR         BEECHNUT LN                            A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201317:00:24",
        "ID:FTS130116000173",
        "ADDR:1110 TAMARACK DR",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:SEMINOLE DR & BEECHNUT LN");

    doTest("T25",
        "INC01 1.0 EV-XXX 0       FTS13011600017215W660 79TH ST                TSTS3AAMB - W/ENGINE ASSIS               M & M MARS                    LAKE RIDGE CLUB DR  S MADISON ST                           A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S536    101/16/201316:48:10",
        "ID:FTS130116000172",
        "ADDR:15W660 79TH ST",  // Not mapping
        "SRC:TS",
        "UNIT:TS3A",
        "CALL:AMB - W/ENGINE ASSIS",
        "PLACE:M & M MARS",
        "X:LAKE RIDGE CLUB DR & S MADISON ST");

    doTest("T26",
        "INC01 1.0 EV-XXX 0       FTS13011600017177 LAKE HINSDALE DR           TSTS2AAMB - W/ENGINE ASSIS                                             KYLE CT             LAKE HINSDALE DR               405     A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201315:26:16",
        "ID:FTS130116000171",
        "ADDR:77 LAKE HINSDALE DR",
        "SRC:TS",
        "UNIT:TS2A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:KYLE CT & LAKE HINSDALE DR");

    doTest("T27",
        "INC01 1.0 EV-XXX 0       FTS1301160001709S125 LAKE DR                 TSTS1BAMB - W/ENGINE ASSIS               STRATFORD GREEN               N FRONTAGE RD       LAKE DR                    21B 105 SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           S526    101/16/201314:45:16",
        "ID:FTS130116000170",
        "ADDR:9S125 LAKE DR",  // Not mapping
        "SRC:TS",
        "UNIT:TS1B",
        "CALL:AMB - W/ENGINE ASSIS",
        "PLACE:STRATFORD GREEN",
        "X:N FRONTAGE RD & LAKE DR");

    doTest("T28",
        "INC01 1.0 EV-XXX 0       FTS13011600016916W486 LAKE DRIVE             TSTS1BAMB - W/ENGINE ASSIS                                             LAKE DR             N FRONTAGE RD                      SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E511    101/16/201312:24:51",
        "ID:FTS130116000169",
        "ADDR:16W486 LAKE DRIVE", // Not mapping
        "SRC:TS",
        "UNIT:TS1B",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:LAKE DR & N FRONTAGE RD");

    doTest("T29",
        "INC01 1.0 EV-XXX 0       FTS1301160001688614 MEADOWBROOK DR           TSTS1AAMB - W/ENGINE ASSIS                                             83RD CT             CIRCLE AV                          SO74A01162013TS34  TFIncident Initiated By: TS/PANOCK,LISA                                           E511    101/16/201311:53:32",
        "ID:FTS130116000168",
        "ADDR:8614 MEADOWBROOK DR",
        "SRC:TS",
        "UNIT:TS1A",
        "CALL:AMB - W/ENGINE ASSIS",
        "X:83RD CT & CIRCLE AV");

  }
  
  @Test
  public void testVillaParkFire() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       FVF1301180001072 W ROOSEVELT RD                H2B OVERDOSE/INGESTION/PSIMONS RESTAURANT                                                                                                23M   MB                                                                                        2                  6121211 FVF130118000105VP",
        "ID:FVF130118000107",
        "ADDR:2 W ROOSEVELT RD",
        "UNIT:H2B",
        "CALL:OVERDOSE/INGESTION/P",
        "PLACE:SIMONS RESTAURANT",
        "CITY:VILLA PARK");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       FVF130118000106621 W VERMONT ST                H8A PSYCHIATRIC/SUICIDE                                                                                                                  25M   MB                                                                                        2                  6120994 FVF130118000104VP",
        "ID:FVF130118000106",
        "ADDR:621 W VERMONT ST",
        "UNIT:H8A",
        "CALL:PSYCHIATRIC/SUICIDE",
        "CITY:VILLA PARK");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       FVF130117000105525 S ARDMORE AV                H3A BREATHING PROBLEMS                                                                                                                   6M    MB                                                                                        2                  6119821 FVF130117000103VP",
        "ID:FVF130117000105",
        "ADDR:525 S ARDMORE AV",
        "MADDR:525 S ARDMORE AVE",
        "UNIT:H3A",
        "CALL:BREATHING PROBLEMS",
        "CITY:VILLA PARK");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       FVF130117000104632 W PLEASANT AV               H8A INVESTIGATIONS                                                                                                                       F600  ST                                                                                        3                  6119228 FVF130117000102VP",
        "ID:FVF130117000104",
        "ADDR:632 W PLEASANT AV",
        "MADDR:632 W PLEASANT AVE",
        "UNIT:H8A",
        "CALL:INVESTIGATIONS",
        "CITY:VILLA PARK");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       FVF1301170001031643 S MICHIGAN AV              H201DIABETIC PROBLEMS                                                                                                                    13M   MB                                                                                        2                  6118952 FVF130117000101VP",
        "ID:FVF130117000103",
        "ADDR:1643 S MICHIGAN AV",
        "MADDR:1643 S MICHIGAN AVE",
        "UNIT:H201",
        "CALL:DIABETIC PROBLEMS",
        "CITY:VILLA PARK");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       FVF13011700010210 W ROOSEVELT RD               H2B BACK PAIN (NON-TRAUMMOTEL 6                                                                                                          5M    MB                                                                                        2                  6118679 FVF130117000100VP",
        "ID:FVF130117000102",
        "ADDR:10 W ROOSEVELT RD",
        "UNIT:H2B",
        "CALL:BACK PAIN (NON-TRAUM",
        "PLACE:MOTEL 6",
        "CITY:VILLA PARK");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       FVF130117000101827 S EUCLID AV                 H1A SICK PERSON                                                                                                                          26M   MB                                                                                        2                  6118536 FVF130117000099VP",
        "ID:FVF130117000101",
        "ADDR:827 S EUCLID AV",
        "MADDR:827 S EUCLID AVE",
        "UNIT:H1A",
        "CALL:SICK PERSON",
        "CITY:VILLA PARK");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       FVF130116000100S ARDMORE AV&W ROOSEVELT RD     H2B INJURIES FROM AN ACC                                                                                                                 29PD  MB                                                                                        2                  6117695 FVF130116000098VP",
        "ID:FVF130116000100",
        "ADDR:S ARDMORE AV & W ROOSEVELT RD",
        "MADDR:S ARDMORE AVE & W ROOSEVELT RD",
        "UNIT:H2B",
        "CALL:INJURIES FROM AN ACC",
        "CITY:VILLA PARK");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       FVF130116000099400 E ROOSEVELT RD              H1B TRAUMATIC INJURIES  CASTLE CHEVROLET                                                                                                 30M   MB                                                                                        2                  6117562 FVF130116000097VP",
        "ID:FVF130116000099",
        "ADDR:400 E ROOSEVELT RD",
        "UNIT:H1B",
        "CALL:TRAUMATIC INJURIES",
        "PLACE:CASTLE CHEVROLET",
        "CITY:VILLA PARK");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       FVF130116000098425 E ST CHARLES RD             H5B INJURIES FROM AN ACC                                                                                                                 29PD  MB                                                                                        2                  6117265 FVF130116000096VP",
        "ID:FVF130116000098",
        "ADDR:425 E ST CHARLES RD",
        "UNIT:H5B",
        "CALL:INJURIES FROM AN ACC",
        "CITY:VILLA PARK");

  }
  
  @Test
  public void testItascaFire() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       FIF130118000083880 W THORNDALE AV              T673AUTOMATIC FIRE ALARMGIVAUDAN BUSINESS                                               ",
        "ID:FIF130118000083",
        "ADDR:880 W THORNDALE AV",
        "MADDR:880 W THORNDALE AVE",
        "UNIT:T673",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:GIVAUDAN BUSINESS");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       FIF130118000082645 COUNTRY CLUB LN             T673PSYCHIATRIC/SUICIDE                                                                 ",
        "ID:FIF130118000082",
        "ADDR:645 COUNTRY CLUB LN",
        "UNIT:T673",
        "CALL:PSYCHIATRIC/SUICIDE");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       FIF130118000081710 CIRCLE DR                   R2  SMOKE INVESTIGATION                                                                 ",
        "ID:FIF130118000081",
        "ADDR:710 CIRCLE DR",
        "UNIT:R2",
        "CALL:SMOKE INVESTIGATION");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       FIF130118000080520 W IRVING PARK RD            T663SICK PERSON         IFFD STATION 66                                                 ",
        "ID:FIF130118000080",
        "ADDR:520 W IRVING PARK RD",
        "UNIT:T663",
        "CALL:SICK PERSON",
        "PLACE:IFFD STATION 66");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       FIF130117000079440 S OAK ST                    T663AUTOMATIC FIRE ALARM                                                                ",
        "ID:FIF130117000079",
        "ADDR:440 S OAK ST",
        "UNIT:T663",
        "CALL:AUTOMATIC FIRE ALARM");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       FIF130116000078535 S ELM ST                    T667BREATHING PROBLEMS  FOREST VIEW REHABIL                                             ",
        "ID:FIF130116000078",
        "ADDR:535 S ELM ST",
        "UNIT:T667",
        "CALL:BREATHING PROBLEMS",
        "PLACE:FOREST VIEW REHABIL");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       FIF1301160000771445 NORWOOD AV                 T673AUTOMATIC FIRE ALARMNESTLE WILLY WONKA                                              ",
        "ID:FIF130116000077",
        "ADDR:1445 NORWOOD AV",
        "MADDR:1445 NORWOOD AVE",
        "UNIT:T673",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:NESTLE WILLY WONKA");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       FIF130115000076513 S CHERRY ST                 T663INVALID ASSIST                                                                      ",
        "ID:FIF130115000076",
        "ADDR:513 S CHERRY ST",
        "UNIT:T663",
        "CALL:INVALID ASSIST");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       FIF1301150000751301 E IRVING PARK RD           U693AUTOMATIC FIRE ALARMMCDONALDS                                                       ",
        "ID:FIF130115000075",
        "ADDR:1301 E IRVING PARK RD",
        "UNIT:U693",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:MCDONALDS");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       FIF130115000074301 E NORTH ST                  T677BACK PAIN (NON-TRAUMPEACOCK JR HIGH SCH                                             ",
        "ID:FIF130115000074",
        "ADDR:301 E NORTH ST",
        "UNIT:T677",
        "CALL:BACK PAIN (NON-TRAUM",
        "PLACE:PEACOCK JR HIGH SCH");

  }
  
  @Test
  public void testElmherstFire() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       FEF130118000252423 MELROSE...HILLSIDE              AUTO AID FIRE EQUIPMSTRUCTURE FIRE.                                                                                                  F700                                                                                            8                  6121745 FEF130118000256",
        "ID:FEF130118000252",
        "ADDR:423 MELROSE",
        "CALL:AUTO AID FIRE EQUIPM",
        "PLACE:STRUCTURE FIRE.");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       FEF130118000251112 FAIRLANE AV                 C6A CO DETECTOR (NO ILLN                                                                                                                 F502  ST                                                                                        8                  6121613 FEF130118000255EL",
        "ID:FEF130118000251",
        "ADDR:112 FAIRLANE AV",
        "MADDR:112 FAIRLANE AVE",
        "UNIT:C6A",
        "CALL:CO DETECTOR (NO ILLN",
        "CITY:ELMHURST");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       FEF130118000250220 S HAWTHORNE AV              C7A FALLS/BACK INJURIES                                                                                                                  17M   MB                                                                                        2                  6121234 FEF130118000254EL",
        "ID:FEF130118000250",
        "ADDR:220 S HAWTHORNE AV",
        "MADDR:220 S HAWTHORNE AVE",
        "UNIT:C7A",
        "CALL:FALLS/BACK INJURIES",
        "CITY:ELMHURST");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       FEF130118000249531 N VAN AUKEN ST              C2A ABDOMINAL PAIN/PROBL                                                                                                                 1M    MB                                                                                        2                  6121080 FEF130118000253EL",
        "ID:FEF130118000249",
        "ADDR:531 N VAN AUKEN ST",
        "UNIT:C2A",
        "CALL:ABDOMINAL PAIN/PROBL",
        "CITY:ELMHURST");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       FEF130118000248422 W 2ND ST                    C5A AUTOMATIC FIRE ALARM                                                                                                                 F500A FS                                                                                        4                  6121023 FEF130118000252EL",
        "ID:FEF130118000248",
        "ADDR:422 W 2ND ST",
        "UNIT:C5A",
        "CALL:AUTOMATIC FIRE ALARM",
        "CITY:ELMHURST");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       FEF130118000247583 N KENILWORTH AV             C2A CHEST PAIN                                                                                                                           10M   MA                                                                                        2                  6120962 FEF130118000251EL",
        "ID:FEF130118000247",
        "ADDR:583 N KENILWORTH AV",
        "MADDR:583 N KENILWORTH AVE",
        "UNIT:C2A",
        "CALL:CHEST PAIN",
        "CITY:ELMHURST");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       FEF130118000246387 N EMROY AV                  C4A FALLS/BACK INJURIES HODATP RESIDENCE                                                                                                 17M   MB                                                                                        2                  6120665 FEF130118000249EL",
        "ID:FEF130118000246",
        "ADDR:387 N EMROY AV",
        "MADDR:387 N EMROY AVE",
        "UNIT:C4A",
        "CALL:FALLS/BACK INJURIES",
        "PLACE:HODATP RESIDENCE",
        "CITY:ELMHURST");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       FEF1301180002453N545 CROWN RD                  C2A INVESTIGATIONS                                                                                                                       F600  ST                                                                                        3                  6120639 FEF130118000248EL",
        "ID:FEF130118000245",
        "ADDR:3N545 CROWN RD",
        "UNIT:C2A",
        "CALL:INVESTIGATIONS",
        "CITY:ELMHURST");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       FEF130118000244N IL 83&W LAKE ST               C3B TRAFFIC ACCIDENTS                                                                                                                    29M   MA                                                                                        2                  6120440 FEF130118000247EL",
        "ID:FEF130118000244",
        "ADDR:N IL 83 & W LAKE ST",
        "UNIT:C3B",
        "CALL:TRAFFIC ACCIDENTS",
        "CITY:ELMHURST");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       FEF1301180002431150 S EUCLID AV                C12BBREATHING PROBLEMS  PARK PLACE OF EL                                                                                                 6M    MA                                                                                        2                  6120242 FEF130118000246EL",
        "ID:FEF130118000243",
        "ADDR:1150 S EUCLID AV",
        "MADDR:1150 S EUCLID AVE",
        "UNIT:C12B",
        "CALL:BREATHING PROBLEMS",
        "PLACE:PARK PLACE OF EL",
        "CITY:ELMHURST");

  }
  
  @Test
  public void testVillaParkPolice() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       LVP130119001667121 S VILLA AV                VPVP05BAR CHECK                                                        GREAT WESTERN TR    E KENILWORTH AV     AV_60          218HA011920139111    Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V2     701/19/201300:41:506121845",
        "ID:LVP130119001667",
        "ADDR:121 S VILLA AV",
        "MADDR:121 S VILLA AVE",
        "SRC:VP",
        "UNIT:VP05",
        "CALL:BAR CHECK",
        "X:GREAT WESTERN TR & E KENILWORTH AV");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       LVP1301190016641250 S ARDMORE AV             VPVP03BUILDING CHECK  (OFF               WILLOWBROOK HS 8063           W HIGH RIDGE RD     E RIORDAN RD        BA_58          312HA011920139022    Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V31    701/19/201300:32:036121834",
        "ID:LVP130119001664",
        "ADDR:1250 S ARDMORE AV",
        "MADDR:1250 S ARDMORE AVE",
        "SRC:VP",
        "UNIT:VP03",
        "CALL:BUILDING CHECK  (OFF",
        "PLACE:WILLOWBROOK HS 8063",
        "X:W HIGH RIDGE RD & E RIORDAN RD");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       LVP130119001662DD                            VP    BAR CHECK                                                                                                                   A011920139111    Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V2     701/19/201300:27:046121830",
        "ID:LVP130119001662",
        "ADDR:DD",
        "SRC:VP",
        "CALL:BAR CHECK");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       LVP130119001660537 S VILLA AV                VPVP05EXCESSIVE NOISE                                                  E HIGHLAND AV       E WASHINGTON ST     AW_60          224HA01192013EN      Incident Initiated By: DC/KLEIN,JEFFREY                                         3V2     601/19/201300:16:156121811",
        "ID:LVP130119001660",
        "ADDR:537 S VILLA AV",
        "MADDR:537 S VILLA AVE",
        "SRC:VP",
        "UNIT:VP05",
        "CALL:EXCESSIVE NOISE",
        "X:E HIGHLAND AV & E WASHINGTON ST");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       LVP130118001655308 W DIVISION ST             VPVP04ASSIST OTHER AGENCY                                              N MICHIGAN AV       N WISCONSIN AV      AU_56          203HA01182013AOA     Incident Initiated By: DC/HUNSAKER,MADELINE                                     3V20    701/18/201323:42:166121747",
        "ID:LVP130118001655",
        "ADDR:308 W DIVISION ST",
        "SRC:VP",
        "UNIT:VP04",
        "CALL:ASSIST OTHER AGENCY",
        "X:N MICHIGAN AV & N WISCONSIN AV");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       LVP130118001652455 N HARVARD AV              VPVP01SUSPICIOUS PERSON                                                W VERMONT ST        W PLYMOUTH ST       AT_57          123HA01182013SP      Incident Initiated By: DC/DOBSON,DIANA                                          3V1     501/18/201323:29:216121725",
        "ID:LVP130118001652",
        "ADDR:455 N HARVARD AV",
        "MADDR:455 N HARVARD AVE",
        "SRC:VP",
        "UNIT:VP01",
        "CALL:SUSPICIOUS PERSON",
        "X:W VERMONT ST & W PLYMOUTH ST");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       LVP130118001650E NORTH AV&N ELLSWORTH AV     VPVP01ASSIST OTHER AGENCY                                                                                      AS_59          109HA01182013AOA     Incident Initiated By: DC/HUNSAKER,MADELINE                                     2V112   701/18/201323:15:056121701",
        "ID:LVP130118001650",
        "ADDR:E NORTH AV & N ELLSWORTH AV",
        "MADDR:E NORTH AVE & N ELLSWORTH AVE",
        "SRC:VP",
        "UNIT:VP01",
        "CALL:ASSIST OTHER AGENCY");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       LVP13011800164440 S ARDMORE AV               VPVP05CITIZEN ASSIST                     VPPD                          W HOME AV           GREAT WESTERN TR    AV_58          208HA01182013CA      Incident Initiated By: DC/GARDINER,HEATHER                                      3V20    701/18/201322:58:186121661",
        "ID:LVP130118001644",
        "ADDR:40 S ARDMORE AV",
        "MADDR:40 S ARDMORE AVE",
        "SRC:VP",
        "UNIT:VP05",
        "CALL:CITIZEN ASSIST",
        "PLACE:VPPD",
        "X:W HOME AV & GREAT WESTERN TR");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       LVP130118001642324 N ILLINOIS                VP    OVERNIGHT PARKER                                                                                                            A01182013ONP     Incident Initiated By: VP/TAUSCHER,ALBERTA                                      2V19    901/18/201322:40:346121635",
        "ID:LVP130118001642",
        "ADDR:324 N ILLINOIS",
        "SRC:VP",
        "CALL:OVERNIGHT PARKER");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       LVP130118001641240 E ROOSEVELT RD            VP    ASSIST OTHER AGENCY                LAZYBOY                       S HAMMERSCHMIDT AV  S STEWART AV        BB_51          170FA01182013AOA     Incident Initiated By: DC/HUNSAKER,MADELINE                                     2V26    701/18/201322:28:216121598",
        "ID:LVP130118001641",
        "ADDR:240 E ROOSEVELT RD",
        "SRC:VP",
        "CALL:ASSIST OTHER AGENCY",
        "PLACE:LAZYBOY",
        "X:S HAMMERSCHMIDT AV & S STEWART AV");

  }
  
  @Test
  public void testRosellePolice() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       LRO130118001308231 E IRVING PARK RD          RORO02SUSPICIOUS VEHICLE                 FAMILY PRIDE LAUNDRY          N PARK ST           LAWRENCE AV         AC_39          DUCOA011820139101    Incident Initiated By: DC/DOBSON,DIANA                                          2R2     501/18/201323:56:556121780",
        "ID:LRO130118001308",
        "ADDR:231 E IRVING PARK RD",
        "SRC:RO",
        "UNIT:RO02",
        "CALL:SUSPICIOUS VEHICLE",
        "PLACE:FAMILY PRIDE LAUNDRY",
        "X:N PARK ST & LAWRENCE AV");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       LRO130118001304100 N PARK CT                 RORO01CITIZEN ASSIST                                                   E HATTENDORF AV                         AC_38          DUCOA01182013CA      Incident Initiated By: DC/MOOI,JESSICA                                          3R90    701/18/201323:42:076121743",
        "ID:LRO130118001304",
        "ADDR:100 N PARK CT",
        "SRC:RO",
        "UNIT:RO01",
        "CALL:CITIZEN ASSIST",
        "X:E HATTENDORF AV");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       LRO130118001301Z4 LAKE ST                    RO    BUILDING CHECK  (OFF                                                                                                        A011820139022    Incident Initiated By: RO/COOK,TIM                                              2R4     701/18/201323:32:076121731",
        "ID:LRO130118001301",
        "ADDR:Z4 LAKE ST",
        "SRC:RO",
        "CALL:BUILDING CHECK  (OFF");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       LRO130118001292601 PLUM GROVE RD             RORO01SEX OFFENSE - GENERA               THE MOORINGS                  OREGON TR           CROSS CREEK CT      AA_41              A01182013SEX     Incident Initiated By: DC/SATALA,GEORGE                                         2R1     501/18/201322:02:006121556",
        "ID:LRO130118001292",
        "ADDR:601 PLUM GROVE RD",
        "SRC:RO",
        "UNIT:RO01",
        "CALL:SEX OFFENSE - GENERA",
        "PLACE:THE MOORINGS",
        "X:OREGON TR & CROSS CREEK CT");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       LRO130118001283500 W BRYN MAWR AV            RORO03SUSPICIOUS PERSON                  LAKE PARK HS WEST             WEST END RD         PEARSON DR          AE_35          DUCOA01182013SP      Incident Initiated By: DC/WYATT,TIANA                                           2R3     501/18/201320:48:226121433",
        "ID:LRO130118001283",
        "ADDR:500 W BRYN MAWR AV",
        "MADDR:500 W BRYN MAWR AVE",
        "SRC:RO",
        "UNIT:RO03",
        "CALL:SUSPICIOUS PERSON",
        "PLACE:LAKE PARK HS WEST",
        "X:WEST END RD & PEARSON DR");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       LRO130118001282GUN DR                        RO    BUILDING CHECK  (OFF                                                                                                        A011820139022    Incident Initiated By: RO/COOK,TIM                                              2R4     701/18/201320:44:536121428",
        "ID:LRO130118001282",
        "ADDR:GUN DR",
        "SRC:RO",
        "CALL:BUILDING CHECK  (OFF");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       LRO130118001280222 PARK LN                   RORO01INFORMATION ONLY                                                 N PARK CT           PARK LN             AC_39          DUCOO01182013INFO    Incident Initiated By: DC/TURANO,NICHOLAS                                       2R90    701/18/201320:01:216121350",
        "ID:LRO130118001280",
        "ADDR:222 PARK LN",
        "SRC:RO",
        "UNIT:RO01",
        "CALL:INFORMATION ONLY",
        "X:N PARK CT & PARK LN");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       LRO130118001279103 S PROSPECT                RORO02THIS IS A TEST TICKE               ROPD                          E ELM ST            ALLEY               AD_38          DUCOA01182013TEST    Incident Initiated By: DC/TURANO,NICHOLAS                                       2R1     901/18/201319:11:346121272",
        "ID:LRO130118001279",
        "ADDR:103 S PROSPECT",
        "SRC:RO",
        "UNIT:RO02",
        "CALL:THIS IS A TEST TICKE",
        "PLACE:ROPD",
        "X:E ELM ST & ALLEY");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       LRO130118001278525 S SPRING                  RORO02NEIGHBOR OR TENANT D                                             BERKSHIRE TER       ORCHARD TER         AE_39          DUCOA01182013NDR     Incident Initiated By: DC/GLOVER, MARISA                                        2R2     901/18/201318:55:526121253",
        "ID:LRO130118001278",
        "ADDR:525 S SPRING",
        "SRC:RO",
        "UNIT:RO02",
        "CALL:NEIGHBOR OR TENANT D",
        "X:BERKSHIRE TER & ORCHARD TER");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       LRO130118001276226 PARK LN                   RORO01WATER MAIN BREAK/WAT                                             N PARK CT           PARK LN             AC_39          DUCOA01182013WATR    Incident Initiated By: DC/BAIRD,JAMIE                                           2R90    701/18/201318:25:106121213",
        "ID:LRO130118001276",
        "ADDR:226 PARK LN",
        "SRC:RO",
        "UNIT:RO01",
        "CALL:WATER MAIN BREAK/WAT",
        "X:N PARK CT & PARK LN");

  }
  
  @Test
  public void testWestChicagoFire() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       FWG130118000137545 BELMONT LN                  B293GEN - FIRES (HIGH PRBELMONT VILLAGE                                                                                                  F100  10                                                                                        3                  6121508 FCR130118000197CS",
        "ID:FWG130118000137",
        "ADDR:545 BELMONT LN",
        "UNIT:B293",
        "CALL:GEN - FIRES (HIGH PR",
        "PLACE:BELMONT VILLAGE",
        "CITY:CAROL STREAM");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       FWG130118000136421 N OAK AV                    I063CO DETECTOR (NO ILLN                                                                                                                 F502  52                                                                                        8                  6121502 FWG130118000143WC",
        "ID:FWG130118000136",
        "ADDR:421 N OAK AV",
        "MADDR:421 N OAK AVE",
        "UNIT:I063",
        "CALL:CO DETECTOR (NO ILLN",
        "CITY:WEST CHICAGO");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       FWG130118000135421 N OAK AV                    I063ALARM INVESTIGATION                                                                                                                  F501  51                                                                                        8                  6121308 FWG130118000142WC",
        "ID:FWG130118000135",
        "ADDR:421 N OAK AV",
        "MADDR:421 N OAK AVE",
        "UNIT:I063",
        "CALL:ALARM INVESTIGATION",
        "CITY:WEST CHICAGO");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       FWG13011800013329W054 GENEVA RD                I063UNKNOWN PROBLEM (MAN                                                                                                                 32M   M1                                                                                        2                  6120967 FWG130118000140WC",
        "ID:FWG130118000133",
        "ADDR:29W054 GENEVA RD",
        "UNIT:I063",
        "CALL:UNKNOWN PROBLEM (MAN",
        "CITY:WEST CHICAGO");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       FWG130118000132202 W GRAND LAKE BL             I063FALLS/BACK INJURIES                                                                                                                  17M   M1                                                                                        2                  6120788 FWG130118000139WC",
        "ID:FWG130118000132",
        "ADDR:202 W GRAND LAKE BL",
        "UNIT:I063",
        "CALL:FALLS/BACK INJURIES",
        "CITY:WEST CHICAGO");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       FWG13011800013129W054 GENEVA RD                I063UNKNOWN PROBLEM (MANROHR,WAYNE 6302313209                                                                                            32M   M1                                                                                        2                  6120645 FWG130118000138WC",
        "ID:FWG130118000131",
        "ADDR:29W054 GENEVA RD",
        "UNIT:I063",
        "CALL:UNKNOWN PROBLEM (MAN",
        "PLACE:ROHR,WAYNE 6302313209",
        "CITY:WEST CHICAGO");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       FWG1301180001301213 JOLIET ST                  I074AUTOMATIC FIRE ALARMWC CENTER TX8477067150                                                                                           F500C 5C                                                                                        4                  6120531 FWG130118000137WC",
        "ID:FWG130118000130",
        "ADDR:1213 JOLIET ST",
        "UNIT:I074",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:WC CENTER TX8477067150",
        "CITY:WEST CHICAGO");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       FWG130118000129650 W FOREST AV                 I073AUTOMATIC FIRE ALARMTOWN AND COUNTRY APTS                                                                                            F500B 5B                                                                                        4                  6120391 FWG130118000136WC",
        "ID:FWG130118000129",
        "ADDR:650 W FOREST AV",
        "MADDR:650 W FOREST AVE",
        "UNIT:I073",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:TOWN AND COUNTRY APTS",
        "CITY:WEST CHICAGO");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       FWG1301180001281800 W HAWTHORNE LN             I078AUTOMATIC FIRE ALARMLAGROU                                                                                                           F500C 5C                                                                                        4                  6120274 FWG130118000135WC",
        "ID:FWG130118000128",
        "ADDR:1800 W HAWTHORNE LN",
        "UNIT:I078",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:LAGROU",
        "CITY:WEST CHICAGO");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       FWG1301180001271228 KINGS CIR                  I054STROKE/ (CVA)       SOUTH BLDG APT 301                                                                                               28M   M2                                                                                        2                  6120221 FWG130118000134WC",
        "ID:FWG130118000127",
        "ADDR:1228 KINGS CIR",
        "UNIT:I054",
        "CALL:STROKE/ (CVA)",
        "PLACE:SOUTH BLDG APT 301",
        "CITY:WEST CHICAGO");
 
  }
  
  @Test
  public void testDUCOMM() {

    doTest("T1",
        "INC01 1.0 EV-XXX 0       FGS130507000758E FULLERTON AV&BLOOMINGDALE RD  N594TRAUMATIC INJURIES  CAMERA PARK                                                                                                      30M   M2                                                                                        2                  6305786 FGS130507000778GL2013-05-07 20:24:21.",
        "ID:FGS130507000758",
        "ADDR:E FULLERTON AV & BLOOMINGDALE RD",
        "MADDR:E FULLERTON AVE & BLOOMINGDALE RD",
        "UNIT:N594",
        "CALL:TRAUMATIC INJURIES",
        "PLACE:CAMERA PARK",
        "CITY:GLENDALE HEIGHTS");

    doTest("T2",
        "INC01 1.0 EV-XXX 0       FWT130507001879502 S WOODLAWN ST               K383FALLS/BACK INJURIES                                                                                                                  17M   M1                                                                                        2                  6305779 FWT130507001757WH2013-05-07 20:22:50.",
        "ID:FWT130507001879",
        "ADDR:502 S WOODLAWN ST",
        "UNIT:K383",
        "CALL:FALLS/BACK INJURIES",
        "CITY:WHEATON");

    doTest("T3",
        "INC01 1.0 EV-XXX 0       FBR130507001287235 N HALE AV                   A013CHEST PAIN                                                                                                                           10M   M2                                                                                        2                  6305768 FBR130507001278BA2013-05-07 20:15:25.",
        "ID:FBR130507001287",
        "ADDR:235 N HALE AV",
        "MADDR:235 N HALE AVE",
        "UNIT:A013",
        "CALL:CHEST PAIN",
        "CITY:BARTLETT");

    doTest("T4",
        "INC01 1.0 EV-XXX 0       FDW1305070008757512 ORCHARD LN                 S12 AUTOMATIC FIRE ALARMDYNASTY POINT APARTMENTS                                                                                         F500B FS                                                                                        4                  6305746 FDW130507000893WO2013-05-07 20:04:25.",
        "ID:FDW130507000875",
        "ADDR:7512 ORCHARD LN",
        "UNIT:S12",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:DYNASTY POINT APARTMENTS",
        "CITY:WOODRIDGE");

    doTest("T5",
        "INC01 1.0 EV-XXX 0       FLW130507002270613 INVERNESS RD                M510OVERDOSE/INGESTION/P                                                                                                                 23M   M1                                                                                        2                  6305739 FLW130507002272LI2013-05-07 20:00:11.",
        "ID:FLW130507002270",
        "ADDR:613 INVERNESS RD",
        "UNIT:M510",
        "CALL:OVERDOSE/INGESTION/P",
        "CITY:LISLE");

    doTest("T6",
        "INC01 1.0 EV-XXX 0       FBR130507001286KATHY LN&LITTLE JOHN CT         A014PSYCHIATRIC/SUICIDE                                                                                                                  25M   M1                                                                                        2                  6305724 FBR130507001277BA2013-05-07 19:49:16.",
        "ID:FBR130507001286",
        "ADDR:KATHY LN & LITTLE JOHN CT",
        "UNIT:A014",
        "CALL:PSYCHIATRIC/SUICIDE",
        "CITY:BARTLETT");

    doTest("T7",
        "INC01 1.0 EV-XXX 0       FGS130507000757780 E NORTH AV                  N594ALARM INVESTIGATION RAMADA INN 2812                                                                                                  F501  51                                                                                        8                  6305707 FGS130507000777GL2013-05-07 19:39:28.",
        "ID:FGS130507000757",
        "ADDR:780 E NORTH AV",
        "MADDR:780 E NORTH AVE",
        "UNIT:N594",
        "CALL:ALARM INVESTIGATION",
        "PLACE:RAMADA INN 2812",
        "CITY:GLENDALE HEIGHTS");

    doTest("T8",
        "INC01 1.0 EV-XXX 0       FVF130507000894742 S ILLINOIS AV               H1A BREATHING PROBLEMS                                                                                                                   6M    MB                                                                                        2                  6305687 FVF130507000873VP2013-05-07 19:29:00.",
        "ID:FVF130507000894",
        "ADDR:742 S ILLINOIS AV",
        "MADDR:742 S ILLINOIS AVE",
        "UNIT:H1A",
        "CALL:BREATHING PROBLEMS",
        "CITY:VILLA PARK");

    doTest("T9",
        "INC01 1.0 EV-XXX 0       FBR130507001285409 LELA LN                     A014AUTOMATIC FIRE ALARMAHMED/6303730704                                                                                                 F500A 5A                                                                                        4                  6305670 FBR130507001276BA2013-05-07 19:14:35.",
        "ID:FBR130507001285",
        "ADDR:409 LELA LN",
        "UNIT:A014",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:AHMED/6303730704",
        "CITY:BARTLETT");

    doTest("T10",
        "INC01 1.0 EV-XXX 0       FEF130507001849681 W NORTH AV                  C50BOUTSIDE FIRE        DIPLOMAT WEST BANQUET HALLS                                                                                      F102  ST                                                                                        3                  6305657 FEF130507001841EL2013-05-07 19:08:10.",
        "ID:FEF130507001849",
        "ADDR:681 W NORTH AV",
        "MADDR:681 W NORTH AVE",
        "UNIT:C50B",
        "CALL:OUTSIDE FIRE",
        "PLACE:DIPLOMAT WEST BANQUET HALLS",
        "CITY:ELMHURST");
  
  }

  public static void main(String[] args) {
    new ILDuPageCountyParserTest().generateTests("T1");
  }
}