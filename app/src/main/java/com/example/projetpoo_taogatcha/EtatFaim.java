package com.example.projetpoo_taogatcha;

import com.example.projetpoo_taogatcha.MVC_Page_2.Pnl2_Mdl;

public class EtatFaim extends Etat
{
    public Pnl2_Mdl mdl;
    @Override
    public void etapeSuivante(Pnl2_Mdl etape) {
        mdl.setMessage("J'ai faim...");
        if (etape.getFaim() >= 50)
        {
            etape.changeEtat(1);
        }
        if (etape.getFaim() < 50)
        {
            etape.changeEtat(0);
        }
    }
}
