package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TXHarrisCountyESD1BParser extends FieldProgramParser {
  
  private static final Pattern REPORT_PTN = Pattern.compile("^ID#:[^ ]+ *- *UNIT:[^ ]+ .*- *DISP:");
  private static final Pattern DELIM = Pattern.compile("(?<=^|[^\\d])-|-(?=[^\\d])");

  public TXHarrisCountyESD1BParser() {
    super("HARRIS COUNTY", "TX",
           "( ID/Z ADDRCH! Cross_Streets:X Key_Map:MAP " +
           "| ( ID UNIT2? | UNIT ) CODE CALL! PREALERT? ADDR! Apt:APT! Bldg:PLACE Key_Map:MAP% Cross_Streets:X Box_#:BOX )");
  }
  
  @Override
  public String getFilter() {
    return "cadnoreply@proxy.hcec.com,93001";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (REPORT_PTN.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE";
  }
  
  private class MyIdField extends IdField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("ID#:")) return false;
      super.parse(field.substring(4).trim(), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  // Address change field 
  private class AddressChangeField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("Address changed to:")) return false;
      data.strCall = "Address changed to:";
      field = field.substring(19).trim();
      super.parse(field, data);
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return "CALL " + super.getFieldNames();
    }
  }
  
  // Unit field only exists if it is tagged
  private class MyUnit2Field extends MyUnitField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("Units:")) return false;
      super.parse(field.substring(6).trim(), data);
      return true;
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+[0-9]+|");
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (!UNIT_PTN.matcher(field).matches()) abort();
      super.parse(field, data);
    }
  }
  
  // Code field has to fit specific pattern
  private static final Pattern CODE_PTN = Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Za-z]?|");
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(CODE_PTN, true);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) {
        String code = field.substring(0,pt);
        if (CODE_PTN.matcher(code).matches()) {
          if (data.strCode.length() == 0) data.strCode = code;
          field = field.substring(pt+1).trim();
        }
      }
      super.parse(field, data);
    }
  }
  
  // PreAlert is a special call extender field
  private class PreAlertField extends CallField {
    
    public PreAlertField() {
      setPattern(Pattern.compile("PreAlert"));
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  // There are two fields, APT and BLD mapped to the apartment field.  But they
  // occur in reverse order, if both are specified, we want to to put bldg first.
  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      data.strApt = append(field, "-", data.strApt);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("ADDRCH"))  return new AddressChangeField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("UNIT2")) return new MyUnit2Field();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PREALERT")) return new PreAlertField();
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
  
}
