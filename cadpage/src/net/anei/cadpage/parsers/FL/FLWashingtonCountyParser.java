package net.anei.cadpage.parsers.FL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class FLWashingtonCountyParser extends SmartAddressParser {

	public FLWashingtonCountyParser() {
		super("WASHINGTON COUNTY", "FL");
		setFieldList("ADDR APT PLACE X INFO CALL NAME");
	}
	
	private static Pattern MASTER = Pattern.compile("(.*?)((?<=[A-Z])\\d+)?\n(.*?)(?:X2\\[(.*?)\\])?\n(Y)?\n\n(.*?)(?:\n(.*))?", Pattern.DOTALL);
//	private static Pattern ALTERNATE = Pattern.compile("(.*?) X2\\[(.*?)\\](.+)");
//	private static Pattern OMG_HELP = Pattern.compile("(.*)(.*) $1(.*)");
	@Override
	public boolean parseMsg(String subject, String body, Data data) {
		//check for alternate format first
		if (subject.equals("=?utf-8?B?NDEx?=")) {
			return false;
//			Matcher mat = ALTERNATE.matcher(body);
//			if (!mat.matches()) return false;
//			data.strAddress = mat.group(1);
//			data.strCross = mat.group(2);
//			data.strSupp = mat.group(3);
//			
//			mat = OMG_HELP.matcher(data.strAddress);
//			if (!mat.matches()) return false;
//			data.strAddress = mat.group(2) + " " + mat.group(1);
//			data.strPlace = mat.group(3);
//			return true;
		}
		
		//check subject
		if (!subject.startsWith("=?")) return false;
		if (!subject.endsWith("?=")) return false;
		
		//parse with RegEx
		Matcher mat = MASTER.matcher(body);
		if (!mat.matches()) return false;
		
		data.strAddress = mat.group(1).trim();
		data.strApt = getOptGroup(mat.group(2));
		data.strPlace = mat.group(3).trim();
		data.strCross = getOptGroup(mat.group(4)).trim();
		data.strSupp = getOptGroup(mat.group(5));
		data.strCall = mat.group(6).trim();
		data.strName = getOptGroup(mat.group(7)).trim();
		
		//discard PLACE if it is identical to ADDR
		if (data.strPlace.equals(data.strAddress)) data.strPlace = "";
		
		return true;
	}

}
