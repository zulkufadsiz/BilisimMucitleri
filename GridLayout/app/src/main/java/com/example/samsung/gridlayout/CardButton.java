package com.example.samsung.gridlayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by samsung on 20.11.2016.
 */

public class CardButton extends Button {
    protected  int row;
    protected  int coloumn;

    protected int  frontDrawableId;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    protected Drawable front, back;

    public CardButton(Context context, int r, int c, int isFrontDrawableId) {
        super(context);

        row = r;
        coloumn = c;
        frontDrawableId = isFrontDrawableId;

        back = context.getDrawable(R.drawable.back);
        front = context.getDrawable(isFrontDrawableId);
        setBackground(back);

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(
                GridLayout.spec(r),
                GridLayout.spec(c));

        tempParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        tempParams.height = GridLayout.LayoutParams.WRAP_CONTENT;

        setLayoutParams(tempParams);

    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched){ isMatched = matched;}


    public int getFrontDrawableId(){
        return frontDrawableId;
    }

    public void flip(){
        if(isMatched)
            return;

        if (isFlipped){
            setBackground(back);
        }
        else{
            setBackground(front);
            isFlipped = true;
        }
    }

}
