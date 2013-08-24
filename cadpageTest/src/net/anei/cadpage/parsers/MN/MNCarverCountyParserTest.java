package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Carver County, MN
Contact: Active911
Agency name: Chanhassen Fire Station
Location: Chanhassen, MN, United States
Sender:  CIS Active 911 <relay@co.carver.mn.us>

(Medical-ems at 2902 Corporate Pl, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 2902 Corporate Pl, Chanhassen, 55317\n\nMedical-ems at 2902 Corporate Pl, Chanhassen, 55317\n\nChanhassen Fire - 201300000380\n\nTime reported: 08/22/2013 10:17:17 AM\n\n\nUnit(s) responded: \n00000200\nE911 CLASS: PBXB
(Medical-ems at Hwy 5/Market Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at Hwy 5/Market Blvd, Chanhassen, 55317\n\nMedical-ems at Hwy 5/Market Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000379\n\nTime reported: 08/20/2013 7:33:33 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 2403 Harvest Way, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 2403 Harvest Way, Chanhassen, 55317\n\nMedical-ems at 2403 Harvest Way, Chanhassen, 55317\n\nChanhassen Fire - 201300000378\n\nTime reported: 08/20/2013 1:27:43 AM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 19011 Lake Dr E, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 19011 Lake Dr E, Chanhassen, 55317\n\nFire Call-fire at 19011 Lake Dr E, Chanhassen, 55317\n\nChanhassen Fire - 201300000377\n\nTime reported: 08/19/2013 4:21:57 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 8280 Market Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 8280 Market Blvd, Chanhassen, 55317\n\nFire Call-fire at 8280 Market Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000376\n\nTime reported: 08/19/2013 9:32:11 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 902 Kimberly Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 902 Kimberly Ln, Chanhassen, 55317\n\nMedical-ems at 902 Kimberly Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000375\n\nTime reported: 08/18/2013 9:17:49 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at Hwy 212/Co Rd 101, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at Hwy 212/Co Rd 101, Chanhassen, 55317\n\nFire Call-fire at Hwy 212/Co Rd 101, Chanhassen, 55317\n\nChanhassen Fire - 201300000374\n\nTime reported: 08/18/2013 8:37:51 PM\n\n\nUnit(s) responded: \n00000201
(Fire Call-fire at Hwy 5/Dell Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at Hwy 5/Dell Rd, Chanhassen, 55317\n\nFire Call-fire at Hwy 5/Dell Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000373\n\nTime reported: 08/18/2013 8:11:08 PM\n\n\nUnit(s) responded: \n00000200\nfire in electrical box / haskels liquor store huge on side of road
(Fire Call-fire at 545 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 545 Lake Dr, Chanhassen, 55317\n\nFire Call-fire at 545 Lake Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000372\n\nTime reported: 08/18/2013 12:54:12 PM\n\n\nUnit(s) responded: \nsmoke alarm
(Medical-ems at 525 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 525 Lake Dr, Chanhassen, 55317\n\nMedical-ems at 525 Lake Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000371\n\nTime reported: 08/18/2013 9:44:01 AM\n\n\nUnit(s) responded: 
(Fire Call-fire at 2200 Lyman Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 2200 Lyman Blvd, Chanhassen, 55317\n\nFire Call-fire at 2200 Lyman Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000370\n\nTime reported: 08/17/2013 12:12:22 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 410 76 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 410 76 St W, Chanhassen, 55317\n\nFire Call-fire at 410 76 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000369\n\nTime reported: 08/17/2013 10:15:11 AM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nChanhassen Fire - 201300000368\n\nTime reported: 08/16/2013 6:04:12 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 3481 Shore Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 3481 Shore Dr, Chanhassen, 55317\n\nMedical-ems at 3481 Shore Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000367\n\nTime reported: 08/16/2013 1:25:18 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 6421 Hazeltine Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 6421 Hazeltine Blvd, Chanhassen, 55317\n\nFire Call-fire at 6421 Hazeltine Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000366\n\nTime reported: 08/16/2013 9:01:46 AM\n\n\nUnit(s) responded: \n00000200\nsilighnt night
(Medical-ems at 6311 Fir Tree, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 6311 Fir Tree, Chanhassen, 55317\n\nMedical-ems at 6311 Fir Tree, Chanhassen, 55317\n\nChanhassen Fire - 201300000365\n\nTime reported: 08/14/2013 2:04:32 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at Santa Vera Dr/Powers Blvd, Chanhassen, ) Notification from CIS Active 911:\n\nMedical-ems at Santa Vera Dr/Powers Blvd, Chanhassen, \n\nMedical-ems at Santa Vera Dr/Powers Blvd, Chanhassen, \n\nChanhassen Fire - 201300000364\n\nTime reported: 08/13/2013 2:05:47 PM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Hwy 5/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 5/Hwy 101, Chanhassen, 55317\n\nPi Accident-ems at Hwy 5/Hwy 101, Chanhassen, 55317\n\nChanhassen Fire - 201300000363\n\nTime reported: 08/13/2013 8:00:50 AM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nChanhassen Fire - 201300000362\n\nTime reported: 08/12/2013 5:34:10 PM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Audubon Rd/Lake Dr W, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Audubon Rd/Lake Dr W, Chanhassen, 55317\n\nPi Accident-ems at Audubon Rd/Lake Dr W, Chanhassen, 55317\n\nChanhassen Fire - 201300000361\n\nTime reported: 08/12/2013 9:40:20 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 2 Lotus Lake, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 2 Lotus Lake, Chanhassen, 55317\n\nMedical-ems at 2 Lotus Lake, Chanhassen, 55317\n\nChanhassen Fire - 201300000360\n\nTime reported: 08/11/2013 9:18:58 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 7058 Red Cedar Cove, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 7058 Red Cedar Cove, Chanhassen, 55317\n\nMedical-ems at 7058 Red Cedar Cove, Chanhassen, 55317\n\nChanhassen Fire - 201300000359\n\nTime reported: 08/11/2013 12:31:34 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\nMedical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000358\n\nTime reported: 08/10/2013 2:55:05 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 505 Laredo Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 505 Laredo Ln, Chanhassen, 55317\n\nFire Call-fire at 505 Laredo Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000357\n\nTime reported: 08/10/2013 2:14:59 AM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Hwy 101/Flying Cloud Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 101/Flying Cloud Dr, Chanhassen, 55317\n\nPi Accident-ems at Hwy 101/Flying Cloud Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000356\n\nTime reported: 08/09/2013 6:23:46 PM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Lyman Blvd/Lake Riley Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Lyman Blvd/Lake Riley Blvd, Chanhassen, 55317\n\nPi Accident-ems at Lyman Blvd/Lake Riley Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000355\n\nTime reported: 08/09/2013 4:15:20 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 2050 Oakwood Ridge, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 2050 Oakwood Ridge, Chanhassen, 55317\n\nMedical-ems at 2050 Oakwood Ridge, Chanhassen, 55317\n\nChanhassen Fire - 201300000354\n\nTime reported: 08/09/2013 12:03:45 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\nMedical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000353\n\nTime reported: 08/07/2013 12:10:21 AM\n\n\nUnit(s) responded: \n00000200\nE911 CLASS: PBXB Apt 218
(Assist Other Agency-fire at , , ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at , , \n\nAssist Other Agency-fire at , , \n\nChanhassen Fire - 201300000352\n\nTime reported: 08/06/2013 7:26:57 PM\n\n\nUnit(s) responded: \n00000200\ntornado watch #474
(Fire Call-fire at Galpin Blvd/Lyman Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at Galpin Blvd/Lyman Blvd, Chanhassen, 55317\n\nFire Call-fire at Galpin Blvd/Lyman Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000351\n\nTime reported: 08/06/2013 6:43:56 AM\n\n\nUnit(s) responded: \n00000200\nsparks flying from power lines
(Medical-ems at 7048 Highover Ct S, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 7048 Highover Ct S, Chanhassen, 55317\n\nMedical-ems at 7048 Highover Ct S, Chanhassen, 55317\n\nChanhassen Fire - 201300000350\n\nTime reported: 08/04/2013 12:05:09 PM\n\n\nUnit(s) responded: \n00000201
(Medical-ems at 2200 Lyman Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 2200 Lyman Blvd, Chanhassen, 55317\n\nMedical-ems at 2200 Lyman Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000349\n\nTime reported: 08/04/2013 11:57:58 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 565 Marshland Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 565 Marshland Trl, Chanhassen, 55317\n\nMedical-ems at 565 Marshland Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000348\n\nTime reported: 08/02/2013 8:57:36 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 2901 Corporate Pl, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 2901 Corporate Pl, Chanhassen, 55317\n\nMedical-ems at 2901 Corporate Pl, Chanhassen, 55317\n\nChanhassen Fire - 201300000347\n\nTime reported: 08/02/2013 12:51:01 PM\n\n\nUnit(s) responded: \n00000201\nE911 CLASS: BUSN
(Medical-ems at 416 Monk Ct, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 416 Monk Ct, Chanhassen, 55317\n\nMedical-ems at 416 Monk Ct, Chanhassen, 55317\n\nChanhassen Fire - 201300000346\n\nTime reported: 08/02/2013 12:26:09 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 9520 Washington Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 9520 Washington Blvd, Chanhassen, 55317\n\nMedical-ems at 9520 Washington Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000345\n\nTime reported: 08/01/2013 7:38:26 PM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at 79 St/Market Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at 79 St/Market Blvd, Chanhassen, 55317\n\nPi Accident-ems at 79 St/Market Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000344\n\nTime reported: 08/01/2013 4:03:19 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 525 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 525 Lake Dr, Chanhassen, 55317\n\nMedical-ems at 525 Lake Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000343\n\nTime reported: 08/01/2013 1:11:38 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 6971 Pima Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 6971 Pima Ln, Chanhassen, 55317\n\nMedical-ems at 6971 Pima Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000342\n\nTime reported: 08/01/2013 6:27:18 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 1001 Park Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 1001 Park Rd, Chanhassen, 55317\n\nMedical-ems at 1001 Park Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000341\n\nTime reported: 07/31/2013 11:43:03 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 1591 Park Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 1591 Park Rd, Chanhassen, 55317\n\nFire Call-fire at 1591 Park Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000340\n\nTime reported: 07/31/2013 9:34:02 AM\n\n\nUnit(s) responded: \n00000200\nfire alarm
(Medical-ems at 1341 Lake Dr W, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 1341 Lake Dr W, Chanhassen, 55317\n\nMedical-ems at 1341 Lake Dr W, Chanhassen, 55317\n\nChanhassen Fire - 201300000339\n\nTime reported: 07/31/2013 5:49:13 AM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 6580 Joshua Cir, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 6580 Joshua Cir, Chanhassen, 55317\n\nFire Call-fire at 6580 Joshua Cir, Chanhassen, 55317\n\nChanhassen Fire - 201300000338\n\nTime reported: 07/30/2013 4:52:28 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 580 79 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 580 79 St W, Chanhassen, 55317\n\nFire Call-fire at 580 79 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000337\n\nTime reported: 07/29/2013 7:57:41 AM\nTime completed: 07/29/2013 8:01:17 AM\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 580 79 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 580 79 St W, Chanhassen, 55317\n\nFire Call-fire at 580 79 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000337\n\nTime reported: 07/29/2013 7:57:41 AM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\nFire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000336\n\nTime reported: 07/27/2013 2:21:05 AM\nTime completed: 07/27/2013 3:01:01 AM\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\nFire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000336\n\nTime reported: 07/27/2013 2:21:05 AM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\nFire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000335\n\nTime reported: 07/26/2013 11:42:20 AM\nTime completed: 07/26/2013 11:53:57 AM\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\nFire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000335\n\nTime reported: 07/26/2013 11:42:20 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 205 77 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 205 77 St W, Chanhassen, 55317\n\nMedical-ems at 205 77 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000334\n\nTime reported: 07/25/2013 12:03:05 PM\nTime completed: 07/25/2013 12:03:44 PM\n\nUnit(s) responded: 
(Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\nFire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000332\n\nTime reported: 07/22/2013 1:56:53 PM\nTime completed: 07/22/2013 2:07:36 PM\n\nUnit(s) responded: \n00000201\nfire alarm /
(Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\nFire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\nChanhassen Fire - 201300000331\n\nTime reported: 07/22/2013 1:43:47 PM\nTime completed: 07/22/2013 2:02:37 PM\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\nFire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000332\n\nTime reported: 07/22/2013 1:56:53 PM\n\n\nUnit(s) responded: \n00000201\nfire alarm /
(Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\nFire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\nChanhassen Fire - 201300000331\n\nTime reported: 07/22/2013 1:43:47 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\nMedical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000330\n\nTime reported: 07/22/2013 11:33:02 AM\nTime completed: 07/22/2013 11:52:08 AM\n\nUnit(s) responded: \n00000200
(Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\nMedical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000330\n\nTime reported: 07/22/2013 11:33:02 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\nMedical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000329\n\nTime reported: 07/22/2013 10:35:46 AM\nTime completed: 07/22/2013 11:01:20 AM\n\nUnit(s) responded: \n00000200
(Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\nMedical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000329\n\nTime reported: 07/22/2013 10:35:46 AM\n\n\nUnit(s) responded: \n00000200
(Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\nAssist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\nChanhassen Fire - 201300000328\n\nTime reported: 07/21/2013 8:46:49 AM\nTime completed: 07/21/2013 10:46:11 AM\n\nUnit(s) responded: \n00000200\nhouse struck by lightening
(Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\nAssist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\nChanhassen Fire - 201300000328\n\nTime reported: 07/21/2013 8:46:49 AM\n\n\nUnit(s) responded: \n00000200\nhouse struck by lightening
(Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\nPi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000327\n\nTime reported: 07/18/2013 12:06:01 PM\nTime completed: 07/18/2013 12:28:39 PM\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\nPi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000327\n\nTime reported: 07/18/2013 12:06:01 PM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\nFire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000326\n\nTime reported: 07/18/2013 11:00:49 AM\nTime completed: 07/18/2013 11:03:53 AM\n\nUnit(s) responded: \n00000200\nSilghnte
(Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\nFire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000326\n\nTime reported: 07/18/2013 11:00:49 AM\n\n\nUnit(s) responded: \n00000200\nSilghnte
(Medical-ems at 545 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 545 Lake Dr, Chanhassen, 55317\n\nMedical-ems at 545 Lake Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000325\n\nTime reported: 07/18/2013 8:10:48 AM\nTime completed: 07/18/2013 8:42:09 AM\n\nUnit(s) responded: \n00000200
(Medical-ems at 545 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 545 Lake Dr, Chanhassen, 55317\n\nMedical-ems at 545 Lake Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000325\n\nTime reported: 07/18/2013 8:10:48 AM\n\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\nChanhassen Fire - 201300000324\n\nTime reported: 07/18/2013 7:44:13 AM\nTime completed: 07/18/2013 7:50:05 AM\n\nUnit(s) responded: \n00000200
(Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\nChanhassen Fire - 201300000324\n\nTime reported: 07/18/2013 7:44:13 AM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\nFire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000323\n\nTime reported: 07/17/2013 10:48:00 AM\nTime completed: 07/17/2013 11:04:16 AM\n\nUnit(s) responded: \n00000200\ncarbon monoxide alarm
(Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\nFire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000323\n\nTime reported: 07/17/2013 10:48:00 AM\n\n\nUnit(s) responded: \n00000200\ncarbon monoxide alarm
(Fire Call-fire at 591 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 591 78 St W, Chanhassen, 55317\n\nFire Call-fire at 591 78 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000322\n\nTime reported: 07/17/2013 9:31:10 AM\nTime completed: 07/17/2013 9:37:25 AM\n\nUnit(s) responded: \n00000200\nFire Alarm
(Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\nFire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000321\n\nTime reported: 07/17/2013 9:23:49 AM\nTime completed: 07/17/2013 9:32:54 AM\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 591 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 591 78 St W, Chanhassen, 55317\n\nFire Call-fire at 591 78 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000322\n\nTime reported: 07/17/2013 9:31:10 AM\n\n\nUnit(s) responded: \nSimplex
(Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\nFire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000321\n\nTime reported: 07/17/2013 9:23:49 AM\n\n\nUnit(s) responded: \n00000200
(Alarm at 1480 Pembroke Pass, Chanhassen, 55317) Notification from CIS Active 911:\n\nAlarm at 1480 Pembroke Pass, Chanhassen, 55317\n\nAlarm at 1480 Pembroke Pass, Chanhassen, 55317\n\nChanhassen Fire - 201300000320\n\nTime reported: 07/17/2013 9:11:19 AM\nTime completed: 07/17/2013 9:12:13 AM\n\nUnit(s) responded: \nresidential alarm
(Assist Other Agency-fire at 131 2 St, Excelsior, ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 131 2 St, Excelsior, \n\nAssist Other Agency-fire at 131 2 St, Excelsior, \n\nChanhassen Fire - 201300000319\n\nTime reported: 07/16/2013 4:48:07 PM\n\n\nUnit(s) responded: \n00000200\none engine / to a house
(Fire Call-fire at 131 2 St, Excelsior, ) Notification from CIS Active 911:\n\nFire Call-fire at 131 2 St, Excelsior, \n\nFire Call-fire at 131 2 St, Excelsior, \n\nChanhassen Fire - 201300000319\n\nTime reported: 07/16/2013 4:48:07 PM\n\n\nUnit(s) responded: \n00000200\none engine / to a house
(Fire Call-fire at 501 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 501 78 St W, Chanhassen, 55317\n\nFire Call-fire at 501 78 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000318\n\nTime reported: 07/16/2013 4:04:13 PM\nTime completed: 07/16/2013 4:25:02 PM\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 501 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 501 78 St W, Chanhassen, 55317\n\nFire Call-fire at 501 78 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000318\n\nTime reported: 07/16/2013 4:04:13 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\nMedical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000317\n\nTime reported: 07/13/2013 9:45:15 AM\nTime completed: 07/13/2013 10:01:15 AM\n\nUnit(s) responded: \n00000201
(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nChanhassen Fire - 201300000316\n\nTime reported: 07/13/2013 9:38:39 AM\nTime completed: 07/13/2013 9:58:28 AM\n\nUnit(s) responded: \n00000200\n2 vehicle
(Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\nMedical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000317\n\nTime reported: 07/13/2013 9:45:15 AM\n\n\nUnit(s) responded: \n00000201
(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nChanhassen Fire - 201300000316\n\nTime reported: 07/13/2013 9:38:39 AM\n\n\nUnit(s) responded: \n00000200\n2 vehicle
(Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\nFire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\nChanhassen Fire - 201300000315\n\nTime reported: 07/13/2013 7:33:21 AM\nTime completed: 07/13/2013 8:04:57 AM\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\nFire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\nChanhassen Fire - 201300000315\n\nTime reported: 07/13/2013 7:33:21 AM\n\n\nUnit(s) responded: \n00000200
(Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\nFire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000314\n\nTime reported: 07/13/2013 6:03:34 AM\nTime completed: 07/13/2013 6:30:05 AM\n\nUnit(s) responded: \n00000200\nArching and sparking
(Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\nFire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000314\n\nTime reported: 07/13/2013 6:03:34 AM\n\n\nUnit(s) responded: \nArching and sparking
(Medical-ems at 7339 Frontier Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\nMedical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000313\n\nTime reported: 07/12/2013 9:56:18 AM\nTime completed: 07/12/2013 10:18:01 AM\n\nUnit(s) responded: \n00000200
(Medical-ems at 7339 Frontier Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\nMedical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000313\n\nTime reported: 07/12/2013 9:56:18 AM\n\n\nUnit(s) responded: \n00000200
(Call Error at , , ) Notification from CIS Active 911:\n\nCall Error at , , \n\nCall Error at , , \n\nChanhassen Fire - 201300000312\n\nTime reported: 07/11/2013 6:23:12 PM\nTime completed: 07/11/2013 6:34:20 PM\n\nUnit(s) responded: \n2B893
(Fire Call at 6200 Cascade Pass, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call at 6200 Cascade Pass, Chanhassen, 55317\n\nFire Call at 6200 Cascade Pass, Chanhassen, 55317\n\nChanhassen Fire - 201300000312\n\nTime reported: 07/11/2013 6:23:12 PM\n\n\nUnit(s) responded: 
(Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\nFire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000311\n\nTime reported: 07/11/2013 3:32:39 PM\nTime completed: 07/11/2013 3:41:22 PM\n\nUnit(s) responded: \n00000200\nAromr
(Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\nFire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000311\n\nTime reported: 07/11/2013 3:32:39 PM\n\n\nUnit(s) responded: \n00000200\nAromr
(Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\nFire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000310\n\nTime reported: 07/11/2013 11:43:10 AM\nTime completed: 07/11/2013 1:06:47 PM\n\nUnit(s) responded: \n00000200\nGas line break
(Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\nFire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\nFire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000310\n\nTime reported: 07/11/2013 11:43:10 AM\n\n\nUnit(s) responded: \n00000200\nGas line break
(Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\nMedical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000309\n\nTime reported: 07/10/2013 12:25:40 PM\nTime completed: 07/10/2013 12:48:39 PM\n\nUnit(s) responded: \n00000200
(Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\nMedical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000309\n\nTime reported: 07/10/2013 12:25:40 PM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\nMedical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000308\n\nTime reported: 07/10/2013 6:53:10 AM\nTime completed: 07/10/2013 7:21:55 AM\n\nUnit(s) responded: \n00000200
(Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\nMedical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000308\n\nTime reported: 07/10/2013 6:53:10 AM\n\n\nUnit(s) responded: \n00000200
(Medical-ems at 1321 Lake Dr W, Chanhassen, 55317) Notification from CIS Active 911:\n\nMedical-ems at 1321 Lake Dr W, Chanhassen, 55317\n\nMedical-ems at 1321 Lake Dr W, Chanhassen, 55317\n\nChanhassen Fire - 201300000307\n\nTime reported: 07/09/2013 11:24:48 AM\nTime completed: 07/09/2013 12:01:54 PM\n\nUnit(s) responded: \n00000200

Contact: Active911
Agency name: Chaska Fire
Location: Chaska, MN, United States
Sender: CIS Active 911 <relay@co.carver.mn.us>

(Medical-ems at 2156 Stahlke Way, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 2156 Stahlke Way, Chaska, 55318\n\nMedical-ems at 2156 Stahlke Way, Chaska, 55318\n\nChaska Fire - 201300000287\n\nTime reported: 08/22/2013 8:47:19 AM\n\n\nUnit(s) responded: \n00000300
(Medical-ems at 1105 Timber Cir, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 1105 Timber Cir, Chaska, 55318\n\nMedical-ems at 1105 Timber Cir, Chaska, 55318\n\nChaska Fire - 201300000286\n\nTime reported: 08/20/2013 9:04:12 PM\n\n\nUnit(s) responded: \n00000300
(Medical-ems at 262 Riverview Rd, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 262 Riverview Rd, Chaska, 55318\n\nMedical-ems at 262 Riverview Rd, Chaska, 55318\n\nChaska Fire - 201300000285\n\nTime reported: 08/19/2013 4:05:04 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 908 Yellow Brick Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 908 Yellow Brick Rd, Chaska, 55318\n\nFire Call-fire at 908 Yellow Brick Rd, Chaska, 55318\n\nChaska Fire - 201300000284\n\nTime reported: 08/19/2013 6:16:39 AM\n\n\nUnit(s) responded: \n00000300\nsmoke in residence from burnt cheese
(Assist Other Agency-fire at 7950 Zinnia St, Victoria, 55387) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 7950 Zinnia St, Victoria, 55387\n\nAssist Other Agency-fire at 7950 Zinnia St, Victoria, 55387\n\nChaska Fire - 201300000283\n\nTime reported: 08/18/2013 2:26:04 PM\n\n\nUnit(s) responded: \n1 mile west / on shore of lake auburn / utility barn /
(Fire Call-fire at 110400 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 110400 Pioneer Trl W, Chaska, 55318\n\nFire Call-fire at 110400 Pioneer Trl W, Chaska, 55318\n\nChaska Fire - 201300000282\n\nTime reported: 08/17/2013 8:50:53 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nFire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nChaska Fire - 201300000281\n\nTime reported: 08/17/2013 9:37:30 AM\n\n\nUnit(s) responded: \n00000300
(Medical-ems at 407 Oak St N, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 407 Oak St N, Chaska, 55318\n\nMedical-ems at 407 Oak St N, Chaska, 55318\n\nChaska Fire - 201300000280\n\nTime reported: 08/14/2013 11:51:03 AM\n\n\nUnit(s) responded: \n00000300
(Call Error at , , ) Notification from CIS Active 911:\n\nCall Error at , , \n\nCall Error at , , \n\nChaska Fire - 201300000279\n\nTime reported: 08/12/2013 6:58:49 PM\nTime completed: 08/12/2013 6:59:21 PM\n\nUnit(s) responded: 
(Fire Call-fire at 111 Pioneer Trl E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 111 Pioneer Trl E, Chaska, 55318\n\nFire Call-fire at 111 Pioneer Trl E, Chaska, 55318\n\nChaska Fire - 201300000278\n\nTime reported: 08/12/2013 6:57:05 PM\n\n\nUnit(s) responded: \n00000300
(Medical-ems at 56 Judith Dr, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 56 Judith Dr, Chaska, 55318\n\nMedical-ems at 56 Judith Dr, Chaska, 55318\n\nChaska Fire - 201300000277\n\nTime reported: 08/11/2013 10:45:40 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 954 Walnut Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 954 Walnut Ct, Chaska, 55318\n\nFire Call-fire at 954 Walnut Ct, Chaska, 55318\n\nChaska Fire - 201300000276\n\nTime reported: 08/11/2013 1:06:33 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 2505 Woodcrest Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2505 Woodcrest Dr, Chaska, 55318\n\nFire Call-fire at 2505 Woodcrest Dr, Chaska, 55318\n\nChaska Fire - 201300000275\n\nTime reported: 08/11/2013 1:11:44 AM\n\n\nUnit(s) responded: \n00000300
(Medical-ems at 2914 Hilltop Dr, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 2914 Hilltop Dr, Chaska, 55318\n\nMedical-ems at 2914 Hilltop Dr, Chaska, 55318\n\nChaska Fire - 201300000274\n\nTime reported: 08/10/2013 9:25:31 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1424 Crest Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1424 Crest Dr, Chaska, 55318\n\nFire Call-fire at 1424 Crest Dr, Chaska, 55318\n\nChaska Fire - 201300000272\n\nTime reported: 08/08/2013 3:50:38 PM\n\n\nUnit(s) responded: \n00000300
(Assist Other Agency-fire at , , ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at , , \n\nAssist Other Agency-fire at , , \n\nChaska Fire - 201300000271\n\nTime reported: 08/06/2013 7:25:31 PM\n\n\nUnit(s) responded: \n00000300\ntornado watch #474
(Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\nFire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\nChaska Fire - 201300000270\n\nTime reported: 08/06/2013 8:40:57 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 3842 Pascolo Bend, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3842 Pascolo Bend, Chaska, 55318\n\nFire Call-fire at 3842 Pascolo Bend, Chaska, 55318\n\nChaska Fire - 201300000269\n\nTime reported: 08/05/2013 5:36:24 AM\n\n\nUnit(s) responded: \n00000301
(Assist Other Agency-fire at 10275 Co Rd 140, Benton Twp, 55387) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 10275 Co Rd 140, Benton Twp, 55387\n\nAssist Other Agency-fire at 10275 Co Rd 140, Benton Twp, 55387\n\nChaska Fire - 201300000268\n\nTime reported: 08/05/2013 5:15:08 AM\n\n\nUnit(s) responded: \n00000300
(Pi Accident-ems at Bavaria Rd/Pioneer Trl, Chaska, 55318) Notification from CIS Active 911:\n\nPi Accident-ems at Bavaria Rd/Pioneer Trl, Chaska, 55318\n\nPi Accident-ems at Bavaria Rd/Pioneer Trl, Chaska, 55318\n\nChaska Fire - 201300000267\n\nTime reported: 08/03/2013 2:20:31 PM\n\n\nUnit(s) responded: \n00000300
(Medical-ems at 501 Oak St N, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 501 Oak St N, Chaska, 55318\n\nMedical-ems at 501 Oak St N, Chaska, 55318\n\nChaska Fire - 201300000266\n\nTime reported: 08/03/2013 8:30:11 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\nFire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\nChaska Fire - 201300000265\n\nTime reported: 08/02/2013 7:31:32 PM\n\n\nUnit(s) responded: \n00000300
(Pi Accident-ems at Hwy 41/Hundertmark Rd W, Chaska, 55318) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 41/Hundertmark Rd W, Chaska, 55318\n\nPi Accident-ems at Hwy 41/Hundertmark Rd W, Chaska, 55318\n\nChaska Fire - 201300000264\n\nTime reported: 08/02/2013 9:48:33 AM\n\n\nUnit(s) responded: \n00000300
(Medical-ems at 32 Rita Ln, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 32 Rita Ln, Chaska, 55318\n\nMedical-ems at 32 Rita Ln, Chaska, 55318\n\nChaska Fire - 201300000263\n\nTime reported: 08/01/2013 12:38:38 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nFire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nChaska Fire - 201300000262\n\nTime reported: 08/01/2013 12:01:44 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1424 Crest Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1424 Crest Dr, Chaska, 55318\n\nFire Call-fire at 1424 Crest Dr, Chaska, 55318\n\nChaska Fire - 201300000261\n\nTime reported: 07/31/2013 7:16:14 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 709 Laura Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 709 Laura Ct, Chaska, 55318\n\nFire Call-fire at 709 Laura Ct, Chaska, 55318\n\nChaska Fire - 201300000260\n\nTime reported: 07/30/2013 11:52:41 PM\n\n\nUnit(s) responded: \n00000300\nveh fire / in street /
(Medical-ems at 1908 Shamrock Pl, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 1908 Shamrock Pl, Chaska, 55318\n\nMedical-ems at 1908 Shamrock Pl, Chaska, 55318\n\nChaska Fire - 201300000259\n\nTime reported: 07/30/2013 6:12:26 AM\nTime completed: 07/30/2013 6:40:33 AM\n\nUnit(s) responded: \n00000300
(Medical-ems at 1908 Shamrock Pl, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 1908 Shamrock Pl, Chaska, 55318\n\nMedical-ems at 1908 Shamrock Pl, Chaska, 55318\n\nChaska Fire - 201300000259\n\nTime reported: 07/30/2013 6:12:26 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nChaska Fire - 201300000258\n\nTime reported: 07/29/2013 8:43:26 PM\nTime completed: 07/29/2013 9:27:43 PM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nChaska Fire - 201300000258\n\nTime reported: 07/29/2013 8:43:26 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nChaska Fire - 201300000257\n\nTime reported: 07/29/2013 10:47:53 AM\nTime completed: 07/29/2013 11:15:40 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nChaska Fire - 201300000257\n\nTime reported: 07/29/2013 10:47:53 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nFire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nChaska Fire - 201300000256\n\nTime reported: 07/26/2013 10:21:42 PM\nTime completed: 07/27/2013 12:10:42 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nFire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nChaska Fire - 201300000256\n\nTime reported: 07/26/2013 10:21:42 PM\n\n\nUnit(s) responded: \n00000300\nsimplex 8887467539 / gen fire /
(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nChaska Fire - 201300000255\n\nTime reported: 07/26/2013 10:10:13 AM\nTime completed: 07/26/2013 10:53:06 AM\n\nUnit(s) responded: \n00000300\nfire Alarm
(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nChaska Fire - 201300000255\n\nTime reported: 07/26/2013 10:10:13 AM\n\n\nUnit(s) responded: \n00000300\nfire Alarm
(Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nAssist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nChaska Fire - 201300000254\n\nTime reported: 07/25/2013 5:17:10 AM\nTime completed: 07/25/2013 12:06:27 PM\n\nUnit(s) responded: \n00000300
(Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nAssist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nChaska Fire - 201300000254\n\nTime reported: 07/25/2013 5:17:10 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322) Notification from CIS Active 911:\n\nFire Call-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nFire Call-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nChaska Fire - 201300000254\n\nTime reported: 07/25/2013 5:17:10 AM\n\n\nUnit(s) responded: \n00000300
(Call Error at , , 55317) Notification from CIS Active 911:\n\nCall Error at , , 55317\n\nCall Error at , , 55317\n\nChaska Fire - 201300000253\n\nTime reported: 07/24/2013 11:30:56 PM\nTime completed: 07/24/2013 11:32:47 PM\n\nUnit(s) responded: \n00001404
(Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\nFire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\nChaska Fire - 201300000252\n\nTime reported: 07/24/2013 4:53:50 PM\nTime completed: 07/24/2013 5:41:37 PM\n\nUnit(s) responded: \n00000300\nRoad hazzard/
(Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\nFire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\nChaska Fire - 201300000252\n\nTime reported: 07/24/2013 4:53:50 PM\n\n\nUnit(s) responded: \n00000300\nRoad hazzard/
(Fire Call-fire at 1 River Bend Pl, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1 River Bend Pl, Chaska, 55318\n\nFire Call-fire at 1 River Bend Pl, Chaska, 55318\n\nChaska Fire - 201300000251\n\nTime reported: 07/23/2013 9:20:10 PM\nTime completed: 07/23/2013 9:34:42 PM\n\nUnit(s) responded: \n00000300\nbonfire in woods / near river / behind the best western / also near the boat landing on the chaska side of river /
(Fire Call-fire at 1 River Bend Pl, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1 River Bend Pl, Chaska, 55318\n\nFire Call-fire at 1 River Bend Pl, Chaska, 55318\n\nChaska Fire - 201300000251\n\nTime reported: 07/23/2013 9:20:10 PM\n\n\nUnit(s) responded: \n00000300\nbonfire in woods / near river / behind the best western / also near the boat landing on the chaska side of river /
(Fire Call-fire at 4004 Peavey Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\nFire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\nChaska Fire - 201300000250\n\nTime reported: 07/22/2013 11:57:19 PM\nTime completed: 07/23/2013 1:05:50 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 4004 Peavey Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\nFire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\nChaska Fire - 201300000250\n\nTime reported: 07/22/2013 11:57:19 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 2660 Christian Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2660 Christian Ct, Chaska, 55318\n\nFire Call-fire at 2660 Christian Ct, Chaska, 55318\n\nChaska Fire - 201300000249\n\nTime reported: 07/22/2013 11:26:32 AM\nTime completed: 07/22/2013 11:36:56 AM\n\nUnit(s) responded: \n00000300\nfire alarm
(Fire Call-fire at 2660 Christian Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2660 Christian Ct, Chaska, 55318\n\nFire Call-fire at 2660 Christian Ct, Chaska, 55318\n\nChaska Fire - 201300000249\n\nTime reported: 07/22/2013 11:26:32 AM\n\n\nUnit(s) responded: \n00000300\nfire alarm
(Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\nFire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\nChaska Fire - 201300000248\n\nTime reported: 07/21/2013 11:37:22 PM\nTime completed: 07/22/2013 12:01:42 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\nFire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\nChaska Fire - 201300000248\n\nTime reported: 07/21/2013 11:37:22 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nChaska Fire - 201300000247\n\nTime reported: 07/21/2013 7:45:39 AM\nTime completed: 07/21/2013 9:52:39 AM\n\nUnit(s) responded: \n00000300\nhouse struck by lightening
(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nChaska Fire - 201300000247\n\nTime reported: 07/21/2013 7:45:39 AM\n\n\nUnit(s) responded: \n00000300\nhouse struck by lightening
(Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\nAssist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\nChaska Fire - 201300000246\n\nTime reported: 07/20/2013 2:37:51 AM\nTime completed: 07/20/2013 3:43:23 AM\n\nUnit(s) responded: \n00000300
(Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\nAssist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\nChaska Fire - 201300000246\n\nTime reported: 07/20/2013 2:37:51 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nFire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nChaska Fire - 201300000245\n\nTime reported: 07/19/2013 9:58:15 PM\nTime completed: 07/19/2013 10:16:15 PM\n\nUnit(s) responded: \n00000300\nfront desk
(Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nFire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nChaska Fire - 201300000245\n\nTime reported: 07/19/2013 9:58:15 PM\n\n\nUnit(s) responded: \n00000300\nfront desk
(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000244\n\nTime reported: 07/17/2013 5:59:07 PM\nTime completed: 07/17/2013 6:01:40 PM\n\nUnit(s) responded: \n00000300\nelev 1 / floor 2went down /rhemotid artheritis 52 yo
(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000244\n\nTime reported: 07/17/2013 5:59:07 PM\n\n\nUnit(s) responded: \nelev 1 / floor 2went down /rhemotid artheritis 52 yo
(Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\nFire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\nChaska Fire - 201300000243\n\nTime reported: 07/16/2013 9:48:24 PM\nTime completed: 07/16/2013 10:02:23 PM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\nFire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\nChaska Fire - 201300000243\n\nTime reported: 07/16/2013 9:48:24 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 401 4 St E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 401 4 St E, Chaska, 55318\n\nFire Call-fire at 401 4 St E, Chaska, 55318\n\nChaska Fire - 201300000242\n\nTime reported: 07/16/2013 6:51:26 AM\nTime completed: 07/16/2013 7:05:49 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 401 4 St E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 401 4 St E, Chaska, 55318\n\nFire Call-fire at 401 4 St E, Chaska, 55318\n\nChaska Fire - 201300000242\n\nTime reported: 07/16/2013 6:51:26 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1108 Village Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1108 Village Rd, Chaska, 55318\n\nFire Call-fire at 1108 Village Rd, Chaska, 55318\n\nChaska Fire - 201300000241\n\nTime reported: 07/15/2013 4:43:07 PM\nTime completed: 07/15/2013 5:03:41 PM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1108 Village Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1108 Village Rd, Chaska, 55318\n\nFire Call-fire at 1108 Village Rd, Chaska, 55318\n\nChaska Fire - 201300000241\n\nTime reported: 07/15/2013 4:43:07 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000240\n\nTime reported: 07/15/2013 2:21:36 AM\nTime completed: 07/15/2013 2:47:17 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000240\n\nTime reported: 07/15/2013 2:21:36 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000239\n\nTime reported: 07/15/2013 12:16:30 AM\nTime completed: 07/15/2013 12:33:25 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000239\n\nTime reported: 07/15/2013 12:16:30 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 1595 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000238\n\nTime reported: 07/14/2013 6:13:36 PM\nTime completed: 07/14/2013 6:31:27 PM\n\nUnit(s) responded: \n00000300\nco alarm
(Fire Call-fire at 1595 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000238\n\nTime reported: 07/14/2013 6:13:36 PM\n\n\nUnit(s) responded: \n00000300\nco alarm
(Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\nFire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\nChaska Fire - 201300000237\n\nTime reported: 07/14/2013 9:28:29 AM\nTime completed: 07/14/2013 10:13:54 AM\n\nUnit(s) responded: \n00000300\ncomm fire and water flow alarm
(Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\nFire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\nChaska Fire - 201300000237\n\nTime reported: 07/14/2013 9:28:29 AM\n\n\nUnit(s) responded: \n00000300
(Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318) Notification from CIS Active 911:\n\nPi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\nPi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\nChaska Fire - 201300000236\n\nTime reported: 07/12/2013 8:00:19 AM\nTime completed: 07/12/2013 8:22:33 AM\n\nUnit(s) responded: \n00000300
(Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318) Notification from CIS Active 911:\n\nPi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\nPi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\nChaska Fire - 201300000236\n\nTime reported: 07/12/2013 8:00:19 AM\n\n\nUnit(s) responded: \n00000300
(Pi Accident-ems at Hwy 41/4 St E, Chaska, 55318) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 41/4 St E, Chaska, 55318\n\nPi Accident-ems at Hwy 41/4 St E, Chaska, 55318\n\nChaska Fire - 201300000236\n\nTime reported: 07/12/2013 8:00:19 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\nFire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\nChaska Fire - 201300000235\n\nTime reported: 07/11/2013 8:20:56 PM\nTime completed: 07/11/2013 8:45:44 PM\n\nUnit(s) responded: \n00000300\nco alarm
(Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\nFire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\nChaska Fire - 201300000235\n\nTime reported: 07/11/2013 8:20:56 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\nFire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\nChaska Fire - 201300000234\n\nTime reported: 07/11/2013 10:26:06 AM\nTime completed: 07/11/2013 10:37:50 AM\n\nUnit(s) responded: \n00000300\nPoss car fire
(Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\nFire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\nChaska Fire - 201300000234\n\nTime reported: 07/11/2013 10:26:06 AM\n\n\nUnit(s) responded: \n00000300\nPoss car fire
(Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nAssist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000233\n\nTime reported: 07/11/2013 5:41:57 AM\nTime completed: 07/11/2013 6:05:14 AM\n\nUnit(s) responded: \n00000300
(Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nAssist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000233\n\nTime reported: 07/11/2013 5:41:57 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call at 445 Moers Cir, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call at 445 Moers Cir, Chaska, 55318\n\nFire Call at 445 Moers Cir, Chaska, 55318\n\nChaska Fire - 201300000232\n\nTime reported: 07/11/2013 1:37:03 AM\nTime completed: 07/11/2013 1:40:18 AM\n\nUnit(s) responded: \n00000300\nco alarm /
(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000231\n\nTime reported: 07/11/2013 12:23:54 AM\nTime completed: 07/11/2013 12:54:42 AM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000231\n\nTime reported: 07/11/2013 12:23:54 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 445 Moers Cir, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 445 Moers Cir, Chaska, 55318\n\nFire Call-fire at 445 Moers Cir, Chaska, 55318\n\nChaska Fire - 201300000230\n\nTime reported: 07/10/2013 11:30:24 PM\nTime completed: 07/10/2013 11:47:31 PM\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 445 Moers Cir, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 445 Moers Cir, Chaska, 55318\n\nFire Call-fire at 445 Moers Cir, Chaska, 55318\n\nChaska Fire - 201300000230\n\nTime reported: 07/10/2013 11:30:24 PM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 307 6 St E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 307 6 St E, Chaska, 55318\n\nFire Call-fire at 307 6 St E, Chaska, 55318\n\nChaska Fire - 201300000229\n\nTime reported: 07/08/2013 2:50:32 PM\nTime completed: 07/08/2013 3:08:19 PM\n\nUnit(s) responded: \n00000300\ntransformer smoking
(Fire Call-fire at 307 6 St E, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 307 6 St E, Chaska, 55318\n\nFire Call-fire at 307 6 St E, Chaska, 55318\n\nChaska Fire - 201300000229\n\nTime reported: 07/08/2013 2:50:32 PM\n\n\nUnit(s) responded: \n00000300\ntransformer smoking
(Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\nPi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\nChaska Fire - 201300000228\n\nTime reported: 07/08/2013 6:39:22 AM\nTime completed: 07/08/2013 7:22:42 AM\n\nUnit(s) responded: \n00000300\nsb /
(Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\nPi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\nChaska Fire - 201300000228\n\nTime reported: 07/08/2013 6:39:22 AM\n\n\nUnit(s) responded: \n00000300\nsb /
(Assist Other Agency-fire at 118 Homes St S, Shakopee, ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 118 Homes St S, Shakopee, \n\nAssist Other Agency-fire at 118 Homes St S, Shakopee, \n\nChaska Fire - 201300000227\n\nTime reported: 07/06/2013 4:16:33 PM\nTime completed: 07/06/2013 5:15:00 PM\n\nUnit(s) responded: \n00000300\nAssist to Shakopee/2nd alarm
(Assist Other Agency-fire at 118 Homes St S, Shakopee, ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 118 Homes St S, Shakopee, \n\nAssist Other Agency-fire at 118 Homes St S, Shakopee, \n\nChaska Fire - 201300000227\n\nTime reported: 07/06/2013 4:16:33 PM\n\n\nUnit(s) responded: \nChaska 2nd alarm/
(Medical-ems at 1782 Prescott Ln, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 1782 Prescott Ln, Chaska, 55318\n\nMedical-ems at 1782 Prescott Ln, Chaska, 55318\n\nChaska Fire - 201300000226\n\nTime reported: 07/06/2013 10:43:58 AM\nTime completed: 07/06/2013 10:56:31 AM\n\nUnit(s) responded: \n00000300
(Medical-ems at 1782 Prescott Ln, Chaska, 55318) Notification from CIS Active 911:\n\nMedical-ems at 1782 Prescott Ln, Chaska, 55318\n\nMedical-ems at 1782 Prescott Ln, Chaska, 55318\n\nChaska Fire - 201300000226\n\nTime reported: 07/06/2013 10:43:58 AM\n\n\nUnit(s) responded: \n00000300
(Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\nAssist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\nChaska Fire - 201300000225\n\nTime reported: 07/05/2013 8:29:59 AM\nTime completed: 07/05/2013 11:46:48 AM\n\nUnit(s) responded: \n00000300\nAssist Shorewood
(Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\nAssist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\nChaska Fire - 201300000225\n\nTime reported: 07/05/2013 8:29:59 AM\n\n\nUnit(s) responded: \n00000300
(Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\nAssist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\nChaska Fire - 201300000224\n\nTime reported: 07/04/2013 12:48:14 AM\nTime completed: 07/04/2013 2:28:30 AM\n\nUnit(s) responded: \n00000300
(Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\nAssist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\nChaska Fire - 201300000224\n\nTime reported: 07/04/2013 12:48:14 AM\n\n\nUnit(s) responded: \n00000300
(Fire Call-fire at 3355 Lake Shore Dr, Chaska, 55318) Notification from CIS Active 911:\n\nFire Call-fire at 3355 Lake Shore Dr, Chaska, 55318\n\nFire Call-fire at 3355 Lake Shore Dr, Chaska, 55318\n\nChaska Fire - 201300000223\n\nTime reported: 07/03/2013 11:13:09 PM\nTime completed: 07/03/2013 11:46:46 PM\n\nUnit(s) responded: \n00000300\nsmoke inside /

Contact: Active911
Agency name: MAYER FIRE DEPT
Location: MAYER, MN, United States
Sender: CIS Active 911 <relay@co.carver.mn.us>

(Medical-ems at Hwy 25/74 St, Waconia Twp, 55360) Notification from CIS Active 911:\n\nMedical-ems at Hwy 25/74 St, Waconia Twp, 55360\n\nMedical-ems at Hwy 25/74 St, Waconia Twp, 55360\n\nMayer Fire - 201300000065\n\nTime reported: 08/21/2013 2:26:27 PM\n\n\nUnit(s) responded: \n00000600
(Assist Other Agency-fire at 12485 Co Rd 30, Waconia Twp, 55387) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 12485 Co Rd 30, Waconia Twp, 55387\n\nAssist Other Agency-fire at 12485 Co Rd 30, Waconia Twp, 55387\n\nMayer Fire - 201300000064\n\nTime reported: 08/21/2013 10:02:50 AM\n\n\nUnit(s) responded: \nbarn fire /
(Fire Call-fire at 2339 Coldwater Crossing, Mayer, 55360) Notification from CIS Active 911:\n\nFire Call-fire at 2339 Coldwater Crossing, Mayer, 55360\n\nFire Call-fire at 2339 Coldwater Crossing, Mayer, 55360\n\nMayer Fire - 201300000063\n\nTime reported: 08/14/2013 1:19:59 AM\n\n\nUnit(s) responded: \n00000600\nstrong smell / smoke /carbon / alarms going off /
(Assist Other Agency-fire at 340 Co Rd 92, , ) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 340 Co Rd 92, , \n\nAssist Other Agency-fire at 340 Co Rd 92, , \n\nMayer Fire - 201300000062\n\nTime reported: 08/06/2013 11:27:19 AM\n\n\nUnit(s) responded: \n00000600
(Assist Other Agency-fire at Co Rd 140/Hwy 284, Waconia Twp, 55387) Notification from CIS Active 911:\n\nAssist Other Agency-fire at Co Rd 140/Hwy 284, Waconia Twp, 55387\n\nAssist Other Agency-fire at Co Rd 140/Hwy 284, Waconia Twp, 55387\n\nMayer Fire - 201300000061\n\nTime reported: 08/05/2013 5:13:15 AM\n\n\nUnit(s) responded: \n00000600
(Medical-ems at 104 West Ridge Rd, Mayer, 55360) Notification from CIS Active 911:\n\nMedical-ems at 104 West Ridge Rd, Mayer, 55360\n\nMedical-ems at 104 West Ridge Rd, Mayer, 55360\n\nMayer Fire - 201300000060\n\nTime reported: 08/04/2013 2:04:40 AM\n\n\nUnit(s) responded: 
(Fire Call-fire at 400 Ash Av N, Mayer, 55360) Notification from CIS Active 911:\n\nFire Call-fire at 400 Ash Av N, Mayer, 55360\n\nFire Call-fire at 400 Ash Av N, Mayer, 55360\n\nMayer Fire - 201300000059\n\nTime reported: 08/01/2013 8:56:30 AM\n\n\nUnit(s) responded: \n00000600\ncompost fire
(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nMayer Fire - 201300000058\n\nTime reported: 07/21/2013 1:43:58 AM\nTime completed: 07/21/2013 2:15:33 AM\n\nUnit(s) responded: \n00000600
(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nMayer Fire - 201300000058\n\nTime reported: 07/21/2013 1:43:58 AM\n\n\nUnit(s) responded: \n00000600
(Medical-ems at 529 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\nMedical-ems at 529 Ash Av S, Mayer, 55360\n\nMedical-ems at 529 Ash Av S, Mayer, 55360\n\nMayer Fire - 201300000057\n\nTime reported: 07/16/2013 10:17:39 PM\nTime completed: 07/16/2013 10:36:23 PM\n\nUnit(s) responded: \n00000600
(Medical-ems at 529 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\nMedical-ems at 529 Ash Av S, Mayer, 55360\n\nMedical-ems at 529 Ash Av S, Mayer, 55360\n\nMayer Fire - 201300000057\n\nTime reported: 07/16/2013 10:17:39 PM\n\n\nUnit(s) responded: \n00000600
(Medical-ems at 305 5 St Ne, Mayer, 55360) Notification from CIS Active 911:\n\nMedical-ems at 305 5 St Ne, Mayer, 55360\n\nMedical-ems at 305 5 St Ne, Mayer, 55360\n\nMayer Fire - 201300000056\n\nTime reported: 07/08/2013 6:47:21 PM\nTime completed: 07/08/2013 7:16:49 PM\n\nUnit(s) responded: \n00000600
(Medical-ems at 305 5 St Ne, Mayer, 55360) Notification from CIS Active 911:\n\nMedical-ems at 305 5 St Ne, Mayer, 55360\n\nMedical-ems at 305 5 St Ne, Mayer, 55360\n\nMayer Fire - 201300000056\n\nTime reported: 07/08/2013 6:47:21 PM\n\n\nUnit(s) responded: \n00000600
(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nMayer Fire - 201300000055\n\nTime reported: 07/08/2013 12:12:04 PM\nTime completed: 07/08/2013 12:40:21 PM\n\nUnit(s) responded: \n00000600
(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nMayer Fire - 201300000055\n\nTime reported: 07/08/2013 12:12:04 PM\n\n\nUnit(s) responded: \n00000600
(Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\nAssist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\nMayer Fire - 201300000054\n\nTime reported: 07/03/2013 2:55:28 PM\nTime completed: 07/03/2013 2:56:46 PM\n\nUnit(s) responded: \n00000600\nThis is a test e-mail for Active 9-1-1 / This is not an actual incident /
(Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\nAssist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\nAssist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\nMayer Fire - 201300000054\n\nTime reported: 07/03/2013 2:55:28 PM\n\n\nUnit(s) responded: \n00000600\nThis is a test e-mail for Active 9-1-1 / This is not an actual incident /

Contact: Active911
Agency name: Hamburg Fire and Resuce
Location: Hamburg, MN, United States

*/

public class MNCarverCountyParserTest extends BaseParserTest {
  
  public MNCarverCountyParserTest() {
    setParser(new MNCarverCountyParser(), "CARVER COUNTY", "MN");
  }
  
  @Test
  public void testChanhassen() {

    doTest("T1",
        "(Medical-ems at 2902 Corporate Pl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2902 Corporate Pl, Chanhassen, 55317\n\n" +
        "Medical-ems at 2902 Corporate Pl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000380\n\n" +
        "Time reported: 08/22/2013 10:17:17 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "E911 CLASS: PBXB",

        "CALL:Medical-ems",
        "ADDR:2902 Corporate Pl",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000380",
        "DATE:08/22/2013",
        "TIME:10:17:17",
        "UNIT:00000200",
        "INFO:E911 CLASS: PBXB");

    doTest("T2",
        "(Medical-ems at Hwy 5/Market Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at Hwy 5/Market Blvd, Chanhassen, 55317\n\n" +
        "Medical-ems at Hwy 5/Market Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000379\n\n" +
        "Time reported: 08/20/2013 7:33:33 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:Hwy 5 & Market Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000379",
        "DATE:08/20/2013",
        "TIME:19:33:33",
        "UNIT:00000200");

    doTest("T3",
        "(Medical-ems at 2403 Harvest Way, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2403 Harvest Way, Chanhassen, 55317\n\n" +
        "Medical-ems at 2403 Harvest Way, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000378\n\n" +
        "Time reported: 08/20/2013 1:27:43 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:2403 Harvest Way",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000378",
        "DATE:08/20/2013",
        "TIME:01:27:43",
        "UNIT:00000200");

    doTest("T4",
        "(Fire Call-fire at 19011 Lake Dr E, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 19011 Lake Dr E, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 19011 Lake Dr E, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000377\n\n" +
        "Time reported: 08/19/2013 4:21:57 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:19011 Lake Dr E",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000377",
        "DATE:08/19/2013",
        "TIME:16:21:57",
        "UNIT:00000200");

    doTest("T5",
        "(Fire Call-fire at 8280 Market Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 8280 Market Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 8280 Market Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000376\n\n" +
        "Time reported: 08/19/2013 9:32:11 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:8280 Market Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000376",
        "DATE:08/19/2013",
        "TIME:09:32:11",
        "UNIT:00000200");

    doTest("T6",
        "(Medical-ems at 902 Kimberly Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 902 Kimberly Ln, Chanhassen, 55317\n\n" +
        "Medical-ems at 902 Kimberly Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000375\n\n" +
        "Time reported: 08/18/2013 9:17:49 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:902 Kimberly Ln",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000375",
        "DATE:08/18/2013",
        "TIME:21:17:49",
        "UNIT:00000200");

    doTest("T7",
        "(Fire Call-fire at Hwy 212/Co Rd 101, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at Hwy 212/Co Rd 101, Chanhassen, 55317\n\n" +
        "Fire Call-fire at Hwy 212/Co Rd 101, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000374\n\n" +
        "Time reported: 08/18/2013 8:37:51 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000201",

        "CALL:Fire Call-fire",
        "ADDR:Hwy 212 & Co Rd 101",
        "MADDR:Hwy 212 & COUNTY ROAD 101", // maps at county road 101 and main street
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000374",
        "DATE:08/18/2013",
        "TIME:20:37:51",
        "UNIT:00000201");

    doTest("T8",
        "(Fire Call-fire at Hwy 5/Dell Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at Hwy 5/Dell Rd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at Hwy 5/Dell Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000373\n\n" +
        "Time reported: 08/18/2013 8:11:08 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "fire in electrical box / haskels liquor store huge on side of road",

        "CALL:Fire Call-fire",
        "ADDR:Hwy 5 & Dell Rd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000373",
        "DATE:08/18/2013",
        "TIME:20:11:08",
        "UNIT:00000200",
        "INFO:fire in electrical box / haskels liquor store huge on side of road");

    doTest("T9",
        "(Fire Call-fire at 545 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 545 Lake Dr, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 545 Lake Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000372\n\n" +
        "Time reported: 08/18/2013 12:54:12 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "smoke alarm",

        "CALL:Fire Call-fire",
        "ADDR:545 Lake Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000372",
        "DATE:08/18/2013",
        "TIME:12:54:12",
        "INFO:smoke alarm");

    doTest("T10",
        "(Medical-ems at 525 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 525 Lake Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 525 Lake Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000371\n\n" +
        "Time reported: 08/18/2013 9:44:01 AM\n\n\n" +
        "Unit(s) responded: ",

        "CALL:Medical-ems",
        "ADDR:525 Lake Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000371",
        "DATE:08/18/2013",
        "TIME:09:44:01");

    doTest("T11",
        "(Fire Call-fire at 2200 Lyman Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2200 Lyman Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 2200 Lyman Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000370\n\n" +
        "Time reported: 08/17/2013 12:12:22 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:2200 Lyman Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000370",
        "DATE:08/17/2013",
        "TIME:12:12:22",
        "UNIT:00000200");

    doTest("T12",
        "(Fire Call-fire at 410 76 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 410 76 St W, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 410 76 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000369\n\n" +
        "Time reported: 08/17/2013 10:15:11 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:410 76 St W",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000369",
        "DATE:08/17/2013",
        "TIME:10:15:11",
        "UNIT:00000200");

    doTest("T13",
        "(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000368\n\n" +
        "Time reported: 08/16/2013 6:04:12 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Co Rd 61 & Hwy 101",
        "MADDR:COUNTY ROAD 61 & Hwy 101",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000368",
        "DATE:08/16/2013",
        "TIME:18:04:12",
        "UNIT:00000200");

    doTest("T14",
        "(Medical-ems at 3481 Shore Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 3481 Shore Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 3481 Shore Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000367\n\n" +
        "Time reported: 08/16/2013 1:25:18 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:3481 Shore Dr",
        "CITY:Chanhassen", // maps at Excelsior, MN
        "SRC:Chanhassen Fire",
        "ID:201300000367",
        "DATE:08/16/2013",
        "TIME:13:25:18",
        "UNIT:00000200");

    doTest("T15",
        "(Fire Call-fire at 6421 Hazeltine Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 6421 Hazeltine Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 6421 Hazeltine Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000366\n\n" +
        "Time reported: 08/16/2013 9:01:46 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "silighnt night",

        "CALL:Fire Call-fire",
        "ADDR:6421 Hazeltine Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000366",
        "DATE:08/16/2013",
        "TIME:09:01:46",
        "UNIT:00000200",
        "INFO:silighnt night");

    doTest("T16",
        "(Medical-ems at 6311 Fir Tree, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 6311 Fir Tree, Chanhassen, 55317\n\n" +
        "Medical-ems at 6311 Fir Tree, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000365\n\n" +
        "Time reported: 08/14/2013 2:04:32 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:6311 Fir Tree",
        "CITY:Chanhassen", // maps at Excelsior, MN
        "SRC:Chanhassen Fire",
        "ID:201300000365",
        "DATE:08/14/2013",
        "TIME:14:04:32",
        "UNIT:00000200");

    doTest("T17",
        "(Medical-ems at Santa Vera Dr/Powers Blvd, Chanhassen, ) Notification from CIS Active 911:\n\n" +
        "Medical-ems at Santa Vera Dr/Powers Blvd, Chanhassen, \n\n" +
        "Medical-ems at Santa Vera Dr/Powers Blvd, Chanhassen, \n\n" +
        "Chanhassen Fire - 201300000364\n\n" +
        "Time reported: 08/13/2013 2:05:47 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:Santa Vera Dr & Powers Blvd, Chanhassen",
        "SRC:Medical-ems at Santa Vera Dr/Powers Blvd, Chanhassen,",
        "DATE:08/13/2013",
        "TIME:14:05:47",
        "UNIT:00000200");

    doTest("T18",
        "(Pi Accident-ems at Hwy 5/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 5/Hwy 101, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Hwy 5/Hwy 101, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000363\n\n" +
        "Time reported: 08/13/2013 8:00:50 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Hwy 5 & Hwy 101",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000363",
        "DATE:08/13/2013",
        "TIME:08:00:50",
        "UNIT:00000200");

    doTest("T19",
        "(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000362\n\n" +
        "Time reported: 08/12/2013 5:34:10 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Co Rd 61 & Hwy 101",
        "MADDR:COUNTY ROAD 61 & Hwy 101",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000362",
        "DATE:08/12/2013",
        "TIME:17:34:10",
        "UNIT:00000200");

    doTest("T20",
        "(Pi Accident-ems at Audubon Rd/Lake Dr W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Audubon Rd/Lake Dr W, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Audubon Rd/Lake Dr W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000361\n\n" +
        "Time reported: 08/12/2013 9:40:20 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Audubon Rd & Lake Dr W",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000361",
        "DATE:08/12/2013",
        "TIME:09:40:20",
        "UNIT:00000200");

    doTest("T21",
        "(Medical-ems at 2 Lotus Lake, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2 Lotus Lake, Chanhassen, 55317\n\n" +
        "Medical-ems at 2 Lotus Lake, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000360\n\n" +
        "Time reported: 08/11/2013 9:18:58 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:2 Lotus Lake", //maps to center of Lotus Lake
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000360",
        "DATE:08/11/2013",
        "TIME:21:18:58",
        "UNIT:00000200");

    doTest("T22",
        "(Medical-ems at 7058 Red Cedar Cove, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 7058 Red Cedar Cove, Chanhassen, 55317\n\n" +
        "Medical-ems at 7058 Red Cedar Cove, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000359\n\n" +
        "Time reported: 08/11/2013 12:31:34 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:7058 Red Cedar Cove",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000359",
        "DATE:08/11/2013",
        "TIME:00:31:34",
        "UNIT:00000200");

    doTest("T23",
        "(Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000358\n\n" +
        "Time reported: 08/10/2013 2:55:05 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:820 Santa Vera Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000358",
        "DATE:08/10/2013",
        "TIME:14:55:05",
        "UNIT:00000200");

    doTest("T24",
        "(Fire Call-fire at 505 Laredo Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 505 Laredo Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 505 Laredo Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000357\n\n" +
        "Time reported: 08/10/2013 2:14:59 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:505 Laredo Ln",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000357",
        "DATE:08/10/2013",
        "TIME:02:14:59",
        "UNIT:00000200");

    doTest("T25",
        "(Pi Accident-ems at Hwy 101/Flying Cloud Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 101/Flying Cloud Dr, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Hwy 101/Flying Cloud Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000356\n\n" +
        "Time reported: 08/09/2013 6:23:46 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Hwy 101 & Flying Cloud Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000356",
        "DATE:08/09/2013",
        "TIME:18:23:46",
        "UNIT:00000200");

    doTest("T26",
        "(Pi Accident-ems at Lyman Blvd/Lake Riley Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Lyman Blvd/Lake Riley Blvd, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Lyman Blvd/Lake Riley Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000355\n\n" +
        "Time reported: 08/09/2013 4:15:20 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Lyman Blvd & Lake Riley Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000355",
        "DATE:08/09/2013",
        "TIME:16:15:20",
        "UNIT:00000200");

    doTest("T27",
        "(Medical-ems at 2050 Oakwood Ridge, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2050 Oakwood Ridge, Chanhassen, 55317\n\n" +
        "Medical-ems at 2050 Oakwood Ridge, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000354\n\n" +
        "Time reported: 08/09/2013 12:03:45 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:2050 Oakwood Ridge",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000354",
        "DATE:08/09/2013",
        "TIME:12:03:45",
        "UNIT:00000200");

    doTest("T28",
        "(Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 820 Santa Vera Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000353\n\n" +
        "Time reported: 08/07/2013 12:10:21 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "E911 CLASS: PBXB Apt 218",

        "CALL:Medical-ems",
        "ADDR:820 Santa Vera Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000353",
        "DATE:08/07/2013",
        "TIME:00:10:21",
        "UNIT:00000200",
        "INFO:E911 CLASS: PBXB Apt 218");

    doTest("T29",
        "(Assist Other Agency-fire at , , ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at , , \n\n" +
        "Assist Other Agency-fire at , , \n\n" +
        "Chanhassen Fire - 201300000352\n\n" +
        "Time reported: 08/06/2013 7:26:57 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "tornado watch #474",

        "CALL:Assist Other Agency-fire",
        "SRC:Assist Other Agency-fire at , ,",
        "DATE:08/06/2013",
        "TIME:19:26:57",
        "UNIT:00000200",
        "INFO:tornado watch #474");

    doTest("T30",
        "(Fire Call-fire at Galpin Blvd/Lyman Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at Galpin Blvd/Lyman Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at Galpin Blvd/Lyman Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000351\n\n" +
        "Time reported: 08/06/2013 6:43:56 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "sparks flying from power lines",

        "CALL:Fire Call-fire",
        "ADDR:Galpin Blvd & Lyman Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000351",
        "DATE:08/06/2013",
        "TIME:06:43:56",
        "UNIT:00000200",
        "INFO:sparks flying from power lines");

    doTest("T31",
        "(Medical-ems at 7048 Highover Ct S, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 7048 Highover Ct S, Chanhassen, 55317\n\n" +
        "Medical-ems at 7048 Highover Ct S, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000350\n\n" +
        "Time reported: 08/04/2013 12:05:09 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000201",

        "CALL:Medical-ems",
        "ADDR:7048 Highover Ct S",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000350",
        "DATE:08/04/2013",
        "TIME:12:05:09",
        "UNIT:00000201");

    doTest("T32",
        "(Medical-ems at 2200 Lyman Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2200 Lyman Blvd, Chanhassen, 55317\n\n" +
        "Medical-ems at 2200 Lyman Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000349\n\n" +
        "Time reported: 08/04/2013 11:57:58 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:2200 Lyman Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000349",
        "DATE:08/04/2013",
        "TIME:11:57:58",
        "UNIT:00000200");

    doTest("T33",
        "(Medical-ems at 565 Marshland Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 565 Marshland Trl, Chanhassen, 55317\n\n" +
        "Medical-ems at 565 Marshland Trl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000348\n\n" +
        "Time reported: 08/02/2013 8:57:36 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:565 Marshland Trl",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000348",
        "DATE:08/02/2013",
        "TIME:20:57:36",
        "UNIT:00000200");

    doTest("T34",
        "(Medical-ems at 2901 Corporate Pl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2901 Corporate Pl, Chanhassen, 55317\n\n" +
        "Medical-ems at 2901 Corporate Pl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000347\n\n" +
        "Time reported: 08/02/2013 12:51:01 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000201\n" +
        "E911 CLASS: BUSN",

        "CALL:Medical-ems",
        "ADDR:2901 Corporate Pl",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000347",
        "DATE:08/02/2013",
        "TIME:12:51:01",
        "UNIT:00000201",
        "INFO:E911 CLASS: BUSN");

    doTest("T35",
        "(Medical-ems at 416 Monk Ct, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 416 Monk Ct, Chanhassen, 55317\n\n" +
        "Medical-ems at 416 Monk Ct, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000346\n\n" +
        "Time reported: 08/02/2013 12:26:09 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:416 Monk Ct",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000346",
        "DATE:08/02/2013",
        "TIME:12:26:09",
        "UNIT:00000200");

    doTest("T36",
        "(Medical-ems at 9520 Washington Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 9520 Washington Blvd, Chanhassen, 55317\n\n" +
        "Medical-ems at 9520 Washington Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000345\n\n" +
        "Time reported: 08/01/2013 7:38:26 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:9520 Washington Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000345",
        "DATE:08/01/2013",
        "TIME:19:38:26",
        "UNIT:00000200");

    doTest("T37",
        "(Pi Accident-ems at 79 St/Market Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at 79 St/Market Blvd, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at 79 St/Market Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000344\n\n" +
        "Time reported: 08/01/2013 4:03:19 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:79 St & Market Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000344",
        "DATE:08/01/2013",
        "TIME:16:03:19",
        "UNIT:00000200");

    doTest("T38",
        "(Medical-ems at 525 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 525 Lake Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 525 Lake Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000343\n\n" +
        "Time reported: 08/01/2013 1:11:38 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:525 Lake Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000343",
        "DATE:08/01/2013",
        "TIME:13:11:38",
        "UNIT:00000200");

    doTest("T39",
        "(Medical-ems at 6971 Pima Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 6971 Pima Ln, Chanhassen, 55317\n\n" +
        "Medical-ems at 6971 Pima Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000342\n\n" +
        "Time reported: 08/01/2013 6:27:18 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:6971 Pima Ln",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000342",
        "DATE:08/01/2013",
        "TIME:06:27:18",
        "UNIT:00000200");

    doTest("T40",
        "(Medical-ems at 1001 Park Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1001 Park Rd, Chanhassen, 55317\n\n" +
        "Medical-ems at 1001 Park Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000341\n\n" +
        "Time reported: 07/31/2013 11:43:03 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:1001 Park Rd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000341",
        "DATE:07/31/2013",
        "TIME:23:43:03",
        "UNIT:00000200");

    doTest("T41",
        "(Fire Call-fire at 1591 Park Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1591 Park Rd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 1591 Park Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000340\n\n" +
        "Time reported: 07/31/2013 9:34:02 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "fire alarm",

        "CALL:Fire Call-fire",
        "ADDR:1591 Park Rd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000340",
        "DATE:07/31/2013",
        "TIME:09:34:02",
        "UNIT:00000200",
        "INFO:fire alarm");

    doTest("T42",
        "(Medical-ems at 1341 Lake Dr W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1341 Lake Dr W, Chanhassen, 55317\n\n" +
        "Medical-ems at 1341 Lake Dr W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000339\n\n" +
        "Time reported: 07/31/2013 5:49:13 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:1341 Lake Dr W",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000339",
        "DATE:07/31/2013",
        "TIME:05:49:13",
        "UNIT:00000200");

    doTest("T43",
        "(Fire Call-fire at 6580 Joshua Cir, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 6580 Joshua Cir, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 6580 Joshua Cir, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000338\n\n" +
        "Time reported: 07/30/2013 4:52:28 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:6580 Joshua Cir",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000338",
        "DATE:07/30/2013",
        "TIME:16:52:28",
        "UNIT:00000200");

    doTest("T44",
        "(Fire Call-fire at 580 79 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 580 79 St W, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 580 79 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000337\n\n" +
        "Time reported: 07/29/2013 7:57:41 AM\n" +
        "Time completed: 07/29/2013 8:01:17 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000337",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 580 79 St W, Chanhassen, 55317\n\nFire Call-fire at 580 79 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000337\n\nTime reported: 07/29/2013 7:57:41 AM\nTime completed: 07/29/2013 8:01:17 AM\n\nUnit(s) responded: \n00000200");

    doTest("T45",
        "(Fire Call-fire at 580 79 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 580 79 St W, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 580 79 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000337\n\n" +
        "Time reported: 07/29/2013 7:57:41 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:580 79 St W",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000337",
        "DATE:07/29/2013",
        "TIME:07:57:41",
        "UNIT:00000200");

    doTest("T46",
        "(Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000336\n\n" +
        "Time reported: 07/27/2013 2:21:05 AM\n" +
        "Time completed: 07/27/2013 3:01:01 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000336",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\nFire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000336\n\nTime reported: 07/27/2013 2:21:05 AM\nTime completed: 07/27/2013 3:01:01 AM\n\nUnit(s) responded: \n00000200");

    doTest("T47",
        "(Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 1621 Mcglynn Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000336\n\n" +
        "Time reported: 07/27/2013 2:21:05 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:1621 Mcglynn Rd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000336",
        "DATE:07/27/2013",
        "TIME:02:21:05",
        "UNIT:00000200");

    doTest("T48",
        "(Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000335\n\n" +
        "Time reported: 07/26/2013 11:42:20 AM\n" +
        "Time completed: 07/26/2013 11:53:57 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000335",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\nFire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000335\n\nTime reported: 07/26/2013 11:42:20 AM\nTime completed: 07/26/2013 11:53:57 AM\n\nUnit(s) responded: \n00000200");

    doTest("T49",
        "(Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 6500 Shadow Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000335\n\n" +
        "Time reported: 07/26/2013 11:42:20 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:6500 Shadow Ln",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000335",
        "DATE:07/26/2013",
        "TIME:11:42:20",
        "UNIT:00000200");

    doTest("T50",
        "(Medical-ems at 205 77 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 205 77 St W, Chanhassen, 55317\n\n" +
        "Medical-ems at 205 77 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000334\n\n" +
        "Time reported: 07/25/2013 12:03:05 PM\n" +
        "Time completed: 07/25/2013 12:03:44 PM\n\n" +
        "Unit(s) responded: ",

        "CALL:RUN REPORT",
        "ID:201300000334",
        "PLACE:Medical-ems at 205 77 St W, Chanhassen, 55317\n\nMedical-ems at 205 77 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000334\n\nTime reported: 07/25/2013 12:03:05 PM\nTime completed: 07/25/2013 12:03:44 PM\n\nUnit(s) responded:");

    doTest("T51",
        "(Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000332\n\n" +
        "Time reported: 07/22/2013 1:56:53 PM\n" +
        "Time completed: 07/22/2013 2:07:36 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000201\n" +
        "fire alarm /",

        "CALL:RUN REPORT",
        "ID:201300000332",
        "UNIT:00000201",
        "PLACE:Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\nFire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000332\n\nTime reported: 07/22/2013 1:56:53 PM\nTime completed: 07/22/2013 2:07:36 PM\n\nUnit(s) responded: \n00000201\nfire alarm /");

    doTest("T52",
        "(Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000331\n\n" +
        "Time reported: 07/22/2013 1:43:47 PM\n" +
        "Time completed: 07/22/2013 2:02:37 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000331",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\nFire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\nChanhassen Fire - 201300000331\n\nTime reported: 07/22/2013 1:43:47 PM\nTime completed: 07/22/2013 2:02:37 PM\n\nUnit(s) responded: \n00000200");

    doTest("T53",
        "(Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7600 Laredo Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000332\n\n" +
        "Time reported: 07/22/2013 1:56:53 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000201\n" +
        "fire alarm /",

        "CALL:Fire Call-fire",
        "ADDR:7600 Laredo Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000332",
        "DATE:07/22/2013",
        "TIME:13:56:53",
        "UNIT:00000201",
        "INFO:fire alarm /");

    doTest("T54",
        "(Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7215 Lodge Pole Pt, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000331\n\n" +
        "Time reported: 07/22/2013 1:43:47 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:7215 Lodge Pole Pt",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000331",
        "DATE:07/22/2013",
        "TIME:13:43:47",
        "UNIT:00000200");

    doTest("T55",
        "(Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000330\n\n" +
        "Time reported: 07/22/2013 11:33:02 AM\n" +
        "Time completed: 07/22/2013 11:52:08 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000330",
        "UNIT:00000200",
        "PLACE:Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\nMedical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000330\n\nTime reported: 07/22/2013 11:33:02 AM\nTime completed: 07/22/2013 11:52:08 AM\n\nUnit(s) responded: \n00000200");

    doTest("T56",
        "(Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 524 Mission Hills Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000330\n\n" +
        "Time reported: 07/22/2013 11:33:02 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:524 Mission Hills Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000330",
        "DATE:07/22/2013",
        "TIME:11:33:02",
        "UNIT:00000200");

    doTest("T57",
        "(Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000329\n\n" +
        "Time reported: 07/22/2013 10:35:46 AM\n" +
        "Time completed: 07/22/2013 11:01:20 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000329",
        "UNIT:00000200",
        "PLACE:Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\nMedical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000329\n\nTime reported: 07/22/2013 10:35:46 AM\nTime completed: 07/22/2013 11:01:20 AM\n\nUnit(s) responded: \n00000200");

    doTest("T58",
        "(Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 1440 Lake Susan Hills Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000329\n\n" +
        "Time reported: 07/22/2013 10:35:46 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:1440 Lake Susan Hills Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000329",
        "DATE:07/22/2013",
        "TIME:10:35:46",
        "UNIT:00000200");

    doTest("T59",
        "(Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Chanhassen Fire - 201300000328\n\n" +
        "Time reported: 07/21/2013 8:46:49 AM\n" +
        "Time completed: 07/21/2013 10:46:11 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "house struck by lightening",

        "CALL:RUN REPORT",
        "ID:201300000328",
        "UNIT:00000200",
        "PLACE:Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\nAssist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\nChanhassen Fire - 201300000328\n\nTime reported: 07/21/2013 8:46:49 AM\nTime completed: 07/21/2013 10:46:11 AM\n\nUnit(s) responded: \n00000200\nhouse struck by lightening");

    doTest("T60",
        "(Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Assist Other Agency-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Chanhassen Fire - 201300000328\n\n" +
        "Time reported: 07/21/2013 8:46:49 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "house struck by lightening",

        "CALL:Assist Other Agency-fire",
        "ADDR:2876 Fairway Dr",
        "CITY:Chaska",
        "SRC:Chanhassen Fire",
        "ID:201300000328",
        "DATE:07/21/2013",
        "TIME:08:46:49",
        "UNIT:00000200",
        "INFO:house struck by lightening");

    doTest("T61",
        "(Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000327\n\n" +
        "Time reported: 07/18/2013 12:06:01 PM\n" +
        "Time completed: 07/18/2013 12:28:39 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000327",
        "UNIT:00000200",
        "PLACE:Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\nPi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000327\n\nTime reported: 07/18/2013 12:06:01 PM\nTime completed: 07/18/2013 12:28:39 PM\n\nUnit(s) responded: \n00000200");

    doTest("T62",
        "(Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Galpin Blvd/Bridle Creek Trl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000327\n\n" +
        "Time reported: 07/18/2013 12:06:01 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Galpin Blvd & Bridle Creek Trl",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000327",
        "DATE:07/18/2013",
        "TIME:12:06:01",
        "UNIT:00000200");

    doTest("T63",
        "(Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000326\n\n" +
        "Time reported: 07/18/2013 11:00:49 AM\n" +
        "Time completed: 07/18/2013 11:03:53 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Silghnte",

        "CALL:RUN REPORT",
        "ID:201300000326",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\nFire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000326\n\nTime reported: 07/18/2013 11:00:49 AM\nTime completed: 07/18/2013 11:03:53 AM\n\nUnit(s) responded: \n00000200\nSilghnte");

    doTest("T64",
        "(Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 8950 Crossroads Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000326\n\n" +
        "Time reported: 07/18/2013 11:00:49 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Silghnte",

        "CALL:Fire Call-fire",
        "ADDR:8950 Crossroads Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000326",
        "DATE:07/18/2013",
        "TIME:11:00:49",
        "UNIT:00000200",
        "INFO:Silghnte");

    doTest("T65",
        "(Medical-ems at 545 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 545 Lake Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 545 Lake Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000325\n\n" +
        "Time reported: 07/18/2013 8:10:48 AM\n" +
        "Time completed: 07/18/2013 8:42:09 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000325",
        "UNIT:00000200",
        "PLACE:Medical-ems at 545 Lake Dr, Chanhassen, 55317\n\nMedical-ems at 545 Lake Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000325\n\nTime reported: 07/18/2013 8:10:48 AM\nTime completed: 07/18/2013 8:42:09 AM\n\nUnit(s) responded: \n00000200");

    doTest("T66",
        "(Medical-ems at 545 Lake Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 545 Lake Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 545 Lake Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000325\n\n" +
        "Time reported: 07/18/2013 8:10:48 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:545 Lake Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000325",
        "DATE:07/18/2013",
        "TIME:08:10:48",
        "UNIT:00000200");

    doTest("T67",
        "(Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000324\n\n" +
        "Time reported: 07/18/2013 7:44:13 AM\n" +
        "Time completed: 07/18/2013 7:50:05 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000324",
        "UNIT:00000200",
        "PLACE:Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\nChanhassen Fire - 201300000324\n\nTime reported: 07/18/2013 7:44:13 AM\nTime completed: 07/18/2013 7:50:05 AM\n\nUnit(s) responded: \n00000200");

    doTest("T68",
        "(Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Co Rd 101/Hwy 5, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000324\n\n" +
        "Time reported: 07/18/2013 7:44:13 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Pi Accident-ems",
        "ADDR:Co Rd 101 & Hwy 5",
        "MADDR:COUNTY ROAD 101 & Hwy 5",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000324",
        "DATE:07/18/2013",
        "TIME:07:44:13",
        "UNIT:00000200");

    doTest("T69",
        "(Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000323\n\n" +
        "Time reported: 07/17/2013 10:48:00 AM\n" +
        "Time completed: 07/17/2013 11:04:16 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "carbon monoxide alarm",

        "CALL:RUN REPORT",
        "ID:201300000323",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\nFire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000323\n\nTime reported: 07/17/2013 10:48:00 AM\nTime completed: 07/17/2013 11:04:16 AM\n\nUnit(s) responded: \n00000200\ncarbon monoxide alarm");

    doTest("T70",
        "(Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 514 Laredo Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000323\n\n" +
        "Time reported: 07/17/2013 10:48:00 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "carbon monoxide alarm",

        "CALL:Fire Call-fire",
        "ADDR:514 Laredo Ln",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000323",
        "DATE:07/17/2013",
        "TIME:10:48:00",
        "UNIT:00000200",
        "INFO:carbon monoxide alarm");

    doTest("T71",
        "(Fire Call-fire at 591 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 591 78 St W, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 591 78 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000322\n\n" +
        "Time reported: 07/17/2013 9:31:10 AM\n" +
        "Time completed: 07/17/2013 9:37:25 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Fire Alarm",

        "CALL:RUN REPORT",
        "ID:201300000322",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 591 78 St W, Chanhassen, 55317\n\nFire Call-fire at 591 78 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000322\n\nTime reported: 07/17/2013 9:31:10 AM\nTime completed: 07/17/2013 9:37:25 AM\n\nUnit(s) responded: \n00000200\nFire Alarm");

    doTest("T72",
        "(Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000321\n\n" +
        "Time reported: 07/17/2013 9:23:49 AM\n" +
        "Time completed: 07/17/2013 9:32:54 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000321",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\nFire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\nChanhassen Fire - 201300000321\n\nTime reported: 07/17/2013 9:23:49 AM\nTime completed: 07/17/2013 9:32:54 AM\n\nUnit(s) responded: \n00000200");

    doTest("T73",
        "(Fire Call-fire at 591 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 591 78 St W, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 591 78 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000322\n\n" +
        "Time reported: 07/17/2013 9:31:10 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "Simplex",

        "CALL:Fire Call-fire",
        "ADDR:591 78 St W",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000322",
        "DATE:07/17/2013",
        "TIME:09:31:10",
        "INFO:Simplex");

    doTest("T74",
        "(Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7808 Kerber Blvd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000321\n\n" +
        "Time reported: 07/17/2013 9:23:49 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:7808 Kerber Blvd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000321",
        "DATE:07/17/2013",
        "TIME:09:23:49",
        "UNIT:00000200");

    doTest("T75",
        "(Alarm at 1480 Pembroke Pass, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Alarm at 1480 Pembroke Pass, Chanhassen, 55317\n\n" +
        "Alarm at 1480 Pembroke Pass, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000320\n\n" +
        "Time reported: 07/17/2013 9:11:19 AM\n" +
        "Time completed: 07/17/2013 9:12:13 AM\n\n" +
        "Unit(s) responded: \n" +
        "residential alarm",

        "CALL:RUN REPORT",
        "ID:201300000320",
        "PLACE:Alarm at 1480 Pembroke Pass, Chanhassen, 55317\n\nAlarm at 1480 Pembroke Pass, Chanhassen, 55317\n\nChanhassen Fire - 201300000320\n\nTime reported: 07/17/2013 9:11:19 AM\nTime completed: 07/17/2013 9:12:13 AM\n\nUnit(s) responded: \nresidential alarm");

    doTest("T76",
        "(Assist Other Agency-fire at 131 2 St, Excelsior, ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 131 2 St, Excelsior, \n\n" +
        "Assist Other Agency-fire at 131 2 St, Excelsior, \n\n" +
        "Chanhassen Fire - 201300000319\n\n" +
        "Time reported: 07/16/2013 4:48:07 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "one engine / to a house",

        "CALL:Assist Other Agency-fire",
        "ADDR:131 2 St, Excelsior",
        "SRC:Assist Other Agency-fire at 131 2 St, Excelsior,",
        "DATE:07/16/2013",
        "TIME:16:48:07",
        "UNIT:00000200",
        "INFO:one engine / to a house");

    doTest("T77",
        "(Fire Call-fire at 131 2 St, Excelsior, ) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 131 2 St, Excelsior, \n\n" +
        "Fire Call-fire at 131 2 St, Excelsior, \n\n" +
        "Chanhassen Fire - 201300000319\n\n" +
        "Time reported: 07/16/2013 4:48:07 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "one engine / to a house",

        "CALL:Fire Call-fire",
        "ADDR:131 2 St, Excelsior",
        "SRC:Fire Call-fire at 131 2 St, Excelsior,",
        "DATE:07/16/2013",
        "TIME:16:48:07",
        "UNIT:00000200",
        "INFO:one engine / to a house");

    doTest("T78",
        "(Fire Call-fire at 501 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 501 78 St W, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 501 78 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000318\n\n" +
        "Time reported: 07/16/2013 4:04:13 PM\n" +
        "Time completed: 07/16/2013 4:25:02 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000318",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 501 78 St W, Chanhassen, 55317\n\nFire Call-fire at 501 78 St W, Chanhassen, 55317\n\nChanhassen Fire - 201300000318\n\nTime reported: 07/16/2013 4:04:13 PM\nTime completed: 07/16/2013 4:25:02 PM\n\nUnit(s) responded: \n00000200");

    doTest("T79",
        "(Fire Call-fire at 501 78 St W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 501 78 St W, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 501 78 St W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000318\n\n" +
        "Time reported: 07/16/2013 4:04:13 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:501 78 St W",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000318",
        "DATE:07/16/2013",
        "TIME:16:04:13",
        "UNIT:00000200");

    doTest("T80",
        "(Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\n" +
        "Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000317\n\n" +
        "Time reported: 07/13/2013 9:45:15 AM\n" +
        "Time completed: 07/13/2013 10:01:15 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000201",

        "CALL:RUN REPORT",
        "ID:201300000317",
        "UNIT:00000201",
        "PLACE:Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\nMedical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000317\n\nTime reported: 07/13/2013 9:45:15 AM\nTime completed: 07/13/2013 10:01:15 AM\n\nUnit(s) responded: \n00000201");

    doTest("T81",
        "(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000316\n\n" +
        "Time reported: 07/13/2013 9:38:39 AM\n" +
        "Time completed: 07/13/2013 9:58:28 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "2 vehicle",

        "CALL:RUN REPORT",
        "ID:201300000316",
        "UNIT:00000200",
        "PLACE:Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nPi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\nChanhassen Fire - 201300000316\n\nTime reported: 07/13/2013 9:38:39 AM\nTime completed: 07/13/2013 9:58:28 AM\n\nUnit(s) responded: \n00000200\n2 vehicle");

    doTest("T82",
        "(Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\n" +
        "Medical-ems at 9355 Kiowa Trl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000317\n\n" +
        "Time reported: 07/13/2013 9:45:15 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000201",

        "CALL:Medical-ems",
        "ADDR:9355 Kiowa Trl",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000317",
        "DATE:07/13/2013",
        "TIME:09:45:15",
        "UNIT:00000201");

    doTest("T83",
        "(Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Pi Accident-ems at Co Rd 61/Hwy 101, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000316\n\n" +
        "Time reported: 07/13/2013 9:38:39 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "2 vehicle",

        "CALL:Pi Accident-ems",
        "ADDR:Co Rd 61 & Hwy 101",
        "MADDR:COUNTY ROAD 61 & Hwy 101",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000316",
        "DATE:07/13/2013",
        "TIME:09:38:39",
        "UNIT:00000200",
        "INFO:2 vehicle");

    doTest("T84",
        "(Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000315\n\n" +
        "Time reported: 07/13/2013 7:33:21 AM\n" +
        "Time completed: 07/13/2013 8:04:57 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000315",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\nFire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\nChanhassen Fire - 201300000315\n\nTime reported: 07/13/2013 7:33:21 AM\nTime completed: 07/13/2013 8:04:57 AM\n\nUnit(s) responded: \n00000200");

    doTest("T85",
        "(Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 2178 Red Fox Cir, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000315\n\n" +
        "Time reported: 07/13/2013 7:33:21 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Fire Call-fire",
        "ADDR:2178 Red Fox Cir",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000315",
        "DATE:07/13/2013",
        "TIME:07:33:21",
        "UNIT:00000200");

    doTest("T86",
        "(Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000314\n\n" +
        "Time reported: 07/13/2013 6:03:34 AM\n" +
        "Time completed: 07/13/2013 6:30:05 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Arching and sparking",

        "CALL:RUN REPORT",
        "ID:201300000314",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\nFire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000314\n\nTime reported: 07/13/2013 6:03:34 AM\nTime completed: 07/13/2013 6:30:05 AM\n\nUnit(s) responded: \n00000200\nArching and sparking");

    doTest("T87",
        "(Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 6891 Utica Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000314\n\n" +
        "Time reported: 07/13/2013 6:03:34 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "Arching and sparking",

        "CALL:Fire Call-fire",
        "ADDR:6891 Utica Ln",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000314",
        "DATE:07/13/2013",
        "TIME:06:03:34",
        "INFO:Arching and sparking");

    doTest("T88",
        "(Medical-ems at 7339 Frontier Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\n" +
        "Medical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000313\n\n" +
        "Time reported: 07/12/2013 9:56:18 AM\n" +
        "Time completed: 07/12/2013 10:18:01 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000313",
        "UNIT:00000200",
        "PLACE:Medical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\nMedical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\nChanhassen Fire - 201300000313\n\nTime reported: 07/12/2013 9:56:18 AM\nTime completed: 07/12/2013 10:18:01 AM\n\nUnit(s) responded: \n00000200");

    doTest("T89",
        "(Medical-ems at 7339 Frontier Trl, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\n" +
        "Medical-ems at 7339 Frontier Trl, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000313\n\n" +
        "Time reported: 07/12/2013 9:56:18 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:7339 Frontier Trl",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000313",
        "DATE:07/12/2013",
        "TIME:09:56:18",
        "UNIT:00000200");

    doTest("T90",
        "(Call Error at , , ) Notification from CIS Active 911:\n\n" +
        "Call Error at , , \n\n" +
        "Call Error at , , \n\n" +
        "Chanhassen Fire - 201300000312\n\n" +
        "Time reported: 07/11/2013 6:23:12 PM\n" +
        "Time completed: 07/11/2013 6:34:20 PM\n\n" +
        "Unit(s) responded: \n" +
        "2B893",

        "CALL:RUN REPORT",
        "ID:201300000312",
        "PLACE:Call Error at , , \n\nCall Error at , , \n\nChanhassen Fire - 201300000312\n\nTime reported: 07/11/2013 6:23:12 PM\nTime completed: 07/11/2013 6:34:20 PM\n\nUnit(s) responded: \n2B893");

    doTest("T91",
        "(Fire Call at 6200 Cascade Pass, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call at 6200 Cascade Pass, Chanhassen, 55317\n\n" +
        "Fire Call at 6200 Cascade Pass, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000312\n\n" +
        "Time reported: 07/11/2013 6:23:12 PM\n\n\n" +
        "Unit(s) responded: ",

        "CALL:Fire Call",
        "ADDR:6200 Cascade Pass",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000312",
        "DATE:07/11/2013",
        "TIME:18:23:12");

    doTest("T92",
        "(Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000311\n\n" +
        "Time reported: 07/11/2013 3:32:39 PM\n" +
        "Time completed: 07/11/2013 3:41:22 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Aromr",

        "CALL:RUN REPORT",
        "ID:201300000311",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\nFire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000311\n\nTime reported: 07/11/2013 3:32:39 PM\nTime completed: 07/11/2013 3:41:22 PM\n\nUnit(s) responded: \n00000200\nAromr");

    doTest("T93",
        "(Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 8000 Audubon Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000311\n\n" +
        "Time reported: 07/11/2013 3:32:39 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Aromr",

        "CALL:Fire Call-fire",
        "ADDR:8000 Audubon Rd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000311",
        "DATE:07/11/2013",
        "TIME:15:32:39",
        "UNIT:00000200",
        "INFO:Aromr");

    doTest("T94",
        "(Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000310\n\n" +
        "Time reported: 07/11/2013 11:43:10 AM\n" +
        "Time completed: 07/11/2013 1:06:47 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Gas line break",

        "CALL:RUN REPORT",
        "ID:201300000310",
        "UNIT:00000200",
        "PLACE:Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\nFire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\nChanhassen Fire - 201300000310\n\nTime reported: 07/11/2013 11:43:10 AM\nTime completed: 07/11/2013 1:06:47 PM\n\nUnit(s) responded: \n00000200\nGas line break");

    doTest("T95",
        "(Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\n" +
        "Fire Call-fire at 7101 Tecumseh Ln, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000310\n\n" +
        "Time reported: 07/11/2013 11:43:10 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200\n" +
        "Gas line break",

        "CALL:Fire Call-fire",
        "ADDR:7101 Tecumseh Ln",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000310",
        "DATE:07/11/2013",
        "TIME:11:43:10",
        "UNIT:00000200",
        "INFO:Gas line break");

    doTest("T96",
        "(Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000309\n\n" +
        "Time reported: 07/10/2013 12:25:40 PM\n" +
        "Time completed: 07/10/2013 12:48:39 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000309",
        "UNIT:00000200",
        "PLACE:Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\nMedical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\nChanhassen Fire - 201300000309\n\nTime reported: 07/10/2013 12:25:40 PM\nTime completed: 07/10/2013 12:48:39 PM\n\nUnit(s) responded: \n00000200");

    doTest("T97",
        "(Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\n" +
        "Medical-ems at 3675 Arboretum Dr, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000309\n\n" +
        "Time reported: 07/10/2013 12:25:40 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:3675 Arboretum Dr",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000309",
        "DATE:07/10/2013",
        "TIME:12:25:40",
        "UNIT:00000200");

    doTest("T98",
        "(Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\n" +
        "Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000308\n\n" +
        "Time reported: 07/10/2013 6:53:10 AM\n" +
        "Time completed: 07/10/2013 7:21:55 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000308",
        "UNIT:00000200",
        "PLACE:Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\nMedical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\nChanhassen Fire - 201300000308\n\nTime reported: 07/10/2013 6:53:10 AM\nTime completed: 07/10/2013 7:21:55 AM\n\nUnit(s) responded: \n00000200");

    doTest("T99",
        "(Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\n" +
        "Medical-ems at 6341 Murray Hill Rd, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000308\n\n" +
        "Time reported: 07/10/2013 6:53:10 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:Medical-ems",
        "ADDR:6341 Murray Hill Rd",
        "CITY:Chanhassen",
        "SRC:Chanhassen Fire",
        "ID:201300000308",
        "DATE:07/10/2013",
        "TIME:06:53:10",
        "UNIT:00000200");

    doTest("T100",
        "(Medical-ems at 1321 Lake Dr W, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1321 Lake Dr W, Chanhassen, 55317\n\n" +
        "Medical-ems at 1321 Lake Dr W, Chanhassen, 55317\n\n" +
        "Chanhassen Fire - 201300000307\n\n" +
        "Time reported: 07/09/2013 11:24:48 AM\n" +
        "Time completed: 07/09/2013 12:01:54 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000200",

        "CALL:RUN REPORT",
        "ID:201300000307",
        "UNIT:00000200",
        "PLACE:Medical-ems at 1321 Lake Dr W, Chanhassen, 55317\n\nMedical-ems at 1321 Lake Dr W, Chanhassen, 55317\n\nChanhassen Fire - 201300000307\n\nTime reported: 07/09/2013 11:24:48 AM\nTime completed: 07/09/2013 12:01:54 PM\n\nUnit(s) responded: \n00000200");
 
  }
  @Test
  public void testChaska() {

    doTest("T1",
        "(Medical-ems at 2156 Stahlke Way, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2156 Stahlke Way, Chaska, 55318\n\n" +
        "Medical-ems at 2156 Stahlke Way, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000287\n\n" +
        "Time reported: 08/22/2013 8:47:19 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:2156 Stahlke Way",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000287",
        "DATE:08/22/2013",
        "TIME:08:47:19",
        "UNIT:00000300");

    doTest("T2",
        "(Medical-ems at 1105 Timber Cir, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1105 Timber Cir, Chaska, 55318\n\n" +
        "Medical-ems at 1105 Timber Cir, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000286\n\n" +
        "Time reported: 08/20/2013 9:04:12 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:1105 Timber Cir",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000286",
        "DATE:08/20/2013",
        "TIME:21:04:12",
        "UNIT:00000300");

    doTest("T3",
        "(Medical-ems at 262 Riverview Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 262 Riverview Rd, Chaska, 55318\n\n" +
        "Medical-ems at 262 Riverview Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000285\n\n" +
        "Time reported: 08/19/2013 4:05:04 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:262 Riverview Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000285",
        "DATE:08/19/2013",
        "TIME:16:05:04",
        "UNIT:00000300");

    doTest("T4",
        "(Fire Call-fire at 908 Yellow Brick Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 908 Yellow Brick Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 908 Yellow Brick Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000284\n\n" +
        "Time reported: 08/19/2013 6:16:39 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "smoke in residence from burnt cheese",

        "CALL:Fire Call-fire",
        "ADDR:908 Yellow Brick Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000284",
        "DATE:08/19/2013",
        "TIME:06:16:39",
        "UNIT:00000300",
        "INFO:smoke in residence from burnt cheese");

    doTest("T5",
        "(Assist Other Agency-fire at 7950 Zinnia St, Victoria, 55387) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 7950 Zinnia St, Victoria, 55387\n\n" +
        "Assist Other Agency-fire at 7950 Zinnia St, Victoria, 55387\n\n" +
        "Chaska Fire - 201300000283\n\n" +
        "Time reported: 08/18/2013 2:26:04 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "1 mile west / on shore of lake auburn / utility barn /",

        "CALL:Assist Other Agency-fire",
        "ADDR:7950 Zinnia St",
        "CITY:Victoria",
        "SRC:Chaska Fire",
        "ID:201300000283",
        "DATE:08/18/2013",
        "TIME:14:26:04",
        "INFO:1 mile west / on shore of lake auburn / utility barn /");

    doTest("T6",
        "(Fire Call-fire at 110400 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 110400 Pioneer Trl W, Chaska, 55318\n\n" +
        "Fire Call-fire at 110400 Pioneer Trl W, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000282\n\n" +
        "Time reported: 08/17/2013 8:50:53 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:110400 Pioneer Trl W", // did not map, but 110 pioneer trail maps well
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000282",
        "DATE:08/17/2013",
        "TIME:20:50:53",
        "UNIT:00000300");

    doTest("T7",
        "(Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000281\n\n" +
        "Time reported: 08/17/2013 9:37:30 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:1661 Park Ridge Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000281",
        "DATE:08/17/2013",
        "TIME:09:37:30",
        "UNIT:00000300");

    doTest("T8",
        "(Medical-ems at 407 Oak St N, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 407 Oak St N, Chaska, 55318\n\n" +
        "Medical-ems at 407 Oak St N, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000280\n\n" +
        "Time reported: 08/14/2013 11:51:03 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:407 Oak St N",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000280",
        "DATE:08/14/2013",
        "TIME:11:51:03",
        "UNIT:00000300");

    doTest("T9",
        "(Call Error at , , ) Notification from CIS Active 911:\n\n" +
        "Call Error at , , \n\n" +
        "Call Error at , , \n\n" +
        "Chaska Fire - 201300000279\n\n" +
        "Time reported: 08/12/2013 6:58:49 PM\n" +
        "Time completed: 08/12/2013 6:59:21 PM\n\n" +
        "Unit(s) responded: ",

        "CALL:RUN REPORT",
        "ID:201300000279",
        "PLACE:Call Error at , , \n\nCall Error at , , \n\nChaska Fire - 201300000279\n\nTime reported: 08/12/2013 6:58:49 PM\nTime completed: 08/12/2013 6:59:21 PM\n\nUnit(s) responded:");

    doTest("T10",
        "(Fire Call-fire at 111 Pioneer Trl E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 111 Pioneer Trl E, Chaska, 55318\n\n" +
        "Fire Call-fire at 111 Pioneer Trl E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000278\n\n" +
        "Time reported: 08/12/2013 6:57:05 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:111 Pioneer Trl E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000278",
        "DATE:08/12/2013",
        "TIME:18:57:05",
        "UNIT:00000300");

    doTest("T11",
        "(Medical-ems at 56 Judith Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 56 Judith Dr, Chaska, 55318\n\n" +
        "Medical-ems at 56 Judith Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000277\n\n" +
        "Time reported: 08/11/2013 10:45:40 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:56 Judith Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000277",
        "DATE:08/11/2013",
        "TIME:22:45:40",
        "UNIT:00000300");

    doTest("T12",
        "(Fire Call-fire at 954 Walnut Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 954 Walnut Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 954 Walnut Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000276\n\n" +
        "Time reported: 08/11/2013 1:06:33 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:954 Walnut Ct",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000276",
        "DATE:08/11/2013",
        "TIME:13:06:33",
        "UNIT:00000300");

    doTest("T13",
        "(Fire Call-fire at 2505 Woodcrest Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2505 Woodcrest Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 2505 Woodcrest Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000275\n\n" +
        "Time reported: 08/11/2013 1:11:44 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:2505 Woodcrest Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000275",
        "DATE:08/11/2013",
        "TIME:01:11:44",
        "UNIT:00000300");

    doTest("T14",
        "(Medical-ems at 2914 Hilltop Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 2914 Hilltop Dr, Chaska, 55318\n\n" +
        "Medical-ems at 2914 Hilltop Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000274\n\n" +
        "Time reported: 08/10/2013 9:25:31 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:2914 Hilltop Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000274",
        "DATE:08/10/2013",
        "TIME:09:25:31",
        "UNIT:00000300");

    doTest("T15",
        "(Fire Call-fire at 1424 Crest Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1424 Crest Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 1424 Crest Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000272\n\n" +
        "Time reported: 08/08/2013 3:50:38 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:1424 Crest Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000272",
        "DATE:08/08/2013",
        "TIME:15:50:38",
        "UNIT:00000300");

    doTest("T16",
        "(Assist Other Agency-fire at , , ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at , , \n\n" +
        "Assist Other Agency-fire at , , \n\n" +
        "Chaska Fire - 201300000271\n\n" +
        "Time reported: 08/06/2013 7:25:31 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "tornado watch #474",

        "CALL:Assist Other Agency-fire",
        "SRC:Assist Other Agency-fire at , ,",
        "DATE:08/06/2013",
        "TIME:19:25:31",
        "UNIT:00000300",
        "INFO:tornado watch #474");

    doTest("T17",
        "(Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000270\n\n" +
        "Time reported: 08/06/2013 8:40:57 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:114000 Hundertmark Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000270",
        "DATE:08/06/2013",
        "TIME:08:40:57",
        "UNIT:00000300");

    doTest("T18",
        "(Fire Call-fire at 3842 Pascolo Bend, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3842 Pascolo Bend, Chaska, 55318\n\n" +
        "Fire Call-fire at 3842 Pascolo Bend, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000269\n\n" +
        "Time reported: 08/05/2013 5:36:24 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000301",

        "CALL:Fire Call-fire",
        "ADDR:3842 Pascolo Bend", // not mapping but found 3818 pascolo bend
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000269",
        "DATE:08/05/2013",
        "TIME:05:36:24",
        "UNIT:00000301");

    doTest("T19",
        "(Assist Other Agency-fire at 10275 Co Rd 140, Benton Twp, 55387) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 10275 Co Rd 140, Benton Twp, 55387\n\n" +
        "Assist Other Agency-fire at 10275 Co Rd 140, Benton Twp, 55387\n\n" +
        "Chaska Fire - 201300000268\n\n" +
        "Time reported: 08/05/2013 5:15:08 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Assist Other Agency-fire",
        "ADDR:10275 Co Rd 140",
        "MADDR:10275 COUNTY ROAD 140", // not found
        "CITY:Benton Twp",
        "SRC:Chaska Fire",
        "ID:201300000268",
        "DATE:08/05/2013",
        "TIME:05:15:08",
        "UNIT:00000300");

    doTest("T20",
        "(Pi Accident-ems at Bavaria Rd/Pioneer Trl, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Bavaria Rd/Pioneer Trl, Chaska, 55318\n\n" +
        "Pi Accident-ems at Bavaria Rd/Pioneer Trl, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000267\n\n" +
        "Time reported: 08/03/2013 2:20:31 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Pi Accident-ems",
        "ADDR:Bavaria Rd & Pioneer Trl",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000267",
        "DATE:08/03/2013",
        "TIME:14:20:31",
        "UNIT:00000300");

    doTest("T21",
        "(Medical-ems at 501 Oak St N, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 501 Oak St N, Chaska, 55318\n\n" +
        "Medical-ems at 501 Oak St N, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000266\n\n" +
        "Time reported: 08/03/2013 8:30:11 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:501 Oak St N",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000266",
        "DATE:08/03/2013",
        "TIME:08:30:11",
        "UNIT:00000300");

    doTest("T22",
        "(Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 114000 Hundertmark Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000265\n\n" +
        "Time reported: 08/02/2013 7:31:32 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:114000 Hundertmark Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000265",
        "DATE:08/02/2013",
        "TIME:19:31:32",
        "UNIT:00000300");

    doTest("T23",
        "(Pi Accident-ems at Hwy 41/Hundertmark Rd W, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 41/Hundertmark Rd W, Chaska, 55318\n\n" +
        "Pi Accident-ems at Hwy 41/Hundertmark Rd W, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000264\n\n" +
        "Time reported: 08/02/2013 9:48:33 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Pi Accident-ems",
        "ADDR:Hwy 41 & Hundertmark Rd W",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000264",
        "DATE:08/02/2013",
        "TIME:09:48:33",
        "UNIT:00000300");

    doTest("T24",
        "(Medical-ems at 32 Rita Ln, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 32 Rita Ln, Chaska, 55318\n\n" +
        "Medical-ems at 32 Rita Ln, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000263\n\n" +
        "Time reported: 08/01/2013 12:38:38 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:32 Rita Ln",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000263",
        "DATE:08/01/2013",
        "TIME:12:38:38",
        "UNIT:00000300");

    doTest("T25",
        "(Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\n" +
        "Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000262\n\n" +
        "Time reported: 08/01/2013 12:01:44 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:110300 Pioneer Trl W",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000262",
        "DATE:08/01/2013",
        "TIME:12:01:44",
        "UNIT:00000300");

    doTest("T26",
        "(Fire Call-fire at 1424 Crest Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1424 Crest Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 1424 Crest Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000261\n\n" +
        "Time reported: 07/31/2013 7:16:14 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:1424 Crest Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000261",
        "DATE:07/31/2013",
        "TIME:07:16:14",
        "UNIT:00000300");

    doTest("T27",
        "(Fire Call-fire at 709 Laura Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 709 Laura Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 709 Laura Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000260\n\n" +
        "Time reported: 07/30/2013 11:52:41 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "veh fire / in street /",

        "CALL:Fire Call-fire",
        "ADDR:709 Laura Ct",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000260",
        "DATE:07/30/2013",
        "TIME:23:52:41",
        "UNIT:00000300",
        "INFO:veh fire / in street /");

    doTest("T28",
        "(Medical-ems at 1908 Shamrock Pl, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1908 Shamrock Pl, Chaska, 55318\n\n" +
        "Medical-ems at 1908 Shamrock Pl, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000259\n\n" +
        "Time reported: 07/30/2013 6:12:26 AM\n" +
        "Time completed: 07/30/2013 6:40:33 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000259",
        "UNIT:00000300",
        "PLACE:Medical-ems at 1908 Shamrock Pl, Chaska, 55318\n\nMedical-ems at 1908 Shamrock Pl, Chaska, 55318\n\nChaska Fire - 201300000259\n\nTime reported: 07/30/2013 6:12:26 AM\nTime completed: 07/30/2013 6:40:33 AM\n\nUnit(s) responded: \n00000300");

    doTest("T29",
        "(Medical-ems at 1908 Shamrock Pl, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1908 Shamrock Pl, Chaska, 55318\n\n" +
        "Medical-ems at 1908 Shamrock Pl, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000259\n\n" +
        "Time reported: 07/30/2013 6:12:26 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:1908 Shamrock Pl",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000259",
        "DATE:07/30/2013",
        "TIME:06:12:26",
        "UNIT:00000300");

    doTest("T30",
        "(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000258\n\n" +
        "Time reported: 07/29/2013 8:43:26 PM\n" +
        "Time completed: 07/29/2013 9:27:43 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000258",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nChaska Fire - 201300000258\n\nTime reported: 07/29/2013 8:43:26 PM\nTime completed: 07/29/2013 9:27:43 PM\n\nUnit(s) responded: \n00000300");

    doTest("T31",
        "(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000258\n\n" +
        "Time reported: 07/29/2013 8:43:26 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:3000 Chestnut St N",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000258",
        "DATE:07/29/2013",
        "TIME:20:43:26",
        "UNIT:00000300");

    doTest("T32",
        "(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000257\n\n" +
        "Time reported: 07/29/2013 10:47:53 AM\n" +
        "Time completed: 07/29/2013 11:15:40 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000257",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nChaska Fire - 201300000257\n\nTime reported: 07/29/2013 10:47:53 AM\nTime completed: 07/29/2013 11:15:40 AM\n\nUnit(s) responded: \n00000300");

    doTest("T33",
        "(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000257\n\n" +
        "Time reported: 07/29/2013 10:47:53 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:2876 Fairway Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000257",
        "DATE:07/29/2013",
        "TIME:10:47:53",
        "UNIT:00000300");

    doTest("T34",
        "(Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\n" +
        "Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000256\n\n" +
        "Time reported: 07/26/2013 10:21:42 PM\n" +
        "Time completed: 07/27/2013 12:10:42 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000256",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nFire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\nChaska Fire - 201300000256\n\nTime reported: 07/26/2013 10:21:42 PM\nTime completed: 07/27/2013 12:10:42 AM\n\nUnit(s) responded: \n00000300");

    doTest("T35",
        "(Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\n" +
        "Fire Call-fire at 110300 Pioneer Trl W, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000256\n\n" +
        "Time reported: 07/26/2013 10:21:42 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "simplex 8887467539 / gen fire /",

        "CALL:Fire Call-fire",
        "ADDR:110300 Pioneer Trl W",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000256",
        "DATE:07/26/2013",
        "TIME:22:21:42",
        "UNIT:00000300",
        "INFO:simplex 8887467539 / gen fire /");

    doTest("T36",
        "(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000255\n\n" +
        "Time reported: 07/26/2013 10:10:13 AM\n" +
        "Time completed: 07/26/2013 10:53:06 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "fire Alarm",

        "CALL:RUN REPORT",
        "ID:201300000255",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nFire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\nChaska Fire - 201300000255\n\nTime reported: 07/26/2013 10:10:13 AM\nTime completed: 07/26/2013 10:53:06 AM\n\nUnit(s) responded: \n00000300\nfire Alarm");

    doTest("T37",
        "(Fire Call-fire at 3000 Chestnut St N, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Fire Call-fire at 3000 Chestnut St N, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000255\n\n" +
        "Time reported: 07/26/2013 10:10:13 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "fire Alarm",

        "CALL:Fire Call-fire",
        "ADDR:3000 Chestnut St N",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000255",
        "DATE:07/26/2013",
        "TIME:10:10:13",
        "UNIT:00000300",
        "INFO:fire Alarm");

    doTest("T38",
        "(Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\n" +
        "Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\n" +
        "Chaska Fire - 201300000254\n\n" +
        "Time reported: 07/25/2013 5:17:10 AM\n" +
        "Time completed: 07/25/2013 12:06:27 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000254",
        "UNIT:00000300",
        "PLACE:Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nAssist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\nChaska Fire - 201300000254\n\nTime reported: 07/25/2013 5:17:10 AM\nTime completed: 07/25/2013 12:06:27 PM\n\nUnit(s) responded: \n00000300");

    doTest("T39",
        "(Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\n" +
        "Assist Other Agency-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\n" +
        "Chaska Fire - 201300000254\n\n" +
        "Time reported: 07/25/2013 5:17:10 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Assist Other Agency-fire",
        "ADDR:8260 Maplewood Rd",
        "CITY:Dahlgren Twp",
        "SRC:Chaska Fire",
        "ID:201300000254",
        "DATE:07/25/2013",
        "TIME:05:17:10",
        "UNIT:00000300");

    doTest("T40",
        "(Fire Call-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\n" +
        "Fire Call-fire at 8260 Maplewood Rd, Dahlgren Twp, 55322\n\n" +
        "Chaska Fire - 201300000254\n\n" +
        "Time reported: 07/25/2013 5:17:10 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:8260 Maplewood Rd",
        "CITY:Dahlgren Twp",
        "SRC:Chaska Fire",
        "ID:201300000254",
        "DATE:07/25/2013",
        "TIME:05:17:10",
        "UNIT:00000300");

    doTest("T41",
        "(Call Error at , , 55317) Notification from CIS Active 911:\n\n" +
        "Call Error at , , 55317\n\n" +
        "Call Error at , , 55317\n\n" +
        "Chaska Fire - 201300000253\n\n" +
        "Time reported: 07/24/2013 11:30:56 PM\n" +
        "Time completed: 07/24/2013 11:32:47 PM\n\n" +
        "Unit(s) responded: \n" +
        "00001404",

        "CALL:RUN REPORT",
        "ID:201300000253",
        "UNIT:00001404",
        "PLACE:Call Error at , , 55317\n\nCall Error at , , 55317\n\nChaska Fire - 201300000253\n\nTime reported: 07/24/2013 11:30:56 PM\nTime completed: 07/24/2013 11:32:47 PM\n\nUnit(s) responded: \n00001404");

    doTest("T42",
        "(Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000252\n\n" +
        "Time reported: 07/24/2013 4:53:50 PM\n" +
        "Time completed: 07/24/2013 5:41:37 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "Road hazzard/",

        "CALL:RUN REPORT",
        "ID:201300000252",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\nFire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\nChaska Fire - 201300000252\n\nTime reported: 07/24/2013 4:53:50 PM\nTime completed: 07/24/2013 5:41:37 PM\n\nUnit(s) responded: \n00000300\nRoad hazzard/");

    doTest("T43",
        "(Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at Walden Dr/Clover Ridge Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000252\n\n" +
        "Time reported: 07/24/2013 4:53:50 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "Road hazzard/",

        "CALL:Fire Call-fire",
        "ADDR:Walden Dr & Clover Ridge Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000252",
        "DATE:07/24/2013",
        "TIME:16:53:50",
        "UNIT:00000300",
        "INFO:Road hazzard/");

    doTest("T44",
        "(Fire Call-fire at 1 River Bend Pl, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1 River Bend Pl, Chaska, 55318\n\n" +
        "Fire Call-fire at 1 River Bend Pl, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000251\n\n" +
        "Time reported: 07/23/2013 9:20:10 PM\n" +
        "Time completed: 07/23/2013 9:34:42 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "bonfire in woods / near river / behind the best western / also near the boat landing on the chaska side of river /",

        "CALL:RUN REPORT",
        "ID:201300000251",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 1 River Bend Pl, Chaska, 55318\n\nFire Call-fire at 1 River Bend Pl, Chaska, 55318\n\nChaska Fire - 201300000251\n\nTime reported: 07/23/2013 9:20:10 PM\nTime completed: 07/23/2013 9:34:42 PM\n\nUnit(s) responded: \n00000300\nbonfire in woods / near river / behind the best western / also near the boat landing on the chaska side of river /");

    doTest("T45",
        "(Fire Call-fire at 1 River Bend Pl, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1 River Bend Pl, Chaska, 55318\n\n" +
        "Fire Call-fire at 1 River Bend Pl, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000251\n\n" +
        "Time reported: 07/23/2013 9:20:10 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "bonfire in woods / near river / behind the best western / also near the boat landing on the chaska side of river /",

        "CALL:Fire Call-fire",
        "ADDR:1 River Bend Pl",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000251",
        "DATE:07/23/2013",
        "TIME:21:20:10",
        "UNIT:00000300",
        "INFO:bonfire in woods / near river / behind the best western / also near the boat landing on the chaska side of river /");

    doTest("T46",
        "(Fire Call-fire at 4004 Peavey Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000250\n\n" +
        "Time reported: 07/22/2013 11:57:19 PM\n" +
        "Time completed: 07/23/2013 1:05:50 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000250",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\nFire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\nChaska Fire - 201300000250\n\nTime reported: 07/22/2013 11:57:19 PM\nTime completed: 07/23/2013 1:05:50 AM\n\nUnit(s) responded: \n00000300");

    doTest("T47",
        "(Fire Call-fire at 4004 Peavey Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 4004 Peavey Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000250\n\n" +
        "Time reported: 07/22/2013 11:57:19 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:4004 Peavey Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000250",
        "DATE:07/22/2013",
        "TIME:23:57:19",
        "UNIT:00000300");

    doTest("T48",
        "(Fire Call-fire at 2660 Christian Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2660 Christian Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 2660 Christian Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000249\n\n" +
        "Time reported: 07/22/2013 11:26:32 AM\n" +
        "Time completed: 07/22/2013 11:36:56 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "fire alarm",

        "CALL:RUN REPORT",
        "ID:201300000249",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 2660 Christian Ct, Chaska, 55318\n\nFire Call-fire at 2660 Christian Ct, Chaska, 55318\n\nChaska Fire - 201300000249\n\nTime reported: 07/22/2013 11:26:32 AM\nTime completed: 07/22/2013 11:36:56 AM\n\nUnit(s) responded: \n00000300\nfire alarm");

    doTest("T49",
        "(Fire Call-fire at 2660 Christian Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2660 Christian Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 2660 Christian Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000249\n\n" +
        "Time reported: 07/22/2013 11:26:32 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "fire alarm",

        "CALL:Fire Call-fire",
        "ADDR:2660 Christian Ct",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000249",
        "DATE:07/22/2013",
        "TIME:11:26:32",
        "UNIT:00000300",
        "INFO:fire alarm");

    doTest("T50",
        "(Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\n" +
        "Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000248\n\n" +
        "Time reported: 07/21/2013 11:37:22 PM\n" +
        "Time completed: 07/22/2013 12:01:42 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000248",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\nFire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\nChaska Fire - 201300000248\n\nTime reported: 07/21/2013 11:37:22 PM\nTime completed: 07/22/2013 12:01:42 AM\n\nUnit(s) responded: \n00000300");

    doTest("T51",
        "(Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\n" +
        "Fire Call-fire at 2485 Christian Pkwy, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000248\n\n" +
        "Time reported: 07/21/2013 11:37:22 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:2485 Christian Pkwy",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000248",
        "DATE:07/21/2013",
        "TIME:23:37:22",
        "UNIT:00000300");

    doTest("T52",
        "(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000247\n\n" +
        "Time reported: 07/21/2013 7:45:39 AM\n" +
        "Time completed: 07/21/2013 9:52:39 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "house struck by lightening",

        "CALL:RUN REPORT",
        "ID:201300000247",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nFire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\nChaska Fire - 201300000247\n\nTime reported: 07/21/2013 7:45:39 AM\nTime completed: 07/21/2013 9:52:39 AM\n\nUnit(s) responded: \n00000300\nhouse struck by lightening");

    doTest("T53",
        "(Fire Call-fire at 2876 Fairway Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 2876 Fairway Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000247\n\n" +
        "Time reported: 07/21/2013 7:45:39 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "house struck by lightening",

        "CALL:Fire Call-fire",
        "ADDR:2876 Fairway Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000247",
        "DATE:07/21/2013",
        "TIME:07:45:39",
        "UNIT:00000300",
        "INFO:house struck by lightening");

    doTest("T54",
        "(Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\n" +
        "Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\n" +
        "Chaska Fire - 201300000246\n\n" +
        "Time reported: 07/20/2013 2:37:51 AM\n" +
        "Time completed: 07/20/2013 3:43:23 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000246",
        "UNIT:00000300",
        "PLACE:Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\nAssist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\nChaska Fire - 201300000246\n\nTime reported: 07/20/2013 2:37:51 AM\nTime completed: 07/20/2013 3:43:23 AM\n\nUnit(s) responded: \n00000300");

    doTest("T55",
        "(Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\n" +
        "Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp, \n\n" +
        "Chaska Fire - 201300000246\n\n" +
        "Time reported: 07/20/2013 2:37:51 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Assist Other Agency-fire",
        "ADDR:3736 Akers Ln, Sand Creek Twnshp",
        "SRC:Assist Other Agency-fire at 3736 Akers Ln, Sand Creek Twnshp,",
        "DATE:07/20/2013",
        "TIME:02:37:51",
        "UNIT:00000300");

    doTest("T56",
        "(Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000245\n\n" +
        "Time reported: 07/19/2013 9:58:15 PM\n" +
        "Time completed: 07/19/2013 10:16:15 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "front desk",

        "CALL:RUN REPORT",
        "ID:201300000245",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nFire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\nChaska Fire - 201300000245\n\nTime reported: 07/19/2013 9:58:15 PM\nTime completed: 07/19/2013 10:16:15 PM\n\nUnit(s) responded: \n00000300\nfront desk");

    doTest("T57",
        "(Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 1661 Park Ridge Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000245\n\n" +
        "Time reported: 07/19/2013 9:58:15 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "front desk",

        "CALL:Fire Call-fire",
        "ADDR:1661 Park Ridge Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000245",
        "DATE:07/19/2013",
        "TIME:21:58:15",
        "UNIT:00000300",
        "INFO:front desk");

    doTest("T58",
        "(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000244\n\n" +
        "Time reported: 07/17/2013 5:59:07 PM\n" +
        "Time completed: 07/17/2013 6:01:40 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "elev 1 / floor 2went down /rhemotid artheritis 52 yo",

        "CALL:RUN REPORT",
        "ID:201300000244",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000244\n\nTime reported: 07/17/2013 5:59:07 PM\nTime completed: 07/17/2013 6:01:40 PM\n\nUnit(s) responded: \n00000300\nelev 1 / floor 2went down /rhemotid artheritis 52 yo");

    doTest("T59",
        "(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000244\n\n" +
        "Time reported: 07/17/2013 5:59:07 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "elev 1 / floor 2went down /rhemotid artheritis 52 yo",

        "CALL:Fire Call-fire",
        "ADDR:111 Hundertmark Rd E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000244",
        "DATE:07/17/2013",
        "TIME:17:59:07",
        "INFO:elev 1 / floor 2went down /rhemotid artheritis 52 yo");

    doTest("T60",
        "(Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\n" +
        "Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000243\n\n" +
        "Time reported: 07/16/2013 9:48:24 PM\n" +
        "Time completed: 07/16/2013 10:02:23 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000243",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\nFire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\nChaska Fire - 201300000243\n\nTime reported: 07/16/2013 9:48:24 PM\nTime completed: 07/16/2013 10:02:23 PM\n\nUnit(s) responded: \n00000300");

    doTest("T61",
        "(Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\n" +
        "Fire Call-fire at 3515 Lyman Blvd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000243\n\n" +
        "Time reported: 07/16/2013 9:48:24 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:3515 Lyman Blvd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000243",
        "DATE:07/16/2013",
        "TIME:21:48:24",
        "UNIT:00000300");

    doTest("T62",
        "(Fire Call-fire at 401 4 St E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 401 4 St E, Chaska, 55318\n\n" +
        "Fire Call-fire at 401 4 St E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000242\n\n" +
        "Time reported: 07/16/2013 6:51:26 AM\n" +
        "Time completed: 07/16/2013 7:05:49 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000242",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 401 4 St E, Chaska, 55318\n\nFire Call-fire at 401 4 St E, Chaska, 55318\n\nChaska Fire - 201300000242\n\nTime reported: 07/16/2013 6:51:26 AM\nTime completed: 07/16/2013 7:05:49 AM\n\nUnit(s) responded: \n00000300");

    doTest("T63",
        "(Fire Call-fire at 401 4 St E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 401 4 St E, Chaska, 55318\n\n" +
        "Fire Call-fire at 401 4 St E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000242\n\n" +
        "Time reported: 07/16/2013 6:51:26 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:401 4 St E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000242",
        "DATE:07/16/2013",
        "TIME:06:51:26",
        "UNIT:00000300");

    doTest("T64",
        "(Fire Call-fire at 1108 Village Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1108 Village Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 1108 Village Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000241\n\n" +
        "Time reported: 07/15/2013 4:43:07 PM\n" +
        "Time completed: 07/15/2013 5:03:41 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000241",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 1108 Village Rd, Chaska, 55318\n\nFire Call-fire at 1108 Village Rd, Chaska, 55318\n\nChaska Fire - 201300000241\n\nTime reported: 07/15/2013 4:43:07 PM\nTime completed: 07/15/2013 5:03:41 PM\n\nUnit(s) responded: \n00000300");

    doTest("T65",
        "(Fire Call-fire at 1108 Village Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1108 Village Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 1108 Village Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000241\n\n" +
        "Time reported: 07/15/2013 4:43:07 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:1108 Village Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000241",
        "DATE:07/15/2013",
        "TIME:16:43:07",
        "UNIT:00000300");

    doTest("T66",
        "(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000240\n\n" +
        "Time reported: 07/15/2013 2:21:36 AM\n" +
        "Time completed: 07/15/2013 2:47:17 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000240",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000240\n\nTime reported: 07/15/2013 2:21:36 AM\nTime completed: 07/15/2013 2:47:17 AM\n\nUnit(s) responded: \n00000300");

    doTest("T67",
        "(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000240\n\n" +
        "Time reported: 07/15/2013 2:21:36 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:1596 Millpond Ct",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000240",
        "DATE:07/15/2013",
        "TIME:02:21:36",
        "UNIT:00000300");

    doTest("T68",
        "(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000239\n\n" +
        "Time reported: 07/15/2013 12:16:30 AM\n" +
        "Time completed: 07/15/2013 12:33:25 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000239",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000239\n\nTime reported: 07/15/2013 12:16:30 AM\nTime completed: 07/15/2013 12:33:25 AM\n\nUnit(s) responded: \n00000300");

    doTest("T69",
        "(Fire Call-fire at 1596 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 1596 Millpond Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000239\n\n" +
        "Time reported: 07/15/2013 12:16:30 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:1596 Millpond Ct",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000239",
        "DATE:07/15/2013",
        "TIME:00:16:30",
        "UNIT:00000300");

    doTest("T70",
        "(Fire Call-fire at 1595 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000238\n\n" +
        "Time reported: 07/14/2013 6:13:36 PM\n" +
        "Time completed: 07/14/2013 6:31:27 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "co alarm",

        "CALL:RUN REPORT",
        "ID:201300000238",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\nFire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\nChaska Fire - 201300000238\n\nTime reported: 07/14/2013 6:13:36 PM\nTime completed: 07/14/2013 6:31:27 PM\n\nUnit(s) responded: \n00000300\nco alarm");

    doTest("T71",
        "(Fire Call-fire at 1595 Millpond Ct, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\n" +
        "Fire Call-fire at 1595 Millpond Ct, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000238\n\n" +
        "Time reported: 07/14/2013 6:13:36 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "co alarm",

        "CALL:Fire Call-fire",
        "ADDR:1595 Millpond Ct",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000238",
        "DATE:07/14/2013",
        "TIME:18:13:36",
        "UNIT:00000300",
        "INFO:co alarm");

    doTest("T72",
        "(Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000237\n\n" +
        "Time reported: 07/14/2013 9:28:29 AM\n" +
        "Time completed: 07/14/2013 10:13:54 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "comm fire and water flow alarm",

        "CALL:RUN REPORT",
        "ID:201300000237",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\nFire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\nChaska Fire - 201300000237\n\nTime reported: 07/14/2013 9:28:29 AM\nTime completed: 07/14/2013 10:13:54 AM\n\nUnit(s) responded: \n00000300\ncomm fire and water flow alarm");

    doTest("T73",
        "(Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 322 Lake Hazeltine Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000237\n\n" +
        "Time reported: 07/14/2013 9:28:29 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:322 Lake Hazeltine Dr",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000237",
        "DATE:07/14/2013",
        "TIME:09:28:29",
        "UNIT:00000300");

    doTest("T74",
        "(Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\n" +
        "Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000236\n\n" +
        "Time reported: 07/12/2013 8:00:19 AM\n" +
        "Time completed: 07/12/2013 8:22:33 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000236",
        "UNIT:00000300",
        "PLACE:Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\nPi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\nChaska Fire - 201300000236\n\nTime reported: 07/12/2013 8:00:19 AM\nTime completed: 07/12/2013 8:22:33 AM\n\nUnit(s) responded: \n00000300");

    doTest("T75",
        "(Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\n" +
        "Pi Accident-ems at Walnut St N/4 St E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000236\n\n" +
        "Time reported: 07/12/2013 8:00:19 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Pi Accident-ems",
        "ADDR:Walnut St N & 4 St E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000236",
        "DATE:07/12/2013",
        "TIME:08:00:19",
        "UNIT:00000300");

    doTest("T76",
        "(Pi Accident-ems at Hwy 41/4 St E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 41/4 St E, Chaska, 55318\n\n" +
        "Pi Accident-ems at Hwy 41/4 St E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000236\n\n" +
        "Time reported: 07/12/2013 8:00:19 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Pi Accident-ems",
        "ADDR:Hwy 41 & 4 St E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000236",
        "DATE:07/12/2013",
        "TIME:08:00:19",
        "UNIT:00000300");

    doTest("T77",
        "(Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000235\n\n" +
        "Time reported: 07/11/2013 8:20:56 PM\n" +
        "Time completed: 07/11/2013 8:45:44 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "co alarm",

        "CALL:RUN REPORT",
        "ID:201300000235",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\nFire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\nChaska Fire - 201300000235\n\nTime reported: 07/11/2013 8:20:56 PM\nTime completed: 07/11/2013 8:45:44 PM\n\nUnit(s) responded: \n00000300\nco alarm");

    doTest("T78",
        "(Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at 3705 Bavaria Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000235\n\n" +
        "Time reported: 07/11/2013 8:20:56 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:3705 Bavaria Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000235",
        "DATE:07/11/2013",
        "TIME:20:20:56",
        "UNIT:00000300");

    doTest("T79",
        "(Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000234\n\n" +
        "Time reported: 07/11/2013 10:26:06 AM\n" +
        "Time completed: 07/11/2013 10:37:50 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "Poss car fire",

        "CALL:RUN REPORT",
        "ID:201300000234",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\nFire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\nChaska Fire - 201300000234\n\nTime reported: 07/11/2013 10:26:06 AM\nTime completed: 07/11/2013 10:37:50 AM\n\nUnit(s) responded: \n00000300\nPoss car fire");

    doTest("T80",
        "(Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\n" +
        "Fire Call-fire at Westwood Ln/Bavaria Rd, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000234\n\n" +
        "Time reported: 07/11/2013 10:26:06 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "Poss car fire",

        "CALL:Fire Call-fire",
        "ADDR:Westwood Ln & Bavaria Rd",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000234",
        "DATE:07/11/2013",
        "TIME:10:26:06",
        "UNIT:00000300",
        "INFO:Poss car fire");

    doTest("T81",
        "(Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000233\n\n" +
        "Time reported: 07/11/2013 5:41:57 AM\n" +
        "Time completed: 07/11/2013 6:05:14 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000233",
        "UNIT:00000300",
        "PLACE:Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nAssist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000233\n\nTime reported: 07/11/2013 5:41:57 AM\nTime completed: 07/11/2013 6:05:14 AM\n\nUnit(s) responded: \n00000300");

    doTest("T82",
        "(Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Assist Other Agency-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000233\n\n" +
        "Time reported: 07/11/2013 5:41:57 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Assist Other Agency-fire",
        "ADDR:111 Hundertmark Rd E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000233",
        "DATE:07/11/2013",
        "TIME:05:41:57",
        "UNIT:00000300");

    doTest("T83",
        "(Fire Call at 445 Moers Cir, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call at 445 Moers Cir, Chaska, 55318\n\n" +
        "Fire Call at 445 Moers Cir, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000232\n\n" +
        "Time reported: 07/11/2013 1:37:03 AM\n" +
        "Time completed: 07/11/2013 1:40:18 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "co alarm /",

        "CALL:RUN REPORT",
        "ID:201300000232",
        "UNIT:00000300",
        "PLACE:Fire Call at 445 Moers Cir, Chaska, 55318\n\nFire Call at 445 Moers Cir, Chaska, 55318\n\nChaska Fire - 201300000232\n\nTime reported: 07/11/2013 1:37:03 AM\nTime completed: 07/11/2013 1:40:18 AM\n\nUnit(s) responded: \n00000300\nco alarm /");

    doTest("T84",
        "(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000231\n\n" +
        "Time reported: 07/11/2013 12:23:54 AM\n" +
        "Time completed: 07/11/2013 12:54:42 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000231",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nFire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\nChaska Fire - 201300000231\n\nTime reported: 07/11/2013 12:23:54 AM\nTime completed: 07/11/2013 12:54:42 AM\n\nUnit(s) responded: \n00000300");

    doTest("T85",
        "(Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Fire Call-fire at 111 Hundertmark Rd E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000231\n\n" +
        "Time reported: 07/11/2013 12:23:54 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:111 Hundertmark Rd E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000231",
        "DATE:07/11/2013",
        "TIME:00:23:54",
        "UNIT:00000300");

    doTest("T86",
        "(Fire Call-fire at 445 Moers Cir, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 445 Moers Cir, Chaska, 55318\n\n" +
        "Fire Call-fire at 445 Moers Cir, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000230\n\n" +
        "Time reported: 07/10/2013 11:30:24 PM\n" +
        "Time completed: 07/10/2013 11:47:31 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000230",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 445 Moers Cir, Chaska, 55318\n\nFire Call-fire at 445 Moers Cir, Chaska, 55318\n\nChaska Fire - 201300000230\n\nTime reported: 07/10/2013 11:30:24 PM\nTime completed: 07/10/2013 11:47:31 PM\n\nUnit(s) responded: \n00000300");

    doTest("T87",
        "(Fire Call-fire at 445 Moers Cir, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 445 Moers Cir, Chaska, 55318\n\n" +
        "Fire Call-fire at 445 Moers Cir, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000230\n\n" +
        "Time reported: 07/10/2013 11:30:24 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Fire Call-fire",
        "ADDR:445 Moers Cir",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000230",
        "DATE:07/10/2013",
        "TIME:23:30:24",
        "UNIT:00000300");

    doTest("T88",
        "(Fire Call-fire at 307 6 St E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 307 6 St E, Chaska, 55318\n\n" +
        "Fire Call-fire at 307 6 St E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000229\n\n" +
        "Time reported: 07/08/2013 2:50:32 PM\n" +
        "Time completed: 07/08/2013 3:08:19 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "transformer smoking",

        "CALL:RUN REPORT",
        "ID:201300000229",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 307 6 St E, Chaska, 55318\n\nFire Call-fire at 307 6 St E, Chaska, 55318\n\nChaska Fire - 201300000229\n\nTime reported: 07/08/2013 2:50:32 PM\nTime completed: 07/08/2013 3:08:19 PM\n\nUnit(s) responded: \n00000300\ntransformer smoking");

    doTest("T89",
        "(Fire Call-fire at 307 6 St E, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 307 6 St E, Chaska, 55318\n\n" +
        "Fire Call-fire at 307 6 St E, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000229\n\n" +
        "Time reported: 07/08/2013 2:50:32 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "transformer smoking",

        "CALL:Fire Call-fire",
        "ADDR:307 6 St E",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000229",
        "DATE:07/08/2013",
        "TIME:14:50:32",
        "UNIT:00000300",
        "INFO:transformer smoking");

    doTest("T90",
        "(Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\n" +
        "Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000228\n\n" +
        "Time reported: 07/08/2013 6:39:22 AM\n" +
        "Time completed: 07/08/2013 7:22:42 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "sb /",

        "CALL:RUN REPORT",
        "ID:201300000228",
        "UNIT:00000300",
        "PLACE:Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\nPi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\nChaska Fire - 201300000228\n\nTime reported: 07/08/2013 6:39:22 AM\nTime completed: 07/08/2013 7:22:42 AM\n\nUnit(s) responded: \n00000300\nsb /");

    doTest("T91",
        "(Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\n" +
        "Pi Accident-ems at Hwy 41/Hwy 212, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000228\n\n" +
        "Time reported: 07/08/2013 6:39:22 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "sb /",

        "CALL:Pi Accident-ems",
        "ADDR:Hwy 41 & Hwy 212",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000228",
        "DATE:07/08/2013",
        "TIME:06:39:22",
        "UNIT:00000300",
        "INFO:sb /");

    doTest("T92",
        "(Assist Other Agency-fire at 118 Homes St S, Shakopee, ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 118 Homes St S, Shakopee, \n\n" +
        "Assist Other Agency-fire at 118 Homes St S, Shakopee, \n\n" +
        "Chaska Fire - 201300000227\n\n" +
        "Time reported: 07/06/2013 4:16:33 PM\n" +
        "Time completed: 07/06/2013 5:15:00 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "Assist to Shakopee/2nd alarm",

        "CALL:RUN REPORT",
        "ID:201300000227",
        "UNIT:00000300",
        "PLACE:Assist Other Agency-fire at 118 Homes St S, Shakopee, \n\nAssist Other Agency-fire at 118 Homes St S, Shakopee, \n\nChaska Fire - 201300000227\n\nTime reported: 07/06/2013 4:16:33 PM\nTime completed: 07/06/2013 5:15:00 PM\n\nUnit(s) responded: \n00000300\nAssist to Shakopee/2nd alarm");

    doTest("T93",
        "(Assist Other Agency-fire at 118 Homes St S, Shakopee, ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 118 Homes St S, Shakopee, \n\n" +
        "Assist Other Agency-fire at 118 Homes St S, Shakopee, \n\n" +
        "Chaska Fire - 201300000227\n\n" +
        "Time reported: 07/06/2013 4:16:33 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "Chaska 2nd alarm/",

        "CALL:Assist Other Agency-fire",
        "ADDR:118 Homes St S, Shakopee",
        "SRC:Assist Other Agency-fire at 118 Homes St S, Shakopee,",
        "DATE:07/06/2013",
        "TIME:16:16:33",
        "INFO:Chaska 2nd alarm/");

    doTest("T94",
        "(Medical-ems at 1782 Prescott Ln, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1782 Prescott Ln, Chaska, 55318\n\n" +
        "Medical-ems at 1782 Prescott Ln, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000226\n\n" +
        "Time reported: 07/06/2013 10:43:58 AM\n" +
        "Time completed: 07/06/2013 10:56:31 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000226",
        "UNIT:00000300",
        "PLACE:Medical-ems at 1782 Prescott Ln, Chaska, 55318\n\nMedical-ems at 1782 Prescott Ln, Chaska, 55318\n\nChaska Fire - 201300000226\n\nTime reported: 07/06/2013 10:43:58 AM\nTime completed: 07/06/2013 10:56:31 AM\n\nUnit(s) responded: \n00000300");

    doTest("T95",
        "(Medical-ems at 1782 Prescott Ln, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 1782 Prescott Ln, Chaska, 55318\n\n" +
        "Medical-ems at 1782 Prescott Ln, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000226\n\n" +
        "Time reported: 07/06/2013 10:43:58 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Medical-ems",
        "ADDR:1782 Prescott Ln",
        "CITY:Chaska",
        "SRC:Chaska Fire",
        "ID:201300000226",
        "DATE:07/06/2013",
        "TIME:10:43:58",
        "UNIT:00000300");

    doTest("T96",
        "(Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\n" +
        "Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\n" +
        "Chaska Fire - 201300000225\n\n" +
        "Time reported: 07/05/2013 8:29:59 AM\n" +
        "Time completed: 07/05/2013 11:46:48 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "Assist Shorewood",

        "CALL:RUN REPORT",
        "ID:201300000225",
        "UNIT:00000300",
        "PLACE:Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\nAssist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\nChaska Fire - 201300000225\n\nTime reported: 07/05/2013 8:29:59 AM\nTime completed: 07/05/2013 11:46:48 AM\n\nUnit(s) responded: \n00000300\nAssist Shorewood");

    doTest("T97",
        "(Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\n" +
        "Assist Other Agency-fire at 5950 Ridge Rd, Shorewood, \n\n" +
        "Chaska Fire - 201300000225\n\n" +
        "Time reported: 07/05/2013 8:29:59 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Assist Other Agency-fire",
        "ADDR:5950 Ridge Rd, Shorewood",
        "SRC:Assist Other Agency-fire at 5950 Ridge Rd, Shorewood,",
        "DATE:07/05/2013",
        "TIME:08:29:59",
        "UNIT:00000300");

    doTest("T98",
        "(Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\n" +
        "Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\n" +
        "Chaska Fire - 201300000224\n\n" +
        "Time reported: 07/04/2013 12:48:14 AM\n" +
        "Time completed: 07/04/2013 2:28:30 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:RUN REPORT",
        "ID:201300000224",
        "UNIT:00000300",
        "PLACE:Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\nAssist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\nChaska Fire - 201300000224\n\nTime reported: 07/04/2013 12:48:14 AM\nTime completed: 07/04/2013 2:28:30 AM\n\nUnit(s) responded: \n00000300");

    doTest("T99",
        "(Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\n" +
        "Assist Other Agency-fire at 4011 Crestview Dr, Chanhassen, 55317\n\n" +
        "Chaska Fire - 201300000224\n\n" +
        "Time reported: 07/04/2013 12:48:14 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000300",

        "CALL:Assist Other Agency-fire",
        "ADDR:4011 Crestview Dr",
        "CITY:Chanhassen",
        "SRC:Chaska Fire",
        "ID:201300000224",
        "DATE:07/04/2013",
        "TIME:00:48:14",
        "UNIT:00000300");

    doTest("T100",
        "(Fire Call-fire at 3355 Lake Shore Dr, Chaska, 55318) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 3355 Lake Shore Dr, Chaska, 55318\n\n" +
        "Fire Call-fire at 3355 Lake Shore Dr, Chaska, 55318\n\n" +
        "Chaska Fire - 201300000223\n\n" +
        "Time reported: 07/03/2013 11:13:09 PM\n" +
        "Time completed: 07/03/2013 11:46:46 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000300\n" +
        "smoke inside /",

        "CALL:RUN REPORT",
        "ID:201300000223",
        "UNIT:00000300",
        "PLACE:Fire Call-fire at 3355 Lake Shore Dr, Chaska, 55318\n\nFire Call-fire at 3355 Lake Shore Dr, Chaska, 55318\n\nChaska Fire - 201300000223\n\nTime reported: 07/03/2013 11:13:09 PM\nTime completed: 07/03/2013 11:46:46 PM\n\nUnit(s) responded: \n00000300\nsmoke inside /");

 
  }
  
  @Test
  public void testMayer() {

    doTest("T1",
        "(Medical-ems at Hwy 25/74 St, Waconia Twp, 55360) Notification from CIS Active 911:\n\n" +
        "Medical-ems at Hwy 25/74 St, Waconia Twp, 55360\n\n" +
        "Medical-ems at Hwy 25/74 St, Waconia Twp, 55360\n\n" +
        "Mayer Fire - 201300000065\n\n" +
        "Time reported: 08/21/2013 2:26:27 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:Medical-ems",
        "ADDR:Hwy 25 & 74 St",
        "CITY:Waconia Twp", // maps at Mayer
        "SRC:Mayer Fire",
        "ID:201300000065",
        "DATE:08/21/2013",
        "TIME:14:26:27",
        "UNIT:00000600");

    doTest("T2",
        "(Assist Other Agency-fire at 12485 Co Rd 30, Waconia Twp, 55387) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 12485 Co Rd 30, Waconia Twp, 55387\n\n" +
        "Assist Other Agency-fire at 12485 Co Rd 30, Waconia Twp, 55387\n\n" +
        "Mayer Fire - 201300000064\n\n" +
        "Time reported: 08/21/2013 10:02:50 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "barn fire /",

        "CALL:Assist Other Agency-fire",
        "ADDR:12485 Co Rd 30",
        "MADDR:12485 COUNTY ROAD 30",
        "CITY:Waconia Twp",
        "SRC:Mayer Fire",
        "ID:201300000064",
        "DATE:08/21/2013",
        "TIME:10:02:50",
        "INFO:barn fire /");

    doTest("T3",
        "(Fire Call-fire at 2339 Coldwater Crossing, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 2339 Coldwater Crossing, Mayer, 55360\n\n" +
        "Fire Call-fire at 2339 Coldwater Crossing, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000063\n\n" +
        "Time reported: 08/14/2013 1:19:59 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600\n" +
        "strong smell / smoke /carbon / alarms going off /",

        "CALL:Fire Call-fire",
        "ADDR:2339 Coldwater Crossing",
        "CITY:Mayer",
        "SRC:Mayer Fire",
        "ID:201300000063",
        "DATE:08/14/2013",
        "TIME:01:19:59",
        "UNIT:00000600",
        "INFO:strong smell / smoke /carbon / alarms going off /");

    doTest("T4",
        "(Assist Other Agency-fire at 340 Co Rd 92, , ) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 340 Co Rd 92, , \n\n" +
        "Assist Other Agency-fire at 340 Co Rd 92, , \n\n" +
        "Mayer Fire - 201300000062\n\n" +
        "Time reported: 08/06/2013 11:27:19 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:Assist Other Agency-fire",
        "ADDR:340 Co Rd 92,",
        "MADDR:340 COUNTY ROAD 92,", // did not map well
        "SRC:Assist Other Agency-fire at 340 Co Rd 92, ,",
        "DATE:08/06/2013",
        "TIME:11:27:19",
        "UNIT:00000600");

    doTest("T5",
        "(Assist Other Agency-fire at Co Rd 140/Hwy 284, Waconia Twp, 55387) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at Co Rd 140/Hwy 284, Waconia Twp, 55387\n\n" +
        "Assist Other Agency-fire at Co Rd 140/Hwy 284, Waconia Twp, 55387\n\n" +
        "Mayer Fire - 201300000061\n\n" +
        "Time reported: 08/05/2013 5:13:15 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:Assist Other Agency-fire",
        "ADDR:Co Rd 140 & Hwy 284",
        "MADDR:COUNTY ROAD 140 & Hwy 284",
        "CITY:Waconia Twp",
        "SRC:Mayer Fire",
        "ID:201300000061",
        "DATE:08/05/2013",
        "TIME:05:13:15",
        "UNIT:00000600");

    doTest("T6",
        "(Medical-ems at 104 West Ridge Rd, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 104 West Ridge Rd, Mayer, 55360\n\n" +
        "Medical-ems at 104 West Ridge Rd, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000060\n\n" +
        "Time reported: 08/04/2013 2:04:40 AM\n\n\n" +
        "Unit(s) responded: ",

        "CALL:Medical-ems",
        "ADDR:104 West Ridge Rd",
        "CITY:Mayer",
        "SRC:Mayer Fire",
        "ID:201300000060",
        "DATE:08/04/2013",
        "TIME:02:04:40");

    doTest("T7",
        "(Fire Call-fire at 400 Ash Av N, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Fire Call-fire at 400 Ash Av N, Mayer, 55360\n\n" +
        "Fire Call-fire at 400 Ash Av N, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000059\n\n" +
        "Time reported: 08/01/2013 8:56:30 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600\n" +
        "compost fire",

        "CALL:Fire Call-fire",
        "ADDR:400 Ash Av N",
        "MADDR:400 Ash Ave N",
        "CITY:Mayer",
        "SRC:Mayer Fire",
        "ID:201300000059",
        "DATE:08/01/2013",
        "TIME:08:56:30",
        "UNIT:00000600",
        "INFO:compost fire");

    doTest("T8",
        "(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Mayer Fire - 201300000058\n\n" +
        "Time reported: 07/21/2013 1:43:58 AM\n" +
        "Time completed: 07/21/2013 2:15:33 AM\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:RUN REPORT",
        "ID:201300000058",
        "UNIT:00000600",
        "PLACE:Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nMayer Fire - 201300000058\n\nTime reported: 07/21/2013 1:43:58 AM\nTime completed: 07/21/2013 2:15:33 AM\n\nUnit(s) responded: \n00000600");

    doTest("T9",
        "(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Mayer Fire - 201300000058\n\n" +
        "Time reported: 07/21/2013 1:43:58 AM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:Pi Accident-ems",
        "ADDR:Hwy 25 & Hwy 7",  // maps to Hwy 25 and 7th st
        "CITY:Watertown Twp",
        "SRC:Mayer Fire",
        "ID:201300000058",
        "DATE:07/21/2013",
        "TIME:01:43:58",
        "UNIT:00000600");

    doTest("T10",
        "(Medical-ems at 529 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 529 Ash Av S, Mayer, 55360\n\n" +
        "Medical-ems at 529 Ash Av S, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000057\n\n" +
        "Time reported: 07/16/2013 10:17:39 PM\n" +
        "Time completed: 07/16/2013 10:36:23 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:RUN REPORT",
        "ID:201300000057",
        "UNIT:00000600",
        "PLACE:Medical-ems at 529 Ash Av S, Mayer, 55360\n\nMedical-ems at 529 Ash Av S, Mayer, 55360\n\nMayer Fire - 201300000057\n\nTime reported: 07/16/2013 10:17:39 PM\nTime completed: 07/16/2013 10:36:23 PM\n\nUnit(s) responded: \n00000600");

    doTest("T11",
        "(Medical-ems at 529 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 529 Ash Av S, Mayer, 55360\n\n" +
        "Medical-ems at 529 Ash Av S, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000057\n\n" +
        "Time reported: 07/16/2013 10:17:39 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:Medical-ems",
        "ADDR:529 Ash Av S",
        "MADDR:529 Ash Ave S",
        "CITY:Mayer",
        "SRC:Mayer Fire",
        "ID:201300000057",
        "DATE:07/16/2013",
        "TIME:22:17:39",
        "UNIT:00000600");

    doTest("T12",
        "(Medical-ems at 305 5 St Ne, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 305 5 St Ne, Mayer, 55360\n\n" +
        "Medical-ems at 305 5 St Ne, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000056\n\n" +
        "Time reported: 07/08/2013 6:47:21 PM\n" +
        "Time completed: 07/08/2013 7:16:49 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:RUN REPORT",
        "ID:201300000056",
        "UNIT:00000600",
        "PLACE:Medical-ems at 305 5 St Ne, Mayer, 55360\n\nMedical-ems at 305 5 St Ne, Mayer, 55360\n\nMayer Fire - 201300000056\n\nTime reported: 07/08/2013 6:47:21 PM\nTime completed: 07/08/2013 7:16:49 PM\n\nUnit(s) responded: \n00000600");

    doTest("T13",
        "(Medical-ems at 305 5 St Ne, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Medical-ems at 305 5 St Ne, Mayer, 55360\n\n" +
        "Medical-ems at 305 5 St Ne, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000056\n\n" +
        "Time reported: 07/08/2013 6:47:21 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:Medical-ems",
        "ADDR:305 5 St Ne",
        "CITY:Mayer",
        "SRC:Mayer Fire",
        "ID:201300000056",
        "DATE:07/08/2013",
        "TIME:18:47:21",
        "UNIT:00000600");

    doTest("T14",
        "(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Mayer Fire - 201300000055\n\n" +
        "Time reported: 07/08/2013 12:12:04 PM\n" +
        "Time completed: 07/08/2013 12:40:21 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:RUN REPORT",
        "ID:201300000055",
        "UNIT:00000600",
        "PLACE:Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nPi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\nMayer Fire - 201300000055\n\nTime reported: 07/08/2013 12:12:04 PM\nTime completed: 07/08/2013 12:40:21 PM\n\nUnit(s) responded: \n00000600");

    doTest("T15",
        "(Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360) Notification from CIS Active 911:\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Pi Accident-ems at Hwy 25/Hwy 7, Watertown Twp, 55360\n\n" +
        "Mayer Fire - 201300000055\n\n" +
        "Time reported: 07/08/2013 12:12:04 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600",

        "CALL:Pi Accident-ems",
        "ADDR:Hwy 25 & Hwy 7",
        "CITY:Watertown Twp",
        "SRC:Mayer Fire",
        "ID:201300000055",
        "DATE:07/08/2013",
        "TIME:12:12:04",
        "UNIT:00000600");

    doTest("T16",
        "(Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\n" +
        "Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000054\n\n" +
        "Time reported: 07/03/2013 2:55:28 PM\n" +
        "Time completed: 07/03/2013 2:56:46 PM\n\n" +
        "Unit(s) responded: \n" +
        "00000600\n" +
        "This is a test e-mail for Active 9-1-1 / This is not an actual incident /",

        "CALL:RUN REPORT",
        "ID:201300000054",
        "UNIT:00000600",
        "PLACE:Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\nAssist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\nMayer Fire - 201300000054\n\nTime reported: 07/03/2013 2:55:28 PM\nTime completed: 07/03/2013 2:56:46 PM\n\nUnit(s) responded: \n00000600\nThis is a test e-mail for Active 9-1-1 / This is not an actual incident /");

    doTest("T17",
        "(Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360) Notification from CIS Active 911:\n\n" +
        "Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\n" +
        "Assist Other Agency-fire at 201 Ash Av S, Mayer, 55360\n\n" +
        "Mayer Fire - 201300000054\n\n" +
        "Time reported: 07/03/2013 2:55:28 PM\n\n\n" +
        "Unit(s) responded: \n" +
        "00000600\n" +
        "This is a test e-mail for Active 9-1-1 / This is not an actual incident /",

        "CALL:Assist Other Agency-fire",
        "ADDR:201 Ash Av S",
        "MADDR:201 Ash Ave S",
        "CITY:Mayer",
        "SRC:Mayer Fire",
        "ID:201300000054",
        "DATE:07/03/2013",
        "TIME:14:55:28",
        "UNIT:00000600",
        "INFO:This is a test e-mail for Active 9-1-1 / This is not an actual incident /");

  
  }
  
  public static void main(String[] args) {
    new MNCarverCountyParserTest().generateTests("T1");
  }
}
