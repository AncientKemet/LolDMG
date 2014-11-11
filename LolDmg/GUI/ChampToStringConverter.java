/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.GUI;

import dto.Static.Champion;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Robert
 */
public class ChampToStringConverter extends Converter {

    @Override
    public Object convertForward(Object value) {
        return ((Champion)value).getName();
    }

    @Override
    public Object convertReverse(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
