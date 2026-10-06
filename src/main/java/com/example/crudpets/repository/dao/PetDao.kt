package com.example.crudpets.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crudpets.model.PetModel


    @Dao
    interface PetDao {
        @Insert
        fun insertPet(pet: PetModel) : Long

        @Update
        fun updatePet(pet: PetModel) : Int

        @Delete
        fun deletePet(pet: PetModel) : Int

        @Query("SELECT * FROM Pet Where id_pet = :id")
        fun get(id: Int) : PetModel

        @Query("SELECT * FROM Pet")
        fun getAll(): List <PetModel>

    }

