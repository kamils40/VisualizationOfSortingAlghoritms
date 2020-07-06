package GUI;

import GUI.ActionListeners.*;

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlgorithmPanel extends JPanel{
    private ArrayDrafter drafter;
    private JButton quick;
    private JButton insertion;
    private JButton bubble;
    private JButton heap;
    private JButton merge;

    public AlgorithmPanel(ArrayDrafter drafter)
    {
        super(new GridLayout(1,5));
        this.drafter = drafter;
        CreateComponents();
    }
    private void CreateComponents()
    {

        this.quick = new JButton("QuickSort");
        this.insertion = new JButton("InsertionSort");
        this.bubble = new JButton("BubbleSort");
        this.heap = new JButton("heapSort");
        this.merge = new JButton("MergeSort");

        BubbleSortListener BSL = new BubbleSortListener(drafter);
        InsertionSortListener ISL = new InsertionSortListener(drafter);
        QuickSortListener QSL = new QuickSortListener(drafter);
        MergeSortListener MSL = new MergeSortListener(drafter);
        HeapSortListener HSL = new HeapSortListener(drafter);

        Timer timer1 = new Timer(20,BSL);
        this.bubble.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BSL.resetIndex();
                timer1.start();
            }
        });
        this.merge.addActionListener(MSL);
        this.heap.addActionListener(HSL);
        this.insertion.addActionListener(ISL);
        this.quick.addActionListener(QSL);

        add(this.merge);
        add(this.bubble);
        add(this.insertion);
        add(this.quick);
        add(this.heap);

    }
}
