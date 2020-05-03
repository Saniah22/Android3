package com.example.android3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rc;
    private List<Object> book_List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc = (RecyclerView) findViewById(R.id.books_list);
        rc.setHasFixedSize(true);

        rc.LayoutManager layoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);

        rc.Adapter adpt = new RecyclerViewAdapter(this,book_List);
        rc.setAdapter(adpt);

        addMenu();
    }

    private void addMenu(){
       try {
           String JSONDataString = readJSON();
           JSONArray menuItemArray = new JSONArray(JSONDataString);

           for(int i = 0;i < menuItemArray.length(); i++){
               JSONObject menuItemObject = menuItemArray.getJSONObject(i);
               String txt_title = menuItemObject.getString("title");
               String txt_author = menuItemObject.getString("author");
               String txt_level = menuItemObject.getString("level");
               String txt_info = menuItemObject.getString("info");
               String txt_image = menuItemObject.getString("cover");
               String txt_URL = menuItemObject.getString("url");

               DataObject object = new DataObject(txt_title,txt_author,txt_level,txt_info,txt_image,txt_URL);
               book_List.add(object);
           }
       }catch (IOException | JSONException exception){
           Log.e(MainActivity.class.getName(),"Unable to Parse the JSON data");
       }
    }

    private String readJSON() throws IOException{
        InputStream is = null;
        StringBuilder res = new StringBuilder();

        try{
            String JSONData = null;
            is = getAssets().open("issues.json");
            BufferedReader bfreader = new BufferedReader(
                    new InputStreamReader(is,"UTF-8"));
            while ((JSONData = bfreader.readLine()) != null){
                res.append(JSONData);
            }
        }finally {
            if (is != null) {
                is.close();
            }
        }
        return new String(res);
    }
}
