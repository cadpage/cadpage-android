package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA11Parser extends FieldProgramParser {
  
  private Properties cityCodes;
  
  public DispatchA11Parser(String defCity, String defState) {
    this(null, defCity, defState);
  }
  
  public DispatchA11Parser(Properties cityCodes, String defCity, String defState) {
    super(defCity, defState,
          "SRC CALL PAGED ADDR UNIT UNIT INFO+");
    this.cityCodes = cityCodes;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), 6, data);
  }
  
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|RM|ROOM)(.*)");
  private class BaseAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      if (cityCodes != null) data.strCity = convertCodes(p.getLastOptional(','), cityCodes);
      String fld = p.getLastOptional(';');
      Matcher match = APT_PTN.matcher(fld);
      if (match.matches()) {
        data.strApt = match.group(1).trim();
      } else {
        data.strPlace = fld;
      }
      super.parse(p.get(), data);
    }
    
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE CITY";
    }
  }
  
  private class BaseUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[-A-Z0-9]+", true);
    if (name.equals("PAGED")) return new SkipField("PAGED", true);
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("UNIT")) return new BaseUnitField();
    return super.getField(name);
  }
  
  
}
