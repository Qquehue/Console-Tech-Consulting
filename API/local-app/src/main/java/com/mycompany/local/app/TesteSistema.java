/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.local.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author UL334AW
 */
public class TesteSistema {

    public static void main(String[] args) {
        
        Conexao conexao = new Conexao(); 
        Maquina maquina = new Maquina();
        Looca looca = new Looca();
        Cruds cruds = new Cruds();
        Processador proc = new Processador();
        /*conexao*/
        conexao.conectar();
        JdbcTemplate database = conexao.getConnection();
        
        List teste = database.queryForList("select * from Funcionario");
        
        String insert = "INSERT INTO testes VALUES (null, ?, null)";
        database.update(insert, proc.getUso());
        System.out.println("dados inseridos");
        
        System.out.println(teste);
        
/*      looca.getGrupoDeDiscos();
        looca.getGrupoDeProcessos();
        looca.getGrupoDeServicos();
        looca.getMemoria();
        looca.getProcessador();
        looca.getSistema();
        looca.getTemperatura();*/
        
        //Sistema sistema = looca.getSistema();
        
/*      sistema.getPermissao();
        sistema.getFabricante();
        sistema.getArquitetura();
        sistema.getInicializado();
        sistema.getSistemaOperacional();*/

//      Exemplos pegando grupos com lista:
        /*DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Disco> discos = grupoDeDiscos.getDiscos();
        for (Disco disco : discos) {
        System.out.println(disco);
        }
        
        System.out.println(cruds.listarTodos());*/
           
    }

}
