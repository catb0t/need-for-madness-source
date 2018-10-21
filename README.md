# Need For Madness decompiled sources
---

http://needformadness.com

Requires Java 7 (OpenJDK 7 or Java 7 SE) to compile / run just like the official game

Decompiled by [Procyon](https://bitbucket.org/mstrobel/procyon) and its [Luyten](https://github.com/deathmarine/Luyten) GUI

There's no actual copyright on the website, in the game, or in strings in the code, but this code obviously belongs to Omar Waly, and is posted here for purposes of research only.

You might read, compile, execute, and use / link against the code for noncommercial personal open source purposes.

I do not endorse or want use of this code for commercial purposes, and you really shouldn't do it.

## Scripts

- `build.sh`: reads `$JDKPATH` or uses system javac / jar if unset; script arguments go to javac
- `run.sh`: reads `$JREPATH` or uses system java if unset

## Branches

- <s>`jd-1.5` contains the (fixed-up) version of the code decompiled by `jd-gui` (Java Decompiler) 1.4.0, a program designed for Java 5</s> JD doesn't seem to provide anything of value over Procyon

- `luyten-1.8` contains the (fixed-up) version of the code decompiled by `luyten` 0.5.3 / `procyon` 0.5.3, a program designed for modern Java 6+

- `master` contains the Procyon source as a base, and has useful differences from other branches merged into it

- `depr` is where we fix deprecation warnings and other things reported by -Xlint:all

later there might come a branch where we make it run on Java 8+....

## Bugs
Things that are wrong and different from the official Game.jar

- Skybox colours aren't set properly and are always black, but are properly coloured in the reference implementation
  - <s>Medium::setsky: might confuse RGB and HSB values for some reason</s>
  - Medium::setsky and setsnap seem to interpret values from stageN.txts just fine
  - Perhaps the colors are transparent and the Frame background is leaking through? (Madness::main, line 52)
- Music doesn't play (???)
- Many deprecation errors, even with Java 7 (100s of warnings with -Xlint:all)
  - Fixing would allow running on newer Java, and might also fix bugs with Java 7
- When another car is closer to a world model (like a jump) than your camera, the other car model is consistently visible through the world model
  - This happens in the official game too, except much less often

## Notes
- Fixed zero-division errors in xtGraphics
- Fixed many runtime-error casts from Float to Object to Integer, to using .floatValue() (probably a decompilation artifact)
- Version support for this decompiled version
  - Java 6: freeze on loading stages / running the game, but no deprecations
  - Java 7: runs but doesn't work perfectly (see Bugs) and has deprecations
  - Java 8+: freeze on loading stage soundtrack; on Ubuntu a missing audio driver will cause an exception `apt install openjdk-8-{jre,jdk,doc} libpulse-{java,jni}`

  - the official Game.jar is unplayably slow in Java 6, runs perfectly in Java 7, and freezes in Java 8+
