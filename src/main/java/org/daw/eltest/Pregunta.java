package org.daw.eltest;

public class Pregunta {
    private String enunciat;
    private String[] respostes;
    private int correcta;

    public Pregunta(String enunciat, String[] respostes, int correcta) {
        this.enunciat = enunciat;
        this.respostes = respostes;
        this.correcta = correcta;
    }

    public Pregunta() {
    }

    public String getEnunciat() {
        return enunciat;
    }

    public void setEnunciat(String enunciat) {
        this.enunciat = enunciat;
    }

    public String[] getRespostes() {
        return respostes;
    }

    public void setRespostes(String[] respostes) {
        this.respostes = respostes;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }

   
}
