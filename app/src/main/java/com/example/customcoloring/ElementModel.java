package com.example.customcoloring;

import static android.graphics.Color.argb;

import android.graphics.Color;

import java.util.ArrayList;

/** ElementModel
 * @author Kevin Nguyen
 * @version February 2022
 *
 * Contains the data of all the elements intractable in the surfaceView
 */
public class ElementModel {
    public ArrayList<CustomShape> elementList = new ArrayList<>();


    public ElementModel(){
        elementList.add(new CustomCircle("Snowman Base",0xFFFFFFFF,600,1300,300));
        elementList.add(new CustomCircle("Snowman Body", 0xFFFFFFF, 600, 800, 200));
        elementList.add(new CustomCircle("Snowman Head",0xFFFFFFFF,600,450,150));
        elementList.add(new CustomRect("Hat",0xFF000000,500,100,700,325));
        elementList.add(new CustomRect("Left Arm",0xFF581845,150,775,400,825));
        elementList.add(new CustomRect("Right Arm",0xFF581845,800,775,1100,825));
    }

    /**
     * External citation
     * Date: 10 February 2022
     * Problem: making an int color using three ints
     * Resource: https://developer.android.com/reference/android/graphics/Color#argb(int,%20int,%20int,%20int)
     * Solution: use argb to make an int from rgb values
     */
    public void changeColor(int red, int green, int blue){
        int colorRGB = argb(255, red, green, blue);
        for (CustomShape i:elementList) {
            if(i.isSelected == true){
                i.setColor(colorRGB);
            }
        }
    }

    /**
     * External citation
     * Date: 10 February 2022
     * Problem: returning only certain color values from one color int source (i.e Red, Green, Blue)
     * Resource: https://stackoverflow.com/questions/17183587/convert-integer-color-value-to-rgb
     * Solution: use Color method .red, .green, .blue to get that certain value of the color
     */

    public int getColorRed(){
        for (CustomShape i:elementList) {
            if(i.isSelected == true){
                return Color.red(i.getColor());
            }
        }
        return -1;
    }
    public int getColorGreen(){
        for (CustomShape i:elementList) {
            if(i.isSelected == true){
                return Color.green(i.getColor());
            }
        }
        return -1;
    }
    public int getColorBlue(){
        for (CustomShape i:elementList) {
            if(i.isSelected == true){
                return Color.blue(i.getColor());
            }
        }
        return -1;
    }
}
