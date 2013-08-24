

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER  = Pattern.compile("\\s*\\b(?:E911 Info .*)(?:(35\\.\\d{4,} +-77\\.\\d{4,})|-361 +-361)$");

  public static void main(String[] args) {
    doTest("");
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
