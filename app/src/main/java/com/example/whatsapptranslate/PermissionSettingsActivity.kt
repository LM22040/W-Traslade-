package com.example.whatsapptranslate

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PermissionSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission_settings)

        val btnGrantPermissions: Button = findViewById(R.id.btn_grant_permissions)
        val btnPrivacyPolicy: Button = findViewById(R.id.btn_privacy_policy)
        val tvPermissionInfo: TextView = findViewById(R.id.tv_permission_info)

        // Botón para conceder permisos
        btnGrantPermissions.setOnClickListener {
            // Abrir la pantalla de configuración de accesibilidad del sistema
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(intent)
        }

        // Botón para ver la política de privacidad
        btnPrivacyPolicy.setOnClickListener {
            // Aquí puedes abrir un enlace a la política de privacidad
            val intent = Intent(this, PrivacyPolicyActivity::class.java)
            startActivity(intent)
        }
    }
}
