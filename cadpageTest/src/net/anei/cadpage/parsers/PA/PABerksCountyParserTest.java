package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PABerksCountyParser;

import org.junit.Test;

/*
Berks County, PA (replace)
Contact: "john.manmiller" <john.manmiller@gmail.com>
Contact: "kreinert@lyons35fire.com" <kreinert@lyons35fire.com>
Contact: Diana York <hawkmeadow@gmail.com>
Contact: Duane Good <duaneg123@gmail.com>
Contact: "jamesmiller4525@gmail.com" <jamesmiller4525@gmail.com>
Contact: "thirty5tripleuno@yahoo.com" <thirty5tripleuno@yahoo.com>
Contact: 4843343577@messaging.sprintpcs.com
Contact: Mike Roth <mroth@springtwpberks.org>
Contact: VJ GREEK <vjgreek@gmail.com>
Contact: Buddy <fwardiv@gmail.com>
Contact: Phoenix <aphoenixrising13@gmail.com>
Contact: Todd Evans <tme5904@gmail.com>
Sender: @berks.alertpa.org,@rsix.roamsecure.net,14100
Unit:M590A Status:Dispatched ALS MEDICAL ; 215 TOWER RD ; ; S PARK AVE / CLAY RD ; Muni: LONGSWAMP ; 64 YOM / IN ACTIVE SIEZURE  ; 07/10/12 12:57
Unit:M590B Status:Dispatched MVAUNK ; W MAIN ST NORMAL AVE ; ; ; Muni: KUTZTOWN ; ; 07/10/12 14:06
Unit:M535A Status:Dispatched ALS MEDICAL ; 281 MOSELEM CHURCH RD ; ; SCHWOYER RD / MISTY LN ; Muni: RICHMOND ; 79 YOF/VOMITING/COUGHING/PAIN IN SIDE ; 07/11/12 10:04 Sent by Berks County RSAN to Fleetwood EMS All CALL -- You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org
Unit:M535A Status:Dispatched ALS MEDICAL ; 224 FAITH DR ; ; GENESIS DR, HOPE DR / HOPE DR ; Muni: MAIDENCREEK ; 39YOM/NOT MAKING SENSE/LAYING ON THE FL ; 07/11/12 21:59 Sent by Berks County RSAN to Fleetwood EMS All CALL -- You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org
Unit:585A Status:Dispatched MVAWITH ; 2330 INTERSTATE 78 E ; I78 MP 23.3 EB; UNKNOWN / RAMP B7 ; Muni: UPPER BERN ; 2 vehs/ ILVER SEDAN / UNK INJS / TX TO PSP  ; 07/11/12 16:33 On Jul 11, 2012 5:55 PM, "Ken Corbin" <ken@cadpage.org> wrote:
Unit:M590A Status:Dispatched MVAWITH ; S BALDY ST TREXLER AVE ; ; ; Muni: KUTZTOWN ; ; 07/11/12 07:10
Unit:M590A Status:Dispatched BLS MEDICAL ; 625 SPRING ST ; PENNSYLVANIA DIALYSIS; CROSSING DR / N 6 ST ; Muni: WYOMISSING ; ; 07/10/12 19:58
Unit:M590B Status:Dispatched MVAUNK ; W MAIN ST NORMAL AVE ; ; ; Muni: KUTZTOWN ; ; 07/10/12 14:06
Unit:R27 Status:Dispatched MVAUNK ; ROUTE 183 MILL RD ; ; ; Muni: UPPER TULPEHOCKEN ; ; 07/12/12 04:48
Unit:535A Status:Dispatched BLS TRAUMA ; 2 W PINE ST ; ; S FRANKLIN ST, E PINE ST /NEW ALY ; Muni: FLEETWOOD ; 79 YOM FELL IN THE DRIVEWAY ; 07/11/12 14:13
Unit:M590A Status:Dispatched ALS MEDICAL ; 7723 HAMILTON BLVD ; ; ; Muni: ; UPPERMACUNGIE TWP- LEHIGH CO/ ; 07/11/12 21:51
Unit:M590A Status:Dispatched ALS MEDICAL ; 1107 APEX AVE ; ; UNKNOWN / LIFESTYLE LN ; Muni: MAXATAWNY ; 20ish yof layin on ground /is cons ; 07/11/12 20:41
Unit:M590A Status:Dispatched ALS TRAUMA ; 15620 KUTZTOWN RD ; ; UNKNOWN / CHURCH RD ; Muni: MAXATAWNY ; 10 YOF FELL FROM A WINDOW  UNCONS ; 07/12/12 12:38
Unit:M590A Status:Dispatched BLS MEDICAL ; 247 RHOADES RD ; ; NUNEMAKER RD / ROTH RD ; Muni: GREENWICH ; RESPONDING FOR BLSMED ; 07/12/12 15:14
Unit:M590A Status:Dispatched LIFT ASSIST ; 35 S WHITEOAK ST SHADE RES ; ; SANDER ALY, N WHITEOAK ST / NORMAL AVE ; Muni: KUTZTOWN ; 74YOM FELL NOT INJ JUST NEEDS HELP GETTING UP ; 07/12/12 17:38
Unit:M590A Status:Dispatched BLS MEDICAL ; 247 RHOADES RD ; ; NUNEMAKER RD / ROTH RD ; Muni: GREENWICH ; RESPONDING FOR BLSMED ; 07/12/12 15:14
Unit:M590A Status:Dispatched ALS TRAUMA ; 15620 KUTZTOWN RD ; ; UNKNOWN / CHURCH RD ; Muni: MAXATAWNY ; 10 YOF FELL FROM A WINDOW  UNCONS ; 07/12/12 12:38
Unit:CO61 Status:Dispatched CMA ; 303 WYNDCLIFFE AVE ; ; HILLTOP CT / CHESTNUT ST, WINTERSON DR ; Muni: HAMBURG ;
Unit:CO61 Status:Dispatched AFA ; 218 PINE ST ; ; S PEACH ALY / S 2 ST ; Muni: HAMBURG ; ; 07/12/12 06:37
Unit:CO85 Status:Dispatched MVAWITH ; 1780 ACORN DR ; ; TIMBER LN / GRAVEL HILL DR ; Muni: SPRING ; FM SCREAMING SHE IS BLEEDING/  ; 07/12/12 02:03\n\nSent by Berks County RSAN to CO85 All Call
Unit:E85-2 Status:Dispatched HAZMAT ; 2227 MCKINLEY AVE ; ; UNKNOWN / WEST WYOMISSING BLVD ; Muni: SPRING ; CHF85 AND E85-2 EN FOR ODOR OF GASOLINE IN RESIDENCE ; 07/11/12 10:07\n\nSent by Berks County RSAN to CO85 All Call
Unit:REN85 Status:Dispatched SF ; 44 WATER ST ; ; POTTSVILLE PKE / N 5 STREET HWY ; Muni: MUHLENBERG ; elderly fm / not answering questions  ; 07/12/12 00:54\n\nSent by Berks County RSAN to CO85 All Call
Unit:R1 Status:Dispatched MVAUNK ; OAK LN / RICHMOND ST ; ; ; Muni: LOWER ALSACE ; mc into ditch / on oak ln / ; 07/12/12 12
FRM: \nSUBJ:1/2\nMSG:Unit:CO13 Status:Dispatched AFA ; 2525 N 12 ST BLDG 30 STONEPOINT CENTER ; ; WESTERN ELECTRIC DR / DEAD END ; MUHLENBERG ;  
Unit:M590A Status:Dispatched BLS TRAUMA ; 111 HARTMAN RD ; ; UNKNOWN / UNKNOWN ; MAXATAWNY ; 65 YOM / TRIPPED AND FELL / HIT HEAD / MINOR BLEEDING ; 05/17/13 08:37
Unit:590T Status:Dispatched ALS MEDICAL ; 211 FISHER LN ; ; UNKNOWN / KLINES CORNER RD ; MAXATAWNY ; 85YOF /POSS STROKE /LE

Contact: Active911
(berks.co85@rsix.roamsecure.net) Unit:CO85 Status:Dispatched MF ; 828 BLUE GATE LN ; ; PERSIMMON DR / HEARTHSTONE LN ; Muni: SPRING ; ; 07/13/12 14:09 Sent by Berks County RSAN to CO85 All Call -- You received this message because you registered on Alert Berks. 
[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched BLS MEDICAL ; 1320 BROADCASTING RD ; ; MERIDIAN BLVD / CONNEL DR ; Muni: SPRING ; RESPONDING FOR BLS MED / DIRECT CALL TO STATION / NFI ; 07/12/12 15:18\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched ALS MEDICAL ; 3121 STATE HILL RD RM17 ; COLUMBIA COTTAGE; YERGER BLVD, WESTBURY DR / LELAND WAY ; Muni: SPRING ; FEMALE CHEST PAIN  ; 07/12/12 15:19\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched CLASS 4 MENTAL ; 107 S 5 ST ROOM 5 ; ; FRANKLIN ST / CHESTNUT ST ; Muni: READING ; FEELING SUICIDAL ; 07/12/12 19:20\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650I Status:Dispatched ALS MEDICAL ; 404 S CHURCH ST ROOM 1 ; GOLDEN RIDGE; PATTERSON DR / PATTERSON DR ; Muni: ROBESONIA ; 88 YOF/ POS TIA ; 07/12/12 19:59\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched ALS MEDICAL ; 1802 TULPEHOCKEN RD RM 277 ; ; UNKNOWN / KISSINGER LN ; Muni: WYOMISSING ; 88 YOF/  ; 07/12/12 21:28\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650I Status:Dispatched ALS MEDICAL ; 101 E FRONT ST ; ; S MAIN ST, N MAIN ST / N WOLF ST ; Muni: BERNVILLE ; 63YOM LABORED BREATHING ; 07/12/12 22:17\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 3012 SUSANNA DR ; ; DANIEL DR / KATHARINE DR ; Muni: SPRING ; ALS ; 07/12/12 22:34\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched DOMESTIC INJURY ; 654 ANNE DR ; ; UNKNOWN / CHRISTOPHER DR ; Muni: WERNERSVILLE ; COMP VS EX HUSB OF GIRLFRIEND/  ; 07/12/12 22:45\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:650T Status:Dispatched CLASS 4 MENTAL ; 4050 CONRAD WEISER PRKWY 4 ; ; MARION DR / SHERIDAN RD ; Muni: MARION ; 21YOF/NEEDS TO BE 302 ; 07/12/12 23:37\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched ALS MEDICAL ; 511 HUNTERS RD ; ; UNKNOWN / UNKNOWN ; Muni: CUMRU ; 76YOM/ BLOOD SUGAR 35/  ; 07/12/12 23:52\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 350 SPORTSMAN RD ; WERNERSVILLE STATE HOSPITAL; WSH ORCHARD RD / WSH MAIN ST ; Muni: SOUTH HEIDELBERG ; 26YOM COUGHING UP BLOOD ; 07/13/12 00:01\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched BLS MEDICAL ; 517 OAK HILL LN ; ; UNKNOWN / UNKNOWN ; Muni: SPRING ; 84 YOF VOMITTING ; 07/13/12 00:51\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 135 BALTHASER RD ; ; N ARTHUR DR, S ARTHUR DR / PRESTON RD ; Muni: SOUTH HEIDELBERG ; 42YOF/ COMP IS PT/  ; 07/13/12 06:39\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650E Status:Enroute BLS MEDICAL ; 1801 CAMBRIDGE AVE D20 ; TENNIS PARK CONDOS; OLD MILL RD / LAUERS LN ; Muni: WYOMISSING ; ; 07/13/12 08:05\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 2701 NORTH MERIDIAN BLVD ; IHOP; BROADCASTING RD / MERIDIAN BLVD ; Muni: SPRING ; ML IN 20'S HAVING SEIZURE ; 07/13/12 10:25\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched ALS MEDICAL ; 1863 LINCOLN AVE VINCENT BECKER RES ; ; BRANDYWINE RD / BRANDYWINE CT ; Muni: WYOMISSING ; 92 YOM ARM IS NUMB/RIGHT EYE DROOPY ; 07/13/12 11:20\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched CLASS 4 MENTAL ; 13 BIRCHWOOD RD ; ; LARCHWOOD RD, CEDARWOOD RD / LARCHWOOD RD ; Muni: WYOMISSING ; sam crisis ; 07/13/12 11:30\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650I Status:Dispatched ALS MEDICAL ; 356 S FREEMAN ST ; ; E MEADOW AVE / W FREEMAN ST, FURNACE ST ; Muni: ROBESONIA ; 90 YOF / VERY WEAK / DEHYDRATED  ; 07/13/12 12:06\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched ALS MEDICAL ; 310 STITZER AVE ; ; E WILSON AVE, W WILSON AVE / E NORMAN ST, W NORMAN ST ; Muni: WERNERSVILLE ; 88 YOM NOT RESPONDING WELL ; 07/13/12 12:40\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n
[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched BLS TRAUMA ; 2912 STATE HILL RD APT B3 ; ; No Cross Streets Found ; Muni: SPRING ; BERKSHIRE ESTATES APTS ; 07/13/12 13:43\nSent by Berks County RSAN to Western Berks EMS All CALL\n--\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n

Contact: Gary Brady <ggbrady@verizon.net>
Contact: KURT REINERT <kurtreinert@gmail.com>
Contact: "courey21142" <courey21142@aol.com>
Contact: Buddy <fwardiv@gmail.com>
Contact: Brian Fisher <berksffemt5555@gmail.com>
Contact: Kyle <phileagles3669@yahoo.com>
Contact: Ryan Glahn <gville.co56@gmail.com>
Sender: @berks.alertpa.org,12101

Unit:B42 Status:Dispatched BF ; 100 BLIMLINE RD BLOCK ; ; DEAD END / DEER CREEK RD ; SPRING ; ; 09/01/12 07:51
Subject:1/2\nUnit:M590A Status:Dispatched ALS MEDICAL ; 120 TREXLER AVE RM 114 ; KUTZTOWN MANOR; LENNI ST / CONSTITUTION BLVD \r
Unit:E42-1 Status:Dispatched AFA ; 322 E WYOMISSING AVE ; ; UNKNOWN / WERNER ST ; CUMRU ; MANGIA ITALIAN FAMILY RESTAURANT ; 09/02/12 14:20
Unit:CO21 Status:Dispatched MVAUNK ; MERTZTOWN RD KENNEDY AVE ; ; ; LONGSWAMP ; VEH INTO POLE ; 09/02/12 13:39
Unit:555A Status:Dispatched CLASS 5 DOA ; 405 OAK LN ; ; DEAD END / DEAD END ; EXETER ; SEE COMPL AT HIS COUSINS RES ; 09/03/12 18:17=
Unit:555A Status:Dispatched MVAWITH ; 1599 BUTTER LN ; ; EXETER RD / OKMED DR ; EXETER ; ; 09/03/12 15:57:
Unit:555A Status:Dispatched SF ; 2000 PERKIOMEN AVE 309 ; ST CATHERINES SENIOR HOUSING; S 21 ST / S 20 ST ; MOUNT PENN ; SM ELLS SMOKE ; 09/02/12 17:35=
Subject:1/2\nUnit:U55 Status:Dispatched UNCONSCIOUS ; 1725 GOLF RD ; ; NORTH TULPEHOCKEN
FRM: \nSUBJ:1/2\nMSG:Unit:M560A Status:Dispatched MVAUNK ; 4320 N 5 STREET HWY ; GIANT - MUHLENBERG; ELNORE AVE, NORTH TEMPLE BLVD / DARBY AVE ;E

Contact: Active911
[berks.680@rsix.roamsecure.net] Unit:M680A Status:Dispatched ALS MEDICAL ; 202 HAYCREEK RD ; ; UNKNOWN / BROOKE MNR ; BIRDSBORO ; F TEMP OF 104 ; 08/28/12 18:14\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched BLS MEDICAL ; 920 N 4 ST ; METROPOLITAN APARTMENTS; WINDSOR ST / SPRING ST ; READING ; WAITING OUTSIDE ON STAIRS ; 08/28/12 18:33\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:680I Status:Dispatched ALS MEDICAL ; 1254 HIGHVIEW PL ; ; MANOR PL / FAIRVIEW CHAPEL RD ; EXETER ; 24 YOF / SEIZURE / HIT HEAD ON GROUND  ; 08/28/12 19:24\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched ALS TRAUMA ; 450 FURNACE RD ; ; MELODY LN / CYPRESS LN ; ROBESON ; ; 08/28/12 19:45\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched ALS MEDICAL ; 31 WASHINGTON ST ; ; S MILLER ST / NEW HOLLAND AVE ; SHILLINGTON ; 54 YOM / DISORIENTED / DIAPHORETIC /  ; 08/28/12 21:06\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680I Status:Dispatched MVAUNK ; W BENJAMIN FRANKLIN HWY RIVER BRIDGE RD ; ; ; AMITY ; VEH IN GRASS ; 08/28/12 21:38\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched BLS TRAUMA ; 1623 MORGANTOWN RD ROOM 158 ; HEALTH SOUTH; HOPE WAY / CARRIAGE LN ; CUMRU ; 86YOM/ FELL OUT OF BED/ LACERATION TO HEAD ; 08/29/12 01:16\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680A Status:Dispatched LIFT ASSIST ; 406 S WALNUT ST ; ; E 4 ST / E 5 ST ; BIRDSBORO ; 55YOF/ FELL AND NEEDS HELP GETTING UP ; 08/29/12 05:30\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680I Status:Dispatched ALS MEDICAL ; 1152 E BENJAMIN FRANKLIN HWY 219 ; VILLA AT MORLATTON ASSISTED LIVING; MAPLEWOOD DR / OLD AIRPORT RD ; AMITY ; 91 YOF SLURRED SPEECH ; 08/29/12 05:32\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched ALS TRAUMA ; 70 N ONEIL ST ; ; UNKNOWN / W MADISON ST ; MOHNTON ; 90 YOM FALL ; 08/29/12 09:00\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680I Status:Dispatched MVAWITH ; W BENJAMIN FRANKLIN HWY MONOCACY HILL RD ; ; ; AMITY ; ; 08/29/12 09:18\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680F Status:Dispatched BLS TRAUMA ; 790 MAPLEWOOD AVE ; ; CEDARWOOD LN / MOHNTON BLVD ; CUMRU ; 70YOM/STAGE 4 PROSTATE CANCER/WEAK/FELL THIS MORN\r\n ; 08/29/12 09:42\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:680A Status:Dispatched ALS MEDICAL ; 24 BUTTERCUP RD H213-27 ; ; DEAD END / SUNSET DR ; AMITY ; 50 YOF ASTHMA ; 08/29/12 10:21\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n
[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched BLS TRAUMA ; 20 S SUMMIT AVE APT 1002 ; SENCIT APARTMENTS; COMMUNITY DR / HARDING AVE, BROOKE BLVD ; CUMRU ; FALL VICTIM CUT  ; 08/29/12 11:48\r\n\r\nSent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n--\r\r\nYou received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n\r\n

Contact: VJ GREEK <vjgreek@gmail.com>
FRM: \nMSG:Unit:E1 Status:Dispatched MF ; SAINT LAWRENCE AVE N  PROSPECT ST ; ; ; SAINT LAWRENCE ; CHECK BETWEEN ABV  ; 11/10/12 22:27: Eff Body:Unit:E1 Status:Dispatched MF ; SAINT LAWRENCE AVE N  PROSPECT ST ; ; ; SAINT LAWRENCE ; CHECK BETWEEN ABV  ; 11/10/12 22:27:
FRM: \nSUBJ:1/2\nMSG:Unit:CO1 Status:Dispatched MVAUNK ; FAIRVIEW AVE S  22 ST ; ; ; MOUNT PENN ; 2 VEH/ FEMALE IS CRYING ON THE PHONE ; 11/09/19
FRM: \nSUBJ:1/2\nMSG:Unit:R1 Status:Dispatched SF ; 3248 MORGANTOWN RD ; TURKEY HILL - MORGANTOWN RD (RT 10) ROBESON; UNKNOWN / RAMP E ; ROBESONS
FRM: \nSUBJ:1/2\nMSG:Unit:E1 Status:Dispatched AFA ; 2929 OLEY TURNPIKE RD ; ; PARKVIEW RD / PERKIOMEN AVE ; SAINT LAWRENCE ; FIRE ALRM SOUNDINGI ; 11/01/12 18:42=
FRM: \nSUBJ:1/2\nMSG:Unit:B1 Status:Dispatched BF ; 2900 OLEY TURNPIKE RD APT A8 ; ST LAWRENCE GARDEN APTS; PERKIOMEN AVE / PARKVIEW RD ; SAINT N LAWRENCE ; ; 10/30/12 01:59=
FRM: \nSUBJ:1/2\nMSG:Unit:R1 Status:Dispatched CMA ; 1313 CARSONIA AVE ; ; MIDLAND AVE / OAK LN ; LOWER ALSACE ; ALMS ARE GOING OFF ; 10/29/12 02 3:17=
FRM: \nMSG:Unit:R1 Status:Dispatched MVAWITH ; 132 BINGAMAN RD ; ; PETSCH RD / ANGORA RD ; ALSACE ; 31YOF  ; 10/07/12 21:59:
FRM: \nMSG:Unit:R1 Status:Dispatched VF ; 66 CENTURY DR ; ; DEAD END / WHITE BEAR RD ; ROBESON ; ; 10/02/12 19:58:
FRM:\nMSG:Unit:CO1 Status:Dispatched HAZMAT ; 35 N 23 ST ; ; DENGLER ST / CUMBERLAND AVE ; MOUNT PENN ; ; 11/17/12 16:26:
FRM:\nSUBJ:1/2\nMSG:Unit:SP1 Status:Dispatched VF ; 1700 MEMORIAL HWY BLOCK ; ; OLEY TURNPIKE RD / OAK LN ; OLEY ; VEH IN DRIVEWAY / AT EDGE BY

Contact: Roger A. Spadt <firemed4760@gmail.com>
Sender: 1210100053
FRM: \nSUBJ:1/2\nMSG:Unit:RE7 Status:Dispatched SF ; 621 KATHRYN ST ; ; DARIEN ST / SNYDER ST ; READING ; GREY BLK SMOKE COMING FROM CHIMNEY ; 0;

*/

