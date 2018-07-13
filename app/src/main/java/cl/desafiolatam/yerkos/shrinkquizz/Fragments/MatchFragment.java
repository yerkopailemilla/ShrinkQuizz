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
import android.widget.SeekBar;
import android.widget.TextView;

import cl.desafiolatam.yerkos.shrinkquizz.Models.MatchResult;
import cl.desafiolatam.yerkos.shrinkquizz.R;

public class MatchFragment extends Fragment {


    private Button sendBtn;
    private SeekBar userSeek, loverSeek;
    private TextView userText, loverText;

    public MatchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        userSeek = view.findViewById(R.id.fragment_match_seekUserYears);
        userText = view.findViewById(R.id.fragment_match_textUser);

        loverSeek = view.findViewById(R.id.fragment_match_seekLoverYears);
        loverText = view.findViewById(R.id.fragment_match_textLover);

        sendBtn = view.findViewById(R.id.fragment_match_sendBtn);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                userText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        loverSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                loverText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int user = userSeek.getProgress();
            int lover = loverSeek.getProgress();

            showCoupleDialog(user, lover);
            }
        });
    }

    private void showCoupleDialog(int userAge, int loverAge){
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Nivel de suerte");
        dialog.setMessage(new MatchResult(userAge, loverAge).showResult());
        dialog.setPositiveButton("Correcto!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
