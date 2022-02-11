package com.example.customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceView;
import android.widget.TextView;

import java.util.ArrayList;

/** PictureSurface
 * @author Kevin Nguyen
 * @version February 2022
 *
 * The "View" of the program. Will draw out the elements from the model
 */
public class PictureSurface extends SurfaceView {

    private ElementModel elements = new ElementModel();



    public PictureSurface(Context context){
        super(context);
        //elements = new ElementModel();
        setWillNotDraw(false);
        //elementName = findViewById(R.id.Element_Text);
    }
    public PictureSurface(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
    }
    public PictureSurface(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
    }

    public ElementModel getModel(){
        return elements;
    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        setBackgroundColor(Color.WHITE);
        for (CustomShape shape : elements.elementList) {
            shape.drawMe(canvas);
            if (shape.isSelected == true) {
                shape.drawHighlight(canvas);
            }
        }

    }
}
