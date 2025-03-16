plugins {
    id("java")
    id("java-library")
}

group = "nettee"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    api("com.github.merge-simpson:letsdev-error-code-api:0.2.0")
}

tasks.test {
    useJUnitPlatform()
}