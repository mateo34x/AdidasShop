package com.example.adidasshop



data class GroceryItem(
    var id: String,
    var name: String,
    var description: String,
    var quantity: Int,
    var category: String,
    var nombre: String,
    var mimeType: String,
    var fotoBase64: String
) {
    override fun toString(): String {
        return "GroceryItem(id='$id', " +"\n"+
                "name='$name', " +"\n"+
                "description='$description', " +"\n"+
                "quantity=$quantity, " +"\n"+
                "category='$category', " +"\n"+
                "nombre='$nombre', " +"\n"+
                "mimeType='$mimeType', " +"\n"+
                "fotoBase64='$fotoBase64')"+"\n"
    }
}

