package com.example.whatsapptranslate

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activation)

        val btnOpenWhatsApp: Button = findViewById(R.id.btn_open_whatsapp)
        val tvInstructions: TextView = findViewById(R.id.tv_activation_instructions)

        btnOpenWhatsApp.setOnClickListener {
            val packageManager = packageManager
            val intent = packageManager.getLaunchIntentForPackage("com.whatsapp")
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                Toast.makeText(this, "Abriendo WhatsApp...", Toast.LENGTH_SHORT).show()
            } else {
                // Si WhatsApp no está instalado, redirige al Play Store
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.whatsapp")))
                } catch (e: Exception) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")))
                }
            }
        }
    }
}
