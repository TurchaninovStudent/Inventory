package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM items WHERE id = :id")
    fun GetItemById(id: Int): Flow<Item>

    @Query("SELECT * FROM items ORDER BY name ASC")
    fun GetAllItems(): Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun Insert(item: Item)

    @Update
    suspend fun Update(item: Item)

    @Delete
    suspend fun Delete(item: Item)
}