package com.example.waterresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Static list to store water resource details
    companion object {
        val waterResourcesList = mutableListOf<Triple<String, String, String>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {

            val nameEditText = findViewById<EditText>(R.id.editTextName)
            val locationEditText = findViewById<EditText>(R.id.editTextLocation)
            val typeEditText = findViewById<EditText>(R.id.editTextType)

            val name = nameEditText.text.toString()
            val location = locationEditText.text.toString()
            val type = typeEditText.text.toString()

            if (name.isNotEmpty() && location.isNotEmpty() && type.isNotEmpty()) {
                // Add record to the static list
                waterResourcesList.add(Triple(name, location, type))

                // Refresh the table
                populateTable(tableLayout)

                // Clear input fields
                nameEditText.text.clear()
                locationEditText.text.clear()
                typeEditText.text.clear()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun populateTable(tableLayout: TableLayout) {
        // Clear existing rows
        tableLayout.removeAllViews()

        // Add header row
        val headerRow = TableRow(this)
        val headerParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        headerRow.layoutParams = headerParams

        val headerNames = arrayOf("Water Resource Name", "Location", "Type")
        for (headerName in headerNames) {
            val headerTextView = TextView(this)
            headerTextView.text = headerName
            headerTextView.setBackgroundResource(R.drawable.table_border)
            headerTextView.setPadding(8, 8, 8, 8)
            headerRow.addView(headerTextView)
        }
        tableLayout.addView(headerRow)

        // Add data rows
        for (waterResource in waterResourcesList) {
            val row = TableRow(this)
            val params = TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
            )
            row.layoutParams = params

            val nameTextView = TextView(this)
            nameTextView.text = waterResource.first
            nameTextView.setBackgroundResource(R.drawable.table_border)
            nameTextView.setPadding(8, 8, 8, 8)
            row.addView(nameTextView)

            val locationTextView = TextView(this)
            locationTextView.text = waterResource.second
            locationTextView.setBackgroundResource(R.drawable.table_border)
            locationTextView.setPadding(8, 8, 8, 8)
            row.addView(locationTextView)

            val typeTextView = TextView(this)
            typeTextView.text = waterResource.third
            typeTextView.setBackgroundResource(R.drawable.table_border)
            typeTextView.setPadding(8, 8, 8, 8)
            row.addView(typeTextView)

            tableLayout.addView(row)
        }
    }

    override fun onResume() {
        super.onResume()
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        populateTable(tableLayout)
    }
}
