

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("^(?:[-=.+_a-z0-9]*[0-9a-f]{8,}[-=.+_a-z0-9]*=)?([\\w.!\\-]+@[\\w.]+)[\\s:]");
  
  public static void main(String[] args) {
    doTest("sentto-81008140-157-1334863333-9109162452=vtext.com@returns.groups.yahoo.com ([northwestvfd] ) 814:6598 NEW GROUND TR NE NORTHWEST MDL 26C02 12-029355 15:17:43 Sick Person (Specifi");
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
