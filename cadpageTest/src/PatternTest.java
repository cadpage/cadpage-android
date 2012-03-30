

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
    Pattern.compile("@RIFD: (\\d+):;([^;]+?);([^;]+?)");
  
  public static void main(String[] args) {
    doTest("@RIFD: 15221:;CRASH PERSONAL INJURIES;24TH ST/18TH AV");
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
