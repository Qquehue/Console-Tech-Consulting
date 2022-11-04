/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.local.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author UL334AW
 */
public class Maquina {

    private Integer idUso;
    private Double temperaturaCPU;
    private Double usoCPU;
    private Double usoMemoria;
    private Integer fkMaquina;
    
    private String modeloCpu;
    private Double totalMemoria;
    private Double totalDisco;
    private Integer fkEstacao;
    private Integer teste = 1;

    public Integer getTeste() {
        return teste;
    }
    
    

    public String getModeloCpu() {
        return modeloCpu;
    }

    public void setModeloCpu(String modeloCpu) {
        this.modeloCpu = modeloCpu;
    }

    public Double getTotalMemoria() {
        return totalMemoria;
    }

    public void setTotalMemoria(Double totalMemoria) {
        this.totalMemoria = totalMemoria;
    }

    public Double getTotalDisco() {
        return totalDisco;
    }

    public void setTotalDisco(Double totalDisco) {
        this.totalDisco = totalDisco;
    }

    public Integer getFkEstacao() {
        return fkEstacao;
    }

    public void setFkEstacao(Integer fkEstacao) {
        this.fkEstacao = fkEstacao;
    }

    
    
    public Integer getIdUso() {
        return idUso;
    }

    public void setIdUso(Integer idUso) {
        this.idUso = idUso;
    }

    public Double getTemperaturaCPU() {
        return temperaturaCPU;
    }

    public void setTemperaturaCPU(Double temperaturaCPU) {
        this.temperaturaCPU = temperaturaCPU;
    }

    public Double getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(Double usoCPU) {
        this.usoCPU = usoCPU;
    }

    public Double getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Double usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }    
    
}