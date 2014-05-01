package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchA14Parser;


public class NYSuffolkCountyBParser extends DispatchA14Parser {
  
  private static final Pattern LETTER_PTN = Pattern.compile("[A-Z]");
  private static final Pattern DIR_SLASH_BOUND_PTN = Pattern.compile("\\b([NSEW])/B\\b");
  private static final Pattern NK_PTN = Pattern.compile("\\bNK\\b");
 
  public NYSuffolkCountyBParser() {
    super(NYSuffolkCountyAParser.CITY_TABLE, DISTRICT_SET, "SUFFOLK COUNTY", "NY");
    setupMultiWordStreets(
        "BAY SHORE",
        "BELLE TERRE",
        "COUNTY LINE",
        "GREAT EAST NECK",
        "GREAT NECK",
        "HALF HOLLOW",
        "HILL CRESCENT",
        "INDIAN HEAD",
        "LITTLE EAST NECK",
        "LONG ISLAND",
        "PARK CENTER",
        "PINE TREE",
        "SWEET HOLLOW",
        "VAN COTT",
        "YACHT CLUB"
    );
    removeWords("ESTATES", "HEIGHTS", "SQUARE");
  }
  
  @Override
  public String getFilter() {
    return "@firerescuesystems.xohost.com,scmproducts@optonline.net,paging@bcfa.xohost.com,alarms@ronkonkomafd.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    body = DIR_SLASH_BOUND_PTN.matcher(body).replaceAll("$1B");
    
    if (!super.parseMsg(body, data)) return false;
    
    // restore AVENUE X street names that got split up by address logic
    if (data.strAddress.endsWith(" AVENUE") && LETTER_PTN.matcher(data.strApt).matches()) {
      data.strAddress = append(data.strAddress, " ", data.strApt);
      data.strApt = "";
    }

    if (data.strAddress.length() == 0) {
      data.strAddress = data.strPlace;
      data.strPlace = "";
    }
    
    if (data.strApt.length() > 0 && checkAddress(data.strApt) > 0) {
      data.strCross = append(data.strApt, " / ", data.strCross);
      data.strApt = "";
    }
    
    if (data.strPlace.startsWith("DOMINICAN VILLAGE")) {
      String addr = data.strPlace.substring(17).trim();
      data.strPlace = append(data.strAddress, " @ ", "DOMINICAN VILLAGE");
      data.strAddress = "";
      parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT | FLAG_NO_CITY | FLAG_ANCHOR_END, addr, data);
    }
    
    // Change dash to slash in cross streets
    data.strCross = data.strCross.replace(" - ", " / ");
    
    // Intersections are always messed up and need a lot of fixing
    if (data.strAddress.contains("&")) {
      for (PatternReplace pr: FIX_INTERSECT_TABLE) {
        if (pr.convert(data)) break;
      }
    }
    
    // Expand NK -> NECK abbreviation
    data.strAddress = NK_PTN.matcher(data.strAddress).replaceAll("NECK");
    return true;
  }

  @Override
  protected boolean isNotExtraApt(String apt) {
    if (apt.startsWith("(")) return true;
    if (apt.startsWith("EXP")) return true;
    return super.isNotExtraApt(apt);
  }
  

  private static class PatternReplace {
    private Pattern pattern;
    private String replace;
    
    public PatternReplace(String pattern, String replace) {
      this.pattern = Pattern.compile(pattern);
      this.replace = replace;
    }
    
    public boolean convert(Data data) {
      Matcher match = pattern.matcher(data.strAddress);
      if (!match.matches()) return false;
      StringBuffer sb = new StringBuffer();
      match.appendReplacement(sb, replace);
      data.strAddress =sb.toString();
      data.strAddress = match.replaceFirst(replace);
      return true;
    }
  }
  
  private static final PatternReplace[] FIX_INTERSECT_TABLE = new PatternReplace[]{
    new PatternReplace("(.* & )(.+ AV)(\\2E)$",                 "$1$3"),
    new PatternReplace("(.* & )(.+) BD(\\2 BLVD)$",            "$1$3"),
    new PatternReplace("(.* & )(.+)(\\2)$",                     "$1$3"),
    new PatternReplace("(.* & )(.+)([NSEW] \\2)$",              "$1$3"),
    new PatternReplace("(.* AV)( & .*)(\\1E)",                  "$3$2"),
    new PatternReplace("(.*) BD( & .*)(\\1 BLVD)",              "$3$2"),
    new PatternReplace("(.*)( & .*)(\\1)",                      "$3$2"),
    new PatternReplace("(.* AV) ([NSEW])( & .*)(\\2 \\1E)",     "$4$3"),
    new PatternReplace("(.*) ([NSEW])( & .*)(\\2 \\1)",         "$4$3"),
    new PatternReplace("(.* & .* AV)[A-DF-Z].+",                "$1E"),
    new PatternReplace("(.* & .* ST)[B-DF-HJ-NPQSTV-Z].+",      "$1"),
  };

  private static final ReverseCodeSet DISTRICT_SET = new ReverseCodeSet(
      "AMITYVILLE FD",
      "BABYLON FD",
      "COPIAGUE FD",
      "DEER PARK FIRE DISTRICT",
      "NORTH BABYLON FC",
      "NORTH LINDENHURST",
      "PT JEFFERSON",
      "WEST BABYLON FIRE DEPT"
  );
}
