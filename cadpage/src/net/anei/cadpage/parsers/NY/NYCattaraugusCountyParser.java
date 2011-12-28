package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Cattaraugus County, NY
Contact: steve W <nibacgol@gmail.com>
Sender: 911@cattco.org,7770

Unit:WVD1 Loc:9356 ROUTE 240 Between:CONTEL ALY/FELTON HILL RD CN: CTV:ASHF Type:BLS BLEED Date:04/10/2011 Time:01:55 Info:67/F UNCONTROLLED NOSE BLEED Caller:SMITH,JAMES,, Inc#:2011-00000066 
Unit:WVD1 Loc:9883 DUTCH HILL RD Between:CEMETERY RD/CROSS RD CN: CTV:ASHF Type:ALS MVA Date:04/05/2011 Time:11:54 Info:ONE CAR IN DITCH W/INJURY Caller:DOE,JANE,, Inc#:2011-00000065 
Unit:WVD1 Loc:5700 HEINZ RD Between:ROUTE 240/END CN: CTV:ASHF Type:Stru Fire Date:03/30/2011 Time:10:19 Info:HOUSE FIRE Caller:VERIZON WIRELESS,,, Inc#:2011-00000061 
Unit:WVD1 Loc:ROUTE 219/PETERS Between:PETERS RD/ROUTE 219 CN: CTV:ASHF Type:BLS MVA Date:03/28/2011 Time:06:10 Info:MVC/2 VEHICLES/UNK INJURIES Caller:SMITH,JOHN,, Inc#:2011-00000060 
Unit:WVD1 Loc:RICEVILLE RD/MCLAUGHLIN Between:MCLAUGHLIN RD/RICEVILLE RD CN: CTV:ASHF Type:Veh Fire Date:03/23/2011 Time:06:24 Info:SNOW PLOW ON FIRE Caller:ERIE CO 911,,, Inc#:2011-00000057 
Unit:WVD3 Loc:CONNOISARAULEY RD Between:N CONNOISARAULEY RD/EOTT TOWN LINE CN: CTV:ASHF Type:MV Crash Date:03/17/2011 Time:07:23 Info:1 CAR MVC, NO INJURY, CAR PARTLY OFF INTO THE  ROADWAY, CAR INTO GUARD RAIL Caller:PATIENT,LACEY,, Inc#:2011-00000055 
Unit:WVD1 Loc:5790 FOX VALLEY RD Between:ROUTE 240/THORNWOOD DR CN: CTV:ASHF Type:ALS CHSTPN Date:03/22/2011 Time:12:15 Info:70 YOF CHEST PAIN Caller:JOHNSON,CHARLES,, Inc#:2011-00000056 
Unit:WVD1 Loc:6567 PLATO RD Between:IRISH HILL RD/JACKMAN HILL RD CN: CTV:ELLT Type:ALS CHSTPN Date:03/16/2011 Time:14:28 Info:64/YOF DIFF BREATHING CHEST PRESSURE Caller:KEMPSTON,CATHERINE,, Inc#:2011-00000193 
Unit:WVD2 Loc:8870 ROUTE 240 Between:ELLI TOWN LINE/ROSZYK HILL RD CN: CTV:ASHF Type:Fire Polce Date:03/14/2011 Time:11:27 Info:FIRE POLICE FOR DISABLED VEHICLE Caller:WEST VALLEY FIRE CHI,,, Inc#:2011-00000051 
Unit:WVD1 Loc:AHRENS RD Between:PRILL RD/ROUTE 219 CN: CTV:ASHF Type:Hazard Date:03/09/2011 Time:15:54 Info:NEXT TO CARSONS RESTAURANT, TREE DOWN BLOCKIN G BOTH LANES. Caller:WHITCOMB,LEON,, Inc#:2011-00000048 
Unit:WVD1 Loc:8984 ROUTE 219 Between:ELLI TOWN LINE/ASHFORD HOLLOW RD CN: CTV:ASHF Type:BLS ABPAIN Date:03/06/2011 Time:18:47 Info:81 YOM WITH ABD PAIN AND VOMITING Caller:BIGTREE,EUGENE,, Inc#:2011-00000046 
Unit:WVD1 Loc:4484 RICEVILLE RD Between:KREPPS RD/MCLAUGHLIN RD CN: CTV:MACH Type:Stru Fire Date:03/02/2011 Time:13:53 Info:CHIMNEY FIRE Caller:MOOSEHEAD,LEONARD,, Inc#:2011-00000058 
Unit:WVD1 Loc:7703 MEYER HILL RD Between:CRUMB HILL RD/REED HILL RD CN: CTV:EOTT Type:MHL 9.45 Date:03/01/2011 Time:16:12 Info:A WOMEN HERE IS 48 Y/O IS THREATING TO KILL HERSELF. SHE IS HIGHLY INTOXICATED.  THERE ARE SHOTGUNS IN THE HOUSE Caller:SMACKLE,ROLAND,, Inc#:2011-00005950 
Unit:WVD1 Loc:8616 ROUTE 219 Between:BEAVER MEADOWS RD/ASHF TOWN LINE CN: CTV:ELLT Type:Stru Fire Date:02/24/2011 Time:07:58 Info:CHIMNEY FIRE, UNKNOWN IF OCCUPIED, PASSER BY Caller:DAY,MR,, Inc#:2011-00000043 
Unit:WVD1 Loc:8374 ROHR HILL RD Between:PLATO RD/MILL VALLEY RD CN: CTV:EOTT Type:Stru Fire Date:02/05/2011 Time:20:45 Info:POSSIBLE STRUCTURE FIRE Caller:STICKMAN,WILLIAM,R, Inc#:2011-00000009 

