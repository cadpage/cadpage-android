package net.anei.cadpage.parsers.NC;

public class NCDavidsonCountyAParser extends NCGuilfordCountyParser {

  public NCDavidsonCountyAParser() {
    super("DAVIDSON COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "cad@davidsoncountync.gov";
  }
}
