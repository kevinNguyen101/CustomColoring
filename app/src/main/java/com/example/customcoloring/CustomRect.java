package com.example.customcoloring;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * @author Kevin Nguyen
 * @version 1.0.0
 * Date: 1 February 2022
 */

/**
 * External Citation
 * Date: 1 February 2022
 * Problem: Creating an element shape as a rect
 * Resource: HW Optional Code @Andrew Nuxoll
 * Solution: Used the code provided
 */
public class CustomRect extends CustomShape {

    protected Rect myRect;

    public CustomRect(String name, int color,
                      int left, int top, int right, int bottom)
    {
        super(name, color);

        this.myRect = new Rect(left, top, right, bottom);
    }


    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawRect(myRect, mainPaint);
        canvas.drawRect(myRect, strokePaint);
    }

    @Override
    public boolean containsPoint(int x, int y) {


        int left = this.myRect.left - TAP_MARGIN;
        int top = this.myRect.top - TAP_MARGIN;
        int right = this.myRect.right + TAP_MARGIN;
        int bottom = this.myRect.bottom + TAP_MARGIN;
        Rect r = new Rect(left, top, right, bottom);

        return r.contains(x, y);
    }


    @Override
    public int getSize() {
        return this.myRect.width() * this.myRect.height();
    }

    @Override
    public void drawHighlight(Canvas canvas) {
        canvas.drawRect(myRect, highlight);
        canvas.drawRect(myRect, strokePaint);
    }




}//class CustomRect
