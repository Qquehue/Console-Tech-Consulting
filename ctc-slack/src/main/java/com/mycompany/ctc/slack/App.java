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
        Scanner validacao = new Scanner(System.in);

        System.out.println("Teste1: ");
        Double x = validacao.nextDouble();

        System.out.println("Teste2: ");
        Double y = validacao.nextDouble();

        System.out.println("Teste3: ");
        Double z = validacao.nextDouble();

        if (x > 80 || y > 70 || z > 70) {

            json.put("text", "Acho que tá dando ruim, hein? :shrug:");
            Slack.sendMessage(json);

        }

    }
}
