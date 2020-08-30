package com.example.ass4
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*
import android.content.DialogInterface as DialogInterface

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
// Initialize a calendar instance
        var calendar = Calendar.getInstance()
// Get the system current date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(
            activity!!, 2, this, day, month, year
        )
    }
    override fun onDateSet(view: DatePicker, day: Int, month: Int, year: Int) {
// Display the selected date in text view
        var tv : TextView? = activity?.findViewById(R.id.edit_date)
        tv!!.text = formatDate(year,month,day)
    }
    override fun onCancel(dialog: DialogInterface) {
        Toast.makeText(activity,"Please select a date.", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
    // Custom method to format date
    private fun formatDate(year:Int, month:Int, day:Int):String{
        var calendar: Calendar = Calendar.getInstance();
// Create a Date variable/object with user chosen date
        calendar.set(day, month, year)
        val chosenDate = calendar.time
// Format the date picker selected date
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM)
        return df.format(chosenDate)
    }
}