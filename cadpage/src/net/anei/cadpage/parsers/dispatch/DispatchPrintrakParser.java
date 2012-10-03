package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchPrintrakParser extends FieldProgramParser {
  
  /**
   * Flag indicating we should use the CMT1 field to replace the normal call field
   */
  public static final int FLG_USE_CMT1_CALL = 0x1;
  
  public DispatchPrintrakParser(String defCity, String defState) {
    this(null, defCity, defState, null);
  }
  
  public DispatchPrintrakParser(String defCity, String defState, String expTerm) {
    this(null, defCity, defState, expTerm);
  }
  
  public DispatchPrintrakParser(Properties cityCodes, String defCity, String defState) {
    this(cityCodes, defCity, defState, null);
  }
  
  public DispatchPrintrakParser(Properties cityCodes, String defCity, String defState, String expTerm) {
    this(cityCodes, defCity, defState, expTerm, 0);
  }
  
  public DispatchPrintrakParser(Properties cityCodes, String defCity, String defState, String expTerm, int flags) {
    super(cityCodes, defCity, defState,
          setExpectFlag("SRC PRI:PRI INC:ID TYP:CALL! BLD:APT APT:APT AD:ADDR! CTY:CITY MAP:MAP LOC:PLACE CN:NAME CMT1:" + 
                        ((flags & FLG_USE_CMT1_CALL) != 0 ? "CALL2" : "INFO") + 
                        " CMT2:INFO TIME:TIME UNTS:UNIT XST:X XST2:X UNTS:UNIT", expTerm));
  }
  
  private class BaseAptField extends AptField {
    
    @Override
    public void parse(String field, Data data) {
      data.strApt = append(data.strApt, "-", field);
    }
  }
  
  private class BasePlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("CALLBK=")) {
        data.strPhone = field.substring(7).trim();
      } else {
        data.strPlace = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE PHONE";
    }
  }
  
  private class BaseTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) {
        data.strUnit = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override 
    public String getFieldNames() {
      return "TIME UNIT";
    }
  }
  
  private class BaseCall2Field extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("**")) field = field.substring(2).trim();
      data.strCall = field;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new BaseAptField();
    if (name.equals("PLACE")) return new BasePlaceField();
    if (name.equals("TIME")) return new BaseTimeField();
    if (name.equals("CALL2")) return new BaseCall2Field();
    return super.getField(name);
  }
}
