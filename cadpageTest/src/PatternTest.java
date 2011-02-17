

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static Pattern LEADER = Pattern.compile("^(\\d\\d)[\\-:]");
  
  public static void main(String[] args) {
    doTest("49-DIABETIC-C :2786 ROUTE 79");
    doTest("25:DIABETIC-C :412 AD");
  }
  
  private static void doTest(String test) {
    Matcher match = LEADER.matcher(test);
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
