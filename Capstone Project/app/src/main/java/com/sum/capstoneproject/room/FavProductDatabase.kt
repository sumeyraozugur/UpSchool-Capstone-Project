package com.sum.capstoneproject.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sum.capstoneproject.model.FavoriteRoomModel

@Database(entities = [FavoriteRoomModel::class], version = 1)
abstract class FavProductDatabase : RoomDatabase() {

    abstract fun favProductDAOInterface(): FavProductDao

    companion object {

        private var instance: FavProductDatabase? = null

        fun favProductDatabase(context: Context): FavProductDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    FavProductDatabase::class.java,
                    "favdatabase.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}