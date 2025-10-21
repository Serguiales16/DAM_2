package base_datos;

import java.io.*;
import java.util.Scanner;

public class Pokemon {



    public static void crearFichero(File fichero) {

        if (!fichero.exists()) {

        fichero = new File(RUTA_FICHERO);

        System.out.println("Fichero creado con exito");

        } else {

            System.out.println("El fichero ya existe");
        }
    }

    public static void añadirPokemon(File fichero)  {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del Pokemon: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el tipo del Pokemon: ");
        String tipo1 = sc.nextLine();
        System.out.println("Introduce el segundo tipo del Pokemon (si no tiene, dejalo vacio): ");
        String tipo2 = sc.nextLine();

        String pokemonFinal = "Nombre: " + nombre + " - Tipo1: " + tipo1 + " Tipo2: " + tipo2;

        try {
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pokemonFinal);
            bw.newLine();
            bw.close();

            System.out.println("Pokemon añadido con exito");
        } catch (IOException e) {

            System.out.println("Error al escribir en el fichero");
            return;

        }



    }

    public static void informacionFichero(File fichero) {

        if (fichero.exists()) {

            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
            System.out.println("Nombre: " + fichero.getName());
            System.out.println("Tamaño: " + fichero.length() + " bytes");
            System.out.println("Se puede leer: " + fichero.canRead());
            System.out.println("Se puede escribir: " + fichero.canWrite());

        } else {

            System.out.println("El fichero no existe");
        }

    }

    public static void leerFichero(File fichero) {

        try {

            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {

                System.out.println(linea);
                if (linea.isEmpty()) {
                    System.out.println("El fichero esta vacio");
                    break;
                }


            }
            br.close();

        } catch (IOException e) {

            System.out.println("Error en la lectura del fichero");
        }

    }

    public static void borrarFichero(File fichero) {

        if (fichero.exists()) {

            fichero.delete();
            System.out.println("Fichero borrado con exito");

        } else {

            System.out.println("El fichero no existe");
        }

    }

    private static final String RUTA_FICHERO =".idea/recursos/pokemon.txt";

    public static void main(String[] args) {

        File fichero = new File(RUTA_FICHERO);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Selecciona una opcion:\n1)Crear Fichero\n2)Añadir Pokemon\n3)Leer Fichero\n4)Informacion tecnica\n5)Borrar Fichero\n6)Salir");
            int opcion = sc.nextInt();


            switch (opcion) {
                case 1:
                    crearFichero(fichero);
                    break;
                case 2:
                    añadirPokemon(fichero);
                    break;
                case 3:
                    leerFichero(fichero);
                    break;
                case 4:
                    informacionFichero(fichero);
                    break;
                case 5:
                    borrarFichero(fichero);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
            }
        }




    }


}
