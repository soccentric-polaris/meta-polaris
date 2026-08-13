# Polaris overrides for the Renesas RZ BSP kernel (linux-renesas 6.12).
#
# The upstream meta-renesas recipe pins KERNEL_REV to a commit that has since
# been removed from the upstream rz_linux-cip "rz-6.12-cip14" branch (the BSP
# branches are force-pushed/rebased upstream). Without an override the fetch
# fails. Pin to the current branch head here so the build is self-contained.
KERNEL_REV = "212f6e88b7249f803ff5475c07b72c92ce2d929d"
