/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import dto.Static.Item;
import java.util.ArrayList;

/**
 *
 * @author Robert
 */
public class ItemUtils {
    
    /**
     * this should do:
     * purchase/complete new item
     * if u complete new item u gotta remove the original items.
    */
    public static Item PurchaseItem(ArrayList<Item> purchasedItems, Item itemToPurchase)
    {
        
    }
    
    /**
     * this should do:
     * do compare dps for each item in loldmg.LolDmg.itemList
     * and find the one that increases dps by most
     * also keep in mind that u need to have at max 6x items in purchasedItems
     * 
     */
    public static Item FindBestItemToPurchase(ArrayList<Item> purchasedItems, Champion myChamp, Champion target, int level, int currentGold)
    {
    }
    
}
