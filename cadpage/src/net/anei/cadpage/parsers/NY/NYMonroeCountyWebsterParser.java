package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA7BaseParser;

/*
Monroe County, NY (Webster) 
Contact: Matt Micsak <wfd316@gmail.com>
Sender: paging@rednmxcad.com
System: Red Alert

L: 701 AUDLEY END\nT: STRUCTURE FIRE\nO: \nB: \nC1: FINCHINGFIELD LA\nC2: WOODBRIDGE LA\nX: PLASTIC CONTAINER CAUGHT FIRE ON STOVE..COMP SAYS THAT CONTAINER IS SMOLD
L: 286 PHILLIPS RD\nT: AUTOMATIC FIRE ALARM\nO: SMELTER RES - 265451\nB:\nC1: N CHIGWELL LA\nC2: MEADOW BREEZE LA\nX: FIRE ALRM ,GEN, C/C - ONLY CORNER STREET ALRM
L: 736 BLUE CREEK DR\nT: AUTOMATIC FIRE ALARM\nO: FRANCO RESIDENCE\nB:\nC1: JOHN GLENN BL\nC2: LITHUANICA LA\nX: FIRE ALRM--SMOKE DETECTOR--UNK WHERE----C/C-----PH#
L: 1271 FAIRPRT NINE MILE PT RD\nT: MVAIA - W/INJURIES\nO:\nB:\nC1: BAINBRIDGE LA\nC2: PLANK RD\nX: PRECAUTIONARY FOR CHEST PAIN DUE TO MVA

Contact: John Overacker <joveracker@fairportfd.org>
A: FAIF BOX: 0176\nL: 2 LEWIS ST\nT: CARDIAC/RESP-NOT BREATHING\nO: \nB: \nC1: POTTER PL\nC2: FILKINS ST\nX: 46 YO/M NOT BREATHING -- COLD TO THE TOUCH

Contact: Mark Smith <smity725@gmail.com>
Sender: chilifd@rednmxcad.com
L: 50 COTTAGE GROVE CI BOX: 0622\nT: CHIE - 6D2 : TRB BREATHING- DIFF SPEAKING            \nB: ROCH PRESB  PH:\nC1: BUFFALO RD\nC2: DEAD END\nX: 43 YO F PROB BREAT

Contact: Active911
(Scottsville Amb.) SCOE  B:0310 1  L:19 CHILI AV ,SCO - GROUP HOME T:6D4    X: MALE 50 TROUBLE BREATHING--CLAMMY AND FEVERISH--
(Scottsville Amb.) SCOE  B:0320 2  L:521 NORTH RD ,SCO - KAYLEIGH STEELLMAN RES T:23C1   X: XFER FROM 211/CLR REQ AMB FOR 19 YO F INTOX, HX OF SUICIDAL TENDENCIES, V IOLENT, NOT ALERT, SOUNDED LIKE SHE WAS BREATHING ABNORMALLY PER 211, F H/U ON 211 
SCOE  B:0450 1P L:851 SCOTTSVILLE MUMFORD RD ,WHE T:17D3   X: 71 YO HUSBAND HAS FALLEN / NOT ALERT
SCOE B:0450 1P L:851 SCOTTSVILLE MUMFORD RD ,WHE T:17D3 X: 71 YO HUSBAND HAS FALLEN / NOT ALERT --
SCOE B:0330 4 L:2 RACE ST ,SCO T:26A1 X: 89 YO F/BLADDER INFECTION /PAIN IN URINATION AND BACK PAIN
SCOE B:0330 1 L:385 SCOTTSVILLE MUMFORD RD ,SCO -- SCOF T:TEST X: TESTING SCOE'S TONES, PLEASE DISREGARD AND HAVE A GOOD NIGHT! --
SCOE B:0310 3 L:724 NORTH RD ,SCO - ROOM 6 T:RBCST X: ,NEED A DRIVER OR A MEDIC TO COMPLETE THE CREW W/ 4M16 - GATES A4569 TAKING THE ALS PORTION --
SCOE B:0310 1 L:724 NORTH RD ,SCO - ROOM 6 T:6D4 X: 48 YO M - TRBL BREATHING - IS CLAMMY - ALERT --
SCOE B:0330 1 L:MAIN ST/RT 251 ,SCO T:29D2N X: CAR TOOK OFF OUT OF COUNTY PARK -- EJECTED ONE OF THE PPL OUT OF THE CAR -- NOW TRYING TO LOAD HER INTO CAR AND LEAVE LOOK TO BE INTOX -- BLU CAR POSS SUBU IMPREZA 4D COMPACT
SCOE B:0320 2 L:NORTH RD/ROCHESTER ST ,SCO - MOBILE GAS STATION T:EMSA X: ODOR OF NATURAL GAS INSIDE THE BLDG - M IN BACK COOKING --
SCOE B:0320 4 L:8 GENESEE ST ,SCO - JOHN HOLTZ RES T:26A2 X: 68 YO MALE - SHAKING - POSS HIGH FEVER - COMPS ETA 15 MINS TO LOC --
SCOE B:0320 4 L:498 NORTH RD ,SCO T:7A1 X: 67 YO MALE RADIATOR SPLASHED ANTI FREEZE ON HIM /BURNING ON HIS CHEST AND FACE --

*/


public class NYMonroeCountyWebsterParser extends DispatchA7BaseParser {
  
  private static final Pattern MARKER = Pattern.compile("^([A-Z]{4}) +B:(\\d{4}) +(\\d[A-Z]?) +");
  
  public NYMonroeCountyWebsterParser() {
    super(CITY_CODES, "MONROE COUNTY", "NY",
          "BOX:BOX? L:ADDR! BOX:BOX? T:CALL! O:NAME? B:PLACE? PH:PHONE? C1:X? C2:X? X:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "@rednmxcad.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ').trim();
    Matcher match = MARKER.matcher(body);
    if (match.find()) {
      data.strSource = match.group(1);
      data.strBox = match.group(2);
      data.strPriority = match.group(3);
      body = body.substring(match.end()).trim();
    }
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC BOX PRI " + super.getProgram();
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BRI", " BRIGHTON",
      "BRO", "BROCKPORT",
      "CHI", "CHILI",
      "CHU", "CHURCHVILLE",
      "CLA", "CLARKSON",
      "ERO", "EAST ROCHESTER ",
      "FRP", "FAIRPORT",
      "GAT", "GATES",
      "GRE", "GREECE",
      "HAM", "HAMLIN",
      "HIL", "HILTON",
      "HON", "HONEOYE FALLS",
      "IRO", "IRONDEQUOIT",
      "MEN", "MENDON",
      "OGD", "OGDEN",
      "PAR", "PARMA",
      "PEN", "PENFIELD",
      "PER", "PERINTON",
      "PIT", "PITTSFORD",
      "RIG", "RIGA",
      "ROC", "ROCHESTER ",
      "RUS", "RUSH",
      "SCO", "SCOTTSVILLE",
      "SPE", "SPENCERPORT",
      "SWE", "SWEDEN",
      "WEB", "WEBSTER",
      "WHE", "WHEATLAND"
  });
  
}
	