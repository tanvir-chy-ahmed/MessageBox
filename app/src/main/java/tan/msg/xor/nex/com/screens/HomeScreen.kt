package tan.msg.xor.nex.com


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import tan.msg.xor.nex.com.screens.SMSCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BankSMSApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5E9FD)) // Light purple background
            .padding(16.dp)
    ) {
        // Top bar


        Spacer(modifier = Modifier.height(120.dp))

        // List of SMS cards


        LazyColumn {
            items(10) { item ->  //person er moton shob item people er moddo store koro then people k show koro lazy column e

                SMSCard(

                    bankName = "DBBL",
                    time = "2:10 PM",
                    message = "Your acct 876... debited Tk 500.00\nAvail bal: Tk 2500.00",
                    backgroundColor = Color(0xFFFFBDBD)
                )

                SMSCard(
                    bankName = "Nagad",
                    time = "1:45 PM",
                    message = "Your OTP is 345678",
                    backgroundColor = Color(0xFF8AF5A5)
                )

                SMSCard(
                    bankName = "City Bank",
                    time = "12:30 PM",
                    message = "Deposit of Tk 1,500.00 received\nin your acct.",
                    backgroundColor = Color(0xFFB3D6FF)
                )

                SMSCard(
                    bankName = "bKash",
                    time = "11:15 AM",
                    message = "Sent Tk 1000 to 01XXXXXXXXX.",
                    backgroundColor = Color(0xFFFFE0B2)
                )
            }
        }


    }

}
