package com.haa.diagnosabullying.ui.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.haa.diagnosabullying.ui.component.DiagnosisItem
import com.haa.diagnosabullying.ui.theme.Poppins
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryDiagnosisScreen(
    navHostController: NavHostController,
    historyDiagnosisViewModel: HistoryDiagnosisViewModel,
) {
    val diagnosisList by historyDiagnosisViewModel.diagnosisListState.collectAsState()

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
                    text = "Riwayat Diagnosa Anda",
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
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding() + 12.dp,
                bottom = paddingValues.calculateBottomPadding() + 12.dp
            )
        ) {
            items(diagnosisList.sortedByDescending { it.createdAt }) { diagnosis ->
                DiagnosisItem(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    stressLevel = diagnosis.stressLevel,
                    diagnosisDateTime = diagnosis.createdAt.toFormattedDateString()
                ) {
                    val encodedDiagnosisId = URLEncoder.encode(diagnosis.id.toString(), "UTF-8")
                    navHostController.navigate("RESULT_SCREEN/$encodedDiagnosisId") {
                        launchSingleTop = true
                    }
                }
            }
        }
    }
}