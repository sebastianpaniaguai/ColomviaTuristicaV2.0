package com.example.sebas.colombiaturistica;

/**
 * Created by sebas on 10/24/2015.
 */
public class ListEntries {
    private int idImage;
    private String nombre;
    private String direccion;
    private String reservas;
    public ListEntries(int idImage, String nombre, String direccion, String reservas) {
        this.idImage = idImage;
        this.nombre = nombre;
        this.direccion = direccion;
        this.reservas = reservas;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getReservas() {
        return reservas;
    }
}
