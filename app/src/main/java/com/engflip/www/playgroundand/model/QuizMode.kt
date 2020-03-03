package com.engflip.www.playgroundand.model

import android.os.Parcel
import android.os.Parcelable

data class QuizMode(
    var selectWord: Boolean =false,
    var selectMeaning: Boolean = false,
    var spelling: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (selectWord) 1 else 0)
        parcel.writeByte(if (selectMeaning) 1 else 0)
        parcel.writeByte(if (spelling) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuizMode> {
        override fun createFromParcel(parcel: Parcel): QuizMode {
            return QuizMode(parcel)
        }

        override fun newArray(size: Int): Array<QuizMode?> {
            return arrayOfNulls(size)
        }
    }
}