package com.example.recycleviewproject;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewproject.adapter.RecyclerAdapter;
import com.example.recycleviewproject.model.RecyclerModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<RecyclerModel> recyclerModels = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView1);
        if (searchView != null) {
            searchView.clearFocus();
        } else {
            Log.e("MainActivity", "SearchView is null. Check your XML layout and ID.");
        }
//        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });




        recyclerView = findViewById(R.id.rv_name);

        //create data on recyclemodel
        recyclerModels.add(new RecyclerModel(R.drawable.spongbob,"SpongeBob","Funny yellow Sponge that lives in the sea"));
        recyclerModels.add(new RecyclerModel(R.drawable.squid,"SquidWard","Grumpy and unhappy squid "));
        recyclerModels.add(new RecyclerModel(R.drawable.garry,"Gary","SpongeBob's pat"));
        recyclerModels.add(new RecyclerModel(R.drawable.patrick,"Patrick","SpongeBob's best friend"));
        recyclerModels.add(new RecyclerModel(R.drawable.krabs,"Mr Krabs","SpongeBob's boss"));
        recyclerModels.add(new RecyclerModel(R.drawable.larry,"Larry","Muscular Krab"));
        recyclerModels.add(new RecyclerModel(R.drawable.puff,"Mrs Puff","Spongebobs driving nervous driving instructor"));
        recyclerModels.add(new RecyclerModel(R.drawable.pearl,"Pearl","Mr Krabs daughter"));
        recyclerModels.add(new RecyclerModel(R.drawable.sandy,"Sandy","Spongebob's female friend"));
        recyclerModels.add(new RecyclerModel(R.drawable.plankton,"Plankton","The tiny bad guy"));

        //call adapter
        recyclerAdapter = new RecyclerAdapter(this,recyclerModels);

        //set adapter recycler view
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    private void fileList(String text) {
        List<RecyclerModel>filteredList = new ArrayList<>();
        for (RecyclerModel item :recyclerModels)
        {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase()))
            {
                filteredList.add(item);
            }



                recyclerAdapter.setFilteredList(filteredList);

        }
    }
}