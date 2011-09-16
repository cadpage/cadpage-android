package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Delaware County, PA (Variant C)
Contact: Mike Bierman <mtb2580@yahoo.com>
Sender: norwoodfireco@rcn.com

1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:[Update]\nF11032765\n06/09/2011\n04:13\nASSIST\nFD TO ASSIST EMS\n17 ELMWOOD AV\nS\n(Con't) 2 of 2\nELMWOOD AV\nMCKINLEY AV\n021/M100D/M100/027B\n~80YOM,Set Station Alarm activ\nFD\nFIRE\nANI/(End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031554 \n06/03/2011 \n08:56 \nSTREET \nSTREET CLOSED \nW ASHLAND AV & N MACDADE BLVD \nW\n(Con't) 2 of 2\nASHLAND AV \nN MACDADE BLVD \nM100D/STA02/STA05/STA09/STA01 \nBETWEEN N WELLS AND MACDADE ON(End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031406 \n06/02/2011 \n14:44 \nACC \nWITH INJURY REPORTED \n8TH AV & LINCOLN AV \n8TH\n(Con't) 2 of 2\nAV \nLINCOLN AV \n487/ENG08/027/M102A/RE08/071 \n610-461-1539,SEE THE MAN,STRIK \nFD \nFIRE \nCELL (End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031265 \n06/01/2011 \n20:40 \nFIRE-BLD \nBUILDING FIRE, COMMERCIAL BLDG \n734 CHESTER\n(Con't) 2 of 2\nPKE \nPENNSYLVANIA AV \nNASSAU BLVD \nENG08/021/027/SN08/RE08/076/07 \n-075.305228 +039.883204 (End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11031005 \n05/31/2011 \n18:14 \nFIRE-OTH \nFD INVESTIGATION \n241 W WINONA AV \nSYLVAN\n(Con't) 2 of 2\nAV \nTRITES AV \n021 \n-075.303855 +039.894780,~ GRIL \nFD \nFIRE \nANI/ALI \nRACHEL - SAME \nFIRE-OT(End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11029356 \n05/24/2011 \n00:41 \nALARM \nCARBON MONOXIDE ALARM \n711 SOUTH AV \nUNNAMED\n(Con't) 2 of 2\nSTREET \nQUAINT ST \nARID7/027/RID7B/677C/MRID7/LA4 \nò~3¿ \nFD \nFIRE \nANI/ALI \nWARD MARGARET - (End)
1 of 2\nFRM:norwoodfireco@rcn.com\nSUBJ:Messenger 911\nMSG:F11027808 \n05/16/2011 \n10:54 \nFIRE-BLD \nBUILDING FIRE, COMMERCIAL BLDG \n701 ASHLAND AV\n(Con't) 2 of 2\n22 \nDELMAR DR \nCARPENTERS CROSSING \nM06/012/017/027A/091/ENG05/TW0 \nMULTIPLE BUSINESSES (End)

*/

public class PADelawareCountyCParser extends FieldProgramParser {
  
  public PADelawareCountyCParser() {
    super("DELAWARE COUNTY", "PA",
           "SKIP? ID DATE TIME CALL CALL ADDR X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "norwoodfireco@rcn.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Messenger 911")) return false;
    if (!parseFields(body.split("\n"), data)) return false;
    
    // It is not uncommon to report the same info in address and cross street fields :(
    if (data.strCross.equals(data.strAddress)) data.strCross = "";
    return true;
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("F\\d{8}"), true);
    }
  }
  
  private class DateField extends SkipField {
    public DateField() {
      setPattern(Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d"), true);
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("DATE")) return new DateField();
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
}
