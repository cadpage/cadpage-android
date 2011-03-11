package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.SmsMsgInfo.Data;

import net.anei.cadpage.parsers.FieldProgramParser;

/*
Prineville, OR
Contact: 5414603655@vzwpix.com
Sender:dispatch@prinevillepd.org

(NEW INCIDENT) 3/10/2011 1003\nEVENT # 1103100020 PFD\nMABD - ABDOMINAL PAIN\nPRIORITY 1 \nLOCATION 2250 SE KYLE RD\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: HA
(NEW INCIDENT) 3/11/2011 1003\nEVENT # 1103110010 PFD\nBURN - BURN INFO ONLY\nPRIORITY 1 \nLOCATION 6282 NW GREEN VALLEY RD\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOM
(NEW INCIDENT) 3/11/2011 0903\nEVENT # 1103110009 PFD\nFALARM - FIRE ALARM\nPRIORITY 1 \nLOCATION 210 NE 3RD ST\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: BACK R\n
(NEW INCIDENT) 3/10/2011 0803\nEVENT # 1103100051 PFD\nMUNK - UNKNOWN MEDICAL\nPRIORITY 1 \nLOCATION 587 SE KNIGHT ST\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT:

*/

public class ORCrookCountyParser extends FieldProgramParser {
  
  public ORCrookCountyParser() {
    super("CROOK COUNTY", "OR",
           "SKIP EVENT:ID! CALL! PRIORITY:SKIP! LOCATION:ADDR! CITY:CITY! APT:APT PREMISE:PLACE COMMENT:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@prinevillepd.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (!subject.equals("NEW INCIDENT")) return false;
    
    body = body.replace("\nEVENT # ","\nEVENT:")
               .replace("\nPRIORITY ","\nPRIORITY:").replace("\nLOCATION ","\nLOCATION:")
               .replace("\nCITY ","\nCITY:").replace("\nAPT ","\nAPT:");
    return parseFields(body.split("\n"), data);
  }
}
