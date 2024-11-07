package com.rocket.cosmicdetox_v2.component.bottomsheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rocket.cosmicdetox_v2.R
import com.rocket.cosmicdetox_v2.component.button.CosmicDetoxButton
import com.rocket.cosmicdetox_v2.ui.theme.Background
import com.rocket.cosmicdetox_v2.ui.theme.Stroke
import com.rocket.cosmicdetox_v2.ui.theme.White
import com.rocket.cosmicdetox_v2.ui.theme.White20

/**
 * icon이 있는 Cosmic Detox Bottom Sheet
 *
 * @param visible Bottom Sheet의 보이는 여부를 설정
 * @param title Bottom Sheet의 Title 텍스트. 다국어 지원을 위해 [stringResource]사용하기.
 * @param content Bottom Sheet의 Body 지정.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CosmicDetoxIconBottomSheet(
    visible: MutableState<Boolean>,
    title: String,
    content: @Composable () -> Unit
) {
   AnimatedVisibility(
       visible = visible.value,
       enter = slideInVertically(
           initialOffsetY = { it }
       ),
       exit = slideOutVertically(
           targetOffsetY = { it }
       )
   ) {
       Card(
           modifier = Modifier
               .fillMaxSize()
               .background(color = Background),
           shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
           colors = CardDefaults.cardColors(containerColor = Background)
       ) {
           CenterAlignedTopAppBar(
               title = {
                   Text(
                       text = title,
                       style = TextStyle(
                           color = White20,
                           fontSize = 16.sp,
                           fontWeight = FontWeight.Normal
                       )
                   )
               },
               actions = {
                   Icon(
                       painter = painterResource(R.drawable.ic_x),
                       contentDescription = "exit bottom sheet",
                       modifier = Modifier.clickable { visible.value = false },
                       tint = White
                   )
               },
               colors = TopAppBarDefaults.topAppBarColors(containerColor = Background)
           )

           HorizontalDivider(color = Stroke)

           content()
       }
   }
}

/**
 * text가 있는 Cosmic Detox Bottom Sheet
 *
 * @param visible Bottom Sheet의 보이는 여부를 설정
 * @param title Bottom Sheet의 Title 텍스트. 다국어 지원을 위해 [stringResource]사용하기.
 * @param content Bottom Sheet의 Body 지정.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CosmicDetoxTextBottomSheet(
    visible: MutableState<Boolean>,
    title: String,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visible.value,
        enter = slideInVertically(
            initialOffsetY = { it }
        ),
        exit = slideOutVertically(
            targetOffsetY = { it }
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Background),
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            colors = CardDefaults.cardColors(containerColor = Background)
        ) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title,
                        style = TextStyle(
                            color = White20,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                actions = {
                    Text(
                        text = stringResource(R.string.bottom_sheet_complete),
                        modifier = Modifier.clickable { visible.value = false },
                        style = TextStyle(
                            color = White20,
                            fontSize = 16.sp
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Background)
            )

            HorizontalDivider(color = Stroke)

            content()
        }
    }
}

/**
 * Bottom Sheet 사용 sample
 */
@Preview
@Composable
private fun CosmicDetoxBottomSheetPreview() {
    val openIconBottomSheet = rememberSaveable { mutableStateOf(false) }
    val openTextBottomSheet = rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background),
        contentAlignment = Alignment.Center
    ) {
        Column {
            CosmicDetoxButton(
                onClick = { openIconBottomSheet.value = true },
                text = "open icon bottom sheet"
            )

            CosmicDetoxButton(
                onClick = { openTextBottomSheet.value = true },
                text = "open text bottom sheet"
            )
        }

        CosmicDetoxIconBottomSheet(
            visible = openIconBottomSheet,
            title = "Title"
        ) {
            Text(
                text = "body",
                color = White
            )
        }

        CosmicDetoxTextBottomSheet(
            visible = openTextBottomSheet,
            title = "Text Title"
        ) {
            Text(
                text = "body",
                color = White
            )
        }
    }
}

