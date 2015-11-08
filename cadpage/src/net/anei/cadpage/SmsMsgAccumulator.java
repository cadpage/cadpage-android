package net.anei.cadpage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.SplitMsgOptions;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * This class is responsible for processing incoming SMS text messages so they
 * can be merged back into individual CAD page messages 
 *
 */
public class SmsMsgAccumulator {
  
  private static final String TIMEOUT_ACTION = "net.anei.cadpage.SmsMsgAccumalator.TIMEOUT_ACTION";
  private static final String EXTRA_TIMEOUT_ID = "net.anei.cadapge.SmsMsgAccumulator.TIMEOUT_ID";

  private List<MessageList> msgQueue = new LinkedList<MessageList>();
  
  /**
   * Add new text message to message accumulator
   * @param newMsg message to be added
   * @return true if message was accepted, which means receiver should abort
   * the message broadcast unless configured to not do so.
   */
  public synchronized boolean addMsg(Context context, SmsMmsMessage newMsg) {
    return addMsg(context, newMsg, false);
  }
  
  /**
   * Add new text message to message accumulator
   * @param context current context
   * @param newMsg message to be added
   * @force true to force processing of msg (like for GCM messages)
   * @return true if message was accepted, which means receiver should abort
   * the message broadcast unless configured to not do so.
   */
  public synchronized boolean addMsg(Context context, SmsMmsMessage newMsg, boolean force) {
    
    // See if this is a recognizable page or general alert.
    // This only fails if this is not a forced call and does not
    // match the sender address filter.  It needs to be called
    // now because callers will want to check on the general alert
    // run report status.
    int flags = (force ? SmsMmsMessage.PARSE_FLG_FORCE : 0);
    boolean isPage = newMsg.isPageMsg(flags);
    if (!isPage) return false;
    
    // First step is to see if this msg matches any of the currently 
    // accumulating messages
    MessageList curList = null;
    for (MessageList list : msgQueue) {
      if (list.matches(newMsg)) {
        curList = list;
        break;
      }
    }
    
    // Did we find a match?
    if (curList != null) {
      
      // Yes we did
      // add the new message to this message list
      curList.addMsg(newMsg);
      
      // If we have a complete message list, set up as the next return messsage
      // remove if from the processing queue
      // and cancel any pending timeout for this list
      // If the queue is empty, release the KeepAliveService lock
      if (curList.isComplete()) {
        processCadPage(curList.getMessage());
        msgQueue.remove(curList);
        setReminder(context, curList.getTimeoutId(), true);
        if (msgQueue.isEmpty())
          unregisterKeepAlive(context);
      }
      
      // In any case, this message has been accepted
      return true;
    }
    
    // If the message contains counters indicating that there is more to follow
    // of if configuration settings expect more than one message as a minimum
    // or if the location parser determines that more data is expected, Create
    // a new message list to build an accumulated CAD page, and start the timeout
    // timer for this message list.
    if (isSplitCad(newMsg)) {
      if (msgQueue.isEmpty()) {
        registerKeepAlive(context);
      }
      MessageList list = new MessageList(newMsg);
      msgQueue.add(list);
      setReminder(context, list.getTimeoutId(), false);
      return true;
    }
    
    // Otherwise simply pass this message into the output queue
    processCadPage(newMsg);
    return true;
  }
  
  protected void  processCadPage(SmsMmsMessage newMsg) {
    SmsReceiver.processCadPage(newMsg);
  }

  protected void registerKeepAlive(Context context) {
    KeepAliveService.register(context, this, R.drawable.ic_stat_notify,
                              R.string.notification_msg_acc_title,
                              R.string.notification_msg_acc_text);
  }
  
  /**
   * Determine if an incoming message is the first of a possible sequence of
   * text messages generated from a single CAD page
   * @param msg message to be checked
   * @return true if this is a possible split message CAD page
   */
  private boolean isSplitCad(SmsMmsMessage msg) {

    // If this message has a message count, life is easy
    // return false if the count is 1 and true if it is > 1
    int msgCount = msg.getMsgCount();
    if (msgCount == 1) return false;
    if (msgCount > 1) return true;
    
    // If there is a configured minimum message count > 1, return true
    if (msg.getSplitMsgOptions().splitMinMsg() > 1) return true;
    return msg.expectMore();
  }

  /**
   * Set up an alarm to timeout and process a reconstructed message if the
   * expected other parts of the page never show up
   * @param msgTimeout timeout interval in seconds
   */
  protected void setReminder(Context context, long id, boolean cancel) {

    Intent intent = new Intent(TIMEOUT_ACTION);
    intent.setClass(context, SmsMsgAccumulatorService.class);
    intent.putExtra(EXTRA_TIMEOUT_ID, id);
    
    // We don't really use it, but it keeps the alarm intents functionally distinct
    intent.setData(Uri.parse("Cadpage://" + id));

    int flags = (cancel ? PendingIntent.FLAG_NO_CREATE : PendingIntent.FLAG_ONE_SHOT);
    PendingIntent pendIntent = PendingIntent.getService(context, 0, intent, flags);
    if (cancel) {
      if (pendIntent != null) pendIntent.cancel();
    } else {
      AlarmManager myAM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
      int msgTimeout = ManagePreferences.partMsgTimeout();
      long triggerTime = System.currentTimeMillis() + (msgTimeout * 1000);
      myAM.set(AlarmManager.RTC_WAKEUP, triggerTime, pendIntent);
    }
  }

  public synchronized void handleIntent(Context context, Intent intent) {
    
    // Make sure this is the correct action and retrieve timeout ID
    if (!TIMEOUT_ACTION.equals(intent.getAction())) return;
    long id = intent.getLongExtra(EXTRA_TIMEOUT_ID, 0);
    if (id == 0) return;
    
    processTimeout(context, id);
  }

