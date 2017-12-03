package itupos.fit.cz.itupos;

import java.util.ArrayList;

public class Menu{
    private ArrayList<MenuItem> menu;

    public Menu(ArrayList<MenuItem> menu) {
        this.menu = new ArrayList<MenuItem>();
    }

    public Integer getMenuCount(){
        return menu.size();
    }

    public void setMenuItem(String name, Integer price){
        menu.add(new MenuItem(name, price));
    }

    public void removeMenuItem(String name){
        for(MenuItem o : menu){
            if(o.getName().equals(name)){
                menu.remove(o);
            }
        }
    }

    public MenuItem getMenuItem(String name){
        for(MenuItem o : menu){
            if(o.getName().equals(name)){
                return o;
            }
        }
        return null;
    }

    public Integer getMenuItemPrice(String name){
        for(MenuItem o : menu){
            if(o.getName().equals(name)){
                return o.getPrice();
            }
        }
        return 0;
    }
}
