package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCDurhamCountyParser extends DispatchOSSIParser {
  
  public NCDurhamCountyParser() {
    super("DURHAM COUNTY", "NC",
           "CALL ADDR CH? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@durhamnc.gov";
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("^\\{(.*?)\\}");
  private static final Pattern JOIN_PTN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d \\d\\d$|PROBLEM$");
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.startsWith("CAD:")) {
      String join;
      if (subject.length() == 4) join = "";
      else if (JOIN_PTN.matcher(subject).find()) join = ":";
      else join = "";
      body = subject + join + body;
    }
    if (!super.parseMsg(body, data)) return false;
    Matcher match = UNIT_PTN.matcher(data.strSupp);
    if (match.find()) {
      data.strUnit = match.group(1);
      data.strSupp = data.strSupp.substring(match.end()).trim();
    }
    return true;
  }
  
  private static final Pattern CH_PTN = Pattern.compile("\\**(OP.*)");
  private class MyChannelField extends ChannelField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      Matcher  match = CH_PTN.matcher(field);
      if (!match.matches()) return false;
      super.parse(match.group(1), data);
      return true;
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (checkAddress(field) > 0) {
        data.strCross = append(data.strCross, " & ", field);
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "INFO X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CH")) return new MyChannelField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
