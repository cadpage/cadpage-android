package net.anei.cadpage.parsers.NY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Nassau County,
Contact: "Andrew Moreno" <a_moreno@verizon.net> (old)
Sender: 2ndSignal@secondsignal.com
(* ) RESCUE\n7:29 PM\n181 MEADOWBROOK ROAD\nMERRICK\nAKEL CT\nWILLIS AVE\nMALE IN PAIN/PREVIOUS MVA\n1-516-324-2379   support@2sig.com

Contact: "Starkie, James" <james.starkie@richmond.edu>
Sender: 2ndSignal@2sig.com
(*) RESCUE\r\n12:06 PM\r\n128 HEWLETT AVE N\r\nMERRICK\r\nSMITH ST\r\nLOINES AVE\r\nDR GOLDSTEINS OFFICE-CHEST PAIN\r\n1-516-324-2379   pport@2sig.com

Contact: Active911.com
Agency name: Bellmore-Merrick EMS Location: Bellmore, NY 
Sender: 2ndSignal@2sig.com  

(*) RESCUE\n11:06 AM\n1815 CAMP AVE\nNO MERRICK\nRHODE AVE\nMAEDER AVE\nKNEE PAIN\n1-516-324-2379   support@2sig.com
(*) RESCUE\n11:26 AM\n1409 BELLMORE AVE\nNO BELLMORE\nWALLEN LA\nWARING ST\nSICK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n3:29 PM\n404 LINDEN ST\nBELLMORE\nTHE CREEK\nNEWBRIDGE ROAD\n91/M STROKE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n12:25 AM\n2199 BENEFIT ST\nNO MERRICK\nHENDRICKSON AVE\nSTEVENS AVE\nCATHETER PROBLEM\n1-516-324-2379   support@2sig.com
(*) MULTIPL\n1:04 AM\n246 PARK AVE\nNO MERRICK\nBIRCH ST\nHOWES ST\n\n1-516-324-2379   support@2sig.com
(*) RESCUE\n6:41 AM\n2496 RAMONA ST\nEAST MEADOW\nNEWBRIDGE ROAD\nMIDVALE AVE\nBACK PAIN\n1-516-324-2379   support@2sig.com
(*) RESCUE\n7:59 PM\n2909 BEACH DR\nMERRICK\nANN ROAD\nALEXIS ROAD\nSICK MALE\n1-516-324-2379   support@2sig.com
(*) MUTUAID\n8:40 PM\n320 MERRICK ROAD W\nFREEPORT\nWASHINGTON ST\nBAYVIEW (S) AVE\nRM228A/UNRESPONSIVE FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n2:04 AM\n2561 NATTA BLVD\nBELLMORE\nMARTIN PL\nHERBERT CT\nCATHETER PROBLEM\n1-516-324-2379   support@2sig.com
(*) RESCUE\n3:45 PM\n2060 FREEMAN AVE\nBELLMORE\nWOODBINE AVE\nSWENSON PL\nSICK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n8:34 AM\n1051 ADRIENNE DR\nNO BELLMORE\nOLD BRITTON ROAD\nMELISSA LA\nELD MALE CANT WALK\n1-516-324-2379   support@2sig.com
(*) RESCUE\n5:29 AM\n1217 RAYMOND ROAD\nNO BELLMORE\nJERUSALEM AVE\nSAWMILL ROAD\nSICK FEM\n1-516-324-2379   support@2sig.com
(*) RESCUE\n12:06 PM\n128 HEWLETT AVE N\nMERRICK\nSMITH ST\nLOINES AVE\nDR GOLDSTEINS OFFICE-CHEST PAIN\n1-516-324-2379   support@2sig.com
(*) AUTOACC\n11:53 PM\nMERRICK ROAD\nMERRICK\n\n\n\n1-516-324-2379   support@2sig.com
(*) RESCUE\n3:14 AM\n632 MIDVALE AVE\nEAST MEADOW\nTONQUIN ST\nNORTH JERUSALEM ROAD\n55F DIZZY/TINGLING IN LEGS\n1-516-324-2379   support@2sig.com
(*) RESCUE\n12:09 PM\n2189 CUSTOM VILLAGE CT\nNO BELLMORE\nNEWBRIDGE ROAD\n-DEAD END-\nFEMALE PASSED OUT\n1-516-324-2379   support@2sig.com
(*) RESCUE\n7:56 AM\n2941 HOLIDAY PARK DR\nMERRICK\nALEXIS ROAD\nCLUBHOUSE ROAD\nSICK MALE\n1-516-324-2379   support@2sig.com
(*) MUTUAID\n1:42 PM\n88 RUTLAND ROAD\nFREEPORT\nPARSONS AVE\nREMSEN AVE\nDIABETIC\n1-516-324-2379   support@2sig.com
(*) RESCUE\n6:50 PM\n1563 STEVENS AVE\nNO MERRICK\nGROVE ST\n-DEAD END-\nCHEST PAIN\n1-516-324-2379   support@2sig.com
(*) RESCUE\n12:50 AM\n2426 COTTAGE CT\nBELLMORE\nHEWLETT LA\n-DEAD END-\nSICK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n6:10 AM\n2476 ARMY PL\nBELLMORE\nSHORE ROAD\nLEGION ST\n\n1-516-324-2379   support@2sig.com
(*) RESCUE\n7:07 AM\n1920 CLEMONS ST\nBELLMORE\nNATTA BLVD\n-DEAD END-\nFM BLEEDING\n1-516-324-2379   support@2sig.com
(*) RESCUE\n1:25 PM\n2988 LONNI LA\nMERRICK\nSTANLEY DR\nGLENN LA\nFEMALE FELL\n1-516-324-2379   support@2sig.com
(*) RESCUE\n2:50 PM\n951 MERRICK AVE\nNO MERRICK\nNORTH JERUSALEM ROAD\nSHIRLEY CT\nASTHMA/DIFF BREATHING\n1-516-324-2379   support@2sig.com
(*) RESCUE\n8:01 AM\n968 SIEMS CT\nNO BELLMORE\nNORWOOD AVE\nLOCUST AVE\nARM LACERATION\n1-516-324-2379   support@2sig.com
(*) RESCUE\n8:35 AM\n1802 NEWBRIDGE ROAD\nNO BELLMORE\nCATHERINE PL\nKENNETH AVE\nSICK FM\n1-516-324-2379   support@2sig.com
(*) RESCUE\n12:18 PM\n2336 NEWBRIDGE ROAD\nBELLMORE\nSUNRISE HWY\nORANGE ST -\nOVERDOSE\n1-516-324-2379   support@2sig.com
(*) MUTUAID\n4:12 PM\nGRAND AVE\nFREEPORT\n\n\nMALE PASSED OUT AGAINST FENCE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n12:45 PM\n2760 BELTAGH AVE\nBELLMORE\nBELLMORE AVE\nBRIGGS ST -\n76 Y/O MALE PASSING OUT\n1-516-324-2379   support@2sig.com
(*) MUTUAID\n4:29 AM\n295 MAIN ST S\nFREEPORT\nFRANKLIN SQ\nARCHER ST -\nMAIN OFFICE-MALE BLEEDING\n1-516-324-2379   support@2sig.com
(*) AUTOACC\n10:54 AM\nSUNRISE HWY\nBELLMORE\n\n\nIFO PC RICHARD\n1-516-324-2379   support@2sig.com
(*) RESCUE\n11:48 AM\n2120 SKIPPER CT\nBELLMORE\nSWENSON PL\n-DEAD END-\nMALE PNEMONIA\n1-516-324-2379   support@2sig.com
(*) RESCUE\n4:40 PM\n1563 STEVENS AVE\nNO MERRICK\nGROVE ST\n-DEAD END-\nFM WEAK\n1-516-324-2379   support@2sig.com
(*) RESCUE\n3:34 AM\n801 NEWBRIDGE ROAD\nNO BELLMORE\nBELMOND AVE\nCOLUMBUS AVE\nUNRESP FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n11:24 AM\n1479 TADMOR ST\nNO MERRICK\nJERUSALEM AVE\nORION CT\nPREGNANT FM SEVERE CRAMPS\n1-516-324-2379   support@2sig.com
(*) RESCUE\n10:30 PM\n2625 JERUSALEM AVE\nNO BELLMORE\nEILEEN CT\nBELLMORE ROAD\n21 Y/O FEMALE-MENTAL AIDED\n1-516-324-2379   support@2sig.com
(*) MUTUAID\n2:44 AM\n148 PINE ST\nFREEPORT\nBERGEN (S) PL\nLONG BEACH (S) AVE\nSTOMACH PAINS-C9\n1-516-324-2379   support@2sig.com
(*) 01  TRAN\n5:06 PM\n2162 REDMOND ROAD\nNO MERRICK\nWHITTIER AVE\nTAFT AVE\nF/FELL\n1-516-324-2379   support@2sig.com
(*) MUTUAID\n5:53 PM\n58 SHONNARD AVE\nFREEPORT\nCOMMERCIAL ST\nPARSONS AVE\n\n1-516-324-2379   support@2sig.com
(*) MULTIPL\n5:58 PM\n1802 NEWBRIDGE ROAD\nNO BELLMORE\nCATHERINE PL\nKENNETH AVE\nSTOMACH PAINS\n1-516-324-2379   support@2sig.com
(*) RESCUE\n7:42 PM\n1667 CENTRAL AVE\nNO MERRICK\n3RD AVE\n2ND AVE\nSICK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n2:45 PM\n19 JUNIPER AVE\nMERRICK\nALFRED (W) ROAD\nALFRED (E) ROAD\nWEAK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n10:08 AM\n1667 CENTRAL AVE\nNO MERRICK\n3RD AVE\n2ND AVE\nSEIZURES\n1-516-324-2379   support@2sig.com
(*) MULTIPL\n10:36 AM\n1150 LITTLE WHALENECK ROAD\nNO MERRICK\nWILSON AVE\nSUFFOLK DR\nDIFF BREATHING\n1-516-324-2379   support@2sig.com
(*) RESCUE\n10:05 AM\n2065 FREEMAN AVE\nBELLMORE\nWOODBINE AVE\nSWENSON PL\nSICK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n11:37 PM\n165 STUYVESANT AVE\nMERRICK\nMADISON ST\nBABYLON TPK\nBACK PAIN\n1-516-324-2379   support@2sig.com
(*) RESCUE\n9:35 AM\n1802 NEWBRIDGE ROAD\nNO BELLMORE\nCATHERINE PL\nKENNETH AVE\nCHEST PAINS/SICK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n12:13 PM\n2065 FREEMAN AVE\nBELLMORE\nWOODBINE AVE\nSWENSON PL\nSICK FEMALE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n3:20 PM\n2809 SCHOOL ST\nBELLMORE\nBELLMORE AVE\nST MARKS (S) AVE\nUNABLE TO URINATE\n1-516-324-2379   support@2sig.com
(*) RESCUE\n9:28 PM\n2908 CHERYL ROAD\nMERRICK\nWYNSUM AVE\nJUDITH DR\nUNRESP FEMALE\n1-516-324-2379   support@2sig.com\n\n

*/


public class NYNassauCountyFParser extends FieldProgramParser {
  
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm aa");

  public NYNassauCountyFParser() {
    super("NASSAU COUNTY", "NY",
           "CALL TIME ADDR CITY X X INFO PHONE!");
  }
  
  @Override
  public String getFilter() {
    return "2ndSignal@2sig.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("*")) return false;
    if (body.endsWith(" support@2sig.com")) {
      body = body.substring(0,body.length()-17).trim();
    }
    return parseFields(body.split("\n"), 6, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField(TIME_FMT);
    return super.getField(name);
  }
}


