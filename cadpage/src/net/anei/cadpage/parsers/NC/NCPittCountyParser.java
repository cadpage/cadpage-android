package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Pitt County, NC
Contact: noah smith <firefighter2114@gmail.com>
Sender: donotreply@pittcountync.gov

S:911 Fire Call M:F24|Rcvd:05/31/2012 03:34|Rsn:FIRE ALARM ACT|Note:SAME|Adr:1550  QUALITY LN
S:911 Fire Call M: F14 | Rcvd:05/27/2012 01:16 | Rsn: MVC PI | Note:MARTIN LUTHER KING JR DR | WHICHARD RD | Adr:0 
S:911 Fire Call M: F14 | Rcvd:05/25/2012 17:12 | Rsn:47 YOM STROKE | Note:618 DANIELLE DR | Adr:0
S:911 Fire Call M: F14 | Rcvd:05/25/2012 01:41 | Rsn: POSS ELECTRICAL FIRE |Note:3157 OLD RIVER RD | Adr:0
S:911 Fire Call M: F14 | Rcvd:05/23/2012 19:55 | Rsn: MVC PI | Note:OLDR RIVER RD | BROWN PLACE DR @ THE BRIDGE | Adr:0
S:911 Fire Call M: F24 | Rcvd:05/22/2012 17:16 | Rsn: FIRE ALARM | Note:SAME | Adr:2185 OAKLEY RD

*/

public class NCPittCountyParser extends FieldProgramParser {
  
  public NCPittCountyParser() {
    super("PITT COUNTY", "NC",
           "SRC! Rcvd:DATETIME! Rsn:CALL! ( Note:SAME! Adr:ADDR! | Note:ADDR! X Adr:SKIP )");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@pittcountync.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("911 Fire Call")) return false;
    return parseFields(body.split("\\|"), data);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strCross = field.substring(0,pt).trim();
        data.strPlace = field.substring(pt+1).trim();
      } else {
        if (checkAddress(field) > 0) {
          data.strCross = field;
        } else {
          data.strPlace = field;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d", true);
    if (name.equals("SAME")) return new SkipField("SAME", true);
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
