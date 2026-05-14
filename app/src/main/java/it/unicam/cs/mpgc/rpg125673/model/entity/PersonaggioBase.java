package it.unicam.cs.mpgc.rpg125673.model.entity;

public abstract class PersonaggioBase implements Personaggio {
    private final String nome;
    private int puntiVita;
    private final int puntiVitaMassimi;
    private final int attacco;

    public PersonaggioBase(String nome, int puntiVitaMassimi, int attacco) {
        this.nome = nome;
        this.puntiVitaMassimi = puntiVitaMassimi;
        this.puntiVita = puntiVitaMassimi;
        this.attacco = attacco;
    }

    @Override
    public String getNome() {return this.nome;}

    @Override
    public int getPuntiVita() {return this.puntiVita;}

    @Override
    public int getPuntiVitaMassimi() {return this.puntiVitaMassimi;}

    @Override
    public int getAttacco() {return this.attacco;}

    @Override
    public void subisciDanno(int danno) {
        if (danno > 0) {
            this.puntiVita -= danno;
        if (this.puntiVita < 0) {
            this.puntiVita = 0;
            }
        }
    }

    @Override
    public boolean isVivo() {
        return this.puntiVita > 0;
    }
}