  public void processTimeout(Context context, long id) {
    // If nothing in queue, nothing to worry about
    if (msgQueue.isEmpty()) return;
    
    // First step is to see if this msg matches any of the currently 
    // accumulating messages
    for (MessageList list : msgQueue) {
      if (list.getTimeoutId() == id) {
        processCadPage(list.getMessage());
        msgQueue.remove(list);
        break;
      }
    }
    
    // If we removed everything, cancel the keep alive service
    if (msgQueue.isEmpty())
      unregisterKeepAlive(context);
  }

  protected void unregisterKeepAlive(Context context) {
    KeepAliveService.unregister(context, this);
  }
  
  /**
   * private list containing some number of text messages being compiled into
   * a single CAD message
   */
  private static class MessageList {
    
    private int count;  // Expected message count
    private List<SmsMmsMessage> list = new ArrayList<SmsMmsMessage>();
    private SmsMmsMessage firstMessage;
    private SmsMmsMessage lastMessage;
    
    private transient SmsMmsMessage result = null;

    /**
     * Construct new message list based on incoming message
     * @param newMsg incoming message
     */
    public MessageList(SmsMmsMessage newMsg) {
      firstMessage = newMsg;
      count = newMsg.getMsgCount();
      if (count > 0) {
        for (int j = 0; j<count; j++) list.add(null);
      }
      addMsg(newMsg);
    }
    
    /**
     * Determine if new message belongs in this message list
     * @param newMsg new message
     * @return true if new message should be added to this list
     */
    public boolean matches(SmsMmsMessage newMsg) {
      
      // If req msg count is differen't don't even consider it
      if (newMsg.getMsgCount() != count) return false;
      
      // Ditto if message has a different direct page parser code
      // which could potentially result in a merge options mismatch
      String newLocation = newMsg.getReqLocation();
      String oldLocation = firstMessage.getReqLocation();
      if ((newLocation == null) ^ (oldLocation == null)) return false;
      if (newLocation != null && !newLocation.equals(oldLocation)) return false;
      
      // This message must have been sent within 30 seconds of last message
      if (newMsg.getSentTime() - lastMessage.getSentTime() > 30000) return false;
      
      // There is an option to not check the sender address. But we have to check
      // something or we will accumulate messages from anyone, whether or not
      // they pass any sender filters in place.  What we will do is accept
      // this as a match if either the first or last 4 characters are the same
      String newAddr = newMsg.getFromAddress();
      String lastAddr = lastMessage.getFromAddress();
      SplitMsgOptions options = newMsg.getSplitMsgOptions();
      if (! options.splitChkSender()) {
        if (newAddr.length() >= 4 && lastAddr.length() >= 4) {
          if (newAddr.substring(0,4).equals(lastAddr.substring(0,4))) return true;
          if (newAddr.substring(newAddr.length()-4).equals(lastAddr.substring(lastAddr.length()-4))) return true;
        }
      }
      
      // We generally expect a complete sender address match
      if (newAddr.equals(lastAddr)) return true;
      
      // if they don't match, we will check the last 3 characters of both addresses
      // if they form sequential numbers, we'll take that
      int len = newAddr.length();
      if (len >= 3 && lastAddr.length() == len) {
        try {
          int newSeq = Integer.parseInt(newAddr.substring(len-3));
          int lastSeq = Integer.parseInt(lastAddr.substring(len-3));
          if (newSeq == lastSeq + 1) return true;
        } catch (NumberFormatException ex) {}
      }
      return false;
    }

    /**
     * Add new message to message list
     * @param newMsg new message to be added
     */
    public void addMsg(SmsMmsMessage newMsg) {
      result = null;
      lastMessage = newMsg;
      if (count > 0) {
        int ndx = newMsg.getMsgIndex();
        if (ndx <= count) list.set(ndx-1, newMsg);
      } else {
        list.add(newMsg);
      }
    }
    
    /**
     * @return true if message list forms a complete message
     */
    public boolean isComplete() {
      
      // If we are looking for a specific number of messages, see if they
      // are all present
      if (count > 0) {
        for (SmsMmsMessage msg : list) {
          if (msg == null) return false;
        }
        return true;
      }
      
      // Retrieve current message
      SmsMmsMessage msg = getMessage();
      if (msg == null) return true;
      
      // If there is a minimum count that we have not reached, return false
      int minCount = msg.getSplitMsgOptions().splitMinMsg();
      if (list.size() < minCount) return false;
      
      // Otherwise, invoke the current location parser and see if it thinks
      // we have a complete message.  If we have an impossible parse failure
      // return complete so we can get rid of this message
      
      msg.isPageMsg(MsgParser.PARSE_FLG_FORCE);
      return !msg.expectMore();
    }

    /**
     * @return timeout associated with this message list
     */
    public long getTimeoutId() {
      return firstMessage.getTimestamp();
    }
    
    /**
     * Convert list into a combined message
     * @return
     */
    public SmsMmsMessage getMessage() {
      if (result == null) result = new SmsMmsMessage(firstMessage, list);
      
      // We have to call isPageMsg() to do the initial message parsing,
      // and we have to force processing because the component text messages
      // have already been blocked from getting to the regular messaging app.
      // If the parse still fails despite the force flag (very bady news)
      // make this message disappear
      if (!result.isPageMsg(SmsMmsMessage.PARSE_FLG_FORCE)) result = null;
      return result;
    }
  }
  
  private static SmsMsgAccumulator instance = new SmsMsgAccumulator();
  
  public static SmsMsgAccumulator instance() {
    return instance;
  }
}
