package net.anei.cadpage.parsers;

public class Cadpage3Parser extends Cadpage2Parser {
  
  public Cadpage3Parser() {
   this("", "");
  }

  public Cadpage3Parser(String defCity, String defState) {
    super(";", defCity, defState);
  }
  
  @Override
  public String getLocName() {
    return "Standard Cadpage Format C";
  }
}
