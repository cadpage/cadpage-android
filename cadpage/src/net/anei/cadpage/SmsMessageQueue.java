package net.anei.cadpage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class SmsMessageQueue implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private static String QUEUE_FILENAME = "message.queue";
  
  private List<SmsMmsMessage> queue = new ArrayList<SmsMmsMessage>();
  private int nextMsgId = 1;
  private Context context;
  private Adapter adapter = null;
  private int newCallCount = 0;
  
  @SuppressWarnings("unchecked")
  private SmsMessageQueue(Context context) {
    this.context = context;
    if (Log.DEBUG) Log.v("SmsMessageQueue: Start");
    ObjectInputStream is = null;
    try {
      is = new ObjectInputStream(
        context.openFileInput(QUEUE_FILENAME));
      queue = (ArrayList<SmsMmsMessage>)is.readObject();
    } catch (FileNotFoundException ex) {
    } catch (Exception ex) {
      Log.e(ex);
    } finally {
      if (is != null) try {is.close();} catch (IOException ex) {}
    }
    
    // Set the next message ID to one more than the highest message ID
    // in the queue, and fix any obsolete location codes
    boolean assign = false;
    for (SmsMmsMessage msg : queue) {
      int msgId = msg.getMsgId();
      if (msgId == 0) assign = true;
      if (msgId >= nextMsgId) nextMsgId = msgId+1;
    }
    
    // First time this release is loaded, the saved messages won't have any
    // message ID's, so they will have to be assigned now.
    if (assign) {
      for (SmsMmsMessage msg : queue) {
        if (msg.getMsgId() == 0) msg.setMsgId(nextMsgId++);
      }
    }
    
    // Update new call count
    calcNewCallCount();
  }

  /**
   * Save queue to persistent file
   */
  private synchronized void save() {
    ObjectOutputStream os = null;
    if (Log.DEBUG) Log.v("SmsMessageQueue: Save");
    try {
      os = new ObjectOutputStream(
        context.openFileOutput(QUEUE_FILENAME, Context.MODE_PRIVATE));
      os.writeObject(queue);
    } catch (IOException ex) {
      Log.e(ex);
    } finally {
      if (os != null) try {os.close();} catch (IOException ex) {}
    }
  }
  
  
  /**
   * Rebuild parse information (if necessary) after the insert blanks between
   * spit message option has changed
   */
  public void splitDelimChange() {
    boolean change = false;
    for (SmsMmsMessage msg : queue) {
      if (msg.splitDelimChange()) change = true;
    }
    if (change) notifyDataChange();
  }

  
  /**
   * Notify call history list that something has changed and view needs to 
   * be refreshed
   */
  public void notifyDataChange() {
	  if (Log.DEBUG) Log.v("SmsMessageQueue: notifyDataChange");  
    if (adapter != null) adapter.notifyDataSetChanged();
    save();
  }
  
  /**
   * Add new message to queue and delete any old messages down to the
   * requested history queue count
   * @param msg message to be added
   */
  public synchronized void addNewMsg(SmsMmsMessage msg) {
	  if (Log.DEBUG) Log.v("SmsMessageQueue: addNewMsg");
    // In theory, the next message ID will overflow after a couple thousand
    // years.  Sounds unlikely, but we must at least consider the possibility
    if (nextMsgId < 0) clearAll();
    
    // Log new message ID while we are trying to track a mysterious problem
    // where Cadpage occasionally brings up a wrong or inappropriate message
    Log.w("New Mesage " + nextMsgId + ": " + msg.getMessageBody());
    
    // Assign next msg ID
    msg.setMsgId(nextMsgId++);
    
    // Add message to beginning of queue
    queue.add(0, msg);
    
    // Get history limit
    int limit = ManagePreferences.historyCount();
    
    // Do we have to delete anything
    int deleteCnt = queue.size() - limit;
    if (deleteCnt > 0) {
      
      // Count the number of messages that can be deleted
      // (read and not locked)
      int availCnt = 0;
      for (SmsMmsMessage m : queue) {
        if (m.isRead() && !m.isLocked()) availCnt++;
      }
      
      // How many of these need to be kept to get us to the right limit
      int keepCnt = Math.max(0, availCnt - deleteCnt);
      
      // Make another pass through the list deleting anything over the keep limit
      for (Iterator<SmsMmsMessage> itr = queue.iterator(); itr.hasNext(); ) {
        SmsMmsMessage m = itr.next();
        if (m.isRead() && !m.isLocked()) {
          if (keepCnt <= 0) itr.remove();
          else keepCnt--;
        }
      }
    }
    calcNewCallCount();
    notifyDataChange();
  }
  
  /**
   * Return message from queue with specified message ID
   * @param msgId requested message ID
   * @return requested message if found, null otherwise
   */
  public SmsMmsMessage getMessage(int msgId) {
	  if (Log.DEBUG) Log.v("SmsMessageQueue: getMessage");
    for (SmsMmsMessage msg : queue) {
      if (msgId == msg.getMsgId()) return msg;
    }
    return null;
  }
  
  /**
   * Delete message from message queue (if preset, read and not locked)
   * @param msg message to be deleted
   */
  public void deleteMessage(SmsMmsMessage msg) {
	  if (Log.DEBUG) Log.v("SmsMessageQueue: deleteMessage");
    // Don't delete unread or locked messages
    if (!msg.canDelete()) return;
    queue.remove(msg);
    notifyDataChange();
  }
  
  /**
   * Remove all expendable (read and not locked) messages
   */
  public void clearAll() {
	  if (Log.DEBUG) Log.v("SmsMessageQueue: clearAll");
    // Delete everything this has been read and isn't locked
    for (Iterator<SmsMmsMessage> itr = queue.iterator(); itr.hasNext(); ) {
      SmsMmsMessage m = itr.next();
      if (m.canDelete()) itr.remove();
    }
    
    if (queue.isEmpty()) nextMsgId = 1;
    
    notifyDataChange();
  }
  
  /**
   * @return ListAdapter that can be bound to ListView to display call history
   */
  public ListAdapter listAdapter(Activity context) {
    adapter = new Adapter(context);
    return adapter;
  }
  
  /**
   * Private ListAdapter class
   */
  private class Adapter extends ArrayAdapter<SmsMmsMessage> {
    
    Activity context;

    public Adapter(Activity context) {
      super(context, 0, queue);
      this.context = context;
    }

    /* (non-Javadoc)
     * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = convertView;
      if (view == null) {
        LayoutInflater li = LayoutInflater.from(context);
        view = li.inflate(R.layout.msg_list_item, parent, false);
        context.registerForContextMenu(view);
      }
      try {
        ((HistoryMsgTextView)view).setMessage(queue.get(position));
      } catch (RuntimeException ex) {
        SmsMsgLogBuffer.getInstance().addCrashMsg(queue.get(position));
        throw ex;
      }
      return view;
    }
  }
  
  /**
   * Recalculate unopened call count
   */
  public void calcNewCallCount() {
    int oldCount = newCallCount;
    newCallCount = 0;
    for (SmsMmsMessage msg : queue) {
      if (!msg.isRead()) newCallCount++;
    }
    if (newCallCount != oldCount) CadPageWidget.update(context);
  }
  
  /**
   * @return unopened call count
   */
  public int getNewCallCount() {
    return newCallCount;
  }

  /**
   * @return message to be displayed when Cadpage starts up, or null if no
   * message should be displayed
   */
  public SmsMmsMessage getDisplayMessage() {
    
    // We don't display a message if there are no queued messge, or if the
    // automatic popup is not enabled
    if (queue.size() == 0) return null;
    if (!ManagePreferences.popupEnabled()) return null;
    
    // First message in queue will be displayed if it has not yet been opened
    SmsMmsMessage msg = queue.get(0);
    if (msg.isRead()) return null;
    return msg;
  }
  
  private static SmsMessageQueue msgQueue = null;
  
  /**
   * Set up singleton message queue object
   * @param context context used to create object
   */
  public static void setupInstance(Context context) {
	  if (Log.DEBUG) Log.v("SmsMessageQueue: SetupInstance");
    if (msgQueue == null) {
      msgQueue = new SmsMessageQueue(context);
    }
  }
  
  /**
   * @return singleton message queue object
   */
  public static SmsMessageQueue getInstance() {
    return msgQueue;
  }
}
