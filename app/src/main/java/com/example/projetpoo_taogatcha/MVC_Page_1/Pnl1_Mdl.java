package com.example.projetpoo_taogatcha.MVC_Page_1;

import android.content.Context;

import com.example.projetpoo_taogatcha.MVC_Page_3.Pnl3_Mdl;

import java.util.Observable;

public class Pnl1_Mdl extends Observable
{
    private String m_sPseudo;
    Pnl3_Mdl refMdl3 = new Pnl3_Mdl();
    //Le pseudo change par rapport à celui mis dans la page 3
    public Pnl1_Mdl(Context context)
    {
        m_sPseudo = "Inconnu";
    }
    public void pseudo()
    {
        if (refMdl3.getPseudo() == null)
        {
            m_sPseudo ="...";
        }
        else
        {
            m_sPseudo = refMdl3.getPseudo();
        }
        setChanged();
        notifyObservers();
    }
    public String getPseudo()
    {
        pseudo();
        return m_sPseudo;
    }
}
