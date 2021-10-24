package com.brian_sjtu.bytedance_hw211017

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.SpannableString
import androidx.core.content.ContextCompat

class HWApp : Application() {
    object DataSet {
        class ItemData(var title: String, var detail: SpannableString, var image: Drawable?)
        private val itemDefault = ItemData("", SpannableString(""), null)
        private var itemList = Array(1) { itemDefault }

        fun setup(mContext: Context) {
            itemList = Array(100) { ItemData(
                "Dog Title $it", SpannableString("Dog Detail $it"),
                ContextCompat.getDrawable(mContext, R.mipmap.ic_launcher_round)
            ) }
        }
        fun getSize() = itemList.size
        fun getTitle(id: Int) = itemList.elementAtOrElse(id) { itemDefault }.title
        fun getDetail(id: Int) = itemList.elementAtOrElse(id) { itemDefault }.detail
        fun getImage(id: Int) = itemList.elementAtOrElse(id) { itemDefault }.image
    }
}
