package com.example.kotlinhomeworck

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }



        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val buttonClik = findViewById<Button>(R.id.buttonClik)

        val toast3 = Toast.makeText(applicationContext,
                "ЕЕЕЕЕЕДААА", Toast.LENGTH_LONG)
        toast3.setGravity(Gravity.CENTER, 0, 0)
        val toastContainer = toast3.getView() as LinearLayout
        val catImageView = ImageView(applicationContext)
        catImageView.setImageResource(R.drawable.cat)
        toastContainer.addView(catImageView, 0)

        buttonClik.setOnClickListener {
            viewModel.beeRate().observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                toast3.show()
            })
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}


