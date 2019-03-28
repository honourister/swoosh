package com.renjum.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.renjum.swoosh.Utilities.EXTRA_LEAGUE
import com.renjum.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {

        if (!mensLegueBtn.isChecked) {
            mensLegueBtn.isChecked = false
            selectedLeague = ""
        } else {
            mensLegueBtn.isChecked = true
            selectedLeague = "mens"
        }
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        Toast.makeText(this, selectedLeague, Toast.LENGTH_SHORT).show()
    }


    fun onWomensClicked(view: View) {

        if (!womensLeagueBtn.isChecked) {
            womensLeagueBtn.isChecked = false
            selectedLeague = ""
        } else {
            womensLeagueBtn.isChecked = true
            selectedLeague = "womens"
        }
        coedLeagueBtn.isChecked = false
        mensLegueBtn.isChecked = false
        Toast.makeText(this, selectedLeague, Toast.LENGTH_SHORT).show()
    }


    fun oncoedClicked(view: View) {

        if (!coedLeagueBtn.isChecked) {
            coedLeagueBtn.isChecked = false
            selectedLeague = ""
        } else {
            coedLeagueBtn.isChecked = true
            selectedLeague = "co-ed"
        }

        mensLegueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
        Toast.makeText(this, selectedLeague, Toast.LENGTH_SHORT).show()
    }

    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }
}