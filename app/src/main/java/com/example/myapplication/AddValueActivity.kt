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

            var nickname = findViewById<View>(R.id.editTextValueName) as EditText


            try {
                customerModel = CustomerModel(-1, nickname.text.toString())
                Toast.makeText(this@AddValueActivity, customerModel.toString(), Toast.LENGTH_SHORT).show()
            }
            catch (e: Exception) {
                Toast.makeText(this@AddValueActivity, "Error creating customer", Toast.LENGTH_SHORT).show()
                customerModel = CustomerModel(-1, "error")
            }

            val dataBaseHelper = DataBaseHelper(this@AddValueActivity)

            var success = dataBaseHelper.addOne(customerModel)

            Toast.makeText(this@AddValueActivity, "Success= $success", Toast.LENGTH_SHORT).show()
        }

    }
}
