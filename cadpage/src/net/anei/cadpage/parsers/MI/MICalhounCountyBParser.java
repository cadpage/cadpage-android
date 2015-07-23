package net.anei.cadpage.parsers.MI;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class MICalhounCountyBParser extends DispatchOSSIParser {
  
  private static final Pattern MANGLED_SUBJECT_PTN = Pattern.compile("\\d\\d/\\d\\d/\\d{4} \\d{2}");
  
  public MICalhounCountyBParser() {
    super(MICalhounCountyParser.CITY_TABLE, "CALHOUN COUNTY", "MI",
          "( CANCEL ADDR | FYI? EMPTY? DATETIME CALL ADDR! ) CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@calhouncountymi.gov";
  }
  
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Fix some mangled messages
    if (MANGLED_SUBJECT_PTN.matcher(subject).matches() && body.startsWith("CAD:")) {
      body = "CAD:" + subject + body.substring(3);
    }
    if (!super.parseMsg(body, data)) return false;
    MICalhounCountyParser.cleanup(data);
    return true;
  }
}
