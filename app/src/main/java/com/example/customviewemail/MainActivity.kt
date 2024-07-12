package com.example.customviewemail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    val emailList = mutableListOf<Email>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView = findViewById<NavigationView>(R.id.navView)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val toolbar =findViewById<AppBarLayout>(R.id.appbar).findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener{
            drawerLayout.openDrawer(navView)
        }

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New Email","Subtitle","HelloHello There its nice to see you hereHello There its nice to see you here There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you hereHello There its nice to see you hereHello There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNewEmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","HelloHello There its nice to see you hereHello There its nice to see you here There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you hereHello There its nice to see you hereHello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNewEmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","HelloHello There its nice to see you hereHello There its nice to see you here There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you hereHello There its nice to see you hereHello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNewEmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New Email","Subtitle","HelloHello There its nice to see you hereHello There its nice to see you here There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you hereHello There its nice to see you hereHello There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNewEmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))

        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","HelloHello There its nice to see you hereHello There its nice to see you here There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you hereHello There its nice to see you hereHello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNewEmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","HelloHello There its nice to see you hereHello There its nice to see you here There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you hereHello There its nice to see you hereHello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New EmailNew EmailNew EmailNew EmailNew EmailNew EmailNewEmailNew EmailNew EmailNew EmailNew EmailNew EmailNew EmailNew Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val emailAdapter = EmailAdapter(emailList)
        recyclerView.adapter =emailAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

    }

}