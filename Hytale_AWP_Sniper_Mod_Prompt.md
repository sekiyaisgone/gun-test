# 🎯 HYTALE AWP SNIPER MOD - COMPREHENSIVE DEVELOPMENT PROMPT

## 📋 PROJECT OVERVIEW

**Objective:** Create a fully functional AWP sniper rifle mod for Hytale with working ammunition system, shooting mechanics, reload animations, and all necessary assets.

**Base Reference:** GunsAndStuff mod (v1.33) by Trist_n
**Model:** AWP Detailed v3 (Blockbench .bbmodel format, already converted to hytale_prop format)

---

## 📚 ESSENTIAL DOCUMENTATION & SOURCES

### Primary Documentation Sources
| Source | URL | Purpose |
|--------|-----|---------|
| **Hytale Modding Documentation (Gitbook)** | https://britakee-studios.gitbook.io/hytale-modding-documentation | Comprehensive community docs |
| **HytaleModding.dev** | https://hytalemodding.dev/en | Official-style guides & tutorials |
| **Hytale Server Docs (Unofficial)** | https://hytale-docs.pages.dev/ | Server API documentation |
| **Hytale-Server-Unpacked** | https://github.com/Ranork/Hytale-Server-Unpacked | Decompiled server source reference |
| **Official Hytale Modding Strategy** | https://hytale.com/news/2025/11/hytale-modding-strategy-and-status | Official modding philosophy |
| **Hytale Blockbench Plugin** | https://github.com/JannisX11/hytale-blockbench-plugin | Official model creation tool |
| **TaleAPI** | https://github.com/polvallverdu/TaleAPI | Community Hytale API wrapper |
| **HytaleModding GitHub** | https://github.com/HytaleModding | Community organization |
| **Hytale Plugin Template** | https://github.com/realBritakee/hytale-template-plugin | Starter template for plugins |
| **CurseForge Hytale Modding** | https://support.curseforge.com/support/solutions/articles/9000273178-hytale-modding | Distribution platform docs |

### Additional Reference
- **Hytale Item IDs Database:** https://www.hytaleitemids.com/
- **Hytale Guide Wiki:** https://hytaleguide.net/items
- **Community Wiki:** https://hytalewiki.org/

---

## 🔧 TECHNICAL REQUIREMENTS

### Development Environment
```
Java Version: 25 (Oracle JDK or Adoptium)
Gradle Version: 9.2.0
IDE: IntelliJ IDEA (recommended)
Model Tool: Blockbench with Hytale Plugin
```

### Mod Type Selection
Hytale supports three mod categories:
1. **Packs (Data Assets)** - JSON-driven content (items, blocks, NPCs) - NO CODE REQUIRED
2. **Plugins** - Java-based server modifications
3. **Bootstrap/Early Plugins** - Low-level bytecode modifications (advanced)

**This mod will be a PACK with optional PLUGIN support for advanced features.**

---

## 📁 REQUIRED FOLDER STRUCTURE

