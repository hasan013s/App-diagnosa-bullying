package com.haa.diagnosabullying

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haa.diagnosabullying.ui.screen.DashboardScreen
import com.haa.diagnosabullying.ui.screen.Question
import com.haa.diagnosabullying.ui.screen.QuestionN
import com.haa.diagnosabullying.ui.screen.QuestionNn
import com.haa.diagnosabullying.ui.screen.QuestionScreen
import com.haa.diagnosabullying.ui.screen.ResultScreen
import com.haa.diagnosabullying.ui.theme.DiagnosaBullyingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            DiagnosaBullyingTheme {
                NavHost(
                    navController = navHostController,
                    route = "ROOT_SCREEN",
                    startDestination = "DASHBOARD_SCREEN",
                ){
                    composable(
                        route = "DASHBOARD_SCREEN"
                    ){
                        DashboardScreen(navHostController = navHostController)
                    }
                    composable(
                        route = "QUESTION_SCREEN"
                    ){
                        QuestionScreen(navHostController = navHostController)
                    }
                    composable(
                        route = "QUESTION"
                    ){
                        Question(navHostController = navHostController)
                    }
                    composable(
                        route = "QUESTIONN"
                    ){
                        QuestionN(navHostController = navHostController)
                    }
                    composable(
                        route = "QUESTIONNN"
                    ){
                        QuestionNn(navHostController = navHostController)
                    }
                    composable(
                        route = "RESULT_SCREEN"
                    ){
                        ResultScreen(navHostController = navHostController)
                    }
                }
            }
        }
    }
}
