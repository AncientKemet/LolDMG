/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import dto.Static.ChampionSpell;
import dto.Static.Item;
import java.util.ArrayList;
import java.util.List;
import static loldmg.LolDmg.itemList;

/**
 *
 * @author Robert
 */
public class ItemUtils {

    /**
     * this should do: purchase/complete new item if u complete new item u gotta
     * remove the original items.
     */
    static ArrayList<Item> finalItems;
    static int dps = 0;
    static int gold = 0;

    public  void PurchaseMaxItems(ArrayList<Item> purchasedItems,  Champion myChamp, Champion target, int level, int cash) {
        if (purchasedItems.size() < 6) {
            for (String key : itemList.getData().keySet()) {
                if (itemList.getData().get(key).getGold().getBase() < cash) {
                    purchasedItems.add(itemList.getData().get(key));
                    PurchaseMaxItems(purchasedItems,  myChamp, target, level, cash - itemList.getData().get(key).getGold().getBase());
                }
            }
        }
        else{
        //calculate dps for each item
        List<ChampionSpell> rotation = null;
        ChampionSpell aa = new ChampionSpell();
        rotation.add(aa);

        int dps2 = Graph.rotationdps(myChamp, target, rotation, purchasedItems, level);

        if (dps2 > dps) {
            System.out.println("max curr dps= " + dps2);
            dps = dps2;
            finalItems = purchasedItems;
            gold = cash;
        }
       
    }
         purchasedItems.remove(purchasedItems.size()-1);
    }

    public  ArrayList<Item> FindBestItemsToPurchase(ArrayList<Item> currentItems,  Champion myChamp, Champion target, int level, int currentGold) {
        PurchaseMaxItems(currentItems, myChamp, target, level, currentGold);
        return (finalItems);
    }

}
