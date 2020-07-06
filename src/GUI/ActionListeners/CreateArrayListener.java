package GUI.ActionListeners;

import GUI.ArrayDrafter;

import javax.swing.*;
import Alghoritms.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CreateArrayListener implements ChangeListener {

    private JSlider slider;

    private int SliderValue;
    private ArrayDrafter drafter;
    public CreateArrayListener( JSlider slider, ArrayDrafter drafter)
    {
        this.SliderValue = 0;
        this.slider = slider;
        this.drafter = drafter;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.SliderValue =  slider.getValue();
        this.drafter.ChangeArray(new RandomArrayCreator(this.SliderValue).randomizeArray());
        this.drafter.setBarColours(this.SliderValue);
    }



}
