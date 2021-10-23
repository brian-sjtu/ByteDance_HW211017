package com.brian_sjtu.bytedance_hw211017

import android.app.Application
import android.graphics.drawable.Drawable
import android.text.SpannableString

class HWApp : Application() {
    object DataSet {
        class ItemData(var title: String, var detail: SpannableString, var image: Drawable?)
        private val itemDefault = ItemData("", SpannableString(""), null)
        private val itemList = Array(1) { itemDefault }

        fun getSize() = itemList.size
        fun getTitle(id: Int) = itemList.elementAtOrElse(id) { itemDefault }.title
        fun getDetail(id: Int) = itemList.elementAtOrElse(id) { itemDefault }.detail
        fun getImage(id: Int) = itemList.elementAtOrElse(id) { itemDefault }.image
    }
}
