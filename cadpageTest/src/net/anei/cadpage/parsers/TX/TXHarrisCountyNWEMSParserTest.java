package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Harris County NWEMS, TX
Contact: "Charles O'Quin" <charles.oquin@nwems.org>
Sender: cad@nwems.org

  / * 13415 MEDICAL COMPLEX DR* 320* * * * 01C05* ABD PAIN -Males w/pain above navel* * * M-1* * * * *
  / * 28602 TOMBALL PKWY* * * * * 19D04* HEART PROBLEMS-Clammy* * * M-1* * * * *
  / * 502 JAMES ST* * * * * 17A01* FALL - Not Dangerous* * * M-1* * * * *
  / * 605 HOLDERRIETH BLVD* 527* * * * 33A02* OUT OF DISTRICT TRANSFER* * * M-1* * * * *
  / * 1019 HICKORY POST CT* * * * * OVERDOSE* OVERDOGE/INGESTION* * * M-1* * * * *

Contact: Active911
Agency name: Tomball Fire Department
Location: Tomball, TX, United States

* 24215 KUYKENDAHL RD* * * * * * 372G* * 65B01* MUTUAL AID - Emergency to incident (single unit)* * * E-1* * * * *\r\n
* 14302 FM 2920* * * * PARK CT* PARK CT* 288K* * 52C03P* ALARMS - COMMERCIAL STRUCTURE - Pull station* * * E-1,TOW-1* * * * *\r\n
* FM 2920 // CALVERT RD* * * * CALVERT RD* TREICHEL RD* 288J* * 59B02O* FUEL SPILL - Contained small spill - OUTSIDE* * * E-1* * * * *\r\n
* 1100 GRAHAM DR* 16 BUILD* * * LAWRENCE ST* TOMBALL PKWY* 288L* * 67O01* OUTSIDE FIRE - Controlled burn* * * E-1* * * * *\r\n
* 27614 DANA DR* * * * DEAD END* ALICE RD* 288P* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,TOW-1* * * * *\r\n
* FM 2920 // CALVERT RD* * * * CALVERT RD* TREICHEL RD* 288J* * MVA* MAJOR ACCIDENT* * * E-1,M-4* * * * *\r\n
* 9714 FM 2920* * * * WALDEN WAY* COMMERCIAL LN* 289L* * 52C01S* ALARMS - HIGH LIFE HAZARD - Smoke detector* * * TOW-1* * * * *\r\n
* 605 HOLDERRIETH BLVD* ER ENTRA* * * GRAHAM DR* DEAD END* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 14235 FM 2920* * * * TOMBALL EXPY* PARK CT* 288K* * 29B01* MVA - Injuries* * * E-1* * * * *\r\n
* 2627 S CHERRY ST* 234* * * PINE MEADOWS ST* HOLDERRIETH RD* 288V* * 31D02* UNCONSCIOUS - W/effective breathing* * * E-1,M41,S-1,TOW-1* * * * *\r\n
* 12919 SPRUCE CIR* * * * PINE WOODS ST* HEMLOCK ST* 288R* * 60B01O* GAS LEAK - Outside residential like or tank - ODOR* * * E-1,TOW-1* * * * *\r\n
* 30500 SH 249* * * * TOMBALL EXPY* TOMBALL PKWY* 288Z* * 68A01* SMOKE INVESTIGATION (OUTSIDE) - LIGHT smoke* * * E-1* * * * *\r\n
* 1055 BAKER DR* * * * LEE ANN* QUINN RD* 288C* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 30403 QUINN RD* * * * BAKER DR* ZION RD* 288C* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 30500 TOMBALL PKWY* * * * HEIDI LN* ZION RD* 288B* * 29B01* MVA - Injuries* * * E-1* * * * *\r\n
* 101 S WALNUT ST* * * * W MAIN* MARKET ST* 288H* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 27721 TOMBALL PKWY* 100* * * ALICE RD* HIRSCHFIELD RD* 288Q* * 52C03* Alarm - COMMERCIAL STRUCTURE* * * TOW-1* * * * *\r\n
* FM 2920 // PARK RD* * * * PARK RD* TOMBALL CEMETERY RD* 288J* * 67B01* SMALL OUTSIDE Fire* * * B-2,E-1* * * * *\r\n
* 30555 TOMBALL PKWY* * * * HEIDI LN* ZION RD* 288B* * 52C03P* ALARMS - COMMERCIAL STRUCTURE - Pull station* * * E-1,TOW-1* * * * *\r\n
* 14333 FM 2920* 106* * * WOODFOREST DR* CALVERT RD* 288K* * 2 FIRE CALL* FIRE CALL* * * E-1* * * * *\r\n
* 1011 VILLAGE SQUARE DR* 615* * * HIGH ST* QUINN RD* 288G* * 23C01I* INTENTIONAL OVERDOSE - Not alert* * * 484,E-1,M-1* * * * *\r\n
* 27721 TOMBALL PKWY* 100* * * ALICE RD* HIRSCHFIELD RD* 288Q* * 52C03S* ALARMS - COMMERCIAL STRUCTURE - Smoke detector* * * E-1* * * * *\r\n
* 1100 GRAHAM DR* 1602* * * LAWRENCE ST* TOMBALL PKWY* 288L* * 17D02* FALL - Unconscious or arrest* * * E-1,M-1* * * * *\r\n
* 27721 TOMBALL PKWY* 100* * * ALICE RD* HIRSCHFIELD RD* 288Q* * 52C03P* ALARMS - COMMERCIAL STRUCTURE - Pull station* * * E-1* * * * *\r\n
* 27650 TOMBALL PKWY* * * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-2,TOW-1* * * * *\r\n
* 516 CLAYTON ST* * * * S PINE ST* S MAGNOLIA ST* 288H* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 18110 HILLOCK GLEN LN* * * * LOFTY EDGE ST* DEAD END* 327H* * 31D02* UNCONSCIOUS - W/effective breathing* * * M-2,S-1,TOW-1* * * * *\r\n
* 605 HOLDERRIETH BLVD* PARK E* * * GRAHAM DR* DEAD END* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 28155 TOMBALL PKWY* 2* * * MEDICAL COMPLEX DR* MICHEL RD* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 702 S OAK* * * * WILLOWICK ST* BELMONT ST* 288M* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 110 ELLA AVE* * * * W QUINN RD* ALMA ST* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 915 BAKER DR* 3336* * * LEE ANN* QUINN RD* 288C* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-1,E-1* * * * *\r\n
* FM 2920 // TELGE* * * * * * * * 67D03U* LARGE OUTSIDE fire - Unknown if threatening* * * B-1,E-1* * * * *\r\n
* 100 W MAIN* * * * S ELM ST* S WALNUT ST* 288H* * 29B01* MVA - Injuries* * * E-1* * * * *\r\n
* 13415 MEDICAL COMPLEX DR* * * * LAWRENCE ST* DEAD END* 288L* * 52C01G* ALARMS - High life hazard - GENERAL* * * E-1* * * * *\r\n
* 400 FANNIN ST* * * * S OAK* S PINE ST* 288H* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 1100 S CHERRY ST* * * * ANNA ST* JUSTIN CT* 288M* * 67B03* OUTSIDE FIRE - Unknown situation* * * TOW-1* * * * *\r\n
* 14083 FM 2920* * * * TOMBALL PKWY* TOMBALL EXPY* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 27650 TOMBALL PKWY* * * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n
* 27610 DANA DR* * * * DEAD END* ALICE RD* 288P* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,TOW-1* * * * *\r\n
* THIESS/ JOHNSON* * * * * * * * 59C04O* FUEL SPILL - Unknown - OUTSIDE* * * TOW-1* * * * *\r\n
* 1322 DOVE TRAILS* * * * ARBOR PINE* DEAD END* 288C* * 52B01S* ALARMS - Residential Single - Smoke detector* * * TOW-1* * * * *\r\n
* 14333 FM 2920* 106* * * WOODFOREST DR* CALVERT RD* 288K* * 52C03* Alarm - COMMERCIAL STRUCTURE* * * E-1* * * * *\r\n
* 14711 OLIN RD* * * * CALVERT RD* DEAD END* 288N* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n
* 1025 ALMA ST* B* * * LAWRENCE ST* RAYMOND AVE* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n
* 13415 MEDICAL COMPLEX DR* * * * LAWRENCE ST* DEAD END* 288L* * 52C03S* ALARMS - COMMERCIAL STRUCTURE - Smoke detector* * * E-1* * * * *\r\n
* 735 E MAIN* * * * N WILLOW ST* SNOOK LN* 289E* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1,TOW-1* * * * *\r\n
* 30555 TOMBALL PKWY* SOUTH* * * HEIDI LN* ZION RD* 288B* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-1,E-1* * * * *\r\n
* 14251 FM 2920* * * * TOMBALL EXPY* PARK CT* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-1,E-1* * * * *\r\n
* 1110 INWOOD* * * * ROXANNE DR* QUINN RD* 288G* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 24903 ELMIRA* * * * ROBERTA* HUFSMITH RD* 249X* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n
* FM 2920 // TOMBALL PKWY* * * * TOMBALL PKWY* TOMBALL EXPY* 288K* * 29B04* MVA - Unknown status* * * E-1* * * * *\r\n
* 27830 CALVERT RD* * * * MARY JANE LN* MEDICAL COMPLEX DR* 288N* * 67O01* OUTSIDE FIRE - Controlled burn* * * TOW-1* * * * *\r\n
* 506 GRAHAM* * * * * * * * Susp Per* Suspicious/Wanted Person - Suspicious person* * * 512,TOW-1* * * * *\r\n
* 27620 TOMBALL PKWY* A-6* * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n
* 400 FANNIN ST* * * * S OAK* S PINE ST* 288H* * 55B04* ELECTRICAL HAZARD - Electrical Odor* * * E-1* * * * *\r\n
* FM 2920 // E HUFFSMITH KHROVILLE* * * * E HUFFSMITH KHROVILLE* STUEBNER ARLINE* 289E* * 69D03* STRUCTURE FIRE - COMMERCIAL STRUCTURE* * * 497,527,552,700,C-2,E-1,KE36,KL36,KTW31,M-2,ME182,ME184,MT184,RHE51,S-1,SR75,TOW-1* * * * *\r\n
* 29807 TOMBALL PKWY* 464* * * BROWN RD* BAKER DR* 288B* * 69D05* STRUCTURE FIRE - Residential MULTIPLE* * * 501,E-1,TOW-1* * * * *\r\n
* FM 2920 // TOMBALL EXPY* * * * TOMBALL EXPY* PARK CT* 288K* * 29D02* MVA - High mechanism* * * BAT-1,M-4,TOW-1* * * * *\r\n
* 27702 BRIAR MEADOW* * * * DEAD END* ALICE RD* 288P* * 57B03* EXPLOSION - Unknown situation (investigation)* * * E-1,KE36,KL36,M-2,RHE51,RHT51,SR75,TOW-1* * * * *\r\n
* 1915 SCOTCH PINE ST* * * * THEISS LN* PINE WOODS ST* 288Q* * 52B01O* ALARMS - Residential Single - OTHER* * * TOW-1* * * * *\r\n
* 14420 FM 2920* * * * PARK CT* PARK CT* 288K* * 52C03* Alarm - COMMERCIAL STRUCTURE* * * E-1* * * * *\r\n
* HOLDERRIETH RD // HUFSMITH KOHRVILLE R* * * * HUFSMITH KOHRVILLE R* SARATOGA LN* 289T* * MVA* MAJOR ACCIDENT* * * E-1,M-1* * * * *\r\n
* 18023 HILLOCK GLEN LN* * * * DEAD END* LOFTY EDGE ST* 327H* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,E-2,TOW-1* * * * *\r\n
* 250 SCHOOL ST* * * * GRAHAM DR* MICHEL RD* 288M* * 52C01P* ALARMS - HIGH LIFE HAZARD - Pull station* * * E-1* * * * *\r\n
* 27650 TOMBALL PKWY* * * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n
* 700 E MAIN* BK* * * N WILLOW ST* SNOOK LN* 289E* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1,TOW-1* * * * *\r\n
* 14018 FM 2920* * * * TOMBALL PKWY* TOMBALL EXPY* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 28520 TOMBALL PKWY* * * * GRAHAM DR* W MAIN* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n
* 25404 DECKER PRAIRIE ROSEHILL RD* * * * * * 287AMCF* * 65B01* MUTUAL AID - Emergency to incident (single unit)* * * B-1* * * * *\r\n
* 14110 ALICE RD* * * * BRIAR MEADOW* GREEN MEADOW RD* 288P* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,E-1* * * * *\r\n

