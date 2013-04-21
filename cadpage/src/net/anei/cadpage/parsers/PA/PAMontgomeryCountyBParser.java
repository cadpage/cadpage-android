package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA8Parser;




public class PAMontgomeryCountyBParser extends DispatchA8Parser {

  public PAMontgomeryCountyBParser() {
    super(PAMontgomeryCountyParser.CITY_CODES, "MONTGOMERY COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "Beryl0908@comcast.net,adi53@comcast.net";
  }
  
  private final class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("SPECIAL ADDRESS COMMENT:")) {
        field = field.substring(24).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  protected void parseSpecialField(String field, Data data) {
    int pt = field.indexOf("Additional Info:\n");
    if (pt >= 0) {
      data.strSupp = append(data.strSupp, "\n", field.substring(pt).replaceAll("\n\n+", "\n"));
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
	