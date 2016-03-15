/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pattengames.loader;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author José
 */
public class Loader2 {

    public static int diasDeAtraso(LocalDate da) {

        return (int) da.until(LocalDate.now(), ChronoUnit.DAYS);

    }

    public static void main(String[] args) {
        int aa = diasDeAtraso(LocalDate.of(2016, Month.MARCH, 11));
        System.err.println("rrrr " + aa);
    }

}
