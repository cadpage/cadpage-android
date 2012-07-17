package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Burlington County, NJ
Contact: Active911

[] 22:41:04\n2012-00000107\nFIRE F Fire Call\n172 NAHMA TR\nCONAWAGA TR/CAYUSE TR\nSMELL OF SMOKE FROM BACK YARD\n3711\n
[] 14:48:13\n2012-00001094\nEMS E EMS Call\n650 TABERNACLE RD\nBEAR HEAD RD/TABERNACLE TWP LI\nMOTORCYCLE VS VEH MVA\n2510\n
[] 19:42:31\n2012-00000154\n132 E UnkMedEmrg\n110 NOKOMIS TR\nMISHE MOKWA TR/KAWESEA TR\n74F PAIN TO LEG UNABLE TO STAN\n3711\n
[] 21:04:44\n2012-00000112\n44 F Wires\n81 OSWEGO TR\nHIAWATHA TR/NANTUCKET TR\nPOSS. ELECTRICAL SURGE IN RES.\n3711\n
[] 13:27:05\n2012-00000113\nFIRE F Fire Call\n112 TABERNACLE RD\nMCKENDIMEN RD/TRADING POST WY\nWIRES SPARKING\n3711\n
[] 20:12:35\n2012-00000114\nFIRE F Fire Call\nSTOKES RD\nTABERNACLE RD\nSMOKE IN AREA NOT SURE WHERE I\n3711\n
[] 06:35:31\n2012-00000116\nFIRE F Fire Call\n100 STOKES RD\nMOHAWK TR/MINNETONKA TR\nFIRE ALARM...SMOKE AND HEAT IN\n3712\n

*/

public class NJBurlingtonCountyGParser extends FieldProgramParser {
  
  public NJBurlingtonCountyGParser() {
    super("BURLINGTON COUNTY", "NJ",
           "TIME ID CALL ADDR X INFO UNIT!");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}", true);
    return super.getField(name);
  }
}
