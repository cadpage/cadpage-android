package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Andover, KS
Contact: Active911
Agency name: Andover Fire and Rescue
Location: Andover, KS, United States
Sender: DispatchMail@andoverks.com

(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE Call Received Time: 6/23/2013 01:16:49 \nANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \nDispatch: 6/23/2013 01:16:54 \nPrimary Incident: 13-0000667 Call Number: 117620 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 1607 E CENTRAL AVE Call Received Time: 6/22/2013 8:49:51 PM \nANDOVER KS MapRegions: CENTRAL PARK CrossStreets: N YORKTOWN RD 0.29 mi NW N PRAIRIE CREEK RD 0.28 mi NE ANDOVER CENTRAL PARK \nDispatch: 6/22/2013 8:50:10 PM \nPrimary Incident: 13-0000666 Call Number: 117608 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 426 S ANDOVER RD Call Received Time: 6/22/2013 11:56:40 \nANDOVER KS MapRegions: ANDOVER CROSSING CrossStreets: E HWY 54 0.14 mi W W TUSCANY DR 1.90 mi S ATWOODS \nDispatch: 6/22/2013 11:56:45 \nPrimary Incident: 13-0000664 Call Number: 117589 \nDescription:  \nReferenceText:
(CAD Call) FIRE - PUBLIC ASSIST SW 130TH ST & SW BUTLER RD Call Received Time: 6/22/2013 09:23:04 \nANDOVER KS MapRegions:  CrossStreets:  \nDispatch: 6/22/2013 09:23:18 \nPrimary Incident: 13-0000663 Call Number: 117584 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE, Apt. C36 Call Received Time: 6/22/2013 00:08:54 \nANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \nDispatch: 6/22/2013 00:09:37 \nPrimary Incident: 13-0000661 Call Number: 117566 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST, Apt. 206 Call Received Time: 6/21/2013 21:26:04 \nANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W  \nDispatch: 6/21/2013 21:26:47 \nPrimary Incident: 13-0000660 Call Number: 117554 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 229 N ANDOVER RD, Apt. 500 Call Received Time: 6/21/2013 15:43:59 \nANDOVER KS MapRegions: BRANSON ADD CrossStreets: W 1ST ST 0.07 mi SE W 2ND ST 0.07 mi NE SUPER CUTS \nDispatch: 6/21/2013 15:47:13 \nPrimary Incident: 13-0000659 Call Number: 117538 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: ABDONMINAL PAIN\n2. EMS enroute?: YES\n3. Any rescue/medical aid in progress?: NO\n\n30 YEAR OLD FEMALE, UNKNOWN MEDICAL. ABDOMINAL PAIN\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 9650 SW EUGENE RD Call Received Time: 6/21/2013 12:14:11 \nBUTLER COUNTY KS MapRegions: COOMBS 1ST ADD RE-RECD CrossStreets: SW 96TH ST 0.03 mi W SW 98TH ST 0.13 mi S  \nDispatch: 6/21/2013 12:14:27 \nPrimary Incident: 13-0000658 Call Number: 117528 \nDescription:  \nReferenceText:
(CAD Call) FIRE - BRUSH/GRASS FIRE 3119 E HARRY ST Call Received Time: 6/20/2013 21:28:20 \nBUTLER COUNTY KS MapRegions:  CrossStreets: S PRAIRIE CREEK RD 0.92 mi W S I35 HWY 3616.13 mi N  \nDispatch: 6/20/2013 21:30:25 Dispatch: 6/20/2013 21:30:25 \nPrimary Incident: 13-0000657 Call Number: 117495 \nDescription: TO THE WEST, NEXT DOOR - TO THE BACK (MOBILE HOME) \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 217 W MAY ST Call Received Time: 6/20/2013 16:51:23 \nANDOVER KS MapRegions: HODGES 2ND SUBDIV CrossStreets: N MAIN ST 0.06 mi E S MERIDIAN AVE 13.17 mi W  \nDispatch: 6/20/2013 16:53:26 \nPrimary Incident: 13-0000655 Call Number: 117485 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: CHEST PAINS\n2. EMS enroute?: Y\n3. Any rescue/medical aid in progress?: U\n\n\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 211 W 8TH ST Call Received Time: 6/18/2013 21:23:55 \nANDOVER KS MapRegions: BARRINER TRACTS CrossStreets: N ANDOVER RD 0.09 mi E N BROADVIEW LN 0.13 mi W  \nDispatch: 6/18/2013 21:26:19 \nPrimary Incident: 13-0000654 Call Number: 117409 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: HEMORRAGE (FOOT)\n2. EMS enroute?: A\n3. Any rescue/medical aid in progress?: U\n\n\n84 MALE WITH BLOOD COMING FROM FOOT. \n\n\n \nReferenceText:
(CAD Call) FIRE - NATURAL GAS ODOR 943 N ANDOVER RD Call Received Time: 6/18/2013 11:56:27 \nANDOVER KS MapRegions:  CrossStreets: E 21ST ST 6218.40 mi NW SW BUTLER RD 6607.89 mi W KINDER KARE \nDispatch: 6/18/2013 11:56:34 \nPrimary Incident: 13-0000652 Call Number: 117385 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/18/2013 10:34:57 \nANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \nDispatch: 6/18/2013 10:36:17 \nPrimary Incident: 13-0000651 Call Number: 117381 \nDescription: STILL HAVING DIFF BREATHING \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 3022 SW HWY 54 Call Received Time: 6/18/2013 10:27:57 \nBUTLER COUNTY KS MapRegions:  CrossStreets: SW BOYER RD 0.16 mi E SW PURITY SPRINGS RD 0.85 mi W  \nDispatch: 6/18/2013 10:28:19 \nPrimary Incident: 13-0000650 Call Number: 117380 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/18/2013 09:07:53 \nANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \nDispatch: 6/18/2013 09:10:03 \nPrimary Incident: 13-0000649 Call Number: 117372 \nDescription: DIFF BREATHING\n\n82 YOF  BADLY CONJUESTED, TRYING TO TAKE A BREATHING \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/18/2013 09:07:53 \nANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \nDispatch: 6/18/2013 09:09:45 \nPrimary Incident: 13-0000649 Call Number: 117372 \nDescription: DIFF BREATHING\n\n82 YOF  BADLY CONJUESTED, TRYING TO TAKE A BREATHING \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 147 S ELM CT Call Received Time: 6/16/2013 10:18:37 \nANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 3RD CrossStreets: W ELM 0.03 mi N W ELM 0.03 mi N  \nDispatch: 6/16/2013 10:22:01 \nPrimary Incident: 13-0000648 Call Number: 117279 \nDescription: 14 YO \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST Call Received Time: 6/16/2013 08:29:59 \nANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER \nDispatch: 6/16/2013 08:31:25 \nPrimary Incident: 13-0000647 Call Number: 117275 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: INDV IS CODING\n2. EMS enroute?: Y\n3. Any rescue/medical aid in progress?: U\n\n\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/15/2013 08:38:26 \nANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \nDispatch: 6/15/2013 08:39:10 \nPrimary Incident: 13-0000644 Call Number: 117225 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 224 E CENTRAL AVE Call Received Time: 6/15/2013 01:51:02 \nANDOVER KS MapRegions:  CrossStreets: N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME \nDispatch: 6/15/2013 01:52:17 \nPrimary Incident: 13-0000642 Call Number: 117210 \nDescription: ROOM 17 \nReferenceText:
(CAD Call) FIRE - PUBLIC ASSIST 120 S LAKESIDE DR Call Received Time: 6/14/2013 11:06:39 \nANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 3RD CrossStreets: N LAKESIDE DR 0.04 mi N W ELM 0.06 mi SW  \nDispatch: 6/14/2013 11:08:39 \nPrimary Incident: 13-0000641 Call Number: 117166 \nDescription: PARAPOLIGIC  NEEDS LIFTED INTO VAN \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 636 S DUBLIN DR Call Received Time: 6/14/2013 10:48:52 \nANDOVER KS MapRegions: HIGHLANDS 1ST ADD CrossStreets: S HIGHLAND DR 0.02 mi W S HIGHLAND DR 0.12 mi S  \nDispatch: 6/14/2013 10:52:22 \nPrimary Incident: 13-0000640 Call Number: 117165 \nDescription: HUSBAND IS   VERY ILL ,LOST FUNCTION OF HIS LEGS, NEEDS TAKEN TO THE HOSPITAL\n\n49YOM CEST PAIN \nReferenceText:
(CAD Call) FIRE - HAZ-MAT RESPONSE N ANDOVER RD & E 13TH ST Call Received Time: 6/14/2013 10:34:21 \nANDOVER KS MapRegions: HODGES TRACTS CrossStreets:  \nDispatch: 6/14/2013 10:36:23 \nPrimary Incident: 13-0000639 Call Number: 117163 \nDescription: 13TH AND ANDOVER   SMALL GAS SERVICE  300 FEET SOUTH OF 13TH ON EAST ANDOVER RD \nReferenceText:
(CAD Call) FIRE - ALARM RESIDENTIAL 224 E CEDAR RIDGE CT Call Received Time: 6/13/2013 21:35:16 \nANDOVER KS MapRegions: FLINT HILLS NAT'L ADD(PHASE 2) CrossStreets: SW FLINT HILLS NATIONAL DR 0.15 mi E SW FLINT HILLS NATIONAL DR 0.16 mi E  \nDispatch: 6/13/2013 21:36:14 \nPrimary Incident: 13-0000638 Call Number: 117131 \nDescription: PANIC KEY PAD ALERT \nReferenceText:
(CAD Call) FIRE - HAZ-MAT RESPONSE 1106 W MULBERRY CT Call Received Time: 6/13/2013 16:16:05 \nANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 2ND CrossStreets: N LAKESIDE DR 0.06 mi W  \nDispatch: 6/13/2013 16:17:20 \nPrimary Incident: 13-0000637 Call Number: 117117 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 612 N ANDOVER RD Call Received Time: 6/13/2013 15:36:01 \nANDOVER KS MapRegions:  CrossStreets: W LEE ST 0.07 mi S W VIRGINIA RD 0.02 mi N WICHITA CLINIC \nDispatch: 6/13/2013 15:39:19 \nPrimary Incident: 13-0000636 Call Number: 117115 \nDescription: 37 FEMALE\nBACK\nDIFFICULTY BREATHING \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 326 E WOODS AVE Call Received Time: 6/13/2013 15:37:30 \nANDOVER KS MapRegions: GOLDEN SPUR ADD CrossStreets: N SHAY RD 0.03 mi E N PORTH AVE 0.10 mi W  \nDispatch: 6/13/2013 15:38:38 \nPrimary Incident: 13-0000635 Call Number: 117116 \nDescription:  \nReferenceText:
(CAD Call) FIRE - RESCUE RESPONSE 1609 N STATE ST Call Received Time: 6/13/2013 12:04:11 \nAUGUSTA KS MapRegions:  CrossStreets: W SHIRLEY AVE 0.07 mi N E JOSEPHINE AVE 0.03 mi S  \nDispatch: 6/13/2013 12:04:18 \nPrimary Incident: 13-0000634 Call Number: 117104 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 224 E CENTRAL AVE, Apt. F18 Call Received Time: 6/13/2013 09:53:10 \nANDOVER KS MapRegions:  CrossStreets: N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME \nDispatch: 6/13/2013 09:57:29 \nPrimary Incident: 13-0000633 Call Number: 117097 \nDescription:  \nReferenceText:
(CAD Call) FIRE - ALARM COMMERCIAL 715 E 13TH ST Call Received Time: 6/13/2013 08:43:31 \nANDOVER KS MapRegions:  CrossStreets: N LAVERN ST 0.34 mi W SW 80TH ST 0.57 mi E BUTLER COUNTY COMMUNITIY COLLEGE, 5000 BLDG \nDispatch: 6/13/2013 08:46:04 \nPrimary Incident: 13-0000632 Call Number: 117092 \nDescription: *** SOP Begin ***\n\n1. TYPE OF ALARM?: FIRE\n2. PRECISE LOCATION OF EMERGENCY?: ZONE 1\n3. ARE BUILDING SPRINKLERS ACTIVATED?: No\n4. Nature of alarm?: FIRE\n5. Anyone on scene?: UNKNOWN\n6. Responsible contacted?: NOT YET\n\n\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 3016 E CENTRAL AVE Call Received Time: 6/12/2013 16:08:20 \nANDOVER KS MapRegions:  CrossStreets: E K96 HWY 6218.40 mi NW N I35 HWY 6218.40 mi NW  \nDispatch: 6/12/2013 16:08:46 \nPrimary Incident: 13-0000631 Call Number: 117059 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 1115 E HWY 54 Call Received Time: 6/12/2013 15:38:19 \nANDOVER KS MapRegions: MARKETPLACE EAST ADD CrossStreets: S MCCANDLESS DR 0.10 mi E S SUNSET DR 0.45 mi W YMCA \nDispatch: 6/12/2013 15:41:02 \nPrimary Incident: 13-0000630 Call Number: 117056 \nDescription: 20 YEAR OLD FEMALE WAS STUNG BY A BEE AND NOW HER THROAT IS SWOLLEN\nENTERY FRONT ENTRANCE. LIFEGUARD.\n733-9622 \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 1202 N ANDOVER RD Call Received Time: 6/12/2013 14:20:06 \nANDOVER KS MapRegions: ANDOVER COMMERICAL SUBD CrossStreets: W 13TH ST 0.17 mi N E COMMERCE ST 0.09 mi SW TREESCAPES \nDispatch: 6/12/2013 14:21:33 \nPrimary Incident: 13-0000629 Call Number: 117053 \nDescription: PAIN RT SIDE  65 YOF \nReferenceText:
(CAD Call) FIRE - PUBLIC ASSIST 600 HEATHER LAKE CT Call Received Time: 6/12/2013 10:13:01 \nANDOVER KS MapRegions:  CrossStreets:  \nDispatch: 6/12/2013 10:13:30 \nPrimary Incident: 13-0000628 Call Number: 117043 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 224 E CENTRAL AVE Call Received Time: 6/12/2013 08:50:56 \nANDOVER KS MapRegions:  CrossStreets: N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME \nDispatch: 6/12/2013 08:52:56 \nPrimary Incident: 13-0000627 Call Number: 117036 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: FALL\n2 EMS enroute?: YES\n3. Any rescue/medical aid in progress?: YES\n\nRM G44B  GRANDRAPIDS   58 YOM\n\nFALL\n\nN DOOR\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 12548 SW WAGON WHEEL RD Call Received Time: 6/12/2013 07:35:18 \nBUTLER COUNTY KS MapRegions: WAGON WHEEL RANCH CrossStreets: SW FRONTIER TRAIL RD 0.02 mi S  \nDispatch: 6/12/2013 07:36:10 \nPrimary Incident: 13-0000626 Call Number: 117030 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 7391 SW SANTA FE LAKE RD Call Received Time: 6/11/2013 14:48:11 \nBUTLER COUNTY KS MapRegions:  CrossStreets: SW 70TH ST 0.34 mi N SW 75TH ST 0.19 mi SE  \nDispatch: 6/11/2013 14:48:36 \nPrimary Incident: 13-0000625 Call Number: 116991 \nDescription: DIFF BREATHING \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 144 N KAREN LN Call Received Time: 6/11/2013 10:02:37 \nANDOVER KS MapRegions: GOLDEN SPUR 2ND ADD CrossStreets: E KAREN CT 0.01 mi W E MADISON AVE 0.04 mi S  \nDispatch: 6/11/2013 10:04:20 \nPrimary Incident: 13-0000624 Call Number: 116975 \nDescription: 58 YOF  STEPPING OVER SNOW FENCE  POSS RT BROKEN LEG \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE Call Received Time: 6/11/2013 08:03:15 \nANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \nDispatch: 6/11/2013 08:05:27 \nPrimary Incident: 13-0000623 Call Number: 116965 \nDescription: RM B23  81 YOM  BACK \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 1314 W ELM Call Received Time: 6/11/2013 07:02:48 \nANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 3RD CrossStreets: S LAKESIDE DR 0.02 mi SE S BIRCH CT 0.13 mi W  \nDispatch: 6/11/2013 07:04:20 \nPrimary Incident: 13-0000622 Call Number: 116962 \nDescription:  \nReferenceText:
(CAD Call) FIRE - VEHICLE FIRE 114 W HWY 54 Call Received Time: 6/11/2013 04:22:48 \nANDOVER KS MapRegions: PRAIRIE STAR ADDITION CrossStreets: S ANDOVER RD 0.06 mi SE S RIVERVIEW ST 0.10 mi W KWIK SHOP \nDispatch: 6/11/2013 04:23:03 \nPrimary Incident: 13-0000621 Call Number: 116960 \nDescription:  \nReferenceText:
(CAD Call) FIRE - BUILDING FIRE RESIDENTIAL 4399 SW CIRCLE RD Call Received Time: 6/10/2013 18:31:04 \nBUTLER COUNTY KS MapRegions:  CrossStreets: SW 43RD TER 0.13 mi NE SW 46TH TER 0.20 mi SE  \nDispatch: 6/10/2013 18:32:25 \nPrimary Incident: 13-0000620 Call Number: 116941 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 721 W 21ST ST Call Received Time: 6/10/2013 16:57:53 \nANDOVER KS MapRegions: NORTH MEADOW 2ND ADDITION CrossStreets: N MARC AVE 0.27 mi E N LAKESIDE DR 0.10 mi W ANDOVER COURT ASSISTED LIVING \nDispatch: 6/10/2013 16:58:56 \nPrimary Incident: 13-0000619 Call Number: 116940 \nDescription: STROKE \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 9735 SW SANTA FE LAKE RD Call Received Time: 6/10/2013 14:47:01 \nBUTLER COUNTY KS MapRegions: COOMBS SUBDIV RE-RECD CrossStreets: SW HWY 54 0.26 mi S SW 95TH ST 0.24 mi N  \nDispatch: 6/10/2013 14:47:11 \nPrimary Incident: 13-0000618 Call Number: 116932 \nDescription:  \nReferenceText:
(CAD Call) FIRE - RESCUE RESPONSE SW 70TH ST & SW SANTA FE LAKE RD Call Received Time: 6/10/2013 11:55:56 \nBUTLER COUNTY KS MapRegions: STONERIDGE ADD CrossStreets:  \nDispatch: 6/10/2013 11:56:21 \nPrimary Incident: 13-0000617 Call Number: 116914 \nDescription:  \nReferenceText:
(CAD Call) FIRE - AIRCRAFT EMERGENCY SW 70TH ST & SW SANTA FE LAKE RD Call Received Time: 6/10/2013 11:55:56 \nBUTLER COUNTY KS MapRegions: STONERIDGE ADD CrossStreets:  \nDispatch: 6/10/2013 11:56:06 \nPrimary Incident: 13-0000617 Call Number: 116914 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 12345 SW SUNRISE TRAIL Call Received Time: 6/10/2013 09:21:57 \nBUTLER COUNTY KS MapRegions: WAGON WHEEL RANCH CrossStreets: SW OVERLAND TRAIL RD 0.11 mi NW  \nDispatch: 6/10/2013 09:24:54 \nPrimary Incident: 13-0000616 Call Number: 116907 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: FALL FROM STANDING\n2. EMS enroute?: YES\n3. Any rescue/medical aid in progress?: NO\n\n65 YOF  \n\nWALKING DOWN THE STEPS AND SLIPED AND FELL  PROSTECTIC LEG  SOME BRISING\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 217 W MAY ST Call Received Time: 6/9/2013 22:35:15 \nANDOVER KS MapRegions: HODGES 2ND SUBDIV CrossStreets: N MAIN ST 0.06 mi E S MERIDIAN AVE 13.17 mi W  \nDispatch: 6/9/2013 22:35:49 \nPrimary Incident: 13-0000615 Call Number: 116891 \nDescription: CHEST PAINS \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 403 W TUSCANY DR Call Received Time: 6/8/2013 23:09:57 \nANDOVER KS MapRegions: TUSCANY ADD (PHASE 1) CrossStreets: S GLENHURST CT 0.02 mi NE S MCKENZIE CT 0.15 mi W  \nDispatch: 6/8/2013 23:11:20 \nPrimary Incident: 13-0000614 Call Number: 116843 \nDescription: HAVING A HARD TIME \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 102 Call Received Time: 6/8/2013 19:59:47 \nANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \nDispatch: 6/8/2013 20:00:34 \nPrimary Incident: 13-0000612 Call Number: 116833 \nDescription: DOOR LOCKED - KEY ON WINDOW TO KITCHEN ON \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 233 N STEPHANIE LN Call Received Time: 6/8/2013 17:45:33 \nANDOVER KS MapRegions: GOLDEN SPUR 2ND ADD CrossStreets: E RHONDDA AVE 0.04 mi NE N SUSAN LN 0.10 mi SW  \nDispatch: 6/8/2013 17:49:55 \nPrimary Incident: 13-0000611 Call Number: 116825 \nDescription: RP ADV THAT THERE IS A MAN PASSED \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 328 W 2ND ST, Apt. 17 Call Received Time: 6/8/2013 13:00:24 \nANDOVER KS MapRegions: COUNTRYSIDE ADD CrossStreets: N LIOBA DR 0.05 mi SW N ANDOVER RD 0.17 mi E  \nDispatch: 6/8/2013 13:01:02 \nPrimary Incident: 13-0000610 Call Number: 116814 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE, Apt. A80 Call Received Time: 6/7/2013 18:26:41 \nANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \nDispatch: 6/7/2013 18:29:02 \nPrimary Incident: 13-0000609 Call Number: 116777 \nDescription: FRONT TO LEFT\n90 YEARS OLD\nDIFFICULTY BREATHING \nReferenceText:
(CAD Call) FIRE - AIRCRAFT EMERGENCY 3013 E HWY 54 Call Received Time: 6/5/2013 18:15:37 \nBUTLER COUNTY KS MapRegions:  CrossStreets: S PAWHUSKA ST 0.03 mi W SW MEADOWLARK RD 0.12 mi E  \nDispatch: 6/5/2013 18:16:16 \nPrimary Incident: 13-0000605 Call Number: 116637 \nDescription:  \nReferenceText:
(CAD Call) FIRE - RESCUE RESPONSE SW SANTA FE LAKE RD & SW HWY 54 Call Received Time: 6/5/2013 04:34:05 \nBUTLER COUNTY KS MapRegions:  CrossStreets:  \nDispatch: 6/5/2013 04:37:27 \nPrimary Incident: 13-0000604 Call Number: 116595 \nDescription: *** SOP Begin ***\n\n1. NATURE OF RESCUE: 10-48 ONE VEHICLE\n2. WHAT CAUSED NEED FOR RESCUE?: 10-48\n3. Number of victims?: 1\n4. Best access for emergency responders?: 54/SANTA FE LAKE RD\n5. Name of contact person for Incident Command.: U\n\n\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE  Call Received Time: 6/5/2013 04:34:05 \nANDOVER KS MapRegions:  CrossStreets:  \nDispatch: 6/5/2013 04:34:10 \nPrimary Incident: 13-0000604 Call Number: 116595 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 524 N ANDOVER RD Call Received Time: 6/4/2013 16:15:09 \nANDOVER KS MapRegions:  CrossStreets: W LEE ST 0.02 mi SW W VIRGINIA RD 0.08 mi N FAMILY PHYSICIANS OF KANSAS \nDispatch: 6/4/2013 16:17:18 \nPrimary Incident: 13-0000601 Call Number: 116554 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: CHEST PAINS\n2 EMS enroute?: Y\n3. Any rescue/medical aid in progress?: U\n\n\n\nLEFT SIDE CHEST PAINS \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST Call Received Time: 6/4/2013 15:28:05 \nANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER \nDispatch: 6/4/2013 15:29:14 \nPrimary Incident: 13-0000600 Call Number: 116549 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: UNKNOWN MED\n2. EMS enroute?: Y\n3. Any rescue/medical aid in progress?: U\n\n\n\n \nReferenceText:
(CAD Call) FIRE - LANDING ZONE 1124 W 21ST ST Call Received Time: 6/4/2013 11:41:27 \nANDOVER KS MapRegions: CORNERSTONE MEDICAL ADDITION CrossStreets: N QUAIL CROSSING 0.07 mi W N KEYSTONE PKY 0.02 mi E KANSAS MEDICAL CENTER \nDispatch: 6/4/2013 12:19:52 \nPrimary Incident: 13-0000599 Call Number: 116526 \nDescription: ETA IS 1300 HRS \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 225 E CLOUD AVE Call Received Time: 6/3/2013 18:02:39 \nANDOVER KS MapRegions: MARKETPLACE COMMERCIAL ADD CrossStreets: S ANDOVER RD 0.07 mi W W CLOUD AVE 0.07 mi W DILLONS MARKETPLACE \nDispatch: 6/3/2013 18:04:21 \nPrimary Incident: 13-0000597 Call Number: 116454 \nDescription: NEAR THE MILK COOLERS \nReferenceText:
(CAD Call) FIRE - LANDING ZONE 1124 W 21ST ST Call Received Time: 6/3/2013 09:55:44 \nANDOVER KS MapRegions: CORNERSTONE MEDICAL ADDITION CrossStreets: N QUAIL CROSSING 0.07 mi W N KEYSTONE PKY 0.02 mi E KANSAS MEDICAL CENTER \nDispatch: 6/3/2013 09:57:19 \nPrimary Incident: 13-0000596 Call Number: 116431 \nDescription: ETA WILL BE THERE AT 1020 \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 408 E CONNELL AVE Call Received Time: 6/2/2013 14:03:42 \nANDOVER KS MapRegions: GOLDEN SPUR ADD CrossStreets: N PORTH AVE 0.06 mi W N SHAY RD 0.07 mi E  \nDispatch: 6/2/2013 14:06:28 \nPrimary Incident: 13-0000593 Call Number: 116362 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 712 S HIGHLAND DR Call Received Time: 6/2/2013 12:50:12 \nANDOVER KS MapRegions: HIGHLANDS 3RD ADD CrossStreets: S DUBLIN DR 0.05 mi E S DUBLIN DR 0.11 mi N  \nDispatch: 6/2/2013 12:52:20 \nPrimary Incident: 13-0000592 Call Number: 116359 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: POSSI HEART ATTACK\n2. EMS enroute?: Y\n3. Any rescue/medical aid in progress?: U\n\n\n55 YO FEMALE \n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE, Apt. C 42 Call Received Time: 6/2/2013 03:48:33 \nANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \nDispatch: 6/2/2013 03:49:54 \nPrimary Incident: 13-0000591 Call Number: 116334 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: FALL VICTIM\n2. EMS enroute?: A\n3. Any rescue/medical aid in progress?: U\n\n\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST, Apt. 117 A Call Received Time: 6/1/2013 21:40:55 \nANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER \nDispatch: 6/1/2013 21:42:34 \nPrimary Incident: 13-0000590 Call Number: 116317 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: SICK CALL\n2. EMS enroute?: A\n3. Any rescue/medical aid in progress?: U\n\n\n\n \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 613 N GLENDEVON RD Call Received Time: 6/1/2013 11:54:52 \nANDOVER KS MapRegions: TERRADYNE ESTATES CrossStreets: N GLENDEVON PL 0.00 mi SW N GLENDEVON CT 0.07 mi NE  \nDispatch: 6/1/2013 11:57:00 \nPrimary Incident: 13-0000589 Call Number: 116294 \nDescription:  \nReferenceText:
(CAD Call) FIRE - MEDICAL RESPONSE 244 N GREENVALLEY DR Call Received Time: 6/1/2013 10:38:56 \nANDOVER KS MapRegions: GREEN VALLEY 1ST ADD CrossStreets: N LAKESIDE DR 0.03 mi SE N OAKMONT CT 0.05 mi NW  \nDispatch: 6/1/2013 10:44:58 \nPrimary Incident: 13-0000588 Call Number: 116291 \nDescription: *** SOP Begin ***\n\n1. Nature of call?: CHEST PAINS\n2 EMS enroute?: Y\n3. Any rescue/medical aid in progress?: U\n\n\n\n \nReferenceText:

*/

public class KSAndoverParserTest extends BaseParserTest {
  
  public KSAndoverParserTest() {
    setParser(new KSAndoverParser(), "ANDOVER", "KS");
  }
  
  @Test
  public void testAndoverFireAndRescue() {

    doTest("T1",
        "(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE Call Received Time: 6/23/2013 01:16:49 \n" +
        "ANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \n" +
        "Dispatch: 6/23/2013 01:16:54 \n" +
        "Primary Incident: 13-0000667 Call Number: 117620 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000667/117620",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:408 E CENTRAL AVE",
        "CITY:ANDOVER",
        "DATE:6/23/2013",
        "TIME:01:16:54",
        "MAP:MEADOWS 3RD ADD",
        "X:N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING");

    doTest("T2",
        "(CAD Call) FIRE - MEDICAL RESPONSE 1607 E CENTRAL AVE Call Received Time: 6/22/2013 8:49:51 PM \n" +
        "ANDOVER KS MapRegions: CENTRAL PARK CrossStreets: N YORKTOWN RD 0.29 mi NW N PRAIRIE CREEK RD 0.28 mi NE ANDOVER CENTRAL PARK \n" +
        "Dispatch: 6/22/2013 8:50:10 PM \n" +
        "Primary Incident: 13-0000666 Call Number: 117608 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000666/117608",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:1607 E CENTRAL AVE",
        "CITY:PM  ANDOVER",
        "DATE:6/22/2013",
        "TIME:8:50:10 PM",
        "MAP:CENTRAL PARK",
        "X:N YORKTOWN RD 0.29 mi NW N PRAIRIE CREEK RD 0.28 mi NE ANDOVER CENTRAL PARK");

    doTest("T3",
        "(CAD Call) FIRE - MEDICAL RESPONSE 426 S ANDOVER RD Call Received Time: 6/22/2013 11:56:40 \n" +
        "ANDOVER KS MapRegions: ANDOVER CROSSING CrossStreets: E HWY 54 0.14 mi W W TUSCANY DR 1.90 mi S ATWOODS \n" +
        "Dispatch: 6/22/2013 11:56:45 \n" +
        "Primary Incident: 13-0000664 Call Number: 117589 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000664/117589",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:426 S ANDOVER RD",
        "CITY:ANDOVER",
        "DATE:6/22/2013",
        "TIME:11:56:45",
        "MAP:ANDOVER CROSSING",
        "X:E HWY 54 0.14 mi W W TUSCANY DR 1.90 mi S ATWOODS");

    doTest("T4",
        "(CAD Call) FIRE - PUBLIC ASSIST SW 130TH ST & SW BUTLER RD Call Received Time: 6/22/2013 09:23:04 \n" +
        "ANDOVER KS MapRegions:  CrossStreets:  \n" +
        "Dispatch: 6/22/2013 09:23:18 \n" +
        "Primary Incident: 13-0000663 Call Number: 117584 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000663/117584",
        "CALL:FIRE - PUBLIC ASSIST",
        "ADDR:SW 130TH ST & SW BUTLER RD",
        "CITY:ANDOVER",
        "DATE:6/22/2013",
        "TIME:09:23:18");

    doTest("T5",
        "(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE, Apt. C36 Call Received Time: 6/22/2013 00:08:54 \n" +
        "ANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \n" +
        "Dispatch: 6/22/2013 00:09:37 \n" +
        "Primary Incident: 13-0000661 Call Number: 117566 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000661/117566",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:408 E CENTRAL AVE",
        "APT:C36",
        "CITY:ANDOVER",
        "DATE:6/22/2013",
        "TIME:00:09:37",
        "MAP:MEADOWS 3RD ADD",
        "X:N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING");

    doTest("T6",
        "(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST, Apt. 206 Call Received Time: 6/21/2013 21:26:04 \n" +
        "ANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W  \n" +
        "Dispatch: 6/21/2013 21:26:47 \n" +
        "Primary Incident: 13-0000660 Call Number: 117554 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000660/117554",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:621 W 21ST ST",
        "APT:206",
        "CITY:ANDOVER",
        "DATE:6/21/2013",
        "TIME:21:26:47",
        "MAP:ANDOVER HGTS 8TH ADD",
        "X:N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W");

    doTest("T7",
        "(CAD Call) FIRE - MEDICAL RESPONSE 229 N ANDOVER RD, Apt. 500 Call Received Time: 6/21/2013 15:43:59 \n" +
        "ANDOVER KS MapRegions: BRANSON ADD CrossStreets: W 1ST ST 0.07 mi SE W 2ND ST 0.07 mi NE SUPER CUTS \n" +
        "Dispatch: 6/21/2013 15:47:13 \n" +
        "Primary Incident: 13-0000659 Call Number: 117538 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: ABDONMINAL PAIN\n" +
        "2. EMS enroute?: YES\n" +
        "3. Any rescue/medical aid in progress?: NO\n\n" +
        "30 YEAR OLD FEMALE, UNKNOWN MEDICAL. ABDOMINAL PAIN\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000659/117538",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:229 N ANDOVER RD",
        "APT:500",
        "CITY:ANDOVER",
        "DATE:6/21/2013",
        "TIME:15:47:13",
        "MAP:BRANSON ADD",
        "X:W 1ST ST 0.07 mi SE W 2ND ST 0.07 mi NE SUPER CUTS",
        "INFO:*** SOP Begin *** 1. Nature of call?: ABDONMINAL PAIN 2. EMS enroute?: YES 3. Any rescue/medical aid in progress?: NO 30 YEAR OLD FEMALE, UNKNOWN MEDICAL. ABDOMINAL PAIN");

    doTest("T8",
        "(CAD Call) FIRE - MEDICAL RESPONSE 9650 SW EUGENE RD Call Received Time: 6/21/2013 12:14:11 \n" +
        "BUTLER COUNTY KS MapRegions: COOMBS 1ST ADD RE-RECD CrossStreets: SW 96TH ST 0.03 mi W SW 98TH ST 0.13 mi S  \n" +
        "Dispatch: 6/21/2013 12:14:27 \n" +
        "Primary Incident: 13-0000658 Call Number: 117528 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000658/117528",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:9650 SW EUGENE RD",
        "CITY:BUTLER COUNTY",
        "DATE:6/21/2013",
        "TIME:12:14:27",
        "MAP:COOMBS 1ST ADD RE-RECD",
        "X:SW 96TH ST 0.03 mi W SW 98TH ST 0.13 mi S");

    doTest("T9",
        "(CAD Call) FIRE - BRUSH/GRASS FIRE 3119 E HARRY ST Call Received Time: 6/20/2013 21:28:20 \n" +
        "BUTLER COUNTY KS MapRegions:  CrossStreets: S PRAIRIE CREEK RD 0.92 mi W S I35 HWY 3616.13 mi N  \n" +
        "Dispatch: 6/20/2013 21:30:25 Dispatch: 6/20/2013 21:30:25 \n" +
        "Primary Incident: 13-0000657 Call Number: 117495 \n" +
        "Description: TO THE WEST, NEXT DOOR - TO THE BACK (MOBILE HOME) \n" +
        "ReferenceText:",

        "CALL:FIRE - BRUSH/GRASS FIRE",
        "ADDR:3119 E HARRY ST",
        "CITY:BUTLER COUNTY",
        "DATE:6/20/2013",
        "TIME:21:30:25",
        "X:S PRAIRIE CREEK RD 0.92 mi W S I35 HWY 3616.13 mi N");

    doTest("T10",
        "(CAD Call) FIRE - MEDICAL RESPONSE 217 W MAY ST Call Received Time: 6/20/2013 16:51:23 \n" +
        "ANDOVER KS MapRegions: HODGES 2ND SUBDIV CrossStreets: N MAIN ST 0.06 mi E S MERIDIAN AVE 13.17 mi W  \n" +
        "Dispatch: 6/20/2013 16:53:26 \n" +
        "Primary Incident: 13-0000655 Call Number: 117485 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: CHEST PAINS\n" +
        "2. EMS enroute?: Y\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000655/117485",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:217 W MAY ST",
        "CITY:ANDOVER",
        "DATE:6/20/2013",
        "TIME:16:53:26",
        "MAP:HODGES 2ND SUBDIV",
        "X:N MAIN ST 0.06 mi E S MERIDIAN AVE 13.17 mi W",
        "INFO:*** SOP Begin *** 1. Nature of call?: CHEST PAINS 2. EMS enroute?: Y 3. Any rescue/medical aid in progress?: U");

    doTest("T11",
        "(CAD Call) FIRE - MEDICAL RESPONSE 211 W 8TH ST Call Received Time: 6/18/2013 21:23:55 \n" +
        "ANDOVER KS MapRegions: BARRINER TRACTS CrossStreets: N ANDOVER RD 0.09 mi E N BROADVIEW LN 0.13 mi W  \n" +
        "Dispatch: 6/18/2013 21:26:19 \n" +
        "Primary Incident: 13-0000654 Call Number: 117409 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: HEMORRAGE (FOOT)\n" +
        "2. EMS enroute?: A\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n" +
        "84 MALE WITH BLOOD COMING FROM FOOT. \n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000654/117409",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:211 W 8TH ST",
        "CITY:ANDOVER",
        "DATE:6/18/2013",
        "TIME:21:26:19",
        "MAP:BARRINER TRACTS",
        "X:N ANDOVER RD 0.09 mi E N BROADVIEW LN 0.13 mi W",
        "INFO:*** SOP Begin *** 1. Nature of call?: HEMORRAGE (FOOT) 2. EMS enroute?: A 3. Any rescue/medical aid in progress?: U 84 MALE WITH BLOOD COMING FROM FOOT.");

    doTest("T12",
        "(CAD Call) FIRE - NATURAL GAS ODOR 943 N ANDOVER RD Call Received Time: 6/18/2013 11:56:27 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: E 21ST ST 6218.40 mi NW SW BUTLER RD 6607.89 mi W KINDER KARE \n" +
        "Dispatch: 6/18/2013 11:56:34 \n" +
        "Primary Incident: 13-0000652 Call Number: 117385 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000652/117385",
        "CALL:FIRE - NATURAL GAS ODOR",
        "ADDR:943 N ANDOVER RD",
        "CITY:ANDOVER",
        "DATE:6/18/2013",
        "TIME:11:56:34",
        "X:E 21ST ST 6218.40 mi NW SW BUTLER RD 6607.89 mi W KINDER KARE");

    doTest("T13",
        "(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/18/2013 10:34:57 \n" +
        "ANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \n" +
        "Dispatch: 6/18/2013 10:36:17 \n" +
        "Primary Incident: 13-0000651 Call Number: 117381 \n" +
        "Description: STILL HAVING DIFF BREATHING \n" +
        "ReferenceText:",

        "ID:13-0000651/117381",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:420 N LIOBA DR",
        "APT:503",
        "CITY:ANDOVER",
        "DATE:6/18/2013",
        "TIME:10:36:17",
        "MAP:KOOB TRACTS",
        "X:W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N",
        "INFO:STILL HAVING DIFF BREATHING");

    doTest("T14",
        "(CAD Call) FIRE - MEDICAL RESPONSE 3022 SW HWY 54 Call Received Time: 6/18/2013 10:27:57 \n" +
        "BUTLER COUNTY KS MapRegions:  CrossStreets: SW BOYER RD 0.16 mi E SW PURITY SPRINGS RD 0.85 mi W  \n" +
        "Dispatch: 6/18/2013 10:28:19 \n" +
        "Primary Incident: 13-0000650 Call Number: 117380 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000650/117380",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:3022 SW HWY 54",
        "CITY:BUTLER COUNTY",
        "DATE:6/18/2013",
        "TIME:10:28:19",
        "X:SW BOYER RD 0.16 mi E SW PURITY SPRINGS RD 0.85 mi W");

    doTest("T15",
        "(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/18/2013 09:07:53 \n" +
        "ANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \n" +
        "Dispatch: 6/18/2013 09:10:03 \n" +
        "Primary Incident: 13-0000649 Call Number: 117372 \n" +
        "Description: DIFF BREATHING\n\n" +
        "82 YOF  BADLY CONJUESTED, TRYING TO TAKE A BREATHING \n" +
        "ReferenceText:",

        "ID:13-0000649/117372",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:420 N LIOBA DR",
        "APT:503",
        "CITY:ANDOVER",
        "DATE:6/18/2013",
        "TIME:09:10:03",
        "MAP:KOOB TRACTS",
        "X:W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N",
        "INFO:DIFF BREATHING 82 YOF BADLY CONJUESTED, TRYING TO TAKE A BREATHING");

    doTest("T16",
        "(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/18/2013 09:07:53 \n" +
        "ANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \n" +
        "Dispatch: 6/18/2013 09:09:45 \n" +
        "Primary Incident: 13-0000649 Call Number: 117372 \n" +
        "Description: DIFF BREATHING\n\n" +
        "82 YOF  BADLY CONJUESTED, TRYING TO TAKE A BREATHING \n" +
        "ReferenceText:",

        "ID:13-0000649/117372",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:420 N LIOBA DR",
        "APT:503",
        "CITY:ANDOVER",
        "DATE:6/18/2013",
        "TIME:09:09:45",
        "MAP:KOOB TRACTS",
        "X:W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N",
        "INFO:DIFF BREATHING 82 YOF BADLY CONJUESTED, TRYING TO TAKE A BREATHING");

    doTest("T17",
        "(CAD Call) FIRE - MEDICAL RESPONSE 147 S ELM CT Call Received Time: 6/16/2013 10:18:37 \n" +
        "ANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 3RD CrossStreets: W ELM 0.03 mi N W ELM 0.03 mi N  \n" +
        "Dispatch: 6/16/2013 10:22:01 \n" +
        "Primary Incident: 13-0000648 Call Number: 117279 \n" +
        "Description: 14 YO \n" +
        "ReferenceText:",

        "ID:13-0000648/117279",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:147 S ELM CT",
        "CITY:ANDOVER",
        "DATE:6/16/2013",
        "TIME:10:22:01",
        "MAP:GREEN VALLEY GREEN CRSE 3RD",
        "X:W ELM 0.03 mi N W ELM 0.03 mi N",
        "INFO:14 YO");

    doTest("T18",
        "(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST Call Received Time: 6/16/2013 08:29:59 \n" +
        "ANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER \n" +
        "Dispatch: 6/16/2013 08:31:25 \n" +
        "Primary Incident: 13-0000647 Call Number: 117275 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: INDV IS CODING\n" +
        "2. EMS enroute?: Y\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000647/117275",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:621 W 21ST ST",
        "CITY:ANDOVER",
        "DATE:6/16/2013",
        "TIME:08:31:25",
        "MAP:ANDOVER HGTS 8TH ADD",
        "X:N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER",
        "INFO:*** SOP Begin *** 1. Nature of call?: INDV IS CODING 2. EMS enroute?: Y 3. Any rescue/medical aid in progress?: U");

    doTest("T19",
        "(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 503 Call Received Time: 6/15/2013 08:38:26 \n" +
        "ANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \n" +
        "Dispatch: 6/15/2013 08:39:10 \n" +
        "Primary Incident: 13-0000644 Call Number: 117225 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000644/117225",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:420 N LIOBA DR",
        "APT:503",
        "CITY:ANDOVER",
        "DATE:6/15/2013",
        "TIME:08:39:10",
        "MAP:KOOB TRACTS",
        "X:W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N");

    doTest("T20",
        "(CAD Call) FIRE - MEDICAL RESPONSE 224 E CENTRAL AVE Call Received Time: 6/15/2013 01:51:02 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME \n" +
        "Dispatch: 6/15/2013 01:52:17 \n" +
        "Primary Incident: 13-0000642 Call Number: 117210 \n" +
        "Description: ROOM 17 \n" +
        "ReferenceText:",

        "ID:13-0000642/117210",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:224 E CENTRAL AVE",
        "CITY:ANDOVER",
        "DATE:6/15/2013",
        "TIME:01:52:17",
        "X:N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME",
        "INFO:ROOM 17");

    doTest("T21",
        "(CAD Call) FIRE - PUBLIC ASSIST 120 S LAKESIDE DR Call Received Time: 6/14/2013 11:06:39 \n" +
        "ANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 3RD CrossStreets: N LAKESIDE DR 0.04 mi N W ELM 0.06 mi SW  \n" +
        "Dispatch: 6/14/2013 11:08:39 \n" +
        "Primary Incident: 13-0000641 Call Number: 117166 \n" +
        "Description: PARAPOLIGIC  NEEDS LIFTED INTO VAN \n" +
        "ReferenceText:",

        "ID:13-0000641/117166",
        "CALL:FIRE - PUBLIC ASSIST",
        "ADDR:120 S LAKESIDE DR",
        "CITY:ANDOVER",
        "DATE:6/14/2013",
        "TIME:11:08:39",
        "MAP:GREEN VALLEY GREEN CRSE 3RD",
        "X:N LAKESIDE DR 0.04 mi N W ELM 0.06 mi SW",
        "INFO:PARAPOLIGIC NEEDS LIFTED INTO VAN");

    doTest("T22",
        "(CAD Call) FIRE - MEDICAL RESPONSE 636 S DUBLIN DR Call Received Time: 6/14/2013 10:48:52 \n" +
        "ANDOVER KS MapRegions: HIGHLANDS 1ST ADD CrossStreets: S HIGHLAND DR 0.02 mi W S HIGHLAND DR 0.12 mi S  \n" +
        "Dispatch: 6/14/2013 10:52:22 \n" +
        "Primary Incident: 13-0000640 Call Number: 117165 \n" +
        "Description: HUSBAND IS   VERY ILL ,LOST FUNCTION OF HIS LEGS, NEEDS TAKEN TO THE HOSPITAL\n\n" +
        "49YOM CEST PAIN \n" +
        "ReferenceText:",

        "ID:13-0000640/117165",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:636 S DUBLIN DR",
        "CITY:ANDOVER",
        "DATE:6/14/2013",
        "TIME:10:52:22",
        "MAP:HIGHLANDS 1ST ADD",
        "X:S HIGHLAND DR 0.02 mi W S HIGHLAND DR 0.12 mi S",
        "INFO:HUSBAND IS VERY ILL ,LOST FUNCTION OF HIS LEGS, NEEDS TAKEN TO THE HOSPITAL 49YOM CEST PAIN");

    doTest("T23",
        "(CAD Call) FIRE - HAZ-MAT RESPONSE N ANDOVER RD & E 13TH ST Call Received Time: 6/14/2013 10:34:21 \n" +
        "ANDOVER KS MapRegions: HODGES TRACTS CrossStreets:  \n" +
        "Dispatch: 6/14/2013 10:36:23 \n" +
        "Primary Incident: 13-0000639 Call Number: 117163 \n" +
        "Description: 13TH AND ANDOVER   SMALL GAS SERVICE  300 FEET SOUTH OF 13TH ON EAST ANDOVER RD \n" +
        "ReferenceText:",

        "ID:13-0000639/117163",
        "CALL:FIRE - HAZ-MAT RESPONSE",
        "ADDR:N ANDOVER RD & E 13TH ST",
        "CITY:ANDOVER",
        "DATE:6/14/2013",
        "TIME:10:36:23",
        "MAP:HODGES TRACTS",
        "INFO:13TH AND ANDOVER SMALL GAS SERVICE 300 FEET SOUTH OF 13TH ON EAST ANDOVER RD");

    doTest("T24",
        "(CAD Call) FIRE - ALARM RESIDENTIAL 224 E CEDAR RIDGE CT Call Received Time: 6/13/2013 21:35:16 \n" +
        "ANDOVER KS MapRegions: FLINT HILLS NAT'L ADD(PHASE 2) CrossStreets: SW FLINT HILLS NATIONAL DR 0.15 mi E SW FLINT HILLS NATIONAL DR 0.16 mi E  \n" +
        "Dispatch: 6/13/2013 21:36:14 \n" +
        "Primary Incident: 13-0000638 Call Number: 117131 \n" +
        "Description: PANIC KEY PAD ALERT \n" +
        "ReferenceText:",

        "ID:13-0000638/117131",
        "CALL:FIRE - ALARM RESIDENTIAL",
        "ADDR:224 E CEDAR RIDGE CT",
        "CITY:ANDOVER",
        "DATE:6/13/2013",
        "TIME:21:36:14",
        "MAP:FLINT HILLS NAT'L ADD(PHASE 2)",
        "X:SW FLINT HILLS NATIONAL DR 0.15 mi E SW FLINT HILLS NATIONAL DR 0.16 mi E",
        "INFO:PANIC KEY PAD ALERT");

    doTest("T25",
        "(CAD Call) FIRE - HAZ-MAT RESPONSE 1106 W MULBERRY CT Call Received Time: 6/13/2013 16:16:05 \n" +
        "ANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 2ND CrossStreets: N LAKESIDE DR 0.06 mi W  \n" +
        "Dispatch: 6/13/2013 16:17:20 \n" +
        "Primary Incident: 13-0000637 Call Number: 117117 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000637/117117",
        "CALL:FIRE - HAZ-MAT RESPONSE",
        "ADDR:1106 W MULBERRY CT",
        "CITY:ANDOVER",
        "DATE:6/13/2013",
        "TIME:16:17:20",
        "MAP:GREEN VALLEY GREEN CRSE 2ND",
        "X:N LAKESIDE DR 0.06 mi W");

    doTest("T26",
        "(CAD Call) FIRE - MEDICAL RESPONSE 612 N ANDOVER RD Call Received Time: 6/13/2013 15:36:01 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: W LEE ST 0.07 mi S W VIRGINIA RD 0.02 mi N WICHITA CLINIC \n" +
        "Dispatch: 6/13/2013 15:39:19 \n" +
        "Primary Incident: 13-0000636 Call Number: 117115 \n" +
        "Description: 37 FEMALE\n" +
        "BACK\n" +
        "DIFFICULTY BREATHING \n" +
        "ReferenceText:",

        "ID:13-0000636/117115",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:612 N ANDOVER RD",
        "CITY:ANDOVER",
        "DATE:6/13/2013",
        "TIME:15:39:19",
        "X:W LEE ST 0.07 mi S W VIRGINIA RD 0.02 mi N WICHITA CLINIC",
        "INFO:37 FEMALE BACK DIFFICULTY BREATHING");

    doTest("T27",
        "(CAD Call) FIRE - MEDICAL RESPONSE 326 E WOODS AVE Call Received Time: 6/13/2013 15:37:30 \n" +
        "ANDOVER KS MapRegions: GOLDEN SPUR ADD CrossStreets: N SHAY RD 0.03 mi E N PORTH AVE 0.10 mi W  \n" +
        "Dispatch: 6/13/2013 15:38:38 \n" +
        "Primary Incident: 13-0000635 Call Number: 117116 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000635/117116",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:326 E WOODS AVE",
        "CITY:ANDOVER",
        "DATE:6/13/2013",
        "TIME:15:38:38",
        "MAP:GOLDEN SPUR ADD",
        "X:N SHAY RD 0.03 mi E N PORTH AVE 0.10 mi W");

    doTest("T28",
        "(CAD Call) FIRE - RESCUE RESPONSE 1609 N STATE ST Call Received Time: 6/13/2013 12:04:11 \n" +
        "AUGUSTA KS MapRegions:  CrossStreets: W SHIRLEY AVE 0.07 mi N E JOSEPHINE AVE 0.03 mi S  \n" +
        "Dispatch: 6/13/2013 12:04:18 \n" +
        "Primary Incident: 13-0000634 Call Number: 117104 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000634/117104",
        "CALL:FIRE - RESCUE RESPONSE",
        "ADDR:1609 N STATE ST",
        "CITY:AUGUSTA",
        "DATE:6/13/2013",
        "TIME:12:04:18",
        "X:W SHIRLEY AVE 0.07 mi N E JOSEPHINE AVE 0.03 mi S");

    doTest("T29",
        "(CAD Call) FIRE - MEDICAL RESPONSE 224 E CENTRAL AVE, Apt. F18 Call Received Time: 6/13/2013 09:53:10 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME \n" +
        "Dispatch: 6/13/2013 09:57:29 \n" +
        "Primary Incident: 13-0000633 Call Number: 117097 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000633/117097",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:224 E CENTRAL AVE",
        "APT:F18",
        "CITY:ANDOVER",
        "DATE:6/13/2013",
        "TIME:09:57:29",
        "X:N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME");

    doTest("T30",
        "(CAD Call) FIRE - ALARM COMMERCIAL 715 E 13TH ST Call Received Time: 6/13/2013 08:43:31 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: N LAVERN ST 0.34 mi W SW 80TH ST 0.57 mi E BUTLER COUNTY COMMUNITIY COLLEGE, 5000 BLDG \n" +
        "Dispatch: 6/13/2013 08:46:04 \n" +
        "Primary Incident: 13-0000632 Call Number: 117092 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. TYPE OF ALARM?: FIRE\n" +
        "2. PRECISE LOCATION OF EMERGENCY?: ZONE 1\n" +
        "3. ARE BUILDING SPRINKLERS ACTIVATED?: No\n" +
        "4. Nature of alarm?: FIRE\n" +
        "5. Anyone on scene?: UNKNOWN\n" +
        "6. Responsible contacted?: NOT YET\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000632/117092",
        "CALL:FIRE - ALARM COMMERCIAL",
        "ADDR:715 E 13TH ST",
        "CITY:ANDOVER",
        "DATE:6/13/2013",
        "TIME:08:46:04",
        "X:N LAVERN ST 0.34 mi W SW 80TH ST 0.57 mi E BUTLER COUNTY COMMUNITIY COLLEGE, 5000 BLDG",
        "INFO:*** SOP Begin *** 1. TYPE OF ALARM?: FIRE 2. PRECISE LOCATION OF EMERGENCY?: ZONE 1 3. ARE BUILDING SPRINKLERS ACTIVATED?: No 4. Nature of alarm?: FIRE 5. Anyone on scene?: UNKNOWN 6. Responsible contacted?: NOT YET");

    doTest("T31",
        "(CAD Call) FIRE - MEDICAL RESPONSE 3016 E CENTRAL AVE Call Received Time: 6/12/2013 16:08:20 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: E K96 HWY 6218.40 mi NW N I35 HWY 6218.40 mi NW  \n" +
        "Dispatch: 6/12/2013 16:08:46 \n" +
        "Primary Incident: 13-0000631 Call Number: 117059 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000631/117059",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:3016 E CENTRAL AVE",
        "CITY:ANDOVER",
        "DATE:6/12/2013",
        "TIME:16:08:46",
        "X:E K96 HWY 6218.40 mi NW N I35 HWY 6218.40 mi NW");

    doTest("T32",
        "(CAD Call) FIRE - MEDICAL RESPONSE 1115 E HWY 54 Call Received Time: 6/12/2013 15:38:19 \n" +
        "ANDOVER KS MapRegions: MARKETPLACE EAST ADD CrossStreets: S MCCANDLESS DR 0.10 mi E S SUNSET DR 0.45 mi W YMCA \n" +
        "Dispatch: 6/12/2013 15:41:02 \n" +
        "Primary Incident: 13-0000630 Call Number: 117056 \n" +
        "Description: 20 YEAR OLD FEMALE WAS STUNG BY A BEE AND NOW HER THROAT IS SWOLLEN\n" +
        "ENTERY FRONT ENTRANCE. LIFEGUARD.\n" +
        "733-9622 \n" +
        "ReferenceText:",

        "ID:13-0000630/117056",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:1115 E HWY 54",
        "CITY:ANDOVER",
        "DATE:6/12/2013",
        "TIME:15:41:02",
        "MAP:MARKETPLACE EAST ADD",
        "X:S MCCANDLESS DR 0.10 mi E S SUNSET DR 0.45 mi W YMCA",
        "INFO:20 YEAR OLD FEMALE WAS STUNG BY A BEE AND NOW HER THROAT IS SWOLLEN ENTERY FRONT ENTRANCE. LIFEGUARD. 733-9622");

    doTest("T33",
        "(CAD Call) FIRE - MEDICAL RESPONSE 1202 N ANDOVER RD Call Received Time: 6/12/2013 14:20:06 \n" +
        "ANDOVER KS MapRegions: ANDOVER COMMERICAL SUBD CrossStreets: W 13TH ST 0.17 mi N E COMMERCE ST 0.09 mi SW TREESCAPES \n" +
        "Dispatch: 6/12/2013 14:21:33 \n" +
        "Primary Incident: 13-0000629 Call Number: 117053 \n" +
        "Description: PAIN RT SIDE  65 YOF \n" +
        "ReferenceText:",

        "ID:13-0000629/117053",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:1202 N ANDOVER RD",
        "CITY:ANDOVER",
        "DATE:6/12/2013",
        "TIME:14:21:33",
        "MAP:ANDOVER COMMERICAL SUBD",
        "X:W 13TH ST 0.17 mi N E COMMERCE ST 0.09 mi SW TREESCAPES",
        "INFO:PAIN RT SIDE 65 YOF");

    doTest("T34",
        "(CAD Call) FIRE - PUBLIC ASSIST 600 HEATHER LAKE CT Call Received Time: 6/12/2013 10:13:01 \n" +
        "ANDOVER KS MapRegions:  CrossStreets:  \n" +
        "Dispatch: 6/12/2013 10:13:30 \n" +
        "Primary Incident: 13-0000628 Call Number: 117043 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000628/117043",
        "CALL:FIRE - PUBLIC ASSIST",
        "ADDR:600 HEATHER LAKE CT",
        "CITY:ANDOVER",
        "DATE:6/12/2013",
        "TIME:10:13:30");

    doTest("T35",
        "(CAD Call) FIRE - MEDICAL RESPONSE 224 E CENTRAL AVE Call Received Time: 6/12/2013 08:50:56 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME \n" +
        "Dispatch: 6/12/2013 08:52:56 \n" +
        "Primary Incident: 13-0000627 Call Number: 117036 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: FALL\n" +
        "2 EMS enroute?: YES\n" +
        "3. Any rescue/medical aid in progress?: YES\n\n" +
        "RM G44B  GRANDRAPIDS   58 YOM\n\n" +
        "FALL\n\n" +
        "N DOOR\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000627/117036",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:224 E CENTRAL AVE",
        "CITY:ANDOVER",
        "DATE:6/12/2013",
        "TIME:08:52:56",
        "X:N PORTH AVE 0.02 mi E W CENTRAL AVE 0.10 mi W VICTORIA FALLS - NURSING HOME",
        "INFO:*** SOP Begin *** 1. Nature of call?: FALL 2 EMS enroute?: YES 3. Any rescue/medical aid in progress?: YES RM G44B GRANDRAPIDS 58 YOM FALL N DOOR");

    doTest("T36",
        "(CAD Call) FIRE - MEDICAL RESPONSE 12548 SW WAGON WHEEL RD Call Received Time: 6/12/2013 07:35:18 \n" +
        "BUTLER COUNTY KS MapRegions: WAGON WHEEL RANCH CrossStreets: SW FRONTIER TRAIL RD 0.02 mi S  \n" +
        "Dispatch: 6/12/2013 07:36:10 \n" +
        "Primary Incident: 13-0000626 Call Number: 117030 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000626/117030",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:12548 SW WAGON WHEEL RD",
        "CITY:BUTLER COUNTY",
        "DATE:6/12/2013",
        "TIME:07:36:10",
        "MAP:WAGON WHEEL RANCH",
        "X:SW FRONTIER TRAIL RD 0.02 mi S");

    doTest("T37",
        "(CAD Call) FIRE - MEDICAL RESPONSE 7391 SW SANTA FE LAKE RD Call Received Time: 6/11/2013 14:48:11 \n" +
        "BUTLER COUNTY KS MapRegions:  CrossStreets: SW 70TH ST 0.34 mi N SW 75TH ST 0.19 mi SE  \n" +
        "Dispatch: 6/11/2013 14:48:36 \n" +
        "Primary Incident: 13-0000625 Call Number: 116991 \n" +
        "Description: DIFF BREATHING \n" +
        "ReferenceText:",

        "ID:13-0000625/116991",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:7391 SW SANTA FE LAKE RD",
        "CITY:BUTLER COUNTY",
        "DATE:6/11/2013",
        "TIME:14:48:36",
        "X:SW 70TH ST 0.34 mi N SW 75TH ST 0.19 mi SE",
        "INFO:DIFF BREATHING");

    doTest("T38",
        "(CAD Call) FIRE - MEDICAL RESPONSE 144 N KAREN LN Call Received Time: 6/11/2013 10:02:37 \n" +
        "ANDOVER KS MapRegions: GOLDEN SPUR 2ND ADD CrossStreets: E KAREN CT 0.01 mi W E MADISON AVE 0.04 mi S  \n" +
        "Dispatch: 6/11/2013 10:04:20 \n" +
        "Primary Incident: 13-0000624 Call Number: 116975 \n" +
        "Description: 58 YOF  STEPPING OVER SNOW FENCE  POSS RT BROKEN LEG \n" +
        "ReferenceText:",

        "ID:13-0000624/116975",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:144 N KAREN LN",
        "CITY:ANDOVER",
        "DATE:6/11/2013",
        "TIME:10:04:20",
        "MAP:GOLDEN SPUR 2ND ADD",
        "X:E KAREN CT 0.01 mi W E MADISON AVE 0.04 mi S",
        "INFO:58 YOF STEPPING OVER SNOW FENCE POSS RT BROKEN LEG");

    doTest("T39",
        "(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE Call Received Time: 6/11/2013 08:03:15 \n" +
        "ANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \n" +
        "Dispatch: 6/11/2013 08:05:27 \n" +
        "Primary Incident: 13-0000623 Call Number: 116965 \n" +
        "Description: RM B23  81 YOM  BACK \n" +
        "ReferenceText:",

        "ID:13-0000623/116965",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:408 E CENTRAL AVE",
        "CITY:ANDOVER",
        "DATE:6/11/2013",
        "TIME:08:05:27",
        "MAP:MEADOWS 3RD ADD",
        "X:N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING",
        "INFO:RM B23 81 YOM BACK");

    doTest("T40",
        "(CAD Call) FIRE - MEDICAL RESPONSE 1314 W ELM Call Received Time: 6/11/2013 07:02:48 \n" +
        "ANDOVER KS MapRegions: GREEN VALLEY GREEN CRSE 3RD CrossStreets: S LAKESIDE DR 0.02 mi SE S BIRCH CT 0.13 mi W  \n" +
        "Dispatch: 6/11/2013 07:04:20 \n" +
        "Primary Incident: 13-0000622 Call Number: 116962 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000622/116962",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:1314 W ELM",
        "CITY:ANDOVER",
        "DATE:6/11/2013",
        "TIME:07:04:20",
        "MAP:GREEN VALLEY GREEN CRSE 3RD",
        "X:S LAKESIDE DR 0.02 mi SE S BIRCH CT 0.13 mi W");

    doTest("T41",
        "(CAD Call) FIRE - VEHICLE FIRE 114 W HWY 54 Call Received Time: 6/11/2013 04:22:48 \n" +
        "ANDOVER KS MapRegions: PRAIRIE STAR ADDITION CrossStreets: S ANDOVER RD 0.06 mi SE S RIVERVIEW ST 0.10 mi W KWIK SHOP \n" +
        "Dispatch: 6/11/2013 04:23:03 \n" +
        "Primary Incident: 13-0000621 Call Number: 116960 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000621/116960",
        "CALL:FIRE - VEHICLE FIRE",
        "ADDR:114 W HWY 54",
        "CITY:ANDOVER",
        "DATE:6/11/2013",
        "TIME:04:23:03",
        "MAP:PRAIRIE STAR ADDITION",
        "X:S ANDOVER RD 0.06 mi SE S RIVERVIEW ST 0.10 mi W KWIK SHOP");

    doTest("T42",
        "(CAD Call) FIRE - BUILDING FIRE RESIDENTIAL 4399 SW CIRCLE RD Call Received Time: 6/10/2013 18:31:04 \n" +
        "BUTLER COUNTY KS MapRegions:  CrossStreets: SW 43RD TER 0.13 mi NE SW 46TH TER 0.20 mi SE  \n" +
        "Dispatch: 6/10/2013 18:32:25 \n" +
        "Primary Incident: 13-0000620 Call Number: 116941 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000620/116941",
        "CALL:FIRE - BUILDING FIRE RESIDENTIAL",
        "ADDR:4399 SW CIRCLE RD",
        "CITY:BUTLER COUNTY",
        "DATE:6/10/2013",
        "TIME:18:32:25",
        "X:SW 43RD TER 0.13 mi NE SW 46TH TER 0.20 mi SE");

    doTest("T43",
        "(CAD Call) FIRE - MEDICAL RESPONSE 721 W 21ST ST Call Received Time: 6/10/2013 16:57:53 \n" +
        "ANDOVER KS MapRegions: NORTH MEADOW 2ND ADDITION CrossStreets: N MARC AVE 0.27 mi E N LAKESIDE DR 0.10 mi W ANDOVER COURT ASSISTED LIVING \n" +
        "Dispatch: 6/10/2013 16:58:56 \n" +
        "Primary Incident: 13-0000619 Call Number: 116940 \n" +
        "Description: STROKE \n" +
        "ReferenceText:",

        "ID:13-0000619/116940",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:721 W 21ST ST",
        "CITY:ANDOVER",
        "DATE:6/10/2013",
        "TIME:16:58:56",
        "MAP:NORTH MEADOW 2ND ADDITION",
        "X:N MARC AVE 0.27 mi E N LAKESIDE DR 0.10 mi W ANDOVER COURT ASSISTED LIVING",
        "INFO:STROKE");

    doTest("T44",
        "(CAD Call) FIRE - MEDICAL RESPONSE 9735 SW SANTA FE LAKE RD Call Received Time: 6/10/2013 14:47:01 \n" +
        "BUTLER COUNTY KS MapRegions: COOMBS SUBDIV RE-RECD CrossStreets: SW HWY 54 0.26 mi S SW 95TH ST 0.24 mi N  \n" +
        "Dispatch: 6/10/2013 14:47:11 \n" +
        "Primary Incident: 13-0000618 Call Number: 116932 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000618/116932",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:9735 SW SANTA FE LAKE RD",
        "CITY:BUTLER COUNTY",
        "DATE:6/10/2013",
        "TIME:14:47:11",
        "MAP:COOMBS SUBDIV RE-RECD",
        "X:SW HWY 54 0.26 mi S SW 95TH ST 0.24 mi N");

    doTest("T45",
        "(CAD Call) FIRE - RESCUE RESPONSE SW 70TH ST & SW SANTA FE LAKE RD Call Received Time: 6/10/2013 11:55:56 \n" +
        "BUTLER COUNTY KS MapRegions: STONERIDGE ADD CrossStreets:  \n" +
        "Dispatch: 6/10/2013 11:56:21 \n" +
        "Primary Incident: 13-0000617 Call Number: 116914 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000617/116914",
        "CALL:FIRE - RESCUE RESPONSE",
        "ADDR:SW 70TH ST & SW SANTA FE LAKE RD",
        "CITY:BUTLER COUNTY",
        "DATE:6/10/2013",
        "TIME:11:56:21",
        "MAP:STONERIDGE ADD");

    doTest("T46",
        "(CAD Call) FIRE - AIRCRAFT EMERGENCY SW 70TH ST & SW SANTA FE LAKE RD Call Received Time: 6/10/2013 11:55:56 \n" +
        "BUTLER COUNTY KS MapRegions: STONERIDGE ADD CrossStreets:  \n" +
        "Dispatch: 6/10/2013 11:56:06 \n" +
        "Primary Incident: 13-0000617 Call Number: 116914 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000617/116914",
        "CALL:FIRE - AIRCRAFT EMERGENCY",
        "ADDR:SW 70TH ST & SW SANTA FE LAKE RD",
        "CITY:BUTLER COUNTY",
        "DATE:6/10/2013",
        "TIME:11:56:06",
        "MAP:STONERIDGE ADD");

    doTest("T47",
        "(CAD Call) FIRE - MEDICAL RESPONSE 12345 SW SUNRISE TRAIL Call Received Time: 6/10/2013 09:21:57 \n" +
        "BUTLER COUNTY KS MapRegions: WAGON WHEEL RANCH CrossStreets: SW OVERLAND TRAIL RD 0.11 mi NW  \n" +
        "Dispatch: 6/10/2013 09:24:54 \n" +
        "Primary Incident: 13-0000616 Call Number: 116907 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: FALL FROM STANDING\n" +
        "2. EMS enroute?: YES\n" +
        "3. Any rescue/medical aid in progress?: NO\n\n" +
        "65 YOF  \n\n" +
        "WALKING DOWN THE STEPS AND SLIPED AND FELL  PROSTECTIC LEG  SOME BRISING\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000616/116907",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:12345 SW SUNRISE TRAIL",
        "CITY:BUTLER COUNTY",
        "DATE:6/10/2013",
        "TIME:09:24:54",
        "MAP:WAGON WHEEL RANCH",
        "X:SW OVERLAND TRAIL RD 0.11 mi NW",
        "INFO:*** SOP Begin *** 1. Nature of call?: FALL FROM STANDING 2. EMS enroute?: YES 3. Any rescue/medical aid in progress?: NO 65 YOF WALKING DOWN THE STEPS AND SLIPED AND FELL PROSTECTIC LEG SOME BRISING");

    doTest("T48",
        "(CAD Call) FIRE - MEDICAL RESPONSE 217 W MAY ST Call Received Time: 6/9/2013 22:35:15 \n" +
        "ANDOVER KS MapRegions: HODGES 2ND SUBDIV CrossStreets: N MAIN ST 0.06 mi E S MERIDIAN AVE 13.17 mi W  \n" +
        "Dispatch: 6/9/2013 22:35:49 \n" +
        "Primary Incident: 13-0000615 Call Number: 116891 \n" +
        "Description: CHEST PAINS \n" +
        "ReferenceText:",

        "ID:13-0000615/116891",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:217 W MAY ST",
        "CITY:ANDOVER",
        "DATE:6/9/2013",
        "TIME:22:35:49",
        "MAP:HODGES 2ND SUBDIV",
        "X:N MAIN ST 0.06 mi E S MERIDIAN AVE 13.17 mi W",
        "INFO:CHEST PAINS");

    doTest("T49",
        "(CAD Call) FIRE - MEDICAL RESPONSE 403 W TUSCANY DR Call Received Time: 6/8/2013 23:09:57 \n" +
        "ANDOVER KS MapRegions: TUSCANY ADD (PHASE 1) CrossStreets: S GLENHURST CT 0.02 mi NE S MCKENZIE CT 0.15 mi W  \n" +
        "Dispatch: 6/8/2013 23:11:20 \n" +
        "Primary Incident: 13-0000614 Call Number: 116843 \n" +
        "Description: HAVING A HARD TIME \n" +
        "ReferenceText:",

        "ID:13-0000614/116843",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:403 W TUSCANY DR",
        "CITY:ANDOVER",
        "DATE:6/8/2013",
        "TIME:23:11:20",
        "MAP:TUSCANY ADD (PHASE 1)",
        "X:S GLENHURST CT 0.02 mi NE S MCKENZIE CT 0.15 mi W",
        "INFO:HAVING A HARD TIME");

    doTest("T50",
        "(CAD Call) FIRE - MEDICAL RESPONSE 420 N LIOBA DR, Apt. 102 Call Received Time: 6/8/2013 19:59:47 \n" +
        "ANDOVER KS MapRegions: KOOB TRACTS CrossStreets: W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N  \n" +
        "Dispatch: 6/8/2013 20:00:34 \n" +
        "Primary Incident: 13-0000612 Call Number: 116833 \n" +
        "Description: DOOR LOCKED - KEY ON WINDOW TO KITCHEN ON \n" +
        "ReferenceText:",

        "ID:13-0000612/116833",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:420 N LIOBA DR",
        "APT:102",
        "CITY:ANDOVER",
        "DATE:6/8/2013",
        "TIME:20:00:34",
        "MAP:KOOB TRACTS",
        "X:W 3RD ST 0.04 mi S W CENTRAL AVE 0.09 mi N",
        "INFO:DOOR LOCKED - KEY ON WINDOW TO KITCHEN ON");

    doTest("T51",
        "(CAD Call) FIRE - MEDICAL RESPONSE 233 N STEPHANIE LN Call Received Time: 6/8/2013 17:45:33 \n" +
        "ANDOVER KS MapRegions: GOLDEN SPUR 2ND ADD CrossStreets: E RHONDDA AVE 0.04 mi NE N SUSAN LN 0.10 mi SW  \n" +
        "Dispatch: 6/8/2013 17:49:55 \n" +
        "Primary Incident: 13-0000611 Call Number: 116825 \n" +
        "Description: RP ADV THAT THERE IS A MAN PASSED \n" +
        "ReferenceText:",

        "ID:13-0000611/116825",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:233 N STEPHANIE LN",
        "CITY:ANDOVER",
        "DATE:6/8/2013",
        "TIME:17:49:55",
        "MAP:GOLDEN SPUR 2ND ADD",
        "X:E RHONDDA AVE 0.04 mi NE N SUSAN LN 0.10 mi SW",
        "INFO:RP ADV THAT THERE IS A MAN PASSED");

    doTest("T52",
        "(CAD Call) FIRE - MEDICAL RESPONSE 328 W 2ND ST, Apt. 17 Call Received Time: 6/8/2013 13:00:24 \n" +
        "ANDOVER KS MapRegions: COUNTRYSIDE ADD CrossStreets: N LIOBA DR 0.05 mi SW N ANDOVER RD 0.17 mi E  \n" +
        "Dispatch: 6/8/2013 13:01:02 \n" +
        "Primary Incident: 13-0000610 Call Number: 116814 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000610/116814",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:328 W 2ND ST",
        "APT:17",
        "CITY:ANDOVER",
        "DATE:6/8/2013",
        "TIME:13:01:02",
        "MAP:COUNTRYSIDE ADD",
        "X:N LIOBA DR 0.05 mi SW N ANDOVER RD 0.17 mi E");

    doTest("T53",
        "(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE, Apt. A80 Call Received Time: 6/7/2013 18:26:41 \n" +
        "ANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \n" +
        "Dispatch: 6/7/2013 18:29:02 \n" +
        "Primary Incident: 13-0000609 Call Number: 116777 \n" +
        "Description: FRONT TO LEFT\n" +
        "90 YEARS OLD\n" +
        "DIFFICULTY BREATHING \n" +
        "ReferenceText:",

        "ID:13-0000609/116777",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:408 E CENTRAL AVE",
        "APT:A80",
        "CITY:ANDOVER",
        "DATE:6/7/2013",
        "TIME:18:29:02",
        "MAP:MEADOWS 3RD ADD",
        "X:N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING",
        "INFO:FRONT TO LEFT 90 YEARS OLD DIFFICULTY BREATHING");

    doTest("T54",
        "(CAD Call) FIRE - AIRCRAFT EMERGENCY 3013 E HWY 54 Call Received Time: 6/5/2013 18:15:37 \n" +
        "BUTLER COUNTY KS MapRegions:  CrossStreets: S PAWHUSKA ST 0.03 mi W SW MEADOWLARK RD 0.12 mi E  \n" +
        "Dispatch: 6/5/2013 18:16:16 \n" +
        "Primary Incident: 13-0000605 Call Number: 116637 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000605/116637",
        "CALL:FIRE - AIRCRAFT EMERGENCY",
        "ADDR:3013 E HWY 54",
        "CITY:BUTLER COUNTY",
        "DATE:6/5/2013",
        "TIME:18:16:16",
        "X:S PAWHUSKA ST 0.03 mi W SW MEADOWLARK RD 0.12 mi E");

    doTest("T55",
        "(CAD Call) FIRE - RESCUE RESPONSE SW SANTA FE LAKE RD & SW HWY 54 Call Received Time: 6/5/2013 04:34:05 \n" +
        "BUTLER COUNTY KS MapRegions:  CrossStreets:  \n" +
        "Dispatch: 6/5/2013 04:37:27 \n" +
        "Primary Incident: 13-0000604 Call Number: 116595 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. NATURE OF RESCUE: 10-48 ONE VEHICLE\n" +
        "2. WHAT CAUSED NEED FOR RESCUE?: 10-48\n" +
        "3. Number of victims?: 1\n" +
        "4. Best access for emergency responders?: 54/SANTA FE LAKE RD\n" +
        "5. Name of contact person for Incident Command.: U\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000604/116595",
        "CALL:FIRE - RESCUE RESPONSE",
        "ADDR:SW SANTA FE LAKE RD & SW HWY 54",
        "CITY:BUTLER COUNTY",
        "DATE:6/5/2013",
        "TIME:04:37:27",
        "INFO:*** SOP Begin *** 1. NATURE OF RESCUE: 10-48 ONE VEHICLE 2. WHAT CAUSED NEED FOR RESCUE?: 10-48 3. Number of victims?: 1 4. Best access for emergency responders?: 54/SANTA FE LAKE RD 5. Name of contact person for Incident Command.: U");

    doTest("T56",
        "(CAD Call) FIRE - MEDICAL RESPONSE  Call Received Time: 6/5/2013 04:34:05 \n" +
        "ANDOVER KS MapRegions:  CrossStreets:  \n" +
        "Dispatch: 6/5/2013 04:34:10 \n" +
        "Primary Incident: 13-0000604 Call Number: 116595 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000604/116595",
        "CALL:FIRE - MEDICAL RESPONSE",
        "CITY:ANDOVER",
        "DATE:6/5/2013",
        "TIME:04:34:10");

    doTest("T57",
        "(CAD Call) FIRE - MEDICAL RESPONSE 524 N ANDOVER RD Call Received Time: 6/4/2013 16:15:09 \n" +
        "ANDOVER KS MapRegions:  CrossStreets: W LEE ST 0.02 mi SW W VIRGINIA RD 0.08 mi N FAMILY PHYSICIANS OF KANSAS \n" +
        "Dispatch: 6/4/2013 16:17:18 \n" +
        "Primary Incident: 13-0000601 Call Number: 116554 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: CHEST PAINS\n" +
        "2 EMS enroute?: Y\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n\n" +
        "LEFT SIDE CHEST PAINS \n" +
        "ReferenceText:",

        "ID:13-0000601/116554",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:524 N ANDOVER RD",
        "CITY:ANDOVER",
        "DATE:6/4/2013",
        "TIME:16:17:18",
        "X:W LEE ST 0.02 mi SW W VIRGINIA RD 0.08 mi N FAMILY PHYSICIANS OF KANSAS",
        "INFO:*** SOP Begin *** 1. Nature of call?: CHEST PAINS 2 EMS enroute?: Y 3. Any rescue/medical aid in progress?: U LEFT SIDE CHEST PAINS");

    doTest("T58",
        "(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST Call Received Time: 6/4/2013 15:28:05 \n" +
        "ANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER \n" +
        "Dispatch: 6/4/2013 15:29:14 \n" +
        "Primary Incident: 13-0000600 Call Number: 116549 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: UNKNOWN MED\n" +
        "2. EMS enroute?: Y\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000600/116549",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:621 W 21ST ST",
        "CITY:ANDOVER",
        "DATE:6/4/2013",
        "TIME:15:29:14",
        "MAP:ANDOVER HGTS 8TH ADD",
        "X:N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER",
        "INFO:*** SOP Begin *** 1. Nature of call?: UNKNOWN MED 2. EMS enroute?: Y 3. Any rescue/medical aid in progress?: U");

    doTest("T59",
        "(CAD Call) FIRE - LANDING ZONE 1124 W 21ST ST Call Received Time: 6/4/2013 11:41:27 \n" +
        "ANDOVER KS MapRegions: CORNERSTONE MEDICAL ADDITION CrossStreets: N QUAIL CROSSING 0.07 mi W N KEYSTONE PKY 0.02 mi E KANSAS MEDICAL CENTER \n" +
        "Dispatch: 6/4/2013 12:19:52 \n" +
        "Primary Incident: 13-0000599 Call Number: 116526 \n" +
        "Description: ETA IS 1300 HRS \n" +
        "ReferenceText:",

        "ID:13-0000599/116526",
        "CALL:FIRE - LANDING ZONE",
        "ADDR:1124 W 21ST ST",
        "CITY:ANDOVER",
        "DATE:6/4/2013",
        "TIME:12:19:52",
        "MAP:CORNERSTONE MEDICAL ADDITION",
        "X:N QUAIL CROSSING 0.07 mi W N KEYSTONE PKY 0.02 mi E KANSAS MEDICAL CENTER",
        "INFO:ETA IS 1300 HRS");

    doTest("T60",
        "(CAD Call) FIRE - MEDICAL RESPONSE 225 E CLOUD AVE Call Received Time: 6/3/2013 18:02:39 \n" +
        "ANDOVER KS MapRegions: MARKETPLACE COMMERCIAL ADD CrossStreets: S ANDOVER RD 0.07 mi W W CLOUD AVE 0.07 mi W DILLONS MARKETPLACE \n" +
        "Dispatch: 6/3/2013 18:04:21 \n" +
        "Primary Incident: 13-0000597 Call Number: 116454 \n" +
        "Description: NEAR THE MILK COOLERS \n" +
        "ReferenceText:",

        "ID:13-0000597/116454",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:225 E CLOUD AVE",
        "CITY:ANDOVER",
        "DATE:6/3/2013",
        "TIME:18:04:21",
        "MAP:MARKETPLACE COMMERCIAL ADD",
        "X:S ANDOVER RD 0.07 mi W W CLOUD AVE 0.07 mi W DILLONS MARKETPLACE",
        "INFO:NEAR THE MILK COOLERS");

    doTest("T61",
        "(CAD Call) FIRE - LANDING ZONE 1124 W 21ST ST Call Received Time: 6/3/2013 09:55:44 \n" +
        "ANDOVER KS MapRegions: CORNERSTONE MEDICAL ADDITION CrossStreets: N QUAIL CROSSING 0.07 mi W N KEYSTONE PKY 0.02 mi E KANSAS MEDICAL CENTER \n" +
        "Dispatch: 6/3/2013 09:57:19 \n" +
        "Primary Incident: 13-0000596 Call Number: 116431 \n" +
        "Description: ETA WILL BE THERE AT 1020 \n" +
        "ReferenceText:",

        "ID:13-0000596/116431",
        "CALL:FIRE - LANDING ZONE",
        "ADDR:1124 W 21ST ST",
        "CITY:ANDOVER",
        "DATE:6/3/2013",
        "TIME:09:57:19",
        "MAP:CORNERSTONE MEDICAL ADDITION",
        "X:N QUAIL CROSSING 0.07 mi W N KEYSTONE PKY 0.02 mi E KANSAS MEDICAL CENTER",
        "INFO:ETA WILL BE THERE AT 1020");

    doTest("T62",
        "(CAD Call) FIRE - MEDICAL RESPONSE 408 E CONNELL AVE Call Received Time: 6/2/2013 14:03:42 \n" +
        "ANDOVER KS MapRegions: GOLDEN SPUR ADD CrossStreets: N PORTH AVE 0.06 mi W N SHAY RD 0.07 mi E  \n" +
        "Dispatch: 6/2/2013 14:06:28 \n" +
        "Primary Incident: 13-0000593 Call Number: 116362 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000593/116362",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:408 E CONNELL AVE",
        "CITY:ANDOVER",
        "DATE:6/2/2013",
        "TIME:14:06:28",
        "MAP:GOLDEN SPUR ADD",
        "X:N PORTH AVE 0.06 mi W N SHAY RD 0.07 mi E");

    doTest("T63",
        "(CAD Call) FIRE - MEDICAL RESPONSE 712 S HIGHLAND DR Call Received Time: 6/2/2013 12:50:12 \n" +
        "ANDOVER KS MapRegions: HIGHLANDS 3RD ADD CrossStreets: S DUBLIN DR 0.05 mi E S DUBLIN DR 0.11 mi N  \n" +
        "Dispatch: 6/2/2013 12:52:20 \n" +
        "Primary Incident: 13-0000592 Call Number: 116359 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: POSSI HEART ATTACK\n" +
        "2. EMS enroute?: Y\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n" +
        "55 YO FEMALE \n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000592/116359",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:712 S HIGHLAND DR",
        "CITY:ANDOVER",
        "DATE:6/2/2013",
        "TIME:12:52:20",
        "MAP:HIGHLANDS 3RD ADD",
        "X:S DUBLIN DR 0.05 mi E S DUBLIN DR 0.11 mi N",
        "INFO:*** SOP Begin *** 1. Nature of call?: POSSI HEART ATTACK 2. EMS enroute?: Y 3. Any rescue/medical aid in progress?: U 55 YO FEMALE");

    doTest("T64",
        "(CAD Call) FIRE - MEDICAL RESPONSE 408 E CENTRAL AVE, Apt. C 42 Call Received Time: 6/2/2013 03:48:33 \n" +
        "ANDOVER KS MapRegions: MEADOWS 3RD ADD CrossStreets: N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING \n" +
        "Dispatch: 6/2/2013 03:49:54 \n" +
        "Primary Incident: 13-0000591 Call Number: 116334 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: FALL VICTIM\n" +
        "2. EMS enroute?: A\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000591/116334",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:408 E CENTRAL AVE",
        "APT:C 42",
        "CITY:ANDOVER",
        "DATE:6/2/2013",
        "TIME:03:49:54",
        "MAP:MEADOWS 3RD ADD",
        "X:N SHAY RD 0.08 mi SE N PORTH AVE 0.10 mi SW VICTORIA FALLS - ASSISTED LIVING",
        "INFO:*** SOP Begin *** 1. Nature of call?: FALL VICTIM 2. EMS enroute?: A 3. Any rescue/medical aid in progress?: U");

    doTest("T65",
        "(CAD Call) FIRE - MEDICAL RESPONSE 621 W 21ST ST, Apt. 117 A Call Received Time: 6/1/2013 21:40:55 \n" +
        "ANDOVER KS MapRegions: ANDOVER HGTS 8TH ADD CrossStreets: N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER \n" +
        "Dispatch: 6/1/2013 21:42:34 \n" +
        "Primary Incident: 13-0000590 Call Number: 116317 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: SICK CALL\n" +
        "2. EMS enroute?: A\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000590/116317",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:621 W 21ST ST",
        "APT:117 A",
        "CITY:ANDOVER",
        "DATE:6/1/2013",
        "TIME:21:42:34",
        "MAP:ANDOVER HGTS 8TH ADD",
        "X:N MARC AVE 0.21 mi E N LAKESIDE DR 0.17 mi W LIFE CARE CENTER OF ANDOVER",
        "INFO:*** SOP Begin *** 1. Nature of call?: SICK CALL 2. EMS enroute?: A 3. Any rescue/medical aid in progress?: U");

    doTest("T66",
        "(CAD Call) FIRE - MEDICAL RESPONSE 613 N GLENDEVON RD Call Received Time: 6/1/2013 11:54:52 \n" +
        "ANDOVER KS MapRegions: TERRADYNE ESTATES CrossStreets: N GLENDEVON PL 0.00 mi SW N GLENDEVON CT 0.07 mi NE  \n" +
        "Dispatch: 6/1/2013 11:57:00 \n" +
        "Primary Incident: 13-0000589 Call Number: 116294 \n" +
        "Description:  \n" +
        "ReferenceText:",

        "ID:13-0000589/116294",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:613 N GLENDEVON RD",
        "CITY:ANDOVER",
        "DATE:6/1/2013",
        "TIME:11:57:00",
        "MAP:TERRADYNE ESTATES",
        "X:N GLENDEVON PL 0.00 mi SW N GLENDEVON CT 0.07 mi NE");

    doTest("T67",
        "(CAD Call) FIRE - MEDICAL RESPONSE 244 N GREENVALLEY DR Call Received Time: 6/1/2013 10:38:56 \n" +
        "ANDOVER KS MapRegions: GREEN VALLEY 1ST ADD CrossStreets: N LAKESIDE DR 0.03 mi SE N OAKMONT CT 0.05 mi NW  \n" +
        "Dispatch: 6/1/2013 10:44:58 \n" +
        "Primary Incident: 13-0000588 Call Number: 116291 \n" +
        "Description: *** SOP Begin ***\n\n" +
        "1. Nature of call?: CHEST PAINS\n" +
        "2 EMS enroute?: Y\n" +
        "3. Any rescue/medical aid in progress?: U\n\n\n\n" +
        " \n" +
        "ReferenceText:",

        "ID:13-0000588/116291",
        "CALL:FIRE - MEDICAL RESPONSE",
        "ADDR:244 N GREENVALLEY DR",
        "CITY:ANDOVER",
        "DATE:6/1/2013",
        "TIME:10:44:58",
        "MAP:GREEN VALLEY 1ST ADD",
        "X:N LAKESIDE DR 0.03 mi SE N OAKMONT CT 0.05 mi NW",
        "INFO:*** SOP Begin *** 1. Nature of call?: CHEST PAINS 2 EMS enroute?: Y 3. Any rescue/medical aid in progress?: U");
    
  }
  
  public static void main(String[] args) {
    new KSAndoverParserTest().generateTests("T1");
  }
}
