package cl.desafiolatam.yerkos.shrinkquizz.Fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import cl.desafiolatam.yerkos.shrinkquizz.Models.LuckyResult;
import cl.desafiolatam.yerkos.shrinkquizz.R;

public class LuckyFragment extends Fragment {


    private Button luckyBtn;
    private CheckBox check, mood;

    public LuckyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lucky, container, false);

        check = view.findViewById(R.id.fragment_lucky_check);
        mood = view.findViewById(R.id.fragment_lucky_mood);
        luckyBtn = view.findViewById(R.id.fragment_lucky_btn);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mood.setChecked(isChecked);
            }
        });

        luckyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answer = mood.isChecked();
                showLuckyDialog(answer);
            }
        });
    }

    private void showLuckyDialog(boolean answer){
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Nivel de suerte");
        dialog.setMessage(new LuckyResult(answer).estaCheck());
        dialog.setPositiveButton("Gracias!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
