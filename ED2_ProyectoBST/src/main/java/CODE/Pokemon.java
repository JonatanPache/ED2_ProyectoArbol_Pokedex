/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE;

/**
 *
 * @author Jonathan
 */
public class Pokemon implements Comparable<Pokemon>{
    private int numb;
    private String name;
    private String type1;
    private String type2;
    private int level;
    private int cp;
    private String image;
    private int atk;
    private int def;
    
    public Pokemon(){
        
    }
    public Pokemon(String name){
        this.name=name;
        this.atk=0;
        this.cp=0;
        this.def=0;
        this.image=null;
        this.level=1;
        this.numb=5;
        this.type1="";
        this.type2="2";
    }
    
    public Pokemon(int numb,String name, String type1, String type2,
    int level, int cp, String image,int atk,int def){
        this.numb=numb;
        this.atk=atk;
        this.cp=cp;
        this.def=def;
        this.image=image;
        this.level=level;
        this.name=name;
        this.type1=type1;
        this.type2=type2;
    }
    
    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
    
    
    @Override
    public String toString(){
        String id=String.valueOf(numb);
        String lvl=String.valueOf(level);
        String ap=String.valueOf(cp);
        String attack=String.valueOf(atk);
        String defense=String.valueOf(def);
        return id+"\t"+name+"\t"+type1+"\t"+type2+"\t"+lvl+"\t"+ap+"\t"+attack+"\t"+defense;
    }
    
    @Override
    public int compareTo(Pokemon otroPokemon) {
        int atk=this.atk;
        int otro=otroPokemon.atk;
        return atk-otro;
    }
    
}
