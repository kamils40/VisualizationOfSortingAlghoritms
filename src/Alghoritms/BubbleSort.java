package Alghoritms;

import GUI.ArrayDrafter;



public class BubbleSort extends SortAlghoritm {

    private ArrayDrafter drafter;
    public BubbleSort(int[] array, ArrayDrafter drafter)
    {
        super(array);
        this.drafter = drafter;
    }
    @Override
    public void sort() {

        {
            for(int i = 1; i<super.array.length; i++)
            {
                if(isBigger(i-1, i))
                {
                  swap(i,i-1);
                    break;
                }



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

    public void sortOne(int n)
    {
        if(isBigger(n-1,n))
        {
            drafter.swap(n-1,n);
            setArray(drafter.getArray());
        }
    }

}
