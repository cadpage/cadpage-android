package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

  public class CAKernCountyParser extends FieldProgramParser {

    public CAKernCountyParser() {
      super(CITY_CODES, "KERN COUNTY", "CA", 
            "Loc:ADDR! EID:ID! CALLER_NAME:NAME! TIME:TIME! Disp:UNIT!");
    }
    
    @Override
    public String getFilter() {
      return "kerncad@kernsheriff.com";
    }
    
    @Override
    public boolean parseMsg(String subject, String body, Data data) {
      do {
        
        if(body.startsWith("CAD one-way SMS page")) {
          body = body.substring(20).trim();
          break;
        }
        
        if (subject.equals("CAD one-way SMS page")) break;
        
        return false;
      } while (false);
      return parseMsg(body, data);
    }

    @Override
    public Field getField(String name) {
      if (name.equals("ADDR")) return new MyAddressField();
      return super.getField(name);
    }
    
    private class MyAddressField extends AddressField {
      @Override
      public void parse(String field, Data data) {
        //parse out place before handing field to parseAddress
        int i = field.indexOf(":");
        if (i != -1) {
          data.strPlace = stripFieldStart(field.substring(i+1).trim(), "@");
          field = field.substring(0, i).trim();
        } 
        
        parseAddress(StartType.START_ADDR, field, data);
        data.strApt = append(data.strApt, "-", getLeft());
      }

      @Override
      public String getFieldNames() {
        return super.getFieldNames() + " PLACE";
      }
    }

    private static final Properties CITY_CODES = buildCodeTable(new String[]{
        "BAK", "BAKERSFIELD",
        "DEL", "DELANO",
        "INY", "INYOKERN",
        "KC",  "KERN COUNTY",
        "MCF", "MCFARLAND",
    });

  }
