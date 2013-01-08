package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYJeffersonCountyParser extends FieldProgramParser {
  
  public NYJeffersonCountyParser() {
    super("JEFFERSON COUNTY", "NY",
          "CALL ADDR! INFO+");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ').replaceAll("  +", " ");
    String[] flds = body.split("\\|", -1);
    if (flds.length != 3) return false;
    return parseFields(flds, data);
  }
  
  private static final Pattern ADDR_PTN = Pattern.compile("\\(.\\)$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_PTN.matcher(field);
      if (match.find()) field = field.substring(0,match.start()).trim();
      Parser p = new Parser(field.trim());
      data.strCity = p.getLastOptional(':');
      data.strPlace = p.getLastOptional(';');
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR PLACE CITY";
    }
  }
  
  private static final Pattern CALLBACK_PTN = Pattern.compile("\\bCALLBACK=([^ ]*) LAT=([^ ]*) LON=([^ ]*)");
  private static final Pattern LATLON_PTN = Pattern.compile("LAT:([^ ]*) +LON:([-+\\.0-9]*)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int cutoff = field.length();
      Matcher match = CALLBACK_PTN.matcher(field);
      if (match.find()) {
        cutoff = Math.min(cutoff, match.start());
        data.strPhone = match.group(1);
        setGPSLoc(append(match.group(2), " ", match.group(3)), data);
      }
      
      if (data.strGPSLoc.length() == 0) {
        match = LATLON_PTN.matcher(field);
        if (match.find()) {
          cutoff = Math.min(cutoff, match.start());
          setGPSLoc(append(match.group(1), " ", match.group(2)), data);
        }
      }

      int pt = field.indexOf(":ProQA");
      if (pt >= 0) cutoff = Math.min(cutoff, pt);
      
      field = field.substring(0,cutoff).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO PHONE GPS";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
