package GUI.ActionListeners;

import GUI.ArrayDrafter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HeapSortListener implements ActionListener {
    private ArrayDrafter drafter;

    public HeapSortListener(ArrayDrafter drafter)
    {
        this.drafter= drafter;
    }
    public void actionPerformed(ActionEvent e)
    {

        StartThread();
    }

    private void StartThread()
    {
        SwingWorker sw = new SwingWorker()
        {
            public void heapify(int n, int i)
            {
                int largest = i;
                int l =2*i +1;
                int r = 2*i +2;
                if(l<n && drafter.getArray()[l] > drafter.getArray()[largest])
                {
                    largest = l;

                }
                if(r<n &&  drafter.getArray()[r] > drafter.getArray()[largest])
                {
                    largest = r;

                }
                if(largest != i)
                {
                    drafter.swap(i,largest);
                    publish(drafter.getArray());

                    try
                    {
                        Thread.sleep(50);
                    } catch (Exception e) {
                        // not implemented yet
                    }
                    heapify(n,largest);
                }
            }
            public void sort() {

                int n = drafter.getArray().length -1;
                for (int i = n / 2 - 1; i >= 0; i--) {
                    heapify(n, i);
                }
                for (int i = n - 1; i > 0; i--)
                {
                    drafter.swap(0,i);

                    heapify(i,0);
                    try
                    {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        // not implemented yet
                    }
                    publish(drafter.getArray());
                }
            }
            @Override
            protected int[] doInBackground() throws Exception {

                sort();

            return drafter.getArray();
        }
            protected void process(List chunks)
            {
                int[] val = (int[]) chunks.get(chunks.size()-1);
                drafter.ChangeArray(val);
                drafter.repaint();
            }
        };
        sw.execute();
    }
}
