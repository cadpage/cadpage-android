package net.anei.cadpage.parsers.NV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Las Vegas County, NV
Contact: Andy Stone <akmedic33@gmail.com>
Sender: sms@pageway.net

(SMS) I: 4273738 U: 3901, P: 3, G: 3423, PH: 17 L: 2711 W WINDMILL LN# , B: , AL: PC:, 1A N:1A], 17:07:17 [Geographic Area: 2711 W WINDMILL LN]
(SMS) I: 4274400 U: 3901, P: 2, G: 3217, PH: 61 L: S DURANGO DR / W MAULE AVE# , B: , AL: PC:, 32B N:32B], 19:02:59 [Geographic Area: S DURANGO
(SMS) I: 4273913 U: 3901, P: 1, G: 2821, PH: 13 L: 4285 DUNEVILLE ST-CC# 236 , B: , AL: PC:, 6D N:6D], Location from Fire: 4285 DUNEVILLE ST, 00
[SMS]  I: 4273807 U: 3901, P: 1, G: 2814, PH: 55 L: 4541 BERSAGLIO ST-CC# , B: , AL: PC:, 5C N:5C], Location from Fire: 4541 BERSAGLIO ST, 19:51:
(SMS) I: 4274438 U: 3901, P: 1, G: 2815, PH: 17 L: W FLAMINGO RD / N I 215# , B: , AL: PC:, 12D N:12D], 20:33:59 [Geographic Area: W FLAMINGO RD
(SMS) I: 4274468 U: 3901, P: 3, G: 3425, PH: 25 L: 8105 BURNT SIENNA ST-CC# , B: , AL: PC:, 17A N:17A], Location from Fire: 8105 BURNT SIENNA ST
(SMS) I: 4274545 U: 3901, P: 7, G: 3216, PH: 11 L: 9300 W SUNSET RD-CC# ER 1 , B: SOUTHERN HILLS HOSPI, AL: 9MOM / IV MON O2 / H1P ER PC:, 430 N
(SMS) I: 4275070 U: 1972, P: 1, G: 3516, PH: 56 L: 8898 DEEP RIDGE CT-CC# , B: , AL: PC:, 10C N:10C], Location from Fire: 8898 DEEP RIDGE CT, 19

(SMS) RUN#:4273913 /RCV:00:32:57/ENR:00:34:10/ONS:00:40:00/TRS:01:23:33/DES:01:28:03/MIL:
(SMS) RN#4274400 /RCV:19:03:42/ENR:19:04:20/ONS:19:08:38/AVA:19:13:06
(SMS) RUN#:A225728 /RCV:16:31:14/ENR:16:31:15/ONS:16:31:15/TRS:/DES:/MIL:

*/

public class NVLasVegasParser extends FieldProgramParser {
  
  public NVLasVegasParser() {
    super("LAS VEGAS", "NV",
           "I:ID! U:UNIT! P:PRI! G:MAP! PH:MAP! L:ADDR! B:PLACE! AL:INFO! PC:CODE! CODE N:SKIP TIME+");
  }
  
  @Override
  public String getFilter() {
    return "sms@pageway.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("SMS")) return false;
    body = body.replace(" U:", ", U:").replace(" L:", ", L:").replace(" PC:", ", PC:").replace(" N:", ", N:");
    return parseFields(body.split(","), 9, data);
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strApt = p.getLastOptional('#');
      field = p.get();
      if (field.endsWith("-CC")) {
        data.strCity = "CLARK COUNTY";
        field = field.substring(0,field.length()-3).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY APT";
    }
  }
  
  private static final Pattern TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d:\\d\\d)\\b");
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      if (data.strTime.length() > 0) return;
      Matcher match = TIME_PTN.matcher(field);
      if (match.find()) data.strTime = match.group(1);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
}
