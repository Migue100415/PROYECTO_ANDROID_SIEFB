package com.siefb.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.siefb.app.ui.navigation.AppNavigation
import com.siefb.app.ui.theme.SIEFBTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            SIEFBTheme {


                AppNavigation()
            }
        }
    }
}