// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    // Groovy の場合、以下で `extra` に `kotlin_version` をセットできる
    //     ext.kotlin_version = "1.3.11"
    // これは以下と等価
    //     (rootProject.)extensions.extraProperties.set("kotlin_version", "1.3.11")
    // Gradle の世界では以下が成立する (= project自体のプロパティのように参照できる)
    //     ext.kotlin_version == (rootProject.)kotlin_version ==  "1.3.11"

    // Kotlin DSL では `ext` は `extra` になるが、 Kotlin では以下のように書くことはできない
    //     extra.kotlin_version = "1.3.11"
    // 明示的に `set` を呼ぶことはできるが、 type safe じゃないし補完も効かない
    //     extra.set("kotlin_version", "1.3.11")  // `get` 時に `String?` へのキャストが必須
    // 委譲プロパティを使って通常の変数のようにアクセスできる拡張を用意してくれている
    // 以下のように書くと、 extra に set しつつ、その後も変数として参照できる
    val kotlin_version by extra("1.3.11")

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task<Delete>( "clean") {
    delete(rootProject.buildDir)
}
