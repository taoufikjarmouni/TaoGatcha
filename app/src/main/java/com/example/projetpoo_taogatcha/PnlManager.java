package com.example.projetpoo_taogatcha;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.projetpoo_taogatcha.MVC_Page_1.Pnl1_Ctrl;
import com.example.projetpoo_taogatcha.MVC_Page_1.Pnl1_Mdl;
import com.example.projetpoo_taogatcha.MVC_Page_1.Pnl1_View;
import com.example.projetpoo_taogatcha.MVC_Page_2.Pnl2_Ctrl;
import com.example.projetpoo_taogatcha.MVC_Page_2.Pnl2_Mdl;
import com.example.projetpoo_taogatcha.MVC_Page_2.Pnl2_View;
import com.example.projetpoo_taogatcha.MVC_Page_3.Pnl3_Ctrl;
import com.example.projetpoo_taogatcha.MVC_Page_3.Pnl3_Mdl;
import com.example.projetpoo_taogatcha.MVC_Page_3.Pnl3_View;

import java.util.Observable;

public class PnlManager extends Observable
{
    private static PnlManager instance = null;
    public MainActivity refAct;

    private Pnl1_Ctrl refCtrl1;
    private Pnl1_Mdl refMdl1;
    private Pnl1_View refVue1;

    private Pnl2_Ctrl refCtrl2;
    private Pnl2_Mdl refMdl2;
    private Pnl2_View refVue2;

    private Pnl3_Ctrl refCtrl3;
    private Pnl3_Mdl refMdl3;
    private Pnl3_View refVue3;

    private boolean alreadyExecuted = false;

    public static PnlManager getManager(Context context)
    {
        if(instance == null)
            instance = new PnlManager(context);

        return instance;
    }

    private PnlManager(Context context){
        refAct = (MainActivity)context;

        refMdl1 = new Pnl1_Mdl(context);
        refCtrl1 = new Pnl1_Ctrl(context, refMdl1);
        refVue1 = new Pnl1_View(refAct, refMdl1, refCtrl1);

        refMdl2 = new Pnl2_Mdl();
        refCtrl2 = new Pnl2_Ctrl();
        refVue2 = new Pnl2_View(refAct, refMdl2, refCtrl2);

        refMdl3 = new Pnl3_Mdl();
        refCtrl3 = new Pnl3_Ctrl();
        refVue3 = new Pnl3_View(refAct, refMdl3, refCtrl3);

        refCtrl1.setVue(refVue1);
        refCtrl1.setManager(this);
        refMdl1.addObserver(refVue1);
        addObserver(refVue1);

        refCtrl2.setRefMod(refMdl2);
        refCtrl2.setVue(refVue2);
        refCtrl2.setManager(this);
        refMdl2.addObserver(refVue2);
        addObserver(refVue2);

        refCtrl3.setRefMod(refMdl3);
        refCtrl3.setVue(refVue3);
        refCtrl3.setManager(this);
        refMdl3.addObserver(refVue3);
        addObserver(refVue3);

        refAct.setContentView(refVue1);
    }

    public void pageChange(int n){
        switch (n)
        {
            case 1:
                refAct.setContentView(refVue1);
                break;
            case 2:
                refAct.setContentView(refVue2);
                if(!alreadyExecuted)
                {
                    refMdl2.timeFaim();
                    refMdl2.timeBonheur();
                    alreadyExecuted = true;
                }
                break;
            case 3:
                refAct.setContentView(refVue3);
                break;
        }
    }

    public void resetAll()
    {
        refMdl2.resetEntiers();
    }

}
