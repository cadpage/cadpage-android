

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  static final Pattern MAPPattern = 
    Pattern.compile("\\b\\d{1,2}-[A-Z]-\\d{1,2}[A-Z]?\\b");
  
  public static void main(String[] args) {
    doTest("12-A-9");
    doTest("HELP 1-C-33D ME");
    doTest("HELP 1-C-33 ME");
  }
  
  private static void doTest(String test) {
    Matcher match = MAPPattern.matcher(test);
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
