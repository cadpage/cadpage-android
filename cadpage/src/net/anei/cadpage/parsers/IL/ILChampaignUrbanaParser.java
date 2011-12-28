package net.anei.cadpage.parsers.IL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Champaign-Urbana, IL (Champaign, Dewit, & Doublas Counties)
Contact: Joe.Kessler <Joe.Kessler@Carle.com>
System: Zoll RescueNet Dispatch-Billing using RescueNet Paging Service

Run# 6373, <Unknown>, 16:48, 1701 W CURTIS RD, CHAMPAIGN, 4M VOMITING FEVER LETHARGIC 26C1, <None>, SICK PERSON
Run# 6407, <Unknown>, 17:00, 404 SCOTTSWOOD DR, URBANA, 11 F W ABDONINAL PAIN 1A1, <None>, ABDOMINAL PAIN
Run# 6400, JOHN SMITH, 14:45, CU DIALYSIS, URBANA, RETURN TO CCNH. AUTH# R1369756, <None>, TRANSFER/INTERFACILITY, CHAMPAIGN COUNTY NURSING HOME, 220 B2, URBANA
Run# 6419, <Unknown>, 21:43, 507 CRYSTAL LAKE DR, URBANA, 25A1 INTOX F PT MENTAL EVAL, <None>, PSYCHIATRIC/SUICIDE
Run# 6422, <Unknown>, 22:28, 2306 BARBERRY DR, CHAMPAIGN, 19C2 RACING HEART RATE, <None>, HEART PROBLEM/AICD
Run# 6427, <Unknown>, 01:23, 208 VAN VOORHIS DR, TUSCOLA, 26A9 FEVER & PAIN, <None>, SICK PERSON
Run# 6368, SMITH, JOHN, 13:48, 709 E BARKER ST, D, TUSCOLA, 68F DIFF BREATHING 6C1, <None>, BREATHING PROBLEM
Run# 6421, SMITH, JOHN, 22:30, 302 S SPRUCE ST, VILLA GROVE, GOING FOR CARE NOT AVALIBLE AT OTHER FACILITY IN AREA // SUICIDAL // NEED AOB, <None>, TRANSFER/INTERFACILITY
Run# 6403, SIDELL, WILLIAM, 15:52, W BRADLEY AVE & CLAYTON BLVD, CHAMPAIGN, 57 M W BACK PAIN AFTER A MVA 29D2, <None>, TRAFFIC/TRANSPORTATION ACCIDENT

*/

public class ILChampaignUrbanaParser extends FieldProgramParser {
  
  public ILChampaignUrbanaParser() {
    super("", "IL",
           "ID NAME NAME? TIME ADDR APT? CITY INFO+");
  }
  
  @Override
  public String getLocName() {
    return "Champaign-Urbana, IL";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("Run# ")) return false;
    body = body.substring(5).trim();
    return parseFields(body.split(", *"), data);
  }
  
  private class MyNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      if (field.equalsIgnoreCase("<Unknown>")) return;
      data.strName = append(data.strName, ", ", field);
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  private class MyAptField extends AptField {
    public MyAptField() {
      setPattern(Pattern.compile(".{1,3}"));
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equalsIgnoreCase("<None>")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NAME")) return new MyNameField();
    if (name.equals("TIME")) return new TimeField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
    
  }
}
