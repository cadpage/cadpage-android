package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Woodford County, IL
(Woodford Comm) 11-022625 ODOR OF NATURAL GAS\n411 W FRONT ST\nN N PL /  N GREEN ST/\nCASEYS OF ROANOKE  ROANOKE\n1V14 ROFD WF27
[Woodford Comm]  11-015377 FIRE\n1936 1400N\n1900E / 2000E/\nROANOKE\n1V24 ROFD
[Woodford Comm]  11-014297 AMBULANCE CALL\n304 N FRANKLIN ST\nW DAVISON ST / W BRO/AD ST\nROANOKE\n1V24 ROFD
[Woodford Comm]  11-006970 ACCIDENT-WITH INJURY\n1400N/ 1900E\nROANOKE\n1V24 ROFD WF16 WF22 WF4
(Woodford Comm) 10-035758 FIRE ALARM\n1797 1700E\n1700N / 1800N/\nSPAFAS INC  WASHBURN FARM  ROANOKE\n1V23 1V24 MEFD ROFD
[Woodford Comm]  11-000116 ACCIDENT-PROPERTY DAMAGE\n217 W HUSSEMAN ST\nN JEFFERSON ST /  W/RANDOLPH ST\nGEISER FORD  ROANOKE\nROFD WF18
[Woodford Comm]  11-001634 911 LINES DOWN\n115 E COURT ST\nN MAIN ST /  DEAD EN/D EAST\nWOODCOM  EUREKA\nMIFD ROFD SBFD WAFD
[Woodford Comm]  11-005470 ACCIDENT INJURY UNKNOWN\n1386 STATE ROUTE 117\n1300N /  116/\nPARSONS COMPANY  ROANOKE\n1V24 ROFD WF8\n
(Woodford Comm) 12-002663 FIRE\n1248 1700E\n1200N / 1300N/\nROANOKE\n1V24 ROFD

Halifax County, VA
[from Central]  11-023176 FALLEN PATIENT\n2210 N TERRYS BRIDGE RD\nJAMES D HAGOOD HWY //SUNSET LN\nHALIFAX
[from Central]  11-023175 FALLEN PATIENT\n1167 LEWIS FERRELL RD\nOAK LEVEL RD / LITTL/E CIR\nSOUTH BOSTON
[from Central]  11-023166 EMERGENCY MEDICAL SERVICE\n111-22 ROSEHILL DR\nPOWELL RD / DEAD END/EN\nROSE HILL APARTMENTS  SOUTH BOSTON
[from Central]  11-023086 UNRESPONSIVE PATIENT\n1110 ASBURY CHURCH RD\nCHATHAM RD / PAUL PR/Y TRL\nYOUNGERS HOME FOR ADULTS  HALIFAX
[from Central]  11-023050 FALLEN PATIENT\n3471 OLD HALIFAX RD\nHIGH SCHOOL CIR /  C/ENTERVILLE PARK RD\nWAL-MART  SOUTH BOSTON
[from Central]  11-023040 EMERGENCY MEDICAL SERVICE\n2082 BURTON RD\nWAGSTAFF LN / CLAYS/MILL RD\nSCOTTSBURG
[from Central]  11-023038 FALLEN PATIENT\n103 WHITE OAK DR\nSYCAMORE RD / SYCAMO/RE RD\nSOUTH BOSTON
[from Central]  11-017088 SHORTNESS OF BREATH, ETC.\n1110 HENRYS TRL\nAMBERSTONE DR / DEAD/END\nNATHALIE
(from Central) 11-022783 ACCIDENT INVOLVING PEDESTRIAN\n104-20 LOVE SHOP PARK RD\nOLD HALIFAX RD / DEA/D END\nLOVE SHOP TRAILER PARK  SOUTH BOSTON
(from Central) 12-024703 EMERGENCY MEDICAL SERVICE\r\n\r\nReported: 06/22/2012 03:50:22\r\n\r\n510 GREENWAY DR\r\n\r\nWILBORN AVE / NORWOO/D AVE\r\n\r\nSOUTH BOSTON
(from Central) 12-024641 RESIDENTIAL\r\n\r\nReported: 06/21/2012 18:23:30\r\n\r\n2123 HORSESHOE TRL\r\n\r\nHUELL MATTHEWS HWY //DEAD END\r\n\r\nALTON
(from Central) 12-024654 GENERAL COMPLAINT - SICK\r\n\r\nReported: 06/21/2012 20:13:43\r\n\r\n1419 WASHINGTON AVE\r\n\r\nEDMUNDS ST / WEBSTER/ST\r\n\r\nSOUTH BOSTON


Winchester, VA
(Winchester ECC info) 11-041989 INSIDE SMELL OR SMOKE\n336 GRAY AVE\nNATIONAL AVE / VIRGI/NIA AVE\nWINCHESTER\nBAT6 E4 E5 EC18 M41 TK2 W1 E
(Winchester ECC info) 11-042157 INSIDE FIRE STRUCT/ELEC/CHIMN\n122-1 E PALL MALL ST\nS CAMERON ST / S KEN/T ST\nWINCHESTER\nBAT6 E1 E4 E5 EC21 M51 TK2
(Winchester ECC info) 11-042110 FIRE ALARM\n1890 AMHERST ST\nWESTSIDE STATION DR// CITY LIMITS\nADULT PSYCH CENTER  WINCHESTER\nE1 E4 EC15 TK2
(Winchester ECC info) 11-042059 OUTSIDE FIRES WITH NO EXPOSURE\n1029 ALLEN DR\nMOLDEN DR / KINZEL D/R\nTINAS QUALITY CLEANING  WINCHESTER\nE1

*/

public class DispatchShieldwareParser extends FieldProgramParser {
  
  public static final int FLG_NO_UNIT = 1;
  
  private static final Pattern CALL_PTN = Pattern.compile("^(\\d\\d-\\d{6}) +");
  
  protected DispatchShieldwareParser(String defCity, String defState) {
    this(defCity, defState, 0);
  }
  
  protected DispatchShieldwareParser(String defCity, String defState, int flags) {
    super(defCity, defState,
           (flags & FLG_NO_UNIT) == 0 ? "CALL DATETIME? ADDR X/Z? PLCITY! UNIT END"
                                      : "CALL DATETIME? ADDR X/Z? PLCITY! END");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = CALL_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    return parseFields(body.split("\n+"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("Reported: ")) return false;
      return super.checkParse(field.substring(10).trim(), data);
    }
  }
  
  private class PlaceCityField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.getLast("  ");
      data.strPlace = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("PLCITY")) return new PlaceCityField();
    return super.getField(name);
    
  }
}
