/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LENOVO
 */
public class BukuData {

    private String judul;
    private String penulis;
    private double rating;
    private double harga;
    private double inputHarga;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
    
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getinputHarga() {
        return inputHarga;
    }

    public void setinputHarga(double inputHarga) {
        this.inputHarga = inputHarga;
    }

    public double getHarga() {
        harga = inputHarga + 500 +  (rating * 100);
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
