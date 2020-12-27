package com.example.junaedmohammed.wordexplorer;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    Button search, pronunciation, favourite, clear;
    AutoCompleteTextView autoCompleteTextView;
    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextToSpeech textToSpeech;
    private Button mic_button;
    List<String> wordname;

    private WordModel model = null;


    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        /// assigning the search edit text to get the search text
        mic_button = (Button) view.findViewById(R.id.bt_mic);

        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.edit_text);
        textView = autoCompleteTextView;

        textToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

//        final HistoryFunctions ht = new HistoryFunctions(getContext());
        final Word_fetch wf = new Word_fetch(getContext());
        wf.insetItems();


        wordname =wf.word_fetch_all();
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, wordname);
        autoCompleteTextView.setAdapter(adapter);


        search = (Button) view.findViewById(R.id.bt_search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // checking if the edit text is empty or not by getting the value of the search edit text

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                if (TextUtils.isEmpty(textView.getText().toString())) {
                    Toast.makeText(getContext(), "No text to translate", Toast.LENGTH_SHORT).show();
                } else {
                    model = wf.word_fetch(autoCompleteTextView.getText().toString());
                    if (model != null) {

                        Data_item hs = new Data_item(autoCompleteTextView.getText().toString());
                        wf.AddingHistoryToTable(hs);


                        textView1 = view.findViewById(R.id.searchText1);
                        textView1.setText("Meaning: \n" + model.getMeaning());

                        textView2 = view.findViewById(R.id.searchText2);
                        textView2.setText("\nSynonym: \n" + model.getSynonym());

                        textView3 = view.findViewById(R.id.searchText3);
                        textView3.setText("\nAntonym: \n" + model.getAntonym());

                        textView4 = view.findViewById(R.id.searchText4);
                        textView4.setText("\nExample: \n" + model.getExample());
                    }
                }
            }
        });
        pronunciation = (Button) view.findViewById(R.id.bt_pronounc);

        pronunciation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                if (TextUtils.isEmpty(textView.getText().toString())) {
                    Toast.makeText(getContext(), "No text to pronounce", Toast.LENGTH_SHORT).show();
                } else {
                    String SpeakPronc = autoCompleteTextView.getText().toString();
                    textToSpeech.speak(SpeakPronc, TextToSpeech.QUEUE_FLUSH, null);

                }

            }
        });

        mic_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                try {
                    startActivityForResult(intent, 200);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getContext(), "intent problem", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final FavoriteFunctions ff = new FavoriteFunctions(getContext());

        favourite = (Button) view.findViewById(R.id.bt_fav);

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                if (model != null) {
                    Data_item fd = new Data_item(autoCompleteTextView.getText().toString());
                    ff.AddingFavoriteToTable(fd);
                    Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Not found!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        clear = (Button) view.findViewById(R.id.bt_Clr);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                if (TextUtils.isEmpty(textView.getText())) {
                    Toast.makeText(getContext(), "No text to clear", Toast.LENGTH_SHORT).show();
                } else
                    autoCompleteTextView.setText("");

                TextView textView1 = view.findViewById(R.id.searchText1);
                textView1.setText("");

                TextView textView2 = view.findViewById(R.id.searchText2);
                textView2.setText("");

                TextView textView3 = view.findViewById(R.id.searchText3);
                textView3.setText("");

                TextView textView4 = view.findViewById(R.id.searchText4);
                textView4.setText("");
            }
        });

        return view;
    }

    public void OnPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 200 && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                autoCompleteTextView.setText(result.get(0));
            }


        }

    }
}
