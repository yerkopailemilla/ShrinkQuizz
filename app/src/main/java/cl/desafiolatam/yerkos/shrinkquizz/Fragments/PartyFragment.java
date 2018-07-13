package cl.desafiolatam.yerkos.shrinkquizz.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cl.desafiolatam.yerkos.shrinkquizz.Models.PartyResults;
import cl.desafiolatam.yerkos.shrinkquizz.R;

public class PartyFragment extends Fragment {


    private Button sendBtn;
    private RadioGroup radioGroup;

    public PartyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_party, container, false);

        radioGroup = view.findViewById(R.id.fragment_party_rg);
        sendBtn = view.findViewById(R.id.fragment_party_btn);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                String answer;
                RadioButton radioButton;

                if (id != -1){
                    radioButton = radioGroup.findViewById(id);
                    answer = radioButton.getText().toString();
                    shoDialog(answer);


                } else {
                    Toast.makeText(getContext(), "Debes marcar una opción", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void shoDialog(String answer){
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Nivel de carrete");
        dialog.setMessage(new PartyResults(answer).score());
        dialog.setPositiveButton("Ejo, ejo, ejo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
