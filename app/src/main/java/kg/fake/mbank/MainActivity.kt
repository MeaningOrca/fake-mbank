package kg.fake.mbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val controller = remember { LifecycleCameraController(applicationContext) }
            controller.bindToLifecycle(LocalLifecycleOwner.current)

            Box {
                AndroidView(
                    factory = {
                        PreviewView(it).apply { this.controller = controller }
                    }, modifier = Modifier.fillMaxSize()
                )

                Icon(
                    painterResource(R.drawable.cancel),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 30.dp, end = 20.dp)
                )

                Button(
                    onClick = { },

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(16.dp),

                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 45.dp)

                ) { Text(text = getString(R.string.button_text)) }

                Image(
                    painterResource(R.drawable.fake_ui), contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}