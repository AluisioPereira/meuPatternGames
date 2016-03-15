/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author José
 */
public interface CalculaMultaIF {

    public BigDecimal calcularMulta(LocalDate dataDevolucao);
}
