# 🌐 App Language Switching – Localization Setup Guide

This project supports **dynamic language switching at runtime** (English, Hindi, Japanese, and Russian).

## 🛠 How to Add Translations using Android Studio

### 1. Open `strings.xml`
- Navigate to `res/values/strings.xml`
- Right-click the file and select **Open Translation Editor**

### 2. Enable Multiple Languages
- In the Translation Editor, click the 🌐 **globe icon** (top left)
- Select all the target languages to support:
  - `hi` for Hindi
  - `ja` for Japanese
  - `ru` for Russian

### 3. Add Keys and Translations
- Add keys like `email`, `password`, and `change_language`
- Enter the **default English text** under the *Default Value* column
- Provide **translations** for each language in their respective columns

> ⚠️ **Important:** Do not tick the "untranslatable" checkbox
> 
> If checked, the key will be excluded from translation and only default values will be used — which defeats the purpose of localization.

---

## 💡 Language Switching Mechanism (Behind the Scenes)

When a user selects a language, the following occurs:

### 🔄 Locale is Changed Programmatically
```java
Locale locale = new Locale(languageCode);
Locale.setDefault(locale);

Configuration config = new Configuration();
config.setLocale(locale);

getBaseContext().getResources().updateConfiguration(
    config,
    getBaseContext().getResources().getDisplayMetrics()
);
```
This updates the app’s configuration with the new locale and applies it to the session.

### 🔁 Activity is Refreshed
```java
recreate();
```
Calling `recreate()` reloads the UI to reflect updated language resources.

---

## ✅ Best Practices
- Use **consistent string keys** across all translations
- Keep key names **lowercase and descriptive** (`email`, `login_button`, etc.)
- Reference strings using `@string/key_name` in layouts and code
- Keep `strings.xml` files **clean and well-organized**

---

This folder structure ensures:
- Full localization support
- Real-time language switching
- No need to restart the app or manage preferences manually

---

<a href="https://github.com/user-attachments/assets/7b8d0933-bea5-41b1-be75-654fa11337b9" alt="Watch the video"> </a>
