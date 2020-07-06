package GUI.ActionListeners;

import Alghoritms.QuickSort;
import GUI.ArrayDrafter;

import javax.swing.*;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuickSortListener implements ActionListener {
    private ArrayDrafter drafter;
    private QuickSort sorter;
    private int index = 0;

    public QuickSortListener(ArrayDrafter drafter)
    {
        this.drafter = drafter;
        this.sorter = new QuickSort(drafter.getArray(),drafter);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        sorter.setArray(drafter.getArray());
        startThread();

    }
    private  void startThread()
    {



            SwingWorker sw1 = new SwingWorker()  {
                public int iteration(int lowIndex, int highIndex) {
                    int pivot = highIndex;
                    int i = lowIndex - 1;
                    for (int j = lowIndex; j < highIndex; j++) {
                        sorter.setArray(drafter.getArray());
                        if (sorter.isBigger(pivot, j)) {

                            i++;
                            drafter.swap(i, j);
                            try {
                                Thread.sleep(100);
                            }
                            catch(Exception e)
                            {
                                // not implemented yet
                            }
                            publish(drafter.getArray());

                        }

                    }
                    sorter.setArray(drafter.getArray());
                    drafter.swap(i+1,pivot);
                    publish(sorter.getArray());
                    return i+1;
                }
                public void sort(int lowIndex, int highIndex)
                {

                    if(lowIndex < highIndex)
                    {
                        int i = iteration(lowIndex,highIndex);
                       // try{
                           sort(lowIndex,i-1) ;
                       // }
                        //finally {
                            sort(i+1, highIndex);
                        //}

                    }
                }
                @Override
                protected int[] doInBackground() throws Exception {
                    sorter.setArray(drafter.getArray());
                    while (!sorter.isArraySorted()) {
                        //Thread.sleep(10);
                        sort(0,sorter.getLength()-1);

                        }


                    return sorter.getArray();
                }
                protected void process(List chunks)
                {
                    int[] val = (int[]) chunks.get(chunks.size()-1);
                    drafter.ChangeArray(val);
                    //drafter.repaint();

                }

                };
            sw1.execute();

    }

}
