package net.anei.cadpage.parsers.NH;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Keene Mutual Aid (VT & NH)
Contact: Nick Cushman <flame05154@gmail.com>
Sender: cad_do_not_reply@firemutualaid.com
System: Symposium

Firemutualaid.com lists all the departments they dispatch 

(CAD Automated Event Notification) 12 CLARK CT\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n1\r\n\r\nNotes\r\n89 Y/O M, BLEEDING FROM PENIS FROM CATHADER, CBA
(CAD Automated Event Notification) 12 CLARK CT\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n1\r\n\r\nNotes\r\nTAC: Tac 1\r\n89 YOM, ILL
(CAD Automated Event Notification) 13 STURTEVANT LN\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n1\r\n\r\nNotes\r\nCaller Phone: 8696225\r\n25YOF KNEE INJ\r\nSOCCER F
(CAD Automated Event Notification) 347 BROOKLINE RD\r\nNO NAME\r\nATHENS\r\nMEDICAL\r\nAthens\r\n\r\nNotes\r\nCaller Name: LIFELINE\r\nWILLIAMS 73F FALLEN HEAD E
(CAD Automated Event Notification) 17 RIVER\r\nNO NAME\r\nSAXTONS RIVER\r\nBRUSH/SMOKE INVEST\r\n1\r\n\r\nNotes\r\nCaller Phone: 869-1399\r\nCaller Name: KIM FAI
(CAD Automated Event Notification) 14 STURTEVANT LN\r\nNO NAME\r\nSAXTONS RIVER\r\nAFA/BOX ALARM\r\n1\r\n\r\nNotes\r\nSTURTAVANT BUILDING\r\nCaller Name: HOME SE
(CAD Automated Event Notification) 801 SAXTONS RIVER RD\r\nNO NAME\r\nROCKINGHAM\r\nMEDICAL\r\n3\r\n\r\nNotes\r\nCaller Phone: 888-289-2018\r\nBUDZIC 90M CARD HX
(CAD Automated Event Notification) 27 MAIN\r\nSAXTONS RIVER INN (MAIN)\r\nSAXTONS RIVER\r\nAFA/BOX ALARM\r\n1

*/


public class NHKeeneMutualAidParser extends FieldProgramParser {
  
  public NHKeeneMutualAidParser() {
    super("","",
           "ADDR PLACE CITY CALL INFO+ Caller_Phone:PHONE? Caller_Name:NAME INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad_do_not_reply@firemutualaid.com";
  }

  @Override
  public String getLocName() {
    return "Keene Mutual Aid, NH";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD Automated Event Notification")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("NO NAME")) return;
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      data.strState = CITY_STATE_MAP.getProperty(field.toUpperCase(), "");
    }
    
    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
  
  private static final Pattern PRI_PTN = Pattern.compile("\\d");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("TAC:")) {
        data.strChannel = field.substring(4).trim();
      } else if (PRI_PTN.matcher(field).matches()) {
        data.strPriority = field;
      } else {
        if (field.startsWith("Notes")) field = field.substring(5).trim();
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PRI INFO CH";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_STATE_MAP = buildCodeTable(new String[]{
      "ACWORTH",        "NH",
      "ALSTEAD",        "NH",
      "AMHERST",        "NH",
      "ANTRIM",         "NH",
      "ATHENS",         "VT",
      "BELLOWS FALLS",  "VT",
      "BENNINGTON",     "VT",
      "BRATTLEBORO",    "VT",
      "CHARLESTOWN",    "NH",
      "CHESTER",        "VT",
      "CHESTERFIELD",   "NH",
      "CLAREMONT",      "NH",
      "DUBLIN",         "NH",
      "DUMMERSTON",     "VT",
      "EAST DOVER",     "VT",
      "EAST SWANZEY",   "NH",
      "FITZWILLIAM",    "NH",
      "FRANCESTOWN",    "NH",
      "GILSUM",         "NH",
      "GOSHEN",         "NH",
      "GRAFTON",        "NH",
      "GREENFIELD",     "NH",
      "GUILFORD",       "VT",
      "HALIFAX",        "VT",
      "HANCOCK",        "NH",
      "HARRISVILLE",    "NH",
      "HINSDALE",       "NH",
      "JAFFREY",        "NH",
      "JAMAICA",        "VT",
      "KEENE",          "NH",
      "LANGDON",        "NH",
      "LEMPSTER",       "NH",
      "LONDONDERRY",    "NH",
      "LYNDEBOROUGH",   "NH",
      "MARLBORO",       "VT",
      "MARLBOROUGH",    "NH",
      "MARLOW",         "NH",
      "MEADOWOOD",      "",
      "NELSON",         "NH",
      "NEW IPSWICH",    "NH",
      "NEWBROOK",       "VT",
      "NORTH WALPOLE",  "NH",
      "PERU",           "VT",
      "PETERBOROUGH",   "NH",
      "PUTNEY",         "VT",
      "READSBORO",      "VT",
      "RICHMOND",       "NH",
      "RINDGE",         "NH",
      "ROCKINGHAM",     "VT",
      "ROXBURY",        "NH",
      "ROYALSTON",      "",
      "SAXTONS RIVER",  "VT",
      "SOUTH LONDONDERRY", "VT",
      "SPOFFORD",       "NH",
      "SPRINGFIELD",    "VT",
      "STODDARD",       "NH",
      "STRATTON",       "VT",
      "SULLIVAN",       "NH",
      "SURRY",          "NH",
      "SWANZEY",        "NH",
      "TEMPLE",         "NH",
      "TOWNSHEND",      "VT",
      "TROY",           "NH",
      "UNITY",          "NH",
      "VERNON",         "VT",
      "WALPOLE",        "NH",
      "WARDSBORO",      "VT",
      "WASHINGTON",     "NH",
      "WEST CHESTERFIELD", "NH",
      "WEST DOVER",     "VT",
      "WEST SWANZEY",   "NH",
      "WESTMINSTER",    "NH",
      "WESTMORELAND",   "NH",
      "WESTON",         "VT",
      "WHITINGHAM",     "VT",
      "WILLIAMSVILLE",  "VT",
      "WILMINGTON",     "VT",
      "WINCHENDON",     "NH",
      "WINCHESTER",     "NH",
      "WINDHAM",        "VT",
      "WINHALL",        "VT"
  });
}
