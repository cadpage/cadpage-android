package net.anei.cadpage.parsers.WV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Cabell County. WV
Contact: Everett Cooper <firefighterorr6@gmail.com>
Sender: dispatch@ccerc911.org

1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22225) CCERC911\nMSG:113030126/10-30-11/06:42:08/Other Fire/8160 FRAZIERS LN/LESAGE/LORENA LN/KATHI\n(Con't) 2 of 2\nLN/50YF/BLEEDING FROM A SURGICAL WOUND IN STOMACH//(End)
1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22343) CCERC911\nMSG:113030199/10-30-11/14:16:29/Structure Fire/6419 RT 60/BARBOURSVILLE/GEORGES DRY\n(Con't) 2 of 2\nCLEANERS/FARMDALE RD/MAIN ST/201 231 ENRT/237/(End)
1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22412) CCERC911\nMSG:113030260/10-30-11/16:53:24/Abdominal Pain/6430 OHIO RIVER RD APT1/LESAGE/TAN\n(Con't) 2 of 2\nZONE/DOUTHAT LN/NINE MILE RD/22YR FEMALE/27WKS PREGNANT/(End)
1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22719) CCERC911\nMSG:113040332/10-31-11/20:53:50/MVA Inj./4805 HILLVIEW DR/HUNTINGTON/OHIO RIVER\n(Con't) 2 of 2\nRD/END/ONE VEH OVER THE HILL/ ADV ABOUT 50 YARD OVER A HILL/(End)
1 of 2\nFRM:dispatch@ccerc911.org\nSUBJ:(22809) CCERC911\nMSG:113050042/11-01-11/05:35:54/MVA Inj./5315 OHIO RIVER RD BLK/HUNTINGTON/THREE MILE\n(Con't) 2 of 2\nCREEK RD/MOBILE CITY RD/TRACTOR TRAILOR / TRUCK IS ON THE TRACKS/(End)

*/
public class WVCabellCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("\\(\\d+\\) CCERC911");
  
  public WVCabellCountyParser() {
    super("CABELL COUNTY", "WV",
           "ID DATE TIME CALL ADDR CITY! PLACE? X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ccerc911.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    return parseFields(body.split("/"), data);
  }
  

  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern("\\d{9}", true);
    }
  }
  
  private class MyDateField extends DateField {
    public MyDateField() {
      setPattern("\\d\\d-\\d\\d-\\d\\d", true);
    }
  }
  
  private class MyTimeField extends TimeField {
    public MyTimeField() {
      setPattern("\\d\\d:\\d\\d:\\d\\d", true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  
}
