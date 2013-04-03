package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/*
 * 
Improved version of DispatchBParser that does a better job of handling call codes and
message prefixes

This has been identified as Interact GIS system
And as CAD Interactive
Go Figure

*/

public class DispatchB2Parser extends DispatchBParser {
  
  private static final Pattern CODE_PATTERN = Pattern.compile("^([-A-Z0-9]+) *> *"); 
  private static final Pattern PHONE_PTN = Pattern.compile(" *((?:\\d{3}[- ]?)?\\d{3}[- ]?\\d{4})$");
  private static final Pattern PHONE2_PTN = Pattern.compile("^((?:\\d{3}[- ]?)?\\d{3}[- ]?\\d{4}) *");
  private static final Pattern APT_PTN = Pattern.compile("[A-Z]?\\d+[A-Z]?");
  
  private String prefix;

  public DispatchB2Parser(String[] cityList, String defCity, String defState) {
    this(null, cityList, defCity, defState);
  }
  
  public DispatchB2Parser(String defCity, String defState) {
    this((String)null, defCity, defState);
  }

  public DispatchB2Parser(String prefix, String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    this.prefix = prefix;
  }
  
  public DispatchB2Parser(String prefix, String defCity, String defState) {
    super(defCity, defState);
    this.prefix = prefix;
  }
  

  @Override
 protected boolean parseMsg(String body, Data data) {
    
    if (prefix != null) {
      if (!body.startsWith(prefix)) return false;
      body = body.substring(prefix.length()).trim();
    }
    return super.parseMsg(body, data);
  }

  
  /**
   * Processes the complicated first address field
   * Will usually be overridden by subclasses
   * @param field first address field
   * @param data message information data object
   * @return true if parse was successful
   */
  protected boolean parseAddrField(String field, Data data) {
    Matcher match = CODE_PATTERN.matcher(field);
    if (match.find()) {
      data.strCode = match.group(1);
      field = field.substring(match.end());
    }
    match = PHONE_PTN.matcher(field);
    if (match.find()) {
      data.strPhone = match.group(1);
      field = field.substring(0,match.start());
    }
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, field, data);
    String name = getLeft();
    if (name.startsWith("&")) {
      data.strAddress = append(data.strAddress, " ", name);
    }
    
    else if (data.strPhone.length() == 0 && (match = PHONE2_PTN.matcher(name)).find()) {
      data.strPhone = match.group(1);
      data.strName = name.substring(match.end());
    } 
    
    else if ((match = APT_PTN.matcher(name)).matches()) {
      data.strApt = name;
    }
    
    else {
      data.strName = name;
    }
    
    return true;
  }
}
