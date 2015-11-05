package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class WASnohomishCountyBParser extends FieldProgramParser {
  
  public WASnohomishCountyBParser() {
    super("SNOHOMISH COUNTY", "WA",
           "CALL CH ADDRCITY/S6 X_UNIT_INFO! INFO/S+");
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
    if (name.equals("CALL")) return new CallField(">>([A-Z]+)<<", true);
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("X_UNIT_INFO")) return new MyCrossUnitInfoField();
    return super.getField(name);
  }
  
  private static final Pattern ADDR_PLACE_PTN = Pattern.compile("(.*) / (.*) / ?(.*)");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_PLACE_PTN.matcher(field);
      if (!match.matches()) abort();
      super.parse(match.group(1).trim().replace('@','&'), data);
      data.strPlace = match.group(2).trim();
      data.strMap = match.group(3).trim();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE MAP";
    }
  }
  
  private static final Pattern X_UNIT_INFO_PTN = Pattern.compile("Between ([^*]*?) \\*([ ,A-Z0-9]*)\\* *(.*)");
  private class MyCrossUnitInfoField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = X_UNIT_INFO_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCross = match.group(1).trim();
      data.strUnit = match.group(2).trim();
      data.strSupp = match.group(3).trim();
    }

    @Override
    public String getFieldNames() {
      return "X UNIT INFO";
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
