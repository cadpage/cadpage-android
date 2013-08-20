package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VAPageCountyParser extends DispatchDAPROParser {
  
  public VAPageCountyParser() {
    super(CITY_CODE_TABLE, "PAGE COUNTY", "VA");
    setupCallList(CALL_SET);
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (body.startsWith("MAILBOX:")) body = body.substring(8).trim();
    if (subject.length() > 0) body = subject + ": " + body;
    return super.parseMsg(body, data);
  }
  
  private static final CodeSet CALL_SET = new CodeSet(
      "CHEST PAINS",
      "COMMERCIAL ALARM",
      "DIZZINESS",
      "EMS-ILLNESS",
      "GENERAL ILLNESS",
      "INJURIES FROM A FALL",
      "PAIN",
      "TRAFFIC CRASH"
  );
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
      "ELK", "ELKTON",
      "LUR", "LURAY",
      "SHE", "SHENANDOAH",
      "STA", "STANLEY"
    });
  
}