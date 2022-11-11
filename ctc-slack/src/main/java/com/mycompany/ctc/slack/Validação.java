/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctc.slack;
import org.json.JSONObject;

/**
 *
 * @author Victor
 */
public class Validação {
    
    private Integer idMaquina;
    private Double usoCPU;
    private Double usoMemoria;
    private Double usoDisco;

    public Validação(Integer idMaquina, Double usoCPU, Double usoMemoria, Double usoDisco) {
        
        this.idMaquina = idMaquina;
        this.usoCPU = usoCPU;
        this.usoMemoria = usoMemoria;
        this.usoDisco = usoDisco;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
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

    public Double getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Double usoDisco) {
        this.usoDisco = usoDisco;
    }
    
    /*public  validarMaquina () {
        
        Double x = usoCPU;
        Double y = usoMemoria;
        Double z = usoDisco;

        if (x > 80 || y > 70 || z > 70) {

            json.put("text", m1.toString());
            Slack.sendMessage(json);

        } 
        
    } */

    @Override
    public String toString() {
        return String.format("\nId da Máquina: %d"
                + "\nUso CPU: %.2f"
                + "\nUso Memória: %.2f"
                + "\nUso Disco: %.2f"
                + "\nEstá com problema na máquina %d", 
                idMaquina,
                usoCPU,
                usoMemoria,
                usoDisco,
                idMaquina);
    }
    
}
