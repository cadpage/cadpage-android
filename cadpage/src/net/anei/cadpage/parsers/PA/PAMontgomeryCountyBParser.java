package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA8Parser;




public class PAMontgomeryCountyBParser extends DispatchA8Parser {

  public PAMontgomeryCountyBParser() {
    super("MONTGOMERY COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "Beryl0908@comcast.net,adi53@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf('\n');
    String sExtra = "";
    if (pt >= 0) {
      sExtra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
    }
    if (! super.parseMsg(body, data)) return false;
    if (data.strSupp.equals("SPECIAL ADDRESS COMMENT:")) data.strSupp = "";
    if (sExtra.length() > 0) {
      while (!sExtra.startsWith("** ")) {
        pt = sExtra.indexOf('\n');
        if (pt < 0) return false;
        data.strSupp = append(data.strSupp, "/n", sExtra.substring(0,pt).trim());
        sExtra = sExtra.substring(pt+1).trim();
      }
      
      Parser p = new Parser(sExtra);
      data.strCallId = getPatternValue(p, CALL_ID_PTN);
      data.strCross = getPatternValue(p, CROSS_STREET_PTN);
      data.strCity = convertCodes(getPatternValue(p, MUNICIPALITY_PTN), PAMontgomeryCountyParser.CITY_CODES);
      data.strUnit = getPatternValue(p, UNIT_PTN);
    }
    
    return true;
  }
  
  private static final Pattern CALL_ID_PTN = Pattern.compile(" INCIDENT: ([^ ]+) *\n");
  private static final Pattern CROSS_STREET_PTN = Pattern.compile("\n *Cross Street: *(.*)(?=\n)");
  private static final Pattern MUNICIPALITY_PTN = Pattern.compile(" MUN: *([A-Z]+) *(?=\n)");
  private static final Pattern UNIT_PTN = Pattern.compile("\n *Units Due: *(.*)(?=\n)");
  
  private String getPatternValue(Parser p, Pattern ptn) {
    Matcher match = p.getMatcher(ptn);
    return (match == null ? "" : match.group(1).trim());
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " ID X CITY UNIT";
  }
}
	