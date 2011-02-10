package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Union County, NC
Contact: David Bruce <dbruce0571@gmail.com>
Sender: CAD@uc.co.union.nc.us

CAD:5413 MONROE ANSONVILLE RD;CHEST PAIN EMD;S09;B-CF2;CLARK ST;ANSONVILLE RD;01/26/2011 05:41:48
CAD:226 S MAIN ST;GATEWOOD VILLAGE;FIRE ALARM EFD;S09;B2;HINSON ST;GOODWILL LN;01/16/2011 14:04:24
CAD:1299 WITMORE RD/OLD MONROE MARSHVILLE RD;ACCIDENT EMD;S09;B-CF2;01/21/2011 16:59:15
CAD:3344 PRESSON RD;UNION COUNTY SHERIFFS OFFICE;FALLS EMD;S09;D/ST;E HWY 74;DRIVEWAY;01/22/2011 16:53:54
CAD:5413 MONROE ANSONVILLE RD;CHEST PAIN EMD;S09;B-CF2;CLARK ST;ANSONVILLE RD;01/26/2011 05:41:48
CAD:101 GOODWILL LN;ANIMAL BITE ATTACKS EMD;S09;B-2;S MAIN ST;01/26/2011 09:13:28
CAD:100 N STEWART ST/E HWY 74;ACCIDENT EMD;S09;B-2;01/26/2011 10:25:54
CAD:210 CAMDEN STREET EXT;PREGNANCY EMD;S09;C-3;JEROME ST;01/26/2011 11:14:34
CAD:1900 WEDDINGTON RD/WAXHAW HWY;VEHICLE FIRE EFD;S16;D-ST;01/26/2011 18:17:07

*/

public class NCUnionCountyParser extends DispatchOSSIParser {
  
  public NCUnionCountyParser() {
    super("UNION COUNTY", "NC",
           "ADDR PLACE? CALL SRC! INFO X X");
  }
  
  @Override
  public String getFilter() {
    return "CAD@buncombecounty.org";
  }
  
  private static final Pattern SOURCE_PAT= Pattern.compile("S\\d\\d");
  private class MySourceField extends SourceField {
    
    public MySourceField() {
      setPattern(SOURCE_PAT);
    }
  }
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
}
