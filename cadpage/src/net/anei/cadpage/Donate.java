package net.anei.cadpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.paypal.android.MEP.CheckoutButton;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalPayment;
import com.paypal.android.MEP.PayPalReceiverDetails;
 


public class Donate extends Activity implements OnClickListener {
  
  public boolean CadpageDonate(Context context) {
    
    PayPal ppObj = PayPal.initWithAppID(context, "APP-80W284485P519543T", PayPal.ENV_NONE);
    
    
    CheckoutButton launchPayPalButton = ppObj.getCheckoutButton(context, PayPal.BUTTON_278x43, CheckoutButton.TEXT_DONATE);
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
    params.bottomMargin = 10;
    launchPayPalButton.setLayoutParams(params);
    launchPayPalButton.setOnClickListener(this);
    ((RelativeLayout)findViewById(R.id.DonateTextView)).addView(launchPayPalButton);
    
    
    
    
    return false;
    
  }
  public void onClick (View v) {

    PayPalPayment newPayment = new PayPalPayment();
            newPayment.setCurrencyType("USD");
            newPayment.setRecipient("support@cadpage.org");
            Intent checkoutIntent = new Intent(this, PayPalActivity.class);
            checkoutIntent.putExtra(PayPalActivity.EXTRA_PAYMENT_INFO, newPayment);
            this.startActivityForResult(checkoutIntent, 1);
    
  }
  
  public void onActivityResults(int requestCode, int resultCode, Intent data) {
  switch(resultCode) {
  case Activity.RESULT_OK:
  break;
  case Activity.RESULT_CANCELED:
  break;
  case PayPalActivity.RESULT_FAILURE:
  }

  }
  
  
  
}