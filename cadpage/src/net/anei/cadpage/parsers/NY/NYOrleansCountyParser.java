package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Orleans County, NY 
Contact: Wayne Litchfield <LitchfieldW@orleansny.com>
Sender: ocdispatch@orleansny.com
System: EM Systems

Three character township codes use are...
VAL TAL, BAR TGN ARE ALBION,NY 14411
VLD YAT ARE LYNDONVILLE,NY 14098
VMD TRW TSH ARE MEDINA,NY 14103
VHL TMR TCL ARE HOLLEY,NY 14470
TKN IS KENDALL,NY 14476

BREATHING PROBLEMS; 231 CHAMBERLAIN ST VAL; 17yom t/b    6-c-1; TEST FROM ORLEANS
CARDIAC/RESPIRATORY ARREST; 16044 GLIDDEN RD TCL; 61 YOM UNATTENDED /COLD  IN WARM ENVIRNMENT JOHN SMITH   
FALLS; 1794 OAK ORCHARD RD TCR; 49 yom fell out of tub difficulty breathing   17d4  PRI 1
BREATHING PROBLEMS; 126 E BANK ST VAL; 76 yom B/P SWEATS DIZZY  6D4  PRI 1;
HEART PROBLEMS/AICD; 15140 RIDGE RD TGN; 50 YOM RAPID HEART 180 BPS ; PRI 1 19c4;
TRAFFIC/TRANSPORTATION INCIDENTS; 14681 RIDGE RD TGN; REPORTED 2 CAR MINOR INJ MVA   29-B-1;
SICK PERSON; 1579 E KENT RD TCR; 75 yom cathater removed pain PRI 3;

Contact: "medinafire6@verizon.net" <medinafire6@verizon.net>
Contact: "jeffelsenheimer@yahoo.com" <jeffelsenheimer@yahoo.com>
(FrmFireCntrl1) TRAUMATIC INJURIES; HIP INH 10741 LAKESHORE FL41A RD TYA;LYNDONVILLE EMS MEDINA AMB PR-3
(FrmFireCntrl3) ALS ONLY RESPONSE; 4540 LINCOLN DR TGP; 58 yof trouble  breathing, decreased level of consciousness 6-d-1
(FrmFireCntrl 2) HEART PROBLEMS/AICD; 12469 LAKESHORE FL44 RD TYA; 80 yof high BP & pulse 19-c-6
(FrmFireCntrl1) ALS ONLY RESPONSE; 28 MAIN ST MDL; MEDINA ALS 83 YOF ABDOMINAL PAIN
(FrmFireCntrl3) ACCIDENT VEH PDO; 1355 YATES CARLTON TL RD TCR; ATV ROLLOVER, NO PT FOUND COVA/CAFD

*/

public class NYOrleansCountyParser extends SmsMsgParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "VAL", "ALBION", 
      "TAL", "ALBION", 
      "BAR", "ALBION", 
      "TGN", "ALBION", 
      "TCR", "CARLTON",
      "VLD", "LYNDONVILLE", 
      "YAT", "LYNDONVILLE",
      "VMD", "MEDINA", 
      "TRW", "MEDINA", 
      "TSH", "MEDINA",
      "VHL", "HOLLEY", 
      "TMR", "HOLLEY", 
      "TCL", "HOLLEY",
      "TKN", "KENDALL", 
      "TGP", "GASPORT",  
      "TYA", "YATES",
      "MDL", "MIDDLEPORT"
  });
  
  private static final Pattern CODE_PATTERN = Pattern.compile("\\b\\d{1,2}-?[A-Za-z]-?\\d\\b");
  
  public NYOrleansCountyParser() {
    super("ORLEANS COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "ocdispatch@orleansny.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    String[] flds = body.split(";");
    data.strCall = flds[0].trim();
    
    if (flds.length <= 1) return false;
    String fld = flds[1].trim();
    int pt = fld.lastIndexOf(' ');
    if (pt < 0) return false;
    parseAddress(fld.substring(0,pt), data);
    data.strCity = CITY_CODES.getProperty(fld.substring(pt+1));
    if (data.strCity == null) return false;
    
    // Anything else is extra info
    for (int ndx = 2; ndx < flds.length; ndx++) {
      fld = flds[ndx].trim();
      if (fld.length() == 0) continue;
      data.strSupp = append(data.strSupp, " / ", fld);
    }
    
    // There might be a type code buried in there, see if we can find it
    Matcher match = CODE_PATTERN.matcher(data.strSupp);
    if (match.find()) {
      data.strCode = data.strSupp.substring(match.start(), match.end());
      String part1 = data.strSupp.substring(0, match.start()).trim();
      String part2 = data.strSupp.substring(match.end()).trim();
      if (part2.length() == 0) data.strSupp = part1;
      else if (part1.length() == 0) data.strSupp = part2;
      else data.strSupp = part1 + " " + part2;
    }
    return true;
  }
}
