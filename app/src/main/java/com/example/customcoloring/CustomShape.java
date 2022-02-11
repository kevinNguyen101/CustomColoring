package com.example.customcoloring;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;

/**
 * @Author Kevin Nguyen
 * @Version 1.0.0
 * Date: 1 February 2022
 */
/**
 * External Citation
 * Date:   1 February 2022
 * Problem:    Unsure how to create a custom drawing
 * Resource:   HW Optional Code @Andrew Nuxoll
 * Solution:   Used code provided to create an abstract
 */
public abstract class CustomShape {
    public static final int TAP_MARGIN = 10;
    protected Paint mainPaint = new Paint();
    protected Paint strokePaint = new Paint();
    protected  Paint highlight = new Paint();
    protected String name = "";

    protected boolean isSelected = false;

    public CustomShape(String initName, int initColor){
        setColor(initColor);
        name = initName;

        strokePaint.setColor(Color.BLACK);
        strokePaint.setStyle(Paint.Style.STROKE);

        highlight.setColor(Color.YELLOW);
        highlight.setStyle(Paint.Style.STROKE);
        highlight.setStrokeWidth(5);
        highlight.setShadowLayer(5, 1, 1, Color.MAGENTA);

    }
    public String getName(){
        return name;
    }
    public void setColor(int newColor){
        if (newColor == mainPaint.getColor()){
            return;
        }
        else{
            mainPaint.setColor(newColor);
        }
    }
    public int getColor(){
        return mainPaint.getColor();
    }
    public abstract void drawMe(Canvas canvas);
    public abstract boolean containsPoint(int x, int y);
    public abstract int getSize();
    public abstract void drawHighlight(Canvas canvas);
}

