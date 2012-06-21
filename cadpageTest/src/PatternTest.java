

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("^Fwd:|^\\[FWD?:[^\\]]*?\\] *\n(?:.*Original Message.*\n)?", Pattern.CASE_INSENSITIVE);
  
  public static void main(String[] args) {
    doTest("[FW: Automatic R&R Notification] \n-----Original Message-----\nFrom: DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US\n[mailto:DDOAK@S105KD4M.CO.GLOUCESTER.NJ.US]\nSent: Tuesday, June 12, 2012 10:33 PM\nTo: EmergencyResponse\nSubject: Automatic R&R Notification\nImportance: High\n \n** ** ** ** ** ** ** ** ** ** ** ** FINAL REPORT ** ** ** ** ** ** ** **\n** ** ** ** \nIncident Number  : 2012-00020243                    ORI: 0818102\nStation: 10-2 \nIncident Type  . : ALMC F CO ALARM             Priority: 3 \nIncident Location: 811 MARLBOROUGH ST\nVenue: WASHINGTON\nCall Time- 20:50:34                                Date- 06/12/2012 \nDispatch - 20:51:29     En-route- 20:56:10     On-scene- 20:59:16\nDepart 1- \nArrive 2 -              Depart 2-              In-statn-\nCleared - 21:37:16\nArea:   R2              Section : 1004         Beat  . :    R \nGrid:  K21              Quadrant: 1017         District: 1017\nPhone Number: (856) 481-4361                Call Source:  TEL\nCaller. . . : PAUL FISHER\nNature of Call : 811 MARLBOROUGH ST\nAdditional Info\n  CO ALARM REDING 210 REQ FD\nNarrative\n Information on the units assigned to the call follows. \n    Unit: 10-2    Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  20:51:29     ENR: 06/12/12  20:56:10 \n       ARV: 06/12/12  20:59:16     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  21:37:16 \n    Unit: F1032   Radio:           Ofcr 1:     F1032  Ofcr 2: \n       DSP: 06/12/12  20:54:43     ENR: 06/12/12  20:54:43 \n       ARV:             :  :       DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  20:57:12 \n    Unit: E1094   Radio:           Ofcr 1:            Ofcr 2: \n       DSP: 06/12/12  21:18:52     ENR: 06/12/12  21:19:51 \n       ARV: 06/12/12  21:22:45     DPT:             :  : \n       QTR:             :  :       CLR: 06/12/12  22:33:24 \n CALLER ADVISED TO EXIT RES                        JJVERRECCH 20:50:18 \n R 1022 W/3                                        JBLAWRENCE 20:56:27 \n R 1021 W/3                                        JBLAWRENCE 20:57:38 \n O 1021                                            JBLAWRENCE 20:59:23 \n O 1022                                            JBLAWRENCE 21:03:13 \n PROGRESS REPORT.............NEG READINGS W/       JBLAWRENCE 21:18:58 \n METERS,REQUEST 1 BLS TO CHECK HOMEOWNER           JBLAWRENCE 21:19:22\nThe Call Taker is VERRECCHIO JOHN J\nThe Dispatcher is MCGARVEY RAYMOND E\n");
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