Contact: Brian Albrecht <albrecht289@gmail.com>
CATTARAUGUS COUNTY SHERIFF ((29) 911 ) Unit:PED1 Loc:3RD ST Between: CN: CTV:OUTS Type:Assist Date:11/13/2011 Time:19:13 Info:ONE BRUSH TRUCK FROM PERRYSBURG TO RESPOND TO 3RD ST FORRESTVILLE Caller:CHAUTAUQUA COUNTY,,, Inc#:2011-00032648

*/

public class NYCattaraugusCountyParser extends FieldProgramParser {
  
  private static Pattern TRAIL_COMMA_PAT = Pattern.compile("[ ,]+$");
  private static Pattern LOCATION_PAT = Pattern.compile(".* COUNTY", Pattern.CASE_INSENSITIVE);
  
  private String address;
  
  public NYCattaraugusCountyParser() {
    super(CITY_CODES, "CATTARAUGUS COUNTY", "NY",
           "Unit:UNIT! Loc:ADDR! Between:X! CN:PLACE CTV:CITY Type:CALL Date:SKIP Time:SKIP Info:INFO Caller:NAME Inc:ID%");
  }
  
  @Override
  public String getFilter() {
    return "911@cattco.org,7770";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace(" Inc#:", " Inc:");
    address = null;
    if (!super.parseMsg(body, data)) return false;
    
    // A city code of OUTS -> OUTSIDE the county means we know nothing
    // about the county or state where this incident occurs :(
    if (data.strCity.equals("OUTSIDE")) {
      data.strCity = data.defCity = data.defState = "";
      
      // See if info field contains the entered address.  If it does, assume
      // that whatever follows the address is really a city name
      int pt = data.strSupp.indexOf(address);
      if (pt > 0) {
        data.strCity = data.strSupp.substring(pt + address.length()).trim();
      }
      
      // Otherwise, see if the name field contains a county or city name
      else if (LOCATION_PAT.matcher(data.strName).matches()) {
        data.strCity = data.strName;
        data.strName = "";
      }
    }
    return true;
  }
  
  // Address field just remembers the address field
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      address = field;
      super.parse(field, data);
    }
  }
  
  // Name field needs to remove trailing commas
  private class MyNameField extends NameField {

    @Override
    public void parse(String field, Data data) {
      
      Matcher match = TRAIL_COMMA_PAT.matcher(field);
      if (match.find()) {
        field = field.substring(0, match.start());
      }
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
     "ALLT","ALLEGANY",
     "ALLV","ALLEGANY",
     "ASHF","ASHFORD",
     "CARR","CARROLLTON",
     "CATT","CATTARAUGUS",
     "CLAR","CLARKSVILLE",
     "COLC","COLLINS CENTER",
     "COLD","COLDSPRING",
     "COLL","COLLINS",
     "CONE","CONEWANGO",
     "DAYT","DAYTON",
     "DELE","DELEVAN",
     "DELEVN","DELEVAN",
     "ELLI","ELLICOTTVILLE",
     "ELLT","ELLICOTTVILLE",
     "ELLV","ELLICOTTVILLE",
     "EOTT","EAST OTTO",
     "ERAN","EAST RANDOLPH",
     "FARM","FARMERSVILLE",
     "FRAT","FRANKLINVILLE",
     "FRAV","FRANKLINVILLE",
     "FREE","FREEDOM",
     "GENE","GENESEE",
     "GOWA","GOWANDA",
     "GVAL","GREAT VALLEY",
     "HINS","HINSDALE",
     "HUMP","HUMPHREY",
     "ISCH","ISCHUA",
     "LEON","LEON",
     "LIME","LIMESTONE",
     "LVLT","LITTLE VALLEY",
     "LVLV","LITTLE VALLEY",
     "LYND","LYNDON",
     "MACH","MACHIAS",
     "MANS","MANSFIELD",
     "NALB","NEW ALBION",
     "NAPO","NAPOLI",
     "OLEC","OLEAN CITY",
     "OLET","OLEAN",
     "OTTO","OTTO",
     "OUTS","OUTSIDE",
     "PERS","PERSIA",
     "PERT","PERRYSBURG",
     "PERV","PERRYSBURG",
     "PORT","PORTVILLE",
     "PORV","PORTVILLE",
     "RANT","RANDOLPH",
     "RANV","RANDOLPH",
     "REDH","RED HOUSE",
     "SALC","SALAMANCA CITY",
     "SALT","SALAMANCA",
     "SDAY","SOUTH DAYTON",
     "SPRGVLL","SPRINGVILLE",
     "SVAL","SOUTH VALLEY",
     "VILL","VILLENOVA",
     "YORK","YORKSHIRE"
  });
}
	