```
AWP_Sniper_Mod/
├── manifest.json                                    # Mod metadata
├── Common/
│   ├── Characters/
│   │   └── Animations/
│   │       └── Items/
│   │           └── Dual_Handed/
│   │               └── AWP/
│   │                   ├── AWP_Idle.blockyanim
│   │                   ├── AWP_Shoot.blockyanim
│   │                   ├── AWP_Reload.blockyanim
│   │                   └── AWP_ADS.blockyanim
│   ├── Icons/
│   │   └── ItemsGenerated/
│   │       ├── Weapon_AWP.png                       # 64x64 inventory icon
│   │       └── AWP_Ammo_Box.png                     # Ammo icon
│   ├── Items/
│   │   └── Weapons/
│   │       ├── Gun/
│   │       │   ├── AWP_Model.blockymodel            # Main weapon model
│   │       │   └── AWP_Texture.png                  # Weapon texture (128x128)
│   │       └── Ammo/
│   │           ├── AWP_Ammo.blockymodel             # Ammo box model
│   │           └── AWP_Ammo_Texture.png             # Ammo texture
│   └── Sounds/
│       └── Weapons/
│           └── AWP/
│               ├── awp_shoot.ogg                    # Gunshot sound
│               ├── awp_reload.ogg                   # Reload sound
│               ├── awp_bolt.ogg                     # Bolt action sound
│               └── awp_empty.ogg                    # Empty click sound
├── Server/
│   ├── Audio/
│   │   └── SoundEvents/
│   │       └── SFX/
│   │           └── Weapons/
│   │               └── AWP/
│   │                   ├── SFX_AWP_Fire.json
│   │                   ├── SFX_AWP_Reload.json
│   │                   └── SFX_AWP_Empty.json
│   ├── Camera/
│   │   ├── CameraEffect/
│   │   │   └── AWP/
│   │   │       └── AWP_Shoot.json
│   │   └── CameraShake/
│   │       └── AWP/
│   │           └── AWP_Shoot.json
│   ├── Entity/
│   │   └── Trails/
│   │       └── AWP_Bullet.json
│   ├── Item/
│   │   ├── Interactions/
│   │   │   └── Weapons/
│   │   │       └── AWP/
│   │   │           ├── AWP_Shoot_Interaction.json
│   │   │           ├── AWP_Reload_Interaction.json
│   │   │           └── AWP_Ammo_Refund.json
│   │   ├── Items/
│   │   │   └── Weapons/
│   │   │       ├── Gun/
│   │   │       │   └── Weapon_AWP.json              # Main weapon definition
│   │   │       └── Ammo/
│   │   │           └── AWP_Ammo.json                # Ammo item definition
│   │   └── RootInteractions/
│   │       └── Weapons/
│   │           └── AWP/
│   │               └── Root_AWP_Reload.json
│   ├── Languages/
│   │   └── en-US/
│   │       └── server.lang
│   ├── Models/
│   │   └── AWP_Bullet.json
│   ├── Particles/
│   │   └── Weapon/
│   │       └── AWP/
│   │           └── AWP_Muzzle_Flash.particlesystem
│   └── Projectiles/
│       └── AWP_Bullet.json
└── resources/                                        # (Optional) Plugin resources
    └── plugin/
        └── AWP_Plugin.java                           # Optional Java plugin
```

---

## 📄 CRITICAL JSON DEFINITIONS

### 1. manifest.json
```json
{
  "Group": "YourModderName",
  "Name": "AWP Sniper Mod",
  "Version": "1.0.0",
  "Description": "A detailed AWP sniper rifle with realistic mechanics and animations",
  "Authors": [
    {
      "Name": "YourName",
      "Email": "",
      "Url": ""
    }
  ],
  "Website": "",
  "Dependencies": {},
  "OptionalDependencies": {},
  "LoadBefore": {},
  "DisabledByDefault": false,
  "IncludesAssetPack": true,
  "SubPlugins": []
}
```

