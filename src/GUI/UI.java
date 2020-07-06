package GUI;
import java.awt.*;
import javax.swing.*;
import Alghoritms.*;
public class UI implements Runnable {

   // private ArrayDrafter drafter;
    private JFrame frame;

    public UI()
    {

       // drafter = new ArrayDrafter(new RandomArrayCreator(50).randomizeArray());
       // AOP = new ArrayOptionPanel();
    }
    public void run()
    {
        frame = new JFrame("Visualisation of sorting algorithms");
        frame.setPreferredSize(new Dimension(1000,1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void createComponents(Container container)
    {
        ArrayDrafter drafter = new ArrayDrafter(new RandomArrayCreator(1).randomizeArray());

       // AlgorithmPanel AP = new AlgorithmPanel(drafter);
        BoxLayout layout = new BoxLayout(container, BoxLayout.PAGE_AXIS);
        container.setLayout(layout);
        FinalPanel FP = new FinalPanel(drafter);

        container.add(FP);


       // container.add(new JSlider(JSlider.HORIZONTAL, 0, 100, 50));
    }
}
