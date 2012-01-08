

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
    Pattern.compile("(?: - *)?(?:(\\b\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)?))?(?: *@ *)?(\\b\\d{4}) */?hrs(?: *- )?");
  
  public static void main(String[] args) {
    doTest("EMS @ 7300 Winbert Dr - 45yof Chest Pain - 01/06/12 @ 0442/hrs - EMS OPS  ALSP");
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
