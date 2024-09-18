package util;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;

public class IdManager {

    /** Prepare le format de la date pour l'id*/
    private static final SimpleDateFormat     sdf   = new SimpleDateFormat("yyMMdd");

    /** Stock le nombre d'enregistrment pour chaque date */
    private static final Map<Long, Integer> dateCounters = new HashMap<>();

    /**
     * Initialise les compteurs pour chaque date des objets de la liste
     * <p>
     * {@code Function<T, Calendar>}
     *     Getter de la date de l'objet.
     *     Cette fonction doit renvoyer un objet de type `Calendar` représentant la date de l'objet
     * <p>
     * {@code Function<T, String>}
     *     Getter de l'ID de l'objet.
     *     Cette fonction doit renvoyer une chaîne de caractères représentant l'ID de l'objet.
     *
     * @param mapObject Liste d'objets
     * @param getCalendarDate Date de l'objet
     * @param getId Id de l'objet
     * @param <T>
     */
    public static <T> void initCounters(Map<String, T> mapObject, Function<T, Calendar> getCalendarDate,
                                        Function<T, String> getId) {

        Iterator<Map.Entry<String, T>> iterator = mapObject.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, T> entry = iterator.next();
            T                    obj   = entry.getValue();

            String id = getId.apply(obj);
            Calendar date = getCalendarDate.apply(obj);

            String dateStr = sdf.format(date.getTime()); // Format la date yyMMdd

            String[] idParts = id.split("-"); // split l id
            //TODO ajouter un controlle du format

            String prefix = idParts[0]; // récupère l'id en debut de chaine typé String

            int objectCount = Integer.parseInt(idParts[2]); // récupère le compteur en fin de chaine

            // Créé un index Long pour le tableau de compteur, combinant le prefix et la date pour les compteurs.
            // Cela permet d avoir des compteurs indépendant par prefix (groupe) et date
            long key = Long.parseLong(prefix + dateStr);

            int currentCount = dateCounters.getOrDefault(key, 0);

            if (objectCount > currentCount) {
                dateCounters.put(key, objectCount);
            }
        }

    }


    /**
     * Créé un id au format int-yyMMdd-int => id_type-date-compteur
     * <p>
     * @param prefix pour differencier les type d'objet
     * @param date
     * @return
     */
    public static String generateId(int prefix, Calendar date) {

        String dateStr = sdf.format(date.getTime());
        long key = Long.parseLong(prefix + dateStr);
        int counter = dateCounters.getOrDefault(key, 0) + 1;

        dateCounters.put(key, counter);

        return prefix + "-" + dateStr + "-" + String.format("%02d", counter);
    }
}
