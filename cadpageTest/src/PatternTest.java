

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("\n *Loc Info: *(.*?)\r?\n *Name: +(.*?) +Addr: +.*? +Phone: *(.*?) *\r?\n");
  
  public static void main(String[] args) {
    doTest("[911 Data]  <SYSTEM GENERATED> TO INT1 FROM FS01  : \n134\n                                                        \n Inc History for: #ED1215452    Xref:                           #PD121200569 \n Entered      04/29/12  14:13:01  BY CT06   815      \n Dispatched   04/29/12  14:13:56  BY FS01   271      \n Initial Type: BTAI    Initial Alarm Level:  1  Final Alarm Level:  1\n Final Type: BTAI  (TRAFFIC ACCIDENT(NON-CRITICAL)) Pri: 3 Dspo:      Prem: [  ]\n EMS Blk:  134055 Fire Blk:  74055  Police Blk:  48101  Map Page: 3033D7 \n Group: EN  Beat: 134 Src:  N ATT:    \n Loc: 560 W BUTLER AV ,48  btwn SCHOOL HOUSE RD & COUNTY LINE RD\n Loc Info: \n Name: AGERO MONITORING CTR    Addr: 3RD PARTY               Phone:           \n/1413  (815     )  ENTRY:         NRI,,BLOCKING,,2 VEHS,,2 CHILDREN IN VEHS PARE\n                                  NT WANT THEM CHECKED OUT\n/1413  (271     )  DISP    A134    #078910   MCDONAGH, PENELOPE \n                                   #095422   HUTTENLOCK, SCOTT (EMT) \n-- \nDISCLAIMER: This electronic message transmission has been sent by Chalfont Emergency Medical Services, Inc., which may contain confidential or privileged information. This information is intended for the individual or entity named above. If you are not the intended recipient, be aware that any disclosure, copying, distribution or use of the contents of this information is prohibited. If you have received this electronic transmission in error, please notify us immediately by telephone at 215-822-1308 x116, or by electronic mail (reply).\n");
  }
  
  private static void doTest(String test) {
    Matcher match = MASTER.matcher(test);
    System.out.print(test);
    if (! match.find()) {
      System.out.print(" no match");
    } else {
      for (int g = 0; g<=match.groupCount(); g++) {
        System.out.print(" G" + g + ":" + match.group(g));
      }
    }
    System.out.println();
  }

}
