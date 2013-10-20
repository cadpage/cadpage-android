package net.anei.cadpage.parsers.dispatch;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA18Parser extends FieldProgramParser {
  
  private Set<String> citySet;
  
  public DispatchA18Parser(String[] cityList, String defCity, String defState) {
    super(defCity, defState,
          "CALL ADDR X BOX! EMPTY+? ( DASHES DATETIME SRC SRC | ) INFO+");
    citySet = new HashSet<String>(Arrays.asList(cityList));
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf("\nDisclaimer");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return parseFields(body.split("\n"), 4, data);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    int pt = sAddress.indexOf(", Box");
    if (pt >= 0) sAddress = sAddress.substring(0,pt).trim();
    return sAddress;
  }

  private static final Pattern DELIM_PTN = Pattern.compile("[-/,]");
  private static final Pattern BOX_PTN = Pattern.compile("^BOX *(\\d+)", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT_PTN = Pattern.compile("^(?:APT|LOT|#) *([-A-Z0-9]+)\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT2_PTN = Pattern.compile("^(\\d{1,4}[A-D]?)\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern APT3_PTN = Pattern.compile("^([A-Z]) +(.*)", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("-- ")) {
        field = field.substring(3).trim();
      } else if (field.startsWith("-")) {
        int pt = field.indexOf('-',1);
        if (pt < 0) abort();
        data.strPlace = field.substring(1,pt).trim();
        field = field.substring(pt+1).trim();
      } else abort();
      
      boolean first = true;
      for (String part : DELIM_PTN.split(field)) {
        part = part.trim();
        if (part.length() == 0) continue;
        
        if (first) {
          first = false;
          parseAddress(part, data);
        } 
        
        else {
          
          Matcher match = BOX_PTN.matcher(part);
          if (match.find()) {
            data.strAddress = data.strAddress + ", Box " + match.group(1);
            part = part.substring(match.end()).trim();
          }
          
          match = APT_PTN.matcher(part);
          if (match.find()) {
            data.strApt = append(data.strApt, "-", match.group(1));
            part = part.substring(match.end()).trim();
          }
          
          match = APT2_PTN.matcher(part);
          if (match.find()) {
            data.strApt = append(data.strApt, "-", match.group(1));
            part = part.substring(match.end()).trim();
          }
          
          if (citySet.contains(part.toUpperCase())) {
            if (data.strCity.length() == 0) data.strCity = part;
            continue;
          }
          
          if (checkAddress(part) > 0) {
            if (Character.isDigit(data.strAddress.charAt(0))) {
              data.strCross = append(data.strCross, "/", part);
            } else {
              data.strAddress = append(data.strAddress, " & ", part);
            }
            continue;
          }
          
          if (APT2_PTN.matcher(part).matches()) {
            data.strApt = append(data.strApt, "-", part);
            continue;
          }
          
          if (data.strCity.length() == 0) {
            match = APT3_PTN.matcher(part);
            if (match.matches()) {
              String city = match.group(2);
              if (citySet.contains(city.toUpperCase())) {
                data.strApt = append(data.strApt, "-", match.group(1));
                data.strCity = city;
                continue;
              }
            }
          }
          
          data.strPlace = append(data.strPlace, " - ", part);
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "/");
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      if (field.endsWith("/NULL")) field = field.substring(0,field.length()-5).trim();
      data.strCross = append(data.strCross, "/", field);
    }
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("Fire Box =")) abort();
      field = field.substring(10).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern INFO_PTN = Pattern.compile("[a-z]+: *(.*?) +\\[(\\d\\d:\\d\\d:\\d\\d)\\]");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1);
        if (data.strTime.length() == 0) data.strTime = match.group(2);
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO TIME";
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("VERIFY")) return;
      data.strSource = append(data.strSource, " ", field.replace(' ', '_'));
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("BOX")) return new MyBoxField();
    if (name.equals("DASHES")) return new SkipField("-{5,}", true);
    if (name.equals("DATETIME")) return new DateTimeField("(\\d\\d.\\d\\d.\\d{4} \\d\\d:\\d\\d:\\d\\d) :.*", true);
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }}
