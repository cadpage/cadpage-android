

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("Inc# (\\d+):(?:([^@]+)@)?(.+?), *([A-Z_]+) *:Map  ([^:]*): LAT/LONG X: ([-+ \\.\\d]+) +Y: ([-+ \\.\\d]+)");
  
  public static void main(String[] args) {
    doTest("(CAD Page) Inc# 007104: NATURAL BRIDGES @ =L(38.051636,-120.470996) ,CALAVERAS_COUNTY :Map  509/37B_005: LAT/LONG X: -120 28.2597  Y: 38 3.09816: MED, TRAFFIC COLLISION: MVA: 24 22 E4452");
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
