package com.rocket.cosmicdetox_v2.component.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rocket.cosmicdetox_v2.R
import com.rocket.cosmicdetox_v2.ui.theme.Background
import com.rocket.cosmicdetox_v2.ui.theme.BlueGrey
import com.rocket.cosmicdetox_v2.ui.theme.StrokeDark
import com.rocket.cosmicdetox_v2.ui.theme.White20

/**
 * 설정에 들어갈 setting item
 *
 * @param modifier setting item의 크기, 기타 속성 정의
 * @param icon setting item의 title icon. drawable로 불러오기.
 * @param title setting item의 title text. [stringResource]를 이용해 다국어 지원이 가능하도록 불러올 것.
 * @param subText setting item의 오른쪽에 들어갈 subText. [subText]가 null이면 [R.drawable.ic_arrow_right]가 들어가게 됨.
 */
@Composable
fun CosmicDetoxSettingItem(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    subText: String? = null
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Background)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = "setting title image",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(White20)
            )

            Text(
                text = title,
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .weight(1f),
                style = TextStyle(
                    color = White20,
                    fontSize = 16.sp
                )
            )

            if (subText != null) {
                Text(
                    text = subText,
                    style = TextStyle(
                        color = White20,
                        fontSize = 14.sp
                    )
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = "setting sub arrow image",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(White20)
                )
            }
        }

        HorizontalDivider(color = StrokeDark)
    }
}

/**
 * 설정에 들어갈 setting item의 header
 *
 * @param title setting header에 들어갈 title text. [stringResource]를 이용해 다국어 지원이 가능하도록 불러올 것.
 */
@Composable
fun CosmicDetoxSettingHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = BlueGrey,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
    }
}

/**
 * cosmic detox setting item 사용 sample.
 */
@Preview
@Composable
private fun CosmicDetoxSettingItemPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
    ) {
        CosmicDetoxSettingHeader(
            title = stringResource(R.string.settings_management_apps_title)
        )
        CosmicDetoxSettingItem(
            icon = R.drawable.ic_locked,
            title = stringResource(R.string.settings_management_apps_privacy_policy)
        )
        CosmicDetoxSettingItem(
            icon = R.drawable.ic_warning_circle,
            title = stringResource(R.string.settings_management_apps_app_version),
            subText = "1.0.0"
        )
    }
}