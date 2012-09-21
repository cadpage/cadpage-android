package net.anei.cadpage.parsers.IN;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Bartholomew County, IN
Contact: Donnie Everroad <dbeverroad@gmail.com>
Sender:  bcpaging@bartholomew.in.gov
FYI: ;08/30/2012 16:36:02;GAS ODOR 651;610 WEST DR;HOPE;WASHINGTON ST;JACKSON ST   - File Messenger Login
FYI: ;08/23/2012 18:06:28;STRUCTURE FIRE 111;2018 FREMONT DR;COL;CLARK BLVD;HARRISON DR   - File Messenger Login
FYI: ;08/22/2012 21:52:37;ACCIDENT PERSONAL INJURY;N MARR RD/E 550 N;COL   - File Messenger Login
FYI: ;08/20/2012 08:51:11;POSSIBLE HEART;7185 N 250 E;COL;E 450 N;E 500 N   - File Messenger Login
FYI: ;08/13/2012 17:32:26;POSSIBLE HEART;8058 N EAST ST;CLIF   - File Messenger Login
Update: ;08/12/2012 13:20:43;DIABETIC REACTION;12301 E 800 N;HOPE;N 575 E;N 670 E   - File Messenger Login
FYI: ;08/15/2012 04:18:54;STRUCTURE FIRE 111;9341 N 250 W;COL;N CHERRY HILLS DR;N CHERRY HILLS DR   - File Messenger Login

*/

public class INBartholomewCountyParser extends DispatchOSSIParser {
  
  public INBartholomewCountyParser() {
    super(CITY_CODES, "BARTHOLOMEW COUNTY", "IN",
           "FYI DATETIME CALL ADDR CITY! X+");
  }
  
  @Override
  public String getFilter() {
    return "bcpaging@bartholomew.in.gov";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    int pt = body.lastIndexOf('-');
    if (pt >= 0 && "- File Messenger Login".startsWith(body.substring(pt))) body = body.substring(0,pt).trim();
    if (!body.startsWith("CAD:")) body = "CAD:" + body;
    return super.parseMsg(body, data);
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CLIF", "CLIFFORD",
      "COL",  "COLUMBUS",
      "HOPE", "HOPE"
  });
}
