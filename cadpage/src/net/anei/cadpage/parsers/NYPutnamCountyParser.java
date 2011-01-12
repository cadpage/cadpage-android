package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;


public class NYPutnamCountyParser extends SmsMsgParser {


  public NYPutnamCountyParser() {
    super("PUTNAM COUNTY", "NY");
  }
  

@Override
  public String getFilter() {
    return "911@putnamcountyny.gov";
  }

@Override
  protected boolean parseMsg(String body, Data data) {
  
  
  int ipt = body.indexOf(" STA ");
  if (ipt < 0) return false;
  int idx1 =0; int idx2 =0; int idx3 =0; int idx4 = 0;
  
  idx2 = body.indexOf(" STA ");
  idx1 = body.lastIndexOf("|",idx2);
  idx3 = body.lastIndexOf("|");
  idx4 = body.indexOf(" XS ");
  
  if (idx1 < 0 && idx2 < 0 ) return false;
  body = body.trim();
  data.strCall = body.substring(0,idx1).trim();
  if (data.strCall.endsWith("|")){
    data.strCall = data.strCall.substring(0,data.strCall.length()-1);
  }
  parseAddress(body.substring(idx1+1,idx2-1), data);
  data.strCross= body.substring(idx4+4,idx3).trim();
  data.strSupp = body.substring(idx3+1);
  if (data.strSupp.contains("NARR")) {
    data.strSupp = data.strSupp.substring(4).trim();
  }
  if (data.strCall.contains("(CAD)")) {
    data.strCall = data.strCall.substring(5).trim();
  }

  return true;
  }
  
}