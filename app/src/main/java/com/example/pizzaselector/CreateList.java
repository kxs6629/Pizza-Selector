package com.example.pizzaselector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CreateList {
    private ArrayList<PizzaPlace> storeList = new ArrayList<PizzaPlace>();
    private String fileName;
    private File infoFile;

    /**
     * Constructor for CreateList
     * @param _fileName name of file to be read
     */
    public CreateList(String _fileName){
        this.fileName = _fileName;
        try{
            System.out.println(new File(".").getAbsoluteFile());
            infoFile = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(infoFile));
            String newPlace = br.readLine();
            while(newPlace != null){
                String[] slices = newPlace.split(",");
                if(slices.length == 2){
                    PizzaPlace pp = new PizzaPlace(slices[0],slices[1]);
                    System.out.println(pp.toString());
                    storeList.add(pp);
                }else if(slices.length == 3){
                    PizzaPlace pp = new PizzaPlace(slices[0],slices[1],slices[2]);
                    System.out.println(pp.toString());
                    storeList.add(pp);
                }
                newPlace = br.readLine();
            }
        }catch(NullPointerException npe){
            System.out.println("Null Pointer Exception. Check the file name!");
            npe.printStackTrace();
        }catch(FileNotFoundException fnfe){
            System.out.println("Unable to locate file " + fileName);
            fnfe.printStackTrace();
        }catch(IOException ioe){
            System.out.println("IOException");
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args){
        new CreateList("pizzalist.txt");
    }

}
