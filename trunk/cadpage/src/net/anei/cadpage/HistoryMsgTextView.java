package net.anei.cadpage;

import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class HistoryMsgTextView extends TextView {
  public static final String CADPAGE_REFRESH = "update";
  private SmsMmsMessage msg;
  public HistoryMsgTextView(Context context) {
    super(context);
    setup();
  }
  
  public HistoryMsgTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    setup();
  }
  
  public HistoryMsgTextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    setup();
  }
  
  private void setup() {
    setLines(2);
    this.setOnClickListener(new OnClickListener(){

      @Override
      public void onClick(View v) {
        
        // Clear any active notification and wake locks
        ClearAllReceiver.clearAll(getContext());
        
        if (msg == null) return;
        
        // display message popup
        SmsPopupActivity.launchActivity(getContext(), msg);
      }});
  }
  
  public void setMessage(SmsMmsMessage message) {
    this.msg = message;
    Context context = getContext();

    long time = msg.getIncidentDate().getTime();
    String text = DateFormat.getLongDateFormat(context).format(time) + " " +
                  DateFormat.getTimeFormat(context).format(time) +
                  (msg.isLocked() ? " (Locked)" : "") +
                  "\n" + msg.getInfo().getTitle();
    float ftextSize = Integer.parseInt(ManagePreferences.textSize());
    this.setTextSize(ftextSize);
    setText(text);
    setTextColor(msg.isRead() ? Color.WHITE : Color.YELLOW);
  }

  public SmsMmsMessage getMessage() {
    return msg;
  }
}
