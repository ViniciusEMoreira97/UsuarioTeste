package me.dio.usuariodeteste.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Test(
    @SerializedName("img")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("percentual")
    val percent: Float,
    @SerializedName("pos")
    val position: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("Copas_do_Mundo_Vencidas")
    val cups: String,
    @SerializedName("Copas_do_Mundo_Disputadas")
    val plays: String
): Parcelable
