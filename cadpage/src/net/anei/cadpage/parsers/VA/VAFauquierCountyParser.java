package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



/*
Fauquier County, VA
Contact: CodeMessaging

CAD:0301;TRAFFIC ACCIDENT;8323 WEST MAIN ST;WINCHESTER RD;FROST ST;CO3;11C
CAD:0366;1050 I 66;179 I-66 W;I-66;CO3;11B
CAD:0410;PUBLIC SERVICE FIRE;5089 OLD TAVERN RD;OLD WINCHESTER RD;WINCHESTER RD;CO4
CAD:0304;OUTSIDE/BRUSH/DUMPSTER FIRE;3800-BLK COBBLER MOUNTAIN RD;EASTVIEW LN;DOUBLE J LN;CO3;11B
CAD:0301;OUTSIDE/BRUSH/DUMPSTER FIRE;8307 EAST MAIN ST;MELODY LN;WINCHESTER RD;CO3;11B
CAD:0367;1050 I 66;250 I-66 W;I-66;I-66;CO3
CAD:0101;FIRE ALARM INSTITUTIONAL;500 HOSPITAL DR;VETERANS DR;CO1
CAD:0306;OUTSIDE/BRUSH/DUMPSTER FIRE;10747 MORELAND RD;FOX HOLLOW RD;CARRINGTON RD;CO3;11B
CAD:0366;VEHICLE FIRE - COMMERCIAL;160 I-66 E;I-66;CO3;11C
CAD:0305;OUTDOOR ELECTRICAL HAZARD;10244 GLENARA LN;CREST HILL RD;CO3;11C
CAD:0311;PUBLIC SERVICE FIRE;3700-BLK GROVE LN;JUSTICE LN;ASHVILLE RD;CO3
CAD:0309;1050 WITH ENTRAPMENT/ROLLOVER;2787 LEEDS MANOR RD;RAVEN LN;MARSHALL SCHOOL LN;CO3;11C
CAD:0303;SMOKE/ELECTRICAL ODORS OUTSIDE;4000-BLK ZULLA RD;LITTLE RIVER LN;SERENITY LN;CO3;11 B
CAD:0301;SMOKE/ELECTRICAL ODORS OUTSIDE;8267-BLK EAST MAIN ST;OLD STOCKYARD RD;MELODY LN;CO3;11 B
CAD:0101;STRUCTURE FIRE - COMMERCIAL;333 CARRIAGE HOUSE LN;WEST SHIRLEY AVE;VETERANS DR;CO1;11C


*/

public class VAFauquierCountyParser extends FieldProgramParser {
  
  public VAFauquierCountyParser() {
    super("Fauquier County", "VA",
        "CAD:BOX CALL! ADDR! X X UNIT");
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! parseFields(body.split(";"), 5, data)) return false;

  return true;
}
  
  private static final Pattern UNIT_PTN = Pattern.compile(" *\\b(CO\\d|ST\\d)+(\\d\\d[A-Z])\\b* ");// Unit is labeled as CO# or ST# Channel could be any #Letter
  private class MyUnitField extends UnitField {
    
    @Override
    public void parse(String field, Data data) {    
    super.parse(field, data);
    Matcher match = UNIT_PTN.matcher(field);
    if (match.find()) {
      data.strUnit = match.group(1);
      data.strChannel = match.group(2);
  } 
    }
    @Override
    public String getFieldNames() {
      return "UNIT CH";
    }
  }
    @Override
    protected Field getField(String name) {
      if (name.equals("UNIT")) return new MyUnitField();
      return super.getField(name);   
    }
    

  
}

