package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
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
  
  private static final Pattern CODE_PATTERN = Pattern.compile("^([- /A-Z0-9]*?|\\?) *> *"); 
  private static final Pattern PHONE_PTN = Pattern.compile(" *((?:\\d{3}[- ]?)?\\d{3}[- ]?\\d{4})$");
  private static final Pattern PHONE2_PTN = Pattern.compile("^((?:\\d{3}[- ]?)?\\d{3}[- ]?\\d{4}) *");
  private static final Pattern APT_PTN = Pattern.compile("[A-Z]?\\d+[A-Z]?");
  private static final Pattern NAME_PTN = Pattern.compile(" +([A-Z]+, ?[A-Z]+(?: [A-Z]\\.?)?)$");
  private static final Pattern TRAIL_DIR_PTN = Pattern.compile(" +([NSEW]B?)$");
  
  private String prefix;

  public DispatchB2Parser(String[] cityList, String defCity, String defState) {
    this(null, cityList, defCity, defState);
  }

  public DispatchB2Parser(Properties cityCodes, String defCity, String defState) {
    this(null, cityCodes, defCity, defState);
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

  public DispatchB2Parser(String prefix, int version, String[] cityList, String defCity, String defState) {
    super(version, cityList, defCity, defState);
    this.prefix = prefix;
  }

  public DispatchB2Parser(String prefix, Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
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
  
  
  @Override
  protected boolean isPageMsg(String body) {
    if (prefix != null) return true;
    return super.isPageMsg(body);
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
    if (field.length() == 0) return false;
    
    if (field.charAt(0) == '(') {
      int pt = 0;
      int pCnt = 0;
      do {
        if (pt >= field.length()) return false;
        char chr = field.charAt(pt);
        if (chr == '(') pCnt++;
        else if (chr == ')') pCnt--;
        pt++;
      } while (pCnt > 0);
      address = field.substring(pt).trim();
      field = field.substring(1, pt-1);
    }

    Matcher match = CODE_PATTERN.matcher(field);
    if (match.find()) {
      data.strCode = match.group(1);
      field = field.substring(match.end());
    }
    
    if (address != null) {
      data.strCall = field;
      field = address;
    } else { 
      Pattern ptn = getCallPattern();
      if (ptn != null) {
        match =  ptn.matcher(field);
        if (match.matches()) {
          data.strCall = match.group(1).trim();
          field = match.group(2).trim();
        }
      }
    }

    StartType st = StartType.START_CALL;
    int flags = FLAG_START_FLD_REQ;
    if (data.strCall.length() > 0) {
      st = StartType.START_ADDR;
      flags = 0;
    }

    match = PHONE_PTN.matcher(field);
    if (match.find()) {
      data.strPhone = match.group(1);
      field = field.substring(0,match.start());
    }
    
    field = cleanWirelessCarrier(field, true);
    match = NAME_PTN.matcher(field);
    if (match.find()) {
      data.strName = match.group(1);
      field = field.substring(0,match.start());
    }
    parseAddress(st, flags | FLAG_NEAR_TO_END, field, data);
    String name = getLeft();
    boolean noCross = (data.strCross.length() == 0);
    if (name.length() > 0) {
      if (name.startsWith("&")) {
        data.strAddress = append(data.strAddress, " ", name);
      } 
      else if (data.strPhone.length() == 0 && (match = PHONE2_PTN.matcher(name)).find()) {
        data.strPhone = match.group(1);
        field = name.substring(match.end());
        if (noCross && checkAddress(field) > 0) {
          data.strCross = field;
        } else {
          data.strName = append(field, " ", data.strName);
        }
      }
      
      else if ((match = APT_PTN.matcher(name)).matches()) {
        data.strApt = name;
      }
      
      else {
        if (noCross && checkAddress(name) > 0) {
          data.strCross = name;
        } else {
          data.strName = append(name, " ", data.strName);
        }
      }
      
      // We can't turn on the FLAG_CROSS_FOLLOWS option or it will mess up followin names
      // but if we have identified a cross street, see if the address has a trailing direction
      // symbol that should be attached to the cross street.
      if (noCross && data.strCross.length() > 0) {
        match = TRAIL_DIR_PTN.matcher(data.strAddress);
        if (match.find()) {
          data.strCross = match.group(1) + ' ' + data.strCross;
          data.strAddress = data.strAddress.substring(0,match.start());
        }
      }
    }
    
    return true;
  }
  
  /***
   * @return Pattern that can be used to separate call description from rest of address line.
   */
  protected Pattern getCallPattern() {
    return null;
  }
}
