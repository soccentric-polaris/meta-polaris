# os-release_%.bbappend — identify this image as "Polaris OS".
DISTRO_NAME  = "Polaris OS"
DISTRO_VERSION = "${PV}"
PRETTY_NAME = "Polaris OS ${PV}"
OS_RELEASE_FIELDS:append = " ID_LIKE"
ID_LIKE = "poky"

do_install:append() {
    cat > ${D}${sysconfdir}/os-release <<OSEOF
ID=polaris
ID_LIKE=poky
NAME="Polaris OS"
VERSION="${PV}"
VERSION_ID="${PV}"
PRETTY_NAME="Polaris OS ${PV}"
HOME_URL="https://polaris.dev/"
SUPPORT_URL="https://polaris.dev/support"
BUG_REPORT_URL="https://polaris.dev/issues"
OSEOF
}
