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
  implementation(files(
    if (Os.isFamily(Os.FAMILY_MAC)) {
      "lib/swt-cocoa.jar"
    } else if (Os.isFamily(Os.FAMILY_WINDOWS)) {
      "lib/swt-win32.jar"
    } else {
      "lib/swt-gtk.jar"
    }
  ))
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}
