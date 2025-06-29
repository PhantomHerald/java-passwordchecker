
# 🔐 Password Strength Checker

A simple Java Swing GUI application that evaluates the strength of a user's password in real-time. The program provides a visual indicator and feedback based on password complexity, length, character variety, and detection of simple or repeated patterns.

---

## 📋 Features

- ✅ Real-time password strength checking
- ✅ Visual strength indicator via a progress bar
- ✅ Suggestions for improving weak or medium-strength passwords
- ✅ Detection of common and simple passwords (e.g. `123456`, `111111`)
- ✅ Option to toggle password visibility
- ✅ Lightweight and easy-to-run GUI application

---

## 🧠 How It Works

The password is evaluated using the following criteria:

- **Length**: More characters = higher score
- **Character Variety**: Adds points for uppercase, lowercase, digits, and special characters
- **Pattern Detection**: Penalizes simple or repeated number sequences like `1234`, `1111`, `000000`, etc.

The final score is used to update a progress bar and display messages:

| Strength Range | Label         | Color    | Recommendation                                  |
|----------------|---------------|----------|--------------------------------------------------|
| 0 - 29         | Weak ❌        | Red      | Add numbers, symbols, and increase length        |
| 30 - 59        | Medium ⚠️      | Orange   | Mix uppercase, lowercase, and special characters |
| 60+            | Strong ✅      | Green    | Great! Password is strong                        |

---

## 🧪 Example Password Scores

| Password       | Strength Score | Rating  |
|----------------|----------------|---------|
| `123456`       | 15             | Weak ❌  |
| `Pass123`      | ~45            | Medium ⚠️ |
| `P@ssw0rd2024` | ~75            | Strong ✅ |

---

## 🛠️ Installation & Running

### Requirements
- Java 8 or later
- Any IDE that supports Java (e.g., IntelliJ, Eclipse, NetBeans) or CLI with `javac`

### Running the App
1. Clone or download the repository.
2. Compile and run the main file:

```bash
javac PasswordStrengthChecker.java
java PasswordStrengthChecker
```

Or run it via your IDE’s GUI environment.

---

## 📂 File Structure

```
PasswordStrengthChecker.java  // Main application file with GUI and logic
```

---

## 💡 Possible Enhancements

- Export strength report
- Add password history to check reused passwords
- Integrate with user account creation modules
- Localized language support

---

## 🧑‍💻 Author

**Gerald Ankomah**  
Feel free to connect or contribute if you find this useful!

---

## 📄 License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).
