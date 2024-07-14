package com.onurgunes.caloriehandbookretrofitmvvm.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.UUID

@Entity
data class Besin (
  @ColumnInfo(name = "isim")
    @SerializedName("isim")
  val besinIsim : String?,
  @ColumnInfo(name = "kalori")
    @SerializedName("kalori")
  val besinKalori : String?,
  @ColumnInfo(name = "karbonhidrat")
    @SerializedName("karbonhidrat")
    val besinKarbonhidrat : String?,
  @ColumnInfo(name = "protein")
    @SerializedName("protein")
    val besinProtein : String?,
  @ColumnInfo(name = "yag")
    @SerializedName("yag")
    val besinYag : String?,
  @ColumnInfo(name = "gorsel")
    @SerializedName("gorsel")
    val besinGorsel : String?,

  @PrimaryKey(autoGenerate = true)
  val uuid: Int = 0

)


