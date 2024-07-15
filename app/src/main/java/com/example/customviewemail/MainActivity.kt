package com.example.customviewemail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginTop
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    val emailList = mutableListOf<Email>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView = findViewById<NavigationView>(R.id.navView)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val toolbar =findViewById<AppBarLayout>(R.id.appbar).findViewById<Toolbar>(R.id.searchbar)
        toolbar.setNavigationOnClickListener{
            drawerLayout.openDrawer(navView)
        }
        navView.setCheckedItem(R.id.primary)
        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

        val fab = findViewById<ExtendedFloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            Toast.makeText(this,"Compose is Clicked",Toast.LENGTH_SHORT).show()
        }
//        fab.shrink()

        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
        emailList.add(Email("New Email","Subtitle","Hello There its nice to see you here","07 July",R.drawable.baseline_person_24))
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
        var emailBadge = bottomNavView.getOrCreateBadge(R.id.bottom_email)
        emailBadge.isVisible = true
        emailBadge.number = emailList.size

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val emailAdapter = EmailAdapter(emailList,emailBadge)
        recyclerView.adapter =emailAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 ) {
                    fab.shrink()
                } else if (dy < 0) {
                    fab.extend()
                }
            }
        })



    }

}