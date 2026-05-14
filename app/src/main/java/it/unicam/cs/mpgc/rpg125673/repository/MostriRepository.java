package it.unicam.cs.mpgc.rpg125673.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.rpg125673.model.entity.Mostro;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Questa classe si occupa ESCLUSIVAMENTE di caricare i mostri dal file JSON.
 * Rispetta il Single Responsibility Principle.
 */
public class MostriRepository {

    // Usiamo una HashMap: la Chiave è il nome (String), il Valore è il Mostro
    private final Map<String, Mostro> mappaMostri;

    public MostriRepository() {
        this.mappaMostri = new HashMap<>();
        caricaMostriDaJson();
    }

    private void caricaMostriDaJson() {
        try {
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(
                    Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("mostri.json"))
            );

            // 1. GSON legge il JSON come una normale Lista temporanea
            Type tipoListaMostri = new TypeToken<List<Mostro>>() {
            }.getType();
            List<Mostro> mostriLetti = gson.fromJson(reader, tipoListaMostri);

            // 2. Travasiamo la Lista nella nostra HashMap
            for (Mostro m : mostriLetti) {
                // Usiamo toLowerCase() così la ricerca non è sensibile alle maiuscole/minuscole
                this.mappaMostri.put(m.getNome().toLowerCase(), m);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Errore durante il caricamneto dei mostri: " + e.getMessage());
        }
    }

    /**
     * Cerca un mostro nella HashMap in modo istantaneo.
     */
    public Mostro getMostro (String nome){
        // Cerchiamo direttamente la chiave nella mappa (tutto in minuscolo)
        Mostro m = this.mappaMostri.get(nome.toLowerCase());

            if (m != null) {
                 // Restituiamo una nuova copia per il combattimento
                return new Mostro(m.getNome(), m.getPuntiVitaMassimi(), m.getAttacco(), m.getRicompensaEsperienza());
                }

            return null; // Se il mostro non esiste nella mappa
        }
}
