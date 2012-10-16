package net.anei.cadpage.parsers.MI;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Mobile Medical Response, MI
 */
public class MIMobileMedicalResponseParser extends DispatchProQAParser {
  
  private static final Pattern MISMATCH1_PTN = Pattern.compile("\\([^\\)]*$");
  private static final Pattern MISMATCH2_PTN = Pattern.compile("^[^\\(]*\\)");
  
  public MIMobileMedicalResponseParser() {
    super("", "MI", 
           "ADDR CALL! XTRA+? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "mailghost@mobilemedical.org,6344,6573";
  }
  
  @Override
  public String getLocName() {
    return "Mobile Medical Response, MI";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    // dummy loop statement
    do {
      if (subject.startsWith("<CAD>")) break;
      if (body.startsWith("--")) body = body.substring(2).trim();
      if (body.startsWith("<CAD> - ")) {
        body = body.substring(8).trim();
        break;
      }
      return false;
    } while (false);
    
    return super.parseMsg(body, data);
  }

  // Field following call can be
  //   extension of call
  //   apt number
  //   or absent
  private class ExtraField extends Field {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      
      // if call has an open left paren, and this field has an open right paren
      // Assume that this is an extension of the call description split by
      // an inadvertent / and put them back together again
      if (MISMATCH1_PTN.matcher(data.strCall).find() &&
          MISMATCH2_PTN.matcher(field).find()) {
        data.strCall = data.strCall + '/' + field;
        return true;
      }
      
      // If field length <= 3, assume it is an apt
      if (field.length() <= 3) {
        data.strApt = field;
        return true;
      }
      
      // Otherwise we can ignore this field and treat data as a normal info field
      return false;
    }

    @Override
    public void parse(String field, Data data) {
      throw new RuntimeException("Not supported");
    }
    
    @Override
    public String getFieldNames() {
      return "APT";
    }
  }
  
  // Normal INFO field sometimes contain cross street info
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.toUpperCase().startsWith("X ")) {
        data.strCross = append(data.strCross, " & ", field.substring(2).trim());
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
    if (name.equals("XTRA")) return new ExtraField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
