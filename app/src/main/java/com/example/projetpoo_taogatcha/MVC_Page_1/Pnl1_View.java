package com.example.projetpoo_taogatcha.MVC_Page_1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projetpoo_taogatcha.R;

import java.util.Observable;
import java.util.Observer;

public class Pnl1_View extends ConstraintLayout implements Observer
{
    public Pnl1_Mdl refMdl1;
    public Pnl1_Ctrl refCtrl1;

    public Button btnJouer;
    public Button btnParametres;

    public TextView txtVotrePseudo;

    public Pnl1_View(Context context, Pnl1_Mdl mdl, Pnl1_Ctrl ctr){
        super(context);

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.pnl1_layout, this);

        refMdl1 = mdl;
        refCtrl1 = ctr;

        btnJouer = (Button)findViewById(R.id.btnJouer);
        btnParametres = (Button)findViewById(R.id.btnParametres);

        btnParametres.setOnClickListener(refCtrl1);
        btnJouer.setOnClickListener(refCtrl1);

        txtVotrePseudo = (TextView)findViewById(R.id.textViewVotreN);
    }
    //Le pseudo est mis à jour à chaque fois qu'on le change dans la page 3
    @Override
    public void update(Observable o, Object arg)
    {
        txtVotrePseudo.setText(refMdl1.getPseudo());
    }
}
