package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.dispatch.DispatchA46Parser;

public class LATangipahoaParishParser extends DispatchA46Parser {

  public LATangipahoaParishParser() {
    super("TANGIPAHOA PARISH", "LA");
    }

  @Override
  public String getFilter() {
    return "PTS@ptssolutions.com";
  }
}
