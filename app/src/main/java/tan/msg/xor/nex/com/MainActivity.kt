package tan.msg.xor.nex.com

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tan.msg.xor.nex.com.screens.FilterScreen
import tan.msg.xor.nex.com.ui.theme.MessageBoxTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()


//
            MessageBoxTheme {

                NavHost(navController = navController, startDestination = "filters") {

                    composable(route = "home") { HomeScreen(navController = navController) }
                    composable(route = "filters") { FilterScreen() }

                }


            }
        }
    }
}

