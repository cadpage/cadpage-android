package net.anei.cadpage.parsers.OK;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OKTulsaBParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\.(?= |$)");
  
  public OKTulsaBParser() {
    super("TULSA", "OK",
          "ADDR PLACE CALL INFO! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "pagealert@cityoftulsa.org,@berryhillfire.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    return parseFields(DELIM.split(body), 4, data);
  }

}
