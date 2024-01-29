package kg.fake.mbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val controller = remember { LifecycleCameraController(applicationContext) }
            controller.bindToLifecycle(LocalLifecycleOwner.current)

            AndroidView(factory = {
                    PreviewView(it).apply { this.controller = controller }
                }, modifier = Modifier.fillMaxSize()
            )
        }
    }
}