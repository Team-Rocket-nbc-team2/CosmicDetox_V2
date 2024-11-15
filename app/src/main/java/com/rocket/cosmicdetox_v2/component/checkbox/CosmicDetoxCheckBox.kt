package com.rocket.cosmicdetox_v2.component.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rocket.cosmicdetox_v2.ui.theme.BlueGrey
import com.rocket.cosmicdetox_v2.ui.theme.Primary
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * Cosmic Detox 전용 checkBox component.
 *
 * @param checked 현재 체크 여부를 state로 불러오기(true면 checked, false면 unchecked)
 * @param onCheckedChange 체크 state가 변경되었을 때 호출([Boolean] 데이터로 현재 checkBox state를 반환함)
 */
@Composable
fun CosmicDetoxCheckBox(
    checked: MutableState<Boolean>,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(if (checked.value) Primary else BlueGrey)
                .clickable {
                    checked.value = !checked.value
                    onCheckedChange(checked.value)
                },
            contentAlignment = Alignment.Center
        ) {
            if (checked.value) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "checkbox checked is true icon",
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize(),
                    tint = White
                )
            }
        }
    }
}

/**
 * Cosmic Detox CheckBox 사용 sample
 */
@Preview
@Composable
private fun CosmicDetoxCheckBoxPreview() {
    val state = remember { mutableStateOf(false) }

    CosmicDetoxCheckBox(checked = state) {
        state.value = it
    }
}