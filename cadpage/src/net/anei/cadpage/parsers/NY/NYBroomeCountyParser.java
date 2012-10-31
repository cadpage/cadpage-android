package net.anei.cadpage.parsers.NY;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYBroomeCountyParser extends FieldProgramParser {
  
  private static Pattern PREFIX = Pattern.compile("^\\.{4} \\(.*?\\) ");
  private static Pattern LEADER = Pattern.compile("^([A-Z0-9/]+)[\\-:]");
  private static Pattern TRAILER = Pattern.compile(" V/Endicott? *$");
  private static Pattern KEYWORD_PAT = Pattern.compile(" (|Cross Sts|Caller|Phone):");
  private static Pattern DATE_TIME_PAT = Pattern.compile(" \\d\\d:\\d\\d \\d\\d/\\d\\d/\\d{4} ");
  private static Pattern TRAIL_COMMA_PAT = Pattern.compile("[ ,]+$");
    
    public NYBroomeCountyParser() {
      super("BROOME COUNTY", "NY",
             "SRC CALL ADDR/SXP! INFO+ Cross_Sts:X Caller:NAME Phone:PHONE");
    }
    
    @Override
    public String getFilter() {
      return "messaging@iamresponding.com,mplus@co.broome.ny.us";
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    body = body.trim().replaceAll("  +", " ");
	    Matcher match = PREFIX.matcher(body);
	    if (match.find()) body = body.substring(match.end()).trim();
	    match = TRAILER.matcher(body);
	    if (match.find()) body = body.substring(0,match.start()).trim();

	    // Fix up leading field separator
	    if (body.startsWith(")")) body = body.substring(1).trim();
	    body = LEADER.matcher(body).replaceFirst("$1 :");
	    
	    // Using a colon as both a field separator and a keyword indicator makes life complicated :(
	    List<String>fldList = new ArrayList<String>();
	    match = KEYWORD_PAT.matcher(body);
	    int st = 0;
	    while (match.find()) {
	      int end = match.start();
	      if (end > st) fldList.add(body.substring(st, end).trim());
	      st = end+1;
	      end = match.end();
	      if (end == st + 1) st = end;
	    }
	    int end = body.length();
      if (end > st) fldList.add(body.substring(st, end).trim());
      String[] flds = fldList.toArray(new String[fldList.size()]);
	    
	    return parseFields(flds, data);
	  }
	  
	  // Source code must be 2 digits or COMM
	  private class MySourceField extends SourceField {
	    public MySourceField() {
	      setPattern(Pattern.compile("[0-9/]+|COMM"), true);
	    }
	  }

	  // Cross street field needs to parse time, date, and ID data from field
	  private class MyCrossField extends CrossField {

      @Override
      public void parse(String field, Data data) {
        Matcher match = DATE_TIME_PAT.matcher(field);
        if (match.find()) {
          data.strCallId = field.substring(match.end()).trim();
          field = field.substring(0, match.start()).trim();
        }
        super.parse(field, data);
      }

      @Override
      public String getFieldNames() {
        return "X ID";
      }
	  }
	  
	  // Name field needs to remove trailing commas
	  private class MyNameField extends NameField {

      @Override
      public void parse(String field, Data data) {
        
        Matcher match = TRAIL_COMMA_PAT.matcher(field);
        if (match.find()) {
          field = field.substring(0, match.start());
        }
        super.parse(field, data);
      }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("SRC")) return new MySourceField();
      if (name.equals("X")) return new MyCrossField();
      if (name.equals("NAME")) return new MyNameField();
      return super.getField(name);
    }
	  
	}
	