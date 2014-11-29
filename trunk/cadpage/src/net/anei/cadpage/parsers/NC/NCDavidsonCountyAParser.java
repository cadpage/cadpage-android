package net.anei.cadpage.parsers.NC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCDavidsonCountyAParser extends DispatchOSSIParser {

  private static final Pattern ID_PTN = Pattern.compile("\\d{10}");

  public NCDavidsonCountyAParser() {
    super(CITY_CODES, "DAVIDSON COUNTY", "NC",
           "CALL ADDR! CITY? ( ID | PLACE ID | PLACE X | ) X+? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@davidsoncountync.gov";
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ID")) return new IdField("\\d{10}");
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern BAD_CALL_PTN = Pattern.compile("\\d{1,2}[A-Z]\\d{1,2}[A-Z]?+ .*|FYI:|Update:");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      // Reject anything that looks like a NCRowanCounty page
      if (BAD_CALL_PTN.matcher(field).matches()) abort();
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (BAD_CITY_CODES.contains(field)) abort();
      super.parse(field, data);
    }
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
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARC",  "ARCHDALE",
      "CL",   "CLEMMONS",
      "DEN",  "DENTON",
      "GREE", "GREENSBORO",
      "HP",   "HIGH POINT",
      "KV",   "KERNERSVILLE",
      "LEX",  "LEXINGTON",
      "LIN",  "LINWOOD",
      "NL",   "NEW LONDON",
      "RAN",  "RANDOLPH COUNTY",
      "RWC",  "ROWAN COUNTY",
      "THA",  "THOMASVILLE",
      "TROY", "TROY",
      "WELC", "WELCOME",
      "WS",   "WINSTON SALEM"
  });
}
