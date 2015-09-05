package net.anei.cadpage.parsers.TX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;


public class TXHarrisCountyESD1BParser extends FieldProgramParser {

  public TXHarrisCountyESD1BParser() {
    super("HARRIS COUNTY", "TX",
           "( CODE_CALL ADDR1? ADDR UNIT! KM:MAP! Xst's:X " + 
           "| ID/Z ADDRCH! ADDR+? Cross_Streets:X Key_Map:MAP " +
           "| ( ID UNIT2? | UNIT ) CODE CALL! PREALERT? ADDR1? ADDR! Apt:APT! Bldg:PLACE Key_Map:MAP% Cross_Streets:X Box_#:BOX )");
  }
  
  @Override
  public String getFilter() {
    return "cadnoreply@proxy.hcec.com,93001,agaleucia@avfd.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  private static final Pattern REPORT_PTN = Pattern.compile("ID#:([^ ]+) *- *UNIT:([^ ])+ +- *(.*)");
  private static final Pattern TIME_DELIM_PTN = Pattern.compile(" +- *");
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = REPORT_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("ID UNIT INFO");
      data.msgType = MsgType.RUN_REPORT;
      data.strCallId = match.group(1);
      data.strUnit = match.group(2);
      data.strSupp = TIME_DELIM_PTN.matcher(match.group(3)).replaceAll("\n");
      return true;
    }
    return parseFields(splitFields(body), data);
  }
  
  private String[] splitFields(String body) {
    List<String> flds = new ArrayList<String>();
    Matcher match = ID_PTN.matcher(body);
    if (match.lookingAt()) {
      flds.add(match.group(1));
      body = body.substring(match.end());
    }
    flds.addAll(Arrays.asList(body.split("-")));
    return flds.toArray(new String[flds.size()]);
  }
  private static final Pattern ID_PTN = Pattern.compile("(ID#:?\\d\\d-\\d\\d-\\d+) *-");

  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE_CALL")) return new CodeCallField();
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("ADDRCH"))  return new AddressChangeField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("UNIT2")) return new MyUnit2Field();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR1")) return new AddressField("\\d+", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PREALERT")) return new PreAlertField();
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
  
  private static final Pattern CALL_CODE_PTN = Pattern.compile("(\\d{1,2}[a-z]\\d{1,2}[a-z]?) +([^ ].*)");
  private class CodeCallField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = CALL_CODE_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strCode = match.group(1);
      data.strCall = match.group(2);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class MyIdField extends IdField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("ID#")) return false;
      field = stripFieldStart(field.substring(3).trim(),":");
      super.parse(field, data);
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
  
  // Unit field only exists if it is tagged (or contains something that looks like a unit
  private static final Pattern UNIT2_PTN = Pattern.compile("[A-Z]+[0-9]+|\\d{4}|NWREH");
  private class MyUnit2Field extends MyUnitField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("Units:")) {
        field = field.substring(6).trim();
      } else if (!UNIT2_PTN.matcher(field).matches()) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+[0-9]+|\\d{4}|NWREH|");
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (!UNIT_PTN.matcher(field).matches()) abort();
      super.parse(field, data);
    }
  }
  
  // Code field has to fit specific pattern
  private static final Pattern CODE_PTN = Pattern.compile("\\d\\d?[A-Z]\\d\\d[A-Za-z]?|");
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
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = append(data.strAddress, "-", field);
      data.strAddress = "";
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
}
