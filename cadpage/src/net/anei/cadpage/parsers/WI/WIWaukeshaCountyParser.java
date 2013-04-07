package net.anei.cadpage.parsers.WI;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Waukesha County, WI
 */
public class WIWaukeshaCountyParser extends FieldProgramParser {
  
  public WIWaukeshaCountyParser() {
    super(CITY_CODES, "WAUKESHA COUNTY", "WI",
           "Location:ADDR/S! TYPE_CODE:CALL! TYPE_CODE:CALL! TIME:TIME%");
  }
  
  @Override
  public String getFilter() {
    return "@iaralerts.com";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional(": @");
      data.strApt = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT PLACE";
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ASHP_T", "ASHIPPUN",
      "BGBD_V", "BIG BEND",
      "BRKF_C", "BROOKFIELD",
      "BRKF_T", "BROOKFIELD",
      "BUTL_V", "BUTLER",
      "CHEN_V", "CHENEQUA",
      "DELA_C", "DELAFIELD",
      "DELA_T", "DELAFIELD",
      "DOUS_V", "DOUSMAN",
      "EAGL_T", "EAGLE",
      "ELMG_V", "ELM GROVE",
      "GENS_T", "GENESSEE DEPOT",
      "HART_V", "HARTLAND",
      "LANN_V", "LANNON",
      "LISB_T", "LISBON",
      "MEFL_V", "MENOMONEE FALLS",
      "MERT_T", "MERTON",
      "MERT_V", "MERTON",
      "MILWCO", "MILWAUKEE COUNTY",
      "MUKW_T", "MUKWONAGO",
      "MUKW_V", "MUKWONAGO",
      "MUSK_C", "MUSKEGO",
      "NASH_V", "NASHOTAH",
      "NBRL_C", "NEW BERLIN",
      "NRPR_V", "NORTH PRAIRIE",
      "OCOL_V", "OCONOMOWOC LAKE",
      "OCON_C", "OCONOMOWOC",
      "OCON_T", "OCONOMOWOC",
      "OTTW_T", "OTTAWA",
      "PWKE_C", "PEWAUKEE",
      "PWKE_V", "PEWAUKEE",
      "RICH_V", "RICHFIELD",
      "SUMM_V", "SUMMIT",
      "SUSX_V", "SUSSEX",
      "VERN_T", "VERNON",
      "WALE_V", "WALES",
      "WAUK_C", "WAUKESHA",
      "WAUK_T", "WAUKESHA",
      "WAUW_C", "WAUWATOSA"

  });
}