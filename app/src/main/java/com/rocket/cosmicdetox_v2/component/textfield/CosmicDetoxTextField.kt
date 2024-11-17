package com.rocket.cosmicdetox_v2.component.textfield

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rocket.cosmicdetox_v2.R
import com.rocket.cosmicdetox_v2.ui.theme.BackgroundLight
import com.rocket.cosmicdetox_v2.ui.theme.BlueGrey
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * cosmic detox의 search text field
 *
 * @param modifier text field의 위치 정의.
 * @param text 초기 text state 정의.
 * @param onTextChange text의 state가 변경되었을 때
 * @param onSearch 검색을 시작했을 때의 기능
 */
@Composable
fun CosmicDetoxSearchTextField(
    modifier: Modifier = Modifier,
    text: MutableState<String> = mutableStateOf(""),
    onTextChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(
        value = text.value,
        onValueChange = onTextChange,
        modifier = modifier,
        textStyle = TextStyle(
            color = White,
            fontSize = 16.sp
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions {
            onSearch()
            keyboardController?.hide()
        },
        singleLine = true
    ) { innerTextField ->
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(BackgroundLight)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "search text field image"
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                if (text.value.isEmpty()) {
                    Text(
                        text = stringResource(R.string.search_edit_text_hint),
                        style = TextStyle(
                            color = BlueGrey,
                            fontSize = 16.sp
                        )
                    )
                }
                innerTextField()
            }

            if (text.value.isNotEmpty()) {
                Image(
                    painter = painterResource(R.drawable.ic_x),
                    contentDescription = "search text clear",
                    modifier = Modifier.clickable { text.value = "" },
                    colorFilter = ColorFilter.tint(BlueGrey)
                )
            }
        }
    }
}

/**
 * cosmic detox text field 사용 sample
 */
@Preview
@Composable
private fun CosmicDetoxTextFieldPreview() {
    val text = remember { mutableStateOf("") }

    CosmicDetoxSearchTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp),
        text = text,
        onTextChange = {
            text.value = it
        },
        onSearch = {
            Log.d("TAG", "CosmicDetoxTextFieldPreview: searching...")
        }
    )
}