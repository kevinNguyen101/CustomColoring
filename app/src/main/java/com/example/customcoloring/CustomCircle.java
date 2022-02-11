package com.example.customcoloring;

import android.graphics.Canvas;
import android.graphics.Rect;
/**
 * @Author Kevin Nguyen
 * @Version 1.0.0
 * Date: 1 February 2022
 */
/**
 * external citation
 * Date:   1 February 2022
 * problem:    Creating an element that is circular
 * Resource:   HW Optional Code @Andrew Nuxoll
 * Solution:   Used code provided to create an element
 */
public class CustomCircle extends CustomShape {


    private int x;
    private int y;
    private int radius;


    public CustomCircle(String initName, int initColor, int x, int y, int radius){
        super(initName, initColor);

        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawCircle(x, y, radius, mainPaint);
        canvas.drawCircle(x, y, radius, strokePaint);
    }


    @Override
    public boolean containsPoint(int x, int y) {
        int xDist = Math.abs(x - this.x);
        int yDist = Math.abs(y - this.y);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);

        return (dist < this.radius + TAP_MARGIN);
    }


    @Override
    public int getSize() {
        return (int)(Math.PI * this.radius * this.radius);
    }


    @Override
    public void drawHighlight(Canvas canvas) {

        canvas.drawCircle(x, y, radius, highlight);
        canvas.drawCircle(x, y, radius, strokePaint);
    }

}

