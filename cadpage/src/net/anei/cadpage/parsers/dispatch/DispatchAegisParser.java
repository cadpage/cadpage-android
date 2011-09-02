package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;


/*
 * Generic base dispatcher for Aegis CAD system clients
 * 
Caroline County, MD
(Chief ALT) [PM13] 26 A-Sick Person -- 520 Kerr Ave Denton - XSts: Dead End / Daffin Ln
(Chief ALT) [200 Fire] Wires Down -- 22542 Dover Bridge Rd Preston - XSts: Poplar Neck Rd, Tanyard Rd / Bethlehem Rd
(Chief ALT) [200 Fire] 17 A-Falls -- 21182 Marsh Creek Rd Preston - XSts: Frazier Neck Rd / Bethlehem Rd
(Chief ALT) [200 EMS] House Fire -- 22272 Havercamp Rd Preston - XSts: Prchal Rd / Poplar Neck Rd
(Chief ALT) [200 EMS] 23 B-Overdose / Poisoning -- 320 Park Ave Federalsburg - XSts: Railroad Ave / Academy Ave
(Chief ALT) [200 EMS] 19 D-Heart Problems / A.i.c.d. -- 121 E Central Ave Federalsburg - XSts: Reliance Ave / N Main St, S Main St, W Central Ave
(Chief ALT) [200 EMS] 23 D-Overdose / Poisoning -- 156 Main St Preston - XSts: Harmony Rd / Lednum Ave
(Chief ALT) [200 EMS] 27 B-Stab/gsw/pen. Trauma -- 6181 Bethlehem Rd Preston - XSts: Harmony Rd, Gilpin Point Rd / Bell Creek Rd, Grove Rd
(Chief ALT) [200 EMS] 04 B-Assault -- 305 Bloomingdale Ave Federalsburg - XSts: N University Ave / Hayman Dr

Ocean City, MD 
(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2500 Baltimore Ave - Crystal Beach Hotel - ADD:(s) (n)boardwalk OCMD - Cross STS:26th St & 25th St
(Chief ALT) [STA:700] - Nature:Vehicle Fire - ADD:8878 Stephen Decatur Hwy OCMD - Cross STS:Clark Rd & Landings Blvd
[Chief ALT]  [STA:700] - Nature:Mutual Aid Fire - ADD:1 W Indian St OCMD - Cross STS:Bay St & E Indian St
(Chief ALT) [700 Service] - Nature:Public Service - ADD:24 White Crane Dr OCMD - Cross STS:Misty Shore Dr & Mystic Harbour Blvd
(Chief ALT) [700 Auto] - Nature:Auto Alarm - ADD:4 Hidden Cove Way OCMD - Cross STS:Fountain Dr W & Sunset Island Dr
[Chief ALT]  [STA:700] - Nature:Gas Leak - LOC:Coins - ADD:2820 Philadelphia Ave OCMD - Cross STS:29th St & 28th St
[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:Sakura Japanese Steak House - ADD:12741 Ocean Gtwy OCMD - Cross STS:Golf Course Rd & Keyser Point Rd
(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:1208 Baltimore Ave - Beach Break - ADD:(s) (n)boardwalk OCMD - Cross STS:Woods Ln & 12th St
(Chief ALT) [STA:700] - Nature:Building Fire - LOC:408 Baltimore Ave - Tidelands Caribbean Annex Bldg - ADD:(s) (n)boardwalk OCMD - Cross STS:5th St & 4th St
(Chief ALT) [700 Auto] - Nature:Auto Alarm - LOC:2700 Baltimore Ave - Dunes Motel - ADD:(s) (n)boardwalk OCMD - Cross STS:28th St & 27th St
[Chief ALT]  [700 Auto] - Nature:Auto Alarm - LOC:1701 Atlantic Ave - Holiday Inn Hotel & Suites - ADD:(s) (n)boardwalk OCMD - Cross STS:18th St & 17th St

Kent County, DE (Alternate)
(Chief ALT) [KCPS] - [911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.
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

 */
public class DispatchAegisParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" +--? +");
  
  public DispatchAegisParser(String defCity, String defState, String program) {
    super(defCity, defState, program);
  }
  
  public DispatchAegisParser(String[] cityList, String defCity, String defState, String program) {
    super(cityList, defCity, defState, program);
  }
  
  public DispatchAegisParser(Properties cityCodes, String defCity, String defState, String program) {
    super(cityCodes, defCity, defState, program);
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] subjects = subject.split("\\|");
    if (subjects.length != 2 || !subjects[0].equals("Chief ALT")) return false;
    data.strSource = subjects[1];
    
    if (body.startsWith("-")) body = body.substring(1).trim();
    String[] flds = DELIM.split(body);
    if (flds.length > 1) {
      if (parseFields(DELIM.split(body), data)) return true;
    }
    
    data.strPlace = body;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
