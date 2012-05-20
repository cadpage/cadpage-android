package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;


/*

Pleasant Prarie Dispatch, WI (Kenosha County)
Contact: David Wilkinson <dwilkinson@plprairiewi.com>
Sender: CAD@plprairiewi.com
System: Prophoenix

Subject:Phoenix Notification\n2012000453 {04/15/2012 14:23:51}\r\nMED CALL - Medical Call{1}\r\n9747 84th Pl\r\nUnits:\r\n    5642    \r\nComments:\r\n\r
Subject:Phoenix Notification\n2012000454 {04/15/2012 17:21:48}\r\nFIRE SNG - Fire - Single Engine{1}\r\n905 114th St\r\nUnits:\r\n    5641    5611  \r
Subject:Phoenix Notification\n2012000454 {04/15/2012 17:21:48}\r\nFIRE SNG - Fire - Single Engine{1}\r\n905 114th St\r\nUnits:\r\n    5641    5611  \r
Subject:Phoenix Notification\n2012000619 {05/16/2012 17:47:56}\r\nFIRE ALA - Fire - Alarm{1}\r\n9901 77th St,CMPLX\r\nUnits:\r\n    5642    \r\nCommen\r
Subject:Phoenix Notification\n2012000618 {05/16/2012 13:31:17}\r\nMED CALL - Medical Call{1}\r\n13000BLK 104th St\r\nUnits:\r\n    5642    \r\nComment\r

*/

public class WIKenoshaCountyCParser extends DispatchProphoenixParser {
  
  public WIKenoshaCountyCParser() {
    super("KENOSHA COUNTY", "WI");
  }
  
  @Override
  public String getFilter() {
    return "CAD@plprairiewi.com";
  }
}