### 2. Weapon_AWP.json (Main Weapon Definition)
```json
{
  "TranslationProperties": {
    "Name": "server.items.Weapon_AWP.name",
    "Description": "server.items.Weapon_AWP.description"
  },
  "Categories": ["Items.Weapons"],
  "PlayerAnimationsId": {
    "Parent": "Rifle",
    "Animations": {
      "Shoot": {
        "ThirdPerson": "Characters/Animations/Items/Dual_Handed/AWP/AWP_Shoot.blockyanim",
        "FirstPerson": "Characters/Animations/Items/Dual_Handed/AWP/AWP_Shoot_FPS.blockyanim",
        "Speed": 2.5,
        "BlendingDuration": 0,
        "ThirdPersonFace": "Characters/Animations/Expressions/Frown.blockyanim"
      },
      "Reload": {
        "ThirdPerson": "Characters/Animations/Items/Dual_Handed/AWP/AWP_Reload.blockyanim",
        "Speed": 1,
        "BlendingDuration": 0.0,
        "Looping": true,
        "FirstPerson": "Characters/Animations/Items/Dual_Handed/AWP/AWP_Reload_FPS.blockyanim"
      },
      "Idle": {
        "ThirdPerson": "Characters/Animations/Items/Dual_Handed/AWP/AWP_Idle.blockyanim"
      }
    }
  },
  "Interactions": {
    "Primary": {
      "Cooldown": {
        "Id": "AWP_Shoot",
        "Cooldown": 1.5
      },
      "Interactions": [
        {
          "Type": "StatsCondition",
          "Rules": {},
          "Costs": {"Ammo": 1},
          "LessThan": false,
          "Next": {
            "Type": "ChangeStat",
            "StatModifiers": {"Ammo": -1},
            "Next": {
              "Type": "Replace",
              "Var": "Shot_Fired"
            },
            "HorizontalSpeedMultiplier": 0,
            "RunTime": 0
          },
          "HorizontalSpeedMultiplier": 1,
          "Failed": "AWP_Ammo_Reload_Entry"
        }
      ],
      "Tags": {"Attack": ["Range"]},
      "RequireNewClick": true
    },
    "Secondary": "AWP_ADS",
    "Ability3": "Root_AWP_Reload",
    "SwapFrom": {
      "Cooldown": {"Cooldown": 0.25},
      "Interactions": ["AWP_Ammo_SwapFrom_Refund"]
    },
    "SwapTo": {
      "Interactions": [{"Type": "Replace", "Var": "Reload_Batch"}]
    }
  },
  "InteractionVars": {
    "Shot_Fired": {
      "Interactions": [
        {"Type": "Replace", "Var": "AWP_Shot_Effects"},
        {
          "Type": "Simple",
          "Next": {
            "Type": "LaunchProjectile",
            "RunTime": 0,
            "ProjectileId": "AWP_Bullet",
            "HorizontalSpeedMultiplier": 1
          },
          "RunTime": 0,
          "HorizontalSpeedMultiplier": 0,
          "Effects": {"ItemAnimationId": "Shoot"}
        },
        {"Type": "Replace", "Var": "Camera_FX"}
      ]
    },
    "AWP_Shot_Effects": {
      "Interactions": [
        {
          "Type": "Simple",
          "Effects": {
            "Particles": [
              {
                "SystemId": "AWP_Muzzle_Flash",
                "PositionOffset": {"Z": 1.2, "Y": 0.15},
                "RotationOffset": {"Pitch": 90}
              }
            ],
            "LocalSoundEventId": "SFX_AWP_Fire",
            "WorldSoundEventId": "SFX_AWP_Fire"
          }
        }
      ]
    },
    "Camera_FX": {
      "Interactions": [
        {
          "Type": "Simple",
          "Effects": {"CameraEffect": "AWP_Shoot"},
          "RunTime": 0.08
        }
      ]
    },
    "No_Ammo_Effects": {
      "Interactions": [{"Parent": "AWP_Empty_Noise"}]
    },
    "Reload_Batch": {
      "Interactions": [
        {
          "Type": "Serial",
          "Interactions": [
            {
              "Type": "Repeat",
              "ForkInteractions": {
                "Interactions": [
                  {
                    "Type": "StatsCondition",
                    "Costs": {"Ammo": 100},
                    "LessThan": true,
                    "ValueType": "Percent",
                    "Next": {
                      "Type": "ModifyInventory",
                      "ItemToRemove": {"Id": "AWP_Ammo", "Quantity": 1},
                      "Next": {
                        "Type": "ChangeStat",
                        "Entity": "User",
                        "StatModifiers": {"Ammo": 1}
                      }
                    }
                  }
                ]
              },
              "Repeat": -1
            },
            {
              "Type": "Simple",
              "Effects": {"LocalSoundEventId": "SFX_AWP_Reload"}
            }
          ]
        }
      ]
    }
  },
  "IconProperties": {
    "Scale": 0.28,
    "Rotation": [342, 56, 6],
    "Translation": [-8, -32]
  },
  "Texture": "Items/Weapons/Gun/AWP_Texture.png",
  "Icon": "Icons/ItemsGenerated/Weapon_AWP.png",
  "Quality": "Rare",
  "Tags": {"Type": ["Weapon"]},
  "Weapon": {
    "StatModifiers": {
      "Ammo": [{"Amount": 10, "CalculationType": "Additive"}]
    },
    "RenderDualWielded": false,
    "EntityStatsToClear": ["Ammo"]
  },
  "Recipe": {
    "Input": [
      {"ResourceTypeId": "Wood_Trunk", "Quantity": 30},
      {"ItemId": "Ingredient_Leather_Medium", "Quantity": 15},
      {"ItemId": "Ingredient_Bar_Iron", "Quantity": 50},
      {"ItemId": "Ingredient_Bar_Gold", "Quantity": 10}
    ],
    "BenchRequirement": [
      {
        "Type": "Crafting",
        "Categories": ["Weapon_Bow"],
        "Id": "Weapon_Bench",
        "RequiredTierLevel": 3
      }
    ]
  },
  "DisplayEntityStatsHUD": ["Ammo"],
  "InteractionConfig": {"DisplayOutlines": false},
  "ItemLevel": 8,
  "MaxDurability": 120,
  "DurabilityLossOnHit": 0.25,
  "UsePlayerAnimations": false,
  "Model": "Items/Weapons/Gun/AWP_Model.blockymodel",
  "Scale": 1.0
}
```

