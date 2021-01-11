package com.example.projetpoo_taogatcha.MVC_Page_2;


import com.example.projetpoo_taogatcha.Etat;
import com.example.projetpoo_taogatcha.EtatFaim;
import com.example.projetpoo_taogatcha.EtatHeureux;
import com.example.projetpoo_taogatcha.EtatMort;
import com.example.projetpoo_taogatcha.EtatTriste;
import com.example.projetpoo_taogatcha.MVC_Page_3.Pnl3_Mdl;

import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Pnl2_Mdl extends Observable
{
    private int m_iFaim;
    private int m_iBonheur;
    private String m_sMessage;
    private String m_sPseudo;
    private int m_iImageTama;
    Timer timer = new Timer();
    Etat etatTaoGatcha;
    Pnl3_Mdl refMdl3 = new Pnl3_Mdl();

    public Pnl2_Mdl()
    {
        m_iFaim = 0;
        m_iBonheur = 100;
        etatTaoGatcha = new EtatHeureux();
        m_sMessage = "Aucun message...";
        m_sPseudo = "Inconnu";
    }
    public void nouvelEtat()
    {
        etatTaoGatcha.etapeSuivante(this);
    }

    public void changeEtat(int etat)
    {
        if (etatTaoGatcha != null)
        {
            etatTaoGatcha = null;
        }
        switch (etat)
        {
            case 0: etatTaoGatcha = new EtatHeureux(); break;
            case 1: etatTaoGatcha = new EtatFaim(); break;
            case 2: etatTaoGatcha = new EtatTriste(); break;
            case 3: etatTaoGatcha = new EtatMort(); break;
        }
    }
    //On incremente le bonheur quand on appuie sur le bouton caresser
    public void incBonheur()
    {
        if(m_iBonheur <= 95)
        {
            m_iBonheur+=5;
            m_sMessage = "Le Tamagotchi a apprécié les caresses";
        }
        else
        {
            m_sMessage = "Le Tamagotchi ne veut plus de caresses";
        }
        if(m_iBonheur < 90)
        {
            m_iImageTama = 700002;
        }
        if(m_iBonheur == 0)
        {
            m_iImageTama = 700051;
        }
        setChanged();
        notifyObservers();
    }
    //Le jouet augmente ou diminue la valeur de bonheur
    public void aleaBonheur()
    {
        if(m_iBonheur <= 80)
        {
            int max = 20;
            int min = -10;
            Random rand = new Random();
            m_iBonheur += rand.nextInt((max - min) + 1) + min;
            m_sMessage = "Le Tamagotchi a joué";
        }
        else if (m_iBonheur >= 80)
        {
            m_sMessage = "Le Tamagotchi ne veut plus de jouets";
        }
        else if (m_iBonheur <= 0)
        {
            m_sMessage = "Le Tamagotchi est... mort d’ennui!";
        }
        if(m_iBonheur < 90)
        {
            m_iImageTama = 700002;
        }
        if(m_iBonheur == 0)
        {
            m_iImageTama = 700051;
        }
        setChanged();
        notifyObservers();
    }
    //La nourriture diminue la faim
    public void aleaFaim()
    {
        if(m_iFaim >= 20)
        {
            int max = 20;
            int min = 0;
            Random rand = new Random();
            m_iFaim -= rand.nextInt((max - min) + 1) + min;
            m_sMessage = "Le Tamagotchi a mangé";
        }
        else if (m_iFaim <= 20)
        {
            m_sMessage = "Le Tamagotchi ne veut plus manger";
        }
        else if (m_iFaim >= 100)
        {
            m_sMessage = "Le Tamagotchi est mort de faim!";
        }
        if(m_iFaim > 2)
        {
            m_iImageTama = 700027;
        }
        if(m_iFaim == 0)
        {
            m_iImageTama = 700051;
        }
        setChanged();
        notifyObservers();
    }
    //La faim augmente au fil du temps
    public void timeFaim()
    {
        timer.schedule(new TimerTask()
        {
            @Override
            public void run() {
                m_iFaim++;
                setChanged();
                notifyObservers();
            }
        }, 1000,1000);
    }
    //Le bonheur diminue au fil du temps
    public void timeBonheur()
    {
        timer.schedule(new TimerTask()
        {
            @Override
            public void run() {
                m_iBonheur--;
                setChanged();
                notifyObservers();
            }
        }, 1000,1000);
    }
    //On remet à 0 les valeurs de bonheur et faim
    public void resetEntiers()
    {
        m_iFaim = 0;
        m_iBonheur = 100;
        m_sMessage = "Aucun message...";
        setChanged();
        notifyObservers();
    }
    //On change l'image par rapport à l'état du tamagotchi
    public int changeImg()
    {
        if (m_iBonheur <= 50 && m_iBonheur > 0)
        {
            //m_sMessage = "Le TaoGatcha s'ennuie...";
            return 700002;
        }
        if (m_iFaim > 50 && m_iFaim < 100)
        {
            //m_sMessage = "Le TaoGatcha a faim...";
            return 700027;
        }
        if (m_iFaim <= 50 && m_iBonheur > 50)
        {
            //m_sMessage = "Le TaoGatcha est en bonne condition!";
            return 700047;
        }
        if(m_iFaim >= 100 || m_iBonheur <= 0)
        {
            //m_sMessage = "Le TaoGatcha est mort!";
            return 700051;
        }
        setChanged();
        notifyObservers();
        return 700047;
    }

    public int getFaim()
    {
        return m_iFaim;
    }
    public int getBonheur()
    {
        return m_iBonheur;
    }
    public String setMessage(String message)
    {
        m_sMessage = message;
        setChanged();
        notifyObservers();
        return m_sMessage;
    }
}
