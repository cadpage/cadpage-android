package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchChiefWebPagingParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" -- | - (?=Cross STS:|EMD:|Notes:)");
  
  public DispatchChiefWebPagingParser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
           "CALL! NAME? ADDR/S! Cross_STS:X? Caller:NAME? EMD:UNIT? Notes:INFO+");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,msg@cfmsg.com,alert@cfmsg.com";
  }

  @Override
   protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.startsWith("Chief ALT|")) return false;
    data.strSource = subject.substring(10).trim();
    
    if (!body.startsWith("-- ")) return false;
    body = body.substring(3).trim();
    
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final Pattern STATE_PTN = Pattern.compile(" +([A-Z]{2})$");
  private class BaseAddressField extends AddressField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // Address field is the last field before any labeled fields
      // or the end of the field list
      String next = getRelativeField(+1);
      if (next.length() > 0 && !next.contains(":")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = STATE_PTN.matcher(field);
      if (match.find()) {
        data.strState = match.group(1);
        field = field.substring(0, match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile(" +(\\d{7,})$");
  private class BaseNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group(1);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("PROQA DETAIL")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("NAME")) return new BaseNameField();
    if (name.equals("INFO")) return new BaseInfoField();
    return super.getField(name);
  }
}


