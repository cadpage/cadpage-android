package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Butte County, CA
 */
public class CASantaClaraCountyParser extends FieldProgramParser {

  private static final Pattern MARKER = Pattern.compile("^EMDC#(M\\d{9})");
  
  public CASantaClaraCountyParser() {
    super(CITY_CODES, "SANTA CLARA COUNTY", "CA",
           "LOC:ADDR! CTY:CITY! ADDL:PLACE! TYPE:CALL! CD:PRI! MAP:MAP! DETAILS:INFO! TC:DATETIME!");
    setBreakChar('=');
  }
  
  @Override
  public String getFilter() {
    return "cademail@911.sccgov.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end()).trim();
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern ADDR_PAREN_PTN = Pattern.compile(" *\\([^\\(\\)]*\\) *");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('@', '&');
      field = ADDR_PAREN_PTN.matcher(field).replaceAll(" ").trim().replaceAll("  +", " ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames();
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/NONE")) field = field.substring(0,field.length()-5).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = CL_PTN.matcher(addr).replaceAll("CIR");
    addr = MC_PTN.matcher(addr).replaceAll("MC");
    return addr;
  }
  private static final Pattern CL_PTN = Pattern.compile("\\bCL\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern MC_PTN = Pattern.compile("\\bMC ", Pattern.CASE_INSENSITIVE);
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CU", "CUPERTINO",
      "SC", "SANTA CLARA",
      "SJ", "SAN JOSE" 
  });
}
