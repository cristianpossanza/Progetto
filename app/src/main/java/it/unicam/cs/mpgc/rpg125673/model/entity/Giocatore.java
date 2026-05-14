package it.unicam.cs.mpgc.rpg125673.model.entity;

public class Giocatore extends PersonaggioBase{
    private int esperienza;
    private int livello;

    public Giocatore(String nome) {
        // Un nuovo giocatore parte sempre con 100 Punti Vita e 15 di attacco
        super(nome, 100, 15);
        this.esperienza = 0;
        this.livello = 1;
    }

    public void aggiungiEsperienza(int quantita) {
        if (quantita > 0) {
            this.esperienza += quantita;
            controllaAumentoLivello();
        }
    }

    private void controllaAumentoLivello() {
        // Logica semplice: ogni 100 punti esperienza si sale di livello
        if (this.esperienza >= (this.livello * 100)) {
            this.livello++;
            // In futuro potremmo aggiungere logica per aumentare le statistiche
        }
    }

    public int getLivello() { return this.livello; }
    public int getEsperienza() { return this.esperienza; }
}
