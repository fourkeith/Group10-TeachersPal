package com.example.fitfourdesktop.group10_teacherspal;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Tyler Wilson
 * @author Lucas Bittencourt
 * @author Keith Wheeler
 */
public class Memory extends AppCompatActivity implements View.OnClickListener {

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    // Integer for holding the score
    private Integer score;

    private int numberOfElements;

    private MemoryButton[] buttons;

    private int[] buttonGraphicPositions;
    private int[] buttonGraphicIDs;

    private MemoryButton firstButton;
    private MemoryButton secondButton;

    private boolean isBusy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridLayout gridLayout = (GridLayout)findViewById(R.id.memoryGame);
        int numColumns = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            numColumns = gridLayout.getColumnCount();
        }
        int numRows = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            numRows = gridLayout.getRowCount();
        }
        numberOfElements = numColumns * numRows;

        buttons = new MemoryButton[numberOfElements];

        buttonGraphicIDs = new int[numberOfElements / 2];

        buttonGraphicIDs[0] = R.drawable.button_1;
        buttonGraphicIDs[1] = R.drawable.button_2;
        buttonGraphicIDs[2] = R.drawable.button_3;
        buttonGraphicIDs[3] = R.drawable.button_4;
        buttonGraphicIDs[4] = R.drawable.button_5;
        buttonGraphicIDs[5] = R.drawable.button_6;
        buttonGraphicIDs[6] = R.drawable.button_7;
        buttonGraphicIDs[7] = R.drawable.button_8;

        buttonGraphicPositions = new int[numberOfElements];

        shuffleButtons();

        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                MemoryButton tmpButton = new MemoryButton(this, row, column,
                        buttonGraphicIDs[buttonGraphicPositions[row * numColumns + column]]);
                if (Build.VERSION.SDK_INT < 17) {
                    for (;;) {
                        final int result = sNextGeneratedId.get();
                        int newValue = result + 1;
                        if (newValue > 0x00FFFFFF)
                            newValue = 1;
                        if (sNextGeneratedId.compareAndSet(result, newValue)) {
                            tmpButton.setId(result);
                        }
                    }
                } else {
                    tmpButton.setId(View.generateViewId());
                }
                tmpButton.setOnClickListener(this);
                buttons[row * numColumns + column] = tmpButton;
                gridLayout.addView(tmpButton);
            }
        }

    }

    protected void shuffleButtons() {
        Random random = new Random();

        /* First, this will create each button on a fixed,
           ordered position inside the GridLayout */
        for (int i = 0; i < numberOfElements; i++) {
            buttonGraphicPositions[i] = i % (numberOfElements / 2);
        }

        /* Then, all of the positions will be swapped,
           giving the game some randomness */
        for (int i = 0; i < numberOfElements; i++) {
            int tmp = buttonGraphicPositions[i];
            int swapIndex = random.nextInt(16);
            buttonGraphicPositions[i] = buttonGraphicPositions[swapIndex];
            buttonGraphicPositions[swapIndex] = tmp;
        }

    }

    public Integer getScore() {
        Log.i("Teachers_Pal", "getScore: " + score);
        return score;
    }

    public void setScore() {}

    @Override
    public void onClick(View view) {

        // This is used to avoid button mashing that could lead to crash
        if (isBusy) {
            return;
        }

        MemoryButton button = (MemoryButton) view;

        // If the player presses a button that already has been matched, nothing happens
        if (button.isMatched) {
            return;
        }

        // If the player presses a new button, it'll flip the card
        if (firstButton == null) {
            firstButton = button;
            firstButton.flip();
            return;
        }

        // If the player presses that same button again, nothing happens
        if (firstButton.getId() == button.getId()) {
            return;
        }

        // If the player presses the matching button, they win
        // TODO: Increase score at this point
        if (firstButton.getFrontDrawableID() == button.getFrontDrawableID()) {
            button.flip();
            button.setMatched(true);
            firstButton.setMatched(true);

            firstButton.setEnabled(false);
            button.setEnabled(false);

            firstButton = null;

            return;
        }
        // If the player fails to match the cards, they'll flip back
        else {
            secondButton = button;
            secondButton.flip();
            isBusy = true;

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    firstButton.flip();
                    secondButton.flip();
                    firstButton = null;
                    secondButton = null;
                    isBusy = false;
                }
            }, 500);

        }

    }
}
