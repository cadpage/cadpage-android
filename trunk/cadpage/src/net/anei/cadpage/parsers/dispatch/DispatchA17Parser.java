package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA17Parser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_MARKER = Pattern.compile("\nCall Closed *:(?!00/00/0000 00:00:00)");
  private static final Pattern COMPRESSED_FMT_MARKER = Pattern.compile("^CAD Incident:.* ESN ");
  
  private String selValue;
  
  public DispatchA17Parser(String defCity, String defState) {
    super(defCity, defState,
           "CAD_Incident:ID! " + 
              "( SELECT/1 Phone:PHONE! Name:NAME! Address:ADDR! Community:CITY! ESN:UNIT! Jurisdctn:INFO! Lo_Cross:X! Hi_Cross:X! Location_Info:PLACE PLACE CAD_Times:CALL! | " + 
              "ESN:UNIT! Phone:PHONE! Name:NAME! Address:ADDR! Community:CITY! Jurisdctn:INFO! Lo_Cross:X! Hi_Cross:X! Location_Info:PLACE PLACE CAD_Call_Times:CALL! ) " +
           "Call_Dispatch_Time:TIME! Grid:MAP Place_Information:PLACE PLACE");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.leelanau.mi.us";
  }
  
  @Override
  protected String getSelectValue() {
    return selValue;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (RUN_REPORT_MARKER.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    selValue = "1";
    if (COMPRESSED_FMT_MARKER.matcher(body).find()) {
      selValue = "2";
      body = reformat(body);
      body = body.replace("[Place Information]", "Place Information:");
    }
    
    body = body.replace(" Grid:", "\nGrid:");
    return parseFields(body.split("\n"), data);
  }
  
  private static final Pattern PHONE_XXX_PTN = Pattern.compile("X{3,}-X{4}");
  private class MyPhoneField extends PhoneField {
    @Override
    public void parse(String field, Data data) {
      if (PHONE_XXX_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern NAME_XXX_PTN = Pattern.compile("X{5,}");
  private class MyNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      if (NAME_XXX_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" VLG")) field = field.substring(0,field.length()-4).trim();
      super.parse(field, data);
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) field = field.substring(0,pt);
      super.parse(field, data);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (data.strPlace.length() > 0 && !data.strPlace.endsWith(" NWBS") || field.startsWith("....")) return;
      super.parse(field, data);
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" ", "");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PHONE")) return new MyPhoneField();
    if (name.equals("NAME")) return new MyNameField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String sAddr) {
    return MNN_PTN.matcher(sAddr).replaceAll("MI $1");
  }
  private static final Pattern MNN_PTN = Pattern.compile("M(\\d+)", Pattern.CASE_INSENSITIVE);
  
  private static String reformat(String body) {
    StringBuilder sb = new StringBuilder();
    String[] lines = body.split("\n");
    boolean split = true;
    for (int ndx = 0; ndx < lines.length; ndx++) {
      String line = lines[ndx];
      
      if (split) {
        if (line.startsWith("Caller Address:") || line.startsWith("......")) split = false;
      } else {
        if (line.startsWith("Call Created :")) split = true;
      }
      
      if (split) {
        if (line.startsWith("Call ") && line.length() < 47 && ++ndx < lines.length) {
          line = line + lines[ndx];
        }
        if (line.startsWith("Call Closed ")) split = false;
        if (line.length() > 40) {
          sb.append(line.substring(0,40).trim());
          sb.append('\n');
          line = line.substring(40);
        }
      }
      sb.append(line.trim());
      sb.append('\n');
    }
    return sb.toString();
  }
}
