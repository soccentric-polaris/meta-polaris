SUMMARY = "Polaris persistent home directory initialisation"
DESCRIPTION = "Creates /home/polaris on first boot after the persistent home \
partition (p4) is mounted at /home."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://polaris-data-init.sh \
    file://polaris-data-init.service \
"


inherit systemd

SYSTEMD_SERVICE:${PN}     = "polaris-data-init.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

RDEPENDS:${PN} = "bash util-linux parted e2fsprogs-resize2fs"

do_install() {
    install -d ${D}${libdir}/polaris-data-init
    install -m 0755 ${WORKDIR}/polaris-data-init.sh \
                    ${D}${libdir}/polaris-data-init/polaris-data-init.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/polaris-data-init.service \
                    ${D}${systemd_system_unitdir}/polaris-data-init.service
}

FILES:${PN} += " \
    ${libdir}/polaris-data-init/ \
    ${systemd_system_unitdir}/polaris-data-init.service \
"
