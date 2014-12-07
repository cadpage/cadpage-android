package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.HtmlParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DispatchBCParser extends DispatchA3Parser {
  private static final String PROGRAM = "ID CALL ADDR DATETIME NAME_PHONE INFO";
  private HtmlParser htmlParser;
  
  public DispatchBCParser(String defCity, String defState) {
    super(defCity, defState, PROGRAM);
    htmlParser = new HtmlParser(LAYOUT);
    htmlParser.translate(TRANS);
  }
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    if (!htmlParser.getHtmlCleaner (body.replace("&nbsp;", " "))) return false;
    return parseFields(htmlParser.getValueArray(), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("NAME_PHONE")) return new MyNamePhoneField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern DIGIT_PATTERN = Pattern.compile("(.*\\d.*?)\\/(.*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = DIGIT_PATTERN.matcher(field);
      if (m.matches()) {
        data.strCode = m.group(1).trim();
        data.strCall = m.group(2).trim();
      }
      else
        data.strCall = field.trim();
    }
    
    @Override
    public String getFieldNames() {
      return "CALL CODE";
    }
  }
  
  private static final Pattern PHONE_PATTERN
    = Pattern.compile("(.*?)((?:\\(\\d{3}\\) ?)?\\d{3}\\-\\d{4}.*)");
  private class MyNamePhoneField extends NameField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = PHONE_PATTERN.matcher(field);
      if (m.matches()) {
        data.strName = m.group(1).trim();
        data.strPhone = m.group(2).trim();
      }
      else
        data.strName = field.trim();
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  private static final Pattern STATE_CODE_PTN = Pattern.compile("[A-Z]{2}");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (STATE_CODE_PTN.matcher(city).matches()) {
        data.strState = city;
        city = p.getLastOptional(',');
      }
      data.strCity = city;
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY ST";
    }
  }
   
  private static final String[] LAYOUT = {
    "CALLID(ELEMENT=TD;LABEL=/Event No:/;OFFSET=2; required)",
    "CALL(ELEMENT=TD;LABEL=/Category:/;OFFSET=2)",
    "ADDRESS(ELEMENT=TD;LABEL=/Address:/;OFFSET=2; required)",
    "DATETIME(ELEMENT=TD;LABEL=/Open:/;OFFSET=2; required)",
    "NAME(ELEMENT=TD;LABEL=/Name Address Phone/;OFFSET=25)",
    "INFO(ELEMENT=TD;LABEL_BEGIN=/Incident Notes:/;LABEL_END=/Event Log/)"
  };

  private static final String[] TRANS = {
    "\\t", "",
    "\n", " ",
  };
}
