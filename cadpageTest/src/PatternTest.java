

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
      Pattern.compile("(?:([- A-Z0-9]+) )?(?:(?:Ds# ([^ ]*?) Al# ([^ ]*?) Utl# ([^ ]*?) )?(\\d\\d/\\d\\d/\\d\\d)|\\^ )");
  
  public static void main(String[] args) {
    doTest("FIELD021 12 Ic# 11 FIELD021 Ds# 125001 Al# 1 Utl# 142-143 06/27/122 BYPASS HW PE <> ELM RDSOUTH SIDE OF ROAD - JUST E/O ELM 1147 TESTING 245 JUST TESTING DO NOT RESPOND");
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
