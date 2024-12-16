package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Restaurante {
    private List<ItemRestaurante> items;
    public Restaurante() {
        this.items=new ArrayList<>();
    }
//Validamos que se pueda agregar una sola linea
    public void addItemRestaurante(ItemRestaurante itemRestaurante) {
        if (items.contains(itemRestaurante)){
            Optional<ItemRestaurante> optionalItemRestaurante=items.stream()
                    .filter(i->i.equals(new ItemRestaurante))
                    .findAny();
            if (optionalItemRestaurante.isPresent()){
                ItemRestaurante i=optionalItemRestaurante.get();
                i.setCantidad(i.getCantidad()+1);
            }
        }else{
            this.items.add(ItemRestaurante);

        }
    }

    public List<ItemRestaurante> getItems() {
        return items;
    }

    public double getTotal(){
        return items.stream().mapToDouble(ItemRestaurante::getSbtotal).sum();
    }
}
