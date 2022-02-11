package com.example.customcoloring;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author Kevin Nguyen
 * @version February 2022
 *
 * The controller that checks for user inputs and sends it to the view and model
 */
public class ColorController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    private PictureSurface picView;
    private ElementModel eModel;
    private TextView eText;
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;

    public ColorController(PictureSurface view, SeekBar red, SeekBar green, SeekBar blue){
        picView = view;
        eModel = view.getModel();
        redSeek = red;
        greenSeek = green;
        blueSeek = blue;
    }

    private int touchX;
    private int touchY;


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        /**
         * External citation
         * Problem: Getting the x and y position of the user's touch input
         * Resource: https://stackoverflow.com/questions/19615596/how-can-i-get-the-x-y-location-of-a-touch-relative-to-the-entire-view-when-i-tou#:~:text=2%20Answers&text=To%20get%20the%20touch%20position,()%20and%20getTop()%20methods.
         * Solution: use the getX and getY and put it into a variable (finding the view's position is irrelevant due to it being 0,0)
         */
        touchX = (int)motionEvent.getX();
        touchY = (int)motionEvent.getY();

        for (CustomShape shape: eModel.elementList) {
            shape.isSelected = shape.containsPoint(touchX,touchY);
            //eText.setText(shape.name);
            redSeek.setProgress(eModel.getColorRed());
            greenSeek.setProgress(eModel.getColorGreen());
            blueSeek.setProgress(eModel.getColorBlue());
        }
        picView.invalidate();
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(b) {
            int rVal = eModel.getColorRed();
            int gVal = eModel.getColorGreen();
            int bVal = eModel.getColorBlue();
            switch (seekBar.getId()) {
                case R.id.Red_Seek:
                    rVal = i;
                    break;
                case R.id.Green_Seek:
                    gVal = i;
                    break;
                case R.id.Blue_Seek:
                    bVal = i;
                    break;
            }

            eModel.changeColor(rVal, gVal, bVal);
            picView.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Do Nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Do Nothing
    }
}
