package net.anei.cadpage.parsers.MI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class MIIronCountyParser extends DispatchOSSIParser {

  public MIIronCountyParser() {
    super("IRON COUNTY", "MI",
          "CALL ( PLACE ADDR2 | ADDR | PLACE ADDR ) X+? INFO+? SRC");
  }
  
  @Override
  public String getFilter() {
    return "CAD@up-911.com";
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(.*)\n(\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}[AP]M)");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ssaa");

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (!match.matches()) return false;
    body = match.group(1).trim();
    setDateTime(DATE_TIME_FMT, match.group(2), data);
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR2")) return new MyAddress2Field();
    if (name.equals("SRC")) return new SourceField("\\d+[A-Z]+", true);
    return super.getField(name);
  }
  
  // Selective address field that does not accept naked streets
  // which are probably cross streets
  private class MyAddress2Field extends AddressField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override 
    public boolean checkParse(String field, Data data) {
      Result res = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, field);
      if (res.getStatus() <= STATUS_STREET_NAME) return false;
      res.getData(data);
      return true;
    }
  }
}
