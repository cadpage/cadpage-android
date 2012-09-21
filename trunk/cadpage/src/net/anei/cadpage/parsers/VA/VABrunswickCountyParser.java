package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Brunswick County, VA
Contact: "Howell, Dennis" <Dennis.Howell@gerdau.com>
Sender: bcso_dispatch@verizon.net
System: Shieldware

Subject:BCSO CFS Info - DO NOT REPLY\n11-019210 BREATHING DIFFICULTY \n493 BROOKS CROSSING \nGRIFFITH LN / LOBLOL/LY DR \nLAWRENCEVILLE
Subject:BCSO CFS Info - DO NOT REPLY\n11-019305 CHEST PAIN/HEART PROBLEM \n1562 GREENS CHAPEL RD \nMEREDITH MILL RD / G/RNADY RD \nBRODNA
Subject:BCSO CFS Info - DO NOT REPLY\n11-019164 MOTOR VEHICLE CRASH \n1634-BLK LAWRENCEVILLE PLANK RD \nPOOR HOUSE RD / BRUNSWICK COMMONS DR
Subject:BCSO CFS Info - DO NOT REPLY\n11-019197 STROKE \n1722 LAWRENCEVILLE PLANK RD \nPOOR HOUSE RD / BRUN/SWICK COMMONS CT \nENVOY HEAL
Subject:BCSO CFS Info - DO NOT REPLY\n11-019208 UNCONSC/UNRESPONSIVE/SYNCOPE \n1904 LAWRENCEVILLE PLANK RD \nBRUNSWICK COMMONS CT// PLAN
Subject:BCSO CFS Info - DO NOT REPLY\n11-019129 STRUCTURE FIRE \n4151 POOR HOUSE RD \nPINEY WOODS RD / DIG/UARDI DR \nJOHNSON GROVE RZUA
Subject:BCSO CFS Info - DO NOT REPLY\n11-019208 UNCONSC/UNRESPONSIVE/SYNCOPE \n1904 LAWRENCEVILLE PLANK RD \nBRUNSWICK COMMONS CT// PLAN
Subject:BCSO CFS Info - DO NOT REPLY\n11-019310 SEIZURES \n18597 CHRISTANNA HWY \nFOX LN / GREEN ACRES/RD \nLAWRENCEVILLE \n7FR 900

 */


public class VABrunswickCountyParser extends FieldProgramParser {
    
  
  public VABrunswickCountyParser() {
    super("BRUNSWICK COUNTY", "VA",
           "IDCALL ADDR! X! CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "bcso_dispatch@verizon.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("BCSO CFS Info - DO NOT REPLY")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyIdCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strCallId = field.substring(0,pt);
      data.strCall = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      data.strCity = expandCity(field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("IDCALL")) return new MyIdCallField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  /*
   * Expand a possibly truncated city name to full city name
   */
  private static String expandCity(String city) {
    for (String cty : CITY_LIST) {
      if (cty.startsWith(city)) return cty;
    }
    return "";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALBERTA",
    "BRODNAX",
    "LAWRENCEVILLE"
  };
}
