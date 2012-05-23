package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Burlington County, NJ (Variant D)
Contact: support@active911.com
Sender: riprun@westamptonfire.org
http://active911.com/interface/parser_report.php?key=107-EDp9G

(Messenger 911) Call Time: 11:58:04\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3410\nLocation: 1 STUDENT DR\nLocated Btwn: WOODLANE RD/DEAD END\nNature: JUV FELL OFF JUNGLE GYM
(Messenger 911) Call Time: 17:34:50\nIncident #: 03131         S\nIncident Type: 16 F Alarms\nQuadrant: 1340\nLocation: 1570 E RT38\nLocated Btwn: MT HOLLY BP/MAIN ST\nNature: FIRE ALARM//BASEMENT SMOKE DET
(Messenger 911) Call Time: 18:41:40\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2731\nLocation: 71 FIELDCREST DR\nLocated Btwn: WILDBERRY DR/SHARPLESS BV\nNature: MALE SLID OFF BED ONTO FLOOR
(Messenger 911) Call Time: 12:03:04\nIncident #: E509          S\nIncident Type: 106 E Breathin\nQuadrant: 5030\nLocation: 7 SAUL PL\nLocated Btwn: LEVIS DR/DEAD END\nNature: 78 Y/O M//RESP DISTRESS/HENRY 
(Messenger 911) Call Time: 13:30:23\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2731\nLocation: SPRINGSIDE RD\nLocated Btwn: IKEA DR\nNature: MVA/INJURIES
(Messenger 911) Call Time: 19:34:17\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3401\nLocation: 26 W RAILROAD AV\nLocated Btwn: LAKE DR/HAND LA\nNature: CARL BUTLER / SCIP TRANSPORT
(Messenger 911) Call Time: 18:42:15\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2721\nLocation: BURLINGTON MT HOLLY RD\nLocated Btwn: WOODLANE RD\nNature: MVA W/INJ
(Messenger 911) Call Time: 07:02:12\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 2721\nLocation: 1012 HOLLY LA\nLocated Btwn: OGDEN DR/HOWELL DR\nNature: CONFUSED ELDERLY FEMALE
(Messenger 911) Call Time: 08:57:48\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3401\nLocation: MILL CREEK RD\nLocated Btwn: POWELL RD/E MILL CREEK RD\nNature: JUV/ASTHMA ATTACK
(Messenger 911) Call Time: 14:35:08\nIncident #: 03161         S\nIncident Type: FIRE F Fire Call\nQuadrant: 1603\nLocation: 6 GUNNER LA\nLocated Btwn: GRAMERCY LA/GENESEE LA\nNature: KITCHEN FIRE
(Messenger 911) Call Time: 16:00:37\nIncident #: 03272         S\nIncident Type: FIRE F Fire Call\nQuadrant: 2721\nLocation: 700 RANCOCAS RD\nLocated Btwn: MUNICIPAL DR/IRICK RD\nNature: ACT GENERAL FIRE ALARM//WILL N
(Messenger 911) Call Time: 20:20:30\nIncident #: 03272         S\nIncident Type: EMS E EMS Call\nQuadrant: 3402\nLocation: 1 JESS CT\nLocated Btwn: JOE RD/DEAD END\nNature: FEMALE NOT BREATHING
(Messenger 911) Call Time: 00:41:36\nIncident #: 03272         S\nIncident Type: 132 E UnkMedEmrg\nQuadrant: 3401\nLocation: 26 W RAILROAD AV\nLocated Btwn: LAKE DR/HAND LA\nNature: CHANGE IN MEMTAL STATUS

*/

public class NJBurlingtonCountyDParser extends FieldProgramParser {
  
  public NJBurlingtonCountyDParser() {
    super("BURLINGTON COUNTY", "NJ",
           "Call_Time:TIME! Incident_#:ID! Incident_Type:CALL! Quadrant:MAP! Location:ADDR! Located_Btwn:X! Nature:INFO!");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Messenger 911")) return false;
    return parseFields(body.split("\n"), 7, data);
  }
  
  private class MyIDField extends IdField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" S")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIDField();
    return super.getField(name);
  }
}
