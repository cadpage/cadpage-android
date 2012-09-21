package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

/*
Monroeville, PA (in Allegheny County)
Contact: Zach Peters <emtpeters@gmail.com>
Sender: alertts@monroeville.pa.us

[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n538 FIRETHORN DR\nMONROEVILLE\nBTWN: FIELDSTONE DR & N/A\n\nRCVD AS Phone\n\nCOM:\n23Y/O FEMALE SICK / ALPHA\n\nCT:\nMD103 at
[Alert: Breathing]  ALRM LVL: 1\nLOC:\n721 HEARTWOOD DR\nMONROEVILLE\nBTWN: COTTONWOOD DR & COTTONWOOD DR\n\nRCVD AS Phone\n\nCOM:\n94 YO FEMALE/DIFF BREATHING/3RD
[Alert: Fire-Alarm Activation]  ALRM LVL: 1\nLOC:\n245 AZALEA DR\nMONROEVILLE\nBTWN: GARDEN CITY DR & N/A\n\nRCVD AS Phone\n\nCOM:\n2ND FLOOR PULL STATION\n\nCT:\nMD10
[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n540 FIRETHORN DR\nMONROEVILLE\nBTWN: FIELDSTONE DR & N/A\n\nRCVD AS Phone\n\nCOM:\n79 YOF HIGH TEMP, CHILLS, LETHARGIC. BRAvo
[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n3912 BARBARA ANN DR\nMONROEVILLE\nBTWN: EVERGREEN DR & N/A\n\nCOM:\n90Y/O MALE - FAMILY NOW WANTS PT TRANSPORTED TO HOS
[Alert: Abdominal Pain]  ALRM LVL: 1\nLOC:\n166 KEEFER\nPENN HILLS\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n86Y/O MALE ABD PAIN / CHARLIE\n\nCT:\nMD103 at POS 01
[Alert: Fall]  ALRM LVL: 1\nLOC:\n3912 BARBARA ANN DR\nMONROEVILLE\nBTWN: EVERGREEN DR & N/A\n\nRCVD AS Phone\n\nCOM:\n92 YO MALE/FELL/NOT BELIEVED TO BE INJURED/3R
[Alert: Heart Problem]  ALRM LVL: 1\nLOC:\n205 HEATHER DR\nMONROEVILLE\nBTWN: DUFF RD & N/A\n\nRCVD AS Phone\n\nCOM:\nRAPID HEART BEAT\n87 YOF CARDIAC HX. CHARLIE

*/

public class PAMonroevilleParser extends DispatchA1Parser {
  
  public PAMonroevilleParser() {
    super("MONROEVILLE", "PA");
  }
  
  @Override
  public String getFilter() {
    return "alertts@monroeville.pa.us";
  }
}
