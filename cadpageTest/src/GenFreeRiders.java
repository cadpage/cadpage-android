import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class converts the input file freeriders.txt to the freeriders.xml
 * resource file.  The class exists in the test project, but must be run in
 * the live cadpage workspace
 */
public class GenFreeRiders {
  
  private static final File IN_FILE = new File("freeriders.txt");
  private static final File CSV_FILE = new File("freeriders.csv");

  private static Map<String,String> purchaseDateMap = new HashMap<String,String>();
  

  public static void main(String[] args) throws IOException {
    
    // Open input and output files
    BufferedReader ir = new BufferedReader(new InputStreamReader(new FileInputStream(IN_FILE)));
    PrintStream ps2 = new PrintStream(new FileOutputStream(CSV_FILE));
    
    String status = "";
    String sponsor = "";
    String purchase = "";
    while (true) {
      String line = ir.readLine();
      if (line == null) break;
      int pt = line.indexOf("//");
      if (pt >= 0) line = line.substring(0,pt);
      line = line.trim();
      if (line.length() == 0) continue;
      if (line.startsWith("%%")) {
        purchase = line.substring(2).trim();
      }
      
      else if (line.startsWith("%")) {
        sponsor = "";
        purchase = "";
        pt = line.indexOf('/');
        if (pt >= 0) {
          sponsor = line.substring(pt+1).trim();
          line = line.substring(0,pt).trim();
        }
        status = line.substring(1).trim();
      }
      
      else {
        boolean skipHash = line.startsWith(">>");
        if (skipHash) line = line.substring(2);
        UserInfo info = cvtUser(line);
        String upshiftUser = info.user.toUpperCase();
        String tmpPurchase = purchaseDateMap.get(upshiftUser);
        if (tmpPurchase == null) {
          tmpPurchase = purchase;
          purchaseDateMap.put(upshiftUser, tmpPurchase);
        }
        line = generateCsvLine(info, status, tmpPurchase, sponsor);
        ps2.println(line);
      }
    }
    ir.close();
    ps2.close();
    
    System.out.println("freeriders.xml has been generated");
  }

  private static class UserInfo {
    String name;
    String user;
  }

  /**
   * Convert user specification line to an MD5 has XML item
   * @param line
   */
  private static final Pattern OPEN_BRACKET = Pattern.compile("[<({]");
  private static final Pattern VALID_EMAIL = Pattern.compile("\\d+|[-\\w\\.]+@[-\\w\\.]+");
  private static UserInfo cvtUser(String line) {
    try {
      // parse name and user account from line
      String user = line;
      String name = null;
      Matcher match = OPEN_BRACKET.matcher(line);
      if (match.find()) {
        int pt1 = match.start();
        char delim = line.charAt(pt1);
        delim = (delim == '(' ? ')' : delim == '<' ? '>' : delim == '{' ? '}' : ']' );
        int pt2 = line.indexOf(delim,pt1+1);
        if (pt2 < 0) throw new RuntimeException("Missing closing " + delim);
        user = line.substring(pt1+1,pt2).trim();
        name = line.substring(0,pt1).replace("\"", "").trim();
      }
      
      // Final validity check
      if (!VALID_EMAIL.matcher(user).matches()) {
        throw new RuntimeException("Malformed user account");
      }
      
      // Return result
      UserInfo result = new UserInfo();
      result.name = name;
      result.user = user;
      return result;
      
    } catch (RuntimeException ex) {
      throw new RuntimeException(ex.getMessage() + " in line: " + line, ex);
    }
  }

  
  private static String generateCsvLine(UserInfo info, String status,
                                          String purchase, String sponsor) {
    StringBuilder sb = new StringBuilder();
    if (info.name != null) {
      sb.append(info.name.replace(',', ';'));
    }
    sb.append(',');
    sb.append(info.user);
    sb.append(',');
    if (status != null) sb.append(status);
    sb.append(',');
    if (purchase != null) sb.append(purchase);
    sb.append(',');
    if (sponsor != null) sb.append(sponsor);
    return sb.toString();
  }
}
