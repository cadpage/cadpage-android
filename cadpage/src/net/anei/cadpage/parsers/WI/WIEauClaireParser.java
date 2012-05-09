package net.anei.cadpage.parsers.WI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Eau Claire, WI
Contact: "Cody Davey" <cody@wisconsinrangers.net>
Sender: tfddispatch@att.net

[Case# 11-253]  @5:23:16 AM // Brunswick // W2250 Rim Rock Rd // Vehicle Fire // vehicle fire, no exposures
[Case# 11-252]  @7:21:18 PM // Washington // 4940 Meadowbrook Ln // Sounding Fire Alarm // sounding fire alarm, showing 1st & 2nd floor smoke detector
[Case# 11-251]  @4:03:35 PM // Washington // 4400 blk South Lowes creek  rd // Fire //
[Case# 11-250]  @12:48:10 PM // Union // HWY 12 & N. Crossing // Motorvehicle Collision // 10/50 PI
[Case# 11-249]  @1:04:04 PM // Brunswick // W2601 HWY 37 // Electrical/Powerline Emergency // powerline is down and pole is on fire
[Case# 11-248]  @4:48:14 PM // Union // I-94, 59mm, Westbound // Motorvehicle Collision // 10/50 PI
[Case# 11-244]  @1:01:11 PM // Brunswick // Jopke Rd & HWY 37 // Motorvehicle Collision // 10/50 PI
[Case# 11-241]  @10:25:42 AM // Washington // I94 WB Mile Marke 65 // Rescue/Medical Assist // 61 y/o male poss stroke

Contact: Andrew Gaede <veghunter10@gmail.com>
Sender: tfddispatch@att.net
@4:38:53 PM // Rock Creek (Dunn) // HWY 85 & 870th // Motorvehicle\nCollision // 3 vehicle 10/50 PI, no extrication, Station 5 requested for\nassistance

Contact: Me <cody@wisconsinrangers.net>
Sender: tfddispatch@att.net
(Case# 12-099) @2:45:18 AM // Seymour // Peterson Ave & Olson Dr. // MVC Extrication //\n10/50 PI with Extrication needed

Contact: Chris Hedlund <chrishedlund213@yahoo.com>
Sender: tfddispatch@att.net
(Case# 12-117) @2:40:48 PM // Washington // henry at pamona // Motorvehicle Collision\n//
(Case# 12-116) @1:51:32 PM // Washington // 500 block Deerfield RD  //\nIllegal/Attempted Burn // large brush pile
(Case# 12-115) @10:31:26 PM // Seymour // 13034 Rossman Dr. // Electrical/Powerline\nEmergency // wires arcing
(Case# 12-114) @6:32:48 PM // Union // 2211 Sherman Creek Rd // Service Call // Tree\nhas fallen into a house
(Case# 12-112) @5:58:51 AM // Tiffany Twp (Dunn) // N11504 280th St // Search Call //\nSearch for hunter missing for 26+hours.  Request is for Manpower and\npossi
(Case# 12-110) @1:10:09 PM // Brunswick // 4800 Karissa Dr. // Motorvehicle Collision\n// 10/50 PI
(Case# 12-107) @8:14:11 AM // Seymour // Freeway 53 92mm Southbound // Vehicle Fire //\nvehicle fire
(Case# 12-104) @11:13:39 AM // Brunswick // S8725 County Line Rd // Brush/Wildland Fire\n// possible out of control burn/brush fire in a field
(Case# 12-099) @2:45:18 AM // Seymour // Peterson Ave & Olson Dr. // MVC Extrication //\n10/50 PI with Extrication needed
(Case# 12-100) @1:33:50 PM // Pleasant Valley // S10700 Hwy 93 // Brush/Wildland Fire\n// grass fire

 */
public class WIEauClaireParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Case# (\\d\\d-\\d{3})");
  
  public WIEauClaireParser() {
    super("EAU CLAIRE", "WI",
           "TIME CITY ADDR CALL INFO+");
  }
  
  @Override
  public String getFilter() {
    return "tfddispatch@att.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher  match = SUBJECT_PTN.matcher(subject);
    if (match.matches()) {
      data.strCallId = match.group(1);
    }
    body = body.replace("\n", " ").replaceAll("  +", " ");
    return parseFields(body.split("//"), data);
  }
  
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyTimeField extends TimeField {
    
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("@")) abort();
      setTime(TIME_FMT, field.substring(1), data);
    }
  }
  
  private static final Pattern CITY_COUNTY_PTN = Pattern.compile("(.*)\\((.*)\\)");
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CITY_COUNTY_PTN.matcher(field);
      String county = "";
      if (match.find()) {
        field = match.group(1).trim();
        county = match.group(2).trim();
      }
      if (field.toUpperCase().endsWith(" TWP")) {
        field = field.substring(0, field.length()-4).trim();
      }
      field = append(field, ", ", county);
      super.parse(field, data);
    }
  }
  
  private static final Pattern BLOCK_PTN = Pattern.compile("\\bBLOCK\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = BLOCK_PTN.matcher(field).replaceAll("BLK");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}