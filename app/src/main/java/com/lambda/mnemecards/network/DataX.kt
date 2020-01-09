package com.lambda.mnemecards.network


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class DataX(
    @Json(name = "back")
    val back: String,
    @Json(name = "front")
    val front: String
):Parcelable