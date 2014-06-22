package net.anei.cadpage.parsers.IL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 *  O'Fallon, IL
 */
public class ILOFallonParser extends DispatchA9Parser {
    
  public ILOFallonParser() {
    super(null, "OFALLON", "IL");
  }
  
  @Override
  public String getFilter() {
    return "ofallonfire@ofallon.org,jrunyan@ofallon.org,forwarding-noreply@google.com";
  }

}
