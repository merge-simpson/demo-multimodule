import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    configureEach {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
}

dependencies {
    val bom = dependencyManagement.importedProperties

    implementation(project(":board"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // logging
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

    // database
    runtimeOnly("org.postgresql:postgresql:42.7.4")

    // flyway
    implementation("org.flywaydb:flyway-database-postgresql")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // mapstruct
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    // jackson
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:${bom["querydsl.version"]}:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:${bom["querydsl.version"]}:jakarta")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2")

    // test tool
    testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
    testImplementation("io.mockk:mockk:1.13.12")
    testImplementation(kotlin("script-runtime"))
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.3")
}

kotlin{
    sourceSets {
        test {
            kotlin.srcDirs(listOf("src/test/kotlin"))
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(listOf(
        "--enable-preview",
        "-Amapstruct.defaultComponentModel=spring",
    ))
}

tasks.named<JavaExec>("bootRun") {
    jvmArgs("--enable-preview")
}

tasks.withType<BootJar> {
    enabled = true
}