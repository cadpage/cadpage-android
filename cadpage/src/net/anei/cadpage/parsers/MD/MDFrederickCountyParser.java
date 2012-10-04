package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Frederick County, MD
 */
public class MDFrederickCountyParser extends FieldProgramParser {

  public MDFrederickCountyParser(){
    super(CITY_CODES, "FREDERICK COUNTY", "MD",
          "CT:ADDR! TIME:TIME? ESZ:BOX? MAP:MAP Disp:UNIT");
  }

  @Override
  public String getFilter() {
    return "www.codemessaging.net,CAD@psb.net,@c-msg.net,messaging@iamresponding.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() > 0) {
      String[] subjects = subject.split("\\|");
      if (subjects.length > 2) return false;
      if (subjects.length == 2) {
        if (subjects[0].equals("CAD")) subject = subjects[1];
        else if (subjects[1].equals("CAD")) subject = subjects[0];
        else return false;
      }
      data.strSource = subject;
    }
    
    if (!super.parseMsg(body, data)) return false;
    
    // Parser is getting pretty sloppy, anything starting with CT: will pass
    // this.  Let's make sure they have at least one additional field
    return data.strTime.length() > 0 ||
            data.strBox.length() > 0 ||
            data.strMap.length() > 0 ||
            data.strUnit.length() > 0;
  }
  
  // Address field gets complicated
  private static final Pattern CITY_PTN = Pattern.compile("\\b([A-Z0-9]{4}(?: CO)?):(?: @)?");
  private static final Pattern PLACE_MARK_PTN = Pattern.compile(": (?:@|AT\\b)");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {

      // Everything changes with a mutual aid call
      // should be followed by a city: address
      int ipt = field.indexOf(" @MA ");
      if (ipt >= 0) {
        data.strCall = "Mutual Aid: " + field.substring(0, ipt).trim();
        int ipt2 = field.indexOf(':', ipt);
        if (ipt2 < 0) {
          data.strCity = convertCodes(field.substring(ipt+5).trim(), CITY_CODES);
        } else {
          data.strCity = convertCodes(field.substring(ipt+5, ipt2).trim(), CITY_CODES);
          field = field.substring(ipt2+1).trim().replaceAll("@", "");
          parseAddress(field, data);
        }
      }
  
      else {
        
        // Not mutual aid.
        // See if there is a / default marker.  If there is it marks the end of the call description
        StartType st = StartType.START_CALL;
        int pt = field.indexOf("/ default ");
        if (pt >= 0) {
          st = StartType.START_ADDR;
          data.strCall = field.substring(0,pt).trim();
          field = field.substring(pt+10).trim();
        }
        
        // Try to split this into three possible parts
        // A City mark separates a leading prefix
        // a place mark separates a trailing suffix
        String prefix = "";
        String suffix = "";
        Matcher match = CITY_PTN.matcher(field);
        String sCity = null;
        if (match.find()) {
          sCity = CITY_CODES.getProperty(match.group(1));
          if (sCity != null) {
            data.strCity = sCity;
            prefix = field.substring(0,match.start()).trim();
            field = field.substring(match.end()).trim();
          }
        }
        
        // We don't want more than 3 parts, so if we already have a call description
        // and have split off a non-empty prefix, move everything to the left
        if (st == StartType.START_ADDR && prefix.length() > 0) {
          suffix = field;
          field = prefix;
          prefix = "";
        } 
        
        // Otherwise try to split off a suffix
        else {
          match = PLACE_MARK_PTN.matcher(field);
          if (match.find()) {
            suffix = field.substring(match.end()).trim();
            field = field.substring(0,match.start()).trim();
          }
        }
        
        // If we have three parts, the last one is the place name
        int flags = 0;
        if (suffix.length() > 0) {
          flags = FLAG_ANCHOR_END;
          data.strPlace = suffix;
        }
        
        // If we have a prefix (which means we do not have a call description then
        if (prefix.length() > 0) {
          
          // If we also have a suffix, then prefix is the call description and field is the address 
          if (suffix.length() > 0) {
            data.strCall = prefix;
            parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
          } 
          
          // Otherwise we have an ambiguous case, prefix and field can be either
          // call-addr and place or
          // call and addr-place
          // We will try parsing field as an address first
          // If that doesn't work, parse prefix as the address
          else {
            Result res = parseAddress(StartType.START_ADDR, field);
            if (res.getStatus() > 0) {
              data.strCall = prefix;
              res.getData(data);
              data.strPlace = res.getLeft();
            } else {
              parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, prefix, data);
              data.strPlace = field;
            }
          }
        }
        
        // No prefix, parse the field as a field with possible leading call and/or trailing place
        else {
          parseAddress(st, flags, field, data);
          if (flags == 0) data.strPlace = getLeft();
        }
      }
      
      // If call is to Franklin or Adams county, set state to PA
      if (data.strCity.equals("Franklin County") || data.strCity.equals("Adams County")) {
        data.strState = "PA";
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL ADDR APT CITY ST PLACE";
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (field.contains("[") && field.contains("]")) {
        field = field.substring(0,field.indexOf("[")).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static final Properties CITY_CODES = 
    buildCodeTable(new String[]{
        "ADAM","Adams County", //PA
        "ADAMCO", "Adams County", //PA
        "ADAM CO", "Adams County", //PA
        "ADCO","Adams County", //PA
        "BRUN","Brunswick",   
        "CARRCO", "Carroll County",
        "CEMB","Emmitsburg",
        "CFR1","Frederick City",
        "CFR2","Frederick City",
        "CFR3","Frederick City",
        "CFR4","Frederick City",
        "CIJM", "New Market",
        "CMON", "Monrovia",
        "CMID", "Middletown",
        "CNMA","New Market",
        "CMTY","Mt Airy",
        "CSAB","Sabillasville",
        "CTHU","Thurmont",
        "CWAL","Walkersville",
        "EMMB", "Emmitsburg",
        "FRAN", "Franklin County",
        "FRAN CO", "Franklin County",
        "FRANCO", "Franklin County",
        "FRE1", "Frederick City",
        "FRE2", "Frederick City",
        "FRE3", "Frederick City",
        "MTAY", "Mt Airy",
        "NEWM", "New Market",
        "THUR","Thurmont",
        "WOOD","Woodsboro",
  });
}