package com.engflip.www.playgroundand.ui.base

import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {
    protected val disposables: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}