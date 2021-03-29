package com.emmagcarbontest.restapi.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
class User(@PrimaryKey var id: String,
           var title: String? = null,
           var firstName: String? = null,
           var lastName: String? = null,
           var gender: String? = null,
           var email: String? = null,
           var dateOfBirth: String? = null,
           var registerDate: String? = null,
           var picture: String? = null,
           var location: Location? = null){

    /*** Returns true only when no member field is null */
    fun isUserInformationComplete(): Boolean {
        return !(title == null || firstName == null || lastName == null || gender == null ||  email == null
                ||  dateOfBirth == null || registerDate == null || picture == null || location == null)
    }
}

class Location( var street: String? = null,
                var city: String? = null,
                var state: String? = null,
                var country: String? = null,
                var timezone: String? = null){

    override fun toString(): String {
        return "Street: $street, city: $city, state: $state, country: $country, timezone: $timezone."
    }
}