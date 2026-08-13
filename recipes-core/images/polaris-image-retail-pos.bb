SUMMARY = "Polaris OS image for retail-pos deployments"
DESCRIPTION = "Full-featured embedded Linux image (generic x86-64) with A/B OTA, gRPC, and hardware interface tools, tuned for the retail-pos vertical."
LICENSE = "MIT"

require recipes-core/images/polaris-image.bb
require recipes-core/images/polaris-image-common.inc

IMAGE_INSTALL:append = "     packagegroup-core-full-cmdline "
