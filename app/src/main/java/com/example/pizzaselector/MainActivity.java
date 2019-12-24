package com.example.pizzaselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.awt.font.TextAttribute;
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
    private TextView displayText;
    private PizzaPlace pp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream is = getResources().openRawResource(R.raw.pizzalist);
        br = new BufferedReader(new InputStreamReader(is));
        createList(br);

        displayText = findViewById(R.id.DisplayTextArea);
        Button pickBtn = findViewById(R.id.startPick);
        pickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inner class that selects a random pizza place for the user 
                selectRandom();
                String pickedStore = pp.toString();
                displayText.setText(pickedStore);
                Toast.makeText(getApplicationContext(),"Selected a store!",Toast.LENGTH_SHORT).show();
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

    public void selectRandom(){
        Random rand = new Random();
        pp = storeList.get(rand.nextInt(storeList.size()));
    }
}