public class PABerksCountyParserTest extends BaseParserTest {
  
  public PABerksCountyParserTest() {
    setParser(new PABerksCountyParser(), "BERKS COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Unit:M590A Status:Dispatched ALS MEDICAL ; 215 TOWER RD ; ; S PARK AVE / CLAY RD ; Muni: LONGSWAMP ; 64 YOM / IN ACTIVE SIEZURE  ; 07/10/12 12:57",
        "UNIT:M590A",
        "CALL:ALS MEDICAL",
        "ADDR:215 TOWER RD",
        "X:S PARK AVE / CLAY RD",
        "CITY:LONGSWAMP",
        "INFO:64 YOM / IN ACTIVE SIEZURE",
        "DATE:07/10/12",
        "TIME:12:57");

    doTest("T2",
        "Unit:M590B Status:Dispatched MVAUNK ; W MAIN ST NORMAL AVE ; ; ; Muni: KUTZTOWN ; ; 07/10/12 14:06",
        "UNIT:M590B",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:W MAIN ST & NORMAL AVE", // Streets don't intersect??
        "CITY:KUTZTOWN",
        "DATE:07/10/12",
        "TIME:14:06");

    doTest("T3",
        "Unit:M535A Status:Dispatched ALS MEDICAL ; 281 MOSELEM CHURCH RD ; ; SCHWOYER RD / MISTY LN ; Muni: RICHMOND ; 79 YOF/VOMITING/COUGHING/PAIN IN SIDE ; 07/11/12 10:04 Sent by Berks County RSAN to Fleetwood EMS All CALL -- You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org",
        "UNIT:M535A",
        "CALL:ALS MEDICAL",
        "ADDR:281 MOSELEM CHURCH RD",
        "X:SCHWOYER RD / MISTY LN",
        "CITY:RICHMOND",
        "INFO:79 YOF/VOMITING/COUGHING/PAIN IN SIDE",
        "DATE:07/11/12",
        "TIME:10:04");

    doTest("T4",
        "Unit:M535A Status:Dispatched ALS MEDICAL ; 224 FAITH DR ; ; GENESIS DR, HOPE DR / HOPE DR ; Muni: MAIDENCREEK ; 39YOM/NOT MAKING SENSE/LAYING ON THE FL ; 07/11/12 21:59 Sent by Berks County RSAN to Fleetwood EMS All CALL -- You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org",
        "UNIT:M535A",
        "CALL:ALS MEDICAL",
        "ADDR:224 FAITH DR",
        "X:GENESIS DR, HOPE DR / HOPE DR",
        "CITY:MAIDENCREEK",
        "INFO:39YOM/NOT MAKING SENSE/LAYING ON THE FL",
        "DATE:07/11/12",
        "TIME:21:59");

    doTest("T5",
        "Unit:585A Status:Dispatched MVAWITH ; 2330 INTERSTATE 78 E ; I78 MP 23.3 EB; UNKNOWN / RAMP B7 ; Muni: UPPER BERN ; 2 vehs/ ILVER SEDAN / UNK INJS / TX TO PSP  ; 07/11/12 16:33 On Jul 11, 2012 5:55 PM, \"Ken Corbin\" <ken@cadpage.org> wrote:",
        "UNIT:585A",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:2330 INTERSTATE 78 E",
        "PLACE:I78 MP 23.3 EB",
        "X:UNKNOWN / RAMP B7",
        "CITY:UPPER BERN",
        "INFO:2 vehs/ ILVER SEDAN / UNK INJS / TX TO PSP");

    doTest("T6",
        "Unit:M590A Status:Dispatched MVAWITH ; S BALDY ST TREXLER AVE ; ; ; Muni: KUTZTOWN ; ; 07/11/12 07:10",
        "UNIT:M590A",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:S BALDY ST & TREXLER AVE",
        "CITY:KUTZTOWN",
        "DATE:07/11/12",
        "TIME:07:10");

    doTest("T7",
        "Unit:M590A Status:Dispatched BLS MEDICAL ; 625 SPRING ST ; PENNSYLVANIA DIALYSIS; CROSSING DR / N 6 ST ; Muni: WYOMISSING ; ; 07/10/12 19:58",
        "UNIT:M590A",
        "CALL:BLS MEDICAL",
        "ADDR:625 SPRING ST",
        "PLACE:PENNSYLVANIA DIALYSIS",
        "X:CROSSING DR / N 6 ST",
        "CITY:WYOMISSING",
        "DATE:07/10/12",
        "TIME:19:58");

    doTest("T8",
        "Unit:M590B Status:Dispatched MVAUNK ; W MAIN ST NORMAL AVE ; ; ; Muni: KUTZTOWN ; ; 07/10/12 14:06",
        "UNIT:M590B",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:W MAIN ST & NORMAL AVE", // Ditto
        "CITY:KUTZTOWN",
        "DATE:07/10/12",
        "TIME:14:06");

    doTest("T9",
        "Unit:R27 Status:Dispatched MVAUNK ; ROUTE 183 MILL RD ; ; ; Muni: UPPER TULPEHOCKEN ; ; 07/12/12 04:48",
        "UNIT:R27",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:ROUTE 183 & MILL RD",
        "CITY:UPPER TULPEHOCKEN",
        "DATE:07/12/12",
        "TIME:04:48");

    doTest("T10",
        "Unit:535A Status:Dispatched BLS TRAUMA ; 2 W PINE ST ; ; S FRANKLIN ST, E PINE ST /NEW ALY ; Muni: FLEETWOOD ; 79 YOM FELL IN THE DRIVEWAY ; 07/11/12 14:13",
        "UNIT:535A",
        "CALL:BLS TRAUMA",
        "ADDR:2 W PINE ST",
        "X:S FRANKLIN ST, E PINE ST /NEW ALY",
        "CITY:FLEETWOOD",
        "INFO:79 YOM FELL IN THE DRIVEWAY",
        "DATE:07/11/12",
        "TIME:14:13");

    doTest("T11",
        "Unit:M590A Status:Dispatched ALS MEDICAL ; 7723 HAMILTON BLVD ; ; ; Muni: ; UPPERMACUNGIE TWP- LEHIGH CO/ ; 07/11/12 21:51",
        "UNIT:M590A",
        "CALL:ALS MEDICAL",
        "ADDR:7723 HAMILTON BLVD",
        "CITY:UPPERMACUNGIE TWP,LEHIGH CO",
        "DATE:07/11/12",
        "TIME:21:51");

    doTest("T12",
        "Unit:M590A Status:Dispatched ALS MEDICAL ; 1107 APEX AVE ; ; UNKNOWN / LIFESTYLE LN ; Muni: MAXATAWNY ; 20ish yof layin on ground /is cons ; 07/11/12 20:41",
        "UNIT:M590A",
        "CALL:ALS MEDICAL",
        "ADDR:1107 APEX AVE",  // Not mapping
        "X:UNKNOWN / LIFESTYLE LN",
        "CITY:MAXATAWNY",
        "INFO:20ish yof layin on ground /is cons",
        "DATE:07/11/12",
        "TIME:20:41");

    doTest("T13",
        "Unit:M590A Status:Dispatched ALS TRAUMA ; 15620 KUTZTOWN RD ; ; UNKNOWN / CHURCH RD ; Muni: MAXATAWNY ; 10 YOF FELL FROM A WINDOW  UNCONS ; 07/12/12 12:38",
        "UNIT:M590A",
        "CALL:ALS TRAUMA",
        "ADDR:15620 KUTZTOWN RD",
        "X:UNKNOWN / CHURCH RD",
        "CITY:MAXATAWNY",
        "INFO:10 YOF FELL FROM A WINDOW  UNCONS",
        "DATE:07/12/12",
        "TIME:12:38");

    doTest("T14",
        "Unit:M590A Status:Dispatched BLS MEDICAL ; 247 RHOADES RD ; ; NUNEMAKER RD / ROTH RD ; Muni: GREENWICH ; RESPONDING FOR BLSMED ; 07/12/12 15:14",
        "UNIT:M590A",
        "CALL:BLS MEDICAL",
        "ADDR:247 RHOADES RD",
        "X:NUNEMAKER RD / ROTH RD",
        "CITY:GREENWICH",
        "INFO:RESPONDING FOR BLSMED",
        "DATE:07/12/12",
        "TIME:15:14");

    doTest("T15",
        "Unit:M590A Status:Dispatched LIFT ASSIST ; 35 S WHITEOAK ST SHADE RES ; ; SANDER ALY, N WHITEOAK ST / NORMAL AVE ; Muni: KUTZTOWN ; 74YOM FELL NOT INJ JUST NEEDS HELP GETTING UP ; 07/12/12 17:38",
        "UNIT:M590A",
        "CALL:LIFT ASSIST",
        "ADDR:35 S WHITEOAK ST",
        "NAME:SHADE", 
        "X:SANDER ALY, N WHITEOAK ST / NORMAL AVE",
        "CITY:KUTZTOWN",
        "INFO:74YOM FELL NOT INJ JUST NEEDS HELP GETTING UP",
        "DATE:07/12/12",
        "TIME:17:38");

    doTest("T16",
        "Unit:M590A Status:Dispatched BLS MEDICAL ; 247 RHOADES RD ; ; NUNEMAKER RD / ROTH RD ; Muni: GREENWICH ; RESPONDING FOR BLSMED ; 07/12/12 15:14",
        "UNIT:M590A",
        "CALL:BLS MEDICAL",
        "ADDR:247 RHOADES RD",
        "X:NUNEMAKER RD / ROTH RD",
        "CITY:GREENWICH",
        "INFO:RESPONDING FOR BLSMED",
        "DATE:07/12/12",
        "TIME:15:14");

    doTest("T17",
        "Unit:M590A Status:Dispatched ALS TRAUMA ; 15620 KUTZTOWN RD ; ; UNKNOWN / CHURCH RD ; Muni: MAXATAWNY ; 10 YOF FELL FROM A WINDOW  UNCONS ; 07/12/12 12:38",
        "UNIT:M590A",
        "CALL:ALS TRAUMA",
        "ADDR:15620 KUTZTOWN RD",
        "X:UNKNOWN / CHURCH RD",
        "CITY:MAXATAWNY",
        "INFO:10 YOF FELL FROM A WINDOW  UNCONS",
        "DATE:07/12/12",
        "TIME:12:38");

    doTest("T18",
        "Unit:CO61 Status:Dispatched CMA ; 303 WYNDCLIFFE AVE ; ; HILLTOP CT / CHESTNUT ST, WINTERSON DR ; Muni: HAMBURG ;",
        "UNIT:CO61",
        "CALL:CMA - Carbon Monoxide",
        "ADDR:303 WYNDCLIFFE AVE",
        "X:HILLTOP CT / CHESTNUT ST, WINTERSON DR",
        "CITY:HAMBURG");

    doTest("T19",
        "Unit:CO61 Status:Dispatched AFA ; 218 PINE ST ; ; S PEACH ALY / S 2 ST ; Muni: HAMBURG ; ; 07/12/12 06:37",
        "UNIT:CO61",
        "CALL:AFA - Fire Alarm",
        "ADDR:218 PINE ST",
        "X:S PEACH ALY / S 2 ST",
        "CITY:HAMBURG",
        "DATE:07/12/12",
        "TIME:06:37");

    doTest("T20",
        "Unit:CO85 Status:Dispatched MVAWITH ; 1780 ACORN DR ; ; TIMBER LN / GRAVEL HILL DR ; Muni: SPRING ; FM SCREAMING SHE IS BLEEDING/  ; 07/12/12 02:03\n\n" +
        "Sent by Berks County RSAN to CO85 All Call",

        "UNIT:CO85",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:1780 ACORN DR",
        "X:TIMBER LN / GRAVEL HILL DR",
        "CITY:SPRING",
        "INFO:FM SCREAMING SHE IS BLEEDING/",
        "DATE:07/12/12",
        "TIME:02:03");

    doTest("T21",
        "Unit:E85-2 Status:Dispatched HAZMAT ; 2227 MCKINLEY AVE ; ; UNKNOWN / WEST WYOMISSING BLVD ; Muni: SPRING ; CHF85 AND E85-2 EN FOR ODOR OF GASOLINE IN RESIDENCE ; 07/11/12 10:07\n\n" +
        "Sent by Berks County RSAN to CO85 All Call",

        "UNIT:E85-2",
        "CALL:HAZMAT",
        "ADDR:2227 MCKINLEY AVE",
        "X:UNKNOWN / WEST WYOMISSING BLVD",
        "CITY:SPRING",
        "INFO:CHF85 AND E85-2 EN FOR ODOR OF GASOLINE IN RESIDENCE",
        "DATE:07/11/12",
        "TIME:10:07");

    doTest("T22",
        "Unit:REN85 Status:Dispatched SF ; 44 WATER ST ; ; POTTSVILLE PKE / N 5 STREET HWY ; Muni: MUHLENBERG ; elderly fm / not answering questions  ; 07/12/12 00:54\n\n" +
        "Sent by Berks County RSAN to CO85 All Call",

        "UNIT:REN85",
        "CALL:SF - Structure Fire",
        "ADDR:44 WATER ST",
        "X:POTTSVILLE PKE / N 5 STREET HWY",
        "CITY:MUHLENBERG",
        "INFO:elderly fm / not answering questions",
        "DATE:07/12/12",
        "TIME:00:54");

    doTest("T23",
        "Unit:R1 Status:Dispatched MVAUNK ; OAK LN / RICHMOND ST ; ; ; Muni: LOWER ALSACE ; mc into ditch / on oak ln / ; 07/12/12 12",
        "UNIT:R1",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:OAK LN & RICHMOND ST",
        "CITY:LOWER ALSACE",
        "INFO:mc into ditch / on oak ln /");

    doTest("T24",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:CO13 Status:Dispatched AFA ; 2525 N 12 ST BLDG 30 STONEPOINT CENTER ; ; WESTERN ELECTRIC DR / DEAD END ; MUHLENBERG ;  ",

        "UNIT:CO13",
        "CALL:AFA - Fire Alarm",
        "ADDR:2525 N 12 ST",
        "APT:BLDG 30 STONEPOINT CENTER",
        "CITY:MUHLENBERG",
        "X:WESTERN ELECTRIC DR / DEAD END");

    doTest("T25",
        "Unit:M590A Status:Dispatched BLS TRAUMA ; 111 HARTMAN RD ; ; UNKNOWN / UNKNOWN ; MAXATAWNY ; 65 YOM / TRIPPED AND FELL / HIT HEAD / MINOR BLEEDING ; 05/17/13 08:37",
        "UNIT:M590A",
        "CALL:BLS TRAUMA",
        "ADDR:111 HARTMAN RD",
        "CITY:MAXATAWNY",
        "X:UNKNOWN / UNKNOWN",
        "INFO:65 YOM / TRIPPED AND FELL / HIT HEAD / MINOR BLEEDING",
        "DATE:05/17/13",
        "TIME:08:37");

    doTest("T26",
        "Unit:590T Status:Dispatched ALS MEDICAL ; 211 FISHER LN ; ; UNKNOWN / KLINES CORNER RD ; MAXATAWNY ; 85YOF /POSS STROKE /LE",
        "UNIT:590T",
        "CALL:ALS MEDICAL",
        "ADDR:211 FISHER LN",
        "CITY:MAXATAWNY",
        "X:UNKNOWN / KLINES CORNER RD",
        "INFO:85YOF /POSS STROKE /LE");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(berks.co85@rsix.roamsecure.net) Unit:CO85 Status:Dispatched MF ; 828 BLUE GATE LN ; ; PERSIMMON DR / HEARTHSTONE LN ; Muni: SPRING ; ; 07/13/12 14:09 Sent by Berks County RSAN to CO85 All Call -- You received this message because you registered on Alert Berks. ",
        "UNIT:CO85",
        "CALL:MF - Misc",
        "ADDR:828 BLUE GATE LN",
        "X:PERSIMMON DR / HEARTHSTONE LN",
        "CITY:SPRING",
        "DATE:07/13/12",
        "TIME:14:09");

