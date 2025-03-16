import org.springframework.boot.gradle.tasks.bundling.BootJar

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {

}

// NOTE root 프로젝트에서 false 기본값을 주면 이 부분은 생략해도 됨.
tasks.withType<BootJar> {
    enabled = false
}