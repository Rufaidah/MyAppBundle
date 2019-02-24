package com.fai.myappbundle

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import java.security.AccessControlContext

const val PARENT_PACKAGE = "com.fai"
const val PACKAGE_PROFILE = "$PARENT_PACKAGE.profile"
const val PACKAGE_LOGIN = "$PARENT_PACKAGE.login"
const val BUNDLE_KEY = "bundle_key"

fun openLoginActivity(context: Context, text: String){
    try {
        val intent = Intent(context, Class.forName("$PACKAGE_LOGIN.LoginActivity"))
        intent.putExtra(BUNDLE_KEY, text)
        context.startActivity(intent)
    }catch (e : Exception){
        Log.d("Navigation", "Activity not found")
    }
}

fun openProfileActivity(context: Context){
    val uri = Uri.parse("bundleapp://page/fai")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}
