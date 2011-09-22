package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Winchester, VA
Contact: Chris & Scott Kensinger <kensingerllc@gmail.com>
Sender: winecc@ci.winchester.va.us

(Winchester ECC info) 11-041989 INSIDE SMELL OR SMOKE\n336 GRAY AVE\nNATIONAL AVE / VIRGI/NIA AVE\nWINCHESTER\nBAT6 E4 E5 EC18 M41 TK2 W1 E
(Winchester ECC info) 11-042157 INSIDE FIRE STRUCT/ELEC/CHIMN\n122-1 E PALL MALL ST\nS CAMERON ST / S KEN/T ST\nWINCHESTER\nBAT6 E1 E4 E5 EC21 M51 TK2
(Winchester ECC info) 11-042110 FIRE ALARM\n1890 AMHERST ST\nWESTSIDE STATION DR// CITY LIMITS\nADULT PSYCH CENTER  WINCHESTER\nE1 E4 EC15 TK2
(Winchester ECC info) 11-042059 OUTSIDE FIRES WITH NO EXPOSURE\n1029 ALLEN DR\nMOLDEN DR / KINZEL D/R\nTINAS QUALITY CLEANING  WINCHESTER\nE1

 */


public class VAWinchesterParser extends FieldProgramParser {
    
  
  public VAWinchesterParser() {
    super("WINCHESTER", "VA",
           "IDCALL ADDR X PLCITY UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "winecc@ci.winchester.va.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("Winchester ECC info")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private static final Pattern ID_CALL_PTN = Pattern.compile("(\\d\\d-\\d{6}) +(.*)");
  private class IdCallField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCall = match.group(1);
      data.strCall = match.group(2);
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL";
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
    if (name.equals("IDCALL")) return new IdCallField();
    if (name.equals("PLCITY")) return new PlaceCityField();
    return super.getField(name);
  }
}
