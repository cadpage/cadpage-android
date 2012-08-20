package net.anei.cadpage.parsers.DE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchAegisParser;

/*
Kent County, DE (Variant B)
Contact: jeffrey morris <bowers4015@gmail.com>
Contact: Adam Warner <awarner7777@gmail.com>
Sender: msg@cfmsg.com
System: Aegis CAD

(Chief ALT) [40 EMS] - 26A10 - Sick Person - Unwell/Ill -- 2536 Skeeter Neck Rd, Frederica -- Xst's: Bowers Beach Rd / E Front St -- Caller: High Vue Logging Inc
(Chief ALT) [KCPS] - [911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.
(Chief ALT) [40 EMS] - 23C1V - Overdose/Poisoning -- 181 Holly Dr, Frederica -- High Point Mhp -- Xst's: Garden Pl / Maple Dr -- Caller: Marrillo Paul
(Chief ALT) [55 EMS 1] - 2D2 - Allergic Reaction -- 149 Juanita Dr, Magnolia -- London Village -- Xst's: Jeffrey Dr / Millchop Ln -- Caller: Price Laura
(Chief ALT) [40 EMS] - 29B4 - MVC Unknown -- Mulberrie Point Rd, Frederica
(Chief ALT) [40 EMS] - 10D2 - Chest Pains -- 196 N  Bayshore Dr, Frederica -- Bowers Beach -- Xst's: N Flack Ave / Main St -- Caller: Margaret
(Chief ALT) [40 EMS] - 26C2 - Sick Person -- 201 Hubbard Ave, Frederica -- Bowers Beach -- Xst's: Dead End / Canal St -- Caller: Ingle Heather
(Chief ALT) [40 EMS] - 10C4 - Chest Pains -- 302 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Second St, Sycamore Dr / Lorna Ln -- Caller: Thom Ronald
(Chief ALT) [40 EMS] - 6C1 - Breathing Problems -- 294 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Kiwi Ct / Kylie Ln -- Caller: Hurd Shirley
(Chief ALT) [40 Fire] - 17A2 - Falls - Non-Recent -- 254 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Tyson Ln / Ibis Ct -- Caller: Spink Kimberley
(Chief ALT) [40 Fire] - Outside Fire-Unknown 2124 BOWERS BEACH RD, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd

Contact:Active911
[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 110 Firehouse Ln Marydel - Cross Sts: Strauss Av\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- Wolf Creek Blvd/ Glenda Rd Dover - Cross Sts: None\n
[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 2898 Arthursville Rd Hartly - Cross Sts: Main St\n Everetts Corner R Cross St2: Main St\n Everetts\n
[Chief ALT] [46 Fire] -- Structure-Commercial -- 1481 N Dupont Hwy Dover - Cross Sts: W Rustic L - Caller:HILL, ANTONETTE\n
[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 40 Saulsbury Rd Dover - Cross Sts: Carver R\n
[Chief ALT] [46 Fire] -- Outside Fire-Field,Grass,Woods -- 1365 N Dupont Hwy Dover - Cross Sts: Dover Mal - Caller:dfd\n
[Chief ALT] [46 Fire] -- 29D2L MVC Motorcycle/Bicycle -- 1131 N Dupont Hwy Dover - Cross Sts: Unknow - Caller:CODY\n
[Chief ALT] [46 Fire] -- 29B4 MVC Unknown -- College Rd/ Mckee Rd Dover - Cross Sts: None - Caller:JAKE\n
[Chief ALT] [46 Fire] -- Electrical Hazard-Arcing -- 1001 Forrest Ave Dover - Cross Sts: Saulsbury Rd\n Forest S Cross St2: Saulsbury\n
[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- 411 S Queen St Dover - Cross Sts: Dupont S\n
[Chief ALT] [46 Fire] -- Alarms CO-Residential (single) -- 39 Kentwood Dr Dover - Cross Sts: Bismark D\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 1368 Rose Valley School Rd Dover - Cross Sts: Unknow\n
[Chief ALT] [46 Fire] -- Search -- 1200 N Dupont Hwy Dover - Cross Sts: College R - Caller:DFD\n
[Chief ALT] [46 Fire] -- 6D1 Breathing Problems -- 14 Fair Wind Pl Dover - Cross Sts: Bay Tree R - Caller:LUKE\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 100 Haman Dr Dover - Cross Sts: Kesselring Av - Caller:TORRES, DIANNA\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 217 Rose Valley School Rd Dover - Cross Sts: Hazlettville R - Caller:KWNTCOM\n
[Chief ALT] [46 Fire] -- Vehicle Fire -- 439 Phoenix Dr Dover - Cross Sts: Santa Fe D - Caller:RILEY, EDEDE, E\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 75 Quail Hollow Dr Dover - Cross Sts: Village D - Caller:AUSTIN, THERESA\n
[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 868 Woodcrest Dr Dover - Cross Sts: Woodcrest Tur - Caller:DFD\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- State Hwy 1  - Cross Sts: None - Caller:BAER, BRETT\n
[Chief ALT] [46 Fire] -- Structure-Residential Single -- 880 Buttner Pl Dover - Cross Sts: Dead En\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n
[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- KENT CO COURT HOUSE -- 414 Federal St Dover - Cross Sts: William Penn S - Caller:SHANER, DISPATCHER\n
[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- LUTHER VILLAGE 1, LUTHER VILLAGE 2 -- 101 Babb Dr Dover - Cross Sts: Nob Hill R\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- COMPASSIONATE PAIN MANAGEMENT -- 740 S New St Dover - Cross Sts: South S - Caller:44, DES\n
[Chief ALT] [46 Fire] -- Alarms-Residential (multiple) -- APT-PINE GROVE APTS -- 255 Webbs Ln Dover - Cross Sts: John Clark Rd\n Mayberry L Cross St2: John Clark R - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- SILVER LAKE CENTER -- 1080 Silver Lake Blvd Dover - Cross Sts: Unknow - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- 22 The Green Dover - Cross Sts: Bank L - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- CHRIST CHURCH -- 501 S State St Dover - Cross Sts: W Water St\n Water S Cross St2: W Water S - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 281 Sheffield Dr Dover - Cross Sts: Norwich Wa - Caller:ADT\n
[Chief ALT] [46 Fire] -- Structure-Mobile Home/Trailer -- 243 Kentwood Dr Dover - Cross Sts: Phoenix D - Caller:SHANON\n


 */
