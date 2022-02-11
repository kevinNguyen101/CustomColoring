package com.example.customcoloring;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

/**
 * @author Kevin Nguyen
 * @version 1.0.0
 * Date: 1 February 2022
 *
 * MainActivity is where the initialization of listeners are at. Will allow the controller to connect with the model and view
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        PictureSurface surface = findViewById(R.id.Drawing_Surface);

        SeekBar redVal = findViewById(R.id.Red_Seek);
        SeekBar greenVal = findViewById(R.id.Green_Seek);
        SeekBar blueVal = findViewById(R.id.Blue_Seek);
        ColorController controller = new ColorController(surface,redVal,greenVal,blueVal);

        surface.setOnTouchListener(controller);
        redVal.setOnSeekBarChangeListener(controller);
        greenVal.setOnSeekBarChangeListener(controller);
        blueVal.setOnSeekBarChangeListener(controller);
    }

}