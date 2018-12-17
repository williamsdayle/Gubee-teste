/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import back_end.Gubee;

import com.google.gson.Gson;

import java.io.Serializable;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.util.List;


/**
 *
 * @author willi
 */


public class Dados implements Serializable {

    Gubee gb;
    Client c;
    WebResource wr;
    String resposta;
    Gson gson;

    public String inserir() {
        gb = new Gubee();
        gb.setProductName("Gubee Integrador");
        gb.setDescription("Ferramenta de integração para marketplaces");
        List<String> list_test_target = new ArrayList<String>();
        list_test_target.add("Ecommerce#");
        list_test_target.add("ERP#");
        list_test_target.add("Lojista que não desejam possuir ecommerce#");
        gb.setTargetMarket(list_test_target);
        List<String> list_technologis = new ArrayList<String>();
        list_technologis.add("Java 10$");
        list_technologis.add("Kotlin$");
        list_technologis.add("Kafka$");
        list_technologis.add("Event Stream$");
        list_technologis.add("Redis$");
        list_technologis.add("MongoDB$");
        gb.setStack(list_technologis);
        if (gb.getProductName().contains(" ")) {
            gb.setProductName(gb.getProductName().replace(' ', '_'));
        }

        c = Client.create();
        wr = c.resource("https://testesteph-bf7a3.firebaseio.com/" + gb.getProductName() + ".json");
        gson = new Gson();
        String response = wr.type(MediaType.APPLICATION_JSON).put(String.class, gson.toJson(gb));
        list_test_target.clear();
        list_technologis.clear();

        gb.setProductName("Gubee Fretes");
        gb.setDescription("Ferramenta para gestão e calculo de fretes");

        list_test_target.add("Ecommerce#");
        list_test_target.add("ERP#");
        list_test_target.add("Loja fisica#");
        gb.setTargetMarket(list_test_target);

        list_technologis.add("NodeJS$");

        list_technologis.add("MongoDB$");
        gb.setStack(list_technologis);
        if (gb.getProductName().contains(" ")) {
            gb.setProductName(gb.getProductName().replace(' ', '_'));
        }

        c = Client.create();
        wr = c.resource("https://testesteph-bf7a3.firebaseio.com/" + gb.getProductName() + ".json");
        gson = new Gson();
        response = wr.type(MediaType.APPLICATION_JSON).put(String.class, gson.toJson(gb));

        list_test_target.clear();
        list_technologis.clear();

        gb.setProductName("Gubee AntiFraude");
        gb.setDescription("Ferramenta especialistas em detecção e prevenção à fraude");

        list_test_target.add("Ecommerce#");
        list_test_target.add("Telecom#");
        list_test_target.add("Venda direta#");
        list_test_target.add("Mobile First#");
        list_test_target.add("Digital Onboarding#");
        gb.setTargetMarket(list_test_target);

        list_technologis.add("Big Data Analytics$");
        list_technologis.add("Hadoop$");
        list_technologis.add("Kafka$");
        list_technologis.add("Pig$");
        list_technologis.add("Cassandra$");

        gb.setStack(list_technologis);
        String temp = "";

        if (gb.getProductName().contains(" ")) {
            gb.setProductName(gb.getProductName().replace(' ', '_'));

        }
        c = Client.create();
        wr = c.resource("https://testesteph-bf7a3.firebaseio.com/" + gb.getProductName() + ".json");
        gson = new Gson();
        response = wr.type(MediaType.APPLICATION_JSON).put(String.class, gson.toJson(gb));

        return response;
    }

    public String returnGubee(String procura) {
        gb = new Gubee();
        c = Client.create();
        if (procura.contains(" ")) {
            procura = procura.replace(' ', '_');
        }
        wr = c.resource("https://testesteph-bf7a3.firebaseio.com/" + procura + ".json");
        gson = new Gson();
        String response = wr.get(String.class);
        Gson gson = new Gson();
        gb = gson.fromJson(response, Gubee.class);

        return gb.getStack().toString() + gb.getTargetMarket().toString();

    }

    public List<Gubee> returnListaGubees() {
        List<Gubee> lista = new ArrayList<Gubee>();

        c = Client.create();
        wr = c.resource("https://testesteph-bf7a3.firebaseio.com/.json");
        gson = new Gson();
        String response = wr.get(String.class);

        String[] gubes = response.split("[}]");
        String nomeGubee = "";
        String descriGubee = "";

        int aux = 0;
        int temp = 0;
        int temp_target = 1;
        int aux_target = 0;
        int temp_stack = 1;
        int aux_stack = 0;

        for (int i = 0; i < gubes.length; i++) {
            List<String> targetVals = new ArrayList<String>();
            List<String> stackVals = new ArrayList<String>();

            aux++;
            aux_target++;
            aux_stack++;

            int x = 0;
            String[] nomes = gubes[i].split("[@]");
            for (int h = 0; h < nomes.length; h++) {
                String nome = "";
                x = nomes[h].indexOf(":");
                if (x != 0) {
                    for (int k = 0; k < x; k++) {
                        nome += nomes[h].charAt(k);
                    }

                    nome = nome.replace("{", "");
                    nome = nome.replace("_", " ");
                    nomeGubee = nome;

                }

            }
            String[] desc = response.split("[d][e][s][c][r][i][p][t][i][o][n]");
            for (int h = temp; h <= aux; h++) {
                temp++;
                String nome = "";
                x = desc[h].indexOf(",");
                if (x != 0) {
                    for (int k = 0; k < x; k++) {
                        nome += desc[h].charAt(k);
                    }
                    nome = nome.replace(":", "");
                    descriGubee = nome;

                }

            }

            String[] target = response.split("[t][a][r][g][e][t][M][a][r][k][e][t]");

            for (int h = temp_target; h < target.length; h++) {
                temp_target++;
                String nome = "";
                String valores = target[h];
                int fim = valores.indexOf("]");
                int begin = valores.indexOf("[");

                if (begin != 0) {

                    for (int k = begin; k <= fim; k++) {
                        nome += valores.charAt(k);
                    }
                    nome = nome.replace("[", "");
                    nome = nome.replace("]", "");
                    String[] separados = nome.split("[,]");

                    for (int k = 0; k < separados.length; k++) {
                        separados[k] = separados[k].replace("#", "");
                        targetVals.add(separados[k]);

                    }
                    break;

                }

            }
            String[] stack = response.split("[s][t][a][c][k]");
            for (int h = temp_stack; h < stack.length; h++) {
                temp_stack++;
                String nome = "";
                String valores = stack[h];
                int fim = valores.indexOf("]");
                int begin = valores.indexOf("[");
                if (begin != 0) {

                    for (int k = begin; k <= fim; k++) {
                        nome += valores.charAt(k);
                    }
                    nome = nome.replace("[", "");
                    nome = nome.replace("]", "");
                    String[] separados = nome.split("[,]");

                    for (int k = 0; k < separados.length; k++) {
                        separados[k] = separados[k].replace("$", "");
                        stackVals.add(separados[k]);
                    }
                    break;
                }
            }
            Gubee gubee = new Gubee();
            gubee.setDescription(descriGubee);
            gubee.setProductName(nomeGubee);
            gubee.setStack(stackVals);
            gubee.setTargetMarket(targetVals);
            lista.add(gubee);

        }

        return lista;

    }

}
