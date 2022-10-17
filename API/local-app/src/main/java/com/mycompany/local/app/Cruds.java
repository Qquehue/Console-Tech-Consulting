/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.local.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author UL334AW
 */
public class Cruds {

    private JdbcTemplate jdbcTemplate;
    private Looca looca = new Looca();
    private Conexao conexao = new Conexao();

    private Maquina maquina = new Maquina();

    private Processador proc = new Processador();
    private Memoria memoria = new Memoria();
    private Sistema sistema = new Sistema();

    public Cruds() {
        BasicDataSource dataSource = new BasicDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);
// configuração do dataSource, como visto antes
    }

    public void programa() {

        conexao.conectar();
        JdbcTemplate database = conexao.getConnection();

        List<Maquina> lista = database.query("select * from usoMaquina",
                new BeanPropertyRowMapper(Maquina.class));

        /*for (Maquina dados : lista) {
            System.out.println(
                    "//////////////////////////////////////////////////////////////////////////////////////////////////////////////\n"+
                    "ID: " + dados.getIdUso()
                    + "\ntemperatura: " + dados.getTemperaturaCPU()
                    + "\nUso CPU: " + dados.getUsoCPU()
                    + "\nUso Memoria: " + dados.getUsoMemoria()
                    + "\nUso Disco: " + dados.getUsoDisco()
                    + "\nUp Time: " + dados.getUpTime()
                    + "\nMaquina Correspondente: " + dados.getFkMaquina()
                    + "\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        }*/

        System.out.println(lista);

        System.out.println(looca.getMemoria());

        System.out.println(sistema.getTempoDeAtividade());

        System.out.println(looca.getGrupoDeDiscos());

        System.out.println(looca.getTemperatura());

    }

    public void insertsBanco() {
        
        
        
    }

}
