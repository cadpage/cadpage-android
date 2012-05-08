package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Hanover County, VA
Contact: brian_grimes@verizon.net
Contact: James Mayhew <kc4bpx@gmail.com>
Sender: e911@ps400.hanoverva.org

Subject:(21777) a\nUnit:E12 UnitSts: Inc#:2010-00000919 Inc:MVANoInj Loc:36 S INTERSTATE 295 MapRef:R Map 1591 VEH VS DEER, NO INJS, H
(16407]  a ) Unit:E07 UnitSts: Inc#:2012-00031976 Inc:DifBreathn Loc:7103 NEW HUNTER RD MapRef:R Map 1593 APT 1011 Addtl:DIFF BREATHING
(12716a ) Unit:E07 UnitSts: Inc#:2012-00031961 Inc:Unconscous Loc:7052 MECHANICSVILLE TP MapRef:R Map 1592 PASSED OUT Addtl:
[(7584]  a ) Unit:E07 UnitSts: Inc#:2012-00031934 Inc:VehFire Loc:MECHANICSVILLE TP/BELL CREEK MapRef:R Map 1592 Addtl:IN TURNING LANE, ON FIRE
(5677 a ) Unit:E07 UnitSts: Inc#:2012-00000667 Inc:OutSmall Loc:BELLFLOWER CR/TIFFANY MapRef:R Map 1503 Addtl:WPH2:
[(5243]  a ) Unit:E07 UnitSts: Inc#:2012-00031927 Inc:VehCrash Loc:COLD HARBOR RD/BELL CREEK MapRef:R Map 1594 3 VEH MVA, UNKNW INJURIES Addtl:ONE ON RIGHT
[(3875]  a ) Unit:E07 UnitSts: Inc#:2012-00031920 Inc:OutSmall Loc:MECHANICSVILLE TP/COLONY MapRef:R Map 1592   IN THE MEDIAN SMOKING Addtl:

 */


public class VAHanoverCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[\\[\\(]?(\\d{4,})[\\)\\] a]*");
  private static final Pattern START_TRASH_PTN = Pattern.compile("^a +[\\)\n]");
    
  
  public VAHanoverCountyParser() {
    super("HANOVER COUNTY", "VA",
           "Unit:UNIT! UnitSts:SKIP! Inc#:ID! Inc:CALL Loc:ADDR! MapRef:MAP");
  }
  
  @Override
  public String getFilter() {
    return "e911@ps400.hanoverva.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    
    match = START_TRASH_PTN.matcher(body);
    if (match.find()) body = body.substring(match.start()).trim();
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("^[A-Z] Map \\d{4}\\b");
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_PTN.matcher(field);
      if (!match.find()) abort();
      data.strMap = match.group();
      field = field.substring(match.end()).trim();
      field = field.replace("Addtl:", "-");
      if (field.startsWith("-")) field = field.substring(1).trim();
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      data.strSupp = field;
    }
    
    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
}
