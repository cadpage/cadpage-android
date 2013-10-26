/*
Chester County, PA
*/

package net.anei.cadpage.parsers.PA;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyJParser extends PAChesterCountyBaseParser{

  public PAChesterCountyJParser() {
    super("ID CALL ADDRCITY X PLACE PLACE_PHONE CITY! INFO+? EMPTY TIME DATE!");
  }

  @Override
  public String getFilter() {
    return "afc23@fdcms.info";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  // Call field strips trailing asterisk marker
  private class MyCallField extends CallField {
  
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("*")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class AddressCityField extends BaseAddressCityField {
    
    @Override
    public void parse(String field, Data data) {
      
      // The base class will not accept fields without a comma.
      // but we have a few that we have to deal with :(
      if (!field.contains(",")) {
        if (field.endsWith("(NV)")) {
          field = field.substring(0,field.length()-4).trim();
          parseAddress(field, data);
          return;
        }
      }
      super.parse(field, data);
    }
  }
  
  private static final Pattern APT_PTN = Pattern.compile("^(?:APT|RM) *([^ \\-]*)[- ]*");
  private static final Pattern PHONE_PTN = Pattern.compile("(.*?)[-#/ ]*\\b((?:CP)?\\d{3}[-\\.]?\\d{3}[-\\.]?\\d{4})\\b[-#/ ]*(.*?)");
  
  private class MyPlacePhoneField extends PlaceField {

    @Override
    public void parse(String field, Data data) {
      
      Matcher match = APT_PTN.matcher(field);
      if (match.find()){
        data.strApt = getOptGroup(match.group(1));
        field = match.replaceFirst("");
      }
      
      match = PHONE_PTN.matcher(field);
      if (match.matches()){
        data.strPhone = match.group(2);
        field = append(match.group(1), " ", match.group(3));
      }
      
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      if (field.startsWith("-")) field = field.substring(1,field.length()).trim();
      data.strPlace = append(data.strPlace, " - ", field).trim();
    }
    
    @Override
    public String getFieldNames(){
      return "APT PLACE PHONE";
    }
  }
  
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.trim().equals("DETAILS TO FOLLOW")) return;
      data.strSupp += field;
    }
    
    @Override
    public boolean doNotTrim() {
      return true;
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDRCITY")) return new AddressCityField();
    if (name.equals("PLACE_PHONE")) return new MyPlacePhoneField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TIME")) return new TimeField("(\\d\\d:\\d\\d):", true);
    return super.getField(name);
  }
}