    doTest("T2",
        "[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched BLS MEDICAL ; 1320 BROADCASTING RD ; ; MERIDIAN BLVD / CONNEL DR ; Muni: SPRING ; RESPONDING FOR BLS MED / DIRECT CALL TO STATION / NFI ; 07/12/12 15:18\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650A",
        "CALL:BLS MEDICAL",
        "ADDR:1320 BROADCASTING RD",
        "X:MERIDIAN BLVD / CONNEL DR",
        "CITY:SPRING",
        "INFO:RESPONDING FOR BLS MED / DIRECT CALL TO STATION / NFI",
        "DATE:07/12/12",
        "TIME:15:18");

    doTest("T3",
        "[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched ALS MEDICAL ; 3121 STATE HILL RD RM17 ; COLUMBIA COTTAGE; YERGER BLVD, WESTBURY DR / LELAND WAY ; Muni: SPRING ; FEMALE CHEST PAIN  ; 07/12/12 15:19\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650B",
        "CALL:ALS MEDICAL",
        "ADDR:3121 STATE HILL RD",
        "APT:17",
        "PLACE:COLUMBIA COTTAGE",
        "X:YERGER BLVD, WESTBURY DR / LELAND WAY",
        "CITY:SPRING",
        "INFO:FEMALE CHEST PAIN",
        "DATE:07/12/12",
        "TIME:15:19");

