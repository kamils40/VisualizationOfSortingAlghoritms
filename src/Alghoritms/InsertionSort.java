package Alghoritms;

import GUI.ArrayDrafter;

public class InsertionSort extends SortAlghoritm {

    private ArrayDrafter drafter;
    public InsertionSort(int[] array,ArrayDrafter drafter)
    {
        super(array);
        this.drafter = drafter;
    }

    public int swapUntilSmallerArgument(int x)
    {

            int key = super.array[x];
            setArray(drafter.getArray());
            while( super.array[x-1] > key)
            {
                drafter.swap(x,x-1);
                setArray(drafter.getArray());

                x=x-1;

                if(x==0)
                {
                    return 0;
                }

            }
            return x;
        }


    public void sortOne(int n)
    {
        swapUntilSmallerArgument(n);
        setArray(drafter.getArray());
        //drafter.repaint();
    }
    @Override
    public void sort() {
        for(int n = 1; n<super.array.length; ++n)
        {
            //swapUntilSmallerArgument(n);
        }
    }
}
