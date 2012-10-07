package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DENewCastleCountyBParser extends FieldProgramParser {
  
  public DENewCastleCountyBParser() {
    super(CITY_LIST, "NEW CASTLE COUNTY", "DE",
           "CALL! NAME? ADDR/S! Cross_STS:X? EMD:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,msg@cfmsg.com";
  }

  @Override
   protected boolean parseMsg(String subject, String body, Data data) {
    
    // Drop calls from Deepwater, NJ
    if (body.contains(" Caller:")) return false;
    
    if (!subject.startsWith("Chief ALT|")) return false;
    data.strSource = subject.substring(10).trim();
    
    if (!body.startsWith("-- ")) return false;
    body = body.substring(3).trim();
    
    String[] flds1 = body.split(" -- ");
    String[] flds2 = flds1[flds1.length-1].replace("Dead - End", "Dead End").split(" - ");
    
    String[] flds = new String[flds1.length-1 + flds2.length];
    System.arraycopy(flds1, 0, flds, 0, flds1.length-1);
    System.arraycopy(flds2, 0, flds, flds1.length-1, flds2.length);
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      String next = getRelativeField(+1);
      if (!next.startsWith("Cross STS:") && !next.startsWith("EMD:")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" DE")) field = field.substring(0,field.length()-3).trim();
      super.parse(field, data);
      if (data.strCity.equalsIgnoreCase("NEW CASTLE")) data.strCity = "";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static String[] CITY_LIST = new String[]{
    "NEW CASTLE",
    
    "ARDENCROFT",
    "ARDENTOWN",
    "BELLEFONTE",
    "CLAYTON",
    "DELAWARE CITY",
    "ELSMERE",
    "MIDDLETOWN",
    "NEW CASTLE",
    "NEWARK",
    "NEWPORT",
    "ODESSA",
    "SMYRNA",
    "TOWNSEND",
    "WILMINGTON",
    "BEAR",
    "BROOKSIDE",
    "CLAYMONT",
    "COLLINS PARK",
    "CHRISTIANA",
    "EDGEMOOR",
    "GLASGOW",
    "GREENVILLE",
    "HOCKESSIN",
    "HOLLY OAK",
    "MARSHALLTON",
    "MINQUADALE",
    "MONTCHANIN",
    "NORTH STAR",
    "OGLETOWN",
    "PIKE CREEK",
    "ROCKLAND",
    "ST. GEORGES",
    "STANTON",
    "WILMINGTON MANOR",
    "WINTERTHUR",
    "WINTERSET"
  };
}


