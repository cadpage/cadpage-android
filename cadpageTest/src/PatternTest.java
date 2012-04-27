

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("\n *EMS Blk: +(\\d*) +Fire Blk: +(\\d*) +Police Blk: +\\d* +Map Page: *([A-Z0-9]*) *(?=\n)");
  
  public static void main(String[] args) {
    doTest(" <SYSTEM GENERATED> TO INT1 FROM FS01  : /134\n                                                    \n\n\n Inc History for: #ED1214497\n\n\n Entered      04/21/12  13:09:26  BY FD01   341      \n Dispatched   04/21/12  13:10:58  BY FS01   764      \n\n Initial Type: AUNC    Initial Alarm Level:  1  Final Alarm Level:  1\n Final Type: AUNC  (UNCONSCIOUS PERSON) Pri: 1 Dspo:      Prem: [  ]\n EMS Blk:   Fire Blk:   Police Blk:   Map Page:  \n Group: EX  Beat:  Src:  N ATT:    \n Loc: 721 CYPRESS CT MONTGOMERY TWP  \n\n Loc Info: XSTS STREAMVIEW DR\n Name: MONTCO                  Addr:                         Phone: INTERCOM\n\n\n/1309  (341     )  ENTRY:         A134 COVER SQ345A, 93 YOM, UNC AND CLAMMY\n/1310  (764     )  DISP    A134    #160645   BRUNK, RYAN \n                                  ,IN THE NESHAMINY FALLS DEVELOPMENT\n\n\n\n\n-- \n\n\nDISCLAIMER: This electronic message transmission has been sent by Chalfont Emergency Medical Services, Inc., which may contain confidential or privileged information. This information is intended for the individual or entity named above. If you are not the intended recipient, be aware that any disclosure, copying, distribution or use of the contents of this information is prohibited. If you have received this electronic transmission in error, please notify us immediately by telephone at 215-822-1308 x116, or by electronic mail (reply).");
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
