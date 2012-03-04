

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
    Pattern.compile("([^ ]+):(\\d{8}) *:(\\d\\d/\\d\\d/\\d\\d\\d\\d) (\\d\\d:\\d\\d:\\d\\d):");
  
  public static void main(String[] args) {
    doTest("/ 77 RESCUE / kharju:SBB-RS:12029633 :03/01/2012 23 <201223>:53:12:SICK PERSON:22 YOM: SOUTH B-SOUTHSIDE GRILL / 2 MAIN ST #10");
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
