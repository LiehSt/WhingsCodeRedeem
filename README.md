# 🧩 WhingsCodeRedeem

Plugin Code Redeem Untuk Minecraft Java **Paper / Spigot**, dengan fitur yang simpel.

---

## ✨ Fitur

- ⚡ Fitur 1: player dapat meredeem sebuah code
- 🔒 Fitur 2: Proteksi / permission khusus
- 🧙 Fitur 3: Kompatibel dengan plugin lain
- 📜 Fitur 4: Konfigurasi fleksibel via config.yml atau di in game
- 🛠️ Support Paper, Spigot.

---

## 🧰 Instalasi

1. Download file `.jar` dari [Releases](https://github.com/LiehSt/WhingsCodeRedeem/releases)
2. Masukkan file ke folder `plugins/` di server Minecraft Kamu!
3. Restart server
4. Plugin aktif secara otomatis!

---

## ⚙️ Command & Permission

### 🎮 Command:

| Command | Deskripsi |
|--------|-----------|
| `/code` | Redeem kode hadiah |
| `/wcr` | Command admin untuk generate dan delete kode |

### 🛡️ Permission:

| Permission | Deskripsi |
|------------|-----------|
| `whingscoderedeem.admin` | Akses ke semua fitur admin |
| `whingscoderedeem.redeem` | Akses ke semua player untuk redeem code |

---

## 📂 Konfigurasi

File config akan muncul otomatis setelah plugin dijalankan.  
Contoh bagian config:
```yaml
codes:
  Welcome2025:
    reward: 'give %player% diamond 3'
```
