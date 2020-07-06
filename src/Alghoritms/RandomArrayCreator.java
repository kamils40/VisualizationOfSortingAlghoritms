package Alghoritms;
import java.util.Random;
public class RandomArrayCreator {
    private int sizeOfArray;
    private Random random;
    public RandomArrayCreator(int size)
    {
        this.sizeOfArray = size;
        this.random = new Random();
    }
    public int[] randomizeArray()
    {
        int[] array = new int[this.sizeOfArray];
        for(int n = 0; n<this.sizeOfArray; n++)
        {
            array[n] = random.nextInt(100) + 1;
        }
        return array;
    }
}
