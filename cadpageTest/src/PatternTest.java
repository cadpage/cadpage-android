

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MASTER = 
    Pattern.compile("(\\d\\d\\.\\d\\d\\.\\d\\d) (\\d\\d/\\d\\d/\\d\\d) (.*?) ([A-Z]{2}FD)((?: [A-Z]+\\d+)+)( +.*)?");
  
  public static void main(String[] args) {
    doTest("08.22.10 02/07/12 EMR RED 505 MADISON AVE; GARFIELD SCHOOL TPFD TP1 YM06 TP0 UNK TYPE OF INJ  / OUTSIDE IN PLAYGROUND / 8 YR BOY - NURSE ON SCENE RP TOLD TO CALL - NOT ON SCENE MAIN PLAYGROUND - WILL MEET UNITS TO DIRECT");
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
