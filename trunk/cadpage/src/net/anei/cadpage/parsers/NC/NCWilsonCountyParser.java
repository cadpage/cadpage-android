package net.anei.cadpage.parsers.NC;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCWilsonCountyParser extends DispatchOSSIParser {
  
  public NCWilsonCountyParser() {
    super("WILSON COUNTY", "NC",
           "ID? CODE? CALL ADDR! SRC X+? INFO+");
  }

  @Override
  public String getFilter() {
    return "CAD@Wilson-co.com,930010";
  }
  
  // ID field has to validate it's existence
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{6,}"));
    }
  }
  
  // CODE field also has to validate its existence
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Z]?"));
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("CODE")) return new MyCodeField();
    return super.getField(name);
  }
  
}