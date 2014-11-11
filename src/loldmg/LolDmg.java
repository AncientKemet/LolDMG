/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg;

import constant.Region;
import dto.Static.Item;
import dto.Static.ItemList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;

/**
 *
 * @author Robert
 */
public class LolDmg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RiotApi api = new RiotApi("e445f0eb-c76f-456e-b255-22931dcf8fef");
        api.setRegion(Region.EUNE);
        try {
            ItemList item = api.getDataItemList();
            for (String key : item.getData().keySet()) {
                System.out.println("Item["+key+"] : "+item.getData().get(key).getName());
            }
            
        } catch (RiotApiException ex) {
            Logger.getLogger(LolDmg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
