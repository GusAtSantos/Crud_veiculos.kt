package com.example.crudpets.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Pet")

class PetModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id_pet")
    var id_pet:Int = 0

    @ColumnInfo(name = "nome_pet")
    var nome_pet: String = ""

    @ColumnInfo(name = "idade")
    var idade_pet: Int = 0

    @ColumnInfo(name = "cor")
    var cor_pet: String = ""

    @ColumnInfo(name = "tipo")
    var tipo_pet: String = ""

    @ColumnInfo(name = "peso")
    var peso_pet: String = ""


}