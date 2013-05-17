package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Base class for new Suffolk County parser based on ** field separators
 */
public class NYSuffolkCountyXBaseParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*\\* ");
  
    public NYSuffolkCountyXBaseParser(String defCity, String defState, String program) {
      super(defCity, defState, program);
    }

	  @Override
	  protected boolean parseMsg(String body, Data data) {
	    if (!body.startsWith("** ")) return false;
	    body = body.substring(3).trim();
	    return parseFields(DELIM.split(body), data);
	  }
    
    private static final Pattern ID_PTN = Pattern.compile("\\d{4}-\\d{6}");
    private class BaseIdField extends IdField {
      
      private boolean allowPartial;
      
      public BaseIdField(boolean allowPartial) {
        this.allowPartial = allowPartial;
      }
      
      @Override
      public boolean checkParse(String field, Data data) {
        Matcher match = ID_PTN.matcher(field);
        if (match.matches()) {
          super.parse(field, data);
          return true;
        }
        
        // OK, this isn't valid, but we check to see if we allow
        // truncated TOA fields
        if (!allowPartial || field.length() == 0) return false;
        if (getRelativeField(+1).length() > 0) return false;
        return "NNNN-NNNNNN".startsWith(field.replaceAll("\\d", "N"));
      }
      
      @Override
      public void parse(String field, Data data) {
        if (!checkParse(field, data)) abort();
      }
    }
	  
	  private static final Pattern TOA_PTN = Pattern.compile("\\d\\d:\\d\\d \\d\\d-\\d\\d-\\d\\d");
	  private class TOAField extends TimeDateField {
	    
	    private boolean allowPartial;
	    
	    public TOAField(boolean allowPartial) {
	      this.allowPartial = allowPartial;
	    }
	    
	    @Override
	    public boolean checkParse(String field, Data data) {
	      Matcher match = TOA_PTN.matcher(field);
	      if (match.matches()) {
	        super.parse(field.replace('-', '/'), data);
	        return true;
	      }
	      
	      // OK, this isn't valid, but we check to see if we allow
	      // truncated TOA fields
	      if (!allowPartial || field.length() == 0) return false;
	      if (getRelativeField(+1).length() > 0) return false;
	      return "NN:NN NN-NN-NN".startsWith(field.replaceAll("\\d", "N"));
	    }
	    
	    @Override
	    public void parse(String field, Data data) {
	      if (!checkParse(field, data)) abort();
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("CODE")) return new CodeField("\\d{1,2}-[A-Z]-\\d{1,2}[A-Z]?", true);
      if (name.equals("ID")) return new BaseIdField(false);
      if (name.equals("IDP")) return new BaseIdField(true);
      if (name.equals("TOA")) return new TOAField(false);
      if (name.equals("TOAP")) return new TOAField(true);
      return super.getField(name);
    }
	  
	}
	