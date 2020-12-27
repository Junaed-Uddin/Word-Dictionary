package com.example.junaedmohammed.wordexplorer;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junaedmohammed.wordexplorer.ui.MainActivity;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {

    TextView score;
    TextView question;
    Button rb1;
    Button rb2;
    Button rb3;
    Button rb4;
    Button quit;
    TextView invalid;

    private Questions mQuestions ;
    private String mAnswer = "";
    private int mScore;
    private int mQuestionsLength ;
    public int count =0;
    public int wrong_answer ;

    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_games, container, false);

        rb1 = (Button) v.findViewById(R.id.but);
        rb2 = (Button) v.findViewById(R.id.but1);
        rb3 = (Button) v.findViewById(R.id.but2);
        rb4 = (Button) v.findViewById(R.id.but3);
        quit = (Button) v.findViewById(R.id.quit);
        invalid = (TextView) v.findViewById(R.id.wrong);

        score = (TextView) v.findViewById(R.id.score);
        question = (TextView) v.findViewById(R.id.question);

        mScore= 0;
        wrong_answer =0;
        final Random r;
        mQuestions = new Questions();

        mQuestionsLength =mQuestions.mQuestions.length;
        r = new Random();

        updateQuestion(r.nextInt(mQuestionsLength));

        score.setText("Score: " + mScore);
        invalid.setText("Mismatch: " + wrong_answer);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (rb1.getText() == mAnswer) {

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    count++;
                    wrong_answer++;
                    invalid.setText("Mismatch: " + wrong_answer);
                    if (count == 5)
                    {
                        gameOver();
                    }
                    else
                        updateQuestion(r.nextInt(mQuestionsLength));

                }

            }


        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rb2.getText() == mAnswer) {

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    count++;
                    wrong_answer++;
                    invalid.setText("Mismatch: " + wrong_answer);
                    if (count == 5)
                    {
                        gameOver();
                    }
                    else
                        updateQuestion(r.nextInt(mQuestionsLength));

                }

            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rb3.getText() == mAnswer) {

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    count++;
                    wrong_answer++;
                    invalid.setText("Mismatch: " + wrong_answer);
                    if (count == 5)
                    {
                        gameOver();
                    }
                    else
                        updateQuestion(r.nextInt(mQuestionsLength));
                }

            }
        });

        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rb4.getText() == mAnswer) {

                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    count++;
                    wrong_answer++;
                    invalid.setText("Mismatch: " + wrong_answer);
                    if (count == 5)
                    {
                        gameOver();
                    }
                    else
                        updateQuestion(r.nextInt(mQuestionsLength));

                }
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Do you want to quit game ?");
                builder.setTitle("Quit");
                builder.setIcon(R.drawable.alerticon);
                builder.setCancelable(true);
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getContext(),MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Your current score is " + mScore +" points.", Toast.LENGTH_SHORT).show();

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return v;
    }

    private void updateQuestion(int i) {

        question.setText(mQuestions.getQuestion(i));
        rb1.setText(mQuestions.getChoice1(i));
        rb2.setText(mQuestions.getChoice2(i));
        rb3.setText(mQuestions.getChoice3(i));
        rb4.setText(mQuestions.getChoice4(i));

        mAnswer = mQuestions.getCorrectAnswer(i);
    }

    private void gameOver(){
        AlertDialog.Builder Builder = new AlertDialog.Builder(getActivity());
        Builder.setMessage("Game Over! Your Score is " + mScore +" points.")
                .setCancelable(true).setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);

            }
        }).setNegativeButton("NEW GAME", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                    mScore= 0;
                    count = 0;
                    wrong_answer =0;
                    final Random r;
                    mQuestions = new Questions();
                    mQuestionsLength =mQuestions.mQuestions.length;
                    r = new Random();
                    updateQuestion(r.nextInt(mQuestionsLength));
                    score.setText("Score: " + mScore);
                    invalid.setText("Mismatch: " + wrong_answer);

            }
        });

        AlertDialog alertDialog = Builder.create();
        alertDialog.show();

    }

}
