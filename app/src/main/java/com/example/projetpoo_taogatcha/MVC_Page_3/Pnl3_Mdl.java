package com.example.projetpoo_taogatcha.MVC_Page_3;

import java.util.Observable;

public class Pnl3_Mdl extends Observable
{
    private String m_sNom;
    private String m_sPseudo;

    public Pnl3_Mdl()
    {
        m_sNom = "";
        m_sPseudo = "";
    }

    public String getNom()
    {
        return m_sNom;
    }
    public String getPseudo()
    {
        return m_sPseudo;
    }

    public String setNom(String nom)
    {
        m_sNom = nom;
        setChanged();
        notifyObservers();
        return m_sPseudo;

    }
    public String setPseudo(String pseudo)
    {
        m_sPseudo = pseudo;
        setChanged();
        notifyObservers();
        return m_sPseudo;
    }
}
