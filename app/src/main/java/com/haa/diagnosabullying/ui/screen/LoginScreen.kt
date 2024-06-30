package com.haa.diagnosabullying.ui.screen

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.haa.diagnosabullying.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navHostController: NavHostController,
) {
    val contex = LocalContext.current
    val activity = (LocalContext.current as? Activity)

    BackHandler {
        activity?.finish()
    }


    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Nav Bar
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
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "LOGIN",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }
        // Text
        Text(
            text = "Selamat Datang Di Aplikasi Sistem Pakar Diagnosa Bullying. Silahkan Isi Data Terlebih Dahulu",
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .height(70.dp)
                .padding(start = 12.dp)
                .clickable {
                    Toast
                        .makeText(contex, "clict", Toast.LENGTH_LONG)
                        .show()
                }
        )
        Spacer(
            modifier = Modifier.height(5.dp)
        )

        // TextField untuk nama
        val nameState1 = remember { mutableStateOf("") }
        val nameState2 = remember { mutableStateOf("") }

        TextField(
            value = nameState1.value,
            onValueChange = { newName ->
                nameState1.value = newName
            },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = nameState2.value,
            onValueChange = { newName ->
                nameState2.value = newName
            },
            label = { Text("Umur") },
            modifier = Modifier.fillMaxWidth()
        )
        // Button Submit
        Button(
            onClick = {
                when {
                    nameState1.value.isBlank() -> {
                        Toast
                            .makeText(
                                contex,
                                "Silahkan Isi Nama Terlebih Dahulu",
                                Toast.LENGTH_LONG
                            )
                            .show()
                    }

                    nameState2.value.isBlank() -> {
                        Toast
                            .makeText(contex, "Silahkan Isi Umur Anda", Toast.LENGTH_LONG)
                            .show()
                    }

                    else -> {
                        // Navigate to Dashboard screen
                        navHostController.navigate("DASHBOARD_SCREEN")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                "Submit",
                fontSize = 18.sp

            )
        }
        //footer
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF46C77A),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                )
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "IG",
                fontSize = 20.sp,
                color = Color.White,
            )
            Text(
                text = "FB",
                fontSize = 20.sp,
                color = Color.White,
            )
            Text(
                text = "YOUTUBE",
                fontSize = 20.sp,
                color = Color.White,
            )
        }
    }
}