Contact: Active911
Agency name: Tomball Police Department
Location: Tomball, TX, United States

201239629* 27844 TOMBALL PKWY* * * TOMBALL* * * * * Alarm Burg* Alarms - Burglary/Intrusion* 671, CENTRAL SECURITY* 888-642-4567* 121,141,442* * Medical: No* Hazards: No* 12/28/2012 07:46:15 : pos5 : scundiff 442 ADV THERE ARE PEOPLE ON LOCATION 12/28/2012 07:44:45 : pos5 : scundiff ** EPD Case Complete ** 12/28/2012 07:44:30 : pos5 : scundiff ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: SUPERIOR CAR WASH * 5.The activation area is: SHOP BACK DOOR * 6.The phone number of the business/resident/owner is: 281-516-3434 * 7.A keyholder/owner will be contacted. 12/28/2012 07:43:41 : pos5 : scundiff ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/28/2012 07:43:29 : pos5 : scundiff ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Quest
201239615* 29807 TOMBALL PKWY* * * TOMBALL* BROWN RD* BAKER DR* 288B* Landmark Comment: NO KNOX BOX AT THIS LOCATION* Dis Ver Sm* Disturbance/Nuisance - Verbal (Individual or small group)* DAY, MARK* 832-229-8503* 365,517,552* 7101* Medical: No* Hazards: No* 12/28/2012 02:12:38 : pos10 : PTOMPKINS REP AD THAT IT SOUNDED LIKE A MALE AND FEMALE YELLING AT EACH OTHER AND SLAMMING DOORS 12/28/2012 02:09:40 : pos10 : PTOMPKINS ** EPD Case Complete ** 12/28/2012 02:09:37 : pos10 : PTOMPKINS ** EPD Key Questions Finished ** Key Questions: * 5.Weapons were not involved or mentioned. * 8.The suspect/person responsible is on scene. * 9.The suspect's description is not known. * 10.It is not known if the suspect arrived in a vehicle. * 11.No one is reported to be in danger. * 12.It is not known if alcohol or drugs are involved. * 13.It is not known if there is a court order/restraining order in place. * 14.It is not known if anyone is injured or sick. 12/28/2012 02:08:54 : pos10 : PTOMPKINS ** EP
201239559* 28437 TOMBALL PKWY* * * TOMBALL* GRAHAM DR* W MAIN* 288K* Landmark Comment: KNOX BOX - OTHER OFFICE IN CENTER* 4B03S* * IREANE* 832-515-4007* 141,295,72,M4,S1* 7102* Medical: No* Hazards: No* 12/27/2012 13:20:27 : pos32 : CKNOWERS FEMALE CAME INTO CLINIC SAYING SHE HAD BEEN SEXUALLY ASSULTED 12/27/2012 13:18:57 : pos32 : CKNOWERS PD CHECKING BY 12/27/2012 13:18:43 : pos32 : CKNOWERS ** EMD Case Complete ** 12/27/2012 13:18:41 : pos32 : CKNOWERS ** EMD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 04B03 Suffix: S CAD Incident Code: 4B03S Key Questions: * 1.The patient was sexually assaulted. * 2.It's not known when this happened. * 3.The assailant is gone, location unknown. * 4.The assailant is not armed. * 5.It's not known if there is SERIOUS bleeding. * 6.She is completely alert (responding appropriately). * 7.It's not known if she has other injuries. 12/27/2012 13:18:02 : pos32 : CKNOWERS ** EMD Case Entry Finished ** Chief Complaint Number: 4 Key Questions
201239554* 724 BARBARA ST* * * TOMBALL* JAMES ST* VERNON AVE* 288L* * Susp Per* Suspicious/Wanted Person - Suspicious person* BLAIR,NITA* 281-687-5794* 141,72* 7102* Medical: No* Hazards: No* 12/27/2012 11:34:21 : pos10 : mrosenberg ** EPD Case Complete ** 12/27/2012 11:34:19 : pos10 : mrosenberg ** EPD Key Questions Finished ** Key Questions: * 10.The location of the suspect/person responsible is not known. * 11.The suspect's description is: * 12.It is not known if the suspect arrived in a vehicle. * 13.No one is reported to be in danger. 12/27/2012 11:34:14 : pos10 : mrosenberg ** EPD Additional Info ** PERSON 1 Info: type Suspect race WHITE gender MALE clothing WHITE HOOD 12/27/2012 11:33:48 : pos10 : mrosenberg ** EPD Recommended Dispatch ** Response Text: Charlie Dispatch Level: 129C01 CAD Incident Code: Susp Per Key Questions: * 1.The caller is on scene. * 2.This is a 2nd party caller. * 3.This incident is in progress. * 4.The caller is on scene. * 5.This is a 2nd party caller. 
201239539* 14424 FM 2920* * * TOMBALL* PARK CT* PARK CT* 288K* * Alarm Burg* Alarms - Burglary/Intrusion* opr MILSA* 877-238-7739* 295,442* 7101* Medical: No* Hazards: No* 12/27/2012 07:06:37 : pos10 : mrosenberg ** EPD Case Complete ** 12/27/2012 07:06:35 : pos10 : mrosenberg ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: OFFICE DEPOT SUPPLY STORE * 5.The activation area is: POE INT MOT * 6.The phone number of the business/resident/owner is: 2812555568 * 7.A keyholder/owner will be contacted. 12/27/2012 07:05:59 : pos10 : mrosenberg ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/27/2012 07:05:41 : pos10 : mrosenberg ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller Statement: ALARM. 12/27/2012 07:05:32 : pos10 
201239469* 1415 ASHLEY CT* * * TOMBALL* AGG RD* DEAD END* 288M* NBH: CHERRY Meadows* Susp Cir* Suspicious/Wanted Person - Suspicious circumstances* MCSWAIN, JEAN* 281-351-1321* 216,395* 7201* Medical: No* Hazards: No* 12/26/2012 12:49:50 : pos10 : eoualline ** EPD Case Complete ** 12/26/2012 12:49:36 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 7.The location of the suspect/person responsible is not known. * 8.The suspect's description is not known. * 9.It is not known if the suspect arrived in a vehicle. * 10.No one is reported to be in danger. 12/26/2012 12:49:10 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Charlie Dispatch Level: 129C05 CAD Incident Code: Susp Cir Key Questions: * 1.The caller is on scene. * 2.This is a 3rd party caller. * 3.This incident is in progress. * 4.This incident involves SUSPICIOUS circumstances. * 5.Weapons were not involved or mentioned. * 6.The circumstances are suspicious because: OPEN FRONT DOOR ON EMPTY 
201239470* 14060 FM 2920* * * TOMBALL* TOMBALL PKWY* TOMBALL EXPY* 288K* Landmark Comment: KNOX BOX ON LOCATION* FOLL* FOLLOW UP* * 281-516-2184* 295* 7101* Medical: No* Hazards: No* 12/26/2012 12:57:24 : pos10 : eoualline Landmark Comment: KNOX BOX ON LOCATION Landmark: KROGER FOOD STORE-TOMBALL*
201239466* 29926 TOMBALL PKWY* * * TOMBALL* BROWN RD* BAKER DR* 288B* * Theft* Theft (Larceny) - Theft (larceny)* HEIM, JARED* 281-351-1474* 395* 7101* Medical: No* Hazards: No* 12/26/2012 11:15:48 : pos10 : eoualline Landmark: VALERO FUEL STATION AND CORNER STORE Cross streets: BROWN RD//BAKER DR WALLET STOLEN AT VALERO*
201239462* 1303 E HUFSMITH RD* * * TOMBALL* SNOOK LN* ZION RD* 249W* Landmark Comment: 281-378-5989/fax NBH: HUFSMITH* Alarm Burg* Alarms - Burglary/Intrusion* SECURE TECH* 888-943-1205* 295* 7201* Medical: No* Hazards: No* 12/26/2012 10:37:21 : pos10 : eoualline ** EPD Case Complete ** 12/26/2012 10:37:11 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: ROBERET SMITH * 5.The activation area is: GENERAL * 6.The phone number of the business/resident/owner is: NO PREMISE PHONE NUMBER * 7.A keyholder/owner will be contacted. 12/26/2012 10:36:33 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/26/2012 10:36:23 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller S
201239461* 27407 TOMBALL PKWY* * * TOMBALL* THEISS LN* HOLDERRIETH RD* 288Q* Landmark Comment: NO KNOX BOX AT THIS LOCATION* Burg Pst* Burglary/Home invasion - Past burglary (break and enter)* LAURA* 281-255-9800* 216,395* 7201* Medical: No* Hazards: No* 12/26/2012 10:24:54 : pos10 : eoualline ** EPD Case Complete ** 12/26/2012 10:24:43 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 110B02 CAD Incident Code: Burg Pst Key Questions: * 1.The caller is on scene. * 2.This is a 3rd party caller. * 3.It is not known when this incident happened. * 4.The suspect/person/vehicle is not in the area. * 5.This incident involves a BURGLARY. * 6.It is not known what was taken. 12/26/2012 10:23:32 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 110 Key Questions: Caller Statement: STORAGE UNIT BURGLARIZED. 12/26/2012 10:23:07 : pos10 : eoualline Cross streets: THEISS LN//HOLDERRIETH RD Landmark: EXCEL STORAGE Landmark Comment: NO KNOX
201239456* 501 CLAYTON ST* * * TOMBALL* S PINE ST* S MAGNOLIA ST* 288H* * WELFARE CK* WELFARE CHECK* MCINVERY, STEVEN* * 216,295,600* 7102* Medical: No* Hazards: No* 12/26/2012 08:56:31 : pos10 : eoualline Cross streets: S PINE ST//S MAGNOLIA ST*
201239454* 14000 FM 2920* * * TOMBALL* * * * * TRAFFIC STOP* TRAFFIC STOP* * 281-723-0629* 395* * Medical: No* Hazards: No* 12/26/2012 08:15:20 : pos10 : eoualline *
201239453* 1475 E MAIN* * * TOMBALL* S PERSIMMON RD* FM 2920* 289E* Landmark Comment: NO KNOX BOX* TRAFFIC STOP* TRAFFIC STOP* * 281-516-2249* 72* 7201* Medical: No* Hazards: No* 12/26/2012 08:04:15 : pos10 : eoualline Landmark Comment: NO KNOX BOX Landmark: STRIPES L.L.C*
201239452* 800 E MAIN* * * TOMBALL* * * * * TRAFFIC STOP* TRAFFIC STOP* * * 72* * Medical: No* Hazards: No* 12/26/2012 07:45:22 : pos10 : eoualline *
201239381* MICHEL RD // TOMBALL PKWY* * * TOMBALL* LAWRENCE ST* TOMBALL PKWY* 288L* Landmark Comment: KNOX BOX LOCATED NEAR FRONT ENTRY DOOR* Dist Intox* Disturbance/Nuisance - Intoxicated/Chemically Impaired* ERIC* 281-995-6620* 216,395,536,72* 7102* Medical: No* Hazards: No* 12/25/2012 11:11:07 : pos10 : eoualline WILL BE OUT ON MICHAEL CLARK 12/25/2012 11:06:44 : pos10 : eoualline 13798 MICHEL RD 12/25/2012 11:04:13 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 11:04:10 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 7.The suspect/person responsible is on scene. * 8.The suspect's description is: * 9.The suspect did not arrive in a vehicle. * 10.No one is reported to be in danger. * 11.There is not a court order/restraining order in place. * 12.No one is reportedly injured or sick. 12/25/2012 11:03:48 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 113B05 CAD Incident Code: Dist Intox Key Questions: * 1.The calle
201239379* 13515 SPRING CT* * * TOMBALL* SPRING FOREST WAY* DEAD END* 288C* NBH: Spring Forest Estates* Alarm Burg* Alarms - Burglary/Intrusion* SMITH THOMPSON* 972-526-8500* 395,72* 7102* Medical: No* Hazards: No* 12/25/2012 10:55:46 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 10:55:41 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: JOHN WIDMER RESIDENCE * 5.The activation area is: GENERAL * 6.The phone number of the business/resident/owner is: 281 351 9357 * 7.A keyholder/owner will be contacted. 12/25/2012 10:54:48 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/25/2012 10:54:38 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller Statement: AL
201239377* 14320 FM 2920* A* * TOMBALL* PARK CT* PARK CT* 288K* Landmark Comment: KNOX BOX ON LOCATION* Alarm Burg* Alarms - Burglary/Intrusion* STANLEY SECUIRTY* 800-689-4984* 216,395* 7101* Medical: No* Hazards: No* 12/25/2012 10:31:57 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 10:31:49 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: LESLIE POOL SUPPLY * 5.The activation area is: FRONT MOTION * 6.The phone number of the business/resident/owner is: 281 516 3833 * 7.A keyholder/owner will be contacted. 12/25/2012 10:30:47 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/25/2012 10:30:30 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller Statemen
201239375* 22311 HUFSMITH KOHRVILLE RD* * * HARRIS CO* COUNTRY CLUB GREEN* WILLOW CREEK ESTATES* 289J* Landmark Comment: KNOX BOX LOCATED AT FRONT GATE* Alarm Burg* Alarms - Burglary/Intrusion* SEMBARA* 281-220-4076* 395,536* 7201* Medical: No* Hazards: No* 12/25/2012 10:01:38 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 10:01:30 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: SALCO * 5.The activation area is: NW WAREHOUSE OVERHEAD DOORS * 6.The phone number of the business/resident/owner is: 281 351 0274 * 7.A keyholder/owner will be contacted. 12/25/2012 10:00:29 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/25/2012 10:00:16 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint 
201239297* 400 FANNIN ST* * * TOMBALL* S OAK* S PINE ST* 288H* * JAIL DUTY* JAIL DUTY* WALKER, JUDGE* 281-351-5451* 216,72* 7102* Medical: No* Hazards: No* 12/24/2012 11:46:50 : pos10 : eoualline Landmark: TOMBALL CITY JAIL Cross streets: S OAK//S PINE ST*
201239288* 28048 TOMBALL PKWY* F* * TOMBALL* ALICE RD* HIRSCHFIELD RD* 288Q* Landmark Comment: NO KNOX BOX* DISTURBANCE* DISTURBANCE* * 281-351-2274* 216,395,536,72* 7201* Medical: No* Hazards: No* 12/24/2012 10:17:14 : pos10 : eoualline Cross streets: ALICE RD//HIRSCHFIELD RD Landmark: CASH AMERICA PAWN Landmark Comment: NO KNOX BOX*
201239987* 6004 BREEN DR* * * * ZUINN ST* ANTOINE DR* 411G* Geo Comment: HCEC NBH: RECREATION ACRES* 67O01* OUTSIDE FIRE - Controlled burn* * * DE-41* 4812* * * 12/31/2012 11:49:28 : pos32 : CKNOWERS ** EFD Case Complete ** 12/31/2012 11:49:26 : pos32 : CKNOWERS ** EFD Recommended Dispatch ** Response Text: Omega Dispatch Level: 67O01 CAD Incident Code: 67O01 Key Questions: * 1.The caller is on scene (1st party). * 2.This is a controlled burn. * 3.The fire has not been extinguished. * 4.The fire is not threatening anything at present. * 5.There are no apparent electrical lines on the ground. * 6.No one is reported to be in danger. * 7.The fire is not spreading. * 8.It is not known what size of an area is burning. * 9.No one is reported to be injured. 12/31/2012 11:48:57 : pos32 : CKNOWERS Cross streets: ZUINN ST//ANTOINE DR Geo Comment: HCEC NBH: RECREATION ACRES*\r\n

