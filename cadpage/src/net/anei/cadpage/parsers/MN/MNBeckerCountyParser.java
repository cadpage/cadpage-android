package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA38Parser;

public class MNBeckerCountyParser extends DispatchA38Parser {
  
  public MNBeckerCountyParser() {
    super("BECKER COUNTY", "MN");
  }
  
  @Override
  public String getFilter() {
    return "Tac10@co.becker.mn.us";
  }
 }
