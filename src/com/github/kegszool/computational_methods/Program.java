package com.github.kegszool.computational_methods;

import com.github.kegszool.computational_methods.lab_1.SimpleMethodIteration;
import com.github.kegszool.computational_methods.lab_2.*;
import com.github.kegszool.computational_methods.lab_3.NewtonsMethod_3;
import com.github.kegszool.computational_methods.lab_4.LagrangeMethod;

public class Program {
    public static void main(String[] args){

//        SimpleMethodIteration.getSolution();
//
//        NewtonsMethod_2.checkConvergenceMethod();
//        NewtonsMethod_2.getSolution(NewtonsOperation.ORDINARY);
//        NewtonsMethod_2.getSolution(NewtonsOperation.MODIFIDED);

//        NewtonsMethod_3.getSolution();
        LagrangeMethod.check(1.45);
        LagrangeMethod.check(1.36);
        LagrangeMethod.check(1.14);

        LagrangeMethod.check(1);

    }
}