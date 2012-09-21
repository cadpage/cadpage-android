package net.anei.cadpage.parsers.AL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Shelby County, AL
 */
public class ALShelbyCountyParser extends FieldProgramParser {
  
  
  public ALShelbyCountyParser() {
    super("SHELBY COUNTY", "AL",
           "DATETIME ID SRC CALL PLACE ADDR! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "arns@shelby911.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("SHELBY911 ARNS ALERT")) return false;
    return parseFields(body.split("\n"), 6, data);
  }
  
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strDate = field.substring(0,pt);
      setTime(TIME_FMT, field.substring(pt+1), data);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strCross = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(": @")) {
        field = field.substring(3).trim();
        if (! field.equals(data.strPlace)) data.strPlace = append(data.strPlace, " - ", field);
      }
      
      else if (field.startsWith(":")) {
        data.strApt = append(data.strApt, " - ", field.substring(1).trim());
      }
      else super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE APT INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
