package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA8Parser;




public class NYOnondagaCountyCParser extends DispatchA8Parser {

  public NYOnondagaCountyCParser() {
    super("ONONDAGA COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "wavescalls@me.com";
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
    
    Parser p = new Parser(sExtra);
    data.strSource = getPatternValue(p, AGENCY_PTN);
    data.strCity = convertCodes(getPatternValue(p, MUNICIPALITY_PTN), CITY_CODES);
    data.strCross = getPatternValue(p, CROSS_STREET_PTN);
    data.strUnit = getPatternValue(p, UNIT_PTN);
    
    return true;
  }
  
  private static final Pattern AGENCY_PTN = Pattern.compile("\n *Agency: *(.*)(?=\n)");
  private static final Pattern MUNICIPALITY_PTN = Pattern.compile("\n *Municipality: *([A-Z]+)(?=\n)");
  private static final Pattern CROSS_STREET_PTN = Pattern.compile("\n *Cross Street: *(.*)(?=\n)");
  private static final Pattern UNIT_PTN = Pattern.compile("\n *Responding Units: *\n* *(.*?)(?=\n|\\*\\*|$)");
  
  private String getPatternValue(Parser p, Pattern ptn) {
    Matcher match = p.getMatcher(ptn);
    return (match == null ? "" : match.group(1).trim());
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " SRC CITY X UNIT";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "TCM", "CAMILLUS",
      "TGD", "GEDDES",
      "VCM", "CAMILLUS",
  });
}
	