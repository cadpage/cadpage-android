package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchAegisParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" +--? +");
  
  public DispatchAegisParser(String defCity, String defState, String program) {
    super(defCity, defState, program);
  }
  
  public DispatchAegisParser(String[] cityList, String defCity, String defState, String program) {
    super(cityList, defCity, defState, program);
  }
  
  public DispatchAegisParser(Properties cityCodes, String defCity, String defState, String program) {
    super(cityCodes, defCity, defState, program);
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] subjects = subject.split("\\|", -1);
    if (subjects.length != 2 || !subjects[0].equals("Chief ALT")) return false;
    data.strSource = subjects[1];
    
    while (body.startsWith("-")) body = body.substring(1).trim();
    String[] flds = DELIM.split(body);
    if (flds.length > 1) {
      if (parseFields(flds, data)) return true;
    }
    
    String src = data.strSource;
    if (src.length() == 0) return false;
    data.parseGeneralAlert(body);
    data.strSource = src;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
