package net.anei.cadpage.parsers;

public class Active911Parser extends Cadpage2Parser {
  
  public Active911Parser() {
   this("", "");
  }

  public Active911Parser(String defCity, String defState) {
    super("\n", defCity, defState, true);
  }
  
  @Override
  public String getLocName() {
    return "Active911 format";
  }
}
