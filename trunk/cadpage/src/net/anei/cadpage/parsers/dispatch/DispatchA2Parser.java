package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA2Parser extends FieldProgramParser {
    
    public DispatchA2Parser(String defCity, String defState) {
      super(defCity, defState,
             "CALL PLACE ADDR SRCX? TIME? INFO+");
    }

	  @Override
	  protected boolean parseMsg(String subject, String body, Data data) {
	    
	    if (!subject.equals("911 EVENT")) return false;
	    
	    int ipt = body.indexOf("\nDisclaimer:");
	    if (ipt >= 0) body = body.substring(0,ipt).trim();
	    
	    if (!parseFields(body.split("\\|"), data)) return false;
	    if (data.strAddress.length() == 0) {
	      parseAddress(data.strCross, data);
	      data.strCross = "";
	    }
	    return true;
	  }

	  // Address field may contains Address, station, and cross steet info
	  private class BaseAddressField extends AddressField {

      @Override
      public void parse(String field, Data data) {
        int pt = field.lastIndexOf(',');
        if (pt >= 0) {
          parseAddress(field.substring(0,pt).trim(), data);
          data.strCity = field.substring(pt+1).trim();
        } else {
          Parser p = new Parser(" " + field + " ");
          parseAddress(p.get(" STA "), data);
          data.strSource = p.get(" XS ");
          data.strCross = p.get();
        }
      }

      @Override
      public String getFieldNames() {
        return super.getFieldNames() + " SRC X CITY";
      }
	  }
	  
	  private class BaseSourceCrossField extends Field {
	    
	    @Override
	    public boolean canFail() {
	      return true;
	    }
	    
	    @Override
	    public boolean checkParse(String field, Data data) {
	      if (!field.startsWith("STA ")) return false;
	      Parser p = new Parser(field.substring(4).trim() + " ");
	      data.strSource =p.get(" XS ");
	      data.strCross = p.get();
	      return true;
	    }

      @Override
      public void parse(String field, Data data) {
        if (!checkParse(field, data)) abort();
      }

      @Override
      public String getFieldNames() {
        return "SRC X";
      }
	  }

	  private class BaseInfoField extends InfoField {
	    @Override
	    public void parse(String field, Data data) {
	      if (field.equals("NARR")) return;
	      if (field.startsWith("NARR ")) field = field.substring(5).trim();
	      super.parse(field, data);
	    }
	  }

    @Override
    protected Field getField(String name) {
      if (name.equals("ADDR")) return new BaseAddressField();
      if (name.equals("SRCX")) return new BaseSourceCrossField();
      if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d");
      if (name.equals("INFO")) return new BaseInfoField();
      return super.getField(name);
    }
	  
	}
	