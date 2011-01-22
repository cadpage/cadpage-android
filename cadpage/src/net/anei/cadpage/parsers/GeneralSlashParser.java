package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

public class GeneralSlashParser extends GeneralParser {

  @Override
  protected boolean parseMsg(String body, Data data) {
    return super.parseMsg(body.replaceAll("/","|"), data);
  }
}
