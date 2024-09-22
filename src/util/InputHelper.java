package util;

import asset.VolailleType;

import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InputHelper
{
    private Scanner sc = new Scanner(System.in);

    /**
     *
     * @param message Message aide à la saisie
     * @param enumClass Class enum pour la vérification de l'existance du type saisi
     * @return Retourne la constante de l'Enum
     * @param <T>
     */
    public <T extends Enum<T>> T inputToEnum(Class<T> enumClass, String message) {

        boolean valide = false;
        T result = null;

        while (!valide) {

            System.out.print(message);
            String input = sc.nextLine().toUpperCase().trim();

            try {

                result = Enum.valueOf(enumClass, input);
                valide = true;

            } catch (IllegalArgumentException e) {

                System.out.println("Saisi invalide. Veuillez réessayer.");

            }
        }

        return result;
    }

    /**
     *
     * @param map HashMap
     * @param message Message aide à la saisie
     * @return La clé K key si elle est rouvé dans la Map sinon propose une nouvelle saisi
     *         Si 0 est saisi renvoi null, indiquant le souhat de quitter
     * @param <K>
     * @param <V>
     */
    public <K, V> K inputMapHasKey(Map<K, V> map, String message) {
        while (true) {
            System.out.print(message + " [Retour > 0]: ");
            String input = sc.nextLine();

            if (input.equals("0")) return null;

            try {
                K key = (K) input; // Convertir l'entrée au Type K défini dans Map
                if (map.containsKey(key)) {
                    return key;
                } else {
                    System.out.println("Clé non trouvée, veuillez réessayer.");
                }
            } catch (ClassCastException e) {
                System.out.println("Erreur de type. Veuillez entrer une valeur valide.");
            }
        }
    }

    /**
     *
     * @param format Format de la date saisie pour la vérification
     * @param message Message aide à la saisie
     * @return La date au format String
     */
    public String inputDate(String format, String message) {

        boolean valide = false;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = null;

        while (!valide) {

            System.out.print(message + "[" + format + "] : ");
            date = sc.nextLine().trim();

            try {

                sdf.parse(date);
                valide = true;

            } catch (Exception e) {

                System.out.println("Format de date invalide. Veuillez réessayer [" + format + "].");

            }
        }

        return date;
    }

    /**
     *
     * @param message  Message aide à la saisie
     * @return
     */
    public int inputInteger(String message) {

        boolean valide = false;
        int value = 0;

        while (!valide) {

            System.out.print(message);

            try {

                value = sc.nextInt();
                valide = true;

            } catch (InputMismatchException e) {

                System.out.println("Saisi invalide. Veuillez réessayer.");
                sc.nextLine();
            }
        }

        return value;
    }

    /**
     *
     * @param message  Message aide à la saisie
     * @return
     */
    public double inputDouble(String message) {

        boolean valide = false;
        double value = 0.0;

        while (!valide) {

            System.out.print(message);

            try {

                value = sc.nextDouble();
                valide = true;

            } catch (InputMismatchException e) {

                System.out.println("Saisi invalide. Veuillez réessayer.");
                sc.nextLine();
            }
        }
        return value;
    }
}
