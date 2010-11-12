package net.anei.cadpage;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

import com.paypal.android.MEP.CheckoutButton;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalReceiverDetails;
import com.paypal.android.MEP.PayPalPayment;

public class Donate extends Activity {
  
  public boolean CadpageDonate(Context context) {
    
    PayPal ppObj = PayPal.initWithAppID(context, "APP-80W284485P519543T", PayPal.ENV_NONE);
    CheckoutButton launchPayPalButton = ppObj.getCheckoutButton(context, PayPal.BUTTON_278x43, CheckoutButton.TEXT_DONATE);
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    params.bottomMargin = 10;
    launchPayPalButton.setLayoutParams(params);
    //launchPayPalButton.setOnClickListener(this);
    ((RelativeLayout)findViewById(R.id.DonateTextView)).addView(launchPayPalButton);
    
    
    
    
    return false;
    
  }
  
  
  
  
  
}