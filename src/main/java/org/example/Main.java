package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cabina> listaCabinas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("1. Crear cabina telefónica");
            System.out.println("2. Escoger cabina telefónica y registrar llamada");
            System.out.println("3. Mostrar información detallada por cabina");
            System.out.println("4. Mostrar consolidado total de cabinas");
            System.out.println("5. Reiniciar cabina telefónica");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número de la cabina: ");
                    String numeroCabina = sc.next();
                    listaCabinas.add(new Cabina(numeroCabina));
                    System.out.println("Cabina creada exitosamente.");
                    break;

                case 2:
                    if (listaCabinas.isEmpty()) {
                        System.out.println("No hay cabinas registradas.");
                        break;
                    }
                    System.out.println("Cabinas disponibles:");
                    for (int i = 0; i < listaCabinas.size(); i++) {
                        System.out.println((i + 1) + ". " + listaCabinas.get(i).getNumeroCabina());
                    }
                    System.out.print("Seleccione una cabina: ");
                    int indiceCabina = sc.nextInt() - 1;
                    if (indiceCabina < 0 || indiceCabina >= listaCabinas.size()) {
                        System.out.println("Selección inválida.");
                        break;
                    }
                    Cabina cabinaSeleccionada = listaCabinas.get(indiceCabina);
                    System.out.println("1. Llamada Local");
                    System.out.println("2. Llamada Larga Distancia");
                    System.out.println("3. Llamada Celular");
                    System.out.print("Seleccione el tipo de llamada: ");
                    int tipoLlamada = sc.nextInt();
                    System.out.print("Ingrese la duración en minutos: ");
                    int minutos = sc.nextInt();
                    switch (tipoLlamada) {
                        case 1:
                            cabinaSeleccionada.registrarLlamadaLocal(minutos);
                            break;
                        case 2:
                            cabinaSeleccionada.registrarLlamadaLargaDistancia(minutos);
                            break;
                        case 3:
                            cabinaSeleccionada.registrarLlamadaCelu(minutos);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                    System.out.println("Llamada registrada exitosamente.");
                    break;

                case 3:
                    if (listaCabinas.isEmpty()) {
                        System.out.println("No hay cabinas registradas.");
                        break;
                    }
                    for (Cabina cabina : listaCabinas) {
                        System.out.println(cabina);
                    }
                    break;

                case 4:
                    if (listaCabinas.isEmpty()) {
                        System.out.println("No hay cabinas registradas.");
                        break;
                    }
                    int totalLlamadas = 0;
                    int totalMinutos = 0;
                    double totalCosto = 0;
                    for (Cabina cabina : listaCabinas) {
                        totalLlamadas += cabina.getLlamadasLocales() + cabina.getLlamadasLargaDistancia() + cabina.getLlamadasCelu();
                        totalMinutos += cabina.getMinutos();
                        totalCosto += cabina.calcularCostoTotal();
                    }
                    System.out.println("Consolidado total:");
                    System.out.println("Total llamadas: " + totalLlamadas);
                    System.out.println("Total minutos: " + totalMinutos);
                    System.out.println("Total costo: $" + totalCosto);
                    break;

                case 5:
                    if (listaCabinas.isEmpty()) {
                        System.out.println("No hay cabinas registradas.");
                        break;
                    }
                    System.out.println("Cabinas disponibles:");
                    for (int i = 0; i < listaCabinas.size(); i++) {
                        System.out.println((i + 1) + ". " + listaCabinas.get(i).getNumeroCabina());
                    }
                    System.out.print("Seleccione una cabina para reiniciar: ");
                    int indiceReiniciar = sc.nextInt() - 1;
                    if (indiceReiniciar < 0 || indiceReiniciar >= listaCabinas.size()) {
                        System.out.println("Selección inválida.");
                        break;
                    }
                    listaCabinas.get(indiceReiniciar).reiniciarCabina();
                    System.out.println("Cabina reiniciada exitosamente.");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
}