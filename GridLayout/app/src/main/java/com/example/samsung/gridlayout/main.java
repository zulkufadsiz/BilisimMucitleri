package com.example.samsung.gridlayout;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import java.util.Random;

public class main extends AppCompatActivity  implements View.OnClickListener {
    private int numberOfElements;

    private CardButton[] buttons;
    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    private CardButton selectedCard1;
    private CardButton selectedCard2;

    private boolean isBusy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout mGridLayout = (GridLayout) findViewById(R.id.gridLayout01);
        int numRows = mGridLayout.getRowCount();
        int numColoumns = mGridLayout.getColumnCount();

        numberOfElements = numRows * numColoumns;

        buttons = new CardButton[numberOfElements];

        buttonGraphics = new int[numberOfElements / 2];

        buttonGraphics[0] = R.drawable.card1;
        buttonGraphics[1] = R.drawable.card2;
        buttonGraphics[2] = R.drawable.card3;
        buttonGraphics[3] = R.drawable.card4;
        buttonGraphics[4] = R.drawable.card5;
        buttonGraphics[5] = R.drawable.card6;
        buttonGraphics[6] = R.drawable.card7;
        buttonGraphics[7] = R.drawable.card8;


        buttonGraphicLocations = new int[numberOfElements];

        kartlariKaristir();

        for (int r = 0;r<numRows;r++){
            for (int c = 0;c<numColoumns;c++){
                CardButton tempButton = new CardButton(this,r,c,
                        buttonGraphics[buttonGraphicLocations[r * numColoumns + c]]);
                tempButton.setId(View.generateViewId());
                tempButton.setOnClickListener(this);
                 buttons[r * numColoumns + c] = tempButton;
                mGridLayout.addView(tempButton);
            }
        }


    }

    public void kartlariKaristir() {
        Random rnd = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }

        for (int i = 0; i < numberOfElements; i++) {
            int temp = buttonGraphicLocations[i];
            int swapindex = rnd.nextInt(numberOfElements);
            buttonGraphicLocations[i] = buttonGraphicLocations[swapindex];
            buttonGraphicLocations[swapindex] = temp;
        }
    }

    @Override
    public void onClick(View view) {
        if (isBusy)
            return;

        CardButton button = (CardButton) view;
        if (button.isMatched())
            return;
        if (selectedCard1 == null) {
            selectedCard1 = button;
            selectedCard1.flip();
            return;
        }
        if (selectedCard1.getId() == button.getId()) {
            button.flip();

            button.setMatched(true);
            selectedCard1.setEnabled(false);
            button.setEnabled(false);

            selectedCard1 = null;
            return;
        } else {
            selectedCard2 = button;
            selectedCard2.flip();
            isBusy = true;

            final Handler handler = new Handler();
         handler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 selectedCard1.flip();
                 selectedCard2.flip();
                 selectedCard1 = null;
                 selectedCard2 = null;
                 isBusy = false;
             }
         },500);

        }
    }
}
