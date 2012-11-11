package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;




public class PAChesterCountyD2Parser extends PAChesterCountyBaseParser {
  
  public PAChesterCountyD2Parser() {
    super("CALL SKIP INFO+? DATE!");
  }
  
  @Override
  public String getFilter() {
    return "pfdfire@fdcms.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (isVariantGMsg(body)) return false;
    
    // Address is passed in subject
    if (!subject.contains(",")) return false;
    parseChesterAddress(subject, data);
    
    // And all of the should treat line breaks as spaces
    body = body.replace('\n', ' ');
    
    // Split fields by asterisk and parse
    return parseFields(body.split("\\*"), data);
  }
  
  // Time must match correct format
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  // Date must match correct format
  private class DateField extends SkipField {
    public DateField() {
      setPattern(Pattern.compile("\\d\\d/\\d\\d/\\d\\d"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("DATE")) return new DateField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ADDR CITY " + super.getProgram();
  }

} 
