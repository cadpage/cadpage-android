package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Humble, TX
*/

public class TXHumbleBParser extends DispatchOSSIParser {
  public TXHumbleBParser() {
    super(CITY_CODE, "HUMBLE", "TX",
          "( CANCEL ADDR! CITY INFO+ " +
          "| FYI? SRC? UNIT/C+? ID? CALL ( DATETIME INFOX+? CITY ADDR UNIT/C+ " + 
                                        "| ADDR! X/Z+? DATETIME! INFO+ ) )");
  }

  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{2}FD", true);
    if (name.equals("UNIT")) return new UnitField("(?:[A-Z]{4}|[A-Z]{2,3}\\d{1,3}\\b,?)+", true);
    if (name.equals("ID")) return new IdField("\\d{8}", true);
    if (name.equals("CODE")) return new CodeField("[A-Z]{4}", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("INFOX")) return new InfoField();
  
    return super.getField(name);
  }
  
  private static final Properties CITY_CODE = buildCodeTable(new String[] {
    "HUMB", "HUMBLE",
  });
}
