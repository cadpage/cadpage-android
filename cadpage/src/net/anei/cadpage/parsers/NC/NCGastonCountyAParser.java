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

Sender: alerts@cadpage.org
[!noSignature!] Illegal Burning ~8TH~AVE/~PARK~ST X-ST: Station:~Station 41 Quadrant:~41A 01/23/2012 00:53:21 1\nBU407
[!noSignature!] 29B1M 2400~N ~I~85~ X-ST: N ONRAMP 23 MCADENVILLE / N EXIT 26 BEL MTH Station:~Station 40 01/22/2012 13:39:39 2  LD400, E37P MVA.
[!noSignature!] 29B4 ~WILKINSON~BLVD/~LAKEWOOD~RD X-ST: Phone:~(704) 215-0592 Station:~Station 41 01/19/2012 17:46:11 6  EN401, SP172, E25P,

Contact: Robert Jacksonr <rgaryj32@gmail.com>
Sender: rc.295@c-msg.net
Fire-Commerical Business 100~BUCKEYE~DR~ X-ST: UNKNOWN / TWINBROOKS DR Phone:~(704) 524-5798 Station 30 01/06/2012
Fire-Commerical Business 100~BUCKEYE~DR~ X-ST: UNKNOWN / TWINBROOKS DR Phone:~(704) 524-5798 Station 30 01/06/2012 08:30:55 10\nLD34, EN303, EN300, EN220, EN194, TA184, TA314, TA204, TA32, TA304
Gas Leak 112~ODANIEL~ST~ X-ST: DUMONT AVE / DEAD END Station:~Station 32 01/06/2012 09:16:04 3\n

*/

public class NCGastonCountyAParser extends FieldProgramParser {
  
  private static final Pattern TRAILER = Pattern.compile("\\b(\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) \\d{1,2}\\b");
  private static final Pattern TRAILER2 = Pattern.compile("Station (\\d+)$");
  private static final String TRAILER3 = "NN/NN/NNNN NN;NN;NN NN";
  private static final Pattern CODE_PTN = Pattern.compile("^\\d{1,2}[A-Z]\\d{1,2}[A-Z]?\\b");
  
  public NCGastonCountyAParser() {
    super("GASTON COUNTY", "NC",
           "ADDR/SC! X-ST:X! Phone:PHONE? Station:SRC Quadrant:MAP");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    
    Matcher match = TRAILER.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strUnit = body.substring(match.end()).trim();
      body = body.substring(0,match.start()).trim();
    } else {
      int pt1 = body.lastIndexOf(' ');
      if (pt1 <= 0) return false;
      int pt2 = body.lastIndexOf(' ', pt1-1);
      if (pt2 <= 0) return false;
      int pt3 = body.lastIndexOf(' ', pt2-1);
      if (pt3 < 0) return false;
      boolean found = false;
      for (int pt :  new int[]{pt3, pt2, pt1}) {
        String tail = body.substring(pt+1);
        String tail2 = tail.replaceAll("\\d", "N");
        if (TRAILER3.startsWith(tail2)) {
          body = body.substring(0,pt).trim();
          int len = tail.length();
          if (len >= 19) len = 19;
          else if (len >= 16) len = 16;
          else len = 0;
          if (len > 0) {
            data.strDate = tail.substring(0,10);
            data.strTime = tail.substring(11,len);
          }
          found = true;
          data.expectMore = true;
          break;
        }
      }
      if (!found) return false;
    }
    
    String defSource = "";
    match = TRAILER2.matcher(body);
    if (match.find()) {
      defSource = match.group(1);
      body = body.substring(0,match.start()).trim();
    }
      
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
    return "CODE " + super.getProgram() + " DATE TIME UNIT";
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
