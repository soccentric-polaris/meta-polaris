# Persistent journal + explicit NTP for Polaris devices.
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://journald-polaris.conf \
    file://timesyncd-polaris.conf \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/journald.conf.d
    install -m 0644 ${WORKDIR}/journald-polaris.conf \
                    ${D}${sysconfdir}/systemd/journald.conf.d/polaris.conf

    install -d ${D}${sysconfdir}/systemd/timesyncd.conf.d
    install -m 0644 ${WORKDIR}/timesyncd-polaris.conf \
                    ${D}${sysconfdir}/systemd/timesyncd.conf.d/polaris.conf
}

FILES:${PN} += " \
    ${sysconfdir}/systemd/journald.conf.d/ \
    ${sysconfdir}/systemd/timesyncd.conf.d/ \
"

INSANE_SKIP:${PN} += "empty-dirs"
