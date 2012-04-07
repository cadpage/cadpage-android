package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/*
EnergyCare (Erie County, PA)
Contact: "Thomas, George" <gthomas@emergycare.org>
System: Zoll RescueNet

Run# 17973/ 0087-A/ 08:55/ ALS/ Priority 1/ E 20TH ST & MCCLELLAND AVE/ 16510/ GREY PICKUP TRUCK/ ON 20TH/ W OF MCCLELLAND/ <PROQA_DET>/ MALE IN PICKUP PARKED ON SIDE OF ROAD SLUMPED OVER OFF TO THE SIDE UNK. EMD: 31D0/ ECDOPS: 2012-35555/ <Unknown>/ X=Buffalo Rd&E 20th St
Run# 17958/ 0081-A/ 08:17/ BLS/ Priority 1/ 2416 STATE ST/ 16503/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ BLS P1; 52 year old/ Female/ Unconscious/ Breathing. Convulsions /Seizures. Not seizing now and breathing effectively (verified) (Epileptic or Previous history of seizures). EMD: 12A1E/ ECDOPS: 2012-35545/ <Unknown>/ X=E 26th St&W 24th St
Run# 17945/ 0030-A/ 07:30/ Medical Taxi/ Priority 4 / VA Out of Town/ TANGLEWOOD APTS/ 16504/ 101 - BUILDING 819/ <PROQA_DET>/ VA MEDICAL CTR UNIVERSITY CAMPUS/ NU/ OWN CH/BILL VA/MCGUIRE WILL DO/ COCCARELLI/ ALBERT/ X=UNNAMED|WAYNE&WAYNE
Run# 17968/ 0045-A/ 09:30/ BLS/ Priority 3 / Local/ TWINBROOK MEDICAL CENTER/ 16511/ east 212/ <PROQA_DET>/ UPMC HAMOT MEDICAL CENTER/ wound clinic for md meritz/ med nec for crew/ ms pt sacreal wounds nsa/ LAST NAME/ FIRST NAME/ X=PRIESTLEY&NAPIER

 */


public class PAErieCountyEnergyCareParser extends DispatchProQAParser {
  
  public PAErieCountyEnergyCareParser() {
    super("ERIE COUNTY", "PA",
           "SKIP TIME CALL PRI ADDR PLACE? ZIP! INFO+");
  }
  
  private class MyPriorityField extends PriorityField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      if (!p.get(' ').equals("Priority")) abort();
      super.parse(p.get(), data);
    }
  }
  
  private class MyCityField extends CityField {
    public MyCityField() {
      setPattern(Pattern.compile("\\d{5}"), true);
    }
  }
  
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
