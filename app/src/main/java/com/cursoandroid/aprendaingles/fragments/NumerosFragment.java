package com.cursoandroid.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cursoandroid.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonUm, buttonDois, buttonTres, buttonQuatro, buttonCinco, buttonSeis;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        buttonUm = view.findViewById(R.id.buttonUm);
        buttonDois = view.findViewById(R.id.buttonDois);
        buttonTres = view.findViewById(R.id.buttonTres);
        buttonQuatro = view.findViewById(R.id.buttonQuatro);
        buttonCinco = view.findViewById(R.id.buttonCinco);
        buttonSeis = view.findViewById(R.id.buttonSeis);

        buttonUm.setOnClickListener(this);
        buttonDois.setOnClickListener(this);
        buttonTres.setOnClickListener(this);
        buttonQuatro.setOnClickListener(this);
        buttonCinco.setOnClickListener(this);
        buttonSeis.setOnClickListener(this);

        return view;
    }

    //Ao clickar, buscar por id e tocar o respectivo som.
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonUm:
                //Context da Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
            break;
            case R.id.buttonDois:
                //Context da Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
            break;
            case R.id.buttonTres:
                //Context da Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
            break;
            case R.id.buttonQuatro:
                //Context da Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
            break;
            case R.id.buttonCinco:
                //Context da Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
            break;
            case R.id.buttonSeis:
                //Context da Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
            break;
        }
    }


    public void tocarSom(){
        if(mediaPlayer!=null){
            mediaPlayer.start();
        //Liberar os recursos qnd a execução for completada.
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }

    }

    //Ao destruir, limpar e liberar os recursos
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
