package de.hshl.isd.licenses

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import de.hshl.isd.licenses.ui.theme.LicensesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LicensesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Button(onClick = {
                        startActivity(
                            Intent(this,
                                OssLicensesMenuActivity::class.java)
                        )
                    }) {
                        Text(text = "Show licenses")
                    }                }
            }
        }
    }
}