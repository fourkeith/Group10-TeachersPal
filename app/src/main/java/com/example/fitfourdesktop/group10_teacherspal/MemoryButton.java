package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.GridLayout;

/**
 * Created by lbittencourt on 07/12/17.
 * @author Lucas Bittencourt
 */

public class MemoryButton extends android.support.v7.widget.AppCompatButton {

    protected int row;
    protected int column;
    protected int frontDrawableID;
    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    // Drawables
    protected Drawable front;
    protected Drawable back;

    public MemoryButton(Context context, int row, int column, int frontImageDrawableID) {

        super(context);

        this.row = row;
        this.column = column;
        this.frontDrawableID = frontImageDrawableID;

        front = ContextCompat.getDrawable(context, frontImageDrawableID);
        back = ContextCompat.getDrawable(context, R.drawable.button_back);

        setBackground(back);
        GridLayout.LayoutParams tmpParams = new GridLayout.LayoutParams(GridLayout.spec(row),
                GridLayout.spec(column));

        tmpParams.width = (int)getResources().getDisplayMetrics().density * 50;
        tmpParams.height = (int)getResources().getDisplayMetrics().density * 50;

        setLayoutParams(tmpParams);

    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontDrawableID() {
        return frontDrawableID;
    }

    public void flip() {
        if (isMatched)
            return;

        if (isFlipped)
        {
            setBackground(back);
            isFlipped = false;
        }
        else {
            setBackground(front);
            isFlipped = true;
        }

    }

}
