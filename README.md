# Need For Madness decompiled sources
---

http://needformadness.com

Requires Java 7 (OpenJDK 7 or Java 7 SE) to compile / run just like the official game

Decompiled by [Procyon](https://bitbucket.org/mstrobel/procyon) and its [Luyten](https://github.com/deathmarine/Luyten) GUI

## Bugs
- Skybox colours are inverted here, but not in the reference impl
  - Medium::setsky: might confuse RGB and HSB valyes for some reason
- Music doesn't play (?)
- Many deprecation errors that need fixing 
  - Would allow running on newer Java, and might also fix existing bugs with Java 7

## Notes
- Fixed zero-division errors in xtGraphics
- Fixed many runtime-error casts from Float to Object to Integer, to using .floatValue() (probably a decompilation artifact)
- These decompiled sources 
  - don't work perfectly in Java 7 (see Bugs)
  - freeze on loading stages in Java 6
  - don't work at all due to UI method changes in Java 8+
  - the official Game.jar runs perfectly only in Java 7

