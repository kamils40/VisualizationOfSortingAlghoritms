package Alghoritms;

import GUI.ArrayDrafter;

import javax.swing.*;

public class QuickSort extends SortAlghoritm {

    private ArrayDrafter drafter;
   
    public QuickSort(int[] array, ArrayDrafter drafter)
    {
        super(array);
        this.drafter = drafter;
        
    }
    public int iteration(int lowIndex, int highIndex, SwingWorker sw)
    {
        int pivot = highIndex;
        int i = lowIndex -1;
        for(int j=lowIndex; j<highIndex; j++)
        {
            if(isBigger(pivot,j))
            {

                    i++;
                    swap(i, j);

                }

            }

         swap(i+1,pivot);
//        drafter.ChangeArray(this.array);
        return i+1;
    }

    @Override
    public void sort() { }
    public int getLength()
    {
       return this.array.length;
    }
    public void sort(int begin, int end, SwingWorker sw)
    {

        if(begin < end)
        {
            int partition = iteration(begin,end,sw);

            try {
                sort(begin, partition - 1,sw);
            }
            finally {
                sort(partition + 1, end,sw);
            }
        }

    }


    public boolean isArraySorted()
    {
        for(int i = 1; i<super.array.length; i++)
        {
            if(isBigger(i-1,i))
            {
                return false;
            }
        }
        return true;
    }
    public boolean isPartOfArraySorted(int begin, int end)
    {
        for(int i = begin; i<end; begin++)
        {

            if(!isBigger(begin,begin+1))
            {
                return false;
            }
        }
        return true;
    }


    }


