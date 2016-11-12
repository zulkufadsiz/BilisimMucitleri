package com.example.samsung.bestprediction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import java.util.Random;
import android.os.Handler;
import java.util.logging.LogRecord;

public class main extends AppCompatActivity implements View.OnClickListener {
    private int numberOfElements;
    private MemoryButton[] buttons;

    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    private MemoryButton selectButton1;
    private MemoryButton selectButton2;

    private  boolean isBusy = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = (GridLayout)findViewById(R.id.grid_layout01);

        int numColoumns  = gridLayout.getColumnCount();
        int numRows = gridLayout.getRowCount();

        numberOfElements = numColoumns * numRows;

        buttons = new MemoryButton[numberOfElements];

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

        shuffleButtonGraphics();
        for (int r = 0; r < numRows; r++) {

            for (int c = 0; c < numColoumns; c++) {

                MemoryButton tempMemoryButton  = new MemoryButton(this,r,c,
                        buttonGraphics[buttonGraphicLocations[r * numColoumns + c]]);
                tempMemoryButton.setId(View.generateViewId());
                tempMemoryButton.setOnClickListener(this);
                buttons[r * numColoumns + c] = tempMemoryButton;
                gridLayout.addView(tempMemoryButton);

            }
        }

    }

    protected  void shuffleButtonGraphics(){

        Random rnd = new Random();

        for (int i = 0; i<numberOfElements; i++){
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }

        for (int i = 0; i< numberOfElements; i++){

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

        MemoryButton button = (MemoryButton) view;

        if (button.isMatched())
            if (selectButton1 == null) {
                selectButton1 = button;
                selectButton1.flip();
                return;
            }
            if (selectButton1.getId() == button.getId())
                return;
            if (selectButton1.getFrontDrawableId() == button.getFrontDrawableId()) {
                button.flip();

                button.setMatched(true);
                selectButton1.setMatched(true);

                selectButton1.setEnabled(false);
                button.setEnabled(false);

                selectButton1 = null;
                return;

            } else {

                selectButton2 = button;
                selectButton2.flip();
                isBusy = true;

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        selectButton1.flip();
                        selectButton2.flip();
                        selectButton1 = null;
                        selectButton2 = null;
                        isBusy = false;
                    }
                },500);


            }

    }
}