    doTest("T4",
        "[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched CLASS 4 MENTAL ; 107 S 5 ST ROOM 5 ; ; FRANKLIN ST / CHESTNUT ST ; Muni: READING ; FEELING SUICIDAL ; 07/12/12 19:20\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650E",
        "CALL:CLASS 4 MENTAL",
        "ADDR:107 S 5 ST",
        "APT:5",
        "X:FRANKLIN ST / CHESTNUT ST",
        "CITY:READING",
        "INFO:FEELING SUICIDAL",
        "DATE:07/12/12",
        "TIME:19:20");

    doTest("T5",
        "[berks.650@rsix.roamsecure.net] Unit:M650I Status:Dispatched ALS MEDICAL ; 404 S CHURCH ST ROOM 1 ; GOLDEN RIDGE; PATTERSON DR / PATTERSON DR ; Muni: ROBESONIA ; 88 YOF/ POS TIA ; 07/12/12 19:59\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650I",
        "CALL:ALS MEDICAL",
        "ADDR:404 S CHURCH ST",
        "APT:1",
        "PLACE:GOLDEN RIDGE",
        "X:PATTERSON DR / PATTERSON DR",
        "CITY:ROBESONIA",
        "INFO:88 YOF/ POS TIA",
        "DATE:07/12/12",
        "TIME:19:59");

