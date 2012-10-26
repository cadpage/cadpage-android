package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCOrangeCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("CAD Page for CFS (\\d{6}-\\d{1,3})");
  
  public NCOrangeCountyParser() {
    super("ORANGE COUNTY", "NC",
           "( CH CALL ADDR! Apt:APT Build:APT | RECD:TIME? TG:CH INC:CALL LOC:ADDR! APT:APT BLDG:APT EMD:CODE )");
  }
  
  @Override
  public String getFilter() {
    return "@cedargrovefire.org,cadpage@orangeem.org,cad@orangecountync.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    return parseFields(body.split("\n"), data);
  }
  
  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      data.strApt = append(field, " - ", data.strApt);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CH")) return new ChannelField("OPS.*");
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
