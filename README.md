# LuckiusLib

This library is primarily used for my personal Minecraft Fabric mods.

## Usage

If you want to use it in your own mods (which I do not recommand, because I am dumb) :

1. First, clone this repo.

2. Use the command ``.\gradlew publishToMavenLocal``.

3. In your mod, add this in your ``build.gradle`` :
```gradle
repositories {
    //...
    mavenLocal()
}

dependencies {
    include modImplementation("net.luckius:luckiuslib:1.3.1-1.20.1")
}
```

``include`` will ensure the library will be bundled into your own mod, so luckiuslib does not have to be compiled by itself.