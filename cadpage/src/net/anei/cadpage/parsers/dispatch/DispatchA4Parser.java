package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA4Parser extends FieldProgramParser {
  
  private static final Pattern SLASH_PTN = Pattern.compile("/+");
  
  public DispatchA4Parser(String defCity, String defState) {
    this(defCity, defState, 1);
  }
  
  public DispatchA4Parser(String defCity, String defState, int version) {
    super(defCity, defState,
          (version == 2 ? "CALL! EMPTY! CITY! ADDR! Apt:APT! Cross_Streets:X"
                        : "CALL! ADDR! Apt:APT! CITY! Cross_Streets:X"));
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("CAD Page for CFS ")) return false;
    data.strCallId = subject.substring(17).trim();
    if (! parseFields(body.split("\n"), data)) return false;
    if (SLASH_PTN.matcher(data.strApt).matches()) data.strApt = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
}
