package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Allegheny County, PA
Contact: Anthony Cuda <acuda@wpahs.org>,"Cuda, Anthony" <acuda@ccac.edu>
Sender: 777*
ALLEGHENY COUNTY 911 :FRCOM3, F1, POSS FIRE COM - SMELL OF SMOKE/BLDG ENDG, SHARPSBURG TOWERS #902, SHP, at 601 MAIN ST #902, SHP, btwn S MAIN ST and 7TH ST, NFD3, 265002, CALLER REPORTING A STRONG SMELL OF "SCHLAK" PAINT OR AMMONIA IN THE BUILDING. CALLER WAS ADVISED TO EVAC, Units:102EN1, 111EN1, 149EN1, 191EN1,
ALLEGHENY COUNTY 911 :NGASRES, F1, NATURAL GAS SMELL/LEAK RES BLDG, 40 EASTON RD, FOX, btwn CHAPEL OAK RD and OLD MILL RD, ON THE STREET, IN FRONT OF, NFD3, 157001, Medical ProQA recommends dispatch at this time, Units:102EN1, 157EN1, 172EN1 - From 405 11/11/2010 12:17:38 TXT STOP to opt-out
ALLEGHENY COUNTY 911 :NGASCOM, F1, NATURAL GAS SMELL/LEAK COM BLDG, FREEPORT MEDICAL ASSOC, ASP, at 241 FREEPORT RD, ASP, SUITE 7-FOX CHAPEL DERMETOLOGY, btwn CENTER AVE and EASTERN AVE, NFD3, 102001, STRONG SMELL OF NATURAL GAS IN THE BLDG, Units:102EN1, 111EN2, 157RQ1, 191TK1, 260RQ1, 265TK1 - From 405 11/10/2010 10:02:01 TXT STOP to opt-out
ALLEGHENY COUNTY 911 :NGASRES, F1, NATURAL GAS SMELL/LEAK RES BLDG, 262 EMERSON RD, SHA, btwn JORDAN LN and HAWTHORNE RD, NFD3, 260001, NAT TXT STOP to opt-out
ALLEGHENY COUNTY 911 :NGASOUT, F2, NATURAL GAS SMELL/LEAK OUTSIDE, 22 4TH ST, SHP, btwn SHORT CANAL ST and PILGRIM WAY, NFD3, 265001, STRON TXT STOP to opt-out
ALLEGHENY COUNTY 911 :QRS0, Q0, E-0 QRS / EMS ASSIST, 43 OAKHURST CIR, ASP, btwn RIVER OAKS DR and RIVER OAKS DR, NFD3, 102001, 74YOF CHEST TXT STOP to opt-out
ALLEGHENY COUNTY 911 :29B1, F1, TRAFFIC -WITH INJURIES, THOMPSON RUN RD/SUNNY HILL DR, ROS,  <310/ 0>, NFD3, 247006 191001, GARAGE ON FIRE, Units:102EN1, 149EN1, 191EN1, 191TK1, 240SQ1, 247TK1, 259EN1, 260TK1, 312RQ40 - From 405 11/13/2010 06:43:58 TXT STOP to opt-out

Split messages, same send time
ALLEGHENY COUNTY 911 :09E1A, E0, NOT BREATHING AT ALL -COLD/STIFF IN WARM, 9116 WALNUT ST, PLU, btwn APPLE AVE and PINE ST, EMD1, E48505, 68 YOM NOT BREATHING,
THINKS HE IS DECEASED, Units:487 - From 504 02/08/2011 19:30:00 TXT STOP to opt-out

:FRVEH, F2, VEHICLE FIRE, 3541 LAKETON RD, PEN, btwn LINDBERG AVE and NELBON AVE, EFD1, 225001

Contact: Justin Hale <jhale715@yahoo.com>
ALLEGHENY COUNTY 911 :QRS3, Q3, E-3 QRS / EMS ASSIST, 1000 ROSS PARK MALL DR, ROS, btwn ROSS PARK DR and CHERYL DR, CALIFORNIA PIZZA KITCHEN, NFD3, 24700

Contact: Kevin Armstrong <kevinarmstrong72@gmail.com>
Sender: 4127802418
ALLEGHENY COUNTY 911 :27D3S, E0, STABBING - CENTRAL WOUNDS, 612 CENTER AVE, ASP, btwn E 6TH ST and W 8TH ST, NMD1, E14004, Medical ProQA recommends dispatch at this time, Units:142, 269 - From 406 05/07/2011 02:34:31 TXT STOP to opt-out

Contact: David Gallagher <ffmedic114@gmail.com>
ALLEGHENY COUNTY 911 :08B1G, E3, HAZMAT-SMELL OF GAS- ALRT/NO DIFF BREATH, 35 LOCUST ST #1STFL, ETN, btwn ELM WAY and WALNUT ST, NMD1, E16001, Medical ProQA recommends dispatch at this time, Units:171, E160ALL - From 404 05/09/2011 19:48:13 TXT STOP to opt-out

Contact: Matthew Yeckel <yeckel01m@gmail.co
ALLEGHENY COUNTY 911 :FRILL, F3, ILLEGAL FIRE, 5172 LOMBARDI DR, BWB, btwn SUNNY DR and END, SFD1, 104002, Units:104AST1, 104AST2 - From 701 02/23/2012 13:23:10

Contact: Jerry DiGennaro <jerry.digennaro@att.net>
From:9300
29D4, F0, TRAFFIC - ENTRAPMENT, EXIT ROUTE 28 NB ROUTE 8 NORTH, ETN, at 5 NB ST HWY 28 ONRP WILL FL HWY RMP, ETN, btwn NB ST HWY 28 ONRP WILL FL HWY and END, NFD3, 265003, F130005614, 1 VEHICLE ACCIDENT, VEHICLE INTO THE MEDIAN, 1 FEMALE WITH FACIAL INJURIES, Unit:149RQ1 - From 405 01/24/2013 02:47:10
29D2MPED, F0, TRAFFIC-HIGH MECHANISM (AUTO-PEDESTRIAN), GIANT EAGLE SHA, SHA, at 1671 BUTLER PLANK RD, SHA, btwn E SUTTER RD and WILLIAM FLYNN HWY, NFD3, 261005, F130030730, Medical ProQA recommends dispatch at this time, Units:164RQ1, 261RQ3, 264EN1 - From 405 05/06/2013 11:13:03

