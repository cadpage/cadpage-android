package net.anei.cadpage.parsers.WA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/*
Pierce County, WA
Contact: Dave Marston <dcmarston@hotmail.com>
Sender: cadpage@rmetro.com

(- part 1 of 1)RC:0038-A/Run#36872/CALL:03:32/DISP:03:32/ENR:03:33/ATS:03:37/TRA:03:45/ATD:0 3:53/PUZIP:98408/DO:St Joseph Hospital

(- part 1 of 1) RC:Run# 36872/Sick Person/<Unknown>/S 56TH ST & PACIFIC AVE///X=56th&55th/TACOMA// AVE//606//TACOMA/773 G5/\r\n\r\nThis is a confidential/proprietary communication intended for the add
(- part 1 of 1) RC:Run# 45146/Unconscious/<Unknown>/6TH AVE & N STEVENS ST//behind 76 station/X=N Verde St&N Stevens St/TACOMA//\r\n\r\nThis is a confidential/propri
(- part 1 of 1) RC:Run# 46137/Unknown/<Unknown>/6016 N HIGHLANDS PKWY//371//TACOMA/772 J4/\r\n\r\nThis is a confidential/proprietary communication intended for the a
(- part 1 of 1) RC:Run# 45014/Sick Person/<Unknown>/919 FAWCETT AVE//606//TACOMA/773 G5/\r\n\r\nThis is a confidential/proprietary communication intended for the add
(- part 1 of 1) RC:Run# 46129/Trauma/<Unknown>/2018 E WRIGHT AVE///X=E Roosevelt Ave/TACOMA//\r\n\r\nThis is a confidential/proprietary communication intended for th
(- part 1 of 1) RC:Run# 46173/Unknown/<Unknown>/6316 S 12TH ST///X=Unknown Street with ID 1319802&S Whitman St/TACOMA//\r\n\r\nThis is a confidential/proprietary com
(- part 1 of 1) RC:Run# 46237/MVA/<Unknown>/4215 S 30TH ST///X=S Tyler St/TACOMA//\r\n\r\nThis is a confidential/proprietary communication intended for the addressee

 */

public class WAPierceCountyParser extends DispatchProQAParser {
  
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("RC:[-A-Z0-9]+/Run#\\d+/CALL:\\d\\d:\\d\\d/DISP:\\d\\d:\\d\\d/ENR:\\d\\d:\\d\\d/ATS:\\d\\d:\\d\\d/TRA:\\d\\d:\\d\\d/ATD:.*");
  
  public WAPierceCountyParser() {
    super("PIERCE COUNTY", "WA", 
           "CALL PLACE ADDR EXTRA+");
  }
  
  @Override
  public String getFilter() {
    return "cadpage@rmetro.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (super.parseMsg(body, data)) return true;
    if (!RUN_REPORT_PTN.matcher(body).matches()) return false;
    data.strCall = "RUN REPORT";
    data.strPlace = body;
    return true;
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("<Unknown>")) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\d{3}");
  private static final Pattern MAP_PTN = Pattern.compile("\\d{3} [A-Z]\\d");
  private class MyExtraField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("X=")) {
        data.strCross = append(data.strCross, " & ", field.substring(2).trim());
      }
      
      else if (UNIT_PTN.matcher(field).matches()) {
        data.strUnit = append(data.strUnit, " ", field);
      }
      
      else if (data.strCity.length() == 0 && CITY_SET.contains(field.toUpperCase())) {
        data.strCity = field;
      }
      
      else if (MAP_PTN.matcher(field).matches()) {
        data.strMap = field;
        return;
      }
      
      else {
        data.strSupp = append(data.strSupp, " / ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X UNIT CITY MAP INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("EXTRA")) return new MyExtraField();
    return super.getField(name);
  }

  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      
      // Census Designated Communities
      "ALDER",
      "ALDERTON",
      "ANDERSON ISLAND",
      "AUBURN",
      "ARTONDALE",
      "ASHFORD",
      "BETHEL",
      "BONNEY LAKE",
      "BUCKLEY",
      "CARBONADO",
      "DUPONT",
      "EATONVILLE",
      "EDGEWOOD",
      "ELBE",
      "ELK PLAIN",
      "ENUMCLAW",
      "FIFE",
      "FIRCREST",
      "FORT LEWIS",
      "FOX ISLAND",
      "FREDERICKSON",
      "GIG HARBOR",
      "GRAHAM",
      "GREENWATER",
      "HOME",
      "KETRON ISLAND",
      "KEY CENTER",
      "LA GRANDE",
      "LAKEWOOD",
      "LONGBRANCH",
      "MCCHORD AFB",
      "MCKENNA",
      "MIDLAND",
      "MILTON",
      "ORTING",
      "PACIFIC",
      "PARKLAND",
      "PRAIRIE RIDGE",
      "PUYALLUP",
      "ROY",
      "RUSTON",
      "SOUTH HILL",
      "SOUTH PRAIRIE",
      "SPANAWAY",
      "STEILACOOM",
      "SUMMIT",
      "SUMNER",
      "TACOMA",
      "UNIVERSITY PLACE",
      "VAUGHN",
      "WALLER",
      "WAUNA",
      "WILKESON",
      "WOLLOCHET",
      
      // Other communities
      "AMERICAN LAKE",
      "ARLETTA",
      "BROWNS POINT",
      "BURNETT",
      "CASCADIA",
      "CEDARVIEW",
      "CRESCENT VALLEY",
      "CROCKER",
      "CROMWELL",
      "DASH POINT",
      "DIERINGER",
      "ELECTRON",
      "ELGIN",
      "FIRWOOD",
      "GLENCOVE",
      "HARBOR HEIGHTS",
      "HERRON ISLAND",
      "LAKEBAY",
      "LONGBRANCH",
      "LOVELAND",
      "MAPLEWOOD",
      "MCNEIL ISLAND",
      "MEEKER",
      "NATIONAL",
      "OAKBROOK",
      "OHOP",
      "PARADISE",
      "POINT FOSDICK",
      "PONDEROSA ESTATES",
      "RAFT ISLAND",
      "RHODODENDRON PARK",
      "ROSEDALE",
      "SHORE ACRES",
      "SHOREWOOD BEACH",
      "SUNNY BAY",
      "SUNRISE BEACH",
      "SYLVAN",
      "THRIFT",
      "TILLICUM",
      "VICTOR",
      "VILLA BEACH",
      "WARREN"
  }));
}
