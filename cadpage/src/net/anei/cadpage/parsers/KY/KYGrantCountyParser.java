package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYGrantCountyParser extends DispatchB2Parser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("^KSP ([- /A-Z0-9]+?)(?: E-?911)?:");
  
  public KYGrantCountyParser() {
    super("KSP:", CITY_LIST, "GRANT COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "KSPDRYRIDGEE-911@P06.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = PREFIX_PTN.matcher(body);
    if (!match.lookingAt()) return false;
    data.strSource = match.group(1).trim();
    body = "KSP:" + body.substring(match.end());
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }

  private static final String[] CITY_LIST = new String[]{
    "BOURBON",
    "BROOKSVILLE",
    "CAMPBELLSBURG",
    "CORINTH",
    "CRITTENDEN",
    "CYNTHIANA",
    "DRY RIDGE",
    "FALMOUTH",
    "FLORENCE",
    "HARRISON",
    "MILFORD",
    "MILLERSBURG",
    "PARIS",
    "PENDLETON",
    "ROBERTSON",
    "SADIEVILLE",
    "WILLIAMSTOWN"
  };


}
