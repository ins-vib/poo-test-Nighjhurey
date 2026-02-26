package org.daw.eltest;

import java.util.ArrayList;

public class Test {
    private int[] respostesUser;
    private ArrayList<Pregunta> preguntes;
    private int posicionActual;

    public Test(ArrayList<Pregunta> preguntes) {
        this.preguntes = preguntes;
        // Array de entero del mismo tamaño del array de preguntas
        this.respostesUser = new int[preguntes.size()];

        for (int i = 0; i < respostesUser.length; i++) {
            // el -1 indica que la pregunta no se a respondido
            respostesUser[i] = -1;
        }
        // Inicia en posicion 0 la pregunta
        this.posicionActual = 0;
    }

    public String getEnunciatPreguntaActual() {
        // devuelve los datos de la pregunta actual se verifica que no este fuera de
        // rango
        if (posicionActual >= 0 && posicionActual < preguntes.size()) {
            Pregunta p = preguntes.get(posicionActual);
            return p.getEnunciat();
        }
        return "";
    }

    public String[] getRespostesPreguntaActual() {
        if (posicionActual >= 0 && posicionActual < preguntes.size()) {
            return preguntes.get(posicionActual).getRespostes();
        }
        // retorna vacio sino cumple
        return new String[0];
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void respondre(int resposta) {
        // verifica que la respuesta corresponda con la pregunta
        if (posicionActual >= 0 && posicionActual < respostesUser.length) {
            //guarda la respuesta en el array
            respostesUser[posicionActual] = resposta;
        }
    }

    public boolean anarEndavant()  {
        //avanza de posicion y si es la ultima no avanza
        if(posicionActual < preguntes.size()-1) {
            posicionActual++;
            return true;
        }
        return false;
    }

    public boolean anarEndarrera() {
        //mira que este en la 1ra posicion sino retrocede
        if(posicionActual > 0) {
            posicionActual--;
            return true;
        }
        return false;
    }

    public double solucionarTest() {
        double puntacion = 0;
        double puntosPorPregunta = 10.0;

        for (int i = 0; i < preguntes.size(); i++) {
            int respuestaUsario = respostesUser[i]; //la resposta de usuario
            Pregunta p = preguntes.get(i); //num de pregunta
            int respuestaCorrecta = p.getCorrecta(); //index de correcta
            int numPosibleRespuesta = p.getRespostes().length; //cantidad de opciones

            if(respuestaUsario == respuestaCorrecta) { //es correcta suma
                puntacion += puntosPorPregunta;
            }else if(respuestaCorrecta == -1) {

            }else {
                double penalizacion = puntosPorPregunta /numPosibleRespuesta;
                puntacion -= penalizacion;
            }
        }
        return puntacion;
    }
    
}
