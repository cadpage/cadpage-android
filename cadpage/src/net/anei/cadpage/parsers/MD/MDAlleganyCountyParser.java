package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Allegheney County, MD
Contact: Chris Green <mediccgreen@gmail.com>
Contact: Joseph Hoffman <jphoffman0@frostburg.edu>
Sender:acgov_911_cad@allconet.org

S:CAD M:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355\n\n
FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355
FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:CHEST PAINS, HEART FROSTBURG VILLAGE NURSING HOME  1 KAYLOR CIR  BOX:F1602 DUE:A364\n\n

Contact: kenny haught <haught65@gmail.com>
S:CAD M:15:31 #058516 BEHAVORIAL EMERGENCY 20960 MARYLAND HW  BOX:F3601 DUE:CO36 A351 M512\n\n

Contact: Jeremy Athey <athey9014@yahoo.com>
Sender: acgov_911_cad@allconet.org
S:CAD M:03:16 #024484 BREATHING DIFFICULTY 12030 IRIS AVE SW  BOX:F0801 DUE:A396\n\n

*/

public class MDAlleganyCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("(\\d\\d:\\d\\d) #(\\d+) +");
  
  public MDAlleganyCountyParser() {
    super("ALLEGANY COUNTY", "MD",
           "ADDR/SC! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "acgov_911_cad@allconet.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("CAD")) return false;
    
    do {
      Matcher match = MARKER.matcher(body);
      if (match.find()) {
        data.strTime = match.group(1);
        data.strCallId = match.group(2);
        body = body.substring(match.end());
        break;
      }
      
      if (body.startsWith("CT:")) {
        body = body.substring(3).trim();
        break;
      }
      
      return false;
      
    } while (false);
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "TIME ID " + super.getProgram();
  }
}
