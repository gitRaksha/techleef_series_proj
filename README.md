# 🚀 Yocto Quick Build Project

This repository contains my **Yocto Quick Build setup** based on the official Yocto Project documentation.  
I use it to learn the basics of building custom Linux images.

---

## 📂 Project Structure

📂 techleef_series_proj/
 ┣ 📂 build/
 ┃ ┗ 📂 conf/          # Yocto configs (local.conf, bblayers.conf)
 ┣ 📂 layers/
 ┃ ┣ 📂 meta-techleef/ # ✨ My custom Yocto layer
 ┃ ┗ 📂 poky/          # Upstream Yocto (not tracked in git)
 ┣ 📄 .gitignore
 ┗ 📄 README.md

---

## 🛠️ Quick Start

```bash
1. Clone this repo
git clone https://github.com/gitRaksha/techleef_series_proj.git
cd techleef_series_proj

2. Fetch poky
git clone -b scarthgap git://git.yoctoproject.org/poky layers/poky

3. Initialize build environment
source layers/poky/oe-init-build-env build

4. Build a minimal image
bitbake core-image-minimal

5. Run in QEMU
runqemu core-image-minimal nographic

6. Login as root (no password) 🎉
