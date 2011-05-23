

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MID_ID_PAT = Pattern.compile(" *& *");
  
  public static void main(String[] args) {
    doTest("RED RD&BLACK ST");
  }
  
  private static void doTest(String test) {
    Matcher match = MID_ID_PAT.matcher(test);
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
