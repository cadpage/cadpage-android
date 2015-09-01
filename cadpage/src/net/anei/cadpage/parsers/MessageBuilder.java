package net.anei.cadpage.parsers;

public class MessageBuilder {

  private MsgParser parser;
  private String fromAddress;
  private String subject;
  private SplitMsgOptions options;
  
  private boolean preserveProgram = false;
  
  private String[] msgBodyList;
  
  public MessageBuilder(MsgParser parser, String fromAddress, String subject, SplitMsgOptions options) {
    this.parser = parser;
    this.fromAddress = fromAddress;
    this.subject = subject;
    this.options = options;
  }
  
  /**
   * In normal operation, the parser will be invoked multiple times
   * and the field program settings from the most recent attempt will
   * most likely not be the one that was used to retrieve the best result.
   * This is called if it is important to the parser return the field
   * term list for the best result
   */
  public void setPreserveProgram() {
    preserveProgram = true;
  }
  
  /**
   * Accumulate one or more message parts into a single Message object
   * @param msgBodyList array of message parts
   * @param lock true of message order is locked
   * @return
   */
  public Message buildMessage(String[] msgBodyList, boolean lock) {
    
    // Life gets easy if there is only one message
    if (msgBodyList.length == 1) return  bldMessage(msgBodyList[0]);
    
    // Reverse the message order is so requested
    if (options.revMsgOrder()) {
      String[] tmp = new String[msgBodyList.length];
      for (int j = 0; j<msgBodyList.length; j++) {
        tmp[j] = msgBodyList[msgBodyList.length-j-1];
      }
      msgBodyList = tmp;
    }
    
    // Only slightly less easier if the message order is known
    if (lock || !options.mixedMsgOrder()) {
      String body = buildMsgBody(msgBodyList);
      return bldMessage(body);
    }
    
    // Otherwise life gets complicated.
    this.msgBodyList = msgBodyList;
    
    int[] msgOrder = new int[msgBodyList.length];
    
    // Now thing get complicated.  We are going to step through each
    // position by pairs.  Stopping just before the last one because
    // the last position can always be autofilled
    for (int n = 1; n < msgBodyList.length; n+=2) {
      
      // for each pair, try all combinations of two
      // parts from the remaining parts
      resetBestResult();
      for (int p1 = 0; p1 < msgBodyList.length; p1++) {
        if (isIndexUsed(p1, msgOrder, n-1)) continue;
        msgOrder[n-1] = p1;
        if (n+1 == msgBodyList.length) {
          trialParse(msgOrder, n);
        }
        else {
          for (int p2 = 0; p2 < msgBodyList.length; p2++) {
            if (isIndexUsed(p2, msgOrder, n)) continue;
            msgOrder[n] = p2;
            trialParse(msgOrder, n+1);
          }
        }
      }
      
      // Then copy the best result back to our working message order array
      int[] bestOrder = bestResult.getMsgOrder();
      System.arraycopy(bestOrder, 0, msgOrder, 0, bestOrder.length);
    }
    
    // We have a result!!!!!
    if (preserveProgram) parser.setFieldList(bestProgram);
    return bestResult.getMessage();
  }
  
  private int bestScore;
  private ParseResult bestResult;
  private String  bestProgram;
  
  private void resetBestResult() {
    bestScore = Integer.MIN_VALUE;
    bestResult = null;
    bestProgram = null;
  }
  
  /**
   * Perferm a trial parse for a particular message order
   * @param msgOrder Array containing the message order indexes
   * @param n Number of elements that have been set in msgOrder
   */
  private void trialParse(int[] msgOrder, int n) {
    ParseResult result = new ParseResult(bldWorkingMsgOrder(msgOrder, n));
    int score = result.getScore();
    if (score > bestScore) {
      bestScore = score;
      bestResult = result;
      if (preserveProgram) bestProgram = parser.getProgram();
    }
  }
  
  /**
   * Construct a working msg order array from a temporary working array
   * If all but the last mesage order has been assigned, the last index
   * will be autofilled with the remaining index
   * @param msgOrder working message order array
   * @param n number of elements to use in message order array
   * @return a pristine array of message indexes to be used to construct message
   */
  private int[] bldWorkingMsgOrder(int[] msgOrder, int n) {
    int len = (n == msgOrder.length-1 ? msgOrder.length : n);
    int[] result = new int[len];
    System.arraycopy(msgOrder, 0, result, 0, n);
    fillLast(result);
    return result;
  }
  
  /**
   * If a message index array is exactly matches the number of message parts
   * auto fill the last element with the remaining index value
   * @param msgOrder message index array
   */
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
  
  /**
   * Determine if an index is already used in the n elements of an array
   * @param ndx index to be checked
   * @param msgOrder message order array
   * @param n number of elements to check
   * @return true if index is found
   */
  private boolean isIndexUsed(int ndx, int[] msgOrder, int n) {
    for (int jj = 0; jj < n; jj++) {
      if (ndx == msgOrder[jj]) return true;
    }
    return false;
  }
  
  /**
   * saves status of one attempt to parse a particular combination of message parts
   * The message part array is passed to the constructor and must not be modified
   * afterwards
   */
  private class ParseResult {
    private int[] msgOrder;
    private Message result;
    private int score;
    
    public ParseResult(int[] msgOrder) {
      this.msgOrder = msgOrder;
      result = bldMessage(msgOrder);
      MsgInfo info = result.getInfo();
      if (info != null) {
        score = info.score();
      } else {
        score = Integer.MIN_VALUE+1;
      }
      
      // For the tie breaker, favor combinations in which the
      // last segment is significantly shorter than the others
      int minLen = Integer.MAX_VALUE;
      for (int j = 0; j<msgOrder.length-1; j++) {
        minLen = Math.min(minLen, msgBodyList[msgOrder[j]].length());
      }
      if (msgBodyList[msgOrder[msgOrder.length-1]].length() < minLen-5) score++;
    }
    
    public int[] getMsgOrder() {
      return msgOrder;
    }
    
    public int getScore() {
      return score;
    }
    
    public Message getMessage() {
      return result;
    }
  }

  /**
   * Construct a Message object from trying the message parts in a
   * particular message order
   * @param msgOrder array continuing the message part indexes to be used
   * @return result Message object
   */
  private Message bldMessage(int[] msgOrder) {
    return bldMessage(buildMsgBody(msgOrder));
  }

  /**
   * Construct a Message object from a text message
   * @param body the text message
   * @return result Message object
   */
  private Message bldMessage(String body) {
    Message result = new Message(false, fromAddress, subject, body, options, false);
    parser.isPageMsg(result, MsgParser.PARSE_FLG_FORCE | MsgParser.PARSE_FLG_SKIP_FILTER);
    return result;
  }
  
  /**
   * Construct a text message from different message parts in specified order
   * @param msgOrder array containing the message indexes to be used
   * @return the complete text message
   */
  private String buildMsgBody(int[] msgOrder) {
    String[] msgList = new String[msgOrder.length];
    for (int jj = 0; jj < msgOrder.length; jj++) {
      msgList[jj] = msgBodyList[msgOrder[jj]];
    }
    return buildMsgBody(msgList);
  }

  /**
   * Construct a text message from an array of message parts
   * @param msgBodyList array of message parts
   * @return the complete text message
   */
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
