package com.rocket.cosmicdetox_v2.component.numberpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chargemap.compose.numberpicker.NumberPicker
import com.rocket.cosmicdetox_v2.R
import com.rocket.cosmicdetox_v2.ui.theme.Background
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * cosmic detox 에서 허용 앱 사용 시간을 정할 number picker
 *
 * @param modifier number picker의 위치와 크기 등을 정의.
 * @param hourValue hour의 초기 값을 정의. 0부터 5까지의 수로 정할 것.
 * @param minuteValue minute의 초기 값을 정의. 0부터 59까지의 수로 정할 것.
 * @param onHourValueChange number picker hour 부분 선택 시 선택된 hour를 int로 반환.
 * @param onMinuteValueChange number picker minute 부분 선택 시 선택된 minute를 int로 반환.
 */
@Composable
fun CosmicDetoxTimeNumberPicker(
    modifier: Modifier = Modifier,
    hourValue: Int = 0,
    minuteValue: Int = 0,
    onHourValueChange: (Int) -> Unit,
    onMinuteValueChange: (Int) -> Unit,
) {
    val hour = stringResource(R.string.number_picker_unit_hour)
    val minute = stringResource(R.string.number_picker_unit_minute)

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        NumberPicker(
            modifier = Modifier.wrapContentWidth(),
            label = { "$it$hour" },
            range = 0..5,
            value = hourValue,
            onValueChange = onHourValueChange,
            dividersColor = White,
            textStyle = TextStyle(
                color = White
            )
        )

        Spacer(modifier = Modifier.size(24.dp))

        NumberPicker(
            modifier = Modifier.wrapContentWidth(),
            label = { if (it < 10) "0$it$minute" else "$it$minute" },
            range = 0..59,
            value = minuteValue,
            onValueChange = onMinuteValueChange,
            dividersColor = White,
            textStyle = TextStyle(
                color = White
            )
        )
    }
}

/**
 * cosmic detox number picker 사용 sample
 */
@Preview
@Composable
private fun CosmicDetoxNumberPickerPreview() {
    Box(modifier = Modifier.background(Background)) {
        CosmicDetoxTimeNumberPicker(
            modifier = Modifier.fillMaxWidth(),
            hourValue = 2,
            minuteValue = 36,
            onHourValueChange = {},
            onMinuteValueChange = {}
        )
    }
}