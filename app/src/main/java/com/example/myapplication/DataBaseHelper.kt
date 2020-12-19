package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.text.Editable

class DataBaseHelper(
    context: Context?
) : SQLiteOpenHelper(context, "customer.db", null, 1) {

// the first time a database is accessed.
    override fun onCreate(db: SQLiteDatabase?) {

        val createTableStatement =
            "CREATE TABLE CUSTOMER_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT, CUSTOMER_NAME TEXT)"

        db?.execSQL(createTableStatement)
}

// upgrades database whenever its structure changes
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        db?.execSQL("DROP TABLE IF EXISTS CUSTOMER_TABLE");

        // Create tables again
        onCreate(db);
    }

    fun addOne(customerModel: CustomerModel): Boolean {
        val db = this.writableDatabase

        val cv = ContentValues()
        cv.put("CUSTOMER_NAME", customerModel.getName())

        val insert = db.insert("CUSTOMER_TABLE", null, cv)

        return insert != -1L
    }

    fun getEveryone(): MutableList<CustomerModel> {
        val returnList : MutableList<CustomerModel> = arrayListOf()

        val db: SQLiteDatabase = this.readableDatabase

//        get data from the database
        val cursor: Cursor = db.rawQuery("SELECT * FROM CUSTOMER_TABLE", null)

        if (cursor.moveToFirst()) {
            do {
                val customerID: Int = cursor.getInt(0)

                val customerName = cursor.getString(1)


                val customerModel: CustomerModel = CustomerModel(customerID, customerName)

                returnList.add(customerModel)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return returnList

    }

}

private fun ContentValues.put(columnCustomerName: String, name: Editable?) {
}
