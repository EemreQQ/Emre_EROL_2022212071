package com.example.myapplication;

public class Teams {
    private String takimAdi;
    private String takimLogo;
    private String takimMilliyeti;
    private int takimSiralama;

    // Boş constructor (Firestore için gerekli)
    public Teams() {}

    public Teams(String takimAdi, String takimLogo, String takimMilliyeti, int takimSiralama) {
        this.takimAdi = takimAdi;
        this.takimLogo = takimLogo;
        this.takimMilliyeti = takimMilliyeti;
        this.takimSiralama = takimSiralama;
    }

    public String getakimAdi() {
        return takimAdi;
    }

    public String getTakimLogo() {
        return takimLogo;
    }

    public String getTakimMilliyeti() {
        return takimMilliyeti;
    }

    public int getTakimSiralama() {
        return takimSiralama;
    }
}