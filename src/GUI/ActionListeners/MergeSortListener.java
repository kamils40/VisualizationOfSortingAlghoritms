package GUI.ActionListeners;

import GUI.ArrayDrafter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MergeSortListener implements ActionListener {
    private ArrayDrafter drafter;
    public MergeSortListener(ArrayDrafter drafter)
    {
        this.drafter = drafter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startThread();
    }

    public void startThread()
    {

        SwingWorker sw = new SwingWorker() {
            public void merge(int lowest, int middle, int highest)
            {
                int[] array = drafter.getArray();

                int temp[] = new int[highest - lowest + 1];
                int i = lowest, j=middle+1,k=0;
                while(i <= middle && j<=highest)
                {
                    if(array[i] <= array[j])
                    {
                        temp[k] = array[i];
                        i+=1;
                        k+=1;
                    }
                    else
                    {
                        temp[k] = array[j];
                        j+=1;
                        k+=1;
                    }
                }
                while(i<=middle)
                {
                    temp[k] = array[i];
                    ++i;
                    ++k;
                }
                while(j<=highest)
                {
                    temp[k] = array[j];
                    ++j;
                    ++k;
                }
                for(i=lowest; i<=highest; ++i)
                {
                   array[i] =temp[i-lowest];
                    drafter.setSingleColor(i);
                    drafter.ChangeArray(array);

                    try {
                        Thread.sleep(50);
                    }
                    catch(Exception e)
                    {
                        // not implemented yet
                    }


                    publish(array);
                }


            }
            public void sort(int lowest, int highest)
            {
                if(lowest<highest)
                {
                    int middle = (lowest + highest) / 2;
                    sort(lowest,middle);
                    sort(middle+1,highest);
                    merge(lowest,middle,highest);
                }
            }
            @Override
            protected int[] doInBackground() throws Exception {

                    sort(0,drafter.getArray().length-1);

                return drafter.getArray();
            }
            protected void process(List chunks)
            {
                int[] val = (int[]) chunks.get(chunks.size()-1);
                drafter.ChangeArray(val);
            }
        };
        sw.execute();
    }
}
