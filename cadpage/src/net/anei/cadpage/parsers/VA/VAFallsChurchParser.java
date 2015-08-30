package net.anei.cadpage.parsers.VA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Falls Church, VA
 */

public class VAFallsChurchParser extends FieldProgramParser {  
  public VAFallsChurchParser() {
    super("FALLS CHURCH", "VA",
        "( EMPTY ( " +
                  "Loc:ADDR Box:BOX ( EMPTY Ch:MY_CH Type:INFO? | INFO )" +
               " | Box:BOX EMPTY Location:ADDR Channel:CH Info:INFO" +
               " | DISPATCH:DISP ( Unit:UNIT | Units:UNIT ) DATETIME" +
               " ) " +
       " | INFO ( EMPTY | INFO ) SKIP SKIP EMPTY Loc:ADDR Box:BOX EMPTY Ch:MY_CH" +
       " )");
    }
  
  @Override
  public String getFilter() {
    return "rwaller@arlingtonva.us";
  }

  @Override
  public String getProgram() { return append(super.getProgram(), " ", "CALL"); }

  private static final Pattern TAG_PATTERN
    = Pattern.compile("((?:Loc(?:ation)?|Box|Ch(?:annel)?|Info|DISPATCH|Units?|Type):) *", Pattern.DOTALL);
  private class Body {
    private String original,
      fixed = "";
    private Matcher mainMatcher;
    int lastPosition = 0;
    Body(String msg) {
      original = msg;
      fixMsg();
    }
    
    private void fixMsg() {
      mainMatcher = TAG_PATTERN.matcher(original);
      while (mainMatcher.find()) {
        int current = mainMatcher.start();
        copyString(current);
        fixed += "\n";
        current = mainMatcher.end();
        copyString(current);
        if (mainMatcher.group(1).equals("Box:"))
          formatBox();
      }
      copyString(original.length()-1);
      fixed = fixed.replaceAll("(?s)\\n>[^\\n]*", "");
    }
    
    private void copyString (int where) {
      fixed += original.substring(lastPosition, where);
      lastPosition = where;
    }
    
    private void formatBox() {
      int current = lastPosition;
      while (Character.isSpaceChar(original.charAt(current)) || Character.isDigit(original.charAt(current)))
        current++;
      copyString(current);
      fixed += "\n";
    }
    
    public String[] fieldArray() {
      return fixed.split("\n");
    }
  }
  
  private static final Pattern SUBJECT_PATTERN
    = Pattern.compile("(?:Re: +)?\\[.*?\\](.*)");
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher m = SUBJECT_PATTERN.matcher(subject);
    if (m.matches()) {
      data.strCall = m.group(1).trim();
    }
    else
      return false;
    Body b = new Body(body);
    return parseFields(b.fieldArray(), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("BOX")) return new BoxField("\\d{5}", true);
    if (name.equals("MY_CH")) return new MyChannelField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("DISP")) return new DispatchField();
    if (name.equals("DATETIME")) return new MyDateTimeField("Sent by admin +[A-Z][a-z]{2} (.*)", true);
    return super.getField(name);
  }
  
  private static final Pattern MY_ADDRESS_PATTERN
    = Pattern.compile("(.*)(?:\\(([^)]+)\\)|(?:and|at|&|/)(.*))");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = MY_ADDRESS_PATTERN.matcher(field);
      if (m.matches()) {
        String part2 = append(getOptGroup(m.group(2)), " ", getOptGroup(m.group(3)));
        Result r = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, part2);
        if (!r.isValid()) {
          data.strPlace = part2.trim();
          field = m.group(1);
        }
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" PLACE";
    }
  }
  
  private static final Pattern INFO_PATTERN
    = Pattern.compile("(.*\\b[A-Z]{2,3}/[A-Z]{2,3})\\b.*");
  private String stripURL(String s) {
    Matcher m = INFO_PATTERN.matcher(s);
    if (m.matches())
      s = m.group(1);
    return s;
  }  
  
  private static final Pattern MY_CHANNEL_PATTERN
    = Pattern.compile("(\\d[A-Fa-f](?: *(?:and|&|/)? *\\d *[A-Fa-f])?)\\W*(.*)");
  private class MyChannelField extends ChannelField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = MY_CHANNEL_PATTERN.matcher(field);
      if (m.matches()) {
        data.strChannel = m.group(1);
        field = m.group(2);
      }
      data.strSupp = append(stripURL(field), "/", data.strSupp);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" INFO";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      super.parse(stripURL(field), data);
    }
  }
  
  private class DispatchField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String[] f = field.split(",");
      data.strBox = f[1].trim();
      parseAddress(f[2], data);
      for (int i=3; i<f.length; i++) {
        f[i] = f[i].trim();
        if (f[i].startsWith("Unit:"))
          data.strUnit = f[i].substring(5);
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" BOX UNIT";
    }
  }
  
  private static final DateFormat MY_DATE_FMT
    = new SimpleDateFormat("MMM dd hh:mm:ss yyyy");
  private class MyDateTimeField extends DateTimeField {
    public MyDateTimeField(String p, boolean h) {
      super(p, h);
    }
    
    @Override
    public void parse (String field, Data data) {
      setDateTime(MY_DATE_FMT, field, data);
    }
  }
 }
