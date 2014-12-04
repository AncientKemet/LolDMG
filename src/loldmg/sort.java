/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg;

import dto.Static.BasicDataStats;
import dto.Static.Item;
import dto.Static.ItemList;

/**
 *
 * @author User
 */
public class sort {

 static   Item[] getaditems(ItemList allitems) {
        Item[] tempstorage = new Item[allitems.getData().size()];
        int loc = 0;
        for (Item i : allitems.getData().values()) {
            if(i!=null && i.getMaps() == null){
            BasicDataStats stats =i.getStats();
            if (stats.getPercentAttackSpeedMod() > 0 || stats.getFlatCritChanceMod() > 0 || stats.getFlatPhysicalDamageMod() > 0 || stats.getrFlatArmorPenetrationMod() > 0 || stats.getrPercentArmorPenetrationMod() > 0) {
                tempstorage[loc] = i;
                loc++;
            }
            }
            
        }
        Item[] finalstorage=new Item[loc];
        System.arraycopy(tempstorage, 0, finalstorage, 0, loc);
        return(finalstorage);
    }
    

    //        if (stats.getFlatMagicDamageMod() > 0||  stats.getrPercentMagicPenetrationMod() > 0 || stats.getrFlatMagicPenetrationMod() > 0) {


}

