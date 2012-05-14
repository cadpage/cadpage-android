

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("(?<=^|,) *Unit: *|(?<=^|,) *Dispatch code: *([^ ]+)\\b|([^ ]+)\\b|(?:(?:^|,)[^,]*?)?\\b([A-Z]{3,4}-\\d{4}-\\d{6,})\\b[^,]*");
  
  public static void main(String[] args) {
    doTest("Unit: 735");
    doTest("Dispatch code: 342A6");
    doTest("Incident #: BCSO-2012-0105711,");
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
