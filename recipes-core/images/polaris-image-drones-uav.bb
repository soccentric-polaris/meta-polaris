SUMMARY = "Polaris OS image for drones-uav deployments"
DESCRIPTION = "Full-featured embedded Linux image (generic x86-64) with A/B OTA, gRPC, and hardware interface tools, tuned for the drones-uav vertical."
LICENSE = "MIT"

require recipes-core/images/polaris-image.bb
require recipes-core/images/polaris-image-common.inc

IMAGE_INSTALL:append = "     packagegroup-core-full-cmdline "
