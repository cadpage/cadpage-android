package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

public class NCJonesCountyParser extends DispatchA3Parser {

  public NCJonesCountyParser() {
    super("Communication:", CITY_LIST, "JONES COUNTY", "NC", "MASH! Line16:INFO! Line17:INFO! Line18:INFO!");
    setBreakChar('=');
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return super.parseMsg(body, data, false);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("MASH")) return new MyMashField();
    return super.getField(name);
  }

  private static final Pattern MASTER = Pattern.compile("(.*?) +((?:[EFL]-|TRAFFIC STOP).*?) *-(.*?)(?: +([^ ]*\\d[^ ]*))?");
  private static final Pattern CLEAN_CROSS = Pattern.compile("[ /]*(.*?)[ /]*");

  private class MyMashField extends Field {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "&");
      Matcher mat = MASTER.matcher(field);
      if (mat.matches()) {
        data.strCall = mat.group(3).trim();
        data.strCode = mat.group(2).trim();
        parseAddress(StartType.START_ADDR, mat.group(1).trim(), data);
        
        // if no city has been selected yet, check whatsLeft for the city and extract it.
        String whatsLeft = getLeft();
        if (data.strCity.length() == 0) {
          parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, whatsLeft, data);
          whatsLeft = getLeft();
        }

        // parse and clean crossroads
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, whatsLeft, data);
        if (data.strCross.length() > 0) {
          Matcher crossMat = CLEAN_CROSS.matcher(data.strCross);
          if (crossMat.matches()) data.strCross = crossMat.group(1);
        }
      } else abort();
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY X CODE CALL";
    }
  }

  public static String[] CITY_LIST = new String[] { "KINSTON", "MAYSVILLE", "POLLOCKSVILLE", "TRENTON" };
}
