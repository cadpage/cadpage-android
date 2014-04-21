package net.anei.cadpage.parsers.MO;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Boone County, MO
 */
public class MOBooneCountyParser extends FieldProgramParser {
  
  public MOBooneCountyParser() {
    super(CITY_CODES, "BOONE COUNTY", "MO",
      "NEWCALL ID ADDR/y APT GPS1 GPS2 ZIP PLACE X X INFO EMPTY EMPTY CALL PRI BOX DATE TIME TIME SRC MAP INFO INFO INFO UNIT NAME NAME? EMPTY PHONE INFO+");
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {

    return super.parseFields(body.split(","), data);
  }
  
  private class MyZipCityField extends Field {
    
    public MyZipCityField() {
      super("\\d{5}|", true);
    }
  
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() == 0) {
        data.strCity = field;
      }
    }

    @Override
    public String getFieldNames() {
      return "CITY";
    }
  }  
  
  private class MyCallCodeField extends CallField {
  
    @Override
    public void parse(String field, Data data) {

      int delimitIndex = field.indexOf("-");
      if (delimitIndex >= 0) {
        
        data.strCode = field.substring(0, delimitIndex).trim();
        data.strCall = field.substring(delimitIndex + 1).trim();
      } else {
        abort();
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class MyNameField extends NameField {
    
    @Override
    public void parse(String field, Data data) {
      data.strName = append(data.strName, ", ", field);
    }
  }

  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.length() > 8) {
        if (!field.startsWith("HSD HDS:")) {
          if (!data.strSupp.startsWith(field.substring(8))) {
            super.parse(field, data);
          }
        }
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NEWCALL")) return new SkipField("NEWCALL", true);
    if (name.equals("ID")) return new IdField("\\d{9}", true);
    if (name.equals("ZIP")) return new MyZipCityField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("CALL")) return new MyCallCodeField();
    if (name.equals("PRI")) return new PriorityField("\\d", true);
    if (name.equals("SRC")) return new SourceField(".{2}|", true);
    if (name.equals("MAP")) return new MapField("((\\d{2}-\\d{2}[A-Z]?)|SP1|)", true);
    if (name.equals("NAME")) return new MyNameField();
    if (name.equals("PHONE")) return new PhoneField("(|\\d{7}(\\d{3})?|(\\d{3}-(\\d{3}-)?\\d{4}))", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AS",   "ASHLAND",
      "HB",   "HARTSBURG",
      
      "BC",   ""
     });
}
