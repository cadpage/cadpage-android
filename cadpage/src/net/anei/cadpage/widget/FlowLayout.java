package net.anei.cadpage.widget;

import net.anei.cadpage.Log;
import net.anei.cadpage.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
  
  private static final int JUSTIFY_LEFT = 1;
  private static final int JUSTIFY_RIGHT = 2;
  private static final int JUSTIFY_CENTER = 3;
  private static final int JUSTIFY_FILL = 4;
  
  private static final boolean DEBUG = true;
	private int mHorizontalSpacing;
	private int mVerticalSpacing;
	private boolean mBalance;
	private int mJustify;

	public FlowLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
		try {
			mHorizontalSpacing = a.getDimensionPixelSize(R.styleable.FlowLayout_horizontalSpacing, 0);
			mVerticalSpacing = a.getDimensionPixelSize(R.styleable.FlowLayout_verticalSpacing, 0);
			mBalance = a.getBoolean(R.styleable.FlowLayout_balance, false);
			mJustify = a.getInt(R.styleable.FlowLayout_justify, JUSTIFY_CENTER);
		} finally {
			a.recycle();
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	  if (DEBUG)
	    Log.w("FlowLayout.onMeasure() WSpec:" + MeasureSpec.toString(widthMeasureSpec) + 
	                                " HSpec:" + MeasureSpec.toString(heightMeasureSpec));
    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    int realWidth = MeasureSpec.getSize(widthMeasureSpec);
    
	  int widthSize;
	  int childWidthSpec;
    if (widthMode == MeasureSpec.UNSPECIFIED) {
      widthSize = Integer.MAX_VALUE;
      childWidthSpec = MeasureSpec.UNSPECIFIED;
    } else {
      widthSize = realWidth;  
      childWidthSpec = 
          MeasureSpec.makeMeasureSpec(MeasureSpec.AT_MOST, widthSize-getPaddingLeft()-getPaddingRight());
    }
    
    // Start by calculating the desired size of each child
    final int count = getChildCount();
    for (int ndx = 0; ndx < count; ndx++) {
      View child = getChildAt(ndx);
      measureChild(child, childWidthSpec, MeasureSpec.UNSPECIFIED);
      if (DEBUG) Log.w("B" + ndx + "  W:" + child.getMeasuredWidth() + "  H:" + child.getMeasuredHeight());
    }
    
    // If the balance option is set, we will multiple calls to calclayout
    // the first locks the window height.  Then we will make calls progressively
    // reducing the effective width to the point where it will for a layout
    // change.  The one we want is the minimal effective width that has the
    // same window height as are original call
    if (mBalance) {
      calcLayout(widthSize, -1);
      int height = getMeasuredHeight();
      while (true) {
        int trialWidth = getMeasuredWidth()-1;
        calcLayout(trialWidth, -1);
        if (getMeasuredHeight() > height) break;
        widthSize = trialWidth;
      }
    }
    
    // If we know the exact window width, we can pass that to calcLayout
    if (widthMode == MeasureSpec.EXACTLY) { 
      calcLayout(widthSize, realWidth);
    } 
    
    // Otherwise we need to make two passes, one to compute the actual window
    // width, and a second to use that width to accurately position each child
    // window.  We can skip the second pass if all children are left justified
    // because in that case the real window width in irrelevant.
    else {
      calcLayout(widthSize, -1);
      if (mJustify != JUSTIFY_LEFT) calcLayout(widthSize, getMeasuredWidth());
    }
    
    // In any case, calcLayout doesn't apply the measurement restrictions so 
    // we have to do that when it returns
    setMeasuredDimension(resolveSize(getMeasuredWidth(), widthMeasureSpec),
                         resolveSize(getMeasuredHeight(), heightMeasureSpec));
	}
	
	/**
	 * Perform a child layout calculation
	 * @param widthSize effective width limit
	 * @param realWidth actual window width (negative if undetermined)
	 */
	private void calcLayout(int widthSize, int realWidth) {
	  
	  if (DEBUG) Log.w("calcLayout for size " + widthSize + "  real size " + realWidth);

	  // Reduce width limit to make room for right pad
	  widthSize -= getPaddingRight();
	  realWidth -= getPaddingRight();
	  
		int width = 0;
		int height = getPaddingTop();

		int currentWidth = getPaddingLeft();
		int nextPos = currentWidth;
		int currentHeight = 0;

		int lastBreakNdx = 0;
		boolean breakLine = false;

		int count = getChildCount();
		for (int ndx = 0; ndx < count; ndx++) {
			View child = getChildAt(ndx);

			LayoutParams lp = (LayoutParams) child.getLayoutParams();
		  int spacing = mHorizontalSpacing;
			if (lp.horizontalSpacing >= 0) spacing = lp.horizontalSpacing;

			if (breakLine || nextPos + child.getMeasuredWidth() > widthSize) {
			  adjustPosition(lastBreakNdx, ndx, realWidth - currentWidth);
			  lastBreakNdx = ndx;
				height += currentHeight + mVerticalSpacing;
				currentHeight = 0;
				width = Math.max(width, currentWidth);
				nextPos = currentWidth = getPaddingLeft();
			}

			lp.x = nextPos;
			lp.y = height;
      if (DEBUG) Log.w("B" + ndx + "  X:" + lp.x + "  Y:" + lp.y);

			currentWidth = nextPos + child.getMeasuredWidth();
			nextPos = currentWidth + spacing;
			currentHeight = Math.max(currentHeight, child.getMeasuredHeight());
			
			breakLine = lp.breakLine;
		}

    adjustPosition(lastBreakNdx, count, realWidth - currentWidth);
  	height += currentHeight;
		width = Math.max(width, currentWidth);

		width += getPaddingRight();
		height += getPaddingBottom();

		if (DEBUG) Log.w("Result  W:" + width + "  H:" + height);
		setMeasuredDimension(width, height);
	}
	
	/**
	 * Adjust horizontal position of all child views for this row
	 * @param startNdx index of first child view on this row
	 * @param endNdx index of first child view on next row
	 * @param extra amount of extra pixels to be distributed 
	 */
	private void adjustPosition(int startNdx, int endNdx, int extra) {
	  
	  // If there is no or negative space, don't do anything
	  // this will be the case if a negative real size was padded
	  if (extra <= 0) return;
	  
	  // Left justify doesn't require any adjustments
	  if (mJustify == JUSTIFY_LEFT) return;
	  
	  // The fill option is the hard one
	  if (mJustify ==- JUSTIFY_FILL) {
	    
	  }
	  else {
  	  int adj = mJustify == JUSTIFY_RIGHT ? extra : extra/2;
  	  if (DEBUG) Log.w("adjustPosition for " + startNdx + "-" + endNdx + " by " + adj);
  	  for (int ndx = startNdx; ndx < endNdx; ndx++) {
  	    View child = getChildAt(ndx);
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        lp.x += adj;
  	  }
	  }
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
	  if (DEBUG) Log.w("FlowLayout.onLayout() changed:" + changed + " left:" + l + " top:" + t + " right:" + r + " bot:" + b);
		final int count = getChildCount();
		for (int i = 0; i < count; i++) {
			View child = getChildAt(i);
			LayoutParams lp = (LayoutParams) child.getLayoutParams();
			child.layout(lp.x, lp.y, lp.x + child.getMeasuredWidth(), lp.y + child.getMeasuredHeight());
		}
	}

	@Override
	protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
		return p instanceof LayoutParams;
	}

	@Override
	protected LayoutParams generateDefaultLayoutParams() {
		return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	}

	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new LayoutParams(getContext(), attrs);
	}
	
	@Override
	protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
		return new LayoutParams(p.width, p.height);
	}

	public static class LayoutParams extends ViewGroup.LayoutParams {
		int x;
		int y;
		
		public int horizontalSpacing;
		public boolean breakLine;

		public LayoutParams(Context context, AttributeSet attrs) {
			super(context, attrs);
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout_LayoutParams);
			try {
				horizontalSpacing = a.getDimensionPixelSize(R.styleable.FlowLayout_LayoutParams_layout_horizontalSpacing, -1);
				breakLine = a.getBoolean(R.styleable.FlowLayout_LayoutParams_layout_breakLine, false);
			} finally {
				a.recycle();
			}
		}

		public LayoutParams(int w, int h) {
			super(w, h);
		}
	}
}
