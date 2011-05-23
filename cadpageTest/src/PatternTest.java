

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MID_ID_PAT = Pattern.compile("^([^ ]+):(\\d{8}):\\d\\d/\\d\\d/\\d\\d\\d\\d \\d\\d:\\d\\d:\\d\\d:");
  
  public static void main(String[] args) {
    doTest("EFD-FD:11051201:05/12/2011 15:44:57:FIRE ALARM: FRANKLI-CARING HOUSE PROJECTS / 18 BLOOMFIELD AVE");
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
