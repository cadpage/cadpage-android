package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Prince Georges County, MD (Variant B)
This is believed to have been superseded by Variant C
We keep it around in case we turn out to be wrong about that
And to give any history calls referring to this parser a place to link to

Contact: James Busi <jb10766@gmail.com>
Contact: "nhedrick36@aol.com" <nhedrick36@aol.com>
Contact:kevin <kgilmore82@gmail.com>
Sender: @alert.princegeorgescountymd.gov

DISPATCH From FED01:ALS1, Medic Local, 4500 LORDS LANDING RD #205, PP, btwn BISHOPS BEQUEST RD and CAPTAIN
DISPATCH From FED10:ALS1, Medic Local, 6802 BURCH HILL RD, PP, btwn BRANDYWINE RD and COLLIN HILL WAY, TGC2
DISPATCH From FED10:BLS0, BLS Amb, 12003 WALLACE LN, PP, btwn DULEY STATION RD and WALLACE LANDING CT, TGC 2, 4504, 5884 C 1, Medical ProQA recommends dispatch at this time, Unit:A820
DISPATCH From FED10:BLS0, BLS Amb, 12003 WALLACE LN, PP, btwn DULEY STATION RD and WALLACE LANDING CT, TGC 2, 4504, 5884 C 1, Medical ProQA recommends dispatch at this time, Unit:A820
DISPATCH From FED10:HOUSEF, House Fire, 10511 MULLIKIN DR, PP, btwn PARKVIEW LN and GATOR PL, TGC3, 2514, 5882 G 1, Fire ProQA recommends dispatch at this time, Units:BO887, E823, E825, E847, RE840, SQ827, TK832, TK837
DISPATCH From FED01:ALS1, Medic Local, 4905 ASHFORD PL, PP, btwn CRANFORD DR and ASHFORD DR, TGA2, 2017, 5 651 K 9, Medical ProQA recommends dispatch at this time, Units:A820, MD845
DISPATCH From FED01:BLS, BLS Amb, 14741 GOVERNOR ODEN BOWIE DR, PP, btwn ELM ST and MAIN ST, TGA2, 2009, 5652 K 10, PER ID 1879 FB NEEDED TO RESPOND TO 5TH FL FOR SEMI CONCIOUS SICK CITZ..NFI @ THIS TIME, Units:A843, E820

BC 887 STREET, Street Alarm, 11113 BIRCH WAY, PP, btwn ELM WAY and PENNY AVE, TGC3, 2515, 5882 G 2, Fire ProQA recommends dispatch at this time, Units:BO887, E825, RE840, SQ827, TK832
E820 ALS, Medic Local, 15903 BISHOPSTONE TER, PP, btwn GALESHEAD DR and END, TGA2, 2001, 5653 D 5, Police ProQA recommends dispatch at this time, Units:A843, E820, NMR
A820 ALS1, Medic Local, 9805 BROADMOOR TER, PP, btwn BROADMOOR LN and BROADMOOR CT, TGC2, 4505, 5768 C 10, Medical ProQA recommends dispatch at this time, Units:A820, MD845
A820 BLS, BLS Amb, 20 DIANE DR, TGA2, MAAA, ANNE ARUNDEL BOX 0904 A820 FOR SICK PERSON ON BRAVO W/ MEDIC 9, Unit:A820
A820 BLS1, BLS Amb, 5302 WATER ST, PP, btwn MAIN ST and CHURCH ST, TGA2, 2009, 5652 K 10, Police ProQA recommends dispatch at this time, Unit:A820
E845 HOUSEG, House Gas Leak, 6512 HALLAM DR, PP, btwn HALLAM CT and MEADOW LARK AVE, TGC2, 2308, 5767 F 2, Fire ProQA recommends dispatch at this time, Units:BO883, E823, E845, SQ827, TK825
A843 ALS1, Medic Local, 4321 COLLINGTON RD #3, PP, btwn EVERGREEN PKY and TOWN CENTER BLVD, TGA2, 1608, 54  2/2 / 13 C 9, 3RD FLOOR, Units:A843, E816, NMR
A820 ALS1, Medic Local, 15201 JOPPA PL, PP, btwn JENNINGS MILL DR and END, TGA2, 4313, 5533 B 6, Medical ProQA recommends dispatch at this time, Units:A820, E843, MD818 Eff Body:roQA recommends dispatch at this time, Units:A820, E843, MD818
BC 887 MOTOR, Motorcycle Accident, NB CAP BELT OL A HWY/NB BRANCH AVE, PP, at NB CAP BELT OL A HWY/NB BRANCH AVE, PP <0/0>, TGC2, 2941, 5650 C 9, MOTORCYLCE SLAMMED INTO THE BACK OF A CAR, Unit:BO887
E845 PIAH, PIA Limited Access, SB CRAIN HWY SW/FRANK TIPPETT RD, PP,  <11400/ 11200>, TGC2, 4015, 5883 H 3, TWO VEHICLE ACCIDENT INVOLVING A WHITE FORD F150 AND A WHITE VAN....POSSIBLE INJURIES....TRANSFERRED CALLER TO MSP, Units:E845, MD845, RE840
E845 PIAH, PIA Limited Access, NB CRAIN HWY SE/TRUMPS HILL RD, PP,  <9200/ 9200>, TGC2, 4505, 5768 B 8, VEH INTO THE WOODS JUST PAST THE CROOM RD..S/B..NO 1034 ON VEH..ADV THERE ARE PEOPLE STANDING OUT SIDE OF TH

