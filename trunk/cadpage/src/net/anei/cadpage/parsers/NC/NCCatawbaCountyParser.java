package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCCatawbaCountyParser extends FieldProgramParser {
  
  private static final Pattern ID_PATTERN = Pattern.compile("20\\d\\d-\\d{6}");
  private static final Pattern C_AND_B = Pattern.compile("\\bC AND B\\b|\\bC *& *B\\b", Pattern.CASE_INSENSITIVE);
  
  public NCCatawbaCountyParser() {
    super("CATAWBA COUNTY", "NC",
           "ID ADDR APT APT CITY INFO CALL! INFO PLACE PHONE UNIT SKIP INFO INFO INFO");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() == 0) return false;
    if (body.charAt(0) == '|') body = body.substring(1).trim();
    body = body.replaceAll("//+", "/");
    body = C_AND_B.matcher(body).replaceAll("C%B");
    String[] flds = body.split("\\*");

    if (! ID_PATTERN.matcher(flds[0]).matches()) return false;

    if (!parseFields(flds, data)) return false;
    data.strAddress = data.strAddress.replace("C%B", "C AND B");
    data.strCross = data.strCross.replace("C%B", "C AND B");
    
    return true;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return C_AND_B.matcher(addr).replaceAll("C%B");
  }

  @Override
  public String postAdjustMapAddress(String sAddress) {
    return sAddress.replace("C%B", "C AND B");
  }
  
  
}
