package com.renjum.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.renjum.swoosh.Model.Player
import com.renjum.swoosh.R
import com.renjum.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {


    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }


    fun onMensClicked(view: View) {

        if (!mensLegueBtn.isChecked) {
            mensLegueBtn.isChecked = false
            player.league = ""
        } else {
            mensLegueBtn.isChecked = true
            player.league = "mens"
        }
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
    }


    fun onWomensClicked(view: View) {

        if (!womensLeagueBtn.isChecked) {
            womensLeagueBtn.isChecked = false
            player.league = ""
        } else {
            womensLeagueBtn.isChecked = true
            player.league = "womens"
        }
        coedLeagueBtn.isChecked = false
        mensLegueBtn.isChecked = false
    }


    fun oncoedClicked(view: View) {

        if (!coedLeagueBtn.isChecked) {
            coedLeagueBtn.isChecked = false
            player.league = ""
        } else {
            coedLeagueBtn.isChecked = true
            player.league = "co-ed"
        }

        mensLegueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }
}