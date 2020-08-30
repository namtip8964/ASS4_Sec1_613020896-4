package com.example.ass4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var subject: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePickerDialog(v: View){
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }



    fun register(view: View) {
        var selectID: Int = radioGroup.checkedRadioButtonId
        var radioButtonChecked: RadioButton = findViewById(selectID)

        text_show.text =
            "Name: ${edit_name.text}\nPassword: ${edit_password.text}\nGender:${radioButtonChecked.text}\nBirthday: ${edit_date.text}"
    }

    fun reset(v: View) {

        edit_name.text.clear()
        edit_password.text.clear()
        edit_email.text.clear()
        radioGroup.clearCheck()
        edit_date.text = "mm / dd / yy"
        text_show.text = "Show Information"
    }
}
