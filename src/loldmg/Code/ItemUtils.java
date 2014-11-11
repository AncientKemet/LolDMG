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
    static int dps=0;
    static int gold=0;

    public static void PurchaseItem(ArrayList<Item> purchasedItems, ArrayList<Item> purchasableItems,Champion myChamp, Champion target, int level, int cash) {
        if (purchasedItems.size() < 6) {
            for (int i = 0; i < purchasableItems.size(); i++) {
                if (purchasableItems.get(i).getGold().getBase() < cash) {
                    purchasedItems.add(purchasableItems.get(i));
                    PurchaseItem(purchasedItems, purchasableItems,myChamp,target,level, cash - purchasableItems.get(i).getGold().getBase());
                }
            }
        }
        System.out.println("dps goes here");

        //calculate dps for each item
        List<ChampionSpell> rotation = null;
        ChampionSpell aa=new ChampionSpell();
        rotation.add(aa);
        int dps2=Graph.rotationdps(myChamp,target,rotation,purchasedItems,level);
        if(dps2>dps){
            dps=dps2;
            finalItems=purchasedItems;
            gold=cash;}
    }

    public static ArrayList<Item> FindBestItemToPurchase(ArrayList<Item> currentItems, ArrayList<Item> purchasableItems,Champion myChamp, Champion target, int level, int currentGold) {
        PurchaseItem(currentItems, purchasableItems,myChamp,target,level,currentGold);
        return (finalItems);
    }

}
