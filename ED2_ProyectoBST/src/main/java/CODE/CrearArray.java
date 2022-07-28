/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jonathan
 */
public class CrearArray {
    public ArbolBinarioBusqueda<String,Pokemon> CrearArray(){
        ArbolBinarioBusqueda<String,Pokemon> pokedex=new ArbolBinarioBusqueda();
        File file=new File("C:/Users/JY/Documents/NetBeansProjects/2022/ED2_ProyectoBST/img/Pokedex.txt");
        Scanner scan=null;
        try{
            scan=new Scanner(file);
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        if(file.exists()){
            while(scan.hasNext()){
                int numb=scan.nextInt();
                String name=scan.next();
                String type1=scan.next();
                String type2=scan.next();
                int lvl=scan.nextInt();
                int cp=scan.nextInt();
                int atk=scan.nextInt();
                int def=scan.nextInt();
                File filePics=new File("C:/Users/JY/Documents/NetBeansProjects/2022/ED2_ProyectoBST/img/pokemons/"+name+".gif");
                String image=filePics.getAbsolutePath();
                if(scan.hasNext()){
                    scan.nextLine();
                }
                Pokemon pokemon=new Pokemon();
                pokemon.setNumb(numb);
                pokemon.setName(name);
                pokemon.setLevel(lvl);
                pokemon.setType1(type1);
                pokemon.setType2(type2);
                pokemon.setCp(cp);
                pokemon.setImage(image);
                pokemon.setAtk(atk);
                pokemon.setDef(def);
                pokedex.Insertar(name,pokemon);
                
            }
        }
        return pokedex;
    }
}
