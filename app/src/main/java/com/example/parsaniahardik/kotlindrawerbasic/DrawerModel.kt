package com.example.parsaniahardik.kotlindrawerbasic

import android.R.attr.name

/**
 * Created by Parsania Hardik on 16-Feb-18.
 */
class DrawerModel {

    var name: String? = null
    var image: Int = 0

    fun getImages(): Int {
        return image
    }

    fun setImages(image: Int) {
        this.image = image
    }

    fun getNames(): String? {
        return name
    }

    fun setNames(name: String) {
        this.name = name
    }

}