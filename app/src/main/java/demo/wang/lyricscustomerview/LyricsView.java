package demo.wang.lyricscustomerview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.width;

/**
 * Created y zhiwei.wang on 2017/8/17.
 */

public class LyricsView extends LinearLayout {
    List<String> lyrics = new ArrayList<>();
    Context context;

    public LyricsView(Context context) {
        super(context);
        this.context = context;
    }

    public LyricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public LyricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }
    public void setData(List<String> lyricsList){
        lyrics = lyricsList;
        for(int index=0;index<lyricsList.size();index++){
            TextView textView = new TextView(context);
            LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.setLayoutParams(layoutParams);
            textView.setText(lyricsList.get(index));
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.RED);
            textView.setTextSize(40);
            LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textLayoutParams.bottomMargin = 40;
            textLayoutParams.topMargin = 20;
            textView.setLineSpacing(20,1);
            textView.setLayoutParams(textLayoutParams);
            linearLayout.setGravity(Gravity.CENTER);
            linearLayout.addView(textView);
            addView(linearLayout);
        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize =  MeasureSpec.getSize(heightMeasureSpec);
        int chlidCount = getChildCount();
        int measureHeight = 0;

        for(int index = 0; index < chlidCount; index ++){
            View child = getChildAt(index);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams)child.getLayoutParams();
            measureHeight = measureHeight + child.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY ? widthSize:width),(heightMode == MeasureSpec.EXACTLY ? heightSize : measureHeight));

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int childCount = getChildCount();
        int measureHeight = 0;
        for(int index = 0; index < childCount; index ++ ){
            View child = getChildAt(index);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams)child.getLayoutParams();
            measureHeight = measureHeight + marginLayoutParams.topMargin;
            child.layout(0,measureHeight,child.getMeasuredWidth() +  marginLayoutParams.leftMargin + marginLayoutParams.rightMargin,measureHeight  + child.getMeasuredHeight() + marginLayoutParams.bottomMargin);
            measureHeight = measureHeight  + child.getMeasuredHeight() + marginLayoutParams.bottomMargin;
        }
    }
}
