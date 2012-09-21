package net.anei.cadpage.parsers.OR;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Prineville, OR
Contact: 5414603655@vzwpix.com
Sender:dispatch@prinevillepd.org

(NEW INCIDENT) 3/10/2011 1003\nEVENT # 1103100020 PFD\nMABD - ABDOMINAL PAIN\nPRIORITY 1 \nLOCATION 2250 SE KYLE RD\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: HA
(NEW INCIDENT) 3/11/2011 1003\nEVENT # 1103110010 PFD\nBURN - BURN INFO ONLY\nPRIORITY 1 \nLOCATION 6282 NW GREEN VALLEY RD\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOM
(NEW INCIDENT) 3/11/2011 0903\nEVENT # 1103110009 PFD\nFALARM - FIRE ALARM\nPRIORITY 1 \nLOCATION 210 NE 3RD ST\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: BACK R\n
(NEW INCIDENT) 3/10/2011 0803\nEVENT # 1103100051 PFD\nMUNK - UNKNOWN MEDICAL\nPRIORITY 1 \nLOCATION 587 SE KNIGHT ST\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT:
(NEW INCIDENT) 3/10/2011 0803\nEVENT # 1103100050 PFD\nALARM - ALARM\nPRIORITY 1 \nLOCATION 705 NW 10TH\nCITY PRINEVILLE\nAPT 27\nPREMISE: \nCOMMENT: 90 YOF FALLE
(NEW INCIDENT) 3/10/2011 0703\nEVENT # 1103100047 PFD\nMVA - 1201: 1273 / 1225\nPRIORITY 1 \nLOCATION HWY 27 MP 2\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: SUV

([PRNV_911] NEW INCIDENT) 5/3/2011 0805\nEVENT # 1105030076 PFD\nMINJ - INJURIES\nPRIORITY 1 \nLOCATION 1265 NW LAMBERT RD\nCITY PRINEVILL
([PRNV_911] NEW INCIDENT) 5/3/2011 0705\nEVENT # 1105030067 PFD\nMFALL - FALL\nPRIORITY 1 \nLOCATION 210 SE 5TH ST\nCITY PRINEVILLE\nAPT 13
([PRNV_911] NEW INCIDENT) 5/3/2011 0605\nEVENT # 1105030061 PFD\nMFALL - FALL\nPRIORITY 1 \nLOCATION 14493 SE LEE WAY\nCITY PRINEVILLE\nAPT

Contact: James Shannon <firemedic2484@gmail.com>
S:NEW INCIDENT M:6/2/2011 1006\nEVENT # 1106020016 PFD\nALARM - 1201:1225/1221/1222/...\nPRIORITY 1\nLOCATION 1100 SE LYNN\nCITY PRINEVILLE\nAPT\nPREMISE:\nCOMMENT: SMOKE ALARM//

Contact: Jason Dad Hupp <hupp375@gmail.com>
Sender: fire_sms-bounces@listserv.cityofprineville.net
([PRNV_911] NEW INCIDENT) 7/21/2011 1107\nEVENT # 1107210080 PFD\nMUNK - UNKNOWN MEDICAL\nPRIORITY 1 \nLOCATION 3813 SE TILLAMOOK LOOP\nCI

*/

public class ORCrookCountyParser extends FieldProgramParser {
  
  public ORCrookCountyParser() {
    super("CROOK COUNTY", "OR",
           "SKIP EVENT:ID! CALL! PRIORITY:SKIP! LOCATION:ADDR! CITY:CITY APT:APT PREMISE:PLACE COMMENT:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@prinevillepd.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (!subject.contains("NEW INCIDENT")) return false;
    
    body = body.replace("\nEVENT # ","\nEVENT:")
               .replace("\nPRIORITY ","\nPRIORITY:").replace("\nLOCATION ","\nLOCATION:")
               .replace("\nCITY ","\nCITY:").replace("\nAPT ","\nAPT:");
    return parseFields(body.split("\n"), data);
  }
}
