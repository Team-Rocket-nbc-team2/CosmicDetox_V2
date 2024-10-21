package com.rocket.cosmicdetox_v2.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rocket.cosmicdetox_v2.ui.theme.BackgroundLight
import com.rocket.cosmicdetox_v2.ui.theme.BlueGrey
import com.rocket.cosmicdetox_v2.ui.theme.Primary
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * 기본 CosmicDetox Button
 *
 * - [onClick]: 버튼 클릭 시 이벤트 처리
 * - [modifier]: 버튼의 크기, 추가 속성을 적용
 * - [text]: 버튼의 text
 * - [textColor]: 버튼의 textColor
 * - [containerColor]: 버튼의 배경색
 * - [icon]: 버튼 icon을 설정
 * - [iconTint]: icon의 색을 수정
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
 * - [onClick]: 버튼 클릭 시 이벤트 처리
 * - [modifier]: 버튼의 크기, 추가 속성을 적용
 * - [text]: 버튼의 text
 * - [textColor]: 버튼의 textColor
 * - [containerColor]: 버튼의 배경색
 * - [borderColor]: 버튼의 테두리 색을 지정
 * - [icon]: 버튼 icon을 설정
 * - [iconTint]: icon의 색을 수정
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
    }
}