

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("\\b[A-Z]{1,4}[0-9]{1,4}(?:,? +[A-Z]{1,4}[0-9]{1,4})*\\b");
  
  public static void main(String[] args) {
    doTest("R Water Rescue: 500 GRIFFIN RD, Grants Pass: 7/9/2012 5:44:21 PM: Quad-104191: 7501, 7514, 7551, M2, J1, 7531: :");
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
