package tan.msg.xor.nex.com

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tan.msg.xor.nex.com.ui.theme.MessageBoxTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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


            MessageBoxTheme {
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
                                                    0 -> { /* Set Filters action */
                                                    }

                                                    1 -> { /* Source Code action */
                                                    }

                                                    2 -> { /* Changelog action */
                                                    }

                                                    3 -> { /* Developer Info action */
                                                    }

                                                    4 -> { /* Feedback action */
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
                    BankSMSApp()
                }
            }
        }
    }
}

