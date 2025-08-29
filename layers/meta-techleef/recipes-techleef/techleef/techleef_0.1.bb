SUMMARY = "Techleef demo app"
DESCRIPTION = "Techleef demo app used in the live yocto session"
HOMEPAGE = ""
LICENSE = "CLOSED"

SRC_URI = "file://techleef.c;subdir=techleef" 
# there was an error because i added a space between the semicolon and subdir, so becarful with spaces
# the same for comments, they should not be in the same line as the variable definition

S = "${WORKDIR}/techleef"

# SRC_URI is the source of the project/files to be compiled it contains the path to the source code
# S is the path to the source directory after unpacking the source code
# file:// means that the source file is local and located in the same directory as this .bb file "in this example techleef_0.1.bb"
# the source of the file can be local, downloaded from a URL, git repo, etc. see more at https://docs.yoctoproject.org/ref-manual/variables.html#var-SRC_URI

PACKAGES += "${PN}-demo"

do_compile(){
    ${CC} techleef.c ${LDFLAGS} -o techleef
}

do_install(){
    install -d ${D}/usr/bin
    install -m 0744 techleef ${D}/usr/bin
}

FILES:${PN}-demo = "/usr/bin/*"

# do_compile works in "S" Source directory
# "B" = "S" if "B" is not defined (which is the case here and in most simple recipes)
# do_install works in "D" image directory

# PN is the package name, which is the name of the recipe file without the version and .bb extension
# PV is the package version, which is defined after the last underscore in the recipe file name
# PR is the package revision, which is used to differentiate between different builds of the same version
# WORKDIR is the working directory for the build process, which contains all the files needed for the build
# CC is the C compiler, which is defined by the toolchain used in the build process
# LDFLAGS are the linker flags, which are defined by the toolchain and the build configuration


# Other useful variables (from /home/marwen/techleef_series_proj/layers/poky/meta/conf/bitbake.conf line 408):
# T = "${WORKDIR}/temp"
# D = "${WORKDIR}/image"
# S = "${WORKDIR}/${BP}"
# B = "${S}"