package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.FieldProgramParser;



public class MDKentCountyParser extends FieldProgramParser {

  public MDKentCountyParser() {
    super("KENT COUNTY", "MD",
           "CT:ADDR/S1C! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "911@kentgov.org";
  }
}