*/

public class TXHarrisCountyNWEMSParserTest extends BaseParserTest {
  
  public TXHarrisCountyNWEMSParserTest() {
    setParser(new TXHarrisCountyNWEMSParser(), "HARRIS COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "  / * 13415 MEDICAL COMPLEX DR* 320* * * * 01C05* ABD PAIN -Males w/pain above navel* * * M-1* * * * *",
        "ADDR:13415 MEDICAL COMPLEX DR",
        "APT:320",
        "CODE:01C05",
        "CALL:ABD PAIN -Males w/pain above navel",
        "UNIT:M-1");

    doTest("T2",
        "  / * 28602 TOMBALL PKWY* * * * * 19D04* HEART PROBLEMS-Clammy* * * M-1* * * * *",
        "ADDR:28602 TOMBALL PKWY",
        "CODE:19D04",
        "CALL:HEART PROBLEMS-Clammy",
        "UNIT:M-1");

    doTest("T3",
        "  / * 502 JAMES ST* * * * * 17A01* FALL - Not Dangerous* * * M-1* * * * *",
        "ADDR:502 JAMES ST",
        "CODE:17A01",
        "CALL:FALL - Not Dangerous",
        "UNIT:M-1");

    doTest("T4",
        "  / * 605 HOLDERRIETH BLVD* 527* * * * 33A02* OUT OF DISTRICT TRANSFER* * * M-1* * * * *",
        "ADDR:605 HOLDERRIETH BLVD",
        "APT:527",
        "CODE:33A02",
        "CALL:OUT OF DISTRICT TRANSFER",
        "UNIT:M-1");

    doTest("T5",
        "  / * 1019 HICKORY POST CT* * * * * OVERDOSE* OVERDOGE/INGESTION* * * M-1* * * * *",
        "ADDR:1019 HICKORY POST CT",
        "CODE:OVERDOSE",
        "CALL:OVERDOGE/INGESTION",
        "UNIT:M-1");
   
  }
  
