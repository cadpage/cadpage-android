package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Montcalm County, MI
Contact: Randy Kibilko <mcsert15@gmail.com>
Sender: cad@mydomain.com

CAD:FYI: ;06/22/2012 01:39:53;4566 S GREENVILLE RD;Event spawned from STRUCTURE FIRE. [06/22/2012 01:38:55 TMORTENSEN]
CAD:FYI: ;06/29/2012 14:52:54;215 N STATE ST;wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]    
CAD:Update: ;06/29/2012 14:52:54;300 N STATE ST;PHONE AND CABLE WIRES, TIRED OFF [06/29/12 15:10:51 JJOURDAN] wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]
CAD:FYI: ;07/03/2012 18:09:20;N LINCOLN ST/E DAY ST;LINE HANGING LOW - POLE TO HOUSE [07/03/12 18:10:19 MROSE] In the city of stanton mi.
CAD:FYI: ;07/05/2012 02:30:55;3720 EAST SHORE DR;POWER LINES DOWN-NO POWER IN THE AREA [07/05/12 02:32:30 TLARSON]
CAD:FYI: ;07/05/2012 02:36:07;96 W EVERGREEN RD;POWER LINES ARCING AND SPARKING [07/05/12 02:38:06 TLARSON]
CAD:FYI: ;07/05/2012 03:05:45;S STAINES RD/E SIDNEY RD;POWER LINES DOWN IN THE ROADWAY NORTH OF INTERSECTION [07/05/12 03:06:40 TMORTENSEN]
CAD:FYI: ;07/05/2012 03:06:43;5201 W HILLIS RD;TREE DOWN AND LINES ON FIRE [07/05/12 03:07:14 TMORTENSEN]
CAD:FYI: ;07/05/2012 03:09:06;2700 S NEVINS RD;3 POWER LINES [07/05/12 03:10:12 TMORTENSEN]
CAD:FYI: ;07/05/2012 03:21:54;S SHERIDAN RD/E PAKES RD;TREES DOWN/WIRES ACROSS THE ROADWAY [07/05/12 03:22:13 SDAVIS]
CAD:FYI: ;07/05/2012 03:24:52;147 E SIDNEY RD;LINES DOWN IN THE DRIVEWAY OF THE CALLERS ADDRESS [07/05/12 03:25:46 TLARSON] POWER LINES DOWN- [07/05/12
CAD:FYI: ;07/05/2012 03:53:11;588 W SIDNEY RD;TREES ON POWER LINES AT THE ABOVE LOCATION-REPORTED BY TRUCK 7 FROM STANTON FIRE [07/05/12 03:53:47

 */
public class MIMontcalmCountyParser extends DispatchOSSIParser {
  
  public MIMontcalmCountyParser() {
    super("MONTCALM COUNTY", "MI",
           "SKIP DATETIME ADDR CALL! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@mydomain.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("CAD:FYI: ;") && !body.startsWith("CAD:Update: ;")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Event spawned from ")) field = field.substring(19).trim(); 
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
}
