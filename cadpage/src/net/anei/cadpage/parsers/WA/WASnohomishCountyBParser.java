package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class WASnohomishCountyBParser extends FieldProgramParser {
  
  public WASnohomishCountyBParser() {
    super("SNOHOMISH COUNTY", "WA",
           "CALL ADDRCITY/S6 MAP_CH UNIT! INFO/S+");
  }
  
  @Override
  public String getFilter() {
    return "NoReply@snopac911.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("DISP")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new CallField("\\*\\*([A-Z]+)\\*\\*", true);
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("MAP_CH")) return new MyMapChannelField();
    if (name.equals("UNIT")) return new UnitField("(.*?) +/", true);
    return super.getField(name);
  }
  
  private static final Pattern ADDR_PLACE_PTN = Pattern.compile("(.*) / (.*) /");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_PLACE_PTN.matcher(field);
      if (!match.matches()) abort();
      super.parse(match.group(1).trim().replace('@','&'), data);
      data.strPlace = match.group(2).trim();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private static final Pattern MAP_CH_PTN = Pattern.compile("([A-Z0-9]+) / (.*) /");
  private class MyMapChannelField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_CH_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strMap = match.group(1);
      data.strChannel = match.group(2).trim();
    }

    @Override
    public String getFieldNames() {
      return "MAP CH";
    }
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    // Usually PK means PIKE, but not here
    addr = PK_PTN.matcher(addr).replaceAll("PKWY");
    
    // SR 2 usually means WA 2, but here is it US 2
    addr = SR2_PTN.matcher(addr).replaceAll("US 2");
    return super.adjustMapAddress(addr);
  }
  private static final Pattern PK_PTN = Pattern.compile("\\bPK\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern SR2_PTN = Pattern.compile("\\bSR *2\\b", Pattern.CASE_INSENSITIVE);
}
