package com.example.pizzaselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<PizzaPlace> storeList = new ArrayList<PizzaPlace>();
    private BufferedReader br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream is = getResources().openRawResource(R.raw.pizzalist);
        br = new BufferedReader(new InputStreamReader(is));
        createList(br);

        Button pickBtn = findViewById(R.id.startPick);
        pickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make the button do something!
                String pickedStore = selectRandom();
                Toast.makeText(getApplicationContext(),pickedStore,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void createList(BufferedReader _br){
        try{
            System.out.println(new File(".").getAbsoluteFile());
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
            System.out.println("Unable to locate file ");
            fnfe.printStackTrace();
        }catch(IOException ioe){
            System.out.println("IOException");
            ioe.printStackTrace();
        }
    }

    public String selectRandom(){
        Random rand = new Random();
        return storeList.get(rand.nextInt(storeList.size())).toString();
    }
}
