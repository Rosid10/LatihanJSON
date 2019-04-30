package com.rosid.belajarjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.rosid.belajarjson.Usser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String id,nama,email;
    private RecyclerView recycleView;
    private usserAdapter adapter;
    private ArrayList<Usser> usersArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersArrayList = new ArrayList<>();
        try{
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray userArray = obj.getJSONArray("users");
            for (int i = 0; i < userArray.length(); i++){
                JSONObject userDetail = userArray.getJSONObject(i);
                id = userDetail.getString("id");
                nama = userDetail.getString("nama");
                email = userDetail.getString("email");

                usersArrayList.add(new Usser(id,nama,email));

            }


        } catch (JSONException e){
            e.printStackTrace();
        }

        recycleView = (RecyclerView) findViewById(R.id.recycle_view);
        adapter = new usserAdapter(usersArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);
    }

    public String loadJSONFromAsset(){
        String json = null;
        try {
            InputStream js = getAssets().open("DATAJSON.json");
            int size = js.available();
            byte[] buffer = new byte[size];
            js.read(buffer);
            js.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