Contact: support@active911.com
(268 Station) 29D2P, F0, TRAFFIC-HIGH MECHANISM (ROLLOVER), BRIDGEVILLE EXIT, SFT, at 54 SB I-79 OFRP MILLERS RUN RD RMP, SFT, btwn END and MILLERS RUN RD, SFD3, 268003, CAR OVERTURNED, Units:268EN1, 268RQ1 - From 703 01/31/2012 19:18:34
  :FRCOM1, 1A, FIRE COM BLDG - FLAMES AND/OR ENTRAPMENT, 3185 BABCOCK BLVD, ROS, btwn OAKGLEN RD and EVERGREEN RD, NFD3, 253001, F120033786, COMP STATING RIGHT IN FRONT OF WEST PENN BILLIARDS THERE IS A BUILDING ON FIRE// CAN SEE SMOKE AND FLAMES, Unit:247EN1 - From 405 05/18/2012 13:54:25
  :29B1, Q1, TRAFFIC -WITH INJURIES, POST OFFICE ROS - MCKNIGHT 15237, ROS, at 4981 MCKNIGHT RD, ROS, US POST OFFICE, btwn MCKNIGHT CIR and SB MKNGHT RD OFRP SIEBERT RD, NFD3, 247004, F120033283, 2 CAR MVC... IN LOT OF POST OFFICE...  NO INJURIES, Units:247EN1, 312RQ40 - From 405 05/16/2012 13:49:00

Contact: Active911
Agency name: Swissvale Fire Department
Location: Swissvale, PA, United States
Sender: CAD.Alert@AlleghenyCounty.us

