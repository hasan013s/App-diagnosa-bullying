package com.haa.diagnosabullying.ui.screen.result

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.haa.diagnosabullying.helper.toFormattedDateString
import com.haa.diagnosabullying.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    navHostController: NavHostController,
    resultViewModel: ResultViewModel,
) {

    val diagnosisState by resultViewModel.diagnosisState.collectAsState()

    Scaffold(
        containerColor = Color.White,
        topBar = {
            //header
            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFF46C77A),
                        shape = RoundedCornerShape(
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .fillMaxWidth()
                    .height(62.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = "Hasil Diagnosa Anda",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }
        },
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(
                    PaddingValues(
                        top = paddingValues.calculateTopPadding() + 12.dp,
                        bottom = 12.dp,
                        start = 12.dp,
                        end = 12.dp
                    ),
                )
        ) {
            Column {
                Text(
                    text = "Tingkat stres",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                )
                Text(
                    text = diagnosisState?.stressLevel ?: "Terjadi kesalahan",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                )
            }
            Column {
                Text(
                    text = "Dampak yang mungkin terjadi pada anak:",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                )
                val impactList = diagnosisState?.impacts?.split(", ")
                impactList?.forEach { impact ->
                    Text(
                        text = "- $impact",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    )
                }
            }
            Column {
                Text(
                    text = "Solusi atau penanganan:",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                )
                val solutionList = diagnosisState?.solutions?.split(", ")
                solutionList?.forEach { solution ->
                    Text(
                        text = "- $solution",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    )
                }
            }
            Column {
                Text(
                    text = "Waktu diagnosa:",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                )
                diagnosisState?.createdAt?.let {
                    Text(
                        text = it.toFormattedDateString(),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}