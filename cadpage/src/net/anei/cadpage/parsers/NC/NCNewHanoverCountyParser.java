package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCNewHanoverCountyParser extends DispatchOSSIParser {
  
  public NCNewHanoverCountyParser() {
    super("NEW HANOVER COUNTY", "NC",
           "SRC CALL ADDR EXTRA! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  private static final Pattern ASTERISK_PTN = Pattern.compile("\\*\\*+");
  private static final Pattern CHANNEL_PTN = Pattern.compile("\\*(TAC\\d+)\\*", Pattern.CASE_INSENSITIVE);
  private static final Pattern ID_PTN = Pattern.compile("\\d{5,}");
  private static final Pattern PLACE_PTN = Pattern.compile("[A-Z ]+");
  private class MyExtraField extends Field {
    @Override
    public void parse(String field, Data data) {
      field = ASTERISK_PTN.matcher(field).replaceAll("*");
      Matcher match = CHANNEL_PTN.matcher(field);
      if (match.matches()) {
        data.strChannel = match.group(1).toUpperCase();
        return;
      }
      
      match = ID_PTN.matcher(field);
      if (match.matches()) {
        data.strCallId = field;
        return;
      }
      
      match = PLACE_PTN.matcher(field);
      if (match.matches()) {
        data.strPlace = field;
        return;
      }
      
      data.strSupp = field;
    }
    
    @Override
    public String getFieldNames() {
      return "CH ID PLACE INFO";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = ASTERISK_PTN.matcher(field).replaceAll("*");
      super.parse(field, data);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("ST\\d+", true);
    if (name.equals("EXTRA")) return new MyExtraField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
