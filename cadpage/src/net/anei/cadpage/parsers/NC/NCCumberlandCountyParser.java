package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

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

Contact: Brandon Norris <lawranger197@gmail.com>
Sender: messaging@iamresponding.com
(Station 13) 2011 07:30:53;ALERT WITH ABNORMAL BREATHING;ST13;2881 STRICKLAND BRIDGE RD;CENTURY CIR
(Station 13) 08/2011 18:00:08;RESIDENTIAL ALARM;0431,2131,ST13,ST19;5681 CAMDEN RD;STATE ST
(Station 13) 7/11/2011 16:16:30;DIFFICULTY SPEAKING BREATHING;ST13,ST19;4737 DESERT RIDGE RD;HYPONY TRL
(Station 13) POINT (N)C8;07/18/2011 16:13:08;NOT ALERT BREATHING PROBSLEMS;ST13;6240 STONEY POINT LOOP;SPRINGRUN RD
(Station 13) 2011 07:30:53;ALERT WITH ABNORMAL BREATHING;ST13;2881 STRICKLAND BRIDGE RD;CENTURY CIR
(Station 13) 08/2011 18:00:08;RESIDENTIAL ALARM;0431,2131,ST13,ST19;5681 CAMDEN RD;STATE ST

Contact: Jr McElyea <j.mcelyea1@gmail.com>
Sender: essaging@iamresponding.com
(Station #4) PAPER MILL 12/09/2011 22:21:31;ABNORMAL BREATHING CHEST PN;4474 CAMERON RD;PECAN DR

*/

public class NCCumberlandCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("(?:\\(S\\)) *(.*?) *\\(N\\) *");
  
  public NCCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "NC",
           "UNIT? DATETIME CALL SRC ADDR X PLACE");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.cumberland.nc.us,messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.endsWith("|N")) {
      subject = subject.substring(0,subject.length()-2);
      body = "(N) " + body;
    }
    if (subject.equals("S")) body = "(S)" + body;
    
    Matcher match = MARKER.matcher(body);
    if (match.find()) {
      data.strPlace = match.group(1).trim();
      body = body.substring(match.end());
    } else {
      int pt = body.indexOf("(N)");
      if (pt >= 0) body = body.substring(pt+3).trim();
    }
    
    return parseFields(body.split(";"), data);
  }
  
  private class MyUnitField extends UnitField {
    public MyUnitField() {
      setPattern(Pattern.compile("[A-Z][0-9]+"));
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(?:(.+?) +)??(?:([0-9/]+) +)?(\\b\\d\\d:\\d\\d:\\d\\d)");
  private static final Pattern DATE_PTN = Pattern.compile("\\d\\d/\\d\\d/\\d{4}");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strPlace = append(data.strPlace, " / ", getOptGroup(match.group(1)));
      String sDate = match.group(2);
      data.strTime = match.group(3);
      if (sDate != null && DATE_PTN.matcher(sDate).matches()) data.strDate = sDate;
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE DATE TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
}