  @Test
  public void testTomballFire() {

    doTest("T1",
        "* 24215 KUYKENDAHL RD* * * * * * 372G* * 65B01* MUTUAL AID - Emergency to incident (single unit)* * * E-1* * * * *\r\n",
        "ADDR:24215 KUYKENDAHL RD",
        "MAP:372G",
        "CODE:65B01",
        "CALL:MUTUAL AID - Emergency to incident (single unit)",
        "UNIT:E-1");

    doTest("T2",
        "* 14302 FM 2920* * * * PARK CT* PARK CT* 288K* * 52C03P* ALARMS - COMMERCIAL STRUCTURE - Pull station* * * E-1,TOW-1* * * * *\r\n",
        "ADDR:14302 FM 2920",
        "X:PARK CT & PARK CT",
        "MAP:288K",
        "CODE:52C03P",
        "CALL:ALARMS - COMMERCIAL STRUCTURE - Pull station",
        "UNIT:E-1,TOW-1");

    doTest("T3",
        "* FM 2920 // CALVERT RD* * * * CALVERT RD* TREICHEL RD* 288J* * 59B02O* FUEL SPILL - Contained small spill - OUTSIDE* * * E-1* * * * *\r\n",
        "ADDR:FM 2920 & CALVERT RD",
        "X:CALVERT RD & TREICHEL RD",
        "MAP:288J",
        "CODE:59B02O",
        "CALL:FUEL SPILL - Contained small spill - OUTSIDE",
        "UNIT:E-1");

    doTest("T4",
        "* 1100 GRAHAM DR* 16 BUILD* * * LAWRENCE ST* TOMBALL PKWY* 288L* * 67O01* OUTSIDE FIRE - Controlled burn* * * E-1* * * * *\r\n",
        "ADDR:1100 GRAHAM DR",
        "APT:16 BUILD",
        "X:LAWRENCE ST & TOMBALL PKWY",
        "MAP:288L",
        "CODE:67O01",
        "CALL:OUTSIDE FIRE - Controlled burn",
        "UNIT:E-1");

    doTest("T5",
        "* 27614 DANA DR* * * * DEAD END* ALICE RD* 288P* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,TOW-1* * * * *\r\n",
        "ADDR:27614 DANA DR",
        "X:DEAD END & ALICE RD",
        "MAP:288P",
        "CODE:67O01",
        "CALL:OUTSIDE FIRE - Controlled burn",
        "UNIT:B-2,TOW-1");

    doTest("T6",
        "* FM 2920 // CALVERT RD* * * * CALVERT RD* TREICHEL RD* 288J* * MVA* MAJOR ACCIDENT* * * E-1,M-4* * * * *\r\n",
        "ADDR:FM 2920 & CALVERT RD",
        "X:CALVERT RD & TREICHEL RD",
        "MAP:288J",
        "CODE:MVA",
        "CALL:MAJOR ACCIDENT",
        "UNIT:E-1,M-4");

    doTest("T7",
        "* 9714 FM 2920* * * * WALDEN WAY* COMMERCIAL LN* 289L* * 52C01S* ALARMS - HIGH LIFE HAZARD - Smoke detector* * * TOW-1* * * * *\r\n",
        "ADDR:9714 FM 2920",
        "X:WALDEN WAY & COMMERCIAL LN",
        "MAP:289L",
        "CODE:52C01S",
        "CALL:ALARMS - HIGH LIFE HAZARD - Smoke detector",
        "UNIT:TOW-1");

    doTest("T8",
        "* 605 HOLDERRIETH BLVD* ER ENTRA* * * GRAHAM DR* DEAD END* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:605 HOLDERRIETH BLVD",
        "APT:ER ENTRA",
        "X:GRAHAM DR & DEAD END",
        "MAP:288L",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T9",
        "* 14235 FM 2920* * * * TOMBALL EXPY* PARK CT* 288K* * 29B01* MVA - Injuries* * * E-1* * * * *\r\n",
        "ADDR:14235 FM 2920",
        "X:TOMBALL EXPY & PARK CT",
        "MAP:288K",
        "CODE:29B01",
        "CALL:MVA - Injuries",
        "UNIT:E-1");

    doTest("T10",
        "* 2627 S CHERRY ST* 234* * * PINE MEADOWS ST* HOLDERRIETH RD* 288V* * 31D02* UNCONSCIOUS - W/effective breathing* * * E-1,M41,S-1,TOW-1* * * * *\r\n",
        "ADDR:2627 S CHERRY ST",
        "APT:234",
        "X:PINE MEADOWS ST & HOLDERRIETH RD",
        "MAP:288V",
        "CODE:31D02",
        "CALL:UNCONSCIOUS - W/effective breathing",
        "UNIT:E-1,M41,S-1,TOW-1");

    doTest("T11",
        "* 12919 SPRUCE CIR* * * * PINE WOODS ST* HEMLOCK ST* 288R* * 60B01O* GAS LEAK - Outside residential like or tank - ODOR* * * E-1,TOW-1* * * * *\r\n",
        "ADDR:12919 SPRUCE CIR",
        "X:PINE WOODS ST & HEMLOCK ST",
        "MAP:288R",
        "CODE:60B01O",
        "CALL:GAS LEAK - Outside residential like or tank - ODOR",
        "UNIT:E-1,TOW-1");

    doTest("T12",
        "* 30500 SH 249* * * * TOMBALL EXPY* TOMBALL PKWY* 288Z* * 68A01* SMOKE INVESTIGATION (OUTSIDE) - LIGHT smoke* * * E-1* * * * *\r\n",
        "ADDR:30500 SH 249",
        "MADDR:30500 TX 249",
        "X:TOMBALL EXPY & TOMBALL PKWY",
        "MAP:288Z",
        "CODE:68A01",
        "CALL:SMOKE INVESTIGATION (OUTSIDE) - LIGHT smoke",
        "UNIT:E-1");

    doTest("T13",
        "* 1055 BAKER DR* * * * LEE ANN* QUINN RD* 288C* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:1055 BAKER DR",
        "X:LEE ANN & QUINN RD",
        "MAP:288C",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T14",
        "* 30403 QUINN RD* * * * BAKER DR* ZION RD* 288C* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:30403 QUINN RD",
        "X:BAKER DR & ZION RD",
        "MAP:288C",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T15",
        "* 30500 TOMBALL PKWY* * * * HEIDI LN* ZION RD* 288B* * 29B01* MVA - Injuries* * * E-1* * * * *\r\n",
        "ADDR:30500 TOMBALL PKWY",
        "X:HEIDI LN & ZION RD",
        "MAP:288B",
        "CODE:29B01",
        "CALL:MVA - Injuries",
        "UNIT:E-1");

    doTest("T16",
        "* 101 S WALNUT ST* * * * W MAIN* MARKET ST* 288H* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:101 S WALNUT ST",
        "X:W MAIN & MARKET ST",
        "MAP:288H",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T17",
        "* 27721 TOMBALL PKWY* 100* * * ALICE RD* HIRSCHFIELD RD* 288Q* * 52C03* Alarm - COMMERCIAL STRUCTURE* * * TOW-1* * * * *\r\n",
        "ADDR:27721 TOMBALL PKWY",
        "APT:100",
        "X:ALICE RD & HIRSCHFIELD RD",
        "MAP:288Q",
        "CODE:52C03",
        "CALL:Alarm - COMMERCIAL STRUCTURE",
        "UNIT:TOW-1");

    doTest("T18",
        "* FM 2920 // PARK RD* * * * PARK RD* TOMBALL CEMETERY RD* 288J* * 67B01* SMALL OUTSIDE Fire* * * B-2,E-1* * * * *\r\n",
        "ADDR:FM 2920 & PARK RD",
        "X:PARK RD & TOMBALL CEMETERY RD",
        "MAP:288J",
        "CODE:67B01",
        "CALL:SMALL OUTSIDE Fire",
        "UNIT:B-2,E-1");

    doTest("T19",
        "* 30555 TOMBALL PKWY* * * * HEIDI LN* ZION RD* 288B* * 52C03P* ALARMS - COMMERCIAL STRUCTURE - Pull station* * * E-1,TOW-1* * * * *\r\n",
        "ADDR:30555 TOMBALL PKWY",
        "X:HEIDI LN & ZION RD",
        "MAP:288B",
        "CODE:52C03P",
        "CALL:ALARMS - COMMERCIAL STRUCTURE - Pull station",
        "UNIT:E-1,TOW-1");

    doTest("T20",
        "* 14333 FM 2920* 106* * * WOODFOREST DR* CALVERT RD* 288K* * 2 FIRE CALL* FIRE CALL* * * E-1* * * * *\r\n",
        "ADDR:14333 FM 2920",
        "APT:106",
        "X:WOODFOREST DR & CALVERT RD",
        "MAP:288K",
        "CODE:2 FIRE CALL",
        "CALL:FIRE CALL",
        "UNIT:E-1");

    doTest("T21",
        "* 1011 VILLAGE SQUARE DR* 615* * * HIGH ST* QUINN RD* 288G* * 23C01I* INTENTIONAL OVERDOSE - Not alert* * * 484,E-1,M-1* * * * *\r\n",
        "ADDR:1011 VILLAGE SQUARE DR",
        "APT:615",
        "X:HIGH ST & QUINN RD",
        "MAP:288G",
        "CODE:23C01I",
        "CALL:INTENTIONAL OVERDOSE - Not alert",
        "UNIT:484,E-1,M-1");

    doTest("T22",
        "* 27721 TOMBALL PKWY* 100* * * ALICE RD* HIRSCHFIELD RD* 288Q* * 52C03S* ALARMS - COMMERCIAL STRUCTURE - Smoke detector* * * E-1* * * * *\r\n",
        "ADDR:27721 TOMBALL PKWY",
        "APT:100",
        "X:ALICE RD & HIRSCHFIELD RD",
        "MAP:288Q",
        "CODE:52C03S",
        "CALL:ALARMS - COMMERCIAL STRUCTURE - Smoke detector",
        "UNIT:E-1");

    doTest("T23",
        "* 1100 GRAHAM DR* 1602* * * LAWRENCE ST* TOMBALL PKWY* 288L* * 17D02* FALL - Unconscious or arrest* * * E-1,M-1* * * * *\r\n",
        "ADDR:1100 GRAHAM DR",
        "APT:1602",
        "X:LAWRENCE ST & TOMBALL PKWY",
        "MAP:288L",
        "CODE:17D02",
        "CALL:FALL - Unconscious or arrest",
        "UNIT:E-1,M-1");

    doTest("T24",
        "* 27721 TOMBALL PKWY* 100* * * ALICE RD* HIRSCHFIELD RD* 288Q* * 52C03P* ALARMS - COMMERCIAL STRUCTURE - Pull station* * * E-1* * * * *\r\n",
        "ADDR:27721 TOMBALL PKWY",
        "APT:100",
        "X:ALICE RD & HIRSCHFIELD RD",
        "MAP:288Q",
        "CODE:52C03P",
        "CALL:ALARMS - COMMERCIAL STRUCTURE - Pull station",
        "UNIT:E-1");

    doTest("T25",
        "* 27650 TOMBALL PKWY* * * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-2,TOW-1* * * * *\r\n",
        "ADDR:27650 TOMBALL PKWY",
        "X:THEISS LN & HOLDERRIETH RD",
        "MAP:288Q",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:B-2,TOW-1");

    doTest("T26",
        "* 516 CLAYTON ST* * * * S PINE ST* S MAGNOLIA ST* 288H* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:516 CLAYTON ST",
        "X:S PINE ST & S MAGNOLIA ST",
        "MAP:288H",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T27",
        "* 18110 HILLOCK GLEN LN* * * * LOFTY EDGE ST* DEAD END* 327H* * 31D02* UNCONSCIOUS - W/effective breathing* * * M-2,S-1,TOW-1* * * * *\r\n",
        "ADDR:18110 HILLOCK GLEN LN",
        "X:LOFTY EDGE ST & DEAD END",
        "MAP:327H",
        "CODE:31D02",
        "CALL:UNCONSCIOUS - W/effective breathing",
        "UNIT:M-2,S-1,TOW-1");

    doTest("T28",
        "* 605 HOLDERRIETH BLVD* PARK E* * * GRAHAM DR* DEAD END* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:605 HOLDERRIETH BLVD",
        "APT:PARK E",
        "X:GRAHAM DR & DEAD END",
        "MAP:288L",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T29",
        "* 28155 TOMBALL PKWY* 2* * * MEDICAL COMPLEX DR* MICHEL RD* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:28155 TOMBALL PKWY",
        "APT:2",
        "X:MEDICAL COMPLEX DR & MICHEL RD",
        "MAP:288L",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T30",
        "* 702 S OAK* * * * WILLOWICK ST* BELMONT ST* 288M* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:702 S OAK",
        "X:WILLOWICK ST & BELMONT ST",
        "MAP:288M",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T31",
        "* 110 ELLA AVE* * * * W QUINN RD* ALMA ST* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:110 ELLA AVE",
        "X:W QUINN RD & ALMA ST",
        "MAP:288L",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T32",
        "* 915 BAKER DR* 3336* * * LEE ANN* QUINN RD* 288C* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-1,E-1* * * * *\r\n",
        "ADDR:915 BAKER DR",
        "APT:3336",
        "X:LEE ANN & QUINN RD",
        "MAP:288C",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:B-1,E-1");

    doTest("T33",
        "* FM 2920 // TELGE* * * * * * * * 67D03U* LARGE OUTSIDE fire - Unknown if threatening* * * B-1,E-1* * * * *\r\n",
        "ADDR:FM 2920 & TELGE",
        "CODE:67D03U",
        "CALL:LARGE OUTSIDE fire - Unknown if threatening",
        "UNIT:B-1,E-1");

    doTest("T34",
        "* 100 W MAIN* * * * S ELM ST* S WALNUT ST* 288H* * 29B01* MVA - Injuries* * * E-1* * * * *\r\n",
        "ADDR:100 W MAIN",
        "X:S ELM ST & S WALNUT ST",
        "MAP:288H",
        "CODE:29B01",
        "CALL:MVA - Injuries",
        "UNIT:E-1");

    doTest("T35",
        "* 13415 MEDICAL COMPLEX DR* * * * LAWRENCE ST* DEAD END* 288L* * 52C01G* ALARMS - High life hazard - GENERAL* * * E-1* * * * *\r\n",
        "ADDR:13415 MEDICAL COMPLEX DR",
        "X:LAWRENCE ST & DEAD END",
        "MAP:288L",
        "CODE:52C01G",
        "CALL:ALARMS - High life hazard - GENERAL",
        "UNIT:E-1");

    doTest("T36",
        "* 400 FANNIN ST* * * * S OAK* S PINE ST* 288H* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:400 FANNIN ST",
        "X:S OAK & S PINE ST",
        "MAP:288H",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T37",
        "* 1100 S CHERRY ST* * * * ANNA ST* JUSTIN CT* 288M* * 67B03* OUTSIDE FIRE - Unknown situation* * * TOW-1* * * * *\r\n",
        "ADDR:1100 S CHERRY ST",
        "X:ANNA ST & JUSTIN CT",
        "MAP:288M",
        "CODE:67B03",
        "CALL:OUTSIDE FIRE - Unknown situation",
        "UNIT:TOW-1");

    doTest("T38",
        "* 14083 FM 2920* * * * TOMBALL PKWY* TOMBALL EXPY* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:14083 FM 2920",
        "X:TOMBALL PKWY & TOMBALL EXPY",
        "MAP:288K",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T39",
        "* 27650 TOMBALL PKWY* * * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n",
        "ADDR:27650 TOMBALL PKWY",
        "X:THEISS LN & HOLDERRIETH RD",
        "MAP:288Q",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:TOW-1");

    doTest("T40",
        "* 27610 DANA DR* * * * DEAD END* ALICE RD* 288P* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,TOW-1* * * * *\r\n",
        "ADDR:27610 DANA DR",
        "X:DEAD END & ALICE RD",
        "MAP:288P",
        "CODE:67O01",
        "CALL:OUTSIDE FIRE - Controlled burn",
        "UNIT:B-2,TOW-1");

    doTest("T41",
        "* THIESS/ JOHNSON* * * * * * * * 59C04O* FUEL SPILL - Unknown - OUTSIDE* * * TOW-1* * * * *\r\n",
        "ADDR:THIESS & JOHNSON",
        "CODE:59C04O",
        "CALL:FUEL SPILL - Unknown - OUTSIDE",
        "UNIT:TOW-1");

    doTest("T42",
        "* 1322 DOVE TRAILS* * * * ARBOR PINE* DEAD END* 288C* * 52B01S* ALARMS - Residential Single - Smoke detector* * * TOW-1* * * * *\r\n",
        "ADDR:1322 DOVE TRAILS",
        "X:ARBOR PINE & DEAD END",
        "MAP:288C",
        "CODE:52B01S",
        "CALL:ALARMS - Residential Single - Smoke detector",
        "UNIT:TOW-1");

    doTest("T43",
        "* 14333 FM 2920* 106* * * WOODFOREST DR* CALVERT RD* 288K* * 52C03* Alarm - COMMERCIAL STRUCTURE* * * E-1* * * * *\r\n",
        "ADDR:14333 FM 2920",
        "APT:106",
        "X:WOODFOREST DR & CALVERT RD",
        "MAP:288K",
        "CODE:52C03",
        "CALL:Alarm - COMMERCIAL STRUCTURE",
        "UNIT:E-1");

    doTest("T44",
        "* 14711 OLIN RD* * * * CALVERT RD* DEAD END* 288N* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n",
        "ADDR:14711 OLIN RD",
        "X:CALVERT RD & DEAD END",
        "MAP:288N",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:TOW-1");

    doTest("T45",
        "* 1025 ALMA ST* B* * * LAWRENCE ST* RAYMOND AVE* 288L* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n",
        "ADDR:1025 ALMA ST",
        "APT:B",
        "X:LAWRENCE ST & RAYMOND AVE",
        "MAP:288L",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:TOW-1");

    doTest("T46",
        "* 13415 MEDICAL COMPLEX DR* * * * LAWRENCE ST* DEAD END* 288L* * 52C03S* ALARMS - COMMERCIAL STRUCTURE - Smoke detector* * * E-1* * * * *\r\n",
        "ADDR:13415 MEDICAL COMPLEX DR",
        "X:LAWRENCE ST & DEAD END",
        "MAP:288L",
        "CODE:52C03S",
        "CALL:ALARMS - COMMERCIAL STRUCTURE - Smoke detector",
        "UNIT:E-1");

    doTest("T47",
        "* 735 E MAIN* * * * N WILLOW ST* SNOOK LN* 289E* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1,TOW-1* * * * *\r\n",
        "ADDR:735 E MAIN",
        "X:N WILLOW ST & SNOOK LN",
        "MAP:289E",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1,TOW-1");

    doTest("T48",
        "* 30555 TOMBALL PKWY* SOUTH* * * HEIDI LN* ZION RD* 288B* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-1,E-1* * * * *\r\n",
        "ADDR:30555 TOMBALL PKWY",
        "APT:SOUTH",
        "X:HEIDI LN & ZION RD",
        "MAP:288B",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:B-1,E-1");

    doTest("T49",
        "* 14251 FM 2920* * * * TOMBALL EXPY* PARK CT* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * B-1,E-1* * * * *\r\n",
        "ADDR:14251 FM 2920",
        "X:TOMBALL EXPY & PARK CT",
        "MAP:288K",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:B-1,E-1");

    doTest("T50",
        "* 1110 INWOOD* * * * ROXANNE DR* QUINN RD* 288G* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:1110 INWOOD",
        "X:ROXANNE DR & QUINN RD",
        "MAP:288G",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T51",
        "* 24903 ELMIRA* * * * ROBERTA* HUFSMITH RD* 249X* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n",
        "ADDR:24903 ELMIRA",
        "X:ROBERTA & HUFSMITH RD",
        "MAP:249X",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:TOW-1");

    doTest("T52",
        "* FM 2920 // TOMBALL PKWY* * * * TOMBALL PKWY* TOMBALL EXPY* 288K* * 29B04* MVA - Unknown status* * * E-1* * * * *\r\n",
        "ADDR:FM 2920 & TOMBALL PKWY",
        "X:TOMBALL PKWY & TOMBALL EXPY",
        "MAP:288K",
        "CODE:29B04",
        "CALL:MVA - Unknown status",
        "UNIT:E-1");

    doTest("T53",
        "* 27830 CALVERT RD* * * * MARY JANE LN* MEDICAL COMPLEX DR* 288N* * 67O01* OUTSIDE FIRE - Controlled burn* * * TOW-1* * * * *\r\n",
        "ADDR:27830 CALVERT RD",
        "X:MARY JANE LN & MEDICAL COMPLEX DR",
        "MAP:288N",
        "CODE:67O01",
        "CALL:OUTSIDE FIRE - Controlled burn",
        "UNIT:TOW-1");

    doTest("T54",
        "* 506 GRAHAM* * * * * * * * Susp Per* Suspicious/Wanted Person - Suspicious person* * * 512,TOW-1* * * * *\r\n",
        "ADDR:506 GRAHAM",
        "CODE:Susp Per",
        "CALL:Suspicious/Wanted Person - Suspicious person",
        "UNIT:512,TOW-1");

    doTest("T55",
        "* 27620 TOMBALL PKWY* A-6* * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n",
        "ADDR:27620 TOMBALL PKWY",
        "APT:A-6",
        "X:THEISS LN & HOLDERRIETH RD",
        "MAP:288Q",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:TOW-1");

    doTest("T56",
        "* 400 FANNIN ST* * * * S OAK* S PINE ST* 288H* * 55B04* ELECTRICAL HAZARD - Electrical Odor* * * E-1* * * * *\r\n",
        "ADDR:400 FANNIN ST",
        "X:S OAK & S PINE ST",
        "MAP:288H",
        "CODE:55B04",
        "CALL:ELECTRICAL HAZARD - Electrical Odor",
        "UNIT:E-1");

    doTest("T57",
        "* FM 2920 // E HUFFSMITH KHROVILLE* * * * E HUFFSMITH KHROVILLE* STUEBNER ARLINE* 289E* * 69D03* STRUCTURE FIRE - COMMERCIAL STRUCTURE* * * 497,527,552,700,C-2,E-1,KE36,KL36,KTW31,M-2,ME182,ME184,MT184,RHE51,S-1,SR75,TOW-1* * * * *\r\n",
        "ADDR:FM 2920 & E HUFFSMITH KHROVILLE",
        "X:E HUFFSMITH KHROVILLE & STUEBNER ARLINE",
        "MAP:289E",
        "CODE:69D03",
        "CALL:STRUCTURE FIRE - COMMERCIAL STRUCTURE",
        "UNIT:497,527,552,700,C-2,E-1,KE36,KL36,KTW31,M-2,ME182,ME184,MT184,RHE51,S-1,SR75,TOW-1");

    doTest("T58",
        "* 29807 TOMBALL PKWY* 464* * * BROWN RD* BAKER DR* 288B* * 69D05* STRUCTURE FIRE - Residential MULTIPLE* * * 501,E-1,TOW-1* * * * *\r\n",
        "ADDR:29807 TOMBALL PKWY",
        "APT:464",
        "X:BROWN RD & BAKER DR",
        "MAP:288B",
        "CODE:69D05",
        "CALL:STRUCTURE FIRE - Residential MULTIPLE",
        "UNIT:501,E-1,TOW-1");

    doTest("T59",
        "* FM 2920 // TOMBALL EXPY* * * * TOMBALL EXPY* PARK CT* 288K* * 29D02* MVA - High mechanism* * * BAT-1,M-4,TOW-1* * * * *\r\n",
        "ADDR:FM 2920 & TOMBALL EXPY",
        "X:TOMBALL EXPY & PARK CT",
        "MAP:288K",
        "CODE:29D02",
        "CALL:MVA - High mechanism",
        "UNIT:BAT-1,M-4,TOW-1");

    doTest("T60",
        "* 27702 BRIAR MEADOW* * * * DEAD END* ALICE RD* 288P* * 57B03* EXPLOSION - Unknown situation (investigation)* * * E-1,KE36,KL36,M-2,RHE51,RHT51,SR75,TOW-1* * * * *\r\n",
        "ADDR:27702 BRIAR MEADOW",
        "X:DEAD END & ALICE RD",
        "MAP:288P",
        "CODE:57B03",
        "CALL:EXPLOSION - Unknown situation (investigation)",
        "UNIT:E-1,KE36,KL36,M-2,RHE51,RHT51,SR75,TOW-1");

    doTest("T61",
        "* 1915 SCOTCH PINE ST* * * * THEISS LN* PINE WOODS ST* 288Q* * 52B01O* ALARMS - Residential Single - OTHER* * * TOW-1* * * * *\r\n",
        "ADDR:1915 SCOTCH PINE ST",
        "X:THEISS LN & PINE WOODS ST",
        "MAP:288Q",
        "CODE:52B01O",
        "CALL:ALARMS - Residential Single - OTHER",
        "UNIT:TOW-1");

    doTest("T62",
        "* 14420 FM 2920* * * * PARK CT* PARK CT* 288K* * 52C03* Alarm - COMMERCIAL STRUCTURE* * * E-1* * * * *\r\n",
        "ADDR:14420 FM 2920",
        "X:PARK CT & PARK CT",
        "MAP:288K",
        "CODE:52C03",
        "CALL:Alarm - COMMERCIAL STRUCTURE",
        "UNIT:E-1");

    doTest("T63",
        "* HOLDERRIETH RD // HUFSMITH KOHRVILLE R* * * * HUFSMITH KOHRVILLE R* SARATOGA LN* 289T* * MVA* MAJOR ACCIDENT* * * E-1,M-1* * * * *\r\n",
        "ADDR:HOLDERRIETH RD & HUFSMITH KOHRVILLE R",
        "X:HUFSMITH KOHRVILLE R & SARATOGA LN",
        "MAP:289T",
        "CODE:MVA",
        "CALL:MAJOR ACCIDENT",
        "UNIT:E-1,M-1");

    doTest("T64",
        "* 18023 HILLOCK GLEN LN* * * * DEAD END* LOFTY EDGE ST* 327H* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,E-2,TOW-1* * * * *\r\n",
        "ADDR:18023 HILLOCK GLEN LN",
        "X:DEAD END & LOFTY EDGE ST",
        "MAP:327H",
        "CODE:67O01",
        "CALL:OUTSIDE FIRE - Controlled burn",
        "UNIT:B-2,E-2,TOW-1");

    doTest("T65",
        "* 250 SCHOOL ST* * * * GRAHAM DR* MICHEL RD* 288M* * 52C01P* ALARMS - HIGH LIFE HAZARD - Pull station* * * E-1* * * * *\r\n",
        "ADDR:250 SCHOOL ST",
        "X:GRAHAM DR & MICHEL RD",
        "MAP:288M",
        "CODE:52C01P",
        "CALL:ALARMS - HIGH LIFE HAZARD - Pull station",
        "UNIT:E-1");

    doTest("T66",
        "* 27650 TOMBALL PKWY* * * * THEISS LN* HOLDERRIETH RD* 288Q* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * TOW-1* * * * *\r\n",
        "ADDR:27650 TOMBALL PKWY",
        "X:THEISS LN & HOLDERRIETH RD",
        "MAP:288Q",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:TOW-1");

    doTest("T67",
        "* 700 E MAIN* BK* * * N WILLOW ST* SNOOK LN* 289E* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1,TOW-1* * * * *\r\n",
        "ADDR:700 E MAIN",
        "APT:BK",
        "X:N WILLOW ST & SNOOK LN",
        "MAP:289E",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1,TOW-1");

    doTest("T68",
        "* 14018 FM 2920* * * * TOMBALL PKWY* TOMBALL EXPY* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:14018 FM 2920",
        "X:TOMBALL PKWY & TOMBALL EXPY",
        "MAP:288K",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T69",
        "* 28520 TOMBALL PKWY* * * * GRAHAM DR* W MAIN* 288K* * 53O01* SERVICE CALL - Locked out of vehicle (unoccupied)* * * E-1* * * * *\r\n",
        "ADDR:28520 TOMBALL PKWY",
        "X:GRAHAM DR & W MAIN",
        "MAP:288K",
        "CODE:53O01",
        "CALL:SERVICE CALL - Locked out of vehicle (unoccupied)",
        "UNIT:E-1");

    doTest("T70",
        "* 25404 DECKER PRAIRIE ROSEHILL RD* * * * * * 287AMCF* * 65B01* MUTUAL AID - Emergency to incident (single unit)* * * B-1* * * * *\r\n",
        "ADDR:25404 DECKER PRAIRIE ROSEHILL RD",
        "MAP:287AMCF",
        "CODE:65B01",
        "CALL:MUTUAL AID - Emergency to incident (single unit)",
        "UNIT:B-1");

    doTest("T71",
        "* 14110 ALICE RD* * * * BRIAR MEADOW* GREEN MEADOW RD* 288P* * 67O01* OUTSIDE FIRE - Controlled burn* * * B-2,E-1* * * * *\r\n",
        "ADDR:14110 ALICE RD",
        "X:BRIAR MEADOW & GREEN MEADOW RD",
        "MAP:288P",
        "CODE:67O01",
        "CALL:OUTSIDE FIRE - Controlled burn",
        "UNIT:B-2,E-1");

  }
  
  @Test
  public void testTomballPolice() {

    doTest("T1",
        "201239629* 27844 TOMBALL PKWY* * * TOMBALL* * * * * Alarm Burg* Alarms - Burglary/Intrusion* 671, CENTRAL SECURITY* 888-642-4567* 121,141,442* * Medical: No* Hazards: No* 12/28/2012 07:46:15 : pos5 : scundiff 442 ADV THERE ARE PEOPLE ON LOCATION 12/28/2012 07:44:45 : pos5 : scundiff ** EPD Case Complete ** 12/28/2012 07:44:30 : pos5 : scundiff ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: SUPERIOR CAR WASH * 5.The activation area is: SHOP BACK DOOR * 6.The phone number of the business/resident/owner is: 281-516-3434 * 7.A keyholder/owner will be contacted. 12/28/2012 07:43:41 : pos5 : scundiff ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/28/2012 07:43:29 : pos5 : scundiff ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Quest",
        "ID:201239629",
        "ADDR:27844 TOMBALL PKWY",
        "INFO:Medical: No / Hazards: No\n442 ADV THERE ARE PEOPLE ON LOCATION\n** EPD Case Complete **\n** EPD Key Questions Finished **\n4.The name of the business/resident/owner is: SUPERIOR CAR WASH\n5.The activation area is: SHOP BACK DOOR\n6.The phone number of the business/resident/owner is: 281-516-3434\n** EPD Recommended Dispatch ** / Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg\n1.The caller is not on scene.\n2.This call is from an alarm monitoring company.\n** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Quest",
        "CITY:TOMBALL",
        "CODE:Alarm Burg",
        "CALL:Alarms - Burglary/Intrusion",
        "NAME:671, CENTRAL SECURITY",
        "PHONE:888-642-4567",
        "UNIT:121,141,442",
        "DATE:12/28/2012",
        "TIME:07:43:29",
        "CH:pos5");

    doTest("T2",
        "201239615* 29807 TOMBALL PKWY* * * TOMBALL* BROWN RD* BAKER DR* 288B* Landmark Comment: NO KNOX BOX AT THIS LOCATION* Dis Ver Sm* Disturbance/Nuisance - Verbal (Individual or small group)* DAY, MARK* 832-229-8503* 365,517,552* 7101* Medical: No* Hazards: No* 12/28/2012 02:12:38 : pos10 : PTOMPKINS REP AD THAT IT SOUNDED LIKE A MALE AND FEMALE YELLING AT EACH OTHER AND SLAMMING DOORS 12/28/2012 02:09:40 : pos10 : PTOMPKINS ** EPD Case Complete ** 12/28/2012 02:09:37 : pos10 : PTOMPKINS ** EPD Key Questions Finished ** Key Questions: * 5.Weapons were not involved or mentioned. * 8.The suspect/person responsible is on scene. * 9.The suspect's description is not known. * 10.It is not known if the suspect arrived in a vehicle. * 11.No one is reported to be in danger. * 12.It is not known if alcohol or drugs are involved. * 13.It is not known if there is a court order/restraining order in place. * 14.It is not known if anyone is injured or sick. 12/28/2012 02:08:54 : pos10 : PTOMPKINS ** EP",
        "ID:201239615",
        "ADDR:29807 TOMBALL PKWY",
        "INFO:NO KNOX BOX AT THIS LOCATION / 7101 / Medical: No / Hazards: No\nREP AD THAT IT SOUNDED LIKE A MALE AND FEMALE YELLING AT EACH OTHER AND SLAMMING DOORS\n** EPD Case Complete **\n** EPD Key Questions Finished **\n5.Weapons were not involved or mentioned.\n8.The suspect/person responsible is on scene.\n9.The suspect's description is not known.\n10.It is not known if the suspect arrived in a vehicle.\n11.No one is reported to be in danger.\n12.It is not known if alcohol or drugs are involved.\n13.It is not known if there is a court order/restraining order in place.",
        "CITY:TOMBALL",
        "X:BROWN RD & BAKER DR",
        "MAP:288B",
        "CODE:Dis Ver Sm",
        "CALL:Disturbance/Nuisance - Verbal (Individual or small group)",
        "NAME:DAY, MARK",
        "PHONE:832-229-8503",
        "UNIT:365,517,552",
        "DATE:12/28/2012",
        "TIME:02:08:54",
        "CH:pos10");

    doTest("T3",
        "201239559* 28437 TOMBALL PKWY* * * TOMBALL* GRAHAM DR* W MAIN* 288K* Landmark Comment: KNOX BOX - OTHER OFFICE IN CENTER* 4B03S* * IREANE* 832-515-4007* 141,295,72,M4,S1* 7102* Medical: No* Hazards: No* 12/27/2012 13:20:27 : pos32 : CKNOWERS FEMALE CAME INTO CLINIC SAYING SHE HAD BEEN SEXUALLY ASSULTED 12/27/2012 13:18:57 : pos32 : CKNOWERS PD CHECKING BY 12/27/2012 13:18:43 : pos32 : CKNOWERS ** EMD Case Complete ** 12/27/2012 13:18:41 : pos32 : CKNOWERS ** EMD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 04B03 Suffix: S CAD Incident Code: 4B03S Key Questions: * 1.The patient was sexually assaulted. * 2.It's not known when this happened. * 3.The assailant is gone, location unknown. * 4.The assailant is not armed. * 5.It's not known if there is SERIOUS bleeding. * 6.She is completely alert (responding appropriately). * 7.It's not known if she has other injuries. 12/27/2012 13:18:02 : pos32 : CKNOWERS ** EMD Case Entry Finished ** Chief Complaint Number: 4 Key Questions",
        "ID:201239559",
        "ADDR:28437 TOMBALL PKWY",
        "INFO:KNOX BOX - OTHER OFFICE IN CENTER / 7102 / Medical: No / Hazards: No\nFEMALE CAME INTO CLINIC SAYING SHE HAD BEEN SEXUALLY ASSULTED\nPD CHECKING BY\nBravo Dispatch Level: 04B03 Suffix: S CAD Incident Code: 4B03S\n1.The patient was sexually assaulted.\n2.It's not known when this happened.\n3.The assailant is gone, location unknown.\n4.The assailant is not armed.\n5.It's not known if there is SERIOUS bleeding.\n6.She is completely alert (responding appropriately).\nChief Complaint Number: 4 Key Questions",
        "CITY:TOMBALL",
        "X:GRAHAM DR & W MAIN",
        "MAP:288K",
        "CODE:4B03S",
        "NAME:IREANE",
        "PHONE:832-515-4007",
        "UNIT:141,295,72,M4,S1",
        "DATE:12/27/2012",
        "TIME:13:18:02",
        "CH:pos32");

    doTest("T4",
        "201239554* 724 BARBARA ST* * * TOMBALL* JAMES ST* VERNON AVE* 288L* * Susp Per* Suspicious/Wanted Person - Suspicious person* BLAIR,NITA* 281-687-5794* 141,72* 7102* Medical: No* Hazards: No* 12/27/2012 11:34:21 : pos10 : mrosenberg ** EPD Case Complete ** 12/27/2012 11:34:19 : pos10 : mrosenberg ** EPD Key Questions Finished ** Key Questions: * 10.The location of the suspect/person responsible is not known. * 11.The suspect's description is: * 12.It is not known if the suspect arrived in a vehicle. * 13.No one is reported to be in danger. 12/27/2012 11:34:14 : pos10 : mrosenberg ** EPD Additional Info ** PERSON 1 Info: type Suspect race WHITE gender MALE clothing WHITE HOOD 12/27/2012 11:33:48 : pos10 : mrosenberg ** EPD Recommended Dispatch ** Response Text: Charlie Dispatch Level: 129C01 CAD Incident Code: Susp Per Key Questions: * 1.The caller is on scene. * 2.This is a 2nd party caller. * 3.This incident is in progress. * 4.The caller is on scene. * 5.This is a 2nd party caller. ",
        "ID:201239554",
        "ADDR:724 BARBARA ST",
        "INFO:7102 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Key Questions Finished **\n10.The location of the suspect/person responsible is not known.\n11.The suspect's description is:\n12.It is not known if the suspect arrived in a vehicle.\n** EPD Additional Info ** PERSON 1 Info: type Suspect race WHITE gender MALE clothing WHITE HOOD\n** EPD Recommended Dispatch ** / Charlie Dispatch Level: 129C01 CAD Incident Code: Susp Per\n1.The caller is on scene.\n2.This is a 2nd party caller.\n3.This incident is in progress.\n4.The caller is on scene.\n5.This is a 2nd party caller.",
        "CITY:TOMBALL",
        "X:JAMES ST & VERNON AVE",
        "MAP:288L",
        "CODE:Susp Per",
        "CALL:Suspicious/Wanted Person - Suspicious person",
        "NAME:BLAIR,NITA",
        "PHONE:281-687-5794",
        "UNIT:141,72",
        "DATE:12/27/2012",
        "TIME:11:34:14",
        "CH:pos10");

    doTest("T5",
        "201239539* 14424 FM 2920* * * TOMBALL* PARK CT* PARK CT* 288K* * Alarm Burg* Alarms - Burglary/Intrusion* opr MILSA* 877-238-7739* 295,442* 7101* Medical: No* Hazards: No* 12/27/2012 07:06:37 : pos10 : mrosenberg ** EPD Case Complete ** 12/27/2012 07:06:35 : pos10 : mrosenberg ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: OFFICE DEPOT SUPPLY STORE * 5.The activation area is: POE INT MOT * 6.The phone number of the business/resident/owner is: 2812555568 * 7.A keyholder/owner will be contacted. 12/27/2012 07:05:59 : pos10 : mrosenberg ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/27/2012 07:05:41 : pos10 : mrosenberg ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller Statement: ALARM. 12/27/2012 07:05:32 : pos10 ",
        "ID:201239539",
        "ADDR:14424 FM 2920",
        "INFO:7101 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Key Questions Finished **\n4.The name of the business/resident/owner is: OFFICE DEPOT SUPPLY STORE\n5.The activation area is: POE INT MOT\n6.The phone number of the business/resident/owner is: 2812555568\n** EPD Recommended Dispatch ** / Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg\n1.The caller is not on scene.\n2.This call is from an alarm monitoring company.\n** EPD Case Entry Finished ** Chief Complaint Number: 104 / Caller Statement: ALARM. 12/27/2012 07:05:32 : pos10",
        "CITY:TOMBALL",
        "X:PARK CT & PARK CT",
        "MAP:288K",
        "CODE:Alarm Burg",
        "CALL:Alarms - Burglary/Intrusion",
        "NAME:opr MILSA",
        "PHONE:877-238-7739",
        "UNIT:295,442",
        "DATE:12/27/2012",
        "TIME:07:05:41",
        "CH:pos10");

    doTest("T6",
        "201239469* 1415 ASHLEY CT* * * TOMBALL* AGG RD* DEAD END* 288M* NBH: CHERRY Meadows* Susp Cir* Suspicious/Wanted Person - Suspicious circumstances* MCSWAIN, JEAN* 281-351-1321* 216,395* 7201* Medical: No* Hazards: No* 12/26/2012 12:49:50 : pos10 : eoualline ** EPD Case Complete ** 12/26/2012 12:49:36 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 7.The location of the suspect/person responsible is not known. * 8.The suspect's description is not known. * 9.It is not known if the suspect arrived in a vehicle. * 10.No one is reported to be in danger. 12/26/2012 12:49:10 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Charlie Dispatch Level: 129C05 CAD Incident Code: Susp Cir Key Questions: * 1.The caller is on scene. * 2.This is a 3rd party caller. * 3.This incident is in progress. * 4.This incident involves SUSPICIOUS circumstances. * 5.Weapons were not involved or mentioned. * 6.The circumstances are suspicious because: OPEN FRONT DOOR ON EMPTY ",
        "ID:201239469",
        "ADDR:1415 ASHLEY CT",
        "INFO:7201 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Key Questions Finished **\n7.The location of the suspect/person responsible is not known.\n8.The suspect's description is not known.\n9.It is not known if the suspect arrived in a vehicle.\n** EPD Recommended Dispatch ** / Charlie Dispatch Level: 129C05 CAD Incident Code: Susp Cir\n1.The caller is on scene.\n2.This is a 3rd party caller.\n3.This incident is in progress.\n4.This incident involves SUSPICIOUS circumstances.\n5.Weapons were not involved or mentioned.\n6.The circumstances are suspicious because: OPEN FRONT DOOR ON EMPTY",
        "CITY:TOMBALL",
        "X:AGG RD & DEAD END",
        "MAP:288M",
        "PLACE:CHERRY Meadows",
        "CODE:Susp Cir",
        "CALL:Suspicious/Wanted Person - Suspicious circumstances",
        "NAME:MCSWAIN, JEAN",
        "PHONE:281-351-1321",
        "UNIT:216,395",
        "DATE:12/26/2012",
        "TIME:12:49:10",
        "CH:pos10");

    doTest("T7",
        "201239470* 14060 FM 2920* * * TOMBALL* TOMBALL PKWY* TOMBALL EXPY* 288K* Landmark Comment: KNOX BOX ON LOCATION* FOLL* FOLLOW UP* * 281-516-2184* 295* 7101* Medical: No* Hazards: No* 12/26/2012 12:57:24 : pos10 : eoualline Landmark Comment: KNOX BOX ON LOCATION Landmark: KROGER FOOD STORE-TOMBALL*",
        "ID:201239470",
        "ADDR:14060 FM 2920",
        "INFO:KNOX BOX ON LOCATION / 7101 / Medical: No / Hazards: No",
        "CITY:TOMBALL",
        "X:TOMBALL PKWY & TOMBALL EXPY",
        "MAP:288K",
        "PLACE:KROGER FOOD STORE-TOMBALL",
        "CODE:FOLL",
        "CALL:FOLLOW UP",
        "PHONE:281-516-2184",
        "UNIT:295",
        "DATE:12/26/2012",
        "TIME:12:57:24",
        "CH:pos10");

    doTest("T8",
        "201239466* 29926 TOMBALL PKWY* * * TOMBALL* BROWN RD* BAKER DR* 288B* * Theft* Theft (Larceny) - Theft (larceny)* HEIM, JARED* 281-351-1474* 395* 7101* Medical: No* Hazards: No* 12/26/2012 11:15:48 : pos10 : eoualline Landmark: VALERO FUEL STATION AND CORNER STORE Cross streets: BROWN RD//BAKER DR WALLET STOLEN AT VALERO*",
        "ID:201239466",
        "ADDR:29926 TOMBALL PKWY",
        "INFO:7101 / Medical: No / Hazards: No\nWALLET STOLEN AT VALERO",
        "CITY:TOMBALL",
        "X:BROWN RD & BAKER DR",
        "MAP:288B",
        "PLACE:VALERO FUEL STATION AND CORNER STORE",
        "CODE:Theft",
        "CALL:Theft (Larceny) - Theft (larceny)",
        "NAME:HEIM, JARED",
        "PHONE:281-351-1474",
        "UNIT:395",
        "DATE:12/26/2012",
        "TIME:11:15:48",
        "CH:pos10");

    doTest("T9",
        "201239462* 1303 E HUFSMITH RD* * * TOMBALL* SNOOK LN* ZION RD* 249W* Landmark Comment: 281-378-5989/fax NBH: HUFSMITH* Alarm Burg* Alarms - Burglary/Intrusion* SECURE TECH* 888-943-1205* 295* 7201* Medical: No* Hazards: No* 12/26/2012 10:37:21 : pos10 : eoualline ** EPD Case Complete ** 12/26/2012 10:37:11 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: ROBERET SMITH * 5.The activation area is: GENERAL * 6.The phone number of the business/resident/owner is: NO PREMISE PHONE NUMBER * 7.A keyholder/owner will be contacted. 12/26/2012 10:36:33 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/26/2012 10:36:23 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller S",
        "ID:201239462",
        "ADDR:1303 E HUFSMITH RD",
        "INFO:281-378-5989/fax NBH: HUFSMITH / 7201 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Key Questions Finished **\n4.The name of the business/resident/owner is: ROBERET SMITH\n5.The activation area is: GENERAL\n6.The phone number of the business/resident/owner is: NO PREMISE PHONE NUMBER\n** EPD Recommended Dispatch ** / Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg\n1.The caller is not on scene.\n2.This call is from an alarm monitoring company.\n** EPD Case Entry Finished ** Chief Complaint Number: 104 / Caller S",
        "CITY:TOMBALL",
        "X:SNOOK LN & ZION RD",
        "MAP:249W",
        "CODE:Alarm Burg",
        "CALL:Alarms - Burglary/Intrusion",
        "NAME:SECURE TECH",
        "PHONE:888-943-1205",
        "UNIT:295",
        "DATE:12/26/2012",
        "TIME:10:36:23",
        "CH:pos10");

    doTest("T10",
        "201239461* 27407 TOMBALL PKWY* * * TOMBALL* THEISS LN* HOLDERRIETH RD* 288Q* Landmark Comment: NO KNOX BOX AT THIS LOCATION* Burg Pst* Burglary/Home invasion - Past burglary (break and enter)* LAURA* 281-255-9800* 216,395* 7201* Medical: No* Hazards: No* 12/26/2012 10:24:54 : pos10 : eoualline ** EPD Case Complete ** 12/26/2012 10:24:43 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 110B02 CAD Incident Code: Burg Pst Key Questions: * 1.The caller is on scene. * 2.This is a 3rd party caller. * 3.It is not known when this incident happened. * 4.The suspect/person/vehicle is not in the area. * 5.This incident involves a BURGLARY. * 6.It is not known what was taken. 12/26/2012 10:23:32 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 110 Key Questions: Caller Statement: STORAGE UNIT BURGLARIZED. 12/26/2012 10:23:07 : pos10 : eoualline Cross streets: THEISS LN//HOLDERRIETH RD Landmark: EXCEL STORAGE Landmark Comment: NO KNOX",
        "ID:201239461",
        "ADDR:27407 TOMBALL PKWY",
        "INFO:NO KNOX BOX AT THIS LOCATION / 7201 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Recommended Dispatch ** / Bravo Dispatch Level: 110B02 CAD Incident Code: Burg Pst\n1.The caller is on scene.\n2.This is a 3rd party caller.\n3.It is not known when this incident happened.\n4.The suspect/person/vehicle is not in the area.\n5.This incident involves a BURGLARY.\n** EPD Case Entry Finished ** Chief Complaint Number: 110 / Caller Statement: STORAGE UNIT BURGLARIZED.",
        "CITY:TOMBALL",
        "X:THEISS LN & HOLDERRIETH RD",
        "MAP:288Q",
        "PLACE:EXCEL STORAGE",
        "CODE:Burg Pst",
        "CALL:Burglary/Home invasion - Past burglary (break and enter)",
        "NAME:LAURA",
        "PHONE:281-255-9800",
        "UNIT:216,395",
        "DATE:12/26/2012",
        "TIME:10:23:32",
        "CH:pos10");

    doTest("T11",
        "201239456* 501 CLAYTON ST* * * TOMBALL* S PINE ST* S MAGNOLIA ST* 288H* * WELFARE CK* WELFARE CHECK* MCINVERY, STEVEN* * 216,295,600* 7102* Medical: No* Hazards: No* 12/26/2012 08:56:31 : pos10 : eoualline Cross streets: S PINE ST//S MAGNOLIA ST*",
        "ID:201239456",
        "ADDR:501 CLAYTON ST",
        "INFO:7102 / Medical: No / Hazards: No",
        "CITY:TOMBALL",
        "X:S PINE ST & S MAGNOLIA ST",
        "MAP:288H",
        "CODE:WELFARE CK",
        "CALL:WELFARE CHECK",
        "NAME:MCINVERY, STEVEN",
        "UNIT:216,295,600",
        "DATE:12/26/2012",
        "TIME:08:56:31",
        "CH:pos10");

    doTest("T12",
        "201239454* 14000 FM 2920* * * TOMBALL* * * * * TRAFFIC STOP* TRAFFIC STOP* * 281-723-0629* 395* * Medical: No* Hazards: No* 12/26/2012 08:15:20 : pos10 : eoualline *",
        "ID:201239454",
        "ADDR:14000 FM 2920",
        "INFO:Medical: No / Hazards: No",
        "CITY:TOMBALL",
        "CODE:TRAFFIC STOP",
        "CALL:TRAFFIC STOP",
        "PHONE:281-723-0629",
        "UNIT:395",
        "DATE:12/26/2012",
        "TIME:08:15:20",
        "CH:pos10");

    doTest("T13",
        "201239453* 1475 E MAIN* * * TOMBALL* S PERSIMMON RD* FM 2920* 289E* Landmark Comment: NO KNOX BOX* TRAFFIC STOP* TRAFFIC STOP* * 281-516-2249* 72* 7201* Medical: No* Hazards: No* 12/26/2012 08:04:15 : pos10 : eoualline Landmark Comment: NO KNOX BOX Landmark: STRIPES L.L.C*",
        "ID:201239453",
        "ADDR:1475 E MAIN",
        "INFO:NO KNOX BOX / 7201 / Medical: No / Hazards: No",
        "CITY:TOMBALL",
        "X:S PERSIMMON RD & FM 2920",
        "MAP:289E",
        "PLACE:STRIPES L.L.C",
        "CODE:TRAFFIC STOP",
        "CALL:TRAFFIC STOP",
        "PHONE:281-516-2249",
        "UNIT:72",
        "DATE:12/26/2012",
        "TIME:08:04:15",
        "CH:pos10");

    doTest("T14",
        "201239452* 800 E MAIN* * * TOMBALL* * * * * TRAFFIC STOP* TRAFFIC STOP* * * 72* * Medical: No* Hazards: No* 12/26/2012 07:45:22 : pos10 : eoualline *",
        "ID:201239452",
        "ADDR:800 E MAIN",
        "INFO:Medical: No / Hazards: No",
        "CITY:TOMBALL",
        "CODE:TRAFFIC STOP",
        "CALL:TRAFFIC STOP",
        "UNIT:72",
        "DATE:12/26/2012",
        "TIME:07:45:22",
        "CH:pos10");

    doTest("T15",
        "201239381* MICHEL RD // TOMBALL PKWY* * * TOMBALL* LAWRENCE ST* TOMBALL PKWY* 288L* Landmark Comment: KNOX BOX LOCATED NEAR FRONT ENTRY DOOR* Dist Intox* Disturbance/Nuisance - Intoxicated/Chemically Impaired* ERIC* 281-995-6620* 216,395,536,72* 7102* Medical: No* Hazards: No* 12/25/2012 11:11:07 : pos10 : eoualline WILL BE OUT ON MICHAEL CLARK 12/25/2012 11:06:44 : pos10 : eoualline 13798 MICHEL RD 12/25/2012 11:04:13 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 11:04:10 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 7.The suspect/person responsible is on scene. * 8.The suspect's description is: * 9.The suspect did not arrive in a vehicle. * 10.No one is reported to be in danger. * 11.There is not a court order/restraining order in place. * 12.No one is reportedly injured or sick. 12/25/2012 11:03:48 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 113B05 CAD Incident Code: Dist Intox Key Questions: * 1.The calle",
        "ID:201239381",
        "ADDR:MICHEL RD & TOMBALL PKWY",
        "INFO:KNOX BOX LOCATED NEAR FRONT ENTRY DOOR / 7102 / Medical: No / Hazards: No\nWILL BE OUT ON MICHAEL CLARK\n13798 MICHEL RD\n** EPD Case Complete **\n** EPD Key Questions Finished **\n7.The suspect/person responsible is on scene.\n8.The suspect's description is:\n9.The suspect did not arrive in a vehicle.\n10.No one is reported to be in danger.\n11.There is not a court order/restraining order in place.\n** EPD Recommended Dispatch ** / Bravo Dispatch Level: 113B05 CAD Incident Code: Dist Intox\n1.The calle",
        "CITY:TOMBALL",
        "X:LAWRENCE ST & TOMBALL PKWY",
        "MAP:288L",
        "CODE:Dist Intox",
        "CALL:Disturbance/Nuisance - Intoxicated/Chemically Impaired",
        "NAME:ERIC",
        "PHONE:281-995-6620",
        "UNIT:216,395,536,72",
        "DATE:12/25/2012",
        "TIME:11:03:48",
        "CH:pos10");

    doTest("T16",
        "201239379* 13515 SPRING CT* * * TOMBALL* SPRING FOREST WAY* DEAD END* 288C* NBH: Spring Forest Estates* Alarm Burg* Alarms - Burglary/Intrusion* SMITH THOMPSON* 972-526-8500* 395,72* 7102* Medical: No* Hazards: No* 12/25/2012 10:55:46 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 10:55:41 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: JOHN WIDMER RESIDENCE * 5.The activation area is: GENERAL * 6.The phone number of the business/resident/owner is: 281 351 9357 * 7.A keyholder/owner will be contacted. 12/25/2012 10:54:48 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/25/2012 10:54:38 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller Statement: AL",
        "ID:201239379",
        "ADDR:13515 SPRING CT",
        "INFO:7102 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Key Questions Finished **\n4.The name of the business/resident/owner is: JOHN WIDMER RESIDENCE\n5.The activation area is: GENERAL\n6.The phone number of the business/resident/owner is: 281 351 9357\n** EPD Recommended Dispatch ** / Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg\n1.The caller is not on scene.\n2.This call is from an alarm monitoring company.\n** EPD Case Entry Finished ** Chief Complaint Number: 104 / Caller Statement: AL",
        "CITY:TOMBALL",
        "X:SPRING FOREST WAY & DEAD END",
        "MAP:288C",
        "PLACE:Spring Forest Estates",
        "CODE:Alarm Burg",
        "CALL:Alarms - Burglary/Intrusion",
        "NAME:SMITH THOMPSON",
        "PHONE:972-526-8500",
        "UNIT:395,72",
        "DATE:12/25/2012",
        "TIME:10:54:38",
        "CH:pos10");

    doTest("T17",
        "201239377* 14320 FM 2920* A* * TOMBALL* PARK CT* PARK CT* 288K* Landmark Comment: KNOX BOX ON LOCATION* Alarm Burg* Alarms - Burglary/Intrusion* STANLEY SECUIRTY* 800-689-4984* 216,395* 7101* Medical: No* Hazards: No* 12/25/2012 10:31:57 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 10:31:49 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: LESLIE POOL SUPPLY * 5.The activation area is: FRONT MOTION * 6.The phone number of the business/resident/owner is: 281 516 3833 * 7.A keyholder/owner will be contacted. 12/25/2012 10:30:47 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/25/2012 10:30:30 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint Number: 104 Key Questions: Caller Statemen",
        "ID:201239377",
        "ADDR:14320 FM 2920",
        "APT:A",
        "INFO:KNOX BOX ON LOCATION / 7101 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Key Questions Finished **\n4.The name of the business/resident/owner is: LESLIE POOL SUPPLY\n5.The activation area is: FRONT MOTION\n6.The phone number of the business/resident/owner is: 281 516 3833\n** EPD Recommended Dispatch ** / Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg\n1.The caller is not on scene.\n2.This call is from an alarm monitoring company.\n** EPD Case Entry Finished ** Chief Complaint Number: 104 / Caller Statemen",
        "CITY:TOMBALL",
        "X:PARK CT & PARK CT",
        "MAP:288K",
        "CODE:Alarm Burg",
        "CALL:Alarms - Burglary/Intrusion",
        "NAME:STANLEY SECUIRTY",
        "PHONE:800-689-4984",
        "UNIT:216,395",
        "DATE:12/25/2012",
        "TIME:10:30:30",
        "CH:pos10");

    doTest("T18",
        "201239375* 22311 HUFSMITH KOHRVILLE RD* * * HARRIS CO* COUNTRY CLUB GREEN* WILLOW CREEK ESTATES* 289J* Landmark Comment: KNOX BOX LOCATED AT FRONT GATE* Alarm Burg* Alarms - Burglary/Intrusion* SEMBARA* 281-220-4076* 395,536* 7201* Medical: No* Hazards: No* 12/25/2012 10:01:38 : pos10 : eoualline ** EPD Case Complete ** 12/25/2012 10:01:30 : pos10 : eoualline ** EPD Key Questions Finished ** Key Questions: * 4.The name of the business/resident/owner is: SALCO * 5.The activation area is: NW WAREHOUSE OVERHEAD DOORS * 6.The phone number of the business/resident/owner is: 281 351 0274 * 7.A keyholder/owner will be contacted. 12/25/2012 10:00:29 : pos10 : eoualline ** EPD Recommended Dispatch ** Response Text: Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg Key Questions: * 1.The caller is not on scene. * 2.This call is from an alarm monitoring company. * 3.This is a burglary/intrusion alarm. 12/25/2012 10:00:16 : pos10 : eoualline ** EPD Case Entry Finished ** Chief Complaint ",
        "ID:201239375",
        "ADDR:22311 HUFSMITH KOHRVILLE RD",
        "INFO:KNOX BOX LOCATED AT FRONT GATE / 7201 / Medical: No / Hazards: No\n** EPD Case Complete **\n** EPD Key Questions Finished **\n4.The name of the business/resident/owner is: SALCO\n5.The activation area is: NW WAREHOUSE OVERHEAD DOORS\n6.The phone number of the business/resident/owner is: 281 351 0274\n** EPD Recommended Dispatch ** / Delta Dispatch Level: 104D01 CAD Incident Code: Alarm Burg\n1.The caller is not on scene.\n2.This call is from an alarm monitoring company.\n** EPD Case Entry Finished ** Chief Complaint",
        "X:COUNTRY CLUB GREEN & WILLOW CREEK ESTATES",
        "MAP:289J",
        "CODE:Alarm Burg",
        "CALL:Alarms - Burglary/Intrusion",
        "NAME:SEMBARA",
        "PHONE:281-220-4076",
        "UNIT:395,536",
        "DATE:12/25/2012",
        "TIME:10:00:16",
        "CH:pos10");

    doTest("T19",
        "201239297* 400 FANNIN ST* * * TOMBALL* S OAK* S PINE ST* 288H* * JAIL DUTY* JAIL DUTY* WALKER, JUDGE* 281-351-5451* 216,72* 7102* Medical: No* Hazards: No* 12/24/2012 11:46:50 : pos10 : eoualline Landmark: TOMBALL CITY JAIL Cross streets: S OAK//S PINE ST*",
        "ID:201239297",
        "ADDR:400 FANNIN ST",
        "INFO:7102 / Medical: No / Hazards: No",
        "CITY:TOMBALL",
        "X:S OAK & S PINE ST",
        "MAP:288H",
        "PLACE:TOMBALL CITY JAIL",
        "CODE:JAIL DUTY",
        "CALL:JAIL DUTY",
        "NAME:WALKER, JUDGE",
        "PHONE:281-351-5451",
        "UNIT:216,72",
        "DATE:12/24/2012",
        "TIME:11:46:50",
        "CH:pos10");

    doTest("T20",
        "201239288* 28048 TOMBALL PKWY* F* * TOMBALL* ALICE RD* HIRSCHFIELD RD* 288Q* Landmark Comment: NO KNOX BOX* DISTURBANCE* DISTURBANCE* * 281-351-2274* 216,395,536,72* 7201* Medical: No* Hazards: No* 12/24/2012 10:17:14 : pos10 : eoualline Cross streets: ALICE RD//HIRSCHFIELD RD Landmark: CASH AMERICA PAWN Landmark Comment: NO KNOX BOX*",
        "ID:201239288",
        "ADDR:28048 TOMBALL PKWY",
        "APT:F",
        "INFO:NO KNOX BOX / 7201 / Medical: No / Hazards: No",
        "CITY:TOMBALL",
        "X:ALICE RD & HIRSCHFIELD RD",
        "MAP:288Q",
        "PLACE:CASH AMERICA PAWN",
        "CODE:DISTURBANCE",
        "CALL:DISTURBANCE",
        "PHONE:281-351-2274",
        "UNIT:216,395,536,72",
        "DATE:12/24/2012",
        "TIME:10:17:14",
        "CH:pos10");

    doTest("T21",
        "201239987* 6004 BREEN DR* * * * ZUINN ST* ANTOINE DR* 411G* Geo Comment: HCEC NBH: RECREATION ACRES* 67O01* OUTSIDE FIRE - Controlled burn* * * DE-41* 4812* * * 12/31/2012 11:49:28 : pos32 : CKNOWERS ** EFD Case Complete ** 12/31/2012 11:49:26 : pos32 : CKNOWERS ** EFD Recommended Dispatch ** Response Text: Omega Dispatch Level: 67O01 CAD Incident Code: 67O01 Key Questions: * 1.The caller is on scene (1st party). * 2.This is a controlled burn. * 3.The fire has not been extinguished. * 4.The fire is not threatening anything at present. * 5.There are no apparent electrical lines on the ground. * 6.No one is reported to be in danger. * 7.The fire is not spreading. * 8.It is not known what size of an area is burning. * 9.No one is reported to be injured. 12/31/2012 11:48:57 : pos32 : CKNOWERS Cross streets: ZUINN ST//ANTOINE DR Geo Comment: HCEC NBH: RECREATION ACRES*\r\n",
        "ID:201239987",
        "ADDR:6004 BREEN DR",
        "X:ZUINN ST & ANTOINE DR",
        "MAP:411G",
        "INFO:HCEC NBH: RECREATION ACRES / 4812\n** EFD Case Complete **\n** EFD Recommended Dispatch ** / Omega Dispatch Level: 67O01 CAD Incident Code: 67O01\n1.The caller is on scene (1st party).\n2.This is a controlled burn.\n3.The fire has not been extinguished.\n4.The fire is not threatening anything at present.\n5.There are no apparent electrical lines on the ground.\n6.No one is reported to be in danger.\n7.The fire is not spreading.\n8.It is not known what size of an area is burning.",
        "CODE:67O01",
        "CALL:OUTSIDE FIRE - Controlled burn",
        "UNIT:DE-41",
        "DATE:12/31/2012",
        "TIME:11:48:57",
        "CH:pos32");

  }

public static void main(String[] args) {
    new TXHarrisCountyNWEMSParserTest().generateTests("T1");
  }

}