    doTest("T6",
        "[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched ALS MEDICAL ; 1802 TULPEHOCKEN RD RM 277 ; ; UNKNOWN / KISSINGER LN ; Muni: WYOMISSING ; 88 YOF/  ; 07/12/12 21:28\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650E",
        "CALL:ALS MEDICAL",
        "ADDR:1802 TULPEHOCKEN RD",
        "APT:277",
        "X:UNKNOWN / KISSINGER LN",
        "CITY:WYOMISSING",
        "INFO:88 YOF/",
        "DATE:07/12/12",
        "TIME:21:28");

    doTest("T7",
        "[berks.650@rsix.roamsecure.net] Unit:M650I Status:Dispatched ALS MEDICAL ; 101 E FRONT ST ; ; S MAIN ST, N MAIN ST / N WOLF ST ; Muni: BERNVILLE ; 63YOM LABORED BREATHING ; 07/12/12 22:17\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650I",
        "CALL:ALS MEDICAL",
        "ADDR:101 E FRONT ST",
        "X:S MAIN ST, N MAIN ST / N WOLF ST",
        "CITY:BERNVILLE",
        "INFO:63YOM LABORED BREATHING",
        "DATE:07/12/12",
        "TIME:22:17");

    doTest("T8",
        "[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 3012 SUSANNA DR ; ; DANIEL DR / KATHARINE DR ; Muni: SPRING ; ALS ; 07/12/12 22:34\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650A",
        "CALL:ALS MEDICAL",
        "ADDR:3012 SUSANNA DR",
        "X:DANIEL DR / KATHARINE DR",
        "CITY:SPRING",
        "INFO:ALS",
        "DATE:07/12/12",
        "TIME:22:34");

    doTest("T9",
        "[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched DOMESTIC INJURY ; 654 ANNE DR ; ; UNKNOWN / CHRISTOPHER DR ; Muni: WERNERSVILLE ; COMP VS EX HUSB OF GIRLFRIEND/  ; 07/12/12 22:45\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650B",
        "CALL:DOMESTIC INJURY",
        "ADDR:654 ANNE DR",
        "X:UNKNOWN / CHRISTOPHER DR",
        "CITY:WERNERSVILLE",
        "INFO:COMP VS EX HUSB OF GIRLFRIEND/",
        "DATE:07/12/12",
        "TIME:22:45");

    doTest("T10",
        "[berks.650@rsix.roamsecure.net] Unit:650T Status:Dispatched CLASS 4 MENTAL ; 4050 CONRAD WEISER PRKWY 4 ; ; MARION DR / SHERIDAN RD ; Muni: MARION ; 21YOF/NEEDS TO BE 302 ; 07/12/12 23:37\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:650T",
        "CALL:CLASS 4 MENTAL",
        "ADDR:4050 CONRAD WEISER PRKWY 4",
        "X:MARION DR / SHERIDAN RD",
        "CITY:MARION",
        "INFO:21YOF/NEEDS TO BE 302",
        "DATE:07/12/12",
        "TIME:23:37");

    doTest("T11",
        "[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched ALS MEDICAL ; 511 HUNTERS RD ; ; UNKNOWN / UNKNOWN ; Muni: CUMRU ; 76YOM/ BLOOD SUGAR 35/  ; 07/12/12 23:52\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650E",
        "CALL:ALS MEDICAL",
        "ADDR:511 HUNTERS RD",
        "X:UNKNOWN / UNKNOWN",
        "CITY:CUMRU",
        "INFO:76YOM/ BLOOD SUGAR 35/",
        "DATE:07/12/12",
        "TIME:23:52");

