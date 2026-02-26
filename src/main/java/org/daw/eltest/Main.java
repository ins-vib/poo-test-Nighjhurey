/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.daw.eltest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {

        // Scanner para leer lo que escribe el usuario
        Scanner sc = new Scanner(System.in);

        // Crear las preguntas llamando al método auxiliar
        ArrayList<Pregunta> preguntes = inicialitzarPreguntes();

        // Crear el objeto Test pasando la lista de preguntas
        Test test = new Test(preguntes);

        // Variable que controla cuándo salir del menú
        boolean fin = false;

        // Bucle principal del programa (menú)
        while (!fin) {

            // Mostrar número de pregunta (+1 porque el usuario ve desde 1)
            System.out.println("Pregunta "
                    + (test.getPosicionActual() + 1)
                    + ". " + test.getEnunciatPreguntaActual());

            // Obtener las opciones de la pregunta actual
            String[] respostes = test.getRespostesPreguntaActual();

            // Recorrer el array y mostrar opciones (+1 para el usuario)
            for (int i = 0; i < respostes.length; i++) {
                System.out.println((i + 1) + ". " + respostes[i]);
            }

            // Mostrar menú de navegación
            System.out.println("1-Volver  2-Responder  3-Avanzar  4-Finalizar");

            // Leer opción elegida
            int opcion = sc.nextInt();

            // Estructura de control del menú
            switch (opcion) {

                case 1:
                    // Intentar retroceder una pregunta
                    if (!test.anarEndarrera()) {
                        System.out.println("No puedes retroceder más.");
                    }
                    break;

                case 2:
                    // Pedir respuesta del usuario
                    System.out.println("Introduce tu respuesta:");
                    int respuesta = sc.nextInt();

                    // Validar que la respuesta esté dentro de rango
                    if (respuesta >= 1 && respuesta <= respostes.length) {

                        // Guardar respuesta (-1 porque array empieza en 0)
                        test.respondre(respuesta - 1);

                        // Avanzar automáticamente a la siguiente
                        if (!test.anarEndavant()) {
                            System.out.println("Has respondido la última pregunta.");
                        }

                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 3:
                    // Avanzar manualmente
                    if (!test.anarEndavant()) {
                        System.out.println("Esta es la última pregunta.");
                    }
                    break;

                case 4:
                    // Salir del bucle
                    fin = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        // Cuando termina el bucle, corregimos el test
        double puntuacion = test.solucionarTest();

        // Mostrar nota final
        System.out.println("Has conseguido: " + puntuacion + " puntos.");

        // Cerrar Scanner
        sc.close();
    }

    // Método auxiliar para crear preguntas iniciales
    // Es static porque se llama desde main (que también es static)
    public static ArrayList<Pregunta> inicialitzarPreguntes() {

        // Crear lista vacía
        ArrayList<Pregunta> preguntes = new ArrayList<>();

        // Añadir preguntas (índice 0-based)
        preguntes.add(new Pregunta(
                "Qui va pintar el Guernica",
                new String[] { "Velàzquez", "Goya", "Picasso" },
                2)); // 2 = tercera opción (Picasso)

        preguntes.add(new Pregunta(
                "Quants segons té 1 hora",
                new String[] { "420", "760", "3600" },
                2)); // 2 = 3600

        // Devolver lista creada
        return preguntes;
    }
}