package com.haa.diagnosabullying.ui.screen

import androidx.compose.foundation.background
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.haa.diagnosabullying.ui.theme.Poppins

@Composable
fun QuestionN(
    navHostController: NavHostController
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
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
                text = "QUESTION SCREEN",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }

        val checkedState1 = remember { mutableStateOf(false) }
        val checkedState2 = remember { mutableStateOf(false) }
        val checkedState3 = remember { mutableStateOf(false) }
        val checkedState4 = remember { mutableStateOf(false) }
        val checkedState5 = remember { mutableStateOf(false) }
        val checkedState6 = remember { mutableStateOf(false) }
        val checkedState7 = remember { mutableStateOf(false) }
        val checkedState8 = remember { mutableStateOf(false) }
        val checkedState9 = remember { mutableStateOf(false) }
        val checkedState10 = remember { mutableStateOf(false) }


        val fontSize = 15.sp
        val rowHeight = 45.dp

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState1.value,
                onCheckedChange = { checkedState1.value = it }
            )
            Text(
                text = "Q21. Insomnia",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState2.value,
                onCheckedChange = { checkedState2.value = it }
            )
            Text(
                text = "Q22. Tidak peduli keadaan sekitar",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState3.value,
                onCheckedChange = { checkedState3.value = it }
            )
            Text(
                text = "Q23. Pusing",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState4.value,
                onCheckedChange = { checkedState4.value = it }
            )
            Text(
                text = "Q24. Hilang kepercayaan kepada orang lain",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState5.value,
                onCheckedChange = { checkedState5.value = it }
            )
            Text(
                text = "Q25. Tekanan Darah Tinggi",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState6.value,
                onCheckedChange = { checkedState6.value = it }
            )
            Text(
                text = "Q26. Jantung berdebar-debar",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState7.value,
                onCheckedChange = { checkedState7.value = it }
            )
            Text(
                text = "Q27. Nyeri leher dan bahu",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState8.value,
                onCheckedChange = { checkedState8.value = it }
            )
            Text(
                text = "Q28. Merasa tidak aman",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState9.value,
                onCheckedChange = { checkedState9.value = it }
            )
            Text(
                text = "Q29. Mudah menyerang orang",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = checkedState10.value,
                onCheckedChange = { checkedState10.value = it }
            )
            Text(
                text = "Q30. Pikiran kacau",
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize,
                color = Color.Black,
                modifier = Modifier
                    .height(rowHeight)
                    .padding(start = 12.dp)
            )
        }

        // footer
        Spacer(modifier = Modifier.weight(1f))
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
                    navHostController.navigate("QUESTION") {
                        //supaya tidak dobel klik
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.textButtonColors()
            ) {
                Text(
                    text = "<< Back",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                // Tidak ada yang dimasukkan ke dalam Box ini karena kita hanya ingin memberikan ruang kosong
            }
            Button(
                onClick = {
                    navHostController.navigate("QUESTIONNN") {
                        //supaya tidak dobel klik
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.textButtonColors()
            ) {
                Text(
                    text = "Next >>",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }

    }
}