package com.example.projetpoo_taogatcha.MVC_Page_1;

import android.content.Context;
import android.view.View;

import com.example.projetpoo_taogatcha.PnlManager;

public class Pnl1_Ctrl implements View.OnClickListener
{
    public Pnl1_Mdl refMdl1;
    public Pnl1_View refVue1;
    public PnlManager refMng;

    public Pnl1_Ctrl(Context context, Pnl1_Mdl mdl)
    {
        refMdl1 = mdl;
    }
    public void setManager(PnlManager m) { refMng = m; }
    public void setVue(Pnl1_View l){
        refVue1 = l;
    }
    //Si on clique sur jouer on est renvoyé à la page 2, si on clique sur Parametres on est envoyé à la page 3
    @Override
    public void onClick(View v)
    {
        if(v.getId() == refVue1.btnJouer.getId())
        {
            refMng.pageChange(2);
        }
        else if(v.getId() == refVue1.btnParametres.getId())
        {
            refMng.pageChange(3);
        }
    }
}
