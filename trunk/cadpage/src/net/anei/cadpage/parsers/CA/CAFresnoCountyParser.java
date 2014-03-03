package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Fresno County, CA
 */
public class CAFresnoCountyParser extends FieldProgramParser {
  
  public CAFresnoCountyParser() {
    super("FRESNO COUNTY", "CA",
           "CALL! For:UNIT! Zone:ADDR! Apt:APT! Between:X! Location_Name:PLACE!");
  }
  
  @Override
  public String getFilter() {
    return "VCMail@co.fresno.ca.us";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("VisiCad Email")) return false;
    body = body.replace("Location Name:", " Location Name:");
    if (super.parseMsg(body, data)) return true;
    
    data.parseGeneralAlert(this, body);
    return true;
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("*")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern ADDR_MAP_PTN = Pattern.compile("^(?:(\\d{5})|NOT FOUND) +");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_MAP_PTN.matcher(field);
      if (!match.find()) abort();
      data.strMap = getOptGroup(match.group(1));
      field = field.substring(match.end());
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "MAP " + super.getFieldNames();
    }
  }

  private static final Pattern APT_PREFIX_PTN = Pattern.compile("^(?:#|APT|ROOM|RM|STE) *", Pattern.CASE_INSENSITIVE);
  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_PREFIX_PTN.matcher(field);
      if (match.find()) field = field.substring(match.end());
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
}
