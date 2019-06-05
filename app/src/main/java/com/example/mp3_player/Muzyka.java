package com.example.mp3_player;

public class Muzyka {
    private String tytul;
    private String autor;
    private int utwor;

    public Muzyka(String tytul, String autor, int utwor)
    {
        this.tytul = tytul;
        this.autor = autor;
        this.utwor = utwor;
    }

    public String getTytul()
    {
        return tytul;
    }

    public void setTytul(String tytul)
    {
        this.tytul=tytul;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        this.tytul=autor;
    }

    public int getUtwor()
    {
        return utwor;
    }

    public void setUtwor(int utwor)
    {
        this.utwor=utwor;
    }
}
