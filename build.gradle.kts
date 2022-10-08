import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.nghaninn.datwyler"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//	implementation("com.squareup.okhttp3:okhttp:4.10.0")
	implementation("com.google.code.gson:gson:2.9.0")

	// https://mvnrepository.com/artifact/org.springframework/spring-context
	implementation("org.springframework:spring-context:5.3.23")
	// https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-bootstrap
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap:3.1.4")
	// https://mvnrepository.com/artifact/com.google.cloud/spring-cloud-gcp-starter
	implementation("com.google.cloud:spring-cloud-gcp-starter:3.3.0")
	// https://mvnrepository.com/artifact/com.google.cloud/spring-cloud-gcp-secretmanager
	implementation("com.google.cloud:spring-cloud-gcp-secretmanager:3.3.0")
	// https://mvnrepository.com/artifact/com.google.cloud/google-cloud-logging-logback
	implementation("com.google.cloud:google-cloud-logging-logback:0.127.10-alpha")

//	implementation("com.google.firebase:firebase-admin:9.0.0")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.springframework.security:spring-security-oauth2-resource-server")
//	implementation("org.springframework.security:spring-security-oauth2-jose")
//	implementation("org.springframework.security:spring-security-config")

//	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")

	// https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api
	implementation("javax.xml.bind:jaxb-api:2.3.1")

	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")



	// JWT Authentication with Firebase Authentication
	implementation("com.google.firebase:firebase-admin:6.12.2")
	// https://mvnrepository.com/artifact/com.google.cloud/spring-cloud-gcp-security-firebase
	implementation("com.google.cloud:spring-cloud-gcp-security-firebase:3.3.0")
	// https://mvnrepository.com/artifact/org.springframework.security/spring-security-config
	implementation("org.springframework.security:spring-security-config:5.7.3")
	// https://mvnrepository.com/artifact/org.springframework.security/spring-security-oauth2-resource-server
	implementation("org.springframework.security:spring-security-oauth2-resource-server:5.7.3")

//	// https://mvnrepository.com/artifact/org.projectlombok/lombok
//	compileOnly("org.projectlombok:lombok:1.18.24")


	runtimeOnly("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
