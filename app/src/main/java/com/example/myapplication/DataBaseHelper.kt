package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.text.Editable

class DataBaseHelper(
    context: Context?
) : SQLiteOpenHelper(context, "customer.db", null, 1) {

    var CUSTOMER_TABLE = "CUSTOMER_TABLE"
    var COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME"
    var COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE"
    var COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER"
    var COLUMN_ID = "COLUMN_ID"

// the first time a databse is accessed.
    override fun onCreate(db: SQLiteDatabase?) {

    val createTableStatement =
        "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + "TEXT) "

        db?.execSQL(createTableStatement)
}

// upgrades database whenever its structure changes
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addOne(customerModel: CustomerModel): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_CUSTOMER_NAME, customerModel.name)

        val insert = db.insert(CUSTOMER_TABLE, null, cv)

        return insert != -1L
    }

}

private fun ContentValues.put(columnCustomerName: String, name: Editable?) {
}
