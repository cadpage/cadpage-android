package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 Clinton County, PA
 */
public class PAClintonCountyParser extends DispatchA5Parser {
  
  public PAClintonCountyParser() {
    super("CLINTON COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "mcgill@CLINTONCOUNTYPA.COM,rupert@CLINTONCOUNTYPA.COM,mchenry@CLINTONCOUNTYPA.COM,wharber@CLINTONCOUNTYPA.COM,jonpless@CLINTONCOUNTYPA.COM,rodgers@CLINTONCOUNTYPA.COM,smckinney@CLINTONCOUNTYPA.COM,baney@CLINTONCOUNTYPA.COM,sanders@CLINTONCOUNTYPA.COM,cstark@CLINTONCOUNTYPA.COM,hillyer@CLINTONCOUNTYPA.COM";
  }
}