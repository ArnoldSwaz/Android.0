package com.Swaz.login_registration.model

class User {
    var email : String = ""
    var password : String = ""
    var userid : String = ""

    constructor(
        email : String,
        password : String,
        userid : String
    )
    {
        this.email = email
        this.password = password
        this.userid = userid
    }
    constructor()
}