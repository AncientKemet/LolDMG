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
    public static Item[] allItems;
    static ArrayList<Item> finalItems;
    static int dps = 0;
    public static int gold = 0;

    public static void PurchaseMaxItems(ArrayList<Item> purchasedItems,  Champion myChamp, Champion target, int level, int cash) {
        if (purchasedItems.size() < 6) {
            for (int i = 0; i < allItems.length; i++) {
                
                Item item = allItems[i];
                if (item.getGold().getTotal() > 359)
                if (item.getGold().getTotal() < cash) {
                    purchasedItems.add(item);
                    
                    PurchaseMaxItems(purchasedItems,  myChamp, target, level, cash - item.getGold().getTotal());
                }
            }
        }
        //calculate dps for each item
        List<ChampionSpell> rotation = new ArrayList<ChampionSpell>();
        ChampionSpell aa = new ChampionSpell();
        rotation.add(aa);

        int dps2 = Graph.rotationdps(myChamp, target, rotation, purchasedItems, level);

        if (dps2 > dps) {
            //System.out.println("max curr dps= " + dps2);
            dps = dps2;
            finalItems = (ArrayList<Item>) purchasedItems.clone();
            gold = cash;
                        
        }
        if(!purchasedItems.isEmpty())
         purchasedItems.remove(purchasedItems.size()-1);
    }

    public static ArrayList<Item> FindBestItemsToPurchase(ArrayList<Item> currentItems,  Champion myChamp, Champion target, int level, int currentGold) {
        PurchaseMaxItems(currentItems, myChamp, target, level, currentGold);
        System.out.println("build");
            for (Item item : finalItems) {
                System.out.println(""+item.getName());
            }
        return (finalItems);
    }

}
