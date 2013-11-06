package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;


public class TNBradleyCountyParser extends DispatchA3Parser {
  
  public TNBradleyCountyParser() {
    super("CLEVELANDTN911 Bradley CO 911:* ", "BRADLEY COUNTY", "TN",
        "ADDR UNK UNK UNK UNK UNK UNK INFO1 CALL UNK UNK UNK UNK UNK UNK UNK INFO+");
  }
  
  @Override
  public String getFilter() {
    return "777";
  }
}
