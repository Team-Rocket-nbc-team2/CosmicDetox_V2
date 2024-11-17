package com.rocket.cosmicdetox_v2.component.item

import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.rocket.cosmicdetox_v2.R
import com.rocket.cosmicdetox_v2.component.checkbox.CosmicDetoxCheckBox
import com.rocket.cosmicdetox_v2.ui.theme.Background
import com.rocket.cosmicdetox_v2.ui.theme.Primary
import com.rocket.cosmicdetox_v2.ui.theme.StrokeDark
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * 앱 정보를 표시하는 list item.
 *
 * @param onClick list를 클릭 했을 때 호출.
 * @param packageManager 앱 정보를 불러올 package manager([LocalContext]를 활용해 context로 불러올 것.)
 * @param packageName 앱 정보를 불러올 package name 정의
 * @param secLeft 앱의 남은 이용 시간(초 형식으로 넘길 것.)
 */
@Composable
fun CosmicDetoxAppTimeItem(
    onClick: () -> Unit,
    packageManager: PackageManager,
    packageName: String,
    secLeft: Long,
) {
    val info = packageManager.getPackageInfo(packageName, 0)
    val appInfo = info.applicationInfo

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(Background)
            .alpha(if (secLeft == 0L) 0.5f else 1f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(appInfo.loadIcon(packageManager)),
                contentDescription = "cosmic detox app icon",
                modifier = Modifier.size(48.dp)
            )

            Text(
                text = appInfo.loadLabel(packageManager).toString(),
                modifier = Modifier.padding(start = 16.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            Text(
                text = toOptionHoursAndMinutes(secLeft),
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    color = Primary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }

        HorizontalDivider(color = StrokeDark)
    }
}

/**
 * 앱 정보를 표시하는 list item에 화살표가 추가됨.
 *
 * @param onClick list를 클릭 했을 때 호출.
 * @param packageManager 앱 정보를 불러올 package manager([LocalContext]를 활용해 context로 불러올 것.)
 * @param packageName 앱 정보를 불러올 package name 정의
 * @param secLeft 앱의 남은 이용 시간(초 형식으로 넘길 것.)
 */
@Composable
fun CosmicDetoxAppTimeArrowItem(
    onClick: () -> Unit,
    packageManager: PackageManager,
    packageName: String,
    secLeft: Long,
) {
    val info = packageManager.getPackageInfo(packageName, 0)
    val appInfo = info.applicationInfo

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(appInfo.loadIcon(packageManager)),
                contentDescription = "cosmic detox app icon",
                modifier = Modifier.size(48.dp)
            )

            Text(
                text = appInfo.loadLabel(packageManager).toString(),
                modifier = Modifier.padding(start = 16.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            Text(
                text = toOptionHoursAndMinutes(secLeft),
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                style = TextStyle(
                    color = Primary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "item arrow image",
                modifier = Modifier
                    .size(36.dp)
                    .clickable { onClick() }
            )
        }

        HorizontalDivider(color = StrokeDark)
    }
}

/**
 * 앱 정보와 CheckBox로 이루어진 Cosmic Detox list item component
 *
 * @param onCheckedChange component에 포함된 checkBox의 state가 변경되었을 경우 [Boolean] 데이터로 현재 checkBox state를 반환함.
 * @param checked component에 포함된 checkBox의 상태(true면 checked, false면 unchecked)
 * @param packageManager 앱 정보를 불러올 package manager([LocalContext]를 활용해 context로 불러올 것.)
 * @param packageName 앱 정보를 불러올 package name 정의
 */
@Composable
fun CosmicDetoxAppCheckBoxItem(
    onCheckedChange: (Boolean) -> Unit,
    checked: MutableState<Boolean>,
    packageManager: PackageManager,
    packageName: String
) {
    val info = packageManager.getPackageInfo(packageName, 0)
    val appInfo = info.applicationInfo

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(appInfo.loadIcon(packageManager)),
                contentDescription = "cosmic detox app icon",
                modifier = Modifier.size(48.dp)
            )

            Text(
                text = appInfo.loadLabel(packageManager).toString(),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            CosmicDetoxCheckBox(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

@Composable
private fun toOptionHoursAndMinutes(sec: Long): String {
    val hour = sec / 3600
    val min = (sec % 3600) / 60
    return if (hour > 0) "${hour}${stringResource(R.string.number_picker_unit_hour)} ${min}${stringResource(R.string.number_picker_unit_minute)}"
    else "${min}${stringResource(R.string.number_picker_unit_minute)}"
}

/**
 * 모든 list item들의 사용 sample
 *
 * 직접 emulator를 실행해서 테스트해야 함. split으로 진행 시 화면 나오지 않음.
 */
@Preview
@Composable
private fun CosmicDetoxAppItemPreview() {
    val context = LocalContext.current
    val state = remember { mutableStateOf(false) }

    Column {
        CosmicDetoxAppTimeItem(
            onClick = {},
            packageManager = context.packageManager,
            packageName = "com.android.chrome",
            secLeft = 1200
        )
        CosmicDetoxAppTimeItem(
            onClick = {},
            packageManager = context.packageManager,
            packageName = "com.android.chrome",
            secLeft = 12000,
        )
        CosmicDetoxAppTimeItem(
            onClick = {},
            packageManager = context.packageManager,
            packageName = "com.android.chrome",
            secLeft = 0,
        )
        CosmicDetoxAppTimeArrowItem(
            onClick = {},
            packageManager = context.packageManager,
            packageName = "com.android.chrome",
            secLeft = 120000
        )
        CosmicDetoxAppCheckBoxItem(
            onCheckedChange = {
                state.value = it
            },
            checked = state,
            packageManager = context.packageManager,
            packageName = "com.android.chrome"
        )
    }
}