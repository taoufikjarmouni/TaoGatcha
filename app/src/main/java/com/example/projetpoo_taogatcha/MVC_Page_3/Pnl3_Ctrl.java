package com.example.projetpoo_taogatcha.MVC_Page_3;

import android.view.View;

import com.example.projetpoo_taogatcha.MVC_Page_2.Pnl2_Mdl;
import com.example.projetpoo_taogatcha.MVC_Page_2.Pnl2_View;
import com.example.projetpoo_taogatcha.PnlManager;
import com.example.projetpoo_taogatcha.R;

public class Pnl3_Ctrl implements View.OnClickListener
{
    public Pnl3_Mdl refMdl3;
    public Pnl3_View refVue3;
    public PnlManager refMng;

    public void setManager(PnlManager m)
    {
        refMng = m;
    }
    public void setRefMod(Pnl3_Mdl m)
    {
        refMdl3 = m;
    }
    public void setVue(Pnl3_View l)
    {
        refVue3 = l;
    }

    //les boutouns changes la page, changent le pseudoet nom ou mettent à 0 les valeurs
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAccueil:
                refMng.pageChange(1);
                break;
            case R.id.btnJouer:
                refMng.pageChange(2);
                break;
            case R.id.btnSoumettre:
                refMdl3.setNom(refVue3.nom);
                refMdl3.setPseudo(refVue3.pseudo);
                break;
            case R.id.btnReset:
                refMng.resetAll();
                break;
        }
    }
}
