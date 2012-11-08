package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Harris County NWEMS, TX
 */
public class TXHarrisCountyNWEMSParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\* ");

  public TXHarrisCountyNWEMSParser() {
    super("HARRIS COUNTY", "TX",
           "ADDR APT UNK UNK ( X/Z X/Z MAP EMPTY | EMPTY+? ) CODE CALL UNK UNK UNIT! INFO+");
  }
  
  public String getFilter() {
    return "cad@nwems.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("* ")) return false;
    body = body.substring(2).trim();
    return parseFields(DELIM.split(body+" "), 10, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "&");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MapField("\\d{3}[A-Z]{1,4}", true);
    return super.getField(name);
  }
}
