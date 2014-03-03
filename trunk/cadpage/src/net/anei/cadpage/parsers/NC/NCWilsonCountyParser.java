package net.anei.cadpage.parsers.NC;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
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
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("Sanoca")) {
      if (body.startsWith(";")) body = "CAD:" + body.substring(1).trim();
    }
    return super.parseMsg(body,  data);
  }
  
  // ID field has to validate it's existence
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{6,}"));
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (US_264_DIR.matcher(field).matches()) {
        parse(field, data);
        return true;
      }
      return super.checkParse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("CODE")) return new CodeField("\\d\\d[A-Za-z]\\d\\d[A-Za-z]?");
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  
  @Override
  public String adjustMapAddress(String address) {
    Matcher match = US_264_DIR.matcher(address);
    if (match.find()) {
      StringBuffer bf = new StringBuffer();
      do {
        match.appendReplacement(bf, "US 264");
        if (match.group(1) != null) bf.append(" ALT");
      } while (match.find());
      address = bf.toString();
    }
    return address;
  }
  private static final Pattern US_264_DIR = Pattern.compile("\\bUS +264(A?)(?: +[NESW])?\\b", Pattern.CASE_INSENSITIVE);
}