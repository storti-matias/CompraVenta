package com.example.compraventa.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String id;
    private String name;
    private String colorAsociado;

    public Categoria(){
    }

    public Categoria(String cod,String nom){
        this.id = cod;
        this.name = nom;
        this.colorAsociado = "#AD1457";
    }

    public Categoria(String cod,String nom,String col){
        this.id = cod;
        this.name = nom;
        this.colorAsociado = col;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorAsociado() {
        return colorAsociado;
    }

    public static List<Categoria> categorias(){
        ArrayList<Categoria> lista = new ArrayList<Categoria>();

        lista.add(new Categoria("MLA5725","Accesorios para Vehículos","#E57373"));
        lista.add(new Categoria("MLA1512","Agro","#F06292"));
        lista.add(new Categoria("MLA1403","Alimentos y Bebida","#FF9E80"));
        lista.add(new Categoria("MLA1071","Animales y Mascotas","#6D4C41"));
        lista.add(new Categoria("MLA1367","Antigüedades y Colecciones","#FF8A65"));
        lista.add(new Categoria("MLA1368","Arte, Librería y Mercería","#757575"));
        lista.add(new Categoria("MLA1743","Autos, Motos y Otros","#FFC400"));
        lista.add(new Categoria("MLA1384","Bebés","#76FF03"));
        lista.add(new Categoria("MLA1246","Belleza y Cuidado Personal","#C6FF00"));
        lista.add(new Categoria("MLA1039","Cámaras y Accesorios","#00C853"));
        lista.add(new Categoria("MLA1051","Celulares y Teléfonos","#FFEA00"));
        lista.add(new Categoria("MLA1648","Computación","#9E9D24"));
        lista.add(new Categoria("MLA1144","Consolas y Videojuegos","#FFD180"));
        lista.add(new Categoria("MLA1500","Construcción","#80D8FF"));
        lista.add(new Categoria("MLA1276","Deportes y Fitness","#EF6C00"));
        lista.add(new Categoria("MLA5726","Electrodomésticos y Aires Ac.","#FFB74D"));
        lista.add(new Categoria("MLA1000","Electrónica, Audio y Video","#64FFDA"));
        lista.add(new Categoria("MLA2547","Entradas para Eventos","#69F0AE"));
        lista.add(new Categoria("MLA407134","Herramientas","#00BFA5"));
        lista.add(new Categoria("MLA1574","Hogar, Muebles y Jardín","#C5E1A5"));
        lista.add(new Categoria("MLA1499","Industrias y Oficinas","#0288D1"));
        lista.add(new Categoria("MLA1459","Inmuebles","#DCE775"));
        lista.add(new Categoria("MLA1182","Instrumentos Musicales","#00796B"));
        lista.add(new Categoria("MLA3937","Joyas y Relojes","#7E57C2"));
        lista.add(new Categoria("MLA1132","Juegos y Juguetes","#E040FB"));
        lista.add(new Categoria("MLA3025","Libros, Revistas y Comics","#0097A7"));
        lista.add(new Categoria("MLA1168","Música, Películas y Series","#EF5350"));
        lista.add(new Categoria("MLA1430","Ropa y Accesorios","#FF5252"));
        lista.add(new Categoria("MLA409431","Salud y Equipamiento Médico","#00838F"));
        lista.add(new Categoria("MLA1540","Servicios","#448AFF"));
        lista.add(new Categoria("MLA9304","Souvenirs, Cotillón y Fiestas","#BA68C8"));
        lista.add(new Categoria("MLA1953","Otras categorías","#536DFE"));

        return lista;
    }
}
