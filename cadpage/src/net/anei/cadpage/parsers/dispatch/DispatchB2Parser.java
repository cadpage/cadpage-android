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
  
  public DispatchB2Parser(int version, String[] cityList, String defCity, String defState) {
    super(version, cityList, defCity, defState);
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
    
    String address = null;
    if (field.charAt(0) == '(') {
      int pt = field.indexOf(')');
      if (pt < 0) return false;
      address = field.substring(pt+1).trim();
      field = field.substring(1, pt);
    }

    Matcher match = CODE_PATTERN.matcher(field);
    if (match.find()) {
      data.strCode = match.group(1);
      field = field.substring(match.end());
    }
    
    StartType st = StartType.START_CALL;
    int flags = FLAG_START_FLD_REQ;
    if (address != null) {
      data.strCall = field;
      field = address;
      st = StartType.START_ADDR;
      flags = 0;
    }
    
    match = PHONE_PTN.matcher(field);
    if (match.find()) {
      data.strPhone = match.group(1);
      field = field.substring(0,match.start());
    }
    
    field = cleanWirelessCarrier(field, true);
    parseAddress(st, flags | FLAG_NEAR_TO_END, field, data);
    String name = getLeft();
    if (name.startsWith("&")) {
      data.strAddress = append(data.strAddress, " ", name);
    }
    
    else if (data.strPhone.length() == 0 && (match = PHONE2_PTN.matcher(name)).find()) {
      data.strPhone = match.group(1);
      field = name.substring(match.end());
      if (checkAddress(field) > 0) {
        data.strCross = field;
      } else {
        data.strName = field;
      }
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
