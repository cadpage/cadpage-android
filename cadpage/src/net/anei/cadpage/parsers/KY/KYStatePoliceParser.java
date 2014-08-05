package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYStatePoliceParser extends DispatchB2Parser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("^KSP (DRY RIDGE E-911|CAMPBELLSBURG)?:");
  
  private boolean srcFound;
  
  public KYStatePoliceParser() {
    super(CITY_LIST, "", "KY");
  }
  
  @Override
  public String getLocName() {
    return "Kentucky State Police";
  }
  
  @Override
  public String getFilter() {
    return "KSPCAMPBELLSBURG@P05.gov,KSPCAMPBELLSBURG@P05.org,KSPDRYRIDGEE-911@P06.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = PREFIX_PTN.matcher(body);
    srcFound = match.lookingAt();
    if (srcFound) body = body.substring(match.end());
    return super.parseMsg(body, data);
  }

  @Override
  protected boolean isPageMsg(String body) {
    if (srcFound) return true;
    if (body.contains(" Cad:")) return true;
    return super.isPageMsg(body);
  }

  @Override
  protected boolean parseAddrField(String field, Data data) {
    field = field.replace('@', '&');
    return super.parseAddrField(field, data);
  }

  private static final String[] CITY_LIST = new String[]{
    "BEDFORD",
    "BOURBON",
    "BROOKSVILLE",
    "CAMPBELLSBURG",
    "CARROLLTON",
    "CONGLETON",
    "CORINTH",
    "CRESTWOOD",
    "CRITTENDEN",
    "CYNTHIANA",
    "DRY RIDGE",
    "EMINENCE",
    "FALMOUTH",
    "FLORENCE",
    "FRANKFORT",
    "GLENCOE",
    "HARRISON",
    "JONESVILLE",
    "LAGRANGE",
    "MILFORD",
    "MILTON",
    "MILLERSBURG",
    "NEW CASTLE",
    "NEW LIBERTY",
    "OWEN",
    "OWENTON",
    "PARIS",
    "PENDLETON",
    "PLEASUREVILLE",
    "PORT ROYAL",
    "ROBERTSON",
    "SADIEVILLE",
    "SANDERS",
    "SMITHFIELD",
    "SPARTA",
    "SULPHUR",
    "WARSAW",
    "WILLIAMSTOWN",
    
    //COUNTIES
    "CARROLL COUNTY",
    "GALLATIN COUNTY",
    "GRANT COUNTY",
    "HENRY COUNTY",
    "JEFFERSON COUNTY",
    "OLDHAM COUNTY",
    "OWEN COUNTY",
    "TRIMBLE COUNTY",
    
  };


}
