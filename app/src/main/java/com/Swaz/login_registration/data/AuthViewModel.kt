package com.Swaz.login_registration.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.Swaz.login_registration.model.User
import com.Swaz.login_registration.nav.Route_hm
import com.Swaz.login_registration.nav.Route_lgn
import com.Swaz.login_registration.nav.Route_reg
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(
    var navController: NavHostController,
    var context : Context,

)
{
    var Auth: FirebaseAuth
    init {
        Auth = FirebaseAuth.getInstance()
    }

    fun sign(
        email: String,
        password: String
    )
    {
        if (
            email.isEmpty()
            && password.isEmpty()
        )
        {
            Toast.makeText(
                context,
                "Please fill in all the fields",
                Toast.LENGTH_LONG
            )
                .show()
        }
        else
        {
            Auth.createUserWithEmailAndPassword(email , password)
                .addOnCompleteListener{
                if (
                    it.isSuccessful
                )
                {
                    val userdata = User(
                        email,
                        password,
                        Auth.currentUser!!.uid
                    )
                    val ref = FirebaseDatabase
                        .getInstance()
                        .getReference()
                        .child("Users/" + Auth.currentUser!!.uid)
                    ref.setValue(userdata)
                        .addOnCompleteListener{
                            if (
                                it.isSuccessful
                            )
                            {
                                Toast.makeText(
                                    context,
                                    "Succesfully created an account",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                                navController.navigate(Route_lgn)
                            }
                            else{
                                Toast.makeText(
                                    context,
                                    "Sign Up failed",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                                navController.navigate(Route_reg)
                            }
                        }
                }
                else
                {
                    navController.navigate(Route_reg)
                }
            }
        }
    }
    fun lgn(
        email: String,
        password: String
    )
    {
        Auth.signInWithEmailAndPassword(email , password)
            .addOnCompleteListener {
                if (
                    it.isSuccessful
                )
                {
                    Toast.makeText(
                        context,
                        "Succesfully logged in your account",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    navController.navigate(Route_hm)
                }
                else
                {
                    Toast.makeText(
                        context,
                        "Sign in failed",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    navController.navigate(Route_lgn)
                }
            }
    }
    fun lgout()
    {
        Auth.signOut()
        navController.navigate(Route_lgn)
    }
    fun isloggedin(): Boolean
    {
        return Auth.currentUser != null
    }
}
