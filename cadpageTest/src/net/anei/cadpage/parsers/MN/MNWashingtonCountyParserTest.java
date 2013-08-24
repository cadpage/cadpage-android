package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Washington County, MN
Contact: Active911
Agency name: Lake Elmo FD
Location: Lake Elmo, MN, United States
Sender: sheriff@co.washington.mn.us

(ICOM/400 notification) STILLWATER BLVD.N  ICR #113013925  DISPATCH
(ICOM/400 notification) 11030.STILLWATER BLVD.N  ICR #113013707  DISPATCH
(ICOM/400 notification) 11260.HUDSON BLVD.N  ICR #113013671  DISPATCH
(ICOM/400 notification) 585.JULEP CT.N.  ICR #113013651  DISPATCH
(ICOM/400 notification) 8511.HUDSON BLVD.N  ICR #113013366  DISPATCH
(ICOM/400 notification) 9095.LAKE JANE TR.N  ICR #113013213  DISPATCH
(ICOM/400 notification) 8961.37TH ST.N  ICR #113013080  DISPATCH
(ICOM/400 notification) 5960.HIGHLANDS TR.N.  ICR #113013073  DISPATCH
(ICOM/400 notification) 9250.STILLWATER BLVD.N  ICR #113013061  DISPATCH
(ICOM/400 notification) 8633.34TH ST.N  ICR #113013011  DISPATCH
(ICOM/400 notification) 5043.ISLE AV.N  ICR #113012927  DISPATCH
(ICOM/400 notification) 10TH ST.N  ICR #113012734  DISPATCH
(ICOM/400 notification) 8030.38TH ST.N  ICR #113012722  DISPATCH
(ICOM/400 notification) 10080.TAPESTRY RD  ICR #113012678  DISPATCH
(ICOM/400 notification) 10605.KINGSFIELD LN  ICR #113608734  DISPATCH
(ICOM/400 notification) 357.CIMARRON  ICR #113012606  DISPATCH
(ICOM/400 notification) 5430.HIGHLANDS TR.N  ICR #113012539  DISPATCH
(ICOM/400 notification) LAKE ELMO AV.N  ICR #113012499  DISPATCH
(ICOM/400 notification) 23.CIMARRON  ICR #113012478  DISPATCH
(ICOM/400 notification) 259.CIMARRON  ICR #113012419  DISPATCH
(ICOM/400 notification) 8650.HUDSON BLVD.N.  ICR #113012396  DISPATCH
(ICOM/400 notification) 447.CIMARRON  ICR #113012305  DISPATCH
(ICOM/400 notification) 8290.HIDDEN BAY CT.N.  ICR #113012003  DISPATCH
(ICOM/400 notification) 11490.HUDSON BLVD.N  ICR #113011891  DISPATCH
(ICOM/400 notification) 8511.HUDSON BLVD.N.203  ICR #113011856  DISPATCH
(ICOM/400 notification) 8511.HUDSON BLVD.N  ICR #113011778  DISPATCH
(ICOM/400 notification) 5041.LINDEN TR.N  ICR #113011589  DISPATCH
(ICOM/400 notification) STILLWATER BLVD.N  ICR #113011533  DISPATCH
(ICOM/400 notification) 10997.32ND ST.N  ICR #113011489  DISPATCH
(ICOM/400 notification) 443.CIMARRON  ICR #113011195  DISPATCH

Contact: Active911
Agency name: Stillwater Fire
Location: Stillwater, MN, United States
Sender: sheriff@co.washington.mn.us

(ICOM/400 notification) 212.2ND ST.N.611  ICR #113203531  DISPATCH
(ICOM/400 notification) 1500.CURVE CREST BLVD..  ICR #113203520  DISPATCH
(ICOM/400 notification) 1826.NORTHWESTERN AV  ICR #113203509  DISPATCH
(ICOM/400 notification) 1119.OWENS ST.N.4  ICR #113203508  DISPATCH
(ICOM/400 notification) 15130.SQUARE LAKE TR.N  ICR #113013802  DISPATCH
(ICOM/400 notification) 1124.LINDEN ST.W  ICR #113203503  DISPATCH
(ICOM/400 notification) PINE ST  ICR #113203489  DISPATCH
(ICOM/400 notification) 630.MAIN ST.N  ICR #113203487  DISPATCH
(ICOM/400 notification) 13311.SQUARE LAKE TR.N  ICR #113013714  DISPATCH
(ICOM/400 notification) 1119.OWENS ST.N.9  ICR #113203476  DISPATCH
(ICOM/400 notification) 3RD ST.N  ICR #113203473  DISPATCH
(ICOM/400 notification) 1255.PONDVIEW LN..7  ICR #113203470  DISPATCH
(ICOM/400 notification) CURVE CREST BLVD.  ICR #113203467  DISPATCH
(ICOM/400 notification) LANSING AV.N  ICR #113013657  DISPATCH
(ICOM/400 notification) 215.WILLIAM ST.N  ICR #113203443  DISPATCH
(ICOM/400 notification) 1370.CURVE CREST BLVD..  ICR #113203437  DISPATCH
(ICOM/400 notification) 215.MAIN ST.S  ICR #113203410  DISPATCH
(ICOM/400 notification) 2775.SADDLE CT..6  ICR #113203400  DISPATCH
(ICOM/400 notification) 319.BURLINGTON ST.E  ICR #113203398  DISPATCH
(ICOM/400 notification) STONEBRIDGE TR  ICR #113013410  DISPATCH
(ICOM/400 notification) 1500.CURVE CREST BLVD  ICR #113203396  DISPATCH
(ICOM/400 notification) 2519.INTERLACHEN DR  ICR #113203383  DISPATCH
(ICOM/400 notification) 1825.CURVE CREST BLVD..  ICR #113203375  DISPATCH
(ICOM/400 notification) 927.CHURCHILL ST.W.  ICR #113203363  DISPATCH
(ICOM/400 notification) 1119.OWENS ST.N.10  ICR #113203357  DISPATCH
(ICOM/400 notification) 2845.BREWERS LN..8  ICR #113203355  DISPATCH
(ICOM/400 notification) 604.LAUREL ST.W  ICR #113203354  DISPATCH
(ICOM/400 notification) 326.MELVILLE CT.N.  ICR #113203325  DISPATCH
(ICOM/400 notification) 1119.OWENS ST.N  ICR #113203321  DISPATCH
(ICOM/400 notification) 409.WILKINS ST.W  ICR #113203320  DISPATCH

Contact: Active911
Agency name: Woodbury Public Safety
Location: Woodbury, MN, United States
Sender: sheriff@co.washington.mn.us

(ICOM/400 notification) 7116.WINDGATE RD..  ICR #113609673  DISPATCH
(ICOM/400 notification) 8906.SAINT CROIX RD  ICR #113609667  DISPATCH
(ICOM/400 notification) 6.EVERGREEN DR  ICR #113013934  DISPATCH
(ICOM/400 notification) 4125.RADIO DR  ICR #113609661  DISPATCH
(ICOM/400 notification) 7360.33RD ST.N  ICR #113303630  DISPATCH
(ICOM/400 notification) STILLWATER BLVD.N  ICR #113013925  DISPATCH
(ICOM/400 notification) 4125.RADIO DR  ICR #113609652  DISPATCH
(ICOM/400 notification) 8675.VALLEY CREEK RD  ICR #113609643  DISPATCH
(ICOM/400 notification) 4994.HAMLET AV.N  ICR #113303624  DISPATCH
(ICOM/400 notification) 4300.RADIO DR  ICR #113609637  DISPATCH
(ICOM/400 notification) 4994.HAMLET AV.N  ICR #113303624  DISPATCH
(ICOM/400 notification) 1850.WEIR DR..3  ICR #113609636  DISPATCH
(ICOM/400 notification) 1918.EVERGREEN ECHO  ICR #113609620  DISPATCH
(ICOM/400 notification) 8725.PROMENADE LN..248  ICR #113609617  DISPATCH
(ICOM/400 notification) 1201.HADLEY AV.N.315  ICR #113303621  DISPATCH
(ICOM/400 notification) 8450.SEASONS PKWY  ICR #113609615  DISPATCH
(ICOM/400 notification) 6281.15TH ST.N  ICR #113303612  DISPATCH
(ICOM/400 notification) 7900.32ND ST.N  ICR #113303610  DISPATCH
(ICOM/400 notification) 3079.JUNIPER LN..E  ICR #113609596  DISPATCH
(ICOM/400 notification) 8133.4TH ST.N  ICR #113303606  DISPATCH
(ICOM/400 notification) 7899.FOREST BLVD..A  ICR #113609576  DISPATCH
(ICOM/400 notification) 7008.LAKE RD..223  ICR #113609573  DISPATCH
(ICOM/400 notification) 4511.HILLVALE AV.N  ICR #113303597  DISPATCH
(ICOM/400 notification) 2361.FIELDSTONE CURVE..  ICR #113609564  DISPATCH
(ICOM/400 notification) 2150.RADIO DR.  ICR #113609558  DISPATCH
(ICOM/400 notification) 1318.CLEARWATER DR  ICR #113609559  DISPATCH
(ICOM/400 notification) 6580.SANDLEWOOD RD  ICR #113609550  DISPATCH
(ICOM/400 notification) 10813.MAPLE BLVD  ICR #113609551  DISPATCH
(ICOM/400 notification) 1385.GENTRY AV.N  ICR #113303593  DISPATCH
(ICOM/400 notification) 1281.HELMO AV.N  ICR #113303591  DISPATCH

