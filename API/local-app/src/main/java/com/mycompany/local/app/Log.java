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

    public void gerarLog(String email, Integer id) throws IOException, InterruptedException {

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

        for (int b = 0; b < 1; b++) {
            Date dateHours = new Date();
            Date date = new Date();

            

            FileWriter arqLog = new FileWriter(String.format("C:\\Users\\FP594HT\\Downloads\\Logs\\log %s.txt", dateHoursFormat.format(dateHours)));
            PrintWriter gravarArqLog = new PrintWriter(arqLog);

           

            for (int i = 0; i < 1; i++) {
                Date hours = new Date();
// Iremos fazer um log de instalação/login, nele terá email e id da maquina do login, e dados do hardware atual da máquina pós iniciação ou manutenção
// total do HD, total da RAM, numero de CPUS, fabricante, nome do processador, frequencia e SO do sistema.
                System.out.println(i);
                
                
                String memoriasHD = Conversor.formatarBytes(discos.getTamanhoTotal()).replace("GiB", "").replace(",", ".");
                Double memoriaHDAtual = Double.parseDouble(memoriasHD);
                String memorias = Conversor.formatarBytes(memoria.getTotal()).replace("GiB", "").replace(",", ".");
                Double memoriaAtual = Double.parseDouble(memorias);
                Integer cpusFisicos = proc.getNumeroCpusFisicas();
                Integer cpusLogicas = proc.getNumeroCpusLogicas();
                String fabricante = proc.getFabricante();
                String nomeProc = proc.getNome();
                String frequencia = Conversor.formatarBytes(proc.getFrequencia()).replace("GiB", "").replace(",", ".");
                String so = sistema.getSistemaOperacional();
                //exemplo
                
                gravarArqLog.print(String.format("Log de instalação gerado às %s horário de Brasília no dia %s\n\n"
                        + "Seja bem vindo(a): %s\n\n"
                        + "--- Informações ---\n"
                        + "ID máquina:   %d \n"
                        + "Processador:  %s \n"
                        + "Fabricante:   %s \n"
                        + "CPU - física: %s \n"
                        + "CPU - lógica: %s \n"
                        + "Memória HD:   %.0f \n"
                        + "Memória RAM:  %.0f \n"
                        + "SO:           %s",
                        hoursFormat.format(hours),
                        dateFormat.format(date),
                        email,
                        id,
                        nomeProc,
                        fabricante,
                        cpusFisicos,
                        cpusLogicas,
                        memoriaHDAtual,
                        memoriaAtual,
                        so));

                TimeUnit.SECONDS.sleep(1);
            }
            arqLog.close();
        }

        System.out.println("Seu log foi gravado com sucesso :)\n");

    }

}
