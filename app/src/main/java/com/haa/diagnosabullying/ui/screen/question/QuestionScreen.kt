package com.haa.diagnosabullying.ui.screen.question

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.haa.diagnosabullying.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(
    navHostController: NavHostController,
    questionViewModel: QuestionViewModel,
) {
    val context = LocalContext.current
    val questionList by questionViewModel.questionState.collectAsState()
    val questionSelectedState by questionViewModel.questionSelectedState.collectAsState()

    Scaffold(
        containerColor = White,
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
                    text = "QUESTION SCREEN",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    color = White,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                )
            }
        },
        bottomBar = {
            // footer
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        color = Color(0xFF46C77A),
                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    )
            ) {
                Button(
                    onClick = {
                        navHostController.navigateUp()
                    },
                    colors = ButtonDefaults.textButtonColors()
                ) {
                    Text(
                        text = "<< Back",
                        fontSize = 20.sp,
                        color = White
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    // Tidak ada yang dimasukkan ke dalam Box ini karena kita hanya ingin memberikan ruang kosong
                }
                Button(
                    onClick = {
                        val questionSelectedStateValue =
                            questionViewModel.questionSelectedState.value
                        val getTrueSelectedQuestionSize =
                            questionSelectedStateValue.values.filter { it }
                        if (
                            questionSelectedStateValue.isEmpty() || getTrueSelectedQuestionSize.isEmpty()
                        ) {
                            Toast.makeText(context, "Silahkan pilih gejala", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            val diagnosisIdList = questionSelectedStateValue
                                .keys
                                .toList()

                            val diagnosis = questionViewModel.calculateDiagnosis(diagnosisIdList)
                            diagnosis?.let { diagnosisModel ->
                                Log.e("diagnosisModel", diagnosisModel.toString())
                                questionViewModel.saveDiagnosis(
                                    diagnosisEntity = diagnosisModel.mapToDiagnosisEntity()
                                ) {
                                    navHostController.navigate("RESULT_SCREEN/$it") {
                                        //supaya tidak dobel klik
                                        launchSingleTop = true
                                    }
                                }
                            }
                        }
                    },
                    colors = ButtonDefaults.textButtonColors()
                ) {
                    Text(
                        text = "Lihat Hasil >>",
                        fontSize = 20.sp,
                        color = White
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding() + 12.dp,
                bottom = paddingValues.calculateBottomPadding() + 12.dp
            ),
        ) {

            itemsIndexed(questionList) { index, question ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Checkbox(
                        checked = questionSelectedState[question.id] ?: false,
                        onCheckedChange = {
                            questionViewModel.onQuestionSelectedChange(
                                id = question.id,
                                newValue = it
                            )
                        }
                    )
                    Text(
                        text = "${index + 1}. ${question.question}",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 12.dp)
                    )
                }
            }
        }
    }
}
