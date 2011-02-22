

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

  private static final Pattern MID_ID_PAT = Pattern.compile(" :\\( *(\\d+) *\\) ");
  
  public static void main(String[] args) {
    doTest("16327 W RIEKENA RD CO :(16300) W SMITHVILLE RD 72 YO MALE JST RELEASED FRM HOSP TODAY FRM BYPASS HAS AN1513,005 INCISION ON CHEST SERIOUS BLEEDING HAS SOAKED THRU TSHIRT1513,005 C/A/B OK RIGHT NOW");
  }
  
  private static void doTest(String test) {
    Matcher match = MID_ID_PAT.matcher(test);
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