Contact: John Hoffman <ejhoffmanjr@gmail.com>
Sender: cad3815@alert.princegeorgescountymd.gov
SQ814 APTF, Apartment Fire, 1404 KANAWHA ST #302, PP, btwn 14TH AVE and 15TH AVE, TGA2, 3413, 5409 C 2, Fire ProQA recommends dispatch at this time, Units:BO884, E702, E712, E834, PE844, SQ814, TK801, TK812
SQ814 BUILDG, Building Gas Leak, 13922 BALTIMORE AVE, LP, btwn LAUREL LAKES CT and CYPRESS ST, TGA9, 1007, 5169 B 7, Fire ProQA recommends dispatch at this time, Units:BO886, E810, RE849, SQ814, TK831
SQ814 HOUSEF, House Fire, 3400 PENNSYLVANIA ST, PP, btwn WELLS BLVD and ADELPHI RD, TGA2, 0117, 5409 G 4, Fire ProQA recommends dispatch at this time, Units:BO884, E807, E811, E834, PE844, SQ814, TK801, TK812

Contact: "Radinsky, Brian S." <bsradinsky@co.pg.md.us>
Sender: cad@alert.princegeorgescountymd.gov
Ambulance 820 ALS1, Medic Local, 17102 USHER PL, PP, btwn GOHAGEN RD and TERRYTOWN CT, TGC7, 2002, 5653 G 8, Medical ProQA recommends dispatch at this time, Units:A820, E820, NMR
Medic 829 ALS1, Medic Local, 2411 KIRTLAND AVE, PP, btwn MARBURY DR and MASON ST, TGC7, 2622, 5650 K 3, Medical ProQA recommends dispatch at this time, Units:A826, MD829
Ambulance 812 PIAH, PIA Limited Access, SB CAP BELT IL A HWY/SB BALTIMORE AVE, PP, at SB CAP BELT IL A HWY/SB BALTIMORE AVE, PP <0/0>, TGA2, 4113, 5288 B 8, 3 VEHICLES ACCIDENT, UNK INJ...MSP CP ADV, Units:A812, E831
Battalion Chief 886 HOUSEF, House Fire, 5031 HURON ST, PP, btwn 50TH PL and 51ST AVE, TA11, 1112, 5288 C 9, HOUSE ON FIRE, CAN SEE THE SMOKE COMING FROM THE HOME - COMPL LEFT THE PHONE BUT STILL HAVE AN O/L, Units:BO886, E811, E813, E831, E835, SQ814, TK812, TW807
Ambulance 827 RAP, Rape, 4220 APPLE ORCHARD LN, PP, btwn APPLEGATE LN and APPLE ORCHARD CT, TGC2, 2917, 5650 A 8, Police ProQA recommends dispatch at this time, Units:A827, TK829
Paramedic Ambulance 838 ALS1, Medic Local, 1114 HILL RD, PP, btwn LOWLAND DR and HIGHLAND PARK DR, TGA2, 3812, 5530 H 6, Medical ProQA recommends dispatch at this time, Units:PA838, QT838
Engine 820 ASPD, Assist Police, 4709 COLONEL ASHTON PL, PP, btwn END and COLONELS CHOICE RD, TG1, 2015, 5652 J 9, Police ProQA recommends dispatch at this time, Unit:E820
Ambulance 836 BLS0, BLS Amb, 15407 GIDEON GILPIN ST, PP, btwn COMMANDER HOWE TER and CAPTAIN ANDRE CT, TGC2, 4001, 5998 J 2, Medical ProQA recommends dispatch at this time, Unit:A836

