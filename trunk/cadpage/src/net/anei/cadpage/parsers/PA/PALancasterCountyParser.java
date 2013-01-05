package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Lancaster County, PA
 */
public class PALancasterCountyParser extends FieldProgramParser {
  
  public PALancasterCountyParser() {
    super("LANCASTER COUNTY", "PA",
           "CITY ADDR X/Z+? UNIT TIME!");
  }
  
  @Override
  public String getFilter() {
    return "911@lcwc911.us,messaging@iamresponding.com,@everbridge.net,141000";
  }
  
//  @Override
//  protected Pattern getHtmlFilter() {
//    return HTML_FILTER_PTN;
//  }
//  private static final Pattern HTML_FILTER_PTN = Pattern.compile("(?:.*?~){3}\\d\\d:\\d\\d:\\d\\d\\^");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! body.contains("~")) return false;
    
    if (subject.indexOf(' ') >= 0 || subject.indexOf('-') >= 0) { 
      data.strCall = subject;
    } else {
      data.strSource = subject;
    }
    
    if (body.endsWith("^")) body = body.substring(0,body.length()-1).trim();
    return parseFields(body.split("~"), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC CALL " + super.getProgram();
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('\n');
      if (pt < 0) pt = field.indexOf('/');
      if (pt >= 0) {
        data.strCall = append(data.strCall, " / ", field.substring(0,pt).trim());
        field = field.substring(pt+1).trim();
      } else {
        if (data.strCall.length() == 0) abort();
      }
      data.strCity = field;
      if (data.strCity.endsWith(" BORO")) data.strCity = data.strCity.substring(0, data.strCity.length()-5).trim();
      if (data.strCity.endsWith(" BOROUGH")) data.strCity = data.strCity.substring(0, data.strCity.length()-8).trim();
      if (data.strCity.startsWith("LANC")) data.strCity = "LANCASTER";
    }
  }
  
  private static Pattern LANC_PTN = Pattern.compile("\\bLANC\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = LANC_PTN.matcher(field).replaceAll("LANCASTER");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
}
