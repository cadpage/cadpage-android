package net.anei.cadpage.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {
  
  // pre-parse message information
  private String parseAddress;
  private String parseSubject;
  private String parseMessageBody;
  private int msgIndex = -1;
  private int msgCount = -1;

  // Parsed message information
  private MsgInfo info = null;

  public Message(boolean preParse, String fromAddress, String subject, String body) {
    this(preParse, fromAddress, subject, body, false);
  }
  
  public Message(boolean preParse, String fromAddress, String subject, String body, boolean keepLeadBreak) {
    if (fromAddress == null) fromAddress = "";
    if (subject == null) subject = "";
    if (body == null) body = "";
    
    if (! preParse) {
      this.parseAddress = fromAddress;
      this.parseSubject = subject;
      this.parseMessageBody = finish(body);
    } else {
      preParse(fromAddress, subject, body, keepLeadBreak);
    }
  }
  
  public String getAddress() {
    return parseAddress;
  }
  
  public String getSubject() {
    return parseSubject;
  }
  
  public String getMessageBody() {
    return parseMessageBody;
  }
  
  public void setMessageBody(String body) {
    parseMessageBody = body;
  }
  
  public int getMsgIndex() {
    return msgIndex;
  }
  
  public int getMsgCount() {
    return msgCount;
  }

  /**
   * Called by the MsgParser object parsing this message to identify the
   * location code associated with that parser.  It will usually be the same
   * as the code passed to ManageParsers.getParser(String location) but may
   * differ if the original parser is a group parser that passes the request
   * to multiple child parsers to do the actual work.
   * @param location location code of actual parser used
   */
  protected void setLocationCode(String location) {}
  
  /**
   * Called by test code to retrieve value set as the location code
   * @return location code saved by setLocationCode
   */
  protected String getLocationCode() {
    return null;
  }
  
  // Patterns used to perform front end descrambling
  private static final Pattern RETURN_PTN = Pattern.compile("\r+\n|\n\r+|\r");
  private static final Pattern LEAD_BLANK = Pattern.compile("^ *\" \" +");
  private static final Pattern DISCLAIMER_PTN = Pattern.compile("\\n+DISCLA.*$| *\\[Attachment\\(s\\) removed\\]$", Pattern.CASE_INSENSITIVE);
  private static final Pattern EXCHANGE_FWD_PTN = Pattern.compile("^(?:\\[FWD?:.*\\] *\n+)?(?:--+(?:Original Message)?--+\n)?From: *(.*?)\n(?:\\[?mailto:.*\\] *\n)?(?:Date:.*\n)?(?:Sent:.*\n)?(?:To:.*\n)?(?:Subject: (.*)\n)?(?:Reply-To:.*\n)?(?:Importance:.*\n)?(?:Auto forwarded by a Rule\n)?(?!\\S*$)");
  private static final Pattern FWD_PTN = Pattern.compile("^FWD?:");
  private static final Pattern[] MSG_HEADER_PTNS = new Pattern[]{
    Pattern.compile("^(000\\d)/(000\\d)\\b"),
    Pattern.compile("^(\\d) *of *(\\d):"),
    Pattern.compile("^\\(?\\((\\d)/(\\d)\\)"),
    Pattern.compile("^ *(\\d)/(\\d) / "),
    Pattern.compile("^\\( *(\\d) +of +(\\d) *\\)"),
    Pattern.compile("^([\\w\\.]+@[\\w\\.]+) /(\\d)/(\\d) /"),
    Pattern.compile("^(\\d)/(\\d)\n+"),
    Pattern.compile("^(\\d)/(\\d)(?![/\\d])"),
    Pattern.compile("^(\\d)/(\\d)(?=\\d{3,}:)"),  // This one is scarry !!!
    Pattern.compile("\\[(\\d) of (\\d)\\]$"),
    Pattern.compile(":(\\d)of(\\d)$"),
    Pattern.compile("^[A-Z]+ +\\((\\d)/(\\d)\\) +(.*?) +STOP$"),
    Pattern.compile("^\\( *([^\\)]*?) +(\\d) *of *(\\d)\\)(.*)$", Pattern.DOTALL)
  };
  private static final Pattern MSG_HEADER_FINAL_PTN = Pattern.compile("^(\\d)/(\\d) +");
  private static final Pattern[] SUBJECT_HEADER_PTNS = new Pattern[]{
    Pattern.compile("^(\\d)/(\\d)$")
  };
  private static final Pattern OPT_OUT_PTN = Pattern.compile("TXT STOP.*$");
  private static final Pattern CONT_PTN = Pattern.compile("\\(C.* \\d\\d? of \\d\\d?");
  
  private static final Pattern[] EMAIL_PATTERNS = new Pattern[]{ 
    Pattern.compile("^(?:\\*.*\\*)?([\\w\\.]+@[\\w\\.]+)( +/ +/ +)"),
    Pattern.compile(" - Sender: *([\\w\\.]+@[\\w\\.]+) *\n"),
    Pattern.compile("^(?:[-=.+_a-z0-9]*[0-9a-f]{8,}[-=.+_a-z0-9]*=)?((?:[\\w.!\\-]+|\\\"[\\w.!\\- ]+\\\")@[\\w.]+)[\\s:]"),
    Pattern.compile("^\\*\\d+: \\*([\\w\\w]+@[\\w\\.]+) +"),
    Pattern.compile("^[^\n]*\\bFr: *(\\S+@\\S+)\\s+"),
    Pattern.compile("^From: *(\\S+@\\S+) +"),
    Pattern.compile("sentto-[-\\d]+ *= *([-\\.\\w]+@[-\\.\\w]+) +"),
    Pattern.compile("^[\\d\\.]+=([-_a-z0-9\\.]+@[-_a-z0-9\\.]+) +")
  };
  private static final Pattern EMAIL_PFX_PATTERN = Pattern.compile("^([\\w\\.]+@[\\w\\.]+)(?:\\n|: )");
  private static final Pattern FRM_TAG_PATTERN = Pattern.compile("\n *FRM:");
  private static final Pattern MULTI_MSG_MASTER_PATTERN = Pattern.compile("1 of \\d FRM:(.*?) SUBJ:(.*?) MSG:(.*)\\(End\\)");
  private static final Pattern MULTI_MSG_BREAK_PATTERN = Pattern.compile(" \\(Con't\\) \\d of \\d ");
  private static final Pattern[] E_S_M_PATTERNS = new Pattern[]{
    Pattern.compile("^(?:([\\w\\.]+@[\\w\\.]+) +)?Subject: *(.*)\n"),
    Pattern.compile("^(?:([^ ,;/]+) +)?S:(.*?)(?: +M:|\n)"), 
    Pattern.compile("^Fr:<(.*?)>?\nSu:(.*?)\nTxt: "),
    Pattern.compile("^prvs=[0-9a-f]{8,}=[\\w .<>@]*<([\\w.\\-]+@[\\w.]+)> *\\((.*?)\\)")
  };
  
  private void preParse(String fromAddress, String subject, String body, boolean keepLeadBreak) {
    
    // Start by decoding common HTML sequences
    body = decode(body);
    body = trimLead(body, keepLeadBreak);
    
    // Get rid of any \r characters
    body = RETURN_PTN.matcher(body).replaceAll("\n");
    
    // Drop FWD: prefix
    if (body.startsWith("FWD:")) body = body.substring(4).trim();
    if (body.startsWith("Begin forwarded message:")) body = body.substring(24).trim();
    
    // default address and subject to obvious values
    parseAddress = fromAddress;
    parseSubject = decode(subject);
    
    // Remove trailing disclaimer(s)
    body = DISCLAIMER_PTN.matcher(body).replaceFirst("");
    
    // Exchange has a unique set of forwarding headers, than can be chained together :()
    body = trimLead(body, keepLeadBreak);
    while (true) {
      Matcher match = EXCHANGE_FWD_PTN.matcher(body);
      if (!match.find()) break;
      String from = match.group(1).trim();
      if (from != null) parseAddress = from;
      String subj = match.group(2);
      if (subj != null) parseSubject = subj.trim();
      body = trimLead(body.substring(match.end()), keepLeadBreak);
    }
    
    if (body.startsWith("Pagecopy-")) body = body.substring(9);
    
    // Dummy loop we can break out of
    do {
      
      // Check the message header pattern,these contain a msg number and total
      // counts.  If the values don't match, set the flag indicating more data
      // is expected
      Matcher match = null;
      boolean found = false;
      for (Pattern ptn : MSG_HEADER_PTNS) {
        match = ptn.matcher(body);
        found = match.find();
        if (found) break;
      }
      if (found) {
        boolean pinned = (match.groupCount() >= 3 && match.start() == 0 && match.end() == body.length());
        int ndx = 1;
        if (pinned) {
          if (match.groupCount() == 4) {
            String tmp = match.group(ndx++);
            if (!tmp.equals("- part")) addSubject(tmp);
          }
        } 
        else if (match.groupCount() == 3) {
          parseAddress = match.group(ndx++);
        }
        msgIndex = Integer.parseInt(match.group(ndx++));
        msgCount = Integer.parseInt(match.group(ndx++));
        if (pinned) {
          body = match.group(ndx);
        }
        else if (match.start() == 0) {
          String origBody = body;
          body = trimLead(body.substring(match.end()),keepLeadBreak);
          if (origBody.startsWith("((")) {
            if (body.startsWith(")")) body = trimLead(body.substring(1), keepLeadBreak);
            else body = "(" + body;
          }
        } else body = trimLead(body.substring(0,match.start()),keepLeadBreak);
      } else {
        if (body.startsWith("/ ")) body = trimLead(body.substring(2), keepLeadBreak);
      }
      
      // Get rid of leading quoted blanks
      match = LEAD_BLANK.matcher(body);
      if (match.find()) body = trimLead(body.substring(match.end()), keepLeadBreak);
      
      // And trailing opt out message
      match = OPT_OUT_PTN.matcher(body);
      if (match.find()) body = trimLead(body.substring(0,match.start()), keepLeadBreak);
      
      /* Decode patterns that look like this.....
      1 of 3
      FRM:CAD@livingstoncounty.livco
      SUBJ:DO NOT REPLY
      MSG:CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10
      (Con't) 2 of 3
      20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN
      (Con 3 of 3
      BREAK(End)
      
      Or This
      
      FRM:e@fireblitz.com <Body%3AFRM%3Ae@fireblitz.com>
      MSG:48: TOWNHOUSE FIRE
      E818 BO802
      9903 BREEZY KNOLL CT [DEAD END & GREEN HAVEN RD]
      12/23 23:32
      http://fireblitz.com/18/8.shtm
      */
      int pt1 = -1;
      if (body.startsWith("FR:")) {
        pt1 = 3;
      } 
      else if (body.startsWith("FRM:")) {
        pt1 = 4;
      } else if (EMAIL_PFX_PATTERN.matcher(body).find()) {
        pt1 = 0;
      } else {
        match = FRM_TAG_PATTERN.matcher(body);
        if (match.find()) pt1 = match.end();
      }
      if (pt1 >= 0) {
        String[] lines = body.substring(pt1).split("\n");
        if (lines.length > 1) {
          lines[0] = lines[0].trim();
          int ndx = 1;
          lines[1] = lines[1].trim();
          if (lines[1].startsWith("SUBJ:")) {
            lines[1] = lines[1].substring(5).trim();
            ndx++;
          } else if (lines[1].startsWith("SUB:")) {
            lines[1] = lines[1].substring(4).trim();
            ndx++;
          }
          if (lines.length > ndx) {
            String line = lines[ndx];
            while (line.length() > 0 && line.charAt(0)==' ') line = line.substring(1);
            if (line.startsWith("MSG:")) {
              parseAddress = lines[0];
              if (ndx > 1) addSubject(lines[1]);
              StringBuilder sb = new StringBuilder(line.substring(4).trim());
              boolean skipBreak = false;
              for ( ndx++; ndx < lines.length; ndx++) {
                line = lines[ndx];
                if (CONT_PTN.matcher(line).matches()) {
                  skipBreak = true;
                } else {
                  if (sb.length() > 0) {
                    sb.append(skipBreak ? ' ' : '\n');
                  }
                  sb.append(line);
                  skipBreak = false;
                }
              }
              trimLast(sb, "(End)");
              trimLast(sb, "\nMore?");
              body = trimLead(sb.toString(), keepLeadBreak);
              break;
            }
          }
        }
      }
      
      /* Decode patterns that look like this (same as above with line breaks removed)
        1 of 2 FRM:ics.gateway@wylietexas.gov SUBJ:Message From Wylie MSG:12030523 RESCUE-TRAPPED PERSON(S) TONY LN / N HIGHWAY 66 IN FATE [FAFD (Con't) 2 of 2 GRID: F121] UNITS: FATEFD ROMED1 ST RMK: <NONE> CFS RMK 12:48 VEHICLE ON ITS SIDE AND OCCP TRAPPED {WYPCCOM05 12:48}(End)
      */
      match = MULTI_MSG_MASTER_PATTERN.matcher(body);
      if (match.matches()) {
        parseAddress = match.group(1).trim();
        parseSubject = match.group(2).trim();
        body = MULTI_MSG_BREAK_PATTERN.matcher(match.group(3)).replaceAll(" ").trim();
        break;
      }
      
      /* Decode patterns that look like this 
      CommCenter@ccems.com <Body%3ACommCenter@ccems.com> [] TAP OUT (SAL)
       */
      int ipt = body.indexOf(" [] ");
      if (ipt >= 0) {
        String sAddr = body.substring(0, ipt).trim();
        if (sAddr.contains("@")) {
          parseAddress = sAddr;
          body = trimLead(body.substring(ipt+4), keepLeadBreak);
          break;
        }
      }
      
      /* Decode patterns that look like this
        Dispatch@ci.waynesboro.va.us <Body%3ADispatch@ci.waynesboro.va.us> Msg: Dispatch:2ND CALL 1001 HOPEMAN PKWY, ZAP12 INJURIES FROM PREVIOUS MVA
      */
      ipt = body.indexOf(" Msg:");
      if (ipt >= 0) {
        String addr = body.substring(0,ipt).trim();
        if (addr.contains("@") && ! addr.contains(":")) {
          parseAddress = addr;
          body = trimLead(body.substring(ipt+5), keepLeadBreak);
          break;
        }
      }
      
      /* Decode patterns that look like this
       * "HC@hamilton-co.org\nMSG:\nHC:ODOR OF GAS 393 PROVIDENCE WY SHRN NEXT TO TRAILER..... CHARLES SOILBACK ** SMELL OF GAS ** SEE MALE COMPL REF ODOR OF NATURAL GAS LEAK FROM A POSS 1 INCH PIPE COMIN",
       */
      ipt  = body.indexOf("\nMSG:\n");
      if (ipt >= 0) {
        parseAddress = body.substring(0,ipt);
        body = trimLead(body.substring(ipt+6), keepLeadBreak);
        break;
      }
      
      /* Decode patterns that contain an email address, subject, and message
       * S:subject M:msg
       */
      found = false;
      for (Pattern ptn : E_S_M_PATTERNS) {
        match = ptn.matcher(body);
        found = match.find();
        if (found) break;
      }
      
      if (found) {
        String from = match.group(1);
        if (from != null) parseAddress = from.trim();
        String sub = match.group(2);
        if (sub != null) addSubject(sub.trim());
        body = trimLead(body.substring(match.end()), keepLeadBreak);
        break;
      }
    
      
      /* Decode patterns that match EMAIL_PATTERN, which is basically an email address
       * followed by one of a set of known delimiters
       */
      found = false;
      for (Pattern ptn : EMAIL_PATTERNS) {
        match = ptn.matcher(body);
        found = match.find();
        if (found) break;
      }
      if (found) {
        parseAddress = match.group(1);
        body = trimLead(body.substring(match.end()), keepLeadBreak);
        break;
      }

    } while (false);
    body = finish(body);
    
    // Make one last check for a message index that might have been masked
    // by parenthesized subjects
    if (msgIndex < 0 && parseSubject.length() > 0) {
      Matcher match = MSG_HEADER_FINAL_PTN.matcher(body);
      if (match.find()) {
        msgIndex = Integer.parseInt(match.group(1));
        msgCount = Integer.parseInt(match.group(2));
        body = body.substring(match.end());
      }
    }
    parseMessageBody = body;
    
    // If we extracted an empty address from the text string, restore the
    // original address
    if (parseAddress.length() == 0) parseAddress = fromAddress;
  }
  
  private static String trimLead(String str, boolean keepLeadBreak) {
    int pt = 0;
    while (pt < str.length() && 
            (keepLeadBreak ? str.charAt(pt) == ' ' : Character.isWhitespace(str.charAt(pt)))) pt++;
    return str.substring(pt);
  }

  /**
   * Remove common HTML sequences
   * @param body
   * @return
   */
  private String decode(String body) {
    body = HTML_PTN.matcher(body).replaceAll("");
    body = BR_PTN.matcher(body).replaceAll("\n");
    return body.replace("&nbsp;",  " ").replace("&amp;",  "&").replace("&gt;", ">").replace("&lt;", "<");
  }
  private static final Pattern HTML_PTN = Pattern.compile("^.*<HTML>|<BODY>|</BODY>|</HTML>.*$", Pattern.CASE_INSENSITIVE);
  private static final Pattern BR_PTN = Pattern.compile("< *br */?>", Pattern.CASE_INSENSITIVE);
  
  /**
   * Perform final message parsing.  This is the last preparse steps that should
   * be done even when no preparsing is requested.  It is used to back out
   * steps that might be generated by a message forwarder or might have been
   * included in the original message so we get consistent results
   * @param body message body
   * @return adjusted message body
   */
  public String finish(String body) {

    // Finally, leading values in square or round brackets are turned into
    // message subjects.  There may be more than one of these, in which case
    // only the last is retained
    int pt1 = 0;
    
    // First skip leading dots and spaces
    while (pt1 < body.length() && " .".indexOf(body.charAt(pt1))>=0) pt1++;
    while (pt1 < body.length()) {
      while (pt1 < body.length() && body.charAt(pt1) == ' ') pt1++;
      if (pt1 >= body.length()) break;
      
      char d1 = body.charAt(pt1);
      if (d1 != '(' && d1 != '[') break;
      
      char d2 = (d1 == '(' ? ')' : ']');
      int level = 0;
      int pt2;
      for (pt2 = pt1; pt2 < body.length(); pt2++) {
        char c = body.charAt(pt2);
        if (c == d1) level++;
        if (c == d2) level--;
        if (level == 0) {
          addSubject(body.substring(pt1+1, pt2).trim());
          pt1 = pt2+1;
          break;
        }
      }
      if (pt2 >= body.length()) break;
    }
    
    body = trimLead(body.substring(pt1), true);
    Matcher match = EMAIL_PFX_PATTERN.matcher(body);
    if (match.find()) {
      parseAddress = match.group(1).trim();
      body = trimLead(body.substring(match.end()), true);
    }
    
    if (body.startsWith("MSG:")) body = trimLead(body.substring(4), true);
    
    match = FWD_PTN.matcher(parseSubject);
    if (match.find()) parseSubject = parseSubject.substring(match.end()).trim();
    
    // Last check, if we ended up with no message, use the last subject as the message
    if (body.length() == 0) {
      int pt = parseSubject.lastIndexOf('|');
      if (pt >= 0) {
        body = parseSubject.substring(pt+1);
        parseSubject = parseSubject.substring(0,pt);
      } else {
        body = parseSubject;
        parseSubject = "";
      }
    }
    
    for (Pattern ptn : SUBJECT_HEADER_PTNS) {
      match = ptn.matcher(parseSubject);
      if (match.find()) {
        msgIndex = match.group(1).charAt(0)-'0';
        msgCount = match.group(2).charAt(0)-'0';
        if (match.start() == 0) parseSubject = parseSubject.substring(match.end()).trim();
        else parseSubject = parseSubject.substring(0,match.start()).trim();
      }
    }
    
    return body;
  }
  
  private void trimLast(StringBuilder sb, String endCode) {
    int len = sb.length()-endCode.length();
    if (len < 0) return;
    if (sb.substring(len).equals(endCode)) sb.setLength(len);
  }
  
  private void addSubject(String subject) {
    if (subject.length() == 0) return;
    if (parseSubject.length() == 0) parseSubject = subject;
    else parseSubject = parseSubject + '|' + subject;
  }

  /**
   * Set parsed message information 
   * @param msgInfo
   */
  public void setInfo(MsgInfo msgInfo) {
    this.info = msgInfo;
    setLocationCode(info.getParserCode());
  }

  /**
   * @return the parsed information object associated with this object 
   * created by a previous call to MsgParser.isPageMsg(Message msg, int parserFlags)
   */
  public MsgInfo getInfo() {
    return info;
  }

  /**
   * Escape a string containing tabs, newlines, or multiple spaces so it
   * will better survive transmission through an email message
   * @param message message to be escaped
   * @return escaped message
   */
  private static final Pattern MULT_SPACES = Pattern.compile(" {2,}");
  private static final Pattern UNPRINTABLE = Pattern.compile("[^\\p{Print}\n]");
  static public String escape(String message) {
    if (message == null) return message;
    message = message.replace("\\", "\\\\");
    message = message.replace("\t", "\\t");
    message = message.replace("\n", "\\n\n");
    message = message.replace("\r", "\\r");
    message = message.replace("\f", "\\f");
    message = message.replace("\b", "\\b");
    Matcher match = MULT_SPACES.matcher(message);
    if (match.find()) {
      StringBuffer sb = new StringBuffer();
      do {
        match.appendReplacement(sb, "\\\\" + (match.end()-match.start()) + "s");
      } while (match.find());
      match.appendTail(sb);
      message = sb.toString();
    }
    match = UNPRINTABLE.matcher(message); 
    if (match.find()) {
      StringBuffer sb = new StringBuffer();
      do {
        int code = message.charAt(match.start());
        match.appendReplacement(sb, String.format("\\\\u%04x",code));
      } while (match.find());
      match.appendTail(sb);
      message = sb.toString();
    }
    return message;
  }
}
