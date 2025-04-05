package com.tweak.applanguageswitcher;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tweak.applanguageswitcher.databinding.ActivityLoginBinding;

import java.util.Locale;

public class Login extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ✅ Apply locale BEFORE calling super.onCreate and setContentView
        applyLocale();

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // ✅ Only use this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.changeLang.setOnClickListener(v -> changeLanguage());
    }

    private void changeLanguage() {
        final String[] lang = {"English", "Hindi", "Japanese", "Russian"};
        final String[] langCodes = {"", "hi", "ja", "ru"};

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(lang, -1, (dialog, which) -> {
            setLocale(langCodes[which]);
            recreate(); // recreate activity to apply new locale
            dialog.dismiss();
        });
        mBuilder.create().show();
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        );
    }

    private void applyLocale() {
        // Just re-apply the current default locale on launch
        Locale locale = Locale.getDefault();
        Configuration config = new Configuration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        );
    }
}
