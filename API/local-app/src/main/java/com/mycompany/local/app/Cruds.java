/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.local.app;

import java.util.List;
import java.util.Map;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author UL334AW
 */
public class Cruds {
    
    private JdbcTemplate jdbcTemplate;

    public Cruds() {
        BasicDataSource dataSource = new BasicDataSource();
// configuração do dataSource, como visto antes
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List listarTodos() {
        List<Map<String, Object>> lista = jdbcTemplate.queryForList("select * from Funcionario");
        return lista;
    }

}