public class DEKentCountyBParser extends DispatchAegisParser {
  
  public DEKentCountyBParser() {
    super(CITY_LIST, "KENT COUNTY", "DE",
           "CODE? CALL+? ADDR! PLACE Xst's:X Caller:NAME");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = body.replace(" - Cross Sts:", " - Xst's:");
    return super.parseMsg(subject,  body, data);
  }
  
  // Call field concatenates with dashes
  // And extract possible leading code
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d{1,2}[A-Z]\\d{1,2}) ");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCode.length() == 0) {
        Matcher match = CODE_PTN.matcher(field);
        if (match.find()) {
          data.strCode = match.group(1);
          field = field.substring(match.end()).trim();
        }
      }
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  // Address field may have comma delimited city name
  private class MyAddressField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {

      // If we haven't found a call decription yet, look for one at the beginning of this field
      StartType st = StartType.START_ADDR;
      int flags = FLAG_ANCHOR_END;
      if (data.strCall.length() == 0) {
        st = StartType.START_CALL;
        flags |= FLAG_START_FLD_REQ;
      }
      
      // See if there is a comma separating the city from the address
      // If there is, this is a confirmed address field
      int pt = field.lastIndexOf(',');
      if (pt > 0) {
        String city = field.substring(pt+1).trim();
        if (!CITY_SET.contains(city.toUpperCase())) return false;
        field = field.substring(0,pt).trim();
        if (st == StartType.START_CALL) {
          parseAddress(st, flags, field, data);
        } else {
          parseAddress(field, data);
        }
        data.strCity = city;
        return true;
      }
      
      
      // We will have to try parsing this.  If we find a city, it is considered good
      else {
        Result res = parseAddress(st, flags, field);
        if (res.getCity().length() == 0) return false;
        res.getData(data);
        return true;
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  public class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("None")) return;
      super.parse(field,  data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new CodeField("\\d{1,2}[A-Z]\\d{1,2}");
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "DOVER",
    "HARRINGTON",
    "MILFORD",
    
    // Towns
    "BOWERS",
    "CAMDEN",
    "CHESWOLD",
    "CLAYTON",
    "FARMINGTON",
    "FELTON",
    "FREDERICA",
    "HARTLY",
    "HOUSTON",
    "KENTON",
    "LEIPSIC",
    "LITTLE CREEK",
    "MAGNOLIA",
    "SMYRNA",
    "VIOLA",
    "WOODSIDE",
    "WYOMING",
    
    // Census - designated places
    "DOVER AIR FORCE BASE",
    "HIGHLAND ACRES",
    "KENT ACRES",
    "RISING SUN-LEBANON",
    "RIVERVIEW",
    "RODNEY VILLAGE",
    "WOODSIDE EAST",
    "[EDIT]OTHER LOCALITIES",
    "ANDREWVILLE",
    "BERRYTOWN",
    "LITTLE HEAVEN",
    "MARYDEL"
  };
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(CITY_LIST));
}
