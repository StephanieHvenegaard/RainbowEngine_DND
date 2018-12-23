/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.dnd.map;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import the_nights.rainbow_engine.graphics.Sprite;
import the_nights.rainbow_engine.graphics.SpriteSheet;
/**
 *
 * @author Stephanie
 */
public class TileSet {

    SpriteSheet sheet;
    ArrayList<BaseTile> tiles;

    public TileSet(File tilesFile, SpriteSheet sheet) {
        this.sheet = sheet;
        this.tiles = new ArrayList<>();
        try {
            Scanner input = new Scanner(tilesFile);
            while (input.hasNext()) {
                String line = input.nextLine();
                if (!line.startsWith("//")) {
                    String[] parts = line.split("-");
                    String tileName = parts[0];
                    int SpriteX = Integer.parseInt(parts[1]);
                    int SpriteY = Integer.parseInt(parts[2]);
                    boolean colidable = false;
                    if(parts.length == 4)
                    {
                        colidable= Boolean.parseBoolean(parts[3]);
                    }
                    BaseTile tile = new BaseTile(tileName, sheet.getSprite(SpriteX, SpriteY),colidable);
                    tiles.add(tile);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public BaseTile getBaseTile(int id)
    {
        if(id < tiles.size())
        {
            return tiles.get(id);
        }
        return null;
    }

    class BaseTile {
        
        String name;
        Sprite sprite;
        boolean colidable;

        public BaseTile(String name, Sprite sprite,boolean colidable) {
            this.name = name;
            this.sprite = sprite;
            this.colidable = colidable;
        }
    }
}
