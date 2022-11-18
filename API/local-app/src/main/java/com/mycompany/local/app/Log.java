package com.mycompany.local.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import oshi.driver.linux.proc.CpuInfo;
import oshi.driver.linux.proc.CpuStat;

/**
 *
 * @author ctc
 */
public class Log {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Instanciando uma máquina para exemplo
        Looca looca = new Looca();
        Maquina maquina = new Maquina();
        Processador proc = new Processador();
        Memoria memoria = new Memoria();
        Sistema sistema = new Sistema();
        DiscosGroup discos = new DiscosGroup();
        Conversor conversor = new Conversor();

        //Classe reponsável em formatar a data
        DateFormat hoursFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateHoursFormat = new SimpleDateFormat("dd-MM-yyyy HH'h'mm'm'ss'ss'");

        for (int b = 0; b < 10; b++) {
            Date dateHours = new Date();
            Date date = new Date();

            System.out.print("Captando log das máquinas...\n");

            FileWriter arqLog = new FileWriter(String.format("C:\\Users\\FP594HT\\Downloads\\Logs\\log %s.txt", dateHoursFormat.format(dateHours)));
            PrintWriter gravarArqLog = new PrintWriter(arqLog);

            gravarArqLog.print("Log iniciado em " + dateFormat.format(date) + " gravando...");

            for (int i = 1; i <= 5; i++) {
                Date hours = new Date();

                System.out.println(i);
                maquina.setUsoMemoria(memoria.getEmUso().doubleValue());
                String memorias = Conversor.formatarBytes(memoria.getEmUso()).replace("GiB", "").replace(",", ".");
                Double memoriaAtual = Double.parseDouble(memorias);
                maquina.setUsoCPU(proc.getUso());
                String cpus = Conversor.formatarBytes(proc.getUso().longValue()).replace("GiB", "").replace(",", ".").replace("bytes", "");
                Double cpuAtual = Double.parseDouble(cpus);
                gravarArqLog.print(String.format("\n CPU: %.1f | RAM: %.2f GB | %s ", cpuAtual,
                memoriaAtual,
                hoursFormat.format(hours)));

                TimeUnit.SECONDS.sleep(1);
            }
            arqLog.close();
        }

        System.out.println("Seu log foi gravado com sucesso :)\n");

    }

}
