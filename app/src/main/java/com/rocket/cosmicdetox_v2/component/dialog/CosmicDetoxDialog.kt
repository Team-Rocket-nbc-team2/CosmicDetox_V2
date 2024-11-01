package com.rocket.cosmicdetox_v2.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rocket.cosmicdetox_v2.component.button.CosmicDetoxBorderButton
import com.rocket.cosmicdetox_v2.component.button.CosmicDetoxButton
import com.rocket.cosmicdetox_v2.ui.theme.BackgroundLight
import com.rocket.cosmicdetox_v2.ui.theme.White

/**
 * 취소, 확인 버튼이 있는 Cosmic Detox Dialog
 *
 * - [onDismissRequest]: dialog가 종료될 때 호출되는 콜백
 * - [properties]: dialog의 종료 속성을 정의(뒤로가기, dialog 영역 바깥 클릭)
 * - [content]: dialog의 body 정의(padding 등 기타 속성은 직접 설정해야 함)
 * - [onConfirmClick]: dialog의 확인 버튼이 클릭되었을 때 호출
 * - [onCancelClick]: dialog의 취소 버튼이 클릭되었을 때 호출
 */
@Composable
fun CosmicDetoxDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    content: @Composable () -> Unit,
    onConfirmClick: () -> Unit,
    onCancelClick: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = BackgroundLight)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()

                Row(modifier = Modifier.fillMaxWidth()) {
                    CosmicDetoxBorderButton(
                        onClick = onCancelClick,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 16.dp),
                        text = "취소",
                        borderColor = BackgroundLight
                    )

                    CosmicDetoxButton(
                        onClick = onConfirmClick,
                        modifier = Modifier.weight(1f),
                        text = "확인"
                    )
                }
            }
        }
    }
}

/**
 * 확인 버튼만 있는 Cosmic Detox Dialog
 *
 * - [onDismissRequest]: dialog가 종료될 때 호출되는 콜백
 * - [properties]: dialog의 종료 속성을 정의(뒤로가기, dialog 영역 바깥 클릭)
 * - [content]: dialog의 body 정의(padding 등 기타 속성은 직접 설정해야 함)
 * - [onConfirmClick]: dialog의 확인 버튼이 클릭되었을 때 호출
 */
@Composable
fun CosmicDetoxOneButtonDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    content: @Composable () -> Unit,
    onConfirmClick: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = BackgroundLight)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()

                CosmicDetoxButton(
                    onClick = onConfirmClick,
                    modifier = Modifier.fillMaxWidth(),
                    text = "확인"
                )
            }
        }
    }
}

/**
 * Dialog를 테스트하는 곳
 *
 * 여기서 Dialog 사용법 익히기.
 */
@Preview
@Composable
private fun CosmicDetoxDialogPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        var dialogState by remember { mutableStateOf(true) }

        CosmicDetoxButton(onClick = { dialogState = true }, text = "open dialog")

        if (dialogState) {
            CosmicDetoxOneButtonDialog(
                onDismissRequest = { dialogState = false },
                content = {
                    Box(modifier = Modifier.padding(vertical = 50.dp)) {
                        Text(
                            text = "Text",
                            color = White
                        )
                    }
                },
                onConfirmClick = { dialogState = false }
            )
        }
    }
}