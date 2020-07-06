package GUI.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Alghoritms.BubbleSort;
import GUI.ArrayDrafter;

import javax.swing.*;


public class BubbleSortListener implements ActionListener {

    private ArrayDrafter drafter;
    private BubbleSort sorter;
    private int index;

    public BubbleSortListener( ArrayDrafter drafter)
    {

        this.drafter = drafter;
        this.sorter = new BubbleSort(drafter.getArray(),drafter);
        this.index = 1;
    }
    public void resetIndex()
    {
        this.index = 1;
    }
    public void checkIndex()
    {
        if(this.index==this.sorter.getArray().length)
        {
            resetIndex();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.sorter.setArray(drafter.getArray());
        if(this.sorter.isArraySorted())
        {
            ((Timer)e.getSource()).stop();
        }
        else
        {
            checkIndex();
            sorter.sortOne(index);

        }
        this.index++;
        drafter.repaint();
    }
}
