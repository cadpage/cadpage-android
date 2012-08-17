

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("RC:[-A-Z0-9]+/Run#\\d+/CALL:\\d\\d:\\d\\d/DISP:\\d\\d:\\d\\d/ENR:\\d\\d:\\d\\d/ATS:\\d\\d:\\d\\d/TRA:\\d\\d:\\d\\d.*");
  
  public static void main(String[] args) {
    doTest("RC:0038-A/Run#36872/CALL:03:32/DISP:03:32/ENR:03:33/ATS:03:37/TRA:03:45/ATD:0 3:53/PUZIP:98408/DO:St Joseph Hospital");
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
