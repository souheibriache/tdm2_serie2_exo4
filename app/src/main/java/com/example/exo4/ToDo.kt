package com.example.exo4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ToDo (val userId :Int ,val id : Int , val title :String ,val body : String ) :
    Parcelable {

}