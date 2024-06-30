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
import com.haa.diagnosabullying.ui.history.HistoryDiagnosisScreen
import com.haa.diagnosabullying.ui.history.HistoryDiagnosisViewModel
import com.haa.diagnosabullying.ui.screen.DashboardScreen
import com.haa.diagnosabullying.ui.screen.LoginScreen
import com.haa.diagnosabullying.ui.screen.question.QuestionScreen
import com.haa.diagnosabullying.ui.screen.question.QuestionViewModel
import com.haa.diagnosabullying.ui.screen.result.ResultScreen
import com.haa.diagnosabullying.ui.screen.result.ResultViewModel
import com.haa.diagnosabullying.ui.theme.DiagnosaBullyingTheme
import dagger.hilt.android.AndroidEntryPoint

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
                    startDestination = "LOGIN_SCREEN",
                ) {
                    composable(
                        route = "DASHBOARD_SCREEN"
                    ) {
                        DashboardScreen(navHostController = navHostController)
                    }
                    composable(
                        route = "LOGIN_SCREEN"
                    ) {
                        LoginScreen(navHostController = navHostController)
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
                        route = "RESULT_SCREEN/{diagnosisId}",
                        arguments = listOf(
                            navArgument("diagnosisId") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val argument = (it.arguments?.getString("diagnosisId") ?: "0").toInt()
                        val resultViewModel = hiltViewModel<ResultViewModel>()
                        resultViewModel.getDiagnosisById(argument)
                        ResultScreen(
                            navHostController = navHostController,
                            resultViewModel = resultViewModel,
                        )
                    }
                    composable(
                        route = "HISTORY_DIAGNOSIS_SCREEN"
                    ) {
                        val historyDiagnosisViewModel = hiltViewModel<HistoryDiagnosisViewModel>()
                        HistoryDiagnosisScreen(
                            navHostController = navHostController,
                            historyDiagnosisViewModel = historyDiagnosisViewModel
                        )
                    }
                }
            }
        }
    }
}
