package net.anei.cadpage.parsers.TN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/* 
Johnson City, TN (Washington County)
Contact: nathan carrier <ncarrier454@gmail.com>
Contact: david harrison <firemist317@gmail.com>
Sender: JCFDTEXT@johnsoncitytn.org
prvs=182efbc0f=JCFDTEXT@johnsoncitytn.org House/Residential Fire E7,E4,L44,E3,MP29\nALLISON LN/HELEN CT\nALLISON PLACE SD\nMap 53C 16:50:40 115143\nThink green: Only print this e-mail
prvs=1838ca3f5=JCFDTEXT@johnsoncitytn.org GRASS/BRUSH FIRE E4\n208 GARDEN DR\nGRACE TEMPLE CHURCH\nMap 46C 19:57:36 115181
prvs=184df15ee=JCFDTEXT@johnsoncitytn.org School Fire Alarm\nE4,L44,E3,MP29,E5\n1509 JOHN EXUM PKWY\nSCIENCE HILL HIGH SCHOOL\nMap 46A 02:23:08 115185
prvs=184df15ee=JCFDTEXT@johnsoncitytn.org Diabetic Problems-CHARLIE M13,E3\n212 W POPLAR ST #APT1\nMap 54B 00:12:17 11111569
prvs=184df15ee=JCFDTEXT@johnsoncitytn.org Unconscious/Fainting-DELTA M7,E5\n1811 W LAKEVIEW DR #B9\nSUMMERCHASE APARTMENTS\nMap 38B 23:05:56 11111542
prvs=1838ca3f5=JCFDTEXT@johnsoncitytn.org GRASS/BRUSH FIRE E4\n208 GARDEN DR\nGRACE TEMPLE CHURCH\nMap 46C 19:57:36 115181
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Heart Problems/AICD-DELTA R2,E4\n1806 LAMONS LN #101\nHARRISON VILLAGE APARTMENTS\nMap 54A 12:39:23 11113129
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Nursing Home Fire Alarm\nE5,L45,E9,E6,MP29,L44\n406 E MOUNTAINVIEW RD\nBROADMORE FACILITY\nMap 29C 14:01:23 115275
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Motor Vehicle Crash - Injury\nE2,E3,MP29\nI26W/OKOLONA EXIT\nMap 63C 14:16:38 115276
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Unconscious/Fainting-DELTA\nM2,E7,R2\n2215 N GREENWOOD DR\nMap 54D 14:20:38 11113195
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Stroke(CVA)-CHARLIE M6,E6,R3\n3711 N ROAN ST #E28\nNORTHPLACE APARTMENTS\nMap 29C 16:31:15 11113269
prvs=1887ea331=JCFDTEXT@johnsoncitytn.org Sick Person-CHARLIE M2,R2,E4\n1208 BAIR VETTE AV\nMap 45C 53B 21:42:56 11113379
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Chest Pain(Non-Traumatic)-DELTA\nM2,R2,E4\n1518 SYLVAN DR\nMap 45C 19:51:57 11113336
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Falls-ALPHA E2\n2802 PLYMOUTH RD\nRAINBOW HOMES\nMap 55D 19:20:41 11113321
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Heart Problems/AICD-DELTA M6,E9,R3\n409 SCENIC OAK DR\nMap 21D 19:07:03 11113313
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Convulsions/Seizures-DELTA\nM2,R2,E4\n301 ROYAL CR #79\nCLARK MANOR APARTMENTS\nMap 54A 17:30:11 11113287\nThink green: Only print this e-mail
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Convulsions/Seizures-CHARLIE\nM1,E2,R1\nS ROAN ST/UNIVERSITY PKWY\nMap 54B 15:06:18 11113223
prvs=187913dbd=JCFDTEXT@johnsoncitytn.org Motor Vehicle Crash - Injury\nE2,E3,MP29\nI26W/OKOLONA EXIT\nMap 63C 14:16:38 115276

Contact: Jason Powell <firedupleadership@gmail.com>
Sender: CAD@wc911.org
Breathing Problems-DELTA M1,E3 \n300 W WALNUT ST #2 \nSHAMROCK \nMap 54b 14:59:59 11111863 \nThink green: Only print this e-mail and any attachment 
Breathing Problems-CHARLIE M1,E1,R1 \n1 UNAKA CT #7 \nMap 39D 21:23:05 11112056 \nThink green: Only print this e-mail and any attachment if necessar 
House/Residential Fire Alarm E2 \n2701 S ROAN ST #124 \nHERITAGE TRAILER PARK \nMap 55D 22:50:03 115214 \nThink green: Only print this e-mail and an
Assault/Sexual Assault-BRAVO M3,R3,E9 \n2918 BRISTOL HY \nADVANCE AUTO PARTS \nMap 38A 19:53:06 11113913 \nThink green: Only print this e-mail and a

*/

public class TNWashingtonCountyParser extends FieldProgramParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\b[A-Z]{1,2}\\d{1,2}(?:,[A-Z]{1,2}\\d{1,2})*$");
  private static final Pattern PRI_PTN = Pattern.compile("-(?:ALPHA|BRAVO|CHARLIE|DELTA)$");
  private static final Pattern MAP_TRAIL_PTN = Pattern.compile(" \\d\\d:\\d\\d:\\d\\d (\\d{6,})$");
  
  public TNWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "TN",
           "CPU UNIT2? ADDR PLACE? MAP!");
  }
  
  @Override
  public String getFilter() {
    return "JCFDTEXT@johnsoncitytn.org,CAD@wc911.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  // CPU - Combined Call / Priority / Unit field
  private class CallPriUnitField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = UNIT_PTN.matcher(field);
      if (match.find()) {
        data.strUnit = match.group();
        field = field.substring(0,match.start()).trim();
      }
      match = PRI_PTN.matcher(field);
      if (match.find()) {
        data.strPriority = (match.group().substring(1,2));
        field = field.substring(0,match.start()).trim();
      }
      data.strCall = field;
    }
    
    @Override
    public String getFieldNames() {
      return "CALL PRI UNIT";
    }
  }
  
  // UNIT2 Lists units if there wern'e included in the CPU field
  private class Unit2Field extends UnitField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strUnit.length() > 0) return false;
      Matcher match = UNIT_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strUnit = field;
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT ID";
    }
  }
  
  // MAP field has to start with map, and drop trailing
  private class MyMapField extends MapField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("Map ")) return false;
      parse(field, data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_TRAIL_PTN.matcher(field);
      if (!match.find()) abort();
      data.strMap = field.substring(3,match.start()).trim();
      data.strCallId = match.group(1);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CPU")) return new CallPriUnitField();
    if (name.equals("UNIT2")) return new Unit2Field();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
