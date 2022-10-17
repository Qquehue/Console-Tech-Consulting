/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.local.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.sql.Time;
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
    private Long usoMemoria;
    private Long usoDisco;
    private Time upTime;
    private Integer fkMaquina;

    public Long getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Long usoDisco) {
        this.usoDisco = usoDisco;
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

    public Long getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Long usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public Time getUpTime() {
        return upTime;
    }

    public void setUpTime(Time upTime) {
        this.upTime = upTime;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }    
    
    

}
