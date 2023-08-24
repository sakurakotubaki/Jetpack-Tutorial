package com.example.jetprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color// Textのカラーはこれをimportする
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetprofile.ui.theme.JetProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetProfileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        // プロフィール画像
                        Image(
                            painter = painterResource(id = R.drawable.image_profile),
                            contentDescription = "プロフィール",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        // 名前
                        Text(
                            text = "Jboy Hashimoto",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        // 職業
                        Text(
                            text = "職業: ソフトウェアエンジニア",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.fillMaxWidth(),
                            ) {
                            // 会社名
                            Text(
                                text = "Google",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            // 部署・グループ名
                            Text(text = "Android開発部",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            // Email
                            Label(icon = Icons.Default.Email, text = "Email")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "example.com", fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(5.dp))

                            Divider(
                                color = Color.LightGray,
                                thickness = 2.dp,
                                modifier = Modifier.clip(RoundedCornerShape(1000.dp))
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        // 詳細表示ボタン
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF85F6A)
                            ),
                            onClick = {}) {
                            Text(text = "詳細を表示", color = Color.White)
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        // 趣味 & 居住地セクション
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.LightGray.copy(alpha = 0.3f))
                                .padding(horizontal = 10.dp, vertical = 20.dp)
                        )
                        {
                            Label(
                                icon = Icons.Default.Favorite,
                                text = "趣味: 旅行, Zennの記事を書く",
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Label(
                                icon = Icons.Default.LocationOn,
                                text = "居住地: 東京都",
                                color = Color.Gray,
                            )
                        }
                    }
                }
            }
        }
    }
}

// アノテーションをつけるとJetpack Composeで使える
@Composable
fun Label(icon: ImageVector, text: String, color: Color = MaterialTheme.colors.onBackground) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, color = color, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}