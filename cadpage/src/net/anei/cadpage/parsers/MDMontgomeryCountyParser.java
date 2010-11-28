package net.anei.cadpage.parsers;

import java.util.Properties;
import net.anei.cadpage.SmsMsgInfo.Data;

public class MDMontgomeryCountyParser extends SmsMsgParser {
	public String getFilter() {
		return "rc.355@c-msg.net";
	}
	  @Override
	protected boolean parseMsg(String body, Data data) {
	    
	    if (!body.contains("[mCAD]")) return false;
	    
	    data.defState = "MD";
	    data.defCity = "MONTGOMERY";
	    body = body.replace("*", ";");
	    Properties props = parseMessage(body, ";", new String[]{"Junk","D","ID","Call","Addr","Units"});
	    data.strCall = props.getProperty("Call", "");
	    String strAddress = props.getProperty("Addr", "");
	    if (strAddress.contains("(")&& strAddress.contains(")")){
	    	int idx = strAddress.indexOf("(");
	    	if (idx > 1 && (idx < strAddress.length())){
	    		data.strSupp = strAddress.substring(idx+1,strAddress.indexOf(")"));
	    		strAddress = strAddress.substring(0,idx);
	    		data.strSupp=data.strSupp.trim();}
	    }
	    if (strAddress.contains(",")){
	    	int idxa = strAddress.indexOf(",");
	    	if (idxa > 1 && idxa < strAddress.length()){
	    		strAddress = strAddress.substring(0,idxa);
	    	}
	    }
	    parseAddress(strAddress, data);
	    data.strUnit= props.getProperty("Units", "");
	    return true;
	  }
}