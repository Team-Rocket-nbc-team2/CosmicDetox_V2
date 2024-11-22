package com.rocket.cosmicdetox_v2.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rocket.cosmicdetox_v2.R
import com.rocket.cosmicdetox_v2.ui.theme.BackgroundLight
import com.rocket.cosmicdetox_v2.ui.theme.BlueGrey
import com.rocket.cosmicdetox_v2.ui.theme.Primary
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * 기본 CosmicDetox Button
 *
 * @param onClick 버튼 클릭 시 이벤트 처리
 * @param modifier 버튼의 크기, 추가 속성을 적용
 * @param text 버튼의 text. 다국어 지원을 위해 [stringResource]를 사용할 것.
 * @param textColor 버튼의 textColor
 * @param containerColor 버튼의 배경색
 * @param icon 버튼 icon을 설정
 * @param iconTint icon의 색을 수정
 */
@Composable
fun CosmicDetoxButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = White,
    containerColor: Color = Primary,
    icon: Int? = null,
    iconTint: Color = White
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "cosmic detox button",
                    modifier = Modifier.padding(end = 8.dp),
                    tint = iconTint
                )
            }

            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp
            )
        }
    }
}

/**
 * Border가 있는 CosmicDetox Button
 *
 * @param onClick 버튼 클릭 시 이벤트 처리
 * @param modifier 버튼의 크기, 추가 속성을 적용
 * @param text 버튼의 text. 다국어 지원을 위해 [stringResource]를 사용할 것.
 * @param textColor 버튼의 textColor
 * @param containerColor 버튼의 배경색
 * @param borderColor 버튼의 테두리 색을 지정
 * @param icon 버튼 icon을 설정
 * @param iconTint icon의 색을 수정
 */
@Composable
fun CosmicDetoxBorderButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = BlueGrey,
    containerColor: Color = BackgroundLight,
    borderColor: Color = Primary,
    icon: Int? = null,
    iconTint: Color = White
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        border = BorderStroke(width = 1.dp, color = borderColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "cosmic detox button",
                    modifier = Modifier.padding(end = 8.dp),
                    tint = iconTint
                )
            }

            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp
            )
        }
    }
}

/**
 * 소셜 로그인 전용 버튼
 *
 * @param onClick 버튼 클릭 시 이벤트 처리
 * @param modifier 버튼의 크기, 추가 속성을 적용
 * @param type 로그인할 sns 종류 선택. [SocialSignInType]을 이용해 sns의 type을 지정.
 */
@Composable
fun CosmicDetoxSocialSignInButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: SocialSignInType,
) {
    val containerColor = if (type == SocialSignInType.KAKAO) Color(0xFFFAE100) else White
    val icon = when (type) {
        SocialSignInType.KAKAO -> R.drawable.ic_kakao
        SocialSignInType.GOOGLE -> R.drawable.ic_google
        SocialSignInType.TWITTER_X -> R.drawable.ic_twitter_x
    }

    IconButton(
        onClick = onClick,
        modifier = modifier.size(48.dp),
        colors = IconButtonDefaults.iconButtonColors(containerColor = containerColor)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "social sign in",
            modifier = Modifier.size(28.dp)
        )
    }
}

/**
 * 버튼 기능 테스트하는 함수
 */
@Preview
@Composable
private fun CosmicDetoxButtonPreview() {
    Column {
        CosmicDetoxButton(
            onClick = {},
            text = "test"
        )

        CosmicDetoxBorderButton(
            onClick = {},
            text = "text border"
        )

        CosmicDetoxSocialSignInButton(
            onClick = {},
            type = SocialSignInType.KAKAO
        )
        CosmicDetoxSocialSignInButton(
            onClick = {},
            type = SocialSignInType.GOOGLE
        )
        CosmicDetoxSocialSignInButton(
            onClick = {},
            type = SocialSignInType.TWITTER_X
        )
    }
}