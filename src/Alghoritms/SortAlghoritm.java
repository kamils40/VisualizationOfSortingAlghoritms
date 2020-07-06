package Alghoritms;
import GUI.ArrayDrafter;
public abstract class SortAlghoritm {
    protected int[] array;

    public SortAlghoritm(int[] array)
    {
        this.array = array;

    }
    public int returnIntOnPlace(int place)
    {
        return array[place];
    }

    public void printArray()
    {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public void setArray(int[] array)
    {
        this.array = array;
    }
    public boolean isBigger(int x, int y)
    {
        if(this.array[x] > this.array[y])
        {
            return true;
        }
        return false;
    }
    public abstract void sort();

    public void swap(int i, int y)
    {
        int temp = array[i];
        array[i] = array[y];
        array[y] = temp;


    }
    public int[] getArray()
    {
        return this.array;
    }


}
