package net.anei.cadpage.parsers.KS;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA21Parser;


public class KSSedgwickCountyParser extends DispatchA21Parser {
  
  public KSSedgwickCountyParser() {
    super(CITY_CODES, "SEDGWICK COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "cad_admin@sedgwick.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String[] parts = subject.split("\\|");
    if (parts.length != 2 || !parts[0].equals("CommandPoint CAD Message")) return false;
    return super.parseMsg(parts[1], body, data);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = KNN_PTN.matcher(addr).replaceAll("STATE $1");
    return addr;
  }
  private static final Pattern KNN_PTN = Pattern.compile("\\bK(\\d+)\\b");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AN", "ANDALE",
      "CO", "COLWICH",
      "DE", "DERBY",
      "MU", "MULVANE",
      "SC", "",          // SEDGWICK COUNTY???
      "WI", "WICHITA"
  });
}
