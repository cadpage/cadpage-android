package net.anei.cadpage.parsers.NC;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCJohnstonCountyParser extends DispatchOSSIParser {
  
  public NCJohnstonCountyParser() {
    super("JOHNSTON COUNTY", "NC",
           "( INFO SRC CODE? | ) CALL ADDR! X? X? X2? NAME DATETIME");
  }

  @Override
  public String getFilter() {
    return "CAD@johnstonnc.com,93001";
  }

  // Source code validates that is is not more than 5 characters long
  private class MySourceField extends SourceField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() > 5) return false;
      parse(field, data);
      return true;
    }
  }
  
  // Code field must match particular pattern
  private static final Pattern CODE_PATTERN = Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Z]?");
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(CODE_PATTERN);
    }
  }
  
  // Cross street won't pass normal address validation
  // We will take anything that doesn't look like a name with a comma
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.contains(",")) return false;
      parse(field, data);
      return true;
    }
  }
  
  // Cross street won't pass normal address validation
  // We will take anything that doesn't look like a name with a comma
  private class MyCross2Field extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.contains(",")) return false;
      return super.checkParse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("X2")) return new MyCross2Field();
    return super.getField(name);
  }
}