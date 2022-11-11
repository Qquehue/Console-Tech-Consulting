package com.mycompany.ctc.slack;

import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Victor
 */
public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        JSONObject json = new JSONObject();
        
        Validação m1 = new Validação(1, 90.0, 50.0, 60.0);
        
        Double x = m1.getUsoCPU();
        Double y = m1.getUsoMemoria();
        Double z = m1.getUsoDisco();

        if (x > 80 || y > 70 || z > 70) {

            json.put("text", m1.toString());
            Slack.sendMessage(json);

        }

    }
}
