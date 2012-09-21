package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Jackson County, OR
Contact Active911
Agency name: Jackson County Fire District #5 Location: Phoenix, OR 
Sender: Messaging@ecso911.com
  
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:CPF, Chest Pains, 345 WILLOW SPRINGS DR, TA, PRI:1, Units:8300, 8331, 8833 - From\n(Con't) 2 of 2\nCAD07 06/24/2012 19:48:52\n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:STRUCF, Structure Fire, 1457 WHITMAN AVE, MF, PRI:1, Unit:8300 - From CAD13 06/25/2012 17:38:40 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n(Con't) 2 of 2\nFrom CAD15 06/25/2012 18:54:05 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:GRASS, Grass Fire, DEER TRAIL LN/COLEMAN CREEK RD, MF, PRI:1, Units:8300, 8303,\n(Con't) 2 of 2\n8341, 8361, 8363, 8801, ODFM - From CAD15 06/25/2012 18:55:35 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:MVCUF, MVC Unknown Injury, 1362 FOSS RD, TA, PRI:1, Units:8300, 8301, 8331, 8831 -\n(Con't) 2 of 2\nFrom CAD15 06/25/2012 18:54:05 \n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:ALRMMF, Medical Alarm, 1122 N ROSE ST, PH, PRI:1, Units:8300, 8303 - From CAD15 06/25/2012 19:25:13 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:STRUCF, Structure Fire, 180 LINCOLN ST, AS, PRI:1, Units:8300, 8301, 8801, 8802,\n(Con't) 2 of 2\n8853, 88CO - From CAD15 06/26/2012 07:47:36 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:UNCF, Unconscious Person, 10548 WAGNER CREEK RD, TA, PRI:1, Units:8300, 8331, 8831 -\n(Con't) 2 of 2\nFrom CAD15 06/25/2012 21:13:21 \n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:STRUCF, Structure Fire, 3555 S PACIFIC HWY #193, MF, PRI:1, Unit:8300 - From CAD13 06/26/2012 23:12:50 
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:MVCIF, MVC injury, 1188 OAK ST, AS, PRI:1, Units:8300, 8311, 8331, 8831 - From CAD15 07/01/2012 17:42:42 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:GRASS, Grass Fire, 4332 FERN VALLEY RD, MF, PRI:2A, Units:8106, 8146, 8166, 8168,\n(Con't) 2 of 2\n8300, 8300DO, 8311 - From CAD15 07/02/2012 19:53:43 \n(End)
FRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:FALLF, Fall Victim, 300 LUMAN RD #45, PH, PRI:1, Units:8300, 8303 - From CAD15 07/01/2012 10:43:31 
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:GRASS, Grass Fire, 2050 BUTLER CREEK RD, AS, PRI:1, Units:8300, 8301, 8341, 8361,\n(Con't) 2 of 2\n8801, 8861, 88CO, ODFM - From CAD15 07/04/2012 13:49:40 \n(End)
1 of 2\nFRM:Messaging@ecso911.com\nSUBJ:CAD Page\nMSG:DISPATCH:SMOKE, Smoke Investigation, FOSS RD/ADAMS RD, TA, PRI:1, Units:8300, 8312 - From\n(Con't) 2 of 2\nCAD15 06/29/2012 20:51:08 \n(End)

*/

public class ORJacksonCountyParser extends FieldProgramParser {
  
  private static final Pattern SRC_DATE_TIME_PTN = Pattern.compile(" - From +([A-Z0-9]+) +(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d:\\d\\d)$");
  
  public ORJacksonCountyParser() {
    super(CITY_CODES, "JACKSON COUNTY", "OR",
          "CODE CALL ADDR CITY! PRI:PRI! Unit:UNIT! UNIT+");
  }
  
  @Override
  public String getFilter() {
    return "Messaging@ecso911.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! subject.equals("CAD Page")) return false;
    if (!body.startsWith("DISPATCH:")) return false;
    body = body.substring(9).trim();
    
    Matcher match = SRC_DATE_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1);
    data.strDate = match.group(2);
    data.strTime = match.group(3);
    body = body.substring(0,match.start()).trim();
    
    body = body.replace("Units:", "Unit:");
    return parseFields(body.split(","), 6, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " SRC DATE TIME";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      parseAddress(p.get('['), data);
      data.strCity = p.get(']');
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, ",", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AS", "ASHLAND",
      "MF", "MEDFORD",
      "PH", "PHOENIX",
      "TA", "TALENT"
  });
}
