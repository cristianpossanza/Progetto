package it.unicam.cs.mpgc.rpg125673.model.item;

public class Arma implements Oggetto{
    private final String nome;
    private final String descrizione;
    private final int bonusAttacco;

    public Arma(String nome, String descrizione, int bonusAttacco) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.bonusAttacco = bonusAttacco;
    }

    @Override
    public String getNome() { return this.nome; }

    @Override
    public String getDescrizione() { return this.descrizione; }

    public int getBonusAttacco() { return this.bonusAttacco; }
}
