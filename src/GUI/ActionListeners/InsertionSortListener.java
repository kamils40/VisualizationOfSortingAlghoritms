package GUI.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Alghoritms.InsertionSort;
import GUI.ArrayDrafter;

import javax.swing.*;

public class InsertionSortListener implements ActionListener {

    private InsertionSort sorter;
    private ArrayDrafter drafter;
    private int index;

    public InsertionSortListener(ArrayDrafter drafter)
    {
        this.drafter = drafter;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        startThread();

    }


    public void startThread()
    {
        SwingWorker sw = new SwingWorker()
        {



            @Override
            protected int[] doInBackground() throws Exception {
                while(!drafter.isArraySorted())
                {
                    for (int n = 1; n < drafter.getArray().length - 1; n++) {

                        int j = n;
                        while (j > 0 && drafter.getArray()[j] < drafter.getArray()[j - 1]) {
                             drafter.swap(j,j-1);
                             publish(drafter.getArray());
                             try
                             {
                                Thread.sleep(100);
                            } catch (Exception e) {
                                // not implemented yet
                            }

                            j = j - 1;

                        }

                    }
                }
                return drafter.getArray();

            }
            protected void process(List chunks) {
                int[] val = (int[]) chunks.get(chunks.size() - 1);

                drafter.ChangeArray(val);
            }
        };
        sw.execute();
    }
}
