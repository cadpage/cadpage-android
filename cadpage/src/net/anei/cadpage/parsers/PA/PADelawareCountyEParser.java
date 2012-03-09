package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Delaware County, PA
Contact: Thomas Dobbins <tdobbins53@gmail.com>
Sender: bfc53@comcast.net
[Update]**AUTOMATIC FIRE ALARM**2725 WEST CHESTER PKE LAW**S MALIN RD**SCHOOL HOUSE LN**13:23**02/04/2012**MULTIPLE LISTING,~ COMPUTER STORE,
STREET CLOSED**REED RD & S PARKWAY BLVD**REED RD**S PARKWAY BLVD**09:14**03/06/2012**Field Event,REED RD CLOSED FROM PARKWAY TO MARPIT
VEHICLE FIRE**467 LAWRENCE RD**WARREN BLVD**SPRINGHOUSE RD**08:00**03/06/2012**610-353-3644,BEHIND DR BRENNER'S BLDG,-075.349238
WITH ENTRAPMENT**40 S NEWTOWN STREET RD**REESE AV**MARY JANE LN**04:22**03/06/2012**610-356-9755,~OVERTURNED,501 LANSDOWNE AV UD,ER: @DELAWAR\r
NATURAL GAS LEAK, INSIDE**400 S STATE RD**US HWY 1 NB**US HWY 1 SB**20:35**03/05/2012*** USE @name LOOKUP OR APT % FOR ALL INCIDENTS AT THIS \r
AUTOMATIC FIRE ALARM**104 RED FOX PL**TROUT RUN DR**TROUT RUN DR**15:19**03/04/2012**~ RES MARTIN,~ SMOKE DET. HALLWAY,OBN,RES 610-356-0622, \r
BUILDING FIRE, RES/DWELLING**20 OBERLIN AV**DARTMOUTH AV**LAFAYETTE AV**05:12**03/05/2012**~ODOR OF SMOKE IN BLDG, **M102/147/132/131/RE44/TW\r
AUTOMATIC FIRE ALARM**1797 S SPROUL RD**W SPROUL RD**CRUM CREEK RD**20:04**03/05/2012**610-543-3350,~PIANELLO BLSG,OBN, **532\r
BUILDING FIRE, RES/DWELLING**200 DARTMOUTH AV**OBERLIN AV**S PRINCETON AV**07:56**03/06/2012**~SMOKE IN THE BASEMENT,~ALSO HEARS A HISSING NO\r

*/

public class PADelawareCountyEParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*\\*");
  
  public PADelawareCountyEParser() {
    super("DELAWARE COUNTY", "PA",
           "UPDT? CALL ADDR/SXP X X TIME DATE! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "bfc53@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(DELIM.split(body), 6, data);
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('~', ' ');
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UPDT")) return new SkipField("|\\[Update\\]");
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("DATE")) return new DateField("\\d\\d/\\d\\d/\\d{4}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