### 3. AWP_Bullet.json (Projectile Definition)
```json
{
  "Appearance": "AWP_Bullet_Model",
  "Radius": 0.08,
  "Height": 0,
  "DepthShot": 0.9,
  "PitchAdjustShot": true,
  "SticksVertically": true,
  "MuzzleVelocity": 1500,
  "TerminalVelocity": 1500,
  "Gravity": 5,
  "Bounciness": 0,
  "ImpactSlowdown": 0,
  "TimeToLive": 80,
  "Damage": 115,
  "DeathEffectsOnHit": true,
  "DeadTime": 0.05,
  "DeadTimeMiss": 0,
  "DeathParticles": {"SystemId": "AWP_Impact"},
  "VerticalCenterShot": 0,
  "HorizontalCenterShot": 0,
  "DeathSoundEventId": "SFX_AWP_Impact"
}
```

### 4. AWP_Ammo.json (Ammo Item Definition)
```json
{
  "TranslationProperties": {
    "Name": "server.items.AWP_Ammo.name",
    "Description": "server.items.AWP_Ammo.description"
  },
  "Categories": ["Items.Weapons"],
  "Quality": "Uncommon",
  "ItemLevel": 6,
  "PlayerAnimationsId": "Item",
  "Recipe": {
    "TimeSeconds": 0.8,
    "KnowledgeRequired": false,
    "Input": [
      {"ItemId": "Ingredient_Bar_Iron", "Quantity": 3},
      {"ItemId": "Ingredient_Bar_Copper", "Quantity": 2}
    ],
    "OutputQuantity": 20,
    "BenchRequirement": [
      {
        "Type": "Crafting",
        "Categories": ["Weapon_Bow"],
        "Id": "Weapon_Bench"
      }
    ]
  },
  "IconProperties": {
    "Scale": 0.85,
    "Rotation": [180, 67, 129],
    "Translation": [5, -2]
  },
  "Model": "Items/Weapons/Ammo/AWP_Ammo.blockymodel",
  "Texture": "Items/Weapons/Ammo/AWP_Ammo_Texture.png",
  "Icon": "Icons/ItemsGenerated/AWP_Ammo_Box.png",
  "MaxStack": 999,
  "Tags": {"Type": ["Weapon"], "Family": ["Arrow"]},
  "ItemSoundSetId": "ISS_Weapons_Arrows"
}
```

### 5. SFX_AWP_Fire.json (Sound Event)
```json
{
  "Layers": [
    {
      "Files": ["Sounds/Weapons/AWP/awp_shoot.ogg"],
      "RandomSettings": {
        "MinPitch": -1,
        "MaxPitch": 1,
        "MinVolume": -1,
        "MaxVolume": 1
      },
      "Volume": -2
    }
  ],
  "MaxInstance": 20,
  "Volume": 1.2,
  "PreventSoundInterruption": true,
  "Parent": "SFX_Attn_Loud",
  "MaxDistance": 50
}
```

