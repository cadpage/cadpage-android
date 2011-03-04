package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Cumberland County, NC
Contact: Travis Walker <tjwalker2212@gmail.com>
Sender: cad@co.cumberland.nc.us

[S] DEERFIELD (N)C4;01/28/2011 13:19:07;POSS DANGEROUS BODY AREA FALL;ST22;441 WAPITI DR;WILDERNESS DR
[S] SPRING LAKE (PLAT BOOK 11, PAGE 3)+/- (N)C4;01/27/2011 22:09:28;CLAMMY BREATHING PROBLEMS;ST22;115-401 LAKE AVE;S FIRST ST;GATEWAY IN
[S]  (N)C4;01/27/2011 17:08:27;UNKNOWN STATUS TRAFFIC ACCIDEN;ST22;670 LILLINGTON HWY;HOLLAND DR;WALMART
[S] OVERHILLS PARK (N)C4;01/27/2011 15:20:35;ABNORMAL BREATHING SICK PERSON;ST22;3110 HUNTLEY ST;ROBBIE CIR
[S] R G CREECH (N)C4;01/27/2011 13:23:42;WIRES DOWN (NO SMOKE OR ARC);ST22;200 RUPE ST;SCARBOROUGH ST

*/

public class NCCumberlandCountyParser extends DispatchOSSIParser {
  
  public NCCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "NC",
           "PLUNIT SKIP CALL SRC ADDR X PLACE");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.cumberland.nc.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("S") && !subject.equals("N")) return false;
    return parseFields(body.split(";"), data);
  }
  
  private class PlaceUnitField extends Field {
    @Override
    public void parse(String fld, Data data) {
      Parser p = new Parser(fld);
      data.strUnit = p.getLast(')');
      data.strPlace = p.get('(');
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE UNIT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLUNIT")) return new PlaceUnitField();
    return super.getField(name);
  }
}
