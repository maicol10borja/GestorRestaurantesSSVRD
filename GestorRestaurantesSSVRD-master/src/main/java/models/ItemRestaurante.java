package models;

import java.util.Objects;

public class ItemRestaurante {
    private int cantidad;
    private Productos productos;

    public ItemRestaurante(int cantidad, Productos productos) {
        this.cantidad = cantidad;
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRestaurante itemCarro = (ItemRestaurante) o;
        return Objects.equals(productos.getIdProducto(), itemCarro.productos.getIdProducto())
                && Objects.equals(productos.getNombre(), itemCarro.productos.getNombre());
    }


    public double getSbtotal() {
        return cantidad * productos.getPrecio();
    }
}
