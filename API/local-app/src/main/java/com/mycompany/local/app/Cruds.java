/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.local.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.driver.linux.proc.CpuInfo;
import oshi.driver.linux.proc.CpuStat;

/**
 *
 * @author UL334AW
 */
public class Cruds {

    private JdbcTemplate jdbcTemplate;
    private Looca looca = new Looca();
    private Conexao conexao = new Conexao();
    private AppSlack slack = new AppSlack();
    private Maquina maquina = new Maquina();
    private Processador proc = new Processador();
    private Memoria memoria = new Memoria();
    private Sistema sistema = new Sistema();
    private DiscosGroup discos = new DiscosGroup();
    Conversor conversor = new Conversor();
    


    
    
    

    public Cruds() {
        BasicDataSource dataSource = new BasicDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);

// configuração do dataSource, como visto antes
    }

    public void programa(Integer id) throws IOException, InterruptedException {

        conexao.conectar();
        JdbcTemplate database = conexao.getConnection();
        
        
        maquina.setUsoMemoria(memoria.getEmUso().doubleValue());
        String memorias = Conversor.formatarBytes(memoria.getEmUso()).replace("GiB", "").replace(",", ".");
        Double memoriaAtual = Double.parseDouble(memorias);
        maquina.setUsoCPU(proc.getUso());
        String cpus = Conversor.formatarBytes(proc.getUso().longValue()).replace("GiB", "").replace(",", ".").replace("bytes", "");
        Double cpuAtual = Double.parseDouble(cpus);
        maquina.setTemperaturaCPU(20.0);
        
        
        

        //maquina.setTemperaturaCPU(looca.getTemperatura().getTemperatura().doubleValue());
        String insertBanco = "INSERT INTO usoMaquina VALUES (null,?,?,?,CURRENT_TIMESTAMP,?)";
        database.update(insertBanco, maquina.getTemperaturaCPU(), cpuAtual, memoriaAtual, id);
        
        String memoria2 = Conversor.formatarBytes(memoria.getTotal()).replace("GiB", "").replace(",", ".");
        Double memoriaTotal = Double.parseDouble(memoria2);
        
        Double x = (memoriaAtual / memoriaTotal) * 100;
        
        System.out.println(x);
        
        if (cpuAtual > 40 || x > 50) {
            
            JSONObject json = new JSONObject();
            Validacao maquinaSlack = new Validacao(id, cpuAtual, x, 50.0);
            maquinaSlack.validarMaquina(json);
            
        }

    }

    
//    public Maquina returnBytes() {
//    Double memorias = maquina.getUsoMemoria();
//        
//    };
    
    
    /*public static void main(String[] args) {
        DiscosGroup grupoDeDiscos = new DiscosGroup();
        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (Disco disco : discos) {
            System.out.println(disco);
        }

    }*/
//    public void cadastroDeMaquina(Integer id) {
//        conexao.conectar();
//        JdbcTemplate database = conexao.getConnection();;
//        
//        
//    
//    
//
//        maquina.setModeloCpu(looca.getProcessador().getNome());
//        maquina.setTotalDisco(discos.getTamanhoTotal().doubleValue());
//        maquina.setTotalMemoria((looca.getMemoria().getTotal()).doubleValue());
//
//        String insertCadastro = "INSERT INTO Maquina VALUES (?,?,?,?,CURRENT_TIMESTAMP,null)";
//        database.update(insertCadastro,this.programa(id), maquina.getModeloCpu(), maquina.getTotalMemoria(), maquina.getTotalDisco());
//
//      
//    
//    
//      
//   }

    }
    

