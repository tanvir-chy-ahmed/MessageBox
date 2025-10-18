package tan.msg.xor.nex.com.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import tan.msg.xor.nex.com.R
import kotlin.math.roundToInt

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(modifier: Modifier = Modifier) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    //Buttons Instruction
    var BankOnlyBtn by remember { mutableStateOf(false) }
    var promotionalBtn by remember { mutableStateOf(false) }
    var BlockOperatorBtn by remember { mutableStateOf(false) }


    var GPBtn by remember { mutableStateOf(false) }
    var BLBtn by remember { mutableStateOf(false) }
    var OtherBtn by remember { mutableStateOf(false) }


    var SliderState by remember { mutableStateOf(0f) }
    var context = LocalContext.current


    var scrollableState = rememberScrollState()
    val overscrollEffect = rememberOverscrollEffect()





    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState){data ->
            Snackbar(
                snackbarData = data,
                containerColor = Color(0xFF4caf50),
                contentColor = Color.White
            )
        } },
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
                .verticalScroll(scrollableState)
                .overscroll(overscrollEffect)
        ) {
            Card(
                modifier = Modifier
                    .padding(paddingValues)
                    .height(
                        height = if (!BlockOperatorBtn) {
                            310.dp
                        } else {
                            480.dp
                        }
                    ),
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
                        isCheked = BankOnlyBtn,
                        onCheckedChange = { BankOnlyBtn = it },
                        isReset = false,
                        onInstructionset2 = false
                    )
                    Spacer(Modifier.height(12.dp))

                    Divider(thickness = 0.2.dp)


                    Spacer(Modifier.height(12.dp))
                    Instructions(
                        modifier = Modifier,
                        title = "Hide Promotional Messages",
                        subtitle = "Filter out marketing and promotional SMS content",
                        isCheked = promotionalBtn,
                        onCheckedChange = { promotionalBtn = it },
                        isReset = false,
                        onInstructionset2 = false
                    )
                    Spacer(Modifier.height(12.dp))

                    Divider(thickness = 1.dp)

                    Spacer(Modifier.height(10.dp))

                    if (BlockOperatorBtn) {
                        Instructions(
                            modifier = Modifier,
                            title = "Block Operator Messages",
                            subtitle = "Hide messages from mobile network operators",
                            isCheked = BlockOperatorBtn,
                            onCheckedChange = { BlockOperatorBtn = it },
                            isReset = false,
                            onInstructionset2 = false
                        )


                        Column (modifier.padding(start = 40.dp)) {


                            Spacer(Modifier.height(22.dp))

                            Instructions(
                                modifier = Modifier,
                                title = "Block GP Messages",
                                subtitle = "",
                                isCheked = GPBtn,
                                onCheckedChange = { GPBtn = it },
                                isReset = false,
                                onInstructionset2 = true
                            )

                            Spacer(Modifier.height(10.dp))
                            Divider(
                                thickness = 1.dp,
                                color = Color.LightGray.copy(alpha = 0.6f),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp)
                            )

                            Spacer(Modifier.height(15.dp))
                            Instructions(
                                modifier = Modifier,
                                title = "Block BL Messages",
                                subtitle = "",
                                isCheked = BLBtn,
                                onCheckedChange = { BLBtn = it },
                                isReset = false,
                                onInstructionset2 = true
                            )

                            Spacer(Modifier.height(10.dp))
                            Divider(
                                thickness = 1.dp,
                                color = Color.LightGray.copy(alpha = 0.6f),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp)
                            )

                            Spacer(Modifier.height(15.dp))
                            Instructions(
                                modifier = Modifier,
                                title = "Block Other Messages",
                                subtitle = "",
                                isCheked = OtherBtn,
                                onCheckedChange = { OtherBtn = it },
                                isReset = false,
                                onInstructionset2 = true
                            )
                        }

                    } else {
                        Instructions(
                            modifier = Modifier,
                            title = "Block Operator Messages",
                            subtitle = "Hide messages from mobile network operators",
                            isCheked = BlockOperatorBtn,
                            onCheckedChange = { BlockOperatorBtn = it },
                            isReset = false,
                            onInstructionset2 = false
                        )
                    }


                }

            }


            Spacer(Modifier.height(15.dp))


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


                    // Start of Elevated Button


                    // End of Elevated Button

                    ThreeOptionSelector { }
                    Spacer(Modifier.height(10.dp))
                    Divider(thickness = 0.7.dp)

                    Spacer(Modifier.height(20.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Message Preview Length",
                            style = TextStyle(
                                fontSize = 17.sp
                            )
                        )
                        Text(
                            "100 chars", style = TextStyle(
                                color = Color(0xFF648AFF),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        )
                    }


                    Spacer(Modifier.height(15.dp))

                    CustomSliderWithSteps(
                        value = SliderState,
                        onValueChange = { SliderState = it },
                        steps = 6, // 0%, 25%, 50%, 75%, 100%
                        trackHeight = 5.dp,
                        thumbSize = 20.dp
                    )

                    Spacer(Modifier.height(10.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Short (50)",
                            style = TextStyle(
                                fontSize = 15.sp,
                                color = Color.Gray
                            )
                        )
                        Text(
                            "Long (200)", style = TextStyle(
                                fontSize = 15.sp,
                                color = Color.Gray
                            )
                        )
                    }


                }

            }

            Spacer(Modifier.height(35.dp))


            Card(
                modifier = Modifier
                    .height(150.dp),
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
                            text = "Advanced", style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                fontSize = 17.sp
                            )
                        )

                    }


                    Instructions(
                        modifier = Modifier,
                        title = "Reset to Defaults",
                        subtitle = "Restore all filter settings to their default values",
                        isCheked = BlockOperatorBtn,
                        onCheckedChange = { BlockOperatorBtn = it },
                        isReset = true,
                        onInstructionset2 = false
                    )


                }
            }

            Spacer(Modifier.height(35.dp))



            ElevatedButton(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5c6bc0)),
                onClick = {
                    //logic
                    scope.launch {
                        snackbarHostState.showSnackbar(message = "Filters settings saved successfully",)
                    }
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)

            ) {
                Text(text = "Save & Apply Filters", style = TextStyle(fontSize = 17.sp))
            }


            Spacer(Modifier.height(50.dp))

        }

    }
}

