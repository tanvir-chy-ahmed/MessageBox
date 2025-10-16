package tan.msg.xor.nex.com.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(modifier: Modifier = Modifier) {
    var isChekedBankingonly by remember { mutableStateOf(false) }
    var context = LocalContext.current
//    val thumbColor by animateColorAsState(if (isChekedBankingonly) Color(0xFF5868CC) else Color.Gray)
//    val trackColor by animateColorAsState(
//        if (isChekedBankingonly) Color(0xFFced2ec) else Color(
//            0xFFf2f2f2
//        )
//    )
//    val thumbSize by animateDpAsState(if (isChekedBankingonly) 28.dp else 24.dp)


    Scaffold(
        containerColor = Color(0xFFfafafa),
        topBar = {

            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFfafafa)),
                title = {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { /* TODO: handle back action */ },
                            modifier = Modifier.size(56.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                modifier = modifier.size(30.dp),
                                tint = Color(0xFF000000)
                            )
                        }


                        Text(
                            text = "Filter Settings",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )


                        // Placeholder to balance the Row (so text truly stays centered)
                        Spacer(modifier = Modifier.size(50.dp))
                    }


                },

                )
        }) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color(0xFFfafafa))
                .padding(20.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(paddingValues)
                    .height(310.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 7.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp)
            )
            {

                Column(
                    modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
                {


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)

                    )
                    {
                        Text(
                            text = "Message Filtering", style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                fontSize = 17.sp
                            )
                        )


                    }

                    Instructions(
                        modifier = Modifier,
                        title = "Show Banking Messages Only",
                        subtitle = "Display only financial and banking SMS messages",
                        isCheked = isChekedBankingonly,
                        onCheckedChange = { isChekedBankingonly = it }
                    )
                    Spacer(Modifier.height(12.dp))

                    Divider(thickness = 0.2.dp)


                    Spacer(Modifier.height(12.dp))
                    Instructions(
                        modifier = Modifier,
                        title = "Hide Promotional Messages",
                        subtitle = "Filter out marketing and promotional SMS content",
                        isCheked = isChekedBankingonly,
                        onCheckedChange = { isChekedBankingonly = it }
                    )
                    Spacer(Modifier.height(12.dp))

                    Divider(thickness = 1.dp)

                    Spacer(Modifier.height(10.dp))

                    Instructions(
                        modifier = Modifier,
                        title = "Block Operator Messages",
                        subtitle = "Hide messages from mobile network operators",
                        isCheked = isChekedBankingonly,
                        onCheckedChange = { isChekedBankingonly = it }
                    )


                }

            }



            Card(
                modifier = Modifier
                    .height(310.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 7.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp)
            )
            {

                Column(
                    modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
                {


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)

                    )
                    {
                        Text(
                            text = "Display Preferences", style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                fontSize = 17.sp
                            )
                        )


                    }

                    Text(
                        text = "Theme", style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    )
                    Spacer(Modifier.height(10.dp))

                    Row(
                        modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    {


                        // Start of Elevated Button


                        // End of Elevated Button

                       ThreeOptionSelector {  }
                    }


                }

            }
        }

    }
}


@Composable
fun Instructions(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    isCheked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {


    val thumbColor by animateColorAsState(if (isCheked) Color(0xFF5868CC) else Color.Gray)
    val trackColor by animateColorAsState(
        if (isCheked) Color(0xFFced2ec) else Color(
            0xFFf2f2f2
        )
    )

    //Row
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier.width(250.dp)
        ) {
            Text(
                text = title, style = TextStyle(
                    color = Color.Black, fontSize = 18.sp
                )
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = subtitle, style = TextStyle(
                    color = Color.Gray, fontSize = 14.sp
                )
            )
        }

        Spacer(modifier = Modifier.width(10.dp))
        Switch(
            checked = isCheked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = thumbColor,
                uncheckedThumbColor = thumbColor,
                checkedTrackColor = trackColor,
                uncheckedTrackColor = trackColor
            ),
            modifier = Modifier
                .width(70.dp)
                .height(40.dp)
        )

    }


}

@Composable
fun ThreeOptionSelector(
    options: List<String> = listOf("Option 1", "Option 2", "Option 3"),
    onOptionSelected: (String) -> Unit
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        options.forEach { option ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = if (selectedOption == option) Color(0xFF6e7bc7) else Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = if (selectedOption == option) Color(0xFF6271C2).copy(alpha = 0.5f) else Color.White,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable {
                        selectedOption = option
                        onOptionSelected(option)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = option,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (selectedOption == option) Color(0xFF4E63DE) else Color.Gray
                )
            }
        }
    }
}

