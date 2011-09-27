

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
    Pattern.compile("^Hoke Co 911:([^\\*]+)\\*(?: \\*)*\\*([^\\*]+)\\*(?: \\*)+ *\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d : (pos\\d+) : ([A-Za-z]+\\d+) (.*)");
  
  public static void main(String[] args) {
    doTest("Hoke Co 911:795 TC JONES RD* * * * * **EMD* * * * * * * * 09/15/2011 14:36:26 : pos4 : mblack3325 ** EMD Case Entry Finished ** Chief Complaint Number: 19 Key Q");
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