    doTest("T12",
        "[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 350 SPORTSMAN RD ; WERNERSVILLE STATE HOSPITAL; WSH ORCHARD RD / WSH MAIN ST ; Muni: SOUTH HEIDELBERG ; 26YOM COUGHING UP BLOOD ; 07/13/12 00:01\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650A",
        "CALL:ALS MEDICAL",
        "ADDR:350 SPORTSMAN RD",
        "PLACE:WERNERSVILLE STATE HOSPITAL",
        "X:WSH ORCHARD RD / WSH MAIN ST",
        "CITY:SOUTH HEIDELBERG",
        "INFO:26YOM COUGHING UP BLOOD",
        "DATE:07/13/12",
        "TIME:00:01");

    doTest("T13",
        "[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched BLS MEDICAL ; 517 OAK HILL LN ; ; UNKNOWN / UNKNOWN ; Muni: SPRING ; 84 YOF VOMITTING ; 07/13/12 00:51\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650A",
        "CALL:BLS MEDICAL",
        "ADDR:517 OAK HILL LN",
        "X:UNKNOWN / UNKNOWN",
        "CITY:SPRING",
        "INFO:84 YOF VOMITTING",
        "DATE:07/13/12",
        "TIME:00:51");

    doTest("T14",
        "[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 135 BALTHASER RD ; ; N ARTHUR DR, S ARTHUR DR / PRESTON RD ; Muni: SOUTH HEIDELBERG ; 42YOF/ COMP IS PT/  ; 07/13/12 06:39\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650A",
        "CALL:ALS MEDICAL",
        "ADDR:135 BALTHASER RD",
        "X:N ARTHUR DR, S ARTHUR DR / PRESTON RD",
        "CITY:SOUTH HEIDELBERG",
        "INFO:42YOF/ COMP IS PT/",
        "DATE:07/13/12",
        "TIME:06:39");

    doTest("T15",
        "[berks.650@rsix.roamsecure.net] Unit:M650E Status:Enroute BLS MEDICAL ; 1801 CAMBRIDGE AVE D20 ; TENNIS PARK CONDOS; OLD MILL RD / LAUERS LN ; Muni: WYOMISSING ; ; 07/13/12 08:05\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650E",
        "CALL:BLS MEDICAL",
        "ADDR:1801 CAMBRIDGE AVE",
        "APT:D20",
        "PLACE:TENNIS PARK CONDOS",
        "X:OLD MILL RD / LAUERS LN",
        "CITY:WYOMISSING",
        "DATE:07/13/12",
        "TIME:08:05");

    doTest("T16",
        "[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched ALS MEDICAL ; 2701 NORTH MERIDIAN BLVD ; IHOP; BROADCASTING RD / MERIDIAN BLVD ; Muni: SPRING ; ML IN 20'S HAVING SEIZURE ; 07/13/12 10:25\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650A",
        "CALL:ALS MEDICAL",
        "ADDR:2701 NORTH MERIDIAN BLVD",
        "PLACE:IHOP",
        "X:BROADCASTING RD / MERIDIAN BLVD",
        "CITY:SPRING",
        "INFO:ML IN 20'S HAVING SEIZURE",
        "DATE:07/13/12",
        "TIME:10:25");

    doTest("T17",
        "[berks.650@rsix.roamsecure.net] Unit:M650E Status:Dispatched ALS MEDICAL ; 1863 LINCOLN AVE VINCENT BECKER RES ; ; BRANDYWINE RD / BRANDYWINE CT ; Muni: WYOMISSING ; 92 YOM ARM IS NUMB/RIGHT EYE DROOPY ; 07/13/12 11:20\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650E",
        "CALL:ALS MEDICAL",
        "ADDR:1863 LINCOLN AVE",
        "NAME:VINCENT BECKER",
        "X:BRANDYWINE RD / BRANDYWINE CT",
        "CITY:WYOMISSING",
        "INFO:92 YOM ARM IS NUMB/RIGHT EYE DROOPY",
        "DATE:07/13/12",
        "TIME:11:20");

    doTest("T18",
        "[berks.650@rsix.roamsecure.net] Unit:M650A Status:Dispatched CLASS 4 MENTAL ; 13 BIRCHWOOD RD ; ; LARCHWOOD RD, CEDARWOOD RD / LARCHWOOD RD ; Muni: WYOMISSING ; sam crisis ; 07/13/12 11:30\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650A",
        "CALL:CLASS 4 MENTAL",
        "ADDR:13 BIRCHWOOD RD",
        "X:LARCHWOOD RD, CEDARWOOD RD / LARCHWOOD RD",
        "CITY:WYOMISSING",
        "INFO:sam crisis",
        "DATE:07/13/12",
        "TIME:11:30");

    doTest("T19",
        "[berks.650@rsix.roamsecure.net] Unit:M650I Status:Dispatched ALS MEDICAL ; 356 S FREEMAN ST ; ; E MEADOW AVE / W FREEMAN ST, FURNACE ST ; Muni: ROBESONIA ; 90 YOF / VERY WEAK / DEHYDRATED  ; 07/13/12 12:06\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650I",
        "CALL:ALS MEDICAL",
        "ADDR:356 S FREEMAN ST",
        "X:E MEADOW AVE / W FREEMAN ST, FURNACE ST",
        "CITY:ROBESONIA",
        "INFO:90 YOF / VERY WEAK / DEHYDRATED",
        "DATE:07/13/12",
        "TIME:12:06");

    doTest("T20",
        "[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched ALS MEDICAL ; 310 STITZER AVE ; ; E WILSON AVE, W WILSON AVE / E NORMAN ST, W NORMAN ST ; Muni: WERNERSVILLE ; 88 YOM NOT RESPONDING WELL ; 07/13/12 12:40\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650B",
        "CALL:ALS MEDICAL",
        "ADDR:310 STITZER AVE",
        "X:E WILSON AVE, W WILSON AVE / E NORMAN ST, W NORMAN ST",
        "CITY:WERNERSVILLE",
        "INFO:88 YOM NOT RESPONDING WELL",
        "DATE:07/13/12",
        "TIME:12:40");

    doTest("T21",
        "[berks.650@rsix.roamsecure.net] Unit:M650B Status:Dispatched BLS TRAUMA ; 2912 STATE HILL RD APT B3 ; ; No Cross Streets Found ; Muni: SPRING ; BERKSHIRE ESTATES APTS ; 07/13/12 13:43\n" +
        "Sent by Berks County RSAN to Western Berks EMS All CALL\n" +
        "--\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\n",

        "UNIT:M650B",
        "CALL:BLS TRAUMA",
        "ADDR:2912 STATE HILL RD",
        "APT:B3",
        "CITY:SPRING",
        "INFO:BERKSHIRE ESTATES APTS",
        "DATE:07/13/12",
        "TIME:13:43");

    doTest("T22",
        "Unit:555A Status:Dispatched CLASS 5 DOA ; 405 OAK LN ; ; DEAD END / DEAD END ; EXETER ; SEE COMPL AT HIS COUSINS RES ; 09/03/12 18:17=",
        "UNIT:555A",
        "CALL:CLASS 5 DOA",
        "ADDR:405 OAK LN",
        "CITY:EXETER",
        "X:DEAD END / DEAD END",
        "INFO:SEE COMPL AT HIS COUSINS RES",
        "DATE:09/03/12",
        "TIME:18:17");

    doTest("T23",
        "Unit:555A Status:Dispatched MVAWITH ; 1599 BUTTER LN ; ; EXETER RD / OKMED DR ; EXETER ; ; 09/03/12 15:57:",
        "UNIT:555A",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:1599 BUTTER LN",
        "CITY:EXETER",
        "X:EXETER RD / OKMED DR");

