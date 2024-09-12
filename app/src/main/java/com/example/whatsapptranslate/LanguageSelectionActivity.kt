package com.example.whatsapptranslate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class LanguageSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_selection)

        val spinnerLanguages: Spinner = findViewById(R.id.spinner_languages)
        val btnSave: Button = findViewById(R.id.btn_save_language)

        btnSave.setOnClickListener {
            // Aquí puedes guardar la selección de idioma en SharedPreferences
            val selectedLanguage = spinnerLanguages.selectedItem.toString()
            saveLanguagePreference(selectedLanguage)

            // Redirigir a la siguiente actividad
            startActivity(Intent(this, PermissionSettingsActivity::class.java))
        }
    }

    private fun saveLanguagePreference(language: String) {
        val sharedPreferences = getSharedPreferences("WhatsAppTranslatePrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("selected_language", language)
        editor.apply()
    }
}
