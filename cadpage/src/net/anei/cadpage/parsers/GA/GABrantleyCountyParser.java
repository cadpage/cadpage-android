package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class GABrantleyCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Disp ([A-Z0-9]+) Case # [-0-9]+ Call # ([0-9]+)");
  
  public GABrantleyCountyParser() {
    super("BRANTLEY COUNTY", "GA",
           "DATETIME CALL STNO? ADDR! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "brantleyga@smtp.sgcce-inc.com,brantleyga@ez911mail.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    data.strCallId = match.group(2);
    
    return parseFields(body.split(" /"), data);
  }
  
  private static final Pattern STREET_NO_PTN = Pattern.compile("\\d+");
  private class MyStreetNoField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (! STREET_NO_PTN.matcher(field).matches()) return false;
      data.strAddress = field;
      return true;
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String fld, Data data) {
      data.strAddress = append(data.strAddress, " ", fld);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("STNO")) return new MyStreetNoField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC ID " + super.getProgram();
  }
}
