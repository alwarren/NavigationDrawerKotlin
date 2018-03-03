package design.demo.navigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(toolbar)

        initNav()
    }

    private fun initNav() {
        navigationView.setNavigationItemSelectedListener { menuItem ->

            menuItem.isChecked = true

            drawerLayout.closeDrawers()

            when(menuItem.itemId) {
                R.id.action_dashboard -> { toast(getString(R.string.nav_dashboard)) }
                R.id.action_calendar -> { toast(getString(R.string.nav_calendar)) }
                R.id.action_preferences -> { toast(getString(R.string.nav_preferences)) }
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
        else {
            super.onBackPressed()
            overridePendingTransition(R.anim.push_out_right, R.anim.pull_in_left)
        }
    }

    private fun toast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

}
