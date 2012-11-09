package net.anei.cadpage.parsers.WV;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Berkeley County, WV
 */
public class WVBerkeleyCountyParser extends FieldProgramParser {
  
  public WVBerkeleyCountyParser() {
    super("BERKELEY COUNTY", "WV",
           "Description:CALL! Address:ADDR! CITY!");
  }
  
  @Override
  public String getFilter() {
    return "alert@berkeleywv.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Alert")) return false;
    return parseFields(body.split("\n"), 3, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" // ", " & ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = PAREN_PTN.matcher(addr).replaceFirst("").trim();
    return addr;
  }
  private static final Pattern PAREN_PTN = Pattern.compile("\\(.*\\)$");
}
