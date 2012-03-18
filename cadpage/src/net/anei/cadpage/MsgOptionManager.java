package net.anei.cadpage;

import java.util.ArrayList;
import java.util.List;

import net.anei.cadpage.donation.DonationManager;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Class to handle all of the menus and popup buttons associated with a message
 */
public class MsgOptionManager {
  
  private Activity activity;
  private SmsMmsMessage message;
  
  // View group and list of button handlers associated with regular buttons
  private ViewGroup regButtonGroup = null;
  private List<ButtonHandler> regButtonList = new ArrayList<ButtonHandler>();
  
  public MsgOptionManager(Activity activity) {
    this(activity, null);
  }
  
  public MsgOptionManager(Activity activity, SmsMmsMessage message) {
    this.activity = activity;
    this.message = message;
  }
  
  public void setMessage(SmsMmsMessage message) {
    this.message = message;
  }

  /**
   * Create option or context menu for message
   * @param context current context
   * @param menu menu to be constructed
   * @param display true if called from popup menu display
   */
  public void createMenu(Menu menu, boolean display) {
    MenuInflater inflater = activity.getMenuInflater();
    inflater.inflate(R.menu.message_menu, menu);
    if (display) {
      menu.removeItem(R.id.open_item);
    } else {
      menu.removeItem(R.id.close_item);
    }
  }
  
  /**
   * Make any final changes to menu before actually displaying it
   * @param context current context
   * @param menu Message menu needed to be adjusted
   */
  public void prepareMenu(Menu menu) {
    for (int ndx = 0; ndx < menu.size(); ndx++) {
      final MenuItem item = menu.getItem(ndx);
      prepareItem(new ItemObject() {
        
        @Override
        public int getId() {
          return item.getItemId();
        }

        @Override
        public void setEnabled(boolean enabled) {
          item.setEnabled(enabled);
        }

        @Override
        public void setTitle(int resId) {
          item.setTitle(resId);
        }

        @Override
        public void setVisible(boolean visible) {
          item.setVisible(visible);
        }
        
      });
    }
  }

  // List of menu items associated with each button index.
  private static final int[] ITEM_ID_LIST = new int[]{
    0, R.id.ack_item, R.id.map_item, R.id.toggle_lock_item, 
    R.id.delete_item, R.id.close_item, R.id.email_item,
    R.id.publish_item
  };
  
  // List of item title resources associated with each button index
  private static final int[] ITEM_TEXT_LIST = new int[]{
    0, R.string.ack_item_text, R.string.map_item_text, 0, 
    R.string.delete_item_text, R.string.close_item_text, R.string.email_item_text,
    R.string.publish_item_text
  };
  
  public void setupButtons(ViewGroup viewGroup) {
    regButtonGroup = viewGroup;

    // Setup the regular button list
    regButtonList.clear();
    for (int btn = 1; btn <= 6; btn++) {
      int itemNdx = ManagePreferences.popupButton(btn);
      if (itemNdx == 0) continue;
      regButtonList.add(new ButtonHandler(itemNdx, regButtonGroup));
    }
  }

  /**
   * Make any last minute corrections to button statuses
   */
  public void prepareButtons() {
    for (ButtonHandler btnHandler : regButtonList) {
      btnHandler.prepareButton();
    }
  }
  
  /*
   * Internal class to handle dynamic button functions on popup
   */
  private class ButtonHandler implements OnClickListener {
    final private int itemId;
    final private Button button;

    public ButtonHandler(int itemNdx, ViewGroup parent) {
      itemId = ITEM_ID_LIST[itemNdx];
      button = (Button)LayoutInflater.from(activity).inflate(R.layout.popup_button, parent, false);
      button.setId(itemId);
      int resId = ITEM_TEXT_LIST[itemNdx];
      if (resId != 0) button.setText(resId);
      button.setOnClickListener(this);
      parent.addView(button);
    }
    
    public void prepareButton() {
      prepareItem(new ItemObject(){
        
        @Override
        public int getId() {
          return itemId;
        }

        @Override
        public void setEnabled(boolean enabled) {
          button.setEnabled(enabled);
        }

        @Override
        public void setTitle(int resId) {
          button.setText(resId);
        }

        @Override
        public void setVisible(boolean visible) {
          button.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
      });
    }

    public void onClick(View v) {
      
      // Perform the requested action
      menuItemSelected(itemId, true);
      
      // Reset button status in case anything has changed
      prepareButtons();
    }
  }
  
  private interface ItemObject {
    public int getId();
    public void setTitle(int resId);
    public void setEnabled(boolean enabled);
    public void setVisible(boolean visible);
  }
  
  private void prepareItem(ItemObject item) {
    
    switch (item.getId()) {
    
    // Disabled button is never visible
    case 0:
      item.setVisible(false);
      break;
    
    // Disable map item if we have no address
    case R.id.map_item:
      item.setEnabled(message.getInfo().getAddress().length() > 0);
      break;
    
    // Change label on toggle lock item depending on current lock state
    case  R.id.toggle_lock_item:
      item.setTitle(message.isLocked() ? R.string.unlock_item_text : R.string.lock_item_text);
      break;
      
    // Delete is only enabled if message has been read and is not locked
    case R.id.delete_item:
      item.setEnabled(message.canDelete());
      break;
    
    // Email is disabled for the free version
    case R.id.email_item:
      item.setEnabled(! DonationManager.instance().isFreeVersion());
      break;
    }
   
  }

  /**
   * Handle a menu selection concerning this message
   * @param itemId Selected Menu ID
   * @param display true if called from message display dialog
   * @return true if menu item processed, false otherwise
   */
  public boolean menuItemSelected(int itemId, boolean display) {
    
    // Any button clears the notice
    ManageNotification.clear(activity);
    message.acknowledge(activity);

    switch (itemId) {
    case R.id.open_item:
      SmsPopupActivity.launchActivity(activity, message);
      return true;
      
    case R.id.ack_item:
      // Doesn't do anything yet (except clear notification)
      return true;
      
    case R.id.map_item:
      mapMessage(activity, false);
      return true;
      
    case R.id.toggle_lock_item:
      message.toggleLocked();
      return true;
      
    case R.id.delete_item:
      SmsMessageQueue.getInstance().deleteMessage(message);
      if (display) activity.finish();
      return true;
      
    case R.id.close_item:
      activity.finish();
      return true;
      
    case R.id.email_item:
      EmailDeveloperActivity.sendMessageEmail(activity,  message.getMsgId());
      return true;
      
    case R.id.publish_item:
      message.broadcastIntent(activity, true);
    
    default:
      return false;
    }
  }

  /**
   * Request map location for message
   * @param context current context
   * @param useGPS use GPS location in preference to regular address
   */
  private void  mapMessage(Context context, boolean useGPS)  {
    if (Log.DEBUG) Log.v("Request Received to Map Call");
    
    String searchStr = message.getMapAddress(useGPS);
    if (searchStr == null) return;
    
    if (!SmsPopupUtils.haveNet(context)) return;

    searchStr = searchStr.replaceAll(" *& *", " AT ");
    Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(searchStr));
    if (Log.DEBUG) Log.v("mapMessage: SearchStr=" + searchStr);
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    
    try {
        context.startActivity(intent);
    } catch (ActivityNotFoundException ex) {
        Log.e("Could not find com.google.android.maps.Maps activity");
    }
  }

}
