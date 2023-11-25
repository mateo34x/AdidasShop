package com.example.adidasshop



data class GroceryItem(
    var id: String,
    var name: String,
    var description: String,
    var price: String,
    var quantity: Int,
    var category: String,
    var nombre: String,
    var mimeType: String,
    var fotoBase1: String,
    var fotoBase2: String
) {
    override fun toString(): String {
        return "GroceryItem(id='$id', " +"\n"+
                "name='$name', " +"\n"+
                "description='$description', " +"\n"+
                "prices='$price', " +"\n"+
                "quantity=$quantity, " +"\n"+
                "category='$category', " +"\n"+
                "nombre='$nombre', " +"\n"+
                "mimeType='$mimeType', " +"\n"+
                "fotoBase2='$fotoBase1')"+"\n"+
                "fotoBase2='$fotoBase2')"+"\n"
    }
}

