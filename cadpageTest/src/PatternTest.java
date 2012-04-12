

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile(" (Med Class(\\d) |([A-Z]{2,3} - ))(.*) (?:(?:Box|BOX) ?([0-9\\-]+)|Fire-Box ([0-9\\-]+) EMS-Box ([0-9\\-]+))");
  
  public static void main(String[] args) {
    doTest("2618 KING ST MI - Miscellaneous Wire Down FG 3 E29 Fire-Box 29-01 EMS-Box 140-1");
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
