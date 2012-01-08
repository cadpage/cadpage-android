package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Gaston County, NC
Contact: Andrew Albright <andrewmalbright@gmail.com>
Sender: rc.459@c-msg.net

(*CAD*) [CAD]   29D2P ~RIVERSIDE~DR/~HICKORY GROVE~RD  X-ST: Phone:~(704) 905-8283 - Station:~Station 40 Station 40 08/25/2011 15:48:11 7\nLD400, EN403, C161, RSU,
(*CAD*) [CAD]   29D2L ~WESLEYAN~DR/~MAIN~ST  X-ST: Phone:~(704) 460-7016 - Station:~Station 40 Station 40 08/29/2011 16:49:18 1\nEN403  WRECK.
(*CAD*) [CAD]   Tree In Roadway 124~CHURCH~ST~  X-ST: ROBINETTE LN - Phone:~(704) 634-0269 Station 40 08/30/2011 05:13:05 1\n
(*CAD*) [CAD]   Alarm-Fire (High Risk) 250~BEATTY~DR~  X-ST: UNKNOWN - Station:~Station 34 Station 34 09/07/2011 21:00:32 3\nLD400, LD34, EN33
(*CAD*) [CAD]   29D4 S ~I~85/~S ~EXIT 23 MCADENVILLE  X-ST: Station:~Station 40 - Quadrant:~40D Station 40 08/30/2011 07:01:38 7\nLD400, EN403, SP172, RSU, E33P, E3
(*CAD*) [CAD]   Tree In Roadway 124~CHURCH~ST~  X-ST: ROBINETTE LN - Phone:~(704) 634-0269 Station 40 08/30/2011 05:13:05 1\nEN403
(*CAD*) [CAD]   29D2L ~WESLEYAN~DR/~MAIN~ST  X-ST: Phone:~(704) 460-7016 - Station:~Station 40 Station 40 08/29/2011 16:49:18 1\nEN403  WRECK.

Contact: Robert Jacksonr <rgaryj32@gmail.com>
Sender: rc.295@c-msg.net
Fire-Commerical Business 100~BUCKEYE~DR~ X-ST: UNKNOWN / TWINBROOKS DR Phone:~(704) 524-5798 Station 30 01/06/2012
Fire-Commerical Business 100~BUCKEYE~DR~ X-ST: UNKNOWN / TWINBROOKS DR Phone:~(704) 524-5798 Station 30 01/06/2012 08:30:55 10\nLD34, EN303, EN300, EN220, EN194, TA184, TA314, TA204, TA32, TA304

Gas Leak 112~ODANIEL~ST~ X-ST: DUMONT AVE / DEAD END Station:~Station 32 01/06/2012 09:16:04 3\n

*/

public class NCGastonCountyParser extends FieldProgramParser {
  
  private static final Pattern TRAILER = Pattern.compile("Station (\\d+) (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) \\d{1,2}$");
  private static final Pattern TRAILER2 = Pattern.compile("Station (\\d+)\\b");
  private static final String TRAILER3 = "NN/NN/NNNN NN;NN;NN NN";
  private static final Pattern CODE_PTN = Pattern.compile("^\\d{1,2}[A-Z]\\d{1,2}[A-Z]?\\b");
  
  public NCGastonCountyParser() {
    super("GASTON COUNTY", "NC",
           "ADDR/SC! X-ST:X! Phone:PHONE? Station:SRC Quadrant:MAP");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String[] lines = body.split("\n");
    if (lines.length > 2) return false;
    if (lines.length > 1) data.strUnit = lines[1];
    body = lines[0];
    
    Matcher match = TRAILER.matcher(body);
    if (match.find()) {
      data.strDate = match.group(2);
      data.strTime = match.group(3);
    } else {
      match = TRAILER2.matcher(body);
      if (!match.find()) return false;
      String trail = body.substring(match.end()).trim();
      if (!TRAILER3.startsWith(trail.replaceAll("\\d", "N"))) return false;
      int len = trail.length();
      if (len >= 19) len = 19;
      else if (len >= 16) len = 16;
      else len = 0;
      if (len > 0) {
        data.strDate = trail.substring(0,10);
        data.strTime = trail.substring(11,len);
      }
      data.expectMore = true;
    }
    String defSource = match.group(1);
    body = body.substring(0, match.start()).trim();
    body = body.replace('~', ' ');
    if (!super.parseMsg(body, data)) return false;
    
    match = CODE_PTN.matcher(data.strCall);
    if (match.find()) {
      data.strCode = match.group();
      data.strCall = data.strCall.substring(match.end()).trim();
    }
    if (data.strSource.length() == 0) data.strSource = defSource;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "CODE " + super.getProgram() + " UNIT DATE TIME";
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      super.parse(stripDash(field), data);
    }
  }
  
  private class MyPhoneField extends PhoneField {
    @Override
    public void parse(String field, Data data) {
      super.parse(stripDash(field), data);
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public void parse(String field, Data data) {
      field = stripDash(field);
      if (field.startsWith("Station ")) field = field.substring(8).trim();
      super.parse(field, data);
    }
  }
  
  private static String stripDash(String field) {
    if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
    return field;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PHONE")) return new MyPhoneField();
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
}
