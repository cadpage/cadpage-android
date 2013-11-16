package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCDurhamCountyParser extends DispatchOSSIParser {
  
  public NCDurhamCountyParser() {
    super("DURHAM COUNTY", "NC",
           "CALL ADDR! CH? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@durhamnc.gov";
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("^\\{(.*?)\\}");
  private static final Pattern JOIN_PTN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d \\d\\d$|PROBLEM$");
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    boolean cadSubj = subject.startsWith("CAD:");
    boolean cadBody = body.startsWith("CAD:");
    if (!cadSubj && !cadBody) return false;
    if (cadSubj || subject.contains(";")) {
      if (cadSubj) subject = subject.substring(4);
      if (cadBody) body = body.substring(4);
      String join = (subject.length() > 0 && JOIN_PTN.matcher(subject).find() ? ":" : "");
      body = "CAD:" + subject + join + body;
    }
    if (!super.parseMsg(body, data)) return false;
    Matcher match = UNIT_PTN.matcher(data.strSupp);
    if (match.find()) {
      data.strUnit = match.group(1);
      data.strSupp = data.strSupp.substring(match.end()).trim();
    }
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CH")) return new ChannelField("\\**(OP.*)", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
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
}
