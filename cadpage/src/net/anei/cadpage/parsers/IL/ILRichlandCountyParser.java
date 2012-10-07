package net.anei.cadpage.parsers.IL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class ILRichlandCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" -(?= |$)");
  
  public ILRichlandCountyParser() {
    super(CITY_LIST, "RICHLAND COUNTY", "IL",
           "SRC ADDR/S INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!parseFields(DELIM.split(body,-1), 3, data)) return false;
    int len = data.strSupp.length();
    if (len == 0) {
      data.strCall = "ALERT";
    } else if (len <= 40) {
      data.strCall = data.strSupp;
      data.strSupp = "";
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
      // Incorporated
      "CALHOUN",
      "CLAREMONT",
      "NOBLE",
      "OLNEY",
      "PARKERSBURG",
      // Unincorporated
      "BERRYVILLE",
      "DUNDAS",
      "WYNOOSE",
      // Townships
      "BONPAS TWP",
      "CLAREMONT TWP",
      "DECKER TWP",
      "DENVER TWP",
      "GERMAN TWP",
      "MADISON TWP",
      "NOBLE TWP",
      "OLNEY TWP",
      "PRESTON TWP"
  };
  
}