@Composable
fun CustomSliderWithSteps(
    value: Float,
    onValueChange: (Float) -> Unit,
    steps: Int = 5, // number of steps including 0 and 1
    modifier: Modifier = Modifier,
    trackHeight: Dp = 6.dp,
    thumbSize: Dp = 20.dp,
) {
    var sliderWidth by remember { mutableStateOf(0) }

    Box(
        modifier = modifier
            .height(max(trackHeight, thumbSize))
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .onGloballyPositioned { sliderWidth = it.size.width }
            .pointerInput(Unit) {
                detectDragGestures { change, _ ->
                    var newValue = (change.position.x / sliderWidth.toFloat()).coerceIn(0f, 1f)

                    // Snap to steps
                    val stepFraction = 1f / (steps - 1)
                    newValue = (newValue / stepFraction).roundToInt() * stepFraction

                    onValueChange(newValue)
                }
            }
    ) {
        // Track
        Canvas(modifier = Modifier.fillMaxSize()) {
            val yCenter = size.height / 2

            // Draw inactive track
            drawLine(
                color = Color.Gray,
                start = Offset(0f, yCenter),
                end = Offset(size.width, yCenter),
                strokeWidth = trackHeight.toPx(),
                cap = StrokeCap.Round
            )

            // Draw active track
            drawLine(
                color = Color(0xFF5c6bc0),
                start = Offset(0f, yCenter),
                end = Offset(50 * size.width, yCenter),
                strokeWidth = trackHeight.toPx(),
                cap = StrokeCap.Round
            )

            // Draw step markers
            for (i in 0 until steps) {
                val x = i * size.width / (steps - 1)
                drawCircle(
                    color = Color.LightGray,
                    radius = trackHeight.toPx() / 2,
                    center = Offset(x, yCenter)
                )
            }
        }

        // Thumb
        Box(
            modifier = Modifier
                .offset { IntOffset((value * sliderWidth).toInt() - thumbSize.roundToPx() / 2, 0) }
                .size(thumbSize)
        ) {
            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(shape = RoundedCornerShape(22.dp), color = Color(0xFF5c6bc0))
            )
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
    isReset: Boolean,
    onInstructionset2: Boolean,
) {


    val thumbColor by animateColorAsState(if (isCheked) Color(0xFF5868CC) else Color.Gray)
    val trackColor by animateColorAsState(
        if (isCheked) Color(0xFFced2ec) else Color(
            0xFFf2f2f2
        )
    )

    if (onInstructionset2) {
        //Row
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .height(20.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = title, style = TextStyle(
                    color = Color.Black, fontSize = 18.sp
                )
            )


            Spacer(modifier = Modifier.width(10.dp))

            if (isReset) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .height(35.dp)
                        .width(70.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFffb952),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {}
                )
                {

                    Text(
                        text = "Reset", style = TextStyle(
                            color = Color(0xFFffb952), fontSize = 14.sp
                        )
                    )

                }

            } else {
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
    } else {
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

            if (isReset) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .height(35.dp)
                        .width(70.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFffb952),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {}
                )
                {

                    Text(
                        text = "Reset", style = TextStyle(
                            color = Color(0xFFffb952), fontSize = 14.sp
                        )
                    )

                }

            } else {
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
    }


}

@Composable
fun ThreeOptionSelector(
    options: List<String> = listOf("Light", "Dark", "System"),
    onOptionSelected: (String) -> Unit,
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
                        color = if (selectedOption == option) Color(0xFF6271C2).copy(alpha = 0.2f) else Color.White,
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




