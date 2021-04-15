package com.infosy.assingment.mycountry.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Country {
    @SerializedName("title")
    @Expose
    var title: String? = null

    constructor(){

    }

    constructor(title: String?, rows: List<CountryDetails>?) {
        this.title = title
        this.rows = rows
    }

    @SerializedName("rows")
    @Expose
    var rows: List<CountryDetails>? = null
}