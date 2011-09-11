package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*    
Allegheney County, MD
Contact: Chris Green <mediccgreen@gmail.com>
Contact: Joseph Hoffman <jphoffman0@frostburg.edu>
Sender:acgov_911_cad@allconet.org

S:CAD M:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355\n\n
FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355
FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:CHEST PAINS, HEART FROSTBURG VILLAGE NURSING HOME  1 KAYLOR CIR  BOX:F1602 DUE:A364\n\n
  
*/

public class MDAlleganyCountyParser extends FieldProgramParser {
  
  public MDAlleganyCountyParser() {
    super("ALLEGANY COUNTY", "MD",
           "CT:ADDR/SC! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "acgov_911_cad@allconet.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("CAD")) return false;
    return super.parseMsg(body, data);
  }
}
