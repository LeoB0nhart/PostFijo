/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author alan
 */
public class Stream {

    public static ArrayList<String> leer(String archivo) {
        String txt = "";
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((txt = br.readLine()) != null) {
                lineas.add(txt.trim());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineas;
    }

}
