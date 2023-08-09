dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation(project(":entry-core"))
    implementation(project(":entry-persistence"))
    implementation(project(":entry-presentation"))
    implementation ("io.jsonwebtoken:jjwt:0.9.1")
    implementation ("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}