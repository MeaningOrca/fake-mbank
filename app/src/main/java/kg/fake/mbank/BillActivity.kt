package kg.fake.mbank

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Timer
import kotlin.concurrent.schedule

class BillActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        Timer().schedule(2000) {
            setContent {
                Check()
            }
        }
    }
}

@Composable
fun Check() {
    // Тут делай что хочешь
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), Arrangement.Center) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painterResource(R.drawable.mbank_logo), contentDescription = null,
                modifier = Modifier.width(100.dp)
            )

            IconButton(onClick = { }) { // finish()
                Icon(painterResource(R.drawable.close), contentDescription = null)
            }
        }

        Image(
            painterResource(R.drawable.check), contentDescription = null,
            modifier = Modifier.width(75.dp)
        )
    }
}