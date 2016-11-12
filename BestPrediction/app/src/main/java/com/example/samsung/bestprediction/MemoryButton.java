package com.example.samsung.bestprediction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by samsung on 12.11.2016.
 */

public class MemoryButton extends Button {

    protected int row;
    protected int coloumn;
    protected int frontDrawableId;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    protected Drawable front;
    protected Drawable back;

    public MemoryButton(Context context, int r , int c, int frontImageDrawableId ) {
        super(context);

        row = r;
        coloumn = c;
        frontDrawableId = frontImageDrawableId;

        front = context.getDrawable(frontImageDrawableId);
        back = context.getDrawable(R.drawable.cardback);

        setBackground(back);

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r),
                GridLayout.spec(c));

        tempParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        tempParams.height = GridLayout.LayoutParams.WRAP_CONTENT;

        setLayoutParams(tempParams);


    }

    public boolean isMatched (){ return isMatched; }
    public void setMatched(boolean matched){ isMatched = matched;}
    public int getFrontDrawableId(){ return  frontDrawableId; }

    public void flip(){
        if (isMatched())
            return;
        if (isFlipped){
            setBackground(back);
            isFlipped = false;
        }else{
            setBackground(front);
            isFlipped = true;
        }
    }
}
