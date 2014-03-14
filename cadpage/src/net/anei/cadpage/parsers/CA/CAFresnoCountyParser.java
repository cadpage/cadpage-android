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
          "( Unit:UNIT! Pri:PRI! Loc:ADDR! MapPage:MAP! Apt:APT! City:CITY! Zone:MAP! EMS#:ID! XStreet:X! " +
           "| CALL! For:UNIT! Zone:MAP_ADDR! Apt:APT! City:CITY? Between:X! Location_Name:PLACE! )");
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
    if (body.startsWith("Unit:")) {
      if (parseFields(body.split(","), 9, data)) return true;
    }
    
    else {
      body = body.replace(" Dist:",  " Zone:").replace("Location Name:", " Location Name:");
      if (super.parseMsg(body, data)) return true;
    }
    
    data.parseGeneralAlert(this, body);
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("MAP_ADDR")) return new MyMapAddressField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "*");
      super.parse(field, data);
    }
  }
  
  private static final Pattern ADDR_MAP_PTN = Pattern.compile("^(?:(\\d{5})|NOT FOUND) +");
  private class MyMapAddressField extends AddressField {
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
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
}
