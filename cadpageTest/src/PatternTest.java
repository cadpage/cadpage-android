

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
    Pattern.compile("911-CENTER:([A-Z0-9]+) +(.+?) AT (.+?) (\\d{3}\\d{7}?)([ A-Z]+)*");
  
  public static void main(String[] args) {
    doTest("911-CENTER:1046 INJURY ACCIDENT LANTANA AT STORIE 7656250985 COUNTY");
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
