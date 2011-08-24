package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Tioga County, PA
Contact: Nick Hults <hultsnm11@gmail.com>
"Dave Cohick" <dcohick@tiogacountypa.us> (Director of Emergancy Serivces)
Sender: 8145582634

TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687
TC911:MVA >MOTOR VEHICLE ACCIDENT PITTS RD XS: CANOE CAMP CREEK RD RICHMOND TWP BRANT MAXWELL Map: Grids:, Cad: 2011-0000020573
TC911:26A >SICK - NO SYMPTOMS 51 SOUTH MAIN ST MANSFIELD BORO CHERLY BLOOM Cad: 2011-0000020561
TC911:MED >MEDICAL 37 CENTRAL AVE XS: WALNUT ST WELLSBORO BORO GREEN HOME INC Map: Grids:, Cad: 2011-0000020394
TC911:6D >BREATHING PROBLEMS / SEVERE 1883 SHUMWAY HILL RD XS: ROUTE 6 CHARLESTON TWP BROAD ACRS HLTH/REHAB423 Map: Grids:, Cad: 2011-0000020675TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687
TC911:12B >SEIZURES - NOT CURRENT NOT VER 2146 S MAIN ST XS: RICHMOND DR RICHMOND TWP GOODRICH RESIDENCE Map: Grids:, Cad: 2011-0000020612
TC911:30D >TRAUMATIC INJ - DANGEROUS 312 BRADFORD RD XS: ROUTE 6 SULLIVAN TWP JOYCE R BRADFORD-ROBERT Map: Grids:, Cad: 2011-0000020081
TC911:10D >CHEST PAIN - SEVERE SOB 55 BENEDICT LN XS: BENSON AVE ROSEVILLE BORO JAMIE KIRK Map: Grids:, Cad: 2011-0000020564
TC911:MED >MEDICAL 100 SHERWOOD MNR Apt: 219 Bldg XS: NOVELTY PL MANSFIELD BORO FORD, VIRGINIA Map: Grids:, Cad: 2011-0000020827

*/

public class PATiogaCountyParser extends DispatchBParser {

  public PATiogaCountyParser() {
    super(CITY_LIST, "TIOGA COUNTY", "PA");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("TC911:");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0, data.strCity.length()-5).trim();
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BLOSSBURG BORO",
    "ELKLAND BORO",
    "KNOXVILLE BORO",
    "LAWRENCEVILLE BORO",
    "LIBERTY BORO",
    "MANSFIELD BORO",
    "ROSEVILLE BORO",
    "TIOGA BORO",
    "WELLSBORO BORO",
    "WESTFIELD BORO",

    "BLOSS TWP",
    "BROOKFIELD TWP",
    "CHARLESTON TWP",
    "CHATHAM TWP",
    "CLYMER TWP",
    "COVINGTON TWP",
    "DEERFIELD TWP",
    "DELMAR TWP",
    "DUNCAN TWP",
    "ELK TWP",
    "FARMINGTON TWP",
    "GAINES TWP",
    "HAMILTON TWP",
    "JACKSON TWP",
    "LAWRENCE TWP",
    "LIBERTY TWP",
    "MIDDLEBURY TWP",
    "MORRIS TWP",
    "NELSON TWP",
    "OSCEOLA TWP",
    "PUTNAM TWP",
    "RICHMOND TWP",
    "RUTLAND TWP",
    "SHIPPEN TWP",
    "SULLIVAN TWP",
    "TIOGA TWP",
    "UNION TWP",
    "WARD TWP",
    "WESTFIELD TWP"
  };
}