Contact: Active911
Agency name: Bayport Fire Department
Location: Bayport, MN, United States
Sender: sheriff@co.washington.mn.us

(ICOM/400 notification) 15154.62ND ST.N  ICR #113701822  DISPATCH
(ICOM/400 notification) 5800.NEAL AV.N  ICR #113701799  DISPATCH
(ICOM/400 notification) 750.HWY 95.N  ICR #113501040  DISPATCH
(ICOM/400 notification) 280.7TH ST.N  ICR #113501039  DISPATCH
(ICOM/400 notification) 13936.LOWER 59TH ST.N  ICR #113701796  DISPATCH
(ICOM/400 notification) 5590.NORWICH PKWY  ICR #113701794  DISPATCH
(ICOM/400 notification) 13025.60TH ST.N  ICR #113701791  DISPATCH
(ICOM/400 notification) 4706.MCDONALD DR PL.N  ICR #113013676  DISPATCH
(ICOM/400 notification) 2114.STAGECOACH TR.N  ICR #113013662  DISPATCH
(ICOM/400 notification) 5329.OSGOOD AV.N  ICR #113701782  DISPATCH
(ICOM/400 notification) 13025.60TH ST.N  ICR #113701779  DISPATCH
(ICOM/400 notification) 14100.HWY I94  ICR #113013618  DISPATCH
(ICOM/400 notification) 970.PICKETT ST.N  ICR #113501026  DISPATCH
(ICOM/400 notification) HWY 94  ICR #113013601  DISPATCH
(ICOM/400 notification) 14830.58TH ST.N.104  ICR #113701774  DISPATCH
(ICOM/400 notification) 6060.OXBORO AV.N.111  ICR #113701767  DISPATCH
(ICOM/400 notification) 5282.NOLAN PKWY.N.  ICR #113701759  DISPATCH
(ICOM/400 notification) 13045.53RD ST PL.N  ICR #113013390  DISPATCH
(ICOM/400 notification) 6060.OXBORO AV.N.227  ICR #113701741  DISPATCH
(ICOM/400 notification) 5601.NORWICH PKWY  ICR #113701737  DISPATCH
(ICOM/400 notification) 4401.OSGOOD AV.N  ICR #113013219  DISPATCH
(ICOM/400 notification) 5600.NORWICH PKWY..225  ICR #113701719  DISPATCH
(ICOM/400 notification) 5329.OSGOOD AV.N  ICR #113701715  DISPATCH
(ICOM/400 notification) 6060.OXBORO AV.N.128  ICR #113701707  DISPATCH
(ICOM/400 notification) 13936.LOWER 59TH ST.N.4  ICR #113701705  DISPATCH
(ICOM/400 notification) 5804.NEAL AV.N  ICR #113701703  DISPATCH
(ICOM/400 notification) I94  ICR #113013023  DISPATCH
(ICOM/400 notification) 750.HWY 95.N.22  ICR #113500961  DISPATCH
(ICOM/400 notification) 14532.57TH ST.N  ICR #113701698  DISPATCH
(ICOM/400 notification) 5903.NEAL AV.N  ICR #113701694  DISPATCH
(ICOM/400 notification) 5610.NORWICH PKWY..330  ICR #113701693  DISPATCH
(ICOM/400 notification) 13575.58TH ST.N  ICR #113701691  DISPATCH
(ICOM/400 notification) 5260.NOLAN PKWY.N.C103  ICR #113701682  DISPATCH
(ICOM/400 notification) MANNING AV.N  ICR #113012845  DISPATCH
(ICOM/400 notification) 13936.LOWER 59TH ST.N.  ICR #113701681  DISPATCH
(ICOM/400 notification) 13936.LOWER 59TH ST.N.4  ICR #113701672  DISPATCH
(ICOM/400 notification) 13575.58TH ST.N  ICR #113701669  DISPATCH
(ICOM/400 notification) 5800.KRUEGER LN.N.  ICR #113701660  DISPATCH
(ICOM/400 notification) 4706.MCDONALD DR PL.N.  ICR #113012713  DISPATCH
(ICOM/400 notification) 5590.NORWICH PKWY..304  ICR #113701658  DISPATCH
(ICOM/400 notification) 4020.MCDONALD DR.N.  ICR #113012668  DISPATCH
(ICOM/400 notification) 14787.UPPER 56TH ST.N  ICR #113701644  DISPATCH
(ICOM/400 notification) 415.9TH ST.N  ICR #113500931  DISPATCH
(ICOM/400 notification) ST MICHAELS CEMETARY  ICR #113500927  DISPATCH
(ICOM/400 notification) 294.3RD ST.N  ICR #113500921  DISPATCH
(ICOM/400 notification) 11776.HARVEST PATH  ICR #113608687  DISPATCH
(ICOM/400 notification) 6413.SAINT CROIX TR.N  ICR #113701629  DISPATCH
(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500915  DISPATCH
(ICOM/400 notification) LE/10TH  ICR #113012499  DISPATCH
(ICOM/400 notification) OAKGREEN AV.N  ICR #113701628  DISPATCH
(ICOM/400 notification) 5329.OSGOOD AV.N  ICR #113701616  DISPATCH
(ICOM/400 notification) 3275.MANNING AV.N  ICR #113012373  DISPATCH
(ICOM/400 notification) 750.HWY 95.N.112  ICR #113500906  DISPATCH
(ICOM/400 notification) 14830.58TH ST.N  ICR #113701611  DISPATCH
(ICOM/400 notification) 5590.NORWICH PKWY..116  ICR #113701609  DISPATCH
(ICOM/400 notification) 14843.57TH ST.N  ICR #113701605  DISPATCH
(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500900  DISPATCH
(ICOM/400 notification) 5712.NORWICH CIR.N.  ICR #113701592  DISPATCH
(ICOM/400 notification) 2 LAKE CIRCLE DR  ICR #113500895  DISPATCH
(ICOM/400 notification) 6060.OXBORO AV.N.129  ICR #113701574  DISPATCH
(ICOM/400 notification) 472.MINNESOTA ST.S  ICR #113500883  DISPATCH
(ICOM/400 notification) 4503.OSGOOD AV.N.  ICR #113203001  DISPATCH
(ICOM/400 notification) 14830.58TH ST.N.500  ICR #113701551  DISPATCH
(ICOM/400 notification) 13575.58TH ST.N.214  ICR #113701549  DISPATCH
(ICOM/400 notification) 5600.NORWICH PKWY  ICR #113701534  DISPATCH
(ICOM/400 notification) 14830.58TH ST.N.305  ICR #113701531  DISPATCH
(ICOM/400 notification) 750.HWY 95.N  ICR #113500863  DISPATCH
(ICOM/400 notification) I94  ICR #113011556  DISPATCH
(ICOM/400 notification) 5815.KRUEGER LN.N.  ICR #113701506  DISPATCH
(ICOM/400 notification) 4271.NORTHBROOK BLVD.N  ICR #113011326  DISPATCH
(ICOM/400 notification) 40TH ST.N  ICR #113011082  DISPATCH
(ICOM/400 notification) I94  ICR #113011076  DISPATCH
(ICOM/400 notification) 12240.27TH ST.N.  ICR #113011074  DISPATCH
(ICOM/400 notification) 13523.60TH ST.N  ICR #113701460  DISPATCH
(ICOM/400 notification) 5815.NORELL AV.N  ICR #113701459  DISPATCH
(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500820  DISPATCH
(ICOM/400 notification) 5815.NORELL AV.N  ICR #113701456  DISPATCH
(ICOM/400 notification) 13936.LOWER 59TH ST.N  ICR #113701455  DISPATCH
(ICOM/400 notification) 13575.58TH ST.N  ICR #113701450  DISPATCH
(ICOM/400 notification) 15021.60TH ST.N  ICR #113701443  DISPATCH
(ICOM/400 notification) 4260.STAGECOACH TR.N  ICR #113010889  DISPATCH
(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500796  DISPATCH
(ICOM/400 notification) 1720.OAKGREEN AV.N  ICR #113010819  DISPATCH
(ICOM/400 notification) 5485.NOLAN AV.N  ICR #113701422  DISPATCH
(ICOM/400 notification) 1127.NOLAN AV.N  ICR #113010703  DISPATCH
(ICOM/400 notification) 5520.MEMORIAL AV.N  ICR #113701392  DISPATCH
(ICOM/400 notification) 655.2ND ST.N  ICR #113500776  DISPATCH
(ICOM/400 notification) 14830.58TH ST.N.408  ICR #113701389  DISPATCH
(ICOM/400 notification) 13575.58TH ST.N.157  ICR #113701370  DISPATCH
(ICOM/400 notification) 263.3RD ST.N  ICR #113500765  DISPATCH
(ICOM/400 notification) 5590.NORWICH AV.N  ICR #113701347  DISPATCH
(ICOM/400 notification) 14830.58TH ST.N  ICR #113701346  DISPATCH
(ICOM/400 notification) 13796.55TH ST.N  ICR #113701343  DISPATCH
(ICOM/400 notification) 15200.UPPER 63RD ST.N  ICR #113701338  DISPATCH
(ICOM/400 notification) 750.HWY 95.N  ICR #113500746  DISPATCH
(ICOM/400 notification) 14596.UPPER 56TH ST.N.  ICR #113701323  DISPATCH
(ICOM/400 notification) 13220.22ND ST.N  ICR #113010046  DISPATCH
(ICOM/400 notification) 5701.STILLWATER BLVD.N  ICR #113701319  DISPATCH

*/

public class MNWashingtonCountyParserTest extends BaseParserTest {
  
  public MNWashingtonCountyParserTest() {
    setParser(new MNWashingtonCountyParser(), "WASHINGTON COUNTY", "MN");
  }
  
  @Test
  public void testLakeElmoFD() {

    doTest("T1",
        "(ICOM/400 notification) STILLWATER BLVD.N  ICR #113013925  DISPATCH",
        "ADDR:STILLWATER BLVD N",
        "ID:113013925",
        "CALL:DISPATCH");

    doTest("T2",
        "(ICOM/400 notification) 11030.STILLWATER BLVD.N  ICR #113013707  DISPATCH",
        "ADDR:11030 STILLWATER BLVD N",
        "ID:113013707",
        "CALL:DISPATCH");

    doTest("T3",
        "(ICOM/400 notification) 11260.HUDSON BLVD.N  ICR #113013671  DISPATCH",
        "ADDR:11260 HUDSON BLVD N",
        "ID:113013671",
        "CALL:DISPATCH");

    doTest("T4",
        "(ICOM/400 notification) 585.JULEP CT.N.  ICR #113013651  DISPATCH",
        "ADDR:585 JULEP CT N",
        "ID:113013651",
        "CALL:DISPATCH");

    doTest("T5",
        "(ICOM/400 notification) 8511.HUDSON BLVD.N  ICR #113013366  DISPATCH",
        "ADDR:8511 HUDSON BLVD N",
        "ID:113013366",
        "CALL:DISPATCH");

    doTest("T6",
        "(ICOM/400 notification) 9095.LAKE JANE TR.N  ICR #113013213  DISPATCH",
        "ADDR:9095 LAKE JANE TR N",
        "ID:113013213",
        "CALL:DISPATCH");

    doTest("T7",
        "(ICOM/400 notification) 8961.37TH ST.N  ICR #113013080  DISPATCH",
        "ADDR:8961 37TH ST N",
        "ID:113013080",
        "CALL:DISPATCH");

    doTest("T8",
        "(ICOM/400 notification) 5960.HIGHLANDS TR.N.  ICR #113013073  DISPATCH",
        "ADDR:5960 HIGHLANDS TR N",
        "ID:113013073",
        "CALL:DISPATCH");

    doTest("T9",
        "(ICOM/400 notification) 9250.STILLWATER BLVD.N  ICR #113013061  DISPATCH",
        "ADDR:9250 STILLWATER BLVD N",
        "ID:113013061",
        "CALL:DISPATCH");

    doTest("T10",
        "(ICOM/400 notification) 8633.34TH ST.N  ICR #113013011  DISPATCH",
        "ADDR:8633 34TH ST N",
        "ID:113013011",
        "CALL:DISPATCH");

    doTest("T11",
        "(ICOM/400 notification) 5043.ISLE AV.N  ICR #113012927  DISPATCH",
        "ADDR:5043 ISLE AV N",
        "MADDR:5043 ISLE AVE N",
        "ID:113012927",
        "CALL:DISPATCH");

    doTest("T12",
        "(ICOM/400 notification) 10TH ST.N  ICR #113012734  DISPATCH",
        "ADDR:10TH ST N",
        "ID:113012734",
        "CALL:DISPATCH");

    doTest("T13",
        "(ICOM/400 notification) 8030.38TH ST.N  ICR #113012722  DISPATCH",
        "ADDR:8030 38TH ST N",
        "ID:113012722",
        "CALL:DISPATCH");

    doTest("T14",
        "(ICOM/400 notification) 10080.TAPESTRY RD  ICR #113012678  DISPATCH",
        "ADDR:10080 TAPESTRY RD",
        "ID:113012678",
        "CALL:DISPATCH");

    doTest("T15",
        "(ICOM/400 notification) 10605.KINGSFIELD LN  ICR #113608734  DISPATCH",
        "ADDR:10605 KINGSFIELD LN",
        "ID:113608734",
        "CALL:DISPATCH");

    doTest("T16",
        "(ICOM/400 notification) 357.CIMARRON  ICR #113012606  DISPATCH",
        "ADDR:357 CIMARRON",
        "ID:113012606",
        "CALL:DISPATCH");

    doTest("T17",
        "(ICOM/400 notification) 5430.HIGHLANDS TR.N  ICR #113012539  DISPATCH",
        "ADDR:5430 HIGHLANDS TR N",
        "ID:113012539",
        "CALL:DISPATCH");

    doTest("T18",
        "(ICOM/400 notification) LAKE ELMO AV.N  ICR #113012499  DISPATCH",
        "ADDR:LAKE ELMO AV N",
        "MADDR:LAKE ELMO AVE N",
        "ID:113012499",
        "CALL:DISPATCH");

    doTest("T19",
        "(ICOM/400 notification) 23.CIMARRON  ICR #113012478  DISPATCH",
        "ADDR:23 CIMARRON",
        "ID:113012478",
        "CALL:DISPATCH");

    doTest("T20",
        "(ICOM/400 notification) 259.CIMARRON  ICR #113012419  DISPATCH",
        "ADDR:259 CIMARRON",
        "ID:113012419",
        "CALL:DISPATCH");

    doTest("T21",
        "(ICOM/400 notification) 8650.HUDSON BLVD.N.  ICR #113012396  DISPATCH",
        "ADDR:8650 HUDSON BLVD N",
        "ID:113012396",
        "CALL:DISPATCH");

    doTest("T22",
        "(ICOM/400 notification) 447.CIMARRON  ICR #113012305  DISPATCH",
        "ADDR:447 CIMARRON",
        "ID:113012305",
        "CALL:DISPATCH");

    doTest("T23",
        "(ICOM/400 notification) 8290.HIDDEN BAY CT.N.  ICR #113012003  DISPATCH",
        "ADDR:8290 HIDDEN BAY CT N",
        "ID:113012003",
        "CALL:DISPATCH");

    doTest("T24",
        "(ICOM/400 notification) 11490.HUDSON BLVD.N  ICR #113011891  DISPATCH",
        "ADDR:11490 HUDSON BLVD N",
        "ID:113011891",
        "CALL:DISPATCH");

    doTest("T25",
        "(ICOM/400 notification) 8511.HUDSON BLVD.N.203  ICR #113011856  DISPATCH",
        "ADDR:8511 HUDSON BLVD N",
        "APT:203",
        "ID:113011856",
        "CALL:DISPATCH");

    doTest("T26",
        "(ICOM/400 notification) 8511.HUDSON BLVD.N  ICR #113011778  DISPATCH",
        "ADDR:8511 HUDSON BLVD N",
        "ID:113011778",
        "CALL:DISPATCH");

    doTest("T27",
        "(ICOM/400 notification) 5041.LINDEN TR.N  ICR #113011589  DISPATCH",
        "ADDR:5041 LINDEN TR N",
        "ID:113011589",
        "CALL:DISPATCH");

    doTest("T28",
        "(ICOM/400 notification) STILLWATER BLVD.N  ICR #113011533  DISPATCH",
        "ADDR:STILLWATER BLVD N",
        "ID:113011533",
        "CALL:DISPATCH");

    doTest("T29",
        "(ICOM/400 notification) 10997.32ND ST.N  ICR #113011489  DISPATCH",
        "ADDR:10997 32ND ST N",
        "ID:113011489",
        "CALL:DISPATCH");

    doTest("T30",
        "(ICOM/400 notification) 443.CIMARRON  ICR #113011195  DISPATCH",
        "ADDR:443 CIMARRON",
        "ID:113011195",
        "CALL:DISPATCH");
    
  }
  
  @Test
  public void testStillwaterFire() {

    doTest("T1",
        "(ICOM/400 notification) 212.2ND ST.N.611  ICR #113203531  DISPATCH",
        "ADDR:212 2ND ST N",
        "APT:611",
        "ID:113203531",
        "CALL:DISPATCH");

    doTest("T2",
        "(ICOM/400 notification) 1500.CURVE CREST BLVD..  ICR #113203520  DISPATCH",
        "ADDR:1500 CURVE CREST BLVD",
        "ID:113203520",
        "CALL:DISPATCH");

    doTest("T3",
        "(ICOM/400 notification) 1826.NORTHWESTERN AV  ICR #113203509  DISPATCH",
        "ADDR:1826 NORTHWESTERN AV",
        "MADDR:1826 NORTHWESTERN AVE",
        "ID:113203509",
        "CALL:DISPATCH");

    doTest("T4",
        "(ICOM/400 notification) 1119.OWENS ST.N.4  ICR #113203508  DISPATCH",
        "ADDR:1119 OWENS ST N",
        "APT:4",
        "ID:113203508",
        "CALL:DISPATCH");

    doTest("T5",
        "(ICOM/400 notification) 15130.SQUARE LAKE TR.N  ICR #113013802  DISPATCH",
        "ADDR:15130 SQUARE LAKE TR N",
        "ID:113013802",
        "CALL:DISPATCH");

    doTest("T6",
        "(ICOM/400 notification) 1124.LINDEN ST.W  ICR #113203503  DISPATCH",
        "ADDR:1124 LINDEN ST W",
        "ID:113203503",
        "CALL:DISPATCH");

    doTest("T7",
        "(ICOM/400 notification) PINE ST  ICR #113203489  DISPATCH",
        "ADDR:PINE ST",
        "ID:113203489",
        "CALL:DISPATCH");

    doTest("T8",
        "(ICOM/400 notification) 630.MAIN ST.N  ICR #113203487  DISPATCH",
        "ADDR:630 MAIN ST N",
        "ID:113203487",
        "CALL:DISPATCH");

    doTest("T9",
        "(ICOM/400 notification) 13311.SQUARE LAKE TR.N  ICR #113013714  DISPATCH",
        "ADDR:13311 SQUARE LAKE TR N",
        "ID:113013714",
        "CALL:DISPATCH");

    doTest("T10",
        "(ICOM/400 notification) 1119.OWENS ST.N.9  ICR #113203476  DISPATCH",
        "ADDR:1119 OWENS ST N",
        "APT:9",
        "ID:113203476",
        "CALL:DISPATCH");

    doTest("T11",
        "(ICOM/400 notification) 3RD ST.N  ICR #113203473  DISPATCH",
        "ADDR:3RD ST N",
        "ID:113203473",
        "CALL:DISPATCH");

    doTest("T12",
        "(ICOM/400 notification) 1255.PONDVIEW LN..7  ICR #113203470  DISPATCH",
        "ADDR:1255 PONDVIEW LN",
        "APT:7",
        "ID:113203470",
        "CALL:DISPATCH");

    doTest("T13",
        "(ICOM/400 notification) CURVE CREST BLVD.  ICR #113203467  DISPATCH",
        "ADDR:CURVE CREST BLVD",
        "ID:113203467",
        "CALL:DISPATCH");

    doTest("T14",
        "(ICOM/400 notification) LANSING AV.N  ICR #113013657  DISPATCH",
        "ADDR:LANSING AV N",
        "MADDR:LANSING AVE N",
        "ID:113013657",
        "CALL:DISPATCH");

    doTest("T15",
        "(ICOM/400 notification) 215.WILLIAM ST.N  ICR #113203443  DISPATCH",
        "ADDR:215 WILLIAM ST N",
        "ID:113203443",
        "CALL:DISPATCH");

    doTest("T16",
        "(ICOM/400 notification) 1370.CURVE CREST BLVD..  ICR #113203437  DISPATCH",
        "ADDR:1370 CURVE CREST BLVD",
        "ID:113203437",
        "CALL:DISPATCH");

    doTest("T17",
        "(ICOM/400 notification) 215.MAIN ST.S  ICR #113203410  DISPATCH",
        "ADDR:215 MAIN ST S",
        "ID:113203410",
        "CALL:DISPATCH");

    doTest("T18",
        "(ICOM/400 notification) 2775.SADDLE CT..6  ICR #113203400  DISPATCH",
        "ADDR:2775 SADDLE CT",
        "APT:6",
        "ID:113203400",
        "CALL:DISPATCH");

    doTest("T19",
        "(ICOM/400 notification) 319.BURLINGTON ST.E  ICR #113203398  DISPATCH",
        "ADDR:319 BURLINGTON ST E",
        "ID:113203398",
        "CALL:DISPATCH");

    doTest("T20",
        "(ICOM/400 notification) STONEBRIDGE TR  ICR #113013410  DISPATCH",
        "ADDR:STONEBRIDGE TR",
        "ID:113013410",
        "CALL:DISPATCH");

    doTest("T21",
        "(ICOM/400 notification) 1500.CURVE CREST BLVD  ICR #113203396  DISPATCH",
        "ADDR:1500 CURVE CREST BLVD",
        "ID:113203396",
        "CALL:DISPATCH");

    doTest("T22",
        "(ICOM/400 notification) 2519.INTERLACHEN DR  ICR #113203383  DISPATCH",
        "ADDR:2519 INTERLACHEN DR",
        "ID:113203383",
        "CALL:DISPATCH");

    doTest("T23",
        "(ICOM/400 notification) 1825.CURVE CREST BLVD..  ICR #113203375  DISPATCH",
        "ADDR:1825 CURVE CREST BLVD",
        "ID:113203375",
        "CALL:DISPATCH");

    doTest("T24",
        "(ICOM/400 notification) 927.CHURCHILL ST.W.  ICR #113203363  DISPATCH",
        "ADDR:927 CHURCHILL ST W",
        "ID:113203363",
        "CALL:DISPATCH");

    doTest("T25",
        "(ICOM/400 notification) 1119.OWENS ST.N.10  ICR #113203357  DISPATCH",
        "ADDR:1119 OWENS ST N",
        "APT:10",
        "ID:113203357",
        "CALL:DISPATCH");

    doTest("T26",
        "(ICOM/400 notification) 2845.BREWERS LN..8  ICR #113203355  DISPATCH",
        "ADDR:2845 BREWERS LN",
        "APT:8",
        "ID:113203355",
        "CALL:DISPATCH");

    doTest("T27",
        "(ICOM/400 notification) 604.LAUREL ST.W  ICR #113203354  DISPATCH",
        "ADDR:604 LAUREL ST W",
        "ID:113203354",
        "CALL:DISPATCH");

    doTest("T28",
        "(ICOM/400 notification) 326.MELVILLE CT.N.  ICR #113203325  DISPATCH",
        "ADDR:326 MELVILLE CT N",
        "ID:113203325",
        "CALL:DISPATCH");

    doTest("T29",
        "(ICOM/400 notification) 1119.OWENS ST.N  ICR #113203321  DISPATCH",
        "ADDR:1119 OWENS ST N",
        "ID:113203321",
        "CALL:DISPATCH");

    doTest("T30",
        "(ICOM/400 notification) 409.WILKINS ST.W  ICR #113203320  DISPATCH",
        "ADDR:409 WILKINS ST W",
        "ID:113203320",
        "CALL:DISPATCH");

  }
  
  @Test
  public void testWoodburyPublicSafety() {

    doTest("T1",
        "(ICOM/400 notification) 7116.WINDGATE RD..  ICR #113609673  DISPATCH",
        "ADDR:7116 WINDGATE RD",
        "ID:113609673",
        "CALL:DISPATCH");

    doTest("T2",
        "(ICOM/400 notification) 8906.SAINT CROIX RD  ICR #113609667  DISPATCH",
        "ADDR:8906 SAINT CROIX RD",
        "ID:113609667",
        "CALL:DISPATCH");

    doTest("T3",
        "(ICOM/400 notification) 6.EVERGREEN DR  ICR #113013934  DISPATCH",
        "ADDR:6 EVERGREEN DR",
        "ID:113013934",
        "CALL:DISPATCH");

    doTest("T4",
        "(ICOM/400 notification) 4125.RADIO DR  ICR #113609661  DISPATCH",
        "ADDR:4125 RADIO DR",
        "ID:113609661",
        "CALL:DISPATCH");

    doTest("T5",
        "(ICOM/400 notification) 7360.33RD ST.N  ICR #113303630  DISPATCH",
        "ADDR:7360 33RD ST N",
        "ID:113303630",
        "CALL:DISPATCH");

    doTest("T6",
        "(ICOM/400 notification) STILLWATER BLVD.N  ICR #113013925  DISPATCH",
        "ADDR:STILLWATER BLVD N",
        "ID:113013925",
        "CALL:DISPATCH");

    doTest("T7",
        "(ICOM/400 notification) 4125.RADIO DR  ICR #113609652  DISPATCH",
        "ADDR:4125 RADIO DR",
        "ID:113609652",
        "CALL:DISPATCH");

    doTest("T8",
        "(ICOM/400 notification) 8675.VALLEY CREEK RD  ICR #113609643  DISPATCH",
        "ADDR:8675 VALLEY CREEK RD",
        "ID:113609643",
        "CALL:DISPATCH");

    doTest("T9",
        "(ICOM/400 notification) 4994.HAMLET AV.N  ICR #113303624  DISPATCH",
        "ADDR:4994 HAMLET AV N",
        "MADDR:4994 HAMLET AVE N",
        "ID:113303624",
        "CALL:DISPATCH");

    doTest("T10",
        "(ICOM/400 notification) 4300.RADIO DR  ICR #113609637  DISPATCH",
        "ADDR:4300 RADIO DR",
        "ID:113609637",
        "CALL:DISPATCH");

    doTest("T11",
        "(ICOM/400 notification) 4994.HAMLET AV.N  ICR #113303624  DISPATCH",
        "ADDR:4994 HAMLET AV N",
        "MADDR:4994 HAMLET AVE N",
        "ID:113303624",
        "CALL:DISPATCH");

    doTest("T12",
        "(ICOM/400 notification) 1850.WEIR DR..3  ICR #113609636  DISPATCH",
        "ADDR:1850 WEIR DR",
        "APT:3",
        "ID:113609636",
        "CALL:DISPATCH");

    doTest("T13",
        "(ICOM/400 notification) 1918.EVERGREEN ECHO  ICR #113609620  DISPATCH",
        "ADDR:1918 EVERGREEN ECHO",
        "ID:113609620",
        "CALL:DISPATCH");

    doTest("T14",
        "(ICOM/400 notification) 8725.PROMENADE LN..248  ICR #113609617  DISPATCH",
        "ADDR:8725 PROMENADE LN",
        "APT:248",
        "ID:113609617",
        "CALL:DISPATCH");

    doTest("T15",
        "(ICOM/400 notification) 1201.HADLEY AV.N.315  ICR #113303621  DISPATCH",
        "ADDR:1201 HADLEY AV N",
        "MADDR:1201 HADLEY AVE N",
        "APT:315",
        "ID:113303621",
        "CALL:DISPATCH");

    doTest("T16",
        "(ICOM/400 notification) 8450.SEASONS PKWY  ICR #113609615  DISPATCH",
        "ADDR:8450 SEASONS PKWY",
        "ID:113609615",
        "CALL:DISPATCH");

    doTest("T17",
        "(ICOM/400 notification) 6281.15TH ST.N  ICR #113303612  DISPATCH",
        "ADDR:6281 15TH ST N",
        "ID:113303612",
        "CALL:DISPATCH");

    doTest("T18",
        "(ICOM/400 notification) 7900.32ND ST.N  ICR #113303610  DISPATCH",
        "ADDR:7900 32ND ST N",
        "ID:113303610",
        "CALL:DISPATCH");

    doTest("T19",
        "(ICOM/400 notification) 3079.JUNIPER LN..E  ICR #113609596  DISPATCH",
        "ADDR:3079 JUNIPER LN E",
        "ID:113609596",
        "CALL:DISPATCH");

    doTest("T20",
        "(ICOM/400 notification) 8133.4TH ST.N  ICR #113303606  DISPATCH",
        "ADDR:8133 4TH ST N",
        "ID:113303606",
        "CALL:DISPATCH");

    doTest("T21",
        "(ICOM/400 notification) 7899.FOREST BLVD..A  ICR #113609576  DISPATCH",
        "ADDR:7899 FOREST BLVD",
        "APT:A",
        "ID:113609576",
        "CALL:DISPATCH");

    doTest("T22",
        "(ICOM/400 notification) 7008.LAKE RD..223  ICR #113609573  DISPATCH",
        "ADDR:7008 LAKE RD",
        "APT:223",
        "ID:113609573",
        "CALL:DISPATCH");

    doTest("T23",
        "(ICOM/400 notification) 4511.HILLVALE AV.N  ICR #113303597  DISPATCH",
        "ADDR:4511 HILLVALE AV N",
        "MADDR:4511 HILLVALE AVE N",
        "ID:113303597",
        "CALL:DISPATCH");

    doTest("T24",
        "(ICOM/400 notification) 2361.FIELDSTONE CURVE..  ICR #113609564  DISPATCH",
        "ADDR:2361 FIELDSTONE CURVE",
        "ID:113609564",
        "CALL:DISPATCH");

    doTest("T25",
        "(ICOM/400 notification) 2150.RADIO DR.  ICR #113609558  DISPATCH",
        "ADDR:2150 RADIO DR",
        "ID:113609558",
        "CALL:DISPATCH");

    doTest("T26",
        "(ICOM/400 notification) 1318.CLEARWATER DR  ICR #113609559  DISPATCH",
        "ADDR:1318 CLEARWATER DR",
        "ID:113609559",
        "CALL:DISPATCH");

    doTest("T27",
        "(ICOM/400 notification) 6580.SANDLEWOOD RD  ICR #113609550  DISPATCH",
        "ADDR:6580 SANDLEWOOD RD",
        "ID:113609550",
        "CALL:DISPATCH");

    doTest("T28",
        "(ICOM/400 notification) 10813.MAPLE BLVD  ICR #113609551  DISPATCH",
        "ADDR:10813 MAPLE BLVD",
        "ID:113609551",
        "CALL:DISPATCH");

    doTest("T29",
        "(ICOM/400 notification) 1385.GENTRY AV.N  ICR #113303593  DISPATCH",
        "ADDR:1385 GENTRY AV N",
        "MADDR:1385 GENTRY AVE N",
        "ID:113303593",
        "CALL:DISPATCH");

    doTest("T30",
        "(ICOM/400 notification) 1281.HELMO AV.N  ICR #113303591  DISPATCH",
        "ADDR:1281 HELMO AV N",
        "MADDR:1281 HELMO AVE N",
        "ID:113303591",
        "CALL:DISPATCH");

  }
  
  @Test
  public void testBayportFireDepartment() {

    doTest("T1",
        "(ICOM/400 notification) 15154.62ND ST.N  ICR #113701822  DISPATCH",
        "ADDR:15154 62ND ST N",
        "ID:113701822",
        "CALL:DISPATCH");

    doTest("T2",
        "(ICOM/400 notification) 5800.NEAL AV.N  ICR #113701799  DISPATCH",
        "ADDR:5800 NEAL AV N",
        "MADDR:5800 NEAL AVE N",
        "ID:113701799",
        "CALL:DISPATCH");

    doTest("T3",
        "(ICOM/400 notification) 750.HWY 95.N  ICR #113501040  DISPATCH",
        "ADDR:750 HWY 95 N",
        "ID:113501040",
        "CALL:DISPATCH");

    doTest("T4",
        "(ICOM/400 notification) 280.7TH ST.N  ICR #113501039  DISPATCH",
        "ADDR:280 7TH ST N",
        "ID:113501039",
        "CALL:DISPATCH");

    doTest("T5",
        "(ICOM/400 notification) 13936.LOWER 59TH ST.N  ICR #113701796  DISPATCH",
        "ADDR:13936 LOWER 59TH ST N",
        "ID:113701796",
        "CALL:DISPATCH");

    doTest("T6",
        "(ICOM/400 notification) 5590.NORWICH PKWY  ICR #113701794  DISPATCH",
        "ADDR:5590 NORWICH PKWY",
        "ID:113701794",
        "CALL:DISPATCH");

    doTest("T7",
        "(ICOM/400 notification) 13025.60TH ST.N  ICR #113701791  DISPATCH",
        "ADDR:13025 60TH ST N",
        "ID:113701791",
        "CALL:DISPATCH");

    doTest("T8",
        "(ICOM/400 notification) 4706.MCDONALD DR PL.N  ICR #113013676  DISPATCH",
        "ADDR:4706 MCDONALD DR PL N",
        "ID:113013676",
        "CALL:DISPATCH");

    doTest("T9",
        "(ICOM/400 notification) 2114.STAGECOACH TR.N  ICR #113013662  DISPATCH",
        "ADDR:2114 STAGECOACH TR N",
        "ID:113013662",
        "CALL:DISPATCH");

    doTest("T10",
        "(ICOM/400 notification) 5329.OSGOOD AV.N  ICR #113701782  DISPATCH",
        "ADDR:5329 OSGOOD AV N",
        "MADDR:5329 OSGOOD AVE N",
        "ID:113701782",
        "CALL:DISPATCH");

    doTest("T11",
        "(ICOM/400 notification) 13025.60TH ST.N  ICR #113701779  DISPATCH",
        "ADDR:13025 60TH ST N",
        "ID:113701779",
        "CALL:DISPATCH");

    doTest("T12",
        "(ICOM/400 notification) 14100.HWY I94  ICR #113013618  DISPATCH",
        "ADDR:14100 I-94",
        "MADDR:14100 I 94",
        "ID:113013618",
        "CALL:DISPATCH");

    doTest("T13",
        "(ICOM/400 notification) 970.PICKETT ST.N  ICR #113501026  DISPATCH",
        "ADDR:970 PICKETT ST N",
        "ID:113501026",
        "CALL:DISPATCH");

    doTest("T14",
        "(ICOM/400 notification) HWY 94  ICR #113013601  DISPATCH",
        "ADDR:HWY 94",
        "ID:113013601",
        "CALL:DISPATCH");

    doTest("T15",
        "(ICOM/400 notification) 14830.58TH ST.N.104  ICR #113701774  DISPATCH",
        "ADDR:14830 58TH ST N",
        "APT:104",
        "ID:113701774",
        "CALL:DISPATCH");

    doTest("T16",
        "(ICOM/400 notification) 6060.OXBORO AV.N.111  ICR #113701767  DISPATCH",
        "ADDR:6060 OXBORO AV N",
        "MADDR:6060 OXBORO AVE N",
        "APT:111",
        "ID:113701767",
        "CALL:DISPATCH");

    doTest("T17",
        "(ICOM/400 notification) 5282.NOLAN PKWY.N.  ICR #113701759  DISPATCH",
        "ADDR:5282 NOLAN PKWY N",
        "ID:113701759",
        "CALL:DISPATCH");

    doTest("T18",
        "(ICOM/400 notification) 13045.53RD ST PL.N  ICR #113013390  DISPATCH",
        "ADDR:13045 53RD ST PL N",
        "ID:113013390",
        "CALL:DISPATCH");

    doTest("T19",
        "(ICOM/400 notification) 6060.OXBORO AV.N.227  ICR #113701741  DISPATCH",
        "ADDR:6060 OXBORO AV N",
        "MADDR:6060 OXBORO AVE N",
        "APT:227",
        "ID:113701741",
        "CALL:DISPATCH");

    doTest("T20",
        "(ICOM/400 notification) 5601.NORWICH PKWY  ICR #113701737  DISPATCH",
        "ADDR:5601 NORWICH PKWY",
        "ID:113701737",
        "CALL:DISPATCH");

    doTest("T21",
        "(ICOM/400 notification) 4401.OSGOOD AV.N  ICR #113013219  DISPATCH",
        "ADDR:4401 OSGOOD AV N",
        "MADDR:4401 OSGOOD AVE N",
        "ID:113013219",
        "CALL:DISPATCH");

    doTest("T22",
        "(ICOM/400 notification) 5600.NORWICH PKWY..225  ICR #113701719  DISPATCH",
        "ADDR:5600 NORWICH PKWY",
        "APT:225",
        "ID:113701719",
        "CALL:DISPATCH");

    doTest("T23",
        "(ICOM/400 notification) 5329.OSGOOD AV.N  ICR #113701715  DISPATCH",
        "ADDR:5329 OSGOOD AV N",
        "MADDR:5329 OSGOOD AVE N",
        "ID:113701715",
        "CALL:DISPATCH");

    doTest("T24",
        "(ICOM/400 notification) 6060.OXBORO AV.N.128  ICR #113701707  DISPATCH",
        "ADDR:6060 OXBORO AV N",
        "MADDR:6060 OXBORO AVE N",
        "APT:128",
        "ID:113701707",
        "CALL:DISPATCH");

    doTest("T25",
        "(ICOM/400 notification) 13936.LOWER 59TH ST.N.4  ICR #113701705  DISPATCH",
        "ADDR:13936 LOWER 59TH ST N",
        "APT:4",
        "ID:113701705",
        "CALL:DISPATCH");

    doTest("T26",
        "(ICOM/400 notification) 5804.NEAL AV.N  ICR #113701703  DISPATCH",
        "ADDR:5804 NEAL AV N",
        "MADDR:5804 NEAL AVE N",
        "ID:113701703",
        "CALL:DISPATCH");

    doTest("T27",
        "(ICOM/400 notification) I94  ICR #113013023  DISPATCH",
        "ADDR:I-94",
        "MADDR:I 94",
        "ID:113013023",
        "CALL:DISPATCH");

    doTest("T28",
        "(ICOM/400 notification) 750.HWY 95.N.22  ICR #113500961  DISPATCH",
        "ADDR:750 HWY 95 N",
        "APT:22",
        "ID:113500961",
        "CALL:DISPATCH");

    doTest("T29",
        "(ICOM/400 notification) 14532.57TH ST.N  ICR #113701698  DISPATCH",
        "ADDR:14532 57TH ST N",
        "ID:113701698",
        "CALL:DISPATCH");

    doTest("T30",
        "(ICOM/400 notification) 5903.NEAL AV.N  ICR #113701694  DISPATCH",
        "ADDR:5903 NEAL AV N",
        "MADDR:5903 NEAL AVE N",
        "ID:113701694",
        "CALL:DISPATCH");

    doTest("T31",
        "(ICOM/400 notification) 5610.NORWICH PKWY..330  ICR #113701693  DISPATCH",
        "ADDR:5610 NORWICH PKWY",
        "APT:330",
        "ID:113701693",
        "CALL:DISPATCH");

    doTest("T32",
        "(ICOM/400 notification) 13575.58TH ST.N  ICR #113701691  DISPATCH",
        "ADDR:13575 58TH ST N",
        "ID:113701691",
        "CALL:DISPATCH");

    doTest("T33",
        "(ICOM/400 notification) 5260.NOLAN PKWY.N.C103  ICR #113701682  DISPATCH",
        "ADDR:5260 NOLAN PKWY N",
        "APT:C103",
        "ID:113701682",
        "CALL:DISPATCH");

    doTest("T34",
        "(ICOM/400 notification) MANNING AV.N  ICR #113012845  DISPATCH",
        "ADDR:MANNING AV N",
        "MADDR:MANNING AVE N",
        "ID:113012845",
        "CALL:DISPATCH");

    doTest("T35",
        "(ICOM/400 notification) 13936.LOWER 59TH ST.N.  ICR #113701681  DISPATCH",
        "ADDR:13936 LOWER 59TH ST N",
        "ID:113701681",
        "CALL:DISPATCH");

    doTest("T36",
        "(ICOM/400 notification) 13936.LOWER 59TH ST.N.4  ICR #113701672  DISPATCH",
        "ADDR:13936 LOWER 59TH ST N",
        "APT:4",
        "ID:113701672",
        "CALL:DISPATCH");

    doTest("T37",
        "(ICOM/400 notification) 13575.58TH ST.N  ICR #113701669  DISPATCH",
        "ADDR:13575 58TH ST N",
        "ID:113701669",
        "CALL:DISPATCH");

    doTest("T38",
        "(ICOM/400 notification) 5800.KRUEGER LN.N.  ICR #113701660  DISPATCH",
        "ADDR:5800 KRUEGER LN N",
        "ID:113701660",
        "CALL:DISPATCH");

    doTest("T39",
        "(ICOM/400 notification) 4706.MCDONALD DR PL.N.  ICR #113012713  DISPATCH",
        "ADDR:4706 MCDONALD DR PL N",
        "ID:113012713",
        "CALL:DISPATCH");

    doTest("T40",
        "(ICOM/400 notification) 5590.NORWICH PKWY..304  ICR #113701658  DISPATCH",
        "ADDR:5590 NORWICH PKWY",
        "APT:304",
        "ID:113701658",
        "CALL:DISPATCH");

    doTest("T41",
        "(ICOM/400 notification) 4020.MCDONALD DR.N.  ICR #113012668  DISPATCH",
        "ADDR:4020 MCDONALD DR N",
        "ID:113012668",
        "CALL:DISPATCH");

    doTest("T42",
        "(ICOM/400 notification) 14787.UPPER 56TH ST.N  ICR #113701644  DISPATCH",
        "ADDR:14787 UPPER 56TH ST N",
        "ID:113701644",
        "CALL:DISPATCH");

    doTest("T43",
        "(ICOM/400 notification) 415.9TH ST.N  ICR #113500931  DISPATCH",
        "ADDR:415 9TH ST N",
        "ID:113500931",
        "CALL:DISPATCH");

    doTest("T44",
        "(ICOM/400 notification) ST MICHAELS CEMETARY  ICR #113500927  DISPATCH",
        "ADDR:ST MICHAELS CEMETARY",
        "ID:113500927",
        "CALL:DISPATCH");

    doTest("T45",
        "(ICOM/400 notification) 294.3RD ST.N  ICR #113500921  DISPATCH",
        "ADDR:294 3RD ST N",
        "ID:113500921",
        "CALL:DISPATCH");

    doTest("T46",
        "(ICOM/400 notification) 11776.HARVEST PATH  ICR #113608687  DISPATCH",
        "ADDR:11776 HARVEST PATH",
        "ID:113608687",
        "CALL:DISPATCH");

    doTest("T47",
        "(ICOM/400 notification) 6413.SAINT CROIX TR.N  ICR #113701629  DISPATCH",
        "ADDR:6413 SAINT CROIX TR N",
        "ID:113701629",
        "CALL:DISPATCH");

    doTest("T48",
        "(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500915  DISPATCH",
        "ADDR:970 PICKETT ST N",
        "ID:113500915",
        "CALL:DISPATCH");

    doTest("T49",
        "(ICOM/400 notification) LE/10TH  ICR #113012499  DISPATCH",
        "ADDR:LE & 10TH",
        "ID:113012499",
        "CALL:DISPATCH");

    doTest("T50",
        "(ICOM/400 notification) OAKGREEN AV.N  ICR #113701628  DISPATCH",
        "ADDR:OAKGREEN AV N",
        "MADDR:OAKGREEN AVE N",
        "ID:113701628",
        "CALL:DISPATCH");

    doTest("T51",
        "(ICOM/400 notification) 5329.OSGOOD AV.N  ICR #113701616  DISPATCH",
        "ADDR:5329 OSGOOD AV N",
        "MADDR:5329 OSGOOD AVE N",
        "ID:113701616",
        "CALL:DISPATCH");

    doTest("T52",
        "(ICOM/400 notification) 3275.MANNING AV.N  ICR #113012373  DISPATCH",
        "ADDR:3275 MANNING AV N",
        "MADDR:3275 MANNING AVE N",
        "ID:113012373",
        "CALL:DISPATCH");

    doTest("T53",
        "(ICOM/400 notification) 750.HWY 95.N.112  ICR #113500906  DISPATCH",
        "ADDR:750 HWY 95 N",
        "APT:112",
        "ID:113500906",
        "CALL:DISPATCH");

    doTest("T54",
        "(ICOM/400 notification) 14830.58TH ST.N  ICR #113701611  DISPATCH",
        "ADDR:14830 58TH ST N",
        "ID:113701611",
        "CALL:DISPATCH");

    doTest("T55",
        "(ICOM/400 notification) 5590.NORWICH PKWY..116  ICR #113701609  DISPATCH",
        "ADDR:5590 NORWICH PKWY",
        "APT:116",
        "ID:113701609",
        "CALL:DISPATCH");

    doTest("T56",
        "(ICOM/400 notification) 14843.57TH ST.N  ICR #113701605  DISPATCH",
        "ADDR:14843 57TH ST N",
        "ID:113701605",
        "CALL:DISPATCH");

    doTest("T57",
        "(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500900  DISPATCH",
        "ADDR:970 PICKETT ST N",
        "ID:113500900",
        "CALL:DISPATCH");

    doTest("T58",
        "(ICOM/400 notification) 5712.NORWICH CIR.N.  ICR #113701592  DISPATCH",
        "ADDR:5712 NORWICH CIR N",
        "ID:113701592",
        "CALL:DISPATCH");

    doTest("T59",
        "(ICOM/400 notification) 2 LAKE CIRCLE DR  ICR #113500895  DISPATCH",
        "ADDR:2 LAKE CIRCLE DR",
        "ID:113500895",
        "CALL:DISPATCH");

    doTest("T60",
        "(ICOM/400 notification) 6060.OXBORO AV.N.129  ICR #113701574  DISPATCH",
        "ADDR:6060 OXBORO AV N",
        "MADDR:6060 OXBORO AVE N",
        "APT:129",
        "ID:113701574",
        "CALL:DISPATCH");

    doTest("T61",
        "(ICOM/400 notification) 472.MINNESOTA ST.S  ICR #113500883  DISPATCH",
        "ADDR:472 MINNESOTA ST S",
        "ID:113500883",
        "CALL:DISPATCH");

    doTest("T62",
        "(ICOM/400 notification) 4503.OSGOOD AV.N.  ICR #113203001  DISPATCH",
        "ADDR:4503 OSGOOD AV N",
        "MADDR:4503 OSGOOD AVE N",
        "ID:113203001",
        "CALL:DISPATCH");

    doTest("T63",
        "(ICOM/400 notification) 14830.58TH ST.N.500  ICR #113701551  DISPATCH",
        "ADDR:14830 58TH ST N",
        "APT:500",
        "ID:113701551",
        "CALL:DISPATCH");

    doTest("T64",
        "(ICOM/400 notification) 13575.58TH ST.N.214  ICR #113701549  DISPATCH",
        "ADDR:13575 58TH ST N",
        "APT:214",
        "ID:113701549",
        "CALL:DISPATCH");

    doTest("T65",
        "(ICOM/400 notification) 5600.NORWICH PKWY  ICR #113701534  DISPATCH",
        "ADDR:5600 NORWICH PKWY",
        "ID:113701534",
        "CALL:DISPATCH");

    doTest("T66",
        "(ICOM/400 notification) 14830.58TH ST.N.305  ICR #113701531  DISPATCH",
        "ADDR:14830 58TH ST N",
        "APT:305",
        "ID:113701531",
        "CALL:DISPATCH");

    doTest("T67",
        "(ICOM/400 notification) 750.HWY 95.N  ICR #113500863  DISPATCH",
        "ADDR:750 HWY 95 N",
        "ID:113500863",
        "CALL:DISPATCH");

    doTest("T68",
        "(ICOM/400 notification) I94  ICR #113011556  DISPATCH",
        "ADDR:I-94",
        "MADDR:I 94",
        "ID:113011556",
        "CALL:DISPATCH");

    doTest("T69",
        "(ICOM/400 notification) 5815.KRUEGER LN.N.  ICR #113701506  DISPATCH",
        "ADDR:5815 KRUEGER LN N",
        "ID:113701506",
        "CALL:DISPATCH");

    doTest("T70",
        "(ICOM/400 notification) 4271.NORTHBROOK BLVD.N  ICR #113011326  DISPATCH",
        "ADDR:4271 NORTHBROOK BLVD N",
        "ID:113011326",
        "CALL:DISPATCH");

    doTest("T71",
        "(ICOM/400 notification) 40TH ST.N  ICR #113011082  DISPATCH",
        "ADDR:40TH ST N",
        "ID:113011082",
        "CALL:DISPATCH");

    doTest("T72",
        "(ICOM/400 notification) I94  ICR #113011076  DISPATCH",
        "ADDR:I-94",
        "MADDR:I 94",
        "ID:113011076",
        "CALL:DISPATCH");

    doTest("T73",
        "(ICOM/400 notification) 12240.27TH ST.N.  ICR #113011074  DISPATCH",
        "ADDR:12240 27TH ST N",
        "ID:113011074",
        "CALL:DISPATCH");

    doTest("T74",
        "(ICOM/400 notification) 13523.60TH ST.N  ICR #113701460  DISPATCH",
        "ADDR:13523 60TH ST N",
        "ID:113701460",
        "CALL:DISPATCH");

    doTest("T75",
        "(ICOM/400 notification) 5815.NORELL AV.N  ICR #113701459  DISPATCH",
        "ADDR:5815 NORELL AV N",
        "MADDR:5815 NORELL AVE N",
        "ID:113701459",
        "CALL:DISPATCH");

    doTest("T76",
        "(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500820  DISPATCH",
        "ADDR:970 PICKETT ST N",
        "ID:113500820",
        "CALL:DISPATCH");

    doTest("T77",
        "(ICOM/400 notification) 5815.NORELL AV.N  ICR #113701456  DISPATCH",
        "ADDR:5815 NORELL AV N",
        "MADDR:5815 NORELL AVE N",
        "ID:113701456",
        "CALL:DISPATCH");

    doTest("T78",
        "(ICOM/400 notification) 13936.LOWER 59TH ST.N  ICR #113701455  DISPATCH",
        "ADDR:13936 LOWER 59TH ST N",
        "ID:113701455",
        "CALL:DISPATCH");

    doTest("T79",
        "(ICOM/400 notification) 13575.58TH ST.N  ICR #113701450  DISPATCH",
        "ADDR:13575 58TH ST N",
        "ID:113701450",
        "CALL:DISPATCH");

    doTest("T80",
        "(ICOM/400 notification) 15021.60TH ST.N  ICR #113701443  DISPATCH",
        "ADDR:15021 60TH ST N",
        "ID:113701443",
        "CALL:DISPATCH");

    doTest("T81",
        "(ICOM/400 notification) 4260.STAGECOACH TR.N  ICR #113010889  DISPATCH",
        "ADDR:4260 STAGECOACH TR N",
        "ID:113010889",
        "CALL:DISPATCH");

    doTest("T82",
        "(ICOM/400 notification) 970.PICKETT ST.N  ICR #113500796  DISPATCH",
        "ADDR:970 PICKETT ST N",
        "ID:113500796",
        "CALL:DISPATCH");

    doTest("T83",
        "(ICOM/400 notification) 1720.OAKGREEN AV.N  ICR #113010819  DISPATCH",
        "ADDR:1720 OAKGREEN AV N",
        "MADDR:1720 OAKGREEN AVE N",
        "ID:113010819",
        "CALL:DISPATCH");

    doTest("T84",
        "(ICOM/400 notification) 5485.NOLAN AV.N  ICR #113701422  DISPATCH",
        "ADDR:5485 NOLAN AV N",
        "MADDR:5485 NOLAN AVE N",
        "ID:113701422",
        "CALL:DISPATCH");

    doTest("T85",
        "(ICOM/400 notification) 1127.NOLAN AV.N  ICR #113010703  DISPATCH",
        "ADDR:1127 NOLAN AV N",
        "MADDR:1127 NOLAN AVE N",
        "ID:113010703",
        "CALL:DISPATCH");

    doTest("T86",
        "(ICOM/400 notification) 5520.MEMORIAL AV.N  ICR #113701392  DISPATCH",
        "ADDR:5520 MEMORIAL AV N",
        "MADDR:5520 MEMORIAL AVE N",
        "ID:113701392",
        "CALL:DISPATCH");

    doTest("T87",
        "(ICOM/400 notification) 655.2ND ST.N  ICR #113500776  DISPATCH",
        "ADDR:655 2ND ST N",
        "ID:113500776",
        "CALL:DISPATCH");

    doTest("T88",
        "(ICOM/400 notification) 14830.58TH ST.N.408  ICR #113701389  DISPATCH",
        "ADDR:14830 58TH ST N",
        "APT:408",
        "ID:113701389",
        "CALL:DISPATCH");

    doTest("T89",
        "(ICOM/400 notification) 13575.58TH ST.N.157  ICR #113701370  DISPATCH",
        "ADDR:13575 58TH ST N",
        "APT:157",
        "ID:113701370",
        "CALL:DISPATCH");

    doTest("T90",
        "(ICOM/400 notification) 263.3RD ST.N  ICR #113500765  DISPATCH",
        "ADDR:263 3RD ST N",
        "ID:113500765",
        "CALL:DISPATCH");

    doTest("T91",
        "(ICOM/400 notification) 5590.NORWICH AV.N  ICR #113701347  DISPATCH",
        "ADDR:5590 NORWICH AV N",
        "MADDR:5590 NORWICH AVE N",
        "ID:113701347",
        "CALL:DISPATCH");

    doTest("T92",
        "(ICOM/400 notification) 14830.58TH ST.N  ICR #113701346  DISPATCH",
        "ADDR:14830 58TH ST N",
        "ID:113701346",
        "CALL:DISPATCH");

    doTest("T93",
        "(ICOM/400 notification) 13796.55TH ST.N  ICR #113701343  DISPATCH",
        "ADDR:13796 55TH ST N",
        "ID:113701343",
        "CALL:DISPATCH");

    doTest("T94",
        "(ICOM/400 notification) 15200.UPPER 63RD ST.N  ICR #113701338  DISPATCH",
        "ADDR:15200 UPPER 63RD ST N",
        "ID:113701338",
        "CALL:DISPATCH");

    doTest("T95",
        "(ICOM/400 notification) 750.HWY 95.N  ICR #113500746  DISPATCH",
        "ADDR:750 HWY 95 N",
        "ID:113500746",
        "CALL:DISPATCH");

    doTest("T96",
        "(ICOM/400 notification) 14596.UPPER 56TH ST.N.  ICR #113701323  DISPATCH",
        "ADDR:14596 UPPER 56TH ST N",
        "ID:113701323",
        "CALL:DISPATCH");

    doTest("T97",
        "(ICOM/400 notification) 13220.22ND ST.N  ICR #113010046  DISPATCH",
        "ADDR:13220 22ND ST N",
        "ID:113010046",
        "CALL:DISPATCH");

    doTest("T98",
        "(ICOM/400 notification) 5701.STILLWATER BLVD.N  ICR #113701319  DISPATCH",
        "ADDR:5701 STILLWATER BLVD N",
        "ID:113701319",
        "CALL:DISPATCH");

  }
  
  public static void main(String[] args) {
    new MNWashingtonCountyParserTest().generateTests("T1");
  }
}