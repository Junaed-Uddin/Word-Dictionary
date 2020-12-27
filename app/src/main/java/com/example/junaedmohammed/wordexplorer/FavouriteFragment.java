package com.example.junaedmohammed.wordexplorer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {

    String[] data;
    ListView lv;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favourite, container, false);

        lv = (ListView) v.findViewById(R.id.show_data);

        FavoriteFunctions ff = new FavoriteFunctions(getContext());

        data = ff.fav_data();

        lv.setAdapter(new ArrayAdapter(getContext(),R.layout.favorite_list_item,R.id.fav_list,data));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(),UpdateFavorite.class);
                intent.putExtra("MYKEY",position);
                startActivity(intent);
            }
        });

        return v;
    }

}
