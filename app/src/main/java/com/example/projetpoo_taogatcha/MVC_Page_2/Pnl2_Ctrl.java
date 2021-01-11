package com.example.projetpoo_taogatcha.MVC_Page_2;

import android.view.View;

import com.example.projetpoo_taogatcha.PnlManager;
import com.example.projetpoo_taogatcha.R;

public class Pnl2_Ctrl implements View.OnClickListener
{
    public Pnl2_Mdl refMdl2;
    public Pnl2_View refVue2;
    public PnlManager refMng;

    public void setManager(PnlManager m) { refMng = m; }
    public void setRefMod(Pnl2_Mdl m){
        refMdl2 = m;
    }
    public void setVue(Pnl2_View l){
        refVue2 = l;
    }

    //Accueil et Parametres changent la page, caresser, jouet et nourriture changent les valeurs de bonheur et faim
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAccueil:
                refMng.pageChange(1);
                break;
            case R.id.btnParametres:
                refMng.pageChange(3);
                break;
            case R.id.btnCaresser:
                refMdl2.incBonheur();
                break;
            case R.id.btnJouet:
                refMdl2.aleaBonheur();
                break;
            case R.id.btnNourriture:
                refMdl2.aleaFaim();
                break;
        }
    }
}
