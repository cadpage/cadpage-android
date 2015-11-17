package net.anei.cadpage.parsers.AZ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class AZYavapaiCountyDParser extends SmartAddressParser {

	private static Pattern NORMAL = Pattern.compile(".{10}(?=\\d+).{60}DISP:\\d{2}:\\d{2}ENRT:\\d{2}:\\d{2}SCNE:\\d{2}:\\d{2}AVAIL:(?:\\d{2}:\\d{2})?");
	private static Pattern CANCEL = Pattern.compile(".{18}(?=\\d+).{60}DISP:\\d{2}:\\d{2}.{7}SCNE:(?:\\d{2}:\\d{2}.{7}|.{12})CNCL:\\d{2}:\\d{2}.{7}REASON:.*");
	private static Pattern REPORT = Pattern.compile(".{7}\\w.{64}APT#.{4}CITY:.{14}MAP:.{8}AUTHORITY:.{28}CROSS:.{33}RUN#:\\d+");
	
	public AZYavapaiCountyDParser() {
		super("YAVAPAI COUNTY", "AZ");
		setFieldList("UNIT ID CALL ADDR APT CITY MAP SRC X INFO");
	}

	private static Pattern FMT = Pattern.compile("(C)NCL:|RUN#:\\d+$");
	
	@Override
	public boolean parseMsg(String body, Data data) {
		
		// get format, init FParser
		Matcher mat = FMT.matcher(body);
		FParser fp = new FParser(body);
		
		// normal format
		if (!mat.find()) {
//			if (!fp.lookahead(100, 6).equals("AVAIL:")) return false;
			if (!NORMAL.matcher(body).matches()) return false;
			data.strUnit = fp.get(10).trim();
			data.strCallId = fp.get(20).trim();
			parseAddress(fp.get(40).trim(), data);
			data.strSupp = fp.get(10)+"\n"+fp.get(10)+"\n"+fp.get(10)+"\n"+fp.get();
			return true;
		}
		
		// cancel format
		if (mat.group(1) != null) {
//			if (!fp.lookahead(129, 7).equals("REASON:")) return false;
			if (!CANCEL.matcher(body).matches()) return false;
			data.strUnit = fp.get(18).trim();
			data.strCallId = fp.get(20).trim();
			parseAddress(fp.get(40).trim(), data);
			data.strSupp = fp.get(17).trim()+"\n"+fp.get(17).trim()+"\n"+fp.get(17).trim();
			fp.skip(7);
			data.strCall = "CANCEL:"+fp.get();
			return true;
		}
		
		// or run report format
//		if (!fp.lookahead(188,  5).equals("RUN#:")) return false;
		if (!REPORT.matcher(body).matches()) return false;
		data.strUnit = fp.get(7).trim();
		data.strCall = fp.get(35).trim();
		parseAddress(fp.get(30).trim(), data);
		fp.skip(4);
		data.strApt = fp.get(4).trim();
		fp.skip(5);
		data.strCity = fp.get(14).trim();
		String mcity = CITY_CODES.getProperty(data.strCity);
		if (mcity != null) data.strCity = mcity;
		fp.skip(4);
		data.strMap = fp.get(8).trim();
		fp.skip(10);
		data.strSource = fp.get(28).trim();
		fp.skip(6);
		data.strCross = fp.get(33).trim();
		fp.skip(5);
		data.strCallId = fp.get();
		
		return true;
	}
	
	Properties CITY_CODES = buildCodeTable(new String[]{
		"CORDES JUNCTIO", "CORDES LAKES",
	});
}
