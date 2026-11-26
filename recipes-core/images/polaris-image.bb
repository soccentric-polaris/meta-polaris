SUMMARY = "Polaris OS — production image for Renesas RZ/G2L"
DESCRIPTION = "Full image with A/B OTA, gRPC/Protobuf, Polaris-HAL, hardware \
interface tooling, and connectivity."
HOMEPAGE = "https://github.com/soccentric-polaris/Polaris-OS"
LICENSE = "MIT"

require recipes-extended/images/core-image-full-cmdline.bb
IMAGE_FEATURES += "ssh-server-openssh"

# OTA / swupdate — install the A/B runtime on the RZ/G2L machine
IMAGE_INSTALL:append:smarc-rzg2l = " swupdate swupdate-www polaris-swupdate-config"

# Home partition init (persistent /home on the data partition)
IMAGE_INSTALL:append = " polaris-data-init"

# Root filesystem expansion (single-partition deployments)
IMAGE_INSTALL:append = " expand-rootfs"

# Connectivity
IMAGE_INSTALL:append = " \
    polaris-connectivity iw rfkill bluez5-dev \
"

# gRPC + Protobuf via packagegroup-polaris-middleware
IMAGE_INSTALL:append = " packagegroup-polaris-middleware sudo"

# Cloud/telemetry package group (not installed by default; add via
# packagegroup-polaris-cloud when deployments need MQTT/NTP/cloud connectivity)
# IMAGE_INSTALL:append = " packagegroup-polaris-cloud"

# Hardware interface tools
IMAGE_INSTALL:append = " \
    i2c-tools python3-smbus python3-smbus2 \
    spitools python3-spidev \
    libgpiod libgpiod-tools python3-gpiod \
    picocom minicom python3-pyserial \
    usbutils pciutils nvme-cli sg3-utils hdparm mtd-utils \
    can-utils \
    lshw ethtool devmem2 cpupower watchdog sysstat iotop strace \
    v4l-utils evtest python3-periphery vim \
"

# Polaris stack
IMAGE_INSTALL:append = " polaris-hal polaris-services"

# Target debugging and profiling
IMAGE_FEATURES += "tools-debug"
IMAGE_INSTALL:append = " gdbserver perf trace-cmd valgrind"

# Ptest package and runner support
IMAGE_FEATURES += "ptest-pkgs"

# Operator account — locked, SSH-key access only
inherit extrausers
EXTRA_USERS_PARAMS = "\
    useradd -M -s /bin/bash -G sudo polaris; \
    usermod -L polaris; \
"
