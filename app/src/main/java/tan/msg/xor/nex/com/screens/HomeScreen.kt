package tan.msg.xor.nex.com


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tan.msg.xor.nex.com.screens.SMSCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController : NavController) {


    val scrollbehaivior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val actionList = listOf(
        "Set Filters",
        "Source Code",
        "Changelog",
        "Developer Info",
        "Feedback"
    )

    val iconList = listOf(
        R.drawable.setting,
        R.drawable.code,
        R.drawable.changelog,
        R.drawable.person,
        R.drawable.review
    )



    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Message Box",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                actions = {

                    IconButton(onClick = {
                        isExpanded = true
                    }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Search",
                            tint = Color(0xFF000000)
                        )
                    }

                    DropdownMenu(
                        expanded = isExpanded,
                        onDismissRequest = { isExpanded = false }
                    ) {
                        actionList.forEachIndexed { index, action ->
                            DropdownMenuItem(
                                onClick = {
                                    isExpanded = false
                                    when (index) {
                                        0 -> {
                                            navController.navigate("filters")
                                        }

                                        1 -> {
                                            /* Source Code action */
                                        }

                                        2 -> {
                                            /* Changelog action */
                                        }

                                        3 -> {
                                            /* Developer Info action */
                                        }

                                        4 -> {
                                            /* Feedback action */
                                        }
                                    }
                                },

                                text = { Text(text = action) },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = iconList[index]),
                                        contentDescription = null,
                                        Modifier.size(20.dp),
                                    )
                                }
                            )
                        }
                    }


                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF5E9FD),
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                scrollBehavior = scrollbehaivior
            )

        },
    ) {
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

}
