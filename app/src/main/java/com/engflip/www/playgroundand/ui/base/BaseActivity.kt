package com.engflip.www.playgroundand.ui.base

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {
    protected val disposables: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}