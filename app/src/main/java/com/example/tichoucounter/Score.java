package com.example.tichoucounter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Score#newInstance} factory method to
 * create an instance of this fragment.
 */
public class
Score extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Score() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Score.
     */
    // TODO: Rename and change types and number of parameters
    public static Score newInstance(String param1, String param2) {
        Score fragment = new Score();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Switch tichuA, noTichuA, grandTichuA, noGrandTichuA, doubleWinA;
    Switch tichuB, noTichuB, grandTichuB, noGrandTichuB, doubleWinB;
    Button submit, rounds;
    EditText inputA, inputB;
    TextView titleA, titleB;
    TextView currentScoreA, currentScoreB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_score, container, false);

        tichuA = view.findViewById(R.id.switch_Score_Tichu_TeamA);
        tichuB = view.findViewById(R.id.switch_Score_Tichu_TeamB);

        noTichuA = view.findViewById(R.id.switch_Score_No_Tichu_TeamA);
        noTichuB = view.findViewById(R.id.switch_Score_No_Tichu_TeamB);

        grandTichuA = view.findViewById(R.id.switch_Score_GrandTichu_TeamA);
        grandTichuB = view.findViewById(R.id.switch_Score_GrandTichu_TeamB);

        noGrandTichuA = view.findViewById(R.id.switch_Score_No_GrandTichu_TeamA);
        noGrandTichuB = view.findViewById(R.id.switch_Score_No_GrandTichu_TeamB);

        doubleWinA = view.findViewById(R.id.switch_Score_Double_TeamA);
        doubleWinB = view.findViewById(R.id.switch_Score_Double_TeamB);

        inputA = view.findViewById(R.id.editText_Score_InputA);
        inputB = view.findViewById(R.id.editText_Score_InputB);

        currentScoreA = view.findViewById(R.id.textView_Score_scoreA);
        currentScoreB = view.findViewById(R.id.textView_Score_scoreB);

        titleA = view.findViewById(R.id.textView_Score_teamA);
        titleB = view.findViewById(R.id.textView_Score_teamB);

        Bundle bundle = this.getArguments();
        String nameA = bundle.getString("nameA");
        String nameB = bundle.getString("nameB");
        titleA.setText(nameA);
        titleB.setText(nameB);

        rounds = view.findViewById(R.id.btn_Score_Rounds);
        submit = view.findViewById(R.id.btn_Score_Submit);
        tichuA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tichuA.isChecked()) {
                    tichuB.setClickable(false);
                    grandTichuA.setClickable(false);
                    grandTichuB.setClickable(false);
                    doubleWinB.setClickable(false);
                } else {
                    tichuB.setClickable(true);
                    grandTichuA.setClickable(true);
                    grandTichuB.setClickable(true);
                    doubleWinB.setClickable(true);
                }
            }
        });
        tichuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tichuB.isChecked()) {
                    tichuA.setClickable(false);
                    grandTichuB.setClickable(false);
                    grandTichuA.setClickable(false);
                    doubleWinA.setClickable(false);
                } else {
                    tichuA.setClickable(true);
                    grandTichuB.setClickable(true);
                    grandTichuA.setClickable(true);
                    doubleWinA.setClickable(true);
                }
            }
        });
        grandTichuA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (grandTichuA.isChecked()) {
                    tichuB.setClickable(false);
                    tichuA.setClickable(false);
                    grandTichuB.setClickable(false);
                    doubleWinB.setClickable(false);
                } else {
                    tichuB.setClickable(true);
                    tichuA.setClickable(true);
                    grandTichuB.setClickable(true);
                    doubleWinB.setClickable(true);
                }
            }
        });
        grandTichuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (grandTichuB.isChecked()) {
                    tichuA.setClickable(false);
                    tichuB.setClickable(false);
                    grandTichuA.setClickable(false);
                    doubleWinA.setClickable(false);
                } else {
                    tichuA.setClickable(true);
                    tichuB.setClickable(true);
                    grandTichuA.setClickable(true);
                    doubleWinA.setClickable(true);
                }
            }
        });
        doubleWinA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (doubleWinA.isChecked()) {
                    tichuB.setClickable(false);
                    grandTichuB.setClickable(false);
                    doubleWinB.setClickable(false);
                } else {
                    tichuB.setClickable(true);
                    grandTichuB.setClickable(true);
                    doubleWinB.setClickable(true);
                }
            }
        });
        doubleWinB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (doubleWinB.isChecked()) {
                    tichuA.setClickable(false);
                    grandTichuA.setClickable(false);
                    doubleWinA.setClickable(false);
                } else {
                    tichuA.setClickable(true);
                    grandTichuA.setClickable(true);
                    doubleWinA.setClickable(true);
                }
            }
        });

            TextWatcher watcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    int tempA = 0, tempB = 0, otherB = 0;
                    try {
                        tempA = Integer.parseInt(inputA.getText().toString());
                        if (tempA > 125){
                            inputA.setText("");
                            inputB.setText("");
                        }
                    }catch (NumberFormatException ex){
                        System.out.println("could not parse");
                    }
                    try {
                        tempB = Integer.parseInt(inputB.getText().toString());
                        if (tempB > 125){
                            inputA.setText("");
                            inputB.setText("");

                        }
                    }catch (NumberFormatException ex){
                        System.out.println("could not parse");
                    }
                    if (tempA <= 125) {
                        otherB = 100 - tempA;
                        String showB = String.valueOf(otherB);
                        inputB.setText(showB);
                    }

                }
            };
            inputA.addTextChangedListener(watcher);
            //inputB.addTextChangedListener(watcher);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(),"ola kala", Toast.LENGTH_LONG).show();
                int resultA = 0, resultB = 0;

                resultA = Integer.parseInt(currentScoreA.getText().toString());
                resultB = Integer.parseInt(currentScoreB.getText().toString());

                /*if (TextUtils.isEmpty(inputA.getText().toString())) {
                    inputA.setText("0");
                }
                if (TextUtils.isEmpty(inputB.getText().toString())) {
                    inputB.setText("0");
                }*/

                int inpA = 0, inpB = 0;
                try {
                    inpA = Integer.parseInt(inputA.getText().toString());
                } catch (NumberFormatException e){
                    System.out.println("could not parse");
                }
                try {
                    inpB = Integer.parseInt(inputB.getText().toString());
                } catch (NumberFormatException e){
                    System.out.println("could not parse");
                }

                if (tichuA.isChecked() != true &&  grandTichuA.isChecked() != true && noTichuA.isChecked() != true &&  noGrandTichuA.isChecked() != true && doubleWinA.isChecked() != true) {
                    resultA = resultA + inpA;
                }

                if (tichuB.isChecked() != true &&  grandTichuB.isChecked() != true && noTichuB.isChecked() != true &&  noGrandTichuB.isChecked() != true && doubleWinB.isChecked() != true) {
                    resultB = resultB + inpB;
                }

                ////Check if a switch of Team A is checked
                if (tichuA.isChecked()){
                    resultA = resultA + inpA + 100;
                }
                if (noTichuA.isChecked()){
                    resultA = resultA + inpA - 100;
                }
                if (grandTichuA.isChecked()){
                    resultA = resultA + inpA + 200;
                }
                if (noGrandTichuA.isChecked()){
                    resultA = resultA + inpA - 200;
                }
                if (doubleWinA.isChecked()){
                    resultA = resultA + 200;
                }

                //Check if a switch of Team B is checked
                if (tichuB.isChecked()){
                    resultB = resultB + inpB + 100;
                }
                if (noTichuB.isChecked()){
                    resultB = resultB + inpB - 100;
                }
                if (grandTichuB.isChecked()){
                    resultB = resultB + inpB + 200;
                }
                if (noGrandTichuB.isChecked()){
                    resultB = resultB + inpB - 200;
                }
                if (doubleWinB.isChecked()){
                    resultB = resultB + 200;
                }

                String resA = String.valueOf(resultA);
                String resB = String.valueOf(resultB);

                currentScoreA.setText(resA);
                currentScoreB.setText(resB);

                inputA.setHint("0");
                inputB.setHint("0");
                inputA.setText("");
                inputB.setText("");
                tichuA.setChecked(false);
                tichuB.setChecked(false);
                noTichuA.setChecked(false);
                noTichuB.setChecked(false);
                grandTichuA.setChecked(false);
                grandTichuB.setChecked(false);
                noGrandTichuA.setChecked(false);
                noGrandTichuB.setChecked(false);
                doubleWinA.setChecked(false);
                doubleWinB.setChecked(false);

            }


        });
        rounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundleScore = new Bundle();

                bundleScore.putString("nameA", titleA.getText().toString());
                bundleScore.putString("nameB", titleB.getText().toString());

                Rounds passRounds = new Rounds();
                passRounds.setArguments(bundleScore);

                getFragmentManager().beginTransaction().replace(R.id.frame_container, passRounds).addToBackStack(null).commit();
            }
        });
        return view;
    }
}