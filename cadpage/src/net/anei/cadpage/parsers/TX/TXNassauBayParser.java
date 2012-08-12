package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Nassau Bay (Harris County, TX?)
Contact: "Robert Hebert /City of Nassau Bay" <robert.hebert@nassaubay.com>
Sender: cad@ossicadpaging

39:CAD:FYI: ;NBFD;FIRE ALARM;18101 POINT LOOKOUT DR;NB;NB;01/12/2011  22:10:16;TRASHROOM 1 SMOKE DETECTOR [01/12/11 22:11:43 NHUGHES] fire alarms going
40:CAD:FYI: ;NBFD;STRUCTURE FIRE;1020-264 W NASA PKWY;WB;WBW;01/13/2011 11:46:25;smoke inside [01/13/11 11:45:40 TSWANSON]
41:CAD:FYI: ;NBFD;ACCIDENT MAJOR;NASA PKWY/ST JOHN BLVD;HO;NB;01/18/2011 12:53:59
CAD:FYI: ;NBFD;UNCONSCIOUS;1427 SAXONY LN;NB;NB;03/06/2011 14:30:40;female down in bathroom [03/06/11 14:30:28 DCOOLEY]
CAD:FYI: ;NBFD;ASSIST BY FIRE;3000 E NASA PKWY;SB;03/06/2011 15:38:43;boat [03/06/11 15:35:58 DCOOLEY]
:CAD:FYI: ;NBFD;VEHICLE FIRE;18100 UPPER BAY RD;NB;NB;03/26/2011 13:36:15

Contact: robert hunter <r.hunter20@gmail.com>
CAD:Update: ;WBFD;FIRE ALARM;450 W MEDICAL CENTER BLVD;WB;WBW;04/02/2011 07:22:55;CALLED THE NUMBER BELOW AND REC ANSWERING SERVICE THEY COULD PROVIDE MORE I
CAD:FYI: ;WBFD;ACCIDENT MAJOR;MAGNOLIA/ S KOBAYSHI;04/03/2011 18:01:07;gry mits eclipse/////18 wheeler [04/03/11 18:00:35 DJOHNSON]
:CAD:FYI: ;WBFD;SMELL OF SMOKE GAS OUTSIDE;18206 EGRET BAY BLVD;WB;WBE;04/04/2011 17:01:45;SMELL OF NATURAL GAS IN AREA - FENCED AREA NEXT TO ICHIBON [04/04/1
:CAD:FYI: ;WBFD;FIRE ALARM;1001-B W BAY AREA BLVD;WB;WBW;04/05/2011 12:18:03;manual pull in offc [04/05/11 12:18:19 ESALLIER]
:CAD:FYI: ;WBFD;UNCONSCIOUS;20233 IH 45 FWY;WB;WBW;04/07/2011 14:44:07;IN FRONT SHOWROOM [04/07/11 14:44:03 VKEENER] FEMALE PASSED OUT, IS BREATHING
:CAD:Update: ;WBFD;MINOR ACCIDENT;SH 3 HWY/MAGNOLIA AVE;WB;WBE;04/10/2011 13:23:20; 7 months [04/10/11 13:23:18 DCOOLEY] blk tk silber pt cruiser [04/10/11 17:42:10 MHAYES]
:CAD:FYI: ;WBFD;FIRE ALARM;901 S KOBAYASHI RD;WB;WBW;04/10/2011 16:11:22;RESIDENT OF 133 CALLED ADVISED SHE HAD A KITCHEN FIRE AND SPRINKLERS CAME ON
:CAD:FYI: ;WBFD;UNCONSCIOUS;409 GREEN ST;WB;WBW;04/09/2011 11:58:10;he is breathing [04/09/11 11:58:08 TSWANSON] cold and clammy [04/09/11 11:57:46 TSWANSON]

Contact: "Bigonesse, Ray" <Ray.Bigonesse@leaguecity.com>
:CAD:FYI: ;LCFD;ELECTRICAL PROBLEMS SPARKS;FOX RUN CT/CREEKSIDE DR;LC;LCFW;09/10/2011 13:26:13;right next to soccer field, [09/10/11 1  
:CAD:Update: ;LCFD;ELECTRICAL PROBLEMS SPARKS;500-BLK PALOMINO LN;LC;LCFW;09/10/2011 13:26:13;(D2) E2 CAN GO BACK IN SERVICE [09/10/11 13
:CAD:Update: ;LCFD;ELECTRICAL PROBLEMS SPARKS;207 HIDDEN PINES CT;LC;LCFW;09/10/2011 13:26:13;(D2) CONTACT ELECTRIC CO. POLE # F1233565A,
:CAD:FYI: ;LCFD;FIRE ALARM;3045 W MARINA BAY DR;LC;LCFE;09/08/2011 08:52:28;NO CONTACT MADE [09/08/11 08:55:10 RCOX] BUILDING 2 ZONE 13 [
:CAD:FYI: ;LCFD;GRASS;2220 COVESIDE ST;LC;LCFE;09/08/2011 15:19:21;grass fire, front yard,possible from transformer [09/08/11 15:20:13 RD
:CAD:FYI: ;LCFD;FIRE ALARM;1455-3307 LOUISIANA AVE;LC;LCFE;09/07/2011 10:52:53;smoke dector alarm resd 281-557-2707 jones, jazzeline [09/
:CAD:FYI: ;LCFD;FIRE ALARM;1450 LOUISIANA AVE;LC;LCFE;09/07/2011 11:55:22;at bldg 5 [09/07/2011 11:55:20 KCOOK]
:CAD:FYI: ;LCFD;FIRE ALARM;211 W LEAGUE CITY PKWY;LC;LCFW;09/07/2011 12:04:36;automatic fire alarm, 24 hour fire circuit to positions 1 a
:CAD:FYI: ;LCFD;GRASS;2381 GUN RANGE RD;LC;LCFE;09/07/2011 14:33:12;grass, no buildings [09/07/11 14:33:47 RDARROW]

 */

public class TXNassauBayParser extends DispatchOSSIParser {
  
  private static final Pattern PREFIX = Pattern.compile("^\\d*:");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "HO", "NASSAU BAY",
      "LC", "LEAGUE CITY",
      "NB", "NASSAU BAY",
      "SB", "SEABROOK",
      "WB", "WEBSTER"
  });
  
  public TXNassauBayParser() {
    this("NASSAU BAY", "TX");
  }
  
  protected TXNassauBayParser(String defCity, String defState) {
    super(CITY_CODES, defCity, defState,
          "SKIP SRC CALL! ADDR! CITY? CODE? DATETIME INFO+");
  }
  
  @Override
  public String getAliasCode() {
    return "TXNassauBay";
  }
  
  @Override
  public String getFilter() {
    return "cad@ossicadpaging";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Strip off option number prefix
    Matcher match = PREFIX.matcher(body);
    if (match.find()) {
      body = body.substring(match.end()).trim();
    }
    return super.parseMsg(body, data);
  }
  
  // This is a location code rather than a call code.  But it shows up in the
  // right place so lets use it
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(Pattern.compile("[A-Z]{2,4}"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    return super.getField(name);
  }
}
