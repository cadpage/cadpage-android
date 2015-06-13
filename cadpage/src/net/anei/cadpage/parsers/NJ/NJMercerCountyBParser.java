package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchH01Parser;


public class NJMercerCountyBParser extends DispatchH01Parser {
  public NJMercerCountyBParser() {
    super("MERCER COUNTY", "NJ",
          "SKIP? ( MARK1! Location:ADDR! Response_Type:CALL! AlarmLevel:PRI! Zone:MAP! HUNITS! UNIT/C+? CPINOTES! " +
                "| MARK2 Location:ADDR! Response_Type:CALL! AlarmLevel:PRI! Name:UNIT! ) NOTES+");
  }
  
  @Override
  public String getFilter() {
    return "@franklinmo.net";
  }
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    if (!subject.equals("Notification")) return false;
    if (!super.parseHtmlMsg(subject, body, data)) return false;
    data.strCross = data.strCross.replaceAll(" *, *", " / ");
    return true;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("MARK1")) return new SkipField("Mercer Fire IAR Rip And Run Report", true);
    if (name.equals("MARK2")) return new SkipField("Mercer Fire Fax Rip and Run", true);
    if (name.equals("HUNITS")) return new SkipField("Handling Units.*", true);
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("CPINOTES")) return new SkipField("CPI Notes.*", true);
    return super.getField(name);
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(' ', '_');
      super.parse(field, data);
    }
  }
}