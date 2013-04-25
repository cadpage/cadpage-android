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
  private static final Pattern CROSS_UNIT_PTN = Pattern.compile(" +([A-Z]+\\d+[A-Z]?(?: *[A-Z]+\\d+[A-Z]?)*),?$");
  
  public VALoudounCountyParser() {
    super(CITY_CODES, "LOUDOUN COUNTY", "VA",
          "CALL:CALL! ADDR/y! APT:APT! X-ST:X! UNIT BOX:BOX! ADC:MAP% FDID:ID");
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
    
    // The newer format lacks a comma between the cross street an unit fields
    // If we did not find a unit field, try splitting units off from the
    // cross street
    match = CROSS_UNIT_PTN.matcher(data.strCross);
    if (match.find()) {
      data.strUnit = match.group(1);
      data.strCross = data.strCross.substring(0,match.start());
    }
    return true;
  }
  
  public String getProgram() {
    return super.getProgram().replace(" X ", " X UNIT ") + " TIME";
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
        "CH", "Chantilly",
        "LB", "Leesburg",
        "AL", "Aldie",
        "ST", "Sterling",
        "MB", "Middleburg",
        "AB", "Ashburn",
        "SP", "Sterling",
        "BL", "Bluemont",
        "CE", "Centreville",
        "HA", "Hamilton",
        "LV", "Lovettsville",
        "PA", "Paris",
        "PV", "Purcellville",
        "PS", "Paeonian",
        "RH", "Round Hill",
        "UP", "Upperville",
        "FX19", "Fairfax",
        "FX11", "Fairfax",
        "FX", "Fairfax",
        "FQ", "Faquier"
   });
}
