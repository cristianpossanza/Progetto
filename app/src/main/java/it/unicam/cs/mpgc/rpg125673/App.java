package it.unicam.cs.mpgc.rpg125673;

import it.unicam.cs.mpgc.rpg125673.model.entity.Giocatore;
import it.unicam.cs.mpgc.rpg125673.model.entity.Mostro;

public class App {
    public static void main(String args[]) {
        // 1. Creiamo le nostre entità
        Giocatore eroe = new Giocatore("Artù");
        Mostro goblin = new Mostro("Goblin Cattivo", 30, 5, 50);

        System.out.println("Inizia la battaglia tra " + eroe.getNome() + " e " + goblin.getNome() + "!\n");

        // 2. L'eroe attacca il goblin
        System.out.println(eroe.getNome() + " attacca infliggendo " + eroe.getAttacco() + " danni!");
        goblin.subisciDanno(eroe.getAttacco());
        System.out.println("Salute del Goblin: " + goblin.getPuntiVita() + "/" + goblin.getPuntiVitaMassimi() + "\n");

        // 3. Il goblin contrattacca
        System.out.println(goblin.getNome() + " contrattacca infliggendo " + goblin.getAttacco() + " danni!");
        eroe.subisciDanno(goblin.getAttacco());
        System.out.println("Salute di " + eroe.getNome() + ": " + eroe.getPuntiVita() + "/" + eroe.getPuntiVitaMassimi() + "\n");

        // 4. L'eroe dà il colpo di grazia
        System.out.println(eroe.getNome() + " sferra un altro attacco!");
        goblin.subisciDanno(eroe.getAttacco());

        if (!goblin.isVivo()) {
            System.out.println("Il " + goblin.getNome() + " è stato sconfitto!");
            eroe.aggiungiEsperienza(goblin.getRicompensaEsperienza());
            System.out.println(eroe.getNome() + " ha guadagnato " + goblin.getRicompensaEsperienza() + " XP. (XP Totali: " + eroe.getEsperienza() + ")");
        }
    }
}

