# Polaris overrides for the Renesas RZ BSP U-Boot (2024.07).
#
# The upstream meta-renesas u-boot_2024.07 recipe used by the RZ/G2L family
# (smarc-rzg2l) never defines UBOOT_BRANCH and pins UBOOT_REV to a commit that
# has been removed from the upstream renesas-u-boot-cip repo, so its fetch
# fails with an unexpanded ${UBOOT_BRANCH}. Point at the matching upstream
# "v2024.07/rz" branch and its current head so the build is self-contained.
UBOOT_BRANCH:rzg2l-family = "v2024.07/rz"
UBOOT_REV:rzg2l-family = "4eebfbaa4e61f8d3fa0e44ae59449213ffee981c"
