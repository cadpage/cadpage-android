package net.anei.cadpage.parsers.OR;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ORMarionCountyNParser extends FieldProgramParser {
  
  private static final Pattern CALL_ID_PTN = Pattern.compile("\\d{1,5}");
  private static final Pattern LEAD_PTN = Pattern.compile("^: *[/)\\|] *");
  private static final Pattern TIME_PTN = Pattern.compile("\\b(\\d{1,2}):(\\d{1,2}):(\\d{1,2})\\b");
  private static final Pattern GPS_PTN = Pattern.compile("\\bLAT: *([+-]?[\\d.]+), *LON: *([+-]?[\\d.]+)\\b");
  
  public ORMarionCountyNParser() {
    super(CITY_LIST, "MARION COUNTY", "OR",
           "CALL ( ADDRCITY ( DUPADDR | CITY | PLACE ) X MAP UNIT! INFO+? DATETIME | ADDR1 ADDR1 ADDR1 ADDR1 ( CITY | APT ) ADDR2 ADDR2 ADDR2  MAP UNIT! INFO DATE TIME )");
  }
  
  private String address[] = new String[2];
  
  @Override
  public String getFilter() {
    return "@ci.woodburn.or.us,600500";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.startsWith("(")) subject = new Parser(subject.substring(1).trim()).get(')');
    if (CALL_ID_PTN.matcher(subject).matches()) data.strCallId = subject;

    Matcher match = LEAD_PTN.matcher(body);
    if (match.find()) body = body.substring(match.end());
    
    // Time field has to be protected from being broken up by colon field separators
    body = TIME_PTN.matcher(body).replaceAll("$1-$2-$3");
    
    // As does a GPS address field
    body = GPS_PTN.matcher(body).replaceAll("$1,$2");
    
    address[0] = address[1] = "";
    if (! parseFields(body.split(":"), 6, data)) return false;
    
    if (data.strAddress.length() == 0) {
      int pt = address[0].indexOf(',');
      if (pt >= 0) {
        data.strCity = address[0].substring(0,pt).trim();
        address[0] = address[0].substring(0,pt).trim();
      }
      parseAddress(append(address[0], " & ", address[1]), data);
    }
    return true;
  }
  
  private static final Pattern ALPHA_PTN = Pattern.compile("[A-Z]");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // This field can be a number of different things depending on whether or not it
      // contains a comma and/or an upper case alpha character
      field = field.replace('@', '&');
      boolean hasComma = field.contains(",");
      boolean hasAlpha = ALPHA_PTN.matcher(field).find();
      
      // Fields with Alpha characters are more or less normal
      if (hasAlpha) {
        
        // If it has a comma it is a normal address, city field
        if (hasComma) {
          super.parse(field, data);
        } 
        
        // If not, it is a plain address field
        else {
          parseAddress(field, data);
        }
      }

      // Fields without alpha characters are wierd
      else {
        
        // If it has a comma, it is GPS location and just goes in the address field
        if (hasComma) {
          data.strAddress = field;
        }
        
        // If not, it is the start of an old style address where the address is broken into
        // four separate fields, the first of which contains the house number or is empty
        // This is the only time we fail so we can take the split address branch
        else return false;
      }
      return true;
    }
  }
  
  // SOmetimes, what should be the city or apt field contains a duplicate of the
  // previous address field
  private class MyDupAddressField extends SkipField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      return field.equals(getRelativeField(-1));
    }
  }
  
  private class MyAddressField extends AddressField {
    
    private int index;
    
    public MyAddressField(int index) {
      this.index = index;
    }
    
    @Override
    public void parse(String fld, Data data) {
      address[index] = append(address[index], " ", fld); 
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String fld, Data data) {
      if (fld.endsWith(",")) fld = fld.substring(0,fld.length()-1);
      super.parse(fld, data);
    }
  }
  
  private static final Pattern DATE_PTN = Pattern.compile("\\d{8}");
  private class MyDateField extends DateField {
    @Override public void parse(String field, Data data) {
      if (!DATE_PTN.matcher(field).matches()) return;
      data.strDate = field.substring(4,6) + "/" + field.substring(6,8) + "/" + field.substring(0,4);
    }
  }
  
  private static final Pattern TIME2_PTN = Pattern.compile("\\d{6}");
  private class MyTimeField extends TimeField {
    @Override public void parse(String field, Data data) {
      if (!TIME2_PTN.matcher(field).matches()) return;
      data.strTime = field.substring(0,2) + ":" + field.substring(2,4) + ":" + field.substring(4,6);
    }
  }

  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh-mm-ss aa"); 
  private class MyDateTimeField extends DateTimeField {
    public MyDateTimeField() {
      super("\\d{1,2}/\\d{1,2}/\\d{4}\\b.*");
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      setDateTime(DATE_TIME_FMT, field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      checkParse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DUPADDR")) return new MyDupAddressField();
    if (name.equals("ADDR1")) return new MyAddressField(0);
    if (name.equals("ADDR2")) return new MyAddressField(1);
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    "AUMSVILLE",
    "AURORA",
    "DETROIT",
    "DONALD",
    "GATES",
    "GERVAIS",
    "HUBBARD",
    "IDANHA",
    "JEFFERSON",
    "KEIZER",
    "MOUNT ANGEL",
    "ST PAUL",
    "SALEM",
    "SCOTTS MILLS",
    "SILVERTON",
    "STAYTON",
    "SUBLIMITY",
    "TURNER",
    "WOODBURN",
    
    "BREITENBUSH",
    "BROOKS",
    "BUTTEVILLE",
    "CHAMPOEG",
    "FOUR CORNERS",
    "HAYESVILLE",
    "LABISH VILLAGE",
    "MARION",
    "MEHAMA",
    "MONITOR",
    "PRATUM",
    "SAINT BENEDICT",
    "SAINT LOUIS",
    "WACONDA",
    "WEST STAYTON",

    "LYONS",
    
    "WILSONVILLE",
    
    "CLACKAMAS COUNTY",
    "MARION COUNTY",
    "LINN COUNTY"
  };
}
