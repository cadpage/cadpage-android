package net.anei.cadpage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

public class HistoryMsgTextView extends TextView {
  
  private SmsMmsMessage msg;
  
  public HistoryMsgTextView(Context context, SmsMmsMessage message) {
    super(context);
    this.msg = message;
    
    long time = msg.getTimestamp();
    String text = DateFormat.getLongDateFormat(context).format(time) + " " +
                  DateFormat.getTimeFormat(context).format(time) +
                  (msg.isLocked() ? " (L)" : "") +
                  "\n" + msg.getCall();
    setText(text);
    if (! msg.isRead()) setTypeface(Typeface.DEFAULT_BOLD);
    
    this.setOnClickListener(new OnClickListener(){

      @Override
      public void onClick(View v) {
        ManageNotification.clear(getContext());
        
        // Flag message read
        msg.setRead(true);
        SmsMessageQueue.dataChange();
        
        // display message popup
        SmsPopupActivity.launchActivity(getContext(), msg);
      }});
  }

}
