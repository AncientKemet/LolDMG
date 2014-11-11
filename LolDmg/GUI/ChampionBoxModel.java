/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.GUI;

import dto.Static.Champion;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Robert
 */
class ChampionBoxModel implements ComboBoxModel {
    
    private ArrayList<ListDataListener> listeners = new ArrayList<>();

    public ChampionBoxModel() {
        setSelectedItem(getElementAt(0));
    }
    
    private Champion selected = null;

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (Champion) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return loldmg.LolDmg.championList.getData().keySet().toArray().length;
    }

    @Override
    public Object getElementAt(int index) {
        return loldmg.LolDmg.championList.getData().get(loldmg.LolDmg.championList.getData().keySet().toArray()[index]);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }
    
}
