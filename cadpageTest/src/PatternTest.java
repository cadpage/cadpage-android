

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  static final Pattern MAP_PATTERN = Pattern.compile("\\b\\d{1,2}-?[A-Za-z]-?\\d\\b");
  
  public static void main(String[] args) {
    doTest("12-A-9");
    doTest("HELP 7d4 ME");
    doTest("HELP 12A9 ME");
  }
  
  private static void doTest(String test) {
    Matcher match = MAP_PATTERN.matcher(test);
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
