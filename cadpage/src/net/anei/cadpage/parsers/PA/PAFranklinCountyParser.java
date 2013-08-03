package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Franklin County, PA
 */
public class PAFranklinCountyParser extends FieldProgramParser {
  
  public PAFranklinCountyParser() {
    this("FRANKLIN COUNTY", "PA");
  }
  
  protected PAFranklinCountyParser(String defCity, String defState) {
    super(defCity, defState,
          "ADDR UNK UNK CITY UNK UNK UNK UNK CALL UNK UNK UNK UNIT! INFO+");
  }

  @Override
  public String getAliasCode() {
    return "PAFranklinCounty";
  }

  @Override
  public String getFilter() {
    return "PageGate@franklindes.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("*")) return false;
    if (body.endsWith("*")) body = body + ' ';
    if (!parseFields(body.split("\\* "), data)) return false;
    if (data.strCity.endsWith(" BORO")) data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    return true;
  }
}
