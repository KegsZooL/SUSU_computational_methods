package com.github.kegszool.computational_methods;

import com.github.kegszool.computational_methods.lab_1.SimpleMethodIteration;
import com.github.kegszool.computational_methods.lab_2.*;

public class Program {
    public static void main(String[] args){

//        SimpleMethodIteration.getSolution();
        NewtonsMethod.checkConvergenceMethod();
        NewtonsMethod.getSolution(NewtonsOperation.ORDINARY);
        NewtonsMethod.getSolution(NewtonsOperation.MODIFIDED);
    }
}