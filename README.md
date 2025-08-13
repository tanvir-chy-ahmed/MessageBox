# 📱 SMS Filter App (Open Source)

A simple and privacy-respecting SMS receiver app for Android that filters out unwanted promotional messages like those from GP, BL, and more. This app is built to help users avoid spam SMS by using a custom keyword-based filter system.

---

## 🔍 Overview

Many users face the issue of receiving too many unwanted promotional SMS from mobile operators and services. This lightweight SMS Filter App solves that problem by allowing users to add custom keywords (e.g., `GP`, `BL`, `Taka`) and block messages containing those words.

The app continuously reads incoming SMS and checks if the content contains any of the user-defined filter words. If it matches, the message is blocked from being shown in the main message list; otherwise, it's displayed.

---

## ✨ Features

- 📩 **Real-time SMS Filtering**
- 🧠 **Custom Keyword Filter System**
- 👤 **User-Friendly Interface**
- 🛑 **Block Promotional SMS**
- ✅ **Allow Only Important Messages**
- 🛡️ **100% Offline - No data is sent anywhere**

---

## 🧪 How It Works

1. App runs a top-positioned SMS receiver.
2. User can tap the "Filter" button to open the keyword management screen.
3. User can add any number of filter keywords like `GP`, `BL`, `Offer`, `Taka`, etc.
4. When a new SMS arrives:
   - App checks if any of the filter keywords are **contained in the message body**.
   - If matched → **Blocked/Hidden**
   - Else → **Shown to the user**

---

## 🛠️ Built With

- 💬 Kotlin + Jetpack Compose
- 🔒 Android SMS Permission Handling
- 📦 Broadcast Receiver
- 💡 MVVM Architecture (optional, if used)

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- Android SDK 24+
- Kotlin

### Clone the repo

```bash
git clone https://github.com/tanvir-chy-ahmed/Message-Box.git
```

### Run the project

1. Open with Android Studio
2. Build & Run on a real device (SMS permissions may not work on emulator)
3. Grant SMS read permission manually if needed

---

## 📸 Screenshots


---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🤝 Contributing

Pull requests are welcome! If you have ideas for improvements or want to report bugs, feel free to open an issue.

---

## 📬 Contact

Made with ❤️ by Tanvir ahmed (chy)  
📧 Email: tanvirchy269@gmail.com
🌐 GitHub: https://github.com/tanvir-chy-ahmed

