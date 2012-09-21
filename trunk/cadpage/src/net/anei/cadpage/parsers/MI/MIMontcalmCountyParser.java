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

Contact: Dwight C <dwightsright@gmail.com>
Sender: CAD@mydomain.com
CAD:6300 N DOUGLAS RD;1204703;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: -Comments: TOOK A NITRO ABOUT 5 MINS AGO-NO R
CAD:216 W LAKE ST;1204713;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 70 year old, Male, Unconscious, Breathing. Unconscious -- AGONAL/INEFFEC
CAD:10522 E BOYER RD;1204741;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 48 year old, Male, Consciousness unknown, Breathing status unknown. A
CAD:213 E SHERMAN ST;1204747;foot ball game [08/28/12 17:57:06 JPYLE]
CAD:501 S ROCK LAKE DR;1204801;REQUEST FOR RESCUE [08/30/12 21:45:45 SDAVIS] 17-A-3 [08/30/12 21:44:40 SDAVIS] [Medical Priority Info] Key Questions Complete RESPO
CAD:10522 E BOYER RD;1204802
CAD:FYI: ;08/26/2012 11:01:49;E STANTON RD/S MT HOPE RD;MT HOPE E STANTON RD JUST TO THE EAST SMELLS REALLY BAD OF NATURAL GAS [08/26/12 11:02:10 BDOOD]
CAD:620-119 N SECOND ST;1204810;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 77 year old, Male, Unconscious, Breathing. Unconscious -- Effectiv
CAD:320-15 JUNIPER ST;1204817;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 70 year old, Female, Conscious, Breathing. POSSIBLY DANGEROUS body a
CAD:7925 PENNY LANE;1204819;PAGED R23 SECOND TIME [08/31/12 15:29:55 KBAILEY] aired over primary [08/31/12 15:24:59 JPYLE] [Medical Priority Info] RESPONSE: Amb &
CAD:118 E PINE ST;1204821;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: 81 year old, Female, Conscious, Breathing. [08/31
CAD:503 GARY ST;1204825;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 21 year old, Male, Unconscious, Breathing. CONTINUOUS or MULTIPLE seizures
CAD:620 N SECOND ST;1204826;[Medical Priority Info] Key Questions Complete RESPONSE: Amb & Rescue RESPONDER SCRIPT: 81 year old, Male, Conscious, Breathing. [09/01
CAD:4401 E DEANER RD;1204828;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 45 year old, Male, Unconscious, Breathing status unknown. Unconscious
CAD:620-103 S SECOND ST;1204832;[Medical Priority Info] RESPONSE: Amb & Rescue RESPONDER SCRIPT: 79 year old, Male, Conscious, Breathing. NON-RECENT (=> 6hrs) inju 

 */
public class MIMontcalmCountyParser extends DispatchOSSIParser {
  
  public MIMontcalmCountyParser() {
    super("MONTCALM COUNTY", "MI",
           "( FYI DATETIME ADDR CALL! | ADDR ID ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@mydomain.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (! super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) data.strCall = "EMS ALERT";
    return true;
  }
  
  private class MyCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Event spawned from ")) field = field.substring(19).trim(); 
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("-Comments:")) field = field.substring(10).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ID")) return new IdField("\\d{7}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
