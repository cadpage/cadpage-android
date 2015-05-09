package net.anei.cadpage.parsers.MI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

public class MIStClairCountyParser extends DispatchA3Parser {

  public MIStClairCountyParser() {
    super("CentralDispatch:", "ST CLAIR COUNTY", "MI", "MASH Line16:INFO! Line17:INFO! Line18:INFO!");
    setBreakChar('=');
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return super.parseMsg(body, data, false);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("MASH")) return new MyMashField();
    return super.getField(name);
  }

  private static final Pattern MASTER = Pattern.compile("(\\d{2}-\\d+)(.*?)(?: ([^ ]+))? ([^ ]+)");
  private class MyMashField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher mat = MASTER.matcher(field);
      if (!mat.matches()) abort();
      data.strCallId = mat.group(1);
      String addr = mat.group(2);
      String callWord1 = mat.group(3);
      String callWord2 = mat.group(4);
      if (callWord1 != null) {
        String call = callWord1 + ' ' + callWord2;
        if (CALL_DESCS.contains(call.toUpperCase())) {
          data.strCall = call;
        } else {
          data.strCall = callWord2;
          addr = addr + ' ' + callWord1;
        }
      } else {
        data.strCall = callWord2;
      }
      addr = addr.replace("//", "/");
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END | FLAG_RECHECK_APT, addr, data);
      if (data.strApt.equals("JAMES") && data.strAddress.endsWith(" ST")) {
        data.strAddress = data.strAddress + ' ' + data.strApt;
        data.strApt = "";
      }
    }

    @Override
    public String getFieldNames() {
      return "ID ADDR APT CALL";
    }
  }

  private static final HashSet<String> CALL_DESCS = new HashSet<String>(Arrays.asList(
      "ALARM FIRE", 
      "PI ACC", 
      "DSP TRAINING", 
      "FIRE VEHICLE", 
      "ASSIST PUB", 
      "FIRE OTHER", 
      "FIRE STRUCT", 
      "ODOR INVES"
  ));
}
