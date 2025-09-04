SUMMARY = "C hello world example recipe"
DESCRIPTION = "Hello world c recipe developed during Yocto techleef course"
HOMEPAGE = "https://github.com/bhstalel/yocto-hello-c-makefile"
SECTIONS = "apps"

LICENSE = "CLOSED"
SRC_URI = "git://github.com/bhstalel/yocto-hello-c-makefile.git;protocol=https;branch=main"

SRCREV = "c0b0245eed82bdf16cdefc76bb821917b9996dfb"

S = "${WORKDIR}/git"

DEPENDS += "hellolib"
# += appends to the variable, = overwrites the variable and we don't want to overwrite it
# DEPENDS is used to define the dependencies of the recipe
# in this case hellotechleef depends on hellolib

# github sources needs three things: protocol, branch and commit
# protocol: https or ssh
# branch: main, master, etc
# protocol and branch are parameters put in the SRC_URI
# commit: the commit hash to checkout, if not defined it will checkout the latest commit
# commit is defined in SRCREV