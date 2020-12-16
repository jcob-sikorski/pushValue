package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_value.*

class AddValueActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_value)

        addValueSubmitButton.setOnClickListener {
            var customerModel: CustomerModel

            val nickname = findViewById<View>(R.id.editTextValueName) as EditText

            try {
                customerModel = CustomerModel(-1L, nickname.text)
                Toast.makeText(this@AddValueActivity, "Error creating customer", Toast.LENGTH_SHORT).show()
            }
            catch (e: Exception) {
                Toast.makeText(this@AddValueActivity, "Error creating customer", Toast.LENGTH_SHORT).show()
                nickname.setText("error")
                customerModel = CustomerModel(-1L, nickname.text)
            }

            val dataBaseHelper = DataBaseHelper(this@AddValueActivity)

            var success = dataBaseHelper.addOne(customerModel)

            Toast.makeText(this@AddValueActivity, "Success= ", Toast.LENGTH_SHORT).show()


//            val database = getSharedPreferences("database", Context.MODE_PRIVATE)
//            database.edit().apply {
//                putString("savedNickname", editTextValueName.text.toString())
//            }.apply()
//            Log.d("savedNickname", editTextValueName.text.toString())

        }

    }
}