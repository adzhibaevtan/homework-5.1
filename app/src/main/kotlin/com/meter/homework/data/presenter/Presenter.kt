package com.meter.homework.data.presenter

import com.meter.homework.data.model.CounterModel
import com.meter.homework.data.view.CounterView

class Presenter {
    private val model = CounterModel()
    lateinit var view: CounterView

    fun increment() {
        model.increment()
        view.changeCount(model.count)
        showChanges()
    }

    fun decrement() {
        model.deccrement()
        view.changeCount(model.count)
        showChanges()
    }

    fun attachView(view: CounterView) {
        this.view = view
    }

    private fun showChanges() {
        if (model.count == 10) {
            view.showToast()
        } else if  (model.count == 15) {
            view.changeColor()
        } else if ( model.count < 15) {
            view.returnColor()
        }
    }

}