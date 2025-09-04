SUMMARY = "Hello library"
DESCRIPTION = "Hello library developed during Yocto techleef course"
HOMEPAGE = "https://github.com/bhstalel/yocto-hello-c-dependency"

LICENSE = "CLOSED"

SRC_URI = "git://github.com/bhstalel/yocto-hello-c-dependency.git;protocol=https;branch=main"
SRCREV = "33e4b827e21d93ba34469cda81864d7d903bab98"

S = "${WORKDIR}/git"


do_install(){

    install -d ${D}/${includedir}
    install -d ${D}/${libdir}

    ln -sf libhello.so.1.0 ${D}/${libdir}/libhello.so

    install -m 0600 hellolib.h ${D}/${includedir}
    install -m 0700 lib*so.* ${D}/${libdir}
    cp libhello.so ${D}/${libdir}
}

# D is  the image directory
# includedir is /usr/include
# libdir is /lib
# ${D}/${includedir} = /usr/include
# ${D}/${libdir} = /lib
# ${includedir} and ${libdir} are variables defined by yocto
# ${D} is the image directory where the recipe will be installed before packaging
# ${WORKDIR} is the working directory where the sources are downloaded and compiled
# ${S} is the source directory where the sources are located, in this case ${WORKDIR}/git
