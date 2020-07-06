package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Alghoritms.*;
public class ArrayDrafter extends JPanel {
    private int[] array;
    private  int[] barColours;
    public ArrayDrafter(int[] array)
    {
        super.setBackground(Color.WHITE);
        this.array = array;
        this.barColours = new int[this.array.length-1];
    }



    protected void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        printArray(graphics);
    }
    public void swap(int i, int y)
    {
        int temp = array[i];
        array[i] = array[y];
        array[y] = temp;

        barColours[i] = 100;
        barColours[y] = 100;
        repaint();
    }
    private void printArray(Graphics graphics)
    {
            int j = getHeight();
            int i = getWidth();
        for(int x = 0; x<this.array.length-1;x++){
            {
                if(barColours[x] ==0)
                {
                    graphics.setColor(Color.GRAY);
                }
                else
                {
                    graphics.setColor(Color.GREEN);
                }
                graphics.fillRect(x * i / this.array.length, j - array[x] * 3, i / this.array.length, array[x] * 3);

            }

        }
        resetColours();
    }
    public void setBarColours(int n)
    {
        this.barColours = new int[n];
    }
    private void resetColours()
    {
        for(int x=0; x<this.array.length-1;x++)
        {
            barColours[x]=0;
        }
    }
    public void setSingleColor(int n)
    {
        barColours[n]=100;
    }




    public void ChangeArray(int[] array)
    {
        this.array = array;
        repaint();
    }
    public int[] getArray()
    {
        return this.array;
    }

    public boolean isArraySorted()
    {
        for(int i = 1; i<this.array.length; i++)
        {
            if(array[i-1] > array[i])
            {
                return false;
            }
        }
        return true;
    }
}
