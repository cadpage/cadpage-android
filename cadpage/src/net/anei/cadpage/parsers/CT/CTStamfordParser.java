package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Stamford, CT
 */
public class CTStamfordParser extends DispatchA3Parser {
  
  private static final Pattern DELIM = Pattern.compile("\\*?\\n");
  
  private static final Pattern PREFIX_PTN = Pattern.compile("(?:(?:911Fire:|STAMFORD 911:)?\\*|STAMFORD 911:Stamford|911Fire:Stamford)\\n");
  public CTStamfordParser() {
    super("STAMFORD", "CT",
          "ADDR EMPTY EMPTY EMPTY X X EMPTY CMT CALL! EMPTY NAME EMPTY EMPTY EMPTY EMPTY INFO+");
  }

  @Override
  public String getFilter() {
    return "911fire@ci.Stamford.ct.us,911Fire@ci.stamford.ct.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.equals("From Stamford 911") || subject.equals("From- Stamford 911")) break;
      
      Matcher match = PREFIX_PTN.matcher(body);
      if (match.lookingAt()) {
        body = body.substring(match.end()).trim();
        break;
      }
      
      return false;
    } while (false);

    body = stripFieldEnd(body, "*");
    return parseFields(DELIM.split(body), data) && data.strCall.length() > 0;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CMT")) return new MyCommentField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern COMMENT_PTN = Pattern.compile("(?:Landmark|Geo|Place|Special) Comment::? *(.*)");
  private class MyCommentField extends BaseInfo1Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return true;
      Matcher match = COMMENT_PTN.matcher(field);
      if (!match.matches()) return false;
      super.parse(match.group(1), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private static final Pattern INFO_PTN = Pattern.compile("\\d\\d?/\\d\\d?/\\d{4} \\d\\d:\\d\\d:\\d\\d .*");
  private class MyInfoField extends BaseInfoField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!INFO_PTN.matcher(field).matches()) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      String saveCross = data.strCross;
      data.strCross = "";
      super.parse(field, data);
      if (data.strCross.length() == 0) data.strCross = saveCross;
    }
  }
}
