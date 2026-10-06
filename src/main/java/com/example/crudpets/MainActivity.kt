package com.example.crudpets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.crudpets.model.PetModel
import com.example.crudpets.repository.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val petDatabase = AppDatabase.getDataBase(this).PetDao()

        val retornoInsert = petDatabase.insertPet(PetModel().apply{
            this.nome_pet = "Saguira"
            this.idade_pet = 70
            this.cor_pet = "prata"
            this.tipo_pet = "Fantasma"
            this.peso_pet = "84kg"
        })

        val retornoSelectMultiplo = petDatabase.getAll()

        for (item in retornoSelectMultiplo){
            Log.d(
                "Retorno",
                "id_pet: ${item.id_pet}, nome: ${item.nome_pet}," +
                        "idade: ${item.idade_pet}, cor ${item.cor_pet}, tipo ${item.tipo_pet}, peso ${item.peso_pet}"
            )
        }

    }
}