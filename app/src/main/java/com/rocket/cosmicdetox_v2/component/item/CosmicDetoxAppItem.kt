package com.rocket.cosmicdetox_v2.component.item

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.rocket.cosmicdetox_v2.ui.theme.Background
import com.rocket.cosmicdetox_v2.ui.theme.Primary
import com.rocket.cosmicdetox_v2.ui.theme.StrokeDark
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * 앱 정보를 표시하는 list item.
 *
 * @param onClick list를 클릭 했을 때 호출.
 * @param packageName 앱 정보를 불러올 package name 정의
 * @param secLeft 앱의 남은 이용 시간(초 형식으로 넘길 것.)
 */
@Composable
fun CosmicDetoxAppTimeItem(
    onClick: () -> Unit,
    packageName: String,
    secLeft: Long,
) {
    val context = LocalContext.current
    val packageManager = context.packageManager
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

private fun toOptionHoursAndMinutes(sec: Long): String {
    val hour = sec / 3600
    val min = (sec % 3600) / 60
    return if (hour > 0) "${hour}시간 ${min}분"
    else "${min}분"
}

/**
 * 모든 list item들의 사용 sample
 *
 * 직접 emulator를 실행해서 테스트해야 함. split으로 진행 시 화면 나오지 않음.
 */
@Preview
@Composable
private fun CosmicDetoxAppItemPreview() {
    Column {
        CosmicDetoxAppTimeItem(
            onClick = {},
            packageName = "com.android.chrome",
            secLeft = 1200
        )
        CosmicDetoxAppTimeItem(
            onClick = {},
            packageName = "com.android.chrome",
            secLeft = 12000,
        )
        CosmicDetoxAppTimeItem(
            onClick = {},
            packageName = "com.android.chrome",
            secLeft = 0,
        )
    }
}