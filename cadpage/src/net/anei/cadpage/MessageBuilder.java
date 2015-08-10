package net.anei.cadpage;

import net.anei.cadpage.parsers.Message;
import net.anei.cadpage.parsers.SplitMsgOptions;

public class MessageBuilder {

  private SmsMmsMessage origMsg;
  private SplitMsgOptions options;
  
  private String[] msgBodyList;
  
  public MessageBuilder(SmsMmsMessage origMsg) {
    this.origMsg = origMsg;
    this.options = origMsg.getSplitMsgOptions();
  }
  
  public Message buildMessage(String[] msgBodyList) {
    
    // Life gets easy if there is only one message
    if (msgBodyList.length == 1) return  bldMessage(msgBodyList[0]);
    
    // Only slightly less easier if the message order is known
    if (!options.mixedMsgOrder()) {
      String body = buildMsgBody(msgBodyList);
      return bldMessage(body);
    }
    
    // Otherwise life gets complicated.  Start by saving a copy of the message body list
    this.msgBodyList = new String[msgBodyList.length];
    System.arraycopy(msgBodyList, 0, this.msgBodyList, 0, msgBodyList.length);
    
    // Run through all the possible 2 part starting sequences
    // selecting the most promising one.
    int bestScore = Integer.MIN_VALUE;
    ParseResult bestResult = null;
    int[] msgOrder = new int[msgBodyList.length];
    
    for (int p1 = 0; p1 < msgBodyList.length; p1++) {
      msgOrder[0] = p1;
      for (int p2 = 0; p2 < msgBodyList.length; p2++) {
        if (p1 == p2) continue;
        msgOrder[1] = p2;
        if (msgOrder.length == 3) {
          for (int p3 = 0; p3 < msgBodyList.length; p3++) {
            if (p3 != p1 && p3 != p2) {
              msgOrder[2] = p3;
              break;
            }
          }
        }
        ParseResult result = new ParseResult(msgOrder);
        if (result.getScore() > bestScore) {
          bestScore = result.getScore();
          bestResult = result;
        }
      }
    }
    
    while (msgOrder.length < msgBodyList.length) {
      int n = msgOrder.length;
      int nn = n;
      if (msgBodyList.length == nn+1) nn++;
      int[] oldMsgOrder = msgOrder;
      
      
      
    }
    
    
    return null;
  }
  
  private int[] bldWorkingMsgOrder(int[] msgOrder, int n) {
    int len = (n == msgOrder.length-1 ? msgOrder.length : n);
    int[] result = new int[len];
    System.arraycopy(msgOrder, 0, result, 0, n);
    fillLast(result);
    return result;
  }
  
  private void fillLast(int[] msgOrder) {
    if (msgOrder.length != msgBodyList.length) return;
    int n = msgOrder.length-1;
    for (int ii = 0; ii < msgOrder.length; ii++) {
      if (isIndexUsed(ii, msgOrder, n)) continue;
      msgOrder[n] = ii;
      return;
    }
    throw new RuntimeException("fillLast could not find final index");
  }
  
  private boolean isIndexUsed(int ndx, int[] msgOrder, int n) {
    for (int jj = 0; jj < n-1; jj++) {
      if (ndx == msgOrder[jj]) return true;
    }
    return false;
  }
  
  /**
   * saves status of one attempt to parse a particular combination of message parts
   */
  private class ParseResult {
    private int[] msgOrder;
    private Message result;
    private int score;
    
    public ParseResult(int[] msgOrder) {
      this.msgOrder = msgOrder;
      result = bldMessage(msgOrder);
      score = result.getInfo().score();
    }
    
    public int getScore() {
      return score;
    }
    
    public Message getMessage() {
      return result;
    }
    
    public void setMessageOrder(String[] msgBodyList) {
      for (int jj = 0; jj < msgOrder.length; jj++) {
        msgBodyList[jj] = MessageBuilder.this.msgBodyList[msgOrder[jj]];
      }
    }
  }

  private Message bldMessage(int[] msgOrder) {
    return bldMessage(buildMsgBody(msgOrder));
  }
  
  private Message bldMessage(String body) {
    return origMsg.trialParse(body, SmsMmsMessage.PARSE_FLG_FORCE | SmsMmsMessage.PARSE_FLG_SKIP_FILTER);
  }
  
  private String buildMsgBody(int[] msgOrder) {
    String[] msgList = new String[msgOrder.length];
    for (int jj = 0; jj < msgOrder.length; jj++) {
      msgList[jj] = msgBodyList[msgOrder[jj]];
    }
    return buildMsgBody(msgList);
  }

  private String buildMsgBody(String[] msgBodyList) {
    boolean insBlank = options.splitBlankIns();
    StringBuilder sb = new StringBuilder();
    for (String msg : msgBodyList) {
      if (insBlank && sb.length() > 0) sb.append(' ');
      sb.append(msg);
    }
    return sb.toString();
  }
}
