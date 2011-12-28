package net.anei.cadpage.parsers.NV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Las Vegas, NV
Contact: Andy Stone <akmedic33@gmail.com>
Sender: sms@epageit.net
System: GEAC software  

[SMS]  RE: 4051722 U: 3901, P: 2, G: 2914, PH: 28 L: 4966 MOMENTI ST-CC# , B: , AL: PC:, 26B PN:, N:26B], Location from Fire: 4966 MOMENTI ST, 01:57:51 88YOM CB...SE
[SMS]  I: 4051701 U: 3901, P: 2, G: 2819, PH: 97 L: 6255 W TROPICANA AVE# , B: , AL: PC:, 32B PN:, N:32B], 00:38:29 Class of service: WPH2], 00:38:29 Validity of add
[SMS]  I: 4051596 U: 3901, P: 2, G: 3223, PH: 55 L: S I 215 / S I 15# , B: , AL: PC:, 29B PN:, N:29B], 18:24:23 PR WAS PASSERBY UNK IF DRIVER IS INJ], 18:24:16 NHP E
[SMS]  I: 4050480 U: 3901, P: 1, G: 2715, PH: 62 L: 3779 TOHONO CANYON ST-CC# , B: , AL: PC:, 19D PN:, N:19D], Location from Fire: 3779 TOHONO CANYON ST, 22:04:52 Cl
[SMS]  I: 4050510 U: 3901, P: 1, G: 2925, PH: 92 L: 5757 WAYNE NEWTON BLVD-CC# , B: MCCARRAN INTERNATION, AL: PC:, 31D PN:, N:31D], Location from Fire: 5757 WAYNE NE
[SMS]  I: 4051701 U: 3901, P: 2, G: 2819, PH: 97 L: 6255 W TROPICANA AVE# , B: , AL: PC:, 32B PN:, N:32B], 00:38:29 Class of service: WPH2], 00:38:29 Validity of add
[SMS]  RE: 4051722 U: 3901, P: 2, G: 2914, PH: 28 L: 4966 MOMENTI ST-CC# , B: , AL: PC:, 26B PN:, N:26B], Location from Fire: 4966 MOMENTI ST, 01:57:51 88YOM CB...SE
[SMS]  I: 4051593 U: 3901, P: 2, G: 3316, PH: 99 L: 291 TAYMAN PARK AVE# , B: , AL: PC:, 25B PN:, N:25B], 18:22:40 17YOM,, /L2K ,, CODE 4 TO ENTER METO 97], 18:22:19
[SMS]  I: 4051184 U: 3901, P: 1, G: 2915, PH: 51 L: 10196 STONE OAK CT-CC# , B: , AL: PC:, 10D PN:, N:10D], Location from Fire: 10196 STONE OAK CT, 01:36:01 [Geograp
[SMS]  I: 4049937 U: 3901, P: 1, G: 2824, PH: 57 L: 265 E HARMON AVE# , B: , AL: PC:, 6C PN:, N:6C], 00:09:13 65YOM,CSHORT OF BREATH], 00:09:04 [Address: 265 E HARMO

*/

public class NVLasVegasParser extends FieldProgramParser {
  
  private static final Pattern TIME_PTN = Pattern.compile("\\b\\d\\d:\\d\\d:\\d\\d\\b");
  private static final Pattern TIME_PTN2 = Pattern.compile("], \\d\\d:\\d\\d:\\d\\d\\b");
  
  public NVLasVegasParser() {
    super("LAS VEGAS", "NV",
           "I:ID U:UNIT P:PRI G:MAP PH:MAP L:ADDR B:PLACE AL:PLACE PC:CODE PN:SKIP N:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "sms@epageit.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("SMS")) return false;
    
    body = body.replaceFirst("^RE:", "I:");
    int pt = body.indexOf("], ");
    if (pt < 0) return false;
    String extra = body.substring(pt+3).trim();
    body = body.substring(0,pt).trim();
    body = body.replace(",", " ");
    if (!parseMsg(body, data)) return false;
    Matcher match = TIME_PTN.matcher(extra);
    if (match.find()) {
      extra = extra.substring(match.end()).trim();
      extra = TIME_PTN2.matcher(extra).replaceAll(",");
      data.strSupp = extra;
    }
    
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("#")) field = field.substring(0,field.length()-1).trim();
      if (field.endsWith("-CC")) field = field.substring(0,field.length()-3).trim();
      super.parse(field, data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      data.strPlace = append(data.strPlace, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " INFO";
  }
}
