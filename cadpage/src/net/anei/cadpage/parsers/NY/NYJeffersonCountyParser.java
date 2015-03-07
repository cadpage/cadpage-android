package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYJeffersonCountyParser extends FieldProgramParser {
  
  public NYJeffersonCountyParser() {
    super("JEFFERSON COUNTY", "NY",
          "CALL ADDR! INFO+");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    body = body.replace('\n', ' ').replaceAll("  +", " ");

    // Fixed stuff messed up by IAR edits :(
    String[] flds;
    if (subject.equals("So. Jeff. Rescue")) {
      data.strSource = subject;
      if (body.endsWith("/") || body.endsWith(":")) body += ' ';
      body = body.replace(" : ", ":");
      
      flds = new String[3];
      
      // Generally split by " / ".  With some special checks to see if there
      // is a legitimate slash sequence in the address or info fields
      int pt1 = body.indexOf(" / ");
      if (pt1 < 0) return false;
      flds[0] = body.substring(0,pt1).trim();
      
      int pt2 = body.indexOf(" / ", pt1+3);
      if (pt2 < 0) return false;
      
      int pt3 = body.indexOf(" / ", pt2+3);
      if (pt3 >= 0) {
        if (!body.substring(pt1+3,pt2).contains(":") &
            body.substring(pt2+3,pt3).contains(":")) {
          pt2 = pt3;
        }
      }
      flds[1] = body.substring(pt1+3,pt2).trim();
      flds[2] = body.substring(pt2+3).trim();
    }
    
    // Normal parsing
    else {
      
      if (subject.startsWith("[")) {
        int pt = subject.indexOf(']');
        if (pt < 0) return false;
        data.strSource = subject.substring(1,pt).trim();
        subject = subject.substring(pt+1).trim();
      }
      
      if (subject.startsWith("DISPATCH:")) {
        data.strUnit = subject.substring(9).trim();
      }
      else if (subject.startsWith("DISPATCH") && subject.contains("Incident #:")) {
        data.strCall = "RUN REPORT";
        data.strPlace = '(' + subject + ") " + body;
        return true;
      }
      
      flds = body.split("\\|", -1);
      if (flds.length != 3) return false;
    }
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC UNIT " + super.getProgram();
  }
  
  private static final Pattern ADDR_PTN = Pattern.compile("\\(.\\)$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_PTN.matcher(field);
      if (match.find()) field = field.substring(0,match.start()).trim();
      Parser p = new Parser(field.trim());
      data.strCity = p.getLastOptional(':');
      data.strPlace = p.getLastOptional(';');
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE CITY";
    }
  }
  
  private static final Pattern CALLBACK_PTN = Pattern.compile("\\bCALLBACK=([^ ]*) LAT=([^ ]*) LON=([^ ]*)");
  private static final Pattern LATLON_PTN = Pattern.compile("LAT:([^ ]*) +LON:([-+\\.0-9]*)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int cutoff = field.length();
      Matcher match = CALLBACK_PTN.matcher(field);
      if (match.find()) {
        cutoff = Math.min(cutoff, match.start());
        data.strPhone = match.group(1);
        setGPSLoc(append(match.group(2), " ", match.group(3)), data);
      }
      
      if (data.strGPSLoc.length() == 0) {
        match = LATLON_PTN.matcher(field);
        if (match.find()) {
          cutoff = Math.min(cutoff, match.start());
          setGPSLoc(append(match.group(1), " ", match.group(2)), data);
        }
      }

      int pt = field.indexOf(":ProQA");
      if (pt >= 0) cutoff = Math.min(cutoff, pt);
      
      field = field.substring(0,cutoff).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO PHONE GPS";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
