package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Harris County NWEMS, TX
Contact: "Charles O'Quin" <charles.oquin@nwems.org>
Sender: cad@nwems.org

  / * 13415 MEDICAL COMPLEX DR* 320* * * * 01C05* ABD PAIN -Males w/pain above navel* * * M-1* * * * *
  / * 28602 TOMBALL PKWY* * * * * 19D04* HEART PROBLEMS-Clammy* * * M-1* * * * *
  / * 502 JAMES ST* * * * * 17A01* FALL - Not Dangerous* * * M-1* * * * *
  / * 605 HOLDERRIETH BLVD* 527* * * * 33A02* OUT OF DISTRICT TRANSFER* * * M-1* * * * *
  / * 1019 HICKORY POST CT* * * * * OVERDOSE* OVERDOGE/INGESTION* * * M-1* * * * *

*/


public class TXHarrisCountyNWEMSParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\* ");

  public TXHarrisCountyNWEMSParser() {
    super("HARRIS COUNTY", "TX",
           "ADDR APT INFO INFO INFO CODE CALL INFO INFO UNIT!");
  }
  
  public String getFilter() {
    return "cad@nwems.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("* ")) return false;
    body = body.substring(2).trim();
    return parseFields(DELIM.split(body+" "), 10, data);
  }
}
