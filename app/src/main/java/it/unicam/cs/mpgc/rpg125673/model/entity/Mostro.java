package it.unicam.cs.mpgc.rpg125673.model.entity;

public class Mostro extends PersonaggioBase{
    private final int ricompensaEsperienza; // Quanta esperienza dà se viene sconfitto

    public Mostro(String nome, int puntiVitaMassimi, int attacco, int ricompensaEsperienza) {
        super(nome, puntiVitaMassimi, attacco);
        this.ricompensaEsperienza = ricompensaEsperienza;
    }

    public int getRicompensaEsperienza() {
        return this.ricompensaEsperienza;
    }
}
