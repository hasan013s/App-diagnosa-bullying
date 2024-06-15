package com.haa.diagnosabullying.ui.screen.result

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.haa.diagnosabullying.ui.theme.Poppins

@Composable
fun ResultScreen(
    navHostController: NavHostController,
    resultViewModel: ResultViewModel,
    diagnosisList: List<String>,
) {
    val contex = LocalContext.current

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Nav Bar
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF46C77A), shape = RoundedCornerShape(
                        bottomStart = 20.dp, bottomEnd = 20.dp
                    )
                )
                .fillMaxWidth()
                .height(62.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "RESULT SCREEN",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
        // Text
        Text(text = "Hasil Diagnosa Pada anak Yang terkena korban bulliying Adalah :",
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .height(59.dp)
                .padding(start = 12.dp)
                .clickable {
                    Toast
                        .makeText(contex, "clict", Toast.LENGTH_LONG)
                        .show()
                })
        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .height(44.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF46C77A), contentColor = Color.White
            ),
            shape = RoundedCornerShape(size = 9.dp),
        ) {
            Text(
                text = resultViewModel.getDiagnosis(diagnosisList),
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}