### 6. Camera Shake (AWP_Shoot.json)
```json
{
  "FirstPerson": {
    "Duration": 0.0,
    "EaseIn": {"Time": 0.08, "Type": "Linear"},
    "EaseOut": {"Time": 0.15, "Type": "Linear"},
    "Rotation": {
      "Pitch": [{"Frequency": 15, "Amplitude": -0.6, "Type": "Cos", "Clamp": {"Min": 0}}],
      "Yaw": [{"Frequency": 4, "Amplitude": -0.15, "Type": "Cos", "Clamp": {"Min": 0}}],
      "Roll": [{"Frequency": 5, "Amplitude": 0.08, "Type": "Cos"}]
    }
  },
  "ThirdPerson": {
    "Duration": 0.0,
    "EaseIn": {"Time": 0.08, "Type": "Linear"},
    "EaseOut": {"Time": 0.15, "Type": "Linear"},
    "Rotation": {
      "Pitch": [{"Frequency": 15, "Amplitude": -0.5, "Type": "Cos", "Clamp": {"Min": 0}}],
      "Yaw": [{"Frequency": 4, "Amplitude": -0.12, "Type": "Cos", "Clamp": {"Min": 0}}],
      "Roll": [{"Frequency": 5, "Amplitude": 0.06, "Type": "Cos"}]
    }
  }
}
```

### 7. server.lang (Translations)
```
items.Weapon_AWP.name=AWP Sniper Rifle
items.Weapon_AWP.description=A precision bolt-action sniper rifle.\n\nRequires AWP Ammo\n\n<i>One shot, one kill.</i>

items.AWP_Ammo.name=AWP Ammunition
items.AWP_Ammo.description=High-caliber rounds designed for the AWP Sniper Rifle.
```

---

## 🎨 MODEL CONVERSION REQUIREMENTS

### Source Model Analysis (awp_detailed_v3_-_Converted.bbmodel)
The provided BBModel contains:
- **Format:** hytale_prop (already converted)
- **Resolution:** 128x128 texture
- **Bone Groups:**
  - `awp` (main weapon body)
  - `bolt` (bolt action mechanism)
  - `trigger` (trigger group)
  - `magazine` (detachable magazine)

### Included Animations
1. **shoot** - 0.8s, includes recoil and trigger pull
2. **reload** - 2.5s, bolt cycling animation
3. **mag_swap** - 3.5s, magazine removal and insertion
4. **idle** - 4.0s loop, subtle breathing sway
5. **ads** - 0.4s, aim down sights transition

### Model Export Steps
1. Open in Blockbench with Hytale plugin
2. Verify bone hierarchy (awp → bolt → trigger → magazine)
3. Export as `.blockymodel` for model
4. Export animations as `.blockyanim`
5. Export texture at 128x128 PNG

---

## ⚙️ WEAPON STATISTICS

| Stat | Value | Notes |
|------|-------|-------|
| **Damage** | 115 | High damage per shot |
| **Fire Rate** | 1.5s cooldown | Slow, deliberate shots |
| **Magazine Size** | 10 rounds | Stored in Ammo stat |
| **Reload Time** | 2.5s (bolt) / 3.5s (mag) | Two reload types |
| **Projectile Speed** | 1500 | Near-instant hit |
| **Effective Range** | 50 blocks | MaxDistance for sound |
| **Gravity Drop** | 5 | Minimal bullet drop |
| **Durability** | 120 | High durability |

---

## 🔌 OPTIONAL PLUGIN FEATURES

For advanced functionality (Java plugin required):

### Custom Interaction Example
```java
public class AWPScopeInteraction extends SimpleInstantInteraction {
    public static final BuilderCodec<AWPScopeInteraction> CODEC = BuilderCodec.builder(
        AWPScopeInteraction.class, 
        AWPScopeInteraction::new, 
        SimpleInstantInteraction.CODEC
    ).build();

    @Override
    protected void firstRun(@Nonnull InteractionType interactionType, 
                           @Nonnull InteractionContext interactionContext, 
                           @Nonnull CooldownHandler cooldownHandler) {
        // Custom scope zoom logic
        // Modify FOV, add overlay, reduce sway
    }
}
```

