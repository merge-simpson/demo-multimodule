import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("java-library")
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
}

allprojects {
    group = "nettee"
    version = "0.0.1-SNAPSHOT"

    tasks.withType<BootJar> {
        enabled = false
    }
}

subprojects {
    apply {
        plugin("java")
        plugin("java-library")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        api(project(":common"))
        compileOnly("org.projectlombok:lombok")
        compileOnly("org.springframework:spring-web")
        compileOnly("org.springframework:spring-context")
    }
}
