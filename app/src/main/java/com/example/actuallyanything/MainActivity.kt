package com.example.actuallyanything

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.TakePicture -> Toast.makeText(this, "Taking Picture", Toast.LENGTH_SHORT).show()
            R.id.Delete -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmation")
                    .setMessage("Are you sure you would like to delete this picture? This action cannot be undone.")
                    .setPositiveButton("Yes"){_,_ -> Toast.makeText(this, "Deleting Picture", Toast.LENGTH_SHORT).show()}
                    .setNegativeButton("Never Mind"){dialog,_ -> dialog.cancel()}
                    .setCancelable(false)
                    .create()
                    .show()
            }
            R.id.Help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))

            else -> return false
        }
        return true
    }
}