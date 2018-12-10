package eda;


import java.util.ArrayList;
import java.util.List;

public class Palabra {

    private String palabra;

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palabra palabra1 = (Palabra) o;
        return this.palabra.equalsIgnoreCase(palabra1.palabra);
    }

    @Override
    public String toString() {
        return this.palabra;
    }


}
