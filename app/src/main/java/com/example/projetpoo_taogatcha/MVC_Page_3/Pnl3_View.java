package com.example.projetpoo_taogatcha.MVC_Page_3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projetpoo_taogatcha.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Observable;
import java.util.Observer;

public class Pnl3_View extends ConstraintLayout implements Observer
{
    public Pnl3_Mdl refMdl3;
    public Pnl3_Ctrl refCtrl3;

    public Button btnAccueil;
    public Button btnJouer;
    public Button btnSoumettre;
    public Button btnReset;

    public TextInputEditText txtNom;
    public TextInputEditText txtPseudo;

    public TextView txtVotrePseudo;

    public String nom;
    public String pseudo;

    public Pnl3_View(Context context, Pnl3_Mdl mdl, Pnl3_Ctrl ctr)
    {
        super(context);

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.pnl3_layout, this);

        refMdl3 = mdl;
        refCtrl3 = ctr;

        btnAccueil = (Button)findViewById(R.id.btnAccueil);
        btnJouer = (Button)findViewById(R.id.btnJouer);
        btnSoumettre = (Button)findViewById(R.id.btnSoumettre);
        btnReset = (Button)findViewById(R.id.btnReset);

        btnAccueil.setOnClickListener(refCtrl3);
        btnJouer.setOnClickListener(refCtrl3);
        btnSoumettre.setOnClickListener(refCtrl3);
        btnReset.setOnClickListener(refCtrl3);

        txtNom = (TextInputEditText) findViewById(R.id.textInputNom);
        txtPseudo = (TextInputEditText) findViewById(R.id.textInputPseudo);

        txtVotrePseudo = (TextView)findViewById(R.id.textViewPseudoDonne);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        nom = txtNom.getText().toString();
        pseudo = txtPseudo.getText().toString();
        txtVotrePseudo.setText(refMdl3.getPseudo());
    }
}
