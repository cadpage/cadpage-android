package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchVisionAirParser;

/**
 * Davie County, NC
 */
public class NCDavieCountyParser extends DispatchVisionAirParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*(?: \\*)*"); 
  
  public NCDavieCountyParser() {
    super("911:Call #", "DAVIE COUNTY", "NC",
           "ID Address:ADDR! City:CITY! INFO+ Type:CALL CALL NAME PH#:PHONE Units:UNIT IRA:SKIP? INFO+ NARR:EXTRA INFO+");
  }
  
  @Override
  public String getSponsor() {
    return "Davie County";
  }
  
  @Override
  public String getSponsorDateString() {
    return "07122011";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    int ipt = body.indexOf("911:Call #");
    if (ipt < 0) return false;
    body = body.substring(ipt+10).trim();
    return parseFields(DELIM.split(body), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("//+", "/");
      super.parse(field, data);
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private class MyInfo2Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " ", "Geo Comment: " + field);
    }
  }
  
  private class MyInfo3Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, " ", "NBH: " + field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("INFO2")) return new MyInfo2Field();
    if (name.equals("INFO3")) return new MyInfo3Field();
    return super.getField(name);
  }
}
