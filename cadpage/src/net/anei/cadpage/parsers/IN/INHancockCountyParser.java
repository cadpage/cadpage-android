package net.anei.cadpage.parsers.IN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Hancock County, IN
Contact: Brandon Wilch <bwilch@bctfd.org>
Vehicle Accident - PI/4100 N 600W GREENFIELD & W AIRPORT BLV/52/ E71 M71 FG1 BCFP1/gate 2A
Structure #ALARM#/7935 W 600N MCCORDSVILLE R12B12089 OAKLANDON/N 700W & N 800W/52/ E71 E72 L71 M71 FG1 BCFP1/General fire alarm
Vehicle Accident - PI/3600 N 600W GREENFIELD/W 350N & W STONER DR/17/ E71 M71 FG3 BCFP1
Sick / Ill Person/2500 N 700W GREENFIELD/W 200N & W 300N/53/ E71 M71 FG1 BCFP1/LE on traffic stop; requesting check out
Aircraft Down/5881 W AIRPORT BLV GREENFIELD FUEL DEPOT/N AVIATION WAY & N 600W/18/ T71 BCFP1/Aircraft into a cart; Vietest building

Contact: "dustin dishman fun jumps llc" <funjumpsllc@funjumpsllc.com>
Sender: 3172237965 <user phone>
Lifting Assistance/1549 S JEANNE CT NEW PALESTINE/DEAD END & S FOX COVE BLV/88/ E42 M42 FG2 SCFP1/75 yo male

Contact: support@active911.com
Sender: mplus@hancockcoingov.org
((59389) Investigate Gas Fumes/8023 N 600W STE.103 MCCORDSVILLE FARMERS INS / MCCORDSVILL) Investigate Gas Fumes/8023 N 600W STE.103 MCCORDSVILLE FARMERS INS / MCCORDSVILLE/W 800N & W 900N/40/ E31 FFDP1/caller adv he struck a gas main
((59620) Sick / Ill Person/453 E ILLINOIS ST FORTVILLE/N CENTER ST & N MADISON ST/21/ R39) Sick / Ill Person/453 E ILLINOIS ST FORTVILLE/N CENTER ST & N MADISON ST/21/ R39 S39 M5227 FFDP1/said male had shock therapy today and can t remember
((60655) Allergic Reaction/9567 CAMPFIRE-MADISON CO// FFDP1/brittany taylor 22yof - unkno) Allergic Reaction/9567 CAMPFIRE-MADISON CO// FFDP1/brittany taylor 22yof - unknown new medication for
((61517) Difficulty Breathing/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDE) Difficulty Breathing/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDEN DR/21/ R39 S39 M5227 FFDP1/Conc and breathing; 91 yoa female
((61823) Abdominal/610 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S39 M5) Abdominal/610 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S39 M5227 FFDP1/27yo female
((62910) Injured Person/7792 W 1050S FORTVILLE/S 750W & S LEE ST/310041/ S39 FFDP1/13 YEA) Injured Person/7792 W 1050S FORTVILLE/S 750W & S LEE ST/310041/ S39 FFDP1/13 YEAR OLD MALE
((63109) Assist Police or Sheriff/211 W RAILROAD ST FORTVILLE/S MCCARTY ST & DEAD END/21/) Assist Police or Sheriff/211 W RAILROAD ST FORTVILLE/S MCCARTY ST & DEAD END/21/ R39 FG1 FFDP1/NEEDING SCBA S FOR POSSIBLE DECEASED SUBJ
((63246) Sick / Ill Person/418 E STAAT ST FORTVILLE/N LELAND ST & E OHIO ST/21/ R39 S39 M) Sick / Ill Person/418 E STAAT ST FORTVILLE/N LELAND ST & E OHIO ST/21/ R39 S39 M5227 FFDP1/1 week old baby
((64109) Sick / Ill Person/503 THOMAS POINT DR FORTVILLE/DEAD END & BEACON POINT LN/21/ R) Sick / Ill Person/503 THOMAS POINT DR FORTVILLE/DEAD END & BEACON POINT LN/21/ R39 S39 M5227 FFDP1/CHECK OUT ON A FEMALE THAT HAS BEEN DRINKING
((65273) Injured Person/425 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S) Injured Person/425 N SCHOOL ST FORTVILLE/E MICHIGAN ST & E CAROLINA ST/21/ R39 S39 M5227 FFDP1
((1090) Difficulty Breathing/885 E BROADWAY ST RM.4 FORTVILLE COLONIAL MOTEL/LINDA DR &) Difficulty Breathing/885 E BROADWAY ST RM.4 FORTVILLE COLONIAL MOTEL/LINDA DR & MOTEL DR/22/ R39 S39 M5227 FFDP1
((1384) Difficulty Breathing/936 E BROADWAY ST FORTVILLE/MOTEL DR & EMERSON DR/22/ R39 S) Difficulty Breathing/936 E BROADWAY ST FORTVILLE/MOTEL DR & EMERSON DR/22/ R39 S39 M5227 FFDP1
((1639) Lifting Assistance/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDEN) Lifting Assistance/704 N MADISON ST APT.2 FORTVILLE APT 2/E HAMILTON ST & ALDEN DR/21/ S39 M5227 FG1 FFDP1

*/

public class INHancockCountyParser extends FieldProgramParser {
  
  public INHancockCountyParser() {
    super(CITY_LIST, "HANCOCK COUNTY", "IN",
           "CALL ( MUTADDR INFO | CALL+? ADDR/SXP CITY? X/Z? MAP ) UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "mplus@hancockcoingov.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("/"), data);
  }
  
  private static final Pattern MUTAID_PTN = Pattern.compile("(.*)-(.*) CO");
  private class MutualAidAddressField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = MUTAID_PTN.matcher(field);
      if (!match.matches()) return false;
      super.parse(match.group(1).trim(), data);
      data.strCity = match.group(2).trim() + " COUNTY";
      return true;
    }
  }
  
  // Address class, special case if field after address starts with &
  // make it a cross road rather than an place name
  private class MyAddressField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      field = field.replace(".", " ").trim().replaceAll("  +", " ");
      if (!super.checkParse(field, data)) return false;
      if (data.strPlace.startsWith("&")) {
        data.strCross = data.strPlace.substring(2).trim();
        data.strPlace = "";
      }
      return true;
    }
    
    @Override 
    public String getFieldNames() {
      return super.getFieldNames() + " X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MUTADDR")) return new MutualAidAddressField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MapField("\\d\\d(?:00\\d\\d)?", true);
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FORTVILLE",
    "GREENFIELD",
    "MAXWELL",
    "MCCORDSVILLE",
    "NEW PALESTINE",
    "SHIRLEY",
    "SPRING LAKE",
    "WILKINSON",

    "BLUE RIVER TWP",
    "BRANDYWINE TWP",
    "BROWN TWP",
    "BUCK CREEK TWP",
    "CENTER TWP",
    "GREEN TWP",
    "JACKSON TWP",
    "SUGAR CREEK TWP",
    "VERNON TWP"
  };
}
