package com.example.projetpoo_taogatcha.MVC_Page_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projetpoo_taogatcha.MainActivity;
import com.example.projetpoo_taogatcha.PnlManager;
import com.example.projetpoo_taogatcha.R;

import java.util.Observable;
import java.util.Observer;

public class Pnl2_View extends ConstraintLayout implements Observer
{

    public Pnl2_Mdl refMdl2;
    public Pnl2_Ctrl refCtrl2;

    public Button btnAccueil;
    public Button btnParametres;
    public Button btnCaresser;
    public Button btnJouet;
    public Button btnNourriture;

    public TextView txtFaimInt;
    public TextView txtBonheurInt;
    public TextView txtMessage;

    public ImageView imgBonheur;
    public ImageView imgMalheur;
    public ImageView imgFaim;
    public ImageView imgMort;

    private MainActivity refAct;

    public TextView txtVotrePseudo;

    public Activity getAct()
    {
        return refAct;
    }

    @SuppressLint("WrongConstant")
    public Pnl2_View(Context context, Pnl2_Mdl mdl, Pnl2_Ctrl ctr){
        super(context);
        refAct = (MainActivity)context;

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.pnl2_layout, this);

        refMdl2 = mdl;
        refCtrl2 = ctr;

        btnAccueil = (Button)findViewById(R.id.btnAccueil);
        btnParametres = (Button)findViewById(R.id.btnParametres);
        btnCaresser = (Button)findViewById(R.id.btnCaresser);
        btnJouet = (Button)findViewById(R.id.btnJouet);
        btnNourriture = (Button)findViewById(R.id.btnNourriture);

        btnAccueil.setOnClickListener(refCtrl2);
        btnParametres.setOnClickListener(refCtrl2);
        btnCaresser.setOnClickListener(refCtrl2);
        btnJouet.setOnClickListener(refCtrl2);
        btnNourriture.setOnClickListener(refCtrl2);

        txtFaimInt = (TextView)findViewById(R.id.textFaimInt);
        txtBonheurInt = (TextView)findViewById(R.id.textBonheurInt);
        txtMessage = (TextView)findViewById(R.id.textMessage);

        imgBonheur = (ImageView)findViewById(R.id.imageTaoGatcha);
        imgMalheur = (ImageView)findViewById(R.id.imageTaoGatchaMalheur);
        imgFaim = (ImageView)findViewById(R.id.imageTaoGatchaFaim);
        imgMort = (ImageView)findViewById(R.id.imageTaoGatchaMort);

        imgBonheur.setVisibility(View.VISIBLE);
        imgMalheur.setVisibility(View.INVISIBLE);
        imgFaim.setVisibility(View.INVISIBLE);
        imgMort.setVisibility(View.INVISIBLE);

        txtVotrePseudo = (TextView)findViewById(R.id.textBPseudo);
    }

    @SuppressLint({"NonConstantResourceId", "WrongConstant"})
    @Override
    public void update(Observable o, Object arg)
    {
        //Pour pouvoir modifier le texte sur l'UI, on appelle la fonction runOnUiThread
        getAct().runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                //txtVotrePseudo.setText(m2.getPseudo());
                switch (refMdl2.changeImg())
                {
                    case 700047:
                        imgBonheur.setVisibility(View.VISIBLE);
                        imgMalheur.setVisibility(View.INVISIBLE);
                        imgFaim.setVisibility(View.INVISIBLE);
                        imgMort.setVisibility(View.INVISIBLE);
                        break;
                    case 700027:
                        imgBonheur.setVisibility(View.INVISIBLE);
                        imgMalheur.setVisibility(View.INVISIBLE);
                        imgFaim.setVisibility(View.VISIBLE);
                        imgMort.setVisibility(View.INVISIBLE);
                        break;
                    case 700002:
                        imgBonheur.setVisibility(View.INVISIBLE);
                        imgMalheur.setVisibility(View.VISIBLE);
                        imgFaim.setVisibility(View.INVISIBLE);
                        imgMort.setVisibility(View.INVISIBLE);
                        break;
                    case 700051:
                        imgBonheur.setVisibility(View.INVISIBLE);
                        imgMalheur.setVisibility(View.INVISIBLE);
                        imgFaim.setVisibility(View.INVISIBLE);
                        imgMort.setVisibility(View.VISIBLE);
                        break;
                }

        }});
        txtFaimInt.setText(Integer.toString(refMdl2.getFaim()));
        txtBonheurInt.setText(Integer.toString(refMdl2.getBonheur()));
    }
}
