

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  static final Pattern GPSPattern = 
    Pattern.compile("\\W*\\b([+-]?[0-9]+\\.[0-9]+)\\W+([+-]?[0-9]+\\.[0-9]+)\\b\\W*");
  
  public static final Pattern NUMERIC = Pattern.compile("\\b\\d+\\b");
  
  public static void main(String[] args) {
    doTest("   0.999");
    doTest("999.999");
    doTest("@123.0@24.567@ ,");
    doTest("AB123.5 23.56");
    doTest("123.5 15.2DE");
    
    System.out.println("NUMERIC-42: " + NUMERIC.matcher("B42").find());
  }
  
  private static void doTest(String test) {
    Matcher match = GPSPattern.matcher(test);
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
