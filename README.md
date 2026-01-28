# JourneyMap Extra InfoSlots

![GitHub release (latest by date)](https://img.shields.io/github/v/release/Drehverschluss/JourneyMap_Extra_InfoSlots?style=flat-square)
![GitHub Workflow Status](https://img.shields.io/github/actions/workflow/status/Drehverschluss/JourneyMap_Extra_InfoSlots/gradle.yml?style=flat-square)

## Was macht dieser Mod?

**JourneyMap Extra InfoSlots** erweitert JourneyMap um zusätzliche InfoSlots, die serverseitige Werte synchronisiert anzeigen können. 

- Zeigt z.B. den aktuellen Mob-Level an der Spielerposition direkt im JourneyMap-HUD an
- Synchronisiert Werte wie MobLevelAtPos per Netzwerk vom Server zum Client
- Kompatibel mit Dynamic Difficulty und NeoForge 1.21.1
- Einfach erweiterbar für weitere InfoSlots

## Features
- Live-Anzeige des Spieler levels im InfoSlot1
- Live-Anzeige des synchronisierten Mob-Levels im InfoSlot2
- Netzwerk-Sync von Serverwerten (z.B. MobLevelAtPos)
- Integration in das JourneyMap InfoHUD

## Installation
1. Lade die neueste Version von [Releases](https://github.com/Drehverschluss/JourneyMap_Extra_InfoSlots/releases) herunter
2. Lege die JAR-Datei in deinen `mods`-Ordner
3. Stelle sicher, dass JourneyMap und Dynamic Difficulty installiert sind
4. Starte Minecraft mit NeoForge 1.21.1

---

Mapping Names:
============
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/NeoForged/NeoForm/blob/main/Mojang.md

Additional Resources: 
==========
Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/

---

## Lizenz

Dieses Projekt steht unter der MIT License. Siehe die Datei [LICENSE](LICENSE) für Details.

---

## Hinweis zur Entwicklung

Ein Großteil dieses Mods wurde mit Unterstützung von AI (GitHub Copilot) entwickelt. Viele Features, Netzwerk- und API-Anbindungen sowie die Dokumentation wurden KI-gestützt umgesetzt und optimiert. Das Projekt zeigt, wie moderne AI-Tools die Mod-Entwicklung beschleunigen und vereinfachen können.
