package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.dispatch.DispatchA46Parser;

public class LAStTammanyParishBParser extends DispatchA46Parser {

  public LAStTammanyParishBParser() {
    super("ST TAMMANY PARISH", "LA");
    }

  @Override
  public String getFilter() {
    return "dispatch@covla.com";
  }
}
