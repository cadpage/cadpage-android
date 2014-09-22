package net.anei.cadpage.parsers.MN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA38Parser;

public class MNBeckerCountyParser extends DispatchA38Parser {
  
  private static final Pattern CRN_PTN = Pattern.compile("\\bCR#(\\d+)", Pattern.CASE_INSENSITIVE);
  private static final Pattern HN_PTN = Pattern.compile("\\bH#(\\d+)", Pattern.CASE_INSENSITIVE);
  private static final Pattern SLASH_DIR_PTN = Pattern.compile(".([NSEW])(?:ORTH|OUTH|AST|EST)?B(?:OUND)?\\b");
  private static final Pattern APT_PTN = Pattern.compile("\\d+[A-Z]?|(?:APT|ROOM|RM|UNIT|LOT|SUITE) *(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern PART_ADDR_PTN = Pattern.compile("\\d.*|HWY .*|US .*|MN .*|ST \\d.*|.*[/&].*");
  
  public MNBeckerCountyParser() {
    super("BECKER COUNTY", "MN");
    setupProtectedNames("TOWN AND COUNTRY");
  }

  @Override
  public String getFilter() {
    return "Tac10@co.becker.mn.us";
  }
 
  @Override
  protected void parseAddress(String field, Data data) {
    field = CRN_PTN.matcher(field).replaceAll("CR $1");
    field = HN_PTN.matcher(field).replaceAll("HWY $1");
    field = SLASH_DIR_PTN.matcher(field).replaceAll(" $1B");
    field = field.replace('@', '&');
    field = field.replace("MOUNTAIN  ASH", "MOUNTAIN ASH");
    
    // They use double blank delimiters to add all kinds
    // of things to the address field.  We will see what we can 
    // do to set things aright.
    int pt = field.indexOf("  ");
    if (pt < 0) {
      super.parseAddress(field, data);
      return;
    }
  
    String part1 = field.substring(0,pt);
    String part2 = field.substring(pt+2).trim();
    Matcher match = APT_PTN.matcher(part2);
    if (match.matches()) {
      String apt = match.group(1);
      if (apt == null) apt = part2;
      super.parseAddress(part1, data);
      data.strApt = apt;
      return;
    } 
  
    match = APT_PTN.matcher(part1);
    if (match.matches()) {
      String apt = match.group(1);
      if (apt != null) {
        super.parseAddress(part2, data);
        data.strApt = apt;
        return;
      }
    }
    
    if (!part2.startsWith("BY ") && isValidAddress(part2)) {
      if (PART_ADDR_PTN.matcher(part1).matches()) {
        parseAddress(part1 + ' ' + part2, data);
      } else {
        data.strPlace = part1;
        super.parseAddress(part2, data);
      }
      return;
    }
    
    if (checkAddress(part2) > checkAddress(part1)) {
      super.parseAddress(part2, data);
      data.strPlace = part1;
    } else {
      data.strAddress = part1;
      data.strPlace = part2;
    }
  }
 }
