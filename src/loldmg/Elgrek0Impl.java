/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg;

import loldmg.Code.Interfaces.GraphInterface;

/**
 *
 * @author Robert
 */
public class Elgrek0Impl implements GraphInterface {

    @Override
    public void NewData(int x, int value) {
        System.out.println("x: "+x+" value: "+value);
    }
    
}
