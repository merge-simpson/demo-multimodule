import org.springframework.boot.gradle.tasks.bundling.BootJar

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<BootJar> {
    enabled = false
}