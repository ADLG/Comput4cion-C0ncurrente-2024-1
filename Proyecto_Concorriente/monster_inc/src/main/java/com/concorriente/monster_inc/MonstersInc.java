package com.concorriente.monster_inc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.concorriente.monster_inc.almacenes.*;
import com.concorriente.monster_inc.banos.*;
import com.concorriente.monster_inc.cafeteria.*;
import com.concorriente.monster_inc.candado.*;
import com.concorriente.monster_inc.centros.*;
import com.concorriente.monster_inc.fabricas.*;
import com.concorriente.monster_inc.monstruos.*;
import com.concorriente.monster_inc.planta_sustos.*;
import com.concorriente.monster_inc.vestidor.*;

import java.util.List;
import java.util.ArrayList;

public class MonstersInc
{
    public static void main(String[] args) throws InterruptedException
    {
        String YELLOW_BOLD_BRIGHT = "\033[1;93m";String rest = "\u001B[0m";
        String WHITE_BOLD = "\033[97m";String CYAN_BRIGHT = "\033[0;96m";
        List<Monstruo> monstruosMain = new ArrayList<>(); 
        String [] str = {""};

        System.out.println(YELLOW_BOLD_BRIGHT+"\n\t\tSSS+   BIENVENIDOS A MONSTERS INC REFORMADO   SSS+\n"+rest);
        System.out.println("Les daremos un pequeno tour por la empresa, comencemos por la Cafeteria:");

        System.out.println(WHITE_BOLD+"\t\t\t*************");
        System.out.println("\t\t\t* CAFETERIA *");
        System.out.println("\t\t\t*************\n"+rest); Thread.sleep(2000);
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.presentaCafeteria();
        cafeteria.main(str);
        System.out.println("\n\t\t¡¡AQUI TERMINA LA CAFETERIA!!\n");

        System.out.println("Veamos que tal lucen esos Banos");
        System.out.println(WHITE_BOLD+"\t\t\t*********");
        System.out.println("\t\t\t* BANOS *");
        System.out.println("\t\t\t*********\n"+rest);
        SimulacionBano banos = new SimulacionBano();
        banos.setMonstruos(cafeteria.getMonstruos());
        banos.main(str);
        System.out.println("\n\t\t¡¡AQUI TERMINAN LOS BANOS!!\n");

        System.out.println("Ahora vamos al Vestidor");
        System.out.println(WHITE_BOLD+"\t\t\t************");
        System.out.println("\t\t\t* VESTIDOR *");
        System.out.println("\t\t\t************\n"+rest);
        Vestidor vestidor = new Vestidor();
        vestidor.setMonstruos(cafeteria.getMonstruos());
        vestidor.main(str);
        System.out.println("\n\t\t¡¡AQUI TERMINAN EL VESTIDOR!!\n");

        System.out.println("Y para finalizar tenemos nuestros famosisimos centros, empecemos por el de Sustos 0_0");
        System.out.println(WHITE_BOLD+"\t\t\t********************");
        System.out.println("\t\t\t* CENTRO DE SUSTOS *");
        System.out.println("\t\t\t********************\n"+rest);
        CentroDeSustos centroDeSustos = new CentroDeSustos();
        centroDeSustos.setMonstruos(cafeteria.getMonstruos());
        centroDeSustos.main(str);
        System.out.println("\n\t\t¡¡AQUI TERMINA CENTRO DE SUSTOS!!\n");

        System.out.println("Y terminemos con el centro de risas 0o0");
        System.out.println(WHITE_BOLD+"\t\t\t*******************");
        System.out.println("\t\t\t* CENTRO DE RISAS *");
        System.out.println("\t\t\t*******************\n"+rest);
        CentroDeRisas centroDeRisas = new CentroDeRisas();
        centroDeRisas.setMonstruos(vestidor.getMonstruos());
        centroDeRisas.main(str);
        System.out.println("\n\t\t¡¡AQUI TERMINA CENTRO DE RISAS!!\n");

        System.out.println(CYAN_BRIGHT+"\t\tASI TERMINAMOS EL RECORRIDO, REGRESEN PRONTO :D"+rest);
    }
}