### Registration in Plugin Main Class
```java
public class AWPPlugin extends JavaPlugin {
    public AWPPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCodecRegistry(Interaction.CODEC)
            .register("awp_scope_interaction", AWPScopeInteraction.class, AWPScopeInteraction.CODEC);
    }
}
```

---

## 📋 IMPLEMENTATION CHECKLIST

### Phase 1: Asset Preparation
- [ ] Convert BBModel to .blockymodel format
- [ ] Export all 5 animations to .blockyanim
- [ ] Create 128x128 weapon texture
- [ ] Create inventory icon (64x64 recommended)
- [ ] Source/create sound effects (.ogg format)
- [ ] Create ammo box model and texture

### Phase 2: JSON Configuration
- [ ] Create manifest.json
- [ ] Create Weapon_AWP.json with all interaction vars
- [ ] Create AWP_Ammo.json
- [ ] Create AWP_Bullet.json projectile
- [ ] Create all sound event JSON files
- [ ] Create camera shake/effect JSON
- [ ] Create translation file

### Phase 3: Folder Structure
- [ ] Organize all files per structure above
- [ ] Verify all paths match JSON references
- [ ] Create particle system files

### Phase 4: Testing
- [ ] Place mod in `%AppData%/Roaming/Hytale/UserData/mods/`
- [ ] Test crafting recipe
- [ ] Test shooting mechanics
- [ ] Test ammo consumption
- [ ] Test reload animation
- [ ] Test sound playback
- [ ] Test projectile damage
- [ ] Test durability loss

---

## ❓ CLARIFYING QUESTIONS

Before proceeding, please clarify:

1. **Scope Mechanic:** Should the secondary action (right-click) provide:
   - Simple zoom (FOV change)
   - Full scope overlay with crosshair
   - Reduced weapon sway while aiming?

2. **Bolt Action Animation:** Should the bolt cycle:
   - Automatically after each shot
   - Require manual trigger (separate key)
   - Only during reload?

3. **Damage Model:**
   - Should headshots deal bonus damage?
   - Should there be damage falloff at range?
   - Should armor penetration be considered?

4. **Sound Design:** Do you have:
   - Custom sound files to include
   - Preference for realistic vs game-y sounds
   - Need for ambient/handling sounds?

5. **Visual Effects:**
   - Muzzle flash particle preferences
   - Bullet tracer visibility
   - Impact effects (sparks, dust, blood)?

6. **Balance Considerations:**
   - What tier/progression level should this be?
   - Comparison to existing ranged weapons?
   - PvP vs PvE balance priority?

---

## 🔗 QUICK REFERENCE LINKS

### API Classes (from Hytale-Server-Unpacked)
- `com.hypixel.hytale.server.core.modules.projectile.ProjectileModule`
- `com.hypixel.hytale.server.core.modules.interaction.InteractionModule`
- `com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction`
- `com.hypixel.hytale.server.core.entity.InteractionContext`
- `com.hypixel.hytale.server.core.asset.type.item.config.Item`

### Key Interaction Types
- `SimpleInstantInteraction` - Instant effect
- `StatsCondition` - Check stat requirements
- `ChangeStat` - Modify entity stats
- `LaunchProjectile` - Fire projectile
- `ModifyInventory` - Add/remove items
- `Serial` - Chain interactions
- `Repeat` - Loop interactions
- `Charging` - Held interactions
- `Condition` - Conditional branching

---

## 📝 NOTES

- Hytale is in **Early Access** - APIs may change
- Always backup before testing
- The server is **not obfuscated** - decompile for reference
- Server source code will be fully open-sourced 1-2 months post-launch
- All modding is **server-side first** - no client mods needed for players

---

*Generated from analysis of GunsAndStuff mod v1.33, AWP BBModel, and comprehensive Hytale modding documentation.*
