package com.engflip.www.playgroundand.ui.store_state

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.engflip.www.playgroundand.R
import com.engflip.www.playgroundand.ui.store_state.fragment.UserInfoFragment
import com.engflip.www.playgroundand.ui.store_state.viewmodel.UserViewModel
import com.engflip.www.playgroundand.databinding.ActivityStoreStateBinding

fun Context.getStoreStateActivityIntent(): Intent = Intent(this, StoreStateActivity::class.java)

class StoreStateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoreStateBinding

    private val userVM: UserViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_store_state
        )
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewPager()
        setupDataObservers()

        userVM.onViewCreated()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun setupViewPager() {
        binding.vpUsers.run {
            adapter = UsersPagerAdapter(
                supportFragmentManager
            )
        }
    }

    private fun setupDataObservers() {
        userVM.users.observe(this, Observer {
            if (it == null) return@Observer

            it.map { user ->
                UserInfoFragment.newInstance(user)
            }.run {
                (binding.vpUsers.adapter as? UsersPagerAdapter)?.setFragments(this)
            }
        })
    }
}