(CAD Page) :QRS0, Q0, E-0 QRS / EMS ASSIST, 2362 BUENA VISTA ST, SWS, btwn HIGHLAND AVE and END, EFD3, 278001, F120093743, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 15:41:12\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :QRS0, Q0, E-0 QRS / EMS ASSIST, 6920 MCCLURE AVE, SWS, btwn POCONO ST and COMMERCIAL ST, EFD3, 278001, F120093717, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 12:57:10\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 7436 SCHOYER AVE, SWS, btwn MIRIAM ST and HAYS ST, EFD3, 278001, F120093677, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 10:41:03\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :29B3U, F1, TRAFFIC - OTHER HAZARDS (UNK # INJ), MELROSE ST/S BRADDOCK AVE, SWS,  <7599/ 2424>, EFD3, 278001, F120093632, VEH INTO A POLE NO INJ...COMP WAS NOT ONSCENE ANOTHER PLOW DRIVER SAW THIS HAPPEN...OCC IS OUT OF THE VEH.... THIS IS ON MELROSE BETWEEN S BRADDOCK AND WOODSTOCK, Unit:278EN1 - From 505 12/29/2012 07:42:37\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 7422 PARK AVE, SWS, btwn ALLEY and PALMER ST, EFD3, 278001, F120093606, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 04:13:28\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :ASTFN, F3, RQST ASST FIRE - NON EMERGENCY, 7464 MCCLURE AVE #7, SWS, btwn MONONGAHELA AVE and S BRADDOCK AVE, EFD3, 278001, F120093597, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 03:00:44\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 7344 SCHLEY AVE, SWS, btwn PROSPECT ST and MONROE ST, EFD3, 278001, F120093500, 23YOF FELL 2 STEPS., Unit:278EN1 - From 505 12/28/2012 18:43:35\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :ASTFE, F0, RQST ASST  FIRE - EMERGENCY, WOODSTOCK AVE/SHORT ST, SWS,  <2531/ 7500>, EFD3, 278001, F120093424, COMPL REPOTING A WIRE HANGING LOW ON SHORT ST/NO SPARKS OR FLAMES..LOOKS LIKE CABLE WIRE, Unit:278EN1 - From 505 12/28/2012 13:33:50\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 1901 HANOVER ST #9, SWS, btwn CHURCH ST and END, EFD3, 278001, F120093334, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/28/2012 08:36:19\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, SWISSVALE TOWERS #702, SWS, at 1826 MONONGAHELA AVE #702, SWS, btwn MCCLURE AVE and CHURCH ST, EFD3, 278001, F120093326, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/28/2012 07:40:24\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   

Contact: Active911
Agency name: Allegheny County Emergency Services
Location: Pittsburgh, PA, United States
Sender: CAD.Alert@AlleghenyCounty.us

(CAD Page) :CLASS1, P1, BOMB/POSS BOMB FOUND, 500 ROUTE 909, PLU, MAINTANACE BUILDING, EPD2, PLU03, P130001683, COMPL FOUND A BAG WITH AT LEAST THREE HAND GRENADES IN IT ALL THREE STILL HAVE PINS IN THEM - From 511 01/01/2013 13:38:10\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :1FM, P0, COUNTY FIRE MARSHAL REQUEST, 512 FOX DR, ROS, btwn END and PARK PL, APD1, ROS01, P121130172, FLAMES THRU THE ROOF.. THERE IS AN AUTISTIC MALE INSIDE.., Units:A401, A4011K, A4013, A402, AFMINT - From 708 12/31/2012 22:59:27\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :CLASS1, P1, BOMB/POSS BOMB FOUND, BELTZHOOVER AVE/EDGEMONT ST, PGH,  <106/ 699>, CPD3, PP305, P121127681, COMPL REPORTING AN OBJECT THAT LOOKS LIKE A WALKIE TALKIE WITH A COUNTDOWN ON IT AND IT IS BEEPING ON BELTHOOVER AVE///COMPL THINKS IT IS A BOMB AND WILL POINT IT OUT TO AN OFC WHEN THEY GET THERE///COMPL IS STANDING ON BELTZHOOVER AVE - From 605 12/31/2012 02:25:50\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :1FM, P0, COUNTY FIRE MARSHAL REQUEST, 800 ROSS AVE #2, WBG, btwn CENTER ST and MILL ST, APD1, WBG01, P121127156, FIRE IN THE BASEMENT, HEATING DUCTS ARE ON FIRE., Unit:A401 - From 705 12/30/2012 20:29:54\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :CLASS1, P1, BOMB/POSS BOMB FOUND, HEINZ FIELD, PGH, at 100 ART ROONEY AVE, PGH, btwn W GENERAL ROBINSON ST and NORTH SHORE DR, CPD1, PP134, P121126507 - From 606 12/30/2012 15:37:24\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Help Desk at 412-350-HELP (412-350-4357) or e-mail\nHelpDesk@AlleghenyCounty.US\n-----------------------------------------   

Contact: Active911
Agency name: RossWest View EMS
Location: Pittsburgh, PA, United States
Sender: CAD.Alert@AlleghenyCounty.us

(CAD Page) :29B1, E1, TRAFFIC -WITH INJURIES, GRANT AVE/SHERMAN ST, MIL,  <300/ 99>, NMD1, E21012, E130078121, REPORT OF WRECKED CAR WITH FEMALE PASSED OUT, Unit:2147 - From 404 05/16/2013 10:02:14\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :32B2, E2, UNKNOWN - MEDICAL ALARM *NO INFO*, 431 MCKNIGHT CIR #D, ROS, btwn END and MCKNIGHT RD, BUILDING D, NMD1, E21002, E130078113, NO CONTACT MADE. RESIDENT IS AN 89 FEM ANN MAIER. 412364 6839, Unit:2141 - From 404 05/16/2013 09:51:21\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :10C2, E1, CHEST PAIN - HEART ATTACK/ANGINA HISTORY, 113 PETUNIA AVE, ROS, btwn END and GOLF DR, NMD1, E21004, E130078096, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/16/2013 09:31:27\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) MOVE-UP: 2142 to E21001.  - From 405 05/16/2013 08:56:06\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :17B1G, E1, FALL -POSS. DANGEROUS BODY AREA (GROUND), 125 LAKEWOOD AVE, WVW, btwn WAVERLY AVE and ALLEY, NMD1, E21010, E130077997, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/16/2013 05:57:05\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :17B3, E1, FALL - UNKNOWN STATUS, PD MIL MILLVALE PD, MIL, at 501 LINCOLN AVE, MIL, btwn SEDGWICK ST and FORNOFF ST, NMD1, E21012, E130077959, Unit:2147 - From 405 05/16/2013 02:04:37\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :06D2, E1, BREATHING - DIFF SPEAKING, VERLAND FOUNDATION OHI, OHI, at 212 IRIS RD, OHI, HOUSE NUMBER 111, btwn LINDA VISTA RD and RITTER RD, NMD1, E21013, E130077951, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/16/2013 01:50:05\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :BOAT1, E0, BOAT EMERGENCY, FORTIETH STREET BRIDGE - MILLVALE SIDE, MIL, at 190 40TH ST BRG, MIL, NMD1, E21012, E130077932, 10 MIN DELAY. CALLER DROVE THROUGH THE AREA AND SAW A SHORTER WHITE MALE EMERGE FROM UNDERNEATH THE BRIDGE. MALE TOLD CALLER THAT HIS BOAT CAPSIZED AND THAT HE NEEDED HELP. CALLER ASKED HIM IF EVERYONE WAS ABLE TO GET OUT AND HE SAID YES. UNK WHERE THIS IS., Units:2147, SQ2175 - From 404 05/16/2013 01:04:52\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :17D3, E0, FALL - NOT ALERT, MANOR CARE ROS #127B, ROS, at 1105 PERRY HWY #127B, ROS, btwn TRION RD and SEWICKLEY OAKMONT RD, NMD1, E21002, E130077894, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/15/2013 23:22:55\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   
(CAD Page) :FRRES1, E1, DWELLING FIRE, 113 VIOLET ST, ROS, btwn PRINCETON AVE and END, NMD1, E21004, E130077873, GRILL ON FIRE, Unit:2141 - From 404 05/15/2013 22:24:38\n\n\n\n----------------------------------------- LEGAL DISCLAIMER\nConfidentiality Notice: This e-mail message, including any\nattachments, is for the sole use of the intended recipient(s) and\nmay contain confidential and privileged information. Any\nunauthorized review, use, disclosure, forwarding, or distribution\nis prohibited. If you are not the intended recipient, please\ncontact the sender by reply e-mail and destroy all copies of the\noriginal message. Any questions should be directed to Allegheny\nCounty Service Desk at 412-350-HELP (412-350-4357) or e-mail\nServiceDesk@AlleghenyCounty.US\n-----------------------------------------   

*/

public class PAAlleghenyCountyParserTest extends BaseParserTest {
  
  public PAAlleghenyCountyParserTest() {
    setParser(new PAAlleghenyCountyParser(), "ALLEGHENY COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "ALLEGHENY COUNTY 911 :FRCOM3, F1, POSS FIRE COM - SMELL OF SMOKE/BLDG ENDG, SHARPSBURG TOWERS #902, SHP, at 601 MAIN ST #902, SHP, btwn S MAIN ST and 7TH ST, NFD3, 265002, CALLER REPORTING A STRONG SMELL OF \"SCHLAK\" PAINT OR AMMONIA IN THE BUILDING. CALLER WAS ADVISED TO EVAC, Units:102EN1, 111EN1, 149EN1, 191EN1,",
        "CODE:FRCOM3",
        "PRI:F1",
        "CALL:POSS FIRE COM - SMELL OF SMOKE/BLDG ENDG",
        "PLACE:SHARPSBURG TOWERS",
        "CITY:SHARPSBURG",
        "ADDR:601 MAIN ST",
        "APT:902",
        "X:S MAIN ST and 7TH ST",
        "SRC:NFD3",
        "BOX:265002",
        "UNIT:102EN1 111EN1 149EN1 191EN1",
        "INFO:CALLER REPORTING A STRONG SMELL OF \"SCHLAK\" PAINT OR AMMONIA IN THE BUILDING. CALLER WAS ADVISED TO EVAC");
        
    doTest("T2",
        "ALLEGHENY COUNTY 911 :NGASRES, F1, NATURAL GAS SMELL/LEAK RES BLDG, 40 EASTON RD, FOX, btwn CHAPEL OAK RD and OLD MILL RD, ON THE STREET, IN FRONT OF, NFD3, 157001, Medical ProQA recommends dispatch at this time, Units:102EN1, 157EN1, 172EN1 - From 405 11/11/2010 12:17:38 TXT STOP to opt-out",
        "CODE:NGASRES",
        "PRI:F1",
        "CALL:NATURAL GAS SMELL/LEAK RES BLDG",
        "ADDR:40 EASTON RD",
        "CITY:FOX CHAPEL",
        "X:CHAPEL OAK RD and OLD MILL RD",
        "INFO:ON THE STREET / IN FRONT OF",
        "SRC:NFD3",
        "BOX:157001",
        "UNIT:102EN1 157EN1 172EN1",
        "DATE:11/11/2010",
        "TIME:12:17:38");
    
    doTest("T3",
        "ALLEGHENY COUNTY 911 :NGASCOM, F1, NATURAL GAS SMELL/LEAK COM BLDG, FREEPORT MEDICAL ASSOC, ASP, at 241 FREEPORT RD, ASP, SUITE 7-FOX CHAPEL DERMETOLOGY, btwn CENTER AVE and EASTERN AVE, NFD3, 102001, STRONG SMELL OF NATURAL GAS IN THE BLDG, Units:102EN1, 111EN2, 157RQ1, 191TK1, 260RQ1, 265TK1 - From 405 11/10/2010 10:02:01 TXT STOP to opt-out",
        "CODE:NGASCOM",
        "PRI:F1",
        "CALL:NATURAL GAS SMELL/LEAK COM BLDG",
        "PLACE:FREEPORT MEDICAL ASSOC",
        "CITY:ASPINWALL", 
        "ADDR:241 FREEPORT RD",
        "INFO:SUITE 7-FOX CHAPEL DERMETOLOGY / STRONG SMELL OF NATURAL GAS IN THE BLDG",
        "X:CENTER AVE and EASTERN AVE",
        "SRC:NFD3", 
        "BOX:102001",
        "UNIT:102EN1 111EN2 157RQ1 191TK1 260RQ1 265TK1",
        "DATE:11/10/2010",
        "TIME:10:02:01");
        
     doTest("T4",   
        "ALLEGHENY COUNTY 911 :NGASRES, F1, NATURAL GAS SMELL/LEAK RES BLDG, 262 EMERSON RD, SHA, btwn JORDAN LN and HAWTHORNE RD, NFD3, 260001, NAT TXT STOP to opt-out",
        "CODE:NGASRES", 
        "PRI:F1",
        "CALL:NATURAL GAS SMELL/LEAK RES BLDG", 
        "ADDR:262 EMERSON RD", 
        "CITY:SHALER", 
        "X:JORDAN LN and HAWTHORNE RD", 
        "SRC:NFD3", 
        "BOX:260001",
        "INFO:NAT");
        
     doTest("T5",
        "ALLEGHENY COUNTY 911 :NGASOUT, F2, NATURAL GAS SMELL/LEAK OUTSIDE, 22 4TH ST, SHP, btwn SHORT CANAL ST and PILGRIM WAY, NFD3, 265001, STRON TXT STOP to opt-out",
        "CODE:NGASOUT", 
        "PRI:F2",
        "CALL:NATURAL GAS SMELL/LEAK OUTSIDE", 
        "ADDR:22 4TH ST", 
        "CITY:SHARPSBURG", 
        "X:SHORT CANAL ST and PILGRIM WAY", 
        "SRC:NFD3", 
        "BOX:265001", 
        "INFO:STRON");
        
    doTest("T6",
        "ALLEGHENY COUNTY 911 :QRS0, Q0, E-0 QRS / EMS ASSIST, 43 OAKHURST CIR, ASP, btwn RIVER OAKS DR and RIVER OAKS DR, NFD3, 102001, 74YOF CHEST TXT STOP to opt-out",
        "CODE:QRS0", 
        "PRI:Q0",
        "CALL:E-0 QRS / EMS ASSIST", 
        "ADDR:43 OAKHURST CIR", 
        "CITY:ASPINWALL", 
        "X:RIVER OAKS DR and RIVER OAKS DR", 
        "SRC:NFD3", 
        "BOX:102001", 
        "INFO:74YOF CHEST");
        
    doTest("T7",
        "ALLEGHENY COUNTY 911 :29B1, F1, TRAFFIC -WITH INJURIES, THOMPSON RUN RD/SUNNY HILL DR, ROS,  <310/ 0>, NFD3, 247006 191001, GARAGE ON FIRE, Units:102EN1, 149EN1, 191EN1, 191TK1, 240SQ1, 247TK1, 259EN1, 260TK1, 312RQ40 - From 405 11/13/2010 06:43:58 TXT STOP to opt-out",
        "CODE:29B1", 
        "PRI:F1",
        "CALL:TRAFFIC -WITH INJURIES", 
        "ADDR:THOMPSON RUN RD & SUNNY HILL DR", 
        "CITY:ROSS",
        "INFO:GARAGE ON FIRE", 
        "SRC:NFD3", 
        "BOX:247006 191001",
        "UNIT:102EN1 149EN1 191EN1 191TK1 240SQ1 247TK1 259EN1 260TK1 312RQ40",
        "DATE:11/13/2010",
        "TIME:06:43:58");

    doTest("T8",
        ":FRVEH, F2, VEHICLE FIRE, 3541 LAKETON RD, PEN, btwn LINDBERG AVE and NELBON AVE, EFD1, 225001",
        "CODE:FRVEH",
        "PRI:F2",
        "CALL:VEHICLE FIRE",
        "ADDR:3541 LAKETON RD",
        "CITY:PENN HILLS",
        "X:LINDBERG AVE and NELBON AVE",
        "SRC:EFD1",
        "BOX:225001");

    doTest("T9",
        "ALLEGHENY COUNTY 911 :QRS3, Q3, E-3 QRS / EMS ASSIST, 1000 ROSS PARK MALL DR, ROS, btwn ROSS PARK DR and CHERYL DR, CALIFORNIA PIZZA KITCHEN, NFD3, 24700",
        "CODE:QRS3",
        "PRI:Q3",
        "CALL:E-3 QRS / EMS ASSIST",
        "ADDR:1000 ROSS PARK MALL DR",
        "CITY:ROSS",
        "X:ROSS PARK DR and CHERYL DR",
        "INFO:CALIFORNIA PIZZA KITCHEN",
        "SRC:NFD3",
        "BOX:24700");

    doTest("T10",
        "ALLEGHENY COUNTY 911 :27D3S, E0, STABBING - CENTRAL WOUNDS, 612 CENTER AVE, ASP, btwn E 6TH ST and W 8TH ST, NMD1, E14004, Medical ProQA recommends dispatch at this time, Units:142, 269 - From 406 05/07/2011 02:34:31 TXT STOP to opt-out",
        "CODE:27D3S",
        "PRI:E0",
        "CALL:STABBING - CENTRAL WOUNDS",
        "ADDR:612 CENTER AVE",
        "CITY:ASPINWALL",
        "X:E 6TH ST and W 8TH ST",
        "SRC:NMD1",
        "BOX:E14004",
        "UNIT:142 269",
        "DATE:05/07/2011", 
        "TIME:02:34:31");

    doTest("T11",
        "ALLEGHENY COUNTY 911 :FRILL, F3, ILLEGAL FIRE, 5172 LOMBARDI DR, BWB, btwn SUNNY DR and END, SFD1, 104002, Units:104AST1, 104AST2 - From 701 02/23/2012 13:23:10",
        "CODE:FRILL",
        "PRI:F3",
        "CALL:ILLEGAL FIRE",
        "ADDR:5172 LOMBARDI DR",
        "CITY:BALDWIN",
        "X:SUNNY DR and END",
        "SRC:SFD1",
        "BOX:104002",
        "UNIT:104AST1 104AST2",
        "DATE:02/23/2012", 
        "TIME:13:23:10");
  }
  
  @Test
  public void testJerryDiGennaro() {

    doTest("T1",
        "29D4, F0, TRAFFIC - ENTRAPMENT, EXIT ROUTE 28 NB ROUTE 8 NORTH, ETN, at 5 NB ST HWY 28 ONRP WILL FL HWY RMP, ETN, btwn NB ST HWY 28 ONRP WILL FL HWY and END, NFD3, 265003, F130005614, 1 VEHICLE ACCIDENT, VEHICLE INTO THE MEDIAN, 1 FEMALE WITH FACIAL INJURIES, Unit:149RQ1 - From 405 01/24/2013 02:47:10",
        "CODE:29D4",
        "PRI:F0",
        "CALL:TRAFFIC - ENTRAPMENT",
        "PLACE:EXIT ROUTE 28 NB ROUTE 8 NORTH",
        "ADDR:5 NB ST HWY 28 ONRP WILL FL HWY RMP",
        "MADDR:5 PA 28 ONRP WILL FL HWY RMP",
        "CITY:ETNA",
        "INFO:1 VEHICLE ACCIDENT / VEHICLE INTO THE MEDIAN / 1 FEMALE WITH FACIAL INJURIES",
        "X:NB ST HWY 28 ONRP WILL FL HWY and END",
        "SRC:NFD3",
        "BOX:265003",
        "ID:F130005614",
        "UNIT:149RQ1",
        "DATE:01/24/2013",
        "TIME:02:47:10");

    doTest("T1",
        "29D2MPED, F0, TRAFFIC-HIGH MECHANISM (AUTO-PEDESTRIAN), GIANT EAGLE SHA, SHA, at 1671 BUTLER PLANK RD, SHA, btwn E SUTTER RD and WILLIAM FLYNN HWY, NFD3, 261005, F130030730, Medical ProQA recommends dispatch at this time, Units:164RQ1, 261RQ3, 264EN1 - From 405 05/06/2013 11:13:03",
        "CODE:29D2MPED",
        "PRI:F0",
        "CALL:TRAFFIC-HIGH MECHANISM (AUTO-PEDESTRIAN)",
        "PLACE:GIANT EAGLE SHA",
        "ADDR:1671 BUTLER PLANK RD",
        "CITY:SHALER",
        "X:E SUTTER RD and WILLIAM FLYNN HWY",
        "SRC:NFD3",
        "BOX:261005",
        "ID:F130030730",
        "UNIT:164RQ1 261RQ3 264EN1",
        "DATE:05/06/2013",
        "TIME:11:13:03");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(268 Station) 29D2P, F0, TRAFFIC-HIGH MECHANISM (ROLLOVER), BRIDGEVILLE EXIT, SFT, at 54 SB I-79 OFRP MILLERS RUN RD RMP, SFT, btwn END and MILLERS RUN RD, SFD3, 268003, CAR OVERTURNED, Units:268EN1, 268RQ1 - From 703 01/31/2012 19:18:34",
        "CODE:29D2P",
        "PRI:F0",
        "CALL:TRAFFIC-HIGH MECHANISM (ROLLOVER)",
        "PLACE:BRIDGEVILLE EXIT",
        "ADDR:54 SB I-79 OFRP MILLERS RUN RD RMP",
        "MADDR:54 I 79",
        "CITY:SOUTH FAYETTE",
        "X:END and MILLERS RUN RD",
        "SRC:SFD3",
        "BOX:268003",
        "UNIT:268EN1 268RQ1",
        "INFO:CAR OVERTURNED",
        "DATE:01/31/2012",
        "TIME:19:18:34");

    doTest("T2",
        "  :FRCOM1, 1A, FIRE COM BLDG - FLAMES AND/OR ENTRAPMENT, 3185 BABCOCK BLVD, ROS, btwn OAKGLEN RD and EVERGREEN RD, NFD3, 253001, F120033786, COMP STATING RIGHT IN FRONT OF WEST PENN BILLIARDS THERE IS A BUILDING ON FIRE// CAN SEE SMOKE AND FLAMES, Unit:247EN1 - From 405 05/18/2012 13:54:25",
        "CODE:FRCOM1",
        "PRI:1A",
        "CALL:FIRE COM BLDG - FLAMES AND/OR ENTRAPMENT",
        "ADDR:3185 BABCOCK BLVD",
        "CITY:ROSS",
        "X:OAKGLEN RD and EVERGREEN RD",
        "SRC:NFD3",
        "BOX:253001",
        "UNIT:247EN1",
        "ID:F120033786",
        "INFO:COMP STATING RIGHT IN FRONT OF WEST PENN BILLIARDS THERE IS A BUILDING ON FIRE// CAN SEE SMOKE AND FLAMES",
        "DATE:05/18/2012",
        "TIME:13:54:25");
    

    doTest("T3",
        "  :29B1, Q1, TRAFFIC -WITH INJURIES, POST OFFICE ROS - MCKNIGHT 15237, ROS, at 4981 MCKNIGHT RD, ROS, US POST OFFICE, btwn MCKNIGHT CIR and SB MKNGHT RD OFRP SIEBERT RD, NFD3, 247004, F120033283, 2 CAR MVC... IN LOT OF POST OFFICE...  NO INJURIES, Units:247EN1, 312RQ40 - From 405 05/16/2012 13:49:00",
        "CODE:29B1",
        "PRI:Q1",
        "CALL:TRAFFIC -WITH INJURIES",
        "PLACE:POST OFFICE ROS - MCKNIGHT 15237",
        "ADDR:4981 MCKNIGHT RD",
        "CITY:ROSS",
        "INFO:US POST OFFICE / 2 CAR MVC... IN LOT OF POST OFFICE...  NO INJURIES",
        "X:MCKNIGHT CIR and SB MKNGHT RD OFRP SIEBERT RD",
        "SRC:NFD3",
        "BOX:247004",
        "ID:F120033283",
        "UNIT:247EN1 312RQ40",
        "DATE:05/16/2012",
        "TIME:13:49:00");
  
  }
  
  @Test
  public void testSwissvaleFireDepartment() {

    doTest("T1",
        "(CAD Page) :QRS0, Q0, E-0 QRS / EMS ASSIST, 2362 BUENA VISTA ST, SWS, btwn HIGHLAND AVE and END, EFD3, 278001, F120093743, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 15:41:12\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:QRS0",
        "PRI:Q0",
        "CALL:E-0 QRS / EMS ASSIST",
        "ADDR:2362 BUENA VISTA ST",
        "CITY:SWISSVALE",
        "X:HIGHLAND AVE and END",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093743",
        "UNIT:278EN1",
        "DATE:12/29/2012",
        "TIME:15:41:12");

    doTest("T2",
        "(CAD Page) :QRS0, Q0, E-0 QRS / EMS ASSIST, 6920 MCCLURE AVE, SWS, btwn POCONO ST and COMMERCIAL ST, EFD3, 278001, F120093717, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 12:57:10\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:QRS0",
        "PRI:Q0",
        "CALL:E-0 QRS / EMS ASSIST",
        "ADDR:6920 MCCLURE AVE",
        "CITY:SWISSVALE",
        "X:POCONO ST and COMMERCIAL ST",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093717",
        "UNIT:278EN1",
        "DATE:12/29/2012",
        "TIME:12:57:10");

    doTest("T3",
        "(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 7436 SCHOYER AVE, SWS, btwn MIRIAM ST and HAYS ST, EFD3, 278001, F120093677, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 10:41:03\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:QRS1",
        "PRI:Q1",
        "CALL:E-1 QRS / EMS ASSIST",
        "ADDR:7436 SCHOYER AVE",
        "CITY:SWISSVALE",
        "X:MIRIAM ST and HAYS ST",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093677",
        "UNIT:278EN1",
        "DATE:12/29/2012",
        "TIME:10:41:03");

    doTest("T4",
        "(CAD Page) :29B3U, F1, TRAFFIC - OTHER HAZARDS (UNK # INJ), MELROSE ST/S BRADDOCK AVE, SWS,  <7599/ 2424>, EFD3, 278001, F120093632, VEH INTO A POLE NO INJ...COMP WAS NOT ONSCENE ANOTHER PLOW DRIVER SAW THIS HAPPEN...OCC IS OUT OF THE VEH.... THIS IS ON MELROSE BETWEEN S BRADDOCK AND WOODSTOCK, Unit:278EN1 - From 505 12/29/2012 07:42:37\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:29B3U",
        "PRI:F1",
        "CALL:TRAFFIC - OTHER HAZARDS (UNK # INJ)",
        "ADDR:MELROSE ST & S BRADDOCK AVE",
        "CITY:SWISSVALE",
        "INFO:VEH INTO A POLE NO INJ...COMP WAS NOT ONSCENE ANOTHER PLOW DRIVER SAW THIS HAPPEN...OCC IS OUT OF THE VEH.... THIS IS ON MELROSE BETWEEN S BRADDOCK AND WOODSTOCK",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093632",
        "UNIT:278EN1",
        "DATE:12/29/2012",
        "TIME:07:42:37");

    doTest("T5",
        "(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 7422 PARK AVE, SWS, btwn ALLEY and PALMER ST, EFD3, 278001, F120093606, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 04:13:28\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:QRS1",
        "PRI:Q1",
        "CALL:E-1 QRS / EMS ASSIST",
        "ADDR:7422 PARK AVE",
        "CITY:SWISSVALE",
        "X:ALLEY and PALMER ST",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093606",
        "UNIT:278EN1",
        "DATE:12/29/2012",
        "TIME:04:13:28");

    doTest("T6",
        "(CAD Page) :ASTFN, F3, RQST ASST FIRE - NON EMERGENCY, 7464 MCCLURE AVE #7, SWS, btwn MONONGAHELA AVE and S BRADDOCK AVE, EFD3, 278001, F120093597, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/29/2012 03:00:44\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:ASTFN",
        "PRI:F3",
        "CALL:RQST ASST FIRE - NON EMERGENCY",
        "ADDR:7464 MCCLURE AVE",
        "APT:7",
        "CITY:SWISSVALE",
        "X:MONONGAHELA AVE and S BRADDOCK AVE",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093597",
        "UNIT:278EN1",
        "DATE:12/29/2012",
        "TIME:03:00:44");

    doTest("T7",
        "(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 7344 SCHLEY AVE, SWS, btwn PROSPECT ST and MONROE ST, EFD3, 278001, F120093500, 23YOF FELL 2 STEPS., Unit:278EN1 - From 505 12/28/2012 18:43:35\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:QRS1",
        "PRI:Q1",
        "CALL:E-1 QRS / EMS ASSIST",
        "ADDR:7344 SCHLEY AVE",
        "CITY:SWISSVALE",
        "INFO:23YOF FELL 2 STEPS.",
        "X:PROSPECT ST and MONROE ST",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093500",
        "UNIT:278EN1",
        "DATE:12/28/2012",
        "TIME:18:43:35");

    doTest("T8",
        "(CAD Page) :ASTFE, F0, RQST ASST  FIRE - EMERGENCY, WOODSTOCK AVE/SHORT ST, SWS,  <2531/ 7500>, EFD3, 278001, F120093424, COMPL REPOTING A WIRE HANGING LOW ON SHORT ST/NO SPARKS OR FLAMES..LOOKS LIKE CABLE WIRE, Unit:278EN1 - From 505 12/28/2012 13:33:50\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:ASTFE",
        "PRI:F0",
        "CALL:RQST ASST  FIRE - EMERGENCY",
        "ADDR:WOODSTOCK AVE & SHORT ST",
        "CITY:SWISSVALE",
        "INFO:COMPL REPOTING A WIRE HANGING LOW ON SHORT ST/NO SPARKS OR FLAMES..LOOKS LIKE CABLE WIRE",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093424",
        "UNIT:278EN1",
        "DATE:12/28/2012",
        "TIME:13:33:50");

    doTest("T9",
        "(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, 1901 HANOVER ST #9, SWS, btwn CHURCH ST and END, EFD3, 278001, F120093334, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/28/2012 08:36:19\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:QRS1",
        "PRI:Q1",
        "CALL:E-1 QRS / EMS ASSIST",
        "ADDR:1901 HANOVER ST",
        "APT:9",
        "CITY:SWISSVALE",
        "X:CHURCH ST and END",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093334",
        "UNIT:278EN1",
        "DATE:12/28/2012",
        "TIME:08:36:19");

    doTest("T10",
        "(CAD Page) :QRS1, Q1, E-1 QRS / EMS ASSIST, SWISSVALE TOWERS #702, SWS, at 1826 MONONGAHELA AVE #702, SWS, btwn MCCLURE AVE and CHURCH ST, EFD3, 278001, F120093326, Medical ProQA recommends dispatch at this time, Unit:278EN1 - From 505 12/28/2012 07:40:24\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:QRS1",
        "PRI:Q1",
        "CALL:E-1 QRS / EMS ASSIST",
        "PLACE:SWISSVALE TOWERS",
        "ADDR:1826 MONONGAHELA AVE",
        "APT:702",
        "CITY:SWISSVALE",
        "X:MCCLURE AVE and CHURCH ST",
        "SRC:EFD3",
        "BOX:278001",
        "ID:F120093326",
        "UNIT:278EN1",
        "DATE:12/28/2012",
        "TIME:07:40:24");

  }
  
  @Test
  public void testAlleghenyCountyEmergencyService() {

    doTest("T1",
        "(CAD Page) :CLASS1, P1, BOMB/POSS BOMB FOUND, 500 ROUTE 909, PLU, MAINTANACE BUILDING, EPD2, PLU03, P130001683, COMPL FOUND A BAG WITH AT LEAST THREE HAND GRENADES IN IT ALL THREE STILL HAVE PINS IN THEM - From 511 01/01/2013 13:38:10\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:CLASS1",
        "PRI:P1",
        "CALL:BOMB/POSS BOMB FOUND",
        "ADDR:500 ROUTE 909",
        "CITY:PLUM",
        "INFO:MAINTANACE BUILDING / COMPL FOUND A BAG WITH AT LEAST THREE HAND GRENADES IN IT ALL THREE STILL HAVE PINS IN THEM",
        "ID:P130001683",
        "SRC:EPD2",
        "BOX:PLU03",
        "DATE:01/01/2013",
        "TIME:13:38:10");

    doTest("T2",
        "(CAD Page) :1FM, P0, COUNTY FIRE MARSHAL REQUEST, 512 FOX DR, ROS, btwn END and PARK PL, APD1, ROS01, P121130172, FLAMES THRU THE ROOF.. THERE IS AN AUTISTIC MALE INSIDE.., Units:A401, A4011K, A4013, A402, AFMINT - From 708 12/31/2012 22:59:27\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:1FM",
        "PRI:P0",
        "CALL:COUNTY FIRE MARSHAL REQUEST",
        "ADDR:512 FOX DR",
        "CITY:ROSS",
        "ID:P121130172",
        "INFO:FLAMES THRU THE ROOF.. THERE IS AN AUTISTIC MALE INSIDE..",
        "X:END and PARK PL",
        "SRC:APD1",
        "BOX:ROS01",
        "UNIT:A401 A4011K A4013 A402 AFMINT",
        "DATE:12/31/2012",
        "TIME:22:59:27");

    doTest("T3",
        "(CAD Page) :CLASS1, P1, BOMB/POSS BOMB FOUND, BELTZHOOVER AVE/EDGEMONT ST, PGH,  <106/ 699>, CPD3, PP305, P121127681, COMPL REPORTING AN OBJECT THAT LOOKS LIKE A WALKIE TALKIE WITH A COUNTDOWN ON IT AND IT IS BEEPING ON BELTHOOVER AVE///COMPL THINKS IT IS A BOMB AND WILL POINT IT OUT TO AN OFC WHEN THEY GET THERE///COMPL IS STANDING ON BELTZHOOVER AVE - From 605 12/31/2012 02:25:50\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:CLASS1",
        "PRI:P1",
        "CALL:BOMB/POSS BOMB FOUND",
        "ADDR:BELTZHOOVER AVE & EDGEMONT ST",
        "CITY:PITTSBURGH",
        "SRC:CPD3",
        "BOX:PP305",
        "ID:P121127681",
        "INFO:COMPL REPORTING AN OBJECT THAT LOOKS LIKE A WALKIE TALKIE WITH A COUNTDOWN ON IT AND IT IS BEEPING ON BELTHOOVER AVE///COMPL THINKS IT IS A BOMB AND WILL POINT IT OUT TO AN OFC WHEN THEY GET THERE///COMPL IS STANDING ON BELTZHOOVER AVE",
        "DATE:12/31/2012",
        "TIME:02:25:50");

    doTest("T4",
        "(CAD Page) :1FM, P0, COUNTY FIRE MARSHAL REQUEST, 800 ROSS AVE #2, WBG, btwn CENTER ST and MILL ST, APD1, WBG01, P121127156, FIRE IN THE BASEMENT, HEATING DUCTS ARE ON FIRE., Unit:A401 - From 705 12/30/2012 20:29:54\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:1FM",
        "PRI:P0",
        "CALL:COUNTY FIRE MARSHAL REQUEST",
        "ADDR:800 ROSS AVE",
        "APT:2",
        "CITY:WILKINSBURG",
        "ID:P121127156",
        "INFO:FIRE IN THE BASEMENT / HEATING DUCTS ARE ON FIRE.",
        "X:CENTER ST and MILL ST",
        "SRC:APD1",
        "BOX:WBG01",
        "UNIT:A401",
        "DATE:12/30/2012",
        "TIME:20:29:54");

    doTest("T5",
        "(CAD Page) :CLASS1, P1, BOMB/POSS BOMB FOUND, HEINZ FIELD, PGH, at 100 ART ROONEY AVE, PGH, btwn W GENERAL ROBINSON ST and NORTH SHORE DR, CPD1, PP134, P121126507 - From 606 12/30/2012 15:37:24\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Help Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "HelpDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:CLASS1",
        "PRI:P1",
        "CALL:BOMB/POSS BOMB FOUND",
        "PLACE:HEINZ FIELD",
        "ADDR:100 ART ROONEY AVE",
        "CITY:PITTSBURGH",
        "ID:P121126507",
        "X:W GENERAL ROBINSON ST and NORTH SHORE DR",
        "SRC:CPD1",
        "BOX:PP134",
        "DATE:12/30/2012",
        "TIME:15:37:24");
    
  }
  
  @Test
  public void testRossWestViewEMS() {

    doTest("T1",
        "(CAD Page) :29B1, E1, TRAFFIC -WITH INJURIES, GRANT AVE/SHERMAN ST, MIL,  <300/ 99>, NMD1, E21012, E130078121, REPORT OF WRECKED CAR WITH FEMALE PASSED OUT, Unit:2147 - From 404 05/16/2013 10:02:14\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:29B1",
        "PRI:E1",
        "CALL:TRAFFIC -WITH INJURIES",
        "ADDR:GRANT AVE & SHERMAN ST",
        "CITY:MILLVALE",
        "INFO:REPORT OF WRECKED CAR WITH FEMALE PASSED OUT",
        "SRC:NMD1",
        "BOX:E21012",
        "ID:E130078121",
        "UNIT:2147",
        "DATE:05/16/2013",
        "TIME:10:02:14");

    doTest("T2",
        "(CAD Page) :32B2, E2, UNKNOWN - MEDICAL ALARM *NO INFO*, 431 MCKNIGHT CIR #D, ROS, btwn END and MCKNIGHT RD, BUILDING D, NMD1, E21002, E130078113, NO CONTACT MADE. RESIDENT IS AN 89 FEM ANN MAIER. 412364 6839, Unit:2141 - From 404 05/16/2013 09:51:21\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:32B2",
        "PRI:E2",
        "CALL:UNKNOWN - MEDICAL ALARM *NO INFO*",
        "ADDR:431 MCKNIGHT CIR",
        "APT:D",
        "CITY:ROSS",
        "X:END and MCKNIGHT RD",
        "INFO:BUILDING D / NO CONTACT MADE. RESIDENT IS AN 89 FEM ANN MAIER. 412364 6839",
        "SRC:NMD1",
        "BOX:E21002",
        "ID:E130078113",
        "UNIT:2141",
        "DATE:05/16/2013",
        "TIME:09:51:21");

    doTest("T3",
        "(CAD Page) :10C2, E1, CHEST PAIN - HEART ATTACK/ANGINA HISTORY, 113 PETUNIA AVE, ROS, btwn END and GOLF DR, NMD1, E21004, E130078096, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/16/2013 09:31:27\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:10C2",
        "PRI:E1",
        "CALL:CHEST PAIN - HEART ATTACK/ANGINA HISTORY",
        "ADDR:113 PETUNIA AVE",
        "CITY:ROSS",
        "X:END and GOLF DR",
        "SRC:NMD1",
        "BOX:E21004",
        "ID:E130078096",
        "UNIT:2142",
        "DATE:05/16/2013",
        "TIME:09:31:27");

    doTest("T4",
        "(CAD Page) MOVE-UP: 2142 to E21001.  - From 405 05/16/2013 08:56:06\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CALL:MOVE-UP to E21001",
        "UNIT:2142",
        "DATE:05/16/2013",
        "TIME:08:56:06");

    doTest("T5",
        "(CAD Page) :17B1G, E1, FALL -POSS. DANGEROUS BODY AREA (GROUND), 125 LAKEWOOD AVE, WVW, btwn WAVERLY AVE and ALLEY, NMD1, E21010, E130077997, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/16/2013 05:57:05\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:17B1G",
        "PRI:E1",
        "CALL:FALL -POSS. DANGEROUS BODY AREA (GROUND)",
        "ADDR:125 LAKEWOOD AVE",
        "CITY:WEST VIEW",
        "X:WAVERLY AVE and ALLEY",
        "SRC:NMD1",
        "BOX:E21010",
        "ID:E130077997",
        "UNIT:2142",
        "DATE:05/16/2013",
        "TIME:05:57:05");

    doTest("T6",
        "(CAD Page) :17B3, E1, FALL - UNKNOWN STATUS, PD MIL MILLVALE PD, MIL, at 501 LINCOLN AVE, MIL, btwn SEDGWICK ST and FORNOFF ST, NMD1, E21012, E130077959, Unit:2147 - From 405 05/16/2013 02:04:37\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:17B3",
        "PRI:E1",
        "CALL:FALL - UNKNOWN STATUS",
        "PLACE:PD MIL MILLVALE PD",
        "ADDR:501 LINCOLN AVE",
        "CITY:MILLVALE",
        "X:SEDGWICK ST and FORNOFF ST",
        "SRC:NMD1",
        "BOX:E21012",
        "ID:E130077959",
        "UNIT:2147",
        "DATE:05/16/2013",
        "TIME:02:04:37");

    doTest("T7",
        "(CAD Page) :06D2, E1, BREATHING - DIFF SPEAKING, VERLAND FOUNDATION OHI, OHI, at 212 IRIS RD, OHI, HOUSE NUMBER 111, btwn LINDA VISTA RD and RITTER RD, NMD1, E21013, E130077951, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/16/2013 01:50:05\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:06D2",
        "PRI:E1",
        "CALL:BREATHING - DIFF SPEAKING",
        "PLACE:VERLAND FOUNDATION OHI",
        "ADDR:212 IRIS RD",
        "CITY:OHIO",
        "X:LINDA VISTA RD and RITTER RD",
        "INFO:HOUSE NUMBER 111",
        "SRC:NMD1",
        "BOX:E21013",
        "ID:E130077951",
        "UNIT:2142",
        "DATE:05/16/2013",
        "TIME:01:50:05");

    doTest("T8",
        "(CAD Page) :BOAT1, E0, BOAT EMERGENCY, FORTIETH STREET BRIDGE - MILLVALE SIDE, MIL, at 190 40TH ST BRG, MIL, NMD1, E21012, E130077932, 10 MIN DELAY. CALLER DROVE THROUGH THE AREA AND SAW A SHORTER WHITE MALE EMERGE FROM UNDERNEATH THE BRIDGE. MALE TOLD CALLER THAT HIS BOAT CAPSIZED AND THAT HE NEEDED HELP. CALLER ASKED HIM IF EVERYONE WAS ABLE TO GET OUT AND HE SAID YES. UNK WHERE THIS IS., Units:2147, SQ2175 - From 404 05/16/2013 01:04:52\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:BOAT1",
        "PRI:E0",
        "CALL:BOAT EMERGENCY",
        "PLACE:FORTIETH STREET BRIDGE - MILLVALE SIDE",
        "ADDR:190 40TH ST BRG",
        "CITY:MILLVALE",
        "SRC:NMD1",
        "BOX:E21012",
        "ID:E130077932",
        "INFO:10 MIN DELAY. CALLER DROVE THROUGH THE AREA AND SAW A SHORTER WHITE MALE EMERGE FROM UNDERNEATH THE BRIDGE. MALE TOLD CALLER THAT HIS BOAT CAPSIZED AND THAT HE NEEDED HELP. CALLER ASKED HIM IF EVERYONE WAS ABLE TO GET OUT AND HE SAID YES. UNK WHERE THIS IS.",
        "UNIT:2147 SQ2175",
        "DATE:05/16/2013",
        "TIME:01:04:52");

    doTest("T9",
        "(CAD Page) :17D3, E0, FALL - NOT ALERT, MANOR CARE ROS #127B, ROS, at 1105 PERRY HWY #127B, ROS, btwn TRION RD and SEWICKLEY OAKMONT RD, NMD1, E21002, E130077894, Medical ProQA recommends dispatch at this time, Unit:2142 - From 404 05/15/2013 23:22:55\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:17D3",
        "PRI:E0",
        "CALL:FALL - NOT ALERT",
        "PLACE:MANOR CARE ROS",
        "ADDR:1105 PERRY HWY",
        "APT:127B",
        "CITY:ROSS",
        "X:TRION RD and SEWICKLEY OAKMONT RD",
        "SRC:NMD1",
        "BOX:E21002",
        "ID:E130077894",
        "UNIT:2142",
        "DATE:05/15/2013",
        "TIME:23:22:55");

    doTest("T10",
        "(CAD Page) :FRRES1, E1, DWELLING FIRE, 113 VIOLET ST, ROS, btwn PRINCETON AVE and END, NMD1, E21004, E130077873, GRILL ON FIRE, Unit:2141 - From 404 05/15/2013 22:24:38\n\n\n\n" +
        "----------------------------------------- LEGAL DISCLAIMER\n" +
        "Confidentiality Notice: This e-mail message, including any\n" +
        "attachments, is for the sole use of the intended recipient(s) and\n" +
        "may contain confidential and privileged information. Any\n" +
        "unauthorized review, use, disclosure, forwarding, or distribution\n" +
        "is prohibited. If you are not the intended recipient, please\n" +
        "contact the sender by reply e-mail and destroy all copies of the\n" +
        "original message. Any questions should be directed to Allegheny\n" +
        "County Service Desk at 412-350-HELP (412-350-4357) or e-mail\n" +
        "ServiceDesk@AlleghenyCounty.US\n" +
        "-----------------------------------------   ",

        "CODE:FRRES1",
        "PRI:E1",
        "CALL:DWELLING FIRE",
        "ADDR:113 VIOLET ST",
        "CITY:ROSS",
        "X:PRINCETON AVE and END",
        "INFO:GRILL ON FIRE",
        "SRC:NMD1",
        "BOX:E21004",
        "ID:E130077873",
        "UNIT:2141",
        "DATE:05/15/2013",
        "TIME:22:24:38");

  }
  
  public static void main(String[] args) {
    new PAAlleghenyCountyParserTest().generateTests("T1");
  }
}
