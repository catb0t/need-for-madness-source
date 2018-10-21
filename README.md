# Need For Madness decompiled sources
---

http://needformadness.com

Requires Java 7 (OpenJDK 7 or Java 7 SE) to compile / run just like the official game

Decompiled by [Procyon](https://bitbucket.org/mstrobel/procyon) and its [Luyten](https://github.com/deathmarine/Luyten) GUI

There's no actual copyright on the website, in the game, or in strings in the code, but this code obviously belongs to Omar Waly, and is posted here for purposes of research only.

You may read, compile, execute, and use / link against the code for noncommercial personal or open source purposes.

I do not endorse or want use of this code for commercial purposes, and you really shouldn't do it.

## Bugs
- Skybox colours are black with white clouds here, but are properly coloured in the reference implementation
  - <s>Medium::setsky: might confuse RGB and HSB values for some reason</s>
  - Medium::setsky and setsnap seem to interpret values from stageN.txts just fine
  - Perhaps the colors are transparent and the Frame background is leaking through? (Madness::main, line 52)
- Music doesn't play (???)
- Many deprecation errors, even with Java 7 (100 warnings with -Xlint:all)
  - Fixing would allow running on newer Java, and might also fix bugs with Java 7

## Notes
- Fixed zero-division errors in xtGraphics
- Fixed many runtime-error casts from Float to Object to Integer, to using .floatValue() (probably a decompilation artifact)
- Version support for this decompiled version
  - Java 6: freeze on loading stages / running the game, but no deprecations
  - Java 7: runs but doesn't work perfectly (see Bugs) and has deprecations
  - Java 8+: doesn't work at all due to UI method changes

  - the official Game.jar is unplayably slow in Java 6, runs perfectly in Java 7, and freezes in Java 8+
