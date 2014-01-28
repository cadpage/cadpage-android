package net.anei.cadpage.parsers.VA;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class VALoudounCountyParser extends FieldProgramParser {
  
  private static final Pattern MISSING_COMMA_PTN = Pattern.compile("(?<!,) (?=APT:|X-ST:|BOX:|ADC:|FDID:)");
  private static final Pattern TRAILER_PTN = Pattern.compile(" +(?:(\\d\\d?:\\d\\d? +[AP]M)|\\[\\d*\\]?)$");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm aa");
  public VALoudounCountyParser() {
    super("LOUDOUN COUNTY", "VA",
          "CALL:CALL! ADDR/y! APT:APT! X-ST:X! UNIT BOX:BOX% ADC:MAP% FDID:ID");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Strip off trailing disclaimer
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // There are two different related formats, upshifting the text string
    // does a lot to  merge them into a common form
    body = body.toUpperCase();
    
    // So does adding missing comma delimiters
    // A simple replaceAll doesn't seem to work with lookahead and lookbehind groups :(
    StringBuffer sb = new StringBuffer();
    Matcher match = MISSING_COMMA_PTN.matcher(body);
    while (match.find()) match.appendReplacement(sb, ",");
    match.appendTail(sb);
    body = sb.toString();
    
    // strip off trailing time or sequence number
    match = TRAILER_PTN.matcher(body);
    if (match.find()) {
      String time = match.group(1);
      if (time != null) setTime(TIME_FMT, time, data);
      body = body.substring(0,match.start());
    }

    // Invoke the main parser
    if (! super.parseFields(body.split(","), data)) return false;
    parseCityCode(data.strCity, data);
    if (data.strCity.length() == 0 && data.strBox.length() >= 2) {
      parseCityCode(data.strBox, data);
    }
    return true;
  }
  
  private void parseCityCode(String code, Data data) {
    if (code.length() >= 2) {
      String city = convertCodes(code.substring(0,2), CITY_CODES);
      if (city != null) {
        int pt = city.indexOf('/');
        if (pt >= 0) {
          data.strState = city.substring(pt+1);
          city = city.substring(0,pt);
        }
        data.strCity = city;
      }
    }
  }
  
  public String getProgram() {
    return super.getProgram().replace("X", "X UNIT").replace("CITY", "CITY ST") + " TIME";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Pattern CALL_CODE_PTN = Pattern.compile("^([A-Z0-9]+)-");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher  match = CALL_CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private static final Pattern CROSS_UNIT_PTN = Pattern.compile("(?:(?: +|^)(?:[A-Z]+\\d+[A-Z]?|CODE|EC|ACO?))+(?: A)?,?$");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      
      // The newer format lacks a comma between the cross street an unit fields
      // If we did not find a unit field, try splitting units off from the
      // cross street
      Matcher match = CROSS_UNIT_PTN.matcher(field);
      if (match.find()) {
        data.strUnit = match.group().trim();
        field = field.substring(0,match.start());
      }
      
      // Sometimes there is an & separator, and sometimes there is not.
      if (field.contains("&")) {
        super.parse(field, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field, data);
        data.strCross = append(data.strCross, " & ", getLeft());
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X UNIT";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AB", "ASHBURN",
      "AL", "ALDIE",
      "BL", "BLUEMONT",
      "CE", "CENTREVILLE",
      "CH", "CHANTILLY",
      "HA", "HAMILTON",
      "LB", "LEESBURG",
      "LV", "LOVETTSVILLE",
      "MB", "MIDDLEBURG",
      "PA", "PARIS",
      "PS", "PAEONIAN",
      "PV", "PURCELLVILLE",
      "SP", "STERLING",
      "ST", "STERLING",
      "RH", "ROUND HILL",
      "UP", "UPPERVILLE",

      "FX19", "FAIRFAX",
      "FX11", "FAIRFAX",
      
      "DU", "DULLES AIRPORT",
      "FQ", "FAUQUIER COUNTY",
      "FR", "FREDERICK COUNTY/MD",
      "FX", "FAIRFAX COUNTY",
      "JE", "JEFFERSON COUNTY/WV",
      "PW", "PRINCE WILLIAM COUNTY",
      "WA", "WASHINGTON COUNTY/MD"

   });
}
