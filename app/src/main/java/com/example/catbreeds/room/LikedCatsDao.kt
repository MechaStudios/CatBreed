package com.example.catbreeds.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.catbreeds.model.Breed
import com.example.catbreeds.model.Likes
import com.example.catbreeds.model.TypeConverter

@Dao
@TypeConverters(TypeConverter::class)
interface LikedCatsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCat(cat: Breed)
    @Query("SELECT * FROM liked_cats_table ORDER BY catId")
    fun readAllData(): LiveData<List<Breed>>
}