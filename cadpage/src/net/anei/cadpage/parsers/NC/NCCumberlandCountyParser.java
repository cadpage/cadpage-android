package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
CAD:(S) (N)C4;03/04/2011 21:18:43;UNKNOWN OUTSIDE FIRE;ST22;2700-BLK BRAGG BLVD
CAD:DIST: 174.69 FT (S)UPTON TYSON (BELRIDGR DR) (N)C10;05/20/2011 08:34:01;CLAMMY CHEST PAIN;ST18;3570 LACEWOOD CT;NC HWY 87 S

*/

public class NCCumberlandCountyParser extends DispatchOSSIParser {
  
  private static final Pattern MARKER = Pattern.compile("\\(S\\) *(.*?) *\\(N\\) *");
  
  public NCCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "NC",
           "UNIT SKIP CALL SRC ADDR X PLACE");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.cumberland.nc.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.endsWith("|N")) {
      subject = subject.substring(0,subject.length()-2);
      body = "(N) " + body;
    }
    if (subject.equals("S")) body = "(S)" + body;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strPlace = match.group(1);
    body = body.substring(match.end());
    
    return parseFields(body.split(";"), data);
  }
  
  @Override
  public String getProgram() {
    return "PLACE " + super.getProgram();
  }
}
