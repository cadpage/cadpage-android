

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
    Pattern.compile("\\b([A-Z]{2}|STATE) *(?:ROAD|RD|RT|RTE|ROUTE|HW|HWY|HY) (?:NO )?+(\\d+[NSEW]?|[A-Z]{1,2})\\b", Pattern.CASE_INSENSITIVE);
  
  public static void main(String[] args) {
    doTest("29 STATE HWY NO 31");
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
