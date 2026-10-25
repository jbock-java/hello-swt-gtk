import org.apache.tools.ant.taskdefs.condition.Os;

plugins {
    id("java")
    id("application")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

application {
    mainClass = "gg.bockig.HelloWorld"
    applicationDefaultJvmArgs = if (Os.isFamily(Os.FAMILY_MAC)) {
        listOf("-XstartOnFirstThread")
    } else {
        listOf()
    }
}

repositories {
    mavenCentral()
}

dependencies {
    val swtVersion = "3.135.0"
    val oep = "org.eclipse.platform"
    implementation(
        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
            "$oep:org.eclipse.swt.win32.win32.x86_64:$swtVersion"
        } else if (Os.isFamily(Os.FAMILY_MAC)) {
            "$oep:org.eclipse.swt.cocoa.macosx.x86_64:$swtVersion"
        } else {
            "$oep:org.eclipse.swt.gtk.linux.x86_64:$swtVersion"
        }
    )
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
