package design.demo.navigation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initNav()
    }

    private fun initNav() {
        navigationView.setNavigationItemSelectedListener { menuItem ->

            menuItem.isChecked = true

            drawerLayout.closeDrawers()

            when(menuItem.itemId) {
                R.id.action_dashboard -> { launchSecondActivity() }
                R.id.action_calendar -> { launchSecondActivity() }
                R.id.action_preferences -> { launchSecondActivity() }
            }

            true
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_nav_toggle)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    private fun launchSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left)
    }

}