Contact: Christopher Olson <lilsmokeeater5@yahoo.com>
Engine 848 BUILDF, Building Fire, 7474 GREENWAY CENTER DR, GP, btwn MD TRADE CTR RD and MD TRADE CTR RD, TGA2, 3506, 5410 J 2, Fire ProQA recommends dispatch at this time, Units:BO886, E811, E812, E835, E848, RE818, TK812, TK814
Tower 807 HOUSEF, House Fire, 1834 VILLAGE GREEN DR, PP, btwn SHERIFF RD and BARLOWE RD, TGA2, 3324, 5530 K 4, Fire ProQA recommends dispatch at this time, Units:BO881, E808, E833, E838, PE830, TK828, TK855, TW807
Mini Pumper 828 BLS, BLS Amb, 9350-A WASHINGTON BLVD, PP, btwn CRESTVIEW DR and CARTER AVE, TGA2, 4802, 5411 E 6, INJ HER LEFT ANKLE // WOULD LIKE IT CHECKED OUT, Unit:MP828

*/

public class MDPrinceGeorgesCountyBParser extends FieldProgramParser {
  
  public MDPrinceGeorgesCountyBParser() {
    super("PRINCE GEORGES COUNTY", "MD",
           "INIT CALL ADDR/S! PP? X? SKIP+? CH ( MA | SKIP MAP ) INFO+ Units:UNIT+");
  }
  
  @Override
  public String getFilter() {
    return "@alert.princegeorgescountymd.gov";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace(" Unit:", "Units:");
    return parseFields(body.split(","), data);
  }
  
  // The initial field is the tricky one.  There are several different
  // starting signatures which all have to be identified.  If the first
  // field doesn't match any of them, abort the transaction
  private static final Pattern[] MATCH_LIST = new Pattern[]{
    Pattern.compile("DISPATCH From (FED\\d+):([A-Z0-9]+)"),
    Pattern.compile("([A-Z]+ ?\\d{3}) ([A-Z0-9]+)"),
    Pattern.compile("(SQ\\d+) ([A-Z]+)"),
    Pattern.compile("([\\w ]+ \\d{3}) ([A-Z0-9]+)")
  };
  private class InitField extends Field {

    @Override
    public void parse(String field, Data data) {
      boolean found = false;
      for (Pattern ptn : MATCH_LIST) {
        Matcher match = ptn.matcher(field);
        if (match.matches()) {
          data.strSource = match.group(1);
          data.strCall = match.group(2);
          found = true;
          break;
        }
      }
      if (!found) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "SRC CALL"; 
    }
  }
  
  // Call field is standard except for shorted compound connector
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "-", field);
    }
  }
  
  //  The PP field isn't parsed, but it must match PP or LP
  private class PPField extends SkipField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return field.equals("PP") || field.equals("LP");
    }
  }
  
  // Cross field only exist if it has the correct keyword
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("btwn ")) {
        field = field.substring(5).trim();
      } else if (field.startsWith("at ")) {
        field = field.substring(3).trim();
      } else {
        return false;
      }
      
      parse(field.trim(), data);
      return true;
    }
  }
  
  // Radio channel must start with TG
  private class MyChannelField extends ChannelField {
    MyChannelField() {
      setPattern(Pattern.compile("T[AG].+"));
    }
  }
  
  // Mutual Aid tag field
  private class MutualAidField extends CityField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("MA")) return false;
      if (field.equals("MAAA")) {
        data.strCity = "ANNE ARUNDEL COUNTY";
      } else if (field.equals("MACC")) {
        data.strCity = "CHARLES COUNTY";
      } else if (field.equals("MAMC")) {
        data.strCity = "MONTGOMERY COUNTY";
      }
      return true;
    }
  }
  
  // Info field needs to skip junk
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.contains("ProQA recommends dispatch at this time")) return;
      super.parse(field, data);
    }
  }
  
  // Unit fields join together with comma separators
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, ", ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INIT")) return new InitField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PP")) return new PPField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("CH")) return new MyChannelField();
    if (name.equals("MA")) return new MutualAidField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
}
