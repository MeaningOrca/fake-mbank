package kg.fake.mbank

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

                Button(
                    onClick = { Toast.makeText(applicationContext, "Наёбан!", Toast.LENGTH_SHORT).show() }, // NotImplemented
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 50.dp)
                ) { Text(text = getString(R.string.button_text)) }
                
                Image(painterResource(R.drawable.fake_ui), contentDescription = null)
            }
        }
    }
}