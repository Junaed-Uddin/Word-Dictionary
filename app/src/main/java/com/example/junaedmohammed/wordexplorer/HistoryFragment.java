package com.example.junaedmohammed.wordexplorer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {


    ListView lv;
    String[] data;
    Button button;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_history, container, false);

        lv = (ListView) v.findViewById(R.id.show_history);

        Word_fetch hs = new Word_fetch(getContext());

        data = hs.his_data();

        lv.setAdapter(new ArrayAdapter(getContext(),R.layout.history_list_item,R.id.his_list,data));

        final HistoryFunctions functions = new HistoryFunctions(getContext());

        /*String t = functions.his_data(rec_post+1);*/


 /*      button = (Button)v.findViewById(R.id.delete_data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });*/

        return v;
    }

}
