package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCWakeCountyParser extends FieldProgramParser {
  
  public NCWakeCountyParser() {
    super(CITY_CODES, "WAKE COUNTY", "NC",
           "Inc:CALL! Map:MAP! Add:ADDR! Loc:PLACE! Apt:APT! CS:X? Unt:UNIT! TG:CH! Cty:CITY! Comm:INFO INFO+");
  }
  
  @Override
  public String getFilter() {
    return "wcps@wakegov.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("WCPS")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(":")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(",", "");
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("  +", " ");
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(",")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AN",     "ANGIER",
      "WCAN",   "ANGIER",
      "AP",     "APEX",
      "WCAP",   "APEX",
      "CA",     "CARY",
      "WCCA",   "CARY",
      "WCCL",   "CLAYTON",
      "WCCR",   "CREEDMOOR",
      "WCDU",   "DURHAM",
      "FV",     "FUQUAY-VARINA",
      "WCFV",   "FUQUAY-VARINA",
      "GR",     "GARNER",
      "WCGR",   "GARNER",
      "HS",     "HOLLY SPRINGS",
      "WCHS",   "HOLLY SPRINGS",
      "KD",     "KNIGHTDALE",
      "WCKD",   "KNIGHTDALE",
      "MV",     "MORRISVILLE",
      "WCMV",   "MORRISVILLE",
      "WCNH",   "NEW HILL",
      "RA",     "RALEIGH",
      "WCRA",   "WAKE COUNTY", // "RALEIGH",
      "RDU",    "RDU",
      "RO",     "ROLESVILLE",
      "WCRO",   "ROLESVILLE",
      "WF",     "WAKE FOREST",
      "WCWF",   "WAKE FOREST",
      "WD",     "WENDELL",
      "WCWD",   "WENDELL",
      "WCWS",   "WILLOW SPRINGS",
      "WCYV",   "YOUNGSVILLE",
      "ZB",     "ZEBULON",
      "WCZB",   "ZEBULON"
  });
}
