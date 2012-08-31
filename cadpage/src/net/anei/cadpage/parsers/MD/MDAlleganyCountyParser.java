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

Contact: Jeremy <athey9014@yahoo.com>
Contact: "Roger Bennett" <rbennett@allconet.org>  (AllCoNet.org) (Dispatch center)
Sender: acgov_911_cad@allconet.org
S:CAD M:08:26 #047678 BEHAVORIAL EMERGENCY 12037 IRIS AVE SW  BOX:F0801 DUE:A396 M514\n\n\n
S:CAD M:12:56 #038525 CHEST PAINS, HEART 12002 BOWLING ST SW  BOX:F0803 DUE:A396 MED08 MED09\n\n
S:CAD M:21:08 #038431 MEDICAL EMERGENCY 13103 QUARRY RIDGE RD SW  BOX:F0902 DUE:CO09 A396\n\n
S:CAD M:21:02 #038765 STROKE/CVA 14512 BARTON BLVD SW  BOX:F0904 DUE:A396\n \n 
S:CAD M:00:02 #038632 MEDICAL EMERGENCY 15201 TRAIL RIDGE RD SW  BOX:F0903 DUE:CO09 A396\n \n

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
