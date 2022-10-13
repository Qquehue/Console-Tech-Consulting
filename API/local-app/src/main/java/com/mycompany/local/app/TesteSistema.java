/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.local.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;

/**
 *
 * @author UL334AW
 */
public class TesteSistema {

    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        Looca looca = new Looca();
        
/*      looca.getGrupoDeDiscos();
        looca.getGrupoDeProcessos();
        looca.getGrupoDeServicos();
        looca.getMemoria();
        looca.getProcessador();
        looca.getSistema();
        looca.getTemperatura();*/
        
        Sistema sistema = looca.getSistema();
        
/*      sistema.getPermissao();
        sistema.getFabricante();
        sistema.getArquitetura();
        sistema.getInicializado();
        sistema.getSistemaOperacional();*/

//      Exemplos pegando grupos com lista:
//      DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
//      List<Disco> discos = grupoDeDiscos.getDiscos();
//      for (Disco disco : discos) {
//      System.out.println(disco);
//      }
        
        
        
        
    }

}