    doTest("T24",
        "Unit:555A Status:Dispatched SF ; 2000 PERKIOMEN AVE 309 ; ST CATHERINES SENIOR HOUSING; S 21 ST / S 20 ST ; MOUNT PENN ; SMELLS SMOKE ; 09/02/12 17:35=",
        "UNIT:555A",
        "CALL:SF - Structure Fire",
        "ADDR:2000 PERKIOMEN AVE",
        "APT:309",
        "CITY:MOUNT PENN",
        "PLACE:ST CATHERINES SENIOR HOUSING",
        "X:S 21 ST / S 20 ST",
        "INFO:SMELLS SMOKE",
        "DATE:09/02/12",
        "TIME:17:35");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Unit:B42 Status:Dispatched BF ; 100 BLIMLINE RD BLOCK ; ; DEAD END / DEER CREEK RD ; SPRING ; ; 09/01/12 07:51",
        "UNIT:B42",
        "CALL:BF - Brush Fire",
        "ADDR:100 BLIMLINE RD",
        "APT:BLOCK",
        "CITY:SPRING",
        "X:DEAD END / DEER CREEK RD",
        "DATE:09/01/12",
        "TIME:07:51");

    doTest("T2",
        "Subject:1/2\nUnit:M590A Status:Dispatched ALS MEDICAL ; 120 TREXLER AVE RM 114 ; KUTZTOWN MANOR; LENNI ST / CONSTITUTION BLVD \r",
        "UNIT:M590A",
        "CALL:ALS MEDICAL",
        "ADDR:120 TREXLER AVE",
        "APT:114",
        "PLACE:KUTZTOWN MANOR",
        "X:LENNI ST / CONSTITUTION BLVD");

    doTest("T3",
        "Unit:E42-1 Status:Dispatched AFA ; 322 E WYOMISSING AVE ; ; UNKNOWN / WERNER ST ; CUMRU ; MANGIA ITALIAN FAMILY RESTAURANT ; 09/02/12 14:20",
        "UNIT:E42-1",
        "CALL:AFA - Fire Alarm",
        "ADDR:322 E WYOMISSING AVE",
        "CITY:CUMRU",
        "X:UNKNOWN / WERNER ST",
        "INFO:MANGIA ITALIAN FAMILY RESTAURANT",
        "DATE:09/02/12",
        "TIME:14:20");

    doTest("T4",
        "Unit:CO21 Status:Dispatched MVAUNK ; MERTZTOWN RD KENNEDY AVE ; ; ; LONGSWAMP ; VEH INTO POLE ; 09/02/12 13:39",
        "UNIT:CO21",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:MERTZTOWN RD & KENNEDY AVE",
        "CITY:LONGSWAMP",
        "INFO:VEH INTO POLE",
        "DATE:09/02/12",
        "TIME:13:39");

    doTest("T5",
        "Subject:1/2\nUnit:U55 Status:Dispatched UNCONSCIOUS ; 1725 GOLF RD ; ; NORTH TULPEHOCKEN",
        "UNIT:U55",
        "CALL:UNCONSCIOUS",
        "ADDR:1725 GOLF RD",
        "X:NORTH TULPEHOCKEN");

    doTest("T6",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:M560A Status:Dispatched MVAUNK ; 4320 N 5 STREET HWY ; GIANT - MUHLENBERG; ELNORE AVE, NORTH TEMPLE BLVD / DARBY AVE ;E",

        "UNIT:M560A",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:4320 N 5 STREET HWY",
        "CITY:E",
        "PLACE:GIANT - MUHLENBERG",
        "X:ELNORE AVE, NORTH TEMPLE BLVD / DARBY AVE");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "[berks.680@rsix.roamsecure.net] Unit:M680A Status:Dispatched ALS MEDICAL ; 202 HAYCREEK RD ; ; UNKNOWN / BROOKE MNR ; BIRDSBORO ; F TEMP OF 104 ; 08/28/12 18:14\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680A",
        "CALL:ALS MEDICAL",
        "ADDR:202 HAYCREEK RD",
        "CITY:BIRDSBORO",
        "X:UNKNOWN / BROOKE MNR",
        "INFO:F TEMP OF 104",
        "DATE:08/28/12",
        "TIME:18:14");

    doTest("T2",
        "[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched BLS MEDICAL ; 920 N 4 ST ; METROPOLITAN APARTMENTS; WINDSOR ST / SPRING ST ; READING ; WAITING OUTSIDE ON STAIRS ; 08/28/12 18:33\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680E",
        "CALL:BLS MEDICAL",
        "ADDR:920 N 4 ST",
        "CITY:READING",
        "PLACE:METROPOLITAN APARTMENTS",
        "X:WINDSOR ST / SPRING ST",
        "INFO:WAITING OUTSIDE ON STAIRS",
        "DATE:08/28/12",
        "TIME:18:33");

    doTest("T3",
        "[berks.680@rsix.roamsecure.net] Unit:680I Status:Dispatched ALS MEDICAL ; 1254 HIGHVIEW PL ; ; MANOR PL / FAIRVIEW CHAPEL RD ; EXETER ; 24 YOF / SEIZURE / HIT HEAD ON GROUND  ; 08/28/12 19:24\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:680I",
        "CALL:ALS MEDICAL",
        "ADDR:1254 HIGHVIEW PL",
        "CITY:EXETER",
        "X:MANOR PL / FAIRVIEW CHAPEL RD",
        "INFO:24 YOF / SEIZURE / HIT HEAD ON GROUND",
        "DATE:08/28/12",
        "TIME:19:24");

    doTest("T4",
        "[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched ALS TRAUMA ; 450 FURNACE RD ; ; MELODY LN / CYPRESS LN ; ROBESON ; ; 08/28/12 19:45\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680E",
        "CALL:ALS TRAUMA",
        "ADDR:450 FURNACE RD",
        "CITY:ROBESON",
        "X:MELODY LN / CYPRESS LN",
        "DATE:08/28/12",
        "TIME:19:45");

    doTest("T5",
        "[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched ALS MEDICAL ; 31 WASHINGTON ST ; ; S MILLER ST / NEW HOLLAND AVE ; SHILLINGTON ; 54 YOM / DISORIENTED / DIAPHORETIC /  ; 08/28/12 21:06\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680E",
        "CALL:ALS MEDICAL",
        "ADDR:31 WASHINGTON ST",
        "CITY:SHILLINGTON",
        "X:S MILLER ST / NEW HOLLAND AVE",
        "INFO:54 YOM / DISORIENTED / DIAPHORETIC /",
        "DATE:08/28/12",
        "TIME:21:06");

    doTest("T6",
        "[berks.680@rsix.roamsecure.net] Unit:M680I Status:Dispatched MVAUNK ; W BENJAMIN FRANKLIN HWY RIVER BRIDGE RD ; ; ; AMITY ; VEH IN GRASS ; 08/28/12 21:38\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680I",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:W BENJAMIN FRANKLIN HWY & RIVER BRIDGE RD",
        "CITY:AMITY",
        "INFO:VEH IN GRASS",
        "DATE:08/28/12",
        "TIME:21:38");

    doTest("T7",
        "[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched BLS TRAUMA ; 1623 MORGANTOWN RD ROOM 158 ; HEALTH SOUTH; HOPE WAY / CARRIAGE LN ; CUMRU ; 86YOM/ FELL OUT OF BED/ LACERATION TO HEAD ; 08/29/12 01:16\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680E",
        "CALL:BLS TRAUMA",
        "ADDR:1623 MORGANTOWN RD",
        "APT:158",
        "CITY:CUMRU",
        "PLACE:HEALTH SOUTH",
        "X:HOPE WAY / CARRIAGE LN",
        "INFO:86YOM/ FELL OUT OF BED/ LACERATION TO HEAD",
        "DATE:08/29/12",
        "TIME:01:16");

    doTest("T8",
        "[berks.680@rsix.roamsecure.net] Unit:M680A Status:Dispatched LIFT ASSIST ; 406 S WALNUT ST ; ; E 4 ST / E 5 ST ; BIRDSBORO ; 55YOF/ FELL AND NEEDS HELP GETTING UP ; 08/29/12 05:30\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680A",
        "CALL:LIFT ASSIST",
        "ADDR:406 S WALNUT ST",
        "CITY:BIRDSBORO",
        "X:E 4 ST / E 5 ST",
        "INFO:55YOF/ FELL AND NEEDS HELP GETTING UP",
        "DATE:08/29/12",
        "TIME:05:30");

    doTest("T9",
        "[berks.680@rsix.roamsecure.net] Unit:M680I Status:Dispatched ALS MEDICAL ; 1152 E BENJAMIN FRANKLIN HWY 219 ; VILLA AT MORLATTON ASSISTED LIVING; MAPLEWOOD DR / OLD AIRPORT RD ; AMITY ; 91 YOF SLURRED SPEECH ; 08/29/12 05:32\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680I",
        "CALL:ALS MEDICAL",
        "ADDR:1152 E BENJAMIN FRANKLIN HWY",
        "APT:219",
        "CITY:AMITY",
        "PLACE:VILLA AT MORLATTON ASSISTED LIVING",
        "X:MAPLEWOOD DR / OLD AIRPORT RD",
        "INFO:91 YOF SLURRED SPEECH",
        "DATE:08/29/12",
        "TIME:05:32");

    doTest("T10",
        "[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched ALS TRAUMA ; 70 N ONEIL ST ; ; UNKNOWN / W MADISON ST ; MOHNTON ; 90 YOM FALL ; 08/29/12 09:00\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680E",
        "CALL:ALS TRAUMA",
        "ADDR:70 N ONEIL ST",
        "CITY:MOHNTON",
        "X:UNKNOWN / W MADISON ST",
        "INFO:90 YOM FALL",
        "DATE:08/29/12",
        "TIME:09:00");

    doTest("T11",
        "[berks.680@rsix.roamsecure.net] Unit:M680I Status:Dispatched MVAWITH ; W BENJAMIN FRANKLIN HWY MONOCACY HILL RD ; ; ; AMITY ; ; 08/29/12 09:18\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680I",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:W BENJAMIN FRANKLIN HWY & MONOCACY HILL RD",
        "CITY:AMITY",
        "DATE:08/29/12",
        "TIME:09:18");

    doTest("T12",
        "[berks.680@rsix.roamsecure.net] Unit:M680F Status:Dispatched BLS TRAUMA ; 790 MAPLEWOOD AVE ; ; CEDARWOOD LN / MOHNTON BLVD ; CUMRU ; 70YOM/STAGE 4 PROSTATE CANCER/WEAK/FELL THIS MORN\r\n" +
        " ; 08/29/12 09:42\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680F",
        "CALL:BLS TRAUMA",
        "ADDR:790 MAPLEWOOD AVE",
        "CITY:CUMRU",
        "X:CEDARWOOD LN / MOHNTON BLVD",
        "INFO:70YOM/STAGE 4 PROSTATE CANCER/WEAK/FELL THIS MORN",
        "DATE:08/29/12",
        "TIME:09:42");

    doTest("T13",
        "[berks.680@rsix.roamsecure.net] Unit:680A Status:Dispatched ALS MEDICAL ; 24 BUTTERCUP RD H213-27 ; ; DEAD END / SUNSET DR ; AMITY ; 50 YOF ASTHMA ; 08/29/12 10:21\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:680A",
        "CALL:ALS MEDICAL",
        "ADDR:24 BUTTERCUP RD",
        "APT:H213-27",
        "CITY:AMITY",
        "X:DEAD END / SUNSET DR",
        "INFO:50 YOF ASTHMA",
        "DATE:08/29/12",
        "TIME:10:21");

    doTest("T14",
        "[berks.680@rsix.roamsecure.net] Unit:M680E Status:Dispatched BLS TRAUMA ; 20 S SUMMIT AVE APT 1002 ; SENCIT APARTMENTS; COMMUNITY DR / HARDING AVE, BROOKE BLVD ; CUMRU ; FALL VICTIM CUT  ; 08/29/12 11:48\r\n" +
        "\r\n" +
        "Sent by Berks County RSAN to Southern Berks EMS All CALL\r\r\n" +
        "--\r\r\n" +
        "You received this message because you registered on Alert Berks.  To change your alerting preferences go to http://berks.alertpa.org\r\r\n" +
        "\r\n",

        "UNIT:M680E",
        "CALL:BLS TRAUMA",
        "ADDR:20 S SUMMIT AVE",
        "APT:1002",
        "CITY:CUMRU",
        "PLACE:SENCIT APARTMENTS",
        "X:COMMUNITY DR / HARDING AVE, BROOKE BLVD",
        "INFO:FALL VICTIM CUT",
        "DATE:08/29/12",
        "TIME:11:48");
  
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "FRM: \n" +
        "MSG:Unit:E1 Status:Dispatched MF ; SAINT LAWRENCE AVE N  PROSPECT ST ; ; ; SAINT LAWRENCE ; CHECK BETWEEN ABV  ; 11/10/12 22:27: Eff Body:Unit:E1 Status:Dispatched MF ; SAINT LAWRENCE AVE N  PROSPECT ST ; ; ; SAINT LAWRENCE ; CHECK BETWEEN ABV  ; 11/10/12 22:27:",

        "UNIT:E1",
        "CALL:MF - Misc",
        "ADDR:SAINT LAWRENCE AVE & N PROSPECT ST",
        "CITY:SAINT LAWRENCE",
        "INFO:CHECK BETWEEN ABV");

    doTest("T2",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:CO1 Status:Dispatched MVAUNK ; FAIRVIEW AVE S  22 ST ; ; ; MOUNT PENN ; 2 VEH/ FEMALE IS CRYING ON THE PHONE ; 11/09/19",

        "UNIT:CO1",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:FAIRVIEW AVE & S 22 ST",
        "CITY:MOUNT PENN",
        "INFO:2 VEH/ FEMALE IS CRYING ON THE PHONE");

    doTest("T3",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:R1 Status:Dispatched SF ; 3248 MORGANTOWN RD ; TURKEY HILL - MORGANTOWN RD (RT 10) ROBESON; UNKNOWN / RAMP E ; ROBESONS",

        "UNIT:R1",
        "CALL:SF - Structure Fire",
        "ADDR:3248 MORGANTOWN RD",
        "CITY:ROBESONS",              // SHould be ROBESON
        "PLACE:TURKEY HILL - MORGANTOWN RD (RT 10) ROBESON",
        "X:UNKNOWN / RAMP E");

    doTest("T4",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:E1 Status:Dispatched AFA ; 2929 OLEY TURNPIKE RD ; ; PARKVIEW RD / PERKIOMEN AVE ; SAINT LAWRENCE ; FIRE ALRM SOUNDINGI ; 11/01/12 18:42=",

        "UNIT:E1",
        "CALL:AFA - Fire Alarm",
        "ADDR:2929 OLEY TURNPIKE RD",
        "CITY:SAINT LAWRENCE",
        "X:PARKVIEW RD / PERKIOMEN AVE",
        "INFO:FIRE ALRM SOUNDINGI",
        "DATE:11/01/12",
        "TIME:18:42");

    doTest("T5",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:B1 Status:Dispatched BF ; 2900 OLEY TURNPIKE RD APT A8 ; ST LAWRENCE GARDEN APTS; PERKIOMEN AVE / PARKVIEW RD ; SAINT N LAWRENCE ; ; 10/30/12 01:59=",

        "UNIT:B1",
        "CALL:BF - Brush Fire",
        "ADDR:2900 OLEY TURNPIKE RD",
        "APT:A8",
        "CITY:SAINT N LAWRENCE",
        "PLACE:ST LAWRENCE GARDEN APTS",
        "X:PERKIOMEN AVE / PARKVIEW RD",
        "DATE:10/30/12",
        "TIME:01:59");

    doTest("T6",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:R1 Status:Dispatched CMA ; 1313 CARSONIA AVE ; ; MIDLAND AVE / OAK LN ; LOWER ALSACE ; ALMS ARE GOING OFF ; 10/29/12 02 3:17=",

        "UNIT:R1",
        "CALL:CMA - Carbon Monoxide",
        "ADDR:1313 CARSONIA AVE",
        "CITY:LOWER ALSACE",
        "X:MIDLAND AVE / OAK LN",
        "INFO:ALMS ARE GOING OFF");

    doTest("T7",
        "FRM: \nMSG:Unit:R1 Status:Dispatched MVAWITH ; 132 BINGAMAN RD ; ; PETSCH RD / ANGORA RD ; ALSACE ; 31YOF  ; 10/07/12 21:59:",
        "UNIT:R1",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:132 BINGAMAN RD",
        "CITY:ALSACE",
        "X:PETSCH RD / ANGORA RD",
        "INFO:31YOF");

    doTest("T8",
        "FRM: \nMSG:Unit:R1 Status:Dispatched VF ; 66 CENTURY DR ; ; DEAD END / WHITE BEAR RD ; ROBESON ; ; 10/02/12 19:58:",
        "UNIT:R1",
        "CALL:VF - Vehicle Fire",
        "ADDR:66 CENTURY DR",
        "CITY:ROBESON",
        "X:DEAD END / WHITE BEAR RD");

    doTest("T9",
        "FRM:\nMSG:Unit:CO1 Status:Dispatched HAZMAT ; 35 N 23 ST ; ; DENGLER ST / CUMBERLAND AVE ; MOUNT PENN ; ; 11/17/12 16:26:",
        "UNIT:CO1",
        "CALL:HAZMAT",
        "ADDR:35 N 23 ST",
        "CITY:MOUNT PENN",
        "X:DENGLER ST / CUMBERLAND AVE");

    doTest("T10",
        "FRM:\n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:SP1 Status:Dispatched VF ; 1700 MEMORIAL HWY BLOCK ; ; OLEY TURNPIKE RD / OAK LN ; OLEY ; VEH IN DRIVEWAY / AT EDGE BY",

        "UNIT:SP1",
        "CALL:VF - Vehicle Fire",
        "ADDR:1700 MEMORIAL HWY",
        "APT:BLOCK",
        "CITY:OLEY",
        "X:OLEY TURNPIKE RD / OAK LN",
        "INFO:VEH IN DRIVEWAY / AT EDGE BY");

  }
  
  @Test
  public void testRogerASpadt() {

    doTest("T1",
        "FRM: \n" +
        "SUBJ:1/2\n" +
        "MSG:Unit:RE7 Status:Dispatched SF ; 621 KATHRYN ST ; ; DARIEN ST / SNYDER ST ; READING ; GREY BLK SMOKE COMING FROM CHIMNEY ; 0;",

        "UNIT:RE7",
        "CALL:SF - Structure Fire",
        "ADDR:621 KATHRYN ST",
        "CITY:READING",
        "X:DARIEN ST / SNYDER ST",
        "INFO:GREY BLK SMOKE COMING FROM CHIMNEY");

  }
  
  public static void main(String[] args) {
    new PABerksCountyParserTest().generateTests("T1");
  }
}
