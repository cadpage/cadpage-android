package net.anei.cadpage.parsers.NC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCDavidsonCountyParser extends DispatchOSSIParser {

  private static final Pattern ID_PTN = Pattern.compile("\\d{10}");

  public NCDavidsonCountyParser() {
    super("DAVIDSON COUNTY", "NC",
           "CALL ADDR! INTLS? ( ID | PLACE ID | PLACE X | ) X+? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@davidsoncountync.gov";
  }
  
  @Override
  public int getMapFlags() {
    // Keep EXT markers
    return MAP_FLG_SUPPR_EXT;
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("/")) body = body.substring(1).trim();
    boolean ok = body.startsWith("CAD:");
    if (!ok) body = "CAD:" + body;
    if (!super.parseMsg(body, data)) return false;
    if (ok) return true;
    return ID_PTN.matcher(data.strCallId).matches();
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (BAD_CITY_CODES.contains(field)) abort();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{10}");
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  // These are the city codes used by the Rowan County, NC location parser
  // Finding any of them is grounds to reject this text message
  private static final Set<String> BAD_CITY_CODES = new HashSet<String>(Arrays.asList(new String[]{
      "CHGV",
      "CLVD",
      "ESPN",
      "FATH",
      "GOLD",
      "GRQY",
      "KANN",
      "LAND",
      "MOOR",
      "ROCK",
      "SALS",
      "SPEN",
      "WOOD"
      
  }));
}
