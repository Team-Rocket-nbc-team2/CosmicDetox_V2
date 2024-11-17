package com.rocket.cosmicdetox_v2.component.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rocket.cosmicdetox_v2.R
import com.rocket.cosmicdetox_v2.ui.theme.Background
import com.rocket.cosmicdetox_v2.ui.theme.BackgroundLight
import com.rocket.cosmicdetox_v2.ui.theme.BlueGrey
import com.rocket.cosmicdetox_v2.ui.theme.Primary
import com.rocket.cosmicdetox_v2.ui.theme.StrokeDark
import com.rocket.cosmicdetox_v2.ui.theme.White
import com.rocket.cosmicdetox_v2.ui.theme.White20

/**
 * 랭킹 1위의 사용자 정보를 나타내는 card.
 *
 * @param modifier card의 크기, 추가 속성을 정의
 * @param icon 사용자의 프로필 image
 * @param name 사용자의 프로필 name
 * @param sec 사용자의 총 detox 시간
 */
@Composable
fun CosmicDetoxRanking1stItem(
    modifier: Modifier = Modifier,
    icon: Int,
    name: String,
    sec: Long,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = BlueGrey)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundLight)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_trophy_1st),
                    contentDescription = "ranking 1st",
                    modifier = Modifier.size(48.dp)
                )
            }

            Image(
                painter = painterResource(icon),
                contentDescription = "user icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color(0xFFFFCF00), CircleShape)
            )

            Text(
                text = name,
                style = TextStyle(
                    color = White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp),
                text = toHoursAndMinutes(sec),
                style = TextStyle(
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

/**
 * 랭킹 2위 사용자 정보를 나타내는 card.
 *
 * @param modifier card의 크기, 추가 속성을 정의
 * @param icon 사용자의 프로필 image
 * @param name 사용자의 프로필 name
 * @param sec 사용자의 총 detox 시간
 */
@Composable
fun CosmicDetoxRanking2ndItem(
    modifier: Modifier = Modifier,
    icon: Int,
    name: String,
    sec: Long,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = BlueGrey)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundLight)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_trophy_2nd),
                    contentDescription = "ranking 1st",
                    modifier = Modifier.size(48.dp)
                )
            }

            Image(
                painter = painterResource(icon),
                contentDescription = "user icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color(0xFFC0C0C0), CircleShape)
            )

            Text(
                text = name,
                style = TextStyle(
                    color = White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp),
                text = toHoursAndMinutes(sec),
                style = TextStyle(
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

/**
 * 랭킹 3위 이하의 사용자 정보를 나타내는 card
 *
 * @param modifier card의 크기, 추가 속성을 정의
 * @param rank 사용자의 순위 정의
 * @param name 사용자의 이름
 * @param sec 사용자의 총 detox 시간
 * @param type 불러올 랭킹 정보. [RankingItemType]을 이용해 값을 불러온다.
 */
@Composable
fun CosmicDetoxRankingItem(
    modifier: Modifier = Modifier,
    rank: Int,
    name: String,
    sec: Long,
    type: RankingItemType = RankingItemType.OTHER_RANK
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(if (type == RankingItemType.OTHER_RANK) Background else Primary)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = rank.toString(),
                modifier = Modifier.weight(0.15f),
                style = TextStyle(
                    color = White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            )

            Image(
                painter = painterResource(convertSecToPlanetImage(sec)),
                contentDescription = "ranking planet image",
                modifier = Modifier.size(64.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = name,
                    style = TextStyle(
                        color = White20,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

                Text(
                    text = toHoursAndMinutes(sec),
                    style = TextStyle(
                        color = White20,
                        fontSize = 14.sp
                    )
                )
            }
        }

        if (type == RankingItemType.OTHER_RANK) {
            HorizontalDivider(color = StrokeDark)
        }
    }
}

private fun convertSecToPlanetImage(sec: Long): Int {
    return if (sec < 21600) R.drawable.img_mercury
    else if (sec < 43200) R.drawable.img_mars
    else if (sec < 86400) R.drawable.img_venus
    else if (sec < 172800) R.drawable.img_earth
    else if (sec < 230400) R.drawable.img_neptune
    else if (sec < 432000) R.drawable.img_uranus
    else if (sec < 864000) R.drawable.img_saturn
    else if (sec < 1.44e+6) R.drawable.img_jupiter
    else R.drawable.img_sun
}

private fun toHoursAndMinutes(sec: Long): String {
    val hour = sec / 3600
    val min = (sec % 3600) / 60
    return "${hour}시간 ${min}분"
}

/**
 * Cosmic Detox Ranking Item 사용 sample
 */
@Preview
@Composable
private fun CosmicDetoxRankingItemPreview() {
    Column(modifier = Modifier.background(Background)) {
        Row {
            CosmicDetoxRanking1stItem(
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_account,
                name = "test",
                sec = 120000
            )

            CosmicDetoxRanking2ndItem(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                icon = R.drawable.ic_account,
                name = "test",
                sec = 120000
            )
        }

        CosmicDetoxRankingItem(
            rank = 3,
            name = "test3",
            sec = 21600
        )

        CosmicDetoxRankingItem(
            rank = 4,
            name = "test4",
            sec = 21599
        )

        CosmicDetoxRankingItem(
            rank = 5,
            name = "my",
            sec = 21321,
            type = RankingItemType.MY_RANK
        )
    }
}