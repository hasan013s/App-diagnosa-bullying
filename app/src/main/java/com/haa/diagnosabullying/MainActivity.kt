package com.haa.diagnosabullying

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.haa.diagnosabullying.ui.screen.DashboardScreen
import com.haa.diagnosabullying.ui.screen.question.QuestionScreen
import com.haa.diagnosabullying.ui.screen.question.QuestionViewModel
import com.haa.diagnosabullying.ui.screen.result.ResultScreen
import com.haa.diagnosabullying.ui.screen.result.ResultViewModel
import com.haa.diagnosabullying.ui.theme.DiagnosaBullyingTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder

@AndroidEntryPoint
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
                ) {
                    composable(
                        route = "DASHBOARD_SCREEN"
                    ) {
                        DashboardScreen(navHostController = navHostController)
                    }
                    composable(
                        route = "QUESTION_SCREEN"
                    ) {
                        val questionViewModel = hiltViewModel<QuestionViewModel>()
                        QuestionScreen(
                            navHostController = navHostController,
                            questionViewModel = questionViewModel
                        )
                    }
                    composable(
                        route = "RESULT_SCREEN/{diagnosis}",
                        arguments = listOf(
                            navArgument("diagnosis") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val argument = it.arguments?.getString("diagnosis") ?: ""
                        val decodedDiagnosis = URLDecoder.decode(argument, "UTF-8")
                        val diagnosisList = decodedDiagnosis.split(":")
                        val resultViewModel = hiltViewModel<ResultViewModel>()
                        ResultScreen(
                            navHostController = navHostController,
                            resultViewModel = resultViewModel,
                            diagnosisList = diagnosisList
                        )
                    }
                }
            }
        }
    }
}
