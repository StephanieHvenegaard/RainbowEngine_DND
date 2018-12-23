///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package the_nights.rainbow_engine.dnd.map;
//
//import the_nights.rainbow_engine.core.IPlacable;
//import the_nights.rainbow_engine.graphics.IRender;
//import the_nights.rainbow_engine.graphics.Sprite;
//import the_nights.rainbow_engine.graphics.IScreenBuffer;
//
///**
// *
// * @author Stephanie
// */
//public class Tile implements IRender, IPlacable {
//
//    protected boolean colliable;
//    protected String name;
//    protected Sprite sprite;
//    protected int x;
//    protected int y;
//
//    public Tile(String name, Sprite sprite, int x, int y, boolean colidable) {
//        this.name = name;
//        this.sprite = sprite;
//        this.colliable = colidable;
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public void render(IScreenBuffer renderHandler, int xZoom, int yZoom) {
//        renderHandler.renderSprite(sprite, x, y, true);
//    }
//
//    @Override
//    public int getX() {
//        return x;
//
//    }
//
//    @Override
//    public int getY() {
//        return y;
//    }
//
//    @Override
//    public void setX(int x) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setY(int y) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public boolean isColiable() {
//        return this.colliable;
//    